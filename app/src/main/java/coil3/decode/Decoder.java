package coil3.decode;

import coil3.fetch.SourceFetchResult;
import coil3.request.Options;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface Decoder {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Factory {
        Decoder create(SourceFetchResult sourceFetchResult, Options options);
    }

    Object decode(ContinuationImpl continuationImpl);
}
