package androidx.compose.foundation.lazy.layout;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface LazyLayoutIntervalContent$Interval {
    Function1 getKey();

    default Function1 getType() {
        return LazyLayoutIntervalContent$Interval$type$1.INSTANCE;
    }
}
