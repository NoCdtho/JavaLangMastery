/* 
 1. Java IO:
 Java IO is an api that is used to read and write data on streams, files, Pipes
 Network connections, in-memory buffers(array), System.in, System.out and System.error.

*/
import java.io.Reader;
import java.io.FileReader;


public class Topics5 {
    public static void main(String[] args){
        try{
            read rd = new read();
            System.out.println(rd.a);
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