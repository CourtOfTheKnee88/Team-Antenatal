import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Visit {
    private boolean hivResult;
    private boolean hivPostCounseling;

    /* Antiretroviral therapy, to help prevent
       transmission of HIV to fetus in the case
       where the mother is HIV positive.
    */
    private boolean arvAdministered;

    private Date date;
    private int visitNumber;
    private double fundalHeight;
    private double bloodPressure;
    private boolean breastFeedingEd;
    private double weight;
    private String complaints;
    private String remarks;

    public Visit(boolean hivResult, boolean hivPostCounseling, 
                 boolean arvAdministered, Date date, 
                 int visitNumber, double fundalHeight, 
                 double bloodPressure, boolean breastFeedingEd, 
                 double weight, String complaints,
                 String remarks) {
        this.hivResult = hivResult;
        this.hivPostCounseling = hivPostCounseling;
        this.arvAdministered = arvAdministered;
        this.date = date;
        this.visitNumber = visitNumber;
        this.fundalHeight = fundalHeight;
        this.bloodPressure = bloodPressure;
        this.breastFeedingEd = breastFeedingEd;
        this.weight = weight;
        this.complaints = complaints;
        this.remarks = remarks;
    }

    public boolean isHivResult() {
        return hivResult;
    }

    public void setHivResult(boolean hivResult) {
        this.hivResult = hivResult;
    }

    public boolean isHivPostCounseling() {
        return hivPostCounseling;
    }

    public void setHivPostCounseling(boolean hivPostCounseling) {
        this.hivPostCounseling = hivPostCounseling;
    }

    public boolean isArvAdministered() {
        return arvAdministered;
    }

    public void setArvAdministered(boolean arvAdministered) {
        this.arvAdministered = arvAdministered;
    }

    public boolean isBreastFeedingEd() {
        return breastFeedingEd;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date visitDate) {
        this.date = visitDate;
    }

    public int getVisitNumber() {
        return visitNumber;
    }

    public void setVisitNumber(int visitNumber) {
        this.visitNumber = visitNumber;
    }

    public double getFundalHeight() {
        return fundalHeight;
    }

    public void setFundalHeight(double fundalHeight) {
        this.fundalHeight = fundalHeight;
    }

    public double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public boolean givenBreastFeedingEd() {
        return breastFeedingEd;
    }

    public void setBreastFeedingEd(boolean breastFeedingEd) {
        this.breastFeedingEd = breastFeedingEd;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    // Needs to be able to divide up each visit into its own object to be able to that informaton
    /**
     * Reads data from a PDF file and processes it.
     * @param pdfFilePath The path to the PDF file.
     * @throws IOException If an error occurs while reading the PDF.
     */
/*     public void readDataFromPDF(String pdfFilePath) throws IOException {
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
                        this.date = line.replace("Visit Date:", "").trim();
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
    } */
}
