package Assignment_5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;


public class MorseCodeConverter {
	
	public static MorseCodeTree tree = new MorseCodeTree();
	
	public static String convertToEnglish(File codefile) throws FileNotFoundException {
		Scanner s = null;
		try {
			s = new Scanner(codefile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return convertToEnglish(s.nextLine());
	}
	public static String convertToEnglish(String s) {
		if(tree.getRoot() == null) {
			tree.buildTree();
		}
		String result = "", letter = "";
		s+=" ";
		char cArray [] = s.toCharArray();
		for(int i = 0; i < cArray.length; i++) {
			if(cArray[i] == '/') {
				result += " ";
			}
			else if(cArray[i] == ' ') {
				if(letter.length() != 0) {
				result += tree.fetch(letter);
				}
				//System.out.println(result + "\n");
				letter = "";
			}
			else {
				//System.out.println(cArray[i]);
				letter+=cArray[i];
			}
		}
		return result;
	}
	
	public static Object printTree() {
		String result = "";
		ArrayList <String> a = tree.toArrayList();
		for(String s: a) {
			result+= s + " ";
		}
		
		return result.trim();
	}
	
	
}
