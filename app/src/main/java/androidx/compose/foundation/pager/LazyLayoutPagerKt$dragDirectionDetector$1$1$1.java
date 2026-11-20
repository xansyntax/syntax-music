package androidx.compose.foundation.pager;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.handwriting.StylusHandwritingNode;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.media3.session.MediaSessionImpl$1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutPagerKt$dragDirectionDetector$1$1$1 extends RestrictedSuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object $state;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyLayoutPagerKt$dragDirectionDetector$1$1$1(StatusLine statusLine, MediaSessionImpl$1 mediaSessionImpl$1, TextDragObserver textDragObserver, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 2;
        this.L$1 = statusLine;
        this.L$2 = mediaSessionImpl$1;
        this.$state = textDragObserver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$state;
        switch (b) {
            case 0:
                LazyLayoutPagerKt$dragDirectionDetector$1$1$1 lazyLayoutPagerKt$dragDirectionDetector$1$1$1 = new LazyLayoutPagerKt$dragDirectionDetector$1$1$1((PagerState) obj2, continuation, (byte) 0);
                lazyLayoutPagerKt$dragDirectionDetector$1$1$1.L$0 = obj;
                return lazyLayoutPagerKt$dragDirectionDetector$1$1$1;
            case 1:
                LazyLayoutPagerKt$dragDirectionDetector$1$1$1 lazyLayoutPagerKt$dragDirectionDetector$1$1$2 = new LazyLayoutPagerKt$dragDirectionDetector$1$1$1((StylusHandwritingNode) obj2, continuation, (byte) 1);
                lazyLayoutPagerKt$dragDirectionDetector$1$1$2.L$0 = obj;
                return lazyLayoutPagerKt$dragDirectionDetector$1$1$2;
            default:
                LazyLayoutPagerKt$dragDirectionDetector$1$1$1 lazyLayoutPagerKt$dragDirectionDetector$1$1$3 = new LazyLayoutPagerKt$dragDirectionDetector$1$1$1((StatusLine) this.L$1, (MediaSessionImpl$1) this.L$2, (TextDragObserver) obj2, continuation);
                lazyLayoutPagerKt$dragDirectionDetector$1$1$3.L$0 = obj;
                return lazyLayoutPagerKt$dragDirectionDetector$1$1$3;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((LazyLayoutPagerKt$dragDirectionDetector$1$1$1) create(pointerEventHandlerCoroutine, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:227:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:230:0x03e2 A[LOOP:9: B:226:0x03d3->B:230:0x03e2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:278:0x03e5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:279:0x03b7 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:187:0x031b -> B:189:0x031f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:223:0x03c6 -> B:225:0x03ca). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x01b0 -> B:89:0x01b4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instruction units count: 1036
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyLayoutPagerKt$dragDirectionDetector$1$1$1(Object obj, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$state = obj;
    }
}
