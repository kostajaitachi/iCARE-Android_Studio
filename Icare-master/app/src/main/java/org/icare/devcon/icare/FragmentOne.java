package org.icare.devcon.icare;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pushbots.push.Pushbots;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends android.support.v4.app.Fragment {

    ImageView ivIcon;
    TextView tvItemName;
    private static final String PUSHBOTS_APPLICATION_ID = "543950b21d0ab1e9798b458f";
    private static final String SENDER_ID = "181170534325";

    public static final String IMAGE_RESOURCE_ID = "iconResourceID";
    public static final String ITEM_NAME = "itemName";

    public FragmentOne() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Pushbots.init(getActivity(), SENDER_ID, PUSHBOTS_APPLICATION_ID);
        View view = inflater.inflate(R.layout.fragment_layout_one, container,
                false);

        ImageView iv1 = (ImageView) view.findViewById(R.id.imageButton1);
        ImageView iv2 = (ImageView) view.findViewById(R.id.imageButton2);
        iv1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getActivity(), GetHelp.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.layout.from_middle, R.layout.to_middle);
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getActivity(), TrackMe.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.layout.from_middle, R.layout.to_middle);
            }
        });


        return view;
    }

    public void onDestroyView() {
        super.onDestroyView();


    }

    public void onBackPressed() {

        //android.os.Process.killProcess(android.os.Process.myPid());
        //System.exit(1);
    }

}
