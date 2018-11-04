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
    private String rolSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_rol_pop_up);

        rol = (ImageView)findViewById(R.id.rolPrin);
        rolSelected = Login.user.getRole();

        //EscalarPantalla
        DisplayMetrics md = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(md);

        int width = md.widthPixels;
        int heigth = md.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (heigth * .6));

        escogerRolPop();
    }

    public void escogerRolPop() {
        if (Login.user.getSignature() == "Proceso Administrativo") {
            if (rolSelected == "Rol 1") {
                rol.setImageDrawable(getDrawable(R.drawable.personaje_hombre_explorador));
            }
            if (rolSelected == "Rol 2") {
                rol.setImageDrawable(getDrawable(R.drawable.personaje_hombre_filantropo));
            }
            if (rolSelected == "Rol 3") {
                rol.setImageDrawable(getDrawable(R.drawable.personaje_hombre_triunfador));
            }
            if (Login.user.getRole() == "Rol 4") {
                rol.setImageDrawable(getDrawable(R.drawable.personaje_hombre_pensador));
            }
            if (Login.user.getRole() == "Rol 5") {
                rol.setImageDrawable(getDrawable(R.drawable.personaje_hombre_revolucionario));
            }
            if (Login.user.getRole() == "Rol 6") {
                rol.setImageDrawable(getDrawable(R.drawable.personaje_hombre_socializador));
            }
        }
    }

    public void btnSelRol(View view) {
        Intent i = new Intent(this, SeleccionarTransporte.class);
        startActivity(i);
    }
}
