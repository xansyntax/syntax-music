package androidx.compose.foundation.gestures;

import com.yalantis.ucrop.view.CropImageView;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$FloatRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollExtensionsKt$animateScrollBy$1 extends ContinuationImpl {
    public Ref$FloatRef L$0;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ScrollableKt.animateScrollBy(null, CropImageView.DEFAULT_ASPECT_RATIO, null, this);
    }
}
