package org.icare.devcon.icare;


import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Feedback_fragment extends android.support.v4.app.Fragment {

    EditText text;

    public Feedback_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_feedback_fragment, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button sendButton = (Button) view.findViewById(R.id.sendMail);
        text = (EditText) view.findViewById(R.id.editTextMail);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "arjun.vijay20@gmail.com", null));
                intent.putExtra(Intent.EXTRA_TEXT, text.toString());
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });
    }
}
