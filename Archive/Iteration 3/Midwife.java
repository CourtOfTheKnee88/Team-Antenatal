/**
 * The Midwife class holds information about a midwife.
 */
public class Midwife {
    // Existing variables
    private String institution;
    private String facilityType;
    private String district;
    private String subDistrict;
    private String region;
    private String eocServices;
    private boolean otrCorner;
    private boolean conductsDelivery;
    private boolean transfusionServices;
    private boolean PMTCT;
    private boolean babyFriendlyServices;

    // Antenatal Variables
    private int numOfRegistrants;
    private int attendances;
    private int numOf4thVisits;
    private int TT2PlusVaccination;
    private int parity;
    private int ageOfMotherAtRegistration;
    private int mothersBelow150cm;
    private int numOfMothers10to14Antenatal;
    private int numOfMothers15to19Antenatal;
    private int numOfMothers20to24Antenatal;
    private int numOfMothers25to29Antenatal;
    private int numOfMothers30to34Antenatal;
    private int numOfMothers35PlusAntenatal;

    // Deliveries Variables
    private int numOfSingleBirthMom;
    private int numOfTwinsMom;
    private int numOfTripletsMom;
    private int numOfOtherNumOfBirthsMom;
    private int numOfSingleBirthBaby;
    private int numOfTwinsBaby;
    private int numOfTripletsBaby;
    private int numOfOtherNumOfBirthsBaby;
    private int totNumMoms;
    private int totNumBaby;
    private int numLiveMaleBirths;
    private int numLiveFemaleBirths;
    private int numStillMaceratedBirths;
    private int numStillFreshBirths;
    private int numPrimparn;
    private int numMultiparn;
    private int totalBelow2_5kgWeight;
    private int totalAbove2_5kgWeight;
    private int numOfDeliveries2PlusIPT;
    private int numOfMaternalDeaths;
    private int numOfAuditedMaternalDeaths;
    private int numOfNeonatalDeaths;
    private int numOfPostneonatalDeaths;
    private int numNormalDelivery;
    private int numCSection;
    private int numVacuumDelivery;
    private int numForcepDelivery;
    private int totalDeliveries;
    private int numOfMothers10to14Delivery;
    private int numOfMothers15to19Delivery;
    private int numOfMothers20to24Delivery;
    private int numOfMothers25to29Delivery;
    private int numOfMothers30to34Delivery;
    private int numOfMothers35PlusDelivery;
    private int numVesicoVaginalFistulaSeen;
    private int numVesicoVaginalFistulaRepaired;
    private int numVesicoVaginalFistulaReferred;
    private int numReceivingOxytocin3rdStageLabor;
    private int numMothersInfantPairsOnlyBreastFeeding;
    private int numMothersBreastFeedingWithin1Hour;
    private int numActiveMotherSupportGroups;
    private int numTrainedInLocationManagement;
    private int numMalariaInPregnancy;
    private int numDropFootCase;
    private int numPuerperalPsychosis;

    // Postnatal Variables
    private int numRegistrants;
    private int numSupervisedDelivery;
    private int numNotSupervised;
    private int numNoANC;
    private int numPostPartumVitAMother;
    private int numBabyWeight7to10Days2_5kgBelow;
    private int numBabyWeight7to10Days2_5kgAbove;
    private int numAntenatalReferrals;
    private int numLabourReferrals;
    private int numPostnatalReferrals;
    private String[][] birthAbnormalities; // 2D array to hold abnormality name and count
    private int numRegistrants10to14Postnatal;
    private int numRegistrants15to19Postnatal;
    private int numRegistrants20to24Postnatal;
    private int numRegistrants25to29Postnatal;
    private int numRegistrants30to34Postnatal;
    private int numRegistrants35AbovePostnatal;

    // New variables for abortion-related data
    private int numElectiveAbortions;
    private int numSpontaneousAbortions;
    private int numInducedAbortions;
    private int numMVAsDone;
    private int numDCDone;
    private int numRegistrants10to14Abortions;
    private int numRegistrants15to19Abortions;
    private int numRegistrants20to24Abortions;
    private int numRegistrants25to29Abortions;
    private int numRegistrants30to34Abortions;
    private int numRegistrants35AboveAbortions;
    private int numBleedingOrHaemorrhage;
    private int numSepsisOrInfectionAbortion;
    private int numPerforationsAbortions;
    private int totNumOfDeathsFromPostAbortionComplications;
    private int numPACFPCounselled;
    private int numPACFPAccepting;

    // New variables for male involvement
    private int numMalesSeenAtANC;
    private int numMalesSeenAtDEL;
    private int numMalesSeenPNC;
    private int numMalesSeenFP;

    /**
     * Constructor for the Midwife class.
     */
    public Midwife(String institution, String facilityType, String district, String subDistrict, String region,
                   String eocServices, boolean otrCorner, boolean conductsDelivery, boolean transfusionServices,
                   boolean PMTCT, boolean babyFriendlyServices, int numOfRegistrants, int attendances,
                   int numOf4thVisits, int TT2PlusVaccination, int parity, int ageOfMotherAtRegistration,
                   int mothersBelow150cm, int numOfSingleBirthMom, int numOfTwinsMom, int numOfTripletsMom,
                   int numOfOtherNumOfBirthsMom, int numOfSingleBirthBaby, int numOfTwinsBaby, int numOfTripletsBaby,
                   int numOfOtherNumOfBirthsBaby, int totNumMoms, int totNumBaby, int numLiveMaleBirths,
                   int numLiveFemaleBirths, int numStillMaceratedBirths, int numStillFreshBirths, int numPrimparn,
                   int numMultiparn, int totalBelow2_5kgWeight, int totalAbove2_5kgWeight, int numOfDeliveries2PlusIPT,
                   int numOfMaternalDeaths, int numOfAuditedMaternalDeaths, int numOfNeonatalDeaths,
                   int numOfPostneonatalDeaths, int numNormalDelivery, int numCSection, int numVacuumDelivery,
                   int numForcepDelivery, int totalDeliveries, int numOfMothers10to14, int numOfMothers15to19,
                   int numOfMothers20to24, int numOfMothers25to29, int numOfMothers30to34, int numOfMothers35Plus,
                   int numVesicoVaginalFistulaSeen, int numVesicoVaginalFistulaRepaired, int numVesicoVaginalFistulaReferred,
                   int numReceivingOxytocin3rdStageLabor, int numMothersInfantPairsOnlyBreastFeeding,
                   int numMothersBreastFeedingWithin1Hour, int numActiveMotherSupportGroups, int numTrainedInLocationManagement,
                   int numMalariaInPregnancy, int numDropFootCase, int numPuerperalPsychosis, int numRegistrants,
                   int numSupervisedDelivery, int numNotSupervised, int numNoANC, int numPostPartumVitAMother,
                   int numBabyWeight7to10Days2_5kgBelow, int numBabyWeight7to10Days2_5kgAbove, int numAntenatalReferrals,
                   int numLabourReferrals, int numPostnatalReferrals, String[][] birthAbnormalities, int numRegistrants10to14,
                   int numRegistrants15to19, int numRegistrants20to24, int numRegistrants25to29, int numRegistrants30to34,
                   int numRegistrants35Above, int numElectiveAbortions, int numSpontaneousAbortions, int numInducedAbortions,
                   int numMVAsDone, int numDCDone, int numRegistrants10to14Abortions, int numRegistrants15to19Abortions,
                   int numRegistrants20to24Abortions, int numRegistrants25to29Abortions, int numRegistrants30to34Abortions,
                   int numRegistrants35AboveAbortions, int numBleedingOrHaemorrhage, int numSepsisOrInfectionAbortion,
                   int numPerforationsAbortions, int totNumOfDeathsFromPostAbortionComplications, int numPACFPCounselled,
                   int numPACFPAccepting, int numMalesSeenAtANC, int numMalesSeenAtDEL, int numMalesSeenPNC,
                   int numMalesSeenFP) {
        this.institution = institution;
        this.facilityType = facilityType;
        this.district = district;
        this.subDistrict = subDistrict;
        this.region = region;
        this.eocServices = eocServices;
        this.otrCorner = otrCorner;
        this.conductsDelivery = conductsDelivery;
        this.transfusionServices = transfusionServices;
        this.PMTCT = PMTCT;
        this.babyFriendlyServices = babyFriendlyServices;
        this.numOfRegistrants = numOfRegistrants;
        this.attendances = attendances;
        this.numOf4thVisits = numOf4thVisits;
        this.TT2PlusVaccination = TT2PlusVaccination;
        this.parity = parity;
        this.ageOfMotherAtRegistration = ageOfMotherAtRegistration;
        this.mothersBelow150cm = mothersBelow150cm;
        this.numOfSingleBirthMom = numOfSingleBirthMom;
        this.numOfTwinsMom = numOfTwinsMom;
        this.numOfTripletsMom = numOfTripletsMom;
        this.numOfOtherNumOfBirthsMom = numOfOtherNumOfBirthsMom;
        this.numOfSingleBirthBaby = numOfSingleBirthBaby;
        this.numOfTwinsBaby = numOfTwinsBaby;
        this.numOfTripletsBaby = numOfTripletsBaby;
        this.numOfOtherNumOfBirthsBaby = numOfOtherNumOfBirthsBaby;
        this.totNumMoms = totNumMoms;
        this.totNumBaby = totNumBaby;
        this.numLiveMaleBirths = numLiveMaleBirths;
        this.numLiveFemaleBirths = numLiveFemaleBirths;
        this.numStillMaceratedBirths = numStillMaceratedBirths;
        this.numStillFreshBirths = numStillFreshBirths;
        this.numPrimparn = numPrimparn;
        this.numMultiparn = numMultiparn;
        this.totalBelow2_5kgWeight = totalBelow2_5kgWeight;
        this.totalAbove2_5kgWeight = totalAbove2_5kgWeight;
        this.numOfDeliveries2PlusIPT = numOfDeliveries2PlusIPT;
        this.numOfMaternalDeaths = numOfMaternalDeaths;
        this.numOfAuditedMaternalDeaths = numOfAuditedMaternalDeaths;
        this.numOfNeonatalDeaths = numOfNeonatalDeaths;
        this.numOfPostneonatalDeaths = numOfPostneonatalDeaths;
        this.numNormalDelivery = numNormalDelivery;
        this.numCSection = numCSection;
        this.numVacuumDelivery = numVacuumDelivery;
        this.numForcepDelivery = numForcepDelivery;
        this.totalDeliveries = totalDeliveries;
        this.numOfMothers10to14Delivery = numOfMothers10to14Delivery;
        this.numOfMothers15to19Delivery = numOfMothers15to19Delivery;
        this.numOfMothers20to24Delivery = numOfMothers20to24Delivery;
        this.numOfMothers25to29Delivery = numOfMothers25to29Delivery;
        this.numOfMothers30to34Delivery = numOfMothers30to34Delivery;
        this.numOfMothers35PlusDelivery = numOfMothers35PlusDelivery;
        this.numVesicoVaginalFistulaSeen = numVesicoVaginalFistulaSeen;
        this.numVesicoVaginalFistulaRepaired = numVesicoVaginalFistulaRepaired;
        this.numVesicoVaginalFistulaReferred = numVesicoVaginalFistulaReferred;
        this.numReceivingOxytocin3rdStageLabor = numReceivingOxytocin3rdStageLabor;
        this.numMothersInfantPairsOnlyBreastFeeding = numMothersInfantPairsOnlyBreastFeeding;
        this.numMothersBreastFeedingWithin1Hour = numMothersBreastFeedingWithin1Hour;
        this.numActiveMotherSupportGroups = numActiveMotherSupportGroups;
        this.numTrainedInLocationManagement = numTrainedInLocationManagement;
        this.numMalariaInPregnancy = numMalariaInPregnancy;
        this.numDropFootCase = numDropFootCase;
        this.numPuerperalPsychosis = numPuerperalPsychosis;
        this.numRegistrants = numRegistrants;
        this.numSupervisedDelivery = numSupervisedDelivery;
        this.numNotSupervised = numNotSupervised;
        this.numNoANC = numNoANC;
        this.numPostPartumVitAMother = numPostPartumVitAMother;
        this.numBabyWeight7to10Days2_5kgBelow = numBabyWeight7to10Days2_5kgBelow;
        this.numBabyWeight7to10Days2_5kgAbove = numBabyWeight7to10Days2_5kgAbove;
        this.numAntenatalReferrals = numAntenatalReferrals;
        this.numLabourReferrals = numLabourReferrals;
        this.numPostnatalReferrals = numPostnatalReferrals;
        this.birthAbnormalities = birthAbnormalities;
        this.numRegistrants10to14Postnatal = numRegistrants10to14Postnatal;
        this.numRegistrants15to19Postnatal= numRegistrants15to19Postnatal;
        this.numRegistrants20to24Postnatal = numRegistrants20to24Postnatal;
        this.numRegistrants25to29Postnatal = numRegistrants25to29Postnatal;
        this.numRegistrants30to34Postnatal = numRegistrants30to34Postnatal;
        this.numRegistrants35AbovePostnatal = numRegistrants35AbovePostnatal;
        this.numElectiveAbortions = numElectiveAbortions;
        this.numSpontaneousAbortions = numSpontaneousAbortions;
        this.numInducedAbortions = numInducedAbortions;
        this.numMVAsDone = numMVAsDone;
        this.numDCDone = numDCDone;
        this.numRegistrants10to14Abortions = numRegistrants10to14Abortions;
        this.numRegistrants15to19Abortions = numRegistrants15to19Abortions;
        this.numRegistrants20to24Abortions = numRegistrants20to24Abortions;
        this.numRegistrants25to29Abortions = numRegistrants25to29Abortions;
        this.numRegistrants30to34Abortions = numRegistrants30to34Abortions;
        this.numRegistrants35AboveAbortions = numRegistrants35AboveAbortions;
        this.numBleedingOrHaemorrhage = numBleedingOrHaemorrhage;
        this.numSepsisOrInfectionAbortion = numSepsisOrInfectionAbortion;
        this.numPerforationsAbortions = numPerforationsAbortions;
        this.totNumOfDeathsFromPostAbortionComplications = totNumOfDeathsFromPostAbortionComplications;
        this.numPACFPCounselled = numPACFPCounselled;
        this.numPACFPAccepting = numPACFPAccepting;
        this.numMalesSeenAtANC = numMalesSeenAtANC;
        this.numMalesSeenAtDEL = numMalesSeenAtDEL;
        this.numMalesSeenPNC = numMalesSeenPNC;
        this.numMalesSeenFP = numMalesSeenFP;
    }

    // Getters and Setters for new variables

    public int getNumElectiveAbortions() {
        return numElectiveAbortions;
    }

    public void setNumElectiveAbortions(int numElectiveAbortions) {
        this.numElectiveAbortions = numElectiveAbortions;
    }

    public int getNumSpontaneousAbortions() {
        return numSpontaneousAbortions;
    }

    public void setNumSpontaneousAbortions(int numSpontaneousAbortions) {
        this.numSpontaneousAbortions = numSpontaneousAbortions;
    }

    public int getNumInducedAbortions() {
        return numInducedAbortions;
    }

    public void setNumInducedAbortions(int numInducedAbortions) {
        this.numInducedAbortions = numInducedAbortions;
    }

    public int getNumMVAsDone() {
        return numMVAsDone;
    }

    public void setNumMVAsDone(int numMVAsDone) {
        this.numMVAsDone = numMVAsDone;
    }

    public int getNumDCDone() {
        return numDCDone;
    }

    public void setNumDCDone(int numDCDone) {
        this.numDCDone = numDCDone;
    }

    public int getNumRegistrants10to14Abortions() {
        return numRegistrants10to14Abortions;
    }

    public void setNumRegistrants10to14Abortions(int numRegistrants10to14Abortions) {
        this.numRegistrants10to14Abortions = numRegistrants10to14Abortions;
    }

    public int getNumRegistrants15to19Abortions() {
        return numRegistrants15to19Abortions;
    }

    public void setNumRegistrants15to19Abortions(int numRegistrants15to19Abortions) {
        this.numRegistrants15to19Abortions = numRegistrants15to19Abortions;
    }

    public int getNumRegistrants20to24Abortions() {
        return numRegistrants20to24Abortions;
    }

    public void setNumRegistrants20to24Abortions(int numRegistrants20to24Abortions) {
        this.numRegistrants20to24Abortions = numRegistrants20to24Abortions;
    }

    public int getNumRegistrants25to29Abortions() {
        return numRegistrants25to29Abortions;
    }

    public void setNumRegistrants25to29Abortions(int numRegistrants25to29Abortions) {
        this.numRegistrants25to29Abortions = numRegistrants25to29Abortions;
    }

    public int getNumRegistrants30to34Abortions() {
        return numRegistrants30to34Abortions;
    }

    public void setNumRegistrants30to34Abortions(int numRegistrants30to34Abortions) {
        this.numRegistrants30to34Abortions = numRegistrants30to34Abortions;
    }

    public int getNumRegistrants35AboveAbortions() {
        return numRegistrants35AboveAbortions;
    }

    public void setNumRegistrants35AboveAbortions(int numRegistrants35AboveAbortions) {
        this.numRegistrants35AboveAbortions = numRegistrants35AboveAbortions;
    }

    public int getNumBleedingOrHaemorrhage() {
        return numBleedingOrHaemorrhage;
    }

    public void setNumBleedingOrHaemorrhage(int numBleedingOrHaemorrhage) {
        this.numBleedingOrHaemorrhage = numBleedingOrHaemorrhage;
    }

    public int getNumSepsisOrInfectionAbortion() {
        return numSepsisOrInfectionAbortion;
    }

    public void setNumSepsisOrInfectionAbortion(int numSepsisOrInfectionAbortion) {
        this.numSepsisOrInfectionAbortion = numSepsisOrInfectionAbortion;
    }

    public int getNumPerforationsAbortions() {
        return numPerforationsAbortions;
    }

    public void setNumPerforationsAbortions(int numPerforationsAbortions) {
        this.numPerforationsAbortions = numPerforationsAbortions;
    }

    public int getTotNumOfDeathsFromPostAbortionComplications() {
        return totNumOfDeathsFromPostAbortionComplications;
    }

    public void setTotNumOfDeathsFromPostAbortionComplications(int totNumOfDeathsFromPostAbortionComplications) {
        this.totNumOfDeathsFromPostAbortionComplications = totNumOfDeathsFromPostAbortionComplications;
    }

    public int getNumPACFPCounselled() {
        return numPACFPCounselled;
    }

    public void setNumPACFPCounselled(int numPACFPCounselled) {
        this.numPACFPCounselled = numPACFPCounselled;
    }

    public int getNumPACFPAccepting() {
        return numPACFPAccepting;
    }

    public void setNumPACFPAccepting(int numPACFPAccepting) {
        this.numPACFPAccepting = numPACFPAccepting;
    }

    public int getNumMalesSeenAtANC() {
        return numMalesSeenAtANC;
    }

    public void setNumMalesSeenAtANC(int numMalesSeenAtANC) {
        this.numMalesSeenAtANC = numMalesSeenAtANC;
    }

    public int getNumMalesSeenAtDEL() {
        return numMalesSeenAtDEL;
    }

    public void setNumMalesSeenAtDEL(int numMalesSeenAtDEL) {
        this.numMalesSeenAtDEL = numMalesSeenAtDEL;
    }

    public int getNumMalesSeenPNC() {
        return numMalesSeenPNC;
    }

    public void setNumMalesSeenPNC(int numMalesSeenPNC) {
        this.numMalesSeenPNC = numMalesSeenPNC;
    }

    public int getNumMalesSeenFP() {
        return numMalesSeenFP;
    }

    public void setNumMalesSeenFP(int numMalesSeenFP) {
        this.numMalesSeenFP = numMalesSeenFP;
    }
}
