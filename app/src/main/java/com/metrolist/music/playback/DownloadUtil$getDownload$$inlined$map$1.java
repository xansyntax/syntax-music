package com.metrolist.music.playback;

import androidx.compose.material3.internal.MappedInteractionSource;
import androidx.compose.runtime.Recomposer$join$2;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.viewmodels.HomeViewModel$2$1;
import com.metrolist.music.viewmodels.HomeViewModel$special$$inlined$map$1;
import com.metrolist.music.viewmodels.OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$1;
import com.metrolist.music.widget.PlaylistWidgetManager$observeQuickPickChanges$6;
import com.metrolist.music.widget.PlaylistWidgetManager$observeQuickPickChanges$7;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1;
import kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.ThrowingCollector;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.CombineKt;
import kotlinx.coroutines.flow.internal.SafeCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class DownloadUtil$getDownload$$inlined$map$1 implements Flow {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object $songId$inlined;
    public final /* synthetic */ Object $this_unsafeTransform$inlined;

    /* JADX INFO: renamed from: com.metrolist.music.playback.DownloadUtil$getDownload$$inlined$map$1$1, reason: invalid class name */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadUtil$getDownload$$inlined$map$1.this.collect(null, this);
        }
    }

    public /* synthetic */ DownloadUtil$getDownload$$inlined$map$1(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.$this_unsafeTransform$inlined = obj;
        this.$songId$inlined = obj2;
    }

    /* JADX WARN: Code duplicated, block: B:115:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:130:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:145:0x022c  */
    /* JADX WARN: Code duplicated, block: B:164:0x027a  */
    /* JADX WARN: Code duplicated, block: B:25:0x0074  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:73:0x0121  */
    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$1 mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$1;
        MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$1 mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$1;
        OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$1 onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$1;
        FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1;
        SafeCollector safeCollector;
        SafeCollector safeCollector2;
        FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1 flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1;
        FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1 flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1;
        HomeViewModel$2$1 homeViewModel$2$1;
        FlowCollector flowCollector2 = flowCollector;
        byte b = this.$r8$classId;
        int i = 0;
        byte b2 = 3;
        Unit unit = Unit.INSTANCE;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        Object obj2 = this.$songId$inlined;
        Object obj3 = this.$this_unsafeTransform$inlined;
        switch (b) {
            case 0:
                if (continuation instanceof AnonymousClass1) {
                    anonymousClass1 = (AnonymousClass1) continuation;
                    int i2 = anonymousClass1.label;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        anonymousClass1.label = i2 - Integer.MIN_VALUE;
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                } else {
                    anonymousClass1 = new AnonymousClass1(continuation);
                }
                Object obj4 = anonymousClass1.result;
                int i3 = anonymousClass1.label;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj4);
                    HomeViewModel$2$1 homeViewModel$2$2 = new HomeViewModel$2$1(flowCollector2, (String) obj2, (byte) 5);
                    anonymousClass1.label = 1;
                    return ((Flow) obj3).collect(homeViewModel$2$2, anonymousClass1) == obj ? obj : unit;
                }
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj4);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 1:
                Object objCollect = ((Flow) obj3).collect(new HomeViewModel$2$1(flowCollector2, (MappedInteractionSource) obj2, b2), continuation);
                return objCollect == obj ? objCollect : unit;
            case 2:
                if (continuation instanceof MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$1) {
                    mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$1 = (MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$1) continuation;
                    int i4 = mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$1.label;
                    if ((i4 & Integer.MIN_VALUE) != 0) {
                        mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$1.label = i4 - Integer.MIN_VALUE;
                    } else {
                        mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$1 = new MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$1(this, continuation);
                    }
                } else {
                    mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$1 = new MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$1(this, continuation);
                }
                Object obj5 = mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$1.result;
                int i5 = mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$1.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj5);
                    MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$2 mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$2 = new MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$2(flowCollector2, (Map) obj2, (byte) 0);
                    mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$1.label = 1;
                    return ((Flow) obj3).collect(mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$2, mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$1) == obj ? obj : unit;
                }
                if (i5 == 1) {
                    ResultKt.throwOnFailure(obj5);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 3:
                if (continuation instanceof MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$1) {
                    mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$1 = (MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$1) continuation;
                    int i6 = mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$1.label;
                    if ((i6 & Integer.MIN_VALUE) != 0) {
                        mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$1.label = i6 - Integer.MIN_VALUE;
                    } else {
                        mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$1 = new MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$1(this, continuation);
                    }
                } else {
                    mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$1 = new MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$1(this, continuation);
                }
                Object obj6 = mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$1.result;
                int i7 = mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$1.label;
                if (i7 == 0) {
                    ResultKt.throwOnFailure(obj6);
                    MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$2 mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$3 = new MediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$2(flowCollector2, (Map) obj2, (byte) 1);
                    mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$1.label = 1;
                    return ((DownloadUtil$getDownload$$inlined$map$1) obj3).collect(mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$1$3, mediaLibrarySessionCallback$onSetMediaItems$1$invokeSuspend$$inlined$map$2$1) == obj ? obj : unit;
                }
                if (i7 == 1) {
                    ResultKt.throwOnFailure(obj6);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 4:
                if (continuation instanceof OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$1) {
                    onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$1 = (OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$1) continuation;
                    int i8 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$1.label;
                    if ((i8 & Integer.MIN_VALUE) != 0) {
                        onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$1.label = i8 - Integer.MIN_VALUE;
                    } else {
                        onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$1 = new OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$1(this, continuation);
                    }
                } else {
                    onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$1 = new OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$1(this, continuation);
                }
                Object obj7 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$1.result;
                int i9 = onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$1.label;
                if (i9 == 0) {
                    ResultKt.throwOnFailure(obj7);
                    HomeViewModel$2$1 homeViewModel$2$3 = new HomeViewModel$2$1(flowCollector2, (YTItem) obj2, (byte) 8);
                    onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$1.label = 1;
                    return ((HomeViewModel$special$$inlined$map$1) obj3).collect(homeViewModel$2$3, onlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$3$1) == obj ? obj : unit;
                }
                if (i9 == 1) {
                    ResultKt.throwOnFailure(obj7);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 5:
                Function3 function3 = (Function3) obj2;
                if (continuation instanceof FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1) {
                    flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1) continuation;
                    int i10 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.label = i10 - Integer.MIN_VALUE;
                    } else {
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 = new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1(this, continuation);
                    }
                } else {
                    flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 = new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1(this, continuation);
                }
                Object obj8 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.result;
                int i11 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.label;
                try {
                    try {
                        if (i11 == 0) {
                            ResultKt.throwOnFailure(obj8);
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.L$2 = flowCollector2;
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.I$0 = 0;
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.label = 1;
                            if (((Flow) obj3).collect(flowCollector2, flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1) != obj) {
                            }
                            return obj;
                        }
                        if (i11 != 1) {
                            if (i11 == 2) {
                                Throwable th = (Throwable) flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.L$3;
                                ResultKt.throwOnFailure(obj8);
                                throw th;
                            }
                            if (i11 != 3) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            safeCollector2 = (SafeCollector) flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.L$3;
                            try {
                                ResultKt.throwOnFailure(obj8);
                                safeCollector2.releaseIntercepted();
                                return unit;
                            } catch (Throwable th2) {
                                th = th2;
                                safeCollector2.releaseIntercepted();
                                throw th;
                            }
                        }
                        i = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.I$0;
                        flowCollector2 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.L$2;
                        ResultKt.throwOnFailure(obj8);
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.L$2 = null;
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.L$3 = safeCollector;
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.I$0 = i;
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.label = 3;
                        if (function3.invoke(safeCollector, null, flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1) != obj) {
                            safeCollector2 = safeCollector;
                            safeCollector2.releaseIntercepted();
                            return unit;
                        }
                        return obj;
                    } catch (Throwable th3) {
                        th = th3;
                        safeCollector2 = safeCollector;
                        safeCollector2.releaseIntercepted();
                        throw th;
                    }
                    safeCollector = new SafeCollector(flowCollector2, flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.getContext());
                } catch (Throwable th4) {
                    ThrowingCollector throwingCollector = new ThrowingCollector(th4);
                    flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.L$2 = null;
                    flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.L$3 = th4;
                    flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.I$0 = i;
                    flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1.label = 2;
                    if (StateFlowKt.invokeSafely$FlowKt__EmittersKt(throwingCollector, function3, th4, flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1) != obj) {
                        throw th4;
                    }
                }
                break;
            case 6:
                if (continuation instanceof FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1) {
                    flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1 = (FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1) continuation;
                    int i12 = flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1.label;
                    if ((i12 & Integer.MIN_VALUE) != 0) {
                        flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1.label = i12 - Integer.MIN_VALUE;
                    } else {
                        flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1 = new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1(this, continuation);
                    }
                } else {
                    flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1 = new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1(this, continuation);
                }
                Object objCatchImpl = flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1.result;
                int i13 = flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1.label;
                if (i13 == 0) {
                    ResultKt.throwOnFailure(objCatchImpl);
                    flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1.L$2 = flowCollector2;
                    flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1.I$0 = 0;
                    flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1.label = 1;
                    objCatchImpl = StateFlowKt.catchImpl((SafeFlow) obj3, flowCollector2, flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1);
                    if (objCatchImpl != obj) {
                    }
                    return obj;
                }
                if (i13 != 1) {
                    if (i13 == 2) {
                        ResultKt.throwOnFailure(objCatchImpl);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                i = flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1.I$0;
                flowCollector2 = flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1.L$2;
                ResultKt.throwOnFailure(objCatchImpl);
                Throwable th5 = (Throwable) objCatchImpl;
                if (th5 == null) {
                    return unit;
                }
                flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1.L$2 = null;
                flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1.I$0 = i;
                flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1.label = 2;
                if (((Function3) obj2).invoke(flowCollector2, th5, flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1) != obj) {
                    return unit;
                }
                return obj;
            case 7:
                if (continuation instanceof FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1) {
                    flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1 = (FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1) continuation;
                    int i14 = flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1.label;
                    if ((i14 & Integer.MIN_VALUE) != 0) {
                        flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1.label = i14 - Integer.MIN_VALUE;
                    } else {
                        flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1 = new FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1(this, continuation);
                    }
                } else {
                    flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1 = new FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1(this, continuation);
                }
                Object obj9 = flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1.result;
                int i15 = flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1.label;
                if (i15 == 0) {
                    ResultKt.throwOnFailure(obj9);
                    FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1 flowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1 = (FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1) obj3;
                    HomeViewModel$2$1 homeViewModel$2$4 = new HomeViewModel$2$1((Recomposer$join$2) obj2, flowCollector2, (byte) 11);
                    try {
                        flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1.L$5 = homeViewModel$2$4;
                        flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1.label = 1;
                        return flowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1.collect(homeViewModel$2$4, flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1) == obj ? obj : unit;
                    } catch (AbortFlowException e) {
                        e = e;
                        homeViewModel$2$1 = homeViewModel$2$4;
                    }
                } else {
                    if (i15 != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    homeViewModel$2$1 = flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1.L$5;
                    try {
                        ResultKt.throwOnFailure(obj9);
                        return unit;
                    } catch (AbortFlowException e2) {
                        e = e2;
                    }
                }
                if (e.owner != homeViewModel$2$1) {
                    throw e;
                }
                AwaitKt.ensureActive(flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1.getContext());
                return unit;
            case 8:
                Object objCollect2 = ((Flow) obj3).collect(new HomeViewModel$2$1(flowCollector2, (PlaylistWidgetManager$observeQuickPickChanges$7) obj2, (byte) 12), continuation);
                return objCollect2 == obj ? objCollect2 : unit;
            case 9:
                Object objCombineInternal = CombineKt.combineInternal(continuation, new FlowKt__ZipKt$combine$1$1((Continuation) null, (Function4) obj2, (byte) 2), flowCollector2, (Flow[]) obj3);
                return objCombineInternal == obj ? objCombineInternal : unit;
            case 10:
                Object objCombineInternal2 = CombineKt.combineInternal(continuation, new FlowKt__ZipKt$combine$1$1((Continuation) null, (Function5) obj2, (byte) 3), flowCollector2, (Flow[]) obj3);
                return objCombineInternal2 == obj ? objCombineInternal2 : unit;
            default:
                Object objCombineInternal3 = CombineKt.combineInternal(continuation, new FlowKt__ZipKt$combine$1$1((Continuation) null, (PlaylistWidgetManager$observeQuickPickChanges$6) obj2, (byte) 4), flowCollector2, (Flow[]) obj3);
                return objCombineInternal3 == obj ? objCombineInternal3 : unit;
        }
    }
}
