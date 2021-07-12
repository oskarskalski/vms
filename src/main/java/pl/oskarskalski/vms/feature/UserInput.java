package pl.oskarskalski.vms.feature;

import java.util.Scanner;

public class UserInput {
    public String getValueFromUser(String title){
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.nextLine();
    }
}
