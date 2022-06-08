package minedemo;

import java.sql.Connection;
import java.util.Scanner;

import javax.sql.DataSource;

public class MainDao {

	public static void main(String[] args) {

System.out.println("請選擇操作：1查詢   2新增   3更新  4刪除  5離開");
		
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		
		Connection conn = null;
		
		switch (choice) {
		case 4:
			System.out.println("請輸入預刪除編號：");
			int no2 = scanner.nextInt();
			
			System.out.println("NEW成功...");
			break;
			
			
		}
	}

}
