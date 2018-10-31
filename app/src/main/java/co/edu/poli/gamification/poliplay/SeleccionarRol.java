package co.edu.poli.gamification.poliplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class SeleccionarRol extends AppCompatActivity {

    private RadioButton rol1, rol2, rol3, rol4, rol5, rol6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_rol);
        rol1 = (RadioButton) findViewById(R.id.rol1);
        rol2 = (RadioButton) findViewById(R.id.rol2);
        rol3 = (RadioButton) findViewById(R.id.rol3);
        rol4 = (RadioButton) findViewById(R.id.rol4);
        rol5 = (RadioButton) findViewById(R.id.rol5);
        rol6 = (RadioButton) findViewById(R.id.rol6);
        String s = Login.user.getSignature();
        if(s.equals("Cultura Ambiental")){
            rol1.setText(getResources().getString(R.string.rolAgua));
            rol2.setText(getResources().getString(R.string.rolTierra));
            rol3.setText(getResources().getString(R.string.rolAire));
            rol4.setText(getResources().getString(R.string.rolEnergia));
            rol5.setText(getResources().getString(R.string.rolFauna));
            rol6.setText(getResources().getString(R.string.rolReciclaje));
        }
        else if(s.equals("Proceso Administrativo")){
            rol1.setText(getResources().getString(R.string.rol1));
            rol2.setText(getResources().getString(R.string.rol2));
            rol3.setText(getResources().getString(R.string.rol3));
            rol4.setText(getResources().getString(R.string.rol4));
            rol5.setText(getResources().getString(R.string.rol5));
            rol6.setText(getResources().getString(R.string.rol6));
        }
        rol1.setChecked(true);
    }

    public void continuarBtn(View view){
        Intent i = new Intent(this, SeleccionarTransporte.class);
        if(rol1.isChecked()) Login.user.setRole(rol1.getText().toString());
        else if(rol2.isChecked()) Login.user.setRole(rol2.getText().toString());
        else if(rol3.isChecked()) Login.user.setRole(rol3.getText().toString());
        else if(rol4.isChecked()) Login.user.setRole(rol4.getText().toString());
        else if(rol5.isChecked()) Login.user.setRole(rol5.getText().toString());
        else if(rol6.isChecked()) Login.user.setRole(rol6.getText().toString());
        startActivity(i);
    }
}
