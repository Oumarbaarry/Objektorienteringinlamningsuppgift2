package Inlämningsuppgift2;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException{
       
        Kunderna k = new Kunderna("m","a", LocalDate.now());

        

        String firstLine = "";
        String secondLine = "";
        String[] list;

     
        try {
            BufferedReader b = new BufferedReader(new FileReader("src/Inlämningsuppgift2/kunder.txt"));
            while ((firstLine = b.readLine()) != null) {
                secondLine += firstLine + "\n";
            }

     

            list = secondLine.split("\n");
            String svar = JOptionPane.showInputDialog("Skriv ett namn eller personnummer: ");
            int kundPos = Kunderna.hittamedlem(svar, list);
            if (kundPos != -1) {




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




