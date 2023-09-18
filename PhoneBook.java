import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class PhoneBook {
    private static Map<String, List<Integer>> contacts = new HashMap<>();

    public static void main(String[] args) {
        int userChoice = 999;
        while(userChoice != 0) {
            System.out.println("");
            System.out.println(" 1 - Show contacts\n 2 - Add new contact\n 3 - Remove contact\n 0 - Close this app\n Input the number of command you want to execute:");
            Scanner scanner0 = new Scanner(System.in, "UTF-8");
            userChoice = scanner0.nextInt();
            if(userChoice == 1) {
                showContacts();
            } else if(userChoice == 2) {
                addContact(contacts);
            } else if(userChoice == 3) {
                removeContact(contacts);
            } else if(userChoice == 0) {
                System.out.println("Goodbye! See you later!");
            } else {
                System.out.println("Input error. Try again!");
            }
        }
    }

    public static void showContacts() {
        if(contacts.size() == 0) {
            System.out.println("Your phonebook is empty. Add new contacts to use it :)");
        } else {
            contacts = contacts.entrySet()      
                .stream()              
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(
                                    Map.Entry::getKey,
                                    Map.Entry::getValue,
                                    (oldValue, newValue) -> oldValue,
                                    LinkedHashMap::new
                                ));
            System.out.println(contacts);
        }
    }

    private static int chooseNumberOfPhonesToAdd() {
        System.out.println("How many phone numbers will your contact have?");
        Scanner scanner1 = new Scanner(System.in, "UTF-8");
        int numberOfPhones = scanner1.nextInt();
        return numberOfPhones;
        }

    public static void addContact(Map<String, List<Integer>> contacts) {
        System.out.println("Input your contact's name in English: ");
        Scanner nameScanner = new Scanner(System.in, "UTF-8");
        String contactName = nameScanner.nextLine();
        int numberOfPhonesToAdd = chooseNumberOfPhonesToAdd();
        List<Integer> phonesList = new ArrayList<>();
        for(int i = 0; i < numberOfPhonesToAdd; i++) {
            System.out.println("Input the contact's phone №" + (i+1) + ":");
            Scanner scanner3 = new Scanner(System.in, "UTF-8");
            Integer contactPhone = scanner3.nextInt();
            phonesList.add(contactPhone);
        }
        contacts.put(contactName, phonesList);
        System.out.println("Contact " + contactName + ", " + phonesList + " was successfully added!");
    }

    public static void removeContact(Map<String, List<Integer>> contacts) {
        System.out.println("Input the name of the contact you want to remove: ");
        Scanner scanner4 = new Scanner(System.in, "UTF-8");
        String contactNameToRemove = scanner4.nextLine();
        if(contacts.containsKey(contactNameToRemove)) {
            contacts.remove(contactNameToRemove);
            System.out.println("Contact " + contactNameToRemove + " was removed from your phonebook!");
        } else {
            System.out.println("Sorry, failed to find this contact. Are your sure it is in your book?");
        }
    }
}