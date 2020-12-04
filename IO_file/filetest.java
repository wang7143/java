package IO_file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;


import org.junit.Test;

public class filetest {

    @Test
    public void test() throws IOException {
        DataOutputStream data = new DataOutputStream(new FileOutputStream("/home/ubuntu/java/IO_file/data.txt"));
        data.writeUTF("liu");
        data.flush();
        data.writeInt(23);
        data.writeBoolean(true);
        data.close();
    }


    @Test
    public void test4() throws IOException {
        DataInputStream data = new DataInputStream(new FileInputStream("/home/ubuntu/java/IO_file/data.txt"));
        String name = data.readUTF();
        int age = data.readInt();
        boolean l = data.readBoolean();

        FileWriter fileWriter = new FileWriter("/home/ubuntu/java/IO_file/data1.txt");
        if(name.equals("liu")){
            name = "wang";
        }
        fileWriter.write(name);
        
        fileWriter.append(String.valueOf(age));
        fileWriter.close();
        data.close();
    }
}
