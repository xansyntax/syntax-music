package kotlin;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class UnsafeLazyImpl implements Lazy, Serializable {
    public Object _value;
    public Function0 initializer;

    private final void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @Override // kotlin.Lazy
    public final Object getValue() {
        Object obj = this._value;
        if (obj != UNINITIALIZED_VALUE.INSTANCE) {
            return obj;
        }
        Function0 function0 = this.initializer;
        function0.getClass();
        Object objInvoke = function0.invoke();
        this._value = objInvoke;
        this.initializer = null;
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
