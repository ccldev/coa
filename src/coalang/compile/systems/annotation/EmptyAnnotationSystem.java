package coalang.compile.systems.annotation;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import coalang.compile.model.CoaAnnotation;
import coalang.compile.model.CoaStatus;

import ccl.v2_1.err.DebugException;
import ccl.v2_1.err.ImplementationException;

import net.bplaced.opl.ccl.CompileSystem;
import net.bplaced.opl.ccl.cat.CclCodeSnippet;

public class EmptyAnnotationSystem implements
		CompileSystem<CclCodeSnippet, File> {

	public static Pattern EANNOT_PATTERN = Pattern.compile
			("\\s*@\\s*([a-zA-Z0-9_]+)\\s*;");
	
	@Override
	public boolean accept(CclCodeSnippet infos) {
		return EANNOT_PATTERN.matcher(infos.getRaw()).matches();
	}

	@Override
	public String compileComplete(CclCodeSnippet infos)
			throws ImplementationException, DebugException, IOException {
		Matcher m = EANNOT_PATTERN.matcher(infos.getRaw());
		m.matches();
		CoaStatus.addAnnotation(new CoaAnnotation(m.group(1)));
		return "";
	}

	@Override
	public File getOutput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String include() {
		// TODO Auto-generated method stub
		return null;
	}

}
