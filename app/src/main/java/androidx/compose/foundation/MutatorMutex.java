package androidx.compose.foundation;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.platform.WindowRecomposer_androidKt;
import androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.pages.LibraryPage;
import com.metrolist.innertubex.extraction.InnerTubeExtractor;
import com.metrolist.lrclib.LrcLib$getAllLyrics$$inlined$sortedByDescending$1;
import com.metrolist.music.constants.AddToPlaylistPosition;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.ui.menu.AddToPlaylistDialogKt$AddToPlaylistDialog$6$1$1$1$2;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.SyncUtils$executeSyncLibrarySongs$2$2$1$1;
import com.metrolist.music.utils.SyncUtils$executeSyncLikedSongs$2$1;
import com.metrolist.music.utils.UtilsKt;
import com.metrolist.music.viewmodels.NewReleaseViewModel;
import dagger.hilt.EntryPoints;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptySet;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DeferredCoroutine;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MutatorMutex {
    public final AtomicReference currentMutator = new AtomicReference(null);
    public final MutexImpl mutex = new MutexImpl();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Mutator {
        public final Job job;
        public final MutatePriority priority;

        public Mutator(MutatePriority mutatePriority, Job job) {
            this.priority = mutatePriority;
            this.job = job;
        }
    }

    public final Object mutate(MutatePriority mutatePriority, Function1 function1, ContinuationImpl continuationImpl) {
        return AwaitKt.coroutineScope(new AnonymousClass2(mutatePriority, this, function1, null), continuationImpl);
    }

    public final void tryMutateOrCancel(Mutator mutator) {
        while (true) {
            AtomicReference atomicReference = this.currentMutator;
            Mutator mutator2 = (Mutator) atomicReference.get();
            if (mutator2 != null && mutator.priority.compareTo(mutator2.priority) < 0) {
                throw new CancellationException("Current mutation had a higher priority");
            }
            do {
                if (atomicReference.compareAndSet(mutator2, mutator)) {
                    if (mutator2 != null) {
                        mutator2.job.cancel(new MutationInterruptedException("Mutation interrupted", (byte) 1));
                        return;
                    }
                    return;
                }
            } while (atomicReference.get() == mutator2);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.MutatorMutex$mutate$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Object $block;
        public Object $priority;
        public final /* synthetic */ byte $r8$classId;
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public byte label;
        public Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MusicDatabase musicDatabase, AddToPlaylistPosition addToPlaylistPosition, SyncUtils syncUtils, Function0 function0, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = (byte) 3;
            this.L$1 = mutableState;
            this.L$2 = mutableState2;
            this.L$0 = mutableState3;
            this.L$3 = musicDatabase;
            this.this$0 = addToPlaylistPosition;
            this.$priority = syncUtils;
            this.$block = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj2 = this.$block;
            switch (b) {
                case 0:
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2((MutatePriority) this.$priority, (MutatorMutex) this.this$0, (Function1) obj2, continuation);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
                case 1:
                    AnonymousClass2 anonymousClass3 = new AnonymousClass2((ContentResolver) this.L$0, (Uri) this.L$3, (WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1) this.this$0, (BufferedChannel) this.$priority, (Context) obj2, continuation);
                    anonymousClass3.L$2 = obj;
                    return anonymousClass3;
                case 2:
                    AnonymousClass2 anonymousClass4 = new AnonymousClass2(obj2, continuation, (byte) 2);
                    anonymousClass4.L$2 = obj;
                    return anonymousClass4;
                case 3:
                    return new AnonymousClass2((MutableState) this.L$1, (MutableState) this.L$2, (MutableState) this.L$0, (MusicDatabase) this.L$3, (AddToPlaylistPosition) this.this$0, (SyncUtils) this.$priority, (Function0) obj2, continuation);
                case 4:
                    return new AnonymousClass2((MusicDatabase) this.L$0, (PlaylistEntity) this.L$3, (Function1) obj2, (Function0) this.this$0, (MutableState) this.$priority, continuation);
                case 5:
                    return new AnonymousClass2(obj2, continuation, (byte) 5);
                default:
                    return new AnonymousClass2((MusicDatabase) this.$priority, (NewReleaseViewModel) obj2, continuation);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 1:
                    return ((AnonymousClass2) create((FlowCollector) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 2:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 3:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 4:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 5:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                default:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            }
        }

        /* JADX WARN: Code duplicated, block: B:102:0x02b4  */
        /* JADX WARN: Code duplicated, block: B:125:0x033f A[LOOP:4: B:123:0x0339->B:125:0x033f, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:178:0x0499  */
        /* JADX WARN: Code duplicated, block: B:185:0x04ab  */
        /* JADX WARN: Code duplicated, block: B:209:0x0525  */
        /* JADX WARN: Code duplicated, block: B:210:0x0526  */
        /* JADX WARN: Code duplicated, block: B:213:0x0533 A[Catch: all -> 0x04e7, TRY_LEAVE, TryCatch #4 {all -> 0x04e7, blocks: (B:197:0x04e1, B:207:0x0516, B:211:0x052b, B:213:0x0533, B:203:0x04f8, B:206:0x050d), top: B:266:0x04d2 }] */
        /* JADX WARN: Code duplicated, block: B:216:0x055d  */
        /* JADX WARN: Code duplicated, block: B:260:0x0484 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:280:0x01b5 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:282:0x01a7 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:296:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:300:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:309:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:30:0x00eb  */
        /* JADX WARN: Code duplicated, block: B:59:0x0190  */
        /* JADX WARN: Code duplicated, block: B:61:0x0199  */
        /* JADX WARN: Code duplicated, block: B:65:0x01ad A[Catch: Exception -> 0x01b9, TryCatch #5 {Exception -> 0x01b9, blocks: (B:87:0x023d, B:62:0x019c, B:63:0x01a7, B:65:0x01ad, B:67:0x01b5, B:69:0x01bc, B:70:0x01cd, B:72:0x01d3, B:73:0x01df, B:75:0x01e9, B:77:0x01ef), top: B:268:0x019c }] */
        /* JADX WARN: Code duplicated, block: B:72:0x01d3 A[Catch: Exception -> 0x01b9, LOOP:3: B:70:0x01cd->B:72:0x01d3, LOOP_END, TryCatch #5 {Exception -> 0x01b9, blocks: (B:87:0x023d, B:62:0x019c, B:63:0x01a7, B:65:0x01ad, B:67:0x01b5, B:69:0x01bc, B:70:0x01cd, B:72:0x01d3, B:73:0x01df, B:75:0x01e9, B:77:0x01ef), top: B:268:0x019c }] */
        /* JADX WARN: Code duplicated, block: B:75:0x01e9 A[Catch: Exception -> 0x01b9, TryCatch #5 {Exception -> 0x01b9, blocks: (B:87:0x023d, B:62:0x019c, B:63:0x01a7, B:65:0x01ad, B:67:0x01b5, B:69:0x01bc, B:70:0x01cd, B:72:0x01d3, B:73:0x01df, B:75:0x01e9, B:77:0x01ef), top: B:268:0x019c }] */
        /* JADX WARN: Code duplicated, block: B:77:0x01ef A[Catch: Exception -> 0x01b9, TRY_LEAVE, TryCatch #5 {Exception -> 0x01b9, blocks: (B:87:0x023d, B:62:0x019c, B:63:0x01a7, B:65:0x01ad, B:67:0x01b5, B:69:0x01bc, B:70:0x01cd, B:72:0x01d3, B:73:0x01df, B:75:0x01e9, B:77:0x01ef), top: B:268:0x019c }] */
        /* JADX WARN: Code duplicated, block: B:80:0x0209  */
        /* JADX WARN: Code duplicated, block: B:84:0x0223 A[Catch: Exception -> 0x0142, LOOP:1: B:82:0x021d->B:84:0x0223, LOOP_END, TryCatch #8 {Exception -> 0x0142, blocks: (B:43:0x0138, B:81:0x020e, B:82:0x021d, B:84:0x0223, B:85:0x022f), top: B:273:0x0138 }] */
        /* JADX WARN: Code duplicated, block: B:90:0x026f  */
        /* JADX WARN: Code duplicated, block: B:93:0x027c A[Catch: Exception -> 0x0293, TryCatch #7 {Exception -> 0x0293, blocks: (B:39:0x0119, B:91:0x0273, B:93:0x027c, B:94:0x0281), top: B:271:0x0119 }] */
        /* JADX WARN: Code duplicated, block: B:97:0x029e A[PHI: r1 r3
          0x029e: PHI (r1v81 java.lang.Object) = (r1v71 java.lang.Object), (r1v82 java.lang.Object) binds: [B:60:0x0197, B:95:0x0291] A[DONT_GENERATE, DONT_INLINE]
          0x029e: PHI (r3v40 java.lang.Object) = (r3v33 java.lang.Object), (r3v41 java.lang.Object) binds: [B:60:0x0197, B:95:0x0291] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:99:0x02a4  */
        /* JADX WARN: Code restructure failed: missing block: B:127:0x0358, code lost:
        
            if (r0.addSongsToPlaylist(r4, r2, false, r20) == r12) goto L128;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0085, code lost:
        
            if (r0 == r12) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:214:0x0559, code lost:
        
            if (r1.emit(r7, r20) == r12) goto L215;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.compose.foundation.MutatorMutex] */
        /* JADX WARN: Type inference failed for: r1v11, types: [java.util.concurrent.atomic.AtomicReference] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r2v5, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r2v64 */
        /* JADX WARN: Type inference failed for: r2v65 */
        /* JADX WARN: Type inference failed for: r3v0, types: [byte] */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v51 */
        /* JADX WARN: Type inference failed for: r3v52 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:214:0x0559 -> B:198:0x04e4). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Function1 function1;
            Mutex mutex;
            Mutator mutator;
            MutatorMutex mutatorMutex;
            Object objInvoke;
            MutatorMutex mutatorMutex2;
            FlowCollector flowCollector;
            Object objHasNext;
            FlowCollector flowCollector2;
            ChannelIterator channelIterator;
            BufferedChannel.BufferedChannelIterator bufferedChannelIterator;
            ChannelIterator bufferedChannelIterator2;
            BufferedChannel.BufferedChannelIterator bufferedChannelIterator3;
            ChannelIterator channelIterator2;
            DeferredCoroutine deferredCoroutineAsync$default;
            List listCreateListBuilder;
            Object objAwait;
            List list;
            List list2;
            List list3;
            InnerTubeExtractor innerTubeExtractor;
            Object objPrewarm$fetchConfig;
            String strM;
            Object objFirstOrNull;
            Object objInvoke2;
            Playlist playlist;
            MutableState mutableState;
            ArrayList arrayList;
            Iterator it;
            Object objIsLoggedIn;
            Object objM1522withRetryBWLJW6A;
            Object obj2;
            ArrayList arrayList2;
            List listReversed;
            ArrayList arrayList3;
            Iterator it2;
            Set set;
            Object objLibrarySongEntitiesByNameAsc;
            Object obj3;
            Set set2;
            Set setIdsRemovedRemotely;
            List list4;
            Set set3;
            Object obj4;
            Set set4;
            MusicDatabase musicDatabase;
            SyncUtils$executeSyncLibrarySongs$2$2$1$1 syncUtils$executeSyncLibrarySongs$2$2$1$1;
            SyncUtils syncUtils;
            Set set5;
            List list5;
            ArrayList arrayList4;
            Iterator it3;
            Object objM1023newReleaseAlbumsIoAF18A;
            Object obj5;
            NewReleaseViewModel newReleaseViewModel;
            List list6;
            LinkedHashMap linkedHashMap;
            LinkedHashMap linkedHashMap2;
            Object objFirst;
            Throwable thM1866exceptionOrNullimpl;
            byte b = this.$r8$classId;
            byte b2 = 3;
            int i = 0;
            Unit unit = Unit.INSTANCE;
            Object obj6 = this.$block;
            ?? r1 = "call to 'resume' before 'invoke' with coroutine";
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            ?? r2 = 1;
            boolean z = true;
            byte b3 = 2;
            Continuation continuation = null;
            switch (b) {
                case 0:
                    MutatorMutex mutatorMutex3 = (MutatorMutex) this.this$0;
                    ?? r3 = this.label;
                    try {
                        try {
                            if (r3 != 0) {
                                if (r3 == 1) {
                                    MutatorMutex mutatorMutex4 = (MutatorMutex) this.L$3;
                                    Function1 function2 = (Function1) this.L$2;
                                    Mutex mutex2 = (Mutex) this.L$1;
                                    Mutator mutator2 = (Mutator) this.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    function1 = function2;
                                    mutatorMutex = mutatorMutex4;
                                    mutex = mutex2;
                                    mutator = mutator2;
                                } else {
                                    if (r3 != 2) {
                                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                        return null;
                                    }
                                    MutatorMutex mutatorMutex5 = (MutatorMutex) this.L$2;
                                    Mutex mutex3 = (Mutex) this.L$1;
                                    Mutator mutator3 = (Mutator) this.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    objInvoke = obj;
                                    mutatorMutex2 = mutatorMutex5;
                                    r2 = mutex3;
                                    r3 = mutator3;
                                }
                                r1 = mutatorMutex2.currentMutator;
                                while (!r1.compareAndSet(r3, null) && r1.get() == r3) {
                                }
                                r2.unlock(null);
                                return objInvoke;
                            }
                            ResultKt.throwOnFailure(obj);
                            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                            MutatePriority mutatePriority = (MutatePriority) this.$priority;
                            CoroutineContext.Element element = coroutineScope.getCoroutineContext().get(Job.Key.$$INSTANCE);
                            element.getClass();
                            Mutator mutator4 = new Mutator(mutatePriority, (Job) element);
                            mutatorMutex3.tryMutateOrCancel(mutator4);
                            MutexImpl mutexImpl = mutatorMutex3.mutex;
                            function1 = (Function1) obj6;
                            this.L$0 = mutator4;
                            this.L$1 = mutexImpl;
                            this.L$2 = function1;
                            this.L$3 = mutatorMutex3;
                            this.label = (byte) 1;
                            if (mutexImpl.lock(this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            mutex = mutexImpl;
                            mutatorMutex = mutatorMutex3;
                            mutator = mutator4;
                            MutatorMutex mutatorMutex6 = mutatorMutex;
                            this.L$0 = mutator;
                            this.L$1 = mutex;
                            this.L$2 = mutatorMutex6;
                            this.L$3 = null;
                            this.label = (byte) 2;
                            objInvoke = function1.invoke(this);
                            mutatorMutex2 = mutatorMutex6;
                            r2 = mutex;
                            r3 = mutator;
                            if (objInvoke == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            r1 = mutatorMutex2.currentMutator;
                            while (!r1.compareAndSet(r3, null)) {
                            }
                            r2.unlock(null);
                            return objInvoke;
                        } catch (Throwable th) {
                            r2.unlock(null);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        AtomicReference atomicReference = r1.currentMutator;
                        while (!atomicReference.compareAndSet(r3, null) && atomicReference.get() == r3) {
                        }
                        throw th2;
                    }
                case 1:
                    WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 = (WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1) this.this$0;
                    ContentResolver contentResolver = (ContentResolver) this.L$0;
                    byte b4 = this.label;
                    try {
                        if (b4 == 0) {
                            ResultKt.throwOnFailure(obj);
                            flowCollector = (FlowCollector) this.L$2;
                            contentResolver.registerContentObserver((Uri) this.L$3, false, windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1);
                            bufferedChannelIterator2 = ((BufferedChannel) this.$priority).new BufferedChannelIterator();
                            this.L$2 = flowCollector;
                            this.L$1 = bufferedChannelIterator2;
                            this.label = (byte) 1;
                            bufferedChannelIterator3 = (BufferedChannel.BufferedChannelIterator) bufferedChannelIterator2;
                            objHasNext = bufferedChannelIterator3.hasNext(this);
                            if (objHasNext == coroutineSingletons) {
                                flowCollector2 = flowCollector;
                                channelIterator = bufferedChannelIterator3;
                                if (!((Boolean) objHasNext).booleanValue()) {
                                    contentResolver.unregisterContentObserver(windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1);
                                    return unit;
                                }
                                bufferedChannelIterator = (BufferedChannel.BufferedChannelIterator) channelIterator;
                                bufferedChannelIterator.next();
                                MutableScatterMap mutableScatterMap = WindowRecomposer_androidKt.animationScale;
                                Float f = new Float(Settings.Global.getFloat(((Context) obj6).getContentResolver(), "animator_duration_scale", 1.0f));
                                this.L$2 = flowCollector2;
                                this.L$1 = bufferedChannelIterator;
                                this.label = (byte) 2;
                                break;
                            }
                            channelIterator2 = bufferedChannelIterator;
                            return coroutineSingletons;
                        }
                        if (b4 == 1) {
                            channelIterator = (ChannelIterator) this.L$1;
                            flowCollector2 = (FlowCollector) this.L$2;
                            ResultKt.throwOnFailure(obj);
                            objHasNext = obj;
                            if (!((Boolean) objHasNext).booleanValue()) {
                                contentResolver.unregisterContentObserver(windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1);
                                return unit;
                            }
                            bufferedChannelIterator = (BufferedChannel.BufferedChannelIterator) channelIterator;
                            bufferedChannelIterator.next();
                            MutableScatterMap mutableScatterMap2 = WindowRecomposer_androidKt.animationScale;
                            Float f2 = new Float(Settings.Global.getFloat(((Context) obj6).getContentResolver(), "animator_duration_scale", 1.0f));
                            this.L$2 = flowCollector2;
                            this.L$1 = bufferedChannelIterator;
                            this.label = (byte) 2;
                        } else {
                            if (b4 != 2) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            ChannelIterator channelIterator3 = (ChannelIterator) this.L$1;
                            flowCollector2 = (FlowCollector) this.L$2;
                            ResultKt.throwOnFailure(obj);
                            channelIterator2 = channelIterator3;
                        }
                        break;
                        channelIterator2 = bufferedChannelIterator;
                        bufferedChannelIterator2 = channelIterator2;
                        flowCollector = flowCollector2;
                        this.L$2 = flowCollector;
                        this.L$1 = bufferedChannelIterator2;
                        this.label = (byte) 1;
                        bufferedChannelIterator3 = (BufferedChannel.BufferedChannelIterator) bufferedChannelIterator2;
                        objHasNext = bufferedChannelIterator3.hasNext(this);
                        if (objHasNext == coroutineSingletons) {
                            flowCollector2 = flowCollector;
                            channelIterator = bufferedChannelIterator3;
                            if (!((Boolean) objHasNext).booleanValue()) {
                                contentResolver.unregisterContentObserver(windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1);
                                return unit;
                            }
                            bufferedChannelIterator = (BufferedChannel.BufferedChannelIterator) channelIterator;
                            bufferedChannelIterator.next();
                            MutableScatterMap mutableScatterMap3 = WindowRecomposer_androidKt.animationScale;
                            Float f3 = new Float(Settings.Global.getFloat(((Context) obj6).getContentResolver(), "animator_duration_scale", 1.0f));
                            this.L$2 = flowCollector2;
                            this.L$1 = bufferedChannelIterator;
                            this.label = (byte) 2;
                            break;
                        }
                        channelIterator2 = bufferedChannelIterator;
                        return coroutineSingletons;
                    } catch (Throwable th3) {
                        contentResolver.unregisterContentObserver(windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1);
                        throw th3;
                    }
                case 2:
                    InnerTubeExtractor innerTubeExtractor2 = (InnerTubeExtractor) obj6;
                    CoroutineScope coroutineScope2 = (CoroutineScope) this.L$2;
                    byte b5 = this.label;
                    try {
                        if (b5 == 0) {
                            ResultKt.throwOnFailure(obj);
                            deferredCoroutineAsync$default = AwaitKt.async$default(coroutineScope2, null, new SyncUtils.AnonymousClass2(innerTubeExtractor2, continuation, (byte) 20), 3);
                            this.L$2 = null;
                            this.L$1 = deferredCoroutineAsync$default;
                            this.label = (byte) 1;
                            if (unit == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } else {
                            if (b5 != 1) {
                                if (b5 != 2) {
                                    if (b5 != 3) {
                                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                        return null;
                                    }
                                    List list7 = (List) this.$priority;
                                    list3 = (List) this.L$3;
                                    innerTubeExtractor = (InnerTubeExtractor) this.L$0;
                                    try {
                                        ResultKt.throwOnFailure(obj);
                                        list = list7;
                                        objPrewarm$fetchConfig = obj;
                                        list.add(objPrewarm$fetchConfig);
                                        break;
                                    } catch (Exception e) {
                                        e = e;
                                        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0 = innerTubeExtractor.logger;
                                        strM = Format$$ExternalSyntheticOutline0.m(e);
                                        if (strM == null) {
                                            strM = "unknown";
                                        }
                                        Map mapSingletonMap = Collections.singletonMap("exceptionType", strM);
                                        mapSingletonMap.getClass();
                                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTubeExtractor", "authenticated player config prewarm failed", mapSingletonMap, 4);
                                    }
                                    list2 = list3;
                                    return CollectionsKt__IterablesKt.build(list2);
                                }
                                List list8 = (List) this.$priority;
                                ListBuilder listBuilder = (ListBuilder) this.this$0;
                                List list9 = (List) this.L$3;
                                innerTubeExtractor2 = (InnerTubeExtractor) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                list2 = list9;
                                list = listBuilder;
                                listCreateListBuilder = list8;
                                objAwait = obj;
                                listCreateListBuilder.add(objAwait);
                                if (innerTubeExtractor2.innerTube.hasSapCookieAuth()) {
                                    try {
                                        this.L$2 = null;
                                        this.L$1 = null;
                                        this.L$0 = innerTubeExtractor2;
                                        this.L$3 = list2;
                                        this.this$0 = null;
                                        this.$priority = list;
                                        this.label = (byte) 3;
                                        objPrewarm$fetchConfig = InnerTubeExtractor.prewarm$fetchConfig(innerTubeExtractor2, true, this);
                                        if (objPrewarm$fetchConfig == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                        list3 = list2;
                                        innerTubeExtractor = innerTubeExtractor2;
                                        list.add(objPrewarm$fetchConfig);
                                        list2 = list3;
                                    } catch (Exception e2) {
                                        e = e2;
                                        list3 = list2;
                                        innerTubeExtractor = innerTubeExtractor2;
                                        PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline1 = innerTubeExtractor.logger;
                                        strM = Format$$ExternalSyntheticOutline0.m(e);
                                        if (strM == null) {
                                            strM = "unknown";
                                        }
                                        Map mapSingletonMap2 = Collections.singletonMap("exceptionType", strM);
                                        mapSingletonMap2.getClass();
                                        EntryPoints.w$default(pathKt$$ExternalSyntheticBUOutline1, "InnerTubeExtractor", "authenticated player config prewarm failed", mapSingletonMap2, 4);
                                    }
                                }
                                return CollectionsKt__IterablesKt.build(list2);
                            }
                            deferredCoroutineAsync$default = (DeferredCoroutine) this.L$1;
                            ResultKt.throwOnFailure(obj);
                        }
                        listCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                        this.L$2 = null;
                        this.L$1 = null;
                        this.L$0 = innerTubeExtractor2;
                        this.L$3 = listCreateListBuilder;
                        this.this$0 = listCreateListBuilder;
                        this.$priority = listCreateListBuilder;
                        this.label = (byte) 2;
                        objAwait = deferredCoroutineAsync$default.await(this);
                        if (objAwait == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        list = listCreateListBuilder;
                        list2 = list;
                        listCreateListBuilder.add(objAwait);
                        if (innerTubeExtractor2.innerTube.hasSapCookieAuth()) {
                            this.L$2 = null;
                            this.L$1 = null;
                            this.L$0 = innerTubeExtractor2;
                            this.L$3 = list2;
                            this.this$0 = null;
                            this.$priority = list;
                            this.label = (byte) 3;
                            objPrewarm$fetchConfig = InnerTubeExtractor.prewarm$fetchConfig(innerTubeExtractor2, true, this);
                            if (objPrewarm$fetchConfig == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            list3 = list2;
                            innerTubeExtractor = innerTubeExtractor2;
                            list.add(objPrewarm$fetchConfig);
                            list2 = list3;
                        }
                        return CollectionsKt__IterablesKt.build(list2);
                    } catch (CancellationException e3) {
                        throw e3;
                    }
                case 3:
                    byte b6 = this.label;
                    if (b6 == 0) {
                        ResultKt.throwOnFailure(obj);
                        MusicDatabase musicDatabase2 = (MusicDatabase) this.L$3;
                        AddToPlaylistPosition addToPlaylistPosition = (AddToPlaylistPosition) this.this$0;
                        SyncUtils syncUtils2 = (SyncUtils) this.$priority;
                        Playlist playlist2 = (Playlist) ((MutableState) this.L$1).getValue();
                        playlist2.getClass();
                        List list10 = (List) ((MutableState) this.L$2).getValue();
                        list10.getClass();
                        MutableState mutableState2 = (MutableState) this.L$0;
                        ArrayList arrayList5 = new ArrayList();
                        for (Object obj7 : list10) {
                            if (!((List) mutableState2.getValue()).contains((String) obj7)) {
                                arrayList5.add(obj7);
                            }
                        }
                        this.label = (byte) 1;
                        if (AlbumMenuKt.AddToPlaylistDialog$addSongsAndSync(musicDatabase2, addToPlaylistPosition, syncUtils2, playlist2, arrayList5, this) != coroutineSingletons) {
                        }
                        return coroutineSingletons;
                    }
                    if (b6 != 1) {
                        if (b6 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    HandlerContext handlerContext = MainDispatcherLoader.dispatcher;
                    AddToPlaylistDialogKt$AddToPlaylistDialog$6$1$1$1$2 addToPlaylistDialogKt$AddToPlaylistDialog$6$1$1$1$2 = new AddToPlaylistDialogKt$AddToPlaylistDialog$6$1$1$1$2((Function0) obj6, continuation, (byte) 0);
                    this.label = (byte) 2;
                    if (AwaitKt.withContext(handlerContext, addToPlaylistDialogKt$AddToPlaylistDialog$6$1$1$1$2, this) != coroutineSingletons) {
                        return unit;
                    }
                    return coroutineSingletons;
                case 4:
                    MusicDatabase musicDatabase3 = (MusicDatabase) this.L$0;
                    MutableState mutableState3 = (MutableState) this.$priority;
                    byte b7 = this.label;
                    if (b7 == 0) {
                        ResultKt.throwOnFailure(obj);
                        Flow flowPlaylist = musicDatabase3.playlist(((PlaylistEntity) this.L$3).id);
                        this.label = (byte) 1;
                        objFirstOrNull = StateFlowKt.firstOrNull(flowPlaylist, this);
                        if (objFirstOrNull != coroutineSingletons) {
                        }
                        return coroutineSingletons;
                    }
                    if (b7 != 1) {
                        if (b7 == 2) {
                            MutableState mutableState4 = (MutableState) this.L$2;
                            Playlist playlist3 = (Playlist) this.L$1;
                            ResultKt.throwOnFailure(obj);
                            playlist = playlist3;
                            mutableState = mutableState4;
                            objInvoke2 = obj;
                            mutableState.setValue((List) objInvoke2);
                            List list11 = (List) mutableState3.getValue();
                            list11.getClass();
                            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list11, 10));
                            it = list11.iterator();
                            while (it.hasNext()) {
                                arrayList.add(new Pair((String) it.next(), null));
                            }
                            this.L$1 = null;
                            this.L$2 = null;
                            this.label = (byte) 3;
                        } else {
                            if (b7 != 3) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        break;
                    } else {
                        ResultKt.throwOnFailure(obj);
                        objFirstOrNull = obj;
                    }
                    ((Function0) this.this$0).invoke();
                    return unit;
                    Playlist playlist4 = (Playlist) objFirstOrNull;
                    if (playlist4 != null) {
                        this.L$1 = playlist4;
                        this.L$2 = mutableState3;
                        this.label = (byte) 2;
                        objInvoke2 = ((Function1) obj6).invoke(this);
                        if (objInvoke2 != coroutineSingletons) {
                            playlist = playlist4;
                            mutableState = mutableState3;
                            mutableState.setValue((List) objInvoke2);
                            List list12 = (List) mutableState3.getValue();
                            list12.getClass();
                            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list12, 10));
                            it = list12.iterator();
                            while (it.hasNext()) {
                                arrayList.add(new Pair((String) it.next(), null));
                            }
                            this.L$1 = null;
                            this.L$2 = null;
                            this.label = (byte) 3;
                            break;
                        }
                        return coroutineSingletons;
                    }
                    ((Function0) this.this$0).invoke();
                    return unit;
                case 5:
                    SyncUtils syncUtils3 = (SyncUtils) obj6;
                    byte b8 = this.label;
                    if (b8 == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = (byte) 1;
                        int i2 = SyncUtils.$r8$clinit;
                        objIsLoggedIn = syncUtils3.isLoggedIn(this);
                        if (objIsLoggedIn != coroutineSingletons) {
                        }
                        return coroutineSingletons;
                    }
                    if (b8 == 1) {
                        ResultKt.throwOnFailure(obj);
                        objIsLoggedIn = obj;
                    } else {
                        if (b8 == 2) {
                            ResultKt.throwOnFailure(obj);
                            objM1522withRetryBWLJW6A = ((Result) obj).value;
                            if (!(objM1522withRetryBWLJW6A instanceof Result.Failure)) {
                                obj2 = ((Result) objM1522withRetryBWLJW6A).value;
                                if (!(obj2 instanceof Result.Failure)) {
                                    try {
                                        List list13 = ((LibraryPage) obj2).items;
                                        arrayList2 = new ArrayList();
                                        for (Object obj8 : list13) {
                                            if (obj8 instanceof SongItem) {
                                                arrayList2.add(obj8);
                                            }
                                        }
                                        listReversed = CollectionsKt.reversed(arrayList2);
                                        arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listReversed, 10));
                                        it2 = listReversed.iterator();
                                        while (it2.hasNext()) {
                                            arrayList3.add(((SongItem) it2.next()).id);
                                        }
                                        set = CollectionsKt.toSet(arrayList3);
                                        if (set.isEmpty()) {
                                            setIdsRemovedRemotely = EmptySet.INSTANCE;
                                            list4 = listReversed;
                                            set3 = set;
                                            set4 = setIdsRemovedRemotely;
                                            int i3 = SyncUtils.$r8$clinit;
                                            Set setFindSongIdsWithoutArtists = syncUtils3.findSongIdsWithoutArtists(set3);
                                            LocalDateTime localDateTimeNow = LocalDateTime.now();
                                            musicDatabase = syncUtils3.database;
                                            syncUtils$executeSyncLibrarySongs$2$2$1$1 = new SyncUtils$executeSyncLibrarySongs$2$2$1$1(set4, list4, localDateTimeNow, setFindSongIdsWithoutArtists, null);
                                            this.L$2 = objM1522withRetryBWLJW6A;
                                            this.L$1 = syncUtils3;
                                            this.L$0 = obj2;
                                            this.L$3 = set3;
                                            this.this$0 = set4;
                                            this.$priority = list4;
                                            this.label = (byte) 4;
                                            if (musicDatabase.withTransaction(syncUtils$executeSyncLibrarySongs$2$2$1$1, this) != coroutineSingletons) {
                                                syncUtils = syncUtils3;
                                                obj4 = objM1522withRetryBWLJW6A;
                                                set5 = set4;
                                                list5 = list4;
                                                if (!set3.isEmpty()) {
                                                    int i4 = SyncUtils.$r8$clinit;
                                                    syncUtils.writeSyncSnapshot("sync_snapshot_library_songs", set3);
                                                }
                                                ConnectionPool connectionPool = Timber.Forest;
                                                list5.size();
                                                set5.size();
                                                connectionPool.getClass();
                                                ConnectionPool.d(new Object[0]);
                                                objM1522withRetryBWLJW6A = obj4;
                                                if (Result.m1866exceptionOrNullimpl(obj2) != null) {
                                                    Timber.Forest.getClass();
                                                    ConnectionPool.e$1(new Object[0]);
                                                }
                                            }
                                        } else {
                                            MusicDatabase musicDatabase4 = syncUtils3.database;
                                            this.L$2 = objM1522withRetryBWLJW6A;
                                            this.L$1 = syncUtils3;
                                            this.L$0 = obj2;
                                            this.L$3 = set;
                                            this.this$0 = listReversed;
                                            this.label = (byte) 3;
                                            objLibrarySongEntitiesByNameAsc = musicDatabase4.$$delegate_0.librarySongEntitiesByNameAsc(this);
                                            if (objLibrarySongEntitiesByNameAsc != coroutineSingletons) {
                                                obj3 = objM1522withRetryBWLJW6A;
                                                set2 = set;
                                                Iterable iterable = (Iterable) objLibrarySongEntitiesByNameAsc;
                                                arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                                                it3 = iterable.iterator();
                                                while (it3.hasNext()) {
                                                    arrayList4.add(((SongEntity) it3.next()).id);
                                                }
                                                int i5 = SyncUtils.$r8$clinit;
                                                setIdsRemovedRemotely = UtilsKt.idsRemovedRemotely(arrayList4, syncUtils3.readSyncSnapshot("sync_snapshot_library_songs"), set2);
                                                list4 = listReversed;
                                                set3 = set2;
                                                objM1522withRetryBWLJW6A = obj3;
                                                set4 = setIdsRemovedRemotely;
                                                int i6 = SyncUtils.$r8$clinit;
                                                Set setFindSongIdsWithoutArtists2 = syncUtils3.findSongIdsWithoutArtists(set3);
                                                LocalDateTime localDateTimeNow2 = LocalDateTime.now();
                                                musicDatabase = syncUtils3.database;
                                                syncUtils$executeSyncLibrarySongs$2$2$1$1 = new SyncUtils$executeSyncLibrarySongs$2$2$1$1(set4, list4, localDateTimeNow2, setFindSongIdsWithoutArtists2, null);
                                                this.L$2 = objM1522withRetryBWLJW6A;
                                                this.L$1 = syncUtils3;
                                                this.L$0 = obj2;
                                                this.L$3 = set3;
                                                this.this$0 = set4;
                                                this.$priority = list4;
                                                this.label = (byte) 4;
                                                if (musicDatabase.withTransaction(syncUtils$executeSyncLibrarySongs$2$2$1$1, this) != coroutineSingletons) {
                                                    syncUtils = syncUtils3;
                                                    obj4 = objM1522withRetryBWLJW6A;
                                                    set5 = set4;
                                                    list5 = list4;
                                                    if (!set3.isEmpty()) {
                                                        int i7 = SyncUtils.$r8$clinit;
                                                        syncUtils.writeSyncSnapshot("sync_snapshot_library_songs", set3);
                                                    }
                                                    ConnectionPool connectionPool2 = Timber.Forest;
                                                    list5.size();
                                                    set5.size();
                                                    connectionPool2.getClass();
                                                    ConnectionPool.d(new Object[0]);
                                                    objM1522withRetryBWLJW6A = obj4;
                                                    if (Result.m1866exceptionOrNullimpl(obj2) != null) {
                                                        Timber.Forest.getClass();
                                                        ConnectionPool.e$1(new Object[0]);
                                                    }
                                                }
                                            }
                                        }
                                        return coroutineSingletons;
                                    } catch (Exception unused) {
                                        obj4 = objM1522withRetryBWLJW6A;
                                        Timber.Forest.getClass();
                                        ConnectionPool.e$1(new Object[0]);
                                    }
                                } else if (Result.m1866exceptionOrNullimpl(obj2) != null) {
                                    Timber.Forest.getClass();
                                    ConnectionPool.e$1(new Object[0]);
                                }
                            }
                            if (Result.m1866exceptionOrNullimpl(objM1522withRetryBWLJW6A) != null) {
                                return unit;
                            }
                            Timber.Forest.getClass();
                            ConnectionPool.e$1(new Object[0]);
                            return unit;
                        }
                        if (b8 != 3) {
                            if (b8 != 4) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            list5 = (List) this.$priority;
                            set5 = (Set) ((Collection) this.this$0);
                            set3 = (Set) this.L$3;
                            obj2 = this.L$0;
                            syncUtils = (SyncUtils) this.L$1;
                            obj4 = this.L$2;
                            try {
                                ResultKt.throwOnFailure(obj);
                                if (!set3.isEmpty()) {
                                    int i8 = SyncUtils.$r8$clinit;
                                    syncUtils.writeSyncSnapshot("sync_snapshot_library_songs", set3);
                                }
                                ConnectionPool connectionPool3 = Timber.Forest;
                                list5.size();
                                set5.size();
                                connectionPool3.getClass();
                                ConnectionPool.d(new Object[0]);
                                break;
                            } catch (Exception unused2) {
                                Timber.Forest.getClass();
                                ConnectionPool.e$1(new Object[0]);
                            }
                            objM1522withRetryBWLJW6A = obj4;
                            if (Result.m1866exceptionOrNullimpl(obj2) != null) {
                                Timber.Forest.getClass();
                                ConnectionPool.e$1(new Object[0]);
                            }
                            if (Result.m1866exceptionOrNullimpl(objM1522withRetryBWLJW6A) != null) {
                                return unit;
                            }
                            Timber.Forest.getClass();
                            ConnectionPool.e$1(new Object[0]);
                            return unit;
                        }
                        List list14 = (List) ((Collection) this.this$0);
                        set2 = (Set) this.L$3;
                        obj2 = this.L$0;
                        SyncUtils syncUtils4 = (SyncUtils) this.L$1;
                        obj3 = this.L$2;
                        try {
                            ResultKt.throwOnFailure(obj);
                            listReversed = list14;
                            syncUtils3 = syncUtils4;
                            objLibrarySongEntitiesByNameAsc = obj;
                            Iterable iterable2 = (Iterable) objLibrarySongEntitiesByNameAsc;
                            arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
                            it3 = iterable2.iterator();
                            while (it3.hasNext()) {
                                arrayList4.add(((SongEntity) it3.next()).id);
                            }
                            int i9 = SyncUtils.$r8$clinit;
                            setIdsRemovedRemotely = UtilsKt.idsRemovedRemotely(arrayList4, syncUtils3.readSyncSnapshot("sync_snapshot_library_songs"), set2);
                            list4 = listReversed;
                            set3 = set2;
                            objM1522withRetryBWLJW6A = obj3;
                            set4 = setIdsRemovedRemotely;
                            int i10 = SyncUtils.$r8$clinit;
                            Set setFindSongIdsWithoutArtists3 = syncUtils3.findSongIdsWithoutArtists(set3);
                            LocalDateTime localDateTimeNow3 = LocalDateTime.now();
                            musicDatabase = syncUtils3.database;
                            syncUtils$executeSyncLibrarySongs$2$2$1$1 = new SyncUtils$executeSyncLibrarySongs$2$2$1$1(set4, list4, localDateTimeNow3, setFindSongIdsWithoutArtists3, null);
                            this.L$2 = objM1522withRetryBWLJW6A;
                            this.L$1 = syncUtils3;
                            this.L$0 = obj2;
                            this.L$3 = set3;
                            this.this$0 = set4;
                            this.$priority = list4;
                            this.label = (byte) 4;
                            if (musicDatabase.withTransaction(syncUtils$executeSyncLibrarySongs$2$2$1$1, this) != coroutineSingletons) {
                                syncUtils = syncUtils3;
                                obj4 = objM1522withRetryBWLJW6A;
                                set5 = set4;
                                list5 = list4;
                                if (!set3.isEmpty()) {
                                    int i11 = SyncUtils.$r8$clinit;
                                    syncUtils.writeSyncSnapshot("sync_snapshot_library_songs", set3);
                                }
                                ConnectionPool connectionPool4 = Timber.Forest;
                                list5.size();
                                set5.size();
                                connectionPool4.getClass();
                                ConnectionPool.d(new Object[0]);
                                objM1522withRetryBWLJW6A = obj4;
                                if (Result.m1866exceptionOrNullimpl(obj2) != null) {
                                    Timber.Forest.getClass();
                                    ConnectionPool.e$1(new Object[0]);
                                }
                                if (Result.m1866exceptionOrNullimpl(objM1522withRetryBWLJW6A) != null) {
                                    return unit;
                                }
                                Timber.Forest.getClass();
                                ConnectionPool.e$1(new Object[0]);
                                return unit;
                            }
                            return coroutineSingletons;
                        } catch (Exception unused3) {
                            obj4 = obj3;
                            Timber.Forest.getClass();
                            ConnectionPool.e$1(new Object[0]);
                        }
                    }
                    if (!((Boolean) objIsLoggedIn).booleanValue()) {
                        Timber.Forest.getClass();
                        ConnectionPool.w(new Object[0]);
                        return unit;
                    }
                    SyncUtils$executeSyncLikedSongs$2$1 syncUtils$executeSyncLikedSongs$2$1 = new SyncUtils$executeSyncLikedSongs$2$1(z ? 1 : 0, continuation, b3);
                    this.label = (byte) 2;
                    int i12 = SyncUtils.$r8$clinit;
                    objM1522withRetryBWLJW6A = syncUtils3.m1522withRetryBWLJW6A(3, 1000L, syncUtils$executeSyncLikedSongs$2$1, this);
                    if (objM1522withRetryBWLJW6A != coroutineSingletons) {
                        if (!(objM1522withRetryBWLJW6A instanceof Result.Failure)) {
                            obj2 = ((Result) objM1522withRetryBWLJW6A).value;
                            if (!(obj2 instanceof Result.Failure)) {
                                List list15 = ((LibraryPage) obj2).items;
                                arrayList2 = new ArrayList();
                                while (r2.hasNext()) {
                                    if (obj8 instanceof SongItem) {
                                        arrayList2.add(obj8);
                                    }
                                }
                                listReversed = CollectionsKt.reversed(arrayList2);
                                arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listReversed, 10));
                                it2 = listReversed.iterator();
                                while (it2.hasNext()) {
                                    arrayList3.add(((SongItem) it2.next()).id);
                                }
                                set = CollectionsKt.toSet(arrayList3);
                                if (set.isEmpty()) {
                                    setIdsRemovedRemotely = EmptySet.INSTANCE;
                                    list4 = listReversed;
                                    set3 = set;
                                    set4 = setIdsRemovedRemotely;
                                    int i13 = SyncUtils.$r8$clinit;
                                    Set setFindSongIdsWithoutArtists4 = syncUtils3.findSongIdsWithoutArtists(set3);
                                    LocalDateTime localDateTimeNow4 = LocalDateTime.now();
                                    musicDatabase = syncUtils3.database;
                                    syncUtils$executeSyncLibrarySongs$2$2$1$1 = new SyncUtils$executeSyncLibrarySongs$2$2$1$1(set4, list4, localDateTimeNow4, setFindSongIdsWithoutArtists4, null);
                                    this.L$2 = objM1522withRetryBWLJW6A;
                                    this.L$1 = syncUtils3;
                                    this.L$0 = obj2;
                                    this.L$3 = set3;
                                    this.this$0 = set4;
                                    this.$priority = list4;
                                    this.label = (byte) 4;
                                    if (musicDatabase.withTransaction(syncUtils$executeSyncLibrarySongs$2$2$1$1, this) != coroutineSingletons) {
                                        syncUtils = syncUtils3;
                                        obj4 = objM1522withRetryBWLJW6A;
                                        set5 = set4;
                                        list5 = list4;
                                        if (!set3.isEmpty()) {
                                            int i14 = SyncUtils.$r8$clinit;
                                            syncUtils.writeSyncSnapshot("sync_snapshot_library_songs", set3);
                                        }
                                        ConnectionPool connectionPool5 = Timber.Forest;
                                        list5.size();
                                        set5.size();
                                        connectionPool5.getClass();
                                        ConnectionPool.d(new Object[0]);
                                        objM1522withRetryBWLJW6A = obj4;
                                        if (Result.m1866exceptionOrNullimpl(obj2) != null) {
                                            Timber.Forest.getClass();
                                            ConnectionPool.e$1(new Object[0]);
                                        }
                                    }
                                } else {
                                    MusicDatabase musicDatabase5 = syncUtils3.database;
                                    this.L$2 = objM1522withRetryBWLJW6A;
                                    this.L$1 = syncUtils3;
                                    this.L$0 = obj2;
                                    this.L$3 = set;
                                    this.this$0 = listReversed;
                                    this.label = (byte) 3;
                                    objLibrarySongEntitiesByNameAsc = musicDatabase5.$$delegate_0.librarySongEntitiesByNameAsc(this);
                                    if (objLibrarySongEntitiesByNameAsc != coroutineSingletons) {
                                        obj3 = objM1522withRetryBWLJW6A;
                                        set2 = set;
                                        Iterable iterable3 = (Iterable) objLibrarySongEntitiesByNameAsc;
                                        arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable3, 10));
                                        it3 = iterable3.iterator();
                                        while (it3.hasNext()) {
                                            arrayList4.add(((SongEntity) it3.next()).id);
                                        }
                                        int i15 = SyncUtils.$r8$clinit;
                                        setIdsRemovedRemotely = UtilsKt.idsRemovedRemotely(arrayList4, syncUtils3.readSyncSnapshot("sync_snapshot_library_songs"), set2);
                                        list4 = listReversed;
                                        set3 = set2;
                                        objM1522withRetryBWLJW6A = obj3;
                                        set4 = setIdsRemovedRemotely;
                                        int i16 = SyncUtils.$r8$clinit;
                                        Set setFindSongIdsWithoutArtists5 = syncUtils3.findSongIdsWithoutArtists(set3);
                                        LocalDateTime localDateTimeNow5 = LocalDateTime.now();
                                        musicDatabase = syncUtils3.database;
                                        syncUtils$executeSyncLibrarySongs$2$2$1$1 = new SyncUtils$executeSyncLibrarySongs$2$2$1$1(set4, list4, localDateTimeNow5, setFindSongIdsWithoutArtists5, null);
                                        this.L$2 = objM1522withRetryBWLJW6A;
                                        this.L$1 = syncUtils3;
                                        this.L$0 = obj2;
                                        this.L$3 = set3;
                                        this.this$0 = set4;
                                        this.$priority = list4;
                                        this.label = (byte) 4;
                                        if (musicDatabase.withTransaction(syncUtils$executeSyncLibrarySongs$2$2$1$1, this) != coroutineSingletons) {
                                            syncUtils = syncUtils3;
                                            obj4 = objM1522withRetryBWLJW6A;
                                            set5 = set4;
                                            list5 = list4;
                                            if (!set3.isEmpty()) {
                                                int i17 = SyncUtils.$r8$clinit;
                                                syncUtils.writeSyncSnapshot("sync_snapshot_library_songs", set3);
                                            }
                                            ConnectionPool connectionPool6 = Timber.Forest;
                                            list5.size();
                                            set5.size();
                                            connectionPool6.getClass();
                                            ConnectionPool.d(new Object[0]);
                                            objM1522withRetryBWLJW6A = obj4;
                                            if (Result.m1866exceptionOrNullimpl(obj2) != null) {
                                                Timber.Forest.getClass();
                                                ConnectionPool.e$1(new Object[0]);
                                            }
                                        }
                                    }
                                }
                            } else if (Result.m1866exceptionOrNullimpl(obj2) != null) {
                                Timber.Forest.getClass();
                                ConnectionPool.e$1(new Object[0]);
                            }
                        }
                        if (Result.m1866exceptionOrNullimpl(objM1522withRetryBWLJW6A) != null) {
                            return unit;
                        }
                        Timber.Forest.getClass();
                        ConnectionPool.e$1(new Object[0]);
                        return unit;
                    }
                    return coroutineSingletons;
                default:
                    byte b9 = this.label;
                    if (b9 == 0) {
                        ResultKt.throwOnFailure(obj);
                        YouTube youTube = YouTube.INSTANCE;
                        this.label = (byte) 1;
                        objM1023newReleaseAlbumsIoAF18A = youTube.m1023newReleaseAlbumsIoAF18A(this);
                        if (objM1023newReleaseAlbumsIoAF18A != coroutineSingletons) {
                        }
                        return coroutineSingletons;
                    }
                    if (b9 == 1) {
                        ResultKt.throwOnFailure(obj);
                        objM1023newReleaseAlbumsIoAF18A = ((Result) obj).value;
                    } else {
                        if (b9 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        LinkedHashMap linkedHashMap3 = (LinkedHashMap) this.this$0;
                        linkedHashMap = (LinkedHashMap) this.L$3;
                        list6 = (List) this.L$0;
                        newReleaseViewModel = (NewReleaseViewModel) this.L$1;
                        obj5 = this.L$2;
                        ResultKt.throwOnFailure(obj);
                        linkedHashMap2 = linkedHashMap3;
                        objFirst = obj;
                    }
                    int i18 = 0;
                    for (Artist artist : (List) objFirst) {
                        int i19 = i + 1;
                        Integer num = new Integer(i);
                        ArtistEntity artistEntity = artist.artist;
                        linkedHashMap.put(num, artistEntity.id);
                        if (artistEntity.bookmarkedAt != null) {
                            linkedHashMap2.put(new Integer(i18), artistEntity.id);
                            i18++;
                        }
                        i = i19;
                    }
                    StateFlowImpl stateFlowImpl = newReleaseViewModel._newReleaseAlbums;
                    List listFilterExplicit = HexFormatKt.filterExplicit(CollectionsKt.sortedWith(list6, new LrcLib$getAllLyrics$$inlined$sortedByDescending$1(linkedHashMap2, linkedHashMap, b2)), ((Boolean) UtilsKt.get(UtilsKt.getDataStore(newReleaseViewModel.context), PreferenceKeysKt.HideExplicitKey, Boolean.FALSE)).booleanValue());
                    stateFlowImpl.getClass();
                    stateFlowImpl.updateState(null, listFilterExplicit);
                    thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj5);
                    if (thM1866exceptionOrNullimpl != null) {
                        return unit;
                    }
                    thM1866exceptionOrNullimpl.printStackTrace();
                    return unit;
                    obj5 = objM1023newReleaseAlbumsIoAF18A;
                    MusicDatabase musicDatabase6 = (MusicDatabase) this.$priority;
                    newReleaseViewModel = (NewReleaseViewModel) obj6;
                    if (!(obj5 instanceof Result.Failure)) {
                        list6 = (List) obj5;
                        linkedHashMap = new LinkedHashMap();
                        linkedHashMap2 = new LinkedHashMap();
                        Flow flowAllArtistsByPlayTime = musicDatabase6.$$delegate_0.allArtistsByPlayTime();
                        this.L$2 = obj5;
                        this.L$1 = newReleaseViewModel;
                        this.L$0 = list6;
                        this.L$3 = linkedHashMap;
                        this.this$0 = linkedHashMap2;
                        this.label = (byte) 2;
                        objFirst = StateFlowKt.first(flowAllArtistsByPlayTime, this);
                        break;
                    }
                    thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj5);
                    if (thM1866exceptionOrNullimpl != null) {
                        return unit;
                    }
                    thM1866exceptionOrNullimpl.printStackTrace();
                    return unit;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MutatePriority mutatePriority, MutatorMutex mutatorMutex, Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = (byte) 0;
            this.$priority = mutatePriority;
            this.this$0 = mutatorMutex;
            this.$block = function1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ContentResolver contentResolver, Uri uri, WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1, BufferedChannel bufferedChannel, Context context, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = (byte) 1;
            this.L$0 = contentResolver;
            this.L$3 = uri;
            this.this$0 = windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1;
            this.$priority = bufferedChannel;
            this.$block = context;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MusicDatabase musicDatabase, PlaylistEntity playlistEntity, Function1 function1, Function0 function0, MutableState mutableState, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = (byte) 4;
            this.L$0 = musicDatabase;
            this.L$3 = playlistEntity;
            this.$block = function1;
            this.this$0 = function0;
            this.$priority = mutableState;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MusicDatabase musicDatabase, NewReleaseViewModel newReleaseViewModel, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = (byte) 6;
            this.$priority = musicDatabase;
            this.$block = newReleaseViewModel;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(Object obj, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$block = obj;
        }
    }
}
