package androidx.compose.ui.text;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnnotatedString$special$$inlined$sortedBy$1 implements Comparator {
    public final /* synthetic */ byte $r8$classId;

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return Integer.valueOf(((AnnotatedString.Range) obj).start).compareTo(Integer.valueOf(((AnnotatedString.Range) obj2).start));
    }
}
