
public class CallArrayNode extends Node {
	
	private Node name;
	private Node req; // 要求された要素の番号
	
	public CallArrayNode(int line, Node name, Node req){
		super(line);
		this.name = name;
		this.req = req;
	}

	@Override
	public Object eval(Env env) throws ParseException {
		Object obj = name.eval(env);
		Object obj_req = req.eval(env);

		if (!(obj_req instanceof Integer))
			throw new ParseException(req + " は数字ではありません" + name.where());

		ArrayFunction arrayFunc = (ArrayFunction)obj;

		if (arrayFunc.arity() <= (int)obj_req)
			throw new ParseException(name + " は要素数が" + arrayFunc.arity() + "の配列です" + where());

		return arrayFunc.get((int)obj_req);
	}
	
	public String toString() {
		return name + "[" + req + "]";
	}

}
