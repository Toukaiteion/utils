package com.hseea;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    public static void main(String[] args) {
        int [] a = {1, 3};
        List<String> list = new ArrayList<>();
        list.add(null);
        String[] word1 = new String[] {
            "ab", "c"
        };
        String[] word2 = new String[] {
                "a", "bc"
        };
        Iterator iterator = list.iterator();
        Observable
        System.out.println(arrayStringsAreEqual(word1, word2));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int arr1Index = 0;
        int arr2Index = 0;
        int arr1CharIndex = 0;
        int arr2CharIndex = 0;
        while(arr1Index<word1.length&&arr2Index<word2.length){
            if(word1[arr1Index].charAt(arr1CharIndex) != word2[arr2Index].charAt(arr2CharIndex)){
                return false;
            }
            arr2CharIndex++;
            arr1CharIndex++;
            if(arr1CharIndex>word1[arr1Index].length()-1){
                arr1Index++;
                arr1CharIndex=0;
            }
            if(arr2CharIndex>word2[arr2Index].length()-1){
                arr2Index++;
                arr2CharIndex=0;
            }
        }
        return arr1Index == word1.length && arr2Index == word2.length;
    }
}
