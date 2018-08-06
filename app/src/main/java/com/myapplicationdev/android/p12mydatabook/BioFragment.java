package com.myapplicationdev.android.p12mydatabook;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class BioFragment extends Fragment {
    Button btnEdit;
    TextView tv;
    FloatingActionButton fab;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    SharedPreferences prefs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.biofragment, container, false);

        btnEdit = (Button) view.findViewById(R.id.btnEdit);
        tv = (TextView) view.findViewById(R.id.tv);
        fab = view.findViewById(R.id.fab);
        drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        drawerList = (ListView) getActivity().findViewById(R.id.left_drawer);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //action to open navigation drawer
                drawerLayout.openDrawer(drawerList);
            }
        });
        prefs = getActivity().getSharedPreferences("prefsBio", MODE_PRIVATE);
        String str = prefs.getString("bio", "");
        tv.setText(str);


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflaterdialog = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                LinearLayout passPhrase = (LinearLayout) inflaterdialog.inflate(R.layout.edit, null);
                final EditText et = (EditText) passPhrase.findViewById(R.id.editText);

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Edit Bio")
                        .setView(passPhrase)
                        .setNeutralButton("Cancel",null)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                tv.setText(et.getText().toString());
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putString("bio", et.getText().toString());
                                editor.apply();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        return view;
    }

}
