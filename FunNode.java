import java.util.List;

public class FunNode extends Node {

	private List<String> params;
	private Node body;
	
	public FunNode(int line, List<String> params, Node body) {
		super(line);
		this.params = params;
		this.body = body;
	}
	
	@Override
	public Object eval(Env env) throws ParseException {
		return new Function(env, params, body);
	}
	
	public String toString() {
		return "fun(" + params.toString().replaceAll("^.|.$", "") + ") {" + body + "}";
	}

}
