package pt.ipg.apphotel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddEventos extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_eventos);

        button = (Button) findViewById(R.id.buttonCancel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
               Toast.makeText(AddEventos.this,"Operação Cancelada",Toast.LENGTH_LONG).show();
            }
        }) ;
    }
    public void SaveEvent (View view){
        EditText editTextName = findViewById(R.id.editTextName);
        String nomeEvent = editTextName.getText().toString();

        if (nomeEvent.trim().length()==0){
            editTextName.setError(getString(R.string.Error_Message));
            editTextName.requestFocus();
            return;

        }
        EditText editTextDate = findViewById(R.id.editTextDate);
        String dateEvent = editTextDate.getText().toString();

        if (dateEvent.trim().length()==8){
            editTextDate.setError(getString(R.string.Error_Message));
            editTextDate.requestFocus();
            return;
        }
        EditText editTextQuantidade = findViewById(R.id.editTextQuantidade);
        String quantity = editTextQuantidade.getText().toString();
        if (quantity.trim().length()==0){
            editTextQuantidade.setError(getString(R.string.Error_Message));
            editTextQuantidade.requestFocus();
            return;
        }
        EditText editTextResp = findViewById(R.id.editTextResp);
        String Responsavel = editTextResp.getText().toString();
        if (Responsavel.trim().length()==0){
            editTextResp.setError(getString(R.string.Error_Message));
            editTextResp.requestFocus();
            return;
        }
        EditText editTextContacto = findViewById(R.id.editTextContacto);
        String Contacto = editTextContacto.getText().toString();
        if (Contacto.trim().length()==9){
            editTextContacto.setError(getString(R.string.Error_Message));
            editTextContacto.requestFocus();
            return;
        }
        EditText editTextObs = findViewById(R.id.editTextObs);
        String Observations = editTextObs.getText().toString();

        button = (Button) findViewById(R.id.buttonSave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();Toast.makeText(AddEventos.this,"Dados Guardados",Toast.LENGTH_LONG).show();

            }
            });
    }
}
