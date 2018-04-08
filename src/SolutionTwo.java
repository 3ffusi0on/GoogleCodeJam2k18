import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author PA
 *
 */
public class SolutionTwo {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		
        try {
			br = new BufferedReader(new InputStreamReader(System.in));
			int nbChallenge = Integer.parseInt(br.readLine());
	
			// Challenge #2
			for (int i=0; i < nbChallenge; i++) {
				int nbInputs = Integer.parseInt(br.readLine());
				String input = br.readLine();
				String[] numbers = input.split(" ");
				int[] values = new int[nbInputs];
				
				// short conversion
				for (int t=0; t < nbInputs; t++) {
					values[t] = Integer.parseInt(numbers[t]);
				}
				
				// lets check this out
				String res = solveTroubleSort(values);
				System.out.println("Case #" + (i+1) + ": " + res);

			}
			
        } catch (IOException e) {}
	}
    
	/**
	 * Our algorithm examines a group of three adjacent numbers,
	 * and if the leftmost number is larger than the rightmost number,
	 * it reverses that entire group. Because our algorithm is
	 * a "triplet bubble sort", we have named it Trouble Sort for short.
	 * @param values like "5 6 8 4 3"
	 * @return verification
	 */
	private static String solveTroubleSort(int[] values) {

		boolean done = false;
		while (!done) {
			done = true;

			for (int i=0; i<values.length - 2; i++) {
				if (values[i] > values[i+2]) {
					done = false;
					
					// reverse
					int tmp = values[i];
					values[i] = values[i+2];
					values[i+2] = tmp;
				}
			}
		}
		
		// verify
		for (int i=0; i<values.length - 1; i++) {
			if (values[i] > values[i+1])
				return i + "";
		}
		return "OK";
	}

}
