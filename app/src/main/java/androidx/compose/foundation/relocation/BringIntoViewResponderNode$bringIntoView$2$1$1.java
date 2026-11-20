package androidx.compose.foundation.relocation;

import androidx.compose.ui.node.NodeCoordinator;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BringIntoViewResponderNode$bringIntoView$2$1$1 extends FunctionReferenceImpl implements Function0 {
    public final /* synthetic */ ComponentRegistry$Builder$$ExternalSyntheticLambda2 $boundsProvider;
    public final /* synthetic */ NodeCoordinator $childCoordinates;
    public final /* synthetic */ BringIntoViewResponderNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BringIntoViewResponderNode$bringIntoView$2$1$1(BringIntoViewResponderNode bringIntoViewResponderNode, NodeCoordinator nodeCoordinator, ComponentRegistry$Builder$$ExternalSyntheticLambda2 componentRegistry$Builder$$ExternalSyntheticLambda2) {
        super(0, Intrinsics.Kotlin.class, "localRect", "bringIntoView$localRect(Landroidx/compose/foundation/relocation/BringIntoViewResponderNode;Landroidx/compose/ui/layout/LayoutCoordinates;Lkotlin/jvm/functions/Function0;)Landroidx/compose/ui/geometry/Rect;", 0);
        this.this$0 = bringIntoViewResponderNode;
        this.$childCoordinates = nodeCoordinator;
        this.$boundsProvider = componentRegistry$Builder$$ExternalSyntheticLambda2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return BringIntoViewResponderNode.bringIntoView$localRect(this.this$0, this.$childCoordinates, this.$boundsProvider);
    }
}
