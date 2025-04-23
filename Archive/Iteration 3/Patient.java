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
     * Constructor with required fields
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
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getPatientID() {
        return patientID;
    }
    
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
    
    public String getMothersID() {
        return mothersID;
    }
    
    public void setMothersID(String mothersID) {
        this.mothersID = mothersID;
    }
    
    public String getOutPatientNumber() {
        return outPatientNumber;
    }
    
    public void setOutPatientNumber(String outPatientNumber) {
        this.outPatientNumber = outPatientNumber;
    }
    
    public String getNhisNumber() {
        return nhisNumber;
    }
    
    public void setNhisNumber(String nhisNumber) {
        this.nhisNumber = nhisNumber;
    }
    
    public String getSex() {
        return sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

} 