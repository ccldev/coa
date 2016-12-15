package coalang.runtime.scripting.support.nashorn;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import ccl.rt.Expression;
import ccl.rt.Value;
import ccl.rt.use.Func;

public class NashornValueWrapper implements Func<Object, Value> {

	@Override
	public Value call(Object p) {
		if(p instanceof ScriptObjectMirror){
			ScriptObjectMirror m = (ScriptObjectMirror) p;
			return new NashornMirrorValue(m);
		}
		return new Expression(p);
	}

}
