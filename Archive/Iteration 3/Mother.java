
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * The Mother class, subtype of Patient, holds maternity-specific information, including
 * their record in the antenatal care register.
 */
public class Mother extends Patient {
    private String midwifeName;
    private int age;
    private int registrationNumber;
    private double height;

    private Trimester trimester;
    private String facilityZone;
    private String subDistrict;

    private String sicklingType;
    private boolean sicklingBlood;
    private String bloodGroup;
    private double hgAtRegistry;
    private double hgAt36Wks;
    private Date estimatedDueDate;
    private int parity;

    private boolean vdrlAdministered;
    private boolean vdrlStatus;

    // pg. 110
    // https://data.unicef.org/wp-content/uploads/2017/04/Pregnancy-Childbirth-Postpartum-and-Newborn-Care.pdf
    private boolean hivPreCounseling;

    // In days.
    private int gestationalAge;

    private Date estimatedConceptionDate;

    private boolean tetanusToxoidStatus;
    private int tetanusToxoidDoses;

    /* IPT, in the context of antenatal care, 
       refers to Intermittent Preventive Treatment 
       of malaria in pregnancy (IPTp). 
       It's a strategy where pregnant women in 
       malaria-endemic areas receive full doses of 
       an antimalarial drug,...at specific intervals 
       during pregnancy, regardless of whether they 
       have malaria symptoms or not.
       (Google AI result).
    */
    private int iptMalariaDoses;

    /* In the context of antental care, ITN refers to 
       insecticide-treated nets, which are bed nets 
       treated with insecticide to prevent mosquito bites 
       and mosquito-borne diseases, particularly malaria. 
       (Google AI result).
     */
    private boolean itnInUse;

    private List<Visit> visits;

    /**
     * Constructs a new Mother object with full maternity details.
     *
     * @param midwifeName name of the attending midwife
     * @param name mother's name
     * @param dateOfBirth mother's date of birth
     * @param patientID unique patient identifier
     * @param mothersID ID of the mother's mother
     * @param sex biological sex
     * @param address residential address
     * @param age current age
     * @param registrationNumber registration ID in the clinic
     * @param height height in centimeters
     * @param trimester current trimester
     * @param facilityZone healthcare zone of the facility
     * @param subDistrict local subdistrict
     * @param sicklingType sickling type if any
     * @param sicklingBlood whether the patient has sickling blood
     * @param bloodGroup blood type
     * @param hgAtRegistry hemoglobin level at registration
     * @param hgAt36Wks hemoglobin level at 36 weeks (if known)
     * @param estimatedDueDate expected date of delivery
     * @param parity number of previous births
     * @param vdrlAdministered whether VDRL was administered
     * @param vdrlStatus VDRL result if administered
     * @param hivPreCounseling whether HIV counseling occurred pre-diagnosis
     * @param gestationalAge age of the pregnancy in days
     * @param tetanusToxoidStatus whether immunized against tetanus
     * @param tetanusToxoidDoses number of tetanus doses given
     * @param iptMalariaDoses number of malaria IPT doses received
     * @param itnInUse whether using insecticide-treated net
     */
    public Mother(String midwifeName, String name, Date dateOfBirth, String patientID, String mothersID, 
            String sex, String address,
            int age, int registrationNumber, double height, Trimester trimester, String facilityZone,
            String subDistrict, String sicklingType, boolean sicklingBlood, String bloodGroup, double hgAtRegistry,
            double hgAt36Wks, Date estimatedDueDate, int parity, boolean vdrlAdministered, boolean vdrlStatus,
            boolean hivPreCounseling, int gestationalAge, boolean tetanusToxoidStatus, int tetanusToxoidDoses,
            int iptMalariaDoses, boolean itnInUse) {
        super(name, dateOfBirth, patientID, mothersID, sex, address);
        this.age = age;
        this.registrationNumber = registrationNumber;
        this.height = height;
        this.trimester = trimester;
        this.facilityZone = facilityZone;
        this.subDistrict = subDistrict;
        this.sicklingType = sicklingType;
        this.sicklingBlood = sicklingBlood;
        this.bloodGroup = bloodGroup;
        this.hgAtRegistry = hgAtRegistry;
        this.hgAt36Wks = hgAt36Wks;
        this.estimatedDueDate = estimatedDueDate;
        this.parity = parity;
        this.vdrlAdministered = vdrlAdministered;
        this.vdrlStatus = vdrlStatus;
        this.hivPreCounseling = hivPreCounseling;
        this.gestationalAge = gestationalAge;
        
        // Estimate start of pregnancy based on gestational age.
        estimatedConceptionDate = 
            new Date((new Date().getTime()) - TimeUnit.DAYS.toMillis(gestationalAge));

        this.tetanusToxoidStatus = tetanusToxoidStatus;
        this.tetanusToxoidDoses = tetanusToxoidDoses;
        this.iptMalariaDoses = iptMalariaDoses;
        this.itnInUse = itnInUse;
        this.visits = new ArrayList<>();
    }

    /** @return name of the assigned midwife */
    public String getMidwifeName() {
        return midwifeName;
    }

    /** @param midwifeName name of the assigned midwife */
    public void setMidwifeName(String midwifeName) {
        this.midwifeName = midwifeName;
    }

    /** @return current age */
    public int getAge() {
        return age;
    }

    /** @param age current age */
    public void setAge(int age) {
        this.age = age;
    }

    /** @return registration number */
    public int getRegistrationNumber() {
        return registrationNumber;
    }

    /** @param registrationNumber clinic registration number */
    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /** @return height in centimeters */
    public double getHeight() {
        return height;
    }

    /** @param height height in centimeters */
    public void setHeight(double height) {
        this.height = height;
    }

    /** @return trimester */
    public Trimester getTrimester() {
        return trimester;
    }

    /** @param trimester current pregnancy trimester */
    public void setTrimester(Trimester trimester) {
        this.trimester = trimester;
    }

    /** @return facility zone */
    public String getFacilityZone() {
        return facilityZone;
    }

    /** @param facilityZone zone of the healthcare facility */
    public void setFacilityZone(String facilityZone) {
        this.facilityZone = facilityZone;
    }

    /** @return subdistrict */
    public String getSubDistrict() {
        return subDistrict;
    }

    /** @param subDistrict patient's local subdistrict */
    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    /** @return sickling type */
    public String getSicklingType() {
        return sicklingType;
    }

    /** @param sicklingType type of sickling blood */
    public void setSicklingType(String sicklingType) {
        this.sicklingType = sicklingType;
    }

    /** @return true if patient has sickling blood */
    public boolean isSicklingBlood() {
        return sicklingBlood;
    }

    /** @param sicklingBlood whether patient has sickling blood */
    public void setSicklingBlood(boolean sicklingBlood) {
        this.sicklingBlood = sicklingBlood;
    }

    /** @return blood group */
    public String getBloodGroup() {
        return bloodGroup;
    }

    /** @param bloodGroup blood group */
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    /** @return blood pressure at registration */
    public double getHgAtRegistry() {
        return hgAtRegistry;
    }

    /** @param hgAtRegistry blood pressure at registration */
    public void setHgAtRegistry(double hgAtRegistry) {
        this.hgAtRegistry = hgAtRegistry;
    }

    /** @return blood pressure at 36 weeks */
    public double getHgAt36Wks() {
        return hgAt36Wks;
    }

    /** @param hgAt36Wks blood pressure at 36 weeks */
    public void setHgAt36Wks(double hgAt36Wks) {
        this.hgAt36Wks = hgAt36Wks;
    }

    /** @return estimated due date */
    public Date getEstimatedDueDate() {
        return estimatedDueDate;
    }

    /** @param estimatedDueDate expected due date */
    public void setEstimatedDueDate(Date estimatedDueDate) {
        this.estimatedDueDate = estimatedDueDate;
    }

    /** @return parity */
    public int getParity() {
        return parity;
    }

    /** @param parity number of births with gestational age of 24+ weeks */
    public void setParity(int parity) {
        this.parity = parity;
    }

    /** @return true if VDRL test was administered */
    public boolean isVdrlAdministered() {
        return vdrlAdministered;
    }

    /** @param vdrlAdministered whether VDRL was administered */
    public void setVdrlAdministered(boolean vdrlAdministered) {
        this.vdrlAdministered = vdrlAdministered;
    }

    /** @return VDRL test result */
    public boolean isVdrlStatus() {
        return vdrlStatus;
    }

    /** @param vdrlStatus result of the VDRL test */
    public void setVdrlStatus(boolean vdrlStatus) {
        this.vdrlStatus = vdrlStatus;
    }

    /** @return true if HIV pre-counseling was provided */
    public boolean isHivPreCounseling() {
        return hivPreCounseling;
    }

    /** @param hivPreCounseling whether HIV counseling occurred */
    public void setHivPreCounseling(boolean hivPreCounseling) {
        this.hivPreCounseling = hivPreCounseling;
    }

    /** @return gestational age in days */
    public int getGestationalAge() {
        return gestationalAge;
    }

    /** @param gestationalAge age of pregnancy in days */
    public void setGestationalAge(int gestationalAge) {
        this.gestationalAge = gestationalAge;
    }

    /** @return estimated date of conception */
    public Date getEstimatedConceptionDate() {
        return estimatedConceptionDate;
    }

    /** @param estimatedConceptionDate calculated or estimated conception date */
    public void setEstimatedConceptionDate(Date estimatedConceptionDate) {
        this.estimatedConceptionDate = estimatedConceptionDate;
    }

    /** @return true if tetanus immunization is given */
    public boolean isTetanusToxoidStatus() {
        return tetanusToxoidStatus;
    }

    /** @param tetanusToxoidStatus tetanus immunization status */
    public void setTetanusToxoidStatus(boolean tetanusToxoidStatus) {
        this.tetanusToxoidStatus = tetanusToxoidStatus;
    }

    /** @return number of tetanus doses received */
    public int getTetanusToxoidDoses() {
        return tetanusToxoidDoses;
    }

    /** @param tetanusToxoidDoses number of doses of tetanus vaccine */
    public void setTetanusToxoidDoses(int tetanusToxoidDoses) {
        this.tetanusToxoidDoses = tetanusToxoidDoses;
    }

    /** @return number of IPT malaria doses received */
    public int getIptMalariaDoses() {
        return iptMalariaDoses;
    }

    /** @param iptMalariaDoses number of malaria IPT doses */
    public void setIptMalariaDoses(int iptMalariaDoses) {
        this.iptMalariaDoses = iptMalariaDoses;
    }

    /** @return true if insecticide-treated net is in use */
    public boolean isItnInUse() {
        return itnInUse;
    }

    /** @param itnInUse whether an insecticide-treated net is used */
    public void setItnInUse(boolean itnInUse) {
        this.itnInUse = itnInUse;
    }

    /**
     * Adds a new visit to the mother's visit record.
     *
     * @param visit a Visit object to add
     */
    public void addVisit(Visit visit) {
        visits.add(visit);
    }

    /**
     * Gets the list of visits recorded for this mother.
     *
     * @return list of Visit objects
     */
    public List<Visit> getVisits() {
        return visits;
    }

    

}