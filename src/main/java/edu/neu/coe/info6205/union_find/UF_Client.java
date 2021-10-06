package edu.neu.coe.info6205.union_find;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UF_Client {

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();


        for(int i = 5; i <= 100000; i *= 2){
            System.out.print("Number of Nodes: " + i);

            int sum = 0;
            for(int j = 0; j < 10; j++){
                sum += count(i);
            }
            double avg = sum / 10;

            double estimated = (i /2.0) * Math.log(i);
            System.out.println(" | Number of pairs :" + avg + " | estimated: " + estimated);
        }

    }

    public static boolean connected(UF_HWQUPC uf, int maxHeight) {
        for(int h : uf.getHeight()){
            if(h == maxHeight){
                return true;
            }
        }
        return false;
    }

    public static int count(int n){
        UF_HWQUPC uf = new UF_HWQUPC(n);
        Random random = new Random();
        int res = 0;
        while(!connected(uf, n)){
            res++;
            int from = random.nextInt(n), to = random.nextInt(n);
            if(uf.connected(from, to)){
                continue;
            }
            uf.union(from, to);
        }
        return res;

    }

}
