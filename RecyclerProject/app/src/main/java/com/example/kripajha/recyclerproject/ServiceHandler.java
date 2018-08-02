package com.example.kripajha.recyclerproject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServiceHandler {

    public  void makeServeiceCall(String urlParam) throws IOException {

        URL url=new URL(urlParam);
        HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();

        InputStream in=new BufferedInputStream(httpURLConnection.getInputStream());

    }
}
