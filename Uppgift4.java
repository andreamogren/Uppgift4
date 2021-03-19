import java.util.Arrays;
import java.util.Scanner;

/**
 * Program som ber användaren om ett antal tal att slumpa fram och skriver ut resultatet i olika format
 *
 * 1. Be användaren om ett antal tal att slumpa fram (kontrollera att inmatningen är av korrekt format)
 * 2. Slumpa fram numren och spara i en array
 * 3. Kopiera denna array och sortera
 * 4. Kolla vilka tal som är jämna och ojämna, spara antalen i två variabler
 * 5. Skriv ut resultat (original array, sorterad, totalt antal tal samt udda och jämna tal)
 *
 * @author Andrea Mogren, andmog-0
 */

public class Uppgift4
{
   public static void main(String[] args)
   {
      // Deklarera variabler och konstanter
      final int MIN = 0;
      final int MAX = 999;
      boolean correctInput = false;
      int desiredAmount;
      int[] randomNumbers;
      int[] sortedNumbers;
      int loopMin = 0;
      int temp = 0;
      int even = 0;
      int odd = 0;
      Scanner input = new Scanner(System.in);

      do
      {
         System.out.print("Ange hur många tal du vill slumpa fram (max 100 st): ");

         // Om användaren matar in felaktig ett felaktigt värde, fånga felet och starta om loopen
         try
         {
            desiredAmount = input.nextInt();
         } catch (Exception e)
         {
            System.out.printf("Felaktig inmatning. Vänligen ange ett heltal skrivet med siffror.%n");

            // Rensa felaktig inmatning
            input.nextLine();
            continue;
         }

         // Kolla så att talet inte överstiger 100, starta isåfall om
         if (desiredAmount > 100)
         {
            System.out.printf("För stort tal, försök igen.%n");
            System.out.print("Ange hur många tal du vill slumpa fram (max 100 st): ");
         } else
         {
            randomNumbers = new int[desiredAmount];

            // Slumpa fram ett nummer för varje plats i arrayen
            for (int i = 0; i < randomNumbers.length; i++)
            {
               randomNumbers[i] = (int) (Math.random() * (MAX - MIN + 1) + MIN);
            }

            // Gör en kopia på randomNumbers för att initiera sortedNumbers
            sortedNumbers = Arrays.copyOf(randomNumbers, randomNumbers.length);

            // Sortera numren
            for (int i = 0; i < sortedNumbers.length - 1; i++)
            {
               loopMin = i;

               for (int k = i + 1; k < sortedNumbers.length; k++)
               {
                  if (sortedNumbers[k] < sortedNumbers[loopMin])
                  {
                     loopMin = k;
                  }
               }

               temp = sortedNumbers[i];
               sortedNumbers[i] = sortedNumbers[loopMin];
               sortedNumbers[loopMin] = temp;
            }

            // Kolla vilka som är jämna och udda
            for (int i = 0; i < sortedNumbers.length; i++)
            {
               if (sortedNumbers[i] % 2 == 0)
               {
                  even++;
               } else
               {
                  odd++;
               }
            }

            // Skriv ut resultat
            System.out.printf("%nHär är de slumpade talen:%n%s%n%n", Arrays.toString(randomNumbers));
            System.out.printf("Här är de slumpade talen ordnade:%n%s%n%n", Arrays.toString(sortedNumbers));
            System.out.printf("Av ovanstående %d tal var %d jämna och %d udda.", randomNumbers.length, even, odd);

            // Sätt correctInput till true eftersom användaren matade in korrekt sorts av värde
            correctInput = true;
         }
      } while (!correctInput);
   }
}
