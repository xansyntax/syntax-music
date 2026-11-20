package androidx.room;

import androidx.datastore.core.Data;
import androidx.datastore.core.Final;
import androidx.datastore.core.NoValueDataState;
import androidx.datastore.core.ReadException;
import androidx.datastore.core.State;
import androidx.datastore.core.UnInitialized;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ObservedTableVersions {
    public final StateFlowImpl versions;

    /* JADX INFO: renamed from: androidx.room.ObservedTableVersions$collect$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            ObservedTableVersions.this.collect(null, this);
            return CoroutineSingletons.COROUTINE_SUSPENDED;
        }
    }

    public ObservedTableVersions() {
        this.versions = StateFlowKt.MutableStateFlow(UnInitialized.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public void collect(TriggerBasedInvalidationTracker$createFlow$1$2 triggerBasedInvalidationTracker$createFlow$1$2, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                throw Fragment$5$$ExternalSyntheticOutline0.m(obj);
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            anonymousClass1.label = 1;
            this.versions.collect(triggerBasedInvalidationTracker$createFlow$1$2, anonymousClass1);
        }
    }

    public State getCurrentState() {
        return (State) this.versions.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x003a  */
    public void tryUpdate(State state) {
        StateFlowImpl stateFlowImpl;
        Object value;
        State state2;
        state.getClass();
        do {
            stateFlowImpl = this.versions;
            value = stateFlowImpl.getValue();
            state2 = (State) value;
            if ((state2 instanceof ReadException) || Intrinsics.areEqual(state2, UnInitialized.INSTANCE)) {
                state2 = state;
            } else if (state2 instanceof Data) {
                if (state.version > ((Data) state2).version) {
                    state2 = state;
                }
            } else if (!(state2 instanceof Final)) {
                if (state2 instanceof NoValueDataState) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542");
                    return;
                } else {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
            }
        } while (!stateFlowImpl.compareAndSet(value, state2));
    }

    public ObservedTableVersions(int i) {
        this.versions = StateFlowKt.MutableStateFlow(new int[i]);
    }
}
