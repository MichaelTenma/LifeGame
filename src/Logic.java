
public abstract class Logic {

	private int getNeighbours(int x,int y,Map map){
		
		int miniRow = 3;
		int miniCol = 3;
		int num = 0;
		int h = y -1;
		int w = x -1;
		//消去目标为存活对最终数值的影响
		{
			Data tempData = map.get(x, y);
			if(tempData != null){
				if(tempData.isLive()){
					num = -1;
				}
			}
		}

		for(int j = 0; j < miniRow;j++){
			for(int k = 0; k < miniCol;k++){
				Data data = map.get(w, h);
				if(data != null){
					if(data.isLive()){
						num++;
					}
				}
				w++;
			}
			/* 归零,清除前面累加操作的影响 */
			w -= miniCol;
			h++;
		}
		return num;
	}

	/** 判断是否该死的逻辑，num为以该点为中心方圆一格活细胞的数量*/
	public abstract boolean isToLive(int num,Data data);
	
	public Map deal(Map map){
		for(int y = 0; y < map.row;y++){
			for(int x = 0; x < map.col;x++){
				int num = this.getNeighbours(x, y,map);
				boolean isLive = this.isToLive(num,map.get(x, y));
				Data target = new Data(isLive);
				map.set(x, y, target);
			}
		}
		return map;
	}

}
