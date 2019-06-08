package pt.ipg.apphotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Eventos<button> extends AppCompatActivity {

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        button =(Button) findViewById(R.id.buttonAdd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddEventos();
            }
        });
        button = (Button) findViewById(R.id.buttonEditEV);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditEv();
            }
        });
        button = (Button)findViewById(R.id.buttonDeleteEv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDeleteEv();
            }
        });
    }
    public void openAddEventos(){
        Intent intent = new Intent(this, AddEventos.class);
        startActivity(intent);
    }
    public void openEditEv(){
        Intent intent = new Intent(this,EditEvento.class);
        startActivity(intent);
    }
    public void openDeleteEv(){
        Intent intent = new Intent(this, DeleteEvento.class);
        startActivity(intent);
    }
}
