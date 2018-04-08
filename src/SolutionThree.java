import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author PA
 *
 */
public class SolutionThree {

	static private BufferedReader br = null;

	public static void main(String[] args) {
		
		
        try {
			br = new BufferedReader(new InputStreamReader(System.in));
			int nbChallenge = Integer.parseInt(br.readLine());
			
			// Challenge #3
			for (int i=0; i < nbChallenge; i++) {
				String input = br.readLine();
				
				goGopher(Integer.parseInt(input));
				// Little check, just in case something goes wrong 
				
			}
			
        } catch (IOException e) {}
	}

	private static void goGopher(int size) throws IOException {
		int[][] map = new int[size][size];
		String input = br.readLine();
		String[] numbers = input.split(" ");
		int x, y;
		
		// short conversion
		x = Integer.parseInt(numbers[0]);
		y = Integer.parseInt(numbers[1]);
		if (x == 0 && y == 0) {
			return;
		}
		if (x == -1 && y == -1) {
			System.exit(-1);
		}
		
		// TODO
	}

}
