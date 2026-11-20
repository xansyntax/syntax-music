package androidx.compose.foundation.gestures;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode$bringIntoView$2$1$1;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.MeasuredSizeAwareModifierNode;
import androidx.compose.ui.unit.IntSize;
import coil3.size.SizeKt;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ContentInViewNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, MeasuredSizeAwareModifierNode {
    public BringIntoViewSpec bringIntoViewSpec;
    public final ScrollableNode$$ExternalSyntheticLambda0 getFocusedRect;
    public boolean isAnimationRunning;
    public Orientation orientation;
    public boolean reverseDirection;
    public final ScrollingLogic scrollingLogic;
    public boolean trackingFocusedChild;
    public final LazyLayoutBeyondBoundsInfo bringIntoViewRequests = new LazyLayoutBeyondBoundsInfo((byte) 1);
    public long viewportSize = -1;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Request {
        public final CancellableContinuationImpl continuation;
        public final BringIntoViewResponderNode$bringIntoView$2$1$1 currentBounds;

        public Request(BringIntoViewResponderNode$bringIntoView$2$1$1 bringIntoViewResponderNode$bringIntoView$2$1$1, CancellableContinuationImpl cancellableContinuationImpl) {
            this.currentBounds = bringIntoViewResponderNode$bringIntoView$2$1$1;
            this.continuation = cancellableContinuationImpl;
        }

        public final String toString() {
            CancellableContinuationImpl cancellableContinuationImpl = this.continuation;
            CoroutineName coroutineName = (CoroutineName) cancellableContinuationImpl.context.get(CoroutineName.Key);
            String str = coroutineName != null ? coroutineName.name : null;
            int iHashCode = hashCode();
            CharsKt.checkRadix(16);
            String string = Integer.toString(iHashCode, 16);
            string.getClass();
            return "Request@" + string + (str != null ? IntIntPair$$ExternalSyntheticOutline0.m("[", str, "](") : "(") + "currentBounds()=" + this.currentBounds.invoke() + ", continuation=" + cancellableContinuationImpl + ")";
        }
    }

    public ContentInViewNode(Orientation orientation, ScrollingLogic scrollingLogic, boolean z, BringIntoViewSpec bringIntoViewSpec, ScrollableNode$$ExternalSyntheticLambda0 scrollableNode$$ExternalSyntheticLambda0) {
        this.orientation = orientation;
        this.scrollingLogic = scrollingLogic;
        this.reverseDirection = z;
        this.bringIntoViewSpec = bringIntoViewSpec;
        this.getFocusedRect = scrollableNode$$ExternalSyntheticLambda0;
    }

    /* JADX INFO: renamed from: isMaxVisible--EQwtKw$default, reason: not valid java name */
    public static boolean m57isMaxVisibleEQwtKw$default(ContentInViewNode contentInViewNode, Rect rect, long j, long j2, int i) {
        if ((i & 1) != 0) {
            j = contentInViewNode.m59getViewportSizeOrZeroYbymL2g$foundation();
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = 0;
        }
        long jM62relocationOffsetfbGrOKE = contentInViewNode.m62relocationOffsetfbGrOKE(rect, j3, j2);
        return Math.abs(Float.intBitsToFloat((int) (jM62relocationOffsetfbGrOKE >> 32))) <= 0.5f && Math.abs(Float.intBitsToFloat((int) (jM62relocationOffsetfbGrOKE & 4294967295L))) <= 0.5f;
    }

    /* JADX INFO: renamed from: calculateScrollDelta-I_oMVgE, reason: not valid java name */
    public final float m58calculateScrollDeltaI_oMVgE(BringIntoViewSpec bringIntoViewSpec, long j) {
        float f;
        Rect rect;
        int iCompare;
        long j2 = this.viewportSize;
        MutableVector mutableVector = this.bringIntoViewRequests.beyondBoundsItems;
        int i = mutableVector.size - 1;
        Object[] objArr = mutableVector.content;
        if (i < objArr.length) {
            rect = null;
            while (true) {
                if (i < 0) {
                    f = CropImageView.DEFAULT_ASPECT_RATIO;
                    break;
                }
                Rect rect2 = (Rect) ((Request) objArr[i]).currentBounds.invoke();
                if (rect2 != null) {
                    long jM444getSizeNHjbRc = rect2.m444getSizeNHjbRc();
                    long jM876toSizeozmzZPI = SizeKt.m876toSizeozmzZPI(m59getViewportSizeOrZeroYbymL2g$foundation());
                    f = CropImageView.DEFAULT_ASPECT_RATIO;
                    int iOrdinal = this.orientation.ordinal();
                    if (iOrdinal == 0) {
                        iCompare = Float.compare(Float.intBitsToFloat((int) (jM444getSizeNHjbRc & 4294967295L)), Float.intBitsToFloat((int) (jM876toSizeozmzZPI & 4294967295L)));
                    } else {
                        if (iOrdinal != 1) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return CropImageView.DEFAULT_ASPECT_RATIO;
                        }
                        iCompare = Float.compare(Float.intBitsToFloat((int) (jM444getSizeNHjbRc >> 32)), Float.intBitsToFloat((int) (jM876toSizeozmzZPI >> 32)));
                    }
                    if (iCompare > 0) {
                        if (rect != null) {
                            break;
                        }
                        rect = rect2;
                        break;
                    }
                    rect = rect2;
                }
                i--;
            }
        } else {
            f = CropImageView.DEFAULT_ASPECT_RATIO;
            rect = null;
        }
        if (rect == null) {
            Rect rect3 = this.trackingFocusedChild ? (Rect) this.getFocusedRect.invoke() : null;
            if (rect3 == null) {
                return f;
            }
            rect = rect3;
        }
        long jM876toSizeozmzZPI2 = SizeKt.m876toSizeozmzZPI(j2);
        int iOrdinal2 = this.orientation.ordinal();
        if (iOrdinal2 == 0) {
            float f2 = rect.top;
            return bringIntoViewSpec.calculateScrollDistance(f2 - ((int) (j & 4294967295L)), rect.bottom - f2, Float.intBitsToFloat((int) (jM876toSizeozmzZPI2 & 4294967295L)));
        }
        if (iOrdinal2 == 1) {
            float f3 = rect.left;
            return bringIntoViewSpec.calculateScrollDistance(f3 - ((int) (j >> 32)), rect.right - f3, Float.intBitsToFloat((int) (jM876toSizeozmzZPI2 >> 32)));
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1();
        return f;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    /* JADX INFO: renamed from: getViewportSizeOrZero-YbymL2g$foundation, reason: not valid java name */
    public final long m59getViewportSizeOrZeroYbymL2g$foundation() {
        long j = this.viewportSize;
        if (IntSize.m810equalsimpl0(j, -1L)) {
            return 0L;
        }
        return j;
    }

    /* JADX INFO: renamed from: launchAnimation--gyyYBs, reason: not valid java name */
    public final void m60launchAnimationgyyYBs(long j) {
        BringIntoViewSpec bringIntoViewSpec = this.bringIntoViewSpec;
        if (bringIntoViewSpec == null) {
            bringIntoViewSpec = (BringIntoViewSpec) HitTestResultKt.currentValueOf(this, BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
        }
        BringIntoViewSpec bringIntoViewSpec2 = bringIntoViewSpec;
        if (this.isAnimationRunning) {
            InlineClassHelperKt.throwIllegalStateException("launchAnimation called when previous animation was running");
        }
        BringIntoViewSpec bringIntoViewSpec3 = this.bringIntoViewSpec;
        if (bringIntoViewSpec3 == null) {
            bringIntoViewSpec3 = (BringIntoViewSpec) HitTestResultKt.currentValueOf(this, BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
        }
        bringIntoViewSpec3.getClass();
        BringIntoViewSpec.Companion.getClass();
        UpdatableAnimationState updatableAnimationState = new UpdatableAnimationState(BringIntoViewSpec.Companion.DefaultScrollAnimationSpec);
        AwaitKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new ContentInViewNode$launchAnimation$2(this, updatableAnimationState, bringIntoViewSpec2, j, null), 1);
    }

    @Override // androidx.compose.ui.node.MeasuredSizeAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    public final void mo61onRemeasuredozmzZPI(long j) {
        int iCompare;
        long j2;
        long jM59getViewportSizeOrZeroYbymL2g$foundation = m59getViewportSizeOrZeroYbymL2g$foundation();
        this.viewportSize = j;
        int iOrdinal = this.orientation.ordinal();
        if (iOrdinal == 0) {
            iCompare = Intrinsics.compare((int) (j & 4294967295L), (int) (jM59getViewportSizeOrZeroYbymL2g$foundation & 4294967295L));
        } else {
            if (iOrdinal != 1) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
            iCompare = Intrinsics.compare((int) (j >> 32), (int) (jM59getViewportSizeOrZeroYbymL2g$foundation >> 32));
        }
        if (iCompare >= 0) {
            return;
        }
        if (this.reverseDirection) {
            j2 = 0;
        } else {
            j2 = this.orientation == Orientation.Vertical ? ((long) (((int) (jM59getViewportSizeOrZeroYbymL2g$foundation & 4294967295L)) - ((int) (j & 4294967295L)))) & 4294967295L : ((long) (((int) (jM59getViewportSizeOrZeroYbymL2g$foundation >> 32)) - ((int) (j >> 32)))) << 32;
        }
        long j3 = j2;
        Rect rect = (Rect) this.getFocusedRect.invoke();
        if (rect == null || this.isAnimationRunning || this.trackingFocusedChild || !m57isMaxVisibleEQwtKw$default(this, rect, jM59getViewportSizeOrZeroYbymL2g$foundation, 0L, 2) || m57isMaxVisibleEQwtKw$default(this, rect, 0L, j3, 1)) {
            return;
        }
        this.trackingFocusedChild = true;
        m60launchAnimationgyyYBs(j3);
    }

    /* JADX INFO: renamed from: relocationOffset-fbGrOKE, reason: not valid java name */
    public final long m62relocationOffsetfbGrOKE(Rect rect, long j, long j2) {
        long jM876toSizeozmzZPI = SizeKt.m876toSizeozmzZPI(j);
        int iOrdinal = this.orientation.ordinal();
        if (iOrdinal == 0) {
            BringIntoViewSpec bringIntoViewSpec = this.bringIntoViewSpec;
            if (bringIntoViewSpec == null) {
                bringIntoViewSpec = (BringIntoViewSpec) HitTestResultKt.currentValueOf(this, BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
            }
            float f = rect.top;
            return (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits(bringIntoViewSpec.calculateScrollDistance(f - ((int) (j2 & 4294967295L)), rect.bottom - f, Float.intBitsToFloat((int) (jM876toSizeozmzZPI & 4294967295L))))) & 4294967295L);
        }
        if (iOrdinal != 1) {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
            return 0L;
        }
        BringIntoViewSpec bringIntoViewSpec2 = this.bringIntoViewSpec;
        if (bringIntoViewSpec2 == null) {
            bringIntoViewSpec2 = (BringIntoViewSpec) HitTestResultKt.currentValueOf(this, BringIntoViewSpec_androidKt.LocalBringIntoViewSpec);
        }
        float f2 = rect.left;
        return (((long) Float.floatToRawIntBits(bringIntoViewSpec2.calculateScrollDistance(f2 - ((int) (j2 >> 32)), rect.right - f2, Float.intBitsToFloat((int) (jM876toSizeozmzZPI >> 32))))) << 32) | (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) & 4294967295L);
    }
}
