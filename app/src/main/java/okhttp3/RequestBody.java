package okhttp3;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.BlackholeSink;
import okio.BufferedSink;
import okio.ByteString;
import okio.FileSystem;
import okio.HashingSink;
import okio.Path;
import okio.RealBufferedSink;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class RequestBody {
    public static final Companion Companion = new Companion();
    public static final RequestBody EMPTY;

    static {
        ByteString byteString = ByteString.EMPTY;
        byteString.getClass();
        EMPTY = new RequestBody$Companion$toRequestBody$1(null, byteString);
    }

    public static final RequestBody create(final Path path, final FileSystem fileSystem, final MediaType mediaType) {
        Companion.getClass();
        path.getClass();
        fileSystem.getClass();
        return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$2
            @Override // okhttp3.RequestBody
            public final long contentLength() {
                Long l = (Long) fileSystem.metadata(path).size;
                if (l != null) {
                    return l.longValue();
                }
                return -1L;
            }

            @Override // okhttp3.RequestBody
            public final MediaType contentType() {
                return mediaType;
            }

            @Override // okhttp3.RequestBody
            public final void writeTo(BufferedSink bufferedSink) throws IOException {
                Source source = fileSystem.source(path);
                try {
                    ((RealBufferedSink) bufferedSink).writeAll(source);
                    source.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CharsKt.closeFinally(source, th);
                        throw th2;
                    }
                }
            }
        };
    }

    public long contentLength() {
        return -1L;
    }

    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return this instanceof RequestBody$Companion$toRequestBody$2;
    }

    public final ByteString sha256() {
        HashingSink hashingSink = new HashingSink(new BlackholeSink());
        RealBufferedSink realBufferedSink = new RealBufferedSink(hashingSink);
        try {
            writeTo(realBufferedSink);
            realBufferedSink.close();
            byte[] bArrDigest = hashingSink.messageDigest.digest();
            bArrDigest.getClass();
            return new ByteString(bArrDigest);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CharsKt.closeFinally(realBufferedSink, th);
                throw th2;
            }
        }
    }

    public abstract void writeTo(BufferedSink bufferedSink);

    public static final RequestBody create(String str, MediaType mediaType) {
        Companion.getClass();
        return Companion.create(str, mediaType);
    }

    @Deprecated
    public static final RequestBody create(MediaType mediaType, File file) {
        Companion.getClass();
        file.getClass();
        return new RequestBody$Companion$asRequestBody$1(mediaType, file);
    }

    @Deprecated
    public static final RequestBody create(MediaType mediaType, String str) {
        Companion.getClass();
        str.getClass();
        return Companion.create(str, mediaType);
    }

    @Deprecated
    public static final RequestBody create(MediaType mediaType, ByteString byteString) {
        Companion.getClass();
        byteString.getClass();
        return new RequestBody$Companion$toRequestBody$1(mediaType, byteString);
    }

    @Deprecated
    public static final RequestBody create(MediaType mediaType, byte[] bArr) {
        Companion.getClass();
        bArr.getClass();
        return Companion.create(mediaType, bArr, 0, bArr.length);
    }

    @Deprecated
    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i) {
        Companion.getClass();
        bArr.getClass();
        return Companion.create(mediaType, bArr, i, bArr.length);
    }

    public static final RequestBody create(final FileDescriptor fileDescriptor, final MediaType mediaType) {
        Companion.getClass();
        fileDescriptor.getClass();
        return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$2
            @Override // okhttp3.RequestBody
            public final MediaType contentType() {
                return mediaType;
            }

            @Override // okhttp3.RequestBody
            public final void writeTo(BufferedSink bufferedSink) throws IOException {
                FileInputStream fileInputStream = new FileInputStream(fileDescriptor);
                try {
                    ((RealBufferedSink) bufferedSink).bufferField.writeAll(StringsKt__IndentKt.source(fileInputStream));
                    fileInputStream.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CharsKt.closeFinally(fileInputStream, th);
                        throw th2;
                    }
                }
            }
        };
    }

    public static final RequestBody create(byte[] bArr) {
        Companion.getClass();
        bArr.getClass();
        return Companion.create$default(null, bArr, 0, 7);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType) {
        Companion.getClass();
        bArr.getClass();
        return Companion.create$default(mediaType, bArr, 0, 6);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i) {
        Companion.getClass();
        bArr.getClass();
        return Companion.create$default(mediaType, bArr, i, 4);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i, int i2) {
        Companion.getClass();
        return Companion.create(mediaType, bArr, i, i2);
    }

    public static final RequestBody create(ByteString byteString, MediaType mediaType) {
        Companion.getClass();
        byteString.getClass();
        return new RequestBody$Companion$toRequestBody$1(mediaType, byteString);
    }

    public static final RequestBody create(File file, MediaType mediaType) {
        Companion.getClass();
        file.getClass();
        return new RequestBody$Companion$asRequestBody$1(mediaType, file);
    }

    @Deprecated
    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i, int i2) {
        Companion.getClass();
        bArr.getClass();
        return Companion.create(mediaType, bArr, i, i2);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion {
        public static RequestBody$Companion$toRequestBody$3 create(String str, MediaType mediaType) {
            str.getClass();
            Charset charset = Charsets.UTF_8;
            if (mediaType != null) {
                Charset charsetCharset$default = MediaType.charset$default(mediaType);
                if (charsetCharset$default == null) {
                    try {
                        mediaType = CollectionsKt__IterablesKt.get(mediaType + "; charset=utf-8");
                    } catch (IllegalArgumentException unused) {
                        mediaType = null;
                    }
                } else {
                    charset = charsetCharset$default;
                }
            }
            byte[] bytes = str.getBytes(charset);
            bytes.getClass();
            return create(mediaType, bytes, 0, bytes.length);
        }

        public static /* synthetic */ RequestBody$Companion$toRequestBody$3 create$default(MediaType mediaType, byte[] bArr, int i, int i2) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return create(mediaType, bArr, i, bArr.length);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [okhttp3.RequestBody$Companion$toRequestBody$3] */
        public static RequestBody$Companion$toRequestBody$3 create(final MediaType mediaType, final byte[] bArr, final int i, final int i2) {
            bArr.getClass();
            _UtilCommonKt.checkOffsetAndCount(bArr.length, i, i2);
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$3
                @Override // okhttp3.RequestBody
                public final long contentLength() {
                    return i2;
                }

                @Override // okhttp3.RequestBody
                public final MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public final void writeTo(BufferedSink bufferedSink) {
                    RealBufferedSink realBufferedSink = (RealBufferedSink) bufferedSink;
                    byte[] bArr2 = bArr;
                    bArr2.getClass();
                    if (realBufferedSink.closed) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("closed");
                    } else {
                        realBufferedSink.bufferField.write(bArr2, i, i2);
                        realBufferedSink.emitCompleteSegments();
                    }
                }
            };
        }
    }
}
