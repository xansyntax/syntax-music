package dev.chrisbanes.haze;

import androidx.compose.runtime.snapshots.StateSetIterator;
import androidx.compose.ui.node.HitTestResultKt;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HazeEffectNode$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ HazeSourceNode f$1;

    public /* synthetic */ HazeEffectNode$$ExternalSyntheticLambda3(HazeEffectNode hazeEffectNode, HazeSourceNode hazeSourceNode) {
        this.f$1 = hazeSourceNode;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        HazeSourceNode hazeSourceNode = this.f$1;
        switch (b) {
            case 0:
                HazeArea hazeArea = (HazeArea) obj;
                hazeArea.getClass();
                boolean z = true;
                if (hazeSourceNode != null && hazeArea.zIndex$delegate.getFloatValue() >= CropImageView.DEFAULT_ASPECT_RATIO) {
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                ((Long) obj).getClass();
                Iterator it = hazeSourceNode.area.preDrawListeners.iterator();
                while (true) {
                    StateSetIterator stateSetIterator = (StateSetIterator) it;
                    if (!stateSetIterator.hasNext()) {
                        return Unit.INSTANCE;
                    }
                    HitTestResultKt.invalidateDraw(((HazeEffectNode$areaPreDrawListener$2$1) stateSetIterator.next()).$tmp0);
                }
                break;
        }
    }

    public /* synthetic */ HazeEffectNode$$ExternalSyntheticLambda3(HazeSourceNode hazeSourceNode) {
        this.f$1 = hazeSourceNode;
    }
}
