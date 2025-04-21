import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a record of a patient's visit to a healthcare facility.
 * 
 * @author: @jabobas
 * @version: March 31, 2025
 */
public class Record {
    String gestationalPregnancy; // (how far along is the parent pregnant)
    Date date;
    String facility_zone;
    String subdistrict;
    String district;
    double bloodPressure;
    double weight;
    Double fetalHeartBeat;
    Double regularHeartbeat;
    int registrationNumber;
    int age;
    int year;
    boolean pretestCounseling; //(did they get info on the test)
    boolean postTestCounseling; //(did they get info on the results)
    boolean testResult; //(did they get tested)
    Boolean VDRL; //(syphilis)   
    ArrayList <String> remarksAndComplaints;
    ArrayList <Visit> visits;
    //boolean corrected;

    /**
     * Constructs a new Record object.
     *
     * @param gestationalPregnancy The stage of pregnancy.
     * @param date The date of the record.
     * @param facility_zone The healthcare facility zone.
     * @param subdistrict The subdistrict of the healthcare facility.
     * @param district The district of the healthcare facility.
     * @param bloodPressure The patient's blood pressure.
     * @param weight The patient's weight.
     * @param fetalHeartBeat The fetal heartbeat (nullable).
     * @param regularHeartbeat The patient's heartbeat (nullable).
     * @param registrationNumber The patient's registration number.
     * @param age The patient's age.
     * @param year The year of the record.
     * @param pretestCounseling Whether pretest counseling was provided.
     * @param postTestCounseling Whether post-test counseling was provided.
     * @param testResult Whether the patient was tested.
     * @param vDRL The result of the VDRL test (syphilis test).
     * @param remarksAndComplaints A list of remarks and complaints from the patient.
     */
    public Record(String gestationalPregnancy, Date date, String facility_zone, String subdistrict, String district,
            double bloodPressure, double weight, Double fetalHeartBeat, Double regularHeartbeat, int registrationNumber,
            int age, int year, boolean pretestCounseling, boolean postTestCounseling, boolean testResult, Boolean vDRL,
            ArrayList<String> remarksAndComplaints) {
        this.gestationalPregnancy = gestationalPregnancy;
        this.date = date;
        this.facility_zone = facility_zone;
        this.subdistrict = subdistrict;
        this.district = district;
        this.bloodPressure = bloodPressure;
        this.weight = weight;
        this.fetalHeartBeat = fetalHeartBeat;
        this.regularHeartbeat = regularHeartbeat;
        this.registrationNumber = registrationNumber;
        this.age = age;
        this.year = year;
        this.pretestCounseling = pretestCounseling;
        this.postTestCounseling = postTestCounseling;
        this.testResult = testResult;
        VDRL = vDRL;
        this.remarksAndComplaints = remarksAndComplaints;
        this.visits = visits;
        //this.corrected = false; //Indicates whether or not a record has been corrected by a newer record
        }

    // Getters and setters for all attributes
    public String getGestationalPregnancy() {
        return gestationalPregnancy;
    }
    public void setGestationalPregnancy(String gestationalPregnancy) {
        this.gestationalPregnancy = gestationalPregnancy;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getFacility_zone() {
        return facility_zone;
    }
    public void setFacility_zone(String facility_zone) {
        this.facility_zone = facility_zone;
    }
    public String getSubdistrict() {
        return subdistrict;
    }
    public void setSubdistrict(String subdistrict) {
        this.subdistrict = subdistrict;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public double getBloodPressure() {
        return bloodPressure;
    }
    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public Double getFetalHeartBeat() {
        return fetalHeartBeat;
    }
    public void setFetalHeartBeat(Double fetalHeartBeat) {
        this.fetalHeartBeat = fetalHeartBeat;
    }
    public Double getRegularHeartbeat() {
        return regularHeartbeat;
    }
    public void setRegularHeartbeat(Double regularHeartbeat) {
        this.regularHeartbeat = regularHeartbeat;
    }
    public int getRegistrationNumber() {
        return registrationNumber;
    }
    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public boolean isPretestCounseling() {
        return pretestCounseling;
    }
    public void setPretestCounseling(boolean pretestCounseling) {
        this.pretestCounseling = pretestCounseling;
    }
    public boolean isPostTestCounseling() {
        return postTestCounseling;
    }
    public void setPostTestCounseling(boolean postTestCounseling) {
        this.postTestCounseling = postTestCounseling;
    }
    public boolean isTestResult() {
        return testResult;
    }
    public void setTestResult(boolean testResult) {
        this.testResult = testResult;
    }
    public Boolean getVDRL() {
        return VDRL;
    }
    public void setVDRL(Boolean vDRL) {
        VDRL = vDRL;
    }
    public ArrayList<String> getRemarksAndComplaints() {
        return remarksAndComplaints;
    }
    public void setRemarksAndComplaints(ArrayList<String> remarksAndComplaints) {
        this.remarksAndComplaints = remarksAndComplaints;
    }
    /*Create a new visit, ask it to populate itself, and adds it to the arraylist of visits*/
    public void newVisit(String path){
        Visit latest = new Visit()
        latest.readDataFromPDF(path);
        visits.add(latest);

        this.weight = latest.weight;
        this.bloodPressure = latest.bloodPressure;
    //Here I will update the record with the latest visit
    }


    // public ArrayList<Visit> getVisits() {
    //     return visits;
    // }
    // public void setVisits(ArrayList<Visit> visits) {
    //     this.visits = visits;
    // }
    // public void addVisit(Visit visit) {
    //     //this.visits.add(visit);
    // }
    // public void removeVisit(Visit visit) {
    //     //this.visits.remove(visit);
    // }

}
