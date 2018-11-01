package co.edu.poli.gamification.poliplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText email;
    private EditText contrasena;
    public static Usuario user = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText)findViewById(R.id.email);
        contrasena = (EditText)findViewById(R.id.contrasena);
    }

    public void entrar(View view){
        user.setName("Alejandro");
        user.setLastName("Arévalo");
        user.setEmail("aaa");
        user.setPassword("a123");
        String varEmail = email.getText().toString();
        String varContrasena = contrasena.getText().toString();
        if(varEmail.equals(user.getEmail()) && varContrasena.equals(user.getPassword())){
            Intent i = new Intent(this, SeleccionarCurso.class);
            startActivity(i);
        }
        else if(varEmail.equals("test")){
            Intent i = new Intent(this, Mapa.class);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "Datos incorrectos, intente nuevamente", Toast.LENGTH_SHORT).show();
        }
    }
}
