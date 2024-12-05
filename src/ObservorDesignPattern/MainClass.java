package ObservorDesignPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Subject channel = new YoutubeChannel();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press 1 to upload video");
			System.out.println("Press 2 to subscribe");
			System.out.println("Press 3 to unsubscribe");
			System.out.println("Press 4 to exit");
			
			int c = Integer.parseInt(br.readLine());
			if(c==1) {
				System.out.println("Enter video title: ");
				String title = br.readLine();
				channel.newVideoUploaded(title);
			}
			else if(c==2) {
				System.out.println("Enter Subscriber name: ");
				String name = br.readLine();
				Observer subs = new Subscriber(name);
				channel.subscribe(subs);
			}
			else if(c==3) {
				System.out.println("Unsubscribe not yet implemented");
			}
			else if(c==4) {
				System.out.println("Thank you for using the app");
				break;
				
			}
			else {
				System.out.println("wrong input");
			}
			
		}
		

	}

}
