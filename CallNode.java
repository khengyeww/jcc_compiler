import java.util.*;

public class CallNode extends Node {
	
	private Node name;
	private List<Node> args;
	
	public CallNode(int line, Node name, List<Node> args){
		super(line);
		this.name = name;
		this.args = args;
	}

	@Override
	public Object eval(Env env) throws ParseException {
		Object obj = name.eval(env);

		if(obj instanceof Function) {
			Function func = (Function)obj;
			
			List<Object> vals = new ArrayList<Object>();
			for (Node arg : args)
				vals.add(arg.eval(env));

			if (func.arity() != vals.size())
				throw new ParseException(name + " は" + func.arity() + "引数の関数です" + where());

			return func.execFunc(vals);
		}
		else if(obj instanceof QuartzObj) {
			QuartzObj quartzObj = (QuartzObj)obj;

			Env inner = quartzObj.env();
			
			Function func = (Function)inner.get("initialize");

			List<Object> vals = new ArrayList<Object>();
			for (Node arg : args)
				vals.add(arg.eval(env));

			return (QuartzObj)func.execInit(vals);
		}

		throw new ParseException(obj + " は未定義の関数です" + name.where());
	}
	
	public String toString() {
		return name + "(" + args.toString().replaceAll("^.|.$", "") + ")";
	}

}
