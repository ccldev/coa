package coalang.compile.base;

public abstract class CoaCompileSystem<I,O> extends CoaCompileSystemBase<I,O> implements ICoaCompileSystem<I>{

	public CoaCompileSystem() {
		super(null);
		impl = this;
	}

}
