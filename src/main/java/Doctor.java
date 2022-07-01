import java.util.ArrayList;

public class Doctor {
    private String fname;
    private String lname;
    private String specality;
    private ArrayList<Patient> patients;

    public Doctor(String fname, String lname, String specality) {
        this.fname = fname;
        this.lname = lname;
        this.specality = specality;
        this.patients = new ArrayList<Patient>();
    }

    public void addPatient(Patient p)
    {
        this.patients.add(p);
    }

    public String getName()
    {
        return "Doctor: " + this.fname + " " + this.lname;
    }

    public String getSpecality()
    {
       return specality;
    }
    public String printSpecality()
    {
       return "Specality: " + this.specality;
    }
    
    public void getListOfPatients()
    {
        for (Patient patient : patients) {
            patient.getName();
            System.out.println("Symptom: " + patient.getSymtoms() + " Problems");
        }
    }
}
