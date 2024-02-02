import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();    
        int B = sc.nextInt();    
        int C = sc.nextInt();   

        B = A * 60 + B;
        B = B + C;

        A = (B / 60) % 24;      
        int min = B % 60;       

        System.out.println(A + " " + min);

    }
}