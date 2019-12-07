
public class Data {
	/** @param value 该位置是否存活 */
	private boolean value = false;
	
	/**
	 * 初始化
	 * @param value 该位置是否存活 
	 */
	public Data(boolean value){
		this.value = value;
	}
	
	/** 初始化默认data，默认为不存活 */
	public Data(){
		this(false);
	}
	
	/**
	 * 判断自身是否可以存活
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
