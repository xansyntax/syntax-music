package coil3.request;

import android.graphics.Bitmap;
import coil3.Extras;
import coil3.UriKt;
import coil3.transition.CrossfadeTransition;
import coil3.transition.Transition;
import coil3.util.Utils_androidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ImageRequests_androidKt {
    public static final Extras.Key allowHardwareKey;
    public static final Extras.Key allowPartialImageKey;
    public static final Extras.Key allowRgb565Key;
    public static final Extras.Key lifecycleKey;
    public static final Extras.Key premultipliedAlphaKey;
    public static final Extras.Key transitionFactoryKey = new Extras.Key(Transition.Factory.NONE);
    public static final Extras.Key bitmapConfigKey = new Extras.Key(Utils_androidKt.DEFAULT_BITMAP_CONFIG);
    public static final Extras.Key colorSpaceKey = new Extras.Key(null);

    static {
        Boolean bool = Boolean.TRUE;
        premultipliedAlphaKey = new Extras.Key(bool);
        lifecycleKey = new Extras.Key(null);
        allowPartialImageKey = new Extras.Key(bool);
        allowHardwareKey = new Extras.Key(bool);
        allowRgb565Key = new Extras.Key(Boolean.FALSE);
    }

    public static final void allowHardware(ImageRequest.Builder builder) {
        builder.getExtras().set(allowHardwareKey, Boolean.FALSE);
    }

    public static final void crossfade(ImageRequest.Builder builder, int i) {
        builder.getExtras().set(transitionFactoryKey, i > 0 ? new CrossfadeTransition.Factory(i) : Transition.Factory.NONE);
    }

    public static final Bitmap.Config getBitmapConfig(Options options) {
        return (Bitmap.Config) UriKt.getExtra(options, bitmapConfigKey);
    }
}
