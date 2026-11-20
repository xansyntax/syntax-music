package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface LayoutCoordinates {
    LayoutCoordinates getParentCoordinates();

    LayoutCoordinates getParentLayoutCoordinates();

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    long mo603getSizeYbymL2g();

    boolean isAttached$1();

    Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z);

    /* JADX INFO: renamed from: localPositionOf-R5De75A, reason: not valid java name */
    long mo604localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j);

    /* JADX INFO: renamed from: localPositionOf-S_NoaFU, reason: not valid java name */
    long mo605localPositionOfS_NoaFU(LayoutCoordinates layoutCoordinates, long j);

    /* JADX INFO: renamed from: localToRoot-MK-Hz9U, reason: not valid java name */
    long mo606localToRootMKHz9U(long j);

    /* JADX INFO: renamed from: localToScreen-MK-Hz9U, reason: not valid java name */
    long mo607localToScreenMKHz9U(long j);

    /* JADX INFO: renamed from: localToWindow-MK-Hz9U, reason: not valid java name */
    long mo608localToWindowMKHz9U(long j);

    /* JADX INFO: renamed from: screenToLocal-MK-Hz9U, reason: not valid java name */
    long mo609screenToLocalMKHz9U(long j);

    /* JADX INFO: renamed from: transformFrom-EL8BTi8, reason: not valid java name */
    void mo610transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, float[] fArr);

    /* JADX INFO: renamed from: transformToScreen-58bKbWc, reason: not valid java name */
    void mo611transformToScreen58bKbWc(float[] fArr);

    /* JADX INFO: renamed from: windowToLocal-MK-Hz9U, reason: not valid java name */
    long mo612windowToLocalMKHz9U(long j);
}
