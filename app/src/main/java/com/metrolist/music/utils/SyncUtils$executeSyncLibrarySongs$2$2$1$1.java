package com.metrolist.music.utils;

import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.MusicDatabase;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SyncUtils$executeSyncLibrarySongs$2$2$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ LocalDateTime $now;
    public final /* synthetic */ List $remoteSongs;
    public final /* synthetic */ Set $removed;
    public final /* synthetic */ Set $songIdsWithoutArtists;
    public int I$0;
    public int I$1;
    public /* synthetic */ Object L$0;
    public Object L$2;
    public List L$3;
    public Set L$4;
    public Iterator L$5;
    public SongItem L$7;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncUtils$executeSyncLibrarySongs$2$2$1$1(Set set, List list, LocalDateTime localDateTime, Set set2, Continuation continuation) {
        super(2, continuation);
        this.$removed = set;
        this.$remoteSongs = list;
        this.$now = localDateTime;
        this.$songIdsWithoutArtists = set2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SyncUtils$executeSyncLibrarySongs$2$2$1$1 syncUtils$executeSyncLibrarySongs$2$2$1$1 = new SyncUtils$executeSyncLibrarySongs$2$2$1$1(this.$removed, this.$remoteSongs, this.$now, this.$songIdsWithoutArtists, continuation);
        syncUtils$executeSyncLibrarySongs$2$2$1$1.L$0 = obj;
        return syncUtils$executeSyncLibrarySongs$2$2$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((SyncUtils$executeSyncLibrarySongs$2$2$1$1) create((MusicDatabase) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0052  */
    /* JADX WARN: Code duplicated, block: B:19:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:22:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:24:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:27:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:30:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:31:0x0106  */
    /* JADX WARN: Code duplicated, block: B:33:0x010e  */
    /* JADX WARN: Code duplicated, block: B:36:0x011e  */
    /* JADX WARN: Code duplicated, block: B:38:0x0133  */
    /* JADX WARN: Code duplicated, block: B:40:0x0138  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0068 -> B:16:0x006c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00e1 -> B:28:0x00e6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r29) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.utils.SyncUtils$executeSyncLibrarySongs$2$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
