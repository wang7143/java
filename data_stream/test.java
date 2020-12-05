package data_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

import org.junit.Test;

public class test {
    @Test
    public void testObjectStream() {
        ObjectOutputStream object = null;
        try {
            object = new ObjectOutputStream(new FileOutputStream("/home/ubuntu/java/data_stream/obt.dat"));
            object.writeObject(new Person("wang", 15));
            object.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } finally {
            if (object != null) {
                try {
                    object.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testObjectInputStream() {
        ObjectInputStream ob = null;
        try {
            ob = new ObjectInputStream(new FileInputStream("/home/ubuntu/java/data_stream/obt.dat"));
            // Object obj = ob.readObject();
            // String str = (String) obj;
            Person p = (Person) ob.readObject();
            System.out.println(p);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (ob != null) {
                try {
                    ob.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test7() {
        RandomAccessFile random = null;
        RandomAccessFile random1 = null;
        try {
            random = new RandomAccessFile(new File("/home/ubuntu/java/data_stream/obt.dat"), "r");
            random1 = new RandomAccessFile(new File("/home/ubuntu/java/data_stream/obt1.dat"), "rw");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = random.read(buffer)) != -1) {
                random1.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }finally{
            if (random != null) {
                try {
                    random.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (random1 != null) {
                try {
                    random1.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void test9() throws IOException {
        RandomAccessFile rand = new RandomAccessFile("/home/ubuntu/java/data_stream/aa.txt", "rw");

        rand.seek(3);
        rand.write("ttt".getBytes());

        rand.close();
    }



    @Test
    public void test6() throws IOException {
        RandomAccessFile rand = new RandomAccessFile("/home/ubuntu/java/data_stream/aa.txt", "rw");

        rand.seek(3);

        StringBuilder buf = new StringBuilder((int) new File("/home/ubuntu/java/data_stream/aa.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while ((len = rand.read(buffer)) != -1) {
             buf.append(new String(buffer,0,len));
        }

        rand.seek(3);
        rand.write("xyz".getBytes());

        rand.write(buf.toString().getBytes());

        rand.close();
    }
}
