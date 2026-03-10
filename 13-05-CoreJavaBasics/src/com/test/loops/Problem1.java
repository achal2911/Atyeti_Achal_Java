package com.test.loops;
/*String str1="JAVA";
    String str2="DEMO"
    Output1->JDAEVMAO;
    Output2->JOAMVEAD*/

public class Problem1 {


    public static void main(String[] args) {
        String str1 = "JAVA";
        int l1 = str1.length();
        String str2 = "DEMO";
        int l2 = str2.length();

        StringBuilder output1 = new StringBuilder();
        StringBuilder output2=new StringBuilder();
        int i = 0, j = l2;

        while (i < l1 && j <= l2) {
            output2.append(str1.charAt(i));
            output2.append(str2.charAt(j - 1));

            i++;
            j--;

        }

        int k = 0, m = 0;

        while (k < l1 && m< l2) {
            output1.append(str1.charAt(k));
            output1.append(str2.charAt(m));

            k++;
            m++;

        }

        System.out.println(output1);
        System.out.println(output2);
    }

}
