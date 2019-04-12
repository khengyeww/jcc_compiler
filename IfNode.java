
public class IfNode extends Node {

	private Node cond;
	private Node thenBlock;
	private Node elseBlock;
	
	public IfNode(int line, Node cond, Node thenBlock, Node elseBlock) {
		super(line);
		this.cond = cond;
		this.thenBlock = thenBlock;
		this.elseBlock = elseBlock;
	}
	
	public Object eval(Env env) throws ParseException {
		if ((int)cond.eval(env) != 0)
			return thenBlock.eval(env);
		else if (elseBlock != null)
			return elseBlock.eval(env);
		return 0;
	}
	
	public String toString() {
		if (elseBlock == null)
			return "if " + cond + " then " + thenBlock + " end";
		else
			return "if " + cond + " then " + thenBlock + " else " + elseBlock + " end";
	}
	
}
