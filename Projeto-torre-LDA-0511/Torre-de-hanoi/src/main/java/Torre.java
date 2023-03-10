/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author diego
 */
public class Torre {
    public static void main(String[] args) 
    {
        int n = 0;
        Scanner Discos = new Scanner(System.in);
        
        while (n < 1) 
        {
            
                 System.out.println("Digite o numero de discos:");
                 n = Discos.nextInt();
                    
                if(n == 0  || n < 0){
                    System.out.println("Só são aceitos números maiores que 0");
                    Discos.nextLine();
                } 
            }
        valorInicial(n);
    }

    static String[] A;
    static String[] B;
    static String[] C;
    static int aux = 0;
    static int discoAtual = 0;
    
     public static void valorInicial(int n) 
     {
         A = new String[n];
         B = new String[n];
         C = new String[n];
         discoAtual = n;
         for (int i = 0; i < n; i++) 
         {
             A[i] = "" + (i + 1);
             B[i] = "";
             C[i] = "";
         }
         
         exibirTorre();
         movimentos(n, A, B, C);
     }
     
     public static void exibirTorre() 
     {
         if (aux != 0 && aux <= (Math.pow(2, discoAtual) - 1)) 
         {
             System.out.println("\nMovimento:  " + aux);
         } else 
         {
             System.out.println("\n");
         }
         for (int i = 0; i < A.length; i++) 
         {
             System.out.printf("%-3s | %-3s | %-3s\n", A[i] , B[i], C[i]);
         //System.out.printf("  "+A[i]+"  |  "+B[i]+"  |  "+C[i] + "\n");
     }
     aux++;
     System.out.println("______________");
     System.out.printf("%-3s | %-3s | %-3s\n", "A", "B", "C");
     
    }
     
    public static void movimentos(int n, String[] A, String[] B, String[] C) 
    {
        String disco = "";
        if (n > 0) 
        {
            movimentos(n - 1, A, C, B);
            disco = mudarDisco(A, C, n);
            exibirTorre();
            movimentos(n - 1, B, A, C);
        }
    }
    
    public static String mudarDisco(String[] orig, String[] dest, int n) 
    {
        String disco = "";
        
        for (int i = 0; i <  orig.length; i++) 
        {
            disco = "" + n;
            if (orig[i] != null && orig[i].equalsIgnoreCase(disco)) 
            {
                orig[i] = "";
                dest[i] = disco;
                break;
            }
        }
        return disco;
    }
}
