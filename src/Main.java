import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DirMng dirMng = new DirMng();
//        dirMng.directoryList.add(new Directory("Vu","0978326973","Bac Ninh","tuanvubn@gmail.com","fbtv"));
//        dirMng.directoryList.add(new Directory("Tu","03947573839","Ha Nam","tuhn@yahoo.com","fbat"));
//        dirMng.directoryList.add(new Directory("Hieu","0962574738","Ha Noi","minhhieuhn@gmail.com","fbmh"));

        String choice;

        do{
            showMenu();
            choice = sc.nextLine();

            switch (choice){
                case "1":
                    dirMng.showAll();
                    break;
                case "2":
                    dirMng.add();
                    break;
                case "3":
                    dirMng.update();
                    break;
                case "4":
                    System.out.println("Nhập số điện thoại : ");
                    String remove =  sc.nextLine();
                    dirMng.remove();
                    break;
                case "5":
                    dirMng.showByPhoneNumber();
                    break;
                case "6":
                    dirMng.read();
                    break;
                case "7":
                    dirMng.save();
                    break;
                case "8":
                    System.out.println("GOODBYE !");
                    break;
                default:
                    System.err.println("Nhập sai !");
                    break;
            }
        }while(!(choice.equals("8")));

    }

    private static void showMenu() {
        System.out.println("------CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ-------");
        System.out.println("Chọn chức năng theo số (để tiếp tục ) : ");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng : ");
    }
}
