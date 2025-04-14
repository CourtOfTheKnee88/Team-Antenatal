/**
 * The Mother class, subtype of Patient, holds maternity-specific information, including
 * their record in the antenatal care register.
 */
public class Mother {
    private String patientName;
    private String address;
    private String estimatedDueDate;
    private int parity;
    private String sicklingType;
    private boolean sicklingBlood;
    private String bloodGroup;
    private double hgAtRegistry;
    private double hgAt36Wks;
    private Record record;
    
    /**
     * Constructor for the Mother class.
     * 
     * @param patientName The name of the mother.
     * @param address The address of the mother.
     * @param estimatedDueDate The estimated due date for the mother.
     * @param parity The parity of the mother.
     * @param sicklingType The sickling type of the mother (if they have one).
     * @param sicklingBlood Whether or not the mother has sickling cell disease.
     * @param bloodGroup The blood group of the mother.
     * @param hgAtRegistry Blood pressure at registry into the care register.
     * @param hgAt36Wks Blood pressure at 36 weeks.
     * @param record The record of the mother.
     */
    Mother(String patientName, String address, String estimatedDueDate,
            int parity, String sicklingType, boolean sicklingBlood, String bloodGroup,
            double hgAtRegistry, double hgAt36Wks, Record record) {
        
        this.patientName = patientName;
        this.address = address;
        this.estimatedDueDate = estimatedDueDate;
        this.parity = parity;
        this.sicklingType = sicklingType;
        this.sicklingBlood = sicklingBlood;
        this.bloodGroup = bloodGroup;
        this.hgAtRegistry = hgAtRegistry;
        this.hgAt36Wks = hgAt36Wks;
        this.record = record;
    }

        /**
     * Gets the name of the mother.
     * 
     * @return The mother's name.
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * Sets the name of the mother.
     * 
     * @param patientName The name to set.
     */
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    /**
     * Gets the address of the mother.
     * 
     * @return The mother's address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the mother.
     * 
     * @param address The address to set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the estimated due date.
     * 
     * @return The estimated due date.
     */
    public String getEstimatedDueDate() {
        return estimatedDueDate;
    }

    /**
     * Sets the estimated due date.
     * 
     * @param estimatedDueDate The estimated due date to set.
     */
    public void setEstimatedDueDate(String estimatedDueDate) {
        this.estimatedDueDate = estimatedDueDate;
    }

    /**
     * Gets the parity of the mother.
     * 
     * @return The parity value.
     */
    public int getParity() {
        return parity;
    }

    /**
     * Sets the parity of the mother.
     * 
     * @param parity The parity value to set.
     */
    public void setParity(int parity) {
        this.parity = parity;
    }

    /**
     * Gets the sickling type of the mother.
     * 
     * @return The sickling type.
     */
    public String getSicklingType() {
        return sicklingType;
    }

    /**
     * Sets the sickling type of the mother.
     * 
     * @param sicklingType The sickling type to set.
     */
    public void setSicklingType(String sicklingType) {
        this.sicklingType = sicklingType;
    }

    /**
     * Checks if the mother has sickling blood.
     * 
     * @return true if the mother has sickling blood, false otherwise.
     */
    public boolean isSicklingBlood() {
        return sicklingBlood;
    }

    /**
     * Sets whether the mother has sickling blood.
     * 
     * @param sicklingBlood true if the mother has sickling blood, false otherwise.
     */
    public void setSicklingBlood(boolean sicklingBlood) {
        this.sicklingBlood = sicklingBlood;
    }

    /**
     * Gets the blood group of the mother.
     * 
     * @return The blood group.
     */
    public String getBloodGroup() {
        return bloodGroup;
    }

    /**
     * Sets the blood group of the mother.
     * 
     * @param bloodGroup The blood group to set.
     */
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    /**
     * Gets the hemoglobin level at registry.
     * 
     * @return The hemoglobin level at registry.
     */
    public double getHgAtRegistry() {
        return hgAtRegistry;
    }

    /**
     * Sets the hemoglobin level at registry.
     * 
     * @param hgAtRegistry The hemoglobin level to set.
     */
    public void setHgAtRegistry(double hgAtRegistry) {
        this.hgAtRegistry = hgAtRegistry;
    }

    /**
     * Gets the hemoglobin level at 36 weeks.
     * 
     * @return The hemoglobin level at 36 weeks.
     */
    public double getHgAt36Wks() {
        return hgAt36Wks;
    }

    /**
     * Sets the hemoglobin level at 36 weeks.
     * 
     * @param hgAt36Wks The hemoglobin level to set.
     */
    public void setHgAt36Wks(double hgAt36Wks) {
        this.hgAt36Wks = hgAt36Wks;
    }

    /**
     * Gets the mother's record.
     * 
     * @return The record.
     */
    public Record getRecord() {
        return record;
    }

    /**
     * Sets the mother's record.
     * 
     * @param record The record to set.
     */
    public void setRecord(Record record) {
        this.record = record;
    }

}