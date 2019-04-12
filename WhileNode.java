
public class WhileNode extends Node {

	private Node cond;
	private Node doBlock;
	
	public WhileNode(int line, Node cond, Node doBlock) {
		super(line);
		this.cond = cond;
		this.doBlock = doBlock;
	}
	
	public Object eval(Env env) throws ParseException {
		int condition = 0;
		
		while ((int)cond.eval(env) != 0)
			condition = (int)doBlock.eval(env);

		/*
		while ((int)cond.eval(env) != 0){
			(int)doBlock.eval(env);
			condition++;
		}
		*/
		
		return condition;
	}
	
	public String toString() {
		return "while " + cond + " do " + doBlock + " end";
	}

}
