package Internet;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientt {
    public static void main(String[] args) throws IOException {
        client1();
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

    public static void client1() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);

        OutputStream output = socket.getOutputStream();

        FileInputStream file = new FileInputStream("/home/ubuntu/java/IO_file/data1.txt");

        byte[] buf = new byte[20];
        int len;
        while ((len = file.read(buf)) != -1) {
            output.write(buf,0,len);
        }
        socket.shutdownOutput();
        
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf1 = new byte[20];
        while ((len = inputStream.read(buf1)) != -1) {
            baos.write(buf1, 0, len);
        }
        
        System.out.println(baos.toString());
        file.close();
        output.close();
        socket.close();
        baos.close();

    }

    public static void client2() {
        
    }
    
}
