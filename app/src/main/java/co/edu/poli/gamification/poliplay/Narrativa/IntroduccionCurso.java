package co.edu.poli.gamification.poliplay.Narrativa;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import co.edu.poli.gamification.poliplay.Secuencia.Login;
import co.edu.poli.gamification.poliplay.R;
import co.edu.poli.gamification.poliplay.Secuencia.SeleccionarCurso;
import co.edu.poli.gamification.poliplay.Secuencia.SeleccionarRol;

public class IntroduccionCurso extends AppCompatActivity {

    private ConstraintLayout layout_intro_curso;
    private Guideline guidelineFooter;
    private ImageView titulo, descripcion;
    private ImageButton btnBack, btnCont;
    private boolean parteUno = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduccion_curso);
        layout_intro_curso = (ConstraintLayout)findViewById(R.id.layout_intro_curso);
        guidelineFooter = (Guideline)findViewById(R.id.footer_intro_curso);
        titulo = (ImageView)findViewById(R.id.titulo_intro_curso);
        descripcion = (ImageView)findViewById(R.id.descripcion_intro_curso);
        btnBack = (ImageButton)findViewById(R.id.btn_back_intro_curso);
        btnCont = (ImageButton)findViewById(R.id.btn_cont_intro_curso);

        setImages();
    }

    public void goBack(View view){
        if(!parteUno) {
            Intent i = new Intent(IntroduccionCurso.this, SeleccionarCurso.class);
            startActivity(i);
        }
        else{
            guidelineFooter.setGuidelinePercent(0.86F);
            btnCont.setImageDrawable(getResources().getDrawable(R.drawable.boton_adelante));
            descripcion.setImageDrawable(getResources().getDrawable(R.drawable.descripcion_intro_curso));
            parteUno = false;
        }
    }

    public void goForward(View view){
        if(parteUno){
            Intent i = new Intent(IntroduccionCurso.this, SeleccionarRol.class);
            startActivity(i);
        }
        else{
            //left top rigth bottom
            guidelineFooter.setGuidelinePercent(0.7F);
            btnCont.setImageResource((R.drawable.boton_vamos_empezar));
            descripcion.setImageDrawable(getResources().getDrawable(R.drawable.descripcion_intro_curso2));
            parteUno = true;
        }
    }

    private void setImages(){
        if(Login.user.getSignature().equals("Cultura Ambiental")){
            layout_intro_curso.setBackground(getResources().getDrawable(R.drawable.fondo_ambiental));
            titulo.setImageDrawable(getResources().getDrawable(R.drawable.titulo_intro_ambiental));
        }
        else if(Login.user.getSignature().equals("Proceso Administrativo")){
            layout_intro_curso.setBackground(getResources().getDrawable(R.drawable.fondo_proceso));
            titulo.setImageDrawable(getResources().getDrawable(R.drawable.titulo_intro_proceso));
        }
    }
}
