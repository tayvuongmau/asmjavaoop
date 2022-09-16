abstract class Staff{
    private String ma_thanh_vien;           //mã nhân viên
    private String ten;                     //tên nhân viên
    private int tuoi;                       //tuổi nhân viên
    private double he_so_luong;             //hệ số lương
    private String ngay_vao_lam;            //ngày vào làm
    private String bo_phan;                 //bộ phận làm việc
    private int ngay_nghi_phep;             //số ngày nghỉ phép

    //method constructpr rỗng
    public Staff() {

    }
    //method constructor chứa tham số
    public Staff(String ma_thanh_vien, String ten, int tuoi, double he_so_luong, String ngay_vao_lam, int ngay_nghi_phep, String bo_phan) {
        this.ma_thanh_vien = ma_thanh_vien;
        this.ten = ten;
        this.tuoi = tuoi;
        this.he_so_luong = he_so_luong;
        this.ngay_vao_lam = ngay_vao_lam;
        this.ngay_nghi_phep = ngay_nghi_phep;
        this.bo_phan = bo_phan;
    }


    public String getMtv(){ return ma_thanh_vien;}
    public void setMtv(String ma_thanh_vien){ this.ma_thanh_vien = ma_thanh_vien; }

    public String getTen(){ return ten;}
    public void setTen(String ten){ this.ten = ten;}

    public int getTuoi(){ return tuoi;}
    public void setTuoi(int tuoi){ this.tuoi = tuoi;}

    public double getHsl(){ return he_so_luong;}
    public void setHsl(double he_so_luong){ this.he_so_luong = he_so_luong;}

    public String getNvl(){ return ngay_vao_lam;}
    public void setNvl(String ngay_vao_lam){ this.ngay_vao_lam = ngay_vao_lam;}

    public int getNnp(){ return ngay_nghi_phep;}
    public void setNnp(int ngay_nghi_phep){ this.ngay_nghi_phep = ngay_nghi_phep;}

    public String getBp(){ return bo_phan;}
    public void setBp(String bo_phan){ this.bo_phan = bo_phan;}



    abstract void displayInformation();         //method thông tin nhân viên
    abstract double salary();                   //method tính lương
    abstract void displaySalary();              //method hiển thị bảng lương cả làng
}

