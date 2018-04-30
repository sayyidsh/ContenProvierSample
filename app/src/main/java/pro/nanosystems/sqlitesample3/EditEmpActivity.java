package pro.nanosystems.sqlitesample3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import pro.nanosystems.sqlitesample3.model.Employee;

public class EditEmpActivity extends AppCompatActivity {
    EditText nameEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_emp);
        Intent i = getIntent();
        nameEdit = findViewById(R.id.nameEdit);
        Employee employee = (Employee) i.getSerializableExtra("emp");
        nameEdit.setText(employee.getName());

    }

    public void saveUpdate(View view) {
        //
    }
}
