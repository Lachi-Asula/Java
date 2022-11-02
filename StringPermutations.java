import java.util.Scanner;

public class StringPermutations {

    public void permStr(String str,String str2) {
        if(str.length() == 0) {
            System.out.println(str2);
        }
        for(int i = 0;i < str.length(); i++) {
            char c = str.charAt(i);
            String perm = str2 + c;
            String res = str.substring(0,i) + str.substring(i + 1);
            permStr(res, perm);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any String");
        String str = sc.next();
        StringPermutations p = new StringPermutations();
        p.permStr(str,"");
    }

}