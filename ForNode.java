
public class ForNode extends Node {

	private String name;
	private Node cond;
	private Node doBlock;
	
	public ForNode(int line, String name, Node cond, Node doBlock) {
		super(line);
		this.name = name;
		this.cond = cond;
		this.doBlock = doBlock;
	}

	@Override
	public Object eval(Env env) throws ParseException {
		Object obj = cond.eval(env);
		ArrayFunction array = (ArrayFunction)obj;
		
		//List<Object> list = new ArrayList<Object>();
		
		Object condition = 0;
		for (int i=0; i < array.getArray().size(); i++) {
			env.put(name, array.get(i));
			condition = doBlock.eval(env);
		}
		
		return condition;
	}

	public String toString() {
		return "for " + name + " in " + cond + " do " + doBlock + " end";
	}
	
}
