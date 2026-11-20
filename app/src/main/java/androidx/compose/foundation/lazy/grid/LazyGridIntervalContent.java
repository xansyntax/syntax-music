package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda2;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda3;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import com.metrolist.music.ui.component.DialogKt$$ExternalSyntheticLambda0;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda3;
import com.metrolist.music.ui.screens.HistoryScreenKt$$ExternalSyntheticLambda20;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridIntervalContent extends LazyLayoutKt {
    public static final ScrollState$$ExternalSyntheticLambda3 DefaultSpan = new ScrollState$$ExternalSyntheticLambda3(4);
    public boolean hasCustomSpans;
    public final LazyGridSpanLayoutProvider spanLayoutProvider = new LazyGridSpanLayoutProvider(this);
    public final StatusLine intervals = new StatusLine();

    public LazyGridIntervalContent(Function1 function1) {
        function1.invoke(this);
    }

    public static /* synthetic */ void item$default(LazyGridIntervalContent lazyGridIntervalContent, String str, Function1 function1, Function0 function0, ComposableLambdaImpl composableLambdaImpl, int i) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        lazyGridIntervalContent.item(str, function1, function0, composableLambdaImpl);
    }

    public static /* synthetic */ void items$default(LazyGridIntervalContent lazyGridIntervalContent, int i, QueueKt$$ExternalSyntheticLambda3 queueKt$$ExternalSyntheticLambda3, ComposableLambdaImpl composableLambdaImpl, int i2) {
        if ((i2 & 4) != 0) {
            queueKt$$ExternalSyntheticLambda3 = null;
        }
        lazyGridIntervalContent.items(i, null, queueKt$$ExternalSyntheticLambda3, LazyGridScope$items$1.INSTANCE, composableLambdaImpl);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKt
    public final StatusLine getIntervals() {
        return this.intervals;
    }

    public final void item(Object obj, Function1 function1, Object obj2, ComposableLambdaImpl composableLambdaImpl) {
        this.intervals.addInterval(1, new LazyGridInterval(obj != null ? new CrossfadeKt$$ExternalSyntheticLambda2((byte) 2, obj) : null, function1 != null ? new DialogKt$$ExternalSyntheticLambda0(function1, (byte) 1) : DefaultSpan, new CrossfadeKt$$ExternalSyntheticLambda2((byte) 2, obj2), new ComposableLambdaImpl(true, -291643851, new HistoryScreenKt$$ExternalSyntheticLambda20((byte) 2, composableLambdaImpl))));
        if (function1 != null) {
            this.hasCustomSpans = true;
        }
    }

    public final void items(int i, Function1 function1, Function2 function2, Function1 function3, ComposableLambdaImpl composableLambdaImpl) {
        this.intervals.addInterval(i, new LazyGridInterval(function1, function2 == null ? DefaultSpan : function2, function3, composableLambdaImpl));
        if (function2 != null) {
            this.hasCustomSpans = true;
        }
    }
}
