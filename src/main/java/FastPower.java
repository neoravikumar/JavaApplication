
public class FastPower {
	
	// 2^4 - base is 2 and exponent is 4 result would be 16
	long fastPower(int base, int exponent) {
		if(exponent==0) {
			return 1;
		}
		long resultHalfByExponent = fastPower(base, exponent/2);
		
		if(resultHalfByExponent % 2 == 1) {
			// Odd number so in this 
			return base * resultHalfByExponent * resultHalfByExponent;
		}else {
			// Even number 
			return resultHalfByExponent * resultHalfByExponent;
		}
	}

	public static void main(String[] args) {
		FastPower fastPower = new FastPower();
		long result = fastPower.fastPower(2, 4);
		System.out.println(result);
	}
}
