package androidx.compose.animation.core;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TwoWayConverterImpl {
    public final Function1 convertFromVector;
    public final Function1 convertToVector;

    public TwoWayConverterImpl(Function1 function1, Function1 function2) {
        this.convertToVector = function1;
        this.convertFromVector = function2;
    }
}
