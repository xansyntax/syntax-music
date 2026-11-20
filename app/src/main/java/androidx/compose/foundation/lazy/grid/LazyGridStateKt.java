package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.ScrollKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.OffsetKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.core.provider.CallbackWrapper;
import coil3.util.LifecyclesKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.collections.EmptyList;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LazyGridStateKt {
    public static final LazyGridMeasureResult EmptyLazyGridLayoutInfo = new LazyGridMeasureResult(null, 0, false, CropImageView.DEFAULT_ASPECT_RATIO, new LazyGridStateKt$EmptyLazyGridLayoutInfo$1(), CropImageView.DEFAULT_ASPECT_RATIO, false, AwaitKt.CoroutineScope(EmptyCoroutineContext.INSTANCE), LifecyclesKt.Density$default(), 0, new OffsetKt$$ExternalSyntheticLambda0((byte) 18), new OffsetKt$$ExternalSyntheticLambda0((byte) 19), 0, null, null, EmptyList.INSTANCE, 0, 0, 0, Orientation.Vertical, 0, 0);

    public static final LazyGridState rememberLazyGridState(Composer composer) {
        Object[] objArr = new Object[0];
        CallbackWrapper callbackWrapper = LazyGridState.Saver;
        boolean zChanged = ((GapComposer) composer).changed(0) | ((GapComposer) composer).changed(0);
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new ScrollKt$$ExternalSyntheticLambda0((byte) 19);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (LazyGridState) SaverKt.m393rememberSaveable(objArr, (Saver) callbackWrapper, (Function0) objRememberedValue, (Composer) gapComposer, 0);
    }
}
