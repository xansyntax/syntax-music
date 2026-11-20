package androidx.compose.foundation;

import android.content.Context;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BorderKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ BorderKt$$ExternalSyntheticLambda1(byte b) {
        this.$r8$classId = b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        int i = 0;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((LayoutNodeDrawScope) obj).drawContent();
                return unit;
            case 1:
                DpOffset dpOffset = (DpOffset) obj;
                return new AnimationVector2D(DpOffset.m798getXD9Ej5fM(dpOffset.packedValue), DpOffset.m799getYD9Ej5fM(dpOffset.packedValue));
            case 2:
                AnimationVector2D animationVector2D = (AnimationVector2D) obj;
                return new DpOffset((((long) Float.floatToRawIntBits(animationVector2D.v2)) & 4294967295L) | (((long) Float.floatToRawIntBits(animationVector2D.v1)) << 32));
            case 3:
                Size size = (Size) obj;
                return new AnimationVector2D(Float.intBitsToFloat((int) (size.packedValue >> 32)), Float.intBitsToFloat((int) (size.packedValue & 4294967295L)));
            case 4:
                AnimationVector2D animationVector2D2 = (AnimationVector2D) obj;
                return new Size((((long) Float.floatToRawIntBits(animationVector2D2.v2)) & 4294967295L) | (((long) Float.floatToRawIntBits(animationVector2D2.v1)) << 32));
            case 5:
                Offset offset = (Offset) obj;
                return new AnimationVector2D(Float.intBitsToFloat((int) (offset.packedValue >> 32)), Float.intBitsToFloat((int) (offset.packedValue & 4294967295L)));
            case 6:
                AnimationVector2D animationVector2D3 = (AnimationVector2D) obj;
                return new Offset((((long) Float.floatToRawIntBits(animationVector2D3.v2)) & 4294967295L) | (((long) Float.floatToRawIntBits(animationVector2D3.v1)) << 32));
            case 7:
                long j = ((IntOffset) obj).packedValue;
                return new AnimationVector2D((int) (j >> 32), (int) (j & 4294967295L));
            case 8:
                AnimationVector2D animationVector2D4 = (AnimationVector2D) obj;
                return new IntOffset((((long) Math.round(animationVector2D4.v2)) & 4294967295L) | (((long) Math.round(animationVector2D4.v1)) << 32));
            case 9:
                long j2 = ((IntSize) obj).packedValue;
                return new AnimationVector2D((int) (j2 >> 32), (int) (j2 & 4294967295L));
            case 10:
                AnimationVector2D animationVector2D5 = (AnimationVector2D) obj;
                int iRound = Math.round(animationVector2D5.v1);
                if (iRound < 0) {
                    iRound = 0;
                }
                int iRound2 = Math.round(animationVector2D5.v2);
                return new IntSize((((long) iRound) << 32) | (((long) (iRound2 >= 0 ? iRound2 : 0)) & 4294967295L));
            case 11:
                Rect rect = (Rect) obj;
                return new AnimationVector4D(rect.left, rect.top, rect.right, rect.bottom);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                AnimationVector4D animationVector4D = (AnimationVector4D) obj;
                return new Rect(animationVector4D.v1, animationVector4D.v2, animationVector4D.v3, animationVector4D.v4);
            case 13:
                return Float.valueOf(((AnimationVector1D) obj).value);
            case 14:
                return unit;
            case 15:
                ((Long) obj).getClass();
                return unit;
            case 16:
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMap = (PersistentCompositionLocalHashMap) obj;
                int i2 = AndroidOverscroll_androidKt.$r8$clinit;
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = AndroidCompositionLocals_androidKt.LocalContext;
                persistentCompositionLocalHashMap.getClass();
                Context context = (Context) Stack.read(persistentCompositionLocalHashMap, staticProvidableCompositionLocal);
                Density density = (Density) Stack.read(persistentCompositionLocalHashMap, CompositionLocalsKt.LocalDensity);
                OverscrollConfiguration overscrollConfiguration = (OverscrollConfiguration) Stack.read(persistentCompositionLocalHashMap, OverscrollConfiguration_androidKt.LocalOverscrollConfiguration);
                if (overscrollConfiguration == null) {
                    return null;
                }
                return new AndroidEdgeEffectOverscrollFactory(context, density, overscrollConfiguration.drawPadding);
            case 17:
                SemanticsPropertiesKt.setProgressBarRangeInfo((SemanticsPropertyReceiver) obj, ProgressBarRangeInfo.Indeterminate);
                return unit;
            case 18:
                return new ScrollState(((Integer) obj).intValue());
            case 19:
                PointerType pointerType = (PointerType) obj;
                if (pointerType != null && pointerType.value == 2) {
                    i = 1;
                }
                return Boolean.valueOf(1 ^ i);
            case 20:
                return Float.valueOf(((Float) obj).floatValue() / 2.0f);
            case 21:
                return Boolean.TRUE;
            case 22:
                ((Integer) obj).getClass();
                return Float.valueOf(Float.NaN);
            case 23:
                return Boolean.TRUE;
            case 24:
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMap2 = (PersistentCompositionLocalHashMap) obj;
                StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = AndroidCompositionLocals_androidKt.LocalContext;
                persistentCompositionLocalHashMap2.getClass();
                if (((Context) Stack.read(persistentCompositionLocalHashMap2, staticProvidableCompositionLocal2)).getPackageManager().hasSystemFeature("android.software.leanback")) {
                    return BringIntoViewSpec_androidKt.PivotBringIntoViewSpec;
                }
                BringIntoViewSpec.Companion.getClass();
                return BringIntoViewSpec.Companion.DefaultBringIntoViewSpec;
            case 25:
                return unit;
            case 26:
                return unit;
            case 27:
                return unit;
            case 28:
                return Boolean.TRUE;
            default:
                ((Long) obj).getClass();
                return unit;
        }
    }
}
