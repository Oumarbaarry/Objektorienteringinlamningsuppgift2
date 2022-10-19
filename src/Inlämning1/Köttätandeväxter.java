package Inlämning1;

public class Köttätandeväxter extends växter {

    //Här skapar jag variablar
    double tillskott = 0.2;
    double basnivå = 0.1;

    // Skapar en superkonstruktor som läser in från min Inlämning1.växter klass

    public Köttätandeväxter(double längd, String name) {
        super(längd, name);
        typVäxt ="Köttättandeväxter";
        typFöda = "Protein dryck";
    }
    // Här är min uträkning för köttätande Inlämning1.växter
    public String antalföda(){
        return "Denna köttätande växt " +typVäxt + " behöver " + (basnivå+(tillskott*this.getLängd()))+ " Liter "+ typFöda+ " per dag";
    }
}
