import java.util.ArrayList;
import java.util.Scanner;

public class HoapitalWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hospitalName;

        //Welcome to hospital world
        System.out.println("Welcome to Hospital world....");
        hospitalName = hasInput(scanner, "Enter the name of your hospital: ");
        //System.out.println("Enter the name of your hospital: ");
        //get the name of the hospital
        Hospital newHospitalWorld = new Hospital(hospitalName);
        //get names of doctors the specality for 3 doctor
        //provide list of specilities the user can choose from
        addDoctors(scanner, newHospitalWorld);
        addPatients(scanner, newHospitalWorld.getListOfDoctors());
        //user to create 5 paitients and add them to the doctors list of patients

        System.out.println("Printing Hospital World:");

        newHospitalWorld.getHospitalName();
        for (Doctor doc : newHospitalWorld.getListOfDoctors() ) {
            System.out.println("----------------------------");
            System.out.println(doc.getName());
            System.out.println( doc.getSpecality());
            doc.getListOfPatients();
            System.out.println("----------------------------");
        }
        scanner.close();
    }
    private static void addPatients(Scanner scanner, ArrayList<Doctor> doctorList) {
        String firstName;
        String lastName;
        int symptomsInt = 0;
        Patient p;

        for(int i = 0; i < 5; i++)
        {
            System.out.println("Follow prompts to enter 5 Patients's Names and area where symtoms exist from list below:");
            System.out.println("----------------------------");
            System.out.println("Patient #: "+(i+1));
            firstName = hasInput(scanner, "Enter First Name: ");
            lastName = hasInput(scanner, "Enter Last Name: ");
            System.out.println("Enter Symptom (1) Skin Issues (2) Brain Issues (3) Eyes Issues (4) Disease related symptoms (5) Kid related symptoms (6) General for misc");
            System.out.println("----------------------------");
            
            do{
                symptomsInt = 0;
                try{
                    symptomsInt = Integer.parseInt(scanner.nextLine());
                }catch(Exception e)
                {
                    System.out.println("Sorry you entered an incorrect value enter value 1-6 to choose Symptom");
                }
            }while(symptomsInt < 1 || symptomsInt > 6);

            switch (symptomsInt)
            {
                case 1:
                    p = new Patient(firstName, lastName, "Skin");
                    assignPatient(p,doctorList);
                    break;
                case 2:
                    p = new Patient(firstName, lastName, "Brain");
                    assignPatient(p,doctorList);
                    break;
                case 3:
                    p = new Patient(firstName, lastName, "Eye");
                    assignPatient(p,doctorList);
                    break;
                case 4:
                    p = new Patient(firstName, lastName, "Disease");
                    assignPatient(p,doctorList);
                    break;
                case 5:
                    p = new Patient(firstName, lastName, "Kid");
                    assignPatient(p,doctorList);
                    break;
                default:
                    p = new Patient(firstName, lastName, "General");
                    assignPatient(p,doctorList);
                    break;
            } 

        }
    }
    public static void addDoctors(Scanner scanner, Hospital newHospitalWorld)
    {
        int specalityInt = 0;
        String firstName;
        String lastName;
        Doctor dr;

        for(int i = 0; i < 3; i++)
        {
            System.out.println("Follow prompts to enter 3 Doctor's Name and Specality from list below:");
            System.out.println("----------------------------");
            System.out.println("Doctor #: "+(i+1));
            firstName = hasInput(scanner, "Enter First Name: ");
            lastName = hasInput(scanner, "Enter Last Name: ");
            System.out.println("Enter (1) Dermatology (2) Neurology (3) Ophthalmology (4) Pathology (5) Pediatrics (6) General");
            System.out.println("----------------------------");
            do{
                try{
                    specalityInt = 0;
                    specalityInt = Integer.parseInt(scanner.nextLine());
                }catch(Exception e)
                {
                    System.out.println("Sorry you entered an incorrect value enter value 1-6 to choose Specality");
                }
            }while(specalityInt < 1 || specalityInt > 6);

            switch (specalityInt)
            {
                case 1:
                    dr = new Doctor(firstName, lastName, "Dermatology");
                    newHospitalWorld.addDoctor(dr);
                    break;
                case 2:
                    dr = new Doctor(firstName, lastName, "Neurology");
                    newHospitalWorld.addDoctor(dr);
                    break;
                case 3:
                    dr = new Doctor(firstName, lastName, "Ophthalmology");
                    newHospitalWorld.addDoctor(dr);
                    break;
                case 4:
                    dr = new Doctor(firstName, lastName, "Pathology");
                    newHospitalWorld.addDoctor(dr);
                    break;
                case 5:
                    dr = new Doctor(firstName, lastName, "Pediatrics");
                    newHospitalWorld.addDoctor(dr);
                    break;
                case 6:
                    dr = new Doctor(firstName, lastName, "General");
                    newHospitalWorld.addDoctor(dr);
                    break;
            }
        }

    }
    public static void assignPatient(Patient p, ArrayList<Doctor> doctorList)
    {
        if(p.getSymtoms().equals("Skin"))
        {
            for (Doctor doctor: doctorList) {
                if(doctor.getSpecality().equals("Dermatology"))
                {
                    doctor.addPatient(p);
                }
            }
        }
        else if(p.getSymtoms().equals("Brain"))
        {
            for (Doctor doctor: doctorList) {
                if(doctor.getSpecality().equals("Neurology"))
                {
                    doctor.addPatient(p);
                }
            }
        }
        else if(p.getSymtoms().equals("Eye"))
        {
            for (Doctor doctor: doctorList) {
                if(doctor.getSpecality().equals("Ophthalmology"))
                {
                    doctor.addPatient(p);
                }
            }
        }
        else if(p.getSymtoms().equals("Disease"))
        {
            for (Doctor doctor: doctorList) {
                if(doctor.getSpecality().equals("Pathology"))
                {
                    doctor.addPatient(p);
                }
            }
        }
        else if(p.getSymtoms().contains("Kid"))
        {
            for (Doctor doctor: doctorList) {
                if(doctor.getSpecality().equals("Pediatrics"))
                {
                    doctor.addPatient(p);
                }
            }
        }
        else
        {
            for (Doctor doctor: doctorList) {
                if(doctor.getSpecality().equals("General"))
                {
                    doctor.addPatient(p);
                }
            }
        }
    }
    public static void noDoctorToTreatYourIllness(Patient p)
    {
        System.out.println("Sorry We do not have a doctor to tret you.");
        p.getName();
        System.out.println("Will have to go to another hospital. Sorry.");
    }
    public static String hasInput(Scanner scanner, String request)
    {
        String check;   
        do{
            System.out.println(request);
            check = scanner.nextLine();
        }while(check.isEmpty());
        return check;
    }
}