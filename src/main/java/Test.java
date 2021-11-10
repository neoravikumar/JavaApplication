import java.util.ArrayList;

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
		
	}

}
