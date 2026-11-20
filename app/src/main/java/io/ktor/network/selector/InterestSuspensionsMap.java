package io.ktor.network.selector;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KCallable;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ5\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00070\rH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u000f\u001a\u00020\u00072\u001e\u0010\u000e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0011H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0012J\u001d\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u001e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, d2 = {"Lio/ktor/network/selector/InterestSuspensionsMap;", "", "<init>", "()V", "Lio/ktor/network/selector/SelectInterest;", "interest", "Lkotlinx/coroutines/CancellableContinuation;", "", "continuation", "addSuspension", "(Lio/ktor/network/selector/SelectInterest;Lkotlinx/coroutines/CancellableContinuation;)V", "", "readyOps", "Lkotlin/Function1;", "block", "invokeForEachPresent", "(ILkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "(Lkotlin/jvm/functions/Function2;)V", "removeSuspension", "(Lio/ktor/network/selector/SelectInterest;)Lkotlinx/coroutines/CancellableContinuation;", "interestOrdinal", "(I)Lkotlinx/coroutines/CancellableContinuation;", "", "toString", "()Ljava/lang/String;", "readHandlerReference", "Lkotlinx/coroutines/CancellableContinuation;", "writeHandlerReference", "connectHandlerReference", "acceptHandlerReference", "Companion", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class InterestSuspensionsMap {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicReferenceFieldUpdater<InterestSuspensionsMap, CancellableContinuation>[] updaters;
    private volatile CancellableContinuation acceptHandlerReference;
    private volatile CancellableContinuation connectHandlerReference;
    private volatile CancellableContinuation readHandlerReference;
    private volatile CancellableContinuation writeHandlerReference;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SelectInterest.values().length];
            try {
                iArr[SelectInterest.READ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SelectInterest.WRITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SelectInterest.ACCEPT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SelectInterest.CONNECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        KCallable kCallable;
        SelectInterest[] allInterests = SelectInterest.INSTANCE.getAllInterests();
        ArrayList arrayList = new ArrayList(allInterests.length);
        for (SelectInterest selectInterest : allInterests) {
            int i = WhenMappings.$EnumSwitchMapping$0[selectInterest.ordinal()];
            if (i == 1) {
                kCallable = new MutablePropertyReference1Impl() { // from class: io.ktor.network.selector.InterestSuspensionsMap$Companion$updaters$1$property$1
                    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((InterestSuspensionsMap) obj).readHandlerReference;
                    }

                    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
                    public void set(Object obj, Object obj2) {
                        ((InterestSuspensionsMap) obj).readHandlerReference = (CancellableContinuation) obj2;
                    }
                };
            } else if (i == 2) {
                kCallable = new MutablePropertyReference1Impl() { // from class: io.ktor.network.selector.InterestSuspensionsMap$Companion$updaters$1$property$2
                    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((InterestSuspensionsMap) obj).writeHandlerReference;
                    }

                    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
                    public void set(Object obj, Object obj2) {
                        ((InterestSuspensionsMap) obj).writeHandlerReference = (CancellableContinuation) obj2;
                    }
                };
            } else if (i == 3) {
                kCallable = new MutablePropertyReference1Impl() { // from class: io.ktor.network.selector.InterestSuspensionsMap$Companion$updaters$1$property$3
                    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((InterestSuspensionsMap) obj).acceptHandlerReference;
                    }

                    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
                    public void set(Object obj, Object obj2) {
                        ((InterestSuspensionsMap) obj).acceptHandlerReference = (CancellableContinuation) obj2;
                    }
                };
            } else {
                if (i != 4) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
                kCallable = new MutablePropertyReference1Impl() { // from class: io.ktor.network.selector.InterestSuspensionsMap$Companion$updaters$1$property$4
                    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((InterestSuspensionsMap) obj).connectHandlerReference;
                    }

                    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
                    public void set(Object obj, Object obj2) {
                        ((InterestSuspensionsMap) obj).connectHandlerReference = (CancellableContinuation) obj2;
                    }
                };
            }
            arrayList.add(AtomicReferenceFieldUpdater.newUpdater(InterestSuspensionsMap.class, CancellableContinuation.class, kCallable.getName()));
        }
        updaters = (AtomicReferenceFieldUpdater[]) arrayList.toArray(new AtomicReferenceFieldUpdater[0]);
    }

    public final void addSuspension(SelectInterest interest, CancellableContinuation continuation) {
        interest.getClass();
        continuation.getClass();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdaterUpdater = INSTANCE.updater(interest);
        while (!atomicReferenceFieldUpdaterUpdater.compareAndSet(this, null, continuation)) {
            if (atomicReferenceFieldUpdaterUpdater.get(this) != null) {
                throw new IllegalStateException(("Handler for " + interest.name() + " is already registered").toString());
            }
        }
    }

    public final void invokeForEachPresent(int readyOps, Function1 block) {
        CancellableContinuation cancellableContinuationRemoveSuspension;
        block.getClass();
        int[] flags = SelectInterest.INSTANCE.getFlags();
        int length = flags.length;
        for (int i = 0; i < length; i++) {
            if ((flags[i] & readyOps) != 0 && (cancellableContinuationRemoveSuspension = removeSuspension(i)) != null) {
                block.invoke(cancellableContinuationRemoveSuspension);
            }
        }
    }

    public final CancellableContinuation removeSuspension(SelectInterest interest) {
        interest.getClass();
        return (CancellableContinuation) INSTANCE.updater(interest).getAndSet(this, null);
    }

    public String toString() {
        return "R " + this.readHandlerReference + " W " + this.writeHandlerReference + " C " + this.connectHandlerReference + " A " + this.acceptHandlerReference;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bR4\u0010\r\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u00060\f8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u0012\u0004\b\u000f\u0010\u0003¨\u0006\u0010"}, d2 = {"Lio/ktor/network/selector/InterestSuspensionsMap$Companion;", "", "<init>", "()V", "Lio/ktor/network/selector/SelectInterest;", "interest", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lio/ktor/network/selector/InterestSuspensionsMap;", "Lkotlinx/coroutines/CancellableContinuation;", "", "updater", "(Lio/ktor/network/selector/SelectInterest;)Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "", "updaters", "[Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "getUpdaters$annotations", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final AtomicReferenceFieldUpdater<InterestSuspensionsMap, CancellableContinuation> updater(SelectInterest interest) {
            return InterestSuspensionsMap.updaters[interest.ordinal()];
        }

        private Companion() {
        }

        private static /* synthetic */ void getUpdaters$annotations() {
        }
    }

    public final CancellableContinuation removeSuspension(int interestOrdinal) {
        return updaters[interestOrdinal].getAndSet(this, null);
    }

    public final void invokeForEachPresent(Function2 block) {
        block.getClass();
        for (SelectInterest selectInterest : SelectInterest.INSTANCE.getAllInterests()) {
            CancellableContinuation cancellableContinuationRemoveSuspension = removeSuspension(selectInterest);
            if (cancellableContinuationRemoveSuspension != null) {
                block.invoke(cancellableContinuationRemoveSuspension, selectInterest);
            }
        }
    }
}
