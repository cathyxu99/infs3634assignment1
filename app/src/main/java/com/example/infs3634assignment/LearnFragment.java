package com.example.infs3634assignment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class LearnFragment extends Fragment {
    public TextView learnText;
    public LearnFragment() {
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
        View view = inflater.inflate(R.layout.fragment_learn, container, false);
        learnText = view.findViewById(R.id.test);

        String organ = getArguments().getString("organName");

        final RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        final String wikiUrl = "https://wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=" +organ;
        //grabs string and cleans it removing bracketed text and any newline characters
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String string = (response.substring(response.lastIndexOf("extract")+10,response.length()-5));
                string = string.replace("\\n", "\n\n");
                string = string.replaceAll("\\(.*?\\)", "");
                learnText.setText(string);
//
                requestQueue.stop();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse (VolleyError error) {
                System.out.println(error.toString());
            }
        };
        StringRequest stringRequest = new StringRequest(Request.Method.GET, wikiUrl, responseListener, errorListener);
        requestQueue.add(stringRequest);

        return view;
    }
}
