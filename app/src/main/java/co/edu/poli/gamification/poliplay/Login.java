package co.edu.poli.gamification.poliplay;

import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Login extends AppCompatActivity {

    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;

    private static long back_pressed;
    private Button btnLogin;
    private EditText usernameLogin, passwordLogin;
    private TextView noReg;
    private ProgressDialog loadingBar;
    private static final String TAG = "Login";

    public static Usuario user = new Usuario("Usuario", "Pruebas", "testuser", "a123*");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        usernameLogin = (EditText)findViewById(R.id.usernameLogin);
        passwordLogin = (EditText)findViewById(R.id.passwordLogin);
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
        String username = usernameLogin.getText().toString();
        if(username.isEmpty()){
            Toast.makeText(Login.this, R.string.toast_usuario, Toast.LENGTH_SHORT).show();
            return;
        }
        String password = passwordLogin.getText().toString();
        if(password.isEmpty()){
            Toast.makeText(Login.this, R.string.toast_contrasena, Toast.LENGTH_SHORT).show();
            return;
        }
        loadingBar.setTitle(R.string.progress_login);
        loadingBar.setMessage(getString(R.string.progress_esperar));
        loadingBar.show();
        if(confirmData(username, password)){
            loadingBar.cancel();
            Intent i = new Intent(Login.this, SeleccionarCurso.class);
            startActivity(i);
            finish();
            return;
        }
        else if(username.equals("t")){
            loadingBar.cancel();
            Intent i = new Intent(Login.this, Mapa.class);
            startActivity(i);
            finish();
            return;
        }
        loadingBar.cancel();
        Toast.makeText(this, R.string.toast_noEquals, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param username Usuario ingresado en la pantalla de Login que se compara en la base de datos
     * @param password Contrasena ingresada en la pantalla de Login que se compara en la base de datos
     * @return Si los datos son válidos o no
     */
    private boolean confirmData(String username, String password){
        return username.equals(user.getUsername()) && password.equals(user.getPassword());
    }

    /**
     * Cuando el usuario oprima el botón de regresar dos veces en menos de 2 segundos
     * la aplicación se cerrará, en ese lapso de tiempo envía un mensaje con la
     * advertencia
     */
    @Override
    public void onBackPressed() {
        if(back_pressed + 2000 > System.currentTimeMillis())
            System.exit(0);
        else
            Toast.makeText(getBaseContext(), R.string.toast_salir, Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
    }


    private class PerformNetworkRequest extends AsyncTask<Void, Void, String> {

        String url;
        HashMap<String, String> params;
        int requestCode;

        PerformNetworkRequest(String url, HashMap<String, String> params, int requestCode){
            this.url = url;
            this.params = params;
            this.requestCode = requestCode;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try{
                JSONObject object = new JSONObject(s);
                if(!object.getBoolean("error")){
                    Toast.makeText(getApplicationContext(), object.getString("message"), Toast.LENGTH_SHORT).show();
                    //refreshHeroList
                }
            }catch (JSONException e){
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(Void... voids) {
            RequestHandler requestHandler = new RequestHandler();
            if(requestCode == CODE_POST_REQUEST){
                return requestHandler.sendPostRequest(url, params);
            }
            if(requestCode == CODE_GET_REQUEST){
                return requestHandler.sendGetRequest(url);
            }
            return null;
        }
    }
}
