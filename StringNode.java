
public class StringNode extends Node {

	private String string;
	
	public StringNode(int line, String string) {
		super(line);
		this.string = string;
	}
	
	@Override
	public Object eval(Env env) throws ParseException {
		return string.substring(1, string.length() - 1);
	}

	public String toString() {
		return string;
	}
	
}
