package pro.nanosystems.sqlitesample3;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import pro.nanosystems.sqlitesample3.database.DbHelper;
import pro.nanosystems.sqlitesample3.database.Employees;
import pro.nanosystems.sqlitesample3.model.Employee;

public class EditEmpActivity extends AppCompatActivity {
    EditText nameEdit;
    final Context context = this;
    Employee employee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_emp);
        Intent i = getIntent();
        nameEdit = findViewById(R.id.nameEdit);
         employee = (Employee) i.getSerializableExtra("emp");
        nameEdit.setText(employee.getName());
        findViewById(R.id.saveEdit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!nameEdit.getText().toString().isEmpty()){
                DbHelper dbHelper = new DbHelper(context);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(Employees.Employee.NAME, nameEdit.getText().toString());
                db.update(Employees.Employee.TABLE, values,
                        Employees.Employee._ID + " = " + employee.get_id(), null );
                finish();
                }
            }
        });


    }


}
