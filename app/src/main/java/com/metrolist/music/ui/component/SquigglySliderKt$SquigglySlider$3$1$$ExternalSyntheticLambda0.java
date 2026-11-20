package com.metrolist.music.ui.component;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.unit.Density;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.ClosedFloatRange;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SquigglySliderKt$SquigglySlider$3$1$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ PointerInputScope f$0;
    public final /* synthetic */ float f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ MutableState f$4;
    public final /* synthetic */ ParcelableSnapshotMutableFloatState f$5;

    public /* synthetic */ SquigglySliderKt$SquigglySlider$3$1$$ExternalSyntheticLambda0(PointerInputScope pointerInputScope, float f, ClosedFloatRange closedFloatRange, Function1 function1, MutableState mutableState, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState) {
        this.f$0 = pointerInputScope;
        this.f$1 = f;
        this.f$2 = closedFloatRange;
        this.f$3 = function1;
        this.f$4 = mutableState;
        this.f$5 = parcelableSnapshotMutableFloatState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.f$5;
        float f = this.f$1;
        Object obj2 = this.f$3;
        MutableState mutableState = this.f$4;
        Object obj3 = this.f$2;
        PointerInputScope pointerInputScope = this.f$0;
        switch (b) {
            case 0:
                mutableState.setValue(Boolean.TRUE);
                parcelableSnapshotMutableFloatState.setFloatValue(UuidKt.coerceIn((Float.intBitsToFloat((int) (((Offset) obj).packedValue >> 32)) / ((int) (((SuspendingPointerInputModifierNodeImpl) pointerInputScope).boundsSize >> 32))) * f, CropImageView.DEFAULT_ASPECT_RATIO, f) + ((ClosedFloatRange) obj3)._start);
                ((Function1) obj2).invoke(Float.valueOf(parcelableSnapshotMutableFloatState.getFloatValue()));
                break;
            default:
                mutableState.setValue(Boolean.TRUE);
                ((ParcelableSnapshotMutableIntState) obj2).setIntValue(-1);
                float f2 = (int) (((SuspendingPointerInputModifierNodeImpl) pointerInputScope).boundsSize & 4294967295L);
                float fMo81toPx0680j_4 = ((Density) obj3).mo81toPx0680j_4(f);
                parcelableSnapshotMutableFloatState.setFloatValue(UuidKt.coerceIn(Float.intBitsToFloat((int) (((Offset) obj).packedValue & 4294967295L)) - (fMo81toPx0680j_4 / 2.0f), CropImageView.DEFAULT_ASPECT_RATIO, f2 - fMo81toPx0680j_4));
                break;
        }
        return unit;
    }

    public /* synthetic */ SquigglySliderKt$SquigglySlider$3$1$$ExternalSyntheticLambda0(PointerInputScope pointerInputScope, Density density, MutableState mutableState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, float f, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState) {
        this.f$0 = pointerInputScope;
        this.f$2 = density;
        this.f$4 = mutableState;
        this.f$3 = parcelableSnapshotMutableIntState;
        this.f$1 = f;
        this.f$5 = parcelableSnapshotMutableFloatState;
    }
}
