package DSA.algorithms_Cracking;

public class A15OneAway {
    boolean oneEditAway(String a, String b){
        if (Math.abs(a.length() - b.length()) > 1)
            return false;
        String A = a.length() < b.length() ? a : b; // shorter
        String B = a.length() < b.length() ? b : a; // longer

        int i = 0, j = 0;
        boolean foundDifference = false;
        while(i < A.length() && j < B.length()){
            if (A.charAt(i) != B.charAt(j)){
                if (foundDifference)
                    return false;
                foundDifference = true;
                // replace
                if (a.length() == b.length()){
                    i++;
                    j++;
                }
                // insert or remove
                else{
                    j++; // move longer one
                }
            }else{
                i++;
                j++;
            }
        }
        return true;
    }
}
