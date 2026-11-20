package androidx.compose.foundation.lazy;

import androidx.collection.MutableIntList;
import androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda2;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import com.metrolist.music.ui.screens.HistoryScreenKt$$ExternalSyntheticLambda20;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListIntervalContent extends LazyLayoutKt {
    public MutableIntList _headerIndexes;
    public final StatusLine intervals = new StatusLine();

    public LazyListIntervalContent(Function1 function1) {
        function1.invoke(this);
    }

    public static /* synthetic */ void item$default(LazyListIntervalContent lazyListIntervalContent, String str, String str2, Function3 function3, int i) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        lazyListIntervalContent.item(str, str2, function3);
    }

    public static void stickyHeader$default(LazyListIntervalContent lazyListIntervalContent, final ComposableLambdaImpl composableLambdaImpl) {
        StatusLine statusLine = lazyListIntervalContent.intervals;
        MutableIntList mutableIntList = lazyListIntervalContent._headerIndexes;
        if (mutableIntList == null) {
            mutableIntList = new MutableIntList();
            lazyListIntervalContent._headerIndexes = mutableIntList;
        }
        mutableIntList.add(statusLine.code);
        final int i = statusLine.code;
        lazyListIntervalContent.item(null, null, new ComposableLambdaImpl(true, -1588696110, new Function3() { // from class: androidx.compose.foundation.lazy.LazyListIntervalContent$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                if ((iIntValue & 6) == 0) {
                    iIntValue |= ((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                    composableLambdaImpl.invoke(lazyItemScopeImpl, Integer.valueOf(i), gapComposer, Integer.valueOf(iIntValue & 14));
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            }
        }));
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKt
    public final StatusLine getIntervals() {
        return this.intervals;
    }

    public final void item(Object obj, Object obj2, Function3 function3) {
        this.intervals.addInterval(1, new LazyListInterval(obj != null ? new CrossfadeKt$$ExternalSyntheticLambda2((byte) 2, obj) : null, new CrossfadeKt$$ExternalSyntheticLambda2((byte) 2, obj2), new ComposableLambdaImpl(true, -857469575, new HistoryScreenKt$$ExternalSyntheticLambda20((byte) 1, function3))));
    }

    public final void items(int i, Function1 function1, Function1 function2, ComposableLambdaImpl composableLambdaImpl) {
        this.intervals.addInterval(i, new LazyListInterval(function1, function2, composableLambdaImpl));
    }
}
