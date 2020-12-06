package Internet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import java.net.URL;


import org.junit.Test;

public class URLTest {
    @Test
    public void URLT() throws IOException {
        URL url = new URL("http://127.0.0.1:8080/examples/index.jpg");
        HttpURLConnection op =(HttpURLConnection) url.openConnection();

        op.connect();

        InputStream in = op.getInputStream();

        FileOutputStream file = new FileOutputStream("/home/ubuntu/java/Internet/index.jpg");

        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) != -1) {
            file.write(buf,0,len);
        }

        file.close();
        in.close();
        op.disconnect();
    }
}
