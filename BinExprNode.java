import java.util.ArrayList;
import java.util.List;

public class BinExprNode extends Node {

	private Node left;
	private String op;
	private Node right;
	
	public BinExprNode(int line, Node left, String op, Node right) {
		super(line);
		this.left = left;
		this.op = op;
		this.right = right;
	}

	@Override
	public Object eval(Env env) throws ParseException {
		Object lval = left.eval(env);
		Object rval = right.eval(env);

		
		if(lval instanceof ArrayFunction && rval instanceof ArrayFunction){
			List<Object> new_array = new ArrayList<Object>();
			ArrayFunction lleft = (ArrayFunction)lval;
			ArrayFunction rright = (ArrayFunction)rval;
			
			for (Object o : lleft.getArray())
				new_array.add(o);
			for (Object o : rright.getArray())
				new_array.add(o);
			
//			List<Object> larray = lleft.getArray();
//			List<Object> rarray = rright.getArray();
//			for (int i=0; i < larray.size(); i++)
//				new_array.add(larray.get(i));
//			for (int i=0; i < rarray.size(); i++)
//				new_array.add(rarray.get(i));

			if(op.equals("+"))
				return new ArrayFunction(new_array);
			throw new ParseException(op + " は未定義のオペレータです" + where());
		}
		else if(lval instanceof Integer && rval instanceof Integer){
			switch (op) {
				case "+":
					return (int)left.eval(env) + (int)right.eval(env);
				case "-":
					return (int)left.eval(env) - (int)right.eval(env);
				case "*":
					return (int)left.eval(env) * (int)right.eval(env);
				case "/":
					return (int)left.eval(env) / (int)right.eval(env);
				case "%":
					return (int)left.eval(env) % (int)right.eval(env);
				case "||":
					return (int)left.eval(env) != 0 || (int)right.eval(env) != 0 ? 1 : 0;
				case "&&":
					return (int)left.eval(env) == 1 && (int)right.eval(env) == 1 ? 1 : 0;
				case ">":
					return (int)left.eval(env) > (int)right.eval(env) ? 1 : 0;
				case "<":
					return (int)left.eval(env) < (int)right.eval(env) ? 1 : 0;
				case ">=":
					return (int)left.eval(env) >= (int)right.eval(env) ? 1 : 0;
				case "<=":
					return (int)left.eval(env) <= (int)right.eval(env) ? 1 : 0;
				case "==":
					return (int)left.eval(env) == (int)right.eval(env) ? 1 : 0;
				case "!=":
					return (int)left.eval(env) != (int)right.eval(env) ? 1 : 0;

				default:
					throw new ParseException(op + " は未定義のオペレータです" + where());
			}
		}
		
		String lstr = lval.toString();
		String rstr = rval.toString();
		if(op.equals("+"))
			return lstr + rstr;
		throw new ParseException(op + " は未定義のオペレータです" + where());
	}

	@Override
	public String toString() {
		// デバッグ用
		return "(" + left + " " + op + " " + right + ")";
	}

}
