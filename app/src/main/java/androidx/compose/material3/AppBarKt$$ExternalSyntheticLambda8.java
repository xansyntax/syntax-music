package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda49;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.collections.ConcurrentMap;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.ClosedFloatRange;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppBarKt$$ExternalSyntheticLambda8 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ AppBarKt$$ExternalSyntheticLambda8(Function0 function0, byte b) {
        this.$r8$classId = b;
        this.f$0 = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        byte b2 = 0;
        Unit unit = Unit.INSTANCE;
        Function0 function0 = this.f$0;
        switch (b) {
            case 0:
                ((ReusableGraphicsLayerScope) obj).setAlpha(((Number) function0.invoke()).floatValue());
                return unit;
            case 1:
                function0.invoke();
                return unit;
            case 2:
                return (Offset) function0.invoke();
            case 3:
                function0.invoke();
                return unit;
            case 4:
                SemanticsPropertyReceiver semanticsPropertyReceiver = (SemanticsPropertyReceiver) obj;
                Object objInvoke = function0.invoke();
                Float f = (Float) (Float.isNaN(((Number) objInvoke).floatValue()) ? null : objInvoke);
                SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(f != null ? f.floatValue() : 0.0f, new ClosedFloatRange(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f), 0));
                return unit;
            case 5:
                SemanticsPropertyReceiver semanticsPropertyReceiver2 = (SemanticsPropertyReceiver) obj;
                Object objInvoke2 = function0.invoke();
                Float f2 = (Float) (Float.isNaN(((Number) objInvoke2).floatValue()) ? null : objInvoke2);
                SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver2, new ProgressBarRangeInfo(f2 != null ? f2.floatValue() : 0.0f, new ClosedFloatRange(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f), 0));
                return unit;
            case 6:
                function0.invoke();
                return unit;
            case 7:
                ((Boolean) obj).booleanValue();
                function0.invoke();
                return unit;
            case 8:
                SemanticsPropertyReceiver semanticsPropertyReceiver3 = (SemanticsPropertyReceiver) obj;
                Object objInvoke3 = function0.invoke();
                Float f3 = (Float) (Float.isNaN(((Number) objInvoke3).floatValue()) ? null : objInvoke3);
                float fFloatValue = f3 != null ? f3.floatValue() : 0.0f;
                if (fFloatValue < CropImageView.DEFAULT_ASPECT_RATIO) {
                    fFloatValue = 0.0f;
                }
                if (fFloatValue > 1.0f) {
                    fFloatValue = 1.0f;
                }
                SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver3, new ProgressBarRangeInfo(fFloatValue, new ClosedFloatRange(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f), 0));
                return unit;
            case 9:
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -140266662, new PlayerMenuKt$$ExternalSyntheticLambda49(function0, b2)), 3);
                return unit;
            case 10:
                FocusStateImpl focusStateImpl = (FocusStateImpl) obj;
                focusStateImpl.getClass();
                if (focusStateImpl.isFocused()) {
                    function0.invoke();
                }
                return unit;
            case 11:
                FocusStateImpl focusStateImpl2 = (FocusStateImpl) obj;
                focusStateImpl2.getClass();
                if (focusStateImpl2.isFocused()) {
                    function0.invoke();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((Boolean) obj).booleanValue();
                function0.invoke();
                return unit;
            case 13:
                return ConcurrentMap.computeIfAbsent$lambda$0(function0, obj);
            default:
                return ByteWriteChannelOperationsKt.invokeOnCompletion$lambda$0(function0, (Throwable) obj);
        }
    }
}
