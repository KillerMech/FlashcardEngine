package com.nerdranchstudy.cash.etswe;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SaveFilePickerFragment extends DialogFragment {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SaveFilePickerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SaveFilePickerFragment newInstance() {
        SaveFilePickerFragment fragment = new SaveFilePickerFragment();

        return fragment;
    }
    public SaveFilePickerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_save_file_picker, container, false);
    }


}
