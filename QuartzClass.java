import java.util.*;

public class QuartzClass {

	private List<Node> members;
	
	public QuartzClass(List<Node> members) {
		this.members = members;
	}
	
	public QuartzObj create(Env env) throws ParseException {
		LocalEnv local = new LocalEnv();
		local.setOuter(env);
		
		for(Node each : members)
			each.eval(local);

		QuartzObj obj = new QuartzObj(local);

		return obj;
	}
	
	public List<Node> members() {
		return members;
	}
	
	public String toString() {
		return "QuartzClass " + members + " end";
	}
	
}
