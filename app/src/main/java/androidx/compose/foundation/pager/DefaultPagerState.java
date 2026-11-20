package androidx.compose.foundation.pager;

import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda3;
import androidx.compose.foundation.layout.OffsetKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.core.provider.CallbackWrapper;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultPagerState extends PagerState {
    public static final CallbackWrapper Saver = SaverKt.listSaver(new ScrollState$$ExternalSyntheticLambda3(7), new OffsetKt$$ExternalSyntheticLambda0((byte) 20));
    public final ParcelableSnapshotMutableState pageCountState;

    public DefaultPagerState(int i, float f, Function0 function0) {
        super(i, f);
        this.pageCountState = Stack.mutableStateOf$default(function0);
    }

    @Override // androidx.compose.foundation.pager.PagerState
    public final int getPageCount() {
        return ((Number) ((Function0) this.pageCountState.getValue()).invoke()).intValue();
    }
}
