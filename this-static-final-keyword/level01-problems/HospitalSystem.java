class Patient{
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;
    private final int PatientId;

    private String name;
    private int age;
    private String aligment;

   public  Patient(int PatientId, String name, int age, String aligment){
    this.PatientId = PatientId;
    this.name = name;
    this.age = age;
    this.aligment = aligment;
    totalPatients++;
   }
   public void displayPatientDetails(){
    if( this instanceof Patient){
        System.out.println("Hospital Name: " + hospitalName);
        System.out.println("PatientId: " + PatientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Aligment: " + aligment);
    }
   }
   public static void getTotalPatients(){
    System.out.println("Total Patients Admitted: " + totalPatients);
   }

}

public class HospitalSystem{
    public static void main(String[] args) {
        Patient patient1 = new Patient(101, "abhi", 22, "Fever");
        Patient patient2 = new Patient(102, "sahu", 22, "cold");
        patient1.displayPatientDetails();
        System.out.println();
        patient2.displayPatientDetails();
        

        Patient.getTotalPatients();
    }
}