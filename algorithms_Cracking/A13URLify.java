package DSA.algorithms_Cracking;

public class A13URLify {
    void replaceSpaces(char[] str, int trueLength){
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' '){
                spaceCount++;
            }
        }

        int index = trueLength + spaceCount * 2;
        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' '){
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            }else{
                str[index - 1] = str[i];
                index--;
            }
        }
    }
}
