package bt2;

public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("Hello, Java World!");
        System.out.println("Chuỗi ban đầu: " + stringBuilder);

        // Xóa các ký tự từ vị trí 5 đến 9
        stringBuilder.delete(5, 9);
        System.out.println("Chuỗi sau khi xóa: " + stringBuilder);

        // Thay thế đoạn "World" bằng "Universe"
        int startIndex = stringBuilder.indexOf("World");
        int endIndex = startIndex + "World".length();
        if (startIndex != -1) { // Kiểm tra nếu đoạn cần thay thế tồn tại
            stringBuilder.replace(startIndex, endIndex, "Universe");
        }
        System.out.println("Chuỗi sau khi thay thế: " + stringBuilder);
    }
}
