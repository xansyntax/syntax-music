package com.metrolist.music.ui.menu;

import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.models.MediaMetadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTubePlaylistMenuKt$YouTubePlaylistMenu$3$1 extends SuspendLambda implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List $songs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ YouTubePlaylistMenuKt$YouTubePlaylistMenu$3$1(List list, Continuation continuation, byte b) {
        super(1, continuation);
        this.$r8$classId = b;
        this.$songs = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new YouTubePlaylistMenuKt$YouTubePlaylistMenu$3$1(this.$songs, continuation, (byte) 0);
            default:
                return new YouTubePlaylistMenuKt$YouTubePlaylistMenu$3$1(this.$songs, continuation, (byte) 1);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Continuation continuation = (Continuation) obj;
        switch (b) {
            case 0:
                break;
        }
        return ((YouTubePlaylistMenuKt$YouTubePlaylistMenu$3$1) create(continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        List list = this.$songs;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((SongItem) it.next()).id);
                }
                return arrayList;
            default:
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((MediaMetadata) it2.next()).id);
                }
                return arrayList2;
        }
    }
}
