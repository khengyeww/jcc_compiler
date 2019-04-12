
public abstract class Node {

	private int line;
	private final int UNKNOWN_LINE = -1;
	
	public Node(int line) {
		this.line = line;
	}
	
	public Node() {
		this.line = UNKNOWN_LINE;
	}
	
	public abstract Object eval(Env env) throws ParseException;
	
	public int line() {
		return line;
	}
	
	public String where() {
		if (line == UNKNOWN_LINE)
			return " at unknown line";
		return " at line " + line;
	}
	
}
