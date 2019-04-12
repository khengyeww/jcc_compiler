import java.util.List;

public class Function {
	
	private Env outer;
	private List<String> params;
	private Node body;
	
	public Function(Env outer, List<String> params, Node body) {
		this.outer = outer;
		this.params = params;
		this.body = body;
	}
	
	public int arity() {
		return params.size();
	}
	
	public Object execFunc(List<Object> vals) throws ParseException {
		LocalEnv local = new LocalEnv();
		local.setOuter(outer);
		
		for (int i=0; i < params.size(); i++)
			local.put(params.get(i), vals.get(i));
		 
		return body.eval(local);
	}
	
	public Object execInit(List<Object> vals) throws ParseException {
		LocalEnv local = new LocalEnv();
		local.setOuter(outer);

		// System.out.println("check1");
		// System.out.println(local);
		// 最初の local（outerを継承した）
		// {} -> {re=0, im=0, ...}
		
		for (int i=0; i < params.size(); i++) 
			local.put(params.get(i), vals.get(i));

		// System.out.println("check2");
		// System.out.println(local);
		// for 分で put した local
		// {r=1, i=2} -> {re=0, im=0, ...}
		
		body.eval(local);
		
		// System.out.println("check3");
		// System.out.println(local);
		// body を evalした後の local
		// {r=1, i=2} -> {re=1, im=2, ...}

		QuartzObj quartzObj = new QuartzObj(local);

		return quartzObj;
	}
	
	public String evalClassString(LocalEnv inner) {
		try {
			return (String)body.eval(inner);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return "Not string!";
	}
	
	public String toString() {
		return "fun/" + arity();
	}
	
}
