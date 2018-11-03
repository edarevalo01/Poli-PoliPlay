package co.edu.poli.gamification.poliplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class SeleccionarRol extends AppCompatActivity {


    private int rolesExis;
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
        String f = rolF1.getContentDescription().toString();



    }
    public void asignarRol(View view){
        Login.user.setRole(view.getContentDescription().toString());
    }

    public void btnSelRolM(View view){
        asignarRol(view);
        Intent i = new Intent(this, SeleccionarRolPopUp.class);
        startActivity(i);
    }
    public void btnSelRolF(View view){
        Intent i = new Intent(this, SeleccionarRolPopUp.class);
        startActivity(i);
    }

    public void btnVolver(View view){
        Intent i = new Intent(this, SeleccionarCurso.class);
        startActivity(i);
    }
}
