import java.util.*;
public class MyClass {
    static String str1 = "send", str2 = "more", str3 = "money";
    static boolean[] isNumUsed = new boolean[10];
    static HashMap<Character, Integer> map = new HashMap<>();
    public static void crypto() {
        String str = str1 + str2 + str3;
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }

        str = "";
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                str += (char) (i + 'a');
        }

        if (str.length() > 10)
            return;
            
        System.out.println(crypto(str, 0));
    }
    public static int getSum(String str){
        String sum = "";
        for(int i = 0; i < str.length(); i++)
            sum += map.get(str.charAt(i));
        return Integer.parseInt(sum);
    }

    public static boolean check(String str){
        return (map.get(str.charAt(0)) == 0); 
    }

    public static int crypto(String str, int idx) {
        if (idx == str.length()) {
            if(check(str1) || check(str2) || check(str3))
                return 0;
            if (getSum(str1) + getSum(str2) == getSum(str3)) {
                for(int i = 0; i < str.length(); i++){
                    System.out.print(str.charAt(i) + "->" + map.get(str.charAt(i)) + " ");
                }
                System.out.println();
                return 1;
            }

            return 0;
        }

        int count = 0;
        for (int num = 0; num <= 9; num++) {
            if (!isNumUsed[num]) {
                isNumUsed[num] = true;
                map.put(str.charAt(idx), num);
                count += crypto(str, idx + 1);
                map.put(str.charAt(idx), -1);
                isNumUsed[num] = false;
            }

        }

        return count;
    }


    public static void main(String args[]) {
        crypto();
      
    }
}
