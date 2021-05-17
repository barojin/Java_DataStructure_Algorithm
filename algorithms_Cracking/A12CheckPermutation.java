package DSA.algorithms_Cracking;

import java.util.Arrays;

public class A12CheckPermutation {
    String sort(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public boolean permutation(String s, String t){
        if (s.length() != t.length())
            return false;
        return sort(s).equals(sort(t));
    }

    // Check if the two strings have identical character counts
    public boolean permutation2(String s, String t){
        if (s.length() != t.length())
            return false;

        int[] letters = new int[128]; // Assumption

        char[] s_array = s.toCharArray();
        for (char c : s_array)
            letters[c]++;

        for (int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i); // ASCIIcode
            letters[c]--;
            if (letters[c] < 0)
                return false;
        }
        return true;
    }
}
