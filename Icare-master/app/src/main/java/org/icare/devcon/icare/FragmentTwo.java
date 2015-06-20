package org.icare.devcon.icare;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends android.support.v4.app.Fragment {

    GoogleMap googleMap;
    ImageView ivIcon;
    TextView tvItemName;
    private TextView responseTextView;
    String s = "";

    public static final String IMAGE_RESOURCE_ID = "iconResourceID";
    public static final String ITEM_NAME = "itemName";

    public FragmentTwo() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View viewHospital = inflater.inflate(R.layout.activity_ma, container, false);

        //Intent i=new Intent(getActivity(),Maina.class);
        //startActivity(i);

        return viewHospital;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (netwrkChk()) {
            responseTextView = (TextView) view
                    .findViewById(R.id.responseTextView);
            new GetAllDataTask().execute(new ApiConnector());
        } else {
            Toast.makeText(getActivity(), "Please Connect to Internet", Toast.LENGTH_LONG).show();

        }
    }

    public void setTextToTextView(JSONArray jsonArray) {

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json = null;
            try {
                json = jsonArray.getJSONObject(i);
                s = s + "Name:" + json.getString("NAME") + "\n" + "Address:"
                        + json.getString("ADDRESS") + "\n" + "Number:"
                        + json.getString("NUMBER") + "\n\n";
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        this.responseTextView.setText(s);
    }

    private class GetAllDataTask extends
            AsyncTask<ApiConnector, Long, JSONArray> {

        @Override
        protected JSONArray doInBackground(ApiConnector... params) {
            // TODO Auto-generated method stub
            return params[0].GetAllData();
        }

        @Override
        protected void onPostExecute(JSONArray result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            setTextToTextView(result);
        }

    }

    private boolean netwrkChk() {
        Context ctx = getActivity();
        ConnectivityManager conMgr = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo i = conMgr.getActiveNetworkInfo();
        if (i == null)
            return false;
        if (!i.isConnected())
            return false;
        if (!i.isAvailable())
            return false;
        return true;
    }

  /*  private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }*/

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        //inflater.inflate(R.menu.main, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();


    }


}

