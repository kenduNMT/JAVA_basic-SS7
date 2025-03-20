package bt5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập một câu bất kỳ:");
        String input = sc.nextLine();

        // Loại bỏ khoảng trắng thừa ở đầu và cuối, sau đó tách câu thành các từ
        String[] words = input.trim().split("\\s+");

        // Đảo ngược thứ tự các từ
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]).append(" ");
        }

        // Loại bỏ khoảng trắng dư thừa ở cuối và in kết quả
        String finalResult = result.toString().trim();
        System.out.println("Câu sau khi đảo ngược thứ tự các từ: " + finalResult);

        sc.close();
    }
}
