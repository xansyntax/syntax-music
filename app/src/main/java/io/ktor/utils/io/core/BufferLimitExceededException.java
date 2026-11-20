package io.ktor.utils.io.core;

import io.ktor.http.ContentType;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/utils/io/core/BufferLimitExceededException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", ContentType.Message.TYPE, "<init>", "(Ljava/lang/String;)V", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BufferLimitExceededException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferLimitExceededException(String str) {
        super(str);
        str.getClass();
    }
}
