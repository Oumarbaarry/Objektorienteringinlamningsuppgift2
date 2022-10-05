public class Kaktusar extends växter{



// Skapar en superkonstruktor som läser in från min växter klass
    public Kaktusar(double längd, String name) {
        super(längd, name);
        typVäxt="Kaktus";
        typFöda="Mineralvatten";
    }
// Här är min uträkning för kaktusen
    public String antalföda(){
        return "Denna kaktus " +this.getName()+ " behöver 0.2 liter "+ typFöda+ " per dag";
    }
}
