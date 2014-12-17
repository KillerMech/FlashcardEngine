package com.nerdranchstudy.cash.etswe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by cash on 12/14/14.
 */
public class MenuFragment extends Fragment {

    private Spinner mTestMode;
    private Button mWorkBook;
    private Button mSaveFile;
    private Button mStartButton;

    private Boolean shuffle = false;
    private Boolean wrongAnswers = false;
    private Boolean goodWorkbook = false;
    private Boolean goodSaveFile = false;
    private Boolean testModeSelected = false;

    //Required empty constructor
    public MenuFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle onSaveInstanceState){
        View v = inflater.inflate(R.layout.fragment_menu, parent, false);

        mTestMode = (Spinner)v.findViewById(R.id.test_mode_selector);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.menu_choices, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mTestMode.setAdapter(adapter);
        mTestMode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        shuffle = false;
                        wrongAnswers = false;
                        testModeSelected = true;
                        break;
                    case 2:
                        shuffle = true;
                        wrongAnswers = false;
                        testModeSelected = true;
                        break;
                    case 3:
                        shuffle = false;
                        wrongAnswers = true;
                        testModeSelected = true;
                        break;
                    case 4:
                        shuffle = true;
                        wrongAnswers = true;
                        testModeSelected = true;
                        break;
                    default:
                        testModeSelected = false;
                        break;
                }
                Log.d(TAG, shuffle + " " + wrongAnswers);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                testModeSelected = false;
            }
        });

        mWorkBook = (Button)v.findViewById(R.id.workbook_chooser_button);
        mWorkBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo make it so user can choose their own spreadsheet
                goodWorkbook = true;
            }
        });

        mSaveFile = (Button)v.findViewById(R.id.save_file_button);
        mSaveFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo make it so the user can have multiple save files that they named
                //and can choose from.
                FragmentManager fm = getActivity().getSupportFragmentManager();
                SaveFilePickerFragment dialog = SaveFilePickerFragment.newInstance();
                dialog.setTargetFragment(MenuFragment.this, REQUEST_SAVE);
                goodSaveFile = true;
                dialog.show(fm, DIALOG_SAVE);
            }
        });

        mStartButton = (Button)v.findViewById(R.id.start_button);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(goodSaveFile == true && goodWorkbook == true && testModeSelected == true){
                    Log.d(TAG, "Good Job");
                }else{
                    Toast badJob = new Toast(getActivity());
                    badJob.setText("Make sure all options have been selected");
                    badJob.show();
                    Log.d(TAG, "Come on!");
                }
            }
        });
        return v;
    }

    private static final String TAG = "com.nerdranchstudy.cash.etswe2";
    private static final String DIALOG_SAVE = "save";
    private static final int REQUEST_SAVE = 0;
}
