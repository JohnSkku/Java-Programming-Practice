
import java.util.ArrayList;  
import java.util.Scanner;

  
public class Contact {  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        ContactManager manager = new ContactManager();

        while (scanner.hasNextLine()) {  
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {  
                continue;  
            }

            String[] tokens = line.split("\\s+");  
            String command = tokens[0];

            switch (command) {  
                case "add":  
                    if (tokens.length != 3) {  
                        System.out.println("error");  
                        break;  
                    }  
                    if (!manager.add(tokens[1], tokens[2])) {  
                        System.out.println("error");  
                    }  
                    break;

                case "find":  
                    if (tokens.length != 2) {  
                        System.out.println("error");  
                        break;  
                    }  
                    String phone = manager.find(tokens[1]);  
                    if (phone == null) {  
                        System.out.println("error");  
                    } else {  
                        System.out.println(phone);  
                    }  
                    break;

                case "delete":  
                    if (tokens.length != 2) {  
                        System.out.println("error");  
                        break;  
                    }  
                    if (!manager.delete(tokens[1])) {  
                        System.out.println("error");  
                    }  
                    break;

                case "show":  
                    if (tokens.length != 1) {  
                        System.out.println("error");  
                        break;  
                    }  
                    ArrayList<String> list = manager.show();  
                    for (String contact : list) {  
                        System.out.println(contact);  
                    }  
                    break;

                default:  
                    System.out.println("error");  
                    break;  
            }  
        }

        scanner.close();  
    }  
}