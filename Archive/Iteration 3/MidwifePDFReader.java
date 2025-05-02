import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class MidwifePDFReader {

    public static Midwife createMidwifeFromPDF(String pdfFilePath) throws IOException {
        File file = new File(pdfFilePath);
        if (!file.exists()) {
            throw new IOException("File not found: " + pdfFilePath);
        }

        // Variables to hold extracted data
        String name = null;
        String institution = null;
        String facilityType = null;
        String district = null;
        String subDistrict = null;
        String region = null;
        String eocServices = null;
        boolean otrCorner = false;
        boolean conductsDelivery = false;
        boolean transfusionServices = false;

        // New variables
        int numElectiveAbortions = 0;
        int numSpontaneousAbortions = 0;
        int numInducedAbortions = 0;
        int numMVAsDone = 0;
        int numDCDone = 0;
        int numMalesSeenAtANC = 0;
        int numMalesSeenAtDEL = 0;
        int numMalesSeenPNC = 0;
        int numMalesSeenFP = 0;

        // Load the PDF document
        try (PDDocument document = PDDocument.load(file)) {
            if (!document.isEncrypted()) {
                PDFTextStripper pdfStripper = new PDFTextStripper();
                pdfStripper.setStartPage(1); // Read only the first page
                pdfStripper.setEndPage(1);

                String text = pdfStripper.getText(document);

                // Process the extracted text to populate variables
                String[] lines = text.split("\n");

                for (String line : lines) {
                    if (line.startsWith("Name:")) {
                        name = line.replace("Name:", "").trim();
                    } else if (line.startsWith("Institution:")) {
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
                    }
                }
            } else {
                throw new IOException("The PDF is encrypted and cannot be read.");
            }
        } catch (Exception e) {
            throw new IOException("Error processing the PDF file: " + e.getMessage(), e);
        }

        // Create and return the Midwife object
        return new Midwife(
            name, institution, facilityType, district, subDistrict, region,
            eocServices, otrCorner, conductsDelivery, transfusionServices,
            numElectiveAbortions, numSpontaneousAbortions, numInducedAbortions,
            numMVAsDone, numDCDone, numMalesSeenAtANC, numMalesSeenAtDEL,
            numMalesSeenPNC, numMalesSeenFP
        );
    }

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

        Midwife midwife = new Midwife(
            name, institution, facilityType, district, subDistrict, region,
            eocServices, otrCorner, conductsDelivery, transfusionServices,
            numElectiveAbortions, numSpontaneousAbortions, numInducedAbortions,
            numMVAsDone, numDCDone, numMalesSeenAtANC, numMalesSeenAtDEL,
            numMalesSeenPNC, numMalesSeenFP
        );
        register.addMidwife(name, midwife);
    }
}
