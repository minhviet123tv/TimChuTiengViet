package package1;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "abodfjtodf";
//		String sub = text.substring(0,2);
//		System.out.println(sub);
		
		System.out.println("length: " + text.length());
		System.out.println("length: " + text.substring(8,10));
		
		String text2 = text.replace("a", "A");
		System.out.println(text2);
		
		StringBuilder stringBuilder = new StringBuilder(text);
		System.out.println(stringBuilder.toString());
		StringBuilder builder = stringBuilder.replace(0, 2, "00");
		
		System.out.println(builder.toString());
	}

}
