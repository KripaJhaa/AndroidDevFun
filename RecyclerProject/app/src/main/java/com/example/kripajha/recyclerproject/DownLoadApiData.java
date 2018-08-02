package com.example.kripajha.recyclerproject;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Message;
import android.widget.ProgressBar;

public class DownLoadApiData extends AsyncTask<Void,Void,String>{

    private final Context context;

    ProgressDialog progressDialog;

    public DownLoadApiData(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog=new ProgressDialog(context);
        progressDialog.setDismissMessage(new Message());
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(Void... voids) {
        return null;
    }
}
