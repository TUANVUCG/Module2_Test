import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DirMng implements DirMngInterface{
    List<Directory> directoryList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void add(){
//        read();
        Directory directory = new Directory();
        directory.input(directoryList);
        directoryList.add(directory);
        save();
    }

    public void showAll() {
//        read();
        for(Directory directory : directoryList){
            directory.show();
        }
    }

    public int search() {
//        read();
        int index = -1;
        int exit = -1;
        do {
            System.out.println("Nhập số điện thoại");
            String phoneNum = sc.nextLine();
            for(int i = 0;i<directoryList.size();i++){
                if(directoryList.get(i).getPhoneNum().equals(phoneNum)){
                    index = i;
                    exit=0;
                }
            }
            if(index==-1){
                System.out.println("Không tìm thấy !");
            }
        }while (exit!=0);
        return index;
    }

    public void showByPhoneNumber(){
        int index = search();
        if(index!=-1){
            directoryList.get(index).show();
        }
    }

    public void update() {
        int index = search();
        if(index!=-1){
            Directory directory = new Directory();
            directory.input(directoryList);
            directoryList.set(index, directory);
        }
        save();
    }

    public void remove() {
        int index = search();
        if(index!=-1){
            directoryList.get(index).show();
            System.out.println("Nhấn Y để xóa, phím khác để bỏ qua");
            String input = sc.nextLine();
            if(input.equals("Y")){
                directoryList.remove(index);
            }
            System.out.println("Không xóa nữa ");
            showAll();
        }
        save();
    }

    public void save() {
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(FILE_NAME);
            fileWriter.append("Tên,Số điện thoại, Địa chỉ,Email,Facebook");
            fileWriter.write("\n");
            for(Directory directory : directoryList){
                fileWriter.append(directory.getName());
                fileWriter.append(",");
                fileWriter.append(directory.getPhoneNum());
                fileWriter.append(",");
                fileWriter.append(directory.getAddress());
                fileWriter.append(",");
                fileWriter.append(directory.getEmail());
                fileWriter.append(",");
                fileWriter.append(directory.getFb());
                fileWriter.append(",");
                fileWriter.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(fileWriter!=null)
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void read() {
        BufferedReader br = null;
        try{
            String line;
            br = new BufferedReader(new FileReader(FILE_NAME));
            while((line= br.readLine())!=null){

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
