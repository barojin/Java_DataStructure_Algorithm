package DSA.algorithms_Cracking;

public class A14IsPermutationPalindrome {
    /*
     * 001000 - 1 = 000111
     * 001000 & 000111 = 0
     * */
    boolean isPermutationOfPalindrome_bit(String phrase){
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    private boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    private int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()){
            int x = getCharNumberIgnoreCase(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    private int toggle(int bitVector, int idx) {
        if (idx < 0) return bitVector;
        int mask = 1 << idx;

        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else{
            bitVector &= ~mask;
        }
        return bitVector;
    }

    boolean isPermutationOfPalindrome(String phrase){
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    private int getCharNumberIgnoreCase(Character c){
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z)
            return val - a;
        return -1;
    }
    private int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c: phrase.toCharArray()){
            int x = getCharNumberIgnoreCase(c);
            if (x != -1)
                table[x]++;
        }
        return table;
    }

    private boolean checkMaxOneOdd(int[] table){
        boolean foundOdd = false;
        for (int count: table){
            if (count % 2 == 1){
                if (foundOdd){
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

}
