package pro.nanosystems.sqlitesample3.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pro.nanosystems.sqlitesample3.R;

public class JobsAdapter extends CursorAdapter {
    public JobsAdapter(Context context, Cursor c) {
        super(context, c, true);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        return LayoutInflater.from(context).inflate(R.layout.jobs_row,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView jId = view.findViewById(R.id.jobIdView);
        TextView jTitle = view.findViewById(R.id.jobTitleView);
        jId.setText(cursor.getInt(0)+"");
        jTitle.setText(cursor.getString(1));

    }
}
