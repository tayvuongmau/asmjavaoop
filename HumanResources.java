import java.util.*;

public class HumanResources {
    static Scanner input = new Scanner(System.in);

    //Khai báo mảng để thêm thành viên manager + employee
    static List<Staff> list = new ArrayList<>();
    //Khai báo mảng để thêm bộ phận
    static List<Department> listDer = new ArrayList<>();

    public static void main(String[] args) {
        int answer;
        boolean choose = true;      //đặt biến điều kiện dùng vòng lặp menu chính
        thanhvien();                //gọi ra danh sách các thành viên có sẵn
        boPhan();                   //gọi ra danh sách bộ phận có sẵn
        System.out.printf("%33s\n","[Thông tin nhân sự của Konoha]");
        //Dùng vòng lặp để sử dụng lại các chức năng trong menu mỗi khi kết thúc 1 chức năng trước đó / yêu cầu nhập đúng kiểu dữ liệu
        while (choose) {
            System.out.printf("%20s\n","[Menu]");
            System.out.println("1. Hiển thị danh sách nhân sự hiện tại của làng.");
            System.out.println("2. Hiển thị các bộ phận làm việc trong làng.");
            System.out.println("3. Hiển thị thành viên theo từng bộ phận.");
            System.out.println("4. Thêm thành viên mới vào làng.");
            System.out.println("5. Tìm kiếm thông tin thành viên theo tên hoặc mã thành viên.");
            System.out.println("6. Hiển thị bảng lương của toàn bộ làng theo thứ tự giảm dần.");
            System.out.println("7. Hiển thị bảng lương của các shinobi theo thứ tự tăng dần.");
            System.out.println("8. Xoá thành viên khỏi làng.");
            System.out.println("0. Thoát chương trình.");
            System.out.print("Lựa chọn của bạn (từ 0 tới 8) : ");
                answer = input.nextInt();
                System.out.println();
                switch (answer) {
                    case 0 -> {
                        System.out.println("Cảm ơn bạn đã sử dụng hệ thống.\nChúc một ngày tốt lành !");
                        choose = false;         //chuyển điều kiện lặp thành false để thoát vòng lặp
                    }
                    case 1 -> {
                        System.out.println("Danh sach tất cả thành viên trong làng :");
                        System.out.printf("%-15s | %-15s | %-5s | %-10s | %-13s | %-15s | %-16s | %-23s | %12s\n",
                                "Mã thành viên", "Tên", "Tuổi", "HS lương", "Ngày vào làm", "Ngày nghỉ phép", "Bộ phận làm việc", "Số giờ làm thêm/Chức vụ", "Lương");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        inThanhvien();
                        System.out.println();
                    }
                    case 2 -> {
                        System.out.println("Các bộ phận của công ty :");
                        System.out.printf("%-10s | %-15s | %-25s\n","Mã bộ phận", "Tên bộ phận", "Số lượng thành viên hiện tại");
                        System.out.println("-----------------------------------------------------------------");
                        inBoPhan();
                        System.out.println();
                    }
                    case 3 -> {
                        System.out.println("Bộ phận Hành chính");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.printf("%-15s | %-15s | %-5s | %-10s | %-13s | %-15s | %-16s | %-23s | %12s\n",
                                "Mã thành viên", "Tên", "Tuổi", "HS lương", "Ngày vào làm", "Ngày nghỉ phép", "Bộ phận làm việc", "Số giờ làm thêm/Chức vụ", "Lương");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        tvBoPhanHC();
                        System.out.println();
                        System.out.println("Bộ phận Kỹ thuật");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.printf("%-15s | %-15s | %-5s | %-10s | %-13s | %-15s | %-16s | %-23s | %12s\n",
                                "Mã thành viên", "Tên", "Tuổi", "HS lương", "Ngày vào làm", "Ngày nghỉ phép", "Bộ phận làm việc", "Số giờ làm thêm/Chức vụ", "Lương");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        tvBoPhanKT();
                        System.out.println();
                    }
                    case 4 -> {
                        addThanhvien();
                        System.out.println();
                    }
                    case 5 -> {
                        System.out.println("1. Tìm kiếm thành viên theo tên");
                        System.out.println("2. Tìm kiếm thành viên theo mã thành viên");
                        searchThanhVien();
                        System.out.println();
                    }
                    case 6 -> {
                        System.out.println("Danh sách lương tất cả thành viên trong làng :");
                        System.out.printf("%-15s | %-16s | %15.5s\n",
                                "Tên", "Bộ phận làm việc", "Lương");
                        System.out.println("---------------------------------------------------------------");
                        bangLuong();
                        System.out.println();
                    }
                    case 7 -> {
                        System.out.println("[ Bảng lương nhân viên theo thứu tự tăng dần]");
                        System.out.printf("%-15s | %-15s | %-5s | %-10s | %-13s | %-15s | %-16s | %-23s | %12s\n",
                                "Mã thành viên", "Tên", "Tuổi", "HS lương", "Ngày vào làm", "Ngày nghỉ phép", "Bộ phận làm việc", "Số giờ làm thêm/Chức vụ", "Lương");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        sapXepThanhVien();
                        System.out.println();
                    }
                    case 8 -> {
                        xoaTv();
                        System.out.println();
                    }
                    default -> {
                        System.out.println("Bạn chỉ có thể lựa chọn từ 0 tới 8.");
                        System.out.println();
                    }
                }
        }
    }

    //Thêm thành viên có sẵn
    static void thanhvien(){
        //khởi tạo các đối tượng thành viên
        Manager mot = new Manager("1st", "Hashirama", 100, 100, "1/1/1993", 0, "Hành chính", "Hokage");
        Manager hai = new Manager("2nd", "Tobirama", 99, 100, "1/1/1995", 0, "Hành chính", "Hokage");
        Manager ba = new Manager("3rd", "CEO Sarutobi", 80, 101, "1/1/2000", 0, "Hành chính", "Hokage");
        Manager bon = new Manager("4th", "Minato", 65, 95, "1/1/2020", 0, "Hành chính", "Hokage");
        Manager nam = new Manager("5th", "Tsunade", 60, 96, "1/1/2022", 0, "Hành chính", "Hokage");
        Employee ninja1 = new Employee("01", "Naruto", 20, 50, "1/1/2030", 0, "Kỹ thuật", 5);
        Employee ninja2 = new Employee("02", "Sasuke", 20, 50, "1/1/2030", 0, "Kỹ thuật", 0);
        Employee ninja3 = new Employee("03", "Sakura", 20, 50, "1/1/2030", 0, "Kỹ thuật", 10);
        //add các thành viên vào arraylist thành viên
        list.add(mot);
        list.add(hai);
        list.add(ba);
        list.add(bon);
        list.add(nam);
        list.add(ninja1);
        list.add(ninja2);
        list.add(ninja3);
    }

    //Thêm thành viên
    static void addThanhvien(){
        System.out.println("1. Thêm thành viên thông thường");
        System.out.println("2. Thêm thành viên cấp quản lí");
        System.out.print("Bạn chọn : ");
        while (true){
            int ans = input.nextInt();                      //nhập lựa chọn từ bàn phím
            if(ans == 1){
                input.nextLine();
                Employee employee = new Employee();
                System.out.print("Nhập mã thành viên : ");
                    String ma_thanh_vien = input.nextLine();        //nhập mã thành viên từ scanner
                    employee.setMtv(ma_thanh_vien);                 //set giá trị vào method constructor
                System.out.print("Nhập tên thành viên : ");
                    String ten = input.nextLine();                  //nhập tên từ scanner
                    employee.setTen(ten);                           //set giá trị vào method constructor
                System.out.print("Nhập tuổi thành viên : ");
                    int tuoi = Integer.parseInt(input.nextLine());  //nhập tuổi từ scanner
                    employee.setTuoi(tuoi);                         //set giá trị vào method constructor
                System.out.print("Nhập hệ số lương : ");
                    double he_so_luong = Double.parseDouble(input.nextLine());  //nhập hệ số lương từ scanner
                    employee.setHsl(he_so_luong);                               //set giá trị vào method constructor
                System.out.print("Nhập ngày bắt đầu làm việc : ");
                    String ngay_vao_lam = input.nextLine();         //nhập ngày vào làm từ scanner
                    employee.setNvl(ngay_vao_lam);                  //set giá trị vào method constructor
                System.out.print("Nhập số ngày nghỉ phép : ");
                    int ngay_nghi_phep = Integer.parseInt(input.nextLine());    //nhập số ngày nghỉ phép từ scanner
                    employee.setNnp(ngay_nghi_phep);                            //set giá trị vào method constructor
                System.out.println("1. HC - Hành chính");
                System.out.println("2. KT - Kỹ thuật");
                System.out.print("Bạn chọn bộ phận ( chọn 1 hoặc 2 ) : ");
                while (true){                                   //vòng lặp lựa chọn bộ phận làm việc
                    int valueBophan = input.nextInt();          //biến giá trị lựa chọn
                    if(valueBophan == 1) {
                        String bo_phan = "Hành chính";
                        employee.setBp(bo_phan);                //set giá trị vào method constructor
                        break;
                    }else
                    if(valueBophan == 2){
                        String bo_phan = "Kỹ thuật";
                        employee.setBp(bo_phan);                //set giá trị vào method constructor
                        break;}
                    else {System.out.print("Nhập lại : ");}
                }
                System.out.print("Nhập số giờ làm thêm : ");
                int gio_lam_them = input.nextInt();             //nhập giờ làm thêm từ scanner
                employee.setGlt(gio_lam_them);                  //set giá trị vào method constructor
                list.add(employee);                             //add thông tin thành viên vừa tạo vào list thành viên
                break;
            } else
                if(ans == 2){
                input.nextLine();
                Manager manager = new Manager();
                System.out.print("Nhập mã thành viên : ");
                    String ma_thanh_vien = input.nextLine();            //nhập mã thành viên từ scanner
                    manager.setMtv(ma_thanh_vien);                      //set giá trị vào method constructor
                System.out.print("Nhập tên thành viên : ");
                    String ten = input.nextLine();                      //nhập tên thành viên từ scanner
                    manager.setTen(ten);                                //set giá trị vào method constructor
                System.out.print("Nhập tuổi thành viên : ");
                    int tuoi = Integer.parseInt(input.nextLine());      //nhập tuổi thành viên từ scanner
                    manager.setTuoi(tuoi);                              //set giá trị vào method constructor
                System.out.print("Nhập hệ số lương : ");
                    double he_so_luong = Double.parseDouble(input.nextLine());      //nhập hệ số lương thành viên từ scanner
                    manager.setHsl(he_so_luong);                                    //set giá trị vào method constructor
                System.out.print("Nhập ngày bắt đầu làm việc : ");
                    String ngay_vao_lam = input.nextLine();             //nhập ngày bắt đầu làm từ scanner
                    manager.setNvl(ngay_vao_lam);                       //set giá trị vào method constructor
                System.out.print("Nhập số ngày nghỉ phép : ");
                    int ngay_nghi_phep = Integer.parseInt(input.nextLine());    //nhập số ngày nghỉ phép
                    manager.setNnp(ngay_nghi_phep);                             //set giá trị vào method constructor
                System.out.println("1. HC - Hành chính");
                System.out.println("2. KT - Kỹ thuật");
                System.out.print("Bạn chọn bộ phận ( chọn 1 hoặc 2 ) : ");
                while (true){                                           //vòng lặp lựa chọn bộ phận
                    int valueBophan = input.nextInt();
                    if(valueBophan == 1){
                        String bo_phan = "Hành chính";
                        manager.setBp(bo_phan);                         //set giá trị vào method constructor
                        break;}
                    else if(valueBophan == 2){
                        String bo_phan = "Kỹ thuật";
                        manager.setBp(bo_phan);                         //set giá trị vào method constructor
                        break;}
                    else {System.out.print("Nhập lại : ");
                    }
                }
                System.out.println("Chức danh :");
                System.out.println("1. Hokage");
                System.out.println("2. Sanin");
                System.out.println("3. Jonin");
                System.out.print("Nhập chức danh : ");
                while (true){                                           //vòng lặp lựa chọn chức danh
                    int valueChucdanh = input.nextInt();
                    if(valueChucdanh == 1){
                        String chuc_danh = "Hokage";
                        manager.setCd(chuc_danh);                       //set giá trị vào method constructor
                        break;
                    }
                    else if (valueChucdanh == 2){
                        String chuc_danh = "Sanin";
                        manager.setCd(chuc_danh);                       //set giá trị vào method constructor
                        break;
                    }
                    else if (valueChucdanh == 3){
                        String chuc_danh = "Jonin";
                        manager.setCd(chuc_danh);                       //set giá trị vào method constructor
                        break;
                    }
                    else {System.out.print("Nhập lại : ");}
                }
                list.add(manager);                                      //add thành viên vừa tạo vào list
                break;
            }
                else {System.out.print("Bạn chỉ được chọn 1 hoặc 2 , chọn lại : ");}
        }
    } //case 4

    //In thành viên
    static void inThanhvien(){
        for (Staff x : list){               //vòng lặp in ra từng đối tượng trong list
            x.displayInformation();
        }
    }  //case 1

    //Hiển thị bảng lương của thành viên cả làng
    static void bangLuong(){
        list.sort(((o1, o2) -> (int) (o2.salary() - o1.salary())));     //sắp xếp list thành viên theo giá trị lương giảm dần
        for (Staff x : list){                                           //vòng lặp in từng đối tượng sau sắp xếp
            x.displaySalary();
        }
    }  //case 6

    //Hiển thị bảng lương của thành viên theo thứ tự lương giảm dần
    static void sapXepThanhVien(){
//        list.sort((o1, o2) -> (int) (o1.salary() - o2.salary()));       //sắp xếp list thành viên theo giá trị lương tăng dần
//        for (Staff x : list){                                           //vòng lặp in từng đối tượng sau sắp xếp
//            x.displayInformation();
//        }

        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return (int) (o1.salary() - o2.salary());                   //sắp xếp list thành viên theo giá trị lương giảm dần
            }
        });
        for (Staff x : list){
          x.displayInformation();                                           //vòng lặp in từng đối tượng sau sắp xếp
        }
    }  //case 7

    //Tìm kiếm thành viên trong làng
    static void searchThanhVien(){
        String answer;
        int number;
        System.out.print("Chọn cách : ");
        number = input.nextInt();           //giá trị nhập vào để lựa chọn cách tìm kiếm
        switch (number) {                   //lệnh rẽ nhánh theo giá trị lựa chọn phù hợp
            case 1 -> {
                input.nextLine();
                System.out.print("Hãy nhập tên thành viên cần tìm : ");
                answer = input.nextLine();                          //giá trị nhập vào để tìm kiếm
                for (Staff x : list) {                              //lặp qua tất cả các đối tợng trong list
                    if (answer.equalsIgnoreCase(x.getTen())) {      //tìm kiếm đối tượng phù hợp
                        System.out.printf("%-15s | %-15s | %-5s | %-10s | %-13s | %-15s | %-16s | %-23s | %12s\n",
                                "Mã thành viên", "Tên", "Tuổi", "HS lương", "Ngày vào làm", "Ngày nghỉ phép", "Bộ phận làm việc", "Số giờ làm thêm/Chức vụ", "Lương");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        x.displayInformation();                     //in ra đối tượng tìm được phù hợp
                        return;                                     //dừng khối code tìm kiếm
                    }
                }
                System.out.println("Thông tin bạn nhập không đúng hoặc thành viên không tồn tại, kết thúc tìm kiếm !");
            }
            case 2 -> {
                input.nextLine();
                System.out.print("Hãy nhập mã thành viên cần tìm : ");
                answer = input.nextLine();                          //giá trị nhập vào để tìm kiếm
                for (Staff x : list){                               //lặp qua tất cả các đối tợng trong list
                    if (answer.equalsIgnoreCase(x.getMtv())) {      //tìm kiếm đối tượng phù hợp
                        System.out.printf("%-15s | %-15s | %-5s | %-10s | %-13s | %-15s | %-16s | %-23s | %12s\n",
                                "Mã thành viên", "Tên", "Tuổi", "HS lương", "Ngày vào làm", "Ngày nghỉ phép", "Bộ phận làm việc", "Số giờ làm thêm/Chức vụ", "Lương");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                        x.displayInformation();     //in ra đối tượng tìm được phù hợp
                        return;                     //dừng khối code tìm kiếm
                    }
                }
                System.out.println("Thông tin bạn nhập không đúng hoặc thành viên không tồn tại, kết thúc tìm kiếm !");
            }
        }
    }  //case 5

    //Hiển thị các bộ phận trong làng
    static void boPhan(){
        //Thêm các đối tượng là bộ phận có sẵn
        Department HC = new Department("HC", "Hành chính", 5);
        Department KT = new Department("KT", "Kỹ thuật", 3);
        //add các đối tượng vào list bộ phận
        listDer.add(HC);
        listDer.add(KT);
    }

    //In bộ phận
    static void inBoPhan(){
        for (Department x : listDer){           //dùng vòng lặp qua list bộ phận và in từng đối tượng ra
            System.out.println(x);
        }
    }  //case 2

    //Hiển thị thành viên hành chính
    static void tvBoPhanHC(){
        String bpHC = "Hành chính";
        for(Staff x : list){                                //vòng lặp qua tất cả đối tượng trong list
            if(bpHC.equalsIgnoreCase(x.getBp())){           //in ra các đối tượng phù hợp
                x.displayInformation();
            }
        }
    }  //case 3

    //Hiển thị thành viên kĩ thuật
    static void tvBoPhanKT() {
        String bpKT = "Kỹ thuật";
        for (Staff x : list) {                              //vòng lặp qua tất cả đối tượng trong list
            if (bpKT.equalsIgnoreCase(x.getBp())) {         //in ra các đối tượng phù hợp
                x.displayInformation();
            }
        }
    }  //case 3

    //Xoá thành viên
    static void xoaTv(){
        int i;
        System.out.print("Nhập index thành viên muốn trục xuất khỏi làng : ");
        try{                        //xoá đối tượng theo chỉ số index
            i = input.nextInt();
            input.nextLine();
            Staff remove = list.remove(i);
            System.out.println("Xoá sổ thành công " + remove.getTen());
        }
        catch (Exception e){
            System.out.println("Không tồn tại thành viên có index này.");
        }
    }  //case 8
}




