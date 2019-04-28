package pt.ipg.apphotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Layout extends AppCompatActivity {
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        button = (Button) findViewById(R.id.buttonAddLayout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddLayout();
            }
        });
        button = (Button) findViewById(R.id.buttonLayout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLayoutInf();
            }
        });
    }
    public void openAddLayout(){
        Intent intent = new Intent(this, NewLayout.class);
        startActivity(intent);

    }
    public void openLayoutInf(){
        Intent intent = new Intent(this, LayoutInfo.class);
        startActivity(intent);
    }
}
