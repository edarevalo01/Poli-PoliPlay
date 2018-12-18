package co.edu.poli.gamification.poliplay.Juegos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import co.edu.poli.gamification.poliplay.R;

public class JuegoCalculadora extends AppCompatActivity {

    private TextView enunciadoCalculadora;
    private EditText ingresoNumCalculadora;
    private TextView subtextCal;
    private Button opc1cal, opc2cal, opc3cal;
    int estadoCalculadora = 0;
    int transporteIngresador = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_calculadora);
        enunciadoCalculadora = (TextView) findViewById(R.id.enunciado_calculadora);
        enunciadoCalculadora.setText("CONSUMO DE ENERGÍA");
        subtextCal = (TextView) findViewById(R.id.subtext_calc);
        subtextCal.setText("Escoja una de las siguientes opciones:");
        ingresoNumCalculadora = (EditText) findViewById(R.id.ingreso_num_cal);
        ingresoNumCalculadora.setEnabled(false);
        opc1cal = (Button) findViewById(R.id.cal_opcion_1);
        opc1cal.setText(R.string.opcion_1_calculadora);
        opc2cal = (Button) findViewById(R.id.cal_opcion_2);
        opc2cal.setText(R.string.opcion_2_calculadora);
        opc3cal = (Button) findViewById(R.id.cal_opcion_3);
        opc3cal.setText("");
    }
    public  void opcion1cal (View view){
        switch (estadoCalculadora) {
            case 0:
                enunciadoCalculadora.setText("MI CONSUMO DE ENERGÍA ELÉCTRICA");
                ingresoNumCalculadora.setEnabled(true);
                opc1cal.setText("Ingresar");
                opc2cal.setText("");
                opc3cal.setText("");
                estadoCalculadora++;
                break;
            case 1:
                enunciadoCalculadora.setText("MI DIETA");
                ingresoNumCalculadora.setEnabled(false);
                ingresoNumCalculadora.setText("");
                subtextCal.setText("Escoja la opción que más se acomode a sus hábitos alimenticios.");
                opc1cal.setText("Vegetariano");
                opc2cal.setText("Baja en carne");
                opc3cal.setText("Alta en carne");
                break;
            case 2:
                enunciadoCalculadora.setText("TRANSPORTE");
                subtextCal.setText("Seleccione la opción más conveniente según la información  que posea.");
                opc1cal.setText("Conozco la distancia diaria que recorro");
                opc2cal.setText("Conozco cuantas horas diarias manejo");
                opc3cal.setText("No tengo vehículo");
                estadoCalculadora++;
                break;
            case 3:
                enunciadoCalculadora.setText("MI VEHÍCULO");
                subtextCal.setText("Conozco la distancia diaria que recojo");
                ingresoNumCalculadora.setEnabled(true);
                opc1cal.setText("Gasolina");
                opc2cal.setText("Diesel");
                opc3cal.setText("Gas");
                estadoCalculadora++;
                break;
            case 4:
                enunciadoCalculadora.setText("TRANSPORTE PÚBLICO");
                subtextCal.setText("Horas Semanales:");
                opc1cal.setText("");
                opc2cal.setText("");
                opc3cal.setText("Ingresar");
                ingresoNumCalculadora.setEnabled(true);
                estadoCalculadora++;
                break;
        }
    }
    public  void opcion2cal (View view){
        switch (estadoCalculadora) {
            case 0:
                enunciadoCalculadora.setText("MI DIETA");
                subtextCal.setText("Escoja la opción que más se acomode a sus hábitos alimenticios.");
                opc1cal.setText("Vegetariano");
                opc2cal.setText("Baja en carne");
                opc3cal.setText("Alta en carne");
                estadoCalculadora++;
                break;
            case 1:
                enunciadoCalculadora.setText("TRANSPORTE");
                subtextCal.setText("Seleccione la opción más conveniente según la información  que posea.");
                opc1cal.setText("Conozco la distancia diaria que recorro");
                opc2cal.setText("Conozco cuantas horas diarias manejo");
                opc3cal.setText("No tengo vehículo");
                estadoCalculadora++;
                break;
            case 2:
                enunciadoCalculadora.setText("MI VEHÍCULO");
                subtextCal.setText("Conozco cuantas horas diarias manejo");
                ingresoNumCalculadora.setEnabled(true);
                opc1cal.setText("Gasolina");
                opc2cal.setText("Diesel");
                opc3cal.setText("Gas");
                estadoCalculadora++;
                break;
            case 4:
                enunciadoCalculadora.setText("TRANSPORTE PÚBLICO");
                subtextCal.setText("Horas Semanales:");
                opc1cal.setText("");
                opc2cal.setText("");
                opc3cal.setText("Ingresar");
                ingresoNumCalculadora.setEnabled(true);
                ingresoNumCalculadora.setText("");
                estadoCalculadora++;
                break;

        }
    }
    public  void opcion3cal (View view){
        switch (estadoCalculadora) {
            case 0:
                break;
            case 1:
                enunciadoCalculadora.setText("TRANSPORTE");
                subtextCal.setText("Seleccione la opción más conveniente según la información  que posea.");
                opc1cal.setText("Conozco la distancia diaria que recorro");
                opc2cal.setText("Conozco cuantas horas diarias manejo");
                opc3cal.setText("No tengo vehículo");
                estadoCalculadora++;
                break;
            case 2:
                enunciadoCalculadora.setText("TRANSPORTE PÚBLICO");
                subtextCal.setText("Horas Semanales:");
                opc1cal.setText("");
                opc2cal.setText("");
                opc3cal.setText("Ingresar");
                ingresoNumCalculadora.setEnabled(true);
                estadoCalculadora++;
                break;
            case 4:
                enunciadoCalculadora.setText("TRANSPORTE PÚBLICO");
                subtextCal.setText("Horas Semanales:");
                opc1cal.setText("");
                opc2cal.setText("");
                opc3cal.setText("Ingresar");
                ingresoNumCalculadora.setEnabled(true);

                estadoCalculadora++;
                break;
        }
    }

}
