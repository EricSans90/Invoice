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
    }



}
