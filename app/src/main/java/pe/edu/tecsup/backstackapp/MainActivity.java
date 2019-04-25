package pe.edu.tecsup.backstackapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView usernametext;
    private ListView contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernametext = findViewById(R.id.username_text);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            String username = bundle.getString("username");
            if(username != null) {
                // Imprimir el username...
                usernametext.setText(username);
            }

        }

        // Lista de contactos
        contactList = findViewById(R.id.contact_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        adapter.add("Juan Perez");
        adapter.add("Mauricio Galvez");
        adapter.add("Rene Torres");
        contactList.setAdapter(adapter);
    }

    public void callRegister(View view) {

        Intent intent = new Intent(this, RegisterActivity.class);
        startActivityForResult(intent, 100);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("MainActivity","requestCode:" + requestCode + " - resultCode:" + resultCode + " - data:" + data);

        if(requestCode == 100){
            if(resultCode == RESULT_OK){
                Bundle bundle = data.getExtras();
                if(bundle != null){

                    String fullname = bundle.getString("fullname");
                    Log.d("MainActivity", "Contacto " + fullname);

                    // Añadir un elemento al listview
                    ArrayAdapter<String> adapter = (ArrayAdapter<String>)contactList.getAdapter();
                    adapter.add(fullname);
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }
}
