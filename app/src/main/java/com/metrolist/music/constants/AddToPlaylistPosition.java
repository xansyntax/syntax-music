package com.metrolist.music.constants;

import kotlin.enums.EnumEntriesList;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.metrolist.music.constants.AddToPlaylistPosition[], still in use, count: 1, list:
  (r0v1 com.metrolist.music.constants.AddToPlaylistPosition[]) from 0x001a: CONSTRUCTOR (r0v1 com.metrolist.music.constants.AddToPlaylistPosition[]) A[MD:(java.lang.Enum[]):void (m), WRAPPED] (LINE:27) call: kotlin.enums.EnumEntriesList.<init>(java.lang.Enum[]):void type: CONSTRUCTOR
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AddToPlaylistPosition {
    BEGINNING(true),
    /* JADX INFO: Fake field, exist only in values array */
    END(false);

    public static final /* synthetic */ EnumEntriesList $ENTRIES;
    public final boolean prepend;

    static {
        $ENTRIES = new EnumEntriesList(addToPlaylistPositionArr);
    }

    public AddToPlaylistPosition(boolean z) {
        super(str, i);
        this.prepend = z;
    }

    public static AddToPlaylistPosition valueOf(String str) {
        return (AddToPlaylistPosition) Enum.valueOf(AddToPlaylistPosition.class, str);
    }

    public static AddToPlaylistPosition[] values() {
        return (AddToPlaylistPosition[]) $VALUES.clone();
    }
}
