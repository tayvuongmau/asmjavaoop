
public class Department {
    private String ma_bo_phan;          //mã bộ phận
    private String ten_bo_phan;         //tên bộ phận
    private int so_luong;               //số lượng nhân viên

    public String getMbp() {return ma_bo_phan;}

    public String getTbp() {return ten_bo_phan;}

    public int getSl() {return so_luong;}

    //method constructor chứa tham số để triển khai danh sách các bộ phận
    public Department(String ma_bo_phan, String ten_bo_phan, int so_luong){
        this.ma_bo_phan = ma_bo_phan;
        this.ten_bo_phan = ten_bo_phan;
        this.so_luong = so_luong;
    }

    //method để triển khai in ra danh sách bộ phận
    public String toString(){
        return String.format("%-10s | %-15s | %-25d",getMbp(),getTbp(),getSl());
    }




















}
