import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.crypto.spec.SecretKeySpec;

public class Test {
	
	
	public int getLastMoment(int n,  ArrayList<Integer> B, ArrayList<Integer> C) {
        int ans=0;
        for(int i=0;i<B.size();i++)
        {
            ans=Math.max(ans,B.get(i));
        }
        for(int i=0;i<C.size();i++)
        {
            ans=Math.max(ans,n-C.get(i));
        }
        return ans;
    }
	
	public static void main(String[] args) {
		
		
		
		System.out.println("---------------------");
		String inputString = "/a/./b/../../c/";
		
		String[] myString = inputString.split("/");
		System.out.println(myString);
		
		System.out.println("---------------------");
		
		
		
		//System.out.println(1<<3);
		// Creating object of ArrayList<Integer>
        ArrayList<String>
            arrlist = new ArrayList<String>();
        
        // declare array and fill with default value
        Integer[] count = new Integer[1001];
		Arrays.fill(count, 0);

        // Populating arrlist1
        arrlist.add("A");
        arrlist.add("B");
        arrlist.add("C");
        arrlist.add("D");
        arrlist.add("E");
        System.out.println(arrlist.subList(0, 5));
        
        System.out.println("Or operations:>");
        System.out.println(3|3);
        
        
        String[] adPasswordCryptoKeys = { "-62", "94", "110", "117", "69", "98", "70", "110" };
        
        toByteArray(adPasswordCryptoKeys);
        
        System.out.println("Hello:>>"+ (7>>0));
        
        
		/*
		 * byte[] newPlainText = this.cipher.doFinal(Base64.decode(in.getBytes()));
		 * return new String(newPlainText, "UTF8");
		 * 
		 * key = new SecretKeySpec(publicKey, transformation);
		 */
        
		
        String URL = "https://eu8-smax.saas.microfocus.com/rest/778901870/ems/Offering?layout=Id&filter=DisplayLabel='WCI - Check-In Check-Out'";
        
        System.out.println(URL);
        
        String booleanR = "false";
        Boolean result = Boolean.parseBoolean(booleanR);
        if(result) {
        	System.out.println("ResultTrue......");
        }
        
	}
	
	
	
	
	 public static byte[] toByteArray(String[] tokens) {
	        byte[] output = null;
	        if (tokens != null) {
	            output = new byte[tokens.length];
	            for(int i = 0; i < tokens.length; i++){
	                output[i] = Byte.decode(tokens[i]).byteValue();
	            }
	            
	           try {
				String myString = new String(output, "UTF8");
				
				System.out.println(">>>>>::::"+myString);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	            return output;
	        }
	        return output;
	    }
	 
	 
	 

}
