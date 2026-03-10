package Dahinh;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Rangbuoc {
	private static Scanner sc = new Scanner(System.in);

	// Kiểm tra chuỗi không rỗng và không chứa ký tự đặc biệt
	public static String kiemTraChuoi(String prompt, String regex, String errorMsg) {
		while (true) {
			System.out.print(prompt);
			String input = sc.nextLine().trim();
			if (input.isEmpty()) {
				System.out.println("Không được để trống!");
				continue;
			}
			if (regex != null && !Pattern.matches(regex, input)) {
				System.out.println(errorMsg);
				continue;
			}
			return input;
		}
	}

	// Kiểm tra số nguyên trong khoảng
	public static int kiemTraSoNguyen(String prompt, int min, int max) {
		while (true) {
			try {
				System.out.print(prompt);
				int num = Integer.parseInt(sc.nextLine().trim());
				if (num < min || num > max) {
					System.out.println("Vui lòng nhập số từ " + min + " đến " + max);
					continue;
				}
				return num;
			} catch (NumberFormatException e) {
				System.out.println("Vui lòng nhập số nguyên hợp lệ!");
			}
		}
	}

	// Kiểm tra số thực trong khoảng
	public static float kiemTraSoThuc(String prompt, float min, float max) {
		while (true) {
			try {
				System.out.print(prompt);
				float num = Float.parseFloat(sc.nextLine().trim());
				if (num < min || num > max) {
					System.out.println("Vui lòng nhập số từ " + min + " đến " + max);
					continue;
				}
				return num;
			} catch (NumberFormatException e) {
				System.out.println("Vui lòng nhập số hợp lệ!");
			}
		}
	}

	// Kiểm tra ngày tháng đúng định dạng
	public static Date kiemTraNgay(String prompt) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false); // Không chấp nhận ngày không hợp lệ

		while (true) {
			System.out.print(prompt + " (dd/MM/yyyy): ");
			String dateStr = sc.nextLine().trim();

			if (!Pattern.matches("^\\d{2}/\\d{2}/\\d{4}$", dateStr)) {
				System.out.println("Định dạng phải là dd/MM/yyyy!");
				continue;
			}

			try {
				Date date = sdf.parse(dateStr);
				// Kiểm tra ngày không trong tương lai
				if (date.after(new Date())) {
					System.out.println("Ngày sinh không thể ở tương lai!");
					continue;
				}
				return date;
			} catch (Exception e) {
				System.out.println("Ngày không hợp lệ! Vui lòng nhập lại.");
			}
		}
	}

	// Kiểm tra giới tính
	public static String kiemTraGioiTinh() {
		while (true) {
			System.out.print("Giới tính (Nam/Nữ/Khác): ");
			String gt = sc.nextLine().trim();
			if (gt.equalsIgnoreCase("Nam") || gt.equalsIgnoreCase("Nữ") || gt.equalsIgnoreCase("Khác")) {
				return gt;
			}
			System.out.println("Vui lòng nhập: Nam, Nữ hoặc Khác");
		}
	}

	// Kiểm tra lựa chọn menu
	public static int kiemTraLuaChon(String prompt, int min, int max) {
		return kiemTraSoNguyen(prompt, min, max);
	}

	public Object getTenKhoa() {
		// TODO Auto-generated method stub
		return null;
	}
}
