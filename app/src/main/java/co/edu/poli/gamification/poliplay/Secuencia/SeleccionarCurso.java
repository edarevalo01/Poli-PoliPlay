package co.edu.poli.gamification.poliplay.Secuencia;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import co.edu.poli.gamification.poliplay.Modelo.TiempoConexion;
import co.edu.poli.gamification.poliplay.Modelo.Usuario;
import co.edu.poli.gamification.poliplay.Modelo.Utiles;
import co.edu.poli.gamification.poliplay.Narrativa.IntroduccionCurso;
import co.edu.poli.gamification.poliplay.R;
import co.edu.poli.gamification.poliplay.Servicios.Api;
import co.edu.poli.gamification.poliplay.Servicios.RequestHandler;

public class SeleccionarCurso extends AppCompatActivity {

    private long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_curso);
        Utiles.startCon = System.currentTimeMillis();

        if(!Login.user.getSignature().equals("vacio")){
            startActivity(new Intent(this, IntroduccionCurso.class));
        }
    }

    public void selAmbiental(View view) {
        String signature = Login.user.getSignature();
        if(signature.equals("vacio")){
            AddSignature as = new AddSignature("Cultura Ambiental");
            as.execute();
        } else{
            startActivity(new Intent(this, IntroduccionCurso.class));
        }
    }

    public void selAdmin(View view) {
        String signature = Login.user.getSignature();
        if (signature.equals("vacio")) {
            AddSignature as = new AddSignature("Proceso Administrativo");
            as.execute();
        } else {
            startActivity(new Intent(this, IntroduccionCurso.class));
        }
    }

    public void btnVolver(View view){
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        if(back_pressed + 2000 > System.currentTimeMillis())
            System.exit(0);
        else
            Toast.makeText(getBaseContext(), R.string.toast_salir, Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }

    class AddSignature extends AsyncTask<Void, Void, String> {
        private String signatureAdd;

        public AddSignature(String signatureAdd){
            this.signatureAdd = signatureAdd;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject obj = new JSONObject(s);
                if (!obj.getBoolean("error")) {
                    Toast.makeText(SeleccionarCurso.this, obj.getString("message"), Toast.LENGTH_SHORT).show();
                    JSONObject userJson = obj.getJSONObject("user");
                    Login.user.setSignature(signatureAdd);

                    finish();
                    Utiles.terminarConexion();
                    startActivity(new Intent(getApplicationContext(), IntroduccionCurso.class));
                } else {
                    Toast.makeText(SeleccionarCurso.this, "Invalid data", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(Void... voids) {
            RequestHandler requestHandler = new RequestHandler();

            HashMap<String, String> params = new HashMap<>();
            params.put("codigo", Login.user.getCode());
            params.put("materia", signatureAdd);

            return requestHandler.sendPostRequest(Api.URL_ADD_SIGNATURE, params);
        }
    }
}
