import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Program som ber användaren om ett antal tal att slumpa fram och skriver ut i olika format
 *
 * 1. Be användaren om ett antal nummer att slumpa fram (kontrollera att inmatning är av korrekt format)
 * 2. Slumpa fram numren och spara i en array
 * 3. Kopiera denna array och sortera
 * 4. Kolla vilka tal som är jämna och ojämna, spara antal i två variabler
 * 5. Skriv ut resultat (original array, sorterad, totalt antal tal samt udda och jämna tal)
 *
 * @author Andrea Mogren, andmog-0
 */

public class Uppgift4
{
   public static void main(String[] args)
   {
      // Deklarera variabler och initiera konstanter
      final int MIN = 0;
      final int MAX = 999;
      boolean wrongInput = true;
      String stringAmount = "";
      int desiredAmount;
      int[] randomNumbers;
      int[] sortedNumbers;
      int loopMin = 0;
      int temp = 0;
      int even = 0;
      int odd = 0;
      // Regex som kollar om användaren skrivit in ett ord
      Pattern pattern = Pattern.compile("^[A-Öa-ö]++$");
      Scanner input = new Scanner(System.in);

      System.out.print("Ange hur många tal du vill slumpa fram (max 100 st): ");
      stringAmount = input.nextLine();

      do
      {
         // Kolla om användren skrivit in ett ord istället för siffror
         if (pattern.matcher(stringAmount).matches())
         {
            System.out.printf("Skriv numret med siffor, ej bokstäver.%n");
            System.out.print("Ange hur många tal du vill slumpa fram (max 100 st): ");
            stringAmount = input.nextLine();
         } else
         {
            desiredAmount = Integer.parseInt(stringAmount);

            // Kolla så att talet inte överstiger 100
            if (desiredAmount > 100)
            {
               System.out.printf("För stort tal, försök igen.%n");
               System.out.print("Ange hur många tal du vill slumpa fram (max 100 st): ");
               stringAmount = input.nextLine();
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

               // Sätt wrong input till false eftersom användaren matade in korrekt sorts av värde
               wrongInput = false;
            }
         }
      } while (wrongInput);
   }
}
