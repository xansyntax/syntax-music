package kotlinx.serialization.json.internal;

import kotlin.Result;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ArrayPoolsKt {
    public static final int MAX_CHARS_IN_POOL;

    static {
        Object failure;
        try {
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            failure = property != null ? StringsKt__StringsJVMKt.toIntOrNull(10, property) : null;
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        Integer num = (Integer) (failure instanceof Result.Failure ? null : failure);
        MAX_CHARS_IN_POOL = num != null ? num.intValue() : 2097152;
    }
}
