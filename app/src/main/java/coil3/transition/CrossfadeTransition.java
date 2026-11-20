package coil3.transition;

import android.graphics.drawable.Drawable;
import coil3.Image;
import coil3.UriKt;
import coil3.decode.DataSource;
import coil3.request.ErrorResult;
import coil3.request.ImageResult;
import coil3.request.SuccessResult;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CrossfadeTransition implements Transition {
    public final int durationMillis;
    public final ImageResult result;
    public final TransitionTarget target;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Factory implements Transition.Factory {
        public final int durationMillis;

        public Factory(int i) {
            this.durationMillis = i;
            if (i > 0) {
                return;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("durationMillis must be > 0.");
            throw null;
        }

        @Override // coil3.transition.Transition.Factory
        public final Transition create(TransitionTarget transitionTarget, ImageResult imageResult) {
            if (imageResult instanceof SuccessResult) {
                return ((SuccessResult) imageResult).dataSource == DataSource.MEMORY_CACHE ? new NoneTransition(transitionTarget, imageResult) : new CrossfadeTransition(transitionTarget, imageResult, this.durationMillis);
            }
            return new NoneTransition(transitionTarget, imageResult);
        }
    }

    public CrossfadeTransition(TransitionTarget transitionTarget, ImageResult imageResult, int i) {
        this.target = transitionTarget;
        this.result = imageResult;
        this.durationMillis = i;
        if (i > 0) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("durationMillis must be > 0.");
        throw null;
    }

    @Override // coil3.transition.Transition
    public final void transition() {
        TransitionTarget transitionTarget = this.target;
        Drawable drawable = transitionTarget.getDrawable();
        ImageResult imageResult = this.result;
        Image image = imageResult.getImage();
        boolean z = imageResult instanceof SuccessResult;
        CrossfadeDrawable crossfadeDrawable = new CrossfadeDrawable(drawable, image != null ? UriKt.asDrawable(image, transitionTarget.getView().getResources()) : null, imageResult.getRequest().scale, this.durationMillis, (z && ((SuccessResult) imageResult).isPlaceholderCached) ? false : true);
        if (z) {
            transitionTarget.onSuccess(UriKt.asImage(crossfadeDrawable));
        } else if (imageResult instanceof ErrorResult) {
            transitionTarget.onError(UriKt.asImage(crossfadeDrawable));
        } else {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
        }
    }
}
