package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import com.metrolist.music.ui.component.DialogKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TimePickerKt$$ExternalSyntheticLambda41 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ long f$3;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda41(int i, TimePickerState timePickerState, int i2, long j) {
        this.f$0 = i;
        this.f$1 = timePickerState;
        this.f$2 = i2;
        this.f$3 = j;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Object obj3;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$2;
        Object obj4 = this.f$1;
        switch (b) {
            case 0:
                TimePickerState timePickerState = (TimePickerState) obj4;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    String strM358numberContentDescriptiondSwYdS4 = TimePickerKt.m358numberContentDescriptiondSwYdS4(this.f$0 ? 1 : 0, timePickerState.is24hour(), i, gapComposer);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    boolean zChanged = gapComposer.changed(strM358numberContentDescriptiondSwYdS4);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                        obj3 = objRememberedValue;
                        IconKt$$ExternalSyntheticLambda1 iconKt$$ExternalSyntheticLambda1 = new IconKt$$ExternalSyntheticLambda1(strM358numberContentDescriptiondSwYdS4, (byte) 7);
                        gapComposer.updateRememberedValue(iconKt$$ExternalSyntheticLambda1);
                        obj3 = iconKt$$ExternalSyntheticLambda1;
                    }
                    obj3 = objRememberedValue;
                    TextKt.m352TextNvy7gAk(CalendarLocale_jvmAndAndroidKt.toLocalString$default(i, 14), SemanticsModifierKt.semantics(companion, false, (Function1) obj3), this.f$3, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262136);
                    gapComposer.end(true);
                }
                break;
            default:
                ((Integer) obj2).getClass();
                DialogKt.m1460CastButtoniJQMabo((Modifier) obj4, this.f$3, (Composer) obj, Stack.updateChangedFlags(i | 1), this.f$0 ? 1 : 0);
                break;
        }
        return unit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda41(Modifier modifier, long j, int i, int i2) {
        this.f$1 = modifier;
        this.f$3 = j;
        this.f$2 = i;
        this.f$0 = i2;
    }
}
