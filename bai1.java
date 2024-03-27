package helo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class bai1 {

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Nhập đường dẫn thư mục: ");
        String path = scanner.nextLine();
        scanner.close();

        File dir = new File(path);
        if (!dir.exists() || !dir.isDirectory()) {
            System.err.println("Đường dẫn không hợp lệ!");
            return;
        }

        StringBuilder xmlContent = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xmlContent.append("<").append(dir.getName()).append(">\n");

        listDirectory(dir, xmlContent, 1);

        xmlContent.append("</").append(dir.getName()).append(">");

        try {
            FileWriter xmlFile = new FileWriter("directory_tree.xml");
            xmlFile.write(xmlContent.toString());
            xmlFile.close();
            System.out.println("Đã tạo file XML thành công!");
        } catch (IOException e) {
            System.err.println("Không thể tạo file XML!");
            e.printStackTrace();
        }
    }

    private static void listDirectory(File dir, StringBuilder xmlContent, int level) {
        String indent = "  ".repeat(level);
        
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                xmlContent.append(indent).append("<").append(file.getName()).append(">\n");
                listDirectory(file, xmlContent, level + 1);
                xmlContent.append(indent).append("</").append(file.getName()).append(">\n");
            } else if (file.isFile()) {
                xmlContent.append(indent).append("<file>").append(file.getName()).append("</file>\n");
            }
        }
    }
}
