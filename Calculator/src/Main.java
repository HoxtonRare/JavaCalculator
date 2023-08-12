import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String example;

        System.out.print("Введите пример: ");
        example = in.nextLine();
        System.out.println("Ответ: " + calc(example));
    }

    public static String calc(String input){
        int num1;
        int num2;
        int answer = 0;
        String result;
        char action = 0;
        String[] nums = new String[0];

        if (input.contains("+")){
            action = '+';
            nums = input.split("\\+");
        }
        else if (input.contains("-")){
            action = '-';
            nums = input.split("-");
        }
        else if (input.contains("*")){
            action = '*';
            nums = input.split("\\*");
        }
        else if (input.contains("/")){
            action = '/';
            nums = input.split("/");
        }
        else{
            try {
                throw new IOException();
            } catch (IOException e){
                System.out.println("Введен неверный пример");
                System.exit(1);
            }
        }

        if (nums.length > 2) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Введен неверный пример");
                System.exit(2);
            }
        }

        for (int i = 0; i < nums.length; i++)
        {
            nums[i] = nums[i].replaceAll(" ", "");
        }

        try {
            num1 = Integer.parseInt(nums[0]);
            num2 = Integer.parseInt(nums[1]);
        } catch (NumberFormatException e){
            System.out.println("Введено неверное число");
            System.exit(3);
        }

        num1 = Integer.parseInt(nums[0]);
        num2 = Integer.parseInt(nums[1]);

        if (num1 < 0 || num1 > 10 || num2 < 0 || num2 > 10){
            try {
                throw new IOException();
            } catch (IOException e){
                System.out.println("Введено неверное число");
                System.exit(4);
            }
        }


        switch (action){
            case('+'):
                answer = num1 + num2;
                break;
            case('-'):
                answer = num1 - num2;
                break;
            case('*'):
                answer = num1 * num2;
                break;
            case('/'):
                answer = num1 / num2;
                break;
        }

        result = String.valueOf(answer);

        return result;
    }
}