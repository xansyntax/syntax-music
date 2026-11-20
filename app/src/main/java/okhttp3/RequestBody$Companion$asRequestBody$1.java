package okhttp3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import kotlin.text.CharsKt;
import okio.BufferedSink;
import okio.InputStreamSource;
import okio.RealBufferedSink;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class RequestBody$Companion$asRequestBody$1 extends RequestBody {
    public final /* synthetic */ MediaType $contentType;
    public final /* synthetic */ File $this_asRequestBody;

    public RequestBody$Companion$asRequestBody$1(MediaType mediaType, File file) {
        this.$contentType = mediaType;
        this.$this_asRequestBody = file;
    }

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        return this.$this_asRequestBody.length();
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return this.$contentType;
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink bufferedSink) throws IOException {
        File file = this.$this_asRequestBody;
        file.getClass();
        InputStreamSource inputStreamSource = new InputStreamSource(new FileInputStream(file), Timeout.NONE);
        try {
            ((RealBufferedSink) bufferedSink).writeAll(inputStreamSource);
            inputStreamSource.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CharsKt.closeFinally(inputStreamSource, th);
                throw th2;
            }
        }
    }
}
