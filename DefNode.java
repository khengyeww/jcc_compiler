import java.util.List;

public class DefNode extends Node {

	private String name;
	private List<String> params;
	private Node body;
	
	public DefNode(int line, String name, List<String> params, Node body) {
		super(line);
		this.name = name;
		this.params = params;
		this.body = body;
	}
	
	@Override
	public Object eval(Env env) throws ParseException {
		return env.put(name, new Function(env, params, body));
	}
	
	public String toString() {
		return "def " + name + "(" + params.toString().replaceAll("^.|.$", "") + ")" + body + " end";
	}
	
}
