//Project members
//Yasser Al-Ruwaiti-440017590
//Abdulrahman Al-Rubayan-440017248
//Abdulkarim Alluhaydan-440016617
//Faisal Al-zaydan-440013811
package com.example.alert;

import android.os.AsyncTask;


import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetworkOperations extends AsyncTask<String,Void,Void> {



    static Client client;
    static boolean set = false;



    @Override
    protected Void doInBackground(String... voids) {
        String message = voids[0];

        if (!set) {

            try {
                String ip = Inet4Address.getByName("192.168.43.37").getCanonicalHostName();
                InetSocketAddress sa = new InetSocketAddress(ip, 1234);

                Socket skt = new Socket();
                skt.connect(sa);

                // Pass the socket and give the client a name and ID.
                client = new Client(skt, "parent", "111");

                client.listenForAlert();
                client.setclient();

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            set = true;
        }
        if(!message.equals("set")){
            client.sendAlert(message);
        }


        return null;
    }


}
