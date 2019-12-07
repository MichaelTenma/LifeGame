
public class Map {
	/** @param row 地图的最大行数  */
	public int row = 0;
	/** @param col 地图的最大列数  */
	public int col = 0;
	/** @param data 地图所有的位置信息,暂时使用二维数组保存  */	
	private Data[][] data = null;
	
	/**
	 * 初始化带有地图信息的地图
	 * @param row 允许的最大行数
	 * @param col 允许的最大列数
	 * @param data 供初始化使用的地图数据
	 */
	public Map(int row,int col,int initX,int initY,Data[][] data){
		this(row,col);
		
		System.out.println("data[]:" + data.length);
		System.out.println("data[][]:" + data[1].length);
		
		for(int y = 0;y < data.length;y++){
			for(int x = 0;x < data[y].length;x++){
				this.set(initX + x, initY + y, data[y][x]);
			}
		}
		
	}
	
	/**
	 * 初始化为默认地图
	 * @param row 允许的最大行数
	 * @param col 允许的最大列数
	 */
	public Map(int row,int col){
		this.row = row;
		this.col = col;
		this.data = new Data[row][col];
		for(int y = 0;y < row;y++){
			for(int x = 0;x < col;x++){
				//依次填入默认的data
				this.set(x, y, new Data());
			}
		}
	}
	
	/**
	 * 用于判断指定位置是否在Data[][] data中，避免越界操作
	 * @param x 横轴位置
	 * @param y 纵轴位置
	 * @return boolean true表明该位置合法，false表明该位置非法
	 */
	private boolean isLegalLocation(int x,int y){
		boolean res = false;
		if(x >= 0 && x < this.col){
			if(y >= 0 && y < this.row){
				res = true;
			}
		}
		return res;
	}

	/**
	 * 从地图中获取指定位置的data
	 * @param x 横轴位置
	 * @param y 纵轴位置
	 * @return Data 返回单个data
	 */
	public Data get(int x,int y){
		Data res = null;
		if(isLegalLocation(x, y)){
			res = this.data[y][x];
		}
		return res;
	}
	
	/**
	 * 修改指定位置的地图数据
	 * @param x 横轴位置
	 * @param y 纵轴位置
	 * @param target 修改为的地图数据
	 */
	public void set(int x,int y,Data target){
		this.data[y][x] = target;
	}
	
	public String toString(){
		StringBuffer str = new StringBuffer();
		str.append("Map row:" + this.row + "\n");
		str.append("Map col:" + this.col + "\n");
		for(int y = 0;y < this.row;y++){
			for(int x = 0;x < this.col;x++){
				Data data = this.get(x, y);
				boolean value = false;
				if(data != null){
					value = data.isLive();
				}
				
				str.append(value?1:0);
				str.append(" ");
			}
			str.append("\n");
		}
		return str.toString();
	}
	
}
