package androidx.compose.ui.node;

import androidx.compose.ui.unit.DensityImpl;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.util.LifecyclesKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LayoutNodeKt {
    public static final DensityImpl DefaultDensity = LifecyclesKt.Density$default();

    public static final Owner requireOwner(LayoutNode layoutNode) {
        Owner owner = layoutNode.owner;
        if (owner != null) {
            return owner;
        }
        throw Fragment$5$$ExternalSyntheticOutline0.m$2("LayoutNode should be attached to an owner");
    }
}
