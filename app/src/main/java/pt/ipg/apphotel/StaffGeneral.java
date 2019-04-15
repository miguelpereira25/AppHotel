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


    }
    public void openStaff(){
        Intent intent = new Intent(this,Staff.class);
        startActivity(intent);
    }
}
