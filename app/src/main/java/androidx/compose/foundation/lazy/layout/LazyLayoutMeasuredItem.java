package androidx.compose.foundation.lazy.layout;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface LazyLayoutMeasuredItem {
    /* JADX INFO: renamed from: getConstraints-msEJaDk */
    long mo163getConstraintsmsEJaDk();

    int getHorizontalAxisSize();

    int getHorizontalAxisSpacing();

    int getIndex();

    Object getKey();

    int getLane();

    /* JADX INFO: renamed from: getOffset-Bjo55l4 */
    long mo165getOffsetBjo55l4(int i);

    List getPlaceables();

    int getSpan();

    int getVerticalAxisSize();

    int getVerticalAxisSpacing();

    void makeNonScrollable();

    void position(int i, int i2, int i3, int i4);
}
