package io.ktor.utils.io.core;

import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlinx.io.Sink;
import kotlinx.io.Source;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"io/ktor/utils/io/core/StringsKt__StringsKt", "io/ktor/utils/io/core/StringsKt__Strings_jvmKt"}, k = 4, mv = {2, 3, 0}, xi = 48)
public final class StringsKt {
    @Deprecated
    public static final String String(byte[] bArr, int i, int i2, Charset charset) {
        return StringsKt__StringsKt.String(bArr, i, i2, charset);
    }

    @Deprecated
    public static final byte[] readBytes(Source source) {
        return StringsKt__StringsKt.readBytes(source);
    }

    public static final String readText(Source source, Charset charset, int i) {
        return StringsKt__Strings_jvmKt.readText(source, charset, i);
    }

    @Deprecated
    public static final String readTextExact(Source source, Charset charset, int i) {
        return StringsKt__StringsKt.readTextExact(source, charset, i);
    }

    public static final String readTextExactCharacters(Source source, int i, Charset charset) {
        return StringsKt__StringsKt.readTextExactCharacters(source, i, charset);
    }

    public static final boolean supportsReadTextExactCharacters(Charset charset) {
        return StringsKt__Strings_jvmKt.supportsReadTextExactCharacters(charset);
    }

    public static final byte[] toByteArray(String str, Charset charset) {
        return StringsKt__StringsKt.toByteArray(str, charset);
    }

    public static final void writeText(Sink sink, CharSequence charSequence, int i, int i2, Charset charset) {
        StringsKt__StringsKt.writeText(sink, charSequence, i, i2, charset);
    }

    public static final void writeText(Sink sink, char[] cArr, int i, int i2, Charset charset) {
        StringsKt__StringsKt.writeText(sink, cArr, i, i2, charset);
    }

    @Deprecated
    public static final byte[] readBytes(Source source, int i) {
        return StringsKt__StringsKt.readBytes(source, i);
    }
}
