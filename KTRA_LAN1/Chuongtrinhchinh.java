package KTRA_LAN1;


public class Chuongtrinhchinh {
    static Xuly xuLy = new Xuly();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== QUẢN LÝ ALBUM CD ===");
            System.out.println("1. Thêm CD");
            System.out.println("2. Xem số lượng và tổng giá");
            System.out.println("3. Sắp xếp CD theo tựa");
            System.out.println("4. Xem tất cả CD");
            System.out.println("5. Tìm CD theo ca sỹ");
            System.out.println("6. Thêm thể loại nhạc");
            System.out.println("7. Thêm CD vào thể loại");
            System.out.println("8. Xem CD theo thể loại");
            System.out.println("9. Thống kê CD theo thể loại");
            System.out.println("0. Thoát");
            
            int chon = nhapLieu.nhapSo("Chọn chức năng: ");
            
            switch (chon) {
                case 1: xuLy.themCD(); break;
                case 2: xuLy.thongKeCD(); break;
                case 3: xuLy.sapXepCD(); break;
                case 4: xuLy.xemTatCaCD(); break;
                case 5: xuLy.timCDTheoCaSy(); break;
                case 6: xuLy.themTheLoai(); break;
                case 7: xuLy.themCDVaoTheLoai(); break;
                case 8: xuLy.xemCDTheoTheLoai(); break;
                case 9: xuLy.thongKeTheLoai(); break;
                case 0: 
                    System.out.println("Bái bai");
                    return;
                default:
                    System.out.println("Chọn sai! Vui lòng chọn 0-9");
            }
        }
    }
}