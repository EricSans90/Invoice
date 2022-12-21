import java.text.DecimalFormat;
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
        printDash2();
        printLineHeader();
        printDash2();
        for (int i=0; i<getLines().length;i++){
            //System.out.print("      ");
            InvoiceLine.addSpaces(12);
            this.lines[i].printLine();
        }
        printDash2();
        printTotalDiscountLine();
        printDash3();
        printSubTotal();
        printDash4();
        printGST();
        printDash4();
        printTotal();
        printDash4();

    }
    public void printDash1(){
        System.out.println("----------------------------------------------------------------------------------"+
                "------------------------------------------------------");
    }
    private void printDash2() {
        InvoiceLine.addSpaces(12);
        System.out.println("----------------------------------------------------------------------------------"+
                "------------------");
    }
    private void printDash3() {
        InvoiceLine.addSpaces(81);
        System.out.println("-------------------------------");
    }
    private void printDash4() {
        InvoiceLine.addSpaces(94);
        System.out.println("------------------");
    }

    private void printTop() {
        System.out.println("                                                     Invoice number: "+this.invoiceNumber);
        System.out.print("                                                     "+
                "                                                          DATE: ");
        System.out.format("%tB %td, %tY%n", this.invoiceDate,this.invoiceDate, this.invoiceDate);
        System.out.println("                                                                 To: "+this.invoiceTo);
        System.out.println("                                                            Ship to: "+this.shipTo);
        System.out.println();
        printDash1();
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
        printDash1();

    }
    private void printInfoTop() {
        printSalesPerson();
        printShippingMethod();
        printShippingTerms();
        printDeliveryDate();
        printPaymentTerms();
        printDueDate();

        System.out.println();
        printDash1();
        System.out.println();
    }
    private void printLineHeader() {
        InvoiceLine.addSpaces(12);
        System.out.println("|     QTY |   Item # |                      DESCRIPTION | UNIT PRICE |   DISCOUNT |     LINE TOTAL |");
    }
    private void printTotalDiscountLine() {
        System.out.print("                                                                  TOTAL DISCOUNT | ");
        String formattedValue1 = customFormat("##.00%",this.totalDiscount/100);
        int auxLen = 10-formattedValue1.length();
        char [] aux = new char[auxLen];
        for (int i=0; i<auxLen; i++){
            aux[i]=' ';
        }
        String aux2 = new String(aux);
        System.out.print(aux2);
        System.out.print(formattedValue1);
        System.out.print(" | ");

        String formattedValue2 = customFormat("$###,###.00",totalWithoutDisc()*this.totalDiscount/100);
        int auxLen2 = 14-formattedValue2.length();
        char [] aux3 = new char[auxLen2];
        for (int j=0; j<auxLen2; j++){
            aux3[j]=' ';
        }
        String aux4 = new String(aux3);
        System.out.print(aux4);
        System.out.print(formattedValue2);
        System.out.print(" | ");
        System.out.println();

    }
    private void printSubTotal() {
        System.out.print("                                                                                     SUBTOTAL | ");
        String formattedValue2 = customFormat("$###,###.00",totalWithoutDisc()-totalWithoutDisc()*this.totalDiscount/100);
        int auxLen2 = 14-formattedValue2.length();
        char [] aux3 = new char[auxLen2];
        for (int j=0; j<auxLen2; j++){
            aux3[j]=' ';
        }
        String aux4 = new String(aux3);
        System.out.print(aux4);
        System.out.print(formattedValue2);
        System.out.print(" | ");
        System.out.println();
    }
    private void printGST() {
        System.out.print("                                                                                          GST | ");
        String formattedValue2 = customFormat("$###,###.00",
                (totalWithoutDisc() - ((totalWithoutDisc() * this.totalDiscount) / 100)) * 0.21);
        int auxLen2 = 14-formattedValue2.length();
        char [] aux3 = new char[auxLen2];
        for (int j=0; j<auxLen2; j++){
            aux3[j]=' ';
        }
        String aux4 = new String(aux3);
        System.out.print(aux4);
        System.out.print(formattedValue2);
        System.out.print(" | ");
        System.out.println();
    }

    private void printTotal() {
        System.out.print("                                                                                        TOTAL | ");
        String formattedValue2 = customFormat("$###,###.00",totalWithoutDisc()*(1-this.totalDiscount/100)*1.21);
        int auxLen2 = 14-formattedValue2.length();
        char [] aux3 = new char[auxLen2];
        for (int j=0; j<auxLen2; j++){
            aux3[j]=' ';
        }
        String aux4 = new String(aux3);
        System.out.print(aux4);
        System.out.print(formattedValue2);
        System.out.print(" | ");
        System.out.println();
    }
    public static String customFormat(String pattern, double value){
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        return output;
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

    public float totalWithoutDisc() {
        float totalNoDisc=0;
        for (int i = 0; i < getLines().length; i++) {
            totalNoDisc += getLines()[i].getLineTotal();
        }
        return totalNoDisc;
    }

}
