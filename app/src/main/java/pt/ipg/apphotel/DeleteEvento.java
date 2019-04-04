package pt.ipg.apphotel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DeleteEvento extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        button = (Button) findViewById(R.id.buttonDelete);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(DeleteEvento.this,"Deleted with success...",Toast.LENGTH_LONG).show();
            }
        });
        button = (Button) findViewById(R.id.buttonCancelDel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(DeleteEvento.this,"Canceled with success",Toast.LENGTH_LONG).show();
            }
        });

    }
}
