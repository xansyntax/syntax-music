package androidx.media3.datasource;

import com.google.common.base.Predicate;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DefaultHttpDataSource$NullFilteringHeadersMap$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ byte $r8$classId;

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return ((Map.Entry) obj).getKey() != null;
            default:
                return ((String) obj) != null;
        }
    }
}
