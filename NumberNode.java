
public class NumberNode extends Node {

	private int num;
	private String image;
	
	public NumberNode(int beginLine, String image) {
		// 先生のやつは入れてない
		//super(beginLine);
		this.image = image;
		num = Integer.parseInt(image);
	}

	@Override
	public Object eval(Env env) throws ParseException {
		return num;
	}

	public String toString() {
		//return String.valueOf(num);
		return image;
	}
	
}
