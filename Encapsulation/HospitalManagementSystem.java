package Encapsulation;
import java.util.ArrayList;
import java.util.List;

// Abstract class Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    // Constructor
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Getters and setters (Encapsulation)
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Concrete method to display patient details
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Abstract method to calculate the bill
    public abstract double calculateBill();
}

// Interface MedicalRecord
interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {
    private double dailyRate;
    private int daysAdmitted;
    private List<String> medicalHistory;

    public InPatient(String patientId, String name, int age, double dailyRate, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyRate = dailyRate;
        this.daysAdmitted = daysAdmitted;
        this.medicalHistory = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return dailyRate * daysAdmitted;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return medicalHistory;
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> medicalHistory;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalHistory = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return medicalHistory;
    }
}

// Main class
public class HospitalManagementSystem {
    public static void main(String[] args) {
        // List to store patients
        List<Patient> patients = new ArrayList<>();

        // Adding patients
        InPatient inPatient1 = new InPatient("IP001", "Alice", 30, 2000, 5);
        inPatient1.addRecord("Admitted for surgery");
        inPatient1.addRecord("Post-surgery care");

        OutPatient outPatient1 = new OutPatient("OP001", "Bob", 40, 500);
        outPatient1.addRecord("Routine checkup");

        patients.add(inPatient1);
        patients.add(outPatient1);

        // Process patients
        System.out.println("Processing Patients...");
        for (Patient patient : patients) {
            System.out.println("=================================");
            patient.getPatientDetails();
            System.out.println("Medical Records: " + ((MedicalRecord) patient).viewRecords());
            System.out.println("Total Bill: " + patient.calculateBill());
            System.out.println("=================================");
        }
    }
}
