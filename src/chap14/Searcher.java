package chap14;

import java.util.ArrayList;

public class Searcher {

    /**
     * Haystack is unordered (order not guaranteed)
     * 
     * @param needle - what we are looking for
     * @param haystack - the data structure we are searching
     * @return the index within haystack if found otherwise -1
     */
    public static int findFirst(int needle, int haystack[]) {
        for (int i=0; i<haystack.length; i++) {
            if (needle==haystack[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Haystack is unordered (order not guaranteed)
     * 
     * @param needle - what we are looking for
     * @param haystack - the data structure we are searching
     * @return an array of indices within haystack if found otherwise an empty array
     */
    public static int[] findAll(int needle, int haystack[]) {
        ArrayList<Integer> hits = new ArrayList<>();
        for (int i=0; i<haystack.length; i++) {
            if (needle==haystack[i]) {
                 hits.add(i);
            }
        }
        Integer retval[] = (Integer[]) hits.toArray();
        return java.util.Arrays.stream(retval)
        .mapToInt(Integer::intValue)
        .toArray();
    }

    /**
     * Haystack is in ascending order
     * 
     * @param needle - what we are looking for
     * @param haystack - the data structure we are searching (must be sorted in ascending order)
     * @return the index within haystack if found otherwise -1
     */
    public static int bfindFirst(int needle, int haystack[]) {
        return bfindFirst(0, haystack.length, needle, haystack);
    }

    // i - inclusive, the start of where we are searching
    // j - exclusive, the end of where we are searching
    public static int bfindFirst(int i, int j, int needle, int haystack[]) {
        if (i==j-1) {
            if (haystack[i]==needle) {
                // we got it on the last chance!
                return i;
            } else {
                // too bad, not found
                return -1;
            }
        }
        int themiddle = (j-i) / 2;
        if (haystack[themiddle] == needle) {
            return themiddle;
        } else if (needle < haystack[themiddle]) {
            return bfindFirst(i, themiddle, needle, haystack);
        } else {
            return bfindFirst(themiddle, j, needle, haystack);
        }
    }

}
