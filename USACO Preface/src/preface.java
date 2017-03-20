import java.io.*;
import java.util.*;

public class preface {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("preface.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
		int n = Integer.parseInt(f.readLine());
		//I 1,L 50,M 1000,V 5,C 100,X 10,D 500
		char[] numerals = {'I','V','X','L','C','D','M'};
		int[] numVals = {1,5,10,50,100,500,1000};
		int[] numCount = new int[numerals.length];
		int num = n;
		for(int i = numVals.length-1; i >= 0; i--){
			if(num/numVals[i] == 0 ){
				continue;
			}
			else{
				int count = num/numVals[i];
				System.out.println(count + " " + numVals[i]);
				num = num%numVals[i];
				
			}
		}
		
		
		
	}
	
}
