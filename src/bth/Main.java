package bth;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        final int MAX = 10;
        String[] studentIdArray = new String[MAX];
        String[] studentNameArray = new String[MAX];
        String[] dateOfBirthArray = new String[MAX];
        boolean[] sexArray = new boolean[MAX];
        int size  = 0;
        studentIdArray[0] = "SV001";
        studentNameArray[0] = "John Doe ấbvdkvnlnfklvjsfvnskhvsb111";
        dateOfBirthArray[0] = "10/12/2004";
        sexArray[0] = true; // true: nam, false: nữ
        size++;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("--------------Student Management--------------");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("0. Thoát");
            System.out.println("----------------------------------------------");
            System.out.println("Nhập lựa chọn ->>>>>");
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1:
                    displayStudentArray(studentIdArray,studentNameArray,dateOfBirthArray,sexArray,size);
                    break;
                case 2:
                    size = addStudent(studentIdArray, studentNameArray, dateOfBirthArray, sexArray, size, sc);
                    break;
                case 3:
                    updateStudent(studentIdArray, studentNameArray, dateOfBirthArray, sexArray, size, sc);
                    break;
                case 4:
                    size = deleteStudent(studentIdArray, studentNameArray, dateOfBirthArray, sexArray, size, sc);
                    break;
                case 5:
                    searchStudent(studentNameArray, studentIdArray, dateOfBirthArray, sexArray, size, sc);
                    break;
                case 0:
                    System.out.println("Bye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Vui lòng chọn từ 0 đến 5.");
            }
        }
    }
    // hien thi
    public static void displayStudentArray( String[] studentIdArray , String[] studentNameArray, String[] dateOfBirthArray,boolean[] sexArray,int size){
        if(size == 0){
            System.err.println("------------Danh sách trống-------------");
            return;
        }
        System.out.println("------------Danh sách sinh viên---------------");
        System.out.printf("+%s+%s+%s+%s+\n","-".repeat(7),"-".repeat(20),"-".repeat(12),"-".repeat(5));
        System.out.printf("|%-7s|%-20s|%-12s|%-5s|\n","ID","Tên sinh viên","Ngày sinh","Sex");
        System.out.printf("+%s+%s+%s+%s+\n","-".repeat(7),"-".repeat(20),"-".repeat(12),"-".repeat(5));
        for (int i = 0; i < size; i++) {
            System.out.printf("|%-7s|%-20s|%-12s|%-5s|\n",studentIdArray[i],formatString(studentNameArray[i],20), dateOfBirthArray[i], sexArray[i]?"Nam":"Nữ");
            System.out.printf("+%s+%s+%s+%s+\n","-".repeat(7),"-".repeat(20),"-".repeat(12),"-".repeat(5));
        }

    }
    private static String formatString(String str, int maxLength) {
        if (str.length() > maxLength){
            return str.substring(0,maxLength-3).concat("...");
        }
        return str;
    }


    public static int addStudent(String[] studentIdArray, String[] studentNameArray, String[] dateOfBirthArray, boolean[] sexArray, int size, Scanner sc) {
        if (size == studentIdArray.length) {
            System.err.println("------------Mảng đầy ----------------");
            return size;
        }
        while (true) {
            System.out.println("Nhập student Id");
            studentIdArray[size] = sc.nextLine();
            if (validateStudentId(studentIdArray[size], studentIdArray, size)) {
                break;
            }
        }
        System.out.println("Nhập tên sinh viên (4-50 ký tự):");
        while (true) {
            studentNameArray[size] = sc.nextLine();
            if (studentNameArray[size].length() >= 4 && studentNameArray[size].length() <= 50) {
                break;
            }
            System.err.println("Tên không hợp lệ, nhập lại.");
        }
        System.out.println("Nhập ngày sinh (dd/MM/yyyy):");
        dateOfBirthArray[size] = sc.nextLine();
        System.out.println("Nhập giới tính (true - Nam, false - Nữ):");
        sexArray[size] = Boolean.parseBoolean(sc.nextLine());
        return ++size;
    }
    private static boolean validateStudentId(String studentId, String[] studentIdArray ,int size){
        String regex = "^SV\\d{3}$";
        if(Pattern.matches(regex,studentId)){
            for (int i = 0; i < size; i++){
                if (studentIdArray[i].equals(studentId)){
                    System.err.println("Id đã tồn tại");
                    return false;
                }
            }
            return true;
        }else {
            System.err.println("Mã sinh viên ko đúng định dạng : ex : SV001");
            return false;
        }
    }
    public static void updateStudent(String[] studentIdArray, String[] studentNameArray, String[] dateOfBirthArray, boolean[] sexArray, int size, Scanner sc) {
        System.out.println("Nhập ID sinh viên cần cập nhật:");
        String id = sc.nextLine();
        for (int i = 0; i < size; i++) {
            if (studentIdArray[i].equals(id)) {
                System.out.println("Nhập tên mới (nhấn Enter để giữ nguyên):");
                String newName = sc.nextLine();
                if (!newName.isEmpty()) {
                    studentNameArray[i] = newName;
                }
                System.out.println("Nhập ngày sinh mới (nhấn Enter để giữ nguyên):");
                String newDateOfBirth = sc.nextLine();
                if (!newDateOfBirth.isEmpty()) {
                    dateOfBirthArray[i] = newDateOfBirth;
                }
                System.out.println("Nhập giới tính mới (true - Nam, false - Nữ, nhấn Enter để giữ nguyên):");
                String newSex = sc.nextLine();
                if (!newSex.isEmpty()) {
                    sexArray[i] = Boolean.parseBoolean(newSex);
                }
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.err.println("Không tìm thấy sinh viên.");
    }

    public static int deleteStudent(String[] studentIdArray, String[] studentNameArray, String[] dateOfBirthArray, boolean[] sexArray, int size, Scanner sc) {
        System.out.println("Nhập ID sinh viên cần xóa:");
        String id = sc.nextLine();
        for (int i = 0; i < size; i++) {
            if (studentIdArray[i].equals(id)) {
                for (int j = i; j < size - 1; j++) {
                    studentIdArray[j] = studentIdArray[j + 1];
                    studentNameArray[j] = studentNameArray[j + 1];
                    dateOfBirthArray[j] = dateOfBirthArray[j + 1];
                    sexArray[j] = sexArray[j + 1];
                }
                System.out.println("Xóa sinh viên thành công");
                return --size;
            }
        }
        System.err.println("Không tìm thấy sinh viên.");
        return size;
    }

    public static void searchStudent(String[] studentNameArray, String[] studentIdArray, String[] dateOfBirthArray, boolean[] sexArray, int size, Scanner sc) {
        System.out.println("Nhập tên sinh viên cần tìm:");
        String name = sc.nextLine();
        for (int i = 0; i < size; i++) {
            if (studentNameArray[i].contains(name)) {
                System.out.println("Tìm thấy sinh viên: " + studentNameArray[i]);
            }
        }
    }
}
