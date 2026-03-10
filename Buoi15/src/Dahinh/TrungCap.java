package Dahinh;

public class TrungCap extends SinhVienNienChe {
	public TrungCap() {
		nienChe = 2;
	}

	@Override
	public void xuatThongTin() {
		super.xuatThongTin();
		System.out.printf("%-15s %-10s %-10s %-12s", "Trung cấp", nienChe + " năm", diemTN, xepLoai);
	}

	@Override
	public void xuatThongTinHocTap() {
		System.out.println("Hệ: Niên chế (Trung cấp)");
		System.out.println("Niên chế: " + nienChe + " năm");
		System.out.println("Điểm TN: " + diemTN);
		System.out.println("Xếp loại: " + xepLoai);
		System.out.println("Tốt nghiệp: " + (isTotNghiep() ? "Đạt" : "Không đạt"));
	}
}