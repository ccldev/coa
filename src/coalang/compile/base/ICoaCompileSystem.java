package coalang.compile.base;

import java.io.IOException;

import coalang.compile.model.CoaInfos;

import ccl.v2_1.err.DebugException;
import ccl.v2_1.err.ImplementationException;

public interface ICoaCompileSystem<I> {
	
	boolean matches(I infos);
	String compileComplete(CoaInfos<I> infos) throws ImplementationException,
			DebugException, IOException;
	
}
