public class FactoryMethodTest {

    public static void main(String[] args) {

        // --- Word Document ---
        System.out.println("--- Testing WordDocumentFactory ---");
        WordDocumentFactory wordFactory = new WordDocumentFactory();
        WordDocument wordDoc = (WordDocument) wordFactory.createDocument();
        System.out.println("Document type created : " + wordDoc.getType());
        System.out.println("Correct type created  : " + wordDoc.getType().equals("Word Document"));
        wordDoc.open();
        wordDoc.save();

        System.out.println();

        // --- PDF Document ---
        System.out.println("--- Testing PdfDocumentFactory ---");
        PdfDocumentFactory pdfFactory = new PdfDocumentFactory();
        PdfDocument pdfDoc = (PdfDocument) pdfFactory.createDocument();
        System.out.println("Document type created : " + pdfDoc.getType());
        System.out.println("Correct type created  : " + pdfDoc.getType().equals("PDF Document"));
        pdfDoc.open();
        pdfDoc.save();

        System.out.println();

        // --- Excel Document ---
        System.out.println("--- Testing ExcelDocumentFactory ---");
        ExcelDocumentFactory excelFactory = new ExcelDocumentFactory();
        ExcelDocument excelDoc = (ExcelDocument) excelFactory.createDocument();
        System.out.println("Document type created : " + excelDoc.getType());
        System.out.println("Correct type created  : " + excelDoc.getType().equals("Excel Document"));
        excelDoc.open();
        excelDoc.save();

        System.out.println();

        // --- Verify each factory produces its own type ---
        System.out.println("--- Cross-type verification ---");
        System.out.println("WordFactory  produces WordDocument  : " + (wordFactory.createDocument() instanceof WordDocument));
        System.out.println("PdfFactory   produces PdfDocument   : " + (pdfFactory.createDocument() instanceof PdfDocument));
        System.out.println("ExcelFactory produces ExcelDocument : " + (excelFactory.createDocument() instanceof ExcelDocument));
    }
}
