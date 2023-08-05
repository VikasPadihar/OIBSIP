import java.util.Scanner;

public class MainDriver{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GuessNumber gn = new GuessNumber();
        int num;
        System.out.println("Welcome\nYou can guess a number between 1 to 100\nYou are allowed only 10 attempts");
        System.out.println("Guess the number:");
        boolean check = false;
        //Take input until it will guess right or exceeds the limit
        while((check!=true)){               
            num = sc.nextInt();
            check = gn.guessNum(num);
        }
        sc.close();
        
        
    }
}