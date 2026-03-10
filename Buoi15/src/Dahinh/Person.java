package Dahinh;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Person {
	protected String hoTen;
	protected Date ngaySinh;
	protected String diaChi;

	public Person() {
	}

	public void nhapThongTin(Scanner sc) {
		this.hoTen = Rangbuoc.kiemTraChuoi("Họ tên: ",
				"^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$",
				"Họ tên chỉ được chứa chữ cái và dấu cách!");

		this.ngaySinh = Rangbuoc.kiemTraNgay("Ngày sinh");

		this.diaChi = Rangbuoc.kiemTraChuoi("Địa chỉ: ", "^[a-zA-Z0-9À-ỹ,\\s./-]+$",
				"Địa chỉ không được chứa ký tự đặc biệt ngoài , . / -");
	}

	public void xuatThongTin() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.printf("%-25s", hoTen);
		System.out.printf("%-12s", sdf.format(ngaySinh));
		System.out.printf("%-25s", diaChi);
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
}