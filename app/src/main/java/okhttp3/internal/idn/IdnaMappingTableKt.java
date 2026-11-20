package okhttp3.internal.idn;

import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class IdnaMappingTableKt {
    public static final Path.Companion IDNA_MAPPING_TABLE = new Path.Companion(14);

    public static final int read14BitInt(int i, String str) {
        char cCharAt = str.charAt(i);
        return (cCharAt << 7) + str.charAt(i + 1);
    }
}
