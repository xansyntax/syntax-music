package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ScrollKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.core.provider.CallbackWrapper;
import coil3.util.LifecyclesKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.collections.EmptyList;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LazyListStateKt {
    public static final LazyListMeasureResult EmptyLazyListMeasureResult = new LazyListMeasureResult(null, 0, false, CropImageView.DEFAULT_ASPECT_RATIO, new LazyListStateKt$EmptyLazyListMeasureResult$1(), CropImageView.DEFAULT_ASPECT_RATIO, false, AwaitKt.CoroutineScope(EmptyCoroutineContext.INSTANCE), LifecyclesKt.Density$default(), ConstraintsKt.Constraints$default(0, 0, 0, 0, 15), 0, EmptyList.INSTANCE, 0, 0, 0, Orientation.Vertical, 0, 0);

    public static final LazyListState rememberLazyListState(Composer composer) {
        Object[] objArr = new Object[0];
        CallbackWrapper callbackWrapper = LazyListState.Saver;
        boolean zChanged = ((GapComposer) composer).changed(0) | ((GapComposer) composer).changed(0);
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new ScrollKt$$ExternalSyntheticLambda0((byte) 18);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (LazyListState) SaverKt.m393rememberSaveable(objArr, (Saver) callbackWrapper, (Function0) objRememberedValue, (Composer) gapComposer, 0);
    }
}
