package androidx.compose.foundation;

import androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1$1;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.text.selection.DefaultTextSelectionColors_androidKt;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.unit.IntOffset;
import coil3.network.okhttp.internal.CallsKt$await$2$1;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.random.Random;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ScrollKt$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ScrollKt$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        byte b2 = 1;
        int i = 12;
        Unit unit = Unit.INSTANCE;
        Object obj = null;
        switch (b) {
            case 0:
                return new ScrollState(0);
            case 1:
                return UUID.randomUUID().toString();
            case 2:
                return unit;
            case 3:
            case 4:
                return null;
            case 5:
                return Integer.valueOf(Random.defaultRandom.nextInt(2147418112) + 65536);
            case 6:
                return null;
            case 7:
                return Boolean.TRUE;
            case 8:
                return ArcSplineKt.Animatable$default(1.0f);
            case 9:
                return ArcSplineKt.Animatable$default(1.0f);
            case 10:
                return new Animatable(new IntOffset(0L), ArcSplineKt.IntOffsetToVector, obj, i);
            case 11:
                return new Animatable(new Color(0L), new TwoWayConverterImpl(ColorVectorConverterKt$ColorToVector$1$1.INSTANCE, new CallsKt$await$2$1(b2, ColorSpaces.Srgb)), obj, i);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return new Animatable(new TransformOrigin(ColorKt.TransformOrigin(0.5f, 0.5f)), EnterExitTransitionKt.TransformOriginVectorConverter, obj, i);
            case 13:
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = IndicationKt.LocalIndication;
                return DefaultDebugIndication.INSTANCE;
            case 14:
                return new OverscrollConfiguration();
            case 15:
            case 16:
            case 17:
                return unit;
            case 18:
                return new LazyListState(0, 0);
            case 19:
                return new LazyGridState(0, 0);
            case 20:
                return 1;
            case 21:
                return new SolidColor(5620469498617266176L);
            case 22:
                return null;
            case 23:
                return new IntOffset(0L);
            case 24:
                return new IntOffset(0L);
            case 25:
            case 26:
                return null;
            case 27:
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                return DefaultIoScheduler.INSTANCE;
            case 28:
                return null;
            default:
                return DefaultTextSelectionColors_androidKt.DefaultTextSelectionColors;
        }
    }
}
