package co.edu.poli.gamification.poliplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class JuegoCalculadora extends AppCompatActivity {

    private EditText dato1, dato2, dato3, dato4, dato5, dato6, dato7;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_calculadora);
        dato1 = (EditText) findViewById(R.id.dato1);
        dato2 = (EditText) findViewById(R.id.dato2);
        dato3 = (EditText) findViewById(R.id.dato3);
        dato4 = (EditText) findViewById(R.id.dato4);
        dato5 = (EditText) findViewById(R.id.dato5);
        dato6 = (EditText) findViewById(R.id.dato6);
        dato7 = (EditText) findViewById(R.id.dato7);

        resultado = (TextView) findViewById(R.id.resultado);


    }
    public  void suma (View view){
        int dat1, dat2, dat3, dat4, dat5, dat6, dat7, res;

        dat1 = Integer.parseInt(dato1.getText().toString());
        dat2 = Integer.parseInt(dato2.getText().toString());
        dat3 = Integer.parseInt(dato3.getText().toString());
        dat4 = Integer.parseInt(dato4.getText().toString());
        dat5 = Integer.parseInt(dato5.getText().toString());
        dat6 = Integer.parseInt(dato6.getText().toString());
        dat7 = Integer.parseInt(dato7.getText().toString());


        res = dat1+dat2+dat3+dat7+dat6+dat5+dat4;

        resultado.setText(String.valueOf(res));
    }

}
