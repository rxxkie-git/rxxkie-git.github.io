package cnlabexam;

import java.util.*;

public class Ninth {
    static int g(int a,int b){return b==0?a:g(b,a%b);}

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);

        System.out.print("Message: ");
        String m=s.nextLine();

        System.out.print("p q: ");
        int p=s.nextInt(), q=s.nextInt();

        int n=p*q, phi=(p-1)*(q-1), e=2;
        while(e<phi && g(e,phi)!=1) e++;

        int d=2; 
        while((d*e)%phi!=1) d++;

        int[] enc=new int[m.length()], dec=new int[m.length()];

        for(int i=0;i<m.length();i++)
            enc[i]=(m.charAt(i)-96+e)%n;

        System.out.println("\nEncrypted:");
        for(int x:enc) System.out.print(x+""+(char)(x+96));

        for(int i=0;i<m.length();i++)
            dec[i]=(enc[i]-e+n)%n;

        System.out.println("\nDecrypted:");
        for(int x:dec) System.out.print((char)(x+96));
}
}