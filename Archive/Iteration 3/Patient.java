import java.util.Date;

/**
 * This Patient class stores information of patients.
 * It provides getters and setters and support methods for determining if the
 * patient is under 5 and the ability to add visits.
 *
 * Author Phil Lane
 */
public class Patient {
    private String name;
    private Date dateOfBirth;
    private String patientID;
    private String mothersID;
    private String outPatientNumber;
    private String nhisNumber;
    private String sex;
    private int age;
    private String address;
    
    /**
     * Constructs a Patient object with required fields.
     *
     * @param name the patient's name
     * @param dateOfBirth the patient's date of birth
     * @param patientID the unique patient identifier
     * @param mothersID the ID of the patient's mother
     * @param sex the patient's sex
     * @param address the patient's address
     */
    public Patient(String name, Date dateOfBirth, 
                   String patientID, String mothersID, 
                   String sex, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.patientID = patientID;
        this.mothersID = mothersID;
        this.sex = sex;
        this.address = address;
    }

    /**
     * Checks if patient is under five years old
     * @return true if patient is under 5 years old
     */
    public boolean isUnderFive() {
        if (this.dateOfBirth == null) {
            return false;
        }
        
        long differenceInMillis = new Date().getTime() - this.dateOfBirth.getTime();
        long differenceInYears = differenceInMillis / (1000L * 60 * 60 * 24 * 365);
        return differenceInYears < 5;
    }
    
    // Getters and Setters
    
    /** @return the patient's name */
    public String getName() {
        return name;
    }
    
    /** @param name the patient's name */
    public void setName(String name) {
        this.name = name;
    }
    
    /** @return the patient's date of birth */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    
    /** @param dateOfBirth the patient's date of birth */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    /** @return the patient ID */
    public String getPatientID() {
        return patientID;
    }
    
    /** @param patientID the patient ID */
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
    
    /** @return the mother's ID */
    public String getMothersID() {
        return mothersID;
    }
    
    /** @param mothersID the mother's ID */
    public void setMothersID(String mothersID) {
        this.mothersID = mothersID;
    }
    
    /** @return the outpatient number */
    public String getOutPatientNumber() {
        return outPatientNumber;
    }
    
    /** @param outPatientNumber the outpatient number */
    public void setOutPatientNumber(String outPatientNumber) {
        this.outPatientNumber = outPatientNumber;
    }
    
    /** @return the NHIS (insurance) number */
    public String getNhisNumber() {
        return nhisNumber;
    }
    
    /** @param nhisNumber the NHIS (insurance) number */
    public void setNhisNumber(String nhisNumber) {
        this.nhisNumber = nhisNumber;
    }
    
    /** @return the patient's sex */
    public String getSex() {
        return sex;
    }
    
    /** @param sex the patient's sex */
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    /** @return the patient's age */
    public int getAge() {
        return age;
    }
    
    /** @param age the patient's age */
    public void setAge(int age) {
        this.age = age;
    }
    
    /** @return the patient's address */
    public String getAddress() {
        return address;
    }
    
    /** @param address the patient's address */
    public void setAddress(String address) {
        this.address = address;
    }

} 