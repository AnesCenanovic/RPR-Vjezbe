package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
            Scanner myScanner=new Scanner(System.in);
            System.out.println("Unesite n: ");
            int m=myScanner.nextInt();
        System.out.println("Sinus n: " + Math.sin(m));
        System.out.println("Faktorijel n: " + faktorijel(m));
        }
    public static long faktorijel(int n) {
        long fakt = 1;
        for (int i = 2; i <= n; i++) {
            fakt = fakt * i;
        }
        return fakt;
    }
}