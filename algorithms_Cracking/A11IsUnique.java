package DSA.algorithms_Cracking;

public class A11IsUnique {
    public boolean isUniqueChars(String str){
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]){
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    public boolean isUniqueChars_bit(String str){
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0){
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}
