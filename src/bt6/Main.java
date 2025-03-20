package bt6;

public class Main {
    public static void main(String[] args) {
        int iterations = 1_000_000; // Số lần thực hiện nối chuỗi
        String appendString = " World";

        // So sánh hiệu suất với String
        String string = "Hello";
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            string += appendString; // Nối chuỗi
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực thi với String: " + (endTime - startTime) + " ms");

        // So sánh hiệu suất với StringBuilder
        StringBuilder stringBuilder = new StringBuilder("Hello");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(appendString); // Nối chuỗi
        }
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực thi với StringBuilder: " + (endTime - startTime) + " ms");

        // So sánh hiệu suất với StringBuffer
        StringBuffer stringBuffer = new StringBuffer("Hello");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(appendString); // Nối chuỗi
        }
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực thi với StringBuffer: " + (endTime - startTime) + " ms");
    }
}
// String: Mỗi lần nối, một đối tượng mới được tạo, dẫn đến hiệu suất rất thấp và tốn bộ nhớ.
// StringBuilder: Hiệu suất cao nhất do sử dụng bộ nhớ hiệu quả và không đồng bộ.
// StringBuffer: Tương tự StringBuilder nhưng có tính đồng bộ, thích hợp cho môi trường đa luồng.