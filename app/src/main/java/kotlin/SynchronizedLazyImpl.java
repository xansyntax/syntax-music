package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class SynchronizedLazyImpl implements Lazy, Serializable {
    public Function0 initializer;
    public volatile Object _value = UNINITIALIZED_VALUE.INSTANCE;
    public final Object lock = this;

    public SynchronizedLazyImpl(Function0 function0) {
        this.initializer = function0;
    }

    @Override // kotlin.Lazy
    public final Object getValue() {
        Object objInvoke;
        Object obj = this._value;
        UNINITIALIZED_VALUE uninitialized_value = UNINITIALIZED_VALUE.INSTANCE;
        if (obj != uninitialized_value) {
            return obj;
        }
        synchronized (this.lock) {
            objInvoke = this._value;
            if (objInvoke == uninitialized_value) {
                Function0 function0 = this.initializer;
                function0.getClass();
                objInvoke = function0.invoke();
                this._value = objInvoke;
                this.initializer = null;
            }
        }
        return objInvoke;
    }

    @Override // kotlin.Lazy
    public final boolean isInitialized() {
        return this._value != UNINITIALIZED_VALUE.INSTANCE;
    }

    public final String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
