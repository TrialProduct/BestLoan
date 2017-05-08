package com.example;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("169.254.214.59", 8889);//IP地址是个字符串，端口号是个整数，这个端口号要跟前面你写的那个一样，还有IP地址，写你的机器的IP地址

            InputStream is = client.getInputStream();//这边的两个流跟上面服务器的差不多的作用
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            OutputStream os = client.getOutputStream();
            PrintStream ps = new PrintStream(os);
            Scanner scanner = new Scanner(System.in);
            boolean flag = true;
            while (flag)//这句话可以让客户端不停的说话
            {
                String s2 = scanner.nextLine();
                ps.println(s2);

                String s = bf.readLine();
                System.out.println(s);
            }

            client.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
