
public class Map {
	/** @param row ��ͼ���������  */
	public int row = 0;
	/** @param col ��ͼ���������  */
	public int col = 0;
	/** @param data ��ͼ���е�λ����Ϣ,��ʱʹ�ö�ά���鱣��  */	
	private Data[][] data = null;
	
	/**
	 * ��ʼ�����е�ͼ��Ϣ�ĵ�ͼ
	 * @param row ������������
	 * @param col ������������
	 * @param data ����ʼ��ʹ�õĵ�ͼ����
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
	 * ��ʼ��ΪĬ�ϵ�ͼ
	 * @param row ������������
	 * @param col ������������
	 */
	public Map(int row,int col){
		this.row = row;
		this.col = col;
		this.data = new Data[row][col];
		for(int y = 0;y < row;y++){
			for(int x = 0;x < col;x++){
				//��������Ĭ�ϵ�data
				this.set(x, y, new Data());
			}
		}
	}
	
	/**
	 * �����ж�ָ��λ���Ƿ���Data[][] data�У�����Խ�����
	 * @param x ����λ��
	 * @param y ����λ��
	 * @return boolean true������λ�úϷ���false������λ�÷Ƿ�
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
	 * �ӵ�ͼ�л�ȡָ��λ�õ�data
	 * @param x ����λ��
	 * @param y ����λ��
	 * @return Data ���ص���data
	 */
	public Data get(int x,int y){
		Data res = null;
		if(isLegalLocation(x, y)){
			res = this.data[y][x];
		}
		return res;
	}
	
	/**
	 * �޸�ָ��λ�õĵ�ͼ����
	 * @param x ����λ��
	 * @param y ����λ��
	 * @param target �޸�Ϊ�ĵ�ͼ����
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
