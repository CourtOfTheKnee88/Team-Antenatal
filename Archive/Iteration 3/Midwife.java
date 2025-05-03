import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

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
    public Midwife(
    String institution,
    String facilityType,
    String district,
    String subDistrict,
    String region,
    String eocServices,
    boolean otrCorner,
    boolean conductsDelivery,
    boolean transfusionServices,
    int pMTCT2,
    int babyFriendlyServices2,

    // Antenatal
    int numOfRegistrants,
    int attendances,
    int numOf4thVisits,
    int TT2PlusVaccination,
    int parity,
    int ageOfMotherAtRegistration,
    int mothersBelow150cm,
    int numOfMothers10to14Antenatal,
    int numOfMothers15to19Antenatal,
    int numOfMothers20to24Antenatal,
    int numOfMothers25to29Antenatal,
    int numOfMothers30to34Antenatal,
    int numOfMothers35PlusAntenatal,

    // Deliveries
    int numOfSingleBirthMom,
    int numOfTwinsMom,
    int numOfTripletsMom,
    int numOfOtherNumOfBirthsMom,
    int numOfSingleBirthBaby,
    int numOfTwinsBaby,
    int numOfTripletsBaby,
    int numOfOtherNumOfBirthsBaby,
    int totNumMoms,
    int totNumBaby,
    int numLiveMaleBirths,
    int numLiveFemaleBirths,
    int numStillMaceratedBirths,
    int numStillFreshBirths,
    int numPrimparn,
    int numMultiparn,
    int totalBelow2_5kgWeight,
    int totalAbove2_5kgWeight,
    int numOfDeliveries2PlusIPT,
    int numOfMaternalDeaths,
    int numOfAuditedMaternalDeaths,
    int numOfNeonatalDeaths,
    int numOfPostneonatalDeaths,
    int numNormalDelivery,
    int numCSection,
    int numVacuumDelivery,
    int numForcepDelivery,
    int totalDeliveries,
    int numOfMothers10to14Delivery,
    int numOfMothers15to19Delivery,
    int numOfMothers20to24Delivery,
    int numOfMothers25to29Delivery,
    int numOfMothers30to34Delivery,
    int numOfMothers35PlusDelivery,
    int numVesicoVaginalFistulaSeen,
    int numVesicoVaginalFistulaRepaired,
    int numVesicoVaginalFistulaReferred,
    int numReceivingOxytocin3rdStageLabor,
    int numMothersInfantPairsOnlyBreastFeeding,
    int numMothersBreastFeedingWithin1Hour,
    int numActiveMotherSupportGroups,
    int numTrainedInLocationManagement,
    int numMalariaInPregnancy,
    int numDropFootCase,
    int numPuerperalPsychosis,

    // Postnatal
    int numRegistrants,
    int numSupervisedDelivery,
    int numNotSupervised,
    int numNoANC,
    int numPostPartumVitAMother,
    int numBabyWeight7to10Days2_5kgBelow,
    int numBabyWeight7to10Days2_5kgAbove,
    int numAntenatalReferrals,
    int numLabourReferrals,
    int numPostnatalReferrals,
    String[][] birthAbnormalities,
    int numRegistrants10to14Postnatal,
    int numRegistrants15to19Postnatal,
    int numRegistrants20to24Postnatal,
    int numRegistrants25to29Postnatal,
    int numRegistrants30to34Postnatal,
    int numRegistrants35AbovePostnatal,

    // Abortions
    int numElectiveAbortions,
    int numSpontaneousAbortions,
    int numInducedAbortions,
    int numMVAsDone,
    int numDCDone,
    int numRegistrants10to14Abortions,
    int numRegistrants15to19Abortions,
    int numRegistrants20to24Abortions,
    int numRegistrants25to29Abortions,
    int numRegistrants30to34Abortions,
    int numRegistrants35AboveAbortions,
    int numBleedingOrHaemorrhage,
    int numSepsisOrInfectionAbortion,
    int numPerforationsAbortions,
    int totNumOfDeathsFromPostAbortionComplications,
    int numPACFPCounselled,
    int numPACFPAccepting,

    // Male involvement
    int numMalesSeenAtANC,
    int numMalesSeenAtDEL,
    int numMalesSeenPNC,
    int numMalesSeenFP
) {
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
    this.numOfMothers10to14Antenatal = numOfMothers10to14Antenatal;
    this.numOfMothers15to19Antenatal = numOfMothers15to19Antenatal;
    this.numOfMothers20to24Antenatal = numOfMothers20to24Antenatal;
    this.numOfMothers25to29Antenatal = numOfMothers25to29Antenatal;
    this.numOfMothers30to34Antenatal = numOfMothers30to34Antenatal;
    this.numOfMothers35PlusAntenatal = numOfMothers35PlusAntenatal;

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
    this.numRegistrants15to19Postnatal = numRegistrants15to19Postnatal;
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



    public Midwife(String pdfFilePath) throws IOException {
        File file = new File(pdfFilePath);
        if (!file.exists()) {
            throw new IOException("File not found: " + pdfFilePath);
        }
        try (PDDocument document = PDDocument.load(file)) {
            if (!document.isEncrypted()) {
                PDFTextStripper pdfStripper = new PDFTextStripper();
                pdfStripper.setStartPage(1); // Read only the first page
                pdfStripper.setEndPage(1);

                String text = pdfStripper.getText(document);

                // Process the extracted text to populate variables
                String[] lines = text.split("\n");

                for (String line : lines) {
                    if (line.startsWith("Institution:")) {
                        institution = line.replace("Institution:", "").trim();
                    } else if (line.startsWith("Facility Type:")) {
                        facilityType = line.replace("Facility Type:", "").trim();
                    } else if (line.startsWith("District:")) {
                        district = line.replace("District:", "").trim();
                    } else if (line.startsWith("Sub District:")) {
                        subDistrict = line.replace("Sub District:", "").trim();
                    } else if (line.startsWith("Region:")) {
                        region = line.replace("Region:", "").trim();
                    } else if (line.startsWith("EOC Services:")) {
                        eocServices = line.replace("EOC Services:", "").trim();
                    } else if (line.startsWith("OTR Corner:")) {
                        otrCorner = Boolean.parseBoolean(line.replace("OTR Corner:", "").trim());
                    } else if (line.startsWith("Conducts Delivery:")) {
                        conductsDelivery = Boolean.parseBoolean(line.replace("Conducts Delivery:", "").trim());
                    } else if (line.startsWith("Transfusion Services:")) {
                        transfusionServices = Boolean.parseBoolean(line.replace("Transfusion Services:", "").trim());
                    } else if (line.startsWith("Elective Abortions:")) {
                        numElectiveAbortions = Integer.parseInt(line.replace("Elective Abortions:", "").trim());
                    } else if (line.startsWith("Spontaneous Abortions:")) {
                        numSpontaneousAbortions = Integer.parseInt(line.replace("Spontaneous Abortions:", "").trim());
                    } else if (line.startsWith("Induced Abortions:")) {
                        numInducedAbortions = Integer.parseInt(line.replace("Induced Abortions:", "").trim());
                    } else if (line.startsWith("MVAs Done:")) {
                        numMVAsDone = Integer.parseInt(line.replace("MVAs Done:", "").trim());
                    } else if (line.startsWith("DC Done:")) {
                        numDCDone = Integer.parseInt(line.replace("DC Done:", "").trim());
                    } else if (line.startsWith("Males Seen at ANC:")) {
                        numMalesSeenAtANC = Integer.parseInt(line.replace("Males Seen at ANC:", "").trim());
                    } else if (line.startsWith("Males Seen at Delivery:")) {
                        numMalesSeenAtDEL = Integer.parseInt(line.replace("Males Seen at Delivery:", "").trim());
                    } else if (line.startsWith("Males Seen at PNC:")) {
                        numMalesSeenPNC = Integer.parseInt(line.replace("Males Seen at PNC:", "").trim());
                    } else if (line.startsWith("Males Seen at FP:")) {
                        numMalesSeenFP = Integer.parseInt(line.replace("Males Seen at FP:", "").trim());
                    } else if (line.startsWith("PMTCT")) {
                        PMTCT = Boolean.parseBoolean(line.replace("PMTCT:", "").trim());   
                    }
                }
            } else {
                throw new IOException("The PDF is encrypted and cannot be read.");
            }
        } catch (Exception e) {
            throw new IOException("Error processing the PDF file: " + e.getMessage(), e);
        }
    }

    public int getNumSupervisedDelivery() {
        return numSupervisedDelivery;
    }

    public void setNumSupervisedDelivery(int numSupervisedDelivery) {
        this.numSupervisedDelivery = numSupervisedDelivery;
    }

    public int getNumNotSupervised() {
        return numNotSupervised;
    }

    public void setNumNotSupervised(int numNotSupervised) {
        this.numNotSupervised = numNotSupervised;
    }

    public int getNumNoANC() {
        return numNoANC;
    }

    public void setNumNoANC(int numNoANC) {
        this.numNoANC = numNoANC;
    }

    public int getNumPostPartumVitAMother() {
        return numPostPartumVitAMother;
    }

    public void setNumPostPartumVitAMother(int numPostPartumVitAMother) {
        this.numPostPartumVitAMother = numPostPartumVitAMother;
    }

    public int getNumBabyWeight7to10Days2_5kgBelow() {
        return numBabyWeight7to10Days2_5kgBelow;
    }

    public void setNumBabyWeight7to10Days2_5kgBelow(int numBabyWeight7to10Days2_5kgBelow) {
        this.numBabyWeight7to10Days2_5kgBelow = numBabyWeight7to10Days2_5kgBelow;
    }

    public int getNumBabyWeight7to10Days2_5kgAbove() {
        return numBabyWeight7to10Days2_5kgAbove;
    }

    public void setNumBabyWeight7to10Days2_5kgAbove(int numBabyWeight7to10Days2_5kgAbove) {
        this.numBabyWeight7to10Days2_5kgAbove = numBabyWeight7to10Days2_5kgAbove;
    }

    public int getNumAntenatalReferrals() {
        return numAntenatalReferrals;
    }

    public void setNumAntenatalReferrals(int numAntenatalReferrals) {
        this.numAntenatalReferrals = numAntenatalReferrals;
    }

    public int getNumLabourReferrals() {
        return numLabourReferrals;
    }

    public void setNumLabourReferrals(int numLabourReferrals) {
        this.numLabourReferrals = numLabourReferrals;
    }

    public int getNumPostnatalReferrals() {
        return numPostnatalReferrals;
    }

    public void setNumPostnatalReferrals(int numPostnatalReferrals) {
        this.numPostnatalReferrals = numPostnatalReferrals;
    }

    public String[][] getBirthAbnormalities() {
        return birthAbnormalities;
    }

    public void setBirthAbnormalities(String[][] birthAbnormalities) {
        this.birthAbnormalities = birthAbnormalities;
    }

    public int getNumVesicoVaginalFistulaSeen() {
        return numVesicoVaginalFistulaSeen;
    }

    public void setNumVesicoVaginalFistulaSeen(int numVesicoVaginalFistulaSeen) {
        this.numVesicoVaginalFistulaSeen = numVesicoVaginalFistulaSeen;
    }

    public int getNumVesicoVaginalFistulaRepaired() {
        return numVesicoVaginalFistulaRepaired;
    }

    public void setNumVesicoVaginalFistulaRepaired(int numVesicoVaginalFistulaRepaired) {
        this.numVesicoVaginalFistulaRepaired = numVesicoVaginalFistulaRepaired;
    }

    public int getNumVesicoVaginalFistulaReferred() {
        return numVesicoVaginalFistulaReferred;
    }

    public void setNumVesicoVaginalFistulaReferred(int numVesicoVaginalFistulaReferred) {
        this.numVesicoVaginalFistulaReferred = numVesicoVaginalFistulaReferred;
    }

    public int getNumReceivingOxytocin3rdStageLabor() {
        return numReceivingOxytocin3rdStageLabor;
    }

    public void setNumReceivingOxytocin3rdStageLabor(int numReceivingOxytocin3rdStageLabor) {
        this.numReceivingOxytocin3rdStageLabor = numReceivingOxytocin3rdStageLabor;
    }

    public int getNumMothersInfantPairsOnlyBreastFeeding() {
        return numMothersInfantPairsOnlyBreastFeeding;
    }

    public void setNumMothersInfantPairsOnlyBreastFeeding(int numMothersInfantPairsOnlyBreastFeeding) {
        this.numMothersInfantPairsOnlyBreastFeeding = numMothersInfantPairsOnlyBreastFeeding;
    }

    public int getNumMothersBreastFeedingWithin1Hour() {
        return numMothersBreastFeedingWithin1Hour;
    }

    public void setNumMothersBreastFeedingWithin1Hour(int numMothersBreastFeedingWithin1Hour) {
        this.numMothersBreastFeedingWithin1Hour = numMothersBreastFeedingWithin1Hour;
    }

    public int getNumActiveMotherSupportGroups() {
        return numActiveMotherSupportGroups;
    }

    public void setNumActiveMotherSupportGroups(int numActiveMotherSupportGroups) {
        this.numActiveMotherSupportGroups = numActiveMotherSupportGroups;
    }

    public int getNumTrainedInLocationManagement() {
        return numTrainedInLocationManagement;
    }

    public void setNumTrainedInLocationManagement(int numTrainedInLocationManagement) {
        this.numTrainedInLocationManagement = numTrainedInLocationManagement;
    }

    public int getNumMalariaInPregnancy() {
        return numMalariaInPregnancy;
    }

    public void setNumMalariaInPregnancy(int numMalariaInPregnancy) {
        this.numMalariaInPregnancy = numMalariaInPregnancy;
    }

    public int getNumDropFootCase() {
        return numDropFootCase;
    }

    public void setNumDropFootCase(int numDropFootCase) {
        this.numDropFootCase = numDropFootCase;
    }

    public int getNumPuerperalPsychosis() {
        return numPuerperalPsychosis;
    }

    public void setNumPuerperalPsychosis(int numPuerperalPsychosis) {
        this.numPuerperalPsychosis = numPuerperalPsychosis;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getEocServices() {
        return eocServices;
    }

    public void setEocServices(String eocServices) {
        this.eocServices = eocServices;
    }

    public boolean isOtrCorner() {
        return otrCorner;
    }

    public void setOtrCorner(boolean otrCorner) {
        this.otrCorner = otrCorner;
    }

    public boolean isConductsDelivery() {
        return conductsDelivery;
    }

    public void setConductsDelivery(boolean conductsDelivery) {
        this.conductsDelivery = conductsDelivery;
    }

    public boolean isTransfusionServices() {
        return transfusionServices;
    }

    public void setTransfusionServices(boolean transfusionServices) {
        this.transfusionServices = transfusionServices;
    }

    public boolean isPMTCT() {
        return PMTCT;
    }

    public void setPMTCT(boolean PMTCT) {
        this.PMTCT = PMTCT;
    }

    public int getNumVacuumDelivery() {
        return numVacuumDelivery;
    }

    public void setNumVacuumDelivery(int numVacuumDelivery) {
        this.numVacuumDelivery = numVacuumDelivery;
    }

    public int getNumForcepDelivery() {
        return numForcepDelivery;
    }

    public void setNumForcepDelivery(int numForcepDelivery) {
        this.numForcepDelivery = numForcepDelivery;
    }

    public int getTotalDeliveries() {
        return totalDeliveries;
    }

    public void setTotalDeliveries(int totalDeliveries) {
        this.totalDeliveries = totalDeliveries;
    }

    public boolean isBabyFriendlyServices() {
        return babyFriendlyServices;
    }

    public void setBabyFriendlyServices(boolean babyFriendlyServices) {
        this.babyFriendlyServices = babyFriendlyServices;
    }

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

    public int getNumOfSingleBirthMom() {
        return numOfSingleBirthMom;
    }

    public void setNumOfSingleBirthMom(int numOfSingleBirthMom) {
        this.numOfSingleBirthMom = numOfSingleBirthMom;
    }

    public int getNumOfTwinsMom() {
        return numOfTwinsMom;
    }

    public void setNumOfTwinsMom(int numOfTwinsMom) {
        this.numOfTwinsMom = numOfTwinsMom;
    }

    public int getNumOfTripletsMom() {
        return numOfTripletsMom;
    }

    public void setNumOfTripletsMom(int numOfTripletsMom) {
        this.numOfTripletsMom = numOfTripletsMom;
    }

    public int getNumOfOtherNumOfBirthsMom() {
        return numOfOtherNumOfBirthsMom;
    }

    public void setNumOfOtherNumOfBirthsMom(int numOfOtherNumOfBirthsMom) {
        this.numOfOtherNumOfBirthsMom = numOfOtherNumOfBirthsMom;
    }

    public int getNumOfSingleBirthBaby() {
        return numOfSingleBirthBaby;
    }

    public void setNumOfSingleBirthBaby(int numOfSingleBirthBaby) {
        this.numOfSingleBirthBaby = numOfSingleBirthBaby;
    }

    public int getNumOfTwinsBaby() {
        return numOfTwinsBaby;
    }

    public void setNumOfTwinsBaby(int numOfTwinsBaby) {
        this.numOfTwinsBaby = numOfTwinsBaby;
    }

    public int getNumOfTripletsBaby() {
        return numOfTripletsBaby;
    }

    public void setNumOfTripletsBaby(int numOfTripletsBaby) {
        this.numOfTripletsBaby = numOfTripletsBaby;
    }

    public int getNumOfOtherNumOfBirthsBaby() {
        return numOfOtherNumOfBirthsBaby;
    }

    public void setNumOfOtherNumOfBirthsBaby(int numOfOtherNumOfBirthsBaby) {
        this.numOfOtherNumOfBirthsBaby = numOfOtherNumOfBirthsBaby;
    }

    public int getTotNumMoms() {
        return totNumMoms;
    }

    public void setTotNumMoms(int totNumMoms) {
        this.totNumMoms = totNumMoms;
    }

    public int getTotNumBaby() {
        return totNumBaby;
    }

    public void setTotNumBaby(int totNumBaby) {
        this.totNumBaby = totNumBaby;
    }

    public int getNumLiveMaleBirths() {
        return numLiveMaleBirths;
    }

    public void setNumLiveMaleBirths(int numLiveMaleBirths) {
        this.numLiveMaleBirths = numLiveMaleBirths;
    }

    public int getNumLiveFemaleBirths() {
        return numLiveFemaleBirths;
    }

    public void setNumLiveFemaleBirths(int numLiveFemaleBirths) {
        this.numLiveFemaleBirths = numLiveFemaleBirths;
    }

    public int getNumStillMaceratedBirths() {
        return numStillMaceratedBirths;
    }

    public void setNumStillMaceratedBirths(int numStillMaceratedBirths) {
        this.numStillMaceratedBirths = numStillMaceratedBirths;
    }

    public int getNumStillFreshBirths() {
        return numStillFreshBirths;
    }

    public void setNumStillFreshBirths(int numStillFreshBirths) {
        this.numStillFreshBirths = numStillFreshBirths;
    }

    public int getNumPrimparn() {
        return numPrimparn;
    }

    public void setNumPrimparn(int numPrimparn) {
        this.numPrimparn = numPrimparn;
    }

    public int getNumMultiparn() {
        return numMultiparn;
    }

    public void setNumMultiparn(int numMultiparn) {
        this.numMultiparn = numMultiparn;
    }

    public int getTotalBelow2_5kgWeight() {
        return totalBelow2_5kgWeight;
    }

    public void setTotalBelow2_5kgWeight(int totalBelow2_5kgWeight) {
        this.totalBelow2_5kgWeight = totalBelow2_5kgWeight;
    }

    public int getTotalAbove2_5kgWeight() {
        return totalAbove2_5kgWeight;
    }

    public void setTotalAbove2_5kgWeight(int totalAbove2_5kgWeight) {
        this.totalAbove2_5kgWeight = totalAbove2_5kgWeight;
    }

    public int getNumOfDeliveries2PlusIPT() {
        return numOfDeliveries2PlusIPT;
    }

    public void setNumOfDeliveries2PlusIPT(int numOfDeliveries2PlusIPT) {
        this.numOfDeliveries2PlusIPT = numOfDeliveries2PlusIPT;
    }

    public int getNumOfMaternalDeaths() {
        return numOfMaternalDeaths;
    }

    public void setNumOfMaternalDeaths(int numOfMaternalDeaths) {
        this.numOfMaternalDeaths = numOfMaternalDeaths;
    }

    public int getNumOfAuditedMaternalDeaths() {
        return numOfAuditedMaternalDeaths;
    }

    public void setNumOfAuditedMaternalDeaths(int numOfAuditedMaternalDeaths) {
        this.numOfAuditedMaternalDeaths = numOfAuditedMaternalDeaths;
    }

    public int getNumOfNeonatalDeaths() {
        return numOfNeonatalDeaths;
    }

    public void setNumOfNeonatalDeaths(int numOfNeonatalDeaths) {
        this.numOfNeonatalDeaths = numOfNeonatalDeaths;
    }

    public int getNumOfPostneonatalDeaths() {
        return numOfPostneonatalDeaths;
    }

    public void setNumOfPostneonatalDeaths(int numOfPostneonatalDeaths) {
        this.numOfPostneonatalDeaths = numOfPostneonatalDeaths;
    }

    public int getNumNormalDelivery() {
        return numNormalDelivery;
    }

    public void setNumNormalDelivery(int numNormalDelivery) {
        this.numNormalDelivery = numNormalDelivery;
    }

    public int getNumCSection() {
        return numCSection;
    }

    public void setNumCSection(int numCSection) {
        this.numCSection = numCSection;
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

    public int getNumOfRegistrants() {
        return numOfRegistrants;
    }

    public void setNumOfRegistrants(int numOfRegistrants) {
        this.numOfRegistrants = numOfRegistrants;
    }

    public int getAttendances() {
        return attendances;
    }

    public void setAttendances(int attendances) {
        this.attendances = attendances;
    }

    public int getNumOf4thVisits() {
        return numOf4thVisits;
    }

    public void setNumOf4thVisits(int numOf4thVisits) {
        this.numOf4thVisits = numOf4thVisits;
    }

    public int getTT2PlusVaccination() {
        return TT2PlusVaccination;
    }

    public void setTT2PlusVaccination(int TT2PlusVaccination) {
        this.TT2PlusVaccination = TT2PlusVaccination;
    }

    public int getParity() {
        return parity;
    }

    public void setParity(int parity) {
        this.parity = parity;
    }

    public int getAgeOfMotherAtRegistration() {
        return ageOfMotherAtRegistration;
    }

    public void setAgeOfMotherAtRegistration(int ageOfMotherAtRegistration) {
        this.ageOfMotherAtRegistration = ageOfMotherAtRegistration;
    }

    public int getMothersBelow150cm() {
        return mothersBelow150cm;
    }

    public void setMothersBelow150cm(int mothersBelow150cm) {
        this.mothersBelow150cm = mothersBelow150cm;
    }

    public int getNumOfMothers10to14Antenatal() {
        return numOfMothers10to14Antenatal;
    }

    public void setNumOfMothers10to14Antenatal(int numOfMothers10to14Antenatal) {
        this.numOfMothers10to14Antenatal = numOfMothers10to14Antenatal;
    }

    public int getNumOfMothers15to19Antenatal() {
        return numOfMothers15to19Antenatal;
    }

    public void setNumOfMothers15to19Antenatal(int numOfMothers15to19Antenatal) {
        this.numOfMothers15to19Antenatal = numOfMothers15to19Antenatal;
    }

    public int getNumOfMothers20to24Antenatal() {
        return numOfMothers20to24Antenatal;
    }

    public void setNumOfMothers20to24Antenatal(int numOfMothers20to24Antenatal) {
        this.numOfMothers20to24Antenatal = numOfMothers20to24Antenatal;
    }

    public int getNumOfMothers25to29Antenatal() {
        return numOfMothers25to29Antenatal;
    }

    public void setNumOfMothers25to29Antenatal(int numOfMothers25to29Antenatal) {
        this.numOfMothers25to29Antenatal = numOfMothers25to29Antenatal;
    }

    public int getNumOfMothers30to34Antenatal() {
        return numOfMothers30to34Antenatal;
    }

    public void setNumOfMothers30to34Antenatal(int numOfMothers30to34Antenatal) {
        this.numOfMothers30to34Antenatal = numOfMothers30to34Antenatal;
    }

    public int getNumOfMothers35PlusAntenatal() {
        return numOfMothers35PlusAntenatal;
    }

    public void setNumOfMothers35PlusAntenatal(int numOfMothers35PlusAntenatal) {
        this.numOfMothers35PlusAntenatal = numOfMothers35PlusAntenatal;
    }

    // Getters and Setters for numOfMothers____Delivery variables

    public int getNumOfMothers10to14Delivery() {
        return numOfMothers10to14Delivery;
    }

    public void setNumOfMothers10to14Delivery(int numOfMothers10to14Delivery) {
        this.numOfMothers10to14Delivery = numOfMothers10to14Delivery;
    }

    public int getNumOfMothers15to19Delivery() {
        return numOfMothers15to19Delivery;
    }

    public void setNumOfMothers15to19Delivery(int numOfMothers15to19Delivery) {
        this.numOfMothers15to19Delivery = numOfMothers15to19Delivery;
    }

    public int getNumOfMothers20to24Delivery() {
        return numOfMothers20to24Delivery;
    }

    public void setNumOfMothers20to24Delivery(int numOfMothers20to24Delivery) {
        this.numOfMothers20to24Delivery = numOfMothers20to24Delivery;
    }

    public int getNumOfMothers25to29Delivery() {
        return numOfMothers25to29Delivery;
    }

    public void setNumOfMothers25to29Delivery(int numOfMothers25to29Delivery) {
        this.numOfMothers25to29Delivery = numOfMothers25to29Delivery;
    }

    public int getNumOfMothers30to34Delivery() {
        return numOfMothers30to34Delivery;
    }

    public void setNumOfMothers30to34Delivery(int numOfMothers30to34Delivery) {
        this.numOfMothers30to34Delivery = numOfMothers30to34Delivery;
    }

    public int getNumOfMothers35PlusDelivery() {
        return numOfMothers35PlusDelivery;
    }

    public void setNumOfMothers35PlusDelivery(int numOfMothers35PlusDelivery) {
        this.numOfMothers35PlusDelivery = numOfMothers35PlusDelivery;
    }

    // Getters and Setters for numRegistrants variables

    public int getNumRegistrants() {
        return numRegistrants;
    }

    public void setNumRegistrants(int numRegistrants) {
        this.numRegistrants = numRegistrants;
    }

    public int getNumRegistrants10to14Postnatal() {
        return numRegistrants10to14Postnatal;
    }

    public void setNumRegistrants10to14Postnatal(int numRegistrants10to14Postnatal) {
        this.numRegistrants10to14Postnatal = numRegistrants10to14Postnatal;
    }

    public int getNumRegistrants15to19Postnatal() {
        return numRegistrants15to19Postnatal;
    }

    public void setNumRegistrants15to19Postnatal(int numRegistrants15to19Postnatal) {
        this.numRegistrants15to19Postnatal = numRegistrants15to19Postnatal;
    }

    public int getNumRegistrants20to24Postnatal() {
        return numRegistrants20to24Postnatal;
    }

    public void setNumRegistrants20to24Postnatal(int numRegistrants20to24Postnatal) {
        this.numRegistrants20to24Postnatal = numRegistrants20to24Postnatal;
    }

    public int getNumRegistrants25to29Postnatal() {
        return numRegistrants25to29Postnatal;
    }

    public void setNumRegistrants25to29Postnatal(int numRegistrants25to29Postnatal) {
        this.numRegistrants25to29Postnatal = numRegistrants25to29Postnatal;
    }

    public int getNumRegistrants30to34Postnatal() {
        return numRegistrants30to34Postnatal;
    }

    public void setNumRegistrants30to34Postnatal(int numRegistrants30to34Postnatal) {
        this.numRegistrants30to34Postnatal = numRegistrants30to34Postnatal;
    }

    public int getNumRegistrants35AbovePostnatal() {
        return numRegistrants35AbovePostnatal;
    }

    public void setNumRegistrants35AbovePostnatal(int numRegistrants35AbovePostnatal) {
        this.numRegistrants35AbovePostnatal = numRegistrants35AbovePostnatal;
    }

    public boolean isRelevantForMonthYear(int month, int year) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isRelevantForMonthYear'");
    }

    public boolean getBabyFriendlyServices(boolean babyFriendlyServices) {
        return babyFriendlyServices;
    }


    public boolean getPMTCT(boolean PMTCT) {
       return PMTCT;
    }



}
