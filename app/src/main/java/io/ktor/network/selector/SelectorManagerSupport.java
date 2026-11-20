package io.ktor.network.selector;

import java.io.IOException;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancelledContinuation;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\b&\u0018\u00002\u00020\u0001:\u00018B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H$¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0012\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000eH\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0004¢\u0006\u0004\b \u0010!J!\u0010 \u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0004¢\u0006\u0004\b \u0010\"R\u0017\u0010$\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\u00020(8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R,\u00107\u001a\u0004\u0018\u00010\u0004*\u00020\u000e2\b\u00102\u001a\u0004\u0018\u00010\u00048B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u00069"}, d2 = {"Lio/ktor/network/selector/SelectorManagerSupport;", "Lio/ktor/network/selector/SelectorManager;", "<init>", "()V", "Lio/ktor/network/selector/Selectable;", "selectable", "", "publishInterest", "(Lio/ktor/network/selector/Selectable;)V", "Lio/ktor/network/selector/SelectInterest;", "interest", "select", "(Lio/ktor/network/selector/Selectable;Lio/ktor/network/selector/SelectInterest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Ljava/nio/channels/SelectionKey;", "selectedKeys", "", "keys", "handleSelectedKeys", "(Ljava/util/Set;Ljava/util/Set;)V", "key", "handleSelectedKey", "(Ljava/nio/channels/SelectionKey;)V", "Ljava/nio/channels/Selector;", "selector", "applyInterest", "(Ljava/nio/channels/Selector;Lio/ktor/network/selector/Selectable;)V", "attachment", "notifyClosedImpl", "(Ljava/nio/channels/Selector;Ljava/nio/channels/SelectionKey;Lio/ktor/network/selector/Selectable;)V", "", "cause", "cancelAllSuspensions", "(Lio/ktor/network/selector/Selectable;Ljava/lang/Throwable;)V", "(Ljava/nio/channels/Selector;Ljava/lang/Throwable;)V", "Ljava/nio/channels/spi/SelectorProvider;", "provider", "Ljava/nio/channels/spi/SelectorProvider;", "getProvider", "()Ljava/nio/channels/spi/SelectorProvider;", "", "pending", "I", "getPending", "()I", "setPending", "(I)V", "cancelled", "getCancelled", "setCancelled", "newValue", "getSubject", "(Ljava/nio/channels/SelectionKey;)Lio/ktor/network/selector/Selectable;", "setSubject", "(Ljava/nio/channels/SelectionKey;Lio/ktor/network/selector/Selectable;)V", "subject", "ClosedSelectorCancellationException", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class SelectorManagerSupport implements SelectorManager {
    private int cancelled;
    private int pending;
    private final SelectorProvider provider;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/network/selector/SelectorManagerSupport$ClosedSelectorCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "<init>", "()V", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ClosedSelectorCancellationException extends CancellationException {
        public ClosedSelectorCancellationException() {
            super("Closed selector");
        }
    }

    public SelectorManagerSupport() {
        SelectorProvider selectorProviderProvider = SelectorProvider.provider();
        selectorProviderProvider.getClass();
        this.provider = selectorProviderProvider;
    }

    private final Selectable getSubject(SelectionKey selectionKey) {
        Object objAttachment = selectionKey.attachment();
        if (objAttachment instanceof Selectable) {
            return (Selectable) objAttachment;
        }
        return null;
    }

    private final void setSubject(SelectionKey selectionKey, Selectable selectable) {
        selectionKey.attach(selectable);
    }

    public final void applyInterest(Selector selector, Selectable selectable) {
        selector.getClass();
        selectable.getClass();
        try {
            SelectableChannel channel = selectable.getChannel();
            SelectionKey selectionKeyKeyFor = channel.keyFor(selector);
            int i = selectable.get_interestedOps();
            if (selectionKeyKeyFor == null) {
                if (i != 0) {
                    channel.register(selector, i, selectable);
                }
            } else if (selectionKeyKeyFor.interestOps() != i) {
                selectionKeyKeyFor.interestOps(i);
            }
            if (i != 0) {
                this.pending++;
            }
        } catch (Throwable th) {
            SelectionKey selectionKeyKeyFor2 = selectable.getChannel().keyFor(selector);
            if (selectionKeyKeyFor2 != null) {
                selectionKeyKeyFor2.cancel();
            }
            cancelAllSuspensions(selectable, th);
        }
    }

    public final void cancelAllSuspensions(Selector selector, Throwable cause) {
        selector.getClass();
        if (cause == null) {
            cause = new ClosedSelectorCancellationException();
        }
        Set<SelectionKey> setKeys = selector.keys();
        setKeys.getClass();
        for (SelectionKey selectionKey : setKeys) {
            try {
                if (selectionKey.isValid()) {
                    selectionKey.interestOps(0);
                }
            } catch (CancelledKeyException unused) {
            }
            Object objAttachment = selectionKey.attachment();
            Selectable selectable = objAttachment instanceof Selectable ? (Selectable) objAttachment : null;
            if (selectable != null) {
                cancelAllSuspensions(selectable, cause);
            }
            selectionKey.cancel();
        }
    }

    public final int getCancelled() {
        return this.cancelled;
    }

    @Override // io.ktor.network.selector.SelectorManager, kotlinx.coroutines.CoroutineScope
    public abstract /* synthetic */ CoroutineContext getCoroutineContext();

    public final int getPending() {
        return this.pending;
    }

    @Override // io.ktor.network.selector.SelectorManager
    public final SelectorProvider getProvider() {
        return this.provider;
    }

    public final void handleSelectedKey(SelectionKey key) {
        CancellableContinuation cancellableContinuationRemoveSuspension;
        key.getClass();
        try {
            int i = key.readyOps();
            int iInterestOps = key.interestOps();
            Selectable subject = getSubject(key);
            if (subject == null) {
                key.cancel();
                this.cancelled++;
                return;
            }
            InterestSuspensionsMap suspensions = subject.getSuspensions();
            int[] flags = SelectInterest.INSTANCE.getFlags();
            int length = flags.length;
            for (int i2 = 0; i2 < length; i2++) {
                if ((flags[i2] & i) != 0 && (cancellableContinuationRemoveSuspension = suspensions.removeSuspension(i2)) != null) {
                    cancellableContinuationRemoveSuspension.resumeWith(Unit.INSTANCE);
                }
            }
            int i3 = (~i) & iInterestOps;
            if (i3 != iInterestOps) {
                key.interestOps(i3);
            }
            if (i3 != 0) {
                this.pending++;
            }
        } catch (Throwable th) {
            key.cancel();
            this.cancelled++;
            Selectable subject2 = getSubject(key);
            if (subject2 != null) {
                cancelAllSuspensions(subject2, th);
                setSubject(key, null);
            }
        }
    }

    public final void handleSelectedKeys(Set<SelectionKey> selectedKeys, Set<? extends SelectionKey> keys) {
        selectedKeys.getClass();
        keys.getClass();
        int size = selectedKeys.size();
        this.pending = keys.size() - size;
        this.cancelled = 0;
        if (size <= 0) {
            return;
        }
        Iterator<SelectionKey> it = selectedKeys.iterator();
        while (it.hasNext()) {
            handleSelectedKey(it.next());
            it.remove();
        }
    }

    public final void notifyClosedImpl(Selector selector, SelectionKey key, Selectable attachment) {
        selector.getClass();
        key.getClass();
        attachment.getClass();
        cancelAllSuspensions(attachment, new ClosedChannelException());
        setSubject(key, null);
        selector.wakeup();
    }

    public abstract void publishInterest(Selectable selectable);

    @Override // io.ktor.network.selector.SelectorManager
    public final Object select(Selectable selectable, SelectInterest selectInterest, Continuation continuation) throws IOException {
        int i = selectable.get_interestedOps();
        int flag = selectInterest.getFlag();
        if (selectable.isClosed()) {
            SelectorManagerSupportKt.selectableIsClosed();
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
            return null;
        }
        if ((i & flag) == 0) {
            SelectorManagerSupportKt.selectableIsInvalid(i, flag);
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
            return null;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellation(new Function1() { // from class: io.ktor.network.selector.SelectorManagerSupport$select$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
            }
        });
        selectable.getSuspensions().addSuspension(selectInterest, cancellableContinuationImpl);
        if (!(cancellableContinuationImpl.getState$kotlinx_coroutines_core() instanceof CancelledContinuation)) {
            publishInterest(selectable);
        }
        Object result = cancellableContinuationImpl.getResult();
        return result == CoroutineSingletons.COROUTINE_SUSPENDED ? result : Unit.INSTANCE;
    }

    public final void setCancelled(int i) {
        this.cancelled = i;
    }

    public final void setPending(int i) {
        this.pending = i;
    }

    public final void cancelAllSuspensions(Selectable attachment, Throwable cause) {
        attachment.getClass();
        cause.getClass();
        InterestSuspensionsMap suspensions = attachment.getSuspensions();
        for (SelectInterest selectInterest : SelectInterest.INSTANCE.getAllInterests()) {
            CancellableContinuation cancellableContinuationRemoveSuspension = suspensions.removeSuspension(selectInterest);
            if (cancellableContinuationRemoveSuspension != null) {
                cancellableContinuationRemoveSuspension.resumeWith(new Result.Failure(cause));
            }
        }
    }
}
