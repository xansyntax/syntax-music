package androidx.compose.runtime.internal;

import android.os.Trace;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import androidx.sqlite.SQLite;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RememberEventDispatcher {
    public Set abandoning;
    public MutableVector currentRememberingList;
    public MutableScatterSet ignoreLeavingSet;
    public final MutableVector leaving;
    public ArrayList nestedRemembersLists;
    public MutableScatterMap pausedPlaceholders;
    public MutableScatterSet releasing;
    public MutableScatterSet rememberSet;
    public final MutableVector remembering;
    public final MutableVector sideEffects;
    public CompositionErrorContextImpl traceContext;

    public RememberEventDispatcher() {
        MutableVector mutableVector = new MutableVector(new RememberObserverHolder[16]);
        this.remembering = mutableVector;
        MutableScatterSet mutableScatterSet = ScatterSetKt.EmptyScatterSet;
        this.rememberSet = new MutableScatterSet();
        this.currentRememberingList = mutableVector;
        this.leaving = new MutableVector(new Object[16]);
        this.sideEffects = new MutableVector(new Function0[16]);
    }

    public static final boolean forgetting$removeFrom(RememberObserverHolder rememberObserverHolder, MutableVector mutableVector) {
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            RememberObserver wrapped = ((RememberObserverHolder) objArr[i2]).getWrapped();
            if (wrapped instanceof PausedCompositionRemembers) {
                MutableVector mutableVector2 = ((PausedCompositionRemembers) wrapped).pausedRemembers;
                if (mutableVector2.remove(rememberObserverHolder) || forgetting$removeFrom(rememberObserverHolder, mutableVector2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void clear() {
        this.abandoning = null;
        this.traceContext = null;
        MutableVector mutableVector = this.remembering;
        mutableVector.clear();
        this.rememberSet.clear();
        this.currentRememberingList = mutableVector;
        this.leaving.clear();
        this.sideEffects.clear();
        this.releasing = null;
        this.pausedPlaceholders = null;
        this.nestedRemembersLists = null;
    }

    public final void dispatchAbandons() {
        Set set = this.abandoning;
        if (set == null || set.isEmpty()) {
            return;
        }
        Trace.beginSection("Compose:abandons");
        try {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                RememberObserver rememberObserver = (RememberObserver) it.next();
                it.remove();
                rememberObserver.onAbandoned();
            }
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0064 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void dispatchRememberObservers() {
        Set set = this.abandoning;
        if (set == null) {
            return;
        }
        this.ignoreLeavingSet = null;
        MutableVector mutableVector = this.leaving;
        byte b = 24;
        if (mutableVector.size != 0) {
            Trace.beginSection("Compose:onForgotten");
            MutableScatterSet mutableScatterSet = this.releasing;
            int i = mutableVector.size;
            while (true) {
                i--;
                if (-1 >= i) {
                    break;
                }
                Object obj = mutableVector.content[i];
                try {
                    if (obj instanceof RememberObserverHolder) {
                        RememberObserver wrapped = ((RememberObserverHolder) obj).getWrapped();
                        set.remove(wrapped);
                        wrapped.onForgotten();
                    }
                    if (obj instanceof ComposeNodeLifecycleCallback) {
                        if (mutableScatterSet == null || !mutableScatterSet.contains(obj)) {
                            ((ComposeNodeLifecycleCallback) obj).onDeactivate();
                        } else {
                            ((ComposeNodeLifecycleCallback) obj).onRelease();
                        }
                    }
                } catch (Throwable th) {
                    CompositionErrorContextImpl compositionErrorContextImpl = this.traceContext;
                    if (compositionErrorContextImpl != null) {
                        SQLite.tryAttachComposeStackTrace(new Recomposer$$ExternalSyntheticLambda6(compositionErrorContextImpl, obj, b), th);
                    }
                    throw th;
                }
            }
            Trace.endSection();
        }
        MutableVector mutableVector2 = this.remembering;
        if (mutableVector2.size != 0) {
            Trace.beginSection("Compose:onRemembered");
            try {
                Set set2 = this.abandoning;
                if (set2 != null) {
                    Object[] objArr = mutableVector2.content;
                    int i2 = mutableVector2.size;
                    for (int i3 = 0; i3 < i2; i3++) {
                        RememberObserverHolder rememberObserverHolder = (RememberObserverHolder) objArr[i3];
                        RememberObserver wrapped2 = rememberObserverHolder.getWrapped();
                        set2.remove(wrapped2);
                        try {
                            wrapped2.onRemembered();
                        } catch (Throwable th2) {
                            CompositionErrorContextImpl compositionErrorContextImpl2 = this.traceContext;
                            if (compositionErrorContextImpl2 != null) {
                                SQLite.tryAttachComposeStackTrace(new Recomposer$$ExternalSyntheticLambda6(compositionErrorContextImpl2, rememberObserverHolder, b), th2);
                            }
                            throw th2;
                        }
                    }
                }
                Trace.endSection();
            } catch (Throwable th3) {
                Trace.endSection();
                throw th3;
            }
        }
    }

    public final void dispatchSideEffects() {
        MutableVector mutableVector = this.sideEffects;
        if (mutableVector.size != 0) {
            Trace.beginSection("Compose:sideeffects");
            try {
                Object[] objArr = mutableVector.content;
                int i = mutableVector.size;
                for (int i2 = 0; i2 < i; i2++) {
                    ((Function0) objArr[i2]).invoke();
                }
                mutableVector.clear();
            } finally {
                Trace.endSection();
            }
        }
    }

    public final void forgetting(RememberObserverHolder rememberObserverHolder) {
        if (!this.rememberSet.contains(rememberObserverHolder)) {
            MutableScatterSet mutableScatterSet = this.ignoreLeavingSet;
            if (mutableScatterSet == null || !mutableScatterSet.contains(rememberObserverHolder)) {
                this.leaving.add(rememberObserverHolder);
                return;
            }
            return;
        }
        this.rememberSet.remove(rememberObserverHolder);
        if (!this.currentRememberingList.remove(rememberObserverHolder)) {
            MutableVector mutableVector = this.remembering;
            if (!mutableVector.remove(rememberObserverHolder)) {
                forgetting$removeFrom(rememberObserverHolder, mutableVector);
            }
        }
        Set set = this.abandoning;
        if (set == null) {
            return;
        }
        set.add(rememberObserverHolder.getWrapped());
    }

    public final void prepare(Set set, CompositionErrorContextImpl compositionErrorContextImpl) {
        clear();
        this.abandoning = set;
        this.traceContext = compositionErrorContextImpl;
    }

    public final void remembering(RememberObserverHolder rememberObserverHolder) {
        this.currentRememberingList.add(rememberObserverHolder);
        this.rememberSet.add(rememberObserverHolder);
    }
}
