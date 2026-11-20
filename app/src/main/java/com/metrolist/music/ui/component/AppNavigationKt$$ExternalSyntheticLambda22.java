package com.metrolist.music.ui.component;

import android.graphics.RuntimeShader;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppNavigationKt$$ExternalSyntheticLambda22 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ float f$2;
    public final /* synthetic */ float f$3;

    public /* synthetic */ AppNavigationKt$$ExternalSyntheticLambda22(float f, float f2, VelocityTracker velocityTracker, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState) {
        this.f$2 = f;
        this.f$3 = f2;
        this.f$0 = velocityTracker;
        this.f$1 = parcelableSnapshotMutableFloatState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$1;
        Object obj3 = this.f$0;
        float f = this.f$3;
        float f2 = this.f$2;
        switch (b) {
            case 0:
                AppNavigationKt.GlassLensBar$lambda$4$0$5$0((RuntimeShader) obj3, (LensController) obj2, f2, f, (ReusableGraphicsLayerScope) obj);
                break;
            default:
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) obj2;
                PointerInputChange pointerInputChange = (PointerInputChange) obj;
                parcelableSnapshotMutableFloatState.setFloatValue(UuidKt.coerceIn(Float.intBitsToFloat((int) (PointerIconKt.positionChangeInternal(pointerInputChange, false) & 4294967295L)) + parcelableSnapshotMutableFloatState.getFloatValue(), f2, f));
                ((VelocityTracker) obj3).m594addPositionUv8p0NA(pointerInputChange.uptimeMillis, pointerInputChange.position);
                pointerInputChange.consume();
                break;
        }
        return unit;
    }

    public /* synthetic */ AppNavigationKt$$ExternalSyntheticLambda22(RuntimeShader runtimeShader, LensController lensController, float f, float f2) {
        this.f$0 = runtimeShader;
        this.f$1 = lensController;
        this.f$2 = f;
        this.f$3 = f2;
    }
}
