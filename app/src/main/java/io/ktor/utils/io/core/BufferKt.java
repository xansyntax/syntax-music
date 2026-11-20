package io.ktor.utils.io.core;

import io.ktor.http.ContentType;
import io.ktor.utils.io.DeprecationKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlinx.io.Buffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003*\u001a\b\u0007\u0010\u0007\"\u00020\u00002\u00020\u0000B\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¨\u0006\b"}, d2 = {"Lkotlinx/io/Buffer;", "", "canRead", "(Lkotlinx/io/Buffer;)Z", "Lkotlin/Deprecated;", ContentType.Message.TYPE, DeprecationKt.IO_DEPRECATION_MESSAGE, "Buffer", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BufferKt {
    public static final boolean canRead(Buffer buffer) {
        buffer.getClass();
        return !buffer.exhausted();
    }

    @Deprecated
    public static /* synthetic */ void Buffer$annotations() {
    }
}
