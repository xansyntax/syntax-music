package com.valentinilk.shimmer;

import android.content.BroadcastReceiver;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.LifecycleRegistry;
import coil3.Image;
import coil3.RealImageLoader;
import coil3.UriKt;
import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import coil3.request.ImageResult;
import coil3.size.RealSizeResolver;
import coil3.size.SizeKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.viewmodels.ArtistViewModel;
import com.metrolist.music.viewmodels.OnlineSearchSuggestionViewModel;
import com.metrolist.music.viewmodels.OnlineSearchSuggestionViewModel$1$invokeSuspend$$inlined$flatMapLatest$1;
import com.metrolist.music.widget.MetrolistWidgetManager;
import com.metrolist.music.widget.PlaylistWidgetManager;
import com.metrolist.music.widget.PlaylistWidgetReceiver;
import dev.chrisbanes.haze.HazeSourceNode;
import java.util.HashSet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperator;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import sh.calvin.reorderable.ReorderableLazyListState;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ShimmerModifierKt$shimmer$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $area;
    public /* synthetic */ Object $customShimmer;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShimmerModifierKt$shimmer$1$1(boolean z, ReorderableLazyListState reorderableLazyListState, Object obj, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 10;
        this.label = z;
        this.$customShimmer = reorderableLazyListState;
        this.$area = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$area;
        switch (b) {
            case 0:
                return new ShimmerModifierKt$shimmer$1$1(this.$customShimmer, obj2, continuation, (byte) 0);
            case 1:
                return new ShimmerModifierKt$shimmer$1$1(this.$customShimmer, obj2, continuation, (byte) 1);
            case 2:
                return new ShimmerModifierKt$shimmer$1$1(this.$customShimmer, obj2, continuation, (byte) 2);
            case 3:
                return new ShimmerModifierKt$shimmer$1$1(this.$customShimmer, obj2, continuation, (byte) 3);
            case 4:
                return new ShimmerModifierKt$shimmer$1$1(this.$customShimmer, obj2, continuation, (byte) 4);
            case 5:
                ShimmerModifierKt$shimmer$1$1 shimmerModifierKt$shimmer$1$1 = new ShimmerModifierKt$shimmer$1$1((SendChannel) obj2, continuation, (byte) 5);
                shimmerModifierKt$shimmer$1$1.$customShimmer = obj;
                return shimmerModifierKt$shimmer$1$1;
            case 6:
                ShimmerModifierKt$shimmer$1$1 shimmerModifierKt$shimmer$1$2 = new ShimmerModifierKt$shimmer$1$1((Flow) obj2, continuation, (byte) 6);
                shimmerModifierKt$shimmer$1$2.$customShimmer = obj;
                return shimmerModifierKt$shimmer$1$2;
            case 7:
                ShimmerModifierKt$shimmer$1$1 shimmerModifierKt$shimmer$1$3 = new ShimmerModifierKt$shimmer$1$1((ChannelFlow) obj2, continuation, (byte) 7);
                shimmerModifierKt$shimmer$1$3.$customShimmer = obj;
                return shimmerModifierKt$shimmer$1$3;
            case 8:
                ShimmerModifierKt$shimmer$1$1 shimmerModifierKt$shimmer$1$4 = new ShimmerModifierKt$shimmer$1$1((ChannelFlowOperator) obj2, continuation, (byte) 8);
                shimmerModifierKt$shimmer$1$4.$customShimmer = obj;
                return shimmerModifierKt$shimmer$1$4;
            case 9:
                ShimmerModifierKt$shimmer$1$1 shimmerModifierKt$shimmer$1$5 = new ShimmerModifierKt$shimmer$1$1((FlowCollector) obj2, continuation, (byte) 9);
                shimmerModifierKt$shimmer$1$5.$customShimmer = obj;
                return shimmerModifierKt$shimmer$1$5;
            default:
                return new ShimmerModifierKt$shimmer$1$1(this.label, (ReorderableLazyListState) this.$customShimmer, obj2, continuation);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((ShimmerModifierKt$shimmer$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return coroutineSingletons;
            case 1:
                return ((ShimmerModifierKt$shimmer$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 2:
                return ((ShimmerModifierKt$shimmer$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 3:
                return ((ShimmerModifierKt$shimmer$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 4:
                ((ShimmerModifierKt$shimmer$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return coroutineSingletons;
            case 5:
                return ((ShimmerModifierKt$shimmer$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 6:
                return ((ShimmerModifierKt$shimmer$1$1) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 7:
                return ((ShimmerModifierKt$shimmer$1$1) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 8:
                return ((ShimmerModifierKt$shimmer$1$1) create((FlowCollector) obj, (Continuation) obj2)).invokeSuspend(unit);
            case 9:
                return ((ShimmerModifierKt$shimmer$1$1) create(obj, (Continuation) obj2)).invokeSuspend(unit);
            default:
                ((ShimmerModifierKt$shimmer$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object failure;
        byte b = this.$r8$classId;
        Object closed = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Object obj2 = this.$area;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (z) {
                        throw Fragment$5$$ExternalSyntheticOutline0.m(obj);
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                StateFlowImpl stateFlowImpl = ((Shimmer) this.$customShimmer).boundsFlow;
                ArtistViewModel.AnonymousClass1.AnonymousClass2 anonymousClass2 = new ArtistViewModel.AnonymousClass1.AnonymousClass2((byte) 13, (ShimmerArea) obj2);
                this.label = true;
                stateFlowImpl.collect(anonymousClass2, this);
                return coroutineSingletons;
            case 1:
                OnlineSearchSuggestionViewModel onlineSearchSuggestionViewModel = (OnlineSearchSuggestionViewModel) this.$customShimmer;
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return closed;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                ChannelFlowTransformLatest channelFlowTransformLatestTransformLatest = FlowKt__MergeKt.transformLatest(onlineSearchSuggestionViewModel.query, new OnlineSearchSuggestionViewModel$1$invokeSuspend$$inlined$flatMapLatest$1(null, (MusicDatabase) obj2, onlineSearchSuggestionViewModel));
                ArtistViewModel.AnonymousClass1.AnonymousClass2 anonymousClass3 = new ArtistViewModel.AnonymousClass1.AnonymousClass2((byte) 12, onlineSearchSuggestionViewModel);
                this.label = true;
                return channelFlowTransformLatestTransformLatest.collect(anonymousClass3, this) == coroutineSingletons ? coroutineSingletons : closed;
            case 2:
                MetrolistWidgetManager metrolistWidgetManager = (MetrolistWidgetManager) this.$customShimmer;
                boolean z3 = this.label;
                try {
                    if (z3) {
                        if (z3) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        }
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    ImageRequest.Builder builder = new ImageRequest.Builder(metrolistWidgetManager.context);
                    builder.data = (String) obj2;
                    builder.sizeResolver = new RealSizeResolver(SizeKt.Size(300, 300));
                    ImageRequests_androidKt.allowHardware(builder);
                    ImageRequests_androidKt.crossfade(builder, 300);
                    ImageRequest imageRequestBuild = builder.build();
                    RealImageLoader realImageLoader = (RealImageLoader) metrolistWidgetManager.imageLoader$delegate.getValue();
                    this.label = true;
                    obj = realImageLoader.execute(imageRequestBuild, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    Image image = ((ImageResult) obj).getImage();
                    if (image != null) {
                        return UriKt.toBitmap$default(image);
                    }
                } catch (Exception unused) {
                }
                return null;
            case 3:
                BroadcastReceiver.PendingResult pendingResult = (BroadcastReceiver.PendingResult) obj2;
                boolean z4 = this.label;
                try {
                    if (!z4) {
                        ResultKt.throwOnFailure(obj);
                        PlaylistWidgetManager playlistWidgetManager = ((PlaylistWidgetReceiver) this.$customShimmer).playlistWidgetManager;
                        if (playlistWidgetManager == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("playlistWidgetManager");
                            throw null;
                        }
                        this.label = true;
                        if (playlistWidgetManager.updateIdleWidgets(this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z4) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                } catch (Exception unused2) {
                    Timber.Forest.tag("PlaylistWidgetReceiver");
                    ConnectionPool.e$1(new Object[0]);
                } finally {
                    pendingResult.finish();
                }
                return closed;
            case 4:
                boolean z5 = this.label;
                if (z5) {
                    if (!z5) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                ReadonlyStateFlow readonlyStateFlowAsStateFlow = StateFlowKt.asStateFlow(((LifecycleRegistry) ((ComponentActivity) this.$customShimmer).getLifecycle())._currentStateFlow);
                ArtistViewModel.AnonymousClass1.AnonymousClass2 anonymousClass4 = new ArtistViewModel.AnonymousClass1.AnonymousClass2((byte) 14, (HazeSourceNode) obj2);
                this.label = true;
                if (readonlyStateFlowAsStateFlow.$$delegate_0.collect(anonymousClass4, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                return null;
            case 5:
                boolean z6 = this.label;
                try {
                    if (!z6) {
                        ResultKt.throwOnFailure(obj);
                        SendChannel sendChannel = (SendChannel) obj2;
                        this.$customShimmer = null;
                        this.label = true;
                        if (sendChannel.send(closed, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z6) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    failure = closed;
                    break;
                } catch (Throwable th) {
                    failure = new Result.Failure(th);
                }
                if (failure instanceof Result.Failure) {
                    closed = new ChannelResult.Closed(Result.m1866exceptionOrNullimpl(failure));
                }
                return new ChannelResult(closed);
            case 6:
                ProducerScope producerScope = (ProducerScope) this.$customShimmer;
                boolean z7 = this.label;
                if (z7) {
                    if (z7) {
                        ResultKt.throwOnFailure(obj);
                        return closed;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                ArtistViewModel.AnonymousClass1.AnonymousClass2 anonymousClass5 = new ArtistViewModel.AnonymousClass1.AnonymousClass2((byte) 15, producerScope);
                this.$customShimmer = null;
                this.label = true;
                return ((Flow) obj2).collect(anonymousClass5, this) == coroutineSingletons ? coroutineSingletons : closed;
            case 7:
                ProducerScope producerScope2 = (ProducerScope) this.$customShimmer;
                boolean z8 = this.label;
                if (!z8) {
                    ResultKt.throwOnFailure(obj);
                    this.$customShimmer = null;
                    this.label = true;
                    return ((ChannelFlow) obj2).collectTo(producerScope2, this) == coroutineSingletons ? coroutineSingletons : closed;
                }
                if (z8) {
                    ResultKt.throwOnFailure(obj);
                    return closed;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 8:
                FlowCollector flowCollector = (FlowCollector) this.$customShimmer;
                boolean z9 = this.label;
                if (!z9) {
                    ResultKt.throwOnFailure(obj);
                    this.$customShimmer = null;
                    this.label = true;
                    return ((ChannelFlowOperator) obj2).flowCollect(flowCollector, this) == coroutineSingletons ? coroutineSingletons : closed;
                }
                if (z9) {
                    ResultKt.throwOnFailure(obj);
                    return closed;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 9:
                Object obj3 = this.$customShimmer;
                boolean z10 = this.label;
                if (!z10) {
                    ResultKt.throwOnFailure(obj);
                    this.$customShimmer = null;
                    this.label = true;
                    return ((FlowCollector) obj2).emit(obj3, this) == coroutineSingletons ? coroutineSingletons : closed;
                }
                if (z10) {
                    ResultKt.throwOnFailure(obj);
                    return closed;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                ResultKt.throwOnFailure(obj);
                boolean z11 = this.label;
                HashSet hashSet = ((ReorderableLazyListState) this.$customShimmer).reorderableKeys;
                if (z11) {
                    hashSet.add(obj2);
                } else {
                    hashSet.remove(obj2);
                }
                return closed;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShimmerModifierKt$shimmer$1$1(Object obj, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$area = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShimmerModifierKt$shimmer$1$1(Object obj, Object obj2, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$customShimmer = obj;
        this.$area = obj2;
    }
}
