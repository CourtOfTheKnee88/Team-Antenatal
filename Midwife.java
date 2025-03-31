public class Midwife {
    private String name;
    private String institution;
    private String facilityType;
    private String district;
    private String subDistrict;
    private String region;
    private String eocServices;

    private boolean otrCorner;
    private boolean conductsDelivery;
    private boolean transfusionServices;

    /**
     * Constructor for the Midwife class.
     * 
     * @param name                 The name of the midwife.
     * @param institution          The institution where the midwife works.
     * @param facilityType         The type of healthcare facility.
     * @param district             The district where the midwife operates.
     * @param subDistrict          The sub-district where the midwife operates.
     * @param region               The region where the midwife is located.
     * @param eocServices          Emergency obstetric care services offered.
     * @param otrCorner            Whether the facility has an OTR corner.
     * @param conductsDelivery     Whether the midwife conducts deliveries.
     * @param transfusionServices  Whether transfusion services are available.
     */
    public Midwife(String name, String institution, String facilityType, String district, String subDistrict,
            String region, String eocServices, boolean otrCorner, boolean conductsDelivery,
            boolean transfusionServices) {
        this.name = name;
        this.institution = institution;
        this.facilityType = facilityType;
        this.district = district;
        this.subDistrict = subDistrict;
        this.region = region;
        this.eocServices = eocServices;
        this.otrCorner = otrCorner;
        this.conductsDelivery = conductsDelivery;
        this.transfusionServices = transfusionServices;
    }

    /**
     * Sets the name of the midwife.
     * @param name The name of the midwife.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the midwife.
     * @return The name of the midwife.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the institution where the midwife works.
     * @param institution The institution name.
     */
    public void setInstitution(String institution) {
        this.institution = institution;
    }

    /**
     * Gets the institution of the midwife.
     * @return The institution name.
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * Sets the type of facility.
     * @param facilityType The facility type.
     */
    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    /**
     * Gets the type of facility.
     * @return The facility type.
     */
    public String getFacilityType() {
        return facilityType;
    }

    /**
     * Sets the district of the midwife.
     * @param district The district name.
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * Gets the district of the midwife.
     * @return The district name.
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Sets the sub-district of the midwife.
     * @param subDistrict The sub-district name.
     */
    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    /**
     * Gets the sub-district of the midwife.
     * @return The sub-district name.
     */
    public String getSubDistrict() {
        return subDistrict;
    }

    /**
     * Sets the region where the midwife operates.
     * @param region The region name.
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Gets the region where the midwife operates.
     * @return The region name.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the emergency obstetric care services provided.
     * @param eocServices The EOC services description.
     */
    public void setEocServices(String eocServices) {
        this.eocServices = eocServices;
    }

    /**
     * Gets the emergency obstetric care services provided.
     * @return The EOC services description.
     */
    public String getEocServices() {
        return eocServices;
    }

    /**
     * Sets whether the facility has an OTR corner.
     * @param otrCorner True if the facility has an OTR corner, otherwise false.
     */
    public void setOtrCorner(boolean otrCorner) {
        this.otrCorner = otrCorner;
    }

    /**
     * Checks if the facility has an OTR corner.
     * @return True if the facility has an OTR corner, otherwise false.
     */
    public boolean isOtrCorner() {
        return otrCorner;
    }

    /**
     * Sets whether the midwife conducts deliveries.
     * @param conductsDelivery True if the midwife conducts deliveries, otherwise false.
     */
    public void setConductsDelivery(boolean conductsDelivery) {
        this.conductsDelivery = conductsDelivery;
    }

    /**
     * Checks if the midwife conducts deliveries.
     * @return True if the midwife conducts deliveries, otherwise false.
     */
    public boolean isConductsDelivery() {
        return conductsDelivery;
    }

    /**
     * Sets whether transfusion services are available.
     * @param transfusionServices True if transfusion services are available, otherwise false.
     */
    public void setTransfusionServices(boolean transfusionServices) {
        this.transfusionServices = transfusionServices;
    }

    /**
     * Checks if transfusion services are available.
     * @return True if transfusion services are available, otherwise false.
     */
    public boolean isTransfusionServices() {
        return transfusionServices;
    }
}
