import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=0;t<T;t++){
            int n=sc.nextInt();
            
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            System.out.println(findmincost(n,arr));
        }
    }
    private static int findmincost(int n,int[] arr){
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);        
        }
        int totalCost=0;
        while(pq.size()>1){
            int rod1=pq.poll();
            int rod2=pq.poll();
            int newrod=rod1+rod2;
            totalCost+=newrod;
            pq.add(newrod);
        }
        return totalCost;
        
    }
}