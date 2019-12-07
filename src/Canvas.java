import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Canvas extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	private int width = 0;
//	private int height = 0;
	private int row = 0;
	private int col = 0;
	
	private int divWidth = 0;
	private int divHeight = 0;
	
	private Map map = null;
	
	/**
	 * Create the panel.
	 */
	public Canvas(int width,int height,int row,int col) {
		
//		this.width = width;
//		this.height = height;
		this.row = row;
		this.col = col;
		
		this.divWidth = width/col;
		System.out.println("this.divWidth:" + this.divWidth);
		this.divHeight = height/row;
		System.out.println("this.divHeight:" + this.divHeight);
		
		this.addMouseListener(new ActionDeal(this.divWidth,this.divHeight));
	}
	

	public void setMap(Map map){
		this.map = map;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		
		for(int x = 0;x < this.col;x++){
			for(int y = 0; y < this.row;y++){
				Color color = Color.GRAY;/* 标准灰 */
				if(this.map != null){
					Data data = this.map.get(x, y);
					if(data != null){
						if(data.isLive()){
							color = new Color(0xCCFFCC);//设置画图的颜色
						}
					}
				}
				g2d.setColor(color);
				g2d.fill3DRect(x*this.divWidth, y*this.divHeight, this.divWidth, this.divHeight, true);//填充一个矩形
			}
		}
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.repaint();
	}

}
