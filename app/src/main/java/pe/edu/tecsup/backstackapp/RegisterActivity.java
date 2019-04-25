package pe.edu.tecsup.backstackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText firstnameInput;
    private EditText lastnameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle(R.string.register_title);

        firstnameInput = findViewById(R.id.firstname_input);
        lastnameInput = findViewById(R.id.lastname_input);
    }

    public void callDoRegister(View view){

        String firstname = firstnameInput.getText().toString();
        String lastname = lastnameInput.getText().toString();

        if(firstname.isEmpty() || lastname.isEmpty()){
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent();
        intent.putExtra("fullname", firstname + " " + lastname);

        setResult(RESULT_OK, intent);
        finish();

    }

}
