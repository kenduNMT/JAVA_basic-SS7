package bt8;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập độ dài chuỗi (1 ≤ n ≤ 1000):");
        int n = sc.nextInt();

        // Kiểm tra giá trị hợp lệ của n
        if (n < 1 || n > 1000) {
            System.out.println("Độ dài chuỗi phải nằm trong khoảng từ 1 đến 1000.");
            return;
        }

        // Ký tự hợp lệ: A-Z, a-z, 0-9
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int charLength = characters.length();

        // Sử dụng StringBuilder để tạo chuỗi ngẫu nhiên
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            // Lấy ký tự ngẫu nhiên từ danh sách
            char randomChar = characters.charAt(random.nextInt(charLength));
            randomString.append(randomChar);
        }

        System.out.println("Chuỗi ngẫu nhiên: " + randomString.toString());

        sc.close();
    }
}
