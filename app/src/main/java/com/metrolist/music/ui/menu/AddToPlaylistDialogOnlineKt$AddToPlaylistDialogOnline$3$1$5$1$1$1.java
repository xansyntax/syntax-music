package com.metrolist.music.ui.menu;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.discord.DiscordRpcManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.coroutines.sync.SemaphoreImpl;
import kotlinx.coroutines.sync.SemaphoreKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$5$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ CoroutineScope $coroutineScope;
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ Function0 $onDismiss;
    public final /* synthetic */ Function1 $onPercentageChange;
    public final /* synthetic */ Function1 $onProgressStart;
    public final /* synthetic */ Function1 $onSongChange;
    public final /* synthetic */ SnapshotStateList $songs;
    public int I$0;
    public Throwable L$2;
    public Iterator L$4;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$5$1$1$1(Function0 function0, SnapshotStateList snapshotStateList, Function1 function1, CoroutineScope coroutineScope, Function1 function2, Function1 function3, MusicDatabase musicDatabase, Continuation continuation) {
        super(2, continuation);
        this.$onDismiss = function0;
        this.$songs = snapshotStateList;
        this.$onProgressStart = function1;
        this.$coroutineScope = coroutineScope;
        this.$onSongChange = function2;
        this.$onPercentageChange = function3;
        this.$database = musicDatabase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$5$1$1$1(this.$onDismiss, this.$songs, this.$onProgressStart, this.$coroutineScope, this.$onSongChange, this.$onPercentageChange, this.$database, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$5$1$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:51:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i;
        Iterator it;
        HandlerContext handlerContext;
        DiscordRpcManager.AnonymousClass1 anonymousClass1;
        byte b = this.label;
        Unit unit = Unit.INSTANCE;
        Function1 function1 = this.$onProgressStart;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (b == 0) {
            ResultKt.throwOnFailure(obj);
            this.$onDismiss.invoke();
            SnapshotStateList snapshotStateList = this.$songs;
            int size = snapshotStateList.size();
            if (size != 0) {
                AtomicInteger atomicInteger = new AtomicInteger(0);
                int i2 = SemaphoreKt.MAX_SPIN_CYCLES;
                SemaphoreImpl semaphoreImpl = new SemaphoreImpl(15);
                function1.invoke(Boolean.TRUE);
                try {
                    List listReversed = CollectionsKt.reversed(snapshotStateList);
                    CoroutineScope coroutineScope = this.$coroutineScope;
                    Function1 function2 = this.$onSongChange;
                    Function1 function3 = this.$onPercentageChange;
                    MusicDatabase musicDatabase = this.$database;
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listReversed, 10));
                    Iterator it2 = listReversed.iterator();
                    while (it2.hasNext()) {
                        CoroutineScope coroutineScope2 = coroutineScope;
                        MusicDatabase musicDatabase2 = musicDatabase;
                        arrayList.add(AwaitKt.launch$default(coroutineScope2, null, null, new AddToPlaylistDialogOnlineKt$AddToPlaylistDialogOnline$3$1$5$1$1$1$jobs$1$1(semaphoreImpl, (Song) it2.next(), atomicInteger, function2, function3, size, musicDatabase2, null), 3));
                        coroutineScope = coroutineScope2;
                        musicDatabase = musicDatabase2;
                    }
                    it = arrayList.iterator();
                    i = size;
                } catch (Throwable th) {
                    th = th;
                    i = size;
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    handlerContext = MainDispatcherLoader.dispatcher;
                    anonymousClass1 = new DiscordRpcManager.AnonymousClass1((byte) 4, null, function1);
                    this.L$2 = th;
                    this.L$4 = null;
                    this.I$0 = i;
                    this.label = (byte) 3;
                    if (AwaitKt.withContext(handlerContext, anonymousClass1, this) == coroutineSingletons) {
                        throw th;
                    }
                }
            }
        }
        if (b != 1) {
            if (b == 2) {
                ResultKt.throwOnFailure(obj);
                return unit;
            }
            if (b != 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Throwable th2 = this.L$2;
            ResultKt.throwOnFailure(obj);
            throw th2;
        }
        i = this.I$0;
        it = this.L$4;
        try {
            ResultKt.throwOnFailure(obj);
        } catch (Throwable th3) {
            th = th3;
            DefaultScheduler defaultScheduler2 = Dispatchers.Default;
            handlerContext = MainDispatcherLoader.dispatcher;
            anonymousClass1 = new DiscordRpcManager.AnonymousClass1((byte) 4, null, function1);
            this.L$2 = th;
            this.L$4 = null;
            this.I$0 = i;
            this.label = (byte) 3;
            if (AwaitKt.withContext(handlerContext, anonymousClass1, this) == coroutineSingletons) {
                throw th;
            }
        }
        while (it.hasNext()) {
            Job job = (Job) it.next();
            this.L$2 = null;
            this.L$4 = it;
            this.I$0 = i;
            this.label = (byte) 1;
            if (job.join(this) == coroutineSingletons) {
            }
        }
        DefaultScheduler defaultScheduler3 = Dispatchers.Default;
        HandlerContext handlerContext2 = MainDispatcherLoader.dispatcher;
        DiscordRpcManager.AnonymousClass1 anonymousClass2 = new DiscordRpcManager.AnonymousClass1((byte) 4, null, function1);
        this.L$2 = null;
        this.L$4 = null;
        this.I$0 = i;
        this.label = (byte) 2;
        return AwaitKt.withContext(handlerContext2, anonymousClass2, this) == coroutineSingletons ? coroutineSingletons : unit;
    }
}
