
public class AssignNode extends Node {

	private NameNode var;
	private Node val;
	
	public AssignNode(int line, NameNode var, Node val) {
		super(line);
		this.var = var;
		this.val = val;
	}
	
	public Object eval(Env env) throws ParseException {
		String name = var.name();
		Object res = val.eval(env);
		
		env.put(name, res);
		
		return res;
	}
	
	public String toString() {
		return "(" + var + " = " + val + ")";
	}
	
}
