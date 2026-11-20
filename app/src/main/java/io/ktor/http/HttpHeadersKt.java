package io.ktor.http;

import kotlin.Metadata;
import kotlin.ranges.CharRange;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0001\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/ktor/http/AsciiBitSet;", "ILLEGAL_HEADER_NAME_CHARS", "Lio/ktor/http/AsciiBitSet;", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpHeadersKt {
    private static final AsciiBitSet ILLEGAL_HEADER_NAME_CHARS;

    static {
        AsciiBitSet.Companion companion = AsciiBitSet.INSTANCE;
        ILLEGAL_HEADER_NAME_CHARS = companion.of(new CharRange((char) 0, ' ')).plus(companion.of("\"(),/:;<=>?@[\\]{}"));
    }
}
