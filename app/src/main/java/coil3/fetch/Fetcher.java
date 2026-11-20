package coil3.fetch;

import coil3.RealImageLoader;
import coil3.intercept.EngineInterceptor;
import coil3.request.Options;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface Fetcher {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Factory {
        Fetcher create(Object obj, Options options, RealImageLoader realImageLoader);
    }

    Object fetch(EngineInterceptor.C00531 c00531);
}
