package co.edu.poli.gamification.poliplay;

import android.content.Intent;
import android.sax.StartElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class SeleccionarTransporte extends AppCompatActivity {

    private RadioButton trans1, trans2, trans3, trans4, trans5, trans6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_transporte);
        trans1 = (RadioButton)findViewById(R.id.trans1);
        trans2 = (RadioButton)findViewById(R.id.trans2);
        trans3 = (RadioButton)findViewById(R.id.trans3);
        trans4 = (RadioButton)findViewById(R.id.trans4);
        trans5 = (RadioButton)findViewById(R.id.trans5);
        trans6 = (RadioButton)findViewById(R.id.trans6);

        trans1.setText(getResources().getString(R.string.transInst));
        trans2.setText(getResources().getString(R.string.transCar));
        trans3.setText(getResources().getString(R.string.transMot));
        trans4.setText(getResources().getString(R.string.transTab));
        trans5.setText(getResources().getString(R.string.transCam));
        trans6.setText(getResources().getString(R.string.transBic));

        trans1.setChecked(true);
    }

    public void selTrans(View view){
        Intent i = new Intent(this, Mapa.class);
        if(trans1.isChecked()) Login.user.setTransport(trans1.getText().toString());
        else if(trans2.isChecked()) Login.user.setTransport(trans2.getText().toString());
        else if(trans3.isChecked()) Login.user.setTransport(trans3.getText().toString());
        else if(trans4.isChecked()) Login.user.setTransport(trans4.getText().toString());
        else if(trans5.isChecked()) Login.user.setTransport(trans5.getText().toString());
        else if(trans6.isChecked()) Login.user.setTransport(trans6.getText().toString());
        startActivity(i);
    }
}
