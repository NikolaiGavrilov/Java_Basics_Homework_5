import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class PhoneBook {
    private static Map<String, List<Integer>> contacts = new HashMap<>();

    public static void main(String[] args) {
        int userChoice = 999;
        while (userChoice != 0){
            System.out.println("");
            System.out.println("1 - Показать контакты, 2 - добавить контакт, 3 - удалить контакт, 0 - завершить работу \nВведите номер команды для работы с телефонной книгой:");
            Scanner scanner0 = new Scanner(System.in, "UTF-8");
            userChoice = scanner0.nextInt();
            if(userChoice == 1) {
                showContacts();
            } else if(userChoice == 2) {
                addContact(contacts);
            } else if(userChoice == 3) {
                removeContact(contacts);
            } else if(userChoice == 0) {
                System.out.println("До свидания, до новых встреч!");
            } else {
                System.out.println("Ошибка ввода");
            }
        }
    }

    public static void showContacts(){
        if (contacts.size() == 0){
            System.out.println("Телефонный справочник пока пуст. Добавьте новый контакт!");
        } else {
            System.out.println(contacts);
        }
    }

    private static int chooseNumberOfPhonesToAdd() {
        System.out.println("Сколько будет телефонных номеров у контакта?");
        Scanner scanner1 = new Scanner(System.in, "UTF-8");
        int numberOfPhones = scanner1.nextInt();
        return numberOfPhones;
        }

    public static void addContact(Map<String, List<Integer>> contacts) {
        System.out.println("Введите имя контакта: ");
        Scanner nameScanner = new Scanner(System.in, "UTF-8");
        String contactName = nameScanner.nextLine();
        int numberOfPhonesToAdd = chooseNumberOfPhonesToAdd();
        List<Integer> phonesList = new ArrayList<>();
        for (int i = 0; i < numberOfPhonesToAdd; i++) {
            System.out.println("Введите телефон " + (i+1) + ":");
            Scanner scanner3 = new Scanner(System.in, "UTF-8");
            Integer contactPhone = scanner3.nextInt();
            phonesList.add(contactPhone);
        }
        contacts.put(contactName, phonesList);
        System.out.println("Контакт " + contactName + ", " + phonesList + " был успешно добавлен!");
    }

    public static void removeContact(Map<String, List<Integer>> contacts) {
        System.out.println("Введите имя контакта, который хотите удалить: ");
        Scanner scanner4 = new Scanner(System.in, "UTF-8");
        String contactNameToRemove = scanner4.nextLine();
        if (contacts.containsKey(contactNameToRemove)){
            contacts.remove(contactNameToRemove);
            System.out.println("Контакт " + contactNameToRemove + " успешно удален!");
        } else {
            System.out.println("Контакт не найден в вашем телефонном справочнике");
        }
    }
}