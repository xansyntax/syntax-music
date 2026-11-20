package androidx.compose.foundation;

import androidx.compose.ui.MotionDurationScale;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FixedMotionDurationScale implements MotionDurationScale {
    public static final FixedMotionDurationScale INSTANCE = new FixedMotionDurationScale();

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return function2.invoke(obj, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        return StringsKt__IndentKt.get(this, key);
    }

    @Override // androidx.compose.ui.MotionDurationScale
    public final float getScaleFactor() {
        return 1.0f;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return StringsKt__IndentKt.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return StringsKt__IndentKt.plus(this, coroutineContext);
    }
}
