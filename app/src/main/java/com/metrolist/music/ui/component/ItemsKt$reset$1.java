package com.metrolist.music.ui.component;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.MutableState;
import com.metrolist.innertube.YouTube;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.lyrics.LyricsTranslationHelper;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda37;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.ReadonlySharedFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ItemsKt$reset$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ MutableState $offset;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ItemsKt$reset$1(MutableState mutableState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$offset = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        MutableState mutableState = this.$offset;
        switch (b) {
            case 0:
                return new ItemsKt$reset$1(mutableState, continuation, (byte) 0);
            case 1:
                return new ItemsKt$reset$1(mutableState, continuation, (byte) 1);
            case 2:
                return new ItemsKt$reset$1(mutableState, continuation, (byte) 2);
            default:
                return new ItemsKt$reset$1(mutableState, continuation, (byte) 3);
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
                return ((ItemsKt$reset$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 1:
                ((ItemsKt$reset$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return CoroutineSingletons.COROUTINE_SUSPENDED;
            case 2:
                return ((ItemsKt$reset$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            default:
                return ((ItemsKt$reset$1) create(coroutineScope, continuation)).invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.$offset;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
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
                float fFloatValue = ((Number) mutableState.getValue()).floatValue();
                TweenSpec tweenSpecTween$default = ArcSplineKt.tween$default(300, 0, null, 6);
                SongMenuKt$$ExternalSyntheticLambda37 songMenuKt$$ExternalSyntheticLambda37 = new SongMenuKt$$ExternalSyntheticLambda37(mutableState, (byte) 3);
                this.label = true;
                return ArcSplineKt.animate$default(fFloatValue, CropImageView.DEFAULT_ASPECT_RATIO, tweenSpecTween$default, songMenuKt$$ExternalSyntheticLambda37, this, 4) == coroutineSingletons ? coroutineSingletons : unit;
            case 1:
                boolean z2 = this.label;
                if (z2) {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                ReadonlySharedFlow readonlySharedFlow = LyricsTranslationHelper.clearTranslationsTrigger;
                NewMenuComponentsKt$NewActionButton$1$1 newMenuComponentsKt$NewActionButton$1$1 = new NewMenuComponentsKt$NewActionButton$1$1(mutableState, null, (byte) 1);
                readonlySharedFlow.getClass();
                this.label = true;
                if (StateFlowKt.collectLatest(readonlySharedFlow, newMenuComponentsKt$NewActionButton$1$1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("SharedFlow never completes, this call should never return.");
                return null;
            case 2:
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) mutableState.getValue()).booleanValue()) {
                        return unit;
                    }
                    this.label = true;
                    if (AwaitKt.delay(1000L, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                mutableState.setValue(Boolean.FALSE);
                return unit;
            default:
                boolean z4 = this.label;
                if (z4) {
                    if (!z4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Object obj2 = ((Result) obj).value;
                    return unit;
                }
                ResultKt.throwOnFailure(obj);
                Playlist playlist = (Playlist) mutableState.getValue();
                if (playlist == null || (str = playlist.playlist.browseId) == null) {
                    return unit;
                }
                YouTube youTube = YouTube.INSTANCE;
                this.label = true;
                return youTube.m1002deletePlaylistgIAlus(str, this) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }
}
