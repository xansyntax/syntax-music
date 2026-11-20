package androidx.compose.ui.node;

import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNodeKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface ComposeUiNode {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion implements NodeCoordinator.HitTestSource {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final TextKt$$ExternalSyntheticLambda3 VirtualConstructor = new TextKt$$ExternalSyntheticLambda3((byte) 24);
        public static final Updater$$ExternalSyntheticLambda0 SetModifier = new Updater$$ExternalSyntheticLambda0((byte) 11);
        public static final Updater$$ExternalSyntheticLambda0 SetResolvedCompositionLocals = new Updater$$ExternalSyntheticLambda0((byte) 12);
        public static final Updater$$ExternalSyntheticLambda0 SetMeasurePolicy = new Updater$$ExternalSyntheticLambda0((byte) 13);
        public static final Updater$$ExternalSyntheticLambda0 SetCompositeKeyHash = new Updater$$ExternalSyntheticLambda0((byte) 14);
        public static final ComposedModifierKt$$ExternalSyntheticLambda0 ApplyOnDeactivatedNodeAssertion = new ComposedModifierKt$$ExternalSyntheticLambda0((byte) 10);

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* JADX INFO: renamed from: childHitTest-qzLsGqo, reason: not valid java name */
        public void mo638childHitTestqzLsGqo(LayoutNode layoutNode, long j, HitTestResult hitTestResult, int i, boolean z) {
            NodeChain nodeChain = layoutNode.nodes;
            NodeCoordinator nodeCoordinator = (NodeCoordinator) nodeChain.outerCoordinator;
            ComposedModifierKt$$ExternalSyntheticLambda0 composedModifierKt$$ExternalSyntheticLambda0 = NodeCoordinator.onCommitAffectingLayerParams;
            ((NodeCoordinator) nodeChain.outerCoordinator).m671hitTestqzLsGqo(NodeCoordinator.SemanticsSource, nodeCoordinator.m666fromParentPosition8S9VItk(j), hitTestResult, 1, z);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* JADX INFO: renamed from: entityType-OLwlOKw, reason: not valid java name */
        public int mo639entityTypeOLwlOKw() {
            return 8;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shareWithSiblings(HitTestResult hitTestResult, LayoutNode layoutNode) {
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTest(Modifier.Node node) {
            return SemanticsNodeKt.isImportantForAccessibility(SemanticsNodeKt.SemanticsNode(HitTestResultKt.requireLayoutNode(node), false));
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode layoutNode) {
            SemanticsConfiguration semanticsConfiguration = layoutNode.getSemanticsConfiguration();
            boolean z = false;
            if (semanticsConfiguration != null && semanticsConfiguration.isClearingSemantics) {
                z = true;
            }
            return !z;
        }
    }
}
