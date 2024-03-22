package helo;
import java.io.File;
import java.util.Scanner;

public class newiostream {
	public static void main(String[] args) {
		System.out.println("bài tập 1");
		Scanner sc = new Scanner(System.in);
		String fileb = sc.nextLine();
		File myobj = new File(fileb);
		System.out.println(myobj.length());
		System.out.println("Bài tập 2");
		String Namefile = sc.nextLine();
		File file1 = new File(Namefile);
		if(file1.delete()) {
			System.out.println("Xóa thành công");
		}else {
			System.out.println("Xóa không thành công ");
		}
	}
	
}