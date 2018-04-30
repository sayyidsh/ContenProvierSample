package pro.nanosystems.sqlitesample3.database;

import android.provider.BaseColumns;

public abstract class Employees {
    public static final String DATABASE = "hr.db";
    public static final int VERSION = 1;

    public static class Job implements BaseColumns {
        public static final String TABLE = "job";
        public static final String TITLE = "title";

        public static final String CREATE = "CREATE TABLE " + TABLE +
                "( " + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TITLE + " TEXT UNIQUE NOT NULL); ";
        public static final String DROP = "DROP TABLE IF EXISTS " + TABLE + "; ";
        public static final String DUMMY =
                " INSERT INTO " + TABLE + " (" + TITLE + ") VALUES " +
                        "( 'Developer'), " +
                        "( 'DESIGNER'), " +
                        "( 'ACC'); ";
    }

    public static class Employee implements BaseColumns {
        public static final String TABLE = "employee";
        public static final String CODE = "code";
        public static final String NAME = "name";
        public static final String JOB = "job";

        public static final String CREATE = " CREATE TABLE " + TABLE +
                "( " + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CODE + " TEXT UNIQUE NOT NULL, " +
                NAME + " TEXT NOT NULL, " +
                JOB + " INTEGER NOT NULL); ";
        public static final String DROP = " DROP TABLE IF EXISTS " + TABLE + "; ";
        public static final String JOIN = TABLE + " e JOIN " +
                Job.TABLE + " j ON(e." + JOB + " = j." + _ID + ") ";
        public static final String[]
                COLUMNS = {"e."+_ID, CODE, NAME, Job.TITLE};

        public static final String DUMMY =
                " INSERT INTO " + TABLE + "(" + CODE + ", " + NAME + ", " + JOB
                        + ") VALUES " +
                        " (100, 'AHMED', 1), " +
                        " (101, 'Mohamed', 2), " +
                        " (102, 'ALI', 2), " +
                        " (103, 'Mahmoud', 3); ";


    }
}
