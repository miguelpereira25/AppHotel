package pt.ipg.apphotel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EditEvento extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_evento);
        button= (Button) findViewById(R.id.buttonSaveEdit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(EditEvento.this,getString(R.string.SavedChanged),Toast.LENGTH_LONG).show();
            }
        });
        button =(Button) findViewById(R.id.buttonCancelEdit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(EditEvento.this,getString(R.string.ActionCanceled),Toast.LENGTH_LONG).show();
            }
        });

    }
}
