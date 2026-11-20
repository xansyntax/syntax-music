package coil3.network.internal;

import coil3.network.CacheStrategy;
import java.util.Set;
import kotlin.collections.ArraysKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultCacheStrategy implements CacheStrategy {
    public static final Set CACHEABLE_STATUS_CODES = ArraysKt.toSet(new Integer[]{300, 301, 404, 405, 410, 414, 501});
}
