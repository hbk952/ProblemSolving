package SOLIDPrinciples;
//A class should have only one reason to change - one responsibilty


class Marker{
	String name;
	String color;
	int year;
	int price;
	public Marker(String name, String color, int year, int price) {
		super();
		this.name = name;
		this.color = color;
		this.year = year;
		this.price = price;
	}
	
}

class Invoice{
	private Marker marker;
	private int quantity;
	public Invoice(Marker marker, int quantity) {
		super();
		this.marker = marker;
		this.quantity = quantity;
	}
	
	public int calculateTotal() {
		int price = ((marker.price)*this.quantity);
		return price;
	}
	
	//having more than one method - more than 1 responsibilty - more than 1 reason for change in same class
	
//	public void printInvoice() {
//		
//	}
	
//	public void saveToDB() {
//		
//	}
}

public class SingleResponsibility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//solution: create seperate class for each responsibilty.
class InvoiceDao{
	Invoice invoice;
	public InvoiceDao(Invoice invoice) {
		this.invoice = invoice;
	}
	public void saveToDB() {
		
	}
}
class InvoicePrinter{
	private Invoice invoice;
	public InvoicePrinter(Invoice invoice) {
		this.invoice = invoice;
	}
	public void printInvoice() {
		
	}
}