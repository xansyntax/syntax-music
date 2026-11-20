package androidx.compose.material3.internal;

import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.pager.PagerState$scrollToPage$2;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.draw.CacheDrawModifierNodeImpl;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Dp;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DeterminateLinearWavyProgressNode extends DelegatingNode {
    public Function1 amplitude;
    public Animatable amplitudeAnimatable;
    public StandaloneCoroutine amplitudeAnimationJob;
    public final CacheDrawModifierNodeImpl cacheDrawNodeDelegate;
    public long color;
    public float gapSize;
    public StandaloneCoroutine offsetAnimationJob;
    public Function0 progress;
    public float stopSize;
    public Stroke stroke;
    public long trackColor;
    public Stroke trackStroke;
    public float waveSpeed;
    public float wavelength;
    public final ParcelableSnapshotMutableFloatState waveOffset = new ParcelableSnapshotMutableFloatState(CropImageView.DEFAULT_ASPECT_RATIO);
    public final LinearProgressDrawingCache progressDrawingCache = new LinearProgressDrawingCache();
    public final float[] progressFractionsArray = {CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO};

    public DeterminateLinearWavyProgressNode(float f, float f2, float f3, float f4, long j, long j2, Stroke stroke, Stroke stroke2, Function0 function0, Function1 function1) {
        this.color = j;
        this.trackColor = j2;
        this.stroke = stroke;
        this.trackStroke = stroke2;
        this.gapSize = f2;
        this.wavelength = f3;
        this.waveSpeed = f4;
        this.progress = function0;
        this.amplitude = function1;
        this.stopSize = f;
        CacheDrawModifierNodeImpl cacheDrawModifierNodeImpl = new CacheDrawModifierNodeImpl(new CacheDrawScope(), new DeterminateLinearWavyProgressNode$$ExternalSyntheticLambda0(this, (byte) 0));
        delegate(cacheDrawModifierNodeImpl);
        this.cacheDrawNodeDelegate = cacheDrawModifierNodeImpl;
    }

    public final float[] getProgressFractions() {
        float[] fArr = this.progressFractionsArray;
        float f = CropImageView.DEFAULT_ASPECT_RATIO;
        fArr[0] = 0.0f;
        float fFloatValue = ((Number) this.progress.invoke()).floatValue();
        if (fFloatValue >= CropImageView.DEFAULT_ASPECT_RATIO) {
            f = fFloatValue;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        fArr[1] = f;
        return fArr;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        updateOffsetAnimation();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        this.amplitudeAnimatable = null;
    }

    public final void updateOffsetAnimation() {
        StandaloneCoroutine standaloneCoroutine = this.offsetAnimationJob;
        Continuation continuation = null;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.offsetAnimationJob = null;
        if (this.isAttached) {
            if (Dp.m795compareTo0680j_4(this.waveSpeed, CropImageView.DEFAULT_ASPECT_RATIO) <= 0 || Dp.m795compareTo0680j_4(this.wavelength, CropImageView.DEFAULT_ASPECT_RATIO) <= 0) {
                this.waveOffset.setFloatValue(CropImageView.DEFAULT_ASPECT_RATIO);
                return;
            }
            int iRound = Math.round((this.wavelength / this.waveSpeed) * 1000.0f);
            if (iRound < 50) {
                iRound = 50;
            }
            this.offsetAnimationJob = AwaitKt.launch$default(getCoroutineScope(), null, null, new PagerState$scrollToPage$2(this, iRound, continuation, (byte) 2), 3);
        }
    }
}
