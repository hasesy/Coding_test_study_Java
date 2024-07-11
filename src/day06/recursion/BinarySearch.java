package day06.recursion;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] n = { 38102, 4, 7, 2, 0, 18, 2098, 582 };
        Arrays.sort(n);

        int index = binarySearch(n, 29, 0, n.length - 1);
        System.out.println("index = " + index);
    }

    static int binarySearch(int[] n, int target, int l, int r) {
        if (r < l) return -1;
        int mid = (l + r) / 2;
        if (target == n[mid]) return mid;
        else if (target < n[mid]) return binarySearch(n, target, l, mid - 1);
        else return binarySearch(n, target, mid + 1, r);
    }
}

// 나중