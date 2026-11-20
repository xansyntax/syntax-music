package androidx.compose.animation;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PendingAnimatedContentTransitionScope implements AnimatedContentTransitionScope {
    public final /* synthetic */ AnimatedContentTransitionScope $$delegate_0;
    public final Object overrideInitialState;
    public final Object overrideTargetState;

    public PendingAnimatedContentTransitionScope(AnimatedContentTransitionScope animatedContentTransitionScope, Object obj, Object obj2) {
        this.$$delegate_0 = animatedContentTransitionScope;
        this.overrideInitialState = obj;
        this.overrideTargetState = obj2;
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public final Object getInitialState() {
        return this.overrideInitialState;
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public final Object getTargetState() {
        return this.overrideTargetState;
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public final boolean isTransitioningTo(Object obj, Object obj2) {
        return this.$$delegate_0.isTransitioningTo(obj, obj2);
    }
}
