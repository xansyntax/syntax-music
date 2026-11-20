package com.metrolist.innertubex.cipher;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import coil3.size.SizeKt;
import com.dokar.quickjs.QuickJs;
import com.dokar.quickjs.QuickJsException;
import com.metrolist.music.ui.screens.playlist.PlaylistType;
import com.metrolist.music.viewmodels.AutoPlaylistViewModel;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class QuickJsEngine$evaluate$3 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $boundedCode;
    public final /* synthetic */ boolean $collectGarbage;
    public final /* synthetic */ byte $r8$classId = 2;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickJsEngine$evaluate$3(Animatable animatable, boolean z, AnimationSpec animationSpec, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.L$1 = animatable;
        this.$collectGarbage = z;
        this.L$0 = animationSpec;
        this.$boundedCode = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        boolean z = this.$collectGarbage;
        Object obj2 = this.$boundedCode;
        switch (b) {
            case 0:
                QuickJsEngine$evaluate$3 quickJsEngine$evaluate$3 = new QuickJsEngine$evaluate$3((String) obj2, z, continuation);
                quickJsEngine$evaluate$3.L$0 = obj;
                return quickJsEngine$evaluate$3;
            case 1:
                return new QuickJsEngine$evaluate$3((MutableState) this.L$0, z, (MutableInteractionSourceImpl) obj2, continuation);
            case 2:
                return new QuickJsEngine$evaluate$3((Animatable) this.L$1, this.$collectGarbage, (AnimationSpec) this.L$0, (Function0) obj2, continuation);
            default:
                return new QuickJsEngine$evaluate$3((String) obj2, (PlaylistType) this.L$1, this.$collectGarbage, (AutoPlaylistViewModel) this.L$0, continuation);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return ((QuickJsEngine$evaluate$3) create((QuickJs) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 1:
                return ((QuickJsEngine$evaluate$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 2:
                return ((QuickJsEngine$evaluate$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            default:
                return ((QuickJsEngine$evaluate$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws QuickJsException {
        QuickJs quickJs;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.$boundedCode;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        boolean z = this.$collectGarbage;
        switch (b) {
            case 0:
                QuickJs quickJs2 = (QuickJs) this.L$0;
                boolean z2 = this.label;
                try {
                    if (!z2) {
                        ResultKt.throwOnFailure(obj);
                        this.L$0 = quickJs2;
                        this.L$1 = quickJs2;
                        this.label = true;
                        obj = quickJs2.evaluateInternal((String) obj2, "main.js", false, this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        quickJs = quickJs2;
                    } else {
                        if (!z2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        quickJs = (QuickJs) this.L$1;
                        ResultKt.throwOnFailure(obj);
                    }
                    String str = (String) SizeKt.castValueOr(obj, Reflection.nullableTypeOf(String.class), new QuickJsEngine$execute$2$invokeSuspend$$inlined$evaluate$default$1(quickJs, (byte) 2));
                    if (str == null) {
                        str = "";
                    }
                    String str2 = str;
                    if (!z) {
                        return str2;
                    }
                    quickJs2.gc();
                    return str2;
                } catch (Throwable th) {
                    if (!z) {
                        throw th;
                    }
                    quickJs2.gc();
                    throw th;
                }
            case 1:
                MutableState mutableState = (MutableState) this.L$0;
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    PressInteraction.Press press = (PressInteraction.Press) mutableState.getValue();
                    if (press == null) {
                        return unit;
                    }
                    MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) obj2;
                    Interaction release = z ? new PressInteraction.Release(press) : new PressInteraction.Cancel(press);
                    if (mutableInteractionSourceImpl != null) {
                        this.L$1 = mutableState;
                        this.label = true;
                        if (mutableInteractionSourceImpl.emit(release, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    mutableState = (MutableState) this.L$1;
                    ResultKt.throwOnFailure(obj);
                }
                mutableState.setValue(null);
                return unit;
            case 2:
                boolean z4 = this.label;
                if (!z4) {
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = (Animatable) this.L$1;
                    Float f = new Float(z ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO);
                    AnimationSpec animationSpec = (AnimationSpec) this.L$0;
                    this.label = true;
                    if (Animatable.animateTo$default(animatable, f, animationSpec, null, null, this, 12) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ((Function0) obj2).invoke();
                return unit;
            default:
                PlaylistType playlistType = (PlaylistType) this.L$1;
                boolean z5 = this.label;
                if (z5) {
                    if (z5) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                System.out.println((Object) ("[UPLOAD_DEBUG] AutoPlaylistScreen LaunchedEffect: playlistId=" + ((String) obj2) + ", playlistType=" + playlistType + ", ytmSync=" + z));
                if (!z) {
                    System.out.println((Object) "[UPLOAD_DEBUG] AutoPlaylistScreen: ytmSync is false, not syncing");
                    return unit;
                }
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$2 = new InterruptibleKt$runInterruptible$2(playlistType, (AutoPlaylistViewModel) this.L$0, null, (byte) 3);
                this.label = true;
                return AwaitKt.withContext(defaultIoScheduler, interruptibleKt$runInterruptible$2, this) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickJsEngine$evaluate$3(MutableState mutableState, boolean z, MutableInteractionSourceImpl mutableInteractionSourceImpl, Continuation continuation) {
        super(2, continuation);
        this.L$0 = mutableState;
        this.$collectGarbage = z;
        this.$boundedCode = mutableInteractionSourceImpl;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickJsEngine$evaluate$3(String str, PlaylistType playlistType, boolean z, AutoPlaylistViewModel autoPlaylistViewModel, Continuation continuation) {
        super(2, continuation);
        this.$boundedCode = str;
        this.L$1 = playlistType;
        this.$collectGarbage = z;
        this.L$0 = autoPlaylistViewModel;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickJsEngine$evaluate$3(String str, boolean z, Continuation continuation) {
        super(2, continuation);
        this.$boundedCode = str;
        this.$collectGarbage = z;
    }
}
