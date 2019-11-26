package functional.programming;

import java.util.function.Consumer;

public class Try {

	Tryable tryable;
	Consumer<Exception> onFail;
	Consumer<Void> onFinish;

	public static Try of(Tryable t) {
		Try tr = new Try();
		tr.tryable = t;
		return tr;
	}

	public Try onFailure(Consumer<Exception> onFail) {
		this.onFail = onFail;
		System.out.println("ejecuto onFailure");
		return this;
	}

	public Try onComplete(Consumer<Void> onFinish) {
		this.onFinish = onFinish;
		System.out.println("ejecuto onComplete");
		return this;
	}

	public void tryIt() {
		try {
			tryable.tryIt();
			System.out.println("ejecuto tryIt");
		} catch (Exception e) {
			onFail.accept(e);
		} finally {
			onFinish.accept(null);
		}
	}
}
