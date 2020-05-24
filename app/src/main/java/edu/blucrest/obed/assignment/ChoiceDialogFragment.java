package edu.blucrest.obed.assignment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;


public class ChoiceDialogFragment extends DialogFragment {

    int position = 0; //default selected position

    public interface SingleChoiceListener {

        void onPositiveButtonClicked(int position);

        void onNegativeButtonClicked();
    }

    public interface SingleChoiceDialogListener {
        void showDialog();
    }



    SingleChoiceListener mListener = new GameActivity();

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        try {
            mListener = (SingleChoiceListener) context;
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + " SingleChoiceListener must implemented");
        }
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final String[] list = getActivity().getResources().getStringArray(R.array.choice_items);


        builder.setTitle("Select a piece to promote to: ");
        builder.setItems(new CharSequence[]
                        {"Queen", "Rook", "Knight", "Bishop"},
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        switch (which) {
                            case 0:
                                mListener.onPositiveButtonClicked(1);
                                break;
                            case 1:
                                mListener.onPositiveButtonClicked(2);
                                break;
                            case 2:
                                mListener.onPositiveButtonClicked(3);
                                break;
                            case 3:
                                mListener.onPositiveButtonClicked(4);
                                break;
                        }
                    }
                });


/*
        builder.setTitle("Select a piece to promote to: ")
                .setSingleChoiceItems(list, position, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        position = i;
                    }
                })

                .setPositiveButton("Queen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mListener.onPositiveButtonClicked(list, position);
                    }
                })

                .setPositiveButton("Rook", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onPositiveButtonClicked(list, position);
                    }
                })

                .setPositiveButton("Knight", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onPositiveButtonClicked(list, position);
                    }
                })

                .setPositiveButton("Bishop", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onPositiveButtonClicked(list, position);
                    }
                });
*/

        return builder.create();
    }


}