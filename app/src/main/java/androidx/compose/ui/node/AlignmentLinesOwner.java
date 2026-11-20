package androidx.compose.ui.node;

import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.layout.Measurable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface AlignmentLinesOwner extends Measurable {
    void forEachChildAlignmentLinesOwner(TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2);

    LookaheadAlignmentLines getAlignmentLines();

    InnerNodeCoordinator getInnerCoordinator();

    AlignmentLinesOwner getParentAlignmentLinesOwner();

    int getPlaceOrder();

    void layoutChildren();

    void requestLayout();

    void requestMeasure();
}
