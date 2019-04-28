package pt.ipg.apphotel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LayoutInfo extends AppCompatActivity {
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_info);
        button = (Button) findViewById(R.id.buttonCancel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(LayoutInfo.this,getString(R.string.CancelOPP), Toast.LENGTH_LONG).show();
            }
        });
        button = (Button) findViewById(R.id.buttonSaveEdit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText EditTextName = findViewById(R.id.EditTextName);
                String NomePersona = EditTextName.getText().toString();
                if(NomePersona.isEmpty()){
                    EditTextName.setError(getString(R.string.Error_Message));
                    EditTextName.requestFocus();
                    return;
                }
                EditText EditTextDate = findViewById(R.id.EditTextDate);
                String DateEvent = EditTextDate.getText().toString();
                if(DateEvent.isEmpty()){
                    EditTextDate.setError(getString(R.string.Error_Message));
                    EditTextDate.requestFocus();
                    return;
                }
                EditText EditTextVegan = findViewById(R.id.EditTextVegan);
                String QuantidadeVegan = EditTextVegan.getText().toString();
                if(QuantidadeVegan.isEmpty()){
                    EditTextVegan.setError(getString(R.string.Error_Message));
                    EditTextVegan.requestFocus();
                    return;
                }
                EditText EditTextVegetarians = findViewById(R.id.EditTextVegetarians);
                String QuantideVegetarianos = EditTextVegetarians.getText().toString();
                if(QuantideVegetarianos.isEmpty()){
                    EditTextVegetarians.setError(getString(R.string.Error_Message));
                    EditTextVegetarians.requestFocus();
                    return;
                }
                EditText EditTextAlergies = findViewById(R.id.EditTextAlergies);
                String Alergicos = EditTextAlergies.getText().toString();
                if(Alergicos.isEmpty()){
                    EditTextAlergies.setError(getString(R.string.Error_Message));
                    EditTextAlergies.requestFocus();
                    return;
                }
                finish();
                Toast.makeText(LayoutInfo.this, getString(R.string.ToastSave),Toast.LENGTH_LONG).show();
            }
        });
    }
}
