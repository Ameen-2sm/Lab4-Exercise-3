
//TCPServer.jav code

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
 //initialize socket and input stream
 private Socket socket = null;
 private ServerSocket server = null;

 // constructor with port
 public TCPServer(int port)
 {
     // starts server and waits for a connection
     try
     {
         server = new ServerSocket(port);
         System.out.println("Server started");

         System.out.println("Waiting for a client ...");

         socket = server.accept();
         System.out.println("Client accepted");

         OutputStream outputStream = socket.getOutputStream();

         InputStream inputStream = socket.getInputStream();

         ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

         String receivedData = objectInputStream.readObject().toString();

         outputStream.write(receivedData.length());

         System.out.println("Closing connection");

         // close connection
         socket.close();
     }
     catch(IOException | ClassNotFoundException i)
     {
         System.out.println(i);
     }
 }

 public static void main(String args[])
 {
     TCPServer server = new TCPServer(3344);
 }
}
