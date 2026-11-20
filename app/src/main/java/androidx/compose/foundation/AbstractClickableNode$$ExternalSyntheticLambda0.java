package androidx.compose.foundation;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.HitTestResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AbstractClickableNode$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ AbstractClickableNode f$0;

    public /* synthetic */ AbstractClickableNode$$ExternalSyntheticLambda0(AbstractClickableNode abstractClickableNode, byte b) {
        this.$r8$classId = b;
        this.f$0 = abstractClickableNode;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        DelegatableNode delegatableNode;
        byte b = this.$r8$classId;
        AbstractClickableNode abstractClickableNode = this.f$0;
        switch (b) {
            case 0:
                IndicationNodeFactory indicationNodeFactory = (IndicationNodeFactory) HitTestResultKt.currentValueOf(abstractClickableNode, IndicationKt.LocalIndication);
                if (indicationNodeFactory == null) {
                    InlineClassHelperKt.throwIllegalArgumentException("clickable only supports IndicationNodeFactory instances provided to LocalIndication, but Indication was provided instead. Either migrate the Indication implementation to implement IndicationNodeFactory, or use the other clickable overload that takes an Indication parameter, and explicitly pass LocalIndication.current there. The Indication instance provided here was: " + indicationNodeFactory);
                }
                IndicationNodeFactory indicationNodeFactory2 = abstractClickableNode.localIndicationNodeFactory;
                abstractClickableNode.localIndicationNodeFactory = indicationNodeFactory;
                if (indicationNodeFactory2 != null && !Intrinsics.areEqual(indicationNodeFactory, indicationNodeFactory2) && ((delegatableNode = abstractClickableNode.indicationNode) != null || !abstractClickableNode.lazilyCreateIndication)) {
                    if (delegatableNode != null) {
                        abstractClickableNode.undelegate(delegatableNode);
                    }
                    abstractClickableNode.indicationNode = null;
                    abstractClickableNode.initializeIndicationAndInteractionSourceIfNeeded();
                }
                return Unit.INSTANCE;
            default:
                abstractClickableNode.performClick();
                return Boolean.TRUE;
        }
    }
}
