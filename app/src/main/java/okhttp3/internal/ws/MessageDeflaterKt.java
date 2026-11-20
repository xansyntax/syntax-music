package okhttp3.internal.ws;

import okio.ByteString;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MessageDeflaterKt {
    public static final ByteString EMPTY_DEFLATE_BLOCK;

    static {
        ByteString byteString = ByteString.EMPTY;
        EMPTY_DEFLATE_BLOCK = Path.Companion.decodeHex("000000ffff");
    }
}
