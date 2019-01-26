package co.edu.poli.gamification.poliplay.Modelo;

import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import co.edu.poli.gamification.poliplay.Juegos.JuegoCrucigrama;
import co.edu.poli.gamification.poliplay.Servicios.Api;
import co.edu.poli.gamification.poliplay.Servicios.RequestHandler;

public class TiempoConexionJuego extends AsyncTask<Void, Void, String> {
    private String fecha;
    private String codigo_usuario;
    private String grupo_usuario;
    private String nombre_juego;
    private String puntaje;
    private String tiempo;

    public TiempoConexionJuego(String fecha, String codigo_usuario, String grupo_usuario, String nombre_juego, String puntaje, String tiempo){
        this.fecha = fecha;
        this.codigo_usuario = codigo_usuario;
        this.grupo_usuario = grupo_usuario;
        this.nombre_juego = nombre_juego;
        this.puntaje = puntaje;
        this.tiempo = tiempo;
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
                JSONObject userJson = obj.getJSONObject("time");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String doInBackground(Void... voids) {
        RequestHandler requestHandler = new RequestHandler();

        HashMap<String, String> params = new HashMap<>();
        params.put("fecha", fecha);
        params.put("codigo_usuario", codigo_usuario);
        params.put("grupo_usuario", grupo_usuario);
        params.put("nombre_juego", nombre_juego);
        params.put("puntaje", puntaje);
        params.put("tiempo", tiempo);

        return requestHandler.sendPostRequest(Api.URL_ADD_GAME_TIME, params);
    }
}
