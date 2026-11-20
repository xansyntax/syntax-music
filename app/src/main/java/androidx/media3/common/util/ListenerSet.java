package androidx.media3.common.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Player;
import coil3.util.UtilsKt;
import java.util.ArrayDeque;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ListenerSet {
    public final ArrayDeque flushingEvents;
    public final IterationFinishedEvent iterationFinishedEvent;
    public final SystemHandlerWrapper iterationFinishedHandler;
    public final CopyOnWriteArraySet listeners;
    public final ArrayDeque queuedEvents;
    public boolean released;
    public final Object releasedLock;
    public final Thread thread;
    public final boolean throwsWhenUsingWrongThread;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Event {
        void invoke(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface IterationFinishedEvent {
        void invoke(Object obj, FlagSet flagSet);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ListenerHolder {
        public FlagSet.Builder flagsBuilder = new FlagSet.Builder((byte) 0);
        public final Object listener;
        public boolean needsIterationFinishedEvent;
        public boolean released;

        public ListenerHolder(Object obj) {
            this.listener = obj;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ListenerHolder.class != obj.getClass()) {
                return false;
            }
            return this.listener.equals(((ListenerHolder) obj).listener);
        }

        public final int hashCode() {
            return this.listener.hashCode();
        }
    }

    public ListenerSet(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, Thread thread, SystemClock systemClock, IterationFinishedEvent iterationFinishedEvent, boolean z) {
        this.thread = thread;
        this.listeners = copyOnWriteArraySet;
        this.iterationFinishedEvent = iterationFinishedEvent;
        this.releasedLock = new Object();
        this.flushingEvents = new ArrayDeque();
        this.queuedEvents = new ArrayDeque();
        if (looper == null || systemClock == null || iterationFinishedEvent == null) {
            this.iterationFinishedHandler = null;
        } else {
            this.iterationFinishedHandler = systemClock.createHandler(looper, new ListenerSet$$ExternalSyntheticLambda0((byte) 0, this));
        }
        this.throwsWhenUsingWrongThread = z;
    }

    public final void add(Object obj) {
        obj.getClass();
        synchronized (this.releasedLock) {
            try {
                if (this.released) {
                    return;
                }
                this.listeners.add(new ListenerHolder(obj));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void flushEvents() {
        if (this.throwsWhenUsingWrongThread) {
            UtilsKt.checkState(Thread.currentThread() == this.thread);
        }
        ArrayDeque arrayDeque = this.queuedEvents;
        if (arrayDeque.isEmpty()) {
            return;
        }
        if (this.iterationFinishedEvent != null) {
            SystemHandlerWrapper systemHandlerWrapper = this.iterationFinishedHandler;
            systemHandlerWrapper.getClass();
            Handler handler = systemHandlerWrapper.handler;
            if (!handler.hasMessages(1)) {
                SystemHandlerWrapper.SystemMessage systemMessageObtainMessage = systemHandlerWrapper.obtainMessage(1);
                Message message = systemMessageObtainMessage.message;
                message.getClass();
                handler.sendMessageAtFrontOfQueue(message);
                systemMessageObtainMessage.recycle();
            }
        }
        ArrayDeque arrayDeque2 = this.flushingEvents;
        boolean zIsEmpty = arrayDeque2.isEmpty();
        arrayDeque2.addAll(arrayDeque);
        arrayDeque.clear();
        if (zIsEmpty) {
            while (!arrayDeque2.isEmpty()) {
                ((Runnable) arrayDeque2.peekFirst()).run();
                arrayDeque2.removeFirst();
            }
        }
    }

    public final void queueEvent(int i, Event event) {
        byte b = 0;
        if (this.throwsWhenUsingWrongThread) {
            UtilsKt.checkState(Thread.currentThread() == this.thread);
        }
        this.queuedEvents.add(new ListenerSet$$ExternalSyntheticLambda1(new CopyOnWriteArraySet(this.listeners), i, event, b));
    }

    public final void release() {
        if (this.throwsWhenUsingWrongThread) {
            UtilsKt.checkState(Thread.currentThread() == this.thread);
        }
        synchronized (this.releasedLock) {
            this.released = true;
        }
        for (ListenerHolder listenerHolder : this.listeners) {
            IterationFinishedEvent iterationFinishedEvent = this.iterationFinishedEvent;
            listenerHolder.released = true;
            if (iterationFinishedEvent != null && listenerHolder.needsIterationFinishedEvent) {
                listenerHolder.needsIterationFinishedEvent = false;
                iterationFinishedEvent.invoke(listenerHolder.listener, listenerHolder.flagsBuilder.build());
            }
        }
        this.listeners.clear();
    }

    public final void remove(Player.Listener listener) {
        if (this.throwsWhenUsingWrongThread) {
            UtilsKt.checkState(Thread.currentThread() == this.thread);
        }
        CopyOnWriteArraySet<ListenerHolder> copyOnWriteArraySet = this.listeners;
        for (ListenerHolder listenerHolder : copyOnWriteArraySet) {
            if (listenerHolder.listener.equals(listener)) {
                listenerHolder.released = true;
                IterationFinishedEvent iterationFinishedEvent = this.iterationFinishedEvent;
                if (iterationFinishedEvent != null && listenerHolder.needsIterationFinishedEvent) {
                    listenerHolder.needsIterationFinishedEvent = false;
                    iterationFinishedEvent.invoke(listenerHolder.listener, listenerHolder.flagsBuilder.build());
                }
                copyOnWriteArraySet.remove(listenerHolder);
            }
        }
    }

    public final void sendEvent(int i, Event event) {
        queueEvent(i, event);
        flushEvents();
    }

    public ListenerSet(Looper looper, IterationFinishedEvent iterationFinishedEvent) {
        this(new CopyOnWriteArraySet(), looper, looper.getThread(), SystemClock.DEFAULT, iterationFinishedEvent, true);
    }

    public ListenerSet(Thread thread) {
        this(new CopyOnWriteArraySet(), null, thread, null, null, true);
    }
}
