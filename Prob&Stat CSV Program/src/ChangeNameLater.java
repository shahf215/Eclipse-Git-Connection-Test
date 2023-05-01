import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ChangeNameLater {
	//change function to be more complicated
	//this is for project 2
	//this line is to test if pushing the update works
	//and this is to see if pulling works

	public static void main(String args[]) {
	File CSVTester = new File("FunctionResults.csv");
	
	try {
	
		BufferedWriter bw = new BufferedWriter(new FileWriter(CSVTester));
		
		String title = "labelx, labely";
		bw.write(title);
		
		for(int i = 1; i <= 100; i++) {
			
			int y = (2*i) + 5;
			
			bw.newLine();
			bw.write(i + "," + y);
			
		}
	
		
		bw.close();
		System.out.println("hi");
		
	}
	
	catch(Exception e) {
		
	}
}
}