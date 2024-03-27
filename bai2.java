package helo;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class bai2 {

    private String name;
    private int age;
    private double gpa;

    public bai2(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }

    public static void main(String[] args) {
        List<bai2> students = new ArrayList<>();
        students.add(new bai2("Nguyen Van A", 20, 3.5));
        students.add(new bai2("Tran Thi B", 22, 3.2));
        students.add(new bai2("Le Van C", 21, 3.8));

        StringBuilder xmlContent = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xmlContent.append("<students>\n");

        for (bai2 student : students) {
            xmlContent.append("  <student>\n");
            xmlContent.append("    <name>").append(student.getName()).append("</name>\n");
            xmlContent.append("    <age>").append(student.getAge()).append("</age>\n");
            xmlContent.append("    <gpa>").append(student.getGpa()).append("</gpa>\n");
            xmlContent.append("  </student>\n");
        }

        xmlContent.append("</students>");

        try {
            // Lưu file XML trong cùng thư mục với mã nguồn
            FileWriter xmlFile = new FileWriter("students.xml");
            xmlFile.write(xmlContent.toString());
            xmlFile.close();
            System.out.println("Đã tạo file XML thành công!");
        } catch (IOException e) {
            System.err.println("Không thể tạo file XML!");
            e.printStackTrace();
        }
    }
}
