import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * The Mother class, subtype of Patient, holds maternity-specific information, including
 * their record in the antenatal care register.
 */
public class Mother extends Patient {
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

    public Mother(String name, Date dateOfBirth, String patientID, String mothersID, String sex, String address,
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Trimester getTrimester() {
        return trimester;
    }

    public void setTrimester(Trimester trimester) {
        this.trimester = trimester;
    }

    public String getFacilityZone() {
        return facilityZone;
    }

    public void setFacilityZone(String facilityZone) {
        this.facilityZone = facilityZone;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getSicklingType() {
        return sicklingType;
    }

    public void setSicklingType(String sicklingType) {
        this.sicklingType = sicklingType;
    }

    public boolean isSicklingBlood() {
        return sicklingBlood;
    }

    public void setSicklingBlood(boolean sicklingBlood) {
        this.sicklingBlood = sicklingBlood;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public double getHgAtRegistry() {
        return hgAtRegistry;
    }

    public void setHgAtRegistry(double hgAtRegistry) {
        this.hgAtRegistry = hgAtRegistry;
    }

    public double getHgAt36Wks() {
        return hgAt36Wks;
    }

    public void setHgAt36Wks(double hgAt36Wks) {
        this.hgAt36Wks = hgAt36Wks;
    }

    public Date getEstimatedDueDate() {
        return estimatedDueDate;
    }

    public void setEstimatedDueDate(Date estimatedDueDate) {
        this.estimatedDueDate = estimatedDueDate;
    }

    public int getParity() {
        return parity;
    }

    public void setParity(int parity) {
        this.parity = parity;
    }

    public boolean isVdrlAdministered() {
        return vdrlAdministered;
    }

    public void setVdrlAdministered(boolean vdrlAdministered) {
        this.vdrlAdministered = vdrlAdministered;
    }

    public boolean isVdrlStatus() {
        return vdrlStatus;
    }

    public void setVdrlStatus(boolean vdrlStatus) {
        this.vdrlStatus = vdrlStatus;
    }

    public boolean isHivPreCounseling() {
        return hivPreCounseling;
    }

    public void setHivPreCounseling(boolean hivPreCounseling) {
        this.hivPreCounseling = hivPreCounseling;
    }

    public int getGestationalAge() {
        return gestationalAge;
    }

    public void setGestationalAge(int gestationalAge) {
        this.gestationalAge = gestationalAge;
    }

    public Date getEstimatedConceptionDate() {
        return estimatedConceptionDate;
    }

    public void setEstimatedConceptionDate(Date estimatedConceptionDate) {
        this.estimatedConceptionDate = estimatedConceptionDate;
    }

    public boolean isTetanusToxoidStatus() {
        return tetanusToxoidStatus;
    }

    public void setTetanusToxoidStatus(boolean tetanusToxoidStatus) {
        this.tetanusToxoidStatus = tetanusToxoidStatus;
    }

    public int getTetanusToxoidDoses() {
        return tetanusToxoidDoses;
    }

    public void setTetanusToxoidDoses(int tetanusToxoidDoses) {
        this.tetanusToxoidDoses = tetanusToxoidDoses;
    }

    public int getIptMalariaDoses() {
        return iptMalariaDoses;
    }

    public void setIptMalariaDoses(int iptMalariaDoses) {
        this.iptMalariaDoses = iptMalariaDoses;
    }

    public boolean isItnInUse() {
        return itnInUse;
    }

    public void setItnInUse(boolean itnInUse) {
        this.itnInUse = itnInUse;
    }

    public void addVisit(Visit visit) {
        visits.add(visit);
    }

    public List<Visit> getVisits() {
        return visits;
    }

}