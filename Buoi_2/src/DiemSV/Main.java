package DiemSV;
import TaoTV.TaoTV;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	int a = TaoTV.cong(12, 7);
    	System.out.println(a);
        Scanner sc = new Scanner(System.in);
        while (true) {
            Xuly ts = new Xuly();
            ts.nhap();
            ts.xuat();

            System.out.print("\nBạn có muốn tiếp tục (y/n)? ");
            String tiepTuc = sc.nextLine();
            if (tiepTuc.equalsIgnoreCase("n")) {
                System.out.println("Kết thúc chương trình!");
                break;
            }
        }
        sc.close();
    }
}
