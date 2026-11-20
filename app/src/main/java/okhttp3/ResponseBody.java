package okhttp3;

import java.io.Closeable;
import java.nio.charset.Charset;
import kotlin.ResultKt;
import kotlin.text.Charsets;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ResponseBody implements Closeable {
    public static final ResponseBody$Companion$asResponseBody$1 EMPTY;

    /* JADX WARN: Type inference failed for: r0v3, types: [okhttp3.ResponseBody$Companion$asResponseBody$1] */
    static {
        ByteString byteString = ByteString.EMPTY;
        byteString.getClass();
        final Buffer buffer = new Buffer();
        buffer.write(byteString);
        final long length = byteString.data.length;
        EMPTY = new ResponseBody() { // from class: okhttp3.ResponseBody$Companion$asResponseBody$1
            @Override // okhttp3.ResponseBody
            public final long contentLength() {
                return length;
            }

            @Override // okhttp3.ResponseBody
            public final BufferedSource source() {
                return buffer;
            }
        };
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        _UtilCommonKt.closeQuietly(source());
    }

    public abstract long contentLength();

    public MediaType contentType() {
        return null;
    }

    public abstract BufferedSource source();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v8 */
    public final String string() {
        Charset charsetCharset$default;
        BufferedSource bufferedSourceSource = source();
        String th = null;
        try {
            MediaType mediaTypeContentType = contentType();
            if (mediaTypeContentType == null || (charsetCharset$default = MediaType.charset$default(mediaTypeContentType)) == null) {
                charsetCharset$default = Charsets.UTF_8;
            }
            String string = bufferedSourceSource.readString(_UtilJvmKt.readBomAsCharset(bufferedSourceSource, charsetCharset$default));
            try {
                bufferedSourceSource.close();
            } catch (Throwable th2) {
                th = th2;
            }
            String str = th;
            th = string;
            th = str;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedSourceSource != null) {
                try {
                    bufferedSourceSource.close();
                } catch (Throwable th4) {
                    ResultKt.addSuppressed(th, th4);
                }
            }
        }
        if (th == 0) {
            return th;
        }
        throw th;
    }
}
