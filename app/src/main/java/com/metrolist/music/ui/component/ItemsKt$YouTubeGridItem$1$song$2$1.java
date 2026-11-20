package com.metrolist.music.ui.component;

import androidx.compose.runtime.ProduceStateScopeImpl;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.db.MusicDatabase;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ItemsKt$YouTubeGridItem$1$song$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MusicDatabase $database;
    public final /* synthetic */ YTItem $item;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ Object L$0;
    public ProduceStateScopeImpl L$1;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ItemsKt$YouTubeGridItem$1$song$2$1(YTItem yTItem, MusicDatabase musicDatabase, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$item = yTItem;
        this.$database = musicDatabase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                ItemsKt$YouTubeGridItem$1$song$2$1 itemsKt$YouTubeGridItem$1$song$2$1 = new ItemsKt$YouTubeGridItem$1$song$2$1(this.$item, this.$database, continuation, (byte) 0);
                itemsKt$YouTubeGridItem$1$song$2$1.L$0 = obj;
                return itemsKt$YouTubeGridItem$1$song$2$1;
            case 1:
                ItemsKt$YouTubeGridItem$1$song$2$1 itemsKt$YouTubeGridItem$1$song$2$2 = new ItemsKt$YouTubeGridItem$1$song$2$1(this.$item, this.$database, continuation, (byte) 1);
                itemsKt$YouTubeGridItem$1$song$2$2.L$0 = obj;
                return itemsKt$YouTubeGridItem$1$song$2$2;
            case 2:
                ItemsKt$YouTubeGridItem$1$song$2$1 itemsKt$YouTubeGridItem$1$song$2$3 = new ItemsKt$YouTubeGridItem$1$song$2$1(this.$item, this.$database, continuation, (byte) 2);
                itemsKt$YouTubeGridItem$1$song$2$3.L$0 = obj;
                return itemsKt$YouTubeGridItem$1$song$2$3;
            default:
                ItemsKt$YouTubeGridItem$1$song$2$1 itemsKt$YouTubeGridItem$1$song$2$4 = new ItemsKt$YouTubeGridItem$1$song$2$1(this.$item, this.$database, continuation, (byte) 3);
                itemsKt$YouTubeGridItem$1$song$2$4.L$0 = obj;
                return itemsKt$YouTubeGridItem$1$song$2$4;
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
            case 1:
                break;
            case 2:
                break;
        }
        return ((ItemsKt$YouTubeGridItem$1$song$2$1) create(produceStateScopeImpl, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MusicDatabase musicDatabase = this.$database;
        YTItem yTItem = this.$item;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                ProduceStateScopeImpl produceStateScopeImpl = (ProduceStateScopeImpl) this.L$0;
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    if (!(yTItem instanceof SongItem)) {
                        return unit;
                    }
                    Flow flowSong = musicDatabase.$$delegate_0.song(((SongItem) yTItem).id);
                    this.L$0 = null;
                    this.L$1 = produceStateScopeImpl;
                    this.label = true;
                    obj = StateFlowKt.firstOrNull(flowSong, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    produceStateScopeImpl = this.L$1;
                    ResultKt.throwOnFailure(obj);
                }
                produceStateScopeImpl.setValue(obj);
                return unit;
            case 1:
                ProduceStateScopeImpl produceStateScopeImpl2 = (ProduceStateScopeImpl) this.L$0;
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    if (!(yTItem instanceof AlbumItem)) {
                        return unit;
                    }
                    Flow flowAlbum = musicDatabase.album(((AlbumItem) yTItem).id);
                    this.L$0 = null;
                    this.L$1 = produceStateScopeImpl2;
                    this.label = true;
                    obj = StateFlowKt.firstOrNull(flowAlbum, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    produceStateScopeImpl2 = this.L$1;
                    ResultKt.throwOnFailure(obj);
                }
                produceStateScopeImpl2.setValue(obj);
                return unit;
            case 2:
                ProduceStateScopeImpl produceStateScopeImpl3 = (ProduceStateScopeImpl) this.L$0;
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    if (!(yTItem instanceof AlbumItem)) {
                        return unit;
                    }
                    Flow flowAlbum2 = musicDatabase.album(((AlbumItem) yTItem).id);
                    this.L$0 = null;
                    this.L$1 = produceStateScopeImpl3;
                    this.label = true;
                    obj = StateFlowKt.firstOrNull(flowAlbum2, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    produceStateScopeImpl3 = this.L$1;
                    ResultKt.throwOnFailure(obj);
                }
                produceStateScopeImpl3.setValue(obj);
                return unit;
            default:
                ProduceStateScopeImpl produceStateScopeImpl4 = (ProduceStateScopeImpl) this.L$0;
                boolean z4 = this.label;
                if (!z4) {
                    ResultKt.throwOnFailure(obj);
                    if (!(yTItem instanceof SongItem)) {
                        return unit;
                    }
                    Flow flowSong2 = musicDatabase.$$delegate_0.song(((SongItem) yTItem).id);
                    this.L$0 = null;
                    this.L$1 = produceStateScopeImpl4;
                    this.label = true;
                    obj = StateFlowKt.firstOrNull(flowSong2, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    produceStateScopeImpl4 = this.L$1;
                    ResultKt.throwOnFailure(obj);
                }
                produceStateScopeImpl4.setValue(obj);
                return unit;
        }
    }
}
