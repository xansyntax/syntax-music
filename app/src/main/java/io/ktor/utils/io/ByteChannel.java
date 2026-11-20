package io.ktor.utils.io;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CopyableThrowable;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001PB\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u0011\u0010\rJ\u0019\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u001b\u001a\u00020\u00182\u0014\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u000b0\u0016H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001f\u0010\u000fJ\u000f\u0010 \u001a\u00020\u000bH\u0002¢\u0006\u0004\b \u0010\u000fJH\u0010'\u001a\u00020\u000b\"\n\b\u0000\u0010\"\u0018\u0001*\u00020!2\u001a\b\u0004\u0010$\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0#\u0012\u0004\u0012\u00028\u00000\u00162\u000e\b\u0004\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030%H\u0082H¢\u0006\u0004\b'\u0010(J\u001c\u0010*\u001a\u00020\u000b\"\n\b\u0000\u0010)\u0018\u0001*\u00020!H\u0082\b¢\u0006\u0004\b*\u0010\u000fJ\u0019\u0010+\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b+\u0010\u0015J4\u0010-\u001a\u00020\u000b\"\n\b\u0000\u0010\"\u0018\u0001*\u00020!2\u0006\u0010,\u001a\u00028\u00002\u000e\b\u0004\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030%H\u0082\b¢\u0006\u0004\b-\u0010.R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010/\u001a\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u001e\u00109\u001a\u000607j\u0002`88\u0002X\u0082\u0004¢\u0006\f\n\u0004\b9\u0010:\u0012\u0004\b;\u0010\u000fR\u0014\u0010<\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u00104R\u0014\u0010=\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u00104R\u001a\u0010@\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b?\u0010\u000f\u001a\u0004\b>\u00101R\u001a\u0010E\u001a\u00020A8VX\u0097\u0004¢\u0006\f\u0012\u0004\bD\u0010\u000f\u001a\u0004\bB\u0010CR\u001a\u0010J\u001a\u00020F8VX\u0097\u0004¢\u0006\f\u0012\u0004\bI\u0010\u000f\u001a\u0004\bG\u0010HR\u0016\u0010M\u001a\u0004\u0018\u00010\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u00101R\u0014\u0010O\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u00101¨\u0006Q"}, d2 = {"Lio/ktor/utils/io/ByteChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/BufferedByteWriteChannel;", "", "autoFlush", "<init>", "(Z)V", "", "min", "awaitContent", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flushWriteBuffer", "()V", "close", "flushAndClose", "", "cause", "cancel", "(Ljava/lang/Throwable;)V", "Lkotlin/Function1;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnClose$ktor_io", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "invokeOnClose", "", "toString", "()Ljava/lang/String;", "rethrowCloseCauseIfNeeded", "moveFlushToReadBuffer", "Lio/ktor/utils/io/ByteChannel$Slot$Task;", "TaskType", "Lkotlin/coroutines/Continuation;", "createTask", "Lkotlin/Function0;", "shouldSleep", "sleepWhile", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Expected", "resumeSlot", "closeSlot", "slot", "trySuspend", "(Lio/ktor/utils/io/ByteChannel$Slot$Task;Lkotlin/jvm/functions/Function0;)V", "Z", "getAutoFlush", "()Z", "Lkotlinx/io/Buffer;", "flushBuffer", "Lkotlinx/io/Buffer;", "flushBufferSize", "I", "", "Lio/ktor/utils/io/locks/SynchronizedObject;", "flushBufferMutex", "Ljava/lang/Object;", "getFlushBufferMutex$annotations", "_readBuffer", "_writeBuffer", "getHasFreeSpace", "getHasFreeSpace$annotations", "hasFreeSpace", "Lkotlinx/io/Source;", "getReadBuffer", "()Lkotlinx/io/Source;", "getReadBuffer$annotations", "readBuffer", "Lkotlinx/io/Sink;", "getWriteBuffer", "()Lkotlinx/io/Sink;", "getWriteBuffer$annotations", "writeBuffer", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "isClosedForWrite", "isClosedForRead", "Slot", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ByteChannel implements ByteReadChannel, BufferedByteWriteChannel {
    volatile /* synthetic */ Object _closedCause;
    private final Buffer _readBuffer;
    private final Buffer _writeBuffer;
    private final boolean autoFlush;
    private volatile /* synthetic */ Object closeHandler;
    private final Buffer flushBuffer;
    private final Object flushBufferMutex;
    private volatile int flushBufferSize;
    volatile /* synthetic */ Object suspensionSlot;
    static final /* synthetic */ AtomicReferenceFieldUpdater suspensionSlot$FU = AtomicReferenceFieldUpdater.newUpdater(ByteChannel.class, Object.class, "suspensionSlot");
    static final /* synthetic */ AtomicReferenceFieldUpdater _closedCause$FU = AtomicReferenceFieldUpdater.newUpdater(ByteChannel.class, Object.class, "_closedCause");
    private static final /* synthetic */ AtomicReferenceFieldUpdater closeHandler$FU = AtomicReferenceFieldUpdater.newUpdater(ByteChannel.class, Object.class, "closeHandler");

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannel$awaitContent$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannel", f = "ByteChannel.kt", l = {329}, m = "awaitContent", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannel.this.awaitContent(0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannel$flush$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannel", f = "ByteChannel.kt", l = {329}, m = "flush", v = 1)
    public static final class C03311 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03311(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannel.this.flush(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannel$flushAndClose$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannel", f = "ByteChannel.kt", l = {154}, m = "flushAndClose", v = 1)
    public static final class C03321 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03321(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannel.this.flushAndClose(this);
        }
    }

    public ByteChannel(boolean z) {
        this.autoFlush = z;
        this.flushBuffer = new Buffer();
        this.flushBufferMutex = new Object();
        this.suspensionSlot = Slot.Empty.INSTANCE;
        this._readBuffer = new Buffer();
        this._writeBuffer = new Buffer();
        this._closedCause = null;
        this.closeHandler = null;
    }

    private final void closeSlot(Throwable cause) {
        Slot slot = (Slot) suspensionSlot$FU.getAndSet(this, cause != null ? new Slot.Closed(cause) : Slot.INSTANCE.getCLOSED());
        if (slot instanceof Slot.Task) {
            ((Slot.Task) slot).resume(cause);
        }
        Function1 function1 = (Function1) closeHandler$FU.getAndSet(this, null);
        if (function1 != null) {
            function1.invoke(cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeOnClose$lambda$2(ByteChannel byteChannel, Function1 function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = closeHandler$FU;
        while (!atomicReferenceFieldUpdater.compareAndSet(byteChannel, function1, null) && atomicReferenceFieldUpdater.get(byteChannel) == function1) {
        }
    }

    private final void moveFlushToReadBuffer() {
        synchronized (this.flushBufferMutex) {
            this.flushBuffer.transferTo(this._readBuffer);
            this.flushBufferSize = 0;
        }
        Slot slot = (Slot) this.suspensionSlot;
        if (slot instanceof Slot.Write) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = suspensionSlot$FU;
            Slot.Empty empty = Slot.Empty.INSTANCE;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, slot, empty)) {
                if (atomicReferenceFieldUpdater.get(this) != slot) {
                    return;
                }
            }
            ((Slot.Task) slot).resume();
        }
    }

    private final <Expected extends Slot.Task> void resumeSlot() {
        Intrinsics.throwUndefinedForReified();
        throw null;
    }

    private final void rethrowCloseCauseIfNeeded() throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }

    private final <TaskType extends Slot.Task> Object sleepWhile(Function1 function1, Function0 function0, Continuation continuation) {
        while (((Boolean) function0.invoke()).booleanValue()) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(continuation));
            cancellableContinuationImpl.initCancellability();
            Slot.Task task = (Slot.Task) function1.invoke(cancellableContinuationImpl);
            Slot slot = (Slot) this.suspensionSlot;
            if (!(slot instanceof Slot.Closed)) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = suspensionSlot$FU;
                do {
                    if (!atomicReferenceFieldUpdater.compareAndSet(this, slot, task)) {
                    }
                } while (atomicReferenceFieldUpdater.get(this) == slot);
                task.resume();
                if (cancellableContinuationImpl.getResult() == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    continuation.getClass();
                }
            }
            Intrinsics.throwUndefinedForReified();
            throw null;
        }
        return Unit.INSTANCE;
    }

    private final <TaskType extends Slot.Task> void trySuspend(TaskType slot, Function0 shouldSleep) {
        Slot slot2 = (Slot) this.suspensionSlot;
        if (!(slot2 instanceof Slot.Closed)) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = suspensionSlot$FU;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, slot2, slot)) {
                if (atomicReferenceFieldUpdater.get(this) != slot2) {
                    slot.resume();
                    return;
                }
            }
        }
        Intrinsics.throwUndefinedForReified();
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0098  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a5 A[LOOP:0: B:26:0x008f->B:32:0x00a5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:35:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:36:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:40:0x00cb A[EDGE_INSN: B:40:0x00cb->B:56:0x0110 BREAK  A[LOOP:1: B:51:0x00fe->B:74:?]] */
    /* JADX WARN: Code duplicated, block: B:41:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:50:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:54:0x010a  */
    /* JADX WARN: Code duplicated, block: B:60:0x011b  */
    /* JADX WARN: Code duplicated, block: B:70:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x0104 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0114 -> B:59:0x0117). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:70:0x0095
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // io.ktor.utils.io.ByteReadChannel
    public java.lang.Object awaitContent(int r18, kotlin.coroutines.Continuation r19) {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannel.awaitContent(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public void cancel(Throwable cause) {
        Throwable thCancellationException;
        if (this._closedCause != null) {
            return;
        }
        CloseToken closeToken = new CloseToken(cause);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _closedCause$FU;
        do {
            thCancellationException = null;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, closeToken)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        Throwable th = closeToken.origin;
        if (th != null) {
            if (th instanceof CopyableThrowable) {
                thCancellationException = ((CopyableThrowable) closeToken.origin).createCopy();
            } else {
                thCancellationException = th instanceof CancellationException ? AwaitKt.CancellationException(((CancellationException) closeToken.origin).getMessage(), closeToken.origin) : new ClosedByteChannelException(closeToken.origin);
            }
        }
        closeSlot(thCancellationException);
    }

    @Override // io.ktor.utils.io.BufferedByteWriteChannel
    public void close() {
        flushWriteBuffer();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _closedCause$FU;
        CloseToken closed = CloseTokenKt.getCLOSED();
        while (!atomicReferenceFieldUpdater.compareAndSet(this, null, closed)) {
            if (atomicReferenceFieldUpdater.get(this) != null) {
                return;
            }
        }
        closeSlot(null);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x008b  */
    /* JADX WARN: Code duplicated, block: B:34:0x009e  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:48:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:52:0x00df  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x00d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object flush(Continuation continuation) throws Throwable {
        C03311 c03311;
        ByteChannel byteChannel;
        int i;
        Slot slot;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Slot.Empty empty;
        Unit unit = Unit.INSTANCE;
        if (continuation instanceof C03311) {
            c03311 = (C03311) continuation;
            int i2 = c03311.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c03311.label = i2 - Integer.MIN_VALUE;
            } else {
                c03311 = new C03311(continuation);
            }
        } else {
            c03311 = new C03311(continuation);
        }
        Object obj = c03311.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i3 = c03311.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            rethrowCloseCauseIfNeeded();
            flushWriteBuffer();
            if (getHasFreeSpace()) {
                return unit;
            }
            byteChannel = this;
            i = 0;
        } else {
            if (i3 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i = c03311.I$0;
            byteChannel = (ByteChannel) c03311.L$0;
            ResultKt.throwOnFailure(obj);
        }
        while (!getHasFreeSpace() && this._closedCause == null) {
            c03311.L$0 = byteChannel;
            c03311.I$0 = i;
            c03311.I$1 = 0;
            c03311.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(c03311));
            cancellableContinuationImpl.initCancellability();
            Slot.Write write = new Slot.Write(cancellableContinuationImpl);
            Slot slot2 = (Slot) byteChannel.suspensionSlot;
            boolean z = slot2 instanceof Slot.Closed;
            if (z) {
                if (slot2 instanceof Slot.Write) {
                    Slot.Task task = (Slot.Task) slot2;
                    task.resume(new ConcurrentIOException(write.taskName(), task.getCreated()));
                } else if (slot2 instanceof Slot.Task) {
                    ((Slot.Task) slot2).resume();
                } else if (z) {
                    write.resume(((Slot.Closed) slot2).getCause());
                } else if (!Intrinsics.areEqual(slot2, Slot.Empty.INSTANCE)) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                if (getHasFreeSpace()) {
                    slot = (Slot) byteChannel.suspensionSlot;
                    if (slot instanceof Slot.Write) {
                        atomicReferenceFieldUpdater = suspensionSlot$FU;
                        empty = Slot.Empty.INSTANCE;
                        do {
                            if (atomicReferenceFieldUpdater.compareAndSet(byteChannel, slot, empty)) {
                                ((Slot.Task) slot).resume();
                                break;
                            }
                        } while (atomicReferenceFieldUpdater.get(byteChannel) == slot);
                    }
                } else {
                    slot = (Slot) byteChannel.suspensionSlot;
                    if (slot instanceof Slot.Write) {
                        atomicReferenceFieldUpdater = suspensionSlot$FU;
                        empty = Slot.Empty.INSTANCE;
                        do {
                            if (atomicReferenceFieldUpdater.compareAndSet(byteChannel, slot, empty)) {
                                ((Slot.Task) slot).resume();
                                break;
                            }
                        } while (atomicReferenceFieldUpdater.get(byteChannel) == slot);
                    }
                }
            } else {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = suspensionSlot$FU;
                while (true) {
                    if (atomicReferenceFieldUpdater2.compareAndSet(byteChannel, slot2, write)) {
                        if (slot2 instanceof Slot.Write) {
                            Slot.Task task2 = (Slot.Task) slot2;
                            task2.resume(new ConcurrentIOException(write.taskName(), task2.getCreated()));
                        } else if (slot2 instanceof Slot.Task) {
                            ((Slot.Task) slot2).resume();
                        } else if (z) {
                            write.resume(((Slot.Closed) slot2).getCause());
                        } else if (!Intrinsics.areEqual(slot2, Slot.Empty.INSTANCE)) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        if (getHasFreeSpace() || this._closedCause != null) {
                            slot = (Slot) byteChannel.suspensionSlot;
                            if (slot instanceof Slot.Write) {
                                atomicReferenceFieldUpdater = suspensionSlot$FU;
                                empty = Slot.Empty.INSTANCE;
                                do {
                                    if (atomicReferenceFieldUpdater.compareAndSet(byteChannel, slot, empty)) {
                                        ((Slot.Task) slot).resume();
                                        break;
                                    }
                                } while (atomicReferenceFieldUpdater.get(byteChannel) == slot);
                            }
                        }
                    } else if (atomicReferenceFieldUpdater2.get(byteChannel) != slot2) {
                        write.resume();
                    }
                }
            }
            if (cancellableContinuationImpl.getResult() == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return unit;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object flushAndClose(Continuation continuation) {
        C03321 c03321;
        Unit unit;
        if (continuation instanceof C03321) {
            c03321 = (C03321) continuation;
            int i = c03321.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03321.label = i - Integer.MIN_VALUE;
            } else {
                c03321 = new C03321(continuation);
            }
        } else {
            c03321 = new C03321(continuation);
        }
        Object obj = c03321.result;
        int i2 = c03321.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                c03321.L$0 = null;
                c03321.I$0 = 0;
                c03321.label = 1;
                Object objFlush = flush(c03321);
                Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objFlush == obj2) {
                    return obj2;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Throwable unused) {
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _closedCause$FU;
        CloseToken closed = CloseTokenKt.getCLOSED();
        do {
            boolean zCompareAndSet = atomicReferenceFieldUpdater.compareAndSet(this, null, closed);
            unit = Unit.INSTANCE;
            if (zCompareAndSet) {
                closeSlot(null);
                return unit;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return unit;
    }

    @Override // io.ktor.utils.io.BufferedByteWriteChannel
    public void flushWriteBuffer() {
        if (this._writeBuffer.exhausted()) {
            return;
        }
        synchronized (this.flushBufferMutex) {
            Buffer buffer = this._writeBuffer;
            int i = (int) buffer.sizeMut;
            this.flushBuffer.transferFrom(buffer);
            this.flushBufferSize += i;
        }
        Slot slot = (Slot) this.suspensionSlot;
        if (slot instanceof Slot.Read) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = suspensionSlot$FU;
            Slot.Empty empty = Slot.Empty.INSTANCE;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, slot, empty)) {
                if (atomicReferenceFieldUpdater.get(this) != slot) {
                    return;
                }
            }
            ((Slot.Task) slot).resume();
        }
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean getAutoFlush() {
        return this.autoFlush;
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public Throwable getClosedCause() {
        Throwable th;
        CloseToken closeToken = (CloseToken) this._closedCause;
        if (closeToken == null || (th = closeToken.origin) == null) {
            return null;
        }
        if (th instanceof CopyableThrowable) {
            return ((CopyableThrowable) closeToken.origin).createCopy();
        }
        return th instanceof CancellationException ? AwaitKt.CancellationException(((CancellationException) closeToken.origin).getMessage(), closeToken.origin) : new ClosedByteChannelException(closeToken.origin);
    }

    public final boolean getHasFreeSpace() {
        return this.flushBufferSize < 1048576;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Source getReadBuffer() throws Throwable {
        Throwable thCancellationException;
        CloseToken closeToken = (CloseToken) this._closedCause;
        if (closeToken != null) {
            Throwable th = closeToken.origin;
            if (th == null) {
                thCancellationException = null;
            } else if (th instanceof CopyableThrowable) {
                thCancellationException = ((CopyableThrowable) closeToken.origin).createCopy();
            } else {
                thCancellationException = th instanceof CancellationException ? AwaitKt.CancellationException(((CancellationException) closeToken.origin).getMessage(), closeToken.origin) : new ClosedReadChannelException(closeToken.origin);
            }
            if (thCancellationException != null) {
                throw thCancellationException;
            }
        }
        if (this._readBuffer.exhausted()) {
            moveFlushToReadBuffer();
        }
        return this._readBuffer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.ktor.utils.io.ByteWriteChannel
    public Sink getWriteBuffer() throws Throwable {
        Throwable thCancellationException;
        if (!isClosedForWrite()) {
            return this._writeBuffer;
        }
        CloseToken closeToken = (CloseToken) this._closedCause;
        Throwable th = null;
        Object[] objArr = 0;
        if (closeToken != null) {
            Throwable th2 = closeToken.origin;
            if (th2 == null) {
                thCancellationException = null;
            } else if (th2 instanceof CopyableThrowable) {
                thCancellationException = ((CopyableThrowable) closeToken.origin).createCopy();
            } else {
                thCancellationException = th2 instanceof CancellationException ? AwaitKt.CancellationException(((CancellationException) closeToken.origin).getMessage(), closeToken.origin) : new ClosedWriteChannelException(closeToken.origin);
            }
            if (thCancellationException != null) {
                throw thCancellationException;
            }
        }
        throw new ClosedWriteChannelException(th, 1, objArr == true ? 1 : 0);
    }

    public final DisposableHandle invokeOnClose$ktor_io(Function1 handler) {
        handler.getClass();
        CloseToken closeToken = (CloseToken) this._closedCause;
        final byte b = 0;
        Throwable thCancellationException = null;
        if (closeToken != null) {
            Throwable th = closeToken.origin;
            if (th != null) {
                if (th instanceof CopyableThrowable) {
                    thCancellationException = ((CopyableThrowable) closeToken.origin).createCopy();
                } else {
                    thCancellationException = th instanceof CancellationException ? AwaitKt.CancellationException(((CancellationException) closeToken.origin).getMessage(), closeToken.origin) : new ClosedByteChannelException(closeToken.origin);
                }
            }
            handler.invoke(thCancellationException);
            return new DisposableHandle() { // from class: io.ktor.utils.io.ByteChannel$$ExternalSyntheticLambda0
                @Override // kotlinx.coroutines.DisposableHandle
                public final void dispose() {
                    switch (b) {
                        case 0:
                            ByteChannel.invokeOnClose$lambda$0();
                            break;
                        default:
                            ByteChannel.invokeOnClose$lambda$1();
                            break;
                    }
                }
            };
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = closeHandler$FU;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, null, handler)) {
            if (atomicReferenceFieldUpdater.get(this) != null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Only one invokeOnClose handler is supported per channel");
                return null;
            }
        }
        CloseToken closeToken2 = (CloseToken) this._closedCause;
        if (closeToken2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = closeHandler$FU;
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, handler, null)) {
                if (atomicReferenceFieldUpdater2.get(this) != handler) {
                }
            }
            Throwable th2 = closeToken2.origin;
            if (th2 != null) {
                if (th2 instanceof CopyableThrowable) {
                    thCancellationException = ((CopyableThrowable) closeToken2.origin).createCopy();
                } else {
                    thCancellationException = th2 instanceof CancellationException ? AwaitKt.CancellationException(((CancellationException) closeToken2.origin).getMessage(), closeToken2.origin) : new ClosedByteChannelException(closeToken2.origin);
                }
            }
            handler.invoke(thCancellationException);
            final byte b2 = 1;
            return new DisposableHandle() { // from class: io.ktor.utils.io.ByteChannel$$ExternalSyntheticLambda0
                @Override // kotlinx.coroutines.DisposableHandle
                public final void dispose() {
                    switch (b2) {
                        case 0:
                            ByteChannel.invokeOnClose$lambda$0();
                            break;
                        default:
                            ByteChannel.invokeOnClose$lambda$1();
                            break;
                    }
                }
            };
        }
        return new ByteChannel$$ExternalSyntheticLambda2(this, handler, b);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public boolean isClosedForRead() {
        if (getClosedCause() == null) {
            return isClosedForWrite() && this.flushBufferSize == 0 && this._readBuffer.exhausted();
        }
        return true;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean isClosedForWrite() {
        return this._closedCause != null;
    }

    public String toString() {
        return "ByteChannel[" + hashCode() + ']';
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u0000 \u00022\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0003\b\t\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot;", "", "Companion", "Empty", "Closed", "Task", "Read", "Write", "Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "Lio/ktor/utils/io/ByteChannel$Slot$Empty;", "Lio/ktor/utils/io/ByteChannel$Slot$Task;", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface Slot {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0083\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u00020\u000fHÖ\u0081\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u00020\u0012HÖ\u0081\u0004¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "Lio/ktor/utils/io/ByteChannel$Slot;", "", "cause", "<init>", "(Ljava/lang/Throwable;)V", "component1", "()Ljava/lang/Throwable;", "copy", "(Ljava/lang/Throwable;)Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Throwable;", "getCause", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class Closed implements Slot {
            private final Throwable cause;

            public Closed(Throwable th) {
                this.cause = th;
            }

            public static /* synthetic */ Closed copy$default(Closed closed, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    th = closed.cause;
                }
                return closed.copy(th);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Throwable getCause() {
                return this.cause;
            }

            public final Closed copy(Throwable cause) {
                return new Closed(cause);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Closed) && Intrinsics.areEqual(this.cause, ((Closed) other).cause);
            }

            public final Throwable getCause() {
                return this.cause;
            }

            public int hashCode() {
                Throwable th = this.cause;
                if (th == null) {
                    return 0;
                }
                return th.hashCode();
            }

            public String toString() {
                return "Closed(cause=" + this.cause + ')';
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÖ\u0083\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u00020\tHÖ\u0081\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u00020\fHÖ\u0081\u0004¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Empty;", "Lio/ktor/utils/io/ByteChannel$Slot;", "<init>", "()V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final /* data */ class Empty implements Slot {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof Empty);
            }

            public int hashCode() {
                return -231472095;
            }

            public String toString() {
                return "Empty";
            }
        }

        static Closed getCLOSED() {
            return INSTANCE.getCLOSED();
        }

        /* JADX INFO: renamed from: getRESUME-d1pmJ48, reason: not valid java name */
        static Object m1832getRESUMEd1pmJ48() {
            return INSTANCE.m1834getRESUMEd1pmJ48();
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0006\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\u0002\u0012\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Task;", "Lio/ktor/utils/io/ByteChannel$Slot;", "", "taskName", "()Ljava/lang/String;", "", "resume", "()V", "", "throwable", "(Ljava/lang/Throwable;)V", "getCreated", "()Ljava/lang/Throwable;", "created", "Lkotlin/coroutines/Continuation;", "getContinuation", "()Lkotlin/coroutines/Continuation;", "continuation", "Lio/ktor/utils/io/ByteChannel$Slot$Read;", "Lio/ktor/utils/io/ByteChannel$Slot$Write;", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public interface Task extends Slot {
            static /* synthetic */ void resume$default(Task task, Throwable th, int i, Object obj) {
                if (obj != null) {
                    PathKt$$ExternalSyntheticBUOutline0.m$2("Super calls with default arguments not supported in this target, function: resume");
                    return;
                }
                if ((i & 1) != 0) {
                    th = null;
                }
                task.resume(th);
            }

            Continuation getContinuation();

            Throwable getCreated();

            default void resume(Throwable throwable) {
                getContinuation().resumeWith(throwable != null ? new Result.Failure(throwable) : Slot.INSTANCE.m1834getRESUMEd1pmJ48());
            }

            String taskName();

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class DefaultImpls {
                @Deprecated
                public static void resume(Task task) {
                    Task.super.resume();
                }

                @Deprecated
                public static void resume(Task task, Throwable th) {
                    Task.super.resume(th);
                }
            }

            default void resume() {
                getContinuation().resumeWith(Slot.INSTANCE.m1834getRESUMEd1pmJ48());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Read;", "Lio/ktor/utils/io/ByteChannel$Slot$Task;", "Lkotlin/coroutines/Continuation;", "", "continuation", "<init>", "(Lkotlin/coroutines/Continuation;)V", "", "taskName", "()Ljava/lang/String;", "Lkotlin/coroutines/Continuation;", "getContinuation", "()Lkotlin/coroutines/Continuation;", "", "created", "Ljava/lang/Throwable;", "getCreated", "()Ljava/lang/Throwable;", "setCreated", "(Ljava/lang/Throwable;)V", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Read implements Task {
            private final Continuation continuation;
            private Throwable created;

            public Read(Continuation continuation) {
                continuation.getClass();
                this.continuation = continuation;
                if (ByteChannel_jvmKt.getDEVELOPMENT_MODE()) {
                    int iHashCode = getContinuation().hashCode();
                    CharsKt.checkRadix(16);
                    String string = Integer.toString(iHashCode, 16);
                    string.getClass();
                    Throwable th = new Throwable("ReadTask 0x".concat(string));
                    ResultKt.stackTraceToString(th);
                    setCreated(th);
                }
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public Continuation getContinuation() {
                return this.continuation;
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public Throwable getCreated() {
                return this.created;
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public /* bridge */ void resume() {
                super.resume();
            }

            public void setCreated(Throwable th) {
                this.created = th;
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public String taskName() {
                return "read";
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public /* bridge */ void resume(Throwable th) {
                super.resume(th);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Write;", "Lio/ktor/utils/io/ByteChannel$Slot$Task;", "Lkotlin/coroutines/Continuation;", "", "continuation", "<init>", "(Lkotlin/coroutines/Continuation;)V", "", "taskName", "()Ljava/lang/String;", "Lkotlin/coroutines/Continuation;", "getContinuation", "()Lkotlin/coroutines/Continuation;", "", "created", "Ljava/lang/Throwable;", "getCreated", "()Ljava/lang/Throwable;", "setCreated", "(Ljava/lang/Throwable;)V", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Write implements Task {
            private final Continuation continuation;
            private Throwable created;

            public Write(Continuation continuation) {
                continuation.getClass();
                this.continuation = continuation;
                if (ByteChannel_jvmKt.getDEVELOPMENT_MODE()) {
                    int iHashCode = getContinuation().hashCode();
                    CharsKt.checkRadix(16);
                    String string = Integer.toString(iHashCode, 16);
                    string.getClass();
                    Throwable th = new Throwable("WriteTask 0x".concat(string));
                    ResultKt.stackTraceToString(th);
                    setCreated(th);
                }
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public Continuation getContinuation() {
                return this.continuation;
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public Throwable getCreated() {
                return this.created;
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public /* bridge */ void resume() {
                super.resume();
            }

            public void setCreated(Throwable th) {
                this.created = th;
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public String taskName() {
                return "write";
            }

            @Override // io.ktor.utils.io.ByteChannel.Slot.Task
            public /* bridge */ void resume(Throwable th) {
                super.resume(th);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR&\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\f\u0010\r\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lio/ktor/utils/io/ByteChannel$Slot$Companion;", "", "<init>", "()V", "Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "CLOSED", "Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "getCLOSED", "()Lio/ktor/utils/io/ByteChannel$Slot$Closed;", "getCLOSED$annotations", "Lkotlin/Result;", "", "RESUME", "Ljava/lang/Object;", "getRESUME-d1pmJ48", "()Ljava/lang/Object;", "getRESUME-d1pmJ48$annotations", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            private static final Closed CLOSED = new Closed(null);
            private static final Object RESUME = Unit.INSTANCE;

            private Companion() {
            }

            public final Closed getCLOSED() {
                return CLOSED;
            }

            /* JADX INFO: renamed from: getRESUME-d1pmJ48, reason: not valid java name */
            public final Object m1834getRESUMEd1pmJ48() {
                return RESUME;
            }

            public static /* synthetic */ void getCLOSED$annotations() {
            }

            /* JADX INFO: renamed from: getRESUME-d1pmJ48$annotations, reason: not valid java name */
            public static /* synthetic */ void m1833getRESUMEd1pmJ48$annotations() {
            }
        }
    }

    public ByteChannel() {
        this(false, 1, null);
    }

    public /* synthetic */ ByteChannel(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    private static /* synthetic */ void getFlushBufferMutex$annotations() {
    }

    public static /* synthetic */ void getHasFreeSpace$annotations() {
    }

    public static /* synthetic */ void getReadBuffer$annotations() {
    }

    public static /* synthetic */ void getWriteBuffer$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeOnClose$lambda$0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeOnClose$lambda$1() {
    }
}
