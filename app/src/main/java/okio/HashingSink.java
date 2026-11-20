package okio;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class HashingSink extends ForwardingSink {
    public final MessageDigest messageDigest;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(BlackholeSink blackholeSink) throws NoSuchAlgorithmException {
        super(blackholeSink);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.getClass();
        this.messageDigest = messageDigest;
    }

    @Override // okio.ForwardingSink, okio.Sink
    public final void write(Buffer buffer, long j) {
        buffer.getClass();
        HexFormatKt.checkOffsetAndCount(buffer.size, 0L, j);
        Segment segment = buffer.head;
        segment.getClass();
        long j2 = 0;
        while (j2 < j) {
            int iMin = (int) Math.min(j - j2, segment.limit - segment.pos);
            this.messageDigest.update(segment.data, segment.pos, iMin);
            j2 += (long) iMin;
            segment = segment.next;
            segment.getClass();
        }
        this.delegate.write(buffer, j);
    }
}
