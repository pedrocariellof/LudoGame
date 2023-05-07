package View;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	
	static Scanner readFile(String path) throws FileNotFoundException {
		File file = new File(path);
		Scanner scan = null;
		
		scan = new Scanner(file);
		
		
		return scan;
	}
}
