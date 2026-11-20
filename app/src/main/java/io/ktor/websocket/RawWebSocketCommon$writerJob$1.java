package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommon$writerJob$1", f = "RawWebSocketCommon.kt", l = {64, 66, 67, 86, 86, 86, 86}, m = "invokeSuspend", v = 1)
public final class RawWebSocketCommon$writerJob$1 extends SuspendLambda implements Function2 {
    Object L$0;
    int label;
    final /* synthetic */ RawWebSocketCommon this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RawWebSocketCommon$writerJob$1(RawWebSocketCommon rawWebSocketCommon, Continuation continuation) {
        super(2, continuation);
        this.this$0 = rawWebSocketCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RawWebSocketCommon$writerJob$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RawWebSocketCommon$writerJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0048  */
    /* JADX WARN: Code duplicated, block: B:23:0x004a A[Catch: all -> 0x0024, ChannelWriteException -> 0x0027, PHI: r8
      0x004a: PHI (r8v23 java.lang.Object) = (r8v0 java.lang.Object), (r8v28 java.lang.Object) binds: [B:17:0x0030, B:21:0x0046] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {ChannelWriteException -> 0x0027, all -> 0x0024, blocks: (B:9:0x0020, B:32:0x007e, B:20:0x0037, B:23:0x004a, B:25:0x004e, B:29:0x006b, B:38:0x00ab, B:40:0x00af, B:41:0x00b5, B:42:0x00cb, B:34:0x0082, B:16:0x002c, B:17:0x0030), top: B:68:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ab A[Catch: all -> 0x0024, ChannelWriteException -> 0x0027, TRY_ENTER, TryCatch #3 {ChannelWriteException -> 0x0027, all -> 0x0024, blocks: (B:9:0x0020, B:32:0x007e, B:20:0x0037, B:23:0x004a, B:25:0x004e, B:29:0x006b, B:38:0x00ab, B:40:0x00af, B:41:0x00b5, B:42:0x00cb, B:34:0x0082, B:16:0x002c, B:17:0x0030), top: B:68:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00af A[Catch: all -> 0x0024, ChannelWriteException -> 0x0027, TryCatch #3 {ChannelWriteException -> 0x0027, all -> 0x0024, blocks: (B:9:0x0020, B:32:0x007e, B:20:0x0037, B:23:0x004a, B:25:0x004e, B:29:0x006b, B:38:0x00ab, B:40:0x00af, B:41:0x00b5, B:42:0x00cb, B:34:0x0082, B:16:0x002c, B:17:0x0030), top: B:68:0x0007 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x007a -> B:32:0x007e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00af -> B:20:0x0037). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            Method dump skipped, instruction units count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommon$writerJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
