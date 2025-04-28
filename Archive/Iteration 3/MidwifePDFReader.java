import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class MidwifePDFReader extends Midwife {

    public MidwifePDFReader(String name, String institution, String facilityType, String district, String subDistrict,
            String region, String eocServices, boolean otrCorner, boolean conductsDelivery,
            boolean transfusionServices) {
        super(name, institution, facilityType, district, subDistrict, region, eocServices, otrCorner, conductsDelivery,
                transfusionServices);
    }

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
            eocServices, otrCorner, conductsDelivery, transfusionServices
        );
    }
}
