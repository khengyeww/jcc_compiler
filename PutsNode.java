
public class PutsNode extends Node {

	private Node param;
	
	public PutsNode(int line, Node param) {
		super(line);
		this.param = param;
	}
	
	@Override
	public Object eval(Env env) throws ParseException {
		Object val = param.eval(env).toString();
		System.out.println(val);
		return val;
	}

	public String toString() {
		return "puts " + param;
	}
	
}
