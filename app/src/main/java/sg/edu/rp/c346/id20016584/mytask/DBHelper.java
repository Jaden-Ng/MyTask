package sg.edu.rp.c346.id20016584.mytask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Sampler;

import org.json.JSONArray;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="Task.db";
    private static final int DATABASE_VERSION = 1;
    private static final String COLUMN_ID = "_id";
    private static final String TABLE_TASK = "Task";
    private static final String COLUMN_TASK="tasks";
    private static final String COLUMN_DATE="date";
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTaskTableSql="CREATE TABLE "+ TABLE_TASK +"("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +COLUMN_DATE + " TEXT, "
                +COLUMN_TASK + " TEXT  )";
        db.execSQL(createTaskTableSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_TASK);
        onCreate(db);
    }
    public long insertTask(String Task, String date){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues Values=new ContentValues();
        Values.put(COLUMN_TASK, Task);
        Values.put(COLUMN_DATE, date);
        long result=db.insert(TABLE_TASK, null, Values);
        db.close();
        return result;
    }
    public ArrayList<Task> getAllTask(){
        ArrayList<Task> taskList=new ArrayList<Task>();
        String selectQuery="SELECT "+COLUMN_ID+", "
                +COLUMN_DATE+"," + COLUMN_TASK+" FROM "+TABLE_TASK;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String date = cursor.getString(1);
                String task = cursor.getString(2);

                Task newTask = new Task(task, date);
                taskList.add(newTask);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return taskList;
    }
}
