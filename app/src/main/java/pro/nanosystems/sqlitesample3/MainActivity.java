package pro.nanosystems.sqlitesample3;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import pro.nanosystems.sqlitesample3.adapters.EmpAdapter;
import pro.nanosystems.sqlitesample3.database.DbHelper;
import pro.nanosystems.sqlitesample3.database.Employees;
import pro.nanosystems.sqlitesample3.model.Employee;

public class MainActivity extends AppCompatActivity {
    DbHelper dbHelper;
    SQLiteDatabase db;
    Cursor cursor = null;
    final Context context = this;
    ListView empList;
    EmpAdapter empAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.addMain).setOnClickListener(e->{
            Intent i = new Intent(this, AddEmpActivity.class);
            startActivity(i);
        });

        dbHelper = new DbHelper(context);
        db = dbHelper.getReadableDatabase();
        cursor = db.query(Employees.Employee.JOIN, Employees.Employee.COLUMNS,
                null, null, null,
                null, null);

        empList = findViewById(R.id.empList);

        empAdapter = new EmpAdapter(context, cursor);

        empList.setAdapter(empAdapter);
        empList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean
            onItemLongClick
                    (AdapterView<?> parent, View view, int position, final long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Confirm!").
                        setMessage(R.string.confirm_delete).
                        setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                db.delete(Employees.Employee.TABLE, "_id = " + id, null);
                                updateEmpList();
                            }
                        }).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            }
        });

empList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(context, EditEmpActivity.class);
        Cursor c = db.
                query(Employees.Employee.TABLE,
                        null,
                        " _id = " + id, null, null,
                        null, null, "0,1");
        c.moveToFirst();
        Employee employee =
                new Employee(c.getInt(0), c.getString(1),
                        c.getString(2), c.getInt(3));
        i.putExtra("emp", employee);
        startActivity(i);
    }
});
    }

    private void updateEmpList() {
        Cursor c = db.
                query(Employees.Employee.JOIN,
                        Employees.Employee.COLUMNS,
                        null, null, null,
                        null, null);
        empAdapter.changeCursor(c);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateEmpList();
    }

    public void jobs(View view) {
        startActivity(new Intent(this, JobsActivity.class));
    }
}
