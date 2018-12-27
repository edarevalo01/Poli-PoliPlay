package co.edu.poli.gamification.poliplay.Secuencia;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import co.edu.poli.gamification.poliplay.Narrativa.IntroduccionCurso;
import co.edu.poli.gamification.poliplay.R;
import co.edu.poli.gamification.poliplay.Servicios.Api;
import co.edu.poli.gamification.poliplay.Servicios.RequestHandler;

public class SeleccionarRol extends AppCompatActivity {

    private ImageView rolM1;
    private ImageView rolF1;
    private ImageView rolM2;
    private ImageView rolF2;
    private ImageView rolM3;
    private ImageView rolF3;
    private ImageView rolM4;
    private ImageView rolF4;
    private ImageView rolM5;
    private ImageView rolF5;
    private ImageView rolM6;
    private ImageView rolF6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_rol);

        rolM1 = (ImageView)findViewById(R.id.rolM1);
        rolF1 = (ImageView)findViewById(R.id.rolF1);
        rolM2 = (ImageView)findViewById(R.id.rolM2);
        rolF2 = (ImageView)findViewById(R.id.rolF2);
        rolM3 = (ImageView)findViewById(R.id.rolM3);
        rolF3 = (ImageView)findViewById(R.id.rolF3);
        rolM4 = (ImageView)findViewById(R.id.rolM4);
        rolF4 = (ImageView)findViewById(R.id.rolF4);
        rolM5 = (ImageView)findViewById(R.id.rolM5);
        rolF5 = (ImageView)findViewById(R.id.rolF5);
        rolM6 = (ImageView)findViewById(R.id.rolM6);
        rolF6 = (ImageView)findViewById(R.id.rolF6);

        asignarMiniRoles();

    }
    public void asignarMiniRoles(){
        if(Login.user.getSignature().equals("Proceso Administrativo")){
            rolM1.setImageDrawable(getDrawable(R.drawable.sel_izq_explorador));
            rolF1.setImageDrawable(getDrawable(R.drawable.sel_der_explorador));
            rolM2.setImageDrawable(getDrawable(R.drawable.sel_izq_filantropo));
            rolF2.setImageDrawable(getDrawable(R.drawable.sel_der_filantropa));
            rolM3.setImageDrawable(getDrawable(R.drawable.sel_izq_triunfador));
            rolF3.setImageDrawable(getDrawable(R.drawable.sel_der_triunfador));
            rolM4.setImageDrawable(getDrawable(R.drawable.sel_izq_pensador));
            rolF4.setImageDrawable(getDrawable(R.drawable.sel_der_pensadora));
            rolM5.setImageDrawable(getDrawable(R.drawable.sel_izq_revolucionario));
            rolF5.setImageDrawable(getDrawable(R.drawable.sel_der_revolucionaria));
            rolM6.setImageDrawable(getDrawable(R.drawable.sel_izq_comunicador));
            rolF6.setImageDrawable(getDrawable(R.drawable.sel_der_comunicadora));
        }
        else if(Login.user.getSignature().equals("Cultura Ambiental")){
            rolF1.setEnabled(false);
            rolF2.setEnabled(false);
            rolF3.setEnabled(false);
            rolF4.setEnabled(false);
            rolF5.setEnabled(false);
            rolF6.setEnabled(false);
            rolM1.setImageDrawable(getDrawable(R.drawable.sel_completo_coati));
            rolM2.setImageDrawable(getDrawable(R.drawable.sel_completo_tucan));
            rolM3.setImageDrawable(getDrawable(R.drawable.sel_completo_aguila));
            rolM4.setImageDrawable(getDrawable(R.drawable.sel_completo_carpintero));
            rolM5.setImageDrawable(getDrawable(R.drawable.sel_completo_tingua));
            rolM6.setImageDrawable(getDrawable(R.drawable.sel_completo_rana));

        }

    }
    public void btnSelRol(View view){
        String role = Login.user.getRole();
        if(role.equals("vacio")){
            String r = view.getContentDescription().toString();
            AddRole ar = new AddRole(r);
            ar.execute();
        }
        else{
            startActivity(new Intent(this, SeleccionarTransporte.class));
        }
    }

    public void btnVolver(View view){
        Intent i = new Intent(this, IntroduccionCurso.class);
        startActivity(i);
    }

    class AddRole extends AsyncTask<Void, Void, String> {
        private String roleAdd;

        public AddRole(String roleAdd){
            this.roleAdd = roleAdd;
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
                    Toast.makeText(SeleccionarRol.this, obj.getString("message"), Toast.LENGTH_SHORT).show();
                    JSONObject userJson = obj.getJSONObject("user");
                    //Agregar la materia al usuario.
                    Login.user.setRole(roleAdd);

                    finish();
                    startActivity(new Intent(getApplicationContext(), SeleccionarRolPopUp.class));
                } else {
                    Toast.makeText(SeleccionarRol.this, "Invalid data", Toast.LENGTH_SHORT).show();
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
            params.put("rol", roleAdd);

            return requestHandler.sendPostRequest(Api.URL_ADD_ROLE, params);
        }
    }
}
