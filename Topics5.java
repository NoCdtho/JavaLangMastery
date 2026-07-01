/* 
 1. Java IO:
 Java IO is an api that is used to read and write data on streams, files, Pipes
 Network connections, in-memory buffers(array), System.in, System.out and System.error.
 2. Files and API:
 I specifically studied How to make http get and post request and read and write the data on the server.
*/


import java.io.*;
import java.net.*;

public class Topics5 {
    public static void main(String[] args){
        try{
            read a = new read();
            System.out.println(a.a);
            write w = new write();
            read b = new read();
            System.out.println(b.a);
        }
        catch(Exception e){
            System.out.println(e);
        }

        // API        
        try{
            HttpURLConnectionExample.sendget();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}


// Reading a file using FileReader class
class read{
     String a="";
    read() throws Exception{
        Reader filereader = new FileReader("E:\\PROJECTS\\JavaLanguage\\file.txt");
        // read() is used each character in the file
        int data = filereader.read();
        while(data != -1){
            char ch = (char) data;
            data = filereader.read();
            a = a + ch;
        }
        filereader.close();
    }
}

// writing in the file
class write{
    write() throws Exception{
        FileWriter fileWriter = new FileWriter("E:\\PROJECTS\\JavaLanguage\\file.txt", true);
        char[] ch = new char[]{'I', 'n', 'u'};
        fileWriter.write(ch);
        fileWriter.close(); 
    }
}

// API
class HttpURLConnectionExample{
    private final static String USER_AGENT =  "chrome";
    private final static String GET_URL =  "randomURL"; //URL used to retrive data from 
    private final static String POST_URL = "randomURL/write"; //URL used to write data on.
    private final static String POST_PARAMS =  "userName=Rohit";

    public static void sendget() throws IOException{
        URL obj = new URL(GET_URL); //used to parse the URL in simple language comverts the URL in java objects
        HttpURLConnection con = (HttpURLConnection) obj.openConnection(); //create the connection
        con.setRequestMethod("GET"); //used to send the get method request which is to retrive data from server
        con.setRequestProperty("USER_AGENT", USER_AGENT); //defines the request header like what platform, os the user is etc
        int responseCode = con.getResponseCode();
        System.out.println("THe connection status: " + responseCode);
        if(responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        }
        else{
            System.out.println("call get method again");
        }
    }
    public static void sendpost() throws Exception{
        URL obj = new URL(POST_URL);
        HttpURLConnection con =  (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("user-agent", USER_AGENT);

        // tell application to send data to the server
        con.setDoOutput(true); //create a output stream to write on the destination
        OutputStream os =  con.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();

        int responseCode = con.getResponseCode();
        System.out.println("THe connection status: " + responseCode);
        if(responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        }
        else{
            System.out.println("send post method again");
        }

    }
}