import java.util.ArrayList;
import java.util.Scanner;
public class KingSolve {
    static ArrayList<String> caper = new ArrayList<>();
/*
8
- + - + - + - +
+ - + - + - + -
- + - K - + - +
+ - + - + - + -
- o - o - + - +
+ - K - + - + -
- o - + - + - +
+ - K - + - K -
*/
    public static void TourOnTable(char[][] table, int row, int col) {
        if((row-1 > 0 && col-1 > 0 && table[row-1][col-1] == 'o') && (row-2 > -1 && col-2 > -1 && table[row-2][col-2] == '+')) {
//				+  
//				  o  
//				    K
            table[row-2][col-2] = 'k';
//				System.out.println("1) go through here !!!");
            for(int i=0;i<table.length;i++) {
                for(int j=0;j<table.length;j++) {
                    System.out.print(table[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("------------------------------");
            //System.out.println(row-1+" "+(col-1));
            caper.add(row-1+" "+(col-1));
            TourOnTable(table, row-2, col-2);
        }
        if((row-1 > 0 && col+1 < table.length-1 && table[row-1][col+1] == 'o') && (row-2 > -1 && col+2 < table.length && table[row-2][col+2] == '+')) {
//				   +
//				 o
//			   K
            table[row-2][col+2] = 'k';
//				System.out.println("2) go through here !!!");
            for(int i=0;i<table.length;i++) {
                for(int j=0;j<table.length;j++) {
                    System.out.print(table[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("------------------------------");
            //System.out.println(row-1+" "+(col+3));
            caper.add(row-1+" "+(col+3));
            TourOnTable(table, row-2, col+2);
        }
        if((row+1 < table.length-1 && col+1 < table.length-1 && table[row+1][col+1] == 'o') && (row+2 < table.length && col+2 < table.length && table[row+2][col+2] == '+')) {
//			   K
//				 o
//				   +
            table[row+2][col+2] = 'k';
//				System.out.println("3) go through here !!!");
            for(int i=0;i<table.length;i++) {
                for(int j=0;j<table.length;j++) {
                    System.out.print(table[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("------------------------------");
            //System.out.println(row+3+" "+(col+3));
            caper.add(row+3+" "+(col+3));
            TourOnTable(table, row+2, col+2);
        }
        if((row+1 < table.length-1 && col-1 > 0 && table[row+1][col-1] == 'o') && (row+2 < table.length && col-2 > -1 && table[row+2][col-2] == '+')) {
//				  K
//			    o
//		      +	 
            table[row+2][col-2] = 'k';
//			    System.out.println("4) go through here !!!");
            for(int i=0;i<table.length;i++) {
                for(int j=0;j<table.length;j++) {
                    System.out.print(table[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("------------------------------");
            //System.out.println(row+1+" "+(col-1));
            caper.add(row+1+" "+(col-1));
            TourOnTable(table, row+2, col-2);
        }
        for(String ss : caper)
            System.out.println(ss);
        caper.clear();
    }
    public static void main(String[] args) {
        Scanner putin = new Scanner(System.in);
        int n = putin.nextInt();
        char[][] table = new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                table[i][j] = putin.next().charAt(0);

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(table[i][j] == 'K') {
                    TourOnTable(table, i, j);
                }
            }
        }
        putin.close();
    }
}