import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class human {
    private String name;
    private int date;
    private int card;

    public human(String name, int date, int card) {
        this.name = name;
        this.date = date;
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public void inPut() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten: ");
        name = scanner.nextLine();
        System.out.print("Nhap ngay sinh: ");
        date = scanner.nextInt();
        System.out.print("Nhap so CMND: ");
        card = scanner.nextInt();
    }

    public void outPut() {
        System.out.println("Ten: " + name);
        System.out.println("Ngay sinh: " + date);
        System.out.println("So CMND: " + card);
    }
}

class khachThue extends human {
    private String loaiPhong;
    private int soNgayThue;
    private int donGia;

    public khachThue(String name, int date, int card, String loaiPhong, int soNgayThue, int donGia) {
        super(name, date, card);
        this.loaiPhong = loaiPhong;
        this.soNgayThue = soNgayThue;
        this.donGia = donGia;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public int getSoNgayThue() {
        return soNgayThue;
    }

    public void setSoNgayThue(int soNgayThue) {
        this.soNgayThue = soNgayThue;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    @Override
    public void inPut() {
        super.inPut();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap loai phong: ");
        loaiPhong = scanner.nextLine();
        System.out.print("Nhap so ngay thue: ");
        soNgayThue = scanner.nextInt();
        System.out.print("Nhap don gia: ");
        donGia = scanner.nextInt();
    }

    @Override
    public void outPut() {
        super.outPut();
        System.out.println("Loai phong: " + loaiPhong);
        System.out.println("So ngay thue: " + soNgayThue);
        System.out.println("Don gia: " + donGia);
    }

    public int tinhTien() {
        return soNgayThue * donGia;
    }

    public static void printInvoice(String cmnd) {
        Map<String, khachThue> khachThueMap = new HashMap<>();
        if (khachThueMap.containsKey(cmnd)) {
            khachThueMap.get(cmnd).outPut();
            System.out.println("Tong tien: " + khachThueMap.get(cmnd).tinhTien());
        }
    }
}

public class quanLySinhVien {
    public static void main(String[] args) {

        Map<Integer, khachThue> customerList = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong khach thue: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin khach thue thu " + (i + 1));
            System.out.print("Nhap so CMND: ");
            int cmnd = scanner.nextInt();
            khachThue khachThue = new khachThue(" ", 0, 0, " ", 0, 0);
            khachThue.inPut();
            customerList.put(cmnd, khachThue);
        }
        System.out.println("Danh sach khach thue: ");
        for (Map.Entry<Integer, khachThue> entry : customerList.entrySet()) {
            System.out.println("So CMND: " + entry.getKey());
            entry.getValue().outPut();
        }
        System.out.println("Nhap so CMND can tim: ");
        int cmnd = scanner.nextInt();
        if (customerList.containsKey(cmnd)) {
            System.out.println("Thong tin khach thue: ");
            customerList.get(cmnd).outPut();
        } else {
            System.out.println("Khong tim thay khach thue");
        }

    }
}
