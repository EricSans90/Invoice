import java.util.Date;
import java.util.Calendar;

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
        for (int i=0; i<getLines().length;i++){
            this.lines[i].printLine();
        }
    }

    private void printTop() {
        System.out.println("                                                     Invoice number: "+this.invoiceNumber);
        //System.out.print("                                                     "+
        //        "                         DATE: ");
        //System.out.format("%tB %te, %ty%n", this.invoiceDate.getMonth(),this.invoiceDate.getDay(), this.invoiceDate.getYear());
        System.out.println("                                                                 To: "+this.invoiceTo);
        System.out.println("                                                            Ship to: "+this.shipTo);
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------"+
                "---------------------------------");
        System.out.print('|');
        System.out.print("        SALES PERSON");
        System.out.print(" | ");
        System.out.print("        SHIPPING METHOD");
        System.out.print(" | ");
        System.out.print("        SHIPPING TERMS");
        System.out.print(" | ");
        System.out.print("    DELIVERY DATE");
        System.out.print(" | ");
        System.out.print("        PAYMENT TERMS");
        System.out.print(" | ");
        System.out.print("    DUE DATE");
        System.out.print(" | ");

        System.out.println();
        System.out.println("----------------------------------------------------------------------------------"+
                "---------------------------------");
        System.out.println();

    }


}
