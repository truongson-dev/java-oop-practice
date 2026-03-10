package Dahinh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class School {
	private String tenTruong;
	private List<Khoa> danhSachKhoa;

	public School(String tenTruong) {
		this.tenTruong = tenTruong;
		new Date();
		this.danhSachKhoa = new ArrayList<>();
	}

	public void themKhoa(Khoa khoa) {
		danhSachKhoa.add(khoa);
		khoa.setTruong(this);
	}

	public String getTenTruong() {
		return tenTruong;
	}

	public List<Khoa> getDanhSachKhoa() {
		return danhSachKhoa;
	}
}