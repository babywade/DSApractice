package DSApractice;
import java.util.*;

public class Solution0301 {
	public static void main(String[] args) {
		Collection<Integer> L = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7, 9, 10, 11, 12));
		Collection<Integer> P = new ArrayList<>(Arrays.asList(1, 3, 4, 6, 9, 10));
		new Solution0301().printLots(L, P);
	}
	
	public void printLots(Collection<Integer> L, Collection<Integer> P) {
		Iterator<Integer> iteratorL = L.iterator();
		Iterator<Integer> iteratorP = P.iterator();
		int i = 0;
		while (iteratorP.hasNext()) {
			int p = iteratorP.next();
			while (i < p - 1) {
				if (!iteratorL.hasNext())
					throw new IllegalArgumentException("illegal input list");
				iteratorL.next();
				i++;
			}
			if (!iteratorL.hasNext())
				throw new IllegalArgumentException("illegal input list");
			System.out.print(iteratorL.next() + ", ");
			i++;
		}
 	}
}
