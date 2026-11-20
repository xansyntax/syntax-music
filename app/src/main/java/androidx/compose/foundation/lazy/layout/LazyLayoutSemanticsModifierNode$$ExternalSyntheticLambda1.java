package androidx.compose.foundation.lazy.layout;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LazyLayoutSemanticsModifierNode$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ LazyLayoutSemanticsModifierNode f$0;

    public /* synthetic */ LazyLayoutSemanticsModifierNode$$ExternalSyntheticLambda1(LazyLayoutSemanticsModifierNode lazyLayoutSemanticsModifierNode, byte b) {
        this.$r8$classId = b;
        this.f$0 = lazyLayoutSemanticsModifierNode;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        LazyLayoutSemanticsModifierNode lazyLayoutSemanticsModifierNode = this.f$0;
        switch (b) {
            case 0:
                return Float.valueOf(lazyLayoutSemanticsModifierNode.state.getScrollOffset());
            case 1:
                return Float.valueOf(lazyLayoutSemanticsModifierNode.state.getMaxScrollOffset());
            default:
                return Float.valueOf(lazyLayoutSemanticsModifierNode.state.getViewport() - lazyLayoutSemanticsModifierNode.state.getContentPadding());
        }
    }
}
