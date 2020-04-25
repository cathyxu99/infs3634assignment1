package com.example.infs3634assignment.Learn;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.infs3634assignment.R;
import com.example.infs3634assignment.TheBodyFragment;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Iterator;

public class LearnFragment extends Fragment {
    public TextView learnText;
    public Button readMore, backBody;

    private ArrayList<String> mImageURLs = new ArrayList<>();
    private ArrayList<String> mImageNames = new ArrayList<>();
    private String imagesResponse;
    private OrganImageResponse organImageResponse;
    private ProgressBar progressBar;
    private LinearLayout extras;

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

       final View view = inflater.inflate(R.layout.fragment_learn, container, false);
       final String organ = getArguments().getString("organName");

       extras = view.findViewById(R.id.extras);
       extras.setVisibility(View.GONE);
       //This API call returns all images used on the target wikipedia page
       final RequestQueue requestQueueImages = Volley.newRequestQueue(getContext());
       final String wikiImages = "https://en.wikipedia.org/w/api.php?action=query&titles="+organ+"&prop=images&format=json";
       Response.Listener<String> responseListener = new Response.Listener<String>() {
          @Override
          public void onResponse(String response) {
              String str = (response.substring(response.indexOf("\"images"),response.length()-3));
              imagesResponse = "{" + str;
              organImageResponse = new Gson().fromJson(imagesResponse, OrganImageResponse.class);
              //Wikipedia API response  returns some irrelevant images. this method removes these images and prevents them from being shown.
              removeImages();
               getImageURLS(view);
               requestQueueImages.stop();
           }
       };

       Response.ErrorListener errorListener = new Response.ErrorListener() {
           @Override
           public void onErrorResponse (VolleyError error) {
               System.out.println(error.toString());
           }
       };
       StringRequest stringRequestImages = new StringRequest(Request.Method.GET, wikiImages, responseListener, errorListener);
       requestQueueImages.add(stringRequestImages);
       learnText = view.findViewById(R.id.test);

       progressBar = view.findViewById(R.id.progressBar);
       progressBar.setVisibility(View.VISIBLE);
        //this api call  returns the first text section (overview/introduction) of the target wikipedia page
       final RequestQueue requestQueueLearn = Volley.newRequestQueue(getContext());
       final String wikiUrl = "https://wikipedia.org/w/api.php?action=query&prop=extracts&exintro&explaintext&redirects=1&titles=" +organ + "&format=json";
       //grabs string and cleans it removing bracketed text and any newline characters
       Response.Listener<String> responseListenerLearn = new Response.Listener<String>() {
           @Override
           public void onResponse(String response) {
               String str = (response.substring(response.lastIndexOf("\"extract\"")+11,response.length()-5));
               str = str.replace("\\n", "\n\n");
               str = str.replaceAll("\\(.*?\\)", "");
               learnText.setText(str);
               requestQueueLearn.stop();
               progressBar.setVisibility(View.GONE);
               extras.setVisibility(View.VISIBLE);
           }
       };

       Response.ErrorListener errorListenerLearn = new Response.ErrorListener() {
           @Override
           public void onErrorResponse (VolleyError error) {
               System.out.println(error.toString());
               progressBar.setVisibility(View.GONE);
               extras.setVisibility(View.VISIBLE);
               Toast.makeText(getActivity(), "Request failed, try to load organ again.", Toast.LENGTH_SHORT).show();

           }
       };
       StringRequest stringRequestLearn = new StringRequest(Request.Method.GET, wikiUrl, responseListenerLearn, errorListenerLearn);
       requestQueueLearn.add(stringRequestLearn);

       readMore = view.findViewById(R.id.readMore);
       readMore.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Uri uriUrl = Uri.parse("https://en.wikipedia.org/wiki/" + organ);
               Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
               startActivity(launchBrowser);
           }
       });
       backBody = view.findViewById(R.id.backBody);
       backBody.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FragmentManager manager = getActivity().getSupportFragmentManager();
               FragmentTransaction transaction = manager.beginTransaction();
               Fragment fragment = new TheBodyFragment();
               Bundle arguments = new Bundle();
               fragment.setArguments(arguments);
               transaction.replace(R.id.mainFragContainer,fragment);
               transaction.commit();
           }
       });
       return view;
    }


    //this method grabs the url of the target image that was found in RequestQueueImages request.
    public void getImageURLS(final View view){
        for(final OrganImage organImage:organImageResponse.getOrganImages()) {
            final RequestQueue requestQueueImagesURL = Volley.newRequestQueue(getContext());

            final String wikiImagesURL = "https://en.wikipedia.org/w/api.php?action=query&titles=" + organImage.getTitle()+"&prop=imageinfo&iiprop=url&format=json";
            final Response.Listener<String> responseListenerURL = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if(response.contains("Unrecognized parameter:")){
                       //nothing ie dont add the the image
                    } else {
                        String str = (response.substring(response.indexOf("\"url\"") + 7, response.indexOf("\"descriptionurl\"") - 2));
                        mImageURLs.add(str);
                        String title = organImage.getTitle();
                        organImage.setTitle(title.substring(title.indexOf("File:") + 5, title.length() - 4));
                        mImageNames.add(organImage.getTitle());
                        requestQueueImagesURL.stop();
                        createImages(view);
                    }
                }
            };
            Response.ErrorListener errorListenerURL = new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println(error.toString());
                    Toast.makeText(getActivity(), "Request failed, try to load organ again.", Toast.LENGTH_SHORT).show();
                }
            };


            StringRequest stringRequestImagesURL = new StringRequest(Request.Method.GET, wikiImagesURL, responseListenerURL, errorListenerURL);
            requestQueueImagesURL.add(stringRequestImagesURL);
        }
    }

    public void createImages(View view){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        OrganImageAdapter adapter = new OrganImageAdapter(getContext(),mImageURLs,mImageNames);
        recyclerView.setAdapter(adapter);

    }

    public void removeImages(){
        for(Iterator<OrganImage> itr = organImageResponse.getOrganImages().iterator(); itr.hasNext();){
            OrganImage organImage = itr.next();
            //removes .svg files as common page images such as help button are saved as .svg
            if(organImage.getTitle().contains(".svg")
                    || organImage.getTitle().contains("File:Axolotl ganz.jpg")
                    || organImage.getTitle().contains("File:ESCAYRAC(1853) p454 Planche VIII.jpg")
                    || organImage.getTitle().contains("File:Big Liver Tumor.JPG")
                    || organImage.getTitle().contains("File:Horse spleen laparoscopic.jpg")
                    || organImage.getTitle().contains("File:1407871818 5c7f215934 o.jpg")
                    || organImage.getTitle().contains("File:An open stomach.jpg")
                    || organImage.getTitle().contains("File:Big Liver Tumor.JPG")){
                itr.remove();
            }
        }
    }
}
