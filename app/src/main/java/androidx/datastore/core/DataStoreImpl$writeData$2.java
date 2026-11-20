package androidx.datastore.core;

import android.content.Context;
import androidx.media3.common.MediaItem;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.pages.PlaylistPage;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.SetVideoIdEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.extensions.ContextExtKt$isSyncEnabled$1;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.MusicService$handleAlarmTrigger$2;
import com.metrolist.music.playback.alarm.MusicAlarmStore$loadBlocking$1;
import com.metrolist.music.playback.queues.ListQueue;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.random.AbstractPlatformRandom;
import kotlin.random.Random;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreImpl$writeData$2 extends SuspendLambda implements Function2 {
    public Object $newData;
    public Object $newVersion;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean $updateCache;
    public Object L$0;
    public Object L$1;
    public byte label;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$writeData$2(boolean z, MusicDatabase musicDatabase, PlaylistItem playlistItem, List list, Context context, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 4;
        this.$updateCache = z;
        this.L$1 = musicDatabase;
        this.$newVersion = playlistItem;
        this.$newData = list;
        this.this$0 = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.this$0;
        switch (b) {
            case 0:
                DataStoreImpl$writeData$2 dataStoreImpl$writeData$2 = new DataStoreImpl$writeData$2((Ref$IntRef) this.$newVersion, (DataStoreImpl) obj2, this.$newData, this.$updateCache, continuation);
                dataStoreImpl$writeData$2.L$0 = obj;
                return dataStoreImpl$writeData$2;
            case 1:
                return new DataStoreImpl$writeData$2((String) this.L$0, this.$updateCache, (MusicService) this.$newData, (String) obj2, continuation);
            case 2:
                return new DataStoreImpl$writeData$2(this.$updateCache, (MusicDatabase) this.L$1, this.$newVersion, (Context) obj2, continuation, (byte) 2);
            case 3:
                return new DataStoreImpl$writeData$2(this.$updateCache, (MusicDatabase) this.L$1, this.$newVersion, (Context) obj2, continuation, (byte) 3);
            default:
                return new DataStoreImpl$writeData$2(this.$updateCache, (MusicDatabase) this.L$1, (PlaylistItem) this.$newVersion, (List) this.$newData, (Context) obj2, continuation);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((DataStoreImpl$writeData$2) create((FileWriteScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 1:
                return ((DataStoreImpl$writeData$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 2:
                return ((DataStoreImpl$writeData$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 3:
                return ((DataStoreImpl$writeData$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            default:
                return ((DataStoreImpl$writeData$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x020c  */
    /* JADX WARN: Code duplicated, block: B:108:0x0241  */
    /* JADX WARN: Code duplicated, block: B:109:0x0252  */
    /* JADX WARN: Code duplicated, block: B:112:0x0259  */
    /* JADX WARN: Code duplicated, block: B:139:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:140:0x02df  */
    /* JADX WARN: Code duplicated, block: B:142:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:147:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:148:0x0307  */
    /* JADX WARN: Code duplicated, block: B:151:0x030e  */
    /* JADX WARN: Code duplicated, block: B:159:0x0342  */
    /* JADX WARN: Code duplicated, block: B:160:0x0353  */
    /* JADX WARN: Code duplicated, block: B:163:0x035a  */
    /* JADX WARN: Code duplicated, block: B:204:0x044c  */
    /* JADX WARN: Code duplicated, block: B:206:0x0451 A[Catch: all -> 0x04ad, TryCatch #0 {all -> 0x04ad, blocks: (B:175:0x039c, B:206:0x0451, B:207:0x0472, B:209:0x0478, B:211:0x0480, B:213:0x0484, B:215:0x0489, B:216:0x048c, B:217:0x048d, B:218:0x0491, B:179:0x03ad, B:201:0x0431, B:180:0x03b4, B:181:0x03b9, B:187:0x03d6, B:189:0x03de, B:191:0x03e4, B:194:0x03f6, B:195:0x0403, B:197:0x0409, B:198:0x041d, B:184:0x03c2), top: B:250:0x0389 }] */
    /* JADX WARN: Code duplicated, block: B:209:0x0478 A[Catch: all -> 0x04ad, TryCatch #0 {all -> 0x04ad, blocks: (B:175:0x039c, B:206:0x0451, B:207:0x0472, B:209:0x0478, B:211:0x0480, B:213:0x0484, B:215:0x0489, B:216:0x048c, B:217:0x048d, B:218:0x0491, B:179:0x03ad, B:201:0x0431, B:180:0x03b4, B:181:0x03b9, B:187:0x03d6, B:189:0x03de, B:191:0x03e4, B:194:0x03f6, B:195:0x0403, B:197:0x0409, B:198:0x041d, B:184:0x03c2), top: B:250:0x0389 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x007f  */
    /* JADX WARN: Code duplicated, block: B:211:0x0480 A[Catch: all -> 0x04ad, TryCatch #0 {all -> 0x04ad, blocks: (B:175:0x039c, B:206:0x0451, B:207:0x0472, B:209:0x0478, B:211:0x0480, B:213:0x0484, B:215:0x0489, B:216:0x048c, B:217:0x048d, B:218:0x0491, B:179:0x03ad, B:201:0x0431, B:180:0x03b4, B:181:0x03b9, B:187:0x03d6, B:189:0x03de, B:191:0x03e4, B:194:0x03f6, B:195:0x0403, B:197:0x0409, B:198:0x041d, B:184:0x03c2), top: B:250:0x0389 }] */
    /* JADX WARN: Code duplicated, block: B:213:0x0484 A[Catch: all -> 0x04ad, TryCatch #0 {all -> 0x04ad, blocks: (B:175:0x039c, B:206:0x0451, B:207:0x0472, B:209:0x0478, B:211:0x0480, B:213:0x0484, B:215:0x0489, B:216:0x048c, B:217:0x048d, B:218:0x0491, B:179:0x03ad, B:201:0x0431, B:180:0x03b4, B:181:0x03b9, B:187:0x03d6, B:189:0x03de, B:191:0x03e4, B:194:0x03f6, B:195:0x0403, B:197:0x0409, B:198:0x041d, B:184:0x03c2), top: B:250:0x0389 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x0089  */
    /* JADX WARN: Code duplicated, block: B:255:0x0489 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:257:0x0487 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x0099 A[PHI: r4 r7
      0x0099: PHI (r4v50 com.metrolist.music.db.entities.Playlist) = (r4v48 com.metrolist.music.db.entities.Playlist), (r4v52 com.metrolist.music.db.entities.Playlist) binds: [B:23:0x0095, B:11:0x0052] A[DONT_GENERATE, DONT_INLINE]
      0x0099: PHI (r7v20 java.lang.Object) = (r7v19 java.lang.Object), (r7v24 java.lang.Object) binds: [B:23:0x0095, B:11:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:261:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:262:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:263:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:266:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:267:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:268:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:269:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:270:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:273:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:274:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:275:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:276:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:277:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x00b6 A[PHI: r4 r7
      0x00b6: PHI (r4v53 com.metrolist.music.db.entities.Playlist) = 
      (r4v48 com.metrolist.music.db.entities.Playlist)
      (r4v54 com.metrolist.music.db.entities.Playlist)
      (r4v54 com.metrolist.music.db.entities.Playlist)
     binds: [B:21:0x0087, B:35:0x00b2, B:36:0x00b4] A[DONT_GENERATE, DONT_INLINE]
      0x00b6: PHI (r7v25 java.util.List) = (r7v17 java.util.List), (r7v33 java.util.List), (r7v34 java.util.List) binds: [B:21:0x0087, B:35:0x00b2, B:36:0x00b4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:40:0x00c9 A[LOOP:0: B:38:0x00c3->B:40:0x00c9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:43:0x00de A[LOOP:1: B:42:0x00dc->B:43:0x00de, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:46:0x00ff A[LOOP:2: B:45:0x00fd->B:46:0x00ff, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:50:0x0122  */
    /* JADX WARN: Code duplicated, block: B:52:0x0126  */
    /* JADX WARN: Code duplicated, block: B:55:0x0138 A[PHI: r1
      0x0138: PHI (r1v43 java.lang.Object) = (r1v40 java.lang.Object), (r1v47 java.lang.Object) binds: [B:53:0x0135, B:8:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:57:0x013c  */
    /* JADX WARN: Code duplicated, block: B:58:0x014d  */
    /* JADX WARN: Code duplicated, block: B:61:0x0156  */
    /* JADX WARN: Code duplicated, block: B:88:0x01da  */
    /* JADX WARN: Code duplicated, block: B:89:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:91:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:96:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:97:0x0205  */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x052e, code lost:
    
        if (r0 == r8) goto L241;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a1, code lost:
    
        if (r7 == r8) goto L63;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws IOException {
        FileWriteScope fileWriteScope;
        Object num;
        Ref$IntRef ref$IntRef;
        Object objWithContext;
        Object objWithContext2;
        List list;
        String str;
        DefaultIoScheduler defaultIoScheduler;
        MusicService.AnonymousClass15 anonymousClass15;
        List listBuild;
        String str2;
        int iNextInt;
        ListBuilder listBuilder;
        int i;
        int i2;
        MediaItem mediaItem;
        Object objM993addEpisodeToSavedEpisodesgIAlus;
        Object setVideoId;
        SetVideoIdEntity setVideoIdEntity;
        String str3;
        Object objM1032removeEpisodeFromSavedEpisodes0E7RQCE;
        int i3;
        HandlerContext handlerContext;
        ContextExtKt$isSyncEnabled$1 contextExtKt$isSyncEnabled$1;
        int i4;
        HandlerContext handlerContext2;
        ContextExtKt$isSyncEnabled$1 contextExtKt$isSyncEnabled$2;
        Object objM993addEpisodeToSavedEpisodesgIAlus2;
        Object setVideoId2;
        SetVideoIdEntity setVideoIdEntity2;
        String str4;
        Object objM1032removeEpisodeFromSavedEpisodes0E7RQCE2;
        int i5;
        HandlerContext handlerContext3;
        ContextExtKt$isSyncEnabled$1 contextExtKt$isSyncEnabled$3;
        int i6;
        HandlerContext handlerContext4;
        ContextExtKt$isSyncEnabled$1 contextExtKt$isSyncEnabled$4;
        Object objFirst;
        Playlist playlist;
        List list2;
        Object objM1025playlistgIAlus;
        Object objCompletedLibrary;
        ArrayList arrayList;
        Iterator it;
        int size;
        int i7;
        ArrayList arrayList2;
        int size2;
        int i8;
        Object objM1037savePodcast0E7RQCE;
        int i9;
        Context context;
        HandlerContext handlerContext5;
        MusicAlarmStore$loadBlocking$1 musicAlarmStore$loadBlocking$1;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        boolean z = this.$updateCache;
        byte b2 = 3;
        byte b3 = 4;
        byte b4 = 2;
        Continuation continuation = null;
        switch (b) {
            case 0:
                Object obj3 = this.$newData;
                DataStoreImpl dataStoreImpl = (DataStoreImpl) obj2;
                Ref$IntRef ref$IntRef2 = (Ref$IntRef) this.$newVersion;
                byte b5 = this.label;
                if (b5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    fileWriteScope = (FileWriteScope) this.L$0;
                    SingleProcessCoordinator coordinator = dataStoreImpl.getCoordinator();
                    this.L$0 = fileWriteScope;
                    this.L$1 = ref$IntRef2;
                    this.label = (byte) 1;
                    num = new Integer(((AtomicInteger) coordinator.version.delegate).incrementAndGet());
                    if (num != coroutineSingletons) {
                        ref$IntRef = ref$IntRef2;
                    }
                    return coroutineSingletons;
                }
                if (b5 != 1) {
                    if (b5 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    if (!z) {
                        return unit;
                    }
                    dataStoreImpl.inMemoryCache.tryUpdate(new Data(obj3 != null ? obj3.hashCode() : 0, ref$IntRef2.element, obj3));
                    return unit;
                }
                ref$IntRef = (Ref$IntRef) this.L$1;
                fileWriteScope = (FileWriteScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                num = obj;
                ref$IntRef.element = ((Number) num).intValue();
                this.L$0 = null;
                this.L$1 = null;
                this.label = (byte) 2;
                if (fileWriteScope.closed.get()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This scope has already been closed.");
                    return null;
                }
                Object objRunFileDiagnosticsIfNotCorruption = FileStorageKt.runFileDiagnosticsIfNotCorruption(fileWriteScope.file, new FileWriteScope$writeData$2(fileWriteScope, obj3, null), this);
                if (objRunFileDiagnosticsIfNotCorruption != coroutineSingletons) {
                    objRunFileDiagnosticsIfNotCorruption = unit;
                }
                break;
                break;
            case 1:
                String str5 = (String) this.L$0;
                String str6 = (String) obj2;
                MusicService musicService = (MusicService) this.$newData;
                byte b6 = this.label;
                try {
                    if (b6 == 0) {
                        ResultKt.throwOnFailure(obj);
                        DefaultScheduler defaultScheduler = Dispatchers.Default;
                        DefaultIoScheduler defaultIoScheduler2 = DefaultIoScheduler.INSTANCE;
                        MusicService$handleAlarmTrigger$2 musicService$handleAlarmTrigger$2 = new MusicService$handleAlarmTrigger$2(musicService, str6, continuation, (byte) 4);
                        this.label = (byte) 1;
                        objWithContext = AwaitKt.withContext(defaultIoScheduler2, musicService$handleAlarmTrigger$2, this);
                        if (objWithContext == coroutineSingletons) {
                        }
                        return coroutineSingletons;
                    }
                    if (b6 == 1) {
                        ResultKt.throwOnFailure(obj);
                        objWithContext = obj;
                    } else {
                        if (b6 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        if (b6 == 3) {
                            List list3 = (List) this.L$1;
                            ResultKt.throwOnFailure(obj);
                            objWithContext2 = obj;
                            list = list3;
                            str = (String) objWithContext2;
                            DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                            defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                            anonymousClass15 = new MusicService.AnonymousClass15((byte) 2, musicService, null);
                            this.L$1 = list;
                            this.$newVersion = str;
                            this.label = (byte) 4;
                            if (AwaitKt.withContext(defaultIoScheduler, anonymousClass15, this) != coroutineSingletons) {
                                listBuild = list;
                                str2 = str;
                            }
                            return coroutineSingletons;
                        }
                        if (b6 != 4) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        String str7 = (String) this.$newVersion;
                        List list4 = (List) this.L$1;
                        ResultKt.throwOnFailure(obj);
                        str2 = str7;
                        listBuild = list4;
                    }
                    if (z) {
                        AbstractPlatformRandom abstractPlatformRandom = Random.defaultRandom;
                        iNextInt = Random.defaultRandom.nextInt(listBuild.size());
                        listBuilder = new ListBuilder(listBuild.size());
                        listBuilder.add(listBuild.get(iNextInt));
                        i = 0;
                        for (Object obj4 : listBuild) {
                            i2 = i + 1;
                            if (i >= 0) {
                                CollectionsKt__IterablesKt.throwIndexOverflow();
                                throw null;
                            }
                            mediaItem = (MediaItem) obj4;
                            if (i != iNextInt) {
                                listBuilder.add(mediaItem);
                            }
                            i = i2;
                        }
                        listBuild = CollectionsKt__IterablesKt.build(listBuilder);
                    }
                    musicService.player.stop();
                    musicService.player.clearMediaItems();
                    musicService.playQueue(new ListQueue(str2, listBuild, 0, 0L), true, false);
                    return unit;
                    List list5 = (List) objWithContext;
                    if (!list5.isEmpty()) {
                        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, 10));
                        Iterator it2 = list5.iterator();
                        while (it2.hasNext()) {
                            arrayList3.add(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(((PlaylistSong) it2.next()).song)));
                        }
                        DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                        DefaultIoScheduler defaultIoScheduler3 = DefaultIoScheduler.INSTANCE;
                        MusicService$handleAlarmTrigger$2 musicService$handleAlarmTrigger$3 = new MusicService$handleAlarmTrigger$2(musicService, str6, continuation, b2);
                        this.L$1 = arrayList3;
                        this.label = (byte) 3;
                        objWithContext2 = AwaitKt.withContext(defaultIoScheduler3, musicService$handleAlarmTrigger$3, this);
                        list = arrayList3;
                        if (objWithContext2 != coroutineSingletons) {
                            str = (String) objWithContext2;
                            DefaultScheduler defaultScheduler4 = Dispatchers.Default;
                            defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                            anonymousClass15 = new MusicService.AnonymousClass15((byte) 2, musicService, null);
                            this.L$1 = list;
                            this.$newVersion = str;
                            this.label = (byte) 4;
                            if (AwaitKt.withContext(defaultIoScheduler, anonymousClass15, this) != coroutineSingletons) {
                                listBuild = list;
                                str2 = str;
                                if (z) {
                                    AbstractPlatformRandom abstractPlatformRandom2 = Random.defaultRandom;
                                    iNextInt = Random.defaultRandom.nextInt(listBuild.size());
                                    listBuilder = new ListBuilder(listBuild.size());
                                    listBuilder.add(listBuild.get(iNextInt));
                                    i = 0;
                                    while (r0.hasNext()) {
                                        i2 = i + 1;
                                        if (i >= 0) {
                                            CollectionsKt__IterablesKt.throwIndexOverflow();
                                            throw null;
                                        }
                                        mediaItem = (MediaItem) obj4;
                                        if (i != iNextInt) {
                                            listBuilder.add(mediaItem);
                                        }
                                        i = i2;
                                    }
                                    listBuild = CollectionsKt__IterablesKt.build(listBuilder);
                                }
                                musicService.player.stop();
                                musicService.player.clearMediaItems();
                                musicService.playQueue(new ListQueue(str2, listBuild, 0, 0L), true, false);
                                return unit;
                            }
                        }
                    } else {
                        if (StringsKt.isBlank(str5)) {
                            return unit;
                        }
                        DefaultScheduler defaultScheduler5 = Dispatchers.Default;
                        DefaultIoScheduler defaultIoScheduler4 = DefaultIoScheduler.INSTANCE;
                        MusicService$handleAlarmTrigger$2 musicService$handleAlarmTrigger$4 = new MusicService$handleAlarmTrigger$2(musicService, str5, continuation, b4);
                        this.label = (byte) 2;
                        if (AwaitKt.withContext(defaultIoScheduler4, musicService$handleAlarmTrigger$4, this) != coroutineSingletons) {
                            return unit;
                        }
                    }
                    return coroutineSingletons;
                } catch (Throwable unused) {
                    Timber.Forest.tag("MusicService");
                    ConnectionPool.e$1(new Object[0]);
                    return unit;
                }
            case 2:
                Context context2 = (Context) obj2;
                SongEntity songEntity = (SongEntity) this.$newVersion;
                byte b7 = this.label;
                if (b7 != 0) {
                    if (b7 == 1) {
                        ResultKt.throwOnFailure(obj);
                        setVideoId = obj;
                        setVideoIdEntity = (SetVideoIdEntity) setVideoId;
                        if (setVideoIdEntity != null) {
                            str3 = setVideoIdEntity.setVideoId;
                        } else {
                            str3 = null;
                        }
                        if (str3 != null) {
                            return unit;
                        }
                        YouTube youTube = YouTube.INSTANCE;
                        String str8 = songEntity.id;
                        this.L$0 = null;
                        this.label = (byte) 2;
                        objM1032removeEpisodeFromSavedEpisodes0E7RQCE = youTube.m1032removeEpisodeFromSavedEpisodes0E7RQCE(str8, str3, this);
                        if (objM1032removeEpisodeFromSavedEpisodes0E7RQCE != coroutineSingletons) {
                        }
                    } else {
                        if (b7 != 2) {
                            if (b7 == 3) {
                            } else if (b7 == 4) {
                                ResultKt.throwOnFailure(obj);
                                objM993addEpisodeToSavedEpisodesgIAlus = ((Result) obj).value;
                                if (objM993addEpisodeToSavedEpisodesgIAlus instanceof Result.Failure) {
                                    i4 = 0;
                                } else {
                                    ConnectionPool connectionPool = Timber.Forest;
                                    String str9 = songEntity.id;
                                    i4 = 0;
                                    connectionPool.getClass();
                                    ConnectionPool.d(new Object[0]);
                                }
                                if (Result.m1866exceptionOrNullimpl(objM993addEpisodeToSavedEpisodesgIAlus) != null) {
                                    return unit;
                                }
                                ConnectionPool connectionPool2 = Timber.Forest;
                                String str10 = songEntity.id;
                                connectionPool2.getClass();
                                ConnectionPool.e$1(new Object[i4]);
                                DefaultScheduler defaultScheduler6 = Dispatchers.Default;
                                handlerContext2 = MainDispatcherLoader.dispatcher;
                                contextExtKt$isSyncEnabled$2 = new ContextExtKt$isSyncEnabled$1(context2, continuation, (byte) 4);
                                this.L$0 = objM993addEpisodeToSavedEpisodesgIAlus;
                                this.label = (byte) 5;
                                if (AwaitKt.withContext(handlerContext2, contextExtKt$isSyncEnabled$2, this) != coroutineSingletons) {
                                    return unit;
                                }
                            } else if (b7 != 5) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        ResultKt.throwOnFailure(obj);
                        objM1032removeEpisodeFromSavedEpisodes0E7RQCE = ((Result) obj).value;
                    }
                    if (objM1032removeEpisodeFromSavedEpisodes0E7RQCE instanceof Result.Failure) {
                        i3 = 0;
                    } else {
                        ConnectionPool connectionPool3 = Timber.Forest;
                        String str11 = songEntity.id;
                        i3 = 0;
                        connectionPool3.getClass();
                        ConnectionPool.d(new Object[0]);
                    }
                    if (Result.m1866exceptionOrNullimpl(objM1032removeEpisodeFromSavedEpisodes0E7RQCE) != null) {
                        return unit;
                    }
                    ConnectionPool connectionPool4 = Timber.Forest;
                    String str12 = songEntity.id;
                    connectionPool4.getClass();
                    ConnectionPool.e$1(new Object[i3]);
                    DefaultScheduler defaultScheduler7 = Dispatchers.Default;
                    handlerContext = MainDispatcherLoader.dispatcher;
                    contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context2, continuation, b2);
                    this.L$0 = null;
                    this.$newData = objM1032removeEpisodeFromSavedEpisodes0E7RQCE;
                    this.label = (byte) 3;
                    if (AwaitKt.withContext(handlerContext, contextExtKt$isSyncEnabled$1, this) != coroutineSingletons) {
                        return unit;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (z) {
                        MusicDatabase musicDatabase = (MusicDatabase) this.L$1;
                        String str13 = songEntity.id;
                        this.label = (byte) 1;
                        setVideoId = musicDatabase.$$delegate_0.getSetVideoId(str13, this);
                        if (setVideoId != coroutineSingletons) {
                            setVideoIdEntity = (SetVideoIdEntity) setVideoId;
                            if (setVideoIdEntity != null) {
                                str3 = setVideoIdEntity.setVideoId;
                            } else {
                                str3 = null;
                            }
                            if (str3 != null) {
                                return unit;
                            }
                            YouTube youTube2 = YouTube.INSTANCE;
                            String str14 = songEntity.id;
                            this.L$0 = null;
                            this.label = (byte) 2;
                            objM1032removeEpisodeFromSavedEpisodes0E7RQCE = youTube2.m1032removeEpisodeFromSavedEpisodes0E7RQCE(str14, str3, this);
                            if (objM1032removeEpisodeFromSavedEpisodes0E7RQCE != coroutineSingletons) {
                                if (objM1032removeEpisodeFromSavedEpisodes0E7RQCE instanceof Result.Failure) {
                                    ConnectionPool connectionPool5 = Timber.Forest;
                                    String str15 = songEntity.id;
                                    i3 = 0;
                                    connectionPool5.getClass();
                                    ConnectionPool.d(new Object[0]);
                                } else {
                                    i3 = 0;
                                }
                                if (Result.m1866exceptionOrNullimpl(objM1032removeEpisodeFromSavedEpisodes0E7RQCE) != null) {
                                    return unit;
                                }
                                ConnectionPool connectionPool6 = Timber.Forest;
                                String str16 = songEntity.id;
                                connectionPool6.getClass();
                                ConnectionPool.e$1(new Object[i3]);
                                DefaultScheduler defaultScheduler8 = Dispatchers.Default;
                                handlerContext = MainDispatcherLoader.dispatcher;
                                contextExtKt$isSyncEnabled$1 = new ContextExtKt$isSyncEnabled$1(context2, continuation, b2);
                                this.L$0 = null;
                                this.$newData = objM1032removeEpisodeFromSavedEpisodes0E7RQCE;
                                this.label = (byte) 3;
                                if (AwaitKt.withContext(handlerContext, contextExtKt$isSyncEnabled$1, this) != coroutineSingletons) {
                                    return unit;
                                }
                            }
                        }
                    } else {
                        YouTube youTube3 = YouTube.INSTANCE;
                        String str17 = songEntity.id;
                        this.label = (byte) 4;
                        objM993addEpisodeToSavedEpisodesgIAlus = youTube3.m993addEpisodeToSavedEpisodesgIAlus(str17, this);
                        if (objM993addEpisodeToSavedEpisodesgIAlus != coroutineSingletons) {
                            if (objM993addEpisodeToSavedEpisodesgIAlus instanceof Result.Failure) {
                                ConnectionPool connectionPool7 = Timber.Forest;
                                String str18 = songEntity.id;
                                i4 = 0;
                                connectionPool7.getClass();
                                ConnectionPool.d(new Object[0]);
                            } else {
                                i4 = 0;
                            }
                            if (Result.m1866exceptionOrNullimpl(objM993addEpisodeToSavedEpisodesgIAlus) != null) {
                                return unit;
                            }
                            ConnectionPool connectionPool8 = Timber.Forest;
                            String str19 = songEntity.id;
                            connectionPool8.getClass();
                            ConnectionPool.e$1(new Object[i4]);
                            DefaultScheduler defaultScheduler9 = Dispatchers.Default;
                            handlerContext2 = MainDispatcherLoader.dispatcher;
                            contextExtKt$isSyncEnabled$2 = new ContextExtKt$isSyncEnabled$1(context2, continuation, (byte) 4);
                            this.L$0 = objM993addEpisodeToSavedEpisodesgIAlus;
                            this.label = (byte) 5;
                            if (AwaitKt.withContext(handlerContext2, contextExtKt$isSyncEnabled$2, this) != coroutineSingletons) {
                                return unit;
                            }
                        }
                    }
                }
                return coroutineSingletons;
            case 3:
                Context context3 = (Context) obj2;
                SongEntity songEntity2 = ((Song) this.$newVersion).song;
                byte b8 = this.label;
                if (b8 != 0) {
                    if (b8 == 1) {
                        ResultKt.throwOnFailure(obj);
                        setVideoId2 = obj;
                        setVideoIdEntity2 = (SetVideoIdEntity) setVideoId2;
                        if (setVideoIdEntity2 != null) {
                            str4 = setVideoIdEntity2.setVideoId;
                        } else {
                            str4 = null;
                        }
                        if (str4 != null) {
                            return unit;
                        }
                        YouTube youTube4 = YouTube.INSTANCE;
                        String str20 = songEntity2.id;
                        this.L$0 = null;
                        this.label = (byte) 2;
                        objM1032removeEpisodeFromSavedEpisodes0E7RQCE2 = youTube4.m1032removeEpisodeFromSavedEpisodes0E7RQCE(str20, str4, this);
                        if (objM1032removeEpisodeFromSavedEpisodes0E7RQCE2 != coroutineSingletons) {
                        }
                    } else {
                        if (b8 != 2) {
                            if (b8 == 3) {
                            } else if (b8 == 4) {
                                ResultKt.throwOnFailure(obj);
                                objM993addEpisodeToSavedEpisodesgIAlus2 = ((Result) obj).value;
                                if (objM993addEpisodeToSavedEpisodesgIAlus2 instanceof Result.Failure) {
                                    i6 = 0;
                                } else {
                                    ConnectionPool connectionPool9 = Timber.Forest;
                                    String str21 = songEntity2.id;
                                    i6 = 0;
                                    connectionPool9.getClass();
                                    ConnectionPool.d(new Object[0]);
                                }
                                if (Result.m1866exceptionOrNullimpl(objM993addEpisodeToSavedEpisodesgIAlus2) != null) {
                                    return unit;
                                }
                                ConnectionPool connectionPool10 = Timber.Forest;
                                String str22 = songEntity2.id;
                                connectionPool10.getClass();
                                ConnectionPool.e$1(new Object[i6]);
                                DefaultScheduler defaultScheduler10 = Dispatchers.Default;
                                handlerContext4 = MainDispatcherLoader.dispatcher;
                                contextExtKt$isSyncEnabled$4 = new ContextExtKt$isSyncEnabled$1(context3, continuation, (byte) 6);
                                this.L$0 = objM993addEpisodeToSavedEpisodesgIAlus2;
                                this.label = (byte) 5;
                                if (AwaitKt.withContext(handlerContext4, contextExtKt$isSyncEnabled$4, this) != coroutineSingletons) {
                                    return unit;
                                }
                            } else if (b8 != 5) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        ResultKt.throwOnFailure(obj);
                        objM1032removeEpisodeFromSavedEpisodes0E7RQCE2 = ((Result) obj).value;
                    }
                    if (objM1032removeEpisodeFromSavedEpisodes0E7RQCE2 instanceof Result.Failure) {
                        i5 = 0;
                    } else {
                        ConnectionPool connectionPool11 = Timber.Forest;
                        String str23 = songEntity2.id;
                        i5 = 0;
                        connectionPool11.getClass();
                        ConnectionPool.d(new Object[0]);
                    }
                    if (Result.m1866exceptionOrNullimpl(objM1032removeEpisodeFromSavedEpisodes0E7RQCE2) != null) {
                        return unit;
                    }
                    ConnectionPool connectionPool12 = Timber.Forest;
                    String str24 = songEntity2.id;
                    connectionPool12.getClass();
                    ConnectionPool.e$1(new Object[i5]);
                    DefaultScheduler defaultScheduler11 = Dispatchers.Default;
                    handlerContext3 = MainDispatcherLoader.dispatcher;
                    contextExtKt$isSyncEnabled$3 = new ContextExtKt$isSyncEnabled$1(context3, continuation, (byte) 5);
                    this.L$0 = null;
                    this.$newData = objM1032removeEpisodeFromSavedEpisodes0E7RQCE2;
                    this.label = (byte) 3;
                    if (AwaitKt.withContext(handlerContext3, contextExtKt$isSyncEnabled$3, this) != coroutineSingletons) {
                        return unit;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (z) {
                        MusicDatabase musicDatabase2 = (MusicDatabase) this.L$1;
                        String str25 = songEntity2.id;
                        this.label = (byte) 1;
                        setVideoId2 = musicDatabase2.$$delegate_0.getSetVideoId(str25, this);
                        if (setVideoId2 != coroutineSingletons) {
                            setVideoIdEntity2 = (SetVideoIdEntity) setVideoId2;
                            if (setVideoIdEntity2 != null) {
                                str4 = setVideoIdEntity2.setVideoId;
                            } else {
                                str4 = null;
                            }
                            if (str4 != null) {
                                return unit;
                            }
                            YouTube youTube5 = YouTube.INSTANCE;
                            String str26 = songEntity2.id;
                            this.L$0 = null;
                            this.label = (byte) 2;
                            objM1032removeEpisodeFromSavedEpisodes0E7RQCE2 = youTube5.m1032removeEpisodeFromSavedEpisodes0E7RQCE(str26, str4, this);
                            if (objM1032removeEpisodeFromSavedEpisodes0E7RQCE2 != coroutineSingletons) {
                                if (objM1032removeEpisodeFromSavedEpisodes0E7RQCE2 instanceof Result.Failure) {
                                    ConnectionPool connectionPool13 = Timber.Forest;
                                    String str27 = songEntity2.id;
                                    i5 = 0;
                                    connectionPool13.getClass();
                                    ConnectionPool.d(new Object[0]);
                                } else {
                                    i5 = 0;
                                }
                                if (Result.m1866exceptionOrNullimpl(objM1032removeEpisodeFromSavedEpisodes0E7RQCE2) != null) {
                                    return unit;
                                }
                                ConnectionPool connectionPool14 = Timber.Forest;
                                String str28 = songEntity2.id;
                                connectionPool14.getClass();
                                ConnectionPool.e$1(new Object[i5]);
                                DefaultScheduler defaultScheduler12 = Dispatchers.Default;
                                handlerContext3 = MainDispatcherLoader.dispatcher;
                                contextExtKt$isSyncEnabled$3 = new ContextExtKt$isSyncEnabled$1(context3, continuation, (byte) 5);
                                this.L$0 = null;
                                this.$newData = objM1032removeEpisodeFromSavedEpisodes0E7RQCE2;
                                this.label = (byte) 3;
                                if (AwaitKt.withContext(handlerContext3, contextExtKt$isSyncEnabled$3, this) != coroutineSingletons) {
                                    return unit;
                                }
                            }
                        }
                    } else {
                        YouTube youTube6 = YouTube.INSTANCE;
                        String str29 = songEntity2.id;
                        this.label = (byte) 4;
                        objM993addEpisodeToSavedEpisodesgIAlus2 = youTube6.m993addEpisodeToSavedEpisodesgIAlus(str29, this);
                        if (objM993addEpisodeToSavedEpisodesgIAlus2 != coroutineSingletons) {
                            if (objM993addEpisodeToSavedEpisodesgIAlus2 instanceof Result.Failure) {
                                ConnectionPool connectionPool15 = Timber.Forest;
                                String str210 = songEntity2.id;
                                i6 = 0;
                                connectionPool15.getClass();
                                ConnectionPool.d(new Object[0]);
                            } else {
                                i6 = 0;
                            }
                            if (Result.m1866exceptionOrNullimpl(objM993addEpisodeToSavedEpisodesgIAlus2) != null) {
                                return unit;
                            }
                            ConnectionPool connectionPool16 = Timber.Forest;
                            String str211 = songEntity2.id;
                            connectionPool16.getClass();
                            ConnectionPool.e$1(new Object[i6]);
                            DefaultScheduler defaultScheduler13 = Dispatchers.Default;
                            handlerContext4 = MainDispatcherLoader.dispatcher;
                            contextExtKt$isSyncEnabled$4 = new ContextExtKt$isSyncEnabled$1(context3, continuation, (byte) 6);
                            this.L$0 = objM993addEpisodeToSavedEpisodesgIAlus2;
                            this.label = (byte) 5;
                            if (AwaitKt.withContext(handlerContext4, contextExtKt$isSyncEnabled$4, this) != coroutineSingletons) {
                                return unit;
                            }
                        }
                    }
                }
                return coroutineSingletons;
            default:
                MusicDatabase musicDatabase3 = (MusicDatabase) this.L$1;
                PlaylistItem playlistItem = (PlaylistItem) this.$newVersion;
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        if (!z) {
                            Flow flowPlaylistByBrowseId = musicDatabase3.playlistByBrowseId(playlistItem.id);
                            this.label = (byte) 1;
                            objFirst = StateFlowKt.first(flowPlaylistByBrowseId, this);
                            if (objFirst != coroutineSingletons) {
                                playlist = (Playlist) objFirst;
                                if (playlist != null) {
                                    list2 = (List) this.$newData;
                                    if (list2.isEmpty()) {
                                        YouTube youTube7 = YouTube.INSTANCE;
                                        String str30 = playlistItem.id;
                                        this.L$0 = playlist;
                                        this.label = (byte) 2;
                                        objM1025playlistgIAlus = youTube7.m1025playlistgIAlus(str30, this);
                                        if (objM1025playlistgIAlus != coroutineSingletons) {
                                            this.L$0 = playlist;
                                            this.label = (byte) 3;
                                            objCompletedLibrary = StringsKt__IndentKt.completedLibrary(objM1025playlistgIAlus, this);
                                        }
                                    } else {
                                        arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                                        it = list2.iterator();
                                        while (it.hasNext()) {
                                            arrayList.add(HexFormatKt.toMediaMetadata((SongItem) it.next()));
                                        }
                                        size = arrayList.size();
                                        i7 = 0;
                                        while (i7 < size) {
                                            Object obj5 = arrayList.get(i7);
                                            i7++;
                                            musicDatabase3.transaction(new MimesKt$$ExternalSyntheticLambda0(b3, (MediaMetadata) obj5));
                                        }
                                        arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                                        size2 = arrayList.size();
                                        i8 = 0;
                                        while (i8 < size2) {
                                            Object obj6 = arrayList.get(i8);
                                            i8++;
                                            MediaMetadata mediaMetadata = (MediaMetadata) obj6;
                                            arrayList2.add(new Pair(mediaMetadata.id, mediaMetadata.setVideoId));
                                        }
                                        this.L$0 = null;
                                        this.label = (byte) 4;
                                        if (musicDatabase3.addSongsToPlaylist(playlist, arrayList2, false, this) != coroutineSingletons) {
                                            if (!playlistItem.isPodcast) {
                                                return unit;
                                            }
                                            this.L$0 = null;
                                            this.label = (byte) 5;
                                            objM1037savePodcast0E7RQCE = YouTube.INSTANCE.m1037savePodcast0E7RQCE(playlistItem.id, !z, this);
                                            if (objM1037savePodcast0E7RQCE != coroutineSingletons) {
                                                if (objM1037savePodcast0E7RQCE instanceof Result.Failure) {
                                                    i9 = 0;
                                                } else {
                                                    ConnectionPool connectionPool17 = Timber.Forest;
                                                    String str31 = playlistItem.id;
                                                    i9 = 0;
                                                    connectionPool17.getClass();
                                                    ConnectionPool.d(new Object[0]);
                                                }
                                                context = (Context) obj2;
                                                if (Result.m1866exceptionOrNullimpl(objM1037savePodcast0E7RQCE) != null) {
                                                    return unit;
                                                }
                                                ConnectionPool connectionPool18 = Timber.Forest;
                                                String str32 = playlistItem.id;
                                                connectionPool18.getClass();
                                                ConnectionPool.e$1(new Object[i9]);
                                                DefaultScheduler defaultScheduler14 = Dispatchers.Default;
                                                handlerContext5 = MainDispatcherLoader.dispatcher;
                                                musicAlarmStore$loadBlocking$1 = new MusicAlarmStore$loadBlocking$1(context, z, (Continuation) null);
                                                this.L$0 = objM1037savePodcast0E7RQCE;
                                                this.label = (byte) 6;
                                                if (AwaitKt.withContext(handlerContext5, musicAlarmStore$loadBlocking$1, this) != coroutineSingletons) {
                                                    return unit;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (!playlistItem.isPodcast) {
                                        return unit;
                                    }
                                    this.L$0 = null;
                                    this.label = (byte) 5;
                                    objM1037savePodcast0E7RQCE = YouTube.INSTANCE.m1037savePodcast0E7RQCE(playlistItem.id, !z, this);
                                    if (objM1037savePodcast0E7RQCE != coroutineSingletons) {
                                        if (objM1037savePodcast0E7RQCE instanceof Result.Failure) {
                                            ConnectionPool connectionPool19 = Timber.Forest;
                                            String str33 = playlistItem.id;
                                            i9 = 0;
                                            connectionPool19.getClass();
                                            ConnectionPool.d(new Object[0]);
                                        } else {
                                            i9 = 0;
                                        }
                                        context = (Context) obj2;
                                        if (Result.m1866exceptionOrNullimpl(objM1037savePodcast0E7RQCE) != null) {
                                            return unit;
                                        }
                                        ConnectionPool connectionPool110 = Timber.Forest;
                                        String str34 = playlistItem.id;
                                        connectionPool110.getClass();
                                        ConnectionPool.e$1(new Object[i9]);
                                        DefaultScheduler defaultScheduler15 = Dispatchers.Default;
                                        handlerContext5 = MainDispatcherLoader.dispatcher;
                                        musicAlarmStore$loadBlocking$1 = new MusicAlarmStore$loadBlocking$1(context, z, (Continuation) null);
                                        this.L$0 = objM1037savePodcast0E7RQCE;
                                        this.label = (byte) 6;
                                        if (AwaitKt.withContext(handlerContext5, musicAlarmStore$loadBlocking$1, this) != coroutineSingletons) {
                                            return unit;
                                        }
                                    }
                                }
                            }
                            break;
                        } else {
                            if (!playlistItem.isPodcast) {
                                return unit;
                            }
                            this.L$0 = null;
                            this.label = (byte) 5;
                            objM1037savePodcast0E7RQCE = YouTube.INSTANCE.m1037savePodcast0E7RQCE(playlistItem.id, !z, this);
                            if (objM1037savePodcast0E7RQCE != coroutineSingletons) {
                                if (objM1037savePodcast0E7RQCE instanceof Result.Failure) {
                                    ConnectionPool connectionPool111 = Timber.Forest;
                                    String str35 = playlistItem.id;
                                    i9 = 0;
                                    connectionPool111.getClass();
                                    ConnectionPool.d(new Object[0]);
                                } else {
                                    i9 = 0;
                                }
                                context = (Context) obj2;
                                if (Result.m1866exceptionOrNullimpl(objM1037savePodcast0E7RQCE) != null) {
                                    return unit;
                                }
                                ConnectionPool connectionPool112 = Timber.Forest;
                                String str36 = playlistItem.id;
                                connectionPool112.getClass();
                                ConnectionPool.e$1(new Object[i9]);
                                DefaultScheduler defaultScheduler16 = Dispatchers.Default;
                                handlerContext5 = MainDispatcherLoader.dispatcher;
                                musicAlarmStore$loadBlocking$1 = new MusicAlarmStore$loadBlocking$1(context, z, (Continuation) null);
                                this.L$0 = objM1037savePodcast0E7RQCE;
                                this.label = (byte) 6;
                                if (AwaitKt.withContext(handlerContext5, musicAlarmStore$loadBlocking$1, this) != coroutineSingletons) {
                                    return unit;
                                }
                            }
                        }
                        return coroutineSingletons;
                    case 1:
                        ResultKt.throwOnFailure(obj);
                        objFirst = obj;
                        playlist = (Playlist) objFirst;
                        if (playlist != null) {
                            list2 = (List) this.$newData;
                            if (list2.isEmpty()) {
                                YouTube youTube8 = YouTube.INSTANCE;
                                String str37 = playlistItem.id;
                                this.L$0 = playlist;
                                this.label = (byte) 2;
                                objM1025playlistgIAlus = youTube8.m1025playlistgIAlus(str37, this);
                                if (objM1025playlistgIAlus != coroutineSingletons) {
                                    this.L$0 = playlist;
                                    this.label = (byte) 3;
                                    objCompletedLibrary = StringsKt__IndentKt.completedLibrary(objM1025playlistgIAlus, this);
                                }
                            } else {
                                arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                                it = list2.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(HexFormatKt.toMediaMetadata((SongItem) it.next()));
                                }
                                size = arrayList.size();
                                i7 = 0;
                                while (i7 < size) {
                                    Object obj7 = arrayList.get(i7);
                                    i7++;
                                    musicDatabase3.transaction(new MimesKt$$ExternalSyntheticLambda0(b3, (MediaMetadata) obj7));
                                }
                                arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                                size2 = arrayList.size();
                                i8 = 0;
                                while (i8 < size2) {
                                    Object obj8 = arrayList.get(i8);
                                    i8++;
                                    MediaMetadata mediaMetadata2 = (MediaMetadata) obj8;
                                    arrayList2.add(new Pair(mediaMetadata2.id, mediaMetadata2.setVideoId));
                                }
                                this.L$0 = null;
                                this.label = (byte) 4;
                                if (musicDatabase3.addSongsToPlaylist(playlist, arrayList2, false, this) != coroutineSingletons) {
                                    if (!playlistItem.isPodcast) {
                                        return unit;
                                    }
                                    this.L$0 = null;
                                    this.label = (byte) 5;
                                    objM1037savePodcast0E7RQCE = YouTube.INSTANCE.m1037savePodcast0E7RQCE(playlistItem.id, !z, this);
                                    if (objM1037savePodcast0E7RQCE != coroutineSingletons) {
                                        if (objM1037savePodcast0E7RQCE instanceof Result.Failure) {
                                            ConnectionPool connectionPool113 = Timber.Forest;
                                            String str38 = playlistItem.id;
                                            i9 = 0;
                                            connectionPool113.getClass();
                                            ConnectionPool.d(new Object[0]);
                                        } else {
                                            i9 = 0;
                                        }
                                        context = (Context) obj2;
                                        if (Result.m1866exceptionOrNullimpl(objM1037savePodcast0E7RQCE) != null) {
                                            return unit;
                                        }
                                        ConnectionPool connectionPool114 = Timber.Forest;
                                        String str39 = playlistItem.id;
                                        connectionPool114.getClass();
                                        ConnectionPool.e$1(new Object[i9]);
                                        DefaultScheduler defaultScheduler17 = Dispatchers.Default;
                                        handlerContext5 = MainDispatcherLoader.dispatcher;
                                        musicAlarmStore$loadBlocking$1 = new MusicAlarmStore$loadBlocking$1(context, z, (Continuation) null);
                                        this.L$0 = objM1037savePodcast0E7RQCE;
                                        this.label = (byte) 6;
                                        if (AwaitKt.withContext(handlerContext5, musicAlarmStore$loadBlocking$1, this) != coroutineSingletons) {
                                            return unit;
                                        }
                                    }
                                }
                            }
                            break;
                        } else {
                            if (!playlistItem.isPodcast) {
                                return unit;
                            }
                            this.L$0 = null;
                            this.label = (byte) 5;
                            objM1037savePodcast0E7RQCE = YouTube.INSTANCE.m1037savePodcast0E7RQCE(playlistItem.id, !z, this);
                            if (objM1037savePodcast0E7RQCE != coroutineSingletons) {
                                if (objM1037savePodcast0E7RQCE instanceof Result.Failure) {
                                    ConnectionPool connectionPool115 = Timber.Forest;
                                    String str310 = playlistItem.id;
                                    i9 = 0;
                                    connectionPool115.getClass();
                                    ConnectionPool.d(new Object[0]);
                                } else {
                                    i9 = 0;
                                }
                                context = (Context) obj2;
                                if (Result.m1866exceptionOrNullimpl(objM1037savePodcast0E7RQCE) != null) {
                                    return unit;
                                }
                                ConnectionPool connectionPool116 = Timber.Forest;
                                String str311 = playlistItem.id;
                                connectionPool116.getClass();
                                ConnectionPool.e$1(new Object[i9]);
                                DefaultScheduler defaultScheduler18 = Dispatchers.Default;
                                handlerContext5 = MainDispatcherLoader.dispatcher;
                                musicAlarmStore$loadBlocking$1 = new MusicAlarmStore$loadBlocking$1(context, z, (Continuation) null);
                                this.L$0 = objM1037savePodcast0E7RQCE;
                                this.label = (byte) 6;
                                if (AwaitKt.withContext(handlerContext5, musicAlarmStore$loadBlocking$1, this) != coroutineSingletons) {
                                    return unit;
                                }
                            }
                        }
                        return coroutineSingletons;
                    case 2:
                        playlist = (Playlist) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        objM1025playlistgIAlus = ((Result) obj).value;
                        this.L$0 = playlist;
                        this.label = (byte) 3;
                        objCompletedLibrary = StringsKt__IndentKt.completedLibrary(objM1025playlistgIAlus, this);
                        break;
                    case 3:
                        playlist = (Playlist) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        objCompletedLibrary = ((Result) obj).value;
                        if (objCompletedLibrary instanceof Result.Failure) {
                            objCompletedLibrary = null;
                        }
                        PlaylistPage playlistPage = (PlaylistPage) objCompletedLibrary;
                        list2 = playlistPage != null ? playlistPage.songs : null;
                        if (list2 == null) {
                            list2 = EmptyList.INSTANCE;
                        }
                        arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                        it = list2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(HexFormatKt.toMediaMetadata((SongItem) it.next()));
                        }
                        size = arrayList.size();
                        i7 = 0;
                        while (i7 < size) {
                            Object obj9 = arrayList.get(i7);
                            i7++;
                            musicDatabase3.transaction(new MimesKt$$ExternalSyntheticLambda0(b3, (MediaMetadata) obj9));
                        }
                        arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                        size2 = arrayList.size();
                        i8 = 0;
                        while (i8 < size2) {
                            Object obj10 = arrayList.get(i8);
                            i8++;
                            MediaMetadata mediaMetadata3 = (MediaMetadata) obj10;
                            arrayList2.add(new Pair(mediaMetadata3.id, mediaMetadata3.setVideoId));
                        }
                        this.L$0 = null;
                        this.label = (byte) 4;
                        if (musicDatabase3.addSongsToPlaylist(playlist, arrayList2, false, this) != coroutineSingletons) {
                            if (!playlistItem.isPodcast) {
                                return unit;
                            }
                            this.L$0 = null;
                            this.label = (byte) 5;
                            objM1037savePodcast0E7RQCE = YouTube.INSTANCE.m1037savePodcast0E7RQCE(playlistItem.id, !z, this);
                            if (objM1037savePodcast0E7RQCE != coroutineSingletons) {
                                if (objM1037savePodcast0E7RQCE instanceof Result.Failure) {
                                    ConnectionPool connectionPool117 = Timber.Forest;
                                    String str312 = playlistItem.id;
                                    i9 = 0;
                                    connectionPool117.getClass();
                                    ConnectionPool.d(new Object[0]);
                                } else {
                                    i9 = 0;
                                }
                                context = (Context) obj2;
                                if (Result.m1866exceptionOrNullimpl(objM1037savePodcast0E7RQCE) != null) {
                                    return unit;
                                }
                                ConnectionPool connectionPool118 = Timber.Forest;
                                String str313 = playlistItem.id;
                                connectionPool118.getClass();
                                ConnectionPool.e$1(new Object[i9]);
                                DefaultScheduler defaultScheduler19 = Dispatchers.Default;
                                handlerContext5 = MainDispatcherLoader.dispatcher;
                                musicAlarmStore$loadBlocking$1 = new MusicAlarmStore$loadBlocking$1(context, z, (Continuation) null);
                                this.L$0 = objM1037savePodcast0E7RQCE;
                                this.label = (byte) 6;
                                if (AwaitKt.withContext(handlerContext5, musicAlarmStore$loadBlocking$1, this) != coroutineSingletons) {
                                    return unit;
                                }
                            }
                        }
                        return coroutineSingletons;
                    case 4:
                        ResultKt.throwOnFailure(obj);
                        if (!playlistItem.isPodcast) {
                            return unit;
                        }
                        this.L$0 = null;
                        this.label = (byte) 5;
                        objM1037savePodcast0E7RQCE = YouTube.INSTANCE.m1037savePodcast0E7RQCE(playlistItem.id, !z, this);
                        if (objM1037savePodcast0E7RQCE != coroutineSingletons) {
                            if (objM1037savePodcast0E7RQCE instanceof Result.Failure) {
                                ConnectionPool connectionPool119 = Timber.Forest;
                                String str314 = playlistItem.id;
                                i9 = 0;
                                connectionPool119.getClass();
                                ConnectionPool.d(new Object[0]);
                            } else {
                                i9 = 0;
                            }
                            context = (Context) obj2;
                            if (Result.m1866exceptionOrNullimpl(objM1037savePodcast0E7RQCE) != null) {
                                return unit;
                            }
                            ConnectionPool connectionPool1110 = Timber.Forest;
                            String str315 = playlistItem.id;
                            connectionPool1110.getClass();
                            ConnectionPool.e$1(new Object[i9]);
                            DefaultScheduler defaultScheduler110 = Dispatchers.Default;
                            handlerContext5 = MainDispatcherLoader.dispatcher;
                            musicAlarmStore$loadBlocking$1 = new MusicAlarmStore$loadBlocking$1(context, z, (Continuation) null);
                            this.L$0 = objM1037savePodcast0E7RQCE;
                            this.label = (byte) 6;
                            if (AwaitKt.withContext(handlerContext5, musicAlarmStore$loadBlocking$1, this) != coroutineSingletons) {
                                return unit;
                            }
                        }
                        return coroutineSingletons;
                    case 5:
                        ResultKt.throwOnFailure(obj);
                        objM1037savePodcast0E7RQCE = ((Result) obj).value;
                        if (objM1037savePodcast0E7RQCE instanceof Result.Failure) {
                            ConnectionPool connectionPool1111 = Timber.Forest;
                            String str316 = playlistItem.id;
                            i9 = 0;
                            connectionPool1111.getClass();
                            ConnectionPool.d(new Object[0]);
                        } else {
                            i9 = 0;
                        }
                        context = (Context) obj2;
                        if (Result.m1866exceptionOrNullimpl(objM1037savePodcast0E7RQCE) != null) {
                            return unit;
                        }
                        ConnectionPool connectionPool1112 = Timber.Forest;
                        String str317 = playlistItem.id;
                        connectionPool1112.getClass();
                        ConnectionPool.e$1(new Object[i9]);
                        DefaultScheduler defaultScheduler111 = Dispatchers.Default;
                        handlerContext5 = MainDispatcherLoader.dispatcher;
                        musicAlarmStore$loadBlocking$1 = new MusicAlarmStore$loadBlocking$1(context, z, (Continuation) null);
                        this.L$0 = objM1037savePodcast0E7RQCE;
                        this.label = (byte) 6;
                        if (AwaitKt.withContext(handlerContext5, musicAlarmStore$loadBlocking$1, this) != coroutineSingletons) {
                            return unit;
                        }
                        return coroutineSingletons;
                    case 6:
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    default:
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$writeData$2(Ref$IntRef ref$IntRef, DataStoreImpl dataStoreImpl, Object obj, boolean z, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 0;
        this.$newVersion = ref$IntRef;
        this.this$0 = dataStoreImpl;
        this.$newData = obj;
        this.$updateCache = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$writeData$2(String str, boolean z, MusicService musicService, String str2, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 1;
        this.L$0 = str;
        this.$updateCache = z;
        this.$newData = musicService;
        this.this$0 = str2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DataStoreImpl$writeData$2(boolean z, MusicDatabase musicDatabase, Object obj, Context context, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$updateCache = z;
        this.L$1 = musicDatabase;
        this.$newVersion = obj;
        this.this$0 = context;
    }
}
