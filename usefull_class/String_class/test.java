package usefull_class.String_class;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.Test;

public class test {

    @Test
    public void test1() {
        String s1 = "abc";
        String s2 = "abc";

        try {
            byte[] gbks = s1.getBytes("gbk");//使用啊
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int a = 132;
        System.out.println(s1 == s2);

        String b = String.valueOf(a);
        System.out.println(b);
    }

    
    public static String[] find(String str1, String str2) {
        if (str1 != null && str2 != null){
            StringBuffer s = new StringBuffer();
            String maxString = (str1.length() > str2.length()) ? str1 : str2;
            String minString = (str1.length() > str2.length()) ? str2 : str1;

            int len = minString.length();
            for (int i = 0; i < len; i++){
                for (int x = 0, y = len - i; y <= len; x++,y++){
                    String sub = minString.substring(x,y);
                    if(maxString.contains(sub)){
                        s.append(sub + ",");
                    }
                }

                if(s.length() != 0){
                    break;
                }
            }
            String[] split = s.toString().replaceAll(",$", "").split("\\,");
            return split;
        }
        return null;
    }

    public static void main(String[] args) {
        String str1 = "abcwerthelloyuiodefabcdef";
        String str2 = "cvhellobnmcdef";
        String[] str3 = find(str1, str2);
        System.out.println(Arrays.toString(str3));
    }
}


