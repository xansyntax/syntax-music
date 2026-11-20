package okio;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import java.io.EOFException;
import java.io.IOException;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class LimitSource extends ForwardingSource {
    public final long byteCount;
    public long bytesReceived;
    public final boolean throwIfSourceIsLonger;

    public LimitSource(Source source, long j, boolean z) {
        super(source);
        this.byteCount = j;
        this.throwIfSourceIsLonger = z;
        if (j >= 0) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m(j, "byteCount < 0: "));
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0039 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x003c  */
    /* JADX WARN: Code duplicated, block: B:20:0x004f  */
    /* JADX WARN: Code duplicated, block: B:22:0x0059 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x005a  */
    /* JADX WARN: Code duplicated, block: B:9:0x0025  */
    @Override // okio.ForwardingSource, okio.Source
    public final long read(Buffer buffer, long j) throws IOException {
        long j2;
        long j3;
        buffer.getClass();
        long j4 = this.bytesReceived;
        long j5 = this.byteCount;
        long j6 = j5 - j4;
        if (j6 < 0) {
            StringBuilder sbM = Fragment$5$$ExternalSyntheticOutline0.m(j5, "expected ", " bytes but got ");
            sbM.append(this.bytesReceived);
            throw new IOException(sbM.toString());
        }
        if (this.throwIfSourceIsLonger) {
            j6++;
            if (j <= j6) {
                j6 = j;
            }
            j2 = this.delegate.read(buffer, j6);
            if (j2 == -1) {
                long j7 = this.bytesReceived + j2;
                this.bytesReceived = j7;
                j3 = j7 - j5;
                if (j3 <= 0) {
                    return j2;
                }
                long j8 = buffer.size - j3;
                Buffer buffer2 = new Buffer();
                buffer2.writeAll(buffer);
                buffer.write(buffer2, j8);
                buffer2.clear();
                StringBuilder sbM2 = Fragment$5$$ExternalSyntheticOutline0.m(j5, "expected ", " bytes but got ");
                sbM2.append(this.bytesReceived);
                throw new IOException(sbM2.toString());
            }
            if (j6 != 0) {
                StringBuilder sbM3 = Fragment$5$$ExternalSyntheticOutline0.m(j5, "expected ", " bytes but got ");
                sbM3.append(this.bytesReceived);
                throw new EOFException(sbM3.toString());
            }
        } else if (j6 != 0) {
            if (j <= j6) {
                j6 = j;
            }
            j2 = this.delegate.read(buffer, j6);
            if (j2 == -1) {
                long j9 = this.bytesReceived + j2;
                this.bytesReceived = j9;
                j3 = j9 - j5;
                if (j3 <= 0) {
                    return j2;
                }
                long j10 = buffer.size - j3;
                Buffer buffer3 = new Buffer();
                buffer3.writeAll(buffer);
                buffer.write(buffer3, j10);
                buffer3.clear();
                StringBuilder sbM4 = Fragment$5$$ExternalSyntheticOutline0.m(j5, "expected ", " bytes but got ");
                sbM4.append(this.bytesReceived);
                throw new IOException(sbM4.toString());
            }
            if (j6 != 0) {
                StringBuilder sbM5 = Fragment$5$$ExternalSyntheticOutline0.m(j5, "expected ", " bytes but got ");
                sbM5.append(this.bytesReceived);
                throw new EOFException(sbM5.toString());
            }
        }
        return -1L;
    }
}
