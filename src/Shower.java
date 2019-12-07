
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Shower extends JFrame implements Viewer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Canvas contentPane;

	/**
	 * 
	 * Create the frame.
	 */
	public Shower(int row,int col) {
		super("Ï¸°û×Ô¶¯»ú");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 650);
		
		contentPane = new Canvas(this.getWidth()-30,this.getHeight()-50,row,col);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}

	@Override
	public void show(Map map) {
		contentPane.setMap(map);
//		System.out.print(map.toString());
	}
}
