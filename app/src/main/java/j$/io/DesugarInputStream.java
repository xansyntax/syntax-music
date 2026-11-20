package j$.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes3.dex */
public final class DesugarInputStream {
    public static long transferTo(InputStream inputStream, OutputStream outputStream) throws IOException {
        Objects.requireNonNull(outputStream, "out");
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr, 0, 8192);
            if (i < 0) {
                return j;
            }
            outputStream.write(bArr, 0, i);
            j += (long) i;
        }
    }
}
