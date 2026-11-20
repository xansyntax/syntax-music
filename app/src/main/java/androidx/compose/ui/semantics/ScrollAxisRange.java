package androidx.compose.ui.semantics;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollAxisRange {
    public final Function0 maxValue;
    public final Function0 value;

    public ScrollAxisRange(Function0 function0, Function0 function1) {
        this.value = function0;
        this.maxValue = function1;
    }

    public final String toString() {
        return "ScrollAxisRange(value=" + this.value.invoke() + ", maxValue=" + this.maxValue.invoke() + ", reverseScrolling=false)";
    }
}
