package io.ktor.events;

import io.ktor.util.collections.CopyOnWriteHashMap;
import io.ktor.util.internal.LockFreeLinkedListHead;
import io.ktor.util.internal.LockFreeLinkedListNode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DisposableHandle;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\t¢\u0006\u0004\b\f\u0010\rJ?\u0010\u000e\u001a\u00020\b\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\t¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0011\u001a\u00020\b\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0015\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lio/ktor/events/Events;", "", "<init>", "()V", "T", "Lio/ktor/events/EventDefinition;", "definition", "Lkotlin/Function1;", "", "Lio/ktor/events/EventHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "subscribe", "(Lio/ktor/events/EventDefinition;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "unsubscribe", "(Lio/ktor/events/EventDefinition;Lkotlin/jvm/functions/Function1;)V", "value", "raise", "(Lio/ktor/events/EventDefinition;Ljava/lang/Object;)V", "Lio/ktor/util/collections/CopyOnWriteHashMap;", "Lio/ktor/util/internal/LockFreeLinkedListHead;", "handlers", "Lio/ktor/util/collections/CopyOnWriteHashMap;", "HandlerRegistration", "ktor-events"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Events {
    private final CopyOnWriteHashMap<EventDefinition<?>, LockFreeLinkedListHead> handlers = new CopyOnWriteHashMap<>();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00040\u0003j\u0006\u0012\u0002\b\u0003`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR)\u0010\u0006\u001a\u0014\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00040\u0003j\u0006\u0012\u0002\b\u0003`\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/events/Events$HandlerRegistration;", "Lio/ktor/util/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlin/Function1;", "", "Lio/ktor/events/EventHandler;", "handler", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "dispose", "()V", "Lkotlin/jvm/functions/Function1;", "getHandler", "()Lkotlin/jvm/functions/Function1;", "ktor-events"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class HandlerRegistration extends LockFreeLinkedListNode implements DisposableHandle {
        private final Function1 handler;

        public HandlerRegistration(Function1 function1) {
            function1.getClass();
            this.handler = function1;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            remove();
        }

        public final Function1 getHandler() {
            return this.handler;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LockFreeLinkedListHead subscribe$lambda$0(EventDefinition eventDefinition) {
        eventDefinition.getClass();
        return new LockFreeLinkedListHead();
    }

    public final <T> void raise(EventDefinition<T> definition, T value) {
        definition.getClass();
        LockFreeLinkedListHead lockFreeLinkedListHead = this.handlers.get(definition);
        Throwable th = null;
        if (lockFreeLinkedListHead != null) {
            Object next = lockFreeLinkedListHead.getNext();
            next.getClass();
            for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(nextNode, lockFreeLinkedListHead); nextNode = nextNode.getNextNode()) {
                if (nextNode instanceof HandlerRegistration) {
                    try {
                        Function1 handler = ((HandlerRegistration) nextNode).getHandler();
                        handler.getClass();
                        TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, handler);
                        handler.invoke(value);
                    } catch (Throwable th2) {
                        if (th != null) {
                            ResultKt.addSuppressed(th, th2);
                        } else {
                            th = th2;
                        }
                    }
                }
            }
        }
        if (th != null) {
            throw th;
        }
    }

    public final <T> DisposableHandle subscribe(EventDefinition<T> definition, Function1 handler) {
        definition.getClass();
        handler.getClass();
        HandlerRegistration handlerRegistration = new HandlerRegistration(handler);
        this.handlers.computeIfAbsent(definition, new Events$$ExternalSyntheticLambda0((byte) 0)).addLast(handlerRegistration);
        return handlerRegistration;
    }

    public final <T> void unsubscribe(EventDefinition<T> definition, Function1 handler) {
        definition.getClass();
        handler.getClass();
        LockFreeLinkedListHead lockFreeLinkedListHead = this.handlers.get(definition);
        if (lockFreeLinkedListHead != null) {
            Object next = lockFreeLinkedListHead.getNext();
            next.getClass();
            for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(nextNode, lockFreeLinkedListHead); nextNode = nextNode.getNextNode()) {
                if (nextNode instanceof HandlerRegistration) {
                    HandlerRegistration handlerRegistration = (HandlerRegistration) nextNode;
                    if (Intrinsics.areEqual(handlerRegistration.getHandler(), handler)) {
                        handlerRegistration.remove();
                    }
                }
            }
        }
    }
}
