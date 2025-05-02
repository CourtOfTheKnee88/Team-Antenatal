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

    /**
     * Constructs a Visit with detailed medical and observational data.
     *
     * @param hivResult HIV test result for the visit
     * @param hivPostCounseling whether post-test HIV counseling occurred
     * @param arvAdministered whether antiretroviral therapy was administered
     * @param date date of the visit
     * @param visitNumber sequential number of the visit
     * @param fundalHeight fundal height measurement
     * @param bloodPressure blood pressure recorded at visit
     * @param breastFeedingEd whether breastfeeding education was provided
     * @param weight mother's weight during visit
     * @param complaints mother's reported complaints
     * @param remarks additional remarks by provider
     */
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

    /** @return HIV result of the visit */
    public boolean isHivResult() {
        return hivResult;
    }

    /** @param hivResult HIV result to set */
    public void setHivResult(boolean hivResult) {
        this.hivResult = hivResult;
    }

    /** @return whether post-HIV test counseling was provided */
    public boolean isHivPostCounseling() {
        return hivPostCounseling;
    }

    /** @param hivPostCounseling whether counseling occurred */
    public void setHivPostCounseling(boolean hivPostCounseling) {
        this.hivPostCounseling = hivPostCounseling;
    }

    /** @return true if antiretroviral therapy was given */
    public boolean isArvAdministered() {
        return arvAdministered;
    }

    /** @param arvAdministered whether ARV was administered */
    public void setArvAdministered(boolean arvAdministered) {
        this.arvAdministered = arvAdministered;
    }

    /** @return date of the visit */
    public Date getDate() {
        return date;
    }

    /** @param visitDate date of the visit */
    public void setDate(Date visitDate) {
        this.date = visitDate;
    }

    /** @return number of the visit */
    public int getVisitNumber() {
        return visitNumber;
    }

    /** @param visitNumber sequential visit number */
    public void setVisitNumber(int visitNumber) {
        this.visitNumber = visitNumber;
    }

    /** @return fundal height recorded during visit */
    public double getFundalHeight() {
        return fundalHeight;
    }

    /** @param fundalHeight measurement of fundal height */
    public void setFundalHeight(double fundalHeight) {
        this.fundalHeight = fundalHeight;
    }

    /** @return blood pressure during visit */
    public double getBloodPressure() {
        return bloodPressure;
    }

    /** @param bloodPressure blood pressure value */
    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    /** @return true if breastfeeding education was provided */
    public boolean givenBreastFeedingEd() {
        return breastFeedingEd;
    }

    /** @return whether breastfeeding education was provided */
    public void setBreastFeedingEd(boolean breastFeedingEd) {
        this.breastFeedingEd = breastFeedingEd;
    }

    /** @return weight measured during visit */
    public double getWeight() {
        return weight;
    }

    /** @param weight mother's weight in kg */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /** @return mother's reported complaints */
    public String getComplaints() {
        return complaints;
    }

    /** @param complaints text of complaints */
    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }

    /** @return any additional remarks */
    public String getRemarks() {
        return remarks;
    }

    /** @return any additional remarks */
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
