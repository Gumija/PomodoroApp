package com.milang.pomodoroapp.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.milang.pomodoroapp.PomodoroApplication;
import com.milang.pomodoroapp.R;

/**
 * Created by Felix on 5/22/2016.
 */
public class AddDialogFragment extends DialogFragment {

    public interface AddDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog, String name, int estimate);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    AddDialogListener mListener;
    private Tracker mTracker;
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (AddDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        PomodoroApplication application = (PomodoroApplication) getActivity().getApplication();
        mTracker = application.getDefaultTracker();
        mTracker.setScreenName("Image~" + "AddDialog");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        final View view = inflater.inflate(R.layout.add_dialog, null);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                // Add action buttons
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String name = ((EditText)view.findViewById(R.id.inputName)).getText().toString();
                        int estimate = new Integer(((EditText)view.findViewById(R.id.inputEstimate)).getText().toString());
                        mListener.onDialogPositiveClick(AddDialogFragment.this, name, estimate);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mListener.onDialogNegativeClick(AddDialogFragment.this);
                        AddDialogFragment.this.getDialog().cancel();
                    }
                });
        builder.setTitle("New Pomodoro");

        return builder.create();
    }
}
