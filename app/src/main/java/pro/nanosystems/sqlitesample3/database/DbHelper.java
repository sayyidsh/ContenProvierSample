package pro.nanosystems.sqlitesample3.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, Employees.DATABASE, null, Employees.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Employees.Job.CREATE);
        db.execSQL(Employees.Employee.CREATE);
        db.execSQL(Employees.Job.DUMMY);
        db.execSQL(Employees.Employee.DUMMY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Employees.Employee.DROP);
        db.execSQL(Employees.Job.DROP);
        onCreate(db);
    }
}
