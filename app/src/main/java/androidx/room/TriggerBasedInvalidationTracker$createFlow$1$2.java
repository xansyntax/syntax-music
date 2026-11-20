package androidx.room;

import androidx.compose.foundation.DefaultDebugIndication;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.TextInputService;
import java.util.ArrayList;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest.AnonymousClass3;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TriggerBasedInvalidationTracker$createFlow$1$2 implements FlowCollector {
    public final /* synthetic */ Object $$this$flow;
    public final /* synthetic */ Object $currentVersions;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object $resolvedTableNames;
    public final /* synthetic */ Object $tableIds;

    public TriggerBasedInvalidationTracker$createFlow$1$2(Ref$ObjectRef ref$ObjectRef, CoroutineScope coroutineScope, ChannelFlowTransformLatest channelFlowTransformLatest, FlowCollector flowCollector) {
        this.$r8$classId = (byte) 3;
        this.$currentVersions = ref$ObjectRef;
        this.$resolvedTableNames = coroutineScope;
        this.$tableIds = channelFlowTransformLatest;
        this.$$this$flow = flowCollector;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0025  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        ChannelFlowTransformLatest$flowCollect$3$1$emit$1 channelFlowTransformLatest$flowCollect$3$1$emit$1;
        byte b = this.$r8$classId;
        boolean z = true;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.$$this$flow;
        Object obj3 = this.$tableIds;
        Object obj4 = this.$resolvedTableNames;
        Object obj5 = this.$currentVersions;
        switch (b) {
            case 0:
                return emit((int[]) obj, continuation);
            case 1:
                Interaction interaction = (Interaction) obj;
                Ref$IntRef ref$IntRef = (Ref$IntRef) obj4;
                Ref$IntRef ref$IntRef2 = (Ref$IntRef) obj2;
                Ref$IntRef ref$IntRef3 = (Ref$IntRef) obj5;
                if (interaction instanceof PressInteraction.Press) {
                    ref$IntRef3.element++;
                } else if ((interaction instanceof PressInteraction.Release) || (interaction instanceof PressInteraction.Cancel)) {
                    ref$IntRef3.element--;
                } else if (interaction instanceof HoverInteraction$Enter) {
                    ref$IntRef2.element++;
                } else if (interaction instanceof HoverInteraction$Exit) {
                    ref$IntRef2.element--;
                } else if (interaction instanceof FocusInteraction.Focus) {
                    ref$IntRef.element++;
                } else if (interaction instanceof FocusInteraction.Unfocus) {
                    ref$IntRef.element--;
                }
                boolean z2 = false;
                boolean z3 = ref$IntRef3.element > 0;
                boolean z4 = ref$IntRef2.element > 0;
                boolean z5 = ref$IntRef.element > 0;
                DefaultDebugIndication.DefaultDebugIndicationInstance defaultDebugIndicationInstance = (DefaultDebugIndication.DefaultDebugIndicationInstance) obj3;
                if (defaultDebugIndicationInstance.isPressed != z3) {
                    defaultDebugIndicationInstance.isPressed = z3;
                    z2 = true;
                }
                if (defaultDebugIndicationInstance.isHovered != z4) {
                    defaultDebugIndicationInstance.isHovered = z4;
                    z2 = true;
                }
                if (defaultDebugIndicationInstance.isFocused != z5) {
                    defaultDebugIndicationInstance.isFocused = z5;
                } else {
                    z = z2;
                }
                if (z) {
                    HitTestResultKt.invalidateDraw(defaultDebugIndicationInstance);
                }
                return unit;
            case 2:
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) obj4;
                LegacyTextFieldState legacyTextFieldState = (LegacyTextFieldState) obj5;
                if (((Boolean) obj).booleanValue() && legacyTextFieldState.getHasFocus()) {
                    BasicTextKt.startInputSession((TextInputService) obj2, legacyTextFieldState, textFieldSelectionManager.getValue$foundation(), (ImeOptions) obj3, textFieldSelectionManager.offsetMapping);
                } else {
                    BasicTextKt.endInputSession(legacyTextFieldState);
                }
                return unit;
            default:
                Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) obj5;
                if (continuation instanceof ChannelFlowTransformLatest$flowCollect$3$1$emit$1) {
                    channelFlowTransformLatest$flowCollect$3$1$emit$1 = (ChannelFlowTransformLatest$flowCollect$3$1$emit$1) continuation;
                    int i = channelFlowTransformLatest$flowCollect$3$1$emit$1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        channelFlowTransformLatest$flowCollect$3$1$emit$1.label = i - Integer.MIN_VALUE;
                    } else {
                        channelFlowTransformLatest$flowCollect$3$1$emit$1 = new ChannelFlowTransformLatest$flowCollect$3$1$emit$1(this, continuation);
                    }
                } else {
                    channelFlowTransformLatest$flowCollect$3$1$emit$1 = new ChannelFlowTransformLatest$flowCollect$3$1$emit$1(this, continuation);
                }
                Object obj6 = channelFlowTransformLatest$flowCollect$3$1$emit$1.result;
                int i2 = channelFlowTransformLatest$flowCollect$3$1$emit$1.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj6);
                    Job job = (Job) ref$ObjectRef.element;
                    if (job != null) {
                        job.cancel(new ChildCancelledException("Child of the scoped flow was cancelled"));
                        channelFlowTransformLatest$flowCollect$3$1$emit$1.L$0 = obj;
                        channelFlowTransformLatest$flowCollect$3$1$emit$1.label = 1;
                        Object objJoin = job.join(channelFlowTransformLatest$flowCollect$3$1$emit$1);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objJoin == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                } else {
                    if (i2 != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    obj = channelFlowTransformLatest$flowCollect$3$1$emit$1.L$0;
                    ResultKt.throwOnFailure(obj6);
                }
                ref$ObjectRef.element = AwaitKt.launch$default((CoroutineScope) obj4, null, CoroutineStart.UNDISPATCHED, ((ChannelFlowTransformLatest) obj3).new AnonymousClass3((FlowCollector) obj2, obj, null), 1);
                return unit;
        }
    }

    public /* synthetic */ TriggerBasedInvalidationTracker$createFlow$1$2(Object obj, Object obj2, Object obj3, Object obj4, byte b) {
        this.$r8$classId = b;
        this.$currentVersions = obj;
        this.$$this$flow = obj2;
        this.$resolvedTableNames = obj3;
        this.$tableIds = obj4;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001f  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0053, code lost:
    
        if (r1.emit(r13, r3) == r4) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0095, code lost:
    
        if (r1.emit(r13, r3) == r4) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0097, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(int[] iArr, Continuation continuation) {
        TriggerBasedInvalidationTracker$createFlow$1$2$emit$1 triggerBasedInvalidationTracker$createFlow$1$2$emit$1;
        String[] strArr = (String[]) this.$resolvedTableNames;
        FlowCollector flowCollector = (FlowCollector) this.$$this$flow;
        Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) this.$currentVersions;
        if (continuation instanceof TriggerBasedInvalidationTracker$createFlow$1$2$emit$1) {
            triggerBasedInvalidationTracker$createFlow$1$2$emit$1 = (TriggerBasedInvalidationTracker$createFlow$1$2$emit$1) continuation;
            int i = triggerBasedInvalidationTracker$createFlow$1$2$emit$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                triggerBasedInvalidationTracker$createFlow$1$2$emit$1.label = i - Integer.MIN_VALUE;
            } else {
                triggerBasedInvalidationTracker$createFlow$1$2$emit$1 = new TriggerBasedInvalidationTracker$createFlow$1$2$emit$1(this, continuation);
            }
        } else {
            triggerBasedInvalidationTracker$createFlow$1$2$emit$1 = new TriggerBasedInvalidationTracker$createFlow$1$2$emit$1(this, continuation);
        }
        Object obj = triggerBasedInvalidationTracker$createFlow$1$2$emit$1.result;
        int i2 = triggerBasedInvalidationTracker$createFlow$1$2$emit$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = ref$ObjectRef.element;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (obj2 == null) {
                Set set = ArraysKt.toSet(strArr);
                triggerBasedInvalidationTracker$createFlow$1$2$emit$1.L$0 = iArr;
                triggerBasedInvalidationTracker$createFlow$1$2$emit$1.label = 1;
            } else {
                int[] iArr2 = (int[]) this.$tableIds;
                ArrayList arrayList = new ArrayList();
                int length = strArr.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    String str = strArr[i3];
                    int i5 = i4 + 1;
                    Object obj3 = ref$ObjectRef.element;
                    if (obj3 != null) {
                        int i6 = iArr2[i4];
                        if (((int[]) obj3)[i6] != iArr[i6]) {
                            arrayList.add(str);
                        }
                        i3++;
                        i4 = i5;
                    } else {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Required value was null.");
                        return null;
                    }
                }
                if (!arrayList.isEmpty()) {
                    Set set2 = CollectionsKt.toSet(arrayList);
                    triggerBasedInvalidationTracker$createFlow$1$2$emit$1.L$0 = iArr;
                    triggerBasedInvalidationTracker$createFlow$1$2$emit$1.label = 2;
                }
            }
        } else {
            if (i2 != 1 && i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            iArr = triggerBasedInvalidationTracker$createFlow$1$2$emit$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        ref$ObjectRef.element = iArr;
        return Unit.INSTANCE;
    }
}
