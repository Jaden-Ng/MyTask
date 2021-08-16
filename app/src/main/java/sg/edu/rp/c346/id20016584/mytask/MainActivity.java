package sg.edu.rp.c346.id20016584.mytask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.shape.CutCornerTreatment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText etTask ;
    Button btnInsert, btnView;
    DatePicker dp;
//    ListView lv;
//    ArrayList<Task> taskList;
//    CustomAdapter caTask;
//    ArrayAdapter<Task> taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp=(DatePicker)findViewById(R.id.datePicker);
        etTask=(EditText)findViewById(R.id.editTextTask);
        btnInsert=(Button)findViewById(R.id.buttonInsert);
        btnView=(Button)findViewById(R.id.buttonShow);
//        lv=(ListView)findViewById(R.id.lv);

//        taskList=new ArrayList<Task>();
//        Calendar date1= Calendar.getInstance();
//        date1.set(2021, 8, 19);
//        Calendar date2= Calendar.getInstance();
//        date2.set(2021, 8, 26);
//        Task item1=new Task("HTML submission date", date1);
//        Task item2=new Task("Networking exam", date2);
//        taskList.add(item1);
//        taskList.add(item2);
//
//        caTask=new CustomAdapter(this, R.layout.row, taskList);
//
//        lv.setAdapter(caTask);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.set(dp.getYear(), dp.getMonth(), dp.getDayOfMonth());
                String date=dp.getYear()+"/"+dp.getMonth()+"/"+dp.getDayOfMonth();
                String strtask=etTask.getText().toString();

//                Task str= new Task(strtask, cal);
//                taskList.add(str);

                DBHelper dbh=new DBHelper(MainActivity.this);
                dbh.insertTask(strtask, date);
                dbh.close();
                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_LONG).show();
//                caTask.notifyDataSetChanged();
                etTask.setText("");
                dp.updateDate(2021,0, 1);
            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent=new Intent(MainActivity.this, MainActivity2.class);
//                intent.putExtra("task", taskList.get(position));
//                startActivity(intent);
//            }
//        });
    }
}