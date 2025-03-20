package bt7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập một chuỗi (PascalCase hoặc camelCase):");
        String input = sc.nextLine();

        if (input.isEmpty()) {
            System.out.println("Chuỗi rỗng.");
            return;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // Nếu là chữ cái viết hoa
            if (Character.isUpperCase(currentChar)) {
                // Thêm dấu gạch dưới trước chữ cái (trừ vị trí đầu tiên)
                if (i != 0) {
                    result.append("_");
                }
                // Thêm chữ cái chuyển thành chữ thường
                result.append(Character.toLowerCase(currentChar));
            } else {
                // Nếu không phải chữ cái viết hoa, thêm trực tiếp vào kết quả
                result.append(currentChar);
            }
        }

        System.out.println("Chuỗi chuyển đổi sang snake_case: " + result.toString());

        sc.close();
    }
}
