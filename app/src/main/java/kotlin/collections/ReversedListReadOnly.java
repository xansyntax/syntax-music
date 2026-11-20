package kotlin.collections;

import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.text.MatcherMatchResult;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ReversedListReadOnly extends AbstractList {
    public final /* synthetic */ byte $r8$classId;
    public final Object delegate;

    public ReversedListReadOnly(List list) {
        this.$r8$classId = (byte) 0;
        list.getClass();
        this.delegate = list;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ boolean contains(Object obj) {
        switch (this.$r8$classId) {
            case 1:
                if (obj instanceof MediaItem) {
                    return super.contains((MediaItem) obj);
                }
                return false;
            case 2:
                if (obj instanceof String) {
                    return super.contains((String) obj);
                }
                return false;
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.List
    public final Object get(int i) {
        byte b = this.$r8$classId;
        Object obj = this.delegate;
        switch (b) {
            case 0:
                return ((List) obj).get(CollectionsKt.reverseElementIndex$CollectionsKt__ReversedViewsKt(i, this));
            case 1:
                MediaItem mediaItemAt = ((Player) obj).getMediaItemAt(i);
                mediaItemAt.getClass();
                return mediaItemAt;
            default:
                String strGroup = ((MatcherMatchResult) obj).matcher.group(i);
                return strGroup == null ? "" : strGroup;
        }
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        byte b = this.$r8$classId;
        Object obj = this.delegate;
        switch (b) {
            case 0:
                return ((List) obj).size();
            case 1:
                return ((Player) obj).getMediaItemCount();
            default:
                return ((MatcherMatchResult) obj).matcher.groupCount() + 1;
        }
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* bridge */ int indexOf(Object obj) {
        switch (this.$r8$classId) {
            case 1:
                if (obj instanceof MediaItem) {
                    return super.indexOf((MediaItem) obj);
                }
                return -1;
            case 2:
                if (obj instanceof String) {
                    return super.indexOf((String) obj);
                }
                return -1;
            default:
                return super.indexOf(obj);
        }
    }

    @Override // kotlin.collections.AbstractList, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                return new ReversedList.AnonymousClass1(this, 0);
            default:
                return super.iterator();
        }
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* bridge */ int lastIndexOf(Object obj) {
        switch (this.$r8$classId) {
            case 1:
                if (obj instanceof MediaItem) {
                    return super.lastIndexOf((MediaItem) obj);
                }
                return -1;
            case 2:
                if (obj instanceof String) {
                    return super.lastIndexOf((String) obj);
                }
                return -1;
            default:
                return super.lastIndexOf(obj);
        }
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator listIterator() {
        switch (this.$r8$classId) {
            case 0:
                return new ReversedList.AnonymousClass1(this, 0);
            default:
                return super.listIterator();
        }
    }

    public /* synthetic */ ReversedListReadOnly(byte b, Object obj) {
        this.$r8$classId = b;
        this.delegate = obj;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator listIterator(int i) {
        switch (this.$r8$classId) {
            case 0:
                return new ReversedList.AnonymousClass1(this, i);
            default:
                return super.listIterator(i);
        }
    }
}
