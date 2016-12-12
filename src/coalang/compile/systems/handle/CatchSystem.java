package coalang.compile.systems.handle;

import java.io.File;
import java.io.IOException;

import net.bplaced.opl.ccl.cat.CclCodeBlock;

import ccl.v2_1.code.CclCodePart;
import ccl.v2_1.err.DebugException;
import ccl.v2_1.err.ImplementationException;
import coalang.compile.base.CoaCompileSystem;
import coalang.compile.model.CoaAnnotation;
import coalang.compile.model.CoaInfos;

public class CatchSystem extends CoaCompileSystem<CclCodeBlock, File>{

	@Override
	public boolean matches(CclCodeBlock infos) {
		if(infos.getKeyword() == null){
			return false;
		}
		return infos.getKeyword().equals("catch");
	}

	@Override
	public String compileComplete(CoaInfos<CclCodeBlock> infos)
			throws ImplementationException, DebugException, IOException {
		StringBuilder b = new StringBuilder();
		
		String toHandle = "\"error\"";
		
		CoaAnnotation handleAnnot = infos.findAnnotation("handle");
		if(handleAnnot != null){
			if(!handleAnnot.isEmpty()){
				toHandle = handleAnnot.getValue();
			}
		}
		
		b.append("if(");
		b.append(infos.getRaw().getCondition());
		b.append(".type==");
		b.append(toHandle);
		b.append("){");
		b.append(infos.getRaw().getContent());
		b.append("}");
		
		return new CclCodePart(b.toString())
			.compile(infos.getRaw().getFollowing());
	}

}
