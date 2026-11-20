package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.internal.InlineClassHelperKt;
import coil3.util.UtilsKt;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VelocityTracker1D {
    public int index;
    public final boolean isDataDifferential;
    public final int minSampleSize;
    public final float[] reusableDataPointsArray;
    public final float[] reusableTimeArray;
    public final float[] reusableVelocityCoefficients;
    public final DataPointAtTime[] samples;
    public final Strategy strategy;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Strategy {
        public static final /* synthetic */ Strategy[] $VALUES;
        public static final Strategy Impulse;
        public static final Strategy Lsq2;

        static {
            Strategy strategy = new Strategy("Lsq2", 0);
            Lsq2 = strategy;
            Strategy strategy2 = new Strategy("Impulse", 1);
            Impulse = strategy2;
            $VALUES = new Strategy[]{strategy, strategy2};
        }

        public static Strategy valueOf(String str) {
            return (Strategy) Enum.valueOf(Strategy.class, str);
        }

        public static Strategy[] values() {
            return (Strategy[]) $VALUES.clone();
        }
    }

    public VelocityTracker1D(boolean z, Strategy strategy) {
        int i;
        this.isDataDifferential = z;
        this.strategy = strategy;
        if (z && strategy.equals(Strategy.Lsq2)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Lsq2 not (yet) supported for differential axes");
            throw null;
        }
        int iOrdinal = strategy.ordinal();
        if (iOrdinal == 0) {
            i = 3;
        } else {
            if (iOrdinal != 1) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                throw null;
            }
            i = 2;
        }
        this.minSampleSize = i;
        this.samples = new DataPointAtTime[20];
        this.reusableDataPointsArray = new float[20];
        this.reusableTimeArray = new float[20];
        this.reusableVelocityCoefficients = new float[3];
    }

    public final void addDataPoint(long j, float f) {
        int i = (this.index + 1) % 20;
        this.index = i;
        DataPointAtTime[] dataPointAtTimeArr = this.samples;
        DataPointAtTime dataPointAtTime = dataPointAtTimeArr[i];
        if (dataPointAtTime != null) {
            dataPointAtTime.time = j;
            dataPointAtTime.dataPoint = f;
        } else {
            DataPointAtTime dataPointAtTime2 = new DataPointAtTime();
            dataPointAtTime2.time = j;
            dataPointAtTime2.dataPoint = f;
            dataPointAtTimeArr[i] = dataPointAtTime2;
        }
    }

    public final float calculateVelocity(float f) {
        Strategy strategy;
        float[] fArr;
        float[] fArr2;
        float f2;
        boolean z;
        int i;
        float f3;
        float fSignum;
        float f4 = CropImageView.DEFAULT_ASPECT_RATIO;
        if (f <= CropImageView.DEFAULT_ASPECT_RATIO) {
            InlineClassHelperKt.throwIllegalStateException("maximumVelocity should be a positive value. You specified=" + f);
        }
        int i2 = this.index;
        DataPointAtTime[] dataPointAtTimeArr = this.samples;
        DataPointAtTime dataPointAtTime = dataPointAtTimeArr[i2];
        if (dataPointAtTime == null) {
            f3 = 0.0f;
            f2 = 0.0f;
        } else {
            int i3 = 0;
            DataPointAtTime dataPointAtTime2 = dataPointAtTime;
            while (true) {
                DataPointAtTime dataPointAtTime3 = dataPointAtTimeArr[i2];
                boolean z2 = this.isDataDifferential;
                strategy = this.strategy;
                fArr = this.reusableDataPointsArray;
                fArr2 = this.reusableTimeArray;
                if (dataPointAtTime3 == null) {
                    f2 = f4;
                    z = z2;
                    i = 1;
                    break;
                }
                long j = dataPointAtTime.time;
                f2 = f4;
                int i4 = i2;
                long j2 = dataPointAtTime3.time;
                float f5 = j - j2;
                z = z2;
                i = 1;
                float fAbs = Math.abs(j2 - dataPointAtTime2.time);
                dataPointAtTime2 = (strategy == Strategy.Lsq2 || z) ? dataPointAtTime3 : dataPointAtTime;
                if (f5 > 100.0f || fAbs > 40.0f) {
                    break;
                }
                fArr[i3] = dataPointAtTime3.dataPoint;
                fArr2[i3] = -f5;
                i2 = (i4 == 0 ? 20 : i4) - 1;
                i3++;
                if (i3 >= 20) {
                    break;
                }
                f4 = f2;
            }
            if (i3 >= this.minSampleSize) {
                int iOrdinal = strategy.ordinal();
                if (iOrdinal == 0) {
                    try {
                        float[] fArr3 = this.reusableVelocityCoefficients;
                        UtilsKt.polyFitLeastSquares(fArr2, fArr, i3, fArr3);
                        fSignum = fArr3[1];
                    } catch (IllegalArgumentException unused) {
                        fSignum = f2;
                    }
                } else {
                    if (iOrdinal != i) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return f2;
                    }
                    int i5 = i3 - i;
                    float f6 = fArr2[i5];
                    int i6 = i5;
                    float fAbs2 = f2;
                    while (i6 > 0) {
                        int i7 = i6 - 1;
                        float f7 = fArr2[i7];
                        if (f6 != f7) {
                            float f8 = (z ? -fArr[i7] : fArr[i6] - fArr[i7]) / (f6 - f7);
                            fAbs2 += Math.abs(f8) * (f8 - (Math.signum(fAbs2) * ((float) Math.sqrt(Math.abs(fAbs2) * 2.0f))));
                            if (i6 == i5) {
                                fAbs2 *= 0.5f;
                            }
                        }
                        i6--;
                        f6 = f7;
                    }
                    fSignum = Math.signum(fAbs2) * ((float) Math.sqrt(Math.abs(fAbs2) * 2.0f));
                }
                f3 = fSignum * 1000.0f;
            } else {
                f3 = f2;
            }
        }
        if (f3 == f2 || Float.isNaN(f3)) {
            return f2;
        }
        if (f3 <= f2) {
            float f9 = -f;
            if (f3 < f9) {
                return f9;
            }
        } else if (f3 > f) {
            f3 = f;
        }
        return f3;
    }

    public /* synthetic */ VelocityTracker1D() {
        this(false, Strategy.Lsq2);
    }

    public VelocityTracker1D(int i) {
        this(true, Strategy.Impulse);
    }
}
