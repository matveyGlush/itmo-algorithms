import java.util.Scanner;

public class Players1401 {
    static int num = 0;
    static int [][] matr1;

    static void wide(int lengh, int zerox, int zeroy, int startx, int starty){
        if (lengh==2){
            num++;
            if (zerox==startx && zeroy==starty){
                matr1[startx+1][starty]=num;
                matr1[startx+1][starty+1]=num;
                matr1[startx][starty+1]=num;
            }
            if (zerox==startx+1 && zeroy==starty){
                matr1[startx][starty]=num;
                matr1[startx+1][starty+1]=num;
                matr1[startx][starty+1]=num;
            }
            if (zerox==startx && zeroy==starty+1){
                matr1[startx][starty]=num;
                matr1[startx+1][starty+1]=num;
                matr1[startx+1][starty]=num;
            }
            if (zerox==startx+1 && zeroy==starty+1){
                matr1[startx][starty]=num;
                matr1[startx+1][starty]=num;
                matr1[startx][starty+1]=num;
            }
        }else{
            int leng=lengh/2;

            if (zerox<startx+leng && zeroy<starty+leng){
                num++;
                matr1[startx+leng][starty+leng-1]=num;
                matr1[startx+leng-1][starty+leng]=num;
                matr1[startx+leng][starty+leng]=num;
                wide(leng,zerox,zeroy, startx, starty);
                wide(leng,startx+leng,starty+leng-1, startx+leng,starty);
                wide(leng,startx+leng-1,starty+leng,startx,starty+leng);
                wide(leng,startx+leng,starty+leng,startx+leng,starty+leng);
            }else{
                if( zerox<startx+leng && zeroy>=starty+leng){
                    num++;
                    matr1[startx+leng][starty+leng-1]=num;
                    matr1[startx+leng-1][starty+leng-1]=num;
                    matr1[startx+leng][starty+leng]=num;
                    wide(leng,zerox,zeroy,startx,starty+leng);
                    wide(leng,startx+leng,starty+leng-1,startx+leng,starty);
                    wide(leng,startx+leng-1,starty+leng-1, startx,starty);
                    wide(leng,startx+leng,starty+leng,startx+leng,starty+leng);
                }else{
                    if( zerox>=startx+leng && zeroy<starty+leng){
                        num++;
                        matr1[startx+leng-1][starty+leng-1]=num;
                        matr1[startx+leng-1][starty+leng]=num;
                        matr1[startx+leng][starty+leng]=num;
                        wide(leng,zerox,zeroy, startx+leng,starty);
                        wide(leng,startx+leng-1,starty+leng-1, startx,starty);
                        wide(leng,startx+leng-1,starty+leng,startx,starty+leng);
                        wide(leng,startx+leng,starty+leng,startx+leng,starty+leng);
                    }else{
                        if( zerox>=startx+leng && zeroy>=starty+leng){
                            num++;
                            matr1[startx+leng][starty+leng-1]=num;
                            matr1[startx+leng-1][starty+leng-1]=num;
                            matr1[startx+leng-1][starty+leng]=num;
                            wide(leng,zerox,zeroy,startx+leng,starty+leng);
                            wide(leng,startx+leng,starty+leng-1,startx+leng,starty);
                            wide(leng,startx+leng-1,starty+leng-1, startx,starty);
                            wide(leng,startx+leng-1,starty+leng,startx,starty+leng);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int n,x,y,size;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        x = scanner.nextInt();
        y = scanner.nextInt();
        x=x-1;
        y=y-1;
        size= (int) Math.pow(2, n);
        matr1 = new int [size][size];
        for (int i = 0; i < size; i++)
            matr1[i] = new int[size];
        matr1[x][y]=0;
        wide(matr1.length,x,y,0,0);
        for(int i=0; i<size;i++){
            for(int j=0; j<size;j++){
                System.out.print(matr1[i][j] + " ");
            }
            System.out.println();
        }
    }
}
