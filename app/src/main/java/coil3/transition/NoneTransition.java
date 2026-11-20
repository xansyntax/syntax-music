package coil3.transition;

import coil3.request.ErrorResult;
import coil3.request.ImageResult;
import coil3.request.SuccessResult;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NoneTransition implements Transition {
    public final ImageResult result;
    public final TransitionTarget target;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Factory implements Transition.Factory {
        @Override // coil3.transition.Transition.Factory
        public final Transition create(TransitionTarget transitionTarget, ImageResult imageResult) {
            return new NoneTransition(transitionTarget, imageResult);
        }
    }

    public NoneTransition(TransitionTarget transitionTarget, ImageResult imageResult) {
        this.target = transitionTarget;
        this.result = imageResult;
    }

    @Override // coil3.transition.Transition
    public final void transition() {
        ImageResult imageResult = this.result;
        boolean z = imageResult instanceof SuccessResult;
        TransitionTarget transitionTarget = this.target;
        if (z) {
            transitionTarget.onSuccess(((SuccessResult) imageResult).image);
        } else if (imageResult instanceof ErrorResult) {
            transitionTarget.onError(((ErrorResult) imageResult).image);
        } else {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
        }
    }
}
