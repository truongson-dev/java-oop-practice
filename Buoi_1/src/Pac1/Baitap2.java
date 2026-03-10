package Pac1;
import java.util.Scanner;

public class Baitap2 
{
	   public static void main(String[] args) 
	   {
	        Scanner sc = new Scanner(System.in);
	        double toan, ly, hoa, diemTrungBinh;

	        System.out.print("Nhập điểm Toán: ");
	        toan = sc.nextDouble();
	        System.out.print("Nhập điểm Lý: ");
	        ly = sc.nextDouble();
	        System.out.print("Nhập điểm Hóa: ");
	        hoa = sc.nextDouble();
	        // Tính điểm trung bình
	        diemTrungBinh = (toan + ly + hoa) / 3;

	        System.out.println("Điểm Toán: " + toan);
	        System.out.println("Điểm Lý: " + ly);
	        System.out.println("Điểm Hóa: " + hoa);
	        System.out.println("Điểm trung bình cộng: " + diemTrungBinh);
	        sc.close();
	   }
}