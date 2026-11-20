package io.ktor.utils.io.core;

import io.ktor.http.auth.HttpAuthHeader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.text.Charsets;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\n\u001a\u00020\t*\u00060\u0001j\u0002`\u0002H\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlinx/io/Source;", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "", "max", "", "readText", "(Lkotlinx/io/Source;Ljava/nio/charset/Charset;I)Ljava/lang/String;", "", "supportsReadTextExactCharacters", "(Ljava/nio/charset/Charset;)Z", "ktor-io"}, k = 5, mv = {2, 3, 0}, xi = 48, xs = "io/ktor/utils/io/core/StringsKt")
final /* synthetic */ class StringsKt__Strings_jvmKt {
    public static final String readText(Source source, Charset charset, int i) {
        source.getClass();
        charset.getClass();
        if (i == Integer.MAX_VALUE) {
            for (long j = 1; source.request(j); j *= 2) {
            }
            return Utf8Kt.readStringImpl(source.getBuffer(), source.getBuffer().sizeMut, charset);
        }
        long j2 = i;
        source.request(j2);
        long jMin = Math.min(source.getBuffer().sizeMut, j2);
        source.require(jMin);
        return Utf8Kt.readStringImpl(source.getBuffer(), jMin, charset);
    }

    public static /* synthetic */ String readText$default(Source source, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return StringsKt.readText(source, charset, i);
    }

    public static final boolean supportsReadTextExactCharacters(Charset charset) {
        charset.getClass();
        return charset.newEncoder().maxBytesPerChar() == 1.0f && charset.newDecoder().maxCharsPerByte() == 1.0f;
    }
}
