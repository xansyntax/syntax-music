package androidx.compose.foundation.pager;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface PageSize {
    int calculateMainAxisPageSize(int i, int i2);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    /* JADX INFO: loaded from: classes2.dex */
    public final class Fill implements PageSize {
        public static final Fill INSTANCE = new Fill();

        @Override // androidx.compose.foundation.pager.PageSize
        public final int calculateMainAxisPageSize(int i, int i2) {
            return i;
        }
    }
}
