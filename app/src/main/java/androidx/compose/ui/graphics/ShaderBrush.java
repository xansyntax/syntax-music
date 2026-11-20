package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Size;
import androidx.core.provider.CallbackWrapper;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ShaderBrush extends Brush {
    public long createdSize = 9205357640488583168L;
    public CallbackWrapper internalTransformShader;
    public float[] transform;

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: applyTo-Pq9zytI */
    public final void mo473applyToPq9zytI(float f, long j, AndroidPaint androidPaint) {
        CallbackWrapper callbackWrapper = this.internalTransformShader;
        if (callbackWrapper == null || !Size.m447equalsimpl0(this.createdSize, j)) {
            if (Size.m449isEmptyimpl(j)) {
                this.internalTransformShader = null;
                this.createdSize = 9205357640488583168L;
                callbackWrapper = null;
            } else {
                callbackWrapper = this.internalTransformShader;
                if (callbackWrapper == null) {
                    callbackWrapper = new CallbackWrapper((byte) 8, false);
                    this.internalTransformShader = callbackWrapper;
                }
                float[] fArr = this.transform;
                if (fArr != null) {
                    callbackWrapper.m829transformQ8lPUPs(fArr);
                }
                Shader shaderMo474createShaderuvyYCjk = mo474createShaderuvyYCjk(j);
                android.graphics.Matrix matrix = (android.graphics.Matrix) callbackWrapper.mCallback;
                if (matrix != null && shaderMo474createShaderuvyYCjk != null) {
                    shaderMo474createShaderuvyYCjk.setLocalMatrix(matrix);
                }
                callbackWrapper.mExecutor = shaderMo474createShaderuvyYCjk;
                this.internalTransformShader = callbackWrapper;
                this.createdSize = j;
            }
        }
        if (!ULong.m1869equalsimpl0(androidPaint.m460getColor0d7_KjU(), -72057594037927936L)) {
            androidPaint.m464setColor8_81llA(-72057594037927936L);
        }
        if (!Intrinsics.areEqual(androidPaint.internalShader, callbackWrapper != null ? (Shader) callbackWrapper.mExecutor : null)) {
            androidPaint.setShader(callbackWrapper != null ? (Shader) callbackWrapper.mExecutor : null);
        }
        if (androidPaint.internalPaint.getAlpha() / 255.0f == f) {
            return;
        }
        androidPaint.setAlpha(f);
    }

    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public abstract Shader mo474createShaderuvyYCjk(long j);
}
