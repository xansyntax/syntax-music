package kotlinx.io;

import j$.io.DesugarInputStream;
import j$.io.InputStreamRetargetInterface;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.functions.Function0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class SourcesJvmKt$asInputStream$1 extends InputStream implements InputStreamRetargetInterface {
    public final /* synthetic */ Function0 $isClosed;
    public final /* synthetic */ Source $this_asInputStream;

    public SourcesJvmKt$asInputStream$1(Function0 function0, Source source) {
        this.$isClosed = function0;
        this.$this_asInputStream = source;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        if (!((Boolean) this.$isClosed.invoke()).booleanValue()) {
            return (int) Math.min(this.$this_asInputStream.getBuffer().sizeMut, 2147483647L);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Underlying source is closed.");
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Exception {
        this.$this_asInputStream.close();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        bArr.getClass();
        if (((Boolean) this.$isClosed.invoke()).booleanValue()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Underlying source is closed.");
            return 0;
        }
        Utf8Kt.checkOffsetAndCount(bArr.length, i, i2);
        return this.$this_asInputStream.readAtMostTo(bArr, i, i2 + i);
    }

    public final String toString() {
        return this.$this_asInputStream + ".asInputStream()";
    }

    @Override // java.io.InputStream, j$.io.InputStreamRetargetInterface
    public /* synthetic */ long transferTo(OutputStream outputStream) {
        return DesugarInputStream.transferTo(this, outputStream);
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (!((Boolean) this.$isClosed.invoke()).booleanValue()) {
            Source source = this.$this_asInputStream;
            if (source.exhausted()) {
                return -1;
            }
            return source.readByte() & 255;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Underlying source is closed.");
        return 0;
    }
}
