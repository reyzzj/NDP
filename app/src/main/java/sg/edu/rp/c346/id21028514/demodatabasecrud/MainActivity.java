package sg.edu.rp.c346.id21028514.demodatabasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnRetrieve;
    EditText etContent;
    EditText etContent2;
    EditText etContent3;
    ArrayList<Note> al;
    RadioGroup rgContent;
    RadioButton rb,star1,star2,star3,star4,star5;
    ListView lv;
    ArrayAdapter<Note> aa;
    Note data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initialize the variables with UI here
        btnAdd = findViewById(R.id.btnAdd);
        btnRetrieve = findViewById(R.id.btnRetrieve);
        lv = findViewById(R.id.lv);
        etContent = findViewById(R.id.etContent);
        etContent2 = findViewById(R.id.etContent2);
        etContent3 = findViewById(R.id.etContent3);
        rgContent = findViewById(R.id.groupradio);
        star1 = findViewById(R.id.radioButton1);
        star2 = findViewById(R.id.radioButton2);
        star3 = findViewById(R.id.radioButton3);
        star4 = findViewById(R.id.radioButton4);
        star5 = findViewById(R.id.radioButton5);
        Intent i = getIntent();
        data = (Note) i.getSerializableExtra("data");


        al = new ArrayList<Note>();
        aa = new ArrayAdapter<Note>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);
//        public void onClick(View star1) {
//            //Set the button's appearance
//            if (star1.isSelected()) {
//                //Handle selected state change
//                android:(R.id.radioButton1)="@drawable/star_uncfm"
//            }
//            else {
//                //Handle de-select state change
//            }
//
//        }
//
//    });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data  = etContent.getText().toString();
                String data1 = etContent2.getText().toString();
                String data2 = etContent3.getText().toString();
                int data3 = rgContent.getCheckedRadioButtonId();
                rb = findViewById(data3);
                int rating = Integer.parseInt(rb.getText().toString());
                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertNote(data,data1,data2,rating);
                if (inserted_id != -1){
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Insert failed",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, pepe2.class);
                startActivity(i);

            }
        });
    }
}
