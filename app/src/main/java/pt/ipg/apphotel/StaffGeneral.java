package pt.ipg.apphotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StaffGeneral extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_general);
        button = (Button) findViewById(R.id.buttonAddStaff);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStaff();
            }
        });
        button = (Button) findViewById(R.id.buttonEdit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEdit();
            }
        });
      /*  button = (Button) findViewById(R.id.buttonDeleteStaff);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDelete();
            }
        });*/

      //ainda não existe uma ligacao á base de dados para eliminar nada portanto o programa pediria sempre introdução de dados em validação


    }
    public void openStaff(){
        Intent intent = new Intent(this,Staff.class);
        startActivity(intent);
    }
    public void openEdit(){
        Intent intent = new Intent(this, EditStaff.class);
        startActivity(intent);
    }
}
