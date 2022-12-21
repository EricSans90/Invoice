import java.util.Date;

public class Invoice {
    private InvoiceLine [] lines;
    private int invoiceNumber;
    private Date invoiceDate, deliveryDate, dueDate;
    private String invoiceTo, shipTo, salesPerson, shippingMethod, shippingTerms, paymentTerms;
    private float totalDiscount;

    public Invoice (int invoiceNumber, Date invoiceDate, String invoiceTo, String shipTo, String salesPerson,
                    String shippingMethod, String shippingTerms, Date deliveryDate, String paymentTerms, Date dueDate,
                    float totalDiscount){
            this.invoiceNumber=invoiceNumber;
            this.invoiceDate=invoiceDate;
            this.invoiceTo=invoiceTo;
            this.shipTo=shipTo;
            this.salesPerson=salesPerson;
            this.shippingMethod=shippingMethod;
            this.shippingTerms=shippingTerms;
            this.deliveryDate=deliveryDate;
            this.paymentTerms=paymentTerms;
            this.dueDate=dueDate;
            this.totalDiscount=totalDiscount;
            this.lines=new InvoiceLine[0];
    }

    public void addInvoiceLine (InvoiceLine addLine){
        InvoiceLine[] aux = new InvoiceLine[this.lines.length+1];
        for (int i=0; i<aux.length-1;i++){
            aux[i]=this.lines[i];
        }
        aux[aux.length-1]=addLine;
        this.lines=aux;
    }

    public InvoiceLine[] getLines() {
        return lines;
    }
// FALTE MODIFICAR PER IMPRIMIR-HO TOT BÉ
    public void print(){
        printTop();
        printInfoTop();
        for (int i=0; i<getLines().length;i++){
            this.lines[i].printLine();
        }
    }

    private void printTop() {
        System.out.println("                                                     Invoice number: "+this.invoiceNumber);
        System.out.print("                                                     "+
                "                                                          DATE: ");
        System.out.format("%tB %td, %tY%n", this.invoiceDate,this.invoiceDate, this.invoiceDate);
        System.out.println("                                                                 To: "+this.invoiceTo);
        System.out.println("                                                            Ship to: "+this.shipTo);
        System.out.println();
        printDash();
        System.out.print('|');
        System.out.print("        SALES PERSON");
        System.out.print(" | ");
        System.out.print("        SHIPPING METHOD");
        System.out.print(" | ");
        System.out.print("         SHIPPING TERMS");
        System.out.print(" | ");
        System.out.print("    DELIVERY DATE");
        System.out.print(" | ");
        System.out.print("          PAYMENT TERMS");
        System.out.print(" | ");
        System.out.print("    DUE DATE");
        System.out.print(" | ");
        System.out.println();
        printDash();

    }
    private void printInfoTop() {
        printSalesPerson();
        printShippingMethod();
        printShippingTerms();
        printDeliveryDate();
        printPaymentTerms();
        printDueDate();

        System.out.println();
        printDash();
        System.out.println();
    }

    public void printDash(){
        System.out.println("----------------------------------------------------------------------------------"+
                "------------------------------------------------------");
    }
    public void printSalesPerson(){
        System.out.print('|');
        //PRINT SALES PERSON
        int auxLen = 20-(this.salesPerson).length();
        char [] aux = new char[auxLen];
        for (int i=0; i<auxLen; i++){
            aux[i]=' ';
        }
        String aux2 = new String(aux);
        System.out.print(aux2+this.salesPerson);
        System.out.print(" | ");
    }
    public void printShippingMethod(){
        int auxLen = 23-(this.shippingMethod).length();
        char [] aux = new char[auxLen];
        for (int i=0; i<auxLen; i++){
            aux[i]=' ';
        }
        String aux2 = new String(aux);
        System.out.print(aux2+this.shippingMethod);
        System.out.print(" | ");
    }
    private void printShippingTerms() {
        int auxLen = 23-(this.shippingTerms).length();
        char [] aux = new char[auxLen];
        for (int i=0; i<auxLen; i++){
            aux[i]=' ';
        }
        String aux2 = new String(aux);
        System.out.print(aux2+this.shippingTerms);
        System.out.print(" | ");
    }

    private void printDeliveryDate() {
        System.out.print("         ");
        //System.out.print(this.deliveryDate);
        System.out.format("%tD", this.invoiceDate);
        System.out.print(" | ");
    }

    private void printPaymentTerms() {
        int auxLen = 23-(this.paymentTerms).length();
        char [] aux = new char[auxLen];
        for (int i=0; i<auxLen; i++){
            aux[i]=' ';
        }
        String aux2 = new String(aux);
        System.out.print(aux2+this.paymentTerms);
        System.out.print(" | ");
    }

    private void printDueDate() {
        System.out.print("    ");
        //System.out.print(this.deliveryDate);
        System.out.format("%tD", this.dueDate);
        System.out.print(" | ");
    }

}
