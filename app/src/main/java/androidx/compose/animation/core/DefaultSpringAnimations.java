package androidx.compose.animation.core;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultSpringAnimations implements Animations {
    public static final DefaultSpringAnimations INSTANCE = new DefaultSpringAnimations();
    public static final FloatSpringSpec anim = new FloatSpringSpec(1.0f, 1500.0f);

    @Override // androidx.compose.animation.core.Animations
    public final FloatAnimationSpec get(int i) {
        return anim;
    }
}
