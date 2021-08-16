package sg.edu.rp.c346.id20016584.mytask;

import java.io.Serializable;
import java.util.Calendar;

public class Task implements Serializable {
    private String task;
    private String date;
//    private String strdate;

    public Task(String task, String date) {
        this.task = task;
        this.date = date;
    }


    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
//    public String toString() {
//        String str = date.get(Calendar.DAY_OF_MONTH)+"/"+date.get(Calendar.MONTH)
//                +"/"+date.get(Calendar.YEAR) + " (" + getDay(date.get(Calendar.DAY_OF_WEEK)) + ")";
//
//        return str;
//    }
//
//    private String getDay(int day) {
//        switch (day) {
//            case 1:
//                return "Monday";
//
//            case 2:
//                return "Tuesday";
//
//            case 3:
//                return "Wednesday";
//
//            case 4:
//                return "Thursday";
//
//            case 5:
//                return "Friday";
//
//            case 6:
//                return "Saturday";
//
//            case 7:
//                return "Sunday";
//
//            default:
//                return "";
//        }
//    }
}
