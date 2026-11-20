package androidx.compose.ui.layout;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface Measurable {
    Object getParentData();

    int maxIntrinsicHeight(int i);

    int maxIntrinsicWidth(int i);

    /* JADX INFO: renamed from: measure-BRTryo0 */
    Placeable mo598measureBRTryo0(long j);

    int minIntrinsicHeight(int i);

    int minIntrinsicWidth(int i);
}
