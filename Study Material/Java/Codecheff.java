import java.util.*;
import java.lang.*;
import java.io.*;

class Codecheff {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // Number of test cases

        while (T-- > 0) {
            int N = scanner.nextInt(); // Number of monsters
            int X = scanner.nextInt(); // Initial health
            int K = scanner.nextInt(); // Multiplier of the spell
            int[] H = new int[N];

            // Read the health of monsters
            for (int i = 0; i < N; i++) {
                H[i] = scanner.nextInt();
            }

            // Sort monster healths
            Arrays.sort(H);

            // Case 1: Using spell immediately
            int healthWithSpell = X * K;
            int monstersDefeatedWithSpell = 0;
            for (int health : H) {
                if (healthWithSpell > health) {
                    monstersDefeatedWithSpell++;
                    healthWithSpell = health;
                } else {
                    break;
                }
            }

            // Case 2: Using spell later (after defeating some monsters)
            int currentHealth = X;
            int monstersDefeatedWithoutSpell = 0;
            int monstersDefeatedWithSpellAfter = 0;
            for (int i = 0; i < N; i++) {
                if (currentHealth > H[i]) {
                    monstersDefeatedWithoutSpell++;
                    currentHealth = H[i];
                    // Count remaining monsters with spell
                    int tempHealth = currentHealth * K;
                    int remainingMonstersDefeated = monstersDefeatedWithoutSpell;
                    for (int j = i + 1; j < N; j++) {
                        if (tempHealth > H[j]) {
                            remainingMonstersDefeated++;
                            tempHealth = H[j];
                        } else {
                            break;
                        }
                    }
                    monstersDefeatedWithSpellAfter = Math.max(monstersDefeatedWithSpellAfter, remainingMonstersDefeated);
                } else {
                    break;
                }
            }

            // Output the maximum number of monsters defeated
            int result = Math.max(monstersDefeatedWithSpell, monstersDefeatedWithSpellAfter);
            System.out.println(result);
        }

        scanner.close();
    }
}
