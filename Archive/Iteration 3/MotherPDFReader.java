// import org.apache.pdfbox.pdmodel.PDDocument;
// import org.apache.pdfbox.text.PDFTextStripper;

// import java.io.File;
// import java.io.IOException;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.Date;

// public class MotherPDFReader extends Mother {

//     public MotherPDFReader(String midwifeName, String name, Date dateOfBirth, String patientID, String mothersID,
//             String sex, String address, int age, int registrationNumber, double height, Trimester trimester,
//             String facilityZone, String subDistrict, String sicklingType, boolean sicklingBlood, String bloodGroup,
//             double hgAtRegistry, double hgAt36Wks, Date estimatedDueDate, int parity, boolean vdrlAdministered,
//             boolean vdrlStatus, boolean hivPreCounseling, int gestationalAge, boolean tetanusToxoidStatus,
//             int tetanusToxoidDoses, int iptMalariaDoses, boolean itnInUse) {
//         super(midwifeName, name, dateOfBirth, patientID, mothersID, sex, address, age, registrationNumber, height, trimester,
//                 facilityZone, subDistrict, sicklingType, sicklingBlood, bloodGroup, hgAtRegistry, hgAt36Wks, estimatedDueDate,
//                 parity, vdrlAdministered, vdrlStatus, hivPreCounseling, gestationalAge, tetanusToxoidStatus, tetanusToxoidDoses,
//                 iptMalariaDoses, itnInUse);
//     }

//     public static Mother createMotherFromPDF(String pdfFilePath) throws IOException {
//         File file = new File(pdfFilePath);
//         if (!file.exists()) {
//             throw new IOException("File not found: " + pdfFilePath);
//         }

//         // Variables to hold extracted data
//         String midwifeName = null;
//         String name = null;
//         Date dateOfBirth = null;
//         String patientID = null;
//         String mothersID = null;
//         String sex = null;
//         String address = null;
//         int age = 0;
//         int registrationNumber = 0;
//         double height = 0.0;
//         Trimester trimester = null; // Assuming Trimester is an enum or class
//         String facilityZone = null;
//         String subDistrict = null;
//         String sicklingType = null;
//         boolean sicklingBlood = false;
//         String bloodGroup = null;
//         double hgAtRegistry = 0.0;
//         double hgAt36Wks = 0.0;
//         Date estimatedDueDate = null;
//         int parity = 0;
//         boolean vdrlAdministered = false;
//         boolean vdrlStatus = false;
//         boolean hivPreCounseling = false;
//         int gestationalAge = 0;
//         boolean tetanusToxoidStatus = false;
//         int tetanusToxoidDoses = 0;
//         int iptMalariaDoses = 0;
//         boolean itnInUse = false;

//         // Load the PDF document
//         try (PDDocument document = PDDocument.load(file)) {
//             if (!document.isEncrypted()) {
//                 PDFTextStripper pdfStripper = new PDFTextStripper();
//                 pdfStripper.setStartPage(1); // Read only the first page
//                 pdfStripper.setEndPage(1);

//                 String text = pdfStripper.getText(document);

//                 // Process the extracted text to populate variables
//                 String[] lines = text.split("\n");
//                 SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Adjust format as needed

//                 for (String line : lines) {
//                     if (line.startsWith("Midwife Name:")) {
//                         midwifeName = line.replace("Midwife Name:", "").trim();
//                     } else if (line.startsWith("Name:")) {
//                         name = line.replace("Name:", "").trim();
//                     } else if (line.startsWith("Date of Birth:")) {
//                         try {
//                             dateOfBirth = dateFormat.parse(line.replace("Date of Birth:", "").trim());
//                         } catch (ParseException e) {
//                             throw new IOException("Invalid date format for Date of Birth.", e);
//                         }
//                     } else if (line.startsWith("Patient ID:")) {
//                         patientID = line.replace("Patient ID:", "").trim();
//                     } else if (line.startsWith("Mother's ID:")) {
//                         mothersID = line.replace("Mother's ID:", "").trim();
//                     } else if (line.startsWith("Sex:")) {
//                         sex = line.replace("Sex:", "").trim();
//                     } else if (line.startsWith("Address:")) {
//                         address = line.replace("Address:", "").trim();
//                     } else if (line.startsWith("Age:")) {
//                         age = Integer.parseInt(line.replace("Age:", "").trim());
//                     } else if (line.startsWith("Registration Number:")) {
//                         registrationNumber = Integer.parseInt(line.replace("Registration Number:", "").trim());
//                     } else if (line.startsWith("Height:")) {
//                         height = Double.parseDouble(line.replace("Height:", "").trim());
//                     } else if (line.startsWith("Facility Zone:")) {
//                         facilityZone = line.replace("Facility Zone:", "").trim();
//                     } else if (line.startsWith("Sub District:")) {
//                         subDistrict = line.replace("Sub District:", "").trim();
//                     } else if (line.startsWith("Sickling Type:")) {
//                         sicklingType = line.replace("Sickling Type:", "").trim();
//                     } else if (line.startsWith("Sickling Blood:")) {
//                         sicklingBlood = Boolean.parseBoolean(line.replace("Sickling Blood:", "").trim());
//                     } else if (line.startsWith("Blood Group:")) {
//                         bloodGroup = line.replace("Blood Group:", "").trim();
//                     } else if (line.startsWith("Hg at Registry:")) {
//                         hgAtRegistry = Double.parseDouble(line.replace("Hg at Registry:", "").trim());
//                     } else if (line.startsWith("Hg at 36 Weeks:")) {
//                         hgAt36Wks = Double.parseDouble(line.replace("Hg at 36 Weeks:", "").trim());
//                     } else if (line.startsWith("Estimated Due Date:")) {
//                         try {
//                             estimatedDueDate = dateFormat.parse(line.replace("Estimated Due Date:", "").trim());
//                         } catch (ParseException e) {
//                             throw new IOException("Invalid date format for Estimated Due Date.", e);
//                         }
//                     } else if (line.startsWith("Parity:")) {
//                         parity = Integer.parseInt(line.replace("Parity:", "").trim());
//                     } else if (line.startsWith("VDRL Administered:")) {
//                         vdrlAdministered = Boolean.parseBoolean(line.replace("VDRL Administered:", "").trim());
//                     } else if (line.startsWith("VDRL Status:")) {
//                         vdrlStatus = Boolean.parseBoolean(line.replace("VDRL Status:", "").trim());
//                     } else if (line.startsWith("HIV Pre-Counseling:")) {
//                         hivPreCounseling = Boolean.parseBoolean(line.replace("HIV Pre-Counseling:", "").trim());
//                     } else if (line.startsWith("Gestational Age:")) {
//                         gestationalAge = Integer.parseInt(line.replace("Gestational Age:", "").trim());
//                     } else if (line.startsWith("Tetanus Toxoid Status:")) {
//                         tetanusToxoidStatus = Boolean.parseBoolean(line.replace("Tetanus Toxoid Status:", "").trim());
//                     } else if (line.startsWith("Tetanus Toxoid Doses:")) {
//                         tetanusToxoidDoses = Integer.parseInt(line.replace("Tetanus Toxoid Doses:", "").trim());
//                     } else if (line.startsWith("IPT Malaria Doses:")) {
//                         iptMalariaDoses = Integer.parseInt(line.replace("IPT Malaria Doses:", "").trim());
//                     } else if (line.startsWith("ITN In Use:")) {
//                         itnInUse = Boolean.parseBoolean(line.replace("ITN In Use:", "").trim());
//                     }
//                 }
//             } else {
//                 throw new IOException("The PDF is encrypted and cannot be read.");
//             }
//         } catch (Exception e) {
//             throw new IOException("Error processing the PDF file: " + e.getMessage(), e);
//         }

//         // Create and return the Mother object
//         return new Mother(
//             midwifeName, name, dateOfBirth, patientID, mothersID, sex, address,
//             age, registrationNumber, height, trimester, facilityZone, subDistrict,
//             sicklingType, sicklingBlood, bloodGroup, hgAtRegistry, hgAt36Wks,
//             estimatedDueDate, parity, vdrlAdministered, vdrlStatus, hivPreCounseling,
//             gestationalAge, tetanusToxoidStatus, tetanusToxoidDoses, iptMalariaDoses, itnInUse
//         );
//     }
// }