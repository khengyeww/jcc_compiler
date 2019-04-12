import java.util.*;

public class ArrayFunction {

	private List<Object> array;
	
	public ArrayFunction(List<Object> es) {
		this.array = es;
	}
	
	public int arity() {
		return array.size();
	}
	
	public Object get(int val) {
		return array.get(val);
	}
	
	public List<Object> getArray() {
		return array;
	}
	
	public String toString() {
		return array.toString();
	}
	
}
