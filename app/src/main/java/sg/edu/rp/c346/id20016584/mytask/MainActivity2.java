package sg.edu.rp.c346.id20016584.mytask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
ListView lv;
ArrayList<Task> taskList;
CustomAdapter adapter;

    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbh=new DBHelper(this);
        taskList.clear();
        taskList.addAll(dbh.getAllTask());
        adapter=new CustomAdapter(this, R.layout.row, taskList);
        adapter.notifyDataSetChanged();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv=(ListView)this.findViewById(R.id.lv);

        DBHelper dbh=new DBHelper(this);
        taskList=dbh.getAllTask();
        dbh.close();

        adapter=new CustomAdapter(this, R.layout.row, taskList);
        lv.setAdapter(adapter);




    }
}