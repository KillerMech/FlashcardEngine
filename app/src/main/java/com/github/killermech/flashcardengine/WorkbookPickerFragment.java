package com.github.killermech.flashcardengine;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.lang.annotation.Target;
import java.util.ArrayList;

/**
 * Created by cash on 12/17/14.
 */
public class WorkbookPickerFragment extends DialogFragment implements MediaStore.Files.FileColumns {

    public static WorkbookPickerFragment newInstance(){
        WorkbookPickerFragment fragment = new WorkbookPickerFragment();
        return fragment;
    }

    public WorkbookPickerFragment(){
    }

    @TargetApi(11)
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        ArrayList<String> fileList = new ArrayList<String>();
        Uri index = MediaStore.Files.getContentUri(Environment.DIRECTORY_DOWNLOADS);

        for(String s : index.getQueryParameterNames()){
            fileList.add(s);
        }

        FileAdapter files = new FileAdapter(fileList);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_workbook_picker, null);
        //Dialog workbookPicker = (Dialog) v.findViewById(R.id.workbook_picker);

        return new AlertDialog.Builder(getActivity()).setTitle("Choose Spreadsheet File")
                .setView(v)
                .setTitle("Choose Spreadsheet File")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //todo
                    }
                })
                .create();
    }

    protected class FileAdapter extends ArrayAdapter<String>{

        public FileAdapter(ArrayList<String> fileName){
            super(getActivity(),0,fileName);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            //if we weren't given a view, inflate one.
            if(convertView == null){
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_file, null);
            }

            //configure the view for this crime
            String f = getItem(position);
            TextView titleTextView =
                    (TextView)convertView.findViewById(R.id.list_item_file_filenameTextView);

            return convertView;
        }
    }

}
