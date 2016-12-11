package coalang.compile.error;

import coalang.compile.model.CoaAnnotation;
import ccl.v2_1.err.DebugException;

public class AnnotationDuplicationException extends DebugException {
	
	public AnnotationDuplicationException(CoaAnnotation a){
		super(a.toString());
	}
	
	private static final long serialVersionUID = -6013214229188649693L;

}
