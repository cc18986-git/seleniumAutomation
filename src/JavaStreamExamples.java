import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list=new ArrayList<>(Arrays.asList("Aniket","Nikhil","Sharvin","Akshay","Parthavi"));
		//Print names which starts with S
		list.stream().filter(s->s.startsWith("S")).forEach(s->System.out.println(s));
		
		//Count names which starts with A
		long count=list.stream().filter(s->s.startsWith("A")).count();
		System.out.println(count);
		
		//Print names in sorted manner
		list.stream().sorted().forEach(System.out::println);
		
		//String Reverse in various ways
		String str="This is Sharvin Chavan";
		System.out.println("Original String: "+str);
		
		//String Reverse Method3
		System.out.println("Reverse Method1: ");
		String[] strList=str.split(" ");
		for(int i=strList.length-1;i>=0;i--) {
			System.out.print(strList[i]+" ");
		}
		
		//String Reverse Method2
		System.out.println("Reverse Method2:");
		char[] charArray=str.toCharArray();
		for(int j=charArray.length-1;j>=0;j--) {
			System.out.print(charArray[j]);
		}
		
		//String Reverse Method3
		System.out.println("Reverse Method3:");
		for(String s:strList) {
			char[] sArray=s.toCharArray();
			for(int k=sArray.length-1;k>=0;k--) {
				System.out.print(sArray[k]);
			}
			System.out.print(" ");
		}
		
		List<Integer> newList=Stream.of(100,120,150,90,80).filter(i->i >99).collect(Collectors.toList());
		System.out.println(newList);
	}

}
