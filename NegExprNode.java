
public class NegExprNode extends Node {

	private Node n;
	
	public NegExprNode(int line, Node n) {
		super(line);
		this.n = n;
	}
	
	@Override
	public Object eval(Env env) throws ParseException {
		return -(int)n.eval(env);
	}

	public String toString() {
		return "(-" + n + ")";
	}

}
