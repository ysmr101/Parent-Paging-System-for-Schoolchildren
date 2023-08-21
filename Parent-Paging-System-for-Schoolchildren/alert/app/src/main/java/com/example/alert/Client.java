//Project members
//Yasser Al-Ruwaiti-440017590
//Abdulrahman Al-Rubayan-440017248
//Abdulkarim Alluhaydan-440016617
//Faisal Al-zaydan-440013811

package com.example.alert;

import java.io.*;
import java.net.Socket;





public class Client {


    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String name;
    private String ID;


    public Client(Socket socket, String name, String ID) {
        try {
            this.socket = socket;
            this.name = name;
            this.ID = ID;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            //close everything
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e2) {
                e.printStackTrace();
            }
        }
    }
    public void setclient() throws IOException {
        bufferedWriter.write(name);
        bufferedWriter.newLine();
        bufferedWriter.write(ID);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
    // Sending a alert isn't blocking and can be done without spawning a thread, unlike waiting for a alert.
    public void sendAlert(String message) {
        try {

            // While there is still a connection with the server, continue to scan the terminal and then send the alert



                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();



        } catch (IOException e) {
            //close everything
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (socket != null) {
                    socket.close();
                }

            } catch (IOException e2) {
                e.printStackTrace();
            }
        }
    }

    // Listening for a Alert is blocking so need a separate thread for that.
    public void listenForAlert() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                // While there is still a connection with the server, continue to listen for alert on a separate thread.
                while (socket.isConnected()) {
                    try {
                        // Get the messages sent from other users and print it to the console.
                        bufferedReader.readLine();
                        MainActivity.tv.setText("طلعت!");
                        MainActivity.tv.setBackgroundResource(R.drawable.rectangle_red);



                    } catch (IOException e) {
                        //close everything
                        try {
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (bufferedWriter != null) {
                                bufferedWriter.close();
                            }
                            if (socket != null) {
                                socket.close();
                            }
                        } catch (IOException e2) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

    }




}