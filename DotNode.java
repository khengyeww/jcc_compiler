
public class DotNode extends Node {

	private Node left;
	private String right;
	
	public DotNode(int line, Node left, String right) {
		super(line);
		this.left = left;
		this.right = right;
	}
	
	@Override
	public Object eval(Env env) throws ParseException {
		Object lval = left.eval(env);
		
		if(lval instanceof QuartzClass && right.equals("new")) {
			QuartzClass quartzClass = (QuartzClass)lval;

			QuartzObj quartzObj = quartzClass.create(env);

			return quartzObj;
		}
		else if(lval instanceof QuartzObj) {
			QuartzObj quartzObj = (QuartzObj)lval;

			Env inner = quartzObj.env();

			return inner.get(right);
		}
		
		throw new ParseException(lval + " は未定義の関数です" + left.where());
	}
	
	public String toString() {
		return left + "." + right;
	}

}
