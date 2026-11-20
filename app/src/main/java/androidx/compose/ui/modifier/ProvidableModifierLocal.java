package androidx.compose.ui.modifier;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.contextmenu.ContextMenuPopupPositionProviderKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ProvidableModifierLocal implements PopupPositionProvider {
    public final Function0 defaultFactory;

    public /* synthetic */ ProvidableModifierLocal(Function0 function0) {
        this.defaultFactory = function0;
    }

    /* JADX INFO: renamed from: decodeToFloat-sgRZ0Mg, reason: not valid java name */
    public static float m627decodeToFloatsgRZ0Mg(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public long mo210calculatePositionllwVHH4(long j, long j2, IntRect intRect, LayoutDirection layoutDirection) {
        long j3 = ((IntOffset) this.defaultFactory.invoke()).packedValue;
        return (((long) ContextMenuPopupPositionProviderKt.alignPopupAxis(intRect.top + ((int) (j3 & 4294967295L)), (int) (j2 & 4294967295L), (int) (j & 4294967295L), true)) & 4294967295L) | (((long) ContextMenuPopupPositionProviderKt.alignPopupAxis(intRect.left + ((int) (j3 >> 32)), (int) (j2 >> 32), (int) (j >> 32), layoutDirection == LayoutDirection.Ltr)) << 32);
    }

    /* JADX INFO: renamed from: decode-sgRZ0Mg, reason: not valid java name */
    public Object m628decodesgRZ0Mg(long j) {
        return Float.valueOf(m627decodeToFloatsgRZ0Mg(j));
    }

    /* JADX INFO: renamed from: encode-sYkar0Y, reason: not valid java name */
    public long m629encodesYkar0Y(Object obj) {
        return Float.floatToRawIntBits(((Number) obj).floatValue());
    }

    /* JADX INFO: renamed from: isLowScrollingDelta-sgRZ0Mg, reason: not valid java name */
    public boolean m630isLowScrollingDeltasgRZ0Mg(long j) {
        return Math.abs(m627decodeToFloatsgRZ0Mg(j)) < 0.5f;
    }

    /* JADX INFO: renamed from: minus-donscBA, reason: not valid java name */
    public long m631minusdonscBA(long j, long j2) {
        return Float.floatToRawIntBits(m627decodeToFloatsgRZ0Mg(j) - m627decodeToFloatsgRZ0Mg(j2));
    }

    public AnimationState newAnimationState() {
        return ArcSplineKt.AnimationState$default(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 30);
    }

    /* JADX INFO: renamed from: normalize-uqq3eFI, reason: not valid java name */
    public long m632normalizeuqq3eFI(long j) {
        return Float.floatToRawIntBits(Math.signum(m627decodeToFloatsgRZ0Mg(j)));
    }

    /* JADX INFO: renamed from: plus-donscBA, reason: not valid java name */
    public long m633plusdonscBA(long j, long j2) {
        return Float.floatToRawIntBits(m627decodeToFloatsgRZ0Mg(j2) + m627decodeToFloatsgRZ0Mg(j));
    }

    /* JADX INFO: renamed from: size-sgRZ0Mg, reason: not valid java name */
    public float m634sizesgRZ0Mg(long j) {
        return Math.abs(m627decodeToFloatsgRZ0Mg(j));
    }

    /* JADX INFO: renamed from: times-uGREC7s, reason: not valid java name */
    public long m635timesuGREC7s(long j, float f) {
        return Float.floatToRawIntBits(m627decodeToFloatsgRZ0Mg(j) * f);
    }

    /* JADX INFO: renamed from: toOffset-GbI52rc, reason: not valid java name */
    public long m636toOffsetGbI52rc(long j) {
        float fM627decodeToFloatsgRZ0Mg = m627decodeToFloatsgRZ0Mg(j);
        if (!((Boolean) this.defaultFactory.invoke()).booleanValue()) {
            return (((long) Float.floatToRawIntBits(fM627decodeToFloatsgRZ0Mg)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)));
        }
        return (((long) Float.floatToRawIntBits(fM627decodeToFloatsgRZ0Mg)) & 4294967295L) | (Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO) << 32);
    }

    /* JADX INFO: renamed from: toScrollValue-Yk_gXsc, reason: not valid java name */
    public long m637toScrollValueYk_gXsc(long j) {
        boolean zBooleanValue = ((Boolean) this.defaultFactory.invoke()).booleanValue();
        int i = (int) (4294967295L & j);
        float fAbs = Math.abs(Float.intBitsToFloat(i));
        int i2 = (int) (j >> 32);
        float fAbs2 = Math.abs(Float.intBitsToFloat(i2));
        float fIntBitsToFloat = CropImageView.DEFAULT_ASPECT_RATIO;
        if (fAbs >= fAbs2) {
            if (zBooleanValue) {
                fIntBitsToFloat = Float.intBitsToFloat(i);
            }
        } else if (!zBooleanValue) {
            fIntBitsToFloat = Float.intBitsToFloat(i2);
        }
        return Float.floatToRawIntBits(fIntBitsToFloat);
    }
}
