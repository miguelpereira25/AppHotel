package pt.ipg.apphotel;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button buttonEvents;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        buttonEvents= (Button) findViewById(R.id.buttonEvents);
        buttonEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEventos();
            }

        });


    }
    public void openEventos(){
        Intent intent = new Intent(this, Eventos.class);
        startActivity(intent);
    }
    public void openAddEventos(){
        Intent intent = new Intent(this, AddEventos.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void toastEventos(View view) {
        Toast.makeText(MainActivity.this,"Eventos existentes",Toast.LENGTH_LONG).show();
    }

    public void toastStaff(View view) {
        Toast.makeText(MainActivity.this,"Staff Disponivel",Toast.LENGTH_LONG).show();
    }

    public void Layout(View view) {
        Toast.makeText(MainActivity.this,"Layouts existentes/Criar",Toast.LENGTH_LONG).show();
    }
}
