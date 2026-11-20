package coil3;

import android.content.Context;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SingletonImageLoaderKt$$ExternalSyntheticLambda0 implements SingletonImageLoader.Factory {
    @Override // coil3.SingletonImageLoader.Factory
    public final RealImageLoader newImageLoader(Context context) {
        ImageLoader$Builder imageLoader$Builder = new ImageLoader$Builder(context);
        ((Extras.Builder) imageLoader$Builder.extras).set(SingletonImageLoaderKt.DefaultSingletonImageLoaderKey, Unit.INSTANCE);
        return imageLoader$Builder.build();
    }
}
