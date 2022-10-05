import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Här skapar jag upp alla olika växter

        växter palm = new Palmer(5,"Laura");
        växter palm2 = new Palmer(1,"Putte");
        växter kaktus = new Kaktusar(0.2,"Igge");
        växter köttätande = new Köttätandeväxter(0.7,"Meatloaf");

// Sedan så gör jag en arraylist så att jag ska kunna lägga in dom olika växterna
        ArrayList<växter>myVäxter=new ArrayList<>();
        myVäxter.add(palm);
        myVäxter.add(palm2);
        myVäxter.add(kaktus);
        myVäxter.add(köttätande);

/* Sen så skapar jag en String array som innehåller alla växter,jag kör en for loop genom hela listan myVäxter
 och stoppar in namnen på varje växt in till plats [i] inut i arrayen.
 */
        String[] växtArray = new String[5];
        for (int i =0; i<4;i++)
            växtArray[i]=myVäxter.get(i).getName();

//Gör dessutom plats för ett 5e alternativ ifall man inte skulle välja någon växt

        växtArray[4]= "Inget av dessa alternativ";

//Sen skapar jag dropdownlistan, första argumentet (det man skriver när man skapar den) i den ska vara null,
// sedan frågan som ställs i rutan, rubriken, meddelandetyp (ikonen), sen null,
// efter det skriver in arrayen som namnen ska tas från i listan och sist skriver den String som är standardvalet i dropdownlistan

        String valAvVäxt = (String) JOptionPane.showInputDialog(null,
                "Välj vilken växt som ska få föda? ",
                "Näringstabell",
                JOptionPane.QUESTION_MESSAGE,
                null,växtArray,växtArray[0]);

/*Sen gör enhanced loop som går igenom alla växter.
Så för varje växt "växt" i listan myVäxter,
kontrollerar loopen om Stringen valAvVäxt är samma som växtens namn,
och om det är det så skriver den ut meddelandet som ligger i det växtobjektet som en metod
 */

        //Här sker polymorfismen
        for (växter växt:myVäxter)
            if (valAvVäxt.equalsIgnoreCase(växt.getName()))
                JOptionPane.showMessageDialog(null, växt.antalföda());



    }
}