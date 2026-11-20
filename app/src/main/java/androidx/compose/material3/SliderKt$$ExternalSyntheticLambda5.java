package androidx.compose.material3;

import android.app.PendingIntent;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import coil3.util.LifecyclesKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.ClosedFloatRange;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SliderKt$$ExternalSyntheticLambda5 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SliderState f$0;

    public /* synthetic */ SliderKt$$ExternalSyntheticLambda5(Density density, SliderState sliderState, MutableState mutableState) {
        this.$r8$classId = (byte) 2;
        this.f$0 = sliderState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws PendingIntent.CanceledException {
        int i;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        SliderState sliderState = this.f$0;
        switch (b) {
            case 0:
                Float f = (Float) obj;
                float fFloatValue = f.floatValue();
                Function1 function1 = sliderState.onValueChangeInternal;
                if (function1 != null) {
                    function1.invoke(f);
                } else {
                    sliderState.setValue(fFloatValue);
                }
                return unit;
            case 1:
                float fFloatValue2 = ((Float) obj).floatValue();
                ClosedFloatRange closedFloatRange = sliderState.trackRange;
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = sliderState.valueState$delegate;
                float fCoerceIn = UuidKt.coerceIn(fFloatValue2, closedFloatRange._start, closedFloatRange._endInclusive);
                int i2 = sliderState.steps;
                boolean z = false;
                if (i2 > 0 && (i = i2 + 1) >= 0) {
                    float fAbs = fCoerceIn;
                    float f2 = fAbs;
                    int i3 = 0;
                    while (true) {
                        float fLerp = LifecyclesKt.lerp(closedFloatRange._start, closedFloatRange._endInclusive, i3 / i);
                        float f3 = fLerp - fCoerceIn;
                        if (Math.abs(f3) <= fAbs) {
                            fAbs = Math.abs(f3);
                            f2 = fLerp;
                        }
                        if (i3 != i) {
                            i3++;
                        } else {
                            fCoerceIn = f2;
                        }
                    }
                }
                if (fCoerceIn != parcelableSnapshotMutableFloatState.getFloatValue()) {
                    if (fCoerceIn != parcelableSnapshotMutableFloatState.getFloatValue()) {
                        Function1 function2 = sliderState.onValueChangeInternal;
                        if (function2 != null) {
                            function2.invoke(Float.valueOf(fCoerceIn));
                        } else {
                            sliderState.setValue(fCoerceIn);
                        }
                    }
                    Function0 function0 = sliderState.onValueChangeFinishedInternal;
                    if (function0 != null) {
                        function0.invoke();
                    }
                    z = true;
                }
                return Boolean.valueOf(z);
            case 2:
                IntSize intSize = (IntSize) obj;
                sliderState.thumbWidth$delegate.setIntValue((int) (intSize.packedValue >> 32));
                sliderState.thumbHeight$delegate.setIntValue((int) (intSize.packedValue & 4294967295L));
                return unit;
            default:
                sliderState.dispatchRawDeltaInternal$material3(CropImageView.DEFAULT_ASPECT_RATIO);
                sliderState.gestureEndAction.invoke();
                return unit;
        }
    }

    public /* synthetic */ SliderKt$$ExternalSyntheticLambda5(SliderState sliderState, byte b) {
        this.$r8$classId = b;
        this.f$0 = sliderState;
    }
}
