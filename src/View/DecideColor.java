package View;

public class DecideColor {
	public static boolean isRed(int i, int j) {
		if((j >= 15 && j <= 17 && i < 13 && i > 1) || 
		   (i >= 2 && i <= 4 && j >= 18 && j <=19) || 
		   (i >=2 && i <=10 && j >= 24 && j<= 31)){
			
			return true;
		}
		return false;
	}
	
	public static boolean isBlue(int i, int j) {
		if((j >= 15 && j <= 17 && i > 19 && i < 31) || 
		   (i >= 28 && i <= 30 && j >= 13 && j <= 14) || 
		   (i >=20 && i <=29 && j >= 1 && j<= 8)) {
			
			return true;
		}
		return false;
	}
	
	public static boolean isGreen(int i, int j) {
		if((j >= 2 && j <= 12 && i > 14 && i < 18) || 
		   (i >= 12 && i <= 14 && j >= 2 && j <= 4) || 
		   (i >=2 && i <=10 && j >= 1 && j<= 8)) {
			
			return true;
		}
		return false;
	}
	
	public static boolean isYellow(int i, int j) {
		if((j >= 20 && j <= 30 && i > 14 && i < 18) || 
		   (i >= 18 && i <= 19 && j >= 28 && j <= 30) || 
		   (i >=20 && i <=29 && j >= 24 && j<= 31)) {
					
			return true;
		}
		return false;
	}
}
