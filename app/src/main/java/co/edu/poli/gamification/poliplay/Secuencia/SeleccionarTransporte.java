package co.edu.poli.gamification.poliplay.Secuencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import co.edu.poli.gamification.poliplay.R;

public class SeleccionarTransporte extends AppCompatActivity {

    private ImageView transp1, transp2, transp3, transp4, transp5, transp6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_transporte);

        transp1 = (ImageView) findViewById(R.id.transp1);
        transp2 = (ImageView) findViewById(R.id.transp2);
        transp3 = (ImageView) findViewById(R.id.transp3);
        transp4 = (ImageView) findViewById(R.id.transp4);
        transp5 = (ImageView) findViewById(R.id.transp5);
        transp6 = (ImageView) findViewById(R.id.transp6);

        asignarTransportes();
    }
    public void asignarTransportes(){
        if(Login.user.getSignature().equals("Proceso Administrativo")){
            transp1.setImageDrawable(getDrawable(R.drawable.sel_completo_trans_avion));
            transp2.setImageDrawable(getDrawable(R.drawable.sel_completo_trans_barco));
            transp3.setImageDrawable(getDrawable(R.drawable.sel_completo_trans_globo));
            transp4.setImageDrawable(getDrawable(R.drawable.sel_completo_trans_balsa));
            transp5.setImageDrawable(getDrawable(R.drawable.sel_completo_trans_submarino));
            transp6.setImageDrawable(getDrawable(R.drawable.sel_completo_trans_tronco));

        }
        else if(Login.user.getSignature().equals("Cultura Ambiental")){
            transp1.setImageDrawable(getDrawable(R.drawable.sel_completo_trans_avion));
            transp2.setImageDrawable(getDrawable(R.drawable.sel_completo_trans_barco));
            transp3.setImageDrawable(getDrawable(R.drawable.sel_completo_trans_globo));
            transp4.setImageDrawable(getDrawable(R.drawable.sel_completo_trans_balsa));
            transp5.setImageDrawable(getDrawable(R.drawable.sel_completo_trans_submarino));
            transp6.setImageDrawable(getDrawable(R.drawable.sel_completo_trans_tronco));
        }
    }
    public void btnVolver(View view){
        Intent i = new Intent(this, SeleccionarRol.class);
        startActivity(i);
    }
    public void btnSelTrans(View view){
        Login.user.setTransport(view.getContentDescription().toString());
        Intent i = new Intent(this, SeleccionarTransportePopUp.class);
        startActivity(i);
    }


}
