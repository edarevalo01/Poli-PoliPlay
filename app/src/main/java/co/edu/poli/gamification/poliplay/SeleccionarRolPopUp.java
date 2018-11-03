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

    private ImageView rol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_rol_pop_up);

        rol = (ImageView)findViewById(R.id.rolPrin);
        escogerRolPop();
        DisplayMetrics md = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(md);

        int width = md.widthPixels;
        int heigth = md.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(heigth*.6));

    }
    public void escogerRolPop(){

        if(Login.user.getRole() == "Rol 1"){
            rol.setImageDrawable(getDrawable(R.drawable.personaje_hombre_explorador));
        }
        if(Login.user.getRole() == "Rol 2"){
            rol.setImageDrawable(getResources().getDrawable(R.drawable.personaje_hombre_filantropo));
        }
        if(Login.user.getRole() == "Rol 3"){
            rol.setImageDrawable(getResources().getDrawable(R.drawable.personaje_hombre_pensador));
        }
        if(Login.user.getRole() == "Rol 4"){
            rol.setImageDrawable(getResources().getDrawable(R.drawable.personaje_hombre_revolucionario));
        }
        if(Login.user.getRole() == "Rol 5"){
            rol.setImageDrawable(getResources().getDrawable(R.drawable.personaje_hombre_socializador));
        }
        if(Login.user.getRole() == "Rol 6"){
            rol.setImageDrawable(getResources().getDrawable(R.drawable.personaje_hombre_triunfador));
        }
    }
    public void btnSelRol (View view){
        Intent i = new Intent( this, SeleccionarTransporte.class );
        startActivity(i);
    }
}
