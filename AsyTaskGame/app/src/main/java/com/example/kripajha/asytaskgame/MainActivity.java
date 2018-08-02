package com.example.kripajha.asytaskgame;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View view = inflater.inflate(R.layout.activity_main, null);
        setContentView(view);
        ApiRequestTask obj = new ApiRequestTask(view, MainActivity.this);
        obj.execute();
    }





}

class ApiRequestTask extends AsyncTask<Void, Void, JSONArray> {
    private final Context context;
    private View AppView;
    TextView txV;
    ProgressDialog pb;

    ApiRequestTask(View view, Context context) {
        this.AppView = view;
        this.context = context;
        pb = new ProgressDialog(context);
    }

    private String urlString = "https://jsonplaceholder.typicode.com/posts";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        txV = AppView.findViewById(R.id.textView);

        pb.setMessage("Loading ...");
        pb.show();
    }

    @Override
    protected JSONArray doInBackground(Void... params) {
        JSONArray response = callingHttpRequest(urlString);
        return response;
    }

    @Override
    protected void onPostExecute(JSONArray s) {
        super.onPostExecute(s);
        if (s != null)
            txV.setText(s.toString());
        pb.dismiss();
    }

    private JSONArray callingHttpRequest(String urlString) {
        Exception mException = null;
        HttpURLConnection urlConnection = null;
        URL url;
        JSONArray object = null;
        InputStream inStream = null;


        try {
            url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            inStream = urlConnection.getInputStream();
            BufferedReader bReader = new BufferedReader(new InputStreamReader(inStream));
            StringBuilder response = new StringBuilder();
            String temp;
            while ((temp = bReader.readLine()) != null) {
                response.append(temp);
            }
            object = new JSONArray(response.toString());
        } catch (Exception e) {
            mException = e;
        } finally {
            if (inStream != null) {
                try {
                    // this will close the bReader as well
                    inStream.close();
                } catch (IOException ignored) {
                }
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return object;
    }
}