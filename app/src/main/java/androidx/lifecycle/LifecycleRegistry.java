package androidx.lifecycle;

import android.os.Looper;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableScatterMap;
import androidx.datastore.core.AtomicInt;
import androidx.emoji2.text.EmojiProcessor;
import androidx.savedstate.Recreator;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleRegistry extends Lifecycle {
    public final StateFlowImpl _currentStateFlow;
    public int addingObserverCounter;
    public final boolean enforceMainThread;
    public boolean handlingEvent;
    public final WeakReference lifecycleOwner;
    public boolean newEventOccurred;
    public EmojiProcessor observerMap;
    public final ArrayList parentStates;
    public Lifecycle.State state;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ObserverWithState {
        public LifecycleEventObserver lifecycleObserver;
        public Lifecycle.State state;

        public final void dispatchEvent(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State targetState = event.getTargetState();
            Lifecycle.State state = this.state;
            if (targetState.compareTo(state) < 0) {
                state = targetState;
            }
            this.state = state;
            this.lifecycleObserver.onStateChanged(lifecycleOwner, event);
            this.state = targetState;
        }
    }

    public LifecycleRegistry(LifecycleOwner lifecycleOwner, boolean z) {
        this.internalScopeRef = new AtomicInt((byte) 14);
        this.enforceMainThread = z;
        this.observerMap = new EmojiProcessor((byte) 18);
        this.lifecycleOwner = new WeakReference(lifecycleOwner);
        this.parentStates = new ArrayList();
        Lifecycle.State state = Lifecycle.State.INITIALIZED;
        this.state = state;
        this._currentStateFlow = StateFlowKt.MutableStateFlow(state);
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void addObserver(LifecycleObserver lifecycleObserver) {
        LifecycleEventObserver defaultLifecycleObserverAdapter;
        ObserverWithState observerWithState;
        LifecycleOwner lifecycleOwner;
        Lifecycle.Event event;
        lifecycleObserver.getClass();
        enforceMainThreadIfNeeded("addObserver");
        Lifecycle.State state = this.state;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        ObserverWithState observerWithState2 = new ObserverWithState();
        observerWithState2.state = state2;
        HashMap map = Lifecycling.callbackCache;
        boolean z = lifecycleObserver instanceof LifecycleEventObserver;
        boolean z2 = lifecycleObserver instanceof DefaultLifecycleObserver;
        byte b = 2;
        Object obj = null;
        byte b2 = 0;
        if (z && z2) {
            defaultLifecycleObserverAdapter = new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) lifecycleObserver, (LifecycleEventObserver) lifecycleObserver, b2);
        } else if (z2) {
            defaultLifecycleObserverAdapter = new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) lifecycleObserver, obj, b2);
        } else if (z) {
            defaultLifecycleObserverAdapter = (LifecycleEventObserver) lifecycleObserver;
        } else {
            Class<?> cls = lifecycleObserver.getClass();
            if (Lifecycling.getObserverConstructorType(cls) == 2) {
                Object obj2 = Lifecycling.classToAdapters.get(cls);
                obj2.getClass();
                List list = (List) obj2;
                if (list.size() == 1) {
                    Lifecycling.createGeneratedAdapter((Constructor) list.get(0), lifecycleObserver);
                    throw null;
                }
                int size = list.size();
                GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[size];
                if (size > 0) {
                    Lifecycling.createGeneratedAdapter((Constructor) list.get(0), lifecycleObserver);
                    throw null;
                }
                defaultLifecycleObserverAdapter = new Recreator(b, generatedAdapterArr);
            } else {
                defaultLifecycleObserverAdapter = new DefaultLifecycleObserverAdapter(lifecycleObserver);
            }
        }
        observerWithState2.lifecycleObserver = defaultLifecycleObserverAdapter;
        EmojiProcessor emojiProcessor = this.observerMap;
        emojiProcessor.getClass();
        MutableScatterMap mutableScatterMap = (MutableScatterMap) emojiProcessor.mSpanFactory;
        FastSafeIterableMap$Entry fastSafeIterableMap$Entry = (FastSafeIterableMap$Entry) mutableScatterMap.get(lifecycleObserver);
        if (fastSafeIterableMap$Entry != null) {
            observerWithState = fastSafeIterableMap$Entry.value;
        } else {
            FastSafeIterableMap$Entry fastSafeIterableMap$Entry2 = new FastSafeIterableMap$Entry(lifecycleObserver, observerWithState2);
            mutableScatterMap.set(lifecycleObserver, fastSafeIterableMap$Entry2);
            FastSafeIterableMap$Entry fastSafeIterableMap$Entry3 = (FastSafeIterableMap$Entry) emojiProcessor.mGlyphChecker;
            if (fastSafeIterableMap$Entry3 == null) {
                emojiProcessor.mMetadataRepo = fastSafeIterableMap$Entry2;
                emojiProcessor.mGlyphChecker = fastSafeIterableMap$Entry2;
            } else {
                fastSafeIterableMap$Entry3.next = fastSafeIterableMap$Entry2;
                fastSafeIterableMap$Entry2.prev = fastSafeIterableMap$Entry3;
                emojiProcessor.mGlyphChecker = fastSafeIterableMap$Entry2;
            }
            observerWithState = null;
        }
        if (observerWithState == null && (lifecycleOwner = (LifecycleOwner) this.lifecycleOwner.delegate.get()) != null) {
            b2 = (this.addingObserverCounter != 0 || this.handlingEvent) ? (byte) 1 : (byte) 0;
            Lifecycle.State stateCalculateTargetState = calculateTargetState(lifecycleObserver);
            this.addingObserverCounter++;
            while (observerWithState2.state.compareTo(stateCalculateTargetState) < 0) {
                EmojiProcessor emojiProcessor2 = this.observerMap;
                emojiProcessor2.getClass();
                if (!((MutableScatterMap) emojiProcessor2.mSpanFactory).containsKey(lifecycleObserver)) {
                    break;
                }
                Lifecycle.State state3 = observerWithState2.state;
                ArrayList arrayList = this.parentStates;
                arrayList.add(state3);
                Lifecycle.Event.Companion companion = Lifecycle.Event.Companion;
                Lifecycle.State state4 = observerWithState2.state;
                companion.getClass();
                state4.getClass();
                int iOrdinal = state4.ordinal();
                if (iOrdinal == 1) {
                    event = Lifecycle.Event.ON_CREATE;
                } else if (iOrdinal != 2) {
                    event = iOrdinal != 3 ? null : Lifecycle.Event.ON_RESUME;
                } else {
                    event = Lifecycle.Event.ON_START;
                }
                if (event == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1(observerWithState2.state, "no event up from ");
                    return;
                } else {
                    observerWithState2.dispatchEvent(lifecycleOwner, event);
                    CollectionsKt__MutableCollectionsKt.removeLastOrNull(arrayList);
                    stateCalculateTargetState = calculateTargetState(lifecycleObserver);
                }
            }
            if (b2 == 0) {
                sync();
            }
            this.addingObserverCounter--;
        }
    }

    public final Lifecycle.State calculateTargetState(LifecycleObserver lifecycleObserver) {
        EmojiProcessor emojiProcessor = this.observerMap;
        emojiProcessor.getClass();
        lifecycleObserver.getClass();
        FastSafeIterableMap$Entry fastSafeIterableMap$Entry = (FastSafeIterableMap$Entry) ((MutableScatterMap) emojiProcessor.mSpanFactory).get(lifecycleObserver);
        FastSafeIterableMap$Entry fastSafeIterableMap$Entry2 = fastSafeIterableMap$Entry != null ? fastSafeIterableMap$Entry.prev : null;
        Lifecycle.State state = fastSafeIterableMap$Entry2 != null ? fastSafeIterableMap$Entry2.value.state : null;
        ArrayList arrayList = this.parentStates;
        Lifecycle.State state2 = arrayList.isEmpty() ? null : (Lifecycle.State) arrayList.get(arrayList.size() - 1);
        Lifecycle.State state3 = this.state;
        if (state == null || state.compareTo(state3) >= 0) {
            state = state3;
        }
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    public final void enforceMainThreadIfNeeded(String str) {
        if (this.enforceMainThread) {
            ArchTaskExecutor.getInstance().getClass();
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                return;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m((Object) IntIntPair$$ExternalSyntheticOutline0.m("Method ", str, " must be called on the main thread"));
        }
    }

    public final void handleLifecycleEvent(Lifecycle.Event event) {
        event.getClass();
        enforceMainThreadIfNeeded("handleLifecycleEvent");
        moveToState(event.getTargetState());
    }

    public final void moveToState(Lifecycle.State state) {
        if (this.state == state) {
            return;
        }
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this.lifecycleOwner.delegate.get();
        Lifecycle.State state2 = this.state;
        Lifecycle.State state3 = Lifecycle.State.INITIALIZED;
        Lifecycle.State state4 = Lifecycle.State.DESTROYED;
        if (state2 == state3 && state == state4) {
            throw new IllegalStateException(("State must be at least '" + Lifecycle.State.CREATED + "' to be moved to '" + state + "' in component " + lifecycleOwner).toString());
        }
        if (state2 == state4 && state2 != state) {
            throw new IllegalStateException(("State is '" + state4 + "' and cannot be moved to `" + state + "` in component " + lifecycleOwner).toString());
        }
        this.state = state;
        if (this.handlingEvent || this.addingObserverCounter != 0) {
            this.newEventOccurred = true;
            return;
        }
        this.handlingEvent = true;
        sync();
        this.handlingEvent = false;
        if (this.state == state4) {
            this.observerMap = new EmojiProcessor((byte) 18);
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void removeObserver(LifecycleObserver lifecycleObserver) {
        lifecycleObserver.getClass();
        enforceMainThreadIfNeeded("removeObserver");
        EmojiProcessor emojiProcessor = this.observerMap;
        emojiProcessor.getClass();
        FastSafeIterableMap$Entry fastSafeIterableMap$Entry = (FastSafeIterableMap$Entry) ((MutableScatterMap) emojiProcessor.mSpanFactory).remove(lifecycleObserver);
        if (fastSafeIterableMap$Entry == null) {
            return;
        }
        FastSafeIterableMap$Entry fastSafeIterableMap$Entry2 = fastSafeIterableMap$Entry.prev;
        FastSafeIterableMap$Entry fastSafeIterableMap$Entry3 = fastSafeIterableMap$Entry.next;
        if (fastSafeIterableMap$Entry2 == null) {
            emojiProcessor.mMetadataRepo = fastSafeIterableMap$Entry3;
        } else {
            fastSafeIterableMap$Entry2.next = fastSafeIterableMap$Entry3;
        }
        FastSafeIterableMap$Entry fastSafeIterableMap$Entry4 = fastSafeIterableMap$Entry.next;
        if (fastSafeIterableMap$Entry4 == null) {
            emojiProcessor.mGlyphChecker = fastSafeIterableMap$Entry2;
        } else {
            fastSafeIterableMap$Entry4.prev = fastSafeIterableMap$Entry2;
        }
        fastSafeIterableMap$Entry.isRemoved = true;
    }

    public final void setCurrentState(Lifecycle.State state) {
        state.getClass();
        enforceMainThreadIfNeeded("setCurrentState");
        moveToState(state);
    }

    public final void sync() {
        Object obj = this.lifecycleOwner.delegate.get();
        if (obj == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
            return;
        }
        final LifecycleOwner lifecycleOwner = (LifecycleOwner) obj;
        while (true) {
            EmojiProcessor emojiProcessor = this.observerMap;
            final byte b = 0;
            if (((MutableScatterMap) emojiProcessor.mSpanFactory)._size == 0) {
                break;
            }
            FastSafeIterableMap$Entry fastSafeIterableMap$Entry = (FastSafeIterableMap$Entry) emojiProcessor.mMetadataRepo;
            if (fastSafeIterableMap$Entry == null) {
                PathKt$$ExternalSyntheticBUOutline0.m$1("Collection is empty.");
                return;
            }
            Lifecycle.State state = fastSafeIterableMap$Entry.value.state;
            FastSafeIterableMap$Entry fastSafeIterableMap$Entry2 = (FastSafeIterableMap$Entry) emojiProcessor.mGlyphChecker;
            if (fastSafeIterableMap$Entry2 == null) {
                PathKt$$ExternalSyntheticBUOutline0.m$1("Collection is empty.");
                return;
            }
            Lifecycle.State state2 = fastSafeIterableMap$Entry2.value.state;
            if (state == state2 && this.state == state2) {
                break;
            }
            this.newEventOccurred = false;
            Lifecycle.State state3 = this.state;
            if (fastSafeIterableMap$Entry == null) {
                PathKt$$ExternalSyntheticBUOutline0.m$1("Collection is empty.");
                return;
            }
            if (state3.compareTo(state) < 0) {
                EmojiProcessor emojiProcessor2 = this.observerMap;
                Function1 function1 = new Function1(this) { // from class: androidx.lifecycle.LifecycleRegistry$$ExternalSyntheticLambda0
                    public final /* synthetic */ LifecycleRegistry f$0;

                    {
                        this.f$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Lifecycle.Event event;
                        byte b2 = b;
                        Unit unit = Unit.INSTANCE;
                        LifecycleOwner lifecycleOwner2 = lifecycleOwner;
                        LifecycleRegistry lifecycleRegistry = this.f$0;
                        Map.Entry entry = (Map.Entry) obj2;
                        switch (b2) {
                            case 0:
                                entry.getClass();
                                LifecycleObserver lifecycleObserver = (LifecycleObserver) entry.getKey();
                                LifecycleRegistry.ObserverWithState observerWithState = (LifecycleRegistry.ObserverWithState) entry.getValue();
                                while (true) {
                                    Lifecycle.State state4 = observerWithState.state;
                                    Lifecycle.State state5 = lifecycleRegistry.state;
                                    ArrayList arrayList = lifecycleRegistry.parentStates;
                                    if (state4.compareTo(state5) <= 0 || lifecycleRegistry.newEventOccurred) {
                                        return unit;
                                    }
                                    EmojiProcessor emojiProcessor3 = lifecycleRegistry.observerMap;
                                    emojiProcessor3.getClass();
                                    lifecycleObserver.getClass();
                                    if (!((MutableScatterMap) emojiProcessor3.mSpanFactory).containsKey(lifecycleObserver)) {
                                        return unit;
                                    }
                                    Lifecycle.Event.Companion companion = Lifecycle.Event.Companion;
                                    Lifecycle.State state6 = observerWithState.state;
                                    companion.getClass();
                                    Lifecycle.Event eventDownFrom = Lifecycle.Event.Companion.downFrom(state6);
                                    if (eventDownFrom == null) {
                                        PathKt$$ExternalSyntheticBUOutline0.m$2(observerWithState.state, "no event down from ");
                                        return null;
                                    }
                                    arrayList.add(eventDownFrom.getTargetState());
                                    observerWithState.dispatchEvent(lifecycleOwner2, eventDownFrom);
                                    CollectionsKt__MutableCollectionsKt.removeLastOrNull(arrayList);
                                }
                                break;
                            default:
                                entry.getClass();
                                LifecycleObserver lifecycleObserver2 = (LifecycleObserver) entry.getKey();
                                LifecycleRegistry.ObserverWithState observerWithState2 = (LifecycleRegistry.ObserverWithState) entry.getValue();
                                while (true) {
                                    Lifecycle.State state7 = observerWithState2.state;
                                    Lifecycle.State state8 = lifecycleRegistry.state;
                                    ArrayList arrayList2 = lifecycleRegistry.parentStates;
                                    if (state7.compareTo(state8) >= 0 || lifecycleRegistry.newEventOccurred) {
                                        return unit;
                                    }
                                    EmojiProcessor emojiProcessor4 = lifecycleRegistry.observerMap;
                                    emojiProcessor4.getClass();
                                    lifecycleObserver2.getClass();
                                    if (!((MutableScatterMap) emojiProcessor4.mSpanFactory).containsKey(lifecycleObserver2)) {
                                        return unit;
                                    }
                                    arrayList2.add(observerWithState2.state);
                                    Lifecycle.Event.Companion companion2 = Lifecycle.Event.Companion;
                                    Lifecycle.State state9 = observerWithState2.state;
                                    companion2.getClass();
                                    state9.getClass();
                                    int iOrdinal = state9.ordinal();
                                    if (iOrdinal == 1) {
                                        event = Lifecycle.Event.ON_CREATE;
                                    } else if (iOrdinal != 2) {
                                        event = iOrdinal != 3 ? null : Lifecycle.Event.ON_RESUME;
                                    } else {
                                        event = Lifecycle.Event.ON_START;
                                    }
                                    if (event == null) {
                                        PathKt$$ExternalSyntheticBUOutline0.m$2(observerWithState2.state, "no event up from ");
                                        return null;
                                    }
                                    observerWithState2.dispatchEvent(lifecycleOwner2, event);
                                    CollectionsKt__MutableCollectionsKt.removeLastOrNull(arrayList2);
                                }
                                break;
                        }
                    }
                };
                emojiProcessor2.getClass();
                for (FastSafeIterableMap$Entry fastSafeIterableMap$Entry3 = (FastSafeIterableMap$Entry) emojiProcessor2.mGlyphChecker; fastSafeIterableMap$Entry3 != null; fastSafeIterableMap$Entry3 = fastSafeIterableMap$Entry3.prev) {
                    if (!fastSafeIterableMap$Entry3.isRemoved) {
                        function1.invoke(fastSafeIterableMap$Entry3);
                    }
                }
            }
            FastSafeIterableMap$Entry fastSafeIterableMap$Entry4 = (FastSafeIterableMap$Entry) this.observerMap.mGlyphChecker;
            if (!this.newEventOccurred && fastSafeIterableMap$Entry4 != null && this.state.compareTo(fastSafeIterableMap$Entry4.value.state) > 0) {
                EmojiProcessor emojiProcessor3 = this.observerMap;
                final byte b2 = 1;
                Function1 function2 = new Function1(this) { // from class: androidx.lifecycle.LifecycleRegistry$$ExternalSyntheticLambda0
                    public final /* synthetic */ LifecycleRegistry f$0;

                    {
                        this.f$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Lifecycle.Event event;
                        byte b3 = b2;
                        Unit unit = Unit.INSTANCE;
                        LifecycleOwner lifecycleOwner2 = lifecycleOwner;
                        LifecycleRegistry lifecycleRegistry = this.f$0;
                        Map.Entry entry = (Map.Entry) obj2;
                        switch (b3) {
                            case 0:
                                entry.getClass();
                                LifecycleObserver lifecycleObserver = (LifecycleObserver) entry.getKey();
                                LifecycleRegistry.ObserverWithState observerWithState = (LifecycleRegistry.ObserverWithState) entry.getValue();
                                while (true) {
                                    Lifecycle.State state4 = observerWithState.state;
                                    Lifecycle.State state5 = lifecycleRegistry.state;
                                    ArrayList arrayList = lifecycleRegistry.parentStates;
                                    if (state4.compareTo(state5) <= 0 || lifecycleRegistry.newEventOccurred) {
                                        return unit;
                                    }
                                    EmojiProcessor emojiProcessor4 = lifecycleRegistry.observerMap;
                                    emojiProcessor4.getClass();
                                    lifecycleObserver.getClass();
                                    if (!((MutableScatterMap) emojiProcessor4.mSpanFactory).containsKey(lifecycleObserver)) {
                                        return unit;
                                    }
                                    Lifecycle.Event.Companion companion = Lifecycle.Event.Companion;
                                    Lifecycle.State state6 = observerWithState.state;
                                    companion.getClass();
                                    Lifecycle.Event eventDownFrom = Lifecycle.Event.Companion.downFrom(state6);
                                    if (eventDownFrom == null) {
                                        PathKt$$ExternalSyntheticBUOutline0.m$2(observerWithState.state, "no event down from ");
                                        return null;
                                    }
                                    arrayList.add(eventDownFrom.getTargetState());
                                    observerWithState.dispatchEvent(lifecycleOwner2, eventDownFrom);
                                    CollectionsKt__MutableCollectionsKt.removeLastOrNull(arrayList);
                                }
                                break;
                            default:
                                entry.getClass();
                                LifecycleObserver lifecycleObserver2 = (LifecycleObserver) entry.getKey();
                                LifecycleRegistry.ObserverWithState observerWithState2 = (LifecycleRegistry.ObserverWithState) entry.getValue();
                                while (true) {
                                    Lifecycle.State state7 = observerWithState2.state;
                                    Lifecycle.State state8 = lifecycleRegistry.state;
                                    ArrayList arrayList2 = lifecycleRegistry.parentStates;
                                    if (state7.compareTo(state8) >= 0 || lifecycleRegistry.newEventOccurred) {
                                        return unit;
                                    }
                                    EmojiProcessor emojiProcessor5 = lifecycleRegistry.observerMap;
                                    emojiProcessor5.getClass();
                                    lifecycleObserver2.getClass();
                                    if (!((MutableScatterMap) emojiProcessor5.mSpanFactory).containsKey(lifecycleObserver2)) {
                                        return unit;
                                    }
                                    arrayList2.add(observerWithState2.state);
                                    Lifecycle.Event.Companion companion2 = Lifecycle.Event.Companion;
                                    Lifecycle.State state9 = observerWithState2.state;
                                    companion2.getClass();
                                    state9.getClass();
                                    int iOrdinal = state9.ordinal();
                                    if (iOrdinal == 1) {
                                        event = Lifecycle.Event.ON_CREATE;
                                    } else if (iOrdinal != 2) {
                                        event = iOrdinal != 3 ? null : Lifecycle.Event.ON_RESUME;
                                    } else {
                                        event = Lifecycle.Event.ON_START;
                                    }
                                    if (event == null) {
                                        PathKt$$ExternalSyntheticBUOutline0.m$2(observerWithState2.state, "no event up from ");
                                        return null;
                                    }
                                    observerWithState2.dispatchEvent(lifecycleOwner2, event);
                                    CollectionsKt__MutableCollectionsKt.removeLastOrNull(arrayList2);
                                }
                                break;
                        }
                    }
                };
                emojiProcessor3.getClass();
                for (FastSafeIterableMap$Entry fastSafeIterableMap$Entry5 = (FastSafeIterableMap$Entry) emojiProcessor3.mMetadataRepo; fastSafeIterableMap$Entry5 != null; fastSafeIterableMap$Entry5 = fastSafeIterableMap$Entry5.next) {
                    if (!fastSafeIterableMap$Entry5.isRemoved) {
                        function2.invoke(fastSafeIterableMap$Entry5);
                    }
                }
            }
        }
        this.newEventOccurred = false;
        this._currentStateFlow.setValue(this.state);
    }
}
