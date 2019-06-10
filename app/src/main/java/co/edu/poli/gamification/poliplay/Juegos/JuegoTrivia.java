package co.edu.poli.gamification.poliplay.Juegos;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
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

import org.xml.sax.helpers.LocatorImpl;

import java.util.Random;

import co.edu.poli.gamification.poliplay.Modelo.TiempoConexionJuego;
import co.edu.poli.gamification.poliplay.Modelo.Utiles;
import co.edu.poli.gamification.poliplay.R;
import co.edu.poli.gamification.poliplay.Secuencia.Login;
import co.edu.poli.gamification.poliplay.Secuencia.Mapa;

public class JuegoTrivia extends AppCompatActivity{

    //---------------------------------------------------------------------------
    //
    // Falta poner los contadores de tiempo de juego y conexion
    //
    //---------------------------------------------------------------------------

    private String [] enunciadosPreg ={
            //
            "El éxito empresarial  depende de la habilidad para planear efectivamente y asegurar su efectividad  en alineación con e control.  Esto se explica porque la planeación",
            //
            "Jóvenes emprendedores han diseñado unos medios de transporte para la prestación del servicio para salir de la isla aprovechando su entorno para tomar decisiones estratégicas. El mayor reto que deberá enfrentar próximamente es:",
            //
            "En una situación desconocida, es importante tomar decisiones para actuar, deberán enfrentar rápidamente un proceso de selección de personas que  permita  elegir los mejores para un buen desempeño. Una combinación para prever lo anterior sería:",
            //
            "Un modelo de negocios es eficiente, pero no eficaz cuando:",
            //
            "Los administradores no solo aplican el proceso administrativo, sino que también desempeñan roles o papeles que según Henry Mintzberg los podemos categorizar en:",
            //Trivia 2
            "Un buen administrador coordina y aprovecha los recursos de la organización y las personas, para alcanzar los objetivos con eficacia y eficiencia. Obtiene resultados a través del proceso administrativo y de su equipo de trabajo. De acuerdo con lo anterior estas son funciones principales de:",
            //
            "Un grupo de estudiantes naufragan en una isla y deben crear un modelo de negocios novedoso orientado a la creación de un medio de transporte que los saque cuanto antes del lugar.  Actualmente los equipos se encuentran adelantando un diagnóstico, con el fin de establecer su nueva línea de transporte sostenible financieramente. Para evaluar el impacto en su nuevo proyecto, sería conveniente iniciar el diagnostico con un:",
            //
            "Unos jóvenes emprendedores acaban de naufragar en una isla en la que deben salir antes de 2 meses. Deben hacer algo, pero no saben cómo, iniciaran su negocio de manera empírica, deben actuar pronto y hacer realidad su idea de negocio condicionado por la falta de dinero. De acuerdo con la historia anterior, ¿Para que los equipos no pierdan tiempo y dinero que debería hacer?  De acuerdo a lo anterior, deberán nombrar oportunamente un líder que los oriente en el qué y cómo hacer y qué espera de ellos, generando al equipo un beneficio porque:",
            //
            "Unos jóvenes emprendedores acaban de naufragar en una isla en la que deben salir antes de 2 meses.  ¡Cuentan con un equipo de trabajo para sumir y lograr el reto!! \n" +
                    "\n" +
            "Los equipos deben hacer algo, pero no saben cómo, iniciaran su negocio de una manera empírica, deben actuar pronto y hacer realidad su idea de negocio condicionado por la falta de dinero. De acuerdo con la historia anterior, ¿Para que los equipos no pierdan tiempo y dinero que debería hacer?",
            //
            "Un equipo náufrago está iniciando su empresa de construcción de un medio de transporte para salir de la isla en un periodo corto de tiempo. Recientemente ganó unos retos para su  construcción, sin embargo, no cuenta con todo el personal, porque están pensando en una alianza para servicios especializados e independientes. Para lo que desea hacer el equipo la estructura por procesos es la más ventajosa ¿por qué?",
            //
            "Unos náufragos desean sacar adelante el proyecto profesional de sus sueños, un modelo de negocios que les permita salir de la isla, la cual desde hace unas semanas viene presentando problemas financieros, tienen como ideas vender excedentes de materia prima u ofrecer  el servicio de transporte. De acuerdo con la historia anterior, si los náufragos ofrecen puestos a otras personas y con el dinero pagan las deudas y equipo esta:",
            //
            "Unos náufragos desean sacar adelante el proyecto profesional de sus sueños, un modelo de negocios que les permita salir de la isla, la cual desde hace unas semanas viene presentando problemas financieros, tienen como ideas vender excedentes de materia prima u ofrecer el servicio de transporte. De acuerdo con la historia anterior, ¿qué es lo primero que deben hacer los náufragos para tomar una buena decisión?",
            //
            "El líder unos jóvenes náufragos se ha sentido frustrado, desde hace 3 semanas vienen desarrollando un proyecto para ayudarlos a salir de la isla y a otros mediante una reducción de costos fijos, generando ahorro en insumos; algunos no convencidos la consideran innecesaria.  El líder del equipo que se ve como un Open Mind tiene una idea Mcgregoriana del comportamiento de sus compañeros de equipo porque:",
            //
            "Un cliente requiere solucionar la problemática presentada en él lugar del naufrago, reúne a expertos para crear opciones. De acuerdo con lo anterior, ¿cuál sería el nombre de las personas que se reúnen y cual su enfoque para encontrar la solución? ",
            //
            "El líder unos jóvenes náufragos se ha sentido frustrado, desde hace 3 semanas vienen desarrollando un proyecto para ayudarlos a salir de la isla y a otros mediante una reducción de costos fijos, generando ahorro en insumos; algunos no convencidos la consideran innecesaria. Frente a la negativa, el líder del equipo está pensando en abandonar el proyecto ya que ve que esta no le hace honor a su nombre “Open Mind”",
            //
            "Unos jóvenes emprendedores acaban de naufragar en una isla en la que deben salir antes de 2 meses.  ¡Cuentan con un equipo de trabajo para sumir y lograr el reto!! \n" +
                    "\n" +
                    "La isla está dotada de 7 zonas para abastecer de recursos para la sobrevivencia y crear un medio de transporte eficiente que les permita alcanzar el objetivo, sin embargo, frente a la situación y en medio del asombro las personas manifiestan no tener claro que deben hacer al no tener mucha experiencia. \n" +
                    "\n" +
                    "Los equipos de trabajo saben que debe hacer algo, pero no sabe cómo, ya que iniciaran su negocio de una manera muy empírica y lo que saben lo ha venido aprendiendo sobre la marcha, saben que si no actúan pronto las personas el tiempo se les agotara por el tiempo que les tomara hacer realidad su idea de negocio y no podrá perder mucho dinero. \n" +
                    "\n" +
                    "Enunciado: \n" +
                    "\n" +
                    "¿De acuerdo con la historia anterior, Para que los equipos no pierdan tiempo y dinero que debería hacer?",
            //
            "Unos jóvenes emprendedores acaban de naufragar en una isla en la que deben salir antes de 2 meses.  ¡Cuentan con un equipo de trabajo para sumir y lograr el reto!! \n" +
                    "\n" +
                    "La isla está dotada de 7 zonas para abastecer de recursos para la sobrevivencia y crear un medio de transporte eficiente que les permita alcanzar el objetivo, sin embargo, frente a la situación y en medio del asombro las personas manifiestan no tener claro que deben hacer al no tener mucha experiencia. \n" +
                    "\n" +
                    "Los equipos de trabajo saben que debe hacer algo, pero no sabe cómo, ya que iniciaran su negocio de una manera muy empírica y lo que saben lo ha venido aprendiendo sobre la marcha, saben que si no actúan pronto las personas el tiempo se les agotara por el tiempo que les tomara hacer realidad su idea de negocio y no podrá perder mucho dinero. \n" +
                    "\n" +
                    "Enunciado: \n" +
                    "\n" +
                    "De acuerdo con la historia anterior, los equipos deberán nombrar de manera oportuna un líder que especifique a cada integrante del equipo que debe hacer, como lo debe hacer y que espera de ellos, lo que los beneficia porque:",
            //
            "Un grupo de estudiantes naufragan en una isla y deben crear un modelo de negocios orientado a la creación de un medio de transporte que los saque cuanto antes del lugar.   \n" +
                    "\n" +
                    "Sera una organización nueva en ese mercado, que se dedica a la producción y comercialización de medios de transporte, cuenta con 7 zonas para abastecerse y un equipo de personas creativas y emprendedoras.  En la actualidad los equipos se encuentran adelantando un diagnóstico para entrar en un proceso de planeación y organización estratégica, con el fin de establecer su nueva línea de transporte que permitan una alta rotación y genere ventas para lograr una sostenibilidad financiera. \n" +
                    "\n" +
                    "Enunciado: \n" +
                    "\n" +
                    "Para que los equipos inicien con el diagnostico estratégico y tengan la herramienta para evaluar a fondo_principal el impacto para su nuevo proyecto, sería conveniente iniciar el diagnostico con un:",
            //
            "Un buen administrador coordina y aprovecha los recursos de la organización y las personas, para alcanzar los objetivos con eficacia y eficiencia. Obtiene resultados a través de la planeación, organización, dirección, control e integración y el del equipo de trabajo conformado por personas de la organización. \n" +
                    "\n" +
                    "Enunciado: \n" +
                    "\n" +
                    "De acuerdo con el contexto anterior la planeación, organización, dirección, control e integración son las funciones principales de:"
    };

    private String[][] opcionesRespuestas = {
            //
            {"Depende de La habilidad de los administradores de desarrollar un plan que reúna y coordine todo el conjunto de tareas que ocurren dentro de ella",
                    "Identifica y diseña las actividades que son necesarias para obtener los objetivos o metas de una organización",
                    "Es un grupo de personas que trabajan juntos en busca de un objetivo común",
                    "Es un proceso en el que los gerentes y los líderes demuestran su capacidad para resolver problemas y convertirlos en oportunidades"},
            //
            {"Competencia creciente en un mercado globalizado.",
                    "Calificación y desarrollo de sus técnicos programadores",
                    "Capacidad financiera para apalancar su crecimiento",
                    "Obsolescencia de sus equipos y recursos tecnológicos."},
            //
            {"La experiencia y las relaciones interpersonales.",
                    "La motivación y la competencia",
                    "Las relaciones interpersonales y el liderazgo",
                    "La autoridad y la competencia."},
            //
            {"La Dirección no tiene una buena comunicación para trasmitir a los integrantes del equipo los objetivos de la planeación.",
            "La Dirección no tiene un alto nivel de negociación con sus proveedores",
            "La Dirección no selecciono el personal adecuado con las competencias y destrezas para el desarrollo de sus actividades",
            "La Dirección no hace el respectivo análisis"},
            //
            {"Vocero, Diseminador, Clarificador",
            "Emprendedor, Manejador   de Crisis, Repartidor de Recursos",
            "Representante, Líder, Enlace",
            "Interpersonales, Informativos, Decisorios"},
        //
            {"El presidente de la junta directiva de la organización",
            "El administrador ",
            "Los accionistas de la empresa",
            "El director de planeación"},
            //
            {"Estudio de mercados",
            "Encuestas y entrevistas",
            "Análisis del entorno",
            "Análisis interno"},
            //
            {"Los equipos   empezarán a vender más porque controlan sus actividades",
            "Los equipos tendrán mayor estabilidad en su trabajo porque están más satisfechos con lo que hacen",
            "Los equipos producirán más y se sentirán más satisfechos",
            "Los equipos se sentirán más satisfechos porque entienden el significado de sus trabajos y tienen control sobre lo que hacen",},
            //
            {"Crear un plan de capacitación",
            "Hacer un mejor reclutamiento y selección",
            "Diseñar bien los cargos que necesita",
            "Especializar el cargo de vendedora"},
            //
            {"Le permite adaptarse a las necesidades locales",
            "Le permite aplicar a los procesos de manufactura con un equipo determinado",
            "Le permite realizar más actividades con menores recursos",
            "Le permite tener grupos de trabajo más cohesionados"},
            //
            {"Estableciendo un objetivo a realizar",
            "Estableciendo una estrategia para solucionar su problema",
            "Tomando una decisión",
            "Implantando una decisión"},
            //
            {"Identificar las oportunidades que tien",
            "Generar y evaluar las alternativas que tiene",
            "Identificar las oportunidades que tiene",
            "Seleccionar unas estrategias e implantarlas"},
            //
            {"Considera que los empleados para trabajar necesitan del grupo para poder sentir confianza en el trabajo y producir",
            "Considera que los empleados evitan en lo posible hacer tareas o asumir responsabilidades",
            "Considera que el empleado requiere un supervisor permanente para realizar sus tareas adecuadamente",
            "Considera que los empleados requieren de relaciones sociales solidas como factor fundamental de productividad"},
            //
            {"Equipo tomador de decisiones y enfoque en el cliente",
            "Junta directiva y enfoque en proyectos de software",
            "Equipo de alto rendimiento y enfoque en procesos",
            "Equipo tomador de decisiones y enfoque en procesos "},
            //
            {"Un modelo administrativo enfocado en el trabajo en equipo, la responsabilidad y autocontrol de los trabajadores en todos los niveles jerárquicos.",
            "Un modelo administrativo enfocado en mejorar las relaciones sociales de los trabajadores como factor fundamental de su productividad",
            "Un modelo administrativo enfocado en el fortalecimiento de la estructura de la organización que de mayor flexibilidad a las tareas que se realizan",
            "Un modelo administrativo enfocado en la productividad individual de los trabajadores"},
            //
            {"Crear un plan de capacitación",
                    "Hacer un mejor reclutamiento y selección",
                    "Diseñar bien los cargos que necesita.",
                    "Especializar el cargo de vendedora."},
            //
            {"Los equipos   empezarán a vender más porque controlan sus actividades.",
                    "Los equipos tendrán mayor estabilidad en su trabajo porque están más satisfechos con lo que hacen.",
                    "Los equipos producirán más y se sentirán más satisfechos.",
                    "Los equipos se sentirán más satisfechos porque entienden el significado de sus trabajos y tienen control sobre lo que hacen."},
            //
            {"Estudio de mercados",
                    "Encuestas y entrevistas",
                    "Análisis del entorno",
                    "Análisis interno"},
            //
            {"El presidente de la junta directiva de la organización",
                    "El administrador",
                    "Los accionistas de la empresa",
                    "El director de planeación"}
    };

    private  String[] respuestas = {
            "Identifica y diseña las actividades que son necesarias para obtener los objetivos o metas de una organización",
            "Competencia creciente en un mercado globalizado.",
            "La motivación y la competencia",
            "La Dirección no tiene una buena comunicación para trasmitir a los integrantes del equipo los objetivos de la planeación.",
            "Interpersonales, Informativos, Decisorios",
            "El administrador",
            "Análisis del entorno",
            "Los equipos se sentirán más satisfechos porque entienden el significado de sus trabajos y tienen control sobre lo que hacen",
            "Diseñar bien los cargos que necesita",
            "Le permite aplicar a los procesos de manufactura con un equipo determinado",
            "Tomando una decisión",
            "Identificar las oportunidades que tiene",
            "Considera que los empleados evitan en lo posible hacer tareas o asumir responsabilidades",
            "Equipo tomador de decisiones y enfoque en el cliente",
            "Un modelo administrativo enfocado en el trabajo en equipo, la responsabilidad y autocontrol de los trabajadores en todos los niveles jerárquicos",
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
    private Handler waiter = new Handler();
    private long start, end;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_trivia);

        enunciadoPregunta = (TextView) findViewById(R.id.enunPreg);
        enunciadoPregunta.setMovementMethod(new ScrollingMovementMethod());
        respues1 = (Button) findViewById(R.id.opcionRes1);
        respues1.setBackground(getResources().getDrawable(R.drawable.circulo_boton_claro));
        respues2 = (Button) findViewById(R.id.opcionRes2);
        respues2.setBackground(getResources().getDrawable(R.drawable.circulo_boton_claro));
        respues3 = (Button) findViewById(R.id.opcionRes3);
        respues3.setBackground(getResources().getDrawable(R.drawable.circulo_boton_claro));
        respues4 = (Button) findViewById(R.id.opcionRes4);
        respues4.setBackground(getResources().getDrawable(R.drawable.circulo_boton_claro));

        Utiles.startCon = System.currentTimeMillis();
        start = System.currentTimeMillis();

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

    public void nextScreen (final View vista){
        vista.setBackground(getResources().getDrawable(R.drawable.circulo_boton_oscuro));
        waiter.postDelayed(new Runnable() {
            @Override
            public void run() {
                //elHaceNada(vista);
            }
        }, 5000);
        TextView opcionPulsada = (TextView) vista;
        if (opcionPulsada.getText().toString() == respuestas[randy]) {
            puntaje++;
        }
        else if(opcionPulsada.getText().toString() != respuestas[randy]){
        }
        vista.setBackground(getResources().getDrawable(R.drawable.circulo_boton_claro));
        screens++;
        if(screens == 3){
            respues1.setEnabled(false);
            respues1.setText("");
            respues1.setBackground(getResources().getDrawable(R.drawable.circulo_boton_oscuro));
            respues2.setEnabled(false);
            respues2.setText("");
            respues2.setBackground(getResources().getDrawable(R.drawable.circulo_boton_oscuro));
            respues3.setEnabled(false);
            respues3.setText("");
            respues3.setBackground(getResources().getDrawable(R.drawable.circulo_boton_oscuro));
            respues4.setEnabled(false);
            respues4.setText("");
            respues4.setBackground(getResources().getDrawable(R.drawable.circulo_boton_oscuro));
            if(puntaje >= 2 && Login.user.getLevel().equals("1")){
                if(puntaje == 3) {
                    guardarRes(1, "2", 1);
                    enunciadoPregunta.setText("Tuvite bien "+puntaje+" pregunta(s)."+
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" + "Obtuviste 1 moneda"+
                            "\n" +
                            "\n" + "Obtuviste 1 insignia");
                }
                else{
                    guardarRes(1, "2", 0);
                    enunciadoPregunta.setText("Tuvite bien "+puntaje+" pregunta(s)."+
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" + "Obtuviste 1 moneda"+
                            "\n" +
                            "\n" + "No obtuviste insignias");
                }
            }
            else if(puntaje >= 2 && Login.user.getLevel().equals("2")){
                if(puntaje == 3) {
                    guardarRes(2, "3", 1);
                    enunciadoPregunta.setText("Tuvite bien "+puntaje+" pregunta(s)."+
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" + "Obtuviste 2 moneda"+
                            "\n" +
                            "\n" + "Obtuviste 1 insignia");
                }
                else{
                    guardarRes(2, "3", 0);
                    enunciadoPregunta.setText("Tuvite bien "+puntaje+" pregunta(s)."+
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" + "Obtuviste 2 moneda"+
                            "\n" +
                            "\n" + "No obtuviste insignias");
                }
            }
            else if(puntaje < 2 && Login.user.getLevel().equals("1")){
                guardarRes(0, "2", 0);
                enunciadoPregunta.setText("Tuvite bien "+puntaje+" pregunta(s)."+
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" + "No obtuviste monedas"+
                        "\n" +
                        "\n" + "No obtuviste insignias");
            }
            else if(puntaje < 2 && Login.user.getLevel().equals("2")){
                guardarRes(0, "3", 0);
                enunciadoPregunta.setText("Tuvite bien "+puntaje+" pregunta(s)."+
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" + "No obtuviste monedas"+
                        "\n" +
                        "\n" + "No obtuviste insignias");
            }
            else if(Login.user.getLevel().equals("FIN")){
                guardarRes(0, "FIN", 0);
                enunciadoPregunta.setText("Tuvite bien "+puntaje+" pregunta(s)."+
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" + "No obtuviste monedas"+
                        "\n" +
                        "\n" + "No obtuviste insignias");
            }
            waiter.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(getApplicationContext(), Mapa.class);
                    i.putExtra("back", "no");
                    Utiles.terminarConexion();
                    startActivity(i);
                }
            }, 3000);
            enunciadoPregunta.setGravity(View.TEXT_ALIGNMENT_CENTER);
        }
        else {
            pantallaRandom();
        }
    }

    public void guardarRes(int res, String level, int insignia){
        end = System.currentTimeMillis();
        long totaltime = (end-start)/1000;
        int puntajes = Integer.parseInt(Login.user.getCoins());
        puntajes += res;
        int insignias = Integer.parseInt(Login.user.getBadges());
        insignias += insignia;
        Login.user.setLevel(level);
        Login.user.setCoins(String.valueOf(puntajes));
        Login.user.setBadges(String.valueOf(insignias));
        TiempoConexionJuego atr = new TiempoConexionJuego(
                Utiles.getFecha(),
                Login.user.getCode(),
                Login.user.getGroup(),
                "Trivia",
                String.valueOf(puntajes),
                String.valueOf(totaltime),
                level,
                String.valueOf(insignias));
        atr.execute();
    }
}
