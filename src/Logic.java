
public abstract class Logic {

	private int getNeighbours(int x,int y,Map map){
		
		int miniRow = 3;
		int miniCol = 3;
		int num = 0;
		int h = y -1;
		int w = x -1;
		//��ȥĿ��Ϊ����������ֵ��Ӱ��
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
			/* ����,���ǰ���ۼӲ�����Ӱ�� */
			w -= miniCol;
			h++;
		}
		return num;
	}

	/** �ж��Ƿ�������߼���numΪ�Ըõ�Ϊ���ķ�Բһ���ϸ��������*/
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
