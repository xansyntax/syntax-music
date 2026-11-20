package androidx.compose.material3;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ThumbNode$onAttach$1$1 implements FlowCollector {
    public final /* synthetic */ Serializable $pressCount;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Modifier.Node this$0;

    public /* synthetic */ ThumbNode$onAttach$1$1(Serializable serializable, Modifier.Node node, byte b) {
        this.$r8$classId = b;
        this.$pressCount = serializable;
        this.this$0 = node;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Modifier.Node node = this.this$0;
        Serializable serializable = this.$pressCount;
        switch (b) {
            case 0:
                Interaction interaction = (Interaction) obj;
                Ref$IntRef ref$IntRef = (Ref$IntRef) serializable;
                if (interaction instanceof PressInteraction.Press) {
                    ref$IntRef.element++;
                } else if ((interaction instanceof PressInteraction.Release) || (interaction instanceof PressInteraction.Cancel)) {
                    ref$IntRef.element--;
                }
                boolean z = ref$IntRef.element > 0;
                ThumbNode thumbNode = (ThumbNode) node;
                if (thumbNode.isPressed != z) {
                    thumbNode.isPressed = z;
                    HitTestResultKt.invalidateMeasurement(thumbNode);
                }
                break;
            default:
                Interaction interaction2 = (Interaction) obj;
                ArrayList arrayList = (ArrayList) serializable;
                if (interaction2 instanceof FocusInteraction.Focus) {
                    arrayList.add(interaction2);
                } else if (interaction2 instanceof FocusInteraction.Unfocus) {
                    arrayList.remove(((FocusInteraction.Unfocus) interaction2).focus);
                }
                boolean z2 = !arrayList.isEmpty();
                IndicatorLineNode indicatorLineNode = (IndicatorLineNode) node;
                if (z2 != indicatorLineNode.focused) {
                    indicatorLineNode.focused = z2;
                    indicatorLineNode.invalidateIndicator();
                }
                break;
        }
        return unit;
    }
}
