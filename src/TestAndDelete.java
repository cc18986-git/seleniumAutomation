import java.util.Set;

public class TestAndDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> cars = Set.of("Maruti","Ford");
		String car1=cars.stream().iterator().next();
		System.out.println(car1);
		String car2=cars.stream().iterator().next();
		System.out.println(car2);
		System.out.println("Pushing to Github1");
		System.out.println("Pushing to Github2");
		
		System.out.println("develop1");
		System.out.println("develop2");

	}

}
