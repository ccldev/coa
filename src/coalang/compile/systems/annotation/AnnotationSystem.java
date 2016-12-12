package coalang.compile.systems.annotation;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.bplaced.opl.ccl.CompileSystem;
import net.bplaced.opl.ccl.cat.CclCodeSnippet;
import ccl.v2_1.err.DebugException;
import ccl.v2_1.err.ImplementationException;
import coalang.compile.model.CoaAnnotation;
import coalang.compile.model.CoaStatus;

public class AnnotationSystem implements
		CompileSystem<CclCodeSnippet, File> {
	
	public static Pattern ANNOT_PATTERN = Pattern.compile
			("\\s*@\\s*([a-zA-Z0-9_]+)\\s*\\((.*)\\);");
	
	@Override
	public boolean accept(CclCodeSnippet infos) {
		return ANNOT_PATTERN.matcher(infos.getRaw()).matches();
	}

	@Override
	public String compileComplete(CclCodeSnippet infos)
			throws ImplementationException, DebugException, IOException {
		Matcher m = ANNOT_PATTERN.matcher(infos.getRaw());
		m.matches();
		CoaStatus.addAnnotation(new CoaAnnotation(m.group(1), m.group(2)));
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
