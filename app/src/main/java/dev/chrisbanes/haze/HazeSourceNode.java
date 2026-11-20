package dev.chrisbanes.haze;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.collection.internal.Lock;
import androidx.compose.animation.core.Animatable;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import coil3.size.SizeKt;
import coil3.util.LifecyclesKt;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.pages.HistoryPage;
import com.metrolist.innertube.pages.PodcastPage;
import com.metrolist.music.playback.DownloadUtil$getDownload$$inlined$map$1;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.viewmodels.ArtistViewModel;
import com.metrolist.music.viewmodels.HistoryViewModel;
import com.metrolist.music.viewmodels.LibraryMixViewModel;
import com.metrolist.music.viewmodels.LyricsMenuViewModel;
import com.metrolist.music.viewmodels.MoodAndGenresViewModel;
import com.metrolist.music.viewmodels.OnlinePodcastViewModel;
import com.metrolist.music.viewmodels.OnlineSearchViewModel;
import com.metrolist.music.viewmodels.OnlineSearchViewModel$1$1;
import com.valentinilk.shimmer.ShimmerEffect;
import com.valentinilk.shimmer.ShimmerModifierKt$shimmer$1$1;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.internal.NopCollector;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import sh.calvin.reorderable.ReorderableLazyListState;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HazeSourceNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode, LayoutAwareModifierNode, DrawModifierNode, TraversableNode, ObserverModifierNode {
    public final HazeArea area;
    public StandaloneCoroutine preDrawJob;
    public HazeState state;

    /* JADX INFO: renamed from: dev.chrisbanes.haze.HazeSourceNode$launchPreDraw$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public boolean label;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(Object obj, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj2 = this.this$0;
            switch (b) {
                case 0:
                    return new AnonymousClass1((HazeSourceNode) obj2, continuation, (byte) 0);
                case 1:
                    return new AnonymousClass1((HistoryViewModel) obj2, continuation, (byte) 1);
                case 2:
                    return new AnonymousClass1((LibraryMixViewModel) obj2, continuation, (byte) 2);
                case 3:
                    return new AnonymousClass1((LyricsMenuViewModel) obj2, continuation, (byte) 3);
                case 4:
                    return new AnonymousClass1((MoodAndGenresViewModel) obj2, continuation, (byte) 4);
                case 5:
                    return new AnonymousClass1((OnlinePodcastViewModel) obj2, continuation, (byte) 5);
                case 6:
                    return new AnonymousClass1((OnlineSearchViewModel) obj2, continuation, (byte) 6);
                case 7:
                    return new AnonymousClass1((ShimmerEffect) obj2, continuation, (byte) 7);
                case 8:
                    return new AnonymousClass1((DownloadUtil$getDownload$$inlined$map$1) obj2, continuation, (byte) 8);
                default:
                    return new AnonymousClass1((ReorderableLazyListState) obj2, continuation, (byte) 9);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) throws Throwable {
            byte b = this.$r8$classId;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                case 1:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                case 2:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                case 3:
                    ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                    return coroutineSingletons;
                case 4:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                case 5:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                case 6:
                    ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                    return coroutineSingletons;
                case 7:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                case 8:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                default:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM1020musicHistoryIoAF18A;
            Object objM1018moodAndGenresIoAF18A;
            Object objM1027podcastgIAlus;
            byte b = this.$r8$classId;
            NopCollector nopCollector = NopCollector.INSTANCE;
            byte b2 = 0;
            Unit unit = Unit.INSTANCE;
            Object obj2 = this.this$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            switch (b) {
                case 0:
                    boolean z = this.label;
                    if (!z) {
                        ResultKt.throwOnFailure(obj);
                        HazeEffectNode$$ExternalSyntheticLambda3 hazeEffectNode$$ExternalSyntheticLambda3 = new HazeEffectNode$$ExternalSyntheticLambda3((HazeSourceNode) obj2);
                        this.label = true;
                        return Stack.getMonotonicFrameClock(getContext()).withFrameNanos(hazeEffectNode$$ExternalSyntheticLambda3, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 1:
                    boolean z2 = this.label;
                    if (!z2) {
                        ResultKt.throwOnFailure(obj);
                        YouTube youTube = YouTube.INSTANCE;
                        this.label = true;
                        objM1020musicHistoryIoAF18A = youTube.m1020musicHistoryIoAF18A(this);
                        if (objM1020musicHistoryIoAF18A == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        objM1020musicHistoryIoAF18A = ((Result) obj).value;
                    }
                    HistoryViewModel historyViewModel = (HistoryViewModel) obj2;
                    if (!(objM1020musicHistoryIoAF18A instanceof Result.Failure)) {
                        historyViewModel.historyPage.setValue((HistoryPage) objM1020musicHistoryIoAF18A);
                    }
                    Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1020musicHistoryIoAF18A);
                    if (thM1866exceptionOrNullimpl == null) {
                        return unit;
                    }
                    thM1866exceptionOrNullimpl.printStackTrace();
                    return unit;
                case 2:
                    LibraryMixViewModel libraryMixViewModel = (LibraryMixViewModel) obj2;
                    boolean z3 = this.label;
                    if (!z3) {
                        ResultKt.throwOnFailure(obj);
                        StateFlowImpl stateFlowImpl = libraryMixViewModel._isRefreshing;
                        Boolean bool = Boolean.TRUE;
                        stateFlowImpl.getClass();
                        stateFlowImpl.updateState(null, bool);
                        SyncUtils syncUtils = libraryMixViewModel.syncUtils;
                        this.label = true;
                        if (syncUtils.performFullSyncSuspend(this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    StateFlowImpl stateFlowImpl2 = libraryMixViewModel._isRefreshing;
                    Boolean bool2 = Boolean.FALSE;
                    stateFlowImpl2.getClass();
                    stateFlowImpl2.updateState(null, bool2);
                    return unit;
                case 3:
                    boolean z4 = this.label;
                    if (z4) {
                        if (!z4) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            ResultKt.throwOnFailure(obj);
                        }
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    LyricsMenuViewModel lyricsMenuViewModel = (LyricsMenuViewModel) obj2;
                    ReadonlyStateFlow readonlyStateFlow = lyricsMenuViewModel.networkConnectivity.networkStatus;
                    ArtistViewModel.AnonymousClass1.AnonymousClass2 anonymousClass2 = new ArtistViewModel.AnonymousClass1.AnonymousClass2((byte) 11, lyricsMenuViewModel);
                    this.label = true;
                    if (readonlyStateFlow.$$delegate_0.collect(anonymousClass2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                    return null;
                case 4:
                    boolean z5 = this.label;
                    if (!z5) {
                        ResultKt.throwOnFailure(obj);
                        YouTube youTube2 = YouTube.INSTANCE;
                        this.label = true;
                        objM1018moodAndGenresIoAF18A = youTube2.m1018moodAndGenresIoAF18A(this);
                        if (objM1018moodAndGenresIoAF18A == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z5) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        objM1018moodAndGenresIoAF18A = ((Result) obj).value;
                    }
                    MoodAndGenresViewModel moodAndGenresViewModel = (MoodAndGenresViewModel) obj2;
                    if (!(objM1018moodAndGenresIoAF18A instanceof Result.Failure)) {
                        moodAndGenresViewModel.moodAndGenres.setValue((List) objM1018moodAndGenresIoAF18A);
                    }
                    Throwable thM1866exceptionOrNullimpl2 = Result.m1866exceptionOrNullimpl(objM1018moodAndGenresIoAF18A);
                    if (thM1866exceptionOrNullimpl2 == null) {
                        return unit;
                    }
                    thM1866exceptionOrNullimpl2.printStackTrace();
                    return unit;
                case 5:
                    OnlinePodcastViewModel onlinePodcastViewModel = (OnlinePodcastViewModel) obj2;
                    StateFlowImpl stateFlowImpl3 = onlinePodcastViewModel._error;
                    StateFlowImpl stateFlowImpl4 = onlinePodcastViewModel._isLoading;
                    boolean z6 = this.label;
                    if (!z6) {
                        ResultKt.throwOnFailure(obj);
                        Timber.Forest.getClass();
                        ConnectionPool.d(new Object[0]);
                        Boolean bool3 = Boolean.TRUE;
                        stateFlowImpl4.getClass();
                        stateFlowImpl4.updateState(null, bool3);
                        stateFlowImpl3.setValue(null);
                        YouTube youTube3 = YouTube.INSTANCE;
                        String str = onlinePodcastViewModel.podcastId;
                        this.label = true;
                        objM1027podcastgIAlus = youTube3.m1027podcastgIAlus(str, this);
                        if (objM1027podcastgIAlus == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z6) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        objM1027podcastgIAlus = ((Result) obj).value;
                    }
                    if (!(objM1027podcastgIAlus instanceof Result.Failure)) {
                        PodcastPage podcastPage = (PodcastPage) objM1027podcastgIAlus;
                        ConnectionPool connectionPool = Timber.Forest;
                        PodcastItem podcastItem = podcastPage.podcast;
                        ArrayList arrayList = podcastPage.episodes;
                        arrayList.size();
                        connectionPool.getClass();
                        ConnectionPool.d(new Object[0]);
                        StateFlowImpl stateFlowImpl5 = onlinePodcastViewModel.podcast;
                        PodcastItem podcastItem2 = podcastPage.podcast;
                        stateFlowImpl5.getClass();
                        stateFlowImpl5.updateState(null, podcastItem2);
                        StateFlowImpl stateFlowImpl6 = onlinePodcastViewModel.episodes;
                        stateFlowImpl6.getClass();
                        stateFlowImpl6.updateState(null, arrayList);
                        Boolean bool4 = Boolean.FALSE;
                        stateFlowImpl4.getClass();
                        stateFlowImpl4.updateState(null, bool4);
                    }
                    Throwable thM1866exceptionOrNullimpl3 = Result.m1866exceptionOrNullimpl(objM1027podcastgIAlus);
                    if (thM1866exceptionOrNullimpl3 == null) {
                        return unit;
                    }
                    ConnectionPool connectionPool2 = Timber.Forest;
                    thM1866exceptionOrNullimpl3.getMessage();
                    connectionPool2.getClass();
                    ConnectionPool.e$1(new Object[0]);
                    String message = thM1866exceptionOrNullimpl3.getMessage();
                    if (message == null) {
                        message = "Failed to load podcast";
                    }
                    stateFlowImpl3.getClass();
                    stateFlowImpl3.updateState(null, message);
                    Boolean bool5 = Boolean.FALSE;
                    stateFlowImpl4.getClass();
                    stateFlowImpl4.updateState(null, bool5);
                    thM1866exceptionOrNullimpl3.printStackTrace();
                    return unit;
                case 6:
                    boolean z7 = this.label;
                    if (z7) {
                        if (z7) {
                            throw Fragment$5$$ExternalSyntheticOutline0.m(obj);
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    OnlineSearchViewModel onlineSearchViewModel = (OnlineSearchViewModel) obj2;
                    StateFlowImpl stateFlowImpl7 = onlineSearchViewModel.filter;
                    OnlineSearchViewModel$1$1 onlineSearchViewModel$1$1 = new OnlineSearchViewModel$1$1(onlineSearchViewModel, b2);
                    this.label = true;
                    stateFlowImpl7.collect(onlineSearchViewModel$1$1, this);
                    return coroutineSingletons;
                case 7:
                    boolean z8 = this.label;
                    if (z8) {
                        if (z8) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    ShimmerEffect shimmerEffect = (ShimmerEffect) obj2;
                    this.label = true;
                    Object objAnimateTo$default = Animatable.animateTo$default(shimmerEffect.animatedState, new Float(1.0f), shimmerEffect.animationSpec, null, null, this, 12);
                    if (objAnimateTo$default != coroutineSingletons) {
                        objAnimateTo$default = unit;
                    }
                    return objAnimateTo$default == coroutineSingletons ? coroutineSingletons : unit;
                case 8:
                    boolean z9 = this.label;
                    if (z9) {
                        if (z9) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    Object objCollect = ((DownloadUtil$getDownload$$inlined$map$1) obj2).collect(nopCollector, this);
                    if (objCollect != coroutineSingletons) {
                        objCollect = unit;
                    }
                    return objCollect == coroutineSingletons ? coroutineSingletons : unit;
                default:
                    boolean z10 = this.label;
                    if (z10) {
                        if (z10) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    FlowKt__LimitKt$take$$inlined$unsafeFlow$1 flowKt__LimitKt$take$$inlined$unsafeFlow$1 = new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(((ReorderableLazyListState) obj2).layoutInfoFlow, (byte) 0);
                    this.label = true;
                    Object objCollect2 = flowKt__LimitKt$take$$inlined$unsafeFlow$1.collect(nopCollector, this);
                    if (objCollect2 != coroutineSingletons) {
                        objCollect2 = unit;
                    }
                    return objCollect2 == coroutineSingletons ? coroutineSingletons : unit;
            }
        }
    }

    public HazeSourceNode(HazeState hazeState) {
        HazeArea hazeArea = new HazeArea();
        this.area = hazeArea;
        hazeArea.zIndex$delegate.setFloatValue(CropImageView.DEFAULT_ASPECT_RATIO);
        this.state = hazeState;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0039 A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:3:0x0004, B:7:0x0010, B:9:0x0020, B:11:0x002e, B:20:0x0042, B:19:0x0039, B:21:0x004e), top: B:25:0x0004 }] */
    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        HazeArea hazeArea = this.area;
        try {
            hazeArea.contentDrawing = true;
            if (this.isAttached) {
                if (MathKt.roundToInt(Size.m448getMinDimensionimpl(layoutNodeDrawScope.canvasDrawScope.mo556getSizeNHjbRc())) >= 1) {
                    GraphicsContext graphicsContext = (GraphicsContext) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalGraphicsContext);
                    GraphicsLayer contentLayer = hazeArea.getContentLayer();
                    if (contentLayer == null) {
                        contentLayer = graphicsContext.createGraphicsLayer();
                        hazeArea.contentLayer$delegate.setValue(contentLayer);
                    } else {
                        if (contentLayer.isReleased) {
                            contentLayer = null;
                        }
                        if (contentLayer == null) {
                            contentLayer = graphicsContext.createGraphicsLayer();
                            hazeArea.contentLayer$delegate.setValue(contentLayer);
                        }
                    }
                    layoutNodeDrawScope.m651recordJVtK1S4(SizeKt.m875toIntSizeuvyYCjk(layoutNodeDrawScope.canvasDrawScope.mo556getSizeNHjbRc()), contentLayer, new HazeEffectNode$$ExternalSyntheticLambda2(layoutNodeDrawScope, contentLayer));
                    LifecyclesKt.drawLayer(layoutNodeDrawScope, contentLayer);
                } else {
                    CanvasKt.drawContentSafely(layoutNodeDrawScope);
                }
            }
        } finally {
            hazeArea.contentDrawing = false;
            launchPreDraw();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public final Object getTraverseKey() {
        return HazeTraversableNodeKeys.Source;
    }

    public final StandaloneCoroutine launchPreDraw() {
        return AwaitKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass1(this, null, (byte) 0), 3);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        Continuation continuation;
        ComponentActivity componentActivity;
        HazeState hazeState = this.state;
        hazeState.getClass();
        HazeArea hazeArea = this.area;
        hazeArea.getClass();
        hazeState._areas.add(hazeArea);
        Context baseContext = (Context) HitTestResultKt.currentValueOf(this, AndroidCompositionLocals_androidKt.LocalContext);
        while (true) {
            continuation = null;
            if (!(baseContext instanceof ComponentActivity)) {
                if (!(baseContext instanceof ContextWrapper)) {
                    componentActivity = null;
                    break;
                } else {
                    baseContext = ((ContextWrapper) baseContext).getBaseContext();
                    baseContext.getClass();
                }
            } else {
                componentActivity = (ComponentActivity) baseContext;
                break;
            }
        }
        if (componentActivity != null) {
            AwaitKt.launch$default(getCoroutineScope(), null, null, new ShimmerModifierKt$shimmer$1$1((Object) componentActivity, (Object) this, continuation, (byte) 4), 3);
        }
        onObservedReadsChanged();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        HazeArea hazeArea = this.area;
        hazeArea.positionOnScreen$delegate.setValue(new Offset(9205357640488583168L));
        hazeArea.size$delegate.setValue(new Size(9205357640488583168L));
        hazeArea.contentDrawing = false;
        GraphicsLayer contentLayer = hazeArea.getContentLayer();
        if (contentLayer != null) {
            ((GraphicsContext) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalGraphicsContext)).releaseGraphicsLayer(contentLayer);
        }
        hazeArea.contentLayer$delegate.setValue(null);
        HazeState hazeState = this.state;
        hazeState.getClass();
        hazeState._areas.remove(hazeArea);
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public final void onGloballyPositioned(NodeCoordinator nodeCoordinator) {
        if (this.isAttached) {
            long jMo607localToScreenMKHz9U = nodeCoordinator.mo607localToScreenMKHz9U(0L);
            HazeArea hazeArea = this.area;
            hazeArea.positionOnScreen$delegate.setValue(new Offset(jMo607localToScreenMKHz9U));
            hazeArea.size$delegate.setValue(new Size(SizeKt.m876toSizeozmzZPI(nodeCoordinator.mo603getSizeYbymL2g())));
            hazeArea.windowId = ((View) HitTestResultKt.currentValueOf(this, AndroidCompositionLocals_androidKt.LocalView)).getWindowId();
        }
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        HitTestResultKt.observeReads(this, new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 22, this));
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public final void onPlaced(LayoutCoordinates layoutCoordinates) {
        HazeArea hazeArea = this.area;
        layoutCoordinates.getClass();
        Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if ((hazeArea.m1541getPositionOnScreenF1C5BW0() & 9223372034707292159L) == 9205357640488583168L && this.isAttached) {
                hazeArea.positionOnScreen$delegate.setValue(new Offset(layoutCoordinates.mo607localToScreenMKHz9U(0L)));
                hazeArea.size$delegate.setValue(new Size(SizeKt.m876toSizeozmzZPI(layoutCoordinates.mo603getSizeYbymL2g())));
                hazeArea.windowId = ((View) HitTestResultKt.currentValueOf(this, AndroidCompositionLocals_androidKt.LocalView)).getWindowId();
            }
        } finally {
            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onReset() {
        HazeArea hazeArea = this.area;
        hazeArea.positionOnScreen$delegate.setValue(new Offset(9205357640488583168L));
        hazeArea.size$delegate.setValue(new Size(9205357640488583168L));
        hazeArea.contentDrawing = false;
    }
}
