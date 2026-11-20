package kotlinx.io;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public interface Source extends RawSource {
    boolean exhausted();

    Buffer getBuffer();

    RealSource peek();

    int readAtMostTo(byte[] bArr, int i, int i2);

    byte readByte();

    int readInt();

    long readLong();

    short readShort();

    void readTo(RawSink rawSink, long j);

    boolean request(long j);

    void require(long j);

    void skip(long j);

    long transferTo(RawSink rawSink);
}
