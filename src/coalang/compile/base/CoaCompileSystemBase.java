package coalang.compile.base;

import java.io.IOException;

import coalang.compile.model.CoaInfos;

import ccl.v2_1.err.DebugException;
import ccl.v2_1.err.ImplementationException;
import net.bplaced.opl.ccl.CompileSystem;

public class CoaCompileSystemBase<I, O> implements CompileSystem<I, O> {
	
	ICoaCompileSystem<I> impl;

	public CoaCompileSystemBase(ICoaCompileSystem<I> impl){
		this.impl = impl;
	}
	
	@Override
	public final boolean accept(I infos) {
		return impl.matches(infos);
	}

	@Override
	public final String compileComplete(I infos) throws ImplementationException,
			DebugException, IOException {
		return impl.compileComplete(new CoaInfos<I>(infos));
	}

	@Override
	public O getOutput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String include() {
		// TODO Auto-generated method stub
		return null;
	}

}
