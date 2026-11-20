package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationState;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ItemFoundInScroll extends CancellationException {
    public final int itemOffset;
    public final AnimationState previousAnimation;

    public ItemFoundInScroll(int i, AnimationState animationState) {
        this.itemOffset = i;
        this.previousAnimation = animationState;
    }
}
