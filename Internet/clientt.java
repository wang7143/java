package Internet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientt {
    public static void main(String[] args) {
        client();
    }
    public static void client() {
        OutputStream outputStream= null;
        Socket socket = null;
        try {
            InetAddress byName = InetAddress.getByName("127.0.0.1");

            socket = new Socket(byName, 8899);
            outputStream = socket.getOutputStream();
            outputStream.write("客户端".getBytes());

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
