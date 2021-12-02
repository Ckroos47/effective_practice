package practice;

import java.io.*;

/**
 * @description: 使用try-with-resources替代try-finally
 * 在处理必须关闭的资源时，使用 try-with-resources 语句替代 try-finally 语句。
 * 生成的代码更简洁，更 清晰，并且生成的异常更有用。
 * @author: chenmo
 * @email: xyisbenben@aliyun.com
 * @date: 2021/12/2 4:52 下午
 */
public class Practice09 {
    // try-with-resources - the the best way to close resources!
    static String firstLineOfFile(String path) throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }
    // try-with-resources on multiple resources - short and sweet
    static void copy(String src,String dst) throws IOException{
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)){
            byte[] buf = new byte[10];
            int n;
            while ((n = in.read(buf))>= 0)
                out.write(buf,0,n);
        }
    }

    // try-with-resources with a catch clause
    static String firstLineOfFile(String path, String defaultVal) {
        try (BufferedReader br = new BufferedReader(
                new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return defaultVal;
        }
    }
}

