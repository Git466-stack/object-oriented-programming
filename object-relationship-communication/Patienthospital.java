import java.util.ArrayList;
import java.util.List;

// Patient class
class Patient {
    private String name;
    int age;
        private List<Doctor> consultedDoctors;
    
        // Constructor
        public Patient(String name, int age) {
            this.name = name;
            this.age = age;
            this.consultedDoctors = new ArrayList<>();
        }
    
        // Getter for patient name
        public String getName() {
            return name;
        }
    
        // Add a doctor to the patient's consulted list
        public void addConsultedDoctor(Doctor doctor) {
            if (!consultedDoctors.contains(doctor)) {
                consultedDoctors.add(doctor);
            }
        }
    
        // Display all doctors the patient has consulted
        public void displayConsultedDoctors() {
            System.out.println("Patient: " + name);
            if (consultedDoctors.isEmpty()) {
                System.out.println(" No doctors consulted yet.");
            } else {
                System.out.println(" Consulted Doctors:");
                for (Doctor doctor : consultedDoctors) {
                    System.out.println("  Dr. " + doctor.getName() + " (Specialization: " + doctor.getSpecialization() + ")");
                }
            }
        }
    }
    
    // Doctor class
    class Doctor {
        private String name;
        private String specialization;
        private List<Patient> patients;
    
        // Constructor
        public Doctor(String name, String specialization) {
            this.name = name;
            this.specialization = specialization;
            this.patients = new ArrayList<>();
        }
    
        // Getter for doctor name
        public String getName() {
            return name;
        }
    
        // Getter for doctor specialization
        public String getSpecialization() {
            return specialization;
        }
    
        // Consult a patient
        public void consult(Patient patient) {
            if (!patients.contains(patient)) {
                patients.add(patient);
                patient.addConsultedDoctor(this); // Ensure the relationship is bi-directional
            }
            System.out.println("Dr. " + name + " is consulting Patient " + patient.getName() + ".");
        }
    
        // Display all patients this doctor has consulted
        public void displayPatients() {
            System.out.println("Dr. " + name + " (Specialization: " + specialization + ")");
            if (patients.isEmpty()) {
                System.out.println(" No patients consulted yet.");
            } else {
                System.out.println(" Patients:");
                for (Patient patient : patients) {
                    System.out.println("  Patient: " + patient.getName());
                }
            }
        }
    }
    
    // Hospital class
    class Hospital {
        private String name;
        private List<Doctor> doctors;
        private List<Patient> patients;
    
        // Constructor
        public Hospital(String name) {
            this.name = name;
            this.doctors = new ArrayList<>();
            this.patients = new ArrayList<>();
        }
    
        // Add a doctor to the hospital
        public void addDoctor(Doctor doctor) {
            if (!doctors.contains(doctor)) {
                doctors.add(doctor);
            }
        }
    
        // Add a patient to the hospital
        public void addPatient(Patient patient) {
            if (!patients.contains(patient)) {
                patients.add(patient);
            }
        }
    
        // Display hospital details
        public void displayHospitalDetails() {
            System.out.println("Hospital: " + name);
    
            // Display doctors
            System.out.println("Doctors:");
            if (doctors.isEmpty()) {
                System.out.println(" No doctors in this hospital.");
            } else {
                for (Doctor doctor : doctors) {
                    System.out.println("  Dr. " + doctor.getName() + " (Specialization: " + doctor.getSpecialization() + ")");
                }
            }
    
            // Display patients
            System.out.println("Patients:");
            if (patients.isEmpty()) {
                System.out.println(" No patients in this hospital.");
            } else {
                for (Patient patient : patients) {
                    System.out.println("  Patient: " + patient.getName() + " (Age: " + patient.age + ")");
            }
        }
    }
}

public class Patienthospital {
    public static void main(String[] args) {
        // Create a hospital
        Hospital hospital = new Hospital("City Hospital");

        // Create doctors
        Doctor doctor1 = new Doctor("Alice", "Cardiology");
        Doctor doctor2 = new Doctor("Bob", "Orthopedics");

        // Create patients
        Patient patient1 = new Patient("John", 30);
        Patient patient2 = new Patient("Emma", 40);

        // Add doctors to the hospital
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);

        // Add patients to the hospital
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        // Consultations
        doctor1.consult(patient1);
        doctor1.consult(patient2);
        doctor2.consult(patient1);

        // Display hospital details
        System.out.println("\nHospital Details:");
        hospital.displayHospitalDetails();

        // Display doctors and their patients
        System.out.println("\nDoctor Details:");
        doctor1.displayPatients();
        doctor2.displayPatients();

        // Display patients and their consulted doctors
        System.out.println("\nPatient Details:");
        patient1.displayConsultedDoctors();
        patient2.displayConsultedDoctors();
    }
}
