package co.edu.poli.gamification.poliplay.Juegos;

import android.content.ClipData;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import co.edu.poli.gamification.poliplay.R;
import co.edu.poli.gamification.poliplay.Secuencia.Login;
import co.edu.poli.gamification.poliplay.Servicios.Api;
import co.edu.poli.gamification.poliplay.Servicios.RequestHandler;

public class JuegoRelacionar extends AppCompatActivity {

    private  TextView txt1, txt2, txt3, txt4, txt5, txt6,
            target1, target2, target3, target4, target5, target6;

    private long start, end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_relacionar);

        start = System.currentTimeMillis();
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        txt4 = (TextView) findViewById(R.id.txt4);
        txt5 = (TextView) findViewById(R.id.txt5);
        txt6 = (TextView) findViewById(R.id.txt6);
        target1 = (TextView) findViewById(R.id.target1);
        target2 = (TextView) findViewById(R.id.target2);
        target3 = (TextView) findViewById(R.id.target3);
        target4 = (TextView) findViewById(R.id.target4);
        target5 = (TextView) findViewById(R.id.target5);
        target6 = (TextView) findViewById(R.id.target6);

        txt1.setOnLongClickListener(longClickListener);
        txt2.setOnLongClickListener(longClickListener);
        txt3.setOnLongClickListener(longClickListener);
        txt4.setOnLongClickListener(longClickListener);
        txt5.setOnLongClickListener(longClickListener);
        txt6.setOnLongClickListener(longClickListener);
        target1.setOnDragListener(dragListener1);
        target2.setOnDragListener(dragListener2);
        target3.setOnDragListener(dragListener3);
        target4.setOnDragListener(dragListener4);
        target5.setOnDragListener(dragListener5);
        target6.setOnDragListener(dragListener6);
    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadowBuilder, v, 0);
            return true;
        }
    };

    View.OnDragListener dragListener1 = new View.OnDragListener(){
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent){
                case DragEvent.ACTION_DROP:
                    final View view = (View) event.getLocalState();
                    if(view.getId() == R.id.txt1) target1.setText(txt1.getText());
                    else if(view.getId() == R.id.txt2) target1.setText(txt2.getText());
                    else if(view.getId() == R.id.txt3) target1.setText(txt3.getText());
                    else if(view.getId() == R.id.txt4) target1.setText(txt4.getText());
                    else if(view.getId() == R.id.txt5) target1.setText(txt5.getText());
                    else if(view.getId() == R.id.txt6) target1.setText(txt6.getText());
                    break;
            }
            return true;
        }
    };

    View.OnDragListener dragListener2 = new View.OnDragListener(){
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent){
                case DragEvent.ACTION_DROP:
                    final View view = (View) event.getLocalState();
                    if(view.getId() == R.id.txt1) target2.setText(txt1.getText());
                    else if(view.getId() == R.id.txt2) target2.setText(txt2.getText());
                    else if(view.getId() == R.id.txt3) target2.setText(txt3.getText());
                    else if(view.getId() == R.id.txt4) target2.setText(txt4.getText());
                    else if(view.getId() == R.id.txt5) target2.setText(txt5.getText());
                    else if(view.getId() == R.id.txt6) target2.setText(txt6.getText());
                    break;
            }
            return true;
        }
    };

    View.OnDragListener dragListener3 = new View.OnDragListener(){
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent){
                case DragEvent.ACTION_DROP:
                    final View view = (View) event.getLocalState();
                    if(view.getId() == R.id.txt1) target3.setText(txt1.getText());
                    else if(view.getId() == R.id.txt2) target3.setText(txt2.getText());
                    else if(view.getId() == R.id.txt3) target3.setText(txt3.getText());
                    else if(view.getId() == R.id.txt4) target3.setText(txt4.getText());
                    else if(view.getId() == R.id.txt5) target3.setText(txt5.getText());
                    else if(view.getId() == R.id.txt6) target3.setText(txt6.getText());
                    break;
            }
            return true;
        }
    };

    View.OnDragListener dragListener4 = new View.OnDragListener(){
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent){
                case DragEvent.ACTION_DROP:
                    final View view = (View) event.getLocalState();
                    if(view.getId() == R.id.txt1) target4.setText(txt1.getText());
                    else if(view.getId() == R.id.txt2) target4.setText(txt2.getText());
                    else if(view.getId() == R.id.txt3) target4.setText(txt3.getText());
                    else if(view.getId() == R.id.txt4) target4.setText(txt4.getText());
                    else if(view.getId() == R.id.txt5) target4.setText(txt5.getText());
                    else if(view.getId() == R.id.txt6) target4.setText(txt6.getText());
                    break;
            }
            return true;
        }
    };

    View.OnDragListener dragListener5 = new View.OnDragListener(){
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent){
                case DragEvent.ACTION_DROP:
                    final View view = (View) event.getLocalState();
                    if(view.getId() == R.id.txt1) target5.setText(txt1.getText());
                    else if(view.getId() == R.id.txt2) target5.setText(txt2.getText());
                    else if(view.getId() == R.id.txt3) target5.setText(txt3.getText());
                    else if(view.getId() == R.id.txt4) target5.setText(txt4.getText());
                    else if(view.getId() == R.id.txt5) target5.setText(txt5.getText());
                    else if(view.getId() == R.id.txt6) target5.setText(txt6.getText());
                    break;
            }
            return true;
        }
    };

    View.OnDragListener dragListener6 = new View.OnDragListener(){
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent){
                case DragEvent.ACTION_DROP:
                    final View view = (View) event.getLocalState();
                    if(view.getId() == R.id.txt1) target6.setText(txt1.getText());
                    else if(view.getId() == R.id.txt2) target6.setText(txt2.getText());
                    else if(view.getId() == R.id.txt3) target6.setText(txt3.getText());
                    else if(view.getId() == R.id.txt4) target6.setText(txt4.getText());
                    else if(view.getId() == R.id.txt5) target6.setText(txt5.getText());
                    else if(view.getId() == R.id.txt6) target6.setText(txt6.getText());
                    break;
            }
            return true;
        }
    };


    public void respuestas(View view){
        int points = getPoints();
        Intent intent = new Intent(this, JuegoRelacionarSolucion.class);
        intent.putExtra("points", points);
        intent.putExtra("ans1", txt1.getText());
        intent.putExtra("ans2", txt2.getText());
        intent.putExtra("ans3", txt3.getText());
        intent.putExtra("ans4", txt4.getText());
        intent.putExtra("ans5", txt5.getText());
        intent.putExtra("ans6", txt6.getText());
        intent.putExtra("sal1", target1.getText());
        intent.putExtra("sal2", target2.getText());
        intent.putExtra("sal3", target3.getText());
        intent.putExtra("sal4", target4.getText());
        intent.putExtra("sal5", target5.getText());
        intent.putExtra("sal6", target6.getText());
        end = System.currentTimeMillis();
        long totaltime = (end-start)/1000;
        AddTimeRelacionar atr = new AddTimeRelacionar(
                getFecha(),
                Login.user.getCode(),
                Login.user.getGroup(),
                "Relacionar",
                String.valueOf(getPoints()),
                String.valueOf(totaltime));
        atr.execute();
        startActivity(intent);
    }

    private String getFecha(){
        String res = "";
        Calendar fecha = new GregorianCalendar();
        int ano = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);

        res += ano + "/" + mes + "/" + dia + "-" + hora + ":" + minuto;
        return res;
    }

    public int getPoints(){
        int cont = 0;
        if(target1.getText() == txt1.getText()) cont++;
        if(target2.getText() == txt2.getText()) cont++;
        if(target3.getText() == txt3.getText()) cont++;
        if(target4.getText() == txt4.getText()) cont++;
        if(target5.getText() == txt5.getText()) cont++;
        if(target6.getText() == txt6.getText()) cont++;
        return cont;
    }

    class AddTimeRelacionar extends AsyncTask<Void, Void, String> {
        private String fecha;
        private String codigo_usuario;
        private String grupo_usuario;
        private String nombre_juego;
        private String puntaje;
        private String tiempo;

        public AddTimeRelacionar(String fecha, String codigo_usuario, String grupo_usuario, String nombre_juego, String puntaje, String tiempo){
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
                    Toast.makeText(JuegoRelacionar.this, obj.getString("message"), Toast.LENGTH_SHORT).show();
                    JSONObject userJson = obj.getJSONObject("time");
                    finish();
                } else {
                    Toast.makeText(JuegoRelacionar.this, "Invalid data", Toast.LENGTH_SHORT).show();
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

}
