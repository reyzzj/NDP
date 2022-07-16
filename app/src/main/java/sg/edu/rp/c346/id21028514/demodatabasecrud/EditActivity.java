package sg.edu.rp.c346.id21028514.demodatabasecrud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {

    TextView tvID;
    EditText etContent, etContent2, etContent3;
    Button btnUpdate, btnDelete;
    Note data;
    Note data1;
    Note data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        //initialize the variables with UI here

        tvID = findViewById(R.id.tvID);
        etContent = findViewById(R.id.etContent);
        etContent2 = findViewById(R.id.etContent2);
        etContent3 = findViewById(R.id.etContent3);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        Intent i = getIntent();
        data = (Note) i.getSerializableExtra("data");
        data1 = (Note) i.getSerializableExtra("data1");

        tvID.setText("ID: " + data.getId());
        etContent.setText(data.getNoteContent());
        etContent2.setText(data1.getNoteContent());
        etContent3.setText(data2.getNoteContent());
//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DBHelper dbh = new DBHelper(EditActivity.this);
//                data.setNoteContent(etContent.getText().toString());
//                data1.setNoteContent(etContent2.getText().toString());
//                dbh.updateNote(data,data1);
//                dbh.close();
//                finish();
//            }
//        });
//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DBHelper dbh = new DBHelper(EditActivity.this);
//                dbh.deleteNote(data.getId());
//                finish();
//
//            }
//        });
    }
}
