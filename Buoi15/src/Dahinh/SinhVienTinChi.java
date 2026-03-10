package Dahinh;

import java.util.Collections;
import java.util.Scanner;

public class SinhVienTinChi extends SinhVien {
	private int tinChi;
	private String tenDeTai;
	private float diemDG;
	private String xepLoai;

	@Override
	public void nhapThongTinHocTap(Scanner sc) {
		this.tinChi = Rangbuoc.kiemTraSoNguyen("Số tín chỉ: ", 0, 200);

		this.tenDeTai = Rangbuoc.kiemTraChuoi("Tên đề tài: ", "^[a-zA-Z0-9À-ỹ,\\s.!?()-]+$",
				"Tên đề tài không được chứa ký tự đặc biệt!");

		this.diemDG = Rangbuoc.kiemTraSoThuc("Điểm đánh giá (0-5): ", 0, 5);
		tinhXepLoai();
	}

	private void tinhXepLoai() {
		if (diemDG >= 4.5) {
			xepLoai = "A";
		} else if (diemDG >= 3.5) {
			xepLoai = "B";
		} else if (diemDG >= 2.5) {
			xepLoai = "C";
		} else {
			xepLoai = "D";
		}
	}

	@Override
	public String getXepLoai() {
		return xepLoai;
	}

	@Override
	public boolean isTotNghiep() {
		return tinChi >= 120 && diemDG >= 2.5;
	}

	@Override
	public float getDiemSo() {
		return diemDG;
	}

	@Override
	public void xuatThongTin() {
		super.xuatThongTin();
		System.out.printf("%-15s %-10s %-15s %-10s %-12s", "Đại học", tinChi, tenDeTai, diemDG, xepLoai);
	}

	@Override
	public void xuatThongTinHocTap() {
		System.out.println("Hệ: Tín chỉ (Đại học)");
		System.out.println("Số tín chỉ: " + tinChi);
		System.out.println("Đề tài: " + tenDeTai);
		System.out.println("Điểm đánh giá: " + diemDG);
		System.out.println("Xếp loại: " + xepLoai);
		System.out.println("Tốt nghiệp: " + (isTotNghiep() ? "Đạt" : "Không đạt"));
	}

	// Cập nhật điểm
	public void setDiemDG(float diemDG) {
		this.diemDG = diemDG;
		tinhXepLoai();
	}

	// Xuất tiêu đề bảng chi tiết
	public static void xuatTieuDeChiTiet() {
		System.out.println("\n" + String.join("", Collections.nCopies(150, "=")));
		System.out.printf("%-10s %-25s %-12s %-25s %-10s %-15s %-15s %-10s %-15s %-10s %-12s", "Mã SV", "Họ tên",
				"Ngày sinh", "Địa chỉ", "Giới tính", "Khoa", "Hệ đào tạo", "Tín chỉ", "Đề tài", "Điểm", "Xếp loại");
		System.out.println("\n" + String.join("", Collections.nCopies(150, "-")));
	}
}