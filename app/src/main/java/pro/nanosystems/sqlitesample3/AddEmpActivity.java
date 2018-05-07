package pro.nanosystems.sqlitesample3;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import pro.nanosystems.sqlitesample3.database.DbHelper;
import pro.nanosystems.sqlitesample3.database.Employees;
import pro.nanosystems.sqlitesample3.databinding.ActivityAddEmpBinding;

public class AddEmpActivity extends AppCompatActivity {

    ActivityAddEmpBinding empBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        empBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_emp);

        empBinding.backAdd.setOnClickListener(e->{
            finish();
        });


        empBinding.saveAdd.setOnClickListener(e->{
            if(!empBinding.codeAdd.getText().
                    toString().
                    isEmpty() && !empBinding.nameAdd.
                    getText().
                    toString().isEmpty()  && !empBinding.
                    jobAdd.getText().toString().isEmpty()){
                DbHelper dbHelper = new DbHelper(this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(Employees.Employee.CODE, empBinding.codeAdd.getText().toString());
                values.put(Employees.Employee.NAME, empBinding.nameAdd.getText().toString());
                values.put(Employees.Employee.JOB, empBinding.jobAdd.getText().toString());

            if(db.insert(Employees.Employee.TABLE, null, values) != -1) {
                empBinding.codeAdd.setText("");
                empBinding.nameAdd.setText("");
                empBinding.jobAdd.setText("");
                empBinding.codeAdd.requestFocus();}
                else {
                Toast.makeText(this, "Invalid Entery.", Toast.LENGTH_SHORT).show();
            }


            }
            else{
                Toast.makeText(this, "Must Fill all data.", Toast.LENGTH_SHORT).show();
            }

        });


    }
}
