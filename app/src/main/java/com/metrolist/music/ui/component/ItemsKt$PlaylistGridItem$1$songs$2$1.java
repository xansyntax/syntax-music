package com.metrolist.music.ui.component;

import androidx.compose.runtime.ProduceStateScopeImpl;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistSong;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ItemsKt$PlaylistGridItem$1$songs$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ Playlist $playlist;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ Object L$0;
    public boolean label;

    /* JADX INFO: renamed from: com.metrolist.music.ui.component.ItemsKt$PlaylistGridItem$1$songs$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ ProduceStateScopeImpl $$this$produceState;
        public final /* synthetic */ MusicDatabase $database;
        public final /* synthetic */ Playlist $playlist;
        public final /* synthetic */ byte $r8$classId;
        public ProduceStateScopeImpl L$0;
        public boolean label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(ProduceStateScopeImpl produceStateScopeImpl, MusicDatabase musicDatabase, Playlist playlist, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$$this$produceState = produceStateScopeImpl;
            this.$database = musicDatabase;
            this.$playlist = playlist;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    return new AnonymousClass1(this.$$this$produceState, this.$database, this.$playlist, continuation, (byte) 0);
                default:
                    return new AnonymousClass1(this.$$this$produceState, this.$database, this.$playlist, continuation, (byte) 1);
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            Playlist playlist = this.$playlist;
            MusicDatabase musicDatabase = this.$database;
            ProduceStateScopeImpl produceStateScopeImpl = this.$$this$produceState;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            switch (b) {
                case 0:
                    boolean z = this.label;
                    if (!z) {
                        ResultKt.throwOnFailure(obj);
                        Flow flowPlaylistSongs = musicDatabase.playlistSongs(playlist.playlist.id);
                        this.L$0 = produceStateScopeImpl;
                        this.label = true;
                        obj = StateFlowKt.first(flowPlaylistSongs, this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        produceStateScopeImpl = this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    Iterable iterable = (Iterable) obj;
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((PlaylistSong) it.next()).song);
                    }
                    produceStateScopeImpl.setValue(arrayList);
                    return unit;
                default:
                    boolean z2 = this.label;
                    if (!z2) {
                        ResultKt.throwOnFailure(obj);
                        Flow flowPlaylistSongs2 = musicDatabase.playlistSongs(playlist.playlist.id);
                        this.L$0 = produceStateScopeImpl;
                        this.label = true;
                        obj = StateFlowKt.first(flowPlaylistSongs2, this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        produceStateScopeImpl = this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    Iterable iterable2 = (Iterable) obj;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
                    Iterator it2 = iterable2.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(((PlaylistSong) it2.next()).song);
                    }
                    produceStateScopeImpl.setValue(arrayList2);
                    return unit;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ItemsKt$PlaylistGridItem$1$songs$2$1(MusicDatabase musicDatabase, Playlist playlist, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$database = musicDatabase;
        this.$playlist = playlist;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                ItemsKt$PlaylistGridItem$1$songs$2$1 itemsKt$PlaylistGridItem$1$songs$2$1 = new ItemsKt$PlaylistGridItem$1$songs$2$1(this.$database, this.$playlist, continuation, (byte) 0);
                itemsKt$PlaylistGridItem$1$songs$2$1.L$0 = obj;
                return itemsKt$PlaylistGridItem$1$songs$2$1;
            default:
                ItemsKt$PlaylistGridItem$1$songs$2$1 itemsKt$PlaylistGridItem$1$songs$2$2 = new ItemsKt$PlaylistGridItem$1$songs$2$1(this.$database, this.$playlist, continuation, (byte) 1);
                itemsKt$PlaylistGridItem$1$songs$2$2.L$0 = obj;
                return itemsKt$PlaylistGridItem$1$songs$2$2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ProduceStateScopeImpl produceStateScopeImpl = (ProduceStateScopeImpl) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
        }
        return ((ItemsKt$PlaylistGridItem$1$songs$2$1) create(produceStateScopeImpl, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                ProduceStateScopeImpl produceStateScopeImpl = (ProduceStateScopeImpl) this.L$0;
                boolean z = this.label;
                if (z) {
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(produceStateScopeImpl, this.$database, this.$playlist, null, (byte) 0);
                this.L$0 = null;
                this.label = true;
                return AwaitKt.withContext(defaultIoScheduler, anonymousClass1, this) == coroutineSingletons ? coroutineSingletons : unit;
            default:
                ProduceStateScopeImpl produceStateScopeImpl2 = (ProduceStateScopeImpl) this.L$0;
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                DefaultIoScheduler defaultIoScheduler2 = DefaultIoScheduler.INSTANCE;
                AnonymousClass1 anonymousClass2 = new AnonymousClass1(produceStateScopeImpl2, this.$database, this.$playlist, null, (byte) 1);
                this.L$0 = null;
                this.label = true;
                return AwaitKt.withContext(defaultIoScheduler2, anonymousClass2, this) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }
}
