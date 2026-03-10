package DiemSV;

	import java.util.Scanner;
	import java.time.*;
	import java.time.format.DateTimeFormatter;

	public class Xuly {
	    String hoTen;
	    String gioiTinh;
	    int tuoi;
	    String ngayThi;
	    double diemThi;
	    String xepLoai;
	    Scanner sc = new Scanner(System.in);

	    // Hàm xếp loại
	    public String xeploai(double diem) {
	        if (diem >= 8)
	            return "Giỏi";
	        else if (diem >= 6.5)
	            return "Khá";
	        else if (diem >= 5)
	            return "Trung bình";
	        else
	            return "Yếu";
	    }

	    // Hàm nhập họ tên
	    public String nhapHoTen() {
	        System.out.print("Nhập họ tên: ");
	        return sc.nextLine();
	    }

	    // Hàm nhập giới tính
	    public String nhapGioiTinh() {
	        while (true) {
	            System.out.print("Nhập giới tính (Nam/Nữ): ");
	            String gt = sc.nextLine();
	            if (gt.equalsIgnoreCase("Nam") || gt.equalsIgnoreCase("Nữ"))
	                return gt;
	            else
	                System.out.println("Lỗi: Chỉ được nhập Nam hoặc Nữ");
	        }
	    }

	    // Hàm nhập tuổi
	    public int nhapTuoi() {
	        while (true) {
	            try {
	                System.out.print("Nhập tuổi (18–40): ");
	                int t = Integer.parseInt(sc.nextLine());
	                if (t >= 18 && t <= 40)
	                    return t;
	                else
	                    System.out.println("Tuổi không hợp lệ, vui lòng nhập từ 18 đến 40");
	            } catch (Exception e) {
	                System.out.println("Lỗi: Hãy nhập số nguyên hợp lệ cho tuổi!");
	            }
	        }
	    }

	    // Hàm nhập ngày thi
	    public String nhapNgayThi() {
	        while (true) {
	            try {
	                System.out.print("Nhập ngày thi (dd/MM/yyyy): ");
	                String input = sc.nextLine();
	                
	                DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	                LocalDate date = LocalDate.parse(input, DTF);
	                LocalDate today = LocalDate.now();

	                if (date.isAfter(today)) {
	                    System.out.println("Ngày thi không được lớn hơn ngày hiện tại");
	                } else {
	                    return input;
	                }
	            } catch (Exception e) {
	                System.out.println("Định dạng ngày sai! Hãy nhập dạng dd/MM/yyyy.");
	            }
	        }
	    }

	    // Hàm nhập điểm thi
	    public double nhapDiemThi() {
	        while (true) {
	            try {
	                System.out.print("Nhập điểm thi (0–10): ");
	                double diem = Double.parseDouble(sc.nextLine());
	                if (diem >= 0 && diem <= 10)
	                    return diem;
	                else
	                    System.out.println("Điểm không hợp lệ, chỉ từ 0 đến 10");
	            } catch (Exception e) {
	                System.out.println("Hãy nhập số hợp lệ cho điểm");
	            }
	        }
	    }

	    // Hàm nhập tổng hợp
	    public void nhap() {
	        hoTen = nhapHoTen();
	        gioiTinh = nhapGioiTinh();
	        tuoi = nhapTuoi();
	        ngayThi = nhapNgayThi();
	        diemThi = nhapDiemThi();
	        xepLoai = xeploai(diemThi);
	    }

	    // Hàm xuất
	    LocalDate today = LocalDate.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    
	    public void xuat() {
	        System.out.println("BẢNG ĐIỂM THI SINH VIÊN\t");
	        System.out.println("HỌ TÊN\t\t: " + hoTen);
	        System.out.println("GIỚI TÍNH\t: " + gioiTinh);
	        System.out.println("TUỔI\t\t: " + tuoi);
	        System.out.println("NGÀY THI\t: " + ngayThi);
	        System.out.println("ĐIỂM THI\t: " + diemThi);
	        System.out.println("XẾP LOẠI\t: " + xepLoai);
	        System.out.println("Đà Nẵng, ngày " + today.format(formatter));
	        System.out.println("\tHiệu trưởng\t");
	        System.out.println("\tSơn\t");
	        System.out.println("\tTrương Thanh Sơn");
	   }
}
