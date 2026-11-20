package kotlinx.serialization;

import androidx.room.concurrent.FileLock;
import com.google.common.base.Splitter;
import kotlin.coroutines.CombinedContext$$ExternalSyntheticLambda0;
import kotlin.time.InstantKt$$ExternalSyntheticLambda0;
import kotlinx.serialization.internal.CachingKt;
import kotlinx.serialization.internal.ClassValueCache;
import kotlinx.serialization.internal.ParametrizedSerializerCache;
import kotlinx.serialization.internal.SerializerCache;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SerializersCacheKt {
    public static final ParametrizedSerializerCache PARAMETRIZED_SERIALIZERS_CACHE;
    public static final ParametrizedSerializerCache PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE;
    public static final SerializerCache SERIALIZERS_CACHE;
    public static final SerializerCache SERIALIZERS_CACHE_NULLABLE;

    static {
        InstantKt$$ExternalSyntheticLambda0 instantKt$$ExternalSyntheticLambda0 = new InstantKt$$ExternalSyntheticLambda0((byte) 26);
        boolean z = CachingKt.useClassValue;
        SERIALIZERS_CACHE = z ? new ClassValueCache(instantKt$$ExternalSyntheticLambda0) : new Splitter(instantKt$$ExternalSyntheticLambda0);
        InstantKt$$ExternalSyntheticLambda0 instantKt$$ExternalSyntheticLambda1 = new InstantKt$$ExternalSyntheticLambda0((byte) 27);
        SERIALIZERS_CACHE_NULLABLE = z ? new ClassValueCache(instantKt$$ExternalSyntheticLambda1) : new Splitter(instantKt$$ExternalSyntheticLambda1);
        CombinedContext$$ExternalSyntheticLambda0 combinedContext$$ExternalSyntheticLambda0 = new CombinedContext$$ExternalSyntheticLambda0((byte) 17);
        PARAMETRIZED_SERIALIZERS_CACHE = z ? new ClassValueCache(combinedContext$$ExternalSyntheticLambda0) : new FileLock(combinedContext$$ExternalSyntheticLambda0);
        CombinedContext$$ExternalSyntheticLambda0 combinedContext$$ExternalSyntheticLambda1 = new CombinedContext$$ExternalSyntheticLambda0((byte) 18);
        PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE = z ? new ClassValueCache(combinedContext$$ExternalSyntheticLambda1) : new FileLock(combinedContext$$ExternalSyntheticLambda1);
    }
}
