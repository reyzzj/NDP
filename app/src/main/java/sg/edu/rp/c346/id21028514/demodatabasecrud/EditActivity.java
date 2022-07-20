package sg.edu.rp.c346.id21028514.demodatabasecrud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {

    TextView tvID;
    EditText etContent, etContent2, etContent3;
    Button btnUpdate, btnDelete, btnCancel;
    RadioGroup rgEditContent;
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
        btnCancel = findViewById(R.id.btnCancel);
        rgEditContent = findViewById(R.id.rgEditContent);

        Intent i = getIntent();
        data = (Note) i.getSerializableExtra("data");
        data1 = (Note) i.getSerializableExtra("data1");
        data2 = (Note) i.getSerializableExtra("data2");

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                data.setNoteContent(etContent.getText().toString());
                data1.setNoteContent2(etContent2.getText().toString());
                data2.setNoteContent3(etContent3.getText().toString());
                int star = rgEditContent.getCheckedRadioButtonId();
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
                    Toast.makeText(EditActivity.this, "Wrong star",
                            Toast.LENGTH_SHORT).show();
                }

                dbh.updateNote(data,data1,data2,data3);
                dbh.close();
                finish();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteNote(data.getId());
                finish();

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
