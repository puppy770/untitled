package com.yang;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] w=new int[M];
        int[] v=new int[M];
        for (int i = 0; i < M; i++) {
            w[i]=sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            v[i]=sc.nextInt();
        }
        int[][] dp=new int[M][N+1];
        for(int i=0;i<=N;i++) {
            if(i>=w[0]) {
                dp[0][i]=v[0];
            }
        }
//        for (int i = w[0]; i <= N; i++) {
//            dp[0][i]=v[0];
//        }
        for(int i=1;i<M;i++) {
            for(int j=0;j<=N;j++) {
                dp[i][j]=dp[i-1][j];
                if(j-w[i]>=0) {
                    dp[i][j]=Math.max(dp[i][j],dp[i][j-w[i]]+v[i]);
                }
            }
        }
        System.out.println(dp[M-1][N]);

    }
}
