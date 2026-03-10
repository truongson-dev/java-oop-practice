package Dahinh;

public class CaoDang extends SinhVienNienChe {
	public CaoDang() {
		nienChe = 3;
	}

	@Override
	public void xuatThongTin() {
		super.xuatThongTin();
		System.out.printf("%-15s %-10s %-10s %-12s", "Cao đẳng", nienChe + " năm", diemTN, xepLoai);
	}

	@Override
	public void xuatThongTinHocTap() {
		System.out.println("Hệ: Niên chế (Cao đẳng)");
		System.out.println("Niên chế: " + nienChe + " năm");
		System.out.println("Điểm TN: " + diemTN);
		System.out.println("Xếp loại: " + xepLoai);
		System.out.println("Tốt nghiệp: " + (isTotNghiep() ? "Đạt" : "Không đạt"));
	}
}