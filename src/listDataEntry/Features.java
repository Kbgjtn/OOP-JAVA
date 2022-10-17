package listDataEntry;

import java.util.*;

class ListData {
    String name;
    String phone;
    String pwd;
    public static ArrayList<ListData> list = new ArrayList<>();

    public ListData(String name, String phone, String pwd) {
        this.name = name;
        this.phone = phone;
        this.pwd = pwd;
    }

    public static void useAdd(String name, String phone, String pwd) {

        ListData userData = new ListData(name, phone, pwd);

        list.add(userData);

        if (userData != null) {
            System.out.println("\nMessage: User data has been successfully added to the list!");
        }

        return;
    }

    public static void useDisplay() {

        System.out.println(
                "\n\n===========================================================================================================================");
        System.out.println("No.\t|\t\tName\t\t|\t\tPhone\t\t|\t\t\tPassword\t\t\t\t");
        System.out.println(
                "===========================================================================================================================");

        if (list.size() == 0) {
            System.out.println("\n\n\t\t\t\t\t\t    No Data Exist!");

            System.out.println(
                    "\n\n===========================================================================================================================");
        }

        int index = 1;

        for (ListData userData : list) {
            System.out.print("\n\n[" + (index++) + "]\t|");
            System.out.print("\t    " + userData.name + "   \t|");
            System.out.print("\t\t" + userData.phone);
            System.out.print("\t|\t\t     " + userData.pwd + "\n");
            System.out.println(
                    "\n\n===========================================================================================================================");
        }

        System.out.print("\ntotal: " + list.size() + "\n");

        return;
    }

    public static Boolean useDelete(int indexOfData) {
        if (list.size() == 0) {
            return false;
        }
        if (indexOfData > list.size()) {
            return false;
        }

        list.remove(indexOfData);
        return true;
    }
}

public class Features {
    private static Stack<String> errorMessage = new Stack<>();

    public static void useFeatures() {
        String regexInputMenu = "(?i)1|2|3";

        do {
            displayMenu();
            Scanner inputMenu = new Scanner(System.in);
            String choosed = inputMenu.nextLine();

            if (choosed.matches("0|Exit|exit|EXIT")) {
                System.out.print("Enter to continue...");
                choosed = inputMenu.nextLine();
                System.out.println("Exit Program...");
                inputMenu.close();
                break;
            }

            if (choosed.matches("clear|cls")) {
                clearConsole();
                continue;
            }

            if (choosed.matches(regexInputMenu)) {
                handleSwitcherMenu(choosed);
                System.out.print("\nEnter to continue...");
                choosed = inputMenu.nextLine();

                continue;
            } else {
                errorMessage.push("Invalid input field, feature menu not found!");
                continue;
            }

        } while (true);
    }

    private static void handleSwitcherMenu(String choosed) {
        switch (choosed) {
            case "0":
                System.out.println("Exit Program...");
                break;
            case "1":
                inputData();
                break;
            case "2":
                ListData.useDisplay();
                break;
            case "3":
                clearConsole();
                deleteData();
                break;
            default:
                errorMessage.push("Invalid input field, feature menu not found!");
                break;
        }
    }

    private static void deleteData() {
        String index = "";
        Scanner userInput = new Scanner(System.in);

        if (index.isEmpty()) {

            do {
                try {
                    ListData.useDisplay();
                    Boolean flag = null;
                    System.out.println("\nInput the data number u wanna delete!");
                    System.out.print(">> ");
                    index = userInput.nextLine();
                    int toInt = Integer.parseInt(index);

                    if (index.isEmpty() || index.isBlank()) {
                        throw new NoSuchElementException("Number or index data input shouldn't be empty!");
                    }

                    if (isAlphabetic(index)) {
                        throw new InputMismatchException("Number or index data must only contains a number!");
                    }

                    flag = ListData.useDelete(toInt - 1);

                    if (!flag) {
                        System.out.println("\nNumber or index data [" + toInt + "] not found!");
                        break;
                    }

                    System.out.println("\ndata to [" + toInt + "] successfully removed from the list!");
                    clearConsole();
                    break;

                } catch (InputMismatchException err) {
                    clearConsole();

                    System.out.print("\nError: ");
                    System.out.println(err.getMessage());
                    continue;

                } catch (NoSuchElementException err) {
                    clearConsole();
                    System.out.print("\nError: ");
                    System.out.println(err.getMessage());
                    System.out.println("Please, try again!");
                    continue;
                }

            } while (true);
        }

    }

    private static void inputData() {
        Scanner userInput = new Scanner(System.in);
        String name = "", phone = "", pwd = "";
        System.out.println("\nPlease, input Fields this form!");

        if (name.isEmpty()) {
            do {
                try {
                    System.out.print("Name: ");
                    name = userInput.nextLine();

                    if (name.isEmpty() || name.isBlank() || name.length() <= 3) {
                        throw new NoSuchElementException("Name input shouldn't be empty!");
                    }

                    if (!isAlphabetic(name)) {
                        throw new InputMismatchException("Name must only contains a letter!");
                    } else {
                        break;
                    }

                } catch (InputMismatchException err) {
                    clearConsole();

                    System.out.print("\nError: ");
                    System.out.println(err.getMessage());
                    System.out.println("Please, try again!");
                    continue;
                } catch (NoSuchElementException err) {
                    clearConsole();
                    System.out.print("\nError: ");
                    System.out.println(err.getMessage());
                    System.out.println("Please, try again!");
                    continue;

                }

            } while (true);
        }

        if (phone.isEmpty()) {
            do {
                try {

                    System.out.print("Number Phone: ");
                    phone = userInput.nextLine();

                    if (phone.isEmpty() || phone.isBlank() || phone.length() <= 3) {
                        throw new NoSuchElementException("Phone number input isn't valid!");
                    }

                    if (isAlphabetic(phone)) {
                        throw new InputMismatchException("Phone number must only contains a number!");
                    } else {
                        break;
                    }

                } catch (InputMismatchException err) {
                    clearConsole();

                    System.out.print("\nError: ");
                    System.out.println(err.getMessage());
                    System.out.println("Please, try again!");
                    continue;

                } catch (NoSuchElementException err) {
                    clearConsole();
                    System.out.print("\nError: ");
                    System.out.println(err.getMessage());
                    System.out.println("Please, try again!");
                    continue;

                }

            } while (true);
        }

        if (pwd.isEmpty()) {
            do {
                try {

                    System.out.print("Password: ");
                    pwd = userInput.nextLine();

                    if (phone.isEmpty() || phone.isBlank() || phone.length() <= 3) {
                        throw new NoSuchElementException("Password input input shouldn't be empty!");
                    } else {
                        break;
                    }
                } catch (NoSuchElementException err) {
                    clearConsole();
                    System.out.print("\nError: ");
                    System.out.println(err.getMessage());
                    System.out.println("Please, try again!");
                    continue;

                }
            } while (true);
        }

        ListData.useAdd(name, phone, pwd);
        // System.out.println(name + " " + phone + " " + pwd);
        return;
    }

    private static boolean isAlphabetic(String input) {
        for (int i = 0; i != input.length(); ++i) {
            if (Character.isWhitespace(input.charAt(i))) {
                continue;
            }
            if (!Character.isLetter(input.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private static void displayMenu() {
        System.out.println("\n\n\n\t\t\t ");
        System.out.println("\n\t\t    - LIST DATA ENTRY APP -\n");
        System.out.println("\n\t Feautures Menu:\n");
        System.out.println("\t [1] Input user data");
        System.out.println("\t [2] Display users data");
        System.out.println("\t [3] Delete user data");
        System.out.println("\t [0] Exit");
        System.out.println("\n\t ps       : type 'clear/cls' to clear console.");

        if (!errorMessage.empty()) {
            System.out.println("\n\n");
            for (String err : errorMessage) {
                System.out.println("Error: " + err);
            }
            errorMessage.clear();
        }

        System.out.print("\nSelect Features u wanna use!");
        System.out.print("\n>> ");
    };

    private static void clearConsole() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

}
