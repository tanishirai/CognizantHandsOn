public class ConcreteWordDocument implements WordDocument {

    @Override
    public void open() {
        System.out.println("Opening Word document (.docx)");
    }

    @Override
    public void save() {
        System.out.println("Saving Word document (.docx)");
    }

    @Override
    public String getType() {
        return "Word Document";
    }
}
