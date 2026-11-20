package com.metrolist.music.ui.component;

import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetState$preUpPostDownNestedScrollConnection$1 implements NestedScrollConnection {
    public boolean isTopReached;
    public final /* synthetic */ BottomSheetState this$0;

    public BottomSheetState$preUpPostDownNestedScrollConnection$1(BottomSheetState bottomSheetState) {
        this.this$0 = bottomSheetState;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public final Object mo99onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
        this.isTopReached = false;
        return new Velocity(0L);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public final long mo100onPostScrollDzOQY0M(int i, long j, long j2) {
        boolean z = this.isTopReached;
        if (!z) {
            z = Float.intBitsToFloat((int) (j & 4294967295L)) == CropImageView.DEFAULT_ASPECT_RATIO && Float.intBitsToFloat((int) (j2 & 4294967295L)) > CropImageView.DEFAULT_ASPECT_RATIO;
            this.isTopReached = z;
        }
        if (!z || i != 1) {
            return 0L;
        }
        this.this$0.dispatchRawDelta(Float.intBitsToFloat((int) (j2 & 4294967295L)));
        return j2;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public final Object mo326onPreFlingQWom1Mo(long j, Continuation continuation) {
        if (this.isTopReached) {
            this.this$0.performFling(-Velocity.m820getYimpl(j), null);
        } else {
            j = 0;
        }
        return new Velocity(j);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public final long mo178onPreScrollOzD1aCk(int i, long j) {
        BottomSheetState bottomSheetState = this.this$0;
        if (bottomSheetState.isExpanded() && Float.intBitsToFloat((int) (j & 4294967295L)) < CropImageView.DEFAULT_ASPECT_RATIO) {
            this.isTopReached = false;
        }
        if (!this.isTopReached) {
            return 0L;
        }
        int i2 = (int) (4294967295L & j);
        if (Float.intBitsToFloat(i2) >= CropImageView.DEFAULT_ASPECT_RATIO || i != 1) {
            return 0L;
        }
        bottomSheetState.dispatchRawDelta(Float.intBitsToFloat(i2));
        return j;
    }
}
