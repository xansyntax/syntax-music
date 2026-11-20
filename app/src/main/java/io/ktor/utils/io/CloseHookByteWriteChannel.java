package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlinx.io.Sink;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005H\u0096A¢\u0006\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0011R*\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00138\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\u001b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lio/ktor/utils/io/CloseHookByteWriteChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "delegate", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "onClose", "<init>", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/jvm/functions/Function1;)V", "flushAndClose", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cause", "cancel", "(Ljava/lang/Throwable;)V", "flush", "Lio/ktor/utils/io/ByteWriteChannel;", "Lkotlin/jvm/functions/Function1;", "", "getAutoFlush", "()Z", "autoFlush", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "isClosedForWrite", "Lkotlinx/io/Sink;", "getWriteBuffer", "()Lkotlinx/io/Sink;", "writeBuffer", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CloseHookByteWriteChannel implements ByteWriteChannel {
    private final ByteWriteChannel delegate;
    private final Function1 onClose;

    /* JADX INFO: renamed from: io.ktor.utils.io.CloseHookByteWriteChannel$flushAndClose$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.CloseHookByteWriteChannel", f = "CloseHookByteWriteChannel.kt", l = {26, 27}, m = "flushAndClose", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CloseHookByteWriteChannel.this.flushAndClose(this);
        }
    }

    public CloseHookByteWriteChannel(ByteWriteChannel byteWriteChannel, Function1 function1) {
        byteWriteChannel.getClass();
        function1.getClass();
        this.delegate = byteWriteChannel;
        this.onClose = function1;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public void cancel(Throwable cause) {
        this.delegate.cancel(cause);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object flush(Continuation continuation) {
        return this.delegate.flush(continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
    
        if (r5.invoke(r0) == r4) goto L21;
     */
    @Override // io.ktor.utils.io.ByteWriteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object flushAndClose(Continuation continuation) {
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
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ByteWriteChannel byteWriteChannel = this.delegate;
            anonymousClass1.label = 1;
            if (byteWriteChannel.flushAndClose(anonymousClass1) != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
        Function1 function1 = this.onClose;
        anonymousClass1.label = 2;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean getAutoFlush() {
        return this.delegate.getAutoFlush();
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Throwable getClosedCause() {
        return this.delegate.getClosedCause();
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Sink getWriteBuffer() {
        return this.delegate.getWriteBuffer();
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean isClosedForWrite() {
        return this.delegate.isClosedForWrite();
    }
}
