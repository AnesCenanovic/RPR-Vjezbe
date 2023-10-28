package com.example.lv2z3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zadatak3{
    public static void main(String[] args) {
        List<Double> list= new ArrayList<>();
        Scanner myScanner= new Scanner(System.in);

        System.out.println("Unesite brojeve. Unesite stop za prekid unosa: ");

        while(true){
            String input = myScanner.next();
            if(input.equals("stop")){
                break;
            }

            try{
                double n=Double.parseDouble(input);
                list.add(n);
            }
            catch (NumberFormatException exception) {
                System.out.println("Nije unesen broj!");
            }
        }
        if(list.isEmpty()){
            System.out.println("Nema unesenih brojeva!");
        }
        else{
            double min = list.get(0);
            double max = list.get(0);
            double sum = 0;

            for(double i : list){

                if(i < min){
                    min = i;
                }

                if(i > max){
                    max = i;
                }

                sum += i;
            }

            double mean = sum/list.size();
            double v = 0;

            for(double i : list){
                v += Math.pow( i - mean , 2);
            }

            double devijacija = Math.sqrt( v / list.size());

            System.out.println("Min: " + min);
            System.out.println("Max: " + max);
            System.out.println("Average: " + mean);
            System.out.println("Devijacija: " + devijacija);
        }
    }
}
