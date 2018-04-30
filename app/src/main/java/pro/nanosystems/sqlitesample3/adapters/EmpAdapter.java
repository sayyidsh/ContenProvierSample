package pro.nanosystems.sqlitesample3.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pro.nanosystems.sqlitesample3.R;

public class EmpAdapter extends CursorAdapter {
    public EmpAdapter(Context context, Cursor c) {
        super(context, c, true);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).
                inflate(R.layout.row_items, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView codeList, nameList, jobList;
        codeList = view.findViewById(R.id.codeList);
        nameList = view.findViewById(R.id.nameList);
        jobList = view.findViewById(R.id.jobList);

        codeList.setText(cursor.getString(1));
        nameList.setText(cursor.getString(2));
        jobList.setText(cursor.getString(3));


    }
}
