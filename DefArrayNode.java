import java.util.*;

public class DefArrayNode extends Node {

	private List<Node> body;
	
	public DefArrayNode(int line, List<Node> body) {
		super(line);
		this.body = body;
	}
	
	@Override
	public Object eval(Env env) throws ParseException {
		//return new ArrayFunction(env, body);
		
		List<Object> es = new ArrayList<Object>();
		
		for (Node n : body)
			es.add(n.eval(env));
		
		return new ArrayFunction(es);
	}

	public String toString() {
		return "[" + body.toString().replaceAll("^.|.$", "") + "]";
	}
}
