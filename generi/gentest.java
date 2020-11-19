package generi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;

public class gentest {
    
    @Test
    public void test1() {
        ArrayList<Integer> foo = new ArrayList();
        foo.add(78);
        foo.add(88);
        foo.add(58);
        foo.add(48);

        // foo.add("tom");

        // for (Integer score : foo) {
        //     int s = score;
        //     System.out.println(s);
        // }

        Iterator<Integer> iterator = foo.iterator();
        while (iterator.hasNext()) {
            int stu = iterator.next();
            System.out.println(stu);
        }
    }

    @Test
    public void test2() {
        Map<String,Integer> map = new HashMap<String,Integer>();

        map.put("Tom", 97);
        map.put("jeck", 12);
        map.put("jerry", 87);

        Set<Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Entry<String, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key + "-----" + value); 
        }
    }
}
