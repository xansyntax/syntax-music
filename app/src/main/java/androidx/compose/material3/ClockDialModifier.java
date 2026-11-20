package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/material3/ClockDialModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/ClockDialNode;", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ClockDialModifier extends ModifierNodeElement {
    public final AnimationSpec animationSpec;
    public final boolean autoSwitchToMinute;
    public final int selection;
    public final AnalogTimePickerState state;

    public ClockDialModifier(AnalogTimePickerState analogTimePickerState, boolean z, int i, FiniteAnimationSpec finiteAnimationSpec) {
        this.state = analogTimePickerState;
        this.autoSwitchToMinute = z;
        this.selection = i;
        this.animationSpec = finiteAnimationSpec;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new ClockDialNode(this.state, this.autoSwitchToMinute, this.selection, this.animationSpec);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClockDialModifier)) {
            return false;
        }
        ClockDialModifier clockDialModifier = (ClockDialModifier) obj;
        return Intrinsics.areEqual(this.state, clockDialModifier.state) && this.autoSwitchToMinute == clockDialModifier.autoSwitchToMinute && this.selection == clockDialModifier.selection && Intrinsics.areEqual(this.animationSpec, clockDialModifier.animationSpec);
    }

    public final int hashCode() {
        return this.animationSpec.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.selection, IntIntPair$$ExternalSyntheticOutline0.m(this.state.hashCode() * 31, this.autoSwitchToMinute, 31), 31);
    }

    public final String toString() {
        String str;
        int i = this.selection;
        if (i == 0) {
            str = "Hour";
        } else {
            str = i == 1 ? "Minute" : "";
        }
        return "ClockDialModifier(state=" + this.state + ", autoSwitchToMinute=" + this.autoSwitchToMinute + ", selection=" + str + ", animationSpec=" + this.animationSpec + ")";
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ClockDialNode clockDialNode = (ClockDialNode) node;
        AnalogTimePickerState analogTimePickerState = this.state;
        clockDialNode.state = analogTimePickerState;
        clockDialNode.autoSwitchToMinute = this.autoSwitchToMinute;
        AnimationSpec animationSpec = this.animationSpec;
        clockDialNode.animationSpec = animationSpec;
        int i = clockDialNode.selection;
        int i2 = this.selection;
        if (i == i2) {
            return;
        }
        clockDialNode.selection = i2;
        AwaitKt.launch$default(clockDialNode.getCoroutineScope(), null, null, new SliderState.AnonymousClass2(analogTimePickerState, animationSpec, null, (byte) 14), 3);
    }
}
