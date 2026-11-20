package io.ktor.websocket;

import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\u001a1\u0010\u0004\u001a\u00028\u0000\"\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0000*\u00020\u00022\u0010\u0010\u0004\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u001a3\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0000*\u00020\u00022\u0010\u0010\u0004\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001c\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\fH\u0086@¢\u0006\u0004\b\n\u0010\r\u001a\u001e\u0010\u0010\u001a\u00020\t*\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001e\u0010\u0010\u001a\u00020\t*\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0087@¢\u0006\u0004\b\u0010\u0010\u0014\u001a\u001c\u0010\u0015\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Lio/ktor/websocket/WebSocketExtension;", "T", "Lio/ktor/websocket/WebSocketSession;", "Lio/ktor/websocket/WebSocketExtensionFactory;", "extension", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/websocket/WebSocketExtensionFactory;)Lio/ktor/websocket/WebSocketExtension;", "extensionOrNull", "", "content", "", "send", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Lio/ktor/websocket/WebSocketSession;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/websocket/CloseReason;", "reason", "close", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/websocket/CloseReason;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cause", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "closeExceptionally", "ktor-websockets"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class WebSocketSessionKt {

    /* JADX INFO: renamed from: io.ktor.websocket.WebSocketSessionKt$close$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.WebSocketSessionKt", f = "WebSocketSession.kt", l = {149, 150}, m = "close", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebSocketSessionKt.close((WebSocketSession) null, (CloseReason) null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
    
        if (r6.flush(r0) == r5) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object close(WebSocketSession webSocketSession, CloseReason closeReason, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Frame.Close close = new Frame.Close(closeReason);
                anonymousClass1.L$0 = webSocketSession;
                anonymousClass1.L$1 = null;
                anonymousClass1.label = 1;
                if (webSocketSession.send(close, anonymousClass1) == coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i2 == 1) {
                webSocketSession = (WebSocketSession) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            anonymousClass1.L$0 = null;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 2;
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ Object close$default(WebSocketSession webSocketSession, CloseReason closeReason, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            closeReason = new CloseReason(CloseReason.Codes.NORMAL, "");
        }
        return close(webSocketSession, closeReason, continuation);
    }

    public static final Object closeExceptionally(WebSocketSession webSocketSession, Throwable th, Continuation continuation) {
        CloseReason closeReason;
        if (th instanceof CancellationException) {
            closeReason = new CloseReason(CloseReason.Codes.NORMAL, "");
        } else {
            closeReason = new CloseReason(CloseReason.Codes.INTERNAL_ERROR, ControlFramesKt.utf8Truncate(th.toString(), ControlFramesKt.MAX_CLOSE_REASON_MESSAGE_SIZE));
        }
        Object objClose = close(webSocketSession, closeReason, continuation);
        return objClose == CoroutineSingletons.COROUTINE_SUSPENDED ? objClose : Unit.INSTANCE;
    }

    public static final <T extends WebSocketExtension<?>> T extension(WebSocketSession webSocketSession, WebSocketExtensionFactory<?, T> webSocketExtensionFactory) {
        webSocketSession.getClass();
        webSocketExtensionFactory.getClass();
        T t = (T) extensionOrNull(webSocketSession, webSocketExtensionFactory);
        if (t != null) {
            return t;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Extension ", webSocketExtensionFactory, " not found.");
        return null;
    }

    public static final <T extends WebSocketExtension<?>> T extensionOrNull(WebSocketSession webSocketSession, WebSocketExtensionFactory<?, T> webSocketExtensionFactory) {
        Object next;
        webSocketSession.getClass();
        webSocketExtensionFactory.getClass();
        Iterator<T> it = webSocketSession.getExtensions().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((WebSocketExtension) next).getFactory().getKey() != webSocketExtensionFactory.getKey());
        if (next instanceof WebSocketExtension) {
            return (T) next;
        }
        return null;
    }

    public static final Object send(WebSocketSession webSocketSession, byte[] bArr, Continuation continuation) {
        Object objSend = webSocketSession.send(new Frame.Binary(true, bArr), continuation);
        return objSend == CoroutineSingletons.COROUTINE_SUSPENDED ? objSend : Unit.INSTANCE;
    }

    public static final Object send(WebSocketSession webSocketSession, String str, Continuation continuation) {
        Object objSend = webSocketSession.send(new Frame.Text(str), continuation);
        return objSend == CoroutineSingletons.COROUTINE_SUSPENDED ? objSend : Unit.INSTANCE;
    }

    @Deprecated
    public static final Object close(WebSocketSession webSocketSession, Throwable th, Continuation continuation) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Unit unit = Unit.INSTANCE;
        if (th == null) {
            Object objClose$default = close$default(webSocketSession, null, continuation, 1, null);
            return objClose$default == coroutineSingletons ? objClose$default : unit;
        }
        Object objCloseExceptionally = closeExceptionally(webSocketSession, th, continuation);
        return objCloseExceptionally == coroutineSingletons ? objCloseExceptionally : unit;
    }
}
