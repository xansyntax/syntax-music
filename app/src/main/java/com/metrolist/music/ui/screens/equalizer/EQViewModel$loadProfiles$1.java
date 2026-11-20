package com.metrolist.music.ui.screens.equalizer;

import androidx.palette.graphics.ColorCutQuantizer;
import com.metrolist.music.eq.data.SavedEQProfile;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EQViewModel$loadProfiles$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public final /* synthetic */ EQViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EQViewModel$loadProfiles$1(EQViewModel eQViewModel, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = eQViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        EQViewModel eQViewModel = this.this$0;
        switch (b) {
            case 0:
                return new EQViewModel$loadProfiles$1(eQViewModel, continuation, (byte) 0);
            default:
                return new EQViewModel$loadProfiles$1(eQViewModel, continuation, (byte) 1);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                ((EQViewModel$loadProfiles$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
            default:
                ((EQViewModel$loadProfiles$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                break;
        }
        return coroutineSingletons;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        final EQViewModel eQViewModel = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        final byte b2 = 1;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                ReadonlyStateFlow readonlyStateFlow = eQViewModel.eqProfileRepository.profiles;
                final byte b3 = 0;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.metrolist.music.ui.screens.equalizer.EQViewModel$loadProfiles$1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj2, Continuation continuation) {
                        Object value;
                        Object value2;
                        byte b4 = b3;
                        Unit unit = Unit.INSTANCE;
                        EQViewModel eQViewModel2 = eQViewModel;
                        switch (b4) {
                            case 0:
                                Iterable iterable = (Iterable) eQViewModel2.eqProfileRepository._profiles.getValue();
                                ArrayList arrayList = new ArrayList();
                                for (Object obj3 : iterable) {
                                    if (((SavedEQProfile) obj3).isCustom) {
                                        arrayList.add(obj3);
                                    }
                                }
                                List listSortedWith = CollectionsKt.sortedWith(arrayList, new ColorCutQuantizer.AnonymousClass1((byte) 9));
                                StateFlowImpl stateFlowImpl = eQViewModel2._state;
                                do {
                                    value = stateFlowImpl.getValue();
                                } while (!stateFlowImpl.compareAndSet(value, EQState.copy$default((EQState) value, listSortedWith, null, null, null, 14)));
                                break;
                            default:
                                SavedEQProfile savedEQProfile = (SavedEQProfile) obj2;
                                StateFlowImpl stateFlowImpl2 = eQViewModel2._state;
                                do {
                                    value2 = stateFlowImpl2.getValue();
                                } while (!stateFlowImpl2.compareAndSet(value2, EQState.copy$default((EQState) value2, null, savedEQProfile != null ? savedEQProfile.id : null, null, null, 13)));
                                break;
                        }
                        return unit;
                    }
                };
                this.label = true;
                if (readonlyStateFlow.$$delegate_0.collect(flowCollector, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                return null;
            default:
                boolean z2 = this.label;
                if (z2) {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                ReadonlyStateFlow readonlyStateFlow2 = eQViewModel.eqProfileRepository.activeProfile;
                FlowCollector flowCollector2 = new FlowCollector() { // from class: com.metrolist.music.ui.screens.equalizer.EQViewModel$loadProfiles$1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj2, Continuation continuation) {
                        Object value;
                        Object value2;
                        byte b4 = b2;
                        Unit unit = Unit.INSTANCE;
                        EQViewModel eQViewModel2 = eQViewModel;
                        switch (b4) {
                            case 0:
                                Iterable iterable = (Iterable) eQViewModel2.eqProfileRepository._profiles.getValue();
                                ArrayList arrayList = new ArrayList();
                                for (Object obj3 : iterable) {
                                    if (((SavedEQProfile) obj3).isCustom) {
                                        arrayList.add(obj3);
                                    }
                                }
                                List listSortedWith = CollectionsKt.sortedWith(arrayList, new ColorCutQuantizer.AnonymousClass1((byte) 9));
                                StateFlowImpl stateFlowImpl = eQViewModel2._state;
                                do {
                                    value = stateFlowImpl.getValue();
                                } while (!stateFlowImpl.compareAndSet(value, EQState.copy$default((EQState) value, listSortedWith, null, null, null, 14)));
                                break;
                            default:
                                SavedEQProfile savedEQProfile = (SavedEQProfile) obj2;
                                StateFlowImpl stateFlowImpl2 = eQViewModel2._state;
                                do {
                                    value2 = stateFlowImpl2.getValue();
                                } while (!stateFlowImpl2.compareAndSet(value2, EQState.copy$default((EQState) value2, null, savedEQProfile != null ? savedEQProfile.id : null, null, null, 13)));
                                break;
                        }
                        return unit;
                    }
                };
                this.label = true;
                if (readonlyStateFlow2.$$delegate_0.collect(flowCollector2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                return null;
        }
    }
}
