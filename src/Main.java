
public class Main {

	public static void main(String[] args) {
		Manager manager = new Manager(70,100,CommonMapData.zero);
		/**
		 * Launch the application.
		 */
		Thread thread = new Thread(manager);
		thread.start();
	}

}
