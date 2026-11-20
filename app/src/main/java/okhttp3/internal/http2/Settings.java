package okhttp3.internal.http2;

import io.ktor.network.sockets.DatagramKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Settings {
    public int set;
    public final int[] values = new int[10];

    public final int getInitialWindowSize() {
        return (this.set & 16) != 0 ? this.values[4] : DatagramKt.MAX_DATAGRAM_SIZE;
    }

    public final void set(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.values;
            if (i >= iArr.length) {
                return;
            }
            this.set = (1 << i) | this.set;
            iArr[i] = i2;
        }
    }
}
