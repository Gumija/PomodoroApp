package com.milang.pomodoroapp.view.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.milang.pomodoroapp.R;

/**
 * Created by Felix on 5/22/2016.
 */
public class PomodoroListAdapter extends BaseAdapter {

    private String[] names;
    private Integer[] estimates;
    private Integer[] dones;
    private Long[] ids;
    private Context context;
    private static LayoutInflater inflater=null;

    public PomodoroListAdapter(Context context, String[] names, Integer[] dones,Integer[] estimates, Long[] ids){
        this.context = context;
        this.names = names;
        this.estimates = estimates;
        this.dones = dones;
        this.ids = ids;
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return names.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = inflater.inflate(R.layout.pomodoro_list_item, null);
        TextView tvName = (TextView) rowView.findViewById(R.id.name);
        TextView tvEstimate = (TextView) rowView.findViewById(R.id.estimate);
        TextView tvDone = (TextView) rowView.findViewById(R.id.done);
        tvName.setText(names[position]);
        tvEstimate.setText(Integer.toString(estimates[position]));
        tvDone.setText(Integer.toString(dones[position]));
        return rowView;

    }
}
