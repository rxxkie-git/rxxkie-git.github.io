package cnlabexam;

import java.util.Scanner;

public class Tenth {

    static int min(int a, int b) {
        return (a < b) ? a : b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The Bucket Size");
        int cap = sc.nextInt();

        System.out.println("Enter The Operation Rate");
        int rate = sc.nextInt();

        System.out.println("Enter The No. Of Seconds You Want To Simulate");
        int n = sc.nextInt();

        int[] pkt = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter The Size Of The Packet Entering At " + (i + 1) + " sec : ");
            pkt[i] = sc.nextInt();
        }

        System.out.println("\nSecond | Packet Received | Packet Sent | Packet Left | Packet Dropped");
        System.out.println("---------------------------------------------------------------------");

        int left = 0;
        for (int i = 0; i < n; i++) {
            left += pkt[i];
            int drop = Math.max(0, left - cap);
            left = Math.min(left, cap);

            int sent = min(left, rate);
            left -= sent;

            System.out.println((i + 1) + "\t\t" + pkt[i] + "\t\t" + sent + "\t\t" + left + "\t\t" + drop);
        }

        int sec = n;
        while (left > 0) {
            sec++;
            int drop = Math.max(0, left - cap);
            left = Math.min(left, cap);

            int sent = min(left, rate);
            left -= sent;

            System.out.println(sec + "\t\t0\t\t" + sent + "\t\t" + left + "\t\t" + drop);
        }

        sc.close();
    }
}