package dev.chrisbanes.haze;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ldev/chrisbanes/haze/HazeEffectNodeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Ldev/chrisbanes/haze/HazeEffectNode;", "haze_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class HazeEffectNodeElement extends ModifierNodeElement {
    public final Function1 block;
    public final HazeState state;
    public final HazeStyle style;

    public HazeEffectNodeElement(HazeState hazeState, HazeStyle hazeStyle, Function1 function1) {
        this.state = hazeState;
        this.style = hazeStyle;
        this.block = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new HazeEffectNode(this.state, this.style, this.block);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HazeEffectNodeElement)) {
            return false;
        }
        HazeEffectNodeElement hazeEffectNodeElement = (HazeEffectNodeElement) obj;
        return Intrinsics.areEqual(this.state, hazeEffectNodeElement.state) && this.style.equals(hazeEffectNodeElement.style) && Intrinsics.areEqual(this.block, hazeEffectNodeElement.block);
    }

    public final int hashCode() {
        HazeState hazeState = this.state;
        int iHashCode = (this.style.hashCode() + ((hazeState == null ? 0 : hazeState.hashCode()) * 31)) * 31;
        Function1 function1 = this.block;
        return iHashCode + (function1 != null ? function1.hashCode() : 0);
    }

    public final String toString() {
        return "HazeEffectNodeElement(state=" + this.state + ", style=" + this.style + ", block=" + this.block + ")";
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        HazeEffectNode hazeEffectNode = (HazeEffectNode) node;
        hazeEffectNode.getClass();
        hazeEffectNode.state = this.state;
        HazeStyle hazeStyle = hazeEffectNode.style;
        HazeStyle hazeStyle2 = this.style;
        if (!Intrinsics.areEqual(hazeStyle, hazeStyle2)) {
            hazeEffectNode.onStyleChanged(hazeEffectNode.style, hazeStyle2);
            hazeEffectNode.style = hazeStyle2;
        }
        hazeEffectNode.block = this.block;
        hazeEffectNode.onObservedReadsChanged();
    }
}
