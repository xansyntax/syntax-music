package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$Interval;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridInterval implements LazyLayoutIntervalContent$Interval {
    public final ComposableLambdaImpl item;
    public final Function1 key;
    public final Function2 span;
    public final Function1 type;

    public LazyGridInterval(Function1 function1, Function2 function2, Function1 function3, ComposableLambdaImpl composableLambdaImpl) {
        this.key = function1;
        this.span = function2;
        this.type = function3;
        this.item = composableLambdaImpl;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$Interval
    public final Function1 getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$Interval
    public final Function1 getType() {
        return this.type;
    }
}
