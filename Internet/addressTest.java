package Internet;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;



public class addressTest {
    public static void main(String[] args) {
        // service();
        client();
        // try {
        //     InetAddress byName = InetAddress.getByName("192.168.31.1");
        //     System.out.println(byName);
        //     InetAddress byName2 = InetAddress.getByName("www.google.com");
        //     System.out.println(byName2);

        //     InetAddress byName3 = InetAddress.getByName("127.0.0.1");
        //     System.out.println(byName3);

        //     InetAddress localHost = InetAddress.getLocalHost();
        //     System.out.println(localHost);

        //     System.out.println(byName2.getHostAddress());
        //     System.out.println(byName2.getHostName());
        // } catch (UnknownHostException e) {
        
        //     e.printStackTrace();
        // }
    }

    // @Test
    public static void client() {
        OutputStream outputStream= null;
        Socket socket = null;
        try {
            InetAddress byName = InetAddress.getByName("127.0.0.1");

            socket = new Socket(byName, 8899);
            outputStream = socket.getOutputStream();
            outputStream.write("客户端".getBytes());

        } catch (UnknownHostException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }finally{
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void service() {
        ServerSocket server = null;
        Socket socket = null;
        InputStream input = null;
        ByteArrayOutputStream baos = null;
        try {
            server = new ServerSocket(8899);
            socket = server.accept();
            input = socket.getInputStream();
            byte[] buf = new byte[5];
            int len;
            // while ((len = input.read(buf)) != -1) {
            //     String str = new String(buf,0,len);
            //     System.out.println(str);    
            // }
            baos = new ByteArrayOutputStream();
            while ((len = input.read(buf)) != -1) {
                baos.write(buf, 0, len);
            }

            System.out.println(baos.toString());
            System.out.println("收到" + socket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            
            e.printStackTrace();
        }finally{
            if(baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
            }
            if(input != null){
                try {
                    input.close();
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
            }
            if(server != null){
                try {
                    server.close();
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
            }
        }
        
    }


    @Test
    public void client1() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);

        OutputStream output = socket.getOutputStream();

        FileInputStream file = new FileInputStream("/home/ubuntu/java/IO_file/data1.txt");

        byte[] buf = new byte[20];
        int len;
        while ((len = file.read(buf)) != -1) {
            output.write(buf,0,len);
        }

        file.close();
        output.close();
        socket.close();
    }

    @Test
    public void server1() throws IOException {
        ServerSocket s = new ServerSocket(9090);
        Socket accept = s.accept();
        InputStream in = accept.getInputStream();
        FileOutputStream file = new FileOutputStream(new File("/home/ubuntu/java/Internet/da.txt"));

        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) != -1) {
            file.write(buf,0,len);
        }

        OutputStream os = accept.getOutputStream();
        os.write("nihao".getBytes());

        file.close();
        in.close();
        accept.close();
        s.close();
    }
}


