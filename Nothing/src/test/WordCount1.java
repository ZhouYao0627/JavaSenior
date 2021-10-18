package test;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 @author：ZhouYao
 @create：2021-10-18 19:08
 */
public class WordCount1 {

    @Test
    public void test() throws IOException {

        HashMap<Character, Integer> map = new HashMap<>();

        FileReader fr = new FileReader("dbcp.txt");

        int c = 0;
        while ((c = fr.read()) != -1) {
            char ch = (char) c;
            if (map.get(ch) == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("count.txt"));

        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();

        for (Map.Entry<Character, Integer> entry : entrySet) {
            switch (entry.getKey()) {
                case ' ':
                    bw.write("空格=" + entry.getValue());
                    break;
                case '\t': // \t表示tab 键字符
                    bw.write("tab键=" + entry.getValue());
                    break;
                case '\r': //
                    bw.write("回车=" + entry.getValue());
                    break;
                case '\n': //
                    bw.write("换行=" + entry.getValue());
                    break;
                default:
                    bw.write(entry.getKey() + "=" + entry.getValue());
                    break;
            }
            bw.newLine();
        }

        bw.close();
        fr.close();
    }
}
