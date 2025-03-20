package bt4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập một chuỗi:");
        String input = sc.nextLine();

        String normalizedInput = input.toLowerCase().trim();

        StringBuilder stringBuilder = new StringBuilder(normalizedInput);
        String reversedString = stringBuilder.reverse().toString();

        if (normalizedInput.equals(reversedString)) {
            System.out.println("Chuỗi đối xứng.");
        } else {
            System.out.println("Chuỗi không đối xứng.");
        }

        sc.close();
    }
}
