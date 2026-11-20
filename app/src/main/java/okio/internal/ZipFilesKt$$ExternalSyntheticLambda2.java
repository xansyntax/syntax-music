package okio.internal;

import kotlin.jvm.functions.Function1;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ZipFilesKt$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ZipFilesKt$$ExternalSyntheticLambda2(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ZipEntry zipEntry = (ZipEntry) obj;
        switch (this.$r8$classId) {
            case 0:
                zipEntry.getClass();
                return Boolean.TRUE;
            default:
                zipEntry.getClass();
                Path path = ResourceFileSystem.ROOT;
                return Boolean.valueOf(_ZlibJvmKt.keepPath(zipEntry.canonicalPath));
        }
    }
}
