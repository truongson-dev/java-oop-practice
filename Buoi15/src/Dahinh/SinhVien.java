package Dahinh;

import java.util.Collections;
import java.util.Scanner;

public abstract class SinhVien extends Person {
	protected String maSV;
	protected String gioiTinh;
	protected Khoa khoa;

	public SinhVien() {
	}

	@Override
	public void nhapThongTin(Scanner sc) {
		super.nhapThongTin(sc);

		this.maSV = Rangbuoc.kiemTraChuoi("Mã sinh viên: ", "^[a-zA-Z0-9]{6,10}$",
				"Mã SV phải từ 6-10 ký tự (chữ và số)!");

		this.gioiTinh = Rangbuoc.kiemTraGioiTinh();
	}

	@Override
	public void xuatThongTin() {
		System.out.printf("%-10s", maSV);
		super.xuatThongTin();
		System.out.printf("%-10s", gioiTinh);
		if (khoa != null) {
			System.out.printf("%-15s", khoa.getTenKhoa());
		} else {
			System.out.printf("%-15s", "Chưa phân");
		}
	}

	// Phương thức xuất tiêu đề bảng
	public static void xuatTieuDe() {
		System.out.println("\n" + String.join("", Collections.nCopies(95, "=")));
		System.out.printf("%-10s %-25s %-12s %-25s %-10s %-15s", "Mã SV", "Họ tên", "Ngày sinh", "Địa chỉ", "Giới tính",
				"Khoa");
		System.out.println("\n" + String.join("", Collections.nCopies(95, "-")));
	}

	// Phương thức xuất chân bảng
	public static void xuatChanBang() {
		System.out.println(String.join("", Collections.nCopies(95, "=")));
	}

	// Phương thức trừu tượng để đa hình
	public abstract String getXepLoai();

	public abstract boolean isTotNghiep();

	public abstract float getDiemSo();

	public abstract void nhapThongTinHocTap(Scanner sc);

	public abstract void xuatThongTinHocTap();

	public String getMaSV() {
		return maSV;
	}

	public void setKhoa(Khoa khoa2) {
		this.khoa = khoa2;
	}

	public Khoa getKhoa() {
		return khoa;
	}
}