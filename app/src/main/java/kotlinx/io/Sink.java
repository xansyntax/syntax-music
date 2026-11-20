package kotlinx.io;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public interface Sink extends RawSink {
    Buffer getBuffer();

    void hintEmit();

    long transferFrom(RawSource rawSource);

    void write(RawSource rawSource, long j);

    void write(byte[] bArr, int i, int i2);

    void writeByte(byte b);

    void writeInt(int i);

    void writeLong(long j);

    void writeShort(short s);
}
