package Dahinh;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Khoa {
	private String tenKhoa;
	private Date ngayTL;
	private School truong;
	private List<SinhVien> danhSachSV;

	public Khoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
		this.ngayTL = new Date();
		this.danhSachSV = new ArrayList<>();
	}

	public void nhapThongTin(Scanner sc) {
		System.out.print("Nhập tên khoa: ");
		tenKhoa = sc.nextLine();
		System.out.print("Nhập ngày thành lập (dd/MM/yyyy): ");
		try {
			ngayTL = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
		} catch (Exception e) {
			ngayTL = new Date();
		}
	}

	public void xuatThongTin() {
		System.out.println("Tên khoa: " + tenKhoa);
		System.out.println("Ngày TL: " + new SimpleDateFormat("dd/MM/yyyy").format(ngayTL));
		if (truong != null) {
			System.out.println("Trường: " + truong.getTenTruong());
		}
	}

	public void themSinhVien(SinhVien sv) {
		danhSachSV.add(sv);
		sv.setKhoa(this);
	}

	public String getTenKhoa() {
		return tenKhoa;
	}

	public List<SinhVien> getDanhSachSV() {
		return danhSachSV;
	}

	public void setTruong(School truong) {
		this.truong = truong;
	}
}
