package Inlämningsuppgift2;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException{
       //Här hämtar jag min andra klass
        Kunderna k = new Kunderna("m","a", LocalDate.now());

        //Här gör jag variablar

        String firstLine = "";
        String secondLine = "";
        String[] list;

        /*Här skapar jag en Bufferedreader och inut i den sätter jag in en Filereader där jag läser in min kundtext
  Sedan använder jag en While loop så att programmet läser igenom textfilen tills den kmr till null
 */

        try {
            BufferedReader b = new BufferedReader(new FileReader("src/Inlämningsuppgift2/kunder.txt"));
            while ((firstLine = b.readLine()) != null) {
                secondLine += firstLine + "\n";
            }

            /* Här delar jag strängen med hjälp utav split när det blir en ny rad, gör dessutom så att alla udda tal i listan
 blir datum och det jämna talen blir namn och personnummer.

Skapar en string där användaren får en fråga om att skriva namn elr personnummer
 Sedan kallar jag på min metod hittaMedlem för att kunna hitta platsen i listan som användaren har eller inte.
 Gjort minus 1 om personen inte finns med
  */

            list = secondLine.split("\n");
            String svar = JOptionPane.showInputDialog("Skriv ett namn eller personnummer: ");
            int kundPos = Kunderna.hittamedlem(svar, list);
            if (kundPos != -1) {


/* Använder mig av LocaleDate för att kunna räkna ut alla som betalt inom ett år tillbaka genom att få ut dagens datum
och göra minus ett år sedan parsar jag in dom, och sedan får jag även ut dom som varit medlemar tidigare
och dom som inte varit medlemmar alls
*/

                LocalDate idag = LocalDate.now();
                LocalDate ettÅrTillbaka = idag.minusYears(1);
                LocalDate senasteBetalning = LocalDate.parse(list[kundPos + 1]);

                if (senasteBetalning.isBefore(ettÅrTillbaka) || senasteBetalning.equals(ettÅrTillbaka)){
                    JOptionPane.showMessageDialog(null, list[kundPos] + " har varit medlem tidigare");
                }else {
                    String[] nuvarandeMedlem = list[kundPos].split(", ");
                    k.loggaIn(nuvarandeMedlem[0], nuvarandeMedlem[1], "src/Inlämningsuppgift2/customer.txt");
                    JOptionPane.showMessageDialog(null, list[kundPos] + " är medlem");
                }
            }else {
                JOptionPane.showMessageDialog(null, "Är inte medlem");
            }
        }catch (IOException e) {
            System.out.println("Felmeddelande");
            e.printStackTrace();
        }
    }}




