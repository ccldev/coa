package coalang.compile.base;

import coalang.compile.systems.annotation.AnnotationSystem;
import coalang.compile.systems.annotation.EmptyAnnotationSystem;
import coalang.compile.systems.handle.CatchSystem;
import net.bplaced.opl.ccl.CompileSystems;

public class CoaCompiler {
	
	public static void setup(){
		CompileSystems.SNIPPET.add(new EmptyAnnotationSystem());
		CompileSystems.SNIPPET.add(new AnnotationSystem());
		
		CompileSystems.BLOCK.add(new CatchSystem());
	}
	
}
