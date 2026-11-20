package io.ktor.network.selector;

import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lio/ktor/network/selector/SelectInterest;", "", "", "flag", "<init>", "(Ljava/lang/String;II)V", "I", "getFlag", "()I", "Companion", "READ", "WRITE", "ACCEPT", "CONNECT", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum SelectInterest {
    READ(1),
    WRITE(4),
    ACCEPT(16),
    CONNECT(8);

    private static final int[] flags;
    private static final int size;
    private final int flag;
    private static final /* synthetic */ EnumEntries $ENTRIES = CollectionsKt__IterablesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SelectInterest[] AllInterests = (SelectInterest[]) getEntries().toArray(new SelectInterest[0]);

    static {
        EnumEntries entries = getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(entries, 10));
        Iterator<E> it = entries.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((SelectInterest) it.next()).flag));
        }
        flags = CollectionsKt.toIntArray(arrayList);
        size = ((AbstractCollection) getEntries()).getSize();
    }

    SelectInterest(int i) {
        this.flag = i;
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    public final int getFlag() {
        return this.flag;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/network/selector/SelectInterest$Companion;", "", "<init>", "()V", "", "Lio/ktor/network/selector/SelectInterest;", "AllInterests", "[Lio/ktor/network/selector/SelectInterest;", "getAllInterests", "()[Lio/ktor/network/selector/SelectInterest;", "", "flags", "[I", "getFlags", "()[I", "", ContentDisposition.Parameters.Size, "I", "getSize", "()I", "ktor-network"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SelectInterest[] getAllInterests() {
            return SelectInterest.AllInterests;
        }

        public final int[] getFlags() {
            return SelectInterest.flags;
        }

        public final int getSize() {
            return SelectInterest.size;
        }

        private Companion() {
        }
    }
}
