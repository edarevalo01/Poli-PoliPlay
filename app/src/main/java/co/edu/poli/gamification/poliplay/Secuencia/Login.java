package co.edu.poli.gamification.poliplay.Secuencia;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import co.edu.poli.gamification.poliplay.Modelo.Usuario;
import co.edu.poli.gamification.poliplay.Modelo.Utiles;
import co.edu.poli.gamification.poliplay.R;
import co.edu.poli.gamification.poliplay.Servicios.Api;
import co.edu.poli.gamification.poliplay.Servicios.RequestHandler;

public class Login extends AppCompatActivity {

    private static long back_pressed;
    private Button btnLogin;
    private EditText usernameLogin, passwordLogin;
    private TextView noReg;
    private ProgressDialog loadingBar;

    public static Usuario user;
    public static long startCon, endCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameLogin = (EditText)findViewById(R.id.usernameLogin);
        passwordLogin = (EditText)findViewById(R.id.passwordLogin);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        noReg = (TextView)findViewById(R.id.msj_no_registro2);

        loadingBar = new ProgressDialog(this, R.style.Theme_AppCompat_DayNight_Dialog);
        loadingBar.setCanceledOnTouchOutside(false);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        noReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, Registro.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void login(){
        final String username = usernameLogin.getText().toString().trim();
        final String password = passwordLogin.getText().toString().trim();
        if(username.isEmpty()){
            usernameLogin.setError("Ingrese un nombre de Usuario.");
            usernameLogin.requestFocus();
            return;
        }
        if(password.isEmpty()){
            passwordLogin.setError("Ingrese una contraseña.");
            passwordLogin.requestFocus();
            return;
        }
        loadingBar.setTitle(R.string.progress_login);
        loadingBar.setMessage(getString(R.string.progress_esperar));
        loadingBar.show();
        if(username.equals("j")){//Ingreso genérico a usuario de pruebas de juegos.
            loadingBar.cancel();
            Intent i = new Intent(Login.this, Mapa.class);
            startActivity(i);
            finish();
            return;
        }
        if(username.equals("t")){//Ingreso genérico a usuario de pruebas sin bd.
            loadingBar.cancel();
            Intent i = new Intent(Login.this, SeleccionarCurso.class);
            startActivity(i);
            finish();
            return;
        }

        class UserLogin extends AsyncTask<Void, Void, String> {
            private ProgressBar progressBar;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar = (ProgressBar) findViewById(R.id.progressBarLogin);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                progressBar.setVisibility(View.GONE);

                try {
                    JSONObject obj = new JSONObject(s);
                    if (!obj.getBoolean("error")) {
                        Toast.makeText(Login.this, obj.getString("message"), Toast.LENGTH_SHORT).show();
                        //Obtener el JSON del usuario en base de datos.
                        JSONObject userJson = obj.getJSONObject("user");
                        //Crear un nuevo usuario.
                        //cod ema user, pass, sig, rol, tran, gro
                        user = new Usuario(
                                userJson.getString("codigo"),
                                userJson.getString("correo"),
                                userJson.getString("username"),
                                userJson.getString("contrasena"),
                                userJson.getString("materia"),
                                userJson.getString("rol"),
                                userJson.getString("transporte"),
                                userJson.getString("grupo"));

                        finish();
                        startCon = System.currentTimeMillis();
                        startActivity(new Intent(getApplicationContext(), SeleccionarCurso.class));
                    } else {
                        Toast.makeText(Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                RequestHandler requestHandler = new RequestHandler();

                HashMap<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("contrasena", password);

                return requestHandler.sendPostRequest(Api.URL_LOGIN_USER, params);
            }
        }
        UserLogin ul = new UserLogin();
        ul.execute();
        loadingBar.cancel();
    }


    /**
     * Cuando el usuario oprima el botón de regresar dos veces en menos de 2 segundos
     * la aplicación se cerrará, en ese lapso de tiempo envía un mensaje con la
     * advertencia
     */
    @Override
    public void onBackPressed() {
        if(back_pressed + 2000 > System.currentTimeMillis()) {
            System.exit(0);
        }
        else
            Toast.makeText(getBaseContext(), R.string.toast_salir, Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }




}
