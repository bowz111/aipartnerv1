package com.hjx.aiservice;

import java.util.Scanner;

/**
 * @Author: 胡嘉鑫
 * @CreateTime: 2025-03-16
 * @Description:
 * @Version: 1.0
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] arr = input.split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        System.out.println(a);
        System.out.println(b);
        for (int i = 0;i<b;i++){
            String str = scanner.nextLine();
            System.out.println(str);
        }
    }
}
