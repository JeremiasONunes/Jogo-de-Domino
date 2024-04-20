package Services;


import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);

    

    public int receberInputInteiro() {
        return scanner.nextInt();
    }

    public String receberInputString() {
        return scanner.next();
    }
}

