package co.edu.poli.gamification.poliplay.Secuencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import co.edu.poli.gamification.poliplay.Juegos.JuegoAhorcado;
import co.edu.poli.gamification.poliplay.Juegos.JuegoCalculadora;
import co.edu.poli.gamification.poliplay.Juegos.JuegoCrucigrama;
import co.edu.poli.gamification.poliplay.Juegos.JuegoRelacionar;
import co.edu.poli.gamification.poliplay.Juegos.JuegoTrivia;
import co.edu.poli.gamification.poliplay.R;

public class Mapa extends AppCompatActivity {

    private TextView nombre, materia, rol, transporte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        nombre = (TextView)findViewById(R.id.nombre);
        materia = (TextView)findViewById(R.id.materia);
        rol = (TextView)findViewById(R.id.roll);
        transporte = (TextView)findViewById(R.id.transporte);

        nombre.setText(Login.user.getUsername());
        materia.setText(Login.user.getSignature());
        rol.setText(Login.user.getRole());
        transporte.setText(Login.user.getTransport());
    }

    public void relacionarBtn(View view){
        Intent i = new Intent(this, JuegoRelacionar.class);
        startActivity(i);
    }
    public void ahorcadoBtn(View view){
        Intent i = new Intent(this, JuegoAhorcado.class);
        startActivity(i);
    }
    public void triviaBtn(View view){
        Intent i = new Intent(this, JuegoTrivia.class);
        startActivity(i);
    }
    public void cruciBtn(View view){
        Intent i = new Intent(this, JuegoCrucigrama.class);
        startActivity(i);
    }
    public void calculadoraBtn(View view){
        Intent i = new Intent(this, JuegoCalculadora.class);
        startActivity(i);
    }
}
