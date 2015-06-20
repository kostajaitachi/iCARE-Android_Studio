package org.icare.devcon.icare;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSix extends android.support.v4.app.Fragment {

    ListView list;
    String[] web = {
            "Medical Centre",
            "Medical Centre One",
            "Apollo",

    };

    Double[] mRating = {
            3.5,
            5.0,
            4.0,
            2.0,
            1.0,
            2.0,
            1.0,

    };

    Double[] mPrice = {
            350.0,
            500.0,
            400.0,
            200.0,
            100.0,
            200.0,
            150.0,

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View viewAppointment = inflater.inflate(R.layout.appointment, container, false);
        //Intent i = new Intent(getActivity(), Appointment.class);
        //startActivity(i);

        return viewAppointment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CustomList adapter = new
                CustomList(getActivity(), web, mRating, mPrice);
        list = (ListView) view.findViewById(R.id.list);
        TextView emptyTextView = (TextView)
                view.findViewById(android.R.id.empty);
        list.setEmptyView(emptyTextView);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getActivity(), "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}
