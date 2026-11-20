package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import java.util.Set;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CompositionContext {
    public abstract void composeInitial$runtime(CompositionImpl compositionImpl, Function2 function2);

    public abstract MutableScatterSet composeInitialPaused$runtime(CompositionImpl compositionImpl, ShouldPauseCallback shouldPauseCallback, Function2 function2);

    public boolean getCollectingCallByInformation$runtime() {
        return ((Boolean) Recomposer._hotReloadEnabled.get()).booleanValue();
    }

    public boolean getCollectingParameterInformation$runtime() {
        return false;
    }

    public boolean getCollectingSourceInformation$runtime() {
        return false;
    }

    public long getCompositeKeyHashCode$runtime() {
        return 1000L;
    }

    public Composition getComposition$runtime() {
        return null;
    }

    public PersistentCompositionLocalHashMap getCompositionLocalScope$runtime() {
        return CompositionContextKt.EmptyPersistentCompositionLocalMap;
    }

    public abstract CoroutineContext getEffectCoroutineContext();

    public boolean getStackTraceEnabled$runtime() {
        return false;
    }

    public abstract void invalidate$runtime(CompositionImpl compositionImpl);

    public abstract MovableContentState movableContentStateResolve$runtime(MovableContentStateReference movableContentStateReference);

    public abstract MutableScatterSet recomposePaused$runtime(CompositionImpl compositionImpl, ShouldPauseCallback shouldPauseCallback, MutableScatterSet mutableScatterSet);

    public abstract void reportPausedScope$runtime(RecomposeScopeImpl recomposeScopeImpl);

    public abstract void reportRemovedComposition$runtime(CompositionImpl compositionImpl);

    public abstract CancellationHandle scheduleFrameEndCallback(RoomDatabase$$ExternalSyntheticLambda0 roomDatabase$$ExternalSyntheticLambda0);

    public abstract void unregisterComposition$runtime(CompositionImpl compositionImpl);

    public void doneComposing$runtime() {
    }

    public void startComposing$runtime() {
    }

    public void recordInspectionTable$runtime(Set set) {
    }

    public void registerComposer$runtime(GapComposer gapComposer) {
    }

    public void unregisterComposer$runtime(GapComposer gapComposer) {
    }
}
