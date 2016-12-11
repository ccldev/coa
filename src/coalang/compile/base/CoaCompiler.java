package coalang.compile.base;

import coalang.compile.systems.annotation.EmptyAnnotationSystem;
import net.bplaced.opl.ccl.CompileSystems;

public class CoaCompiler {
	
	public static void setup(){
		CompileSystems.SNIPPET.add(new EmptyAnnotationSystem());
	}
	
}
