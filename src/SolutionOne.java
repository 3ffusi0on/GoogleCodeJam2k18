import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author PA
 *
 */
public class SolutionOne {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		
        try {
			br = new BufferedReader(new InputStreamReader(System.in));
			int nbChallenge = Integer.parseInt(br.readLine());
			
			// Challenge #1
			for (int i=0; i < nbChallenge; i++) {
				String input = br.readLine();
				String res = saveTheEarth(input);
				System.out.println("Case #" + (i+1) + ": " + res);
			}
			
        } catch (IOException e) {}
	}

	/**
	 * To prevent the robot from getting too suspicious, the President does not
	 * want to hack too many times. What is this smallest possible number of hacks
	 * which will ensure that the program does no more than D total damage,
	 * if it is possible to do so?
	 * 
	 * @param input is something like "6 SCCSSC"
	 */
	private static String saveTheEarth(String input) {
		
		String[] challengeLine = input.split(" ");
		int shieldPower = Integer.parseInt(challengeLine[0]);
		String challenge = challengeLine[1]; 

		// let's start real fight
		int nbHacks = 0;
		StringBuilder editableInput = new StringBuilder(challenge);
		while (calcDamages(editableInput.toString()) > shieldPower) {

			// find the best place to hack
			int lIndex = editableInput.lastIndexOf("CS");

			// Runetime error ! ;-)
			if (lIndex < 0) {
				return "IMPOSSIBLE";
			}

			// HACK
			editableInput.setCharAt(lIndex + 1, 'C');
			editableInput.setCharAt(lIndex, 'S');
			nbHacks++;
		}
		return nbHacks + "";
		
	}
	
	private static int calcDamages(String input) {
		int damageTaken = 0;
		int beamStrength  = 1;
		for (int i=0; i < input.length(); i++) {
			if (input.charAt(i) == 'S')
				damageTaken += beamStrength;
			else
				beamStrength *= 2;
		}
		return damageTaken;
	}


}
