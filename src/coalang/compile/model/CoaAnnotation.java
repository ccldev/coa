package coalang.compile.model;

public class CoaAnnotation {
	
	private String name;
	private String value;
	
	public CoaAnnotation(String name){
		this.name = name;
	}
	public CoaAnnotation(String name, String value){
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	public String getValue() {
		return value;
	}
	
	public boolean isEmpty(){
		return value == null;
	}
	@Override
	public String toString() {
		return "CoaAnnotation [name=" + name + ", value=" + value
				+ ", isEmpty()=" + isEmpty() + "]";
	}
	
}
