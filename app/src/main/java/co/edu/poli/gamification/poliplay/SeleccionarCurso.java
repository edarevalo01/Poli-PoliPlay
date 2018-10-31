package co.edu.poli.gamification.poliplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class SeleccionarCurso extends AppCompatActivity {

    private RadioButton cultura, proceso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_curso);
        cultura = (RadioButton)findViewById(R.id.culturaButton);
        proceso = (RadioButton)findViewById(R.id.procesoButton);
        cultura.setChecked(true);
    }

    public void continuarSelCurso(View view){
        Intent i = new Intent(this, SeleccionarRol.class);
        if(cultura.isChecked()){
            Login.user.setSignature("Cultura Ambiental");
            startActivity(i);
        }
        else if(proceso.isChecked()){
            Login.user.setSignature("Proceso Administrativo");
            startActivity(i);
        }

    }
}
