package com.milang.pomodoroapp.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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
    private boolean moveLeft;
    private static LayoutInflater inflater=null;

    public PomodoroListAdapter(Context context, String[] names, Integer[] dones,Integer[] estimates, Long[] ids, boolean moveLeft){
        this.context = context;
        this.names = names;
        this.estimates = estimates;
        this.dones = dones;
        this.ids = ids;
        this.moveLeft = moveLeft;
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        View rowView = inflater.inflate(R.layout.pomodoro_list_item, null);
        TextView tvName = (TextView) rowView.findViewById(R.id.name);
        TextView tvEstimate = (TextView) rowView.findViewById(R.id.estimate);
        TextView tvDone = (TextView) rowView.findViewById(R.id.done);
        tvName.setText(names[position]);
        tvEstimate.setText(Integer.toString(estimates[position]));
        tvDone.setText(Integer.toString(dones[position]));
        TextView tvPlusOne = (TextView) rowView.findViewById(R.id.plus_one);
        ImageView ivDelete = (ImageView) rowView.findViewById(R.id.delete);
        ImageView ivMove = (ImageView) rowView.findViewById(R.id.move);
        ImageView ivFinish = (ImageView) rowView.findViewById(R.id.finish);
        if (moveLeft){
            ivMove.setRotation(90);
            ivFinish.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
        }

        tvPlusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.plusOne(ids[position]);
            }
        });

        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.delete(ids[position]);
            }
        });

        ivMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.move(ids[position]);
            }
        });
        ivFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.finish(ids[position]);
            }
        });

        return rowView;

    }

    public void attachListener(PomodoroListAdapterListener listener){
        mListener = listener;
    }

    PomodoroListAdapterListener mListener;

    public interface PomodoroListAdapterListener {
        void plusOne(long id);
        void delete(long id);
        void move(long id);
        void finish(long id);
    }
}
