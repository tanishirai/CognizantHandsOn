public class ConcreteExcelDocument implements ExcelDocument {

    @Override
    public void open() {
        System.out.println("Opening Excel document (.xlsx)");
    }

    @Override
    public void save() {
        System.out.println("Saving Excel document (.xlsx)");
    }

    @Override
    public String getType() {
        return "Excel Document";
    }
}
