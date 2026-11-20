package com.metrolist.innertube;

import io.ktor.http.CodecsKt$$ExternalSyntheticLambda0;
import j$.io.DesugarInputStream;
import j$.io.InputStreamRetargetInterface;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class UploadProgressInputStream extends FilterInputStream implements InputStreamRetargetInterface {
    public long bytesRead;
    public final long contentLength;
    public final CodecsKt$$ExternalSyntheticLambda0 onProgress;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadProgressInputStream(InputStream inputStream, long j, CodecsKt$$ExternalSyntheticLambda0 codecsKt$$ExternalSyntheticLambda0) {
        super(inputStream);
        inputStream.getClass();
        this.contentLength = j;
        this.onProgress = codecsKt$$ExternalSyntheticLambda0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        bArr.getClass();
        int i3 = super.read(bArr, i, i2);
        if (i3 > 0) {
            reportBytesRead(i3);
        }
        return i3;
    }

    public final void reportBytesRead(int i) {
        long j = this.bytesRead + ((long) i);
        this.bytesRead = j;
        float f = j / this.contentLength;
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.onProgress.invoke(Float.valueOf(f));
    }

    @Override // java.io.InputStream, j$.io.InputStreamRetargetInterface
    public /* synthetic */ long transferTo(OutputStream outputStream) {
        return DesugarInputStream.transferTo(this, outputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i = super.read();
        if (i >= 0) {
            reportBytesRead(1);
        }
        return i;
    }
}
