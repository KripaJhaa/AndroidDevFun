package com.example.kripajha.recyclerproject;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MessageDialog {

    public  void showDialog(Activity activity,String message){
        final Dialog dialog=new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialogmessage);

        TextView textViewForMessage= dialog.findViewById(R.id.dialogTextView);
        textViewForMessage.setText(message);
        Button dialogButton=dialog.findViewById(R.id.closeDialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}
