package coalang.compile.model;

import java.util.ArrayList;
import java.util.List;

import coalang.compile.error.AnnotationDuplicationException;

public class CoaStatus {
	
	static{
		currentAnnotations = new ArrayList<CoaAnnotation>();
		annotationNames = new ArrayList<String>();
	}
	
	private static List<CoaAnnotation> currentAnnotations;
	private static List<String> annotationNames;
	
	public static void addAnnotation(CoaAnnotation a) throws AnnotationDuplicationException{
		String name = a.getName();
		if(annotationNames.contains(name)){
			throw new AnnotationDuplicationException(a);
		}else{
			currentAnnotations.add(a);
			annotationNames.add(name);
		}
	}
	public static CoaAnnotation findAnnotation(String name){
		int index = annotationNames.indexOf(name);
		if(index < 0){
			return null;
		}else{
			return currentAnnotations.get(index);
		}
	}
	static CoaAnnotation[] clearAnnotations(){
		annotationNames.clear();
		CoaAnnotation[] ret = currentAnnotations.toArray(new CoaAnnotation[0]);
		currentAnnotations.clear();
		return ret;
	}
	
}
