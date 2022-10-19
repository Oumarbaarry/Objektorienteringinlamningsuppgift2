package Inlämning1;

public abstract class växter implements VäxterInterface {

    /*Här ger jag ut variablar som är nödvändiga för inläsning av växt
    gör private på längd och namn för att det är något dom alla har
     */
    private double längd;
    private String name;

    String typVäxt;

    String typFöda;


    //Skapar en konstruktor
    public växter (double längd, String name){
        this.längd=längd;
        this.name=name;

        // Sedan använder jag getters för att kunna kalla på de olika variablarna
    }
    public double getLängd(){
        return längd;
    }
    public String getName(){
        return name;
    }




    }

