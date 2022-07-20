package sg.edu.rp.c346.id21028514.demodatabasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    RadioButton star1,star2,star3,star4,star5;
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
        Intent i = getIntent();
        data = (Note) i.getSerializableExtra("data");


        al = new ArrayList<Note>();
        aa = new ArrayAdapter<Note>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data  = etContent.getText().toString();
                String data1 = etContent2.getText().toString();
                String data2 = etContent3.getText().toString();
                int star = rgContent.getCheckedRadioButtonId();
                String data3 = "empty";

                if(star == R.id.radioButton1) {
                    data3 = "radioButton1";
                } else if(star == R.id.radioButton2) {
                    data3 = "radioButton2";
                } else if(star == R.id.radioButton3) {
                    data3 = "radioButton3";
                } else if(star == R.id.radioButton4) {
                    data3 = "radioButton4";
                } else if(star == R.id.radioButton5) {
                    data3 = "radioButton5";
                } else {
                    Toast.makeText(MainActivity.this, "Wrong star",
                            Toast.LENGTH_SHORT).show();
                }
                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertNote(data,data1,data2,data3);

                if (inserted_id != -1){
                    al.clear();
                    al.addAll(dbh.getAllNotes());
                    aa.notifyDataSetChanged();
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

//        lv = findViewById(R.id.lv);
//        aa = new ArrayAdapter<Note>(this,
//                android.R.layout.simple_list_item_1, al);
//        lv.setAdapter(aa);
//
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int
//                    position, long identity) {
//                Note data = al.get(position);
//                Intent i = new Intent(MainActivity.this,
//                        EditActivity.class);
//                i.putExtra("data", data);
//                startActivity(i);
//            }
//        });

    }

}
