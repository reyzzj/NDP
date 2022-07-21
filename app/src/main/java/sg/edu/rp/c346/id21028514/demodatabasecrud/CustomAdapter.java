package sg.edu.rp.c346.id21028514.demodatabasecrud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Note> arrayList;


    public CustomAdapter(Context context, int resource, ArrayList<Note>objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        arrayList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //OBTAIN THE LAYOUT INFLATER OBJECT-TO LET THE VIEW CAN SHOW
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //"INFLATE" THE VIEW FOR EACH ROW
        View rowView = inflater.inflate(layout_id, parent, false);

        //OBTAIN THE UI COMPONENTS AND DO THE NECESSARY BINDING
        TextView tvSong = rowView.findViewById(R.id.tvSong);
        TextView tvYear = rowView.findViewById(R.id.tvYear);
        TextView tvSinger = rowView.findViewById(R.id.tvSinger);
        ImageView imgView1 = rowView.findViewById(R.id.star1);
        ImageView imgView2 = rowView.findViewById(R.id.star2);
        ImageView imgView3 = rowView.findViewById(R.id.star3);
        ImageView imgView4 = rowView.findViewById(R.id.star4);
        ImageView imgView5 = rowView.findViewById(R.id.star5);

        //OBTAIN THE SONG INFORMATION BASED ON THE POSITITION
        Note currentVersion = arrayList.get(position);

        //SET VALUES TO THE TEXTVIEW TO DISPLAY THE CORRESPONDING INFORMATION
        tvSong.setText(currentVersion.getNoteContent());
        tvSinger.setText(currentVersion.getNoteContent2());
        tvYear.setText(currentVersion.getNoteContent3());

        imgView1.setVisibility(View.INVISIBLE);
        imgView2.setVisibility(View.INVISIBLE);
        imgView3.setVisibility(View.INVISIBLE);
        imgView4.setVisibility(View.INVISIBLE);
        imgView5.setVisibility(View.INVISIBLE);

        if (currentVersion.getNoteContent4() == 1) { imgView1.setVisibility(View.VISIBLE);}
        else if (currentVersion.getNoteContent4() == 2) {
            imgView1.setVisibility(View.VISIBLE);
            imgView2.setVisibility(View.VISIBLE);
        }
        else if (currentVersion.getNoteContent4() == 3) {
            imgView1.setVisibility(View.VISIBLE);
            imgView2.setVisibility(View.VISIBLE);
            imgView3.setVisibility(View.VISIBLE);
        }
        else if (currentVersion.getNoteContent4() == 4) {
            imgView1.setVisibility(View.VISIBLE);
            imgView2.setVisibility(View.VISIBLE);
            imgView3.setVisibility(View.VISIBLE);
            imgView4.setVisibility(View.VISIBLE);
        }
        else if (currentVersion.getNoteContent4() == 5) {
            imgView1.setVisibility(View.VISIBLE);
            imgView2.setVisibility(View.VISIBLE);
            imgView3.setVisibility(View.VISIBLE);
            imgView4.setVisibility(View.VISIBLE);
            imgView5.setVisibility(View.VISIBLE);
        }

        return rowView;
    }
}
