package cnlabexam;

import java.io.*;

class Fourth {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter number of data bits: ");
        int n = Integer.parseInt(br.readLine());
        int[] data = read(br, n, "Enter data bits:");

        System.out.print("Enter number of bits in divisor: ");
        int m = Integer.parseInt(br.readLine());
        int[] divisor = read(br, m, "Enter divisor bits:");

        int[] dividend = new int[n + m - 1];
        System.arraycopy(data, 0, dividend, 0, n);

        System.out.print("Dividend (after appending 0's): ");
        print(dividend);

        int[] remainder = divide(dividend.clone(), divisor);
        int[] crc = new int[m - 1];
        System.arraycopy(remainder, n, crc, 0, m - 1);

        System.out.print("\nCRC code: ");
        print(crc);

        int[] codeword = new int[n + m - 1];
        System.arraycopy(data, 0, codeword, 0, n);
        System.arraycopy(crc, 0, codeword, n, crc.length);

        System.out.print("\nFull codeword (data + CRC): ");
        print(codeword);

        System.out.print("\nEnter CRC code of " + (n + m - 1) + " bits: ");
        int[] recv = read(br, n + m - 1, null);

        boolean error = false;
        for (int bit : divide(recv.clone(), divisor))
            if (bit != 0) error = true;

        System.out.println(error ? "Error" : "No Error");
        System.out.println("THANK YOU.... :)");
    }

    static int[] divide(int[] a, int[] d) {
        for (int i = 0; i + d.length <= a.length; i++)
            if (a[i] == 1)
                for (int j = 0; j < d.length; j++)
                    a[i + j] ^= d[j];
        return a;
    }

    static int[] read(BufferedReader br, int n, String msg) throws Exception {
        if (msg != null) System.out.println(msg);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        return arr;
    }

    static void print(int[] a) {
        for (int x : a) System.out.print(x);
        System.out.println();
}
}
