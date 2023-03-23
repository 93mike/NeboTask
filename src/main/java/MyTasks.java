import java.io.File;
import java.io.FileNotFoundException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MyTasks {
    public static void main(String[] args) throws FileNotFoundException {
        CoreLanguageTasks.convertTemperatureFromFahrenheitToCeslius();
        System.out.println(CoreLanguageTasks.getGratestValue());
        CoreLanguageTasks.iterateAllElements();
        CoreLanguageTasks.findLongestWordInFile();
        CoreLanguageTasks.writeElementsOfArrUsingPosition();
        CoreLanguageTasks.displayDatesWithFormat();
    }

    static class CoreLanguageTasks {
        public static void convertTemperatureFromFahrenheitToCeslius() {
            System.out.println("Vvedit Fahrenheit value: ");
            Scanner scanner = new Scanner(System.in);
            double fahrenheit = scanner.nextDouble();
            double ceslius = ((fahrenheit - 32) * 5) / 9;
            System.out.println("Converted value from Fahrenheit to Ceslius is equal to: " + ceslius);
        }

        public static double getGratestValue() {
            System.out.println("we will print the gratest value");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Vvedit chyslo A");
            double a = scanner.nextDouble();
            System.out.println("Vvedit chyslo B");
            double b = scanner.nextDouble();
            System.out.println("Vvedit chyslo C");
            double c = scanner.nextDouble();
            System.out.print("the gratest value is: ");
            if (a > b) {
                return a > c ? a : c;
            } else
                return b > c ? b : c;
        }

        public static void iterateAllElements() {
            List<Object> objStream = Arrays.asList("London", 1, 1, "black");
            int arrLength = objStream.toArray().length;
            System.out.println("array length=: " + arrLength);
            for (int i = 0; i < objStream.toArray().length; i++) {
                System.out.println(objStream.toArray()[i]);
            }
        }

        public static void findLongestWordInFile() throws FileNotFoundException {
            Scanner scanner = new Scanner(new File("C:\\Users\\mmazu2\\studying\\text.txt"));
            String currentWord;
            String checkedWord = "";
            while (scanner.hasNext()) {
                currentWord = scanner.next();
                if (currentWord.length() > checkedWord.length()) {
                    checkedWord = currentWord;
                }
            }
            System.out.println("The longest word is:= " + checkedWord);
        }

        public static void writeElementsOfArrUsingPosition() {
            List<String> strList = Arrays.asList("One", "Two", "Tree", "Four", "London", "Lviv", "1234");
            System.out.println("Select elements from ArrList: " + strList);
            System.out.println("vvedit nomer elementa: ");
            Scanner scanner = new Scanner(System.in);
            int getNum = scanner.nextInt();
            System.out.println("element is: " + strList.get(getNum - 1));
        }

        public static void displayDatesWithFormat() {
            System.out.println("Which date format would you like");
            System.out.println("press 1 if: 16::Sep::2016");
            System.out.println("press 2 if: 16::Sep::2016 11::46::01");
            System.out.println("press 3 if: 2016-09-16T06:16:01.456Z");
            System.out.println("press 4 if: 2014-04-27T21:39:48");
            Scanner scanner = new Scanner(System.in);
            int variant = scanner.nextInt();
            if (variant == 1) {
                System.out.print("N1: ");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd::MMM::yyy");
                System.out.println(dtf.format(LocalDate.now()));
            } else if (variant == 2) {
                System.out.print("N2: ");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd::MMM::yyy HH:mm:ss");
                System.out.println(dtf.format(LocalDateTime.now()));
            } else if (variant == 3) {
                System.out.print("N3: ");
                Instant instantTime = Instant.now();
                System.out.println(instantTime);
            } else if (variant == 4) {
                System.out.print("N4:");
                String locatTime = LocalDateTime.now().toString();
                System.out.println(locatTime.substring(0, locatTime.lastIndexOf(".")));
            } else
                System.out.println("Bye");
        }
    }
}