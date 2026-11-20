package androidx.compose.foundation.pager;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PagerState$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ PagerState f$0;

    public /* synthetic */ PagerState$$ExternalSyntheticLambda2(PagerState pagerState, byte b) {
        this.$r8$classId = b;
        this.f$0 = pagerState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int pageCount;
        byte b = this.$r8$classId;
        PagerState pagerState = this.f$0;
        switch (b) {
            case 0:
                pageCount = pagerState.getPageCount();
                break;
            case 1:
                pageCount = pagerState.getPageCount();
                break;
            default:
                pageCount = pagerState.getPageCount();
                break;
        }
        return Integer.valueOf(pageCount);
    }
}
