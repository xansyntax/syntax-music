package coil3.network.internal;

import coil3.network.SourceResponseBody;
import coil3.util.UtilsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import okio.Buffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class UtilsKt$readBuffer$1 extends ContinuationImpl {
    public SourceResponseBody L$1;
    public Buffer L$3;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return UtilsKt.readBuffer(null, this);
    }
}
