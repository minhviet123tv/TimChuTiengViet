package package1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Bài test online - Mobile Internship 03/2024
 * Họ Tên: Cao Văn Việt. Email:minhviet.dragon@gmail.com. SĐT: 0961120861
 */
public class TimChuCaiTiengViet {

	public static void main(String[] args) {
		
		//1. Khai báo nhập dữ liệu, ít nhất 1 ký tự
		Scanner scanner = new Scanner(System.in);
		String text;
		String regex1 = "^[A-Za-z0-9]$";
		String regex2 = "^[A-Za-z0-9]+[A-Za-z0-9]$";
		
		do {
			System.out.println("Nhập dữ liệu (Không chứa khoảng trống hoặc ký tự đặc biệt):");
			text = scanner.nextLine();
			
		//Nếu có khoảng trống hoặc ký tự đặc biêt (không phải ký tự bình thường) trong text thì nhập lại
		} while (text.matches("(.*)\\s(.*)") || (!text.matches(regex1) && !text.matches(regex2)));
		
		//2. Xác nhận, hiển thị dữ liệu đã nhập
		System.out.println("Input: " + text);
		
		//3. Tạo đếm số lượng chữ tiếng Việt
		ArrayList<String> tiengViet2Chu = new ArrayList<>(Arrays.asList("aw", "aa", "dd", "ee", "oo", "ow"));
		ArrayList<String> tiengViet1Chu = new ArrayList<>(Arrays.asList("w"));
		int count = 0;
		ArrayList<String> result = new ArrayList<>();
		
		//4. Kiểm tra dữ liệu nhập vào, tăng số đếm nếu có chữ tiếng Việt
		if(text.length() >= 2) {
			
			//Kiểm tra từng cặp 2 chữ và 1 chữ của dữ liệu nhập vào so với chữ tiếng Việt trong list
			for(int i=0; i<=text.length() - 2; i= i+1) {
				
				StringBuilder stringBuilder = new StringBuilder(text);
				
				//Kiểm tra trường hợp 2 chữ cái trước
				for(int j=0; j<tiengViet2Chu.size(); j++) {
					
					if(text.substring(i, i+2).contains(tiengViet2Chu.get(j))) {
						//Tăng số đếm và thêm vào list kết quả
						count++;
						result.add(tiengViet2Chu.get(j));
						
						//Đặt lại giá trị khác cho chữ đã đếm được (vẫn giữ nguyên độ dài)
						StringBuilder builder = stringBuilder.replace(i, i+2, "00");
						
						//Trả lại chuỗi dữ liệu mới
						text = builder.toString();
						
					} 
				}
				
				//Trường hợp 1 chữ cái
				if (text.substring(i, i+1).equals(tiengViet1Chu.get(0))) {
					//Tăng số đếm và thêm vào list kết quả
					count++;
					result.add(tiengViet1Chu.get(0));
					
					//Đặt lại giá trị khác cho chữ đã đếm được (vẫn giữ nguyên độ dài)
					StringBuilder builder = stringBuilder.replace(i, i+1, "9");
					
					//Trả lại chuỗi dữ liệu mới
					text = builder.toString();
					
				} 
				
				if (text.substring(i+1, i+2).equals(tiengViet1Chu.get(0))) {
					//Tăng số đếm và thêm vào list kết quả
					count++;
					result.add(tiengViet1Chu.get(0));
					
					//Đặt lại giá trị khác cho chữ đã đếm được (vẫn giữ nguyên độ dài)
					StringBuilder builder = stringBuilder.replace(i+1, i+2, "9");
					
					//Trả lại chuỗi dữ liệu mới
					text = builder.toString();
				}
			}
			
		//Nếu dữ liệu nhập chỉ có 1 ký tự
		} else if (text.length() == 1) {
			
			//So sánh chữ trong dữ liệu với tiếng Việt 1 chữ
			if(text.contains(tiengViet1Chu.get(0))) {
				//Tăng số đếm và thêm vào list kết quả
				count++;
				result.add(tiengViet1Chu.get(0));
			}
		}
			
	
		//5. Hiển thị kết quả
		System.out.print("Output: " + count + "(");
		
		for(int j=0; j<result.size(); j++) {
			if(j == 0) {
				System.out.print(result.get(j));
			} else {
				System.out.print("," + result.get(j));
			}
		}
		
		System.out.println(")");
		
//		System.out.println("replace text: " + text);
		

	}

}
