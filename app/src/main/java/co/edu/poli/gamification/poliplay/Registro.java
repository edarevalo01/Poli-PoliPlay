package co.edu.poli.gamification.poliplay;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Registro extends AppCompatActivity {

    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;

    private EditText emailR, userR, codeR, pass1, pass2;
    private Button btnR;
    private ProgressBar progressBar;

    boolean isUpdating = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        emailR = (EditText)findViewById(R.id.email_registro);
        userR = (EditText)findViewById(R.id.usuario_registro);
        codeR = (EditText)findViewById(R.id.codigo_registro);
        pass1 =(EditText)findViewById(R.id.clave_uno_registro);
        pass2 =(EditText)findViewById(R.id.clave_dos_registro);
        btnR = (Button)findViewById(R.id.btn_registro_registro);

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
        Toast.makeText(Registro.this, "¡Registro Exitoso!", Toast.LENGTH_SHORT).show();
    }

    private void createUser(){
        String email = emailR.getText().toString().trim();
        String user = userR.getText().toString().trim();
        String code = codeR.getText().toString().trim();
        String passU = (pass1.getText().toString().trim());
        String passD = (pass2.getText().toString().trim());
        if(TextUtils.isEmpty(email)){
            emailR.setError("Por favor ingresa un email válido.");
            emailR.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(user)){
            userR.setError("Ingresa un nombre de usuario.");
            userR.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(code)){
            codeR.setError("Ingresa un código");
            codeR.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(passU)){
            pass1.setError("Ingresa una contraseña");
            pass1.requestFocus();
            return;
        }
        if(!passU.equals(passD)){
            pass2.setError("Las contraseñas no coinciden.");
            pass2.requestFocus();
            return;
        }
        HashMap<String, String> params = new HashMap<>();
        params.put("codigo", code);
        params.put("correo", email);
        params.put("username", user);
        params.put("contrasena", passU);

        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_CREATE_USER, params, CODE_POST_REQUEST);
        request.execute();
    }

    private String encrip(String pass){
        return DigestUtils.md5Hex(pass.trim());
    }

    private class PerformNetworkRequest extends AsyncTask<Void, Void, String>{

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
