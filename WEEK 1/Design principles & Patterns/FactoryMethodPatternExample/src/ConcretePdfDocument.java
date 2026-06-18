public class ConcretePdfDocument implements PdfDocument {

    @Override
    public void open() {
        System.out.println("Opening PDF document (.pdf)");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document (.pdf)");
    }

    @Override
    public String getType() {
        return "PDF Document";
    }
}
