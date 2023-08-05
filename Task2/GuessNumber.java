import java.util.Random;

class GuessNumber {
    private int guessN;
    int attempts;
    GuessNumber(){
        Random random = new Random();
        guessN = random.nextInt(100);
        attempts = 0;
    }
    public int getguessN(){
        return guessN;
    }
    public boolean guessNum(int num){
        attempts++;
        if(attempts>=10){
            System.out.println("SORRY, YOU FAILED, YOU CAN'T EXCEED MORE THAN 10");
            return true;
        }
        if(num==guessN){
            System.out.println("Congratulations, You guessed it,it is "+ getguessN());
            System.out.println("The number of attempts are"+" "+attempts);
            System.out.println("Your score is "+(10-attempts+1));
            return true;
        }else if(num<guessN){
            System.out.println("You have entered a small number.\nTry again!!!");
            return false;
        }else{
            System.out.println("You have entered a large number.\nTry again!!!");
            return false;
        }

    }
}
