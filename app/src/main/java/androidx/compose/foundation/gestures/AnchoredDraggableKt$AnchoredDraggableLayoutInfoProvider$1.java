package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.pager.MeasuredPage;
import androidx.compose.foundation.pager.PagerMeasureResult;
import androidx.compose.foundation.pager.PagerSnapDistanceMaxPages;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.node.NodeChain;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda11;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.uuid.UuidKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableKt$AnchoredDraggableLayoutInfoProvider$1 implements SnapLayoutInfoProvider {
    public final /* synthetic */ Function $positionalThreshold;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object $state;
    public final /* synthetic */ Object $velocityThreshold;

    public /* synthetic */ AnchoredDraggableKt$AnchoredDraggableLayoutInfoProvider$1(Object obj, Function function, Object obj2, byte b) {
        this.$r8$classId = b;
        this.$state = obj;
        this.$positionalThreshold = function;
        this.$velocityThreshold = obj2;
    }

    @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
    public final float calculateApproachOffset(float f, float f2) {
        switch (this.$r8$classId) {
            case 0:
                return CropImageView.DEFAULT_ASPECT_RATIO;
            default:
                PagerState pagerState = (PagerState) this.$state;
                int pageSize$foundation = pagerState.getPageSize$foundation();
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = pagerState.pagerLayoutInfoState;
                int i = ((PagerMeasureResult) parcelableSnapshotMutableState.getValue()).pageSpacing + pageSize$foundation;
                if (i == 0) {
                    return CropImageView.DEFAULT_ASPECT_RATIO;
                }
                int i2 = pagerState.firstVisiblePage;
                if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
                    i2++;
                }
                int iCoerceIn = UuidKt.coerceIn(((int) (f2 / i)) + i2, 0, pagerState.getPageCount());
                PagerSnapDistanceMaxPages pagerSnapDistanceMaxPages = (PagerSnapDistanceMaxPages) this.$velocityThreshold;
                pagerState.getPageSize$foundation();
                int i3 = ((PagerMeasureResult) parcelableSnapshotMutableState.getValue()).pageSpacing;
                long j = i2;
                pagerSnapDistanceMaxPages.getClass();
                long j2 = j - 1;
                if (j2 < 0) {
                    j2 = 0;
                }
                int i4 = (int) j2;
                long j3 = j + 1;
                if (j3 > 2147483647L) {
                    j3 = 2147483647L;
                }
                int iAbs = Math.abs((UuidKt.coerceIn(UuidKt.coerceIn(iCoerceIn, i4, (int) j3), 0, pagerState.getPageCount()) - i2) * i) - i;
                int i5 = iAbs >= 0 ? iAbs : 0;
                if (i5 == 0) {
                    return i5;
                }
                return Math.signum(f) * i5;
        }
    }

    /* JADX WARN: Code duplicated, block: B:81:0x018a  */
    @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
    public final float calculateSnapOffset(float f) {
        Object objClosestAnchor;
        byte b = this.$r8$classId;
        Function function = this.$positionalThreshold;
        Object obj = this.$state;
        switch (b) {
            case 0:
                NodeChain nodeChain = (NodeChain) obj;
                float fRequireOffset = nodeChain.requireOffset();
                DefaultDraggableAnchors anchors = nodeChain.getAnchors();
                Function1 function1 = (Function1) function;
                SheetDefaultsKt$$ExternalSyntheticLambda0 sheetDefaultsKt$$ExternalSyntheticLambda0 = (SheetDefaultsKt$$ExternalSyntheticLambda0) this.$velocityThreshold;
                if (Float.isNaN(fRequireOffset)) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("The offset provided to computeTarget must not be NaN.");
                    return CropImageView.DEFAULT_ASPECT_RATIO;
                }
                boolean z = Math.abs(f) > CropImageView.DEFAULT_ASPECT_RATIO;
                boolean z2 = z && f > CropImageView.DEFAULT_ASPECT_RATIO;
                if (!z) {
                    objClosestAnchor = anchors.closestAnchor(fRequireOffset);
                    objClosestAnchor.getClass();
                } else if (Math.abs(f) >= Math.abs(((Number) sheetDefaultsKt$$ExternalSyntheticLambda0.invoke()).floatValue())) {
                    objClosestAnchor = anchors.closestAnchor(fRequireOffset, z2);
                    objClosestAnchor.getClass();
                } else {
                    objClosestAnchor = anchors.closestAnchor(fRequireOffset, false);
                    objClosestAnchor.getClass();
                    float fPositionOf = anchors.positionOf(objClosestAnchor);
                    Object objClosestAnchor2 = anchors.closestAnchor(fRequireOffset, true);
                    objClosestAnchor2.getClass();
                    float fPositionOf2 = anchors.positionOf(objClosestAnchor2);
                    float fAbs = Math.abs(((Number) function1.invoke(Float.valueOf(Math.abs(fPositionOf - fPositionOf2)))).floatValue());
                    if (!z2) {
                        fPositionOf = fPositionOf2;
                    }
                    i = Math.abs(fPositionOf - fRequireOffset) >= fAbs ? 1 : 0;
                    if (i != 1) {
                        if (i != 0) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return CropImageView.DEFAULT_ASPECT_RATIO;
                        }
                        if (!z2) {
                            objClosestAnchor = objClosestAnchor2;
                        }
                    } else if (z2) {
                        objClosestAnchor = objClosestAnchor2;
                    }
                }
                if (!((Boolean) ((Function1) nodeChain.layoutNode).invoke(objClosestAnchor)).booleanValue()) {
                    objClosestAnchor = ((ParcelableSnapshotMutableState) nodeChain.outerCoordinator).getValue();
                }
                return nodeChain.getAnchors().positionOf(objClosestAnchor) - fRequireOffset;
            default:
                PagerState pagerState = (PagerState) obj;
                SnapPosition snapPosition = pagerState.getLayoutInfo().snapPosition;
                List list = pagerState.getLayoutInfo().visiblePagesInfo;
                int size = list.size();
                float f2 = Float.NEGATIVE_INFINITY;
                float f3 = Float.POSITIVE_INFINITY;
                for (int i = 0; i < size; i++) {
                    MeasuredPage measuredPage = (MeasuredPage) list.get(i);
                    FileSystemsKt.getMainAxisViewportSize(pagerState.getLayoutInfo());
                    int i2 = pagerState.getLayoutInfo().viewportStartOffset;
                    int i3 = pagerState.getLayoutInfo().afterContentPadding;
                    int i4 = pagerState.getLayoutInfo().pageSize;
                    float fPosition = measuredPage.offset - snapPosition.position(measuredPage.index, pagerState.getPageCount());
                    if (fPosition <= CropImageView.DEFAULT_ASPECT_RATIO && fPosition > f2) {
                        f2 = fPosition;
                    }
                    if (fPosition >= CropImageView.DEFAULT_ASPECT_RATIO && fPosition < f3) {
                        f3 = fPosition;
                    }
                }
                if (f2 == Float.NEGATIVE_INFINITY) {
                    f2 = f3;
                }
                if (f3 == Float.POSITIVE_INFINITY) {
                    f3 = f2;
                }
                if (!pagerState.getCanScrollForward()) {
                    if (UtilsKt.isScrollingForward(pagerState, f)) {
                        f2 = 0.0f;
                        f3 = 0.0f;
                    } else {
                        f3 = 0.0f;
                    }
                }
                if (!pagerState.getCanScrollBackward()) {
                    f2 = 0.0f;
                    if (!UtilsKt.isScrollingForward(pagerState, f)) {
                        f3 = 0.0f;
                    }
                }
                Float fValueOf = Float.valueOf(f2);
                Float fValueOf2 = Float.valueOf(f3);
                float fFloatValue = fValueOf.floatValue();
                float fFloatValue2 = fValueOf2.floatValue();
                float fFloatValue3 = ((Number) ((AlbumMenuKt$$ExternalSyntheticLambda11) function).invoke(Float.valueOf(f), Float.valueOf(fFloatValue), Float.valueOf(fFloatValue2))).floatValue();
                if (fFloatValue3 != fFloatValue && fFloatValue3 != fFloatValue2 && fFloatValue3 != CropImageView.DEFAULT_ASPECT_RATIO) {
                    InlineClassHelperKt.throwIllegalStateException("Final Snapping Offset Should Be one of " + fFloatValue + ", " + fFloatValue2 + " or 0.0");
                }
                return (fFloatValue3 == Float.POSITIVE_INFINITY || fFloatValue3 == Float.NEGATIVE_INFINITY) ? CropImageView.DEFAULT_ASPECT_RATIO : fFloatValue3;
        }
    }
}
