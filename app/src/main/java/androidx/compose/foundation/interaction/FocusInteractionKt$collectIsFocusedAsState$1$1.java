package androidx.compose.foundation.interaction;

import androidx.compose.runtime.MutableState;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FocusInteractionKt$collectIsFocusedAsState$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MutableState $isFocused;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ InteractionSource $this_collectIsFocusedAsState;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FocusInteractionKt$collectIsFocusedAsState$1$1(InteractionSource interactionSource, MutableState mutableState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$this_collectIsFocusedAsState = interactionSource;
        this.$isFocused = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new FocusInteractionKt$collectIsFocusedAsState$1$1(this.$this_collectIsFocusedAsState, this.$isFocused, continuation, (byte) 0);
            default:
                return new FocusInteractionKt$collectIsFocusedAsState$1$1(this.$this_collectIsFocusedAsState, this.$isFocused, continuation, (byte) 1);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
        }
        return ((FocusInteractionKt$collectIsFocusedAsState$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        final MutableState mutableState = this.$isFocused;
        InteractionSource interactionSource = this.$this_collectIsFocusedAsState;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        final byte b2 = 1;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                final ArrayList arrayList = new ArrayList();
                Flow interactions = interactionSource.getInteractions();
                final byte b3 = 0;
                FlowCollector flowCollector = new FlowCollector() { // from class: androidx.compose.foundation.interaction.FocusInteractionKt$collectIsFocusedAsState$1$1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj2, Continuation continuation) {
                        byte b4 = b3;
                        Unit unit2 = Unit.INSTANCE;
                        MutableState mutableState2 = mutableState;
                        ArrayList arrayList2 = arrayList;
                        switch (b4) {
                            case 0:
                                Interaction interaction = (Interaction) obj2;
                                if (interaction instanceof FocusInteraction.Focus) {
                                    arrayList2.add(interaction);
                                } else if (interaction instanceof FocusInteraction.Unfocus) {
                                    arrayList2.remove(((FocusInteraction.Unfocus) interaction).focus);
                                }
                                mutableState2.setValue(Boolean.valueOf(!arrayList2.isEmpty()));
                                break;
                            default:
                                Interaction interaction2 = (Interaction) obj2;
                                if (interaction2 instanceof PressInteraction.Press) {
                                    arrayList2.add(interaction2);
                                } else if (interaction2 instanceof PressInteraction.Release) {
                                    arrayList2.remove(((PressInteraction.Release) interaction2).press);
                                } else if (interaction2 instanceof PressInteraction.Cancel) {
                                    arrayList2.remove(((PressInteraction.Cancel) interaction2).press);
                                }
                                mutableState2.setValue(Boolean.valueOf(!arrayList2.isEmpty()));
                                break;
                        }
                        return unit2;
                    }
                };
                this.label = true;
                return interactions.collect(flowCollector, this) == coroutineSingletons ? coroutineSingletons : unit;
            default:
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                final ArrayList arrayList2 = new ArrayList();
                Flow interactions2 = interactionSource.getInteractions();
                FlowCollector flowCollector2 = new FlowCollector() { // from class: androidx.compose.foundation.interaction.FocusInteractionKt$collectIsFocusedAsState$1$1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj2, Continuation continuation) {
                        byte b4 = b2;
                        Unit unit2 = Unit.INSTANCE;
                        MutableState mutableState2 = mutableState;
                        ArrayList arrayList3 = arrayList2;
                        switch (b4) {
                            case 0:
                                Interaction interaction = (Interaction) obj2;
                                if (interaction instanceof FocusInteraction.Focus) {
                                    arrayList3.add(interaction);
                                } else if (interaction instanceof FocusInteraction.Unfocus) {
                                    arrayList3.remove(((FocusInteraction.Unfocus) interaction).focus);
                                }
                                mutableState2.setValue(Boolean.valueOf(!arrayList3.isEmpty()));
                                break;
                            default:
                                Interaction interaction2 = (Interaction) obj2;
                                if (interaction2 instanceof PressInteraction.Press) {
                                    arrayList3.add(interaction2);
                                } else if (interaction2 instanceof PressInteraction.Release) {
                                    arrayList3.remove(((PressInteraction.Release) interaction2).press);
                                } else if (interaction2 instanceof PressInteraction.Cancel) {
                                    arrayList3.remove(((PressInteraction.Cancel) interaction2).press);
                                }
                                mutableState2.setValue(Boolean.valueOf(!arrayList3.isEmpty()));
                                break;
                        }
                        return unit2;
                    }
                };
                this.label = true;
                return interactions2.collect(flowCollector2, this) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }
}
