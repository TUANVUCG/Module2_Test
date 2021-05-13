import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Directory implements Serializable {

    private String name;
    private String phoneNum;
    private String address;
    private String email;
    private String fb;

    public Directory() {
    }

    public Directory(String name, String phoneNum, String address, String email, String fb) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.address = address;
        this.email = email;
        this.fb = fb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public void input(List<Directory> directoryList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên : ");
        name = sc.nextLine();

        System.out.print("Nhập số điện thoại ( số điện thoại gồm 10 hoặc 11 chữ số viết liền ) :  ");
        while (true) {
            phoneNum = sc.nextLine();
            boolean numFind = false;
            for (int i = 0; i < directoryList.size(); i++) {
                if (directoryList.get(i).getPhoneNum().equals(phoneNum)) {
                    numFind = true;
                }
            }
            String regex = "^[(09)(03)]\\d{9,10}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(phoneNum);
            if (matcher.find()) {
                if (!numFind)
                    break;
                else {
                    System.err.println("Số điện thoại này đã được sử dụng, vui lòng nhập số điện thoại khác !");
                    continue;
                }
            }
            System.err.println("Số điện thoại không đúng !!!");
        }


        System.out.println("Nhập địa chỉ : ");
        address = sc.nextLine();

        System.out.print("Nhập email (ví dụ : abc@abc.abc) : ");
        while (true) {
            email = sc.nextLine();
            boolean emailFind = false;
            for (int i = 0; i < directoryList.size(); i++) {
                if (directoryList.get(i).getPhoneNum().equals(email)) {
                    emailFind = true;
                }
            }
            String regex = "^[a-zA-Z]+[a-zA-Z0-9]*@[a-z]+(\\.[a-zA-Z0-9]+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (matcher.find()) {
                if (!emailFind)
                    break;
                else {
                    System.err.println("Email này đã được sử dụng, vui lòng nhập email khác !!!");
                    continue;
                }
            }
            System.err.println("Email không đúng !!!");
        }

        System.out.println("Nhập facebook : ");
        fb = sc.nextLine();
    }

    public void show() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return   "Tên: " + name + "\t" +
                "Số điện thoai : " + phoneNum + "\t" +
                "Địa chỉ : " + address + "\t" +
                "Email: " + email + "\t" +
                "Facebook : " + fb + "\t";
    }
}
