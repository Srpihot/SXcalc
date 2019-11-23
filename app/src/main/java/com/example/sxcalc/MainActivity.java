package com.example.sxcalc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.DialogInterface;
import android.os.Bundle;

import java.util.Objects;

import static com.example.sxcalc.R.id.fragment;

public class MainActivity extends AppCompatActivity {
    NavController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller= Navigation.findNavController(this,R.id.fragment);
        NavigationUI.setupActionBarWithNavController(this,controller);
    }

    @Override
    public boolean onSupportNavigateUp() {
        if(Objects.requireNonNull(controller.getCurrentDestination()).getId()==R.id.questionFragment){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.quit_message_title));
            builder.setPositiveButton(R.string.quit_yes, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    controller.navigateUp();
                }
            });
            builder.setNegativeButton(R.string.quit_cancle, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog dialog=builder.create();
            dialog.show();
        }else if(controller.getCurrentDestination().getId()== R.id.welcomeFragment){
            finish();
        }else {
            controller.navigate(R.id.welcomeFragment);
        }

        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() { onSupportNavigateUp(); }
}
