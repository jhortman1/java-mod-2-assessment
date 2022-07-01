public class Patient {

    private String symtoms;
    private String fname;
    private String lname;

    public Patient(String fname, String lname, String symtoms) {
        this.symtoms = symtoms;
        this.fname = fname;
        this.lname = lname;
    }

    public void getName()
    {
        System.out.println("Patient: "+ fname + " "+ lname);
    }
    public String getSymtoms()
    {
        return symtoms;
    }
    public void printSymptom()
    {
            System.out.println(symtoms);
    }

}
