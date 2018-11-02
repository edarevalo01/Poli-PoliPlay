package co.edu.poli.gamification.poliplay;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;

public class SeleccionarRolPopUp extends Activity {


    //private ImageView rol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_rol_pop_up);

        //rol = (ImageView)findViewById(R.id.rol);
        //rol.setImageDrawable(getResources().getDrawable(R.drawable.ahorcado7));
        DisplayMetrics md = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(md);

        int width = md.widthPixels;
        int heigth = md.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(heigth*.6));

    }

    public void btnSelRol (View view){
        Intent i = new Intent( this, SeleccionarTransporte.class );
        startActivity(i);
    }
}
