
public class Data {
	/** @param value ��λ���Ƿ��� */
	private boolean value = false;
	
	/**
	 * ��ʼ��
	 * @param value ��λ���Ƿ��� 
	 */
	public Data(boolean value){
		this.value = value;
	}
	
	/** ��ʼ��Ĭ��data��Ĭ��Ϊ����� */
	public Data(){
		this(false);
	}
	
	/**
	 * �ж������Ƿ���Դ��
	 * @return boolean
	 */
	public boolean isLive(){
		return this.value;
	}

	public static Data load(char value) {
		boolean res = false;
		if(value == '1'){
			res = true;
		}
		return (new Data(res));
	}
}
