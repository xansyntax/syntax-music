package androidx.compose.ui.node;

import androidx.compose.ui.graphics.Canvas;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class NodeCoordinator$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ NodeCoordinator f$0;

    public /* synthetic */ NodeCoordinator$$ExternalSyntheticLambda2(NodeCoordinator nodeCoordinator, byte b) {
        this.$r8$classId = b;
        this.f$0 = nodeCoordinator;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NodeCoordinator nodeCoordinator = this.f$0;
        switch (b) {
            case 0:
                Canvas canvas = nodeCoordinator.drawBlockCanvas;
                canvas.getClass();
                nodeCoordinator.drawContainedDrawModifiers(canvas, nodeCoordinator.drawBlockParentLayer);
                break;
            default:
                NodeCoordinator nodeCoordinator2 = nodeCoordinator.wrappedBy;
                if (nodeCoordinator2 != null) {
                    nodeCoordinator2.invalidateLayer();
                }
                break;
        }
        return unit;
    }
}
