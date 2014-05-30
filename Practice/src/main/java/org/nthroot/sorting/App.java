package org.nthroot.sorting;

import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class App {

    public static void main(String[] args) {

        System.out.println("Welcome to Sorting!");

        if (args.length < 1) {
            System.err.println("Please specify test file");
            System.exit(1);
        }

        String inputFile = args[0];

        //int[] inputData = null;
        Integer[] inputData = null;
        try {
            //inputData = loadInts(inputFile);
            inputData = loadIntegers(inputFile);
        } catch (Exception e) {
            System.err.println("Failed to load input data");
            System.err.println(e.getMessage());
            System.exit(1);
        }

    /*
    for (int i = 0 ; i < inputData.length ; i++) {
      System.out.println(inputData[i]);
    }
    */

        if (QuickSort.isSorted(inputData)) {
            System.out.println("Array is sorted");
        } else {
            System.out.println("Array is not sorted");
        }

        //int[] outputData = MergeSort.sort(inputData);
        //Comparable[] outputData = MergeSort.sort(inputData);
        QuickSort.sort(inputData);

    /*
    for (int i = 0 ; i < outputData.length ; i++) {
      System.out.println(outputData[i]);
    }
    */

        if (QuickSort.isSorted(inputData)) {
            System.out.println("Array is sorted");
        } else {
            System.out.println("Array is not sorted");
        }

    }

    private static int[] loadInts(String filename) throws Exception {

        ArrayList arr = new ArrayList<Integer>();
        File file = new File(filename);
        BufferedReader reader = null;

        reader = new BufferedReader(new FileReader(file));
        String intext = null;

        try {
            while ((intext = reader.readLine()) != null) {
                arr.add(Integer.parseInt(intext));
            }
        } catch (Exception e) {
            System.err.println("Failed to parse int");
            throw (e);
        }

        reader.close();

        int result[] = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            Integer val = (Integer) arr.get(i);
            result[i] = val.intValue();
        }

        return result;
    }

    private static Integer[] loadIntegers(String filename) throws Exception {

        ArrayList arr = new ArrayList<Integer>();
        File file = new File(filename);
        BufferedReader reader = null;

        reader = new BufferedReader(new FileReader(file));
        String intext = null;

        try {
            while ((intext = reader.readLine()) != null) {
                arr.add(Integer.parseInt(intext));
            }
        } catch (Exception e) {
            System.err.println("Failed to parse int");
            throw (e);
        }

        reader.close();

        Integer[] result = (Integer[])arr.toArray(new Integer[arr.size()]);

        return result;
    }
}
