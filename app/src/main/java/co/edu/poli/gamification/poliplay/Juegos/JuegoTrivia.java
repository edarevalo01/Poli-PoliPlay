package co.edu.poli.gamification.poliplay.Juegos;
import android.content.Intent;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import co.edu.poli.gamification.poliplay.R;

public class JuegoTrivia extends AppCompatActivity{

    private String [] enunciadosPreg ={
            //Primer Enunciado
            "Unos jóvenes emprendedores acaban de naufragar en una isla en la que deben salir antes de 2 meses.  ¡Cuentan con un equipo de trabajo para sumir y lograr el reto!! \n" +
                    "\n" +
                    "La isla está dotada de 7 zonas para abastecer de recursos para la sobrevivencia y crear un medio de transporte eficiente que les permita alcanzar el objetivo, sin embargo, frente a la situación y en medio del asombro las personas manifiestan no tener claro que deben hacer al no tener mucha experiencia. \n" +
                    "\n" +
                    "Los equipos de trabajo saben que debe hacer algo, pero no sabe cómo, ya que iniciaran su negocio de una manera muy empírica y lo que saben lo ha venido aprendiendo sobre la marcha, saben que si no actúan pronto las personas el tiempo se les agotara por el tiempo que les tomara hacer realidad su idea de negocio y no podrá perder mucho dinero. \n" +
                    "\n" +
                    "Enunciado: \n" +
                    "\n" +
                    "¿De acuerdo con la historia anterior, Para que los equipos no pierdan tiempo y dinero que debería hacer?",
            //Segundo Enunciado
            "Unos jóvenes emprendedores acaban de naufragar en una isla en la que deben salir antes de 2 meses.  ¡Cuentan con un equipo de trabajo para sumir y lograr el reto!! \n" +
                    "\n" +
                    "La isla está dotada de 7 zonas para abastecer de recursos para la sobrevivencia y crear un medio de transporte eficiente que les permita alcanzar el objetivo, sin embargo, frente a la situación y en medio del asombro las personas manifiestan no tener claro que deben hacer al no tener mucha experiencia. \n" +
                    "\n" +
                    "Los equipos de trabajo saben que debe hacer algo, pero no sabe cómo, ya que iniciaran su negocio de una manera muy empírica y lo que saben lo ha venido aprendiendo sobre la marcha, saben que si no actúan pronto las personas el tiempo se les agotara por el tiempo que les tomara hacer realidad su idea de negocio y no podrá perder mucho dinero. \n" +
                    "\n" +
                    "Enunciado: \n" +
                    "\n" +
                    "De acuerdo con la historia anterior, los equipos deberán nombrar de manera oportuna un líder que especifique a cada integrante del equipo que debe hacer, como lo debe hacer y que espera de ellos, lo que los beneficia porque:",
            //Tercer Enunciado
            "Un grupo de estudiantes naufragan en una isla y deben crear un modelo de negocios orientado a la creación de un medio de transporte que los saque cuanto antes del lugar.   \n" +
                    "\n" +
                    "Sera una organización nueva en ese mercado, que se dedica a la producción y comercialización de medios de transporte, cuenta con 7 zonas para abastecerse y un equipo de personas creativas y emprendedoras.  En la actualidad los equipos se encuentran adelantando un diagnóstico para entrar en un proceso de planeación y organización estratégica, con el fin de establecer su nueva línea de transporte que permitan una alta rotación y genere ventas para lograr una sostenibilidad financiera. \n" +
                    "\n" +
                    "Enunciado: \n" +
                    "\n" +
                    "Para que los equipos inicien con el diagnostico estratégico y tengan la herramienta para evaluar a fondo_principal el impacto para su nuevo proyecto, sería conveniente iniciar el diagnostico con un:",
            //Cuarto
            "Un buen administrador coordina y aprovecha los recursos de la organización y las personas, para alcanzar los objetivos con eficacia y eficiencia. Obtiene resultados a través de la planeación, organización, dirección, control e integración y el del equipo de trabajo conformado por personas de la organización. \n" +
                    "\n" +
                    "Enunciado: \n" +
                    "\n" +
                    "De acuerdo con el contexto anterior la planeación, organización, dirección, control e integración son las funciones principales de:"


    };

    private String[][] opcionesRespuestas = {
            //Primeras Opciones de Respuesta
            {"Crear un plan de capacitación",
                    "Hacer un mejor reclutamiento y selección",
                    "Diseñar bien los cargos que necesita.",
                    "Especializar el cargo de vendedora."},
            //Segundas opciones de respuesta
            {"Los equipos   empezarán a vender más porque controlan sus actividades.",
                    "Los equipos tendrán mayor estabilidad en su trabajo porque están más satisfechos con lo que hacen.",
                    "Los equipos producirán más y se sentirán más satisfechos.",
                    "Los equipos se sentirán más satisfechos porque entienden el significado de sus trabajos y tienen control sobre lo que hacen."},
            //Terceras Opciones
            {"Estudio de mercados",
                    "Encuestas y entrevistas",
                    "Análisis del entorno",
                    "Análisis interno"},
            //Cuartas
            {"El presidente de la junta directiva de la organización",
                    "El administrador",
                    "Los accionistas de la empresa",
                    "El director de planeación"}
    };

    private  String[] respuestas = {
            "Diseñar bien los cargos que necesita.",
            "Los equipos se sentirán más satisfechos porque entienden el significado de sus trabajos y tienen control sobre lo que hacen.",
            "Análisis del entorno",
            "El director de planeación"};

    private int puntaje = 0;
    private int screens = 0;
    private int randy = 0;
    private TextView enunciadoPregunta;
    private Random randomEnun= new Random();
    private Button respues1;
    private Button respues2;
    private Button respues3;
    private Button respues4;
    private TextView score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_trivia);

        enunciadoPregunta = (TextView) findViewById(R.id.enunPreg);
        enunciadoPregunta.setMovementMethod(new ScrollingMovementMethod());
        respues1 = (Button) findViewById(R.id.opcionRes1);
        respues2 = (Button) findViewById(R.id.opcionRes2);
        respues3 = (Button) findViewById(R.id.opcionRes3);
        respues4 = (Button) findViewById(R.id.opcionRes4);

        pantallaRandom();
    }

    public void pantallaRandom(){
        int randomEnunciados = randomEnun.nextInt(enunciadosPreg.length);
        enunciadoPregunta.setText(enunciadosPreg[randomEnunciados]);
        respues1.setText(opcionesRespuestas[randomEnunciados][0]);
        respues2.setText(opcionesRespuestas[randomEnunciados][1]);
        respues3.setText(opcionesRespuestas[randomEnunciados][2]);
        respues4.setText(opcionesRespuestas[randomEnunciados][3]);
        randy = randomEnunciados;

    }

    public void nextScreen (View vista){
        TextView opcionPulsada = (TextView) vista;
        if (opcionPulsada.getText().toString() == respuestas[randy]) {
            puntaje++;
        }
        screens++;
        pantallaRandom();
    }


}
