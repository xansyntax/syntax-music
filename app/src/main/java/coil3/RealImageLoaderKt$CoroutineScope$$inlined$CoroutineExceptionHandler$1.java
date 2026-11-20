package coil3;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RealImageLoaderKt$CoroutineScope$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RealImageLoaderKt$CoroutineScope$$inlined$CoroutineExceptionHandler$1(CoroutineContext.Key key, byte b) {
        super(key);
        this.$r8$classId = b;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext coroutineContext, Throwable th) {
        switch (this.$r8$classId) {
            case 0:
            case 1:
            case 2:
                break;
            default:
                if (!(th instanceof CancellationException)) {
                    Timber.Forest.getClass();
                    ConnectionPool.e$1(new Object[0]);
                }
                break;
        }
    }

    private final void handleException$androidx$compose$ui$text$font$FontListFontFamilyTypefaceAdapter$special$$inlined$CoroutineExceptionHandler$1(CoroutineContext coroutineContext, Throwable th) {
    }

    private final void handleException$coil3$RealImageLoaderKt$CoroutineScope$$inlined$CoroutineExceptionHandler$1(CoroutineContext coroutineContext, Throwable th) {
    }

    private final void handleException$com$metrolist$music$extensions$CoroutineExtKt$special$$inlined$CoroutineExceptionHandler$1(CoroutineContext coroutineContext, Throwable th) {
    }
}
