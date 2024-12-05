package PrototypeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class NetworkConnection implements Cloneable{
	private String ip;
	private String importantData;
	private List<String> domains = new ArrayList<>();
	
	public List<String> getDomains() {
		return domains;
	}
	public void setDomains(List<String> domains) {
		this.domains = domains;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getImportantData() {
		return importantData;
	}
	public void setImportantData(String importantData) {
		this.importantData = importantData;
	}
	
	
	@Override
	public String toString() {
		return "NetworkConnection [ip=" + ip + ", importantData=" + importantData + ", domains=" + domains + "]";
	}
	//creating a method to examplify object creation takes time.
	//when object creaed for the first time, it will take time due to complex process involved.
	//when the same object cloned, will not take time
	public void loadImportantData() throws InterruptedException {
		this.importantData = "very very important data";
		this.domains.add("www.xyz.com");
		this.domains.add("www.abc.com");
		this.domains.add("www.vsdv.com");
		Thread.sleep(5000); //saying 5 secs spent during object creation due to complex process
		
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		//logic for deep copy
		NetworkConnection connection = new NetworkConnection();
		connection.setIp(this.getIp());
		connection.setImportantData(this.getImportantData());
		for(String d: this.getDomains()) {
			connection.getDomains().add(d);
		}
		return connection;
	}
}
