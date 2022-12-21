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
        for (int i=0; i<getLines().length;i++){
            this.lines[i].printLine();
        }
    }


}
