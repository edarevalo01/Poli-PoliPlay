package co.edu.poli.gamification.poliplay.Juegos;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import co.edu.poli.gamification.poliplay.Secuencia.Mapa;
import co.edu.poli.gamification.poliplay.R;

public class JuegoAhorcado extends AppCompatActivity {

    int index = 0;
    int intentos = 7;
    boolean cambio = false;
    private TextView intentosRes;
    private TextView hideWord;
    private TextView showWord;
    private TextView intentosRestantes;
    private TextView showEnum;
    private Random randomWords = new Random();
    private Random randomLetters = new Random();
    private String[] palabras = {"RETROALIMENTACION", "EMPODERAMIENTO", "LINEA", "DELEGACION", "ORGANICA"};
    private String[] enunciadosPalabras = {"La cantidad de información que recibe un trabajador sobre su desempeño",
            "Sensación de motivación intrínseca en la que los trabajadores perciben que su trabajo tiene impacto y significado y ellos se sienten capaces y competentes para actuar con autodeterminación. ",
            "Autoridad de _____ El derecho de mando sobre las personas inmediatamente subordinadas en la cadena de comando",
            "La asignación de autoridad directa y responsabilidad a un subordinado para completar tareas por las que el jefe es responsable normalmente.",
            "Sensación de motivación intrínseca en la que los trabajadores perciben que su trabajo tiene impacto y significado y ellos se sienten capaces y competentes para actuar con autodeterminación"};
    private TextView[] letters = new TextView[21];
    private ImageView animador;

    private Handler waiter = new Handler();
    private Runnable runner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_ahorcado);
        intentosRes = (TextView) findViewById(R.id.intenRes);
        intentosRestantes = (TextView) findViewById(R.id.intentosRest);
        hideWord = (TextView) findViewById(R.id.hideWord);
        showEnum = (TextView) findViewById(R.id.showEnun);
        animador = (ImageView) findViewById(R.id.animacion);
        animador.setImageDrawable(getResources().getDrawable(R.drawable.ahorcado0));

        palabraRandom();
        enunciadoRand();

        letters[0] = (TextView) findViewById(R.id.let1);
        letters[1] = (TextView) findViewById(R.id.let2);
        letters[2] = (TextView) findViewById(R.id.let3);
        letters[3] = (TextView) findViewById(R.id.let4);
        letters[4] = (TextView) findViewById(R.id.let5);
        letters[5] = (TextView) findViewById(R.id.let6);
        letters[6] = (TextView) findViewById(R.id.let7);
        letters[7] = (TextView) findViewById(R.id.let8);
        letters[8] = (TextView) findViewById(R.id.let9);
        letters[9] = (TextView) findViewById(R.id.let10);
        letters[10] = (TextView) findViewById(R.id.let11);
        letters[11] = (TextView) findViewById(R.id.let12);
        letters[12] = (TextView) findViewById(R.id.let13);
        letters[13] = (TextView) findViewById(R.id.let14);
        letters[14] = (TextView) findViewById(R.id.let15);
        letters[15] = (TextView) findViewById(R.id.let16);
        letters[16] = (TextView) findViewById(R.id.let17);
        letters[17] = (TextView) findViewById(R.id.let18);
        letters[18] = (TextView) findViewById(R.id.let19);
        letters[19] = (TextView) findViewById(R.id.let20);
        letters[20] = (TextView) findViewById(R.id.let21);

        letrasRandom();


    }

    public void comprobar(View vista) throws Exception {

        TextView t = (TextView) vista;

        String partsWord = palabras[index];
        String unlockWords = hideWord.getText().toString();
        String[] c = unlockWords.split(" +");
        String d = t.getText().toString();
        for (int i = 0; i < partsWord.length(); i++) {
            if (partsWord.charAt(i) == d.charAt(0)) {
                c[i] = d;
                cambio = true;
                t.setTextColor(getResources().getColor(R.color.colorSecondary));
                t.setEnabled(false);
            }
        }

        char[] e = new char[(c.length * 2) - 1];
        int contador = 0;
        for (int i = 0; i < e.length; i++) {
            if (i % 2 == 1) {
                e[i] = ' ';
            } else if (i % 2 == 0) {
                e[i] = c[contador].charAt(0);
                contador++;
            }
        }

        String f = String.valueOf(e).trim();
        hideWord.setText(f);

        if (!cambio) {
            intRestantes();
        }
        cambio = false;

        //Método que no deja jugar más si pierde
        gameOver();


    }

    public void gameOver() throws Exception {

        String termino = hideWord.getText().toString();
        termino.split(" +");
        int contador = 0;
        for (int i = 0; i < termino.length(); i++) {
            if (termino.charAt(i) == '_') {
                contador++;
            }
        }
        if (contador == 0) {
            for (int i = 0; i < letters.length; i++) {
                letters[i].setTextColor(getResources().getColor(R.color.colorSecondary));
                letters[i].setEnabled(false);
            }
            runner = new Runnable() {
                @Override
                public void run() {
                    alMapa();
                }
            };
            waiter.postDelayed(runner, 2500);


        }
        if (intentos == 0) {
            hideWord.setText("PERDISTE!");

        }
    }

    public void cambioImagen() {
        switch (intentos) {
            case 6:
                animador.setImageDrawable(getResources().getDrawable(R.drawable.ahorcado1));
                break;

            case 5:
                animador.setImageDrawable(getResources().getDrawable(R.drawable.ahorcado2));
                break;

            case 4:
                animador.setImageDrawable(getResources().getDrawable(R.drawable.ahorcado3));
                break;

            case 3:
                animador.setImageDrawable(getResources().getDrawable(R.drawable.ahorcado4));
                break;

            case 2:
                animador.setImageDrawable(getResources().getDrawable(R.drawable.ahorcado5));
                break;

            case 1:
                animador.setImageDrawable(getResources().getDrawable(R.drawable.ahorcado6));
                break;

            case 0:
                animador.setImageDrawable(getResources().getDrawable(R.drawable.ahorcado7));
                break;

            default:
                animador.setImageDrawable(getResources().getDrawable(R.drawable.ahorcado0));
        }
    }

    public void intRestantes() {
        intentos--;
        intentosRestantes.setText(String.valueOf(intentos));
        cambioImagen();
        if (intentos == 0) {
            for (int i = 0; i < letters.length; i++) {
                letters[i].setEnabled(false);
            }
        }
    }

    public void palabraRandom() {
        int rand = randomWords.nextInt(palabras.length);
        hideWord.setText(palabras[rand]);
        String hideR = "";
        for (int i = 0; i < hideWord.getText().toString().length(); i++) {
            hideR += "_ ";
        }

        hideWord.setText(hideR.trim());
        index = rand;
    }

    public void enunciadoRand() {
        showEnum.setText(enunciadosPalabras[index]);
    }

    public void letrasRandom() {
        String word = palabras[index];
        char[] an_g = word.toCharArray();
        Set<Character> conjunto = new TreeSet<Character>();
        int j = 0;
        while (conjunto.size() < 21) {
            if (j < word.length()) {
                conjunto.add(an_g[j]);
                j++;
            } else {
                int rand = randomLetters.nextInt(26);
                conjunto.add((char) (rand + 65));
            }
        }
        String ale = "";
        while (conjunto.size() != 0) {
            char aux = ((TreeSet<Character>) conjunto).first();
            ale += String.valueOf(aux);
            conjunto.remove(aux);
        }
        for (int i = 0; i < 21; i++) {
            letters[i].setText(String.valueOf(ale.charAt(i)));
        }
    }

    public void alMapa(){
        Intent i = new Intent(this, Mapa.class);
        startActivity(i);
    }
}
