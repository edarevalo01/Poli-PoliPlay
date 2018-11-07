package co.edu.poli.gamification.poliplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class SeleccionarCurso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_curso);
    }

    public void selAmbiental(View view){
        Intent i = new Intent(this, IntroduccionCurso.class);
        Login.user.setSignature("Cultura Ambiental");
        startActivity(i);
    }

    public void selAdmin(View view){
        Intent i = new Intent(this, IntroduccionCurso.class);
        Login.user.setSignature("Proceso Administrativo");
        startActivity(i);
    }

    public void btnVolver(View view){
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }
}
