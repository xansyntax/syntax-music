package coil3.intercept;

import coil3.EventListener$Companion$NONE$1;
import coil3.request.ImageRequest;
import coil3.request.Options;
import coil3.util.FileSystemsKt;
import java.util.List;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EngineInterceptorKt$transform$1 extends ContinuationImpl {
    public int I$0;
    public int I$1;
    public EngineInterceptor.ExecuteResult L$0;
    public ImageRequest L$1;
    public Options L$2;
    public EventListener$Companion$NONE$1 L$3;
    public List L$8;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FileSystemsKt.transform(null, null, null, null, this);
    }
}
