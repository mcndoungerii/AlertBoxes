package com.example.alertbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder alertDialog;
    private Button showDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialog = (Button) findViewById(R.id.showDialogButtonID);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Connecting the alert dialog with this activity. as in alert dialog do run on top of MainActivity
                alertDialog = new AlertDialog.Builder(MainActivity.this);

                //set a title
                alertDialog.setTitle(getResources().getString(R.string.title));

                //set icon
                alertDialog.setIcon(android.R.drawable.btn_star_big_on);

                //set a alert message
                alertDialog.setMessage(getResources().getString(R.string.message));

                //set a cancellable -- so that user can not get out of the screen
                alertDialog.setCancelable(false);

                //set a positive button && pass an event to it (DialogInterface
                alertDialog.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Exit our MainActivity
                        MainActivity.this.finish();
                    }
                });

                //set Negative button
                alertDialog.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                //create the dialog
                AlertDialog dialog = alertDialog.create();

                //show Dialog
                dialog.show();
            }
        });
    }
}