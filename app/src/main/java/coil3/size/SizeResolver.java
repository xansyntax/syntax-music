package coil3.size;

import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface SizeResolver {
    public static final RealSizeResolver ORIGINAL = new RealSizeResolver(Size.ORIGINAL);

    Object size(Continuation continuation);
}
