package Bai3;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== KIỂM THỬ TÀI KHOẢN THẤU CHI ===\n");

		// Tạo tài khoản thấu chi mẫu
		System.out.println("1. Tạo tài khoản thấu chi:");
		OverdraftAccount account = new OverdraftAccount("OD001", 5000000, 10000000);
		System.out.println("Tài khoản vừa tạo:");
		System.out.println(account);

		// Test rút tiền
		System.out.println("\n2. Test rút tiền:");
		System.out.print("Nhập số tiền muốn rút: ");
		double withdrawAmount = scanner.nextDouble();

		boolean result = account.withdraw(withdrawAmount);
		if (result) {
			System.out.println("✅ Rút tiền thành công!");
			System.out.println("Thông tin sau khi rút:");
			System.out.println(account);
		} else {
			System.out.println("❌ Rút tiền thất bại! Vượt quá hạn mức.");
		}

		// Test nạp tiền
		System.out.println("\n3. Test nạp tiền:");
		System.out.print("Nhập số tiền muốn nạp: ");
		double depositAmount = scanner.nextDouble();

		account.deposit(depositAmount);
		System.out.println("✅ Nạp tiền thành công!");
		System.out.println("Thông tin sau khi nạp:");
		System.out.println(account);

		// Test cập nhật hạn mức
		System.out.println("\n4. Test cập nhật hạn mức:");
		System.out.print("Nhập hạn mức mới: ");
		double newLimit = scanner.nextDouble();

		account.setODLimit(newLimit);
		System.out.println("✅ Cập nhật hạn mức thành công!");
		System.out.println("Thông tin sau khi cập nhật:");
		System.out.println(account);

		// Test thấu chi vượt quá hạn mức
		System.out.println("\n5. Test rút vượt hạn mức:");
		double largeWithdraw = account.getAvailableBalance() + 1000000;
		System.out.println("Thử rút: " + largeWithdraw);

		boolean failResult = account.withdraw(largeWithdraw);
		if (!failResult) {
			System.out.println("❌ (Đúng) Rút tiền thất bại - Vượt quá hạn mức!");
		}

		System.out.println("\n=== KẾT THÚC KIỂM THỬ ===");
		scanner.close();
	}

	public static String inputNonEmptyString(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public static double inputDouble(String string) {
		// TODO Auto-generated method stub
		return 0;
	}
}