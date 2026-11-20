package okio.internal;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class EocdRecord {
    public long centralDirectoryOffset;
    public long entryCount;

    public EocdRecord() {
        this.entryCount = -9223372036854775807L;
        this.centralDirectoryOffset = -9223372036854775807L;
    }

    public EocdRecord(int i, long j, long j2) {
        this.entryCount = j;
        this.centralDirectoryOffset = j2;
    }

    public EocdRecord(long j, long j2) {
        this.entryCount = j;
        this.centralDirectoryOffset = j2;
    }
}
