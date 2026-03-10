package Dahinh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuanLySinhVien {
	private List<SinhVien> danhSachSV;
	private List<Khoa> danhSachKhoa;
	private Scanner sc;

	public QuanLySinhVien() {
		danhSachSV = new ArrayList<>();
		danhSachKhoa = new ArrayList<>();
		sc = new Scanner(System.in);
		new School("ĐH Công Nghiệp");

		// Khởi tạo một số khoa mẫu
		khoiTaoDuLieuMau();
	}

	private void khoiTaoDuLieuMau() {
		Khoa cntt = new Khoa("Công nghệ Thông tin");
		Khoa kt = new Khoa("Kế Toán");
		Khoa qt = new Khoa("Quản trị Kinh doanh");
		danhSachKhoa.add(cntt);
		danhSachKhoa.add(kt);
		danhSachKhoa.add(qt);

		// Thêm dữ liệu mẫu
		SinhVien sv1 = new SinhVienTinChi();
		sv1.maSV = "SV001";
		sv1.hoTen = "Nguyễn Văn A";
		sv1.diaChi = "Hà Nội";
		sv1.gioiTinh = "Nam";
		((SinhVienTinChi) sv1).setDiemDG(4.8f);
		sv1.setKhoa(cntt);
		danhSachSV.add(sv1);
		cntt.themSinhVien(sv1);

		SinhVien sv2 = new CaoDang();
		sv2.maSV = "SV002";
		sv2.hoTen = "Trần Thị B";
		sv2.diaChi = "Hải Phòng";
		sv2.gioiTinh = "Nữ";
		((CaoDang) sv2).setDiemTN(8.5f);
		sv2.setKhoa(kt);
		danhSachSV.add(sv2);
		kt.themSinhVien(sv2);
	}

	// ========== NHÓM 1: QUẢN LÝ THÔNG TIN ==========

	public void nhapThongTinSV() {
		System.out.println("\n=== CHỌN HỆ ĐÀO TẠO ===");
		System.out.println("1. Hệ Tín chỉ (Đại học)");
		System.out.println("2. Hệ Niên chế (Cao đẳng)");
		System.out.println("3. Hệ Niên chế (Trung cấp)");
		int choice = Rangbuoc.kiemTraLuaChon("Lựa chọn: ", 1, 3);

		SinhVien sv = null;
		switch (choice) {
		case 1:
			sv = new SinhVienTinChi();
			break;
		case 2:
			sv = new CaoDang();
			break;
		case 3:
			sv = new TrungCap();
			break;
		}

		System.out.println("\n=== NHẬP THÔNG TIN CÁ NHÂN ===");
		sv.nhapThongTin(sc);

		System.out.println("\n=== NHẬP THÔNG TIN HỌC TẬP ===");
		sv.nhapThongTinHocTap(sc);

		// Chọn khoa
		System.out.println("\n=== CHỌN KHOA ===");
		for (int i = 0; i < danhSachKhoa.size(); i++) {
			System.out.println((i + 1) + ". " + danhSachKhoa.get(i).getTenKhoa());
		}
		System.out.println("0. Không chọn khoa");

		int khoaIdx = Rangbuoc.kiemTraLuaChon("Chọn khoa: ", 0, danhSachKhoa.size());

		if (khoaIdx > 0) {
			danhSachKhoa.get(khoaIdx - 1).themSinhVien(sv);
		}

		danhSachSV.add(sv);
		System.out.println("✓ Thêm sinh viên thành công!");
	}

	public void capNhatDiaChi() {
		if (danhSachSV.isEmpty()) {
			System.out.println("Danh sách sinh viên trống!");
			return;
		}

		String ma = Rangbuoc.kiemTraChuoi("Nhập mã SV cần cập nhật: ", "^[a-zA-Z0-9]{6,10}$", "Mã SV không hợp lệ!");

		for (SinhVien sv : danhSachSV) {
			if (sv.getMaSV().equalsIgnoreCase(ma)) {
				System.out.println("Tìm thấy sinh viên: " + sv.getHoTen());
				String diaChiMoi = Rangbuoc.kiemTraChuoi("Nhập địa chỉ mới: ", "^[a-zA-Z0-9À-ỹ,\\s./-]+$",
						"Địa chỉ không hợp lệ!");
				sv.setDiaChi(diaChiMoi);
				System.out.println("✓ Cập nhật địa chỉ thành công!");
				return;
			}
		}
		System.out.println("✗ Không tìm thấy sinh viên với mã: " + ma);
	}

	public void capNhatDiem() {
		if (danhSachSV.isEmpty()) {
			System.out.println("Danh sách sinh viên trống!");
			return;
		}

		String ma = Rangbuoc.kiemTraChuoi("Nhập mã SV cần cập nhật điểm: ", "^[a-zA-Z0-9]{6,10}$",
				"Mã SV không hợp lệ!");

		for (SinhVien sv : danhSachSV) {
			if (sv.getMaSV().equalsIgnoreCase(ma)) {
				System.out.println("Tìm thấy sinh viên: " + sv.getHoTen());

				if (sv instanceof SinhVienTinChi) {
					float diemMoi = Rangbuoc.kiemTraSoThuc("Nhập điểm đánh giá mới (0-5): ", 0, 5);
					((SinhVienTinChi) sv).setDiemDG(diemMoi);
				} else if (sv instanceof SinhVienNienChe) {
					float diemMoi = Rangbuoc.kiemTraSoThuc("Nhập điểm TN mới (0-10): ", 0, 10);
					((SinhVienNienChe) sv).setDiemTN(diemMoi);
				}
				System.out.println("✓ Cập nhật điểm thành công!");
				return;
			}
		}
		System.out.println("✗ Không tìm thấy sinh viên với mã: " + ma);
	}

	public void xuatDanhSach() {
		if (danhSachSV.isEmpty()) {
			System.out.println("Danh sách sinh viên trống!");
			return;
		}

		System.out.println("\n=== DANH SÁCH SINH VIÊN TOÀN TRƯỜNG ===");
		SinhVien.xuatTieuDe();

		int stt = 1;
		for (SinhVien sv : danhSachSV) {
			System.out.printf("%-3d ", stt++);
			sv.xuatThongTin();
			System.out.println();
		}

		SinhVien.xuatChanBang();
		System.out.println("Tổng số: " + danhSachSV.size() + " sinh viên");
	}

	public void xuatTheoKhoa() {
		if (danhSachKhoa.isEmpty()) {
			System.out.println("Chưa có khoa nào!");
			return;
		}

		System.out.println("\n=== DANH SÁCH SINH VIÊN THEO KHOA ===");

		for (Khoa khoa : danhSachKhoa) {
			List<SinhVien> dsSV = khoa.getDanhSachSV();
			if (!dsSV.isEmpty()) {
				System.out.println("\n--- KHOA: " + khoa.getTenKhoa() + " (" + dsSV.size() + " SV) ---");
				SinhVien.xuatTieuDe();

				int stt = 1;
				for (SinhVien sv : dsSV) {
					System.out.printf("%-3d ", stt++);
					sv.xuatThongTin();
					System.out.println();
				}
				SinhVien.xuatChanBang();
			}
		}
	}

	public void xuatTheoHe() {
		if (danhSachSV.isEmpty()) {
			System.out.println("Danh sách sinh viên trống!");
			return;
		}

		// Hệ tín chỉ
		System.out.println("\n=== HỆ TÍN CHỈ (ĐẠI HỌC) ===");
		boolean coSV = false;
		SinhVienTinChi.xuatTieuDeChiTiet();

		int stt = 1;
		for (SinhVien sv : danhSachSV) {
			if (sv instanceof SinhVienTinChi) {
				System.out.printf("%-3d ", stt++);
				sv.xuatThongTin();
				System.out.println();
				coSV = true;
			}
		}

		if (!coSV) {
			System.out.println("Chưa có sinh viên hệ tín chỉ!");
		} else {
			System.out.println(String.join("", Collections.nCopies(150, "=")));
		}

		// Hệ niên chế
		System.out.println("\n=== HỆ NIÊN CHẾ ===");
		coSV = false;
		SinhVienNienChe.xuatTieuDeChiTiet();

		stt = 1;
		for (SinhVien sv : danhSachSV) {
			if (sv instanceof SinhVienNienChe) {
				System.out.printf("%-3d ", stt++);
				sv.xuatThongTin();
				System.out.println();
				coSV = true;
			}
		}

		if (!coSV) {
			System.out.println("Chưa có sinh viên hệ niên chế!");
		} else {
			System.out.println(String.join("", Collections.nCopies(120, "=")));
		}
	}

	// ========== NHÓM 2: XỬ LÝ HỌC TẬP ==========

	public void xuatXepLoai() {
		if (danhSachSV.isEmpty()) {
			System.out.println("Danh sách sinh viên trống!");
			return;
		}

		System.out.println("\n=== XẾP LOẠI SINH VIÊN ===");
		System.out.println(String.join("", Collections.nCopies(60, "=")));
		System.out.printf("%-10s %-25s %-15s %-10s\n", "Mã SV", "Họ tên", "Hệ đào tạo", "Xếp loại");
		System.out.println(String.join("", Collections.nCopies(60, "-")));

		for (SinhVien sv : danhSachSV) {
			String heDaoTao = (sv instanceof SinhVienTinChi) ? "Đại học"
					: (sv instanceof CaoDang) ? "Cao đẳng" : "Trung cấp";
			System.out.printf("%-10s %-25s %-15s %-10s\n", sv.getMaSV(), sv.getHoTen(), heDaoTao, sv.getXepLoai());
		}
		System.out.println(String.join("", Collections.nCopies(60, "=")));
	}

	public void xetTotNghiep() {
		if (danhSachSV.isEmpty()) {
			System.out.println("Danh sách sinh viên trống!");
			return;
		}

		System.out.println("\n=== XÉT TỐT NGHIỆP ===");
		System.out.println(String.join("", Collections.nCopies(70, "=")));
		System.out.printf("%-10s %-25s %-15s %-10s %-10s\n", "Mã SV", "Họ tên", "Hệ đào tạo", "Xếp loại", "Kết quả");
		System.out.println(String.join("", Collections.nCopies(70, "-")));

		int countDat = 0;
		for (SinhVien sv : danhSachSV) {
			String heDaoTao = (sv instanceof SinhVienTinChi) ? "Đại học"
					: (sv instanceof CaoDang) ? "Cao đẳng" : "Trung cấp";
			String ketQua = sv.isTotNghiep() ? "ĐẠT" : "KHÔNG ĐẠT";
			if (sv.isTotNghiep()) {
				countDat++;
			}

			System.out.printf("%-10s %-25s %-15s %-10s %-10s\n", sv.getMaSV(), sv.getHoTen(), heDaoTao, sv.getXepLoai(),
					ketQua);
		}
		System.out.println(String.join("", Collections.nCopies(70, "=")));
		System.out.printf("Tỷ lệ tốt nghiệp: %.1f%% (%d/%d)\n",
				(danhSachSV.size() > 0 ? (countDat * 100.0 / danhSachSV.size()) : 0), countDat, danhSachSV.size());
	}

	// ========== NHÓM 3: THỐNG KÊ ==========

	public void thongKeSoLuong() {
		System.out.println("\n=== THỐNG KÊ SỐ LƯỢNG ===");
		System.out.println(String.join("", Collections.nCopies(50, "=")));

		int cntTinChi = 0, cntCaoDang = 0, cntTrungCap = 0;

		for (SinhVien sv : danhSachSV) {
			if (sv instanceof SinhVienTinChi) {
				cntTinChi++;
			} else if (sv instanceof CaoDang) {
				cntCaoDang++;
			} else if (sv instanceof TrungCap) {
				cntTrungCap++;
			}
		}

		System.out.printf("Tổng số SV: %d\n", danhSachSV.size());
		System.out.printf("Hệ tín chỉ (Đại học): %d (%.1f%%)\n", cntTinChi,
				danhSachSV.size() > 0 ? (cntTinChi * 100.0 / danhSachSV.size()) : 0);
		System.out.printf("Hệ cao đẳng: %d (%.1f%%)\n", cntCaoDang,
				danhSachSV.size() > 0 ? (cntCaoDang * 100.0 / danhSachSV.size()) : 0);
		System.out.printf("Hệ trung cấp: %d (%.1f%%)\n", cntTrungCap,
				danhSachSV.size() > 0 ? (cntTrungCap * 100.0 / danhSachSV.size()) : 0);

		System.out.println("\n--- THEO KHOA ---");
		for (Khoa khoa : danhSachKhoa) {
			System.out.printf("Khoa %-25s: %d SV\n", khoa.getTenKhoa(), khoa.getDanhSachSV().size());
		}
		System.out.println(String.join("", Collections.nCopies(50, "=")));
	}

	public void thongKeKetQua() {
		System.out.println("\n=== THỐNG KÊ KẾT QUẢ ===");
		System.out.println(String.join("", Collections.nCopies(60, "=")));

		int cntA = 0, cntB = 0, cntC = 0, cntD = 0;
		int cntGioi = 0, cntKha = 0, cntTB = 0, cntYeu = 0;

		for (SinhVien sv : danhSachSV) {
			String xl = sv.getXepLoai();
			if (sv instanceof SinhVienTinChi) {
				switch (xl) {
				case "A":
					cntA++;
					break;
				case "B":
					cntB++;
					break;
				case "C":
					cntC++;
					break;
				case "D":
					cntD++;
					break;
				}
			} else {
				switch (xl) {
				case "Giỏi":
					cntGioi++;
					break;
				case "Khá":
					cntKha++;
					break;
				case "Trung bình":
					cntTB++;
					break;
				case "Yếu":
					cntYeu++;
					break;
				}
			}
		}

		System.out.println("HỆ TÍN CHỈ (A/B/C/D):");
		System.out.printf("A: %-3d | B: %-3d | C: %-3d | D: %-3d\n", cntA, cntB, cntC, cntD);

		System.out.println("\nHỆ NIÊN CHẾ (Giỏi/Khá/TB/Yếu):");
		System.out.printf("Giỏi: %-3d | Khá: %-3d | TB: %-3d | Yếu: %-3d\n", cntGioi, cntKha, cntTB, cntYeu);

		System.out.println(String.join("", Collections.nCopies(60, "=")));
	}

	// ========== NHÓM 4: NÂNG CAO ==========

	public void danhSachKhenThuong() {
		System.out.println("\n=== DANH SÁCH KHEN THƯỞNG CUỐI KHÓA ===");
		System.out.println(String.join("", Collections.nCopies(80, "=")));
		System.out.printf("%-10s %-25s %-15s %-15s %-15s\n", "Mã SV", "Họ tên", "Khoa", "Hệ đào tạo", "Xếp loại");
		System.out.println(String.join("", Collections.nCopies(80, "-")));

		boolean coSV = false;
		for (SinhVien sv : danhSachSV) {
			if ((sv instanceof SinhVienTinChi && sv.getXepLoai().equals("A"))
					|| (sv instanceof SinhVienNienChe && sv.getXepLoai().equals("Giỏi"))) {

				String heDaoTao = (sv instanceof SinhVienTinChi) ? "Đại học"
						: (sv instanceof CaoDang) ? "Cao đẳng" : "Trung cấp";
				String khoa = (sv.getKhoa() != null) ? sv.getKhoa().getTenKhoa() : "Chưa phân";

				System.out.printf("%-10s %-25s %-15s %-15s %-15s\n", sv.getMaSV(), sv.getHoTen(), khoa, heDaoTao,
						sv.getXepLoai());
				coSV = true;
			}
		}

		if (!coSV) {
			System.out.println("Không có sinh viên nào đủ điều kiện khen thưởng!");
		}
		System.out.println(String.join("", Collections.nCopies(80, "=")));
	}

	public void timKiemTheoMa() {
		if (danhSachSV.isEmpty()) {
			System.out.println("Danh sách sinh viên trống!");
			return;
		}

		String ma = Rangbuoc.kiemTraChuoi("Nhập mã SV cần tìm: ", "^[a-zA-Z0-9]{6,10}$", "Mã SV không hợp lệ!");

		System.out.println("\n=== KẾT QUẢ TÌM KIẾM ===");
		boolean found = false;
		for (SinhVien sv : danhSachSV) {
			if (sv.getMaSV().equalsIgnoreCase(ma)) {
				sv.xuatThongTinHocTap();
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("✗ Không tìm thấy sinh viên với mã: " + ma);
		}
	}

	public void timKiemTheoTen() {
		if (danhSachSV.isEmpty()) {
			System.out.println("Danh sách sinh viên trống!");
			return;
		}

		System.out.print("Nhập tên cần tìm: ");
		String ten = sc.nextLine().trim().toLowerCase();

		System.out.println("\n=== KẾT QUẢ TÌM KIẾM ===");
		boolean found = false;
		for (SinhVien sv : danhSachSV) {
			if (sv.getHoTen().toLowerCase().contains(ten)) {
				if (!found) {
					SinhVien.xuatTieuDe();
					found = true;
				}
				sv.xuatThongTin();
				System.out.println();
			}
		}
		if (!found) {
			System.out.println("✗ Không tìm thấy sinh viên với tên chứa: " + ten);
		} else {
			SinhVien.xuatChanBang();
		}
	}

	public void sapXepTheoMa() {
		if (danhSachSV.isEmpty()) {
			System.out.println("Danh sách sinh viên trống!");
			return;
		}

		danhSachSV.sort((sv1, sv2) -> sv1.getMaSV().compareToIgnoreCase(sv2.getMaSV()));
		System.out.println("✓ Đã sắp xếp danh sách theo mã sinh viên!");
	}

	public void sapXepTheoTen() {
		if (danhSachSV.isEmpty()) {
			System.out.println("Danh sách sinh viên trống!");
			return;
		}

		danhSachSV.sort((sv1, sv2) -> {
			// Tách tên từ họ tên (lấy phần tử cuối cùng)
			String[] ten1 = sv1.getHoTen().split("\\s+");
			String[] ten2 = sv2.getHoTen().split("\\s+");
			return ten1[ten1.length - 1].compareToIgnoreCase(ten2[ten2.length - 1]);
		});
		System.out.println("✓ Đã sắp xếp danh sách theo tên!");
	}

	public void sapXepTheoDiem() {
		if (danhSachSV.isEmpty()) {
			System.out.println("Danh sách sinh viên trống!");
			return;
		}

		// Tách riêng các hệ
		List<SinhVien> tinChi = new ArrayList<>();
		List<SinhVien> caoDang = new ArrayList<>();
		List<SinhVien> trungCap = new ArrayList<>();

		for (SinhVien sv : danhSachSV) {
			if (sv instanceof SinhVienTinChi) {
				tinChi.add(sv);
			} else if (sv instanceof CaoDang) {
				caoDang.add(sv);
			} else if (sv instanceof TrungCap) {
				trungCap.add(sv);
			}
		}

		// Sắp xếp giảm dần theo điểm
		tinChi.sort((sv1, sv2) -> Float.compare(sv2.getDiemSo(), sv1.getDiemSo()));
		caoDang.sort((sv1, sv2) -> Float.compare(sv2.getDiemSo(), sv1.getDiemSo()));
		trungCap.sort((sv1, sv2) -> Float.compare(sv2.getDiemSo(), sv1.getDiemSo()));

		// Gộp lại
		danhSachSV.clear();
		danhSachSV.addAll(tinChi);
		danhSachSV.addAll(caoDang);
		danhSachSV.addAll(trungCap);

		System.out.println("✓ Đã sắp xếp danh sách theo điểm (giảm dần)!");
	}

	// ========== MENU CHÍNH ==========

	public void hienThiMenu() {
		System.out.println("\n" + String.join("", Collections.nCopies(50, "=")));
		System.out.println("       QUẢN LÝ SINH VIÊN");
		System.out.println(String.join("", Collections.nCopies(50, "=")));
		System.out.println("NHÓM 1: QUẢN LÝ THÔNG TIN");
		System.out.println("  1. Nhập thông tin sinh viên mới");
		System.out.println("  2. Xuất toàn bộ sinh viên");
		System.out.println("  3. Cập nhật địa chỉ sinh viên");
		System.out.println("  4. Cập nhật điểm sinh viên");
		System.out.println("  5. Xuất danh sách theo khoa");
		System.out.println("  6. Xuất danh sách theo hệ đào tạo");
		System.out.println("\nNHÓM 2: XỬ LÝ HỌC TẬP");
		System.out.println("  7. Xem xếp loại sinh viên");
		System.out.println("  8. Xét tốt nghiệp");
		System.out.println("\nNHÓM 3: THỐNG KÊ");
		System.out.println("  9. Thống kê số lượng");
		System.out.println(" 10. Thống kê kết quả học tập");
		System.out.println("\nNHÓM 4: NÂNG CAO");
		System.out.println(" 11. Danh sách khen thưởng cuối khóa");
		System.out.println(" 12. Tìm kiếm theo mã sinh viên");
		System.out.println(" 13. Tìm kiếm theo tên sinh viên");
		System.out.println(" 14. Sắp xếp theo mã sinh viên");
		System.out.println(" 15. Sắp xếp theo tên sinh viên");
		System.out.println(" 16. Sắp xếp theo điểm");
		System.out.println("\n  0. Thoát chương trình");
		System.out.println(String.join("", Collections.nCopies(50, "-")));
	}

	public void menu() {
		int choice;

		do {
			hienThiMenu();
			choice = Rangbuoc.kiemTraLuaChon("Lựa chọn của bạn: ", 0, 16);

			switch (choice) {
			case 1:
				nhapThongTinSV();
				break;
			case 2:
				xuatDanhSach();
				break;
			case 3:
				capNhatDiaChi();
				break;
			case 4:
				capNhatDiem();
				break;
			case 5:
				xuatTheoKhoa();
				break;
			case 6:
				xuatTheoHe();
				break;
			case 7:
				xuatXepLoai();
				break;
			case 8:
				xetTotNghiep();
				break;
			case 9:
				thongKeSoLuong();
				break;
			case 10:
				thongKeKetQua();
				break;
			case 11:
				danhSachKhenThuong();
				break;
			case 12:
				timKiemTheoMa();
				break;
			case 13:
				timKiemTheoTen();
				break;
			case 14:
				sapXepTheoMa();
				break;
			case 15:
				sapXepTheoTen();
				break;
			case 16:
				sapXepTheoDiem();
				break;
			case 0:
				System.out.println("\nCảm ơn bạn đã sử dụng chương trình!");
				System.out.println("Chương trình kết thúc!");
				break;
			}

			if (choice != 0) {
				System.out.print("\nNhấn Enter để tiếp tục...");
				sc.nextLine();
			}
		} while (choice != 0);

		sc.close();
	}

	public static void main(String[] args) {
		QuanLySinhVien ql = new QuanLySinhVien();
		ql.menu();
	}
}