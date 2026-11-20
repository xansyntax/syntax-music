package io.ktor.util.cio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.ReadingKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\t\u001a\u00020\b*\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ljava/io/InputStream;", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "pool", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/Job;", "parent", "Lio/ktor/utils/io/ByteReadChannel;", "toByteReadChannel", "(Ljava/io/InputStream;Lio/ktor/utils/io/pool/ObjectPool;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/Job;)Lio/ktor/utils/io/ByteReadChannel;", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class InputStreamAdaptersKt {
    @Deprecated
    public static final ByteReadChannel toByteReadChannel(InputStream inputStream, ObjectPool<ByteBuffer> objectPool, CoroutineContext coroutineContext, Job job) {
        inputStream.getClass();
        objectPool.getClass();
        coroutineContext.getClass();
        job.getClass();
        return ReadingKt.toByteReadChannel(inputStream, coroutineContext.plus(job), objectPool);
    }

    public static ByteReadChannel toByteReadChannel$default(InputStream inputStream, ObjectPool objectPool, CoroutineContext coroutineContext, Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            objectPool = ByteBufferPoolKt.getKtorDefaultPool();
        }
        if ((i & 2) != 0) {
            coroutineContext = Dispatchers.Unconfined;
        }
        if ((i & 4) != 0) {
            job = AwaitKt.Job$default();
        }
        return toByteReadChannel(inputStream, objectPool, coroutineContext, job);
    }
}
