package org.icare.devcon.icare;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentThree extends android.support.v4.app.Fragment {


    public FragmentThree() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_three, container,
                false);


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
