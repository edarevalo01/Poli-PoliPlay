package co.edu.poli.gamification.poliplay.Secuencia;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import co.edu.poli.gamification.poliplay.Modelo.Utiles;
import co.edu.poli.gamification.poliplay.Narrativa.InicioViaje;
import co.edu.poli.gamification.poliplay.R;
import co.edu.poli.gamification.poliplay.Servicios.Api;
import co.edu.poli.gamification.poliplay.Servicios.RequestHandler;

import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class SeleccionarPuesto extends AppCompatActivity {

    private LinearLayout verticalLay;
    private Button buttons[] = new Button[506];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!Login.user.getGroup().equals("vacio")){
            startActivity(new Intent(getApplicationContext(), SeleccionarTransporte.class));
        }
        setContentView(R.layout.activity_seleccionar_puesto);
        String algo = null;
        try {
            algo = new CheckinSeleccionar().execute().get();
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        String numToList="";
        ArrayList <Integer> toUnable = new ArrayList<Integer>();
        for (int i = 1; i < algo.length(); i++) {
            if(Character.isDigit(algo.charAt(i))){
                numToList += algo.charAt(i);
            }
            else if(numToList != ""){
                toUnable.add(Integer.parseInt(numToList));
                numToList="";
            }
            else{
                continue;
            }
        }

        verticalLay = (LinearLayout) findViewById(R.id.verticalLayOut);
        for (int i = 1; i < 51; i++) {
            LinearLayout hl = new LinearLayout(this);
            hl.setOrientation(LinearLayout.HORIZONTAL);
            agregarBotones(hl, i);
            verticalLay.addView(hl);
        }

        for (int i = 0; i < toUnable.size(); i++) {
            buttons[toUnable.get(i)].setEnabled(false);
            buttons[toUnable.get(i)].setBackground(getResources().getDrawable(R.drawable.boton_sillas_dis));
        }

    }

    public void agregarBotones(LinearLayout hl, int l){
        for (int i = 1; i < 6; i++) {
            Button tv = new Button(this);
            LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
            tv.setBackground(getResources().getDrawable(R.drawable.boton_sillas_en));
            tv.setLayoutParams(lp);
            tv.setId((l*10)+i);
            tv.setText(l+"-"+String.valueOf((char)(i+64)));
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle ext = getIntent().getExtras();
                    String r = String.valueOf(v.getId());
                    AddGroup ar = new AddGroup(r);
                    ar.execute();
                    v.setEnabled(false);
                    v.setBackground(getResources().getDrawable(R.drawable.boton_sillas_dis));
                    startActivity(new Intent(getApplicationContext(), InicioViaje.class));
                }
            });
            hl.addView(tv);
            buttons[(l*10)+i] = tv;
        }
    }

    class AddGroup extends AsyncTask<Void, Void, String> {
        private String groupAdd;
        public AddGroup(String groupAdd){
            this.groupAdd = groupAdd;
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
                    Toast.makeText(SeleccionarPuesto.this, obj.getString("message"), Toast.LENGTH_SHORT).show();
                    JSONObject userJson = obj.getJSONObject("user");
                    Login.user.setGroup(groupAdd);
                    finish();
                    Utiles.terminarConexion();
                    startActivity(new Intent(getApplicationContext(), InicioViaje.class));
                } else {
                    Toast.makeText(SeleccionarPuesto.this, "Invalid data", Toast.LENGTH_SHORT).show();
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
            params.put("grupo", groupAdd);

            return requestHandler.sendPostRequest(Api.URL_ADD_GROUP, params);
        }
    }

    class CheckinSeleccionar extends AsyncTask<Void, Void, String>{
        @Override
        protected String doInBackground(Void... voids) {
            RequestHandler requestHandler = new RequestHandler();
            return requestHandler.sendGetRequest(Api.URL_GET_CHECKIN);
        }
    }

}