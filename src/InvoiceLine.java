import java.text.DecimalFormat;

public class InvoiceLine {
    private int qty;
    private String itemName, description;
    private float unitPrice, discount, lineTotal;

    public InvoiceLine (int qty, String itemName, String description, float unitPrice, float discount){
        this.qty=qty;
        this.itemName=itemName;
        this.description=description;
        this.unitPrice=unitPrice;
        this.discount=discount;
        this.lineTotal=qty*unitPrice*(1-discount/100);
    }

    public static String customFormat(String pattern, double value){
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
    return output;
    }
    //to print dollars -> customFormat("$###,###.##",value);
    public void printLine (){
        printQty();
        printItem();
        printDescription();
        printUnitPrice();
        printDiscount();
        printLineTotal();
        System.out.println();
    }
    public void printQty(){
        //int auxLen = 8-finalSpace(this.qty);
        int auxLen = 8-Integer.toString(this.qty).length();
        char [] aux = new char[auxLen];
        for (int i=0; i<auxLen; i++){
            aux[i]=' ';
        }
        String aux2 = new String(aux);
        System.out.print('|');
        System.out.print(aux2);
        System.out.print(customFormat("###,###",this.qty));
        // customFormat("###,###",this.qty).length();


        System.out.print(" | ");
    }

    private int finalSpace(int qty) {

        return qty;
    }

    public void printItem(){
        int auxLen = 8-this.itemName.length();
        char [] aux = new char[auxLen];
        for (int i=0; i<auxLen; i++){
            aux[i]=' ';
        }
        String aux2 = new String(aux);
        System.out.print(aux2);
        System.out.print(this.itemName);
        System.out.print(" | ");
    }

    public void printDescription(){
        int auxLen = 32-this.description.length();
        char [] aux = new char[auxLen];
        for (int i=0; i<auxLen; i++){
            aux[i]=' ';
        }
        String aux2 = new String(aux);
        System.out.print(aux2);
        System.out.print(this.description);
        System.out.print(" | ");
    }
    public void printUnitPrice(){
        int auxLen = 10-Float.toString(this.unitPrice).length();
        char [] aux = new char[auxLen];
        for (int i=0; i<auxLen; i++){
            aux[i]=' ';
        }
        String aux2 = new String(aux);
        System.out.print(aux2);
        System.out.print(customFormat("$###,###.00",this.unitPrice));
        System.out.print(" | ");
    }
    public void printDiscount(){
        int auxLen = 8-Float.toString(this.discount).length();
        char [] aux = new char[auxLen];
        for (int i=0; i<auxLen; i++){
            aux[i]=' ';
        }
        String aux2 = new String(aux);
        System.out.print(aux2);
        System.out.print(customFormat("##.00%",this.discount/100));
        System.out.print(" | ");
    }
    public void printLineTotal(){
        int auxLen = 14-Float.toString(this.lineTotal).length();
        char [] aux = new char[auxLen];
        for (int i=0; i<auxLen; i++){
            aux[i]=' ';
        }
        String aux2 = new String(aux);
        System.out.print(aux2);
        System.out.print(customFormat("$###,###.00",this.lineTotal));
        System.out.print(" | ");
    }

    public float getLineTotal() {
        return lineTotal;
    }
}
