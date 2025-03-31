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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getInstitution() {
        return institution;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDistrict() {
        return district;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setEocServices(String eocServices) {
        this.eocServices = eocServices;
    }

    public String getEocServices() {
        return eocServices;
    }

    public void setOtrCorner(boolean otrCorner) {
        this.otrCorner = otrCorner;
    }

    public boolean isOtrCorner() {
        return otrCorner;
    }

    public void setConductsDelivery(boolean conductsDelivery) {
        this.conductsDelivery = conductsDelivery;
    }

    public boolean isConductsDelivery() {
        return conductsDelivery;
    }

    public void setTransfusionServices(boolean transfusionServices) {
        this.transfusionServices = transfusionServices;
    }

    public boolean isTransfusionServices() {
        return transfusionServices;
    }
    
}
