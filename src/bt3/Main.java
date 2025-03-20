package bt3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập một chuỗi bất kỳ:");
        String input = sc.nextLine();

        StringBuilder stringBuilder = new StringBuilder(input);

        // Đảo ngược chuỗi bằng phương thức reverse()
        StringBuilder reversedString = stringBuilder.reverse();

        System.out.println("Chuỗi ban đầu: " + input);
        System.out.println("Chuỗi đã được đảo ngược: " + reversedString);

        sc.close();
    }
}