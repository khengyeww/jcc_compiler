
public class QuartzObj {
	
	private LocalEnv inner;
	
	public QuartzObj(LocalEnv inner) {
		this.inner = inner;
	}
	
	public Env env() {
		return inner;
	}
	
	public String getClassString() {
		if(inner.containsKey("to_s")) {
			Function func = (Function)inner.get("to_s");
			
			return func.evalClassString(inner);
		}
		
		return "QuartzObj object: " + inner.toString().replaceAll("^.|.$", "");
	}
	
	public String toString() {
		return getClassString();
	}
	
}
