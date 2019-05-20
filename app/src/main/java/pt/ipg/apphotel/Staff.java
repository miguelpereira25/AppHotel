package pt.ipg.apphotel;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Staff extends AppCompatActivity  {




    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        button = (Button) findViewById(R.id.buttonCancel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(Staff.this, getString(R.string.CancelOPP), Toast.LENGTH_LONG).show();
            }
        });
        button = (Button) findViewById(R.id.buttonSaveEdit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText TextInputName = findViewById(R.id.TextInputName);
                String nomeStaff = TextInputName.getText().toString();
                if (nomeStaff.isEmpty()) {
                    TextInputName.setError(getString(R.string.Error_Message));
                    TextInputName.requestFocus();
                    return;
                }
                EditText TextInputContact = findViewById(R.id.TextInputContact);
                String contactStaff = TextInputContact.getText().toString();
                if (contactStaff.isEmpty()) {
                    TextInputContact.setError(getString(R.string.Error_Message));
                    TextInputContact.requestFocus();
                    return;
                }
                EditText TextInputNib = findViewById(R.id.TextInputNib);
                String nibStaff = TextInputNib.getText().toString();
                if (nibStaff.isEmpty()) {
                    TextInputNib.setError(getString(R.string.Error_Message));
                    TextInputNib.requestFocus();
                    return;
                }
                EditText TextInputSocialN = findViewById(R.id.TextInputSocialN);
                String socialNumber = TextInputSocialN.getText().toString();
                if (socialNumber.isEmpty()) {
                    TextInputSocialN.setError(getString(R.string.Error_Message));
                    TextInputSocialN.requestFocus();
                    return;
                }
                finish();
                Toast.makeText(Staff.this, getString(R.string.ToastSave), Toast.LENGTH_LONG).show();
            }
        });
    }
}
