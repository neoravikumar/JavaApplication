import java.util.ArrayList;

public class PrintPattern {

	public ArrayList<ArrayList<Integer>> solve(int A) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 1; i <= A; i++) {
			ArrayList<Integer> ri = new ArrayList<Integer>();
			for (int j = 1; j <= A; j++) {
				if (j <= i) {

					ri.add(0);
				} else {
					ri.add(j);
				}
			}
			result.add(ri);
		}
		display(result);
		return result;
	}

	private void display(ArrayList<ArrayList<Integer>> a) {
		for (ArrayList<Integer> list : a) {
			if (null != list && list.size() > 0) {
				System.out.print(list);
			}
		}
	}

	public static void main(String[] args) {

		PrintPattern pt = new PrintPattern();
		ArrayList<ArrayList<Integer>> result = pt.solve(3);
		//System.out.println(result);

	}

}
