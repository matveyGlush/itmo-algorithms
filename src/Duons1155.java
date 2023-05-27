import java.util.Scanner;

public class Duons1155 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();
        int f = scanner.nextInt();
        int g = scanner.nextInt();
        int h = scanner.nextInt();

        if((a+h+f+c)!=(b+g+e+d)){
            System.out.println("IMPOSSIBLE");;
        } else {
            for(int i=0; i<100;i++){
                if( a>0 && b>0){
                    System.out.println("AB-");
                    a--;
                    b--;
                }
                if( a>0 && d>0){
                    System.out.println("AD-");
                    a--;
                    d--;
                }
                if( a>0 && e>0){
                    System.out.println("AE-");
                    a--;
                    e--;
                }
                if( a>0 && g>0){
                    System.out.println("FB+");
                    System.out.println("FG-");
                    System.out.println("AB-");
                    a--;
                    g--;
                }

                if( h>0 && e>0){
                    System.out.println("HE-");
                    h--;
                    e--;
                }
                if ( h>0 && d>0){
                    System.out.println("HD-");
                    h--;
                    d--;
                }
                if ( h>0 && g>0){
                    System.out.println("HG-");
                    h--;
                    g--;
                }
                if ( h>0 && b>0){
                    System.out.println("FG+");
                    System.out.println("HG-");
                    System.out.println("FB-");
                    h--;
                    b--;
                }

                if ( f>0 && b>0){
                    System.out.println("FB-");
                    f--;
                    b--;
                }
                if ( f>0 && g>0){
                    System.out.println("FG-");
                    f--;
                    g--;
                }
                if ( f>0 && e>0){
                    System.out.println("FE-");
                    f--;
                    e--;
                }
                if ( f>0 && d>0){
                    System.out.println("HG+");
                    System.out.println("HD-");
                    System.out.println("FG-");
                    f--;
                    d--;
                }

                if ( c>0 && b>0){
                    System.out.println("CB-");
                    c--;
                    b--;
                }
                if ( c>0 && d>0){
                    System.out.println("CD-");
                    c--;
                    d--;
                }
                if ( c>0 && g>0){
                    System.out.println("CG-");
                    c--;
                    g--;
                }
                if ( c>0 && e>0){
                    System.out.println("HG+");
                    System.out.println("EH-");
                    System.out.println("CG-");
                    c--;
                    e--;
                }}
        }
    }
}
