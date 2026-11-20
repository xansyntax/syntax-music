package com.metrolist.music.ui.menu;

import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.SearchResult;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.utils.SyncUtils$createPlaylist$1;
import io.ktor.sse.ServerSentEventKt;
import j$.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.coroutines.sync.SemaphoreAndMutexImpl;
import kotlinx.coroutines.sync.SemaphoreImpl;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$5$1$1$1$jobs$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ Function1 $onPercentageChange;
    public final /* synthetic */ Function1 $onSongChange;
    public final /* synthetic */ SemaphoreImpl $semaphore;
    public final /* synthetic */ Song $song;
    public final /* synthetic */ AtomicInteger $songsIdx;
    public final /* synthetic */ int $songsTot;
    public int I$0;
    public SemaphoreImpl L$0;
    public Song L$1;
    public AtomicInteger L$2;
    public Function1 L$3;
    public Function1 L$4;
    public MusicDatabase L$5;
    public Object L$7;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$5$1$1$1$jobs$1$1(SemaphoreImpl semaphoreImpl, Song song, AtomicInteger atomicInteger, Function1 function1, Function1 function2, int i, MusicDatabase musicDatabase, Continuation continuation) {
        super(2, continuation);
        this.$semaphore = semaphoreImpl;
        this.$song = song;
        this.$songsIdx = atomicInteger;
        this.$onSongChange = function1;
        this.$onPercentageChange = function2;
        this.$songsTot = i;
        this.$database = musicDatabase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$5$1$1$1$jobs$1$1(this.$semaphore, this.$song, this.$songsIdx, this.$onSongChange, this.$onPercentageChange, this.$songsTot, this.$database, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$5$1$1$1$jobs$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:110:0x0174 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0146 A[Catch: all -> 0x0176, Exception -> 0x017e, TryCatch #9 {Exception -> 0x017e, all -> 0x0176, blocks: (B:46:0x0142, B:48:0x0146, B:49:0x0159, B:51:0x015f, B:53:0x0171, B:59:0x0186, B:61:0x018c, B:63:0x0194, B:66:0x019a), top: B:106:0x0142 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x015f A[Catch: all -> 0x0176, Exception -> 0x017e, TryCatch #9 {Exception -> 0x017e, all -> 0x0176, blocks: (B:46:0x0142, B:48:0x0146, B:49:0x0159, B:51:0x015f, B:53:0x0171, B:59:0x0186, B:61:0x018c, B:63:0x0194, B:66:0x019a), top: B:106:0x0142 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0171 A[Catch: all -> 0x0176, Exception -> 0x017e, TryCatch #9 {Exception -> 0x017e, all -> 0x0176, blocks: (B:46:0x0142, B:48:0x0146, B:49:0x0159, B:51:0x015f, B:53:0x0171, B:59:0x0186, B:61:0x018c, B:63:0x0194, B:66:0x019a), top: B:106:0x0142 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x018c A[Catch: all -> 0x0176, Exception -> 0x017e, TryCatch #9 {Exception -> 0x017e, all -> 0x0176, blocks: (B:46:0x0142, B:48:0x0146, B:49:0x0159, B:51:0x015f, B:53:0x0171, B:59:0x0186, B:61:0x018c, B:63:0x0194, B:66:0x019a), top: B:106:0x0142 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0194 A[Catch: all -> 0x0176, Exception -> 0x017e, TryCatch #9 {Exception -> 0x017e, all -> 0x0176, blocks: (B:46:0x0142, B:48:0x0146, B:49:0x0159, B:51:0x015f, B:53:0x0171, B:59:0x0186, B:61:0x018c, B:63:0x0194, B:66:0x019a), top: B:106:0x0142 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0197  */
    /* JADX WARN: Code duplicated, block: B:66:0x019a A[Catch: all -> 0x0176, Exception -> 0x017e, TRY_LEAVE, TryCatch #9 {Exception -> 0x017e, all -> 0x0176, blocks: (B:46:0x0142, B:48:0x0146, B:49:0x0159, B:51:0x015f, B:53:0x0171, B:59:0x0186, B:61:0x018c, B:63:0x0194, B:66:0x019a), top: B:106:0x0142 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:74:0x01e3 A[Catch: all -> 0x01e7, Exception -> 0x01eb, TRY_LEAVE, TryCatch #12 {Exception -> 0x01eb, all -> 0x01e7, blocks: (B:72:0x01dd, B:74:0x01e3), top: B:100:0x01dd }] */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0255: INVOKE (r9 I:kotlinx.coroutines.sync.SemaphoreAndMutexImpl) VIRTUAL call: kotlinx.coroutines.sync.SemaphoreAndMutexImpl.release():void A[MD:():void (m)] (LINE:598), block:B:91:0x0255 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SemaphoreAndMutexImpl semaphoreAndMutexImplRelease;
        Song song;
        Function1 function1;
        AtomicInteger atomicInteger;
        Function1 function2;
        MusicDatabase musicDatabase;
        SemaphoreImpl semaphoreImpl;
        int i;
        double d;
        Function1 function3;
        Function1 function4;
        AtomicInteger atomicInteger2;
        Song song2;
        SemaphoreImpl semaphoreImpl2;
        Object objM1039searchMVsJJCw;
        Function1 function5;
        AtomicInteger atomicInteger3;
        Song song3;
        SemaphoreImpl semaphoreImpl3;
        MusicDatabase musicDatabase2;
        Function1 function6;
        HashSet hashSet;
        ArrayList arrayList;
        Object objFirstOrNull;
        SongItem songItem;
        DefaultIoScheduler defaultIoScheduler;
        SyncUtils$createPlaylist$1.AnonymousClass1 anonymousClass1;
        Object obj2;
        Throwable thM1866exceptionOrNullimpl;
        byte b = this.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (b == 0) {
                    ResultKt.throwOnFailure(obj);
                    SemaphoreImpl semaphoreImpl4 = this.$semaphore;
                    this.L$0 = semaphoreImpl4;
                    Song song4 = this.$song;
                    this.L$1 = song4;
                    AtomicInteger atomicInteger4 = this.$songsIdx;
                    this.L$2 = atomicInteger4;
                    Function1 function7 = this.$onSongChange;
                    this.L$3 = function7;
                    Function1 function8 = this.$onPercentageChange;
                    this.L$4 = function8;
                    MusicDatabase musicDatabase3 = this.$database;
                    this.L$5 = musicDatabase3;
                    int i2 = this.$songsTot;
                    this.I$0 = i2;
                    this.label = (byte) 1;
                    if (semaphoreImpl4.acquire(this) != coroutineSingletons) {
                        song = song4;
                        function1 = function8;
                        atomicInteger = atomicInteger4;
                        function2 = function7;
                        musicDatabase = musicDatabase3;
                        semaphoreImpl = semaphoreImpl4;
                        i = i2;
                    }
                    return coroutineSingletons;
                }
                if (b != 1) {
                    if (b != 2) {
                        if (b != 3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        i = this.I$0;
                        obj2 = this.L$7;
                        function3 = this.L$4;
                        function4 = this.L$3;
                        atomicInteger2 = this.L$2;
                        song2 = this.L$1;
                        semaphoreImpl2 = this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            d = 100.0d;
                            function5 = function4;
                            function6 = function3;
                            objM1039searchMVsJJCw = obj2;
                            try {
                                thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1039searchMVsJJCw);
                                if (thM1866exceptionOrNullimpl != null) {
                                    thM1866exceptionOrNullimpl.printStackTrace();
                                }
                                int iIncrementAndGet = atomicInteger2.incrementAndGet();
                                function5.invoke(song2.song.title);
                                function6.invoke(new Integer((int) ((((double) iIncrementAndGet) / ((double) i)) * d)));
                            } catch (Exception e) {
                                e = e;
                                function3 = function6;
                                function4 = function5;
                                try {
                                    Timber.Forest.tag("ERROR");
                                    e.toString();
                                    ConnectionPool.v(new Object[0]);
                                    int iIncrementAndGet2 = atomicInteger2.incrementAndGet();
                                    function4.invoke(song2.song.title);
                                    function3.invoke(new Integer((int) ((((double) iIncrementAndGet2) / ((double) i)) * d)));
                                } catch (Throwable th) {
                                    th = th;
                                    int iIncrementAndGet3 = atomicInteger2.incrementAndGet();
                                    function4.invoke(song2.song.title);
                                    function3.invoke(new Integer((int) ((((double) iIncrementAndGet3) / ((double) i)) * d)));
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                function3 = function6;
                                function4 = function5;
                                int iIncrementAndGet4 = atomicInteger2.incrementAndGet();
                                function4.invoke(song2.song.title);
                                function3.invoke(new Integer((int) ((((double) iIncrementAndGet4) / ((double) i)) * d)));
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            d = 100.0d;
                            Timber.Forest.tag("ERROR");
                            e.toString();
                            ConnectionPool.v(new Object[0]);
                            int iIncrementAndGet5 = atomicInteger2.incrementAndGet();
                            function4.invoke(song2.song.title);
                            function3.invoke(new Integer((int) ((((double) iIncrementAndGet5) / ((double) i)) * d)));
                            semaphoreImpl2.release();
                            return Unit.INSTANCE;
                        } catch (Throwable th3) {
                            th = th3;
                            d = 100.0d;
                            int iIncrementAndGet6 = atomicInteger2.incrementAndGet();
                            function4.invoke(song2.song.title);
                            function3.invoke(new Integer((int) ((((double) iIncrementAndGet6) / ((double) i)) * d)));
                            throw th;
                        }
                        semaphoreImpl2.release();
                        return Unit.INSTANCE;
                    }
                    i = this.I$0;
                    MusicDatabase musicDatabase4 = this.L$5;
                    function6 = this.L$4;
                    Function1 function9 = this.L$3;
                    AtomicInteger atomicInteger5 = this.L$2;
                    Song song5 = this.L$1;
                    SemaphoreImpl semaphoreImpl5 = this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        function5 = function9;
                        atomicInteger3 = atomicInteger5;
                        song3 = song5;
                        semaphoreImpl3 = semaphoreImpl5;
                        d = 100.0d;
                        musicDatabase2 = musicDatabase4;
                        objM1039searchMVsJJCw = ((Result) obj).value;
                        try {
                            if (!(objM1039searchMVsJJCw instanceof Result.Failure)) {
                                List list = ((SearchResult) objM1039searchMVsJJCw).items;
                                hashSet = new HashSet();
                                arrayList = new ArrayList();
                                for (Object obj3 : list) {
                                    if (hashSet.add(((YTItem) obj3).getId())) {
                                        arrayList.add(obj3);
                                    }
                                }
                                if (!arrayList.isEmpty()) {
                                    objFirstOrNull = CollectionsKt.firstOrNull((List) arrayList);
                                    if (objFirstOrNull instanceof SongItem) {
                                        songItem = (SongItem) objFirstOrNull;
                                    } else {
                                        songItem = null;
                                    }
                                    if (songItem != null) {
                                        MediaMetadata mediaMetadata = HexFormatKt.toMediaMetadata(songItem);
                                        SongEntity songEntity = HexFormatKt.toMediaMetadata(songItem).toSongEntity();
                                        DefaultScheduler defaultScheduler = Dispatchers.Default;
                                        defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                                        anonymousClass1 = new SyncUtils$createPlaylist$1.AnonymousClass1(musicDatabase2, mediaMetadata, songEntity, (Continuation) null, (byte) 11);
                                        this.L$0 = semaphoreImpl3;
                                        this.L$1 = song3;
                                        this.L$2 = atomicInteger3;
                                        this.L$3 = function5;
                                        this.L$4 = function6;
                                        this.L$5 = null;
                                        this.L$7 = objM1039searchMVsJJCw;
                                        this.I$0 = i;
                                        this.label = (byte) 3;
                                        if (AwaitKt.withContext(defaultIoScheduler, anonymousClass1, this) != coroutineSingletons) {
                                            obj2 = objM1039searchMVsJJCw;
                                            function3 = function6;
                                            function4 = function5;
                                            atomicInteger2 = atomicInteger3;
                                            song2 = song3;
                                            semaphoreImpl2 = semaphoreImpl3;
                                            function5 = function4;
                                            function6 = function3;
                                            objM1039searchMVsJJCw = obj2;
                                        }
                                        return coroutineSingletons;
                                    }
                                    thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1039searchMVsJJCw);
                                    if (thM1866exceptionOrNullimpl != null) {
                                        thM1866exceptionOrNullimpl.printStackTrace();
                                    }
                                    int iIncrementAndGet7 = atomicInteger2.incrementAndGet();
                                    function5.invoke(song2.song.title);
                                    function6.invoke(new Integer((int) ((((double) iIncrementAndGet7) / ((double) i)) * d)));
                                    semaphoreImpl2.release();
                                    return Unit.INSTANCE;
                                }
                            }
                            atomicInteger2 = atomicInteger3;
                            song2 = song3;
                            semaphoreImpl2 = semaphoreImpl3;
                            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1039searchMVsJJCw);
                            if (thM1866exceptionOrNullimpl != null) {
                                thM1866exceptionOrNullimpl.printStackTrace();
                            }
                            int iIncrementAndGet8 = atomicInteger2.incrementAndGet();
                            function5.invoke(song2.song.title);
                            function6.invoke(new Integer((int) ((((double) iIncrementAndGet8) / ((double) i)) * d)));
                        } catch (Exception e3) {
                            e = e3;
                            function3 = function6;
                            function4 = function5;
                            atomicInteger2 = atomicInteger3;
                            song2 = song3;
                            semaphoreImpl2 = semaphoreImpl3;
                            Timber.Forest.tag("ERROR");
                            e.toString();
                            ConnectionPool.v(new Object[0]);
                            int iIncrementAndGet9 = atomicInteger2.incrementAndGet();
                            function4.invoke(song2.song.title);
                            function3.invoke(new Integer((int) ((((double) iIncrementAndGet9) / ((double) i)) * d)));
                            semaphoreImpl2.release();
                            return Unit.INSTANCE;
                        } catch (Throwable th4) {
                            th = th4;
                            function3 = function6;
                            function4 = function5;
                            atomicInteger2 = atomicInteger3;
                            song2 = song3;
                            int iIncrementAndGet10 = atomicInteger2.incrementAndGet();
                            function4.invoke(song2.song.title);
                            function3.invoke(new Integer((int) ((((double) iIncrementAndGet10) / ((double) i)) * d)));
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        function3 = function6;
                        function4 = function9;
                        atomicInteger2 = atomicInteger5;
                        song2 = song5;
                        semaphoreImpl2 = semaphoreImpl5;
                        d = 100.0d;
                        Timber.Forest.tag("ERROR");
                        e.toString();
                        ConnectionPool.v(new Object[0]);
                        int iIncrementAndGet11 = atomicInteger2.incrementAndGet();
                        function4.invoke(song2.song.title);
                        function3.invoke(new Integer((int) ((((double) iIncrementAndGet11) / ((double) i)) * d)));
                        semaphoreImpl2.release();
                        return Unit.INSTANCE;
                    } catch (Throwable th5) {
                        th = th5;
                        function3 = function6;
                        function4 = function9;
                        atomicInteger2 = atomicInteger5;
                        song2 = song5;
                        d = 100.0d;
                        int iIncrementAndGet12 = atomicInteger2.incrementAndGet();
                        function4.invoke(song2.song.title);
                        function3.invoke(new Integer((int) ((((double) iIncrementAndGet12) / ((double) i)) * d)));
                        throw th;
                    }
                    semaphoreImpl2.release();
                    return Unit.INSTANCE;
                }
                i = this.I$0;
                musicDatabase = this.L$5;
                function1 = this.L$4;
                function2 = this.L$3;
                atomicInteger = this.L$2;
                song = this.L$1;
                semaphoreImpl = this.L$0;
                ResultKt.throwOnFailure(obj);
                String str = "";
                Iterator it = song.artists.iterator();
                while (it.hasNext()) {
                    d = 100.0d;
                    try {
                        str = ((Object) str) + ServerSentEventKt.SPACE + URLDecoder.decode(((ArtistEntity) it.next()).name, StandardCharsets.UTF_8.toString());
                    } catch (Exception e5) {
                        e = e5;
                        function3 = function1;
                        function4 = function2;
                        atomicInteger2 = atomicInteger;
                        song2 = song;
                        semaphoreImpl2 = semaphoreImpl;
                        Timber.Forest.tag("ERROR");
                        e.toString();
                        ConnectionPool.v(new Object[0]);
                        int iIncrementAndGet13 = atomicInteger2.incrementAndGet();
                        function4.invoke(song2.song.title);
                        function3.invoke(new Integer((int) ((((double) iIncrementAndGet13) / ((double) i)) * d)));
                        semaphoreImpl2.release();
                        return Unit.INSTANCE;
                    } catch (Throwable th6) {
                        th = th6;
                        function3 = function1;
                        function4 = function2;
                        atomicInteger2 = atomicInteger;
                        song2 = song;
                        int iIncrementAndGet14 = atomicInteger2.incrementAndGet();
                        function4.invoke(song2.song.title);
                        function3.invoke(new Integer((int) ((((double) iIncrementAndGet14) / ((double) i)) * d)));
                        throw th;
                    }
                }
                d = 100.0d;
                String str2 = song.song.title + " - " + ((Object) str);
                YouTube youTube = YouTube.INSTANCE;
                this.L$0 = semaphoreImpl;
                this.L$1 = song;
                this.L$2 = atomicInteger;
                this.L$3 = function2;
                this.L$4 = function1;
                this.L$5 = musicDatabase;
                this.L$7 = null;
                this.I$0 = i;
                this.label = (byte) 2;
                objM1039searchMVsJJCw = YouTube.INSTANCE.m1039searchMVsJJCw(str2, "EgWKAQIIAWoKEAkQBRAKEAMQBA%3D%3D", false, this);
                if (objM1039searchMVsJJCw != coroutineSingletons) {
                    function5 = function2;
                    atomicInteger3 = atomicInteger;
                    song3 = song;
                    semaphoreImpl3 = semaphoreImpl;
                    musicDatabase2 = musicDatabase;
                    function6 = function1;
                    if (!(objM1039searchMVsJJCw instanceof Result.Failure)) {
                        List list2 = ((SearchResult) objM1039searchMVsJJCw).items;
                        hashSet = new HashSet();
                        arrayList = new ArrayList();
                        while (r7.hasNext()) {
                            if (hashSet.add(((YTItem) obj3).getId())) {
                                arrayList.add(obj3);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            objFirstOrNull = CollectionsKt.firstOrNull((List) arrayList);
                            if (objFirstOrNull instanceof SongItem) {
                                songItem = (SongItem) objFirstOrNull;
                            } else {
                                songItem = null;
                            }
                            if (songItem != null) {
                                MediaMetadata mediaMetadata2 = HexFormatKt.toMediaMetadata(songItem);
                                SongEntity songEntity2 = HexFormatKt.toMediaMetadata(songItem).toSongEntity();
                                DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                                defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                                anonymousClass1 = new SyncUtils$createPlaylist$1.AnonymousClass1(musicDatabase2, mediaMetadata2, songEntity2, (Continuation) null, (byte) 11);
                                this.L$0 = semaphoreImpl3;
                                this.L$1 = song3;
                                this.L$2 = atomicInteger3;
                                this.L$3 = function5;
                                this.L$4 = function6;
                                this.L$5 = null;
                                this.L$7 = objM1039searchMVsJJCw;
                                this.I$0 = i;
                                this.label = (byte) 3;
                                if (AwaitKt.withContext(defaultIoScheduler, anonymousClass1, this) != coroutineSingletons) {
                                    obj2 = objM1039searchMVsJJCw;
                                    function3 = function6;
                                    function4 = function5;
                                    atomicInteger2 = atomicInteger3;
                                    song2 = song3;
                                    semaphoreImpl2 = semaphoreImpl3;
                                    function5 = function4;
                                    function6 = function3;
                                    objM1039searchMVsJJCw = obj2;
                                }
                            }
                            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1039searchMVsJJCw);
                            if (thM1866exceptionOrNullimpl != null) {
                                thM1866exceptionOrNullimpl.printStackTrace();
                            }
                            int iIncrementAndGet15 = atomicInteger2.incrementAndGet();
                            function5.invoke(song2.song.title);
                            function6.invoke(new Integer((int) ((((double) iIncrementAndGet15) / ((double) i)) * d)));
                            semaphoreImpl2.release();
                            return Unit.INSTANCE;
                        }
                    }
                    atomicInteger2 = atomicInteger3;
                    song2 = song3;
                    semaphoreImpl2 = semaphoreImpl3;
                    thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1039searchMVsJJCw);
                    if (thM1866exceptionOrNullimpl != null) {
                        thM1866exceptionOrNullimpl.printStackTrace();
                    }
                    int iIncrementAndGet16 = atomicInteger2.incrementAndGet();
                    function5.invoke(song2.song.title);
                    function6.invoke(new Integer((int) ((((double) iIncrementAndGet16) / ((double) i)) * d)));
                    semaphoreImpl2.release();
                    return Unit.INSTANCE;
                }
                return coroutineSingletons;
            } catch (Exception e6) {
                e = e6;
                d = 100.0d;
            } catch (Throwable th7) {
                th = th7;
                d = 100.0d;
            }
        } catch (Throwable th8) {
            semaphoreAndMutexImplRelease.release();
            throw th8;
        }
    }
}
