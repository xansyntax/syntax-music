package coil3.map;

import android.content.Context;
import android.content.res.Resources;
import coil3.Uri;
import coil3.UriKt;
import coil3.request.Options;
import java.io.File;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FileMapper {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ FileMapper(byte b) {
        this.$r8$classId = b;
    }

    public final Uri map(Object obj, Options options) {
        switch (this.$r8$classId) {
            case 0:
                return UriKt.Uri$default(((File) obj).getPath());
            case 1:
                return UriKt.toUri$default(((android.net.Uri) obj).toString());
            case 2:
                return UriKt.Uri$default(((Path) obj).bytes.utf8());
            case 3:
                int iIntValue = ((Number) obj).intValue();
                Context context = options.context;
                try {
                    if (context.getResources().getResourceEntryName(iIntValue) != null) {
                        return UriKt.toUri$default("android.resource://" + context.getPackageName() + "/" + iIntValue);
                    }
                } catch (Resources.NotFoundException unused) {
                }
                return null;
            default:
                return UriKt.toUri$default((String) obj);
        }
    }
}
