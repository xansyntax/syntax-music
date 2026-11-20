package coil3.compose;

import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.time.Duration;
import kotlin.time.MonotonicTimeSource;
import kotlin.time.TimeSource$Monotonic$ValueTimeMark;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CrossfadePainter extends Painter {
    public BlendModeColorFilter colorFilter;
    public final ContentScale contentScale;
    public final long duration;
    public final Painter end;
    public final boolean fadeStart;
    public final long intrinsicSize;
    public boolean isDone;
    public Painter start;
    public TimeSource$Monotonic$ValueTimeMark startTime;
    public final ParcelableSnapshotMutableIntState invalidateTick$delegate = new ParcelableSnapshotMutableIntState(0);
    public float maxAlpha = 1.0f;

    /* JADX WARN: Code duplicated, block: B:20:0x0044  */
    /* JADX WARN: Code duplicated, block: B:23:0x0081  */
    public CrossfadePainter(Painter painter, Painter painter2, ContentScale contentScale, long j, boolean z, boolean z2) {
        this.end = painter2;
        this.contentScale = contentScale;
        this.duration = j;
        this.fadeStart = z;
        this.start = painter;
        long jMo573getIntrinsicSizeNHjbRc = painter != null ? painter.mo573getIntrinsicSizeNHjbRc() : 0L;
        long jMo573getIntrinsicSizeNHjbRc2 = painter2 != null ? painter2.mo573getIntrinsicSizeNHjbRc() : 0L;
        boolean z3 = jMo573getIntrinsicSizeNHjbRc != 9205357640488583168L;
        boolean z4 = jMo573getIntrinsicSizeNHjbRc2 != 9205357640488583168L;
        if (z2) {
            if (z4) {
                jMo573getIntrinsicSizeNHjbRc = jMo573getIntrinsicSizeNHjbRc2;
            } else if (!z3) {
                if (z3) {
                    jMo573getIntrinsicSizeNHjbRc = 9205357640488583168L;
                } else {
                    jMo573getIntrinsicSizeNHjbRc = 9205357640488583168L;
                }
            }
        } else if (z3 || !z4) {
            jMo573getIntrinsicSizeNHjbRc = 9205357640488583168L;
        } else {
            jMo573getIntrinsicSizeNHjbRc = (((long) Float.floatToRawIntBits(Math.max(Float.intBitsToFloat((int) (jMo573getIntrinsicSizeNHjbRc >> 32)), Float.intBitsToFloat((int) (jMo573getIntrinsicSizeNHjbRc2 >> 32))))) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(Math.max(Float.intBitsToFloat((int) (jMo573getIntrinsicSizeNHjbRc & 4294967295L)), Float.intBitsToFloat((int) (jMo573getIntrinsicSizeNHjbRc2 & 4294967295L))))));
        }
        this.intrinsicSize = jMo573getIntrinsicSizeNHjbRc;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean applyAlpha(float f) {
        this.maxAlpha = f;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean applyColorFilter(BlendModeColorFilter blendModeColorFilter) {
        this.colorFilter = blendModeColorFilter;
        return true;
    }

    public final void drawPainter(LayoutNodeDrawScope layoutNodeDrawScope, Painter painter, float f) {
        if (painter == null || f <= CropImageView.DEFAULT_ASPECT_RATIO) {
            return;
        }
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        long jMo556getSizeNHjbRc = canvasDrawScope.mo556getSizeNHjbRc();
        long jMo573getIntrinsicSizeNHjbRc = painter.mo573getIntrinsicSizeNHjbRc();
        long jM625timesUQTWf7w = (jMo573getIntrinsicSizeNHjbRc == 9205357640488583168L || Size.m449isEmptyimpl(jMo573getIntrinsicSizeNHjbRc) || jMo556getSizeNHjbRc == 9205357640488583168L || Size.m449isEmptyimpl(jMo556getSizeNHjbRc)) ? jMo556getSizeNHjbRc : RulerKt.m625timesUQTWf7w(jMo573getIntrinsicSizeNHjbRc, this.contentScale.mo597computeScaleFactorH7hwNQA(jMo573getIntrinsicSizeNHjbRc, jMo556getSizeNHjbRc));
        if (jMo556getSizeNHjbRc == 9205357640488583168L || Size.m449isEmptyimpl(jMo556getSizeNHjbRc)) {
            painter.m575drawx_KDEd0(layoutNodeDrawScope, jM625timesUQTWf7w, f, this.colorFilter);
            return;
        }
        long j = jM625timesUQTWf7w;
        float fIntBitsToFloat = (Float.intBitsToFloat((int) (jMo556getSizeNHjbRc >> 32)) - Float.intBitsToFloat((int) (j >> 32))) / 2.0f;
        float fIntBitsToFloat2 = (Float.intBitsToFloat((int) (jMo556getSizeNHjbRc & 4294967295L)) - Float.intBitsToFloat((int) (4294967295L & j))) / 2.0f;
        ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).inset(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat, fIntBitsToFloat2);
        try {
            painter.m575drawx_KDEd0(layoutNodeDrawScope, j, f, this.colorFilter);
        } finally {
            float f2 = -fIntBitsToFloat;
            float f3 = -fIntBitsToFloat2;
            ((DrawResult) canvasDrawScope.drawContext.mSpanFactory).inset(f2, f3, f2, f3);
        }
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public final long mo573getIntrinsicSizeNHjbRc() {
        return this.intrinsicSize;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void onDraw(LayoutNodeDrawScope layoutNodeDrawScope) {
        boolean z = this.isDone;
        Painter painter = this.end;
        if (z) {
            drawPainter(layoutNodeDrawScope, painter, this.maxAlpha);
            return;
        }
        TimeSource$Monotonic$ValueTimeMark timeSource$Monotonic$ValueTimeMark = this.startTime;
        if (timeSource$Monotonic$ValueTimeMark == null) {
            timeSource$Monotonic$ValueTimeMark = new TimeSource$Monotonic$ValueTimeMark(MonotonicTimeSource.read());
            this.startTime = timeSource$Monotonic$ValueTimeMark;
        }
        float fM1887getInWholeMillisecondsimpl = Duration.m1887getInWholeMillisecondsimpl(TimeSource$Monotonic$ValueTimeMark.m1894elapsedNowUwyO8pc(timeSource$Monotonic$ValueTimeMark.reading)) / Duration.m1887getInWholeMillisecondsimpl(this.duration);
        float fCoerceIn = UuidKt.coerceIn(fM1887getInWholeMillisecondsimpl, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
        float f = this.maxAlpha;
        float f2 = fCoerceIn * f;
        if (this.fadeStart) {
            f -= f2;
        }
        this.isDone = fM1887getInWholeMillisecondsimpl >= 1.0f;
        drawPainter(layoutNodeDrawScope, this.start, f);
        drawPainter(layoutNodeDrawScope, painter, f2);
        if (this.isDone) {
            this.start = null;
        } else {
            ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.invalidateTick$delegate;
            parcelableSnapshotMutableIntState.setIntValue(parcelableSnapshotMutableIntState.getIntValue() + 1);
        }
    }
}
