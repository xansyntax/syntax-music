package coil3.compose;

import android.os.Trace;
import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.MarqueeModifierNode;
import androidx.compose.foundation.gestures.TrackpadScrollingLogicImpl;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerNode;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.ProduceStateScopeImpl;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.datastore.core.DataStoreImpl;
import androidx.navigation.NavHostController;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda2;
import androidx.room.Transactor;
import androidx.room.TriggerBasedInvalidationTracker;
import coil3.RealImageLoader;
import coil3.UriKt;
import coil3.compose.internal.DeferredDispatchCoroutineContext;
import coil3.compose.internal.DeferredDispatchCoroutineDispatcher;
import coil3.compose.internal.UtilsKt;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import coil3.request.ImageResult;
import coil3.request.SuccessResult;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.SizeResolver;
import coil3.transition.CrossfadeTransition;
import coil3.transition.Transition;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.base.Splitter;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertubex.cipher.QuickJsEngine;
import com.metrolist.music.MainActivity;
import com.metrolist.music.db.InternalDatabase;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.daos.SpeedDialDao_Impl;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.db.entities.SpeedDialItem;
import com.metrolist.music.eq.EqualizerService;
import com.metrolist.music.eq.data.EQProfileRepository;
import com.metrolist.music.eq.data.EQProfileRepository$deleteProfile$2;
import com.metrolist.music.eq.data.SavedEQProfile;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.screens.equalizer.EQState;
import com.metrolist.music.ui.screens.equalizer.EQViewModel;
import com.metrolist.music.viewmodels.AlbumViewModel;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.time.InstantKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AsyncImagePainter extends Painter implements RememberObserver {
    public static final RoomDatabase$$ExternalSyntheticLambda2 DefaultTransform = new RoomDatabase$$ExternalSyntheticLambda2((byte) 21);
    public Input _input;
    public BlendModeColorFilter colorFilter;
    public final StateFlowImpl inputFlow;
    public boolean isRemembered;
    public Function1 onState;
    public AsyncImagePreviewHandler$Companion$Default$1 previewHandler;
    public Job rememberJob;
    public CoroutineScope scope;
    public final ReadonlyStateFlow state;
    public final StateFlowImpl stateFlow;
    public final ParcelableSnapshotMutableState painter$delegate = Stack.mutableStateOf$default(null);
    public float alpha = 1.0f;
    public long drawSize = 9205357640488583168L;
    public Function1 transform = DefaultTransform;
    public ContentScale contentScale = ContentScale.Companion.Fit;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Input {
        public final RealImageLoader imageLoader;
        public final AsyncImageModelEqualityDelegate$Companion$Default$1 modelEqualityDelegate;
        public final ImageRequest request;

        public Input(RealImageLoader realImageLoader, ImageRequest imageRequest, AsyncImageModelEqualityDelegate$Companion$Default$1 asyncImageModelEqualityDelegate$Companion$Default$1) {
            this.imageLoader = realImageLoader;
            this.request = imageRequest;
            this.modelEqualityDelegate = asyncImageModelEqualityDelegate$Companion$Default$1;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Input)) {
                return false;
            }
            Input input = (Input) obj;
            if (this.imageLoader != input.imageLoader) {
                return false;
            }
            AsyncImageModelEqualityDelegate$Companion$Default$1 asyncImageModelEqualityDelegate$Companion$Default$1 = input.modelEqualityDelegate;
            AsyncImageModelEqualityDelegate$Companion$Default$1 asyncImageModelEqualityDelegate$Companion$Default$2 = this.modelEqualityDelegate;
            return Intrinsics.areEqual(asyncImageModelEqualityDelegate$Companion$Default$2, asyncImageModelEqualityDelegate$Companion$Default$1) && asyncImageModelEqualityDelegate$Companion$Default$2.equals(this.request, input.request);
        }

        public final int hashCode() {
            int iHashCode = this.imageLoader.hashCode() * 31;
            AsyncImageModelEqualityDelegate$Companion$Default$1 asyncImageModelEqualityDelegate$Companion$Default$1 = this.modelEqualityDelegate;
            return asyncImageModelEqualityDelegate$Companion$Default$1.hashCode(this.request) + ((asyncImageModelEqualityDelegate$Companion$Default$1.hashCode() + iHashCode) * 31);
        }

        public final String toString() {
            return "Input(imageLoader=" + this.imageLoader + ", request=" + this.request + ", modelEqualityDelegate=" + this.modelEqualityDelegate + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface State {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Empty implements State {
            public static final Empty INSTANCE = new Empty();

            public final boolean equals(Object obj) {
                return this == obj || (obj instanceof Empty);
            }

            @Override // coil3.compose.AsyncImagePainter.State
            public final Painter getPainter() {
                return null;
            }

            public final int hashCode() {
                return -1625786264;
            }

            public final String toString() {
                return "Empty";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Error implements State {
            public final Painter painter;
            public final ErrorResult result;

            public Error(Painter painter, ErrorResult errorResult) {
                this.painter = painter;
                this.result = errorResult;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Error)) {
                    return false;
                }
                Error error = (Error) obj;
                return Intrinsics.areEqual(this.painter, error.painter) && this.result.equals(error.result);
            }

            @Override // coil3.compose.AsyncImagePainter.State
            public final Painter getPainter() {
                return this.painter;
            }

            public final int hashCode() {
                Painter painter = this.painter;
                return this.result.hashCode() + ((painter == null ? 0 : painter.hashCode()) * 31);
            }

            public final String toString() {
                return "Error(painter=" + this.painter + ", result=" + this.result + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Loading implements State {
            public final Painter painter;

            public Loading(Painter painter) {
                this.painter = painter;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Loading) && Intrinsics.areEqual(this.painter, ((Loading) obj).painter);
            }

            @Override // coil3.compose.AsyncImagePainter.State
            public final Painter getPainter() {
                return this.painter;
            }

            public final int hashCode() {
                Painter painter = this.painter;
                if (painter == null) {
                    return 0;
                }
                return painter.hashCode();
            }

            public final String toString() {
                return "Loading(painter=" + this.painter + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class Success implements State {
            public final Painter painter;
            public final SuccessResult result;

            public Success(Painter painter, SuccessResult successResult) {
                this.painter = painter;
                this.result = successResult;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Success)) {
                    return false;
                }
                Success success = (Success) obj;
                return this.painter.equals(success.painter) && this.result.equals(success.result);
            }

            @Override // coil3.compose.AsyncImagePainter.State
            public final Painter getPainter() {
                return this.painter;
            }

            public final int hashCode() {
                return this.result.hashCode() + (this.painter.hashCode() * 31);
            }

            public final String toString() {
                return "Success(painter=" + this.painter + ", result=" + this.result + ")";
            }
        }

        Painter getPainter();
    }

    public AsyncImagePainter(Input input) {
        this._input = input;
        this.inputFlow = StateFlowKt.MutableStateFlow(input);
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(State.Empty.INSTANCE);
        this.stateFlow = stateFlowImplMutableStateFlow;
        this.state = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean applyAlpha(float f) {
        this.alpha = f;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean applyColorFilter(BlendModeColorFilter blendModeColorFilter) {
        this.colorFilter = blendModeColorFilter;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public final long mo573getIntrinsicSizeNHjbRc() {
        Painter painter = getPainter();
        if (painter != null) {
            return painter.mo573getIntrinsicSizeNHjbRc();
        }
        return 9205357640488583168L;
    }

    public final Painter getPainter() {
        return (Painter) this.painter$delegate.getValue();
    }

    public final void launchJob() {
        Input input = this._input;
        if (input == null) {
            return;
        }
        CoroutineScope coroutineScope = this.scope;
        Continuation continuation = null;
        if (coroutineScope == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scope");
            throw null;
        }
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this, input, continuation, (byte) 0);
        CoroutineContext coroutineContext = coroutineScope.getCoroutineContext();
        int i = UtilsKt.$r8$clinit;
        CoroutineContext.Element element = coroutineContext.get(ContinuationInterceptor$Key.$$INSTANCE);
        CoroutineDispatcher coroutineDispatcher = element instanceof CoroutineDispatcher ? (CoroutineDispatcher) element : null;
        CoroutineStart coroutineStart = CoroutineStart.UNDISPATCHED;
        StandaloneCoroutine standaloneCoroutineLaunch = (coroutineDispatcher == null || coroutineDispatcher.equals(Dispatchers.Unconfined)) ? AwaitKt.launch(coroutineScope, Dispatchers.Unconfined, coroutineStart, anonymousClass1) : AwaitKt.launch(AwaitKt.CoroutineScope(new DeferredDispatchCoroutineContext(coroutineScope.getCoroutineContext())), new DeferredDispatchCoroutineDispatcher(coroutineDispatcher), coroutineStart, anonymousClass1);
        Job job = this.rememberJob;
        if (job != null) {
            job.cancel(null);
        }
        this.rememberJob = standaloneCoroutineLaunch;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
        Job job = this.rememberJob;
        if (job != null) {
            job.cancel(null);
        }
        this.rememberJob = null;
        Object painter = getPainter();
        RememberObserver rememberObserver = painter instanceof RememberObserver ? (RememberObserver) painter : null;
        if (rememberObserver != null) {
            rememberObserver.onAbandoned();
        }
        this.isRemembered = false;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void onDraw(LayoutNodeDrawScope layoutNodeDrawScope) {
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        long jMo556getSizeNHjbRc = canvasDrawScope.mo556getSizeNHjbRc();
        if (!Size.m447equalsimpl0(this.drawSize, jMo556getSizeNHjbRc)) {
            this.drawSize = jMo556getSizeNHjbRc;
        }
        Painter painter = getPainter();
        if (painter != null) {
            painter.m575drawx_KDEd0(layoutNodeDrawScope, canvasDrawScope.mo556getSizeNHjbRc(), this.alpha, this.colorFilter);
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        Job job = this.rememberJob;
        if (job != null) {
            job.cancel(null);
        }
        this.rememberJob = null;
        Object painter = getPainter();
        RememberObserver rememberObserver = painter instanceof RememberObserver ? (RememberObserver) painter : null;
        if (rememberObserver != null) {
            rememberObserver.onForgotten();
        }
        this.isRemembered = false;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
        Trace.beginSection("AsyncImagePainter.onRemembered");
        try {
            Object painter = getPainter();
            RememberObserver rememberObserver = painter instanceof RememberObserver ? (RememberObserver) painter : null;
            if (rememberObserver != null) {
                rememberObserver.onRemembered();
            }
            launchJob();
            this.isRemembered = true;
        } finally {
            Trace.endSection();
        }
    }

    public final void set_input$io_coil_kt_coil3_coil_compose_core(Input input) {
        if (Intrinsics.areEqual(this._input, input)) {
            return;
        }
        this._input = input;
        if (input == null) {
            Job job = this.rememberJob;
            if (job != null) {
                job.cancel(null);
            }
            this.rememberJob = null;
        } else if (this.isRemembered) {
            launchJob();
        }
        if (input != null) {
            this.inputFlow.updateState(null, input);
        }
    }

    public final ImageRequest updateRequest(ImageRequest imageRequest, boolean z) {
        ImageRequest.Builder builderNewBuilder$default = ImageRequest.newBuilder$default(imageRequest);
        builderNewBuilder$default.target = new Splitter(imageRequest, this, (byte) 7);
        ImageRequest.Defined defined = imageRequest.defined;
        if (defined.sizeResolver == null) {
            builderNewBuilder$default.sizeResolver = SizeResolver.ORIGINAL;
        }
        if (defined.scale == null) {
            ContentScale contentScale = this.contentScale;
            int i = UtilsKt.$r8$clinit;
            builderNewBuilder$default.scale = (Intrinsics.areEqual(contentScale, ContentScale.Companion.Fit) || Intrinsics.areEqual(contentScale, ContentScale.Companion.Inside)) ? Scale.FIT : Scale.FILL;
        }
        if (defined.precision == null) {
            builderNewBuilder$default.precision = Precision.INEXACT;
        }
        if (z) {
            EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
            builderNewBuilder$default.interceptorCoroutineContext = emptyCoroutineContext;
            builderNewBuilder$default.fetcherCoroutineContext = emptyCoroutineContext;
            builderNewBuilder$default.decoderCoroutineContext = emptyCoroutineContext;
        }
        return builderNewBuilder$default.build();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0080  */
    /* JADX WARN: Code duplicated, block: B:26:0x0084  */
    /* JADX WARN: Code duplicated, block: B:29:0x0097  */
    /* JADX WARN: Code duplicated, block: B:31:0x009f  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:44:? A[RETURN, SYNTHETIC] */
    public final void updateState(State state) {
        ImageResult imageResult;
        Painter painter;
        Function1 function1;
        Object painter2;
        RememberObserver rememberObserver;
        RememberObserver rememberObserver2;
        StateFlowImpl stateFlowImpl = this.stateFlow;
        State state2 = (State) stateFlowImpl.getValue();
        State state3 = (State) this.transform.invoke(state);
        stateFlowImpl.setValue(state3);
        ContentScale contentScale = this.contentScale;
        if (!(state3 instanceof State.Success)) {
            if (state3 instanceof State.Error) {
                imageResult = ((State.Error) state3).result;
            } else {
                painter = null;
            }
            if (painter == null) {
                painter = state3.getPainter();
            }
            this.painter$delegate.setValue(painter);
            if (state2.getPainter() != state3.getPainter()) {
                painter2 = state2.getPainter();
                if (painter2 instanceof RememberObserver) {
                    rememberObserver = (RememberObserver) painter2;
                } else {
                    rememberObserver = null;
                }
                if (rememberObserver != null) {
                    rememberObserver.onForgotten();
                }
                Object painter3 = state3.getPainter();
                rememberObserver2 = painter3 instanceof RememberObserver ? (RememberObserver) painter3 : null;
                if (rememberObserver2 != null) {
                    rememberObserver2.onRemembered();
                }
            }
            function1 = this.onState;
            if (function1 != null) {
                function1.invoke(state3);
            }
        }
        imageResult = ((State.Success) state3).result;
        Transition transitionCreate = ((Transition.Factory) UriKt.getExtra(imageResult.getRequest(), ImageRequests_androidKt.transitionFactoryKey)).create(AsyncImageKt.FakeTransitionTarget, imageResult);
        if (transitionCreate instanceof CrossfadeTransition) {
            Painter painter4 = state2.getPainter();
            if (!(state2 instanceof State.Loading)) {
                painter4 = null;
            }
            Painter painter5 = state3.getPainter();
            Path.Companion companion = Duration.Companion;
            painter = new CrossfadePainter(painter4, painter5, contentScale, InstantKt.toDuration(((CrossfadeTransition) transitionCreate).durationMillis, DurationUnit.MILLISECONDS), ((imageResult instanceof SuccessResult) && ((SuccessResult) imageResult).isPlaceholderCached) ? false : true, ((Boolean) UriKt.getExtra(imageResult.getRequest(), AsyncImageKt.preferEndFirstIntrinsicSizeKey)).booleanValue());
        } else {
            painter = null;
        }
        if (painter == null) {
            painter = state3.getPainter();
        }
        this.painter$delegate.setValue(painter);
        if (state2.getPainter() != state3.getPainter()) {
            painter2 = state2.getPainter();
            if (painter2 instanceof RememberObserver) {
                rememberObserver = (RememberObserver) painter2;
            } else {
                rememberObserver = null;
            }
            if (rememberObserver != null) {
                rememberObserver.onForgotten();
            }
            Object painter6 = state3.getPainter();
            if (painter6 instanceof RememberObserver) {
            }
            if (rememberObserver2 != null) {
                rememberObserver2.onRemembered();
            }
        }
        function1 = this.onState;
        if (function1 != null) {
            function1.invoke(state3);
        }
    }

    /* JADX INFO: renamed from: coil3.compose.AsyncImagePainter$launchJob$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Object $input;
        public final /* synthetic */ byte $r8$classId;
        public Object L$2;
        public byte label;
        public Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(Object obj, Object obj2, Object obj3, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.L$2 = obj;
            this.this$0 = obj2;
            this.$input = obj3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
        
            if (r2.delete(r1, r19) == r6) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0074, code lost:
        
            if (r2.insert(r7, r19) == r6) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0076, code lost:
        
            return r6;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final Object invokeSuspend$com$metrolist$music$ui$menu$PlaylistMenuKt$PlaylistMenu$12$1$3$1$4$1$1(Object obj) {
            Playlist playlist = (Playlist) this.this$0;
            byte b = this.label;
            if (b == 0) {
                ResultKt.throwOnFailure(obj);
                boolean zBooleanValue = ((Boolean) ((androidx.compose.runtime.State) this.$input).getValue()).booleanValue();
                InternalDatabase internalDatabase = ((MusicDatabase) this.L$2).delegate;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (zBooleanValue) {
                    SpeedDialDao_Impl speedDialDao = internalDatabase.getSpeedDialDao();
                    String str = playlist.playlist.id;
                    this.label = (byte) 1;
                } else {
                    SpeedDialDao_Impl speedDialDao2 = internalDatabase.getSpeedDialDao();
                    PlaylistEntity playlistEntity = playlist.playlist;
                    SpeedDialItem speedDialItem = new SpeedDialItem(playlistEntity.id, (String) null, playlistEntity.name, (String) null, (String) null, (String) CollectionsKt.firstOrNull(playlist.getThumbnails()), "LOCAL_PLAYLIST", false, (String) null, (String) null, 1922);
                    this.label = (byte) 2;
                }
            } else {
                if (b != 1 && b != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
        
            if (r1.delete(r2, r21) == r8) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x00a3, code lost:
        
            if (r3.insert(r9, r21) == r8) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00a5, code lost:
        
            return r8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final Object invokeSuspend$com$metrolist$music$ui$menu$SongMenuKt$SongMenu$14$1$3$1$3$1$1(Object obj) throws IOException {
            Song song = (Song) this.this$0;
            SongEntity songEntity = song.song;
            byte b = this.label;
            if (b == 0) {
                ResultKt.throwOnFailure(obj);
                boolean zBooleanValue = ((Boolean) ((androidx.compose.runtime.State) this.$input).getValue()).booleanValue();
                InternalDatabase internalDatabase = ((MusicDatabase) this.L$2).delegate;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (zBooleanValue) {
                    SpeedDialDao_Impl speedDialDao = internalDatabase.getSpeedDialDao();
                    String str = songEntity.id;
                    this.label = (byte) 1;
                } else {
                    SpeedDialDao_Impl speedDialDao2 = internalDatabase.getSpeedDialDao();
                    String str2 = songEntity.id;
                    String str3 = songEntity.title;
                    String strJoinToString$default = CollectionsKt.joinToString$default(song.artists, ", ", null, null, new SongMenuKt$$ExternalSyntheticLambda16((byte) 14), 30);
                    String strJoinToString$default2 = CollectionsKt.joinToString$default(song.artists, ", ", null, null, new SongMenuKt$$ExternalSyntheticLambda16((byte) 15), 30);
                    String str4 = songEntity.thumbnailUrl;
                    boolean z = songEntity.explicit;
                    AlbumEntity albumEntity = song.album;
                    SpeedDialItem speedDialItem = new SpeedDialItem(str2, (String) null, str3, strJoinToString$default, strJoinToString$default2, str4, "SONG", z, albumEntity != null ? albumEntity.id : null, albumEntity != null ? albumEntity.title : null, 258);
                    this.label = (byte) 2;
                }
            } else {
                if (b != 1 && b != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
        
            if (r6.delete(r0, r5) == r4) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
        
            if (r6.insert(r0, r5) == r4) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
        
            return r4;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final Object invokeSuspend$com$metrolist$music$ui$menu$YouTubeArtistMenuKt$YouTubeArtistMenu$1$1$1$1$3$1$1(Object obj) throws IOException {
            ArtistItem artistItem = (ArtistItem) this.this$0;
            byte b = this.label;
            if (b == 0) {
                ResultKt.throwOnFailure(obj);
                boolean zBooleanValue = ((Boolean) ((androidx.compose.runtime.State) this.$input).getValue()).booleanValue();
                InternalDatabase internalDatabase = ((MusicDatabase) this.L$2).delegate;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (zBooleanValue) {
                    SpeedDialDao_Impl speedDialDao = internalDatabase.getSpeedDialDao();
                    String str = artistItem.id;
                    this.label = (byte) 1;
                } else {
                    SpeedDialDao_Impl speedDialDao2 = internalDatabase.getSpeedDialDao();
                    SpeedDialItem speedDialItemFromYTItem = UuidKt.fromYTItem(artistItem);
                    this.label = (byte) 2;
                }
            } else {
                if (b != 1 && b != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
        
            if (r6.delete(r0, r5) == r4) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
        
            if (r6.insert(r0, r5) == r4) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
        
            return r4;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final Object invokeSuspend$com$metrolist$music$ui$menu$YouTubePlaylistMenuKt$YouTubePlaylistMenu$14$1$2$6$1$1(Object obj) throws IOException {
            PlaylistItem playlistItem = (PlaylistItem) this.this$0;
            byte b = this.label;
            if (b == 0) {
                ResultKt.throwOnFailure(obj);
                boolean zBooleanValue = ((Boolean) ((androidx.compose.runtime.State) this.$input).getValue()).booleanValue();
                InternalDatabase internalDatabase = ((MusicDatabase) this.L$2).delegate;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (zBooleanValue) {
                    SpeedDialDao_Impl speedDialDao = internalDatabase.getSpeedDialDao();
                    String str = playlistItem.id;
                    this.label = (byte) 1;
                } else {
                    SpeedDialDao_Impl speedDialDao2 = internalDatabase.getSpeedDialDao();
                    SpeedDialItem speedDialItemFromYTItem = UuidKt.fromYTItem(playlistItem);
                    this.label = (byte) 2;
                }
            } else {
                if (b != 1 && b != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0073, code lost:
        
            if (kotlinx.coroutines.AwaitKt.delay(500, r6) == r5) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final Object invokeSuspend$com$metrolist$music$ui$menu$YouTubeSongMenuKt$YouTubeSongMenu$11$1$3$1$3$1$1(Object obj) {
            Object objM1006feedbackgIAlus;
            SongItem songItem = (SongItem) this.L$2;
            byte b = this.label;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (b != 0) {
                if (b == 1) {
                    ResultKt.throwOnFailure(obj);
                    objM1006feedbackgIAlus = ((Result) obj).value;
                } else {
                    if (b != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ((Function0) this.this$0).invoke();
                ((Function0) this.$input).invoke();
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            ConnectionPool connectionPool = Timber.Forest;
            String str = songItem.id;
            connectionPool.getClass();
            ConnectionPool.d(new Object[0]);
            YouTube youTube = YouTube.INSTANCE;
            String str2 = songItem.historyRemoveToken;
            str2.getClass();
            List listListOf = CollectionsKt__IterablesKt.listOf(str2);
            this.label = (byte) 1;
            objM1006feedbackgIAlus = youTube.m1006feedbackgIAlus(listListOf, this);
            if (objM1006feedbackgIAlus != coroutineSingletons) {
            }
            return coroutineSingletons;
            if (!(objM1006feedbackgIAlus instanceof Result.Failure)) {
                ((Boolean) objM1006feedbackgIAlus).getClass();
                Timber.Forest.getClass();
                ConnectionPool.d(new Object[0]);
            }
            if (Result.m1866exceptionOrNullimpl(objM1006feedbackgIAlus) != null) {
                Timber.Forest.getClass();
                ConnectionPool.e$1(new Object[0]);
            }
            this.label = (byte) 2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
        
            if (r6.delete(r0, r5) == r4) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
        
            if (r6.insert(r0, r5) == r4) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
        
            return r4;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final Object invokeSuspend$com$metrolist$music$ui$menu$YouTubeSongMenuKt$YouTubeSongMenu$11$1$3$1$6$1$1(Object obj) throws IOException {
            SongItem songItem = (SongItem) this.this$0;
            byte b = this.label;
            if (b == 0) {
                ResultKt.throwOnFailure(obj);
                boolean zBooleanValue = ((Boolean) ((androidx.compose.runtime.State) this.$input).getValue()).booleanValue();
                InternalDatabase internalDatabase = ((MusicDatabase) this.L$2).delegate;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (zBooleanValue) {
                    SpeedDialDao_Impl speedDialDao = internalDatabase.getSpeedDialDao();
                    String str = songItem.id;
                    this.label = (byte) 1;
                } else {
                    SpeedDialDao_Impl speedDialDao2 = internalDatabase.getSpeedDialDao();
                    SpeedDialItem speedDialItemFromYTItem = UuidKt.fromYTItem(songItem);
                    this.label = (byte) 2;
                }
            } else {
                if (b != 1 && b != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: Code duplicated, block: B:39:0x00a5 A[LOOP:0: B:39:0x00a5->B:46:?, LOOP_START] */
        /* JADX WARN: Code duplicated, block: B:41:0x00b2  */
        /* JADX WARN: Multi-variable type inference failed */
        private final Object invokeSuspend$com$metrolist$music$ui$screens$equalizer$EQViewModel$selectProfile$1(Object obj) {
            Object next;
            Object objM1068applyProfileIoAF18A;
            Object obj2;
            Throwable thM1866exceptionOrNullimpl;
            Object value;
            EQState eQState;
            String message;
            String str = (String) this.this$0;
            EQViewModel eQViewModel = (EQViewModel) this.$input;
            StateFlowImpl stateFlowImpl = eQViewModel._state;
            EQProfileRepository eQProfileRepository = eQViewModel.eqProfileRepository;
            EqualizerService equalizerService = eQViewModel.equalizerService;
            byte b = this.label;
            Unit unit = Unit.INSTANCE;
            byte b2 = 1;
            String str2 = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            if (b == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (str == null) {
                    equalizerService.disable();
                    this.label = (byte) 1;
                    eQProfileRepository.getClass();
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    Object objWithContext = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new EQProfileRepository$deleteProfile$2(eQProfileRepository, str2, objArr2 == true ? 1 : 0, b2), this);
                    if (objWithContext != coroutineSingletons) {
                        objWithContext = unit;
                    }
                    if (objWithContext == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    Iterator it = ((EQState) stateFlowImpl.getValue()).profiles.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!Intrinsics.areEqual(((SavedEQProfile) next).id, str));
                    SavedEQProfile savedEQProfile = (SavedEQProfile) next;
                    if (savedEQProfile != null) {
                        objM1068applyProfileIoAF18A = equalizerService.m1068applyProfileIoAF18A(savedEQProfile);
                        if (!(objM1068applyProfileIoAF18A instanceof Result.Failure)) {
                            this.L$2 = objM1068applyProfileIoAF18A;
                            this.label = (byte) 2;
                            eQProfileRepository.getClass();
                            DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                            Object objWithContext2 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new EQProfileRepository$deleteProfile$2(eQProfileRepository, str, objArr == true ? 1 : 0, b2), this);
                            if (objWithContext2 != coroutineSingletons) {
                                objWithContext2 = unit;
                            }
                            if (objWithContext2 != coroutineSingletons) {
                                obj2 = objM1068applyProfileIoAF18A;
                                objM1068applyProfileIoAF18A = obj2;
                                thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1068applyProfileIoAF18A);
                                if (thM1866exceptionOrNullimpl != null) {
                                    do {
                                        value = stateFlowImpl.getValue();
                                        eQState = (EQState) value;
                                        message = thM1866exceptionOrNullimpl.getMessage();
                                        if (message == null) {
                                            message = "Unknown error";
                                        }
                                    } while (!stateFlowImpl.compareAndSet(value, EQState.copy$default(eQState, null, null, null, message, 7)));
                                }
                            }
                            return coroutineSingletons;
                        }
                        thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1068applyProfileIoAF18A);
                        if (thM1866exceptionOrNullimpl != null) {
                            do {
                                value = stateFlowImpl.getValue();
                                eQState = (EQState) value;
                                message = thM1866exceptionOrNullimpl.getMessage();
                                if (message == null) {
                                    message = "Unknown error";
                                }
                            } while (!stateFlowImpl.compareAndSet(value, EQState.copy$default(eQState, null, null, null, message, 7)));
                        }
                    }
                }
            } else if (b == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (b != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                obj2 = this.L$2;
                ResultKt.throwOnFailure(obj);
                objM1068applyProfileIoAF18A = obj2;
                thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1068applyProfileIoAF18A);
                if (thM1866exceptionOrNullimpl != null) {
                    do {
                        value = stateFlowImpl.getValue();
                        eQState = (EQState) value;
                        message = thM1866exceptionOrNullimpl.getMessage();
                        if (message == null) {
                            message = "Unknown error";
                        }
                    } while (!stateFlowImpl.compareAndSet(value, EQState.copy$default(eQState, null, null, null, message, 7)));
                }
            }
            return unit;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
        
            if (r2.delete(r1, r19) == r6) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
        
            if (r2.insert(r7, r19) == r6) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x006c, code lost:
        
            return r6;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final Object invokeSuspend$com$metrolist$music$ui$screens$library$LibraryPodcastsScreenKt$PodcastEpisodePlaylistMenu$5$1$1(Object obj) {
            PodcastEntity podcastEntity = (PodcastEntity) this.this$0;
            byte b = this.label;
            if (b == 0) {
                ResultKt.throwOnFailure(obj);
                boolean zBooleanValue = ((Boolean) ((androidx.compose.runtime.State) this.$input).getValue()).booleanValue();
                MusicDatabase musicDatabase = (MusicDatabase) this.L$2;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (zBooleanValue) {
                    SpeedDialDao_Impl speedDialDao = musicDatabase.delegate.getSpeedDialDao();
                    String str = podcastEntity.id;
                    this.label = (byte) 1;
                } else {
                    SpeedDialDao_Impl speedDialDao2 = musicDatabase.delegate.getSpeedDialDao();
                    SpeedDialItem speedDialItem = new SpeedDialItem(podcastEntity.id, (String) null, podcastEntity.title, podcastEntity.author, (String) null, podcastEntity.thumbnailUrl, "PLAYLIST", false, (String) null, (String) null, 1938);
                    this.label = (byte) 2;
                }
            } else {
                if (b != 1 && b != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj2 = this.$input;
            switch (b) {
                case 0:
                    return new AnonymousClass1((AsyncImagePainter) this.this$0, (Input) obj2, continuation, (byte) 0);
                case 1:
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1((MarqueeModifierNode) obj2, continuation, (byte) 1);
                    anonymousClass1.this$0 = obj;
                    return anonymousClass1;
                case 2:
                    AnonymousClass1 anonymousClass2 = new AnonymousClass1((Job) this.this$0, (Function2) obj2, continuation, (byte) 2);
                    anonymousClass2.L$2 = obj;
                    return anonymousClass2;
                case 3:
                    AnonymousClass1 anonymousClass3 = new AnonymousClass1((TrackpadScrollingLogicImpl) obj2, continuation, (byte) 3);
                    anonymousClass3.this$0 = obj;
                    return anonymousClass3;
                case 4:
                    return new AnonymousClass1((TextContextMenuToolbarHandlerNode) this.this$0, (TextContextMenuProvider) obj2, continuation, (byte) 4);
                case 5:
                    AnonymousClass1 anonymousClass4 = new AnonymousClass1((Function0) this.this$0, (Animatable) obj2, continuation, (byte) 5);
                    anonymousClass4.L$2 = obj;
                    return anonymousClass4;
                case 6:
                    return new AnonymousClass1((MutableStateFlow) this.this$0, (TooltipStateImpl) obj2, continuation, (byte) 6);
                case 7:
                    AnonymousClass1 anonymousClass5 = new AnonymousClass1((CoroutineContext) this.this$0, (Flow) obj2, continuation, (byte) 7);
                    anonymousClass5.L$2 = obj;
                    return anonymousClass5;
                case 8:
                    AnonymousClass1 anonymousClass6 = new AnonymousClass1((DataStoreImpl) obj2, continuation, (byte) 8);
                    anonymousClass6.this$0 = obj;
                    return anonymousClass6;
                case 9:
                    AnonymousClass1 anonymousClass7 = new AnonymousClass1((TriggerBasedInvalidationTracker) obj2, continuation, (byte) 9);
                    anonymousClass7.this$0 = obj;
                    return anonymousClass7;
                case 10:
                    return new AnonymousClass1((QuickJsEngine) obj2, continuation, (byte) 10);
                case 11:
                    return new AnonymousClass1((String) this.this$0, (NavHostController) obj2, continuation, (byte) 11);
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    return new AnonymousClass1((String) this.this$0, (MainActivity) obj2, continuation, (byte) 12);
                case 13:
                    return new AnonymousClass1((MusicService) obj2, continuation, (byte) 13);
                case 14:
                    return new AnonymousClass1((MusicDatabase) this.L$2, (Album) this.this$0, (androidx.compose.runtime.State) obj2, continuation, (byte) 14);
                case 15:
                    return new AnonymousClass1((MusicDatabase) this.L$2, (Artist) this.this$0, (androidx.compose.runtime.State) obj2, continuation, (byte) 15);
                case 16:
                    return new AnonymousClass1((MusicDatabase) this.L$2, (MediaMetadata) this.this$0, (androidx.compose.runtime.State) obj2, continuation, (byte) 16);
                case 17:
                    return new AnonymousClass1((MusicDatabase) this.L$2, (Playlist) this.this$0, (androidx.compose.runtime.State) obj2, continuation, (byte) 17);
                case 18:
                    return new AnonymousClass1((MusicDatabase) this.L$2, (Song) this.this$0, (androidx.compose.runtime.State) obj2, continuation, (byte) 18);
                case 19:
                    return new AnonymousClass1((MusicDatabase) this.L$2, (AlbumItem) this.this$0, (androidx.compose.runtime.State) obj2, continuation, (byte) 19);
                case 20:
                    return new AnonymousClass1((MusicDatabase) this.L$2, (ArtistItem) this.this$0, (androidx.compose.runtime.State) obj2, continuation, (byte) 20);
                case 21:
                    return new AnonymousClass1((MusicDatabase) this.L$2, (PlaylistItem) this.this$0, (androidx.compose.runtime.State) obj2, continuation, (byte) 21);
                case 22:
                    return new AnonymousClass1((SongItem) this.L$2, (Function0) this.this$0, (Function0) obj2, continuation, (byte) 22);
                case 23:
                    return new AnonymousClass1((MusicDatabase) this.L$2, (SongItem) this.this$0, (androidx.compose.runtime.State) obj2, continuation, (byte) 23);
                case 24:
                    return new AnonymousClass1((String) this.this$0, (EQViewModel) obj2, continuation, (byte) 24);
                case 25:
                    return new AnonymousClass1((MusicDatabase) this.L$2, (PodcastEntity) this.this$0, (androidx.compose.runtime.State) obj2, continuation, (byte) 25);
                default:
                    return new AnonymousClass1((MusicDatabase) this.this$0, (AlbumViewModel) obj2, continuation, (byte) 26);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 1:
                    return ((AnonymousClass1) create((Float) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 2:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 3:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 4:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 5:
                    return ((AnonymousClass1) create((Flow) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 6:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 7:
                    return ((AnonymousClass1) create((ProduceStateScopeImpl) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 8:
                    return ((AnonymousClass1) create((FlowCollector) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 9:
                    return ((AnonymousClass1) create((Transactor) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 10:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 11:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 13:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 14:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 15:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 16:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 17:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 18:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 19:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 20:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 21:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 22:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 23:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 24:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 25:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                default:
                    return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            }
        }

        /* JADX WARN: Code duplicated, block: B:465:0x082b A[Catch: all -> 0x0805, TryCatch #3 {all -> 0x0805, blocks: (B:454:0x0801, B:463:0x0821, B:465:0x082b, B:469:0x083d, B:460:0x0813), top: B:572:0x07f5 }] */
        /* JADX WARN: Code duplicated, block: B:467:0x083a  */
        /* JADX WARN: Code duplicated, block: B:468:0x083b  */
        /* JADX WARN: Code duplicated, block: B:472:0x084e  */
        /* JADX WARN: Code duplicated, block: B:524:0x0962  */
        /* JADX WARN: Code duplicated, block: B:525:0x0963 A[Catch: all -> 0x08d2, PHI: r0
          0x0963: PHI (r0v24 java.lang.Object) = (r0v23 java.lang.Object), (r0v28 java.lang.Object) binds: [B:523:0x0960, B:507:0x08ce] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #9 {all -> 0x08d2, blocks: (B:506:0x08cb, B:525:0x0963, B:522:0x094f), top: B:583:0x08ab }] */
        /* JADX WARN: Code duplicated, block: B:555:0x09ed  */
        /* JADX WARN: Code duplicated, block: B:557:0x0a00  */
        /* JADX WARN: Code duplicated, block: B:559:0x0a04  */
        /* JADX WARN: Code duplicated, block: B:561:0x0a0c  */
        /* JADX WARN: Code duplicated, block: B:564:0x0a1e  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0, types: [kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r10v3, types: [androidx.compose.ui.graphics.painter.Painter] */
        /* JADX WARN: Type inference failed for: r10v47 */
        /* JADX WARN: Type inference failed for: r2v124 */
        /* JADX WARN: Type inference failed for: r2v61, types: [byte] */
        /* JADX WARN: Type inference failed for: r2v65 */
        /* JADX WARN: Type inference failed for: r2v67 */
        /* JADX WARN: Type inference failed for: r2v68 */
        /* JADX WARN: Type inference failed for: r3v112 */
        /* JADX WARN: Type inference failed for: r3v113 */
        /* JADX WARN: Type inference failed for: r3v114 */
        /* JADX WARN: Type inference failed for: r3v56 */
        /* JADX WARN: Type inference failed for: r3v57, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r3v59, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v60, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r3v61 */
        /* JADX WARN: Type inference failed for: r6v25 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:472:0x084e -> B:463:0x0821). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r32) {
            /*
                Method dump skipped, instruction units count: 2650
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: coil3.compose.AsyncImagePainter.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(Object obj, Object obj2, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = obj;
            this.$input = obj2;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(Object obj, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.$input = obj;
        }
    }
}
