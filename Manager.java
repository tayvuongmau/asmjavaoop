public class Manager extends Staff implements ICalculator{
    private String chuc_danh;           //chức danh

    public String getCd(){ return chuc_danh;}  //khi cần gọi ra giá trị của chức danh để dùng
    public void setCd(String chuc_danh){ this.chuc_danh = chuc_danh;}  //dùng để set lại chức danh cho thành viên khi tạo thành viên mới

    //method constructor rỗng
    public Manager() {

    }

    //method constructor chứa tham số
    public Manager(String ma_thanh_vien, String ten, int tuoi, double he_so_luong, String ngay_vao_lam, int ngay_nghi_phep, String bo_phan, String chuc_danh){
        super(ma_thanh_vien, ten, tuoi, he_so_luong, ngay_vao_lam, ngay_nghi_phep, bo_phan);
        this.chuc_danh = chuc_danh;
    }

    //tính lương cho cán bộ ghi đè từ interface
    @Override
    public double salary() {
        double luongTrachNhiem = switch (chuc_danh) {
            case "Hokage" -> 8000000;
            case "Sanin" -> 5000000;
            case "Jonin" -> 6000000;
            default -> 0;
        };
        double luong = getHsl() * 5000000 + luongTrachNhiem;
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
                getMtv(),getTen(),getTuoi(),getHsl(),getNvl(),getNnp(), getBp(),getCd(),salary());
    }

}
