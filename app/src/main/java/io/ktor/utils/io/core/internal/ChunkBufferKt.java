package io.ktor.utils.io.core.internal;

import io.ktor.http.ContentType;
import io.ktor.utils.io.DeprecationKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlinx.io.Buffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003*\u001a\b\u0007\u0010\b\"\u00020\u00002\u00020\u0000B\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¨\u0006\t"}, d2 = {"Lkotlinx/io/Buffer;", "", "getWriteRemaining", "(Lkotlinx/io/Buffer;)I", "writeRemaining", "Lkotlin/Deprecated;", ContentType.Message.TYPE, DeprecationKt.IO_DEPRECATION_MESSAGE, "ChunkBuffer", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ChunkBufferKt {
    public static final int getWriteRemaining(Buffer buffer) {
        buffer.getClass();
        return Integer.MAX_VALUE;
    }

    @Deprecated
    public static /* synthetic */ void ChunkBuffer$annotations() {
    }
}
