package com.metrolist.music.ui.component;

import androidx.compose.runtime.ProduceStateScopeImpl;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import kotlin.ResultKt;
import kotlin.Unit;
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
public final class ItemsKt$AlbumGridItem$1$songs$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Album $album;
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ Object L$0;
    public boolean label;

    /* JADX INFO: renamed from: com.metrolist.music.ui.component.ItemsKt$AlbumGridItem$1$songs$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ ProduceStateScopeImpl $$this$produceState;
        public final /* synthetic */ Album $album;
        public final /* synthetic */ MusicDatabase $database;
        public final /* synthetic */ byte $r8$classId;
        public ProduceStateScopeImpl L$0;
        public boolean label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(ProduceStateScopeImpl produceStateScopeImpl, MusicDatabase musicDatabase, Album album, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$$this$produceState = produceStateScopeImpl;
            this.$database = musicDatabase;
            this.$album = album;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    return new AnonymousClass1(this.$$this$produceState, this.$database, this.$album, continuation, (byte) 0);
                default:
                    return new AnonymousClass1(this.$$this$produceState, this.$database, this.$album, continuation, (byte) 1);
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
            Album album = this.$album;
            MusicDatabase musicDatabase = this.$database;
            ProduceStateScopeImpl produceStateScopeImpl = this.$$this$produceState;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            switch (b) {
                case 0:
                    boolean z = this.label;
                    if (!z) {
                        ResultKt.throwOnFailure(obj);
                        Flow flowAlbumSongs = musicDatabase.albumSongs(album.album.id);
                        this.L$0 = produceStateScopeImpl;
                        this.label = true;
                        obj = StateFlowKt.first(flowAlbumSongs, this);
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
                    produceStateScopeImpl.setValue(obj);
                    return unit;
                default:
                    boolean z2 = this.label;
                    if (!z2) {
                        ResultKt.throwOnFailure(obj);
                        Flow flowAlbumSongs2 = musicDatabase.albumSongs(album.album.id);
                        this.L$0 = produceStateScopeImpl;
                        this.label = true;
                        obj = StateFlowKt.first(flowAlbumSongs2, this);
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
                    produceStateScopeImpl.setValue(obj);
                    return unit;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ItemsKt$AlbumGridItem$1$songs$2$1(MusicDatabase musicDatabase, Album album, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$database = musicDatabase;
        this.$album = album;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                ItemsKt$AlbumGridItem$1$songs$2$1 itemsKt$AlbumGridItem$1$songs$2$1 = new ItemsKt$AlbumGridItem$1$songs$2$1(this.$database, this.$album, continuation, (byte) 0);
                itemsKt$AlbumGridItem$1$songs$2$1.L$0 = obj;
                return itemsKt$AlbumGridItem$1$songs$2$1;
            default:
                ItemsKt$AlbumGridItem$1$songs$2$1 itemsKt$AlbumGridItem$1$songs$2$2 = new ItemsKt$AlbumGridItem$1$songs$2$1(this.$database, this.$album, continuation, (byte) 1);
                itemsKt$AlbumGridItem$1$songs$2$2.L$0 = obj;
                return itemsKt$AlbumGridItem$1$songs$2$2;
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
        return ((ItemsKt$AlbumGridItem$1$songs$2$1) create(produceStateScopeImpl, continuation)).invokeSuspend(unit);
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
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(produceStateScopeImpl, this.$database, this.$album, null, (byte) 0);
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
                AnonymousClass1 anonymousClass2 = new AnonymousClass1(produceStateScopeImpl2, this.$database, this.$album, null, (byte) 1);
                this.L$0 = null;
                this.label = true;
                return AwaitKt.withContext(defaultIoScheduler2, anonymousClass2, this) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }
}
