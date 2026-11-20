package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Velocity;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DraggableKt {
    public static final DraggableKt$NoOpOnDragStarted$1 NoOpOnDragStarted = new DraggableKt$NoOpOnDragStarted$1(3, null, (byte) 0);
    public static final DraggableKt$NoOpOnDragStarted$1 NoOpOnDragStopped = new DraggableKt$NoOpOnDragStarted$1(3, null, (byte) 1);

    public static Modifier draggable$default(Modifier modifier, DraggableState draggableState, Orientation orientation, boolean z, MutableInteractionSourceImpl mutableInteractionSourceImpl, boolean z2, Function3 function3, boolean z3, int i) {
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z4 = z;
        if ((i & 8) != 0) {
            mutableInteractionSourceImpl = null;
        }
        return modifier.then(new DraggableElement(draggableState, orientation, z4, mutableInteractionSourceImpl, (i & 16) != 0 ? false : z2, NoOpOnDragStarted, function3, (i & 128) != 0 ? false : z3));
    }

    /* JADX INFO: renamed from: toValidVelocity-TH1AsA0, reason: not valid java name */
    public static final long m68toValidVelocityTH1AsA0(long j) {
        boolean zIsNaN = Float.isNaN(Velocity.m819getXimpl(j));
        float fM820getYimpl = CropImageView.DEFAULT_ASPECT_RATIO;
        float fM819getXimpl = zIsNaN ? 0.0f : Velocity.m819getXimpl(j);
        if (!Float.isNaN(Velocity.m820getYimpl(j))) {
            fM820getYimpl = Velocity.m820getYimpl(j);
        }
        return MathKt.Velocity(fM819getXimpl, fM820getYimpl);
    }
}
