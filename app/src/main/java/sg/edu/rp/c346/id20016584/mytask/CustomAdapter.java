package sg.edu.rp.c346.id20016584.mytask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Task> TaskList;

    public CustomAdapter(Context context, int resource, ArrayList<Task> objects){
        super(context, resource, objects);
        parent_context=context;
        layout_id=resource;
        TaskList=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=inflater.inflate(layout_id, parent, false);

        TextView tvDate=rowView.findViewById(R.id.textViewDate1);
        TextView tvTask=rowView.findViewById(R.id.textViewTask1);

        tvDate.setText(TaskList.get(position).getDate());
        tvTask.setText(TaskList.get(position).getTask());

        return rowView;
    }
}
