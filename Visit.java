import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.IOException;
import java.sql.Date;

public class Visit extends Record {
    private Date visitDate;
    private int visitNumber;
    private String complaints;
    private String remarks;

    public Visit() {
        super();
        this.visitDate = null;
        this.visitNumber = 0;
        this.complaints = null;
        this.remarks = null;
    }

    public void getSpecificVisitReport(int patientNumber, int visitNumber) {
        // Logic to retrieve a specific visit report for a patient
        // This could involve querying a database or searching through a list of visits
    }


    // Needs to be able to divide up each visit into its own object to be able to that informaton
    /**
     * Reads data from a PDF file and processes it.
     * @param pdfFilePath The path to the PDF file.
     * @throws IOException If an error occurs while reading the PDF.
     */
    public void readDataFromPDF(String pdfFilePath) throws IOException {
        File file = new File(pdfFilePath);
        try (PDDocument document = PDDocument.load(file)) {
            if (!document.isEncrypted()) {
                PDFTextStripper pdfStripper = new PDFTextStripper();
                String text = pdfStripper.getText(document);

                // Process the extracted text to populate fields
                // Example: Assuming the PDF contains data in a specific format
                String[] lines = text.split("\n");
                for (String line : lines) {
                    if (line.startsWith("Visit Date:")) {
                        this.visitDate = line.replace("Visit Date:", "").trim();
                    } else if (line.startsWith("Visit Number:")) {
                        this.visitNumber = Integer.parseInt(line.replace("Visit Number:", "").trim());
                    } else if (line.startsWith("Complaints:")) {
                        this.complaints = line.replace("Complaints:", "").trim();
                    } else if (line.startsWith("Remarks:")) {
                        this.remarks = line.replace("Remarks:", "").trim();
                    }
                }
            } else {
                throw new IOException("The PDF is encrypted and cannot be read.");
            }
        }
    }
}
