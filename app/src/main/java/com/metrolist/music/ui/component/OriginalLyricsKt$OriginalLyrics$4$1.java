package com.metrolist.music.ui.component;

import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.lyrics.LyricsTranslationHelper;
import com.metrolist.music.viewmodels.ArtistViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.ReadonlySharedFlow;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OriginalLyricsKt$OriginalLyrics$4$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ List $lines;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OriginalLyricsKt$OriginalLyrics$4$1(List list, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$lines = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        List list = this.$lines;
        switch (b) {
            case 0:
                return new OriginalLyricsKt$OriginalLyrics$4$1(list, continuation, (byte) 0);
            case 1:
                return new OriginalLyricsKt$OriginalLyrics$4$1(list, continuation, (byte) 1);
            default:
                return new OriginalLyricsKt$OriginalLyrics$4$1(list, continuation, (byte) 2);
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
                ((OriginalLyricsKt$OriginalLyrics$4$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return CoroutineSingletons.COROUTINE_SUSPENDED;
            case 1:
                return ((OriginalLyricsKt$OriginalLyrics$4$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            default:
                return ((OriginalLyricsKt$OriginalLyrics$4$1) create(coroutineScope, continuation)).invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM989queue0E7RQCE$default;
        byte b = this.$r8$classId;
        List list = this.$lines;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                ReadonlySharedFlow readonlySharedFlow = LyricsTranslationHelper.clearTranslationsTrigger;
                ArtistViewModel.AnonymousClass1.AnonymousClass2 anonymousClass2 = new ArtistViewModel.AnonymousClass1.AnonymousClass2((byte) 8, list);
                this.label = true;
                if (readonlySharedFlow.$$delegate_0.collect(anonymousClass2, this) == obj2) {
                    return obj2;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                return null;
            case 1:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    if (list.isEmpty()) {
                        return EmptyMap.INSTANCE;
                    }
                    YouTube youTube = YouTube.INSTANCE;
                    this.label = true;
                    objM989queue0E7RQCE$default = YouTube.m989queue0E7RQCE$default(list, this);
                    if (objM989queue0E7RQCE$default == obj2) {
                        return obj2;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM989queue0E7RQCE$default = ((Result) obj).value;
                }
                if (objM989queue0E7RQCE$default instanceof Result.Failure) {
                    objM989queue0E7RQCE$default = EmptyList.INSTANCE;
                }
                ArrayList arrayList = new ArrayList();
                for (SongItem songItem : (Iterable) objM989queue0E7RQCE$default) {
                    Integer num = songItem.duration;
                    Pair pair = num != null ? new Pair(songItem.id, new Integer(num.intValue())) : null;
                    if (pair != null) {
                        arrayList.add(pair);
                    }
                }
                return MapsKt__MapsKt.toMap(arrayList);
            default:
                boolean z3 = this.label;
                if (z3) {
                    if (z3) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                YouTube youTube2 = YouTube.INSTANCE;
                this.label = true;
                Object objResolveArtistIds = youTube2.resolveArtistIds(list, this);
                return objResolveArtistIds == obj2 ? obj2 : objResolveArtistIds;
        }
    }
}
