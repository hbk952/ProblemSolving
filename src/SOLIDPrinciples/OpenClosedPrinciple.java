package SOLIDPrinciples;
//A class should be open for extension but closed for modification.
//We have a class for saveToDB - which is developed, tested and deployed in production.
//New requirement - we want to save it to File also.
//we can add method saveToFile in the same class but it will be against the principle.
//Solution: creating interface of invoice Dao with declaring "save" method in it.
// Then implementing and defining this method as per requirement accordingly.

interface InvoiceDao1{
public void save(Invoice invoice);	
}

class DatabaseInvoiceDao implements InvoiceDao1{

	@Override
	public void save(Invoice invoice) {
		// TODO Auto-generated method stub
		
	}
	
}

class FileInvoiceDao implements InvoiceDao1{

	@Override
	public void save(Invoice invoice) {
		// TODO Auto-generated method stub
		
	}
	
}


public class OpenClosedPrinciple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

