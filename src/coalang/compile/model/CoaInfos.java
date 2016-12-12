package coalang.compile.model;

public class CoaInfos<I> {
	
	private I raw;
	private CoaAnnotation[] annotations;

	public CoaInfos(I raw){
		this.raw = raw;
		this.annotations = CoaStatus.clearAnnotations();
	}
	
	public I getRaw(){
		return raw;
	}
	public CoaAnnotation[] getAnnotations(){
		return annotations;
	}
	public CoaAnnotation findAnnotation(String name){
		for(int i = 0; i < annotations.length; i++){
			CoaAnnotation a = annotations[i];
			if(a.getName().equals(name)){
				return a;
			}
		}
		return null;
	}
	
}
