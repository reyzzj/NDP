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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class pepe2 extends AppCompatActivity {
    Button btnAdd, btnRetrieve,btnShow5;
    TextView tvID;
    EditText etContent;
    EditText etContent2;
    EditText etContent3;
    Spinner spnYear;
    ListView lv;
    ArrayList<Note> al;
    ArrayAdapter<Note> aa;
    Note data;
    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper(pepe2.this);
        al.clear();
        al.addAll(dbh.getAllNotes());
        aa.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pepe2);

        Intent i = getIntent();
        data = (Note) i.getSerializableExtra("data");


        tvID = findViewById(R.id.tvID);
        btnAdd = findViewById(R.id.btnAdd);
        btnRetrieve = findViewById(R.id.btnRetrieve);
        btnShow5 = findViewById(R.id.btnShow5);
        spnYear = findViewById(R.id.spn);
        etContent = findViewById(R.id.etContent);
        etContent2 = findViewById(R.id.etContent2);
        etContent3 = findViewById(R.id.etContent3);

        lv = findViewById(R.id.lv);
        al = new ArrayList<Note>();
        aa = new ArrayAdapter<Note>(this, android.R.layout.simple_list_item_1, al);
        CustomAdapter adapter;

        adapter = new CustomAdapter(this, R.layout.row, al);
        lv.setAdapter(adapter);




        btnShow5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    DBHelper dbh = new DBHelper(pepe2.this);
                    al.clear();
                    al.addAll(dbh.getAll5StarSongs());
                    adapter.notifyDataSetChanged();
                Toast.makeText(pepe2.this, "Displaying all 5 star songs!", Toast.LENGTH_SHORT).show();
            }
        });


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long identity) {
                Note data = al.get(position);
                Intent i = new Intent(pepe2.this, EditActivity.class);
                i.putExtra("data", data);
                startActivity(i);

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}