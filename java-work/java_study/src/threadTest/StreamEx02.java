package threadTest;

import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamEx02 {
    public static void main(String[] args) {
        InputStream in = System.in; // 키보드 입력
        InputStreamReader ir = new InputStreamReader(in);

        try {
            char[] data = new char[10];
            ir.read(data);
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//InputStreamReader는 기본적으로 InputStream을 배열로 받음