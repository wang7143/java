package data_stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class test {
    @Test
    public void testObjectStream() {
        ObjectOutputStream object = null;
        try {
            object = new ObjectOutputStream(new FileOutputStream("/home/ubuntu/java/data_stream/obt.dat"));
            object.writeObject(new String("aaaaaaaaa"));
            object.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        } finally{
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
}
