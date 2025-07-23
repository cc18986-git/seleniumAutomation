
public class TempClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] numbers= {10,50,20,30,40};
		System.out.println("First Element: "+numbers[0]);
		System.out.println("Last Element: "+numbers[(numbers.length)-1]);
		
		System.out.println("Array is reverse order: ");
		for(int i=numbers.length-1;i>=0;i--) {
			System.out.println(numbers[i]);
			
		}
		
		System.out.println("Count of Elements:" + numbers.length);

	}

}
