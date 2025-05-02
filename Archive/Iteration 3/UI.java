import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UI {
    private static AntenatalCareRegister register;

    public static void main(String[] args) {
        register = new AntenatalCareRegister();

        // Create the main frame
        JFrame frame = new JFrame("Antenatal Records");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300); // Adjusted size to accommodate new buttons

        // Create a panel
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Create buttons
        JButton addMotherButton = new JButton("Add Mother Visit");
        JButton addMidwifeButton = new JButton("Add Midwife Record");
        JButton printMotherReportButton = new JButton("Print Mother Report");
        JButton printMidwifeReportButton = new JButton("Print Midwife Report");

        // Add action listeners to buttons
        addMotherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showOptionsDialog(frame, "Mother Visit");
            }
        });

        addMidwifeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showOptionsDialog(frame, "Midwife Record");
            }
        });

        printMotherReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printMotherReport(frame);
            }
        });

        printMidwifeReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printMidwifeReport(frame);
            }
        });

        // Add buttons to the panel
        panel.add(addMotherButton);
        panel.add(addMidwifeButton);
        panel.add(printMotherReportButton);
        panel.add(printMidwifeReportButton);

        // Add panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }

    /**
     * Prompts the user to enter a date via a dialog, and parses it.
     * 
     * @param frame the parent JFrame
     * @param message the message to display
     * @return the parsed Date object
     */
    private static Date getDateEntry(JFrame frame, String message) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);

        Date date = null;
        boolean valid = false;

        while (!valid) {
            String input = JOptionPane.showInputDialog(null, message);

            if (input == null) {
                JOptionPane.showMessageDialog(frame, "Please enter a date.");
                continue;
            }

            try {
                date = dateFormat.parse(input);
                valid = true;
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Invalid date format. Please try again.");
                e.printStackTrace();
            }
        }

        return date;
    }

    /**
     * Prompts the user to enter an integer within a range.
     *
     * @param lowerLimit minimum acceptable value (exclusive)
     * @param upperLimit maximum acceptable value (exclusive)
     * @param frame the parent JFrame
     * @param msg the prompt message
     * @return the entered integer
     */    
    private static int getIntEntry(int lowerLimit, int upperLimit, JFrame frame, String msg) {
        while (true) {
            String input = JOptionPane.showInputDialog(frame, msg);

            if (input == null) {
                JOptionPane.showMessageDialog(frame, "Please enter a number.");
                continue;
            }

            try {
                int intInput = Integer.parseInt(input);

                if (intInput <= lowerLimit) {
                    JOptionPane.showMessageDialog(frame, 
                        String.format("Please input a number larger than %d.", lowerLimit)
                    );
                    continue;   
                }
                if (intInput >= upperLimit) {
                    JOptionPane.showMessageDialog(frame, 
                        String.format("Please input a number smaller than %d.", upperLimit)
                    );
                    continue;   
                }

                return intInput;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Please enter a number.");
                e.printStackTrace();
            }
        }
    }

    /**
     * Prompts the user to enter a double within a range.
     *
     * @param lowerLimit minimum acceptable value (exclusive)
     * @param upperLimit maximum acceptable value (exclusive)
     * @param frame the parent JFrame
     * @param msg the prompt message
     * @return the entered double
     */
    private static double getDoubleEntry(double lowerLimit, 
                                      double upperLimit, JFrame frame, String msg) {
        while (true) {
            String input = JOptionPane.showInputDialog(frame, msg);

            if (input == null) {
                JOptionPane.showMessageDialog(frame, "Please enter a number.");
                continue;
            }

            try {
                double doubleInput = Double.parseDouble(input);

                if (doubleInput <= lowerLimit) {
                    JOptionPane.showMessageDialog(frame, 
                        String.format("Please input a number larger than %f.", lowerLimit)
                    );
                    continue;   
                }
                if (doubleInput >= upperLimit) {
                    JOptionPane.showMessageDialog(frame, 
                        String.format("Please input a number smaller than %f.", upperLimit)
                    );
                    continue;   
                }

                return doubleInput;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Please enter a number.");
                e.printStackTrace();
            }
        }
    }

    /**
     * Prompts the user with a yes/no dialog.
     *
     * @param frame the parent JFrame
     * @param message the question message
     * @param title the title of the dialog
     * @return true if user selects "Yes", false otherwise
     */    
    private static boolean getBoolEntry(JFrame frame, String message, String title) {
        int choice = JOptionPane.showOptionDialog(
            frame,  
            message,
            title,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[]{"Yes", "No"},
            "Yes"
        );
        return choice == JOptionPane.YES_OPTION ? true : false;
    }

    /**
     * Prompts the user for mother information and manually creates a new Mother record.
     *
     * @param name the name of the mother
     * @param frame the parent JFrame
     */    
    private static void manualAddMother(String name, JFrame frame) {
        String midwifeName = JOptionPane.showInputDialog(
            "Enter the name of the midwife providing care to the mother:"
        );
        if (!register.hasMidwife(midwifeName)) {
            int choice = JOptionPane.showOptionDialog(
                frame,  
                "This midwife doesn't exist in the records- add now?",
                "Add New Midwife?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Yes", "No"},
                "Yes"
            );
            if (choice == JOptionPane.YES_OPTION)
                manualAddMidwife(frame);
        }
        Date dateOfBirth = getDateEntry(frame,
            "Enter the mother's date of birth (MM/dd/yyyy):"
        );
        String patientId = JOptionPane.showInputDialog(
            "Enter the mother's patient id:"
        );
        // ???
        String mothersId = JOptionPane.showInputDialog(
            "Enter the id of the mother's mother:"
        );
        String sex = JOptionPane.showInputDialog(
            "Enter the sex of the mother:"
        );
        String address = JOptionPane.showInputDialog(
            "Enter the address of the mother:"
        );
        int age = getIntEntry(17, 100, frame, 
        "Please enter the age of the mother:"
        );
        int registrationNumber = register.getMothers().size() + 1;
        double height = getDoubleEntry(
            0, 
            304, 
            frame, 
            "Enter the height of the mother (in cm):"
        );
        Trimester trimester = null;
        while (trimester == null) {
            trimester = (Trimester) JOptionPane.showInputDialog(
                null,
                "Select a Trimester:",
                "Trimester",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Trimester.values(),
                Trimester.values()[0]
            );
            if (trimester == null) {
                JOptionPane.showMessageDialog(frame, "Please select a trimester.");
            }
        }
        String facilityZone = JOptionPane.showInputDialog(
            "Enter the facility zone of the mother:"
        );
        String subDistrict = JOptionPane.showInputDialog(
            "Enter the sub district of the mother:"
        );
        boolean sicklingBlood = getBoolEntry(
            frame, 
            "Does the mother have Sickling Cell disease?", 
            "Sickling Cell Disease?"
        );
        String sicklingType = "";
        if (sicklingBlood) {
            sicklingType = JOptionPane.showInputDialog(
                "Enter the mother's Sickling type:"
            );
        }
        String bloodGroup = JOptionPane.showInputDialog(
            "Enter the blood type of the mother:"
        );
        double hgAtRegistry = getDoubleEntry(
            0, 
            1000, 
            frame, 
            "Enter the blood pressure of the mother:"
        );
        Date estimatedDueDate = getDateEntry(
            frame, 
        "Enter the expected due date of the mother:"
        );
        int parity = getIntEntry(
            -1, 
            10000, 
            frame, 
            "Enter the number of times the mother has given birth with a gestational age of 24 weeks or more:"
        );
        boolean vdrlAdministered = getBoolEntry(
            frame, 
            "Has the mother have had a VDRL?", 
            "VDRL?"
        );
        boolean vdrlStatus = false;
        if (vdrlAdministered) {
            vdrlStatus = getBoolEntry(
                frame, 
                "Was the result positive?", 
                "VDRL?"
            );
        }
        boolean hivPreCounseling = getBoolEntry(
            frame, 
            "Has the mother been given counseling about HIV?", 
            "HIV Counseling?"
        );
        int gestationalAge = getIntEntry(
            -1, 
            1000, 
            frame, 
            "Enter the gestational age of the pregnancy:"
        );
        boolean tetanusToxoidStatus = getBoolEntry(
            frame, 
            "Has the mother been immunized against Tetanus?", 
            "Tetanus Immunization"
        );
        int tetanusToxoidDoses = 0;
        if (tetanusToxoidStatus) {
            tetanusToxoidDoses = getIntEntry(
                0, 
                4, 
                frame, 
                "How many doses of the vaccine have they recieved?"
            );
        }
        int iptMalariaDoses = getIntEntry(
            0, 
            4, 
            frame, 
            "How many doses of antivirals against Malaria has the mother recieved?"
        );
        boolean itnInUse = getBoolEntry(
            frame, 
            "Has the mother been using an ITN (Insecticide-Treated Net)?",
            "ITN Net?"
        );
        Mother newMother = new Mother(
            midwifeName,
            name, 
            dateOfBirth, 
            patientId, 
            mothersId, 
            sex, 
            address, 
            age, 
            registrationNumber, 
            height, 
            trimester, 
            facilityZone, 
            subDistrict, 
            sicklingType, 
            sicklingBlood, 
            bloodGroup, 
            hgAtRegistry, 
            0, 
            estimatedDueDate, 
            parity, 
            vdrlAdministered, 
            vdrlStatus, 
            hivPreCounseling, 
            gestationalAge, 
            tetanusToxoidStatus, 
            tetanusToxoidDoses, 
            iptMalariaDoses, 
            itnInUse
        );
        register.addMother(name, newMother);
        JOptionPane.showMessageDialog(
            frame,
            String.format("Added %s to the registry!", name)
        );
    }

    /**
     * Prompts the user for a mother visit and adds it to the mother's record.
     *
     * @param frame the parent JFrame
     */    
    private static void manualAddMotherVisit(JFrame frame) {
        String name = JOptionPane.showInputDialog(
            "Enter the name of Mother whose visit we're recording:"
        );
        if (!register.hasMother(name)) {
            int choice = JOptionPane.showOptionDialog(
                frame,  
                "This name doesn't exist in the records- add new mother?",
                "Add New Mother?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Yes", "No"},
                "Yes"
            );
            if (choice == JOptionPane.YES_OPTION)
                manualAddMother(name, frame);
            else return;
            Mother mother = register.getMother(name);
            boolean hivResult = getBoolEntry(
                frame, 
                "Has the mother tested positive for HIV since the last visit?", 
                "HIV?"
            );
            boolean hivPostCounseling = false;
            boolean arvAdministered = false;
            if (hivResult) {
                hivPostCounseling = getBoolEntry(
                    frame, 
                    "Has the mother recieved counciling about their HIV diagnosis?", 
                    "HIV Counciling?"
                );
                arvAdministered = getBoolEntry(
                    frame, 
                    "Has the mother started Antiretroviral therapy?", 
                    "Antiretroviral Therapy?"
                );
            }
            Date date = getDateEntry(
                frame, 
                "Enter the date of the visit:"
            );
            int visitNumber = mother.getVisits().size() + 1;
            double fundalHeight = getDoubleEntry(
                0,
                1000,
                frame,
                "Enter the Fundal Height of the mother:"
            );
            double bloodPressure = getDoubleEntry(
                0,
                10000,
                frame,
                "Enter the blood pressure of the mother:"
            );

            // Set blood pressure at 36 weeks if applicable.
            long diffInMillis = Math.abs(date.getTime() - mother.getEstimatedConceptionDate().getTime());
            long weeks = TimeUnit.MILLISECONDS.toDays(diffInMillis) / 7;
            if (weeks >= 36) {
                mother.setHgAt36Wks(bloodPressure);
            }

            boolean breastFeedingEd = getBoolEntry(
                frame,
                "Has the mother recieved education about breast feeding?",
                "Breast Feeding Ed?"
            );
            double weight = getDoubleEntry(
                0,
                10000,
                frame,
                "Enter the current weight of the mother (in kg):"
            );
            String complaints = JOptionPane.showInputDialog(
                "Enter any complaints from the mother:"
            );
            String remarks = JOptionPane.showInputDialog(
                "Enter any other remarks here:"
            );
            Visit visit = new Visit(
                hivResult,
                hivPostCounseling,
                arvAdministered,
                date,
                visitNumber,
                fundalHeight,
                bloodPressure,
                breastFeedingEd,
                weight,
                complaints,
                remarks
            );
            mother.addVisit(visit);
            JOptionPane.showMessageDialog(
                frame,
                "Visit has been recorded!"
            );
        }
    }

    /**
     * Prompts the user to enter or update a midwife record.
     *
     * @param frame the parent JFrame
     */
    private static void manualAddMidwife(JFrame frame) {
        String name = JOptionPane.showInputDialog("Enter the name of the midwife:");
        if (register.hasMidwife(name)) {
            int choice = JOptionPane.showOptionDialog(
                frame,
                "This name already exists in the records- continue and update?",
                "Update Midwife?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Yes", "No"},
                "Yes"
            );
            if (choice != JOptionPane.YES_OPTION)
                return;
        }
        String institution = JOptionPane.showInputDialog("Enter the name of the institution where the midwife works:");
        String facilityType = JOptionPane.showInputDialog("Enter the type of facility the midwife works at:");
        String district = JOptionPane.showInputDialog("Enter the district the midwife operates:");
        String subDistrict = JOptionPane.showInputDialog("Enter the sub district the midwife operates:");
        String region = JOptionPane.showInputDialog("Enter the region the midwife is located:");
        String eocServices = JOptionPane.showInputDialog("Enter what emergency obstetric services are offered:");
        boolean otrCorner = getBoolEntry(frame, "Does the midwife's facility have an OTR corner?", "OTR Corner?");
        boolean conductsDelivery = getBoolEntry(frame, "Does the midwife conduct deliveries?", "Conducts Deliveries?");
        boolean transfusionServices = getBoolEntry(frame, "Are transfusion services available?", "Transfusion Services?");
        int numElectiveAbortions = getIntEntry(0, 1000, frame, "Enter the number of elective abortions:");
        int numSpontaneousAbortions = getIntEntry(0, 1000, frame, "Enter the number of spontaneous abortions:");
        int numInducedAbortions = getIntEntry(0, 1000, frame, "Enter the number of induced abortions:");
        int numMVAsDone = getIntEntry(0, 1000, frame, "Enter the number of MVAs done:");
        int numDCDone = getIntEntry(0, 1000, frame, "Enter the number of DCs done:");
        int numMalesSeenAtANC = getIntEntry(0, 1000, frame, "Enter the number of males seen at ANC:");
        int numMalesSeenAtDEL = getIntEntry(0, 1000, frame, "Enter the number of males seen at delivery:");
        int numMalesSeenPNC = getIntEntry(0, 1000, frame, "Enter the number of males seen at PNC:");
        int numMalesSeenFP = getIntEntry(0, 1000, frame, "Enter the number of males seen at FP:");
        int PMTCT = getIntEntry(0, 1000, frame, "Enter the number of PMTCT cases:");
        int babyFriendlyServices = getIntEntry(0, 1000, frame, "Enter the number of baby friendly services:");
        int numOfRegistrants = getIntEntry(0, 1000, frame, "Enter the number of registrants:");
        int attendances = getIntEntry(0, 1000, frame, "Enter the number of attendances:");
        int numOf4thVisits = getIntEntry(0, 1000, frame, "Enter the number of 4th visits:");
        int TT2PlusVaccination = getIntEntry(0, 1000, frame, "Enter the number of TT2+ vaccinations:");
        int parity = getIntEntry(0, 1000, frame, "Enter the parity:");
        int ageOfMotherAtRegistration = getIntEntry(0, 100, frame, "Enter the age of the mother at registration:");
        int mothersBelow150cm = getIntEntry(0, 1000, frame, "Enter the number of mothers below 150 cm:");
        int numOfSingleBirthMom = getIntEntry(0, 1000, frame, "Enter the number of single birth mothers:");
        int numOfTwinsMom = getIntEntry(0, 1000, frame, "Enter the number of twin mothers:");
        int numOfTripletsMom = getIntEntry(0, 1000, frame, "Enter the number of triplet mothers:");
        int numOfOtherNumOfBirthsMom = getIntEntry(0, 1000, frame, "Enter the number of other births mothers:");
        int numOfSingleBirthBaby = getIntEntry(0, 1000, frame, "Enter the number of single birth babies:");
        int numOfTwinsBaby = getIntEntry(0, 1000, frame, "Enter the number of twin babies:");
        int numOfTripletsBaby = getIntEntry(0, 1000, frame, "Enter the number of triplet babies:");
        int numOfOtherNumOfBirthsBaby = getIntEntry(0, 1000, frame, "Enter the number of other births babies:");
        int totNumMoms = getIntEntry(0, 1000, frame, "Enter the total number of mothers:");
        int totNumBaby = getIntEntry(0, 1000, frame, "Enter the total number of babies:");
        int numLiveMaleBirths = getIntEntry(0, 1000, frame, "Enter the number of live male births:");
        int numLiveFemaleBirths = getIntEntry(0, 1000, frame, "Enter the number of live female births:");
        int numStillMaceratedBirths = getIntEntry(0, 1000, frame, "Enter the number of still macerated births:");
        int numStillFreshBirths = getIntEntry(0, 1000, frame, "Enter the number of still fresh births:");
        int numPrimparn = getIntEntry(0, 1000, frame, "Enter the number of primparn:");
        int numMultiparn = getIntEntry(0, 1000, frame, "Enter the number of multiparn:");
        int totalBelow2_5kgWeight = getIntEntry(0, 1000, frame, "Enter the total weight of babies below 2.5 kg:");
        int totalAbove2_5kgWeight = getIntEntry(0, 1000, frame, "Enter the total weight of babies above 2.5 kg:");
        int numOfDeliveries2PlusIPT = getIntEntry(0, 1000, frame, "Enter the number of deliveries with 2+ IPT:");
        int numOfMaternalDeaths = getIntEntry(0, 1000, frame, "Enter the number of maternal deaths:");
        int numOfAuditedMaternalDeaths = getIntEntry(0, 1000, frame, "Enter the number of audited maternal deaths:");
        int numOfNeonatalDeaths = getIntEntry(0, 1000, frame, "Enter the number of neonatal deaths:");
        int numOfPostneonatalDeaths = getIntEntry(0, 1000, frame, "Enter the number of post-neonatal deaths:");
        int numNormalDelivery = getIntEntry(0, 1000, frame, "Enter the number of normal deliveries:");
        int numCSection = getIntEntry(0, 1000, frame, "Enter the number of C-sections:");
        int numVacuumDelivery = getIntEntry(0, 1000, frame, "Enter the number of vacuum deliveries:");
        int numForcepDelivery = getIntEntry(0, 1000, frame, "Enter the number of forcep deliveries:");
        int totalDeliveries = getIntEntry(0, 1000, frame, "Enter the total number of deliveries:");
        int numOfMothers10to14 = getIntEntry(0, 1000, frame, "Enter the number of mothers aged 10-14:");
        int numOfMothers15to19 = getIntEntry(0, 1000, frame, "Enter the number of mothers aged 15-19:");
        int numOfMothers20to24 = getIntEntry(0, 1000, frame, "Enter the number of mothers aged 20-24:");
        int numOfMothers25to29 = getIntEntry(0, 1000, frame, "Enter the number of mothers aged 25-29:");
        int numOfMothers30to34 = getIntEntry(0, 1000, frame, "Enter the number of mothers aged 30-34:");
        int numOfMothers35Plus = getIntEntry(0, 1000, frame, "Enter the number of mothers aged 35+:");
        int numVesicoVaginalFistulaSeen = getIntEntry(0, 1000, frame, "Enter the number of vesico-vaginal fistula seen:");
        int numVesicoVaginalFistulaRepaired = getIntEntry(0, 1000, frame, "Enter the number of vesico-vaginal fistula repaired:");
        int numVesicoVaginalFistulaReferred = getIntEntry(0, 1000, frame, "Enter the number of vesico-vaginal fistula referred:");
        int numReceivingOxytocin3rdStageLabor = getIntEntry(0, 1000, frame, "Enter the number of mothers receiving oxytocin in 3rd stage labor:");
        int numMothersInfantPairsOnlyBreastFeeding = getIntEntry(0, 1000, frame, "Enter the number of mothers with infant pairs only breast feeding:");
        int numMothersBreastFeedingWithin1Hour = getIntEntry(0, 1000, frame, "Enter the number of mothers breast feeding within 1 hour:");
        int numActiveMotherSupportGroups = getIntEntry(0, 1000, frame, "Enter the number of active mother support groups:");
        int numTrainedInLocationManagement = getIntEntry(0, 1000, frame, "Enter the number of trained in location management:");
        int numMalariaInPregnancy = getIntEntry(0, 1000, frame, "Enter the number of malaria in pregnancy cases:");
        int numDropFootCase = getIntEntry(0, 1000, frame, "Enter the number of drop foot cases:");
        int numPuerperalPsychosis = getIntEntry(0, 1000, frame, "Enter the number of puerperal psychosis cases:");
        int numRegistrants = getIntEntry(0, 1000, frame, "Enter the number of registrants:");
        int numSupervisedDelivery = getIntEntry(0, 1000, frame, "Enter the number of supervised deliveries:");
        int numNotSupervised = getIntEntry(0, 1000, frame, "Enter the number of not supervised deliveries:");
        int numNoANC = getIntEntry(0, 1000, frame, "Enter the number of mothers with no ANC:");
        int numPostPartumVitAMother = getIntEntry(0, 1000, frame, "Enter the number of mothers receiving post-partum vitamin A:");
        int numBabyWeight7to10Days2_5kgBelow = getIntEntry(0, 1000, frame, "Enter the number of babies weighing 2.5 kg or less at 7-10 days:");
        int numBabyWeight7to10Days2_5kgAbove = getIntEntry(0, 1000, frame, "Enter the number of babies weighing more than 2.5 kg at 7-10 days:");
        int numAntenatalReferrals = getIntEntry(0, 1000, frame, "Enter the number of antenatal referrals:");
        int numLabourReferrals = getIntEntry(0, 1000, frame, "Enter the number of labor referrals:");
        int numPostnatalReferrals = getIntEntry(0, 1000, frame, "Enter the number of postnatal referrals:");
        String birthAbnormalities = JOptionPane.showInputDialog(
            "Enter any birth abnormalities:"
        );
        int numRegistrants10to14 = getIntEntry(0, 1000, frame, "Enter the number of registrants aged 10-14:");
        int numRegistrants15to19 = getIntEntry(0, 1000, frame, "Enter the number of registrants aged 15-19:");
        int numRegistrants20to24 = getIntEntry(0, 1000, frame, "Enter the number of registrants aged 20-24:");
        int numRegistrants25to29 = getIntEntry(0, 1000, frame, "Enter the number of registrants aged 25-29:");
        int numRegistrants30to34 = getIntEntry(0, 1000, frame, "Enter the number of registrants aged 30-34:");
        int numRegistrants35Above = getIntEntry(0, 1000, frame, "Enter the number of registrants aged 35 and above:");
        int numRegistrants10to14Abortions = getIntEntry(0, 1000, frame, "Enter the number of registrants aged 10-14 for abortions:");
        int numRegistrants15to19Abortions = getIntEntry(0, 1000, frame, "Enter the number of registrants aged 15-19 for abortions:");
        int numRegistrants20to24Abortions = getIntEntry(0, 1000, frame, "Enter the number of registrants aged 20-24 for abortions:");
        int numRegistrants25to29Abortions = getIntEntry(0, 1000, frame, "Enter the number of registrants aged 25-29 for abortions:");
        int numRegistrants30to34Abortions = getIntEntry(0, 1000, frame, "Enter the number of registrants aged 30-34 for abortions:");
        int numRegistrants35AboveAbortions = getIntEntry(0, 1000, frame, "Enter the number of registrants aged 35 and above for abortions:");
        int numBleedingOrHaemorrhage = getIntEntry(0, 1000, frame, "Enter the number of cases of bleeding or hemorrhage:");
        int numSepsisOrInfectionAbortion = getIntEntry(0, 1000, frame, "Enter the number of cases of sepsis or infection during abortion:");
        int numPerforationsAbortions = getIntEntry(0, 1000, frame, "Enter the number of perforations during abortions:");
        int totNumOfDeathsFromPostAbortionComplications = getIntEntry(0, 1000, frame, "Enter the total number of deaths from post-abortion complications:");
        int numPACFPCounselled = getIntEntry(0, 1000, frame, "Enter the number of PAC/FP counseled:");
        int numPACFPAccepting = getIntEntry(0, 1000, frame, "Enter the number of PAC/FP accepting:");


        Midwife midwife = new Midwife(institution, facilityType, district, subDistrict, region, eocServices, otrCorner,
        conductsDelivery, transfusionServices, PMTCT, babyFriendlyServices, numOfRegistrants, attendances,
        numOf4thVisits, TT2PlusVaccination, parity, ageOfMotherAtRegistration, mothersBelow150cm,
        numOfSingleBirthMom, numOfTwinsMom, numOfTripletsMom, numOfOtherNumOfBirthsMom, numOfSingleBirthBaby,
        numOfTwinsBaby, numOfTripletsBaby, numOfOtherNumOfBirthsBaby, totNumMoms, totNumBaby, numLiveMaleBirths,
        numLiveFemaleBirths, numStillMaceratedBirths, numStillFreshBirths, numPrimparn, numMultiparn,
        totalBelow2_5kgWeight, totalAbove2_5kgWeight, numOfDeliveries2PlusIPT, numOfMaternalDeaths,
        numOfAuditedMaternalDeaths, numOfNeonatalDeaths, numOfPostneonatalDeaths, numNormalDelivery,
        numCSection, numVacuumDelivery, numForcepDelivery, totalDeliveries, numOfMothers10to14,
        numOfMothers15to19, numOfMothers20to24, numOfMothers25to29, numOfMothers30to34, numOfMothers35Plus,
        numVesicoVaginalFistulaSeen, numVesicoVaginalFistulaRepaired, numVesicoVaginalFistulaReferred,
        numReceivingOxytocin3rdStageLabor, numMothersInfantPairsOnlyBreastFeeding,
        numMothersBreastFeedingWithin1Hour, numActiveMotherSupportGroups, numTrainedInLocationManagement,
        numMalariaInPregnancy, numDropFootCase, numPuerperalPsychosis, numRegistrants, numSupervisedDelivery,
        numNotSupervised, numNoANC, numPostPartumVitAMother, numBabyWeight7to10Days2_5kgBelow,
        numBabyWeight7to10Days2_5kgAbove, numAntenatalReferrals, numLabourReferrals, numPostnatalReferrals,
        birthAbnormalities, numRegistrants10to14, numRegistrants15to19, numRegistrants20to24,
        numRegistrants25to29, numRegistrants30to34, numRegistrants35Above, numElectiveAbortions,
        numSpontaneousAbortions, numInducedAbortions, numMVAsDone, numDCDone, numRegistrants10to14Abortions,
        numRegistrants15to19Abortions, numRegistrants20to24Abortions, numRegistrants25to29Abortions,
        numRegistrants30to34Abortions, numRegistrants35AboveAbortions, numBleedingOrHaemorrhage,
        numSepsisOrInfectionAbortion, numPerforationsAbortions, totNumOfDeathsFromPostAbortionComplications,
        numPACFPCounselled, numPACFPAccepting, numMalesSeenAtANC, numMalesSeenAtDEL, numMalesSeenPNC,
        numMalesSeenFP
        ); // Ensure the Midwife class constructor matches these arguments
        register.addMidwife(name, midwife);
    }

    /**
     * Prompts the user to choose between manual or PDF entry for a record type.
     *
     * @param frame the parent JFrame
     * @param recordType the type of record (e.g., "Mother Visit" or "Midwife Record")
     */    
    private static void showOptionsDialog(JFrame frame, String recordType) {
        // Create a dialog with two options
        int choice = JOptionPane.showOptionDialog(
            frame,
            "How would you like to add the " + recordType + "?",
            "Select Entry Method",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[]{"Manual Entry", "PDF Scan"},
            "Manual Entry"
        );

        if (choice == JOptionPane.YES_OPTION) {
            // Manual Entry selected
            JOptionPane.showMessageDialog(frame, "Manual Entry selected for " + recordType + ".");
            if (recordType.equals("Mother Visit")) {
                manualAddMotherVisit(frame);
            }
            else if (recordType.equals("Midwife Record"))
                manualAddMidwife(frame);
        } else if (choice == JOptionPane.NO_OPTION) {
            // PDF Scan selected
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setDialogTitle("Select a PDF File");
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                if (selectedFile.getName().endsWith(".pdf")) {
                    JOptionPane.showMessageDialog(frame, "Selected file: " + selectedFile.getAbsolutePath());
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a valid PDF file.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * Prompts the user for a mother's name and registration number, and displays a summary report.
     *
     * @param frame the parent JFrame
     */
    private static void printMotherReport(JFrame frame) {
        // Prompt the user for the mother's name
        String motherName = JOptionPane.showInputDialog(frame, "Enter the mother's name:");
        if (motherName == null || motherName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Mother name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Prompt the user for the registration number
        String registrationNumberInput = JOptionPane.showInputDialog(frame, "Enter the mother's registration number:");
        if (registrationNumberInput == null || registrationNumberInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Registration number cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int registrationNumber;
        try {
            registrationNumber = Integer.parseInt(registrationNumberInput.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid registration number. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Find the mother in the register
        Mother mother = register.getMother(motherName);
        if (mother == null || mother.getRegistrationNumber() != registrationNumber) {
            JOptionPane.showMessageDialog(frame, "No mother found with the provided name and registration number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Generate the report for the specific mother
        StringBuilder report = new StringBuilder("Mother Report:\n\n");
        report.append("Name: ").append(mother.getName()).append("\n");
        report.append("Age: ").append(mother.getAge()).append("\n");
        report.append("Height: ").append(mother.getHeight()).append(" cm\n");
        report.append("Parity: ").append(mother.getParity()).append("\n");
        report.append("Gestational Age: ").append(mother.getGestationalAge()).append(" days\n");
        report.append("Estimated Due Date: ").append(mother.getEstimatedDueDate()).append("\n");
        report.append("--------------------------------------------------\n");

        // Display the report
        JOptionPane.showMessageDialog(frame, report.toString(), "Mother Report", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Prompts the user for a month and year, then displays a summary of all midwife records
     * relevant to that period.
     *
     * @param frame the parent JFrame
     */
    private static void printMidwifeReport(JFrame frame) {
        // Prompt the user for the month
        String monthInput = JOptionPane.showInputDialog(frame, "Enter the month (1-12):");
        if (monthInput == null || monthInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Month cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int month;
        try {
            month = Integer.parseInt(monthInput.trim());
            if (month < 1 || month > 12) {
                throw new NumberFormatException("Month out of range");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid month. Please enter a number between 1 and 12.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Prompt the user for the year
        String yearInput = JOptionPane.showInputDialog(frame, "Enter the year (e.g., 2025):");
        if (yearInput == null || yearInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Year cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int year;
        try {
            year = Integer.parseInt(yearInput.trim());
            if (year < 1900 || year > 2100) { // Adjust range as needed
                throw new NumberFormatException("Year out of range");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid year. Please enter a valid year (e.g., 2025).", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Generate the report for the specified month and year
        StringBuilder report = new StringBuilder("Midwife Report for " + month + "/" + year + ":\n\n");
        boolean hasRelevantData = false;

        for (Midwife midwife : register.getMidwives()) {
            // Assuming midwife data includes a method to check relevance for the given month/year
            if (midwife.isRelevantForMonthYear(month, year)) {
                hasRelevantData = true;
                report.append("Name: ").append(midwife.getName()).append("\n");
                report.append("Institution: ").append(midwife.getInstitution()).append("\n");
                report.append("Facility Type: ").append(midwife.getFacilityType()).append("\n");
                report.append("Region: ").append(midwife.getRegion()).append("\n");
                report.append("Conducts Deliveries: ").append(midwife.isConductsDelivery() ? "Yes" : "No").append("\n");
                report.append("--------------------------------------------------\n");
            }
        }

        // Display the report or show a message if no data is found
        if (hasRelevantData) {
            JOptionPane.showMessageDialog(frame, report.toString(), "Midwife Report", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "No midwife records found for " + month + "/" + year + ".", "Midwife Report", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
