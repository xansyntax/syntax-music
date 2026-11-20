package kotlinx.io;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SinksKt {
    public static final byte[] HEX_DIGIT_BYTES;

    static {
        byte[] bArr = new byte[16];
        int i = 0;
        while (i < 16) {
            bArr[i] = (byte) ((i < 10 ? 48 : 87) + i);
            i++;
        }
        HEX_DIGIT_BYTES = bArr;
    }
}
