package org.icare.devcon.icare;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFive extends android.support.v4.app.Fragment {


    public static int prox = 0;
    SeekBar s;

    public FragmentFive() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_settings, container,
                false);
        s = (SeekBar) view.findViewById(R.id.seekBar1);

        s.setProgress(15);
        prox = s.getProgress();
        Button save = (Button) view.findViewById(R.id.save_set);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prox = s.getProgress();

            }
        });
        //Intent i = new Intent(getActivity(), Setting.class);
        //startActivity(i);
        return view;
    }

    public void onDestroyView() {
        super.onDestroyView();


    }

    public void onBackPressed() {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }


}
