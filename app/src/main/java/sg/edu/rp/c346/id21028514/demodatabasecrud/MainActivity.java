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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnRetrieve;
    TextView tvDBContent;
    EditText etContent;
    EditText etContent2;
    ArrayList<Note> al;
    ListView lv;
    ArrayAdapter<Note> aa;

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


        al = new ArrayList<Note>();
        aa = new ArrayAdapter<Note>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = etContent.getText().toString() + etContent2.getText().toString();
                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertNote(data);

                if (inserted_id != -1){
                    al.clear();
                    al.addAll(dbh.getAllNotes());
                    aa.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, pepe2.class);
                startActivity(intent);

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
