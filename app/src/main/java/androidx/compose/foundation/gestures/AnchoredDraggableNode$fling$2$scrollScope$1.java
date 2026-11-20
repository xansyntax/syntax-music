package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutationInterruptedException;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableNode$fling$2$scrollScope$1 implements ScrollScope {
    public final /* synthetic */ Object $$this$anchoredDrag;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object this$0;

    public /* synthetic */ AnchoredDraggableNode$fling$2$scrollScope$1(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.this$0 = obj;
        this.$$this$anchoredDrag = obj2;
    }

    @Override // androidx.compose.foundation.gestures.ScrollScope
    public final float scrollBy(float f) {
        byte b = this.$r8$classId;
        Object obj = this.$$this$anchoredDrag;
        Object obj2 = this.this$0;
        switch (b) {
            case 0:
                AnchoredDraggableNode anchoredDraggableNode = (AnchoredDraggableNode) obj2;
                float fNewOffsetForDelta$foundation = anchoredDraggableNode.state.newOffsetForDelta$foundation(f);
                float floatValue = fNewOffsetForDelta$foundation - ((ParcelableSnapshotMutableFloatState) anchoredDraggableNode.state.head).getFloatValue();
                ((AnchoredDraggableState$anchoredDragScope$1) obj).dragTo(fNewOffsetForDelta$foundation, CropImageView.DEFAULT_ASPECT_RATIO);
                return floatValue;
            default:
                ScrollingLogic scrollingLogic = (ScrollingLogic) obj2;
                if (Math.abs(f) == CropImageView.DEFAULT_ASPECT_RATIO || ((Boolean) scrollingLogic.isScrollableNodeAttached.invoke()).booleanValue()) {
                    return scrollingLogic.reverseIfNeeded(scrollingLogic.m105toFloatk4lQ0M(((ScrollingLogic$nestedScrollScope$1) obj).m107scrollByWithOverscrollOzD1aCk(2, scrollingLogic.m104reverseIfNeededMKHz9U(scrollingLogic.m106toOffsettuRUvjQ(f)))));
                }
                throw new MutationInterruptedException("The fling animation was cancelled", (byte) 1);
        }
    }
}
