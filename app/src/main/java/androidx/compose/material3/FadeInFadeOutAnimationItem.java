package androidx.compose.material3;

import androidx.compose.runtime.internal.ComposableLambdaImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FadeInFadeOutAnimationItem {
    public final Object key;
    public final ComposableLambdaImpl transition;

    public FadeInFadeOutAnimationItem(SnackbarHostState.SnackbarDataImpl snackbarDataImpl, ComposableLambdaImpl composableLambdaImpl) {
        this.key = snackbarDataImpl;
        this.transition = composableLambdaImpl;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FadeInFadeOutAnimationItem) {
            FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem = (FadeInFadeOutAnimationItem) obj;
            return Intrinsics.areEqual(this.key, fadeInFadeOutAnimationItem.key) && this.transition == fadeInFadeOutAnimationItem.transition;
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.key;
        return this.transition.hashCode() + ((obj == null ? 0 : obj.hashCode()) * 31);
    }

    public final String toString() {
        return "FadeInFadeOutAnimationItem(key=" + this.key + ", transition=" + this.transition + ")";
    }
}
