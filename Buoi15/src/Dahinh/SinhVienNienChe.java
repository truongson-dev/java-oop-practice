package Dahinh;

import java.util.Collections;
import java.util.Scanner;

public abstract class SinhVienNienChe extends SinhVien {
	protected int nienChe;
	protected float diemTN;
	protected String xepLoai;

	@Override
	public void nhapThongTinHocTap(Scanner sc) {
		this.diemTN = Rangbuoc.kiemTraSoThuc("Điểm tốt nghiệp (0-10): ", 0, 10);
		tinhXepLoai();
	}

	protected void tinhXepLoai() {
		if (diemTN >= 8) {
			xepLoai = "Giỏi";
		} else if (diemTN >= 6.5) {
			xepLoai = "Khá";
		} else if (diemTN >= 5) {
			xepLoai = "Trung bình";
		} else {
			xepLoai = "Yếu";
		}
	}

	@Override
	public String getXepLoai() {
		return xepLoai;
	}

	@Override
	public boolean isTotNghiep() {
		return diemTN >= 5;
	}

	@Override
	public float getDiemSo() {
		return diemTN;
	}

	// Cập nhật điểm
	public void setDiemTN(float diemTN) {
		this.diemTN = diemTN;
		tinhXepLoai();
	}

	// Xuất tiêu đề bảng chi tiết cho niên chế
	public static void xuatTieuDeChiTiet() {
		System.out.println("\n" + String.join("", Collections.nCopies(120, "=")));
		System.out.printf("%-10s %-25s %-12s %-25s %-10s %-15s %-15s %-10s %-12s", "Mã SV", "Họ tên", "Ngày sinh",
				"Địa chỉ", "Giới tính", "Khoa", "Hệ đào tạo", "Niên chế", "Điểm TN", "Xếp loại");
		System.out.println("\n" + String.join("", Collections.nCopies(120, "-")));
	}
}