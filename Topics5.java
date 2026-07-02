/* 
 1. Java IO:
 Java IO is an api that is used to read and write data on streams, files, Pipes
 Network connections, in-memory buffers(array), System.in, System.out and System.error.

 2. Files and API:
 I specifically studied How to make http get and post request and read and write the data on the server.
 convered the how to read and write files and make API calls with a server used get and post function.

 3. Concurrency:
 This is the process where multiple task can be executed at same without waiting for one process to complete.

 4. High order function
 When a func is passed as a argument or a function returns a function then it's considered 
 a higer order functions.
*/


import java.io.*;
import java.net.*;
import java.util.*;
import java.util.function.Predicate;

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

        /* Concurrency
            start() is used to create new thread evrytime its called and run() executes the code in the same thread
            obj.start();
            obj2.start();

            running multiple threads and tracking which thread is executing.

            join() method is used when we want to stop the program until the thread is executed.
        */
        multiThreadThing obj = new multiThreadThing();
        multiThreadThing obj2 = new multiThreadThing();

       
        // for(int i = 0; i < 3; i++){
        //     multiThreadThing obj3 = new multiThreadThing(i);
        //     Thread mainThread = new Thread(obj3);
        //     mainThread.start();
        //     try{
        //         mainThread.join();
        //     }
        //     catch (Exception e) {}
        // }

        // java high order function
         hof hof = new hof();
         hof.fun();
         hof.revFun();

        //  Functional Composition
        functionalComposition fc = new functionalComposition();
        System.out.println(fc.res);
    }
}


/* below read and write class are used to read a txt file using filereader class 
*/
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
class write{
    write() throws Exception{
        FileWriter fileWriter = new FileWriter("E:\\PROJECTS\\JavaLanguage\\file.txt", true);
        char[] ch = new char[]{'I', 'n', 'u'};
        fileWriter.write(ch);
        fileWriter.close(); 
    }
}

/* API created using sendget() and sendpost() are created to get the response
of the requested URL.
Applied get method and post method here using HttpURLConnection class 
*/
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

/* Thread and Concurrency 
Below code will used to learn the basis of concurrency
in the first the run method the thread is sleeping for 1 second
we can also implement a interface runnable but then we have to create a object of Thread class 
to call the start(). 
 */

class multiThreadThing implements Runnable {
    multiThreadThing(){}

    int a;
    multiThreadThing(int i){
        this.a = i;
    }

    @Override
    public void run() {
        for(int i = 1; i < 6; i++){
            System.out.println(i + " from Thread " + a);
            try{
                Thread.sleep(1000);
            }
            catch (Exception e){}
        }
    }
}

/*
Java higher order functions
in the fun function the sorting function takes a list and lamda expression,
so its takes a function as a argument and returns a list of sorted items 
*/
class hof{
    List<String> list = new ArrayList<>();
    void fun(){
        list.add("One");
        list.add("Two");
        list.add("Four");

        Collections.sort(list, (String a, String b) -> {
        return a.compareTo(b);
        });

        System.out.println(list);
    }

    // reversing the sort using .reversed()
    List<String> list2 = new ArrayList<>();
    void revFun(){
        list2.add("cherry");
        list2.add("Apple");
        list2.add("Banana");

        Comparator<String> var = (String a, String b) -> {
            return a.compareTo(b);
        };

        Comparator<String> reversed = var.reversed();

        System.out.println("\nReversed the list: ");
        Collections.sort(list2, reversed);
        System.out.println(list2);

        System.out.println("\nReversing the reversed list: ");
        Collections.sort(list2, var);
        System.out.println(list2);

    }
}

/*
Below class uses predicate interface and startWith and endWith functions 
*/
class functionalComposition{
    Predicate<String> one = (text) -> {
        return text.startsWith("s");
    };
    Predicate<String> two = (text) -> {
        return text.endsWith("a");
    };
    Predicate<String> answer = one.and(two);

    String text = "shut up you more nea";

    boolean res = answer.test(text);
}