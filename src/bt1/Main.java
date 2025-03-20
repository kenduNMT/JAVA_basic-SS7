package bt1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập 3 chuỗi cách nhau bởi dấu phẩy (,):");
        String input = sc.nextLine();

        // Tách các chuỗi bằng dấu phẩy
        String[] parts = input.split(",");

        if (parts.length != 3) {
            System.out.println("Vui lòng nhập chính xác 3 chuỗi, cách nhau bởi dấu phẩy.");
            return;
        }

        // Tạo đối tượng StringBuilder và nối chuỗi
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(parts[0]);
        stringBuilder.append(parts[1]);
        stringBuilder.append(parts[2]);

        // Chuyển chuỗi đã nối thành chữ hoa
        String result = stringBuilder.toString().toUpperCase();

        System.out.println("Chuỗi đã nối và chuyển sang chữ hoa: " + result);

        sc.close();
    }
}
