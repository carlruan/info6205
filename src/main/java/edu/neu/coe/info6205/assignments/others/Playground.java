package edu.neu.coe.info6205.assignments.others;

import java.util.Arrays;

public class Playground {


    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 10};
        Arrays.sort((arr));
        int n = arr.length;
        int max = arr[0];
        for(int i = 1; i < n; i++){
            if(max * 2 < arr[i]){
                System.out.println(2 * max);
                break;
            }else{
                max = 2 * Math.min(max, arr[i]);
            }
        }
        System.out.println(max);

    }
}
