package com.metrolist.music.ui.menu;

import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.SearchResult;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.models.MediaMetadata;
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
public final class AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1$1$jobs$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ int $index;
    public final /* synthetic */ Function1 $onPercentageChange;
    public final /* synthetic */ Function1 $onSongChange;
    public final /* synthetic */ String[] $resolvedSongIds;
    public final /* synthetic */ SemaphoreImpl $semaphore;
    public final /* synthetic */ Song $song;
    public final /* synthetic */ AtomicInteger $songsIdx;
    public final /* synthetic */ int $songsTot;
    public int I$0;
    public int I$1;
    public SemaphoreImpl L$0;
    public Song L$1;
    public AtomicInteger L$2;
    public Function1 L$3;
    public Function1 L$4;
    public MusicDatabase L$5;
    public String[] L$6;
    public Object L$7;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1$1$jobs$1$1(SemaphoreImpl semaphoreImpl, Song song, AtomicInteger atomicInteger, Function1 function1, Function1 function2, int i, MusicDatabase musicDatabase, String[] strArr, int i2, Continuation continuation) {
        super(2, continuation);
        this.$semaphore = semaphoreImpl;
        this.$song = song;
        this.$songsIdx = atomicInteger;
        this.$onSongChange = function1;
        this.$onPercentageChange = function2;
        this.$songsTot = i;
        this.$database = musicDatabase;
        this.$resolvedSongIds = strArr;
        this.$index = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1$1$jobs$1$1(this.$semaphore, this.$song, this.$songsIdx, this.$onSongChange, this.$onPercentageChange, this.$songsTot, this.$database, this.$resolvedSongIds, this.$index, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1$1$jobs$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:121:0x017d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x0194 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x0164 A[Catch: all -> 0x0209, Exception -> 0x020c, TryCatch #19 {Exception -> 0x020c, all -> 0x0209, blocks: (B:40:0x0160, B:42:0x0164, B:43:0x0177), top: B:119:0x0160 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0191 A[Catch: all -> 0x0198, Exception -> 0x019f, TRY_LEAVE, TryCatch #14 {Exception -> 0x019f, all -> 0x0198, blocks: (B:47:0x0187, B:49:0x0191, B:68:0x01be), top: B:129:0x0187 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x01b6 A[Catch: all -> 0x01fe, Exception -> 0x0202, TRY_LEAVE, TryCatch #12 {Exception -> 0x0202, all -> 0x01fe, blocks: (B:64:0x01b0, B:66:0x01b6, B:72:0x01c5), top: B:133:0x01b0 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x01be A[Catch: all -> 0x0198, Exception -> 0x019f, TRY_ENTER, TRY_LEAVE, TryCatch #14 {Exception -> 0x019f, all -> 0x0198, blocks: (B:47:0x0187, B:49:0x0191, B:68:0x01be), top: B:129:0x0187 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:72:0x01c5 A[Catch: all -> 0x01fe, Exception -> 0x0202, TRY_ENTER, TRY_LEAVE, TryCatch #12 {Exception -> 0x0202, all -> 0x01fe, blocks: (B:64:0x01b0, B:66:0x01b6, B:72:0x01c5), top: B:133:0x01b0 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0206  */
    /* JADX WARN: Code duplicated, block: B:91:0x020f  */
    /* JADX WARN: Code duplicated, block: B:95:0x0219 A[Catch: all -> 0x021d, Exception -> 0x021f, TRY_LEAVE, TryCatch #11 {Exception -> 0x021f, blocks: (B:93:0x0213, B:95:0x0219), top: B:115:0x0213 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0284: INVOKE (r9 I:kotlinx.coroutines.sync.SemaphoreAndMutexImpl) VIRTUAL call: kotlinx.coroutines.sync.SemaphoreAndMutexImpl.release():void A[MD:():void (m)] (LINE:645), block:B:113:0x0284 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SemaphoreAndMutexImpl semaphoreAndMutexImplRelease;
        Song song;
        AtomicInteger atomicInteger;
        MusicDatabase musicDatabase;
        String[] strArr;
        double d;
        int i;
        SemaphoreImpl semaphoreImpl;
        int i2;
        Function1 function1;
        Function1 function2;
        Song song2;
        AtomicInteger atomicInteger2;
        Function1 function3;
        SemaphoreImpl semaphoreImpl2;
        Object objM1039searchMVsJJCw;
        int i3;
        MusicDatabase musicDatabase2;
        Song song3;
        String[] strArr2;
        SemaphoreImpl semaphoreImpl3;
        HashSet hashSet;
        ArrayList arrayList;
        SemaphoreImpl semaphoreImpl4;
        Object objFirstOrNull;
        SongItem songItem;
        DefaultIoScheduler defaultIoScheduler;
        AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1$1$jobs$1$1$1$2$1 addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1$1$jobs$1$1$1$2$1;
        Integer num;
        Throwable thM1866exceptionOrNullimpl;
        byte b = this.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (b == 0) {
                    ResultKt.throwOnFailure(obj);
                    SemaphoreImpl semaphoreImpl5 = this.$semaphore;
                    this.L$0 = semaphoreImpl5;
                    song = this.$song;
                    this.L$1 = song;
                    atomicInteger = this.$songsIdx;
                    this.L$2 = atomicInteger;
                    Function1 function4 = this.$onSongChange;
                    this.L$3 = function4;
                    Function1 function5 = this.$onPercentageChange;
                    this.L$4 = function5;
                    musicDatabase = this.$database;
                    this.L$5 = musicDatabase;
                    strArr = this.$resolvedSongIds;
                    this.L$6 = strArr;
                    int i4 = this.$songsTot;
                    this.I$0 = i4;
                    d = 100.0d;
                    i = this.$index;
                    this.I$1 = i;
                    this.label = (byte) 1;
                    if (semaphoreImpl5.acquire(this) != coroutineSingletons) {
                        semaphoreImpl = semaphoreImpl5;
                        i2 = i4;
                        function1 = function4;
                        function2 = function5;
                    }
                    return coroutineSingletons;
                }
                if (b != 1) {
                    if (b == 2) {
                        int i5 = this.I$1;
                        int i6 = this.I$0;
                        String[] strArr3 = this.L$6;
                        MusicDatabase musicDatabase3 = this.L$5;
                        Function1 function6 = this.L$4;
                        Function1 function7 = this.L$3;
                        AtomicInteger atomicInteger3 = this.L$2;
                        Song song4 = this.L$1;
                        SemaphoreImpl semaphoreImpl6 = this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            atomicInteger2 = atomicInteger3;
                            song3 = song4;
                            objM1039searchMVsJJCw = ((Result) obj).value;
                            d = 100.0d;
                            i3 = i5;
                            i2 = i6;
                            strArr2 = strArr3;
                            function3 = function6;
                            function1 = function7;
                            musicDatabase2 = musicDatabase3;
                            semaphoreImpl2 = semaphoreImpl6;
                            try {
                                if (objM1039searchMVsJJCw instanceof Result.Failure) {
                                    semaphoreImpl3 = semaphoreImpl2;
                                } else {
                                    List list = ((SearchResult) objM1039searchMVsJJCw).items;
                                    hashSet = new HashSet();
                                    arrayList = new ArrayList();
                                    for (Object obj2 : list) {
                                        try {
                                            semaphoreImpl4 = semaphoreImpl2;
                                            try {
                                                if (hashSet.add(((YTItem) obj2).getId())) {
                                                    arrayList.add(obj2);
                                                }
                                                semaphoreImpl2 = semaphoreImpl4;
                                            } catch (Exception e) {
                                                e = e;
                                                semaphoreImpl2 = semaphoreImpl4;
                                                song2 = song3;
                                                Timber.Forest.tag("ERROR");
                                                e.toString();
                                                ConnectionPool.v(new Object[0]);
                                                int iIncrementAndGet = atomicInteger2.incrementAndGet();
                                                function1.invoke(song2.song.title);
                                                num = new Integer((int) ((((double) iIncrementAndGet) / ((double) i2)) * d));
                                                function3.invoke(num);
                                                semaphoreImpl2.release();
                                                return Unit.INSTANCE;
                                            } catch (Throwable th) {
                                                th = th;
                                                song2 = song3;
                                                int iIncrementAndGet2 = atomicInteger2.incrementAndGet();
                                                function1.invoke(song2.song.title);
                                                function3.invoke(new Integer((int) ((((double) iIncrementAndGet2) / ((double) i2)) * d)));
                                                throw th;
                                            }
                                        } catch (Exception e2) {
                                            e = e2;
                                            song2 = song3;
                                            Timber.Forest.tag("ERROR");
                                            e.toString();
                                            ConnectionPool.v(new Object[0]);
                                            int iIncrementAndGet3 = atomicInteger2.incrementAndGet();
                                            function1.invoke(song2.song.title);
                                            num = new Integer((int) ((((double) iIncrementAndGet3) / ((double) i2)) * d));
                                            function3.invoke(num);
                                            semaphoreImpl2.release();
                                            return Unit.INSTANCE;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            song2 = song3;
                                            int iIncrementAndGet4 = atomicInteger2.incrementAndGet();
                                            function1.invoke(song2.song.title);
                                            function3.invoke(new Integer((int) ((((double) iIncrementAndGet4) / ((double) i2)) * d)));
                                            throw th;
                                        }
                                    }
                                    semaphoreImpl4 = semaphoreImpl2;
                                    try {
                                        if (arrayList.isEmpty()) {
                                            semaphoreImpl3 = semaphoreImpl4;
                                        } else {
                                            objFirstOrNull = CollectionsKt.firstOrNull((List) arrayList);
                                            if (objFirstOrNull instanceof SongItem) {
                                                songItem = (SongItem) objFirstOrNull;
                                            } else {
                                                songItem = null;
                                            }
                                            if (songItem != null) {
                                                MediaMetadata mediaMetadata = HexFormatKt.toMediaMetadata(songItem);
                                                DefaultScheduler defaultScheduler = Dispatchers.Default;
                                                defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                                                semaphoreImpl3 = semaphoreImpl4;
                                                try {
                                                    addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1$1$jobs$1$1$1$2$1 = new AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1$1$jobs$1$1$1$2$1(musicDatabase2, mediaMetadata, strArr2, i3, songItem, null);
                                                    this.L$0 = semaphoreImpl3;
                                                    this.L$1 = song3;
                                                    this.L$2 = atomicInteger2;
                                                    this.L$3 = function1;
                                                    this.L$4 = function3;
                                                    this.L$5 = null;
                                                    this.L$6 = null;
                                                    this.L$7 = objM1039searchMVsJJCw;
                                                    this.I$0 = i2;
                                                    this.label = (byte) 3;
                                                    if (AwaitKt.withContext(defaultIoScheduler, addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1$1$jobs$1$1$1$2$1, this) == coroutineSingletons) {
                                                        return coroutineSingletons;
                                                    }
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    semaphoreImpl2 = semaphoreImpl3;
                                                    song2 = song3;
                                                    Timber.Forest.tag("ERROR");
                                                    e.toString();
                                                    ConnectionPool.v(new Object[0]);
                                                    int iIncrementAndGet5 = atomicInteger2.incrementAndGet();
                                                    function1.invoke(song2.song.title);
                                                    num = new Integer((int) ((((double) iIncrementAndGet5) / ((double) i2)) * d));
                                                    function3.invoke(num);
                                                    semaphoreImpl2.release();
                                                    return Unit.INSTANCE;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    song2 = song3;
                                                    int iIncrementAndGet6 = atomicInteger2.incrementAndGet();
                                                    function1.invoke(song2.song.title);
                                                    function3.invoke(new Integer((int) ((((double) iIncrementAndGet6) / ((double) i2)) * d)));
                                                    throw th;
                                                }
                                            } else {
                                                semaphoreImpl3 = semaphoreImpl4;
                                            }
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        semaphoreImpl3 = semaphoreImpl4;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        semaphoreImpl3 = semaphoreImpl4;
                                    }
                                }
                                atomicInteger2 = atomicInteger2;
                                semaphoreImpl2 = semaphoreImpl3;
                                song2 = song3;
                                thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1039searchMVsJJCw);
                                if (thM1866exceptionOrNullimpl != null) {
                                    thM1866exceptionOrNullimpl.printStackTrace();
                                }
                                int iIncrementAndGet7 = atomicInteger2.incrementAndGet();
                                function1.invoke(song2.song.title);
                                num = new Integer((int) ((((double) iIncrementAndGet7) / ((double) i2)) * d));
                            } catch (Exception e5) {
                                e = e5;
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            i2 = i6;
                            function3 = function6;
                            function1 = function7;
                            atomicInteger2 = atomicInteger3;
                            song2 = song4;
                            semaphoreImpl2 = semaphoreImpl6;
                            d = 100.0d;
                            Timber.Forest.tag("ERROR");
                            e.toString();
                            ConnectionPool.v(new Object[0]);
                            int iIncrementAndGet8 = atomicInteger2.incrementAndGet();
                            function1.invoke(song2.song.title);
                            num = new Integer((int) ((((double) iIncrementAndGet8) / ((double) i2)) * d));
                            function3.invoke(num);
                            semaphoreImpl2.release();
                            return Unit.INSTANCE;
                        } catch (Throwable th6) {
                            th = th6;
                            i2 = i6;
                            function3 = function6;
                            function1 = function7;
                            atomicInteger2 = atomicInteger3;
                            song2 = song4;
                            d = 100.0d;
                            int iIncrementAndGet9 = atomicInteger2.incrementAndGet();
                            function1.invoke(song2.song.title);
                            function3.invoke(new Integer((int) ((((double) iIncrementAndGet9) / ((double) i2)) * d)));
                            throw th;
                        }
                    } else {
                        if (b != 3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        i2 = this.I$0;
                        objM1039searchMVsJJCw = this.L$7;
                        function3 = this.L$4;
                        function1 = this.L$3;
                        atomicInteger2 = this.L$2;
                        song2 = this.L$1;
                        semaphoreImpl2 = this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            d = 100.0d;
                            try {
                                try {
                                    thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1039searchMVsJJCw);
                                    if (thM1866exceptionOrNullimpl != null) {
                                        thM1866exceptionOrNullimpl.printStackTrace();
                                    }
                                    int iIncrementAndGet10 = atomicInteger2.incrementAndGet();
                                    function1.invoke(song2.song.title);
                                    num = new Integer((int) ((((double) iIncrementAndGet10) / ((double) i2)) * d));
                                } catch (Exception e7) {
                                    e = e7;
                                    Timber.Forest.tag("ERROR");
                                    e.toString();
                                    ConnectionPool.v(new Object[0]);
                                    int iIncrementAndGet11 = atomicInteger2.incrementAndGet();
                                    function1.invoke(song2.song.title);
                                    num = new Integer((int) ((((double) iIncrementAndGet11) / ((double) i2)) * d));
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                int iIncrementAndGet12 = atomicInteger2.incrementAndGet();
                                function1.invoke(song2.song.title);
                                function3.invoke(new Integer((int) ((((double) iIncrementAndGet12) / ((double) i2)) * d)));
                                throw th;
                            }
                        } catch (Exception e8) {
                            e = e8;
                            d = 100.0d;
                            Timber.Forest.tag("ERROR");
                            e.toString();
                            ConnectionPool.v(new Object[0]);
                            int iIncrementAndGet13 = atomicInteger2.incrementAndGet();
                            function1.invoke(song2.song.title);
                            num = new Integer((int) ((((double) iIncrementAndGet13) / ((double) i2)) * d));
                            function3.invoke(num);
                            semaphoreImpl2.release();
                            return Unit.INSTANCE;
                        } catch (Throwable th8) {
                            th = th8;
                            d = 100.0d;
                            int iIncrementAndGet14 = atomicInteger2.incrementAndGet();
                            function1.invoke(song2.song.title);
                            function3.invoke(new Integer((int) ((((double) iIncrementAndGet14) / ((double) i2)) * d)));
                            throw th;
                        }
                    }
                    function3.invoke(num);
                    semaphoreImpl2.release();
                    return Unit.INSTANCE;
                }
                int i7 = this.I$1;
                int i8 = this.I$0;
                String[] strArr4 = this.L$6;
                MusicDatabase musicDatabase4 = this.L$5;
                function2 = this.L$4;
                Function1 function8 = this.L$3;
                AtomicInteger atomicInteger4 = this.L$2;
                Song song5 = this.L$1;
                semaphoreImpl = this.L$0;
                ResultKt.throwOnFailure(obj);
                strArr = strArr4;
                song = song5;
                musicDatabase = musicDatabase4;
                atomicInteger = atomicInteger4;
                i = i7;
                i2 = i8;
                function1 = function8;
                d = 100.0d;
                String str = "";
                Iterator it = song.artists.iterator();
                while (it.hasNext()) {
                    str = ((Object) str) + ServerSentEventKt.SPACE + URLDecoder.decode(((ArtistEntity) it.next()).name, StandardCharsets.UTF_8.toString());
                }
                String str2 = song.song.title + " - " + ((Object) str);
                YouTube youTube = YouTube.INSTANCE;
                this.L$0 = semaphoreImpl;
                this.L$1 = song;
                this.L$2 = atomicInteger;
                this.L$3 = function1;
                this.L$4 = function2;
                this.L$5 = musicDatabase;
                this.L$6 = strArr;
                this.L$7 = null;
                this.I$0 = i2;
                this.I$1 = i;
                this.label = (byte) 2;
                objM1039searchMVsJJCw = YouTube.INSTANCE.m1039searchMVsJJCw(str2, "EgWKAQIIAWoKEAkQBRAKEAMQBA%3D%3D", false, this);
                if (objM1039searchMVsJJCw != coroutineSingletons) {
                    MusicDatabase musicDatabase5 = musicDatabase;
                    i3 = i;
                    atomicInteger2 = atomicInteger;
                    musicDatabase2 = musicDatabase5;
                    song3 = song;
                    function3 = function2;
                    strArr2 = strArr;
                    semaphoreImpl2 = semaphoreImpl;
                    if (objM1039searchMVsJJCw instanceof Result.Failure) {
                        List list2 = ((SearchResult) objM1039searchMVsJJCw).items;
                        hashSet = new HashSet();
                        arrayList = new ArrayList();
                        while (r11.hasNext()) {
                            semaphoreImpl4 = semaphoreImpl2;
                            if (hashSet.add(((YTItem) obj2).getId())) {
                                arrayList.add(obj2);
                            }
                            semaphoreImpl2 = semaphoreImpl4;
                        }
                        semaphoreImpl4 = semaphoreImpl2;
                        if (arrayList.isEmpty()) {
                            objFirstOrNull = CollectionsKt.firstOrNull((List) arrayList);
                            if (objFirstOrNull instanceof SongItem) {
                                songItem = (SongItem) objFirstOrNull;
                            } else {
                                songItem = null;
                            }
                            if (songItem != null) {
                                MediaMetadata mediaMetadata2 = HexFormatKt.toMediaMetadata(songItem);
                                DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                                defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                                semaphoreImpl3 = semaphoreImpl4;
                                addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1$1$jobs$1$1$1$2$1 = new AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1$1$jobs$1$1$1$2$1(musicDatabase2, mediaMetadata2, strArr2, i3, songItem, null);
                                this.L$0 = semaphoreImpl3;
                                this.L$1 = song3;
                                this.L$2 = atomicInteger2;
                                this.L$3 = function1;
                                this.L$4 = function3;
                                this.L$5 = null;
                                this.L$6 = null;
                                this.L$7 = objM1039searchMVsJJCw;
                                this.I$0 = i2;
                                this.label = (byte) 3;
                                if (AwaitKt.withContext(defaultIoScheduler, addToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$4$1$1$1$jobs$1$1$1$2$1, this) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            } else {
                                semaphoreImpl3 = semaphoreImpl4;
                            }
                        } else {
                            semaphoreImpl3 = semaphoreImpl4;
                        }
                    } else {
                        semaphoreImpl3 = semaphoreImpl2;
                    }
                    atomicInteger2 = atomicInteger2;
                    semaphoreImpl2 = semaphoreImpl3;
                    song2 = song3;
                    thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1039searchMVsJJCw);
                    if (thM1866exceptionOrNullimpl != null) {
                        thM1866exceptionOrNullimpl.printStackTrace();
                    }
                    int iIncrementAndGet15 = atomicInteger2.incrementAndGet();
                    function1.invoke(song2.song.title);
                    num = new Integer((int) ((((double) iIncrementAndGet15) / ((double) i2)) * d));
                    function3.invoke(num);
                    semaphoreImpl2.release();
                    return Unit.INSTANCE;
                }
                return coroutineSingletons;
            } catch (Exception e9) {
                e = e9;
                song2 = song;
                atomicInteger2 = atomicInteger;
                function3 = function2;
                semaphoreImpl2 = semaphoreImpl;
                Timber.Forest.tag("ERROR");
                e.toString();
                ConnectionPool.v(new Object[0]);
                int iIncrementAndGet16 = atomicInteger2.incrementAndGet();
                function1.invoke(song2.song.title);
                num = new Integer((int) ((((double) iIncrementAndGet16) / ((double) i2)) * d));
                function3.invoke(num);
                semaphoreImpl2.release();
                return Unit.INSTANCE;
            } catch (Throwable th9) {
                th = th9;
                song2 = song;
                atomicInteger2 = atomicInteger;
                function3 = function2;
                int iIncrementAndGet17 = atomicInteger2.incrementAndGet();
                function1.invoke(song2.song.title);
                function3.invoke(new Integer((int) ((((double) iIncrementAndGet17) / ((double) i2)) * d)));
                throw th;
            }
        } catch (Throwable th10) {
            semaphoreAndMutexImplRelease.release();
            throw th10;
        }
    }
}
