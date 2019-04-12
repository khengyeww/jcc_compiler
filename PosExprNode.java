
public class PosExprNode extends Node {

	private Node n;
	
	public PosExprNode(int line, Node n) {
		super(line);
		this.n = n;
	}
	
	@Override
	public Object eval(Env env) throws ParseException {
		return n.eval(env);
	}

	public String toString() {
		return "(+" + n + ")";
	}

}
