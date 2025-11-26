package cnlabexam;

import java.util.*;

public class Sixth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] A = new int[n][n];
        System.out.println("Enter adjacency matrix (999 for infinity):");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                A[i][j] = sc.nextInt();

        System.out.print("Enter source vertex: ");
        int s = sc.nextInt();

        int[] D = new int[n];
        Arrays.fill(D, 999);
        D[s] = 0;

        for (int k = 0; k < n - 1; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (D[i] + A[i][j] < D[j])
                        D[j] = D[i] + A[i][j];

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < n; i++)
        	System.out.println(s + " → " + i + " = " + D[i]);
}
}