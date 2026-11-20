package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda7;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import com.metrolist.music.ui.component.ItemsKt$$ExternalSyntheticLambda34;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PagerLazyLayoutItemProvider implements LazyLayoutItemProvider {
    public final LazyLayoutKt intervalContent;
    public final StatusLine keyIndexMap;
    public final PagerState state;

    public PagerLazyLayoutItemProvider(PagerState pagerState, PagerLayoutIntervalContent pagerLayoutIntervalContent, StatusLine statusLine) {
        this.state = pagerState;
        this.intervalContent = pagerLayoutIntervalContent;
        this.keyIndexMap = statusLine;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public final void Item(int i, Object obj, Composer composer, int i2) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1201380429);
        int i3 = (gapComposer.changed(i) ? 4 : 2) | i2 | (gapComposer.changedInstance(obj) ? 32 : 16) | (gapComposer.changed(this) ? 256 : 128);
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
            LazyLayoutKt.LazyLayoutPinnableItem(obj, i, this.state.pinnedPages, Expect_jvmKt.rememberComposableLambda(1142237095, new ItemsKt$$ExternalSyntheticLambda34((Object) this, i, (byte) 3), gapComposer), gapComposer, ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112));
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SnackbarHostKt$$ExternalSyntheticLambda7(this, i, obj, i2, (byte) 5);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PagerLazyLayoutItemProvider)) {
            return false;
        }
        return Intrinsics.areEqual(this.intervalContent, ((PagerLazyLayoutItemProvider) obj).intervalContent);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public final int getIndex(Object obj) {
        return this.keyIndexMap.getIndex(obj);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public final int getItemCount() {
        return this.intervalContent.getIntervals().code;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public final Object getKey(int i) {
        Object key = this.keyIndexMap.getKey(i);
        return key == null ? this.intervalContent.getKey(i) : key;
    }

    public final int hashCode() {
        return this.intervalContent.hashCode();
    }
}
