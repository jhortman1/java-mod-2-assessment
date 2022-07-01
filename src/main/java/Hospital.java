import java.util.ArrayList;

public class Hospital {
    private String name;
    private ArrayList<Doctor> doctorsList;
    public Hospital(String name) {
        this.name = name;
        this.doctorsList = new ArrayList<Doctor>();
    }
    public ArrayList<Doctor> getListOfDoctors()
    {
        return this.doctorsList;
    }
    public void printListOfDoctors()
    {
        for (Doctor doctor : doctorsList) {
            System.out.println("Doctor: " + doctor.getName() + " " + "Specality: " + doctor.getSpecality());
            System.out.println("Patients: ");
            doctor.getListOfPatients();
        }
    }
    public void addDoctor(Doctor doc)
    {
        doctorsList.add(doc);
    }
    public void getHospitalName()
    {
        System.out.println("Hospital: " + name);
    }    
}
