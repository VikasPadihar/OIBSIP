import java.util.*;

public class OnlineExam {
	private String username;
	private String password;
	private boolean isLoggedIn;
	private int timeRemain;
	private int questionTot;
	private int[] userAns;
	private int[] correctAns;

	public OnlineExam(String username, String password) {
		this.username = username;
		this.password = password;
		System.out.println("You are registered Sucessfully !");
		this.isLoggedIn = false;
        //Total time in minutes for the quiz or exam
		this.timeRemain = 10;
        //Total number of questions
		this.questionTot = 10;
		this.userAns = new int[questionTot];
		this.correctAns = new int[questionTot];
		// initialize correct answers with random values (0 or 1)
		for (int i = 0; i < questionTot; i++) {
			correctAns[i] = (int) Math.round(Math.random());
		}
	}

	public void login() {
		System.out.println("Log in to give the Exam ");
		Scanner sc = new Scanner(System.in);
        boolean check = false;
        while(!check){
            System.out.print("Username: ");
            String inputUsername = sc.nextLine();
            System.out.print("Password: ");
            String inputPassword = sc.nextLine();
            if (inputUsername.equals(username) && inputPassword.equals(password)) {
                check = true;
                isLoggedIn = true;
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed!!! Please try again.");
            }
        }
	}

	public void logout() {
		isLoggedIn = false;
		System.out.println("Logout successful.");
	}

	public void startExam() {
		if (!isLoggedIn) {
			System.out.println("Please login first.");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("You have " + timeRemain + " minutes to complete the exam.");
		for (int i = 0; i < questionTot; i++) {
			System.out.println("Question " + (i + 1) + ":");
			System.out.println("1. Option 1");
			System.out.println("2. Option 2");
            System.out.println("3. Option 3");
            System.out.println("4. Option 4");
			System.out.print("Your answer (1, 2, 3 or 4): ");
            boolean check = false;
            while(!check){
                int answer = sc.nextInt();
                if(answer>=1&&answer<=4){
                    userAns[i] = answer;
                    check = true;
                }
            }
			
		}
       
		System.out.println("Would you like to submit? \n1:Yes \n2:NO ");
		int n = sc.nextInt();
		if (n == 1) {
			submitExam();
		} else {
			// Auto-submit
			try {
				Thread.sleep(timeRemain * 10 * 1000);
			} catch (Exception e) {
				e.printStackTrace();
				submitExam();
			}

		}
	}

	public void submitExam() {
		if (!isLoggedIn) {
			System.out.println("Please login first.");
			return;
		}
		int score = 0;
		for (int i = 0; i < questionTot; i++) {
			if (userAns[i] == correctAns[i]) {
				score++;
			}
		}
		System.out.println("You scored " + score + " out of " + questionTot + ".");
		System.out.println("Have a good day:)");
		logout();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your username and password");
		String name = sc.nextLine();
		String pswrd = sc.nextLine();
		OnlineExam examSystem = new OnlineExam(name, pswrd);
		examSystem.login();
		examSystem.startExam();
        sc.close();
	}
}