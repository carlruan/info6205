package edu.neu.coe.info6205.assignments.benchmark;

import edu.neu.coe.info6205.sort.elementary.InsertionSort;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.Arrays;

public class InsertionSortBenchmark {


    static Integer[] testArray;

    public static void test(int n){
        System.out.println("");
        System.out.print(n + " numbers in Array-------------------------------------------------------------------------------------------------");
        System.out.println("");
        testArray = new Integer[n];
        for(int i = 0; i < n; i++){
            testArray[i] = (int)(Math.random()*100);
        }
        Integer[] backup = new Integer[n];
        for(int i = 0; i < n; i++){
            backup[i] = testArray[i];
        }

        random(testArray);

        ordered(testArray);

        partiallyOrdered(backup);

        reversed(testArray);

    }


    public static void random(Integer[] arr){

        for(int i = 0; i < 10; i++){
            edu.neu.coe.info6205.sort.elementary.InsertionSort.sort(arr);
        }

        Benchmark_Timer benchmark_timer = new Benchmark_Timer("random test:", null , (t)-> edu.neu.coe.info6205.sort.elementary.InsertionSort.sort(arr), null );
        System.out.println(benchmark_timer.run(true , 100));
    }

    public static void ordered(Integer[] arr){
        Arrays.sort(arr);
        for(int i = 0; i < 10; i++){
            edu.neu.coe.info6205.sort.elementary.InsertionSort.sort(arr);
        }

        Benchmark_Timer benchmark_timer = new Benchmark_Timer("orderd test:", null, (t)-> edu.neu.coe.info6205.sort.elementary.InsertionSort.sort(arr), null );
        System.out.println(benchmark_timer.run(true , 100));

    }


    public static void partiallyOrdered(Integer[] arr){

        Arrays.sort(arr, 0, arr.length / 2);
        for(int i = 0; i < 10; i++){
            edu.neu.coe.info6205.sort.elementary.InsertionSort.sort(arr);
        }


        Benchmark_Timer benchmark_timer = new Benchmark_Timer("partially orderd test:", null, (t)-> edu.neu.coe.info6205.sort.elementary.InsertionSort.sort(arr), null );
        System.out.println(benchmark_timer.run(true , 100));

    }

    public static void reversed(Integer[] arr){
        Arrays.sort(arr);
        reverse(arr);
        for(int i = 0; i < 10; i++){
            edu.neu.coe.info6205.sort.elementary.InsertionSort.sort(arr);
        }

        Benchmark_Timer benchmark_timer = new Benchmark_Timer("reverse test:", null, (t)-> InsertionSort.sort(arr), null );
        System.out.println(benchmark_timer.run(true , 100));
    }

    public static void reverse(Integer[] arr){
        int l = 0, r = arr.length - 1;
        while(l < r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            r--;
            l++;
        }
    }

    public static void main(String[] args) {

        for(int i = 100; i < 20000; i*=2){
            test(i);
        }

    }

}
