/* 
 1. Java IO:
 Java IO is an api that is used to read and write data on streams, files, Pipes
 Network connections, in-memory buffers(array), System.in, System.out and System.error.
*/

import java.io.*;

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