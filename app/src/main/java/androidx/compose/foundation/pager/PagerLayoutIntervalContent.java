package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PagerLayoutIntervalContent extends LazyLayoutKt {
    public final StatusLine intervals;
    public final Function1 key;

    public PagerLayoutIntervalContent(Function4 function4, Function1 function1, int i) {
        this.key = function1;
        StatusLine statusLine = new StatusLine();
        statusLine.addInterval(i, new PagerIntervalContent(function1, function4));
        this.intervals = statusLine;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKt
    public final StatusLine getIntervals() {
        return this.intervals;
    }
}
