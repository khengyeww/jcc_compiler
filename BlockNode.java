import java.util.List;
import java.util.StringJoiner;

public class BlockNode extends Node {

	private List<Node> nodes;
	
	public BlockNode(List<Node> nodes) {
		this.nodes = nodes;
	}
	
	@Override
	public Object eval(Env env) throws ParseException {
		Object result = 0;
		for (Node node : nodes)
			result = node.eval(env);
		return result;
	}

	public String toString() {
		StringJoiner s = new StringJoiner(" ");
		for (Node node : nodes)
			s.add(node.toString());
		return "(" + s.toString() + ")";
	}
	
}
