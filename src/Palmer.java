public class Palmer extends växter{


    //Här skapar jag variablar
    final double föda = 0.5;

    // Skapar en superkonstruktor som läser in från min växter klass
    public Palmer(double längd, String name) {
        super(längd, name);
        typVäxt ="Palm";
        typFöda = "Kranvatten";
    }
    // Här är min uträkning för palmer
    public String antalföda(){
        return "Denna palm "+ this.getName() + " behöver " +(this.getLängd()*föda)+ " liter "+ typFöda + " per dag";
    }

}


