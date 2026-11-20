package io.ktor.network.selector;

import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelector;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.text.CharsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00017B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\rH\u0082H¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0017\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\tH\u0014¢\u0006\u0004\b\u001c\u0010\u001bJ\u001c\u0010\u001d\u001a\u0004\u0018\u00010\t*\b\u0012\u0004\u0012\u00020\t0\bH\u0082@¢\u0006\u0004\b\u001d\u0010\u001eJ\u001c\u0010\u001f\u001a\u0004\u0018\u00010\t*\b\u0012\u0004\u0012\u00020\t0\bH\u0082@¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b \u0010\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R&\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0*0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010(R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u00068"}, d2 = {"Lio/ktor/network/selector/ActorSelectorManager;", "Lio/ktor/network/selector/SelectorManagerSupport;", "Ljava/io/Closeable;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "Lio/ktor/network/selector/LockFreeMPSCQueue;", "Lio/ktor/network/selector/Selectable;", "mb", "Ljava/nio/channels/Selector;", "selector", "", "process", "(Lio/ktor/network/selector/LockFreeMPSCQueue;Ljava/nio/channels/Selector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "select", "(Ljava/nio/channels/Selector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectWakeup", "()V", "processInterests", "(Lio/ktor/network/selector/LockFreeMPSCQueue;Ljava/nio/channels/Selector;)V", "selectable", "notifyClosed", "(Lio/ktor/network/selector/Selectable;)V", "publishInterest", "receiveOrNull", "(Lio/ktor/network/selector/LockFreeMPSCQueue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveOrNullSuspend", "close", "selectorRef", "Ljava/nio/channels/Selector;", "Ljava/util/concurrent/atomic/AtomicLong;", "wakeup", "Ljava/util/concurrent/atomic/AtomicLong;", "", "inSelect", "Z", "Lio/ktor/network/selector/ActorSelectorManager$ContinuationHolder;", "Lkotlin/coroutines/Continuation;", "continuation", "Lio/ktor/network/selector/ActorSelectorManager$ContinuationHolder;", "closed", "selectionQueue", "Lio/ktor/network/selector/LockFreeMPSCQueue;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/DisposableHandle;", "parentCancellationHandler", "Lkotlinx/coroutines/DisposableHandle;", "ContinuationHolder", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ActorSelectorManager extends SelectorManagerSupport implements Closeable, CoroutineScope {
    private volatile boolean closed;
    private final ContinuationHolder<Unit, Continuation> continuation;
    private final CoroutineContext coroutineContext;
    private volatile boolean inSelect;
    private volatile DisposableHandle parentCancellationHandler;
    private final LockFreeMPSCQueue<Selectable> selectionQueue;
    private volatile Selector selectorRef;
    private final AtomicLong wakeup;

    /* JADX INFO: renamed from: io.ktor.network.selector.ActorSelectorManager$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.selector.ActorSelectorManager$2", f = "ActorSelectorManager.kt", l = {58}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        public AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ActorSelectorManager.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            AbstractSelector abstractSelectorOpenSelector;
            ActorSelectorManager actorSelectorManager;
            Closeable closeable;
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    abstractSelectorOpenSelector = ActorSelectorManager.this.getProvider().openSelector();
                    if (abstractSelectorOpenSelector == null) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("openSelector() = null");
                        return null;
                    }
                    ActorSelectorManager.this.selectorRef = abstractSelectorOpenSelector;
                    actorSelectorManager = ActorSelectorManager.this;
                    try {
                        LockFreeMPSCQueue lockFreeMPSCQueue = actorSelectorManager.selectionQueue;
                        this.L$0 = null;
                        this.L$1 = abstractSelectorOpenSelector;
                        this.L$2 = actorSelectorManager;
                        this.L$3 = abstractSelectorOpenSelector;
                        this.I$0 = 0;
                        this.label = 1;
                        Object objProcess = actorSelectorManager.process(lockFreeMPSCQueue, abstractSelectorOpenSelector, this);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objProcess == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        closeable = abstractSelectorOpenSelector;
                        actorSelectorManager.closed = true;
                        actorSelectorManager.selectionQueue.close();
                    } catch (Throwable th) {
                        th = th;
                        closeable = abstractSelectorOpenSelector;
                        actorSelectorManager.closed = true;
                        actorSelectorManager.selectionQueue.close();
                        actorSelectorManager.cancelAllSuspensions(abstractSelectorOpenSelector, th);
                        actorSelectorManager.closed = true;
                        actorSelectorManager.selectionQueue.close();
                    }
                } else {
                    if (i != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    abstractSelectorOpenSelector = (AbstractSelector) this.L$3;
                    actorSelectorManager = (ActorSelectorManager) this.L$2;
                    closeable = (Closeable) this.L$1;
                    try {
                        ResultKt.throwOnFailure(obj);
                        actorSelectorManager.closed = true;
                        actorSelectorManager.selectionQueue.close();
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            actorSelectorManager.closed = true;
                            actorSelectorManager.selectionQueue.close();
                            actorSelectorManager.cancelAllSuspensions(abstractSelectorOpenSelector, th);
                            actorSelectorManager.closed = true;
                            actorSelectorManager.selectionQueue.close();
                        } catch (Throwable th3) {
                            actorSelectorManager.closed = true;
                            actorSelectorManager.selectionQueue.close();
                            actorSelectorManager.selectorRef = null;
                            actorSelectorManager.cancelAllSuspensions(abstractSelectorOpenSelector, (Throwable) null);
                            throw th3;
                        }
                    }
                }
                actorSelectorManager.selectorRef = null;
                actorSelectorManager.cancelAllSuspensions(abstractSelectorOpenSelector, (Throwable) null);
                while (true) {
                    Selectable selectable = (Selectable) actorSelectorManager.selectionQueue.removeFirstOrNull();
                    if (selectable == null) {
                        CharsKt.closeFinally(closeable, null);
                        return Unit.INSTANCE;
                    }
                    actorSelectorManager.cancelAllSuspensions(selectable, new ClosedSendChannelException("Failed to apply interest: selector closed"));
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    CharsKt.closeFinally(closeable, th4);
                    throw th5;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00028\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"Lio/ktor/network/selector/ActorSelectorManager$ContinuationHolder;", "R", "Lkotlin/coroutines/Continuation;", "C", "", "<init>", "()V", "value", "", "resume", "(Ljava/lang/Object;)Z", "continuation", "Lkotlin/Function0;", "condition", "suspendIf", "(Lkotlin/coroutines/Continuation;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicReference;", "ref", "Ljava/util/concurrent/atomic/AtomicReference;", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ContinuationHolder<R, C extends Continuation> {
        private final AtomicReference<C> ref = new AtomicReference<>(null);

        public final boolean resume(R value) {
            C andSet = this.ref.getAndSet(null);
            if (andSet == null) {
                return false;
            }
            andSet.resumeWith(value);
            return true;
        }

        public final Object suspendIf(C continuation, Function0 condition) {
            continuation.getClass();
            condition.getClass();
            if (!((Boolean) condition.invoke()).booleanValue()) {
                return null;
            }
            AtomicReference atomicReference = this.ref;
            while (!atomicReference.compareAndSet(null, continuation)) {
                if (atomicReference.get() != null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Continuation is already set");
                    return null;
                }
            }
            if (!((Boolean) condition.invoke()).booleanValue()) {
                AtomicReference atomicReference2 = this.ref;
                while (!atomicReference2.compareAndSet(continuation, null)) {
                    if (atomicReference2.get() != continuation) {
                    }
                }
                return null;
            }
            return CoroutineSingletons.COROUTINE_SUSPENDED;
        }
    }

    /* JADX INFO: renamed from: io.ktor.network.selector.ActorSelectorManager$process$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.selector.ActorSelectorManager", f = "ActorSelectorManager.kt", l = {84, 88, 104}, m = "process", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ActorSelectorManager.this.process(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.network.selector.ActorSelectorManager$receiveOrNullSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.selector.ActorSelectorManager", f = "ActorSelectorManager.kt", l = {182}, m = "receiveOrNullSuspend", v = 1)
    public static final class C03161 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03161(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ActorSelectorManager.this.receiveOrNullSuspend(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.network.selector.ActorSelectorManager$select$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.selector.ActorSelectorManager", f = "ActorSelectorManager.kt", l = {226}, m = "select", v = 1)
    public static final class C03171 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03171(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ActorSelectorManager.this.select(null, this);
        }
    }

    public ActorSelectorManager(CoroutineContext coroutineContext) {
        coroutineContext.getClass();
        this.wakeup = new AtomicLong();
        this.continuation = new ContinuationHolder<>();
        this.selectionQueue = new LockFreeMPSCQueue<>();
        this.coroutineContext = coroutineContext.plus(new CoroutineName("selector"));
        Job job = (Job) coroutineContext.get(Job.Key.$$INSTANCE);
        this.parentCancellationHandler = job != null ? job.invokeOnCompletion(true, true, new MimesKt$$ExternalSyntheticLambda0((byte) 29, this)) : null;
        AwaitKt.launch$default(this, null, null, new AnonymousClass2(null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(ActorSelectorManager actorSelectorManager, Throwable th) {
        if (th != null) {
            actorSelectorManager.close();
        }
        return Unit.INSTANCE;
    }

    private final Object dispatchIfNeeded(Continuation continuation) {
        AwaitKt.yield(continuation);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:21:0x0069  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:37:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:50:0x00dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x00c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0089 -> B:19:0x0065). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00a3 -> B:19:0x0065). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00b3 -> B:19:0x0065). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00e8 -> B:44:0x00eb). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object process(io.ktor.network.selector.LockFreeMPSCQueue<io.ktor.network.selector.Selectable> r9, java.nio.channels.Selector r10, kotlin.coroutines.Continuation r11) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.selector.ActorSelectorManager.process(io.ktor.network.selector.LockFreeMPSCQueue, java.nio.channels.Selector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void processInterests(LockFreeMPSCQueue<Selectable> mb, Selector selector) {
        while (true) {
            Selectable selectableRemoveFirstOrNull = mb.removeFirstOrNull();
            if (selectableRemoveFirstOrNull == null) {
                return;
            } else {
                applyInterest(selector, selectableRemoveFirstOrNull);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object receiveOrNull(LockFreeMPSCQueue<Selectable> lockFreeMPSCQueue, Continuation continuation) {
        Selectable selectableRemoveFirstOrNull = lockFreeMPSCQueue.removeFirstOrNull();
        return selectableRemoveFirstOrNull == null ? receiveOrNullSuspend(lockFreeMPSCQueue, continuation) : selectableRemoveFirstOrNull;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object receiveOrNullSuspend(LockFreeMPSCQueue<Selectable> lockFreeMPSCQueue, Continuation continuation) {
        C03161 c03161;
        Object obj;
        if (continuation instanceof C03161) {
            c03161 = (C03161) continuation;
            int i = c03161.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03161.label = i - Integer.MIN_VALUE;
            } else {
                c03161 = new C03161(continuation);
            }
        } else {
            c03161 = new C03161(continuation);
        }
        Object obj2 = c03161.result;
        Object obj3 = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = c03161.label;
        if (i2 != 0) {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            lockFreeMPSCQueue = (LockFreeMPSCQueue) c03161.L$0;
        }
        ResultKt.throwOnFailure(obj2);
        do {
            Selectable selectableRemoveFirstOrNull = lockFreeMPSCQueue.removeFirstOrNull();
            if (selectableRemoveFirstOrNull != null) {
                return selectableRemoveFirstOrNull;
            }
            if (this.closed) {
                return null;
            }
            c03161.L$0 = lockFreeMPSCQueue;
            c03161.L$1 = null;
            c03161.label = 1;
            ContinuationHolder<Unit, Continuation> continuationHolder = this.continuation;
            if (!lockFreeMPSCQueue.isEmpty() || this.closed) {
                obj = null;
            } else {
                AtomicReference atomicReference = ((ContinuationHolder) continuationHolder).ref;
                while (!atomicReference.compareAndSet(null, c03161)) {
                    if (atomicReference.get() != null) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Continuation is already set");
                        return null;
                    }
                }
                if (!lockFreeMPSCQueue.isEmpty() || this.closed) {
                    AtomicReference atomicReference2 = ((ContinuationHolder) continuationHolder).ref;
                    while (true) {
                        if (atomicReference2.compareAndSet(c03161, null)) {
                            obj = null;
                        } else if (atomicReference2.get() != c03161) {
                        }
                    }
                }
                obj = CoroutineSingletons.COROUTINE_SUSPENDED;
            }
            if (obj == null) {
                obj = Unit.INSTANCE;
            }
        } while (obj != obj3);
        return obj3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object select(Selector selector, Continuation continuation) throws IOException {
        C03171 c03171;
        int iSelectNow;
        if (continuation instanceof C03171) {
            c03171 = (C03171) continuation;
            int i = c03171.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03171.label = i - Integer.MIN_VALUE;
            } else {
                c03171 = new C03171(continuation);
            }
        } else {
            c03171 = new C03171(continuation);
        }
        Object obj = c03171.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = c03171.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            this.inSelect = true;
            c03171.L$0 = selector;
            c03171.L$1 = null;
            c03171.I$0 = 0;
            c03171.label = 1;
            if (AwaitKt.yield(c03171) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            selector = (Selector) c03171.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (this.wakeup.get() == 0) {
            iSelectNow = selector.select(500L);
            this.inSelect = false;
        } else {
            this.inSelect = false;
            this.wakeup.set(0L);
            iSelectNow = selector.selectNow();
        }
        return new Integer(iSelectNow);
    }

    private final void selectWakeup() {
        Selector selector;
        if (this.wakeup.incrementAndGet() == 1 && this.inSelect && (selector = this.selectorRef) != null) {
            selector.wakeup();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DisposableHandle disposableHandle = this.parentCancellationHandler;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
        this.parentCancellationHandler = null;
        this.closed = true;
        this.selectionQueue.close();
        if (this.continuation.resume(Unit.INSTANCE)) {
            return;
        }
        selectWakeup();
    }

    @Override // io.ktor.network.selector.SelectorManagerSupport, io.ktor.network.selector.SelectorManager, kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.network.selector.SelectorManager
    public void notifyClosed(Selectable selectable) {
        SelectionKey selectionKeyKeyFor;
        selectable.getClass();
        cancelAllSuspensions(selectable, new ClosedChannelException());
        Selector selector = this.selectorRef;
        if (selector == null || (selectionKeyKeyFor = selectable.getChannel().keyFor(selector)) == null) {
            return;
        }
        selectionKeyKeyFor.cancel();
        selectWakeup();
    }

    @Override // io.ktor.network.selector.SelectorManagerSupport
    public void publishInterest(Selectable selectable) {
        selectable.getClass();
        try {
            if (this.selectionQueue.addLast(selectable)) {
                this.continuation.resume(Unit.INSTANCE);
                selectWakeup();
            } else {
                if (!selectable.getChannel().isOpen()) {
                    throw new ClosedChannelException();
                }
                throw new ClosedSelectorException();
            }
        } catch (Throwable th) {
            cancelAllSuspensions(selectable, th);
        }
    }
}
