//Project members
//Yasser Al-Ruwaiti-440017590
//Abdulrahman Al-Rubayan-440017248
//Abdulkarim Alluhaydan-440016617
//Faisal Al-zaydan-440013811

package com.example.alert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    static TextView tv;


    NetworkOperations networkOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textNotificationBoy);


        networkOperations = new NetworkOperations();
        networkOperations.execute("set");





    }

    public void send(View v) throws IOException {
        networkOperations = new NetworkOperations();
        networkOperations.execute("222,kid");

    }




}