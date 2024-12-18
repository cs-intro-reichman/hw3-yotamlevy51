
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // -3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int y1 = x1;
		int y2 = x2;
		if (y2 < 0) {
			for (int i = 0; i > y2; i--) {
				y1 --;
			}	
		} else {
		for (int i = 0; i < y2; i++) {
			y1 ++;
		}
	}
		return y1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int y1 = x1;
		int y2 = x2;
		if (y2 <0) {
			for (int i = 0; i > y2; i--) {
				y1 ++;
			}
		} else {
			for (int i = 0; i < y2; i++) {
			y1 --;
		}
	}
		return y1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int y1 = (x1 < 0) ? -x1 : x1;
		int y2 = (x2 < 0) ? -x2 : x2;
		int s = 0;
		
	for (int i = 0; i < y2; i++) {
		s = plus(s, y1);	
	}

	if ((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0)) {
        s = -s;
	}

	return s;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int y = x;
		int m = n;
		int r = 1; 
		boolean NegativeBase = false;

		if (m == 0) {
			r = 1;
		}

		if (x < 0) {
			y = minus(0, y);
			NegativeBase = !NegativeBase;
			
		}
			
		for (int i = 0; i < m; i++) {
			r = times(r, y);
		}
		if (NegativeBase && mod(n, 2) != 0) {
			return minus(0, r);
		}
		
		return r;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int y1 = x1;
		int y2 = x2;
		int count = 0;

		if (y2 == 0) {
			throw new IllegalArgumentException("Division by zero is not allowed");
		}

		boolean NegativeResult = (y1 < 0) != (y2 < 0);

    	y1 = (y1 < 0) ? -y1 : y1; 
    	y2 = (y2 < 0) ? -y2 : y2;
		
		while (y1 >= y2) {
			y1 = minus(y1, y2);
			count ++;
		}

		if (NegativeResult) {
			count = -count;
		}

		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int y1 = x1;
		int y2 = x2;
		int s = y1;
		if (y2 == 0) {
			throw new IllegalArgumentException("Division by zero is not allowed");
		}

		if (y1 < y2) {
			s = y1;
		} else {
			
		while (s >= y2) {
			s = minus(s, y2);
		}
	}
		return s;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int y = x;
		int r = 0;
		int s = 0;

		if (y < 0) {
			throw new IllegalArgumentException("Cannot calculate the square root of a negative number");
		}
	
		while (s <= y) {
			r++;
			s = times(r, r); 
		}
		return minus(r, 1);
	}	  	  
}