package coil3.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import coil3.Image;
import coil3.UriKt;
import coil3.transition.TransitionTarget;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class GenericViewTarget implements TransitionTarget, DefaultLifecycleObserver, Target {
    private boolean isStarted;

    @Override // coil3.transition.TransitionTarget
    public abstract Drawable getDrawable();

    @Override // coil3.transition.TransitionTarget
    public abstract View getView();

    @Override // coil3.target.Target
    public void onError(Image image) {
        updateImage(image);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner lifecycleOwner) {
        this.isStarted = true;
        updateAnimation();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner lifecycleOwner) {
        this.isStarted = false;
        updateAnimation();
    }

    @Override // coil3.target.Target
    public void onSuccess(Image image) {
        updateImage(image);
    }

    public abstract void setDrawable(Drawable drawable);

    public final void updateAnimation() {
        Object drawable = getDrawable();
        Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
        if (animatable == null) {
            return;
        }
        if (this.isStarted) {
            animatable.start();
        } else {
            animatable.stop();
        }
    }

    public final void updateImage(Image image) {
        Drawable drawableAsDrawable = image != null ? UriKt.asDrawable(image, getView().getResources()) : null;
        Object drawable = getDrawable();
        Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
        if (animatable != null) {
            animatable.stop();
        }
        setDrawable(drawableAsDrawable);
        updateAnimation();
    }

    @Override // coil3.target.Target
    public void onStart(Image image) {
        updateImage(image);
    }
}
