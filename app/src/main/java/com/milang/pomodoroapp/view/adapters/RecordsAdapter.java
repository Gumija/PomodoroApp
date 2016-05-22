package com.milang.pomodoroapp.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.milang.pomodoroapp.R;
import com.milang.pomodoroapp.model.PomodoroTask;

import java.text.SimpleDateFormat;

/**
 * Created by Felix on 5/22/2016.
 */
public class RecordsAdapter extends BaseAdapter {

    private PomodoroTask[] records;
    private Context context;
    private static LayoutInflater inflater = null;

    public RecordsAdapter(Context context, PomodoroTask[] records) {
        this.context = context;
        this.records = records;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return records.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View rowView = inflater.inflate(R.layout.records_list_item, null);
        TextView tvName = (TextView) rowView.findViewById(R.id.name);
        TextView tvEstimate = (TextView) rowView.findViewById(R.id.estimate);
        TextView tvDone = (TextView) rowView.findViewById(R.id.done);
        TextView tvDate = (TextView) rowView.findViewById(R.id.date);
        tvName.setText(records[position].name);
        tvEstimate.setText(Integer.toString(records[position].estimate1));
        tvDone.setText(Integer.toString(records[position].pomodorosDone));
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String c = format.format(records[position].createdOn);
        String f = format.format(records[position].finishedOn);
        tvDate.setText(c + " - " + f);



        return rowView;

    }
}