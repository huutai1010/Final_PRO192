/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author maihuutai
 */
public class Main {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Manager manager = new Manager();
        int choice;
        do {
            Main.menu();
            System.out.println("Nhập lựa chọn: ");
            choice = Integer.parseInt(sc.nextLine());
            
            switch(choice) {
                case 1:
                    manager.create();
                    break;
                case 2:
                    manager.read();
                    break;
                case 3:
                    manager.details();
                    break;
                case 4:
                    manager.update();
                    break;
                case 5: 
                    manager.delete();
                    break;
                case 6:
                    System.out.println("Bạn có muốn lưu file: YES or NO");
                    sc = new Scanner(System.in);
                    String choose = sc.nextLine();
                    if (choose.equals("YES")) {
                        sc = new Scanner(System.in);
                        System.out.println("Nhập tên file: ");
                        String fileName = sc.nextLine();
                        manager.write(fileName);
                    } else {
                        System.out.println("EXIT!!!");
                    }
                    break;
            }
        } while (choice >= 1 && choice < 6);
    }
    
    public static void menu() {
        System.out.println();
        System.out.println("1 - Thêm mới tin tức.");
        System.out.println("2 - Liệt kê danh sách tin tức.");
        System.out.println("3 - Hiển thị thông tin chi tiết tin tức qua mã số.");
        System.out.println("4 - Cập nhật thông tin tin tức.");
        System.out.println("5 - Xoá tin tức.");
        System.out.println("6- Thoát chương trình.\n");
    }
}
