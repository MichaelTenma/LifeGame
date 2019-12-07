import java.util.ArrayList;

public class Manager implements Runnable{
	private Shower shower = null;
	private Logic logic = null;
	private Map map = null;
	
	
	private static ArrayList<Manager> list = new ArrayList<Manager>();
	
	public  boolean isRun = false;
	public int interval = 1000;//million second
	private int row = 0;
	private int col = 0;
	
	public static Manager getInStance(int index){
		return Manager.list.get(index);
	}
	
	public Manager(int row,int col,String mapData){
		this.row = row;
		this.col = col;
		
		/* 初始化地图  */
		Data[][] dataArray = this.toMapData(11, 11, mapData);
		/* 注意越界情况的发生 */
		this.map = new Map(this.row, this.col,40,30,dataArray);
		
		this.logic = new Logic(){
			@Override
			public boolean isToLive(int num,Data data){
				boolean res = false;
				if(num == 2){
					res = data.isLive();
				}else if(num == 3){
					res = true;
				}
				return res;
			}
		};
		
		Manager.list.add(this);
		
	}
	
	@Override
	public void run() {
		this.shower = new Shower(this.row,this.col);
		this.shower.setVisible(true);
		while(true){
			this.shower.show(this.map);
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(this.isRun){
				this.logic.deal(this.map);
			}
		}
	}
	
	private Data[][] toMapData(int row,int col,String mapData){
		/* 根据String载入地图数据 */
		StringBuffer strBuffer = new StringBuffer(mapData);
		Data dataArray[][] = new Data[row][col];
		{
			int j = 0;
			for(int i = 0;i < row;i++){
				for(int k = 0;k < col;k++){
					dataArray[i][k] = Data.load(strBuffer.charAt(j));
					if(j < strBuffer.length()){
						j++;
					}
				}
			}
		}
		return dataArray;
	}

	public void editMap(int x, int y, Data data) {
		this.map.set(x, y, data);
	}
	public void reset(){
		this.map = new Map(this.row, this.col);
	}

}
