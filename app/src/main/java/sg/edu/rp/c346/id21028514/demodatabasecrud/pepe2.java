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

import java.util.ArrayList;

public class pepe2 extends AppCompatActivity {
    Button btnAdd, btnRetrieve;
    TextView tvDBContent;
    EditText etContent;
    EditText etContent2;
    EditText etContent3;
    ListView lv;
    ArrayList<Note> al;
    ArrayAdapter<Note> aa;
    Note data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pepe2);

        Intent i = getIntent();
        data = (Note) i.getSerializableExtra("data");

        btnAdd = findViewById(R.id.btnAdd);
        btnRetrieve = findViewById(R.id.btnRetrieve);
        etContent = findViewById(R.id.etContent);
        etContent2 = findViewById(R.id.etContent2);
        etContent3 = findViewById(R.id.etContent3);

        lv = findViewById(R.id.lv);
        al = new ArrayList<Note>();
        aa = new ArrayAdapter<Note>(this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);


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
    protected void onResume() {
    super.onResume();
        DBHelper dbh = new DBHelper(pepe2.this);
        al.clear();
        al.addAll(dbh.getAllNotes());
        aa.notifyDataSetChanged();
    }
    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}