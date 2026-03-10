package Pac1;
//import TaoTV.TaoTV;

import java.util.Scanner;


public class Baitap1 {
public static void main(String[] args) 
{
	
     Scanner sc = new Scanner(System.in);

     // Khai báo các biến
     String maSV;
     String hoTen;
     int tuoi;
     int namSinh;
     double diemTB;
//Nhập
     System.out.print("Nhập mã sinh viên: ");
     maSV = sc.nextLine();

     System.out.print("Nhập họ tên: ");
     hoTen = sc.nextLine();

     System.out.print("Nhập tuổi: ");
     tuoi = sc.nextInt();

     System.out.print("Nhập năm sinh: ");
     namSinh = sc.nextInt();

     System.out.print("Nhập điểm trung bình: ");
     diemTB = sc.nextDouble();

     //sc.nextLine() tự động đọc 1 dòng trống 
     
     // Xuất 
     System.out.println("Mã sinh viên: " + maSV);
     System.out.println("Họ tên: " + hoTen);
     System.out.println("Tuổi: " + tuoi);
     System.out.println("Năm sinh: " + namSinh);
     System.out.println("Điểm trung bình: " + diemTB);
     sc.close();
 }
}
