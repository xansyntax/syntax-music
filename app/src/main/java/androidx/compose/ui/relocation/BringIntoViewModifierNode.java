package androidx.compose.ui.relocation;

import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.NodeCoordinator;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface BringIntoViewModifierNode extends DelegatableNode {
    Object bringIntoView(NodeCoordinator nodeCoordinator, ComponentRegistry$Builder$$ExternalSyntheticLambda2 componentRegistry$Builder$$ExternalSyntheticLambda2, ContinuationImpl continuationImpl);
}
