package com.metrolist.music.ui.menu;

import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.pages.PlaylistPage;
import com.metrolist.music.db.DatabaseDao$$ExternalSyntheticLambda0;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.models.MediaMetadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTubePlaylistMenuKt$YouTubePlaylistMenu$2$1 extends SuspendLambda implements Function1 {
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ PlaylistItem $playlist;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List $songs;
    public ArrayList L$0;
    public byte label;

    /* JADX INFO: renamed from: com.metrolist.music.ui.menu.YouTubePlaylistMenuKt$YouTubePlaylistMenu$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ ArrayList $allSongs;
        public final /* synthetic */ byte $r8$classId;
        public /* synthetic */ Object L$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(ArrayList arrayList, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$allSongs = arrayList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            ArrayList arrayList = this.$allSongs;
            switch (b) {
                case 0:
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(arrayList, continuation, (byte) 0);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                default:
                    AnonymousClass1 anonymousClass2 = new AnonymousClass1(arrayList, continuation, (byte) 1);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            MusicDatabase musicDatabase = (MusicDatabase) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    ((AnonymousClass1) create(musicDatabase, continuation)).invokeSuspend(unit);
                    break;
                default:
                    ((AnonymousClass1) create(musicDatabase, continuation)).invokeSuspend(unit);
                    break;
            }
            return unit;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            int i = 0;
            ArrayList arrayList = this.$allSongs;
            MusicDatabase musicDatabase = (MusicDatabase) this.L$0;
            switch (b) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    int size = arrayList.size();
                    while (i < size) {
                        Object obj2 = arrayList.get(i);
                        i++;
                        musicDatabase.insert((MediaMetadata) obj2, new DatabaseDao$$ExternalSyntheticLambda0((byte) 0));
                    }
                    break;
                default:
                    ResultKt.throwOnFailure(obj);
                    int size2 = arrayList.size();
                    while (i < size2) {
                        Object obj3 = arrayList.get(i);
                        i++;
                        musicDatabase.insert((MediaMetadata) obj3, new DatabaseDao$$ExternalSyntheticLambda0((byte) 0));
                    }
                    break;
            }
            return unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ YouTubePlaylistMenuKt$YouTubePlaylistMenu$2$1(List list, MusicDatabase musicDatabase, PlaylistItem playlistItem, Continuation continuation, byte b) {
        super(1, continuation);
        this.$r8$classId = b;
        this.$songs = list;
        this.$database = musicDatabase;
        this.$playlist = playlistItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new YouTubePlaylistMenuKt$YouTubePlaylistMenu$2$1(this.$songs, this.$database, this.$playlist, continuation, (byte) 0);
            default:
                return new YouTubePlaylistMenuKt$YouTubePlaylistMenu$2$1(this.$songs, this.$database, this.$playlist, continuation, (byte) 1);
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
        return ((YouTubePlaylistMenuKt$YouTubePlaylistMenu$2$1) create(continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0063  */
    /* JADX WARN: Code duplicated, block: B:26:0x0068  */
    /* JADX WARN: Code duplicated, block: B:27:0x006b  */
    /* JADX WARN: Code duplicated, block: B:30:0x006f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0084 A[LOOP:1: B:33:0x007e->B:35:0x0084, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:39:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b2 A[LOOP:0: B:41:0x00b0->B:42:0x00b2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:63:0x010c  */
    /* JADX WARN: Code duplicated, block: B:66:0x0111  */
    /* JADX WARN: Code duplicated, block: B:67:0x0114  */
    /* JADX WARN: Code duplicated, block: B:70:0x0118  */
    /* JADX WARN: Code duplicated, block: B:75:0x012d A[LOOP:3: B:73:0x0127->B:75:0x012d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:79:0x014b  */
    /* JADX WARN: Code duplicated, block: B:82:0x015b A[LOOP:2: B:81:0x0159->B:82:0x015b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:90:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM1025playlistgIAlus;
        Object objCompletedLibrary;
        ArrayList arrayList;
        Iterator it;
        AnonymousClass1 anonymousClass1;
        ArrayList arrayList2;
        PlaylistPage playlistPage;
        List list;
        ArrayList arrayList3;
        int size;
        Object objM1025playlistgIAlus2;
        Object objCompletedLibrary2;
        ArrayList arrayList4;
        Iterator it2;
        AnonymousClass1 anonymousClass2;
        ArrayList arrayList5;
        PlaylistPage playlistPage2;
        List list2;
        ArrayList arrayList6;
        int size2;
        byte b = this.$r8$classId;
        MusicDatabase musicDatabase = this.$database;
        List list3 = EmptyList.INSTANCE;
        PlaylistItem playlistItem = this.$playlist;
        List list4 = this.$songs;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        byte b2 = 0;
        int i = 0;
        byte b3 = 1;
        Continuation continuation = null;
        switch (b) {
            case 0:
                byte b4 = this.label;
                if (b4 == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (list4.isEmpty()) {
                        YouTube youTube = YouTube.INSTANCE;
                        String str = playlistItem.id;
                        this.label = (byte) 1;
                        objM1025playlistgIAlus = youTube.m1025playlistgIAlus(str, this);
                        if (objM1025playlistgIAlus == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
                    it = list4.iterator();
                    while (it.hasNext()) {
                        arrayList.add(HexFormatKt.toMediaMetadata((SongItem) it.next()));
                    }
                    anonymousClass1 = new AnonymousClass1(arrayList, continuation, b2);
                    this.L$0 = arrayList;
                    this.label = (byte) 3;
                    if (musicDatabase.withTransaction(anonymousClass1, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    arrayList2 = arrayList;
                    arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
                    size = arrayList2.size();
                    while (b2 < size) {
                        arrayList3.add(((MediaMetadata) arrayList2.get(b2)).id);
                        b2++;
                    }
                    return arrayList3;
                }
                if (b4 == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM1025playlistgIAlus = ((Result) obj).value;
                } else if (b4 == 2) {
                    ResultKt.throwOnFailure(obj);
                    objCompletedLibrary = ((Result) obj).value;
                    if (objCompletedLibrary instanceof Result.Failure) {
                        objCompletedLibrary = null;
                    }
                    playlistPage = (PlaylistPage) objCompletedLibrary;
                    if (playlistPage != null) {
                        list = playlistPage.songs;
                    } else {
                        list = null;
                    }
                    if (list != null) {
                        list3 = list;
                    }
                    list4 = list3;
                    arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
                    it = list4.iterator();
                    while (it.hasNext()) {
                        arrayList.add(HexFormatKt.toMediaMetadata((SongItem) it.next()));
                    }
                    anonymousClass1 = new AnonymousClass1(arrayList, continuation, b2);
                    this.L$0 = arrayList;
                    this.label = (byte) 3;
                    if (musicDatabase.withTransaction(anonymousClass1, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    arrayList2 = arrayList;
                } else {
                    if (b4 != 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ArrayList arrayList7 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    arrayList2 = arrayList7;
                }
                arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
                size = arrayList2.size();
                while (b2 < size) {
                    arrayList3.add(((MediaMetadata) arrayList2.get(b2)).id);
                    b2++;
                }
                return arrayList3;
                this.label = (byte) 2;
                objCompletedLibrary = StringsKt__IndentKt.completedLibrary(objM1025playlistgIAlus, this);
                if (objCompletedLibrary == coroutineSingletons) {
                    return coroutineSingletons;
                }
                if (objCompletedLibrary instanceof Result.Failure) {
                    objCompletedLibrary = null;
                }
                playlistPage = (PlaylistPage) objCompletedLibrary;
                if (playlistPage != null) {
                    list = playlistPage.songs;
                } else {
                    list = null;
                }
                if (list != null) {
                    list3 = list;
                }
                list4 = list3;
                arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
                it = list4.iterator();
                while (it.hasNext()) {
                    arrayList.add(HexFormatKt.toMediaMetadata((SongItem) it.next()));
                }
                anonymousClass1 = new AnonymousClass1(arrayList, continuation, b2);
                this.L$0 = arrayList;
                this.label = (byte) 3;
                if (musicDatabase.withTransaction(anonymousClass1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                arrayList2 = arrayList;
                arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
                size = arrayList2.size();
                while (b2 < size) {
                    arrayList3.add(((MediaMetadata) arrayList2.get(b2)).id);
                    b2++;
                }
                return arrayList3;
            default:
                byte b5 = this.label;
                if (b5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (list4.isEmpty()) {
                        YouTube youTube2 = YouTube.INSTANCE;
                        String str2 = playlistItem.id;
                        this.label = (byte) 1;
                        objM1025playlistgIAlus2 = youTube2.m1025playlistgIAlus(str2, this);
                        if (objM1025playlistgIAlus2 == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
                    it2 = list4.iterator();
                    while (it2.hasNext()) {
                        arrayList4.add(HexFormatKt.toMediaMetadata((SongItem) it2.next()));
                    }
                    anonymousClass2 = new AnonymousClass1(arrayList4, continuation, b3);
                    this.L$0 = arrayList4;
                    this.label = (byte) 3;
                    if (musicDatabase.withTransaction(anonymousClass2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    arrayList5 = arrayList4;
                    arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList5, 10));
                    size2 = arrayList5.size();
                    while (i < size2) {
                        Object obj2 = arrayList5.get(i);
                        i++;
                        arrayList6.add(((MediaMetadata) obj2).id);
                    }
                    return arrayList6;
                }
                if (b5 == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM1025playlistgIAlus2 = ((Result) obj).value;
                } else if (b5 == 2) {
                    ResultKt.throwOnFailure(obj);
                    objCompletedLibrary2 = ((Result) obj).value;
                    if (objCompletedLibrary2 instanceof Result.Failure) {
                        objCompletedLibrary2 = null;
                    }
                    playlistPage2 = (PlaylistPage) objCompletedLibrary2;
                    if (playlistPage2 != null) {
                        list2 = playlistPage2.songs;
                    } else {
                        list2 = null;
                    }
                    if (list2 != null) {
                        list3 = list2;
                    }
                    list4 = list3;
                    arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
                    it2 = list4.iterator();
                    while (it2.hasNext()) {
                        arrayList4.add(HexFormatKt.toMediaMetadata((SongItem) it2.next()));
                    }
                    anonymousClass2 = new AnonymousClass1(arrayList4, continuation, b3);
                    this.L$0 = arrayList4;
                    this.label = (byte) 3;
                    if (musicDatabase.withTransaction(anonymousClass2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    arrayList5 = arrayList4;
                } else {
                    if (b5 != 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    arrayList5 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList5, 10));
                size2 = arrayList5.size();
                while (i < size2) {
                    Object obj3 = arrayList5.get(i);
                    i++;
                    arrayList6.add(((MediaMetadata) obj3).id);
                }
                return arrayList6;
                this.label = (byte) 2;
                objCompletedLibrary2 = StringsKt__IndentKt.completedLibrary(objM1025playlistgIAlus2, this);
                if (objCompletedLibrary2 == coroutineSingletons) {
                    return coroutineSingletons;
                }
                if (objCompletedLibrary2 instanceof Result.Failure) {
                    objCompletedLibrary2 = null;
                }
                playlistPage2 = (PlaylistPage) objCompletedLibrary2;
                if (playlistPage2 != null) {
                    list2 = playlistPage2.songs;
                } else {
                    list2 = null;
                }
                if (list2 != null) {
                    list3 = list2;
                }
                list4 = list3;
                arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
                it2 = list4.iterator();
                while (it2.hasNext()) {
                    arrayList4.add(HexFormatKt.toMediaMetadata((SongItem) it2.next()));
                }
                anonymousClass2 = new AnonymousClass1(arrayList4, continuation, b3);
                this.L$0 = arrayList4;
                this.label = (byte) 3;
                if (musicDatabase.withTransaction(anonymousClass2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                arrayList5 = arrayList4;
                arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList5, 10));
                size2 = arrayList5.size();
                while (i < size2) {
                    Object obj4 = arrayList5.get(i);
                    i++;
                    arrayList6.add(((MediaMetadata) obj4).id);
                }
                return arrayList6;
        }
    }
}
