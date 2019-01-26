package co.edu.poli.gamification.poliplay.Secuencia;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import co.edu.poli.gamification.poliplay.Modelo.Utiles;
import co.edu.poli.gamification.poliplay.R;
import co.edu.poli.gamification.poliplay.Servicios.Api;
import co.edu.poli.gamification.poliplay.Servicios.RequestHandler;

public class SeleccionarTransportePopUp extends Activity {

    private ImageView transporte;
    private String transporteSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_transporte_pop_up);

        transporte = (ImageView)findViewById(R.id.transportePrincipal);
        transporteSeleccionado = Login.user.getTempTransport();

        //EscalarPantalla
        DisplayMetrics md = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(md);
        int width = md.widthPixels;
        int heigth = md.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (heigth * .6));

        escogerTransportePopUp();
    }

    public void escogerTransportePopUp() {

        if (Login.user.getSignature().equals("Proceso Administrativo")) {
            if (transporteSeleccionado.equals("Transporte 1"))    {
                transporte.setImageDrawable(getDrawable(R.drawable.transporte_alas));
            }
            else if (transporteSeleccionado.equals("Transporte 2"))    {
                transporte.setImageDrawable(getDrawable(R.drawable.transporte_barco));
            }
            else if (transporteSeleccionado.equals("Transporte 3")) {
                transporte.setImageDrawable(getDrawable(R.drawable.transporte_globo));
            }
            else if (transporteSeleccionado.equals("Transporte 4")) {
                transporte.setImageDrawable(getDrawable(R.drawable.transporte_balsa));
            }
            else if (transporteSeleccionado.equals("Transporte 5")) {
                transporte.setImageDrawable(getDrawable(R.drawable.transporte_submarino));
            }
            else if (transporteSeleccionado.equals("Transporte 6")) {
                transporte.setImageDrawable(getDrawable(R.drawable.transporte_tronco));
            }
        }
        else if (Login.user.getSignature().equals("Cultura Ambiental")) {
            if (transporteSeleccionado.equals("Transporte 1"))    {
                transporte.setImageDrawable(getDrawable(R.drawable.transporte_alas));
            }
            else if (transporteSeleccionado.equals("Transporte 2"))    {
                transporte.setImageDrawable(getDrawable(R.drawable.transporte_barco));
            }
            else if (transporteSeleccionado.equals("Transporte 3")) {
                transporte.setImageDrawable(getDrawable(R.drawable.transporte_globo));
            }
            else if (transporteSeleccionado.equals("Transporte 4")) {
                transporte.setImageDrawable(getDrawable(R.drawable.transporte_balsa));
            }
            else if (transporteSeleccionado.equals("Transporte 5")) {
                transporte.setImageDrawable(getDrawable(R.drawable.transporte_submarino));
            }
            else if (transporteSeleccionado.equals("Transporte 6")) {
                transporte.setImageDrawable(getDrawable(R.drawable.transporte_tronco));
            }
        }
    }

    public void btnSelTrans(View view) {
        Bundle ext = getIntent().getExtras();
        String r = ext.getString("transport");
        AddTransport ar = new AddTransport(r);
        ar.execute();
    }

    class AddTransport extends AsyncTask<Void, Void, String> {
        private String transportAdd;
        public AddTransport(String transportAdd){
            this.transportAdd = transportAdd;
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
                    Toast.makeText(SeleccionarTransportePopUp.this, obj.getString("message"), Toast.LENGTH_SHORT).show();
                    JSONObject userJson = obj.getJSONObject("user");
                    //Agregar el transporte al usuario.
                    Login.user.setTransport(transportAdd);

                    finish();
                    Utiles.terminarConexion();
                    startActivity(new Intent(getApplicationContext(), Mapa.class));
                } else {
                    Toast.makeText(SeleccionarTransportePopUp.this, "Invalid data", Toast.LENGTH_SHORT).show();
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
            params.put("transporte", transportAdd);

            return requestHandler.sendPostRequest(Api.URL_ADD_TRANSPORT, params);
        }
    }
}
