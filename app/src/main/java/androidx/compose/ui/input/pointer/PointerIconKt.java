package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import io.ktor.client.utils.CIOKt;
import kotlin.jvm.functions.Function1;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PointerIconKt {
    public static final StackTraceElement[] EmptyStackTraceElements;
    public static final AndroidPointerIconType pointerIconDefault = new AndroidPointerIconType(CIOKt.DEFAULT_HTTP_POOL_SIZE);
    public static final AndroidPointerIconType pointerIconHand;
    public static final AndroidPointerIconType pointerIconText;

    static {
        new AndroidPointerIconType(1007);
        pointerIconText = new AndroidPointerIconType(1008);
        pointerIconHand = new AndroidPointerIconType(1002);
        EmptyStackTraceElements = new StackTraceElement[0];
    }

    public static final boolean changedToDown(PointerInputChange pointerInputChange) {
        return (pointerInputChange.isConsumed() || pointerInputChange.previousPressed || !pointerInputChange.pressed) ? false : true;
    }

    public static final boolean changedToDownIgnoreConsumed(PointerInputChange pointerInputChange) {
        return !pointerInputChange.previousPressed && pointerInputChange.pressed;
    }

    public static final boolean changedToUp(PointerInputChange pointerInputChange) {
        return (pointerInputChange.isConsumed() || !pointerInputChange.previousPressed || pointerInputChange.pressed) ? false : true;
    }

    public static final boolean changedToUpIgnoreConsumed(PointerInputChange pointerInputChange) {
        return pointerInputChange.previousPressed && !pointerInputChange.pressed;
    }

    /* JADX INFO: renamed from: isOutOfBounds-jwHxaWs, reason: not valid java name */
    public static final boolean m588isOutOfBoundsjwHxaWs(PointerInputChange pointerInputChange, long j, long j2) {
        int i = pointerInputChange.type == 1 ? 1 : 0;
        long j3 = pointerInputChange.position;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L));
        float f = i;
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j2 >> 32)) * f;
        float f2 = ((int) (j >> 32)) + fIntBitsToFloat3;
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j2 & 4294967295L)) * f;
        return (fIntBitsToFloat > f2) | (fIntBitsToFloat < (-fIntBitsToFloat3)) | (fIntBitsToFloat2 < (-fIntBitsToFloat4)) | (fIntBitsToFloat2 > ((int) (j & 4294967295L)) + fIntBitsToFloat4);
    }

    public static final long positionChangeInternal(PointerInputChange pointerInputChange, boolean z) {
        long jM438minusMKHz9U = Offset.m438minusMKHz9U(pointerInputChange.position, pointerInputChange.previousPosition);
        if (z || !pointerInputChange.isConsumed()) {
            return jM438minusMKHz9U;
        }
        return 0L;
    }

    /* JADX INFO: renamed from: toMotionEventScope-ubNVwUQ, reason: not valid java name */
    public static final void m589toMotionEventScopeubNVwUQ(PointerEvent pointerEvent, long j, Function1 function1, boolean z) {
        MotionEvent motionEvent = pointerEvent.getMotionEvent();
        if (motionEvent == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("The PointerEvent receiver cannot have a null MotionEvent.");
            return;
        }
        int action = motionEvent.getAction();
        if (z) {
            motionEvent.setAction(3);
        }
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        motionEvent.offsetLocation(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
        function1.invoke(motionEvent);
        motionEvent.offsetLocation(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
        motionEvent.setAction(action);
    }
}
