import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ActionDeal implements MouseListener {

	private int divWidth = 0;
	private int divHeight = 0;
	
	public ActionDeal(int divWidth,int divHeight){
		this.divWidth = divWidth;
		this.divHeight = divHeight;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Manager manager = Manager.getInStance(0);
		int clickTimes = e.getClickCount();
		if(clickTimes == 1 && !manager.isRun){
			
			Point res = this.evaluatePoint(e.getX(), e.getY());
			/* »ñµÃmanager */
			boolean value = false;
			if(e.getButton() == MouseEvent.BUTTON1){
				value = true;
			}
			Data data = new Data(value);
			System.out.printf("%d %d  (%d,%d)\n",this.divWidth,this.divHeight,e.getX(),e.getY());
			System.out.println(res.toString());
			manager.editMap((int)res.getX(),(int)res.getY(),data);
			
		}else if (clickTimes == 2) {
			if(e.getButton() == MouseEvent.BUTTON1){
				manager.isRun = !manager.isRun;
				if(manager.isRun){
					manager.interval = 50;
				}else{
					manager.interval = 1000;
				}
			}else if(e.getButton() == MouseEvent.BUTTON3){
				manager.reset();
			}

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	private Point evaluatePoint(int focusX,int focusY){
		int x = focusX/this.divWidth;
		int y = focusY/this.divHeight;
		return (new Point(x,y));
	}

}
