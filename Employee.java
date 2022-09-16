
public class Employee extends Staff implements ICalculator{

    private int gio_lam_them;                    //số giờ làm thêm

    public int getGlt() {return gio_lam_them;}
    public void setGlt(int gio_lam_them) {this.gio_lam_them = gio_lam_them;}

    //method constructor rỗng
    public Employee() {

    }
    //method constructor chứa tham số
    public  Employee(String ma_thanh_vien, String ten, int tuoi, double he_so_luong, String ngay_vao_lam, int ngay_nghi_phep, String bo_phan, int gio_lam_them){
        super(ma_thanh_vien, ten, tuoi, he_so_luong, ngay_vao_lam, ngay_nghi_phep, bo_phan);
        this.gio_lam_them = gio_lam_them;
    }

    //tính lương cho thành viên bình thường ghi đè từ interface
    @Override
    public double salary() {
        double luong;
        luong = getHsl()*3000000 + getGlt()*200000;
        return luong;
    }

    //bảng lương thành viên viên theo tên ghi đè từ abstract
    @Override
    void displaySalary() {
        System.out.printf("%-15s | %-16s | %15.1f \n",getTen(),getBp(),salary());
    }

    //bảng danh sách thành viên ghi đè từ abstract
    @Override
    void displayInformation() {
        System.out.printf("%-15s | %-15s | %-5d | %-10.1f | %-13s | %-15s | %-16s | %-23s | %15.1f \n",
                getMtv(),getTen(),getTuoi(),getHsl(),getNvl(),getNnp(), getBp(),getGlt(),salary());
    }




}
