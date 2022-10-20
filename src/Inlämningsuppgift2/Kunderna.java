package Inlämningsuppgift2;

import java.io.*;
import java.time.LocalDate;

public class Kunderna {

    String namn;
    String pNummer;
    LocalDate senasteBetalning;

    
    public static int hittamedlem(String kund, String[] lista) {
        for (int i = 0; i < lista.length; i++){
            if (i % 2 == 0) {
                String[] nyMedlem = lista[i].split(", ");
                if (nyMedlem[0].equals(kund.trim()) || nyMedlem[1].equalsIgnoreCase(kund.trim())) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void loggaIn(String pNummer, String namn, String skapaText) throws IOException {
        String line;
        String inneBörd = "";
        BufferedReader bb = new BufferedReader(new FileReader(skapaText));
        while ((line = bb.readLine()) != null) {
            inneBörd += line + "\n";
        }
        try (PrintWriter ström = new PrintWriter(new BufferedWriter(new FileWriter(skapaText)));) {
            File fil2 = new File(skapaText);
            String kundData = pNummer + " " + namn + " " + LocalDate.now();
            inneBörd += kundData + "\n";
            ström.append(inneBörd);

        }
    }
   
    public Kunderna (String namn, String pNummer, LocalDate senasteBetalning){

    }
}
