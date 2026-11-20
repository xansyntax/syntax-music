package com.metrolist.music.utils;

import android.content.Context;
import androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda3;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences$Key;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.AccountInfo;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.DatabaseDao;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.screens.AuthData;
import com.metrolist.music.viewmodels.HomeViewModel;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SyncUtils$createPlaylist$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $onCreated;
    public Object $playlist;
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ boolean $syncWithYouTube;
    public Object L$0;
    public byte label;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncUtils$createPlaylist$1(boolean z, PlaylistEntity playlistEntity, SyncUtils syncUtils, CrossfadeKt$$ExternalSyntheticLambda3 crossfadeKt$$ExternalSyntheticLambda3, Continuation continuation) {
        super(2, continuation);
        this.$syncWithYouTube = z;
        this.$playlist = playlistEntity;
        this.this$0 = syncUtils;
        this.$onCreated = crossfadeKt$$ExternalSyntheticLambda3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$onCreated;
        Object obj3 = this.this$0;
        switch (b) {
            case 0:
                SyncUtils$createPlaylist$1 syncUtils$createPlaylist$1 = new SyncUtils$createPlaylist$1(this.$syncWithYouTube, (PlaylistEntity) this.$playlist, (SyncUtils) obj3, (CrossfadeKt$$ExternalSyntheticLambda3) obj2, continuation);
                syncUtils$createPlaylist$1.L$0 = obj;
                return syncUtils$createPlaylist$1;
            default:
                return new SyncUtils$createPlaylist$1((HomeViewModel) obj3, (LocalDateTime) obj2, this.$syncWithYouTube, continuation);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
        }
        return ((SyncUtils$createPlaylist$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:28:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:68:0x018a  */
    /* JADX WARN: Code duplicated, block: B:72:0x0192  */
    /* JADX WARN: Code duplicated, block: B:87:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x009f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object failure;
        String str;
        boolean z;
        HandlerContext handlerContext;
        AnonymousClass1 anonymousClass1;
        Object objCreatePlaylist;
        Object objFirst;
        List listTake;
        Object objFirst2;
        ArrayList arrayList;
        List listTake2;
        Object objFirst3;
        List list;
        Artist artist;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        boolean z2 = this.$syncWithYouTube;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Object obj2 = this.this$0;
        Object obj3 = this.$onCreated;
        switch (b) {
            case 0:
                PlaylistEntity playlistEntity = (PlaylistEntity) this.$playlist;
                byte b2 = this.label;
                Continuation continuation = null;
                try {
                    if (b2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        if (z2) {
                            YouTube youTube = YouTube.INSTANCE;
                            String str2 = playlistEntity.name;
                            this.L$0 = null;
                            this.label = (byte) 1;
                            objCreatePlaylist = youTube.createPlaylist(str2, this);
                            if (objCreatePlaylist == coroutineSingletons) {
                            }
                        } else {
                            str = null;
                            if (z2 || str == null) {
                                z = false;
                            } else {
                                z = true;
                            }
                            PlaylistEntity playlistEntityCopy$default = PlaylistEntity.copy$default(playlistEntity, null, str, null, false, null, null, null, null, null, null, z, 8187);
                            MusicDatabase musicDatabase = ((SyncUtils) obj2).database;
                            musicDatabase.getClass();
                            musicDatabase.$$delegate_0.insert(playlistEntityCopy$default);
                            DefaultScheduler defaultScheduler = Dispatchers.Default;
                            handlerContext = MainDispatcherLoader.dispatcher;
                            anonymousClass1 = new AnonymousClass1(obj3, (Object) playlistEntityCopy$default, (Object) str, continuation, (byte) 0);
                            this.L$0 = null;
                            this.label = (byte) 2;
                            if (AwaitKt.withContext(handlerContext, anonymousClass1, this) != coroutineSingletons) {
                                return unit;
                            }
                        }
                        return coroutineSingletons;
                    }
                    if (b2 != 1) {
                        if (b2 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objCreatePlaylist = obj;
                    failure = (String) objCreatePlaylist;
                    break;
                } catch (Throwable th) {
                    failure = new Result.Failure(th);
                }
                if (Result.m1866exceptionOrNullimpl(failure) != null) {
                    Timber.Forest.getClass();
                    ConnectionPool.e$1(new Object[0]);
                }
                if (failure instanceof Result.Failure) {
                    failure = null;
                }
                String str3 = (String) failure;
                if (str3 == null || StringsKt.isBlank(str3)) {
                    str = null;
                } else {
                    str = str3;
                }
                if (z2) {
                    z = false;
                } else {
                    z = false;
                }
                PlaylistEntity playlistEntityCopy$default2 = PlaylistEntity.copy$default(playlistEntity, null, str, null, false, null, null, null, null, null, null, z, 8187);
                MusicDatabase musicDatabase2 = ((SyncUtils) obj2).database;
                musicDatabase2.getClass();
                musicDatabase2.$$delegate_0.insert(playlistEntityCopy$default2);
                DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                handlerContext = MainDispatcherLoader.dispatcher;
                anonymousClass1 = new AnonymousClass1(obj3, (Object) playlistEntityCopy$default2, (Object) str, continuation, (byte) 0);
                this.L$0 = null;
                this.label = (byte) 2;
                if (AwaitKt.withContext(handlerContext, anonymousClass1, this) != coroutineSingletons) {
                    return unit;
                }
                return coroutineSingletons;
            default:
                LocalDateTime localDateTime = (LocalDateTime) obj3;
                HomeViewModel homeViewModel = (HomeViewModel) obj2;
                MusicDatabase musicDatabase3 = homeViewModel.database;
                byte b3 = this.label;
                if (b3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    localDateTime.getClass();
                    LocalDateTime localDateTimeNow = LocalDateTime.now();
                    musicDatabase3.getClass();
                    Flow flowMostPlayedSongs = musicDatabase3.$$delegate_0.mostPlayedSongs(localDateTime, 15, 5, localDateTimeNow);
                    this.label = (byte) 1;
                    objFirst = StateFlowKt.first(flowMostPlayedSongs, this);
                    if (objFirst != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b3 == 1) {
                    ResultKt.throwOnFailure(obj);
                    objFirst = obj;
                } else {
                    if (b3 == 2) {
                        listTake = (List) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        objFirst2 = obj;
                        arrayList = new ArrayList();
                        for (Object obj4 : (Iterable) objFirst2) {
                            if (((Album) obj4).album.thumbnailUrl != null) {
                                arrayList.add(obj4);
                            }
                        }
                        List mutableList = CollectionsKt.toMutableList((Iterable) arrayList);
                        Collections.shuffle(mutableList);
                        listTake2 = CollectionsKt.take(mutableList, 5);
                        localDateTime.getClass();
                        Flow flowMostPlayedArtists$default = DatabaseDao.mostPlayedArtists$default(musicDatabase3, localDateTime, 0, null, 14);
                        this.L$0 = listTake;
                        this.$playlist = listTake2;
                        this.label = (byte) 3;
                        objFirst3 = StateFlowKt.first(flowMostPlayedArtists$default, this);
                        if (objFirst3 != coroutineSingletons) {
                            list = listTake;
                        }
                        return coroutineSingletons;
                    }
                    if (b3 != 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    List list2 = (List) this.$playlist;
                    list = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    listTake2 = list2;
                    objFirst3 = obj;
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj5 : (Iterable) objFirst3) {
                    artist = (Artist) obj5;
                    if (!artist.artist.isYouTubeArtist() && artist.artist.thumbnailUrl != null) {
                        arrayList2.add(obj5);
                    }
                }
                List mutableList2 = CollectionsKt.toMutableList((Iterable) arrayList2);
                Collections.shuffle(mutableList2);
                List listTake3 = CollectionsKt.take(mutableList2, 5);
                StateFlowImpl stateFlowImpl = homeViewModel.keepListening;
                List mutableList3 = CollectionsKt.toMutableList((Iterable) CollectionsKt.plus((Iterable) listTake3, (Collection) CollectionsKt.plus((Iterable) listTake2, (Collection) list)));
                Collections.shuffle(mutableList3);
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, mutableList3);
                return unit;
                List mutableList4 = CollectionsKt.toMutableList((Iterable) CollectionsKt__IterablesKt.filterVideoSongs((List) objFirst, z2));
                Collections.shuffle(mutableList4);
                listTake = CollectionsKt.take(mutableList4, 10);
                localDateTime.getClass();
                Flow flowMostPlayedAlbums$default = DatabaseDao.mostPlayedAlbums$default(musicDatabase3, localDateTime, 8, null, 8);
                this.L$0 = listTake;
                this.label = (byte) 2;
                objFirst2 = StateFlowKt.first(flowMostPlayedAlbums$default, this);
                if (objFirst2 != coroutineSingletons) {
                    arrayList = new ArrayList();
                    while (r5.hasNext()) {
                        if (((Album) obj4).album.thumbnailUrl != null) {
                            arrayList.add(obj4);
                        }
                    }
                    List mutableList5 = CollectionsKt.toMutableList((Iterable) arrayList);
                    Collections.shuffle(mutableList5);
                    listTake2 = CollectionsKt.take(mutableList5, 5);
                    localDateTime.getClass();
                    Flow flowMostPlayedArtists$default2 = DatabaseDao.mostPlayedArtists$default(musicDatabase3, localDateTime, 0, null, 14);
                    this.L$0 = listTake;
                    this.$playlist = listTake2;
                    this.label = (byte) 3;
                    objFirst3 = StateFlowKt.first(flowMostPlayedArtists$default2, this);
                    if (objFirst3 != coroutineSingletons) {
                        list = listTake;
                        ArrayList arrayList3 = new ArrayList();
                        while (r0.hasNext()) {
                            artist = (Artist) obj5;
                            if (!artist.artist.isYouTubeArtist()) {
                            }
                        }
                        List mutableList6 = CollectionsKt.toMutableList((Iterable) arrayList3);
                        Collections.shuffle(mutableList6);
                        List listTake4 = CollectionsKt.take(mutableList6, 5);
                        StateFlowImpl stateFlowImpl2 = homeViewModel.keepListening;
                        List mutableList7 = CollectionsKt.toMutableList((Iterable) CollectionsKt.plus((Iterable) listTake4, (Collection) CollectionsKt.plus((Iterable) listTake2, (Collection) list)));
                        Collections.shuffle(mutableList7);
                        stateFlowImpl2.getClass();
                        stateFlowImpl2.updateState(null, mutableList7);
                        return unit;
                    }
                }
                return coroutineSingletons;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.SyncUtils$createPlaylist$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Object $browseId;
        public final /* synthetic */ Object $createdPlaylist;
        public /* synthetic */ Object $onCreated;
        public final /* synthetic */ byte $r8$classId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(Context context, String str, Object obj, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$onCreated = context;
            this.$browseId = str;
            this.$createdPlaylist = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj2 = this.$browseId;
            Object obj3 = this.$createdPlaylist;
            switch (b) {
                case 0:
                    return new AnonymousClass1(this.$onCreated, obj3, obj2, continuation, (byte) 0);
                case 1:
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1((PointerInputScope) obj3, (TextDragObserver) obj2, continuation, (byte) 1);
                    anonymousClass1.$onCreated = obj;
                    return anonymousClass1;
                case 2:
                    return new AnonymousClass1(this.$onCreated, obj3, obj2, continuation, (byte) 2);
                case 3:
                    return new AnonymousClass1(this.$onCreated, obj3, obj2, continuation, (byte) 3);
                case 4:
                    AnonymousClass1 anonymousClass2 = new AnonymousClass1((BottomSheetState) obj3, (PlayerConnection) obj2, continuation, (byte) 4);
                    anonymousClass2.$onCreated = obj;
                    return anonymousClass2;
                case 5:
                    AnonymousClass1 anonymousClass3 = new AnonymousClass1((MusicDatabase) obj3, (String) obj2, continuation, (byte) 5);
                    anonymousClass3.$onCreated = obj;
                    return anonymousClass3;
                case 6:
                    return new AnonymousClass1(this.$onCreated, obj3, obj2, continuation, (byte) 6);
                case 7:
                    return new AnonymousClass1(this.$onCreated, obj3, obj2, continuation, (byte) 7);
                case 8:
                    return new AnonymousClass1((Context) this.$onCreated, (String) obj2, obj3, continuation, (byte) 8);
                case 9:
                    return new AnonymousClass1(this.$onCreated, obj3, obj2, continuation, (byte) 9);
                case 10:
                    return new AnonymousClass1((Context) this.$onCreated, (String) obj2, obj3, continuation, (byte) 10);
                case 11:
                    return new AnonymousClass1(this.$onCreated, obj3, obj2, continuation, (byte) 11);
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    return new AnonymousClass1(this.$onCreated, obj3, obj2, continuation, (byte) 12);
                case 13:
                    AnonymousClass1 anonymousClass4 = new AnonymousClass1((AuthData) obj3, (AccountInfo) obj2, continuation, (byte) 13);
                    anonymousClass4.$onCreated = obj;
                    return anonymousClass4;
                case 14:
                    return new AnonymousClass1(this.$onCreated, obj3, obj2, continuation, (byte) 14);
                case 15:
                    return new AnonymousClass1(this.$onCreated, obj3, obj2, continuation, (byte) 15);
                case 16:
                    return new AnonymousClass1(this.$onCreated, obj3, obj2, continuation, (byte) 16);
                case 17:
                    return new AnonymousClass1(this.$onCreated, obj3, obj2, continuation, (byte) 17);
                case 18:
                    return new AnonymousClass1(this.$onCreated, obj3, obj2, continuation, (byte) 18);
                case 19:
                    return new AnonymousClass1(this.$onCreated, obj3, obj2, continuation, (byte) 19);
                case 20:
                    return new AnonymousClass1(this.$onCreated, obj3, obj2, continuation, (byte) 20);
                case 21:
                    AnonymousClass1 anonymousClass5 = new AnonymousClass1((Preferences$Key) obj3, obj2, continuation, (byte) 21);
                    anonymousClass5.$onCreated = obj;
                    return anonymousClass5;
                case 22:
                    return new AnonymousClass1(this.$onCreated, obj3, obj2, continuation, (byte) 22);
                default:
                    AnonymousClass1 anonymousClass6 = new AnonymousClass1((SongEntity) obj3, (SongItem) obj2, continuation, (byte) 23);
                    anonymousClass6.$onCreated = obj;
                    return anonymousClass6;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 1:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 2:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 3:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 4:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 5:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 6:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 7:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 8:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 9:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 10:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 11:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 13:
                    ((AnonymousClass1) create((MutablePreferences) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 14:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 15:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 16:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 17:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 18:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 19:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 20:
                    ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 21:
                    ((AnonymousClass1) create((MutablePreferences) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 22:
                    ((AnonymousClass1) create((MusicDatabase) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                default:
                    ((AnonymousClass1) create((MusicDatabase) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
            }
        }

        /* JADX WARN: Code duplicated, block: B:115:0x02f0  */
        /* JADX WARN: Code duplicated, block: B:121:0x0309  */
        /* JADX WARN: Code duplicated, block: B:137:0x035a  */
        /* JADX WARN: Code duplicated, block: B:140:0x0365 A[LOOP:7: B:129:0x032d->B:140:0x0365, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:160:0x03b2  */
        /* JADX WARN: Code duplicated, block: B:166:0x03ce  */
        /* JADX WARN: Code duplicated, block: B:285:0x02b2 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:289:0x0304 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:295:0x0367 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:300:0x03c9 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:96:0x02aa  */
        /* JADX WARN: Code duplicated, block: B:99:0x02b0 A[LOOP:3: B:88:0x0281->B:99:0x02b0, LOOP_END] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v14 */
        /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r7v6 java.lang.Object, still in use, count: 2, list:
              (r7v6 java.lang.Object) from 0x0358: PHI (r7 I:??) = (r7v4 java.lang.Object), (r7v6 java.lang.Object) binds: [B:135:0x0357, B:297:0x0358] A[DONT_GENERATE, DONT_INLINE]
              (r7v6 java.lang.Object) from 0x034e: CHECK_CAST (com.metrolist.music.db.entities.PlaylistSong) (r7v6 java.lang.Object)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
            	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
            	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
            	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
            	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
            	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
            	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
            	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                Method dump skipped, instruction units count: 1780
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.utils.SyncUtils$createPlaylist$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(Object obj, Object obj2, Object obj3, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$onCreated = obj;
            this.$createdPlaylist = obj2;
            this.$browseId = obj3;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(Object obj, Object obj2, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$createdPlaylist = obj;
            this.$browseId = obj2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncUtils$createPlaylist$1(HomeViewModel homeViewModel, LocalDateTime localDateTime, boolean z, Continuation continuation) {
        super(2, continuation);
        this.this$0 = homeViewModel;
        this.$onCreated = localDateTime;
        this.$syncWithYouTube = z;
    }
}
