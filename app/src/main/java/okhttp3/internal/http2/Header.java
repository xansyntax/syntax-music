package okhttp3.internal.http2;

import io.ktor.sse.ServerSentEventKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Header {
    public static final ByteString PSEUDO_PREFIX;
    public static final ByteString RESPONSE_STATUS;
    public static final ByteString TARGET_AUTHORITY;
    public static final ByteString TARGET_METHOD;
    public static final ByteString TARGET_PATH;
    public static final ByteString TARGET_SCHEME;
    public final int hpackSize;
    public final ByteString name;
    public final ByteString value;

    static {
        ByteString byteString = ByteString.EMPTY;
        PSEUDO_PREFIX = Path.Companion.encodeUtf8(ServerSentEventKt.COLON);
        RESPONSE_STATUS = Path.Companion.encodeUtf8(":status");
        TARGET_METHOD = Path.Companion.encodeUtf8(":method");
        TARGET_PATH = Path.Companion.encodeUtf8(":path");
        TARGET_SCHEME = Path.Companion.encodeUtf8(":scheme");
        TARGET_AUTHORITY = Path.Companion.encodeUtf8(":authority");
    }

    public Header(ByteString byteString, ByteString byteString2) {
        byteString.getClass();
        byteString2.getClass();
        this.name = byteString;
        this.value = byteString2;
        this.hpackSize = byteString2.getSize$okio() + byteString.getSize$okio() + 32;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return Intrinsics.areEqual(this.name, header.name) && Intrinsics.areEqual(this.value, header.value);
    }

    public final int hashCode() {
        return this.value.hashCode() + (this.name.hashCode() * 31);
    }

    public final String toString() {
        return this.name.utf8() + ": " + this.value.utf8();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(String str, String str2) {
        this(Path.Companion.encodeUtf8(str), Path.Companion.encodeUtf8(str2));
        ByteString byteString = ByteString.EMPTY;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(String str, ByteString byteString) {
        this(byteString, Path.Companion.encodeUtf8(str));
        byteString.getClass();
        str.getClass();
        ByteString byteString2 = ByteString.EMPTY;
    }
}
