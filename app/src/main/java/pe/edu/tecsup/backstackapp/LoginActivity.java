package pe.edu.tecsup.backstackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameInput;
    private EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);
    }

    public static Map<String, String> ALL_USERS = new HashMap<>();
    static{
        ALL_USERS.put("sabrina", "tecsup");
        ALL_USERS.put("renzo", "tecsup");
        ALL_USERS.put("antony", "tecsup");
    }

    public void callLogin(View view) {

        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(username.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Ingrese todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // validar ese username y password
        String passwd = ALL_USERS.get(username);
        if(passwd == null){
            Toast.makeText(this, "Usuario no existe", Toast.LENGTH_SHORT).show();
            return;
        } else {
            if(!passwd.equals(password)){
                Toast.makeText(this, "Clave incorrecta", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("username", username);  // Envío del parámetro username
        startActivity(intent);
        finish();

    }

}
