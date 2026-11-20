package com.metrolist.music.utils;

import android.content.Context;
import android.view.textclassifier.TextClassifier;
import android.widget.Toast;
import androidx.collection.MutableObjectList;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.DefaultDebugIndication;
import androidx.compose.foundation.FocusableNode;
import androidx.compose.foundation.MarqueeModifierNode;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.MouseWheelScrollingLogicImpl;
import androidx.compose.foundation.internal.ClipboardUtils;
import androidx.compose.foundation.relocation.BringIntoViewRequesterImpl;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LinkStateInteractionSourceObserver;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.input.internal.CursorAnimationState;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.AnalogTimePickerState;
import androidx.compose.material3.AnalogTimePickerState$onGestureEnd$2;
import androidx.compose.material3.ClockDialNode;
import androidx.compose.material3.SliderState;
import androidx.compose.material3.SliderState$$ExternalSyntheticLambda0;
import androidx.compose.material3.ThumbNode;
import androidx.compose.material3.ThumbNode$onAttach$1$1;
import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.material3.ripple.AndroidRippleNode;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.platform.AndroidClipboardImpl;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.font.AsyncFontListLoader;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.core.os.HandlerCompat$Api28Impl;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreImpl;
import androidx.datastore.core.SimpleActor$offer$2;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import androidx.room.InvalidationTracker;
import androidx.room.TriggerBasedInvalidationTracker;
import androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2;
import coil3.RealImageLoaderKt$CoroutineScope$$inlined$CoroutineExceptionHandler$1;
import coil3.compose.AsyncImagePainter;
import coil3.disk.DiskLruCache;
import coil3.disk.RealDiskCache;
import coil3.network.NetworkFetcher$doFetch$fetchResult$1;
import coil3.request.ViewTargetRequestDelegate;
import coil3.request.ViewTargetRequestManager;
import coil3.size.SizeKt;
import coil3.target.GenericViewTarget;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.dokar.quickjs.QuickJs;
import com.metrolist.innertube.InnerTube;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.MediaInfo;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.pages.ChartsPage;
import com.metrolist.innertube.pages.PlaylistPage;
import com.metrolist.innertubex.cipher.QuickJsEngine;
import com.metrolist.innertubex.extraction.InnerTubeExtractor;
import com.metrolist.lastfm.LastFM;
import com.metrolist.music.App;
import com.metrolist.music.constants.AddToPlaylistPosition;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.discord.DiscordRpcManager;
import com.metrolist.music.eq.data.GitHubAutoEqSearch$buildIndex$2;
import com.metrolist.music.extensions.CoroutineExtKt;
import com.metrolist.music.listentogether.ListenTogetherClient;
import com.metrolist.music.listentogether.ListenTogetherClient$blockUser$3;
import com.metrolist.music.listentogether.LogLevel;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$2$1$1;
import com.metrolist.music.ui.screens.equalizer.wizard.WizardState;
import com.metrolist.music.ui.screens.equalizer.wizard.WizardViewModel;
import com.metrolist.music.ui.screens.search.LocalSearchScreenKt$$ExternalSyntheticLambda5;
import com.metrolist.music.viewmodels.BackupRestoreViewModel;
import com.metrolist.music.viewmodels.ChartsViewModel;
import com.metrolist.music.viewmodels.HomeViewModel$2$1;
import com.metrolist.music.viewmodels.StatsViewModel;
import com.metrolist.music.viewmodels.StatsViewModel$syncMostPlaylistsIfNeeded$1;
import com.metrolist.music.widget.PlaylistWidgetManager$buildQuickPicks$2;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import dagger.hilt.EntryPoints;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt$$ExternalSyntheticLambda0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.text.Charsets;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import kotlinx.coroutines.SupervisorJobImpl;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonImpl;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.BlackholeSink;
import okio.RealBufferedSink;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SyncUtils {
    public static final /* synthetic */ int $r8$clinit = 0;
    public volatile long cachedLastSyncEpoch;
    public final Context context;
    public final MusicDatabase database;
    public long lastPlaylistEditAtMs;
    public boolean lastfmSendLikes;
    public final MutexImpl playlistEditMutex;
    public final ConcurrentHashMap playlistsBeingModified;
    public final ConcurrentHashMap.KeySetView queuedOperationKeys;
    public final BufferedChannel syncChannel;
    public final MutexImpl syncExecutionMutex;
    public final ContextScope syncScope;

    /* JADX INFO: renamed from: com.metrolist.music.utils.SyncUtils$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public boolean Z$0;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(Object obj, Continuation continuation, byte b) {
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
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2((SyncUtils) obj2, continuation, (byte) 0);
                    anonymousClass2.Z$0 = ((Boolean) obj).booleanValue();
                    return anonymousClass2;
                case 1:
                    return new AnonymousClass2((SeekableTransitionState) obj2, continuation, (byte) 1);
                case 2:
                    return new AnonymousClass2((DefaultDebugIndication.DefaultDebugIndicationInstance) obj2, continuation, (byte) 2);
                case 3:
                    return new AnonymousClass2((FocusableNode) obj2, continuation, (byte) 3);
                case 4:
                    return new AnonymousClass2((MarqueeModifierNode) obj2, continuation, (byte) 4);
                case 5:
                    return new AnonymousClass2((MouseWheelScrollingLogicImpl) obj2, continuation, (byte) 5);
                case 6:
                    return new AnonymousClass2((WeakCache) obj2, continuation, (byte) 6);
                case 7:
                    return new AnonymousClass2((CursorAnimationState) obj2, continuation, (byte) 7);
                case 8:
                    return new AnonymousClass2((LinkStateInteractionSourceObserver) obj2, continuation, (byte) 8);
                case 9:
                    return new AnonymousClass2((TextFieldSelectionManager) obj2, continuation, (byte) 9);
                case 10:
                    return new AnonymousClass2((ClockDialNode) obj2, continuation, (byte) 10);
                case 11:
                    return new AnonymousClass2((ThumbNode) obj2, continuation, (byte) 11);
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    return new AnonymousClass2((SyncUtils$executeLikeSong$2$1) obj2, continuation, (byte) 12);
                case 13:
                    return new AnonymousClass2((AndroidRippleNode) obj2, continuation, (byte) 13);
                case 14:
                    return new AnonymousClass2((AsyncFontListLoader) obj2, continuation, (byte) 14);
                case 15:
                    return new AnonymousClass2((DataStoreImpl) obj2, continuation, (byte) 15);
                case 16:
                    return new AnonymousClass2((InvalidationTracker) obj2, continuation, (byte) 16);
                case 17:
                    return new AnonymousClass2((TriggerBasedInvalidationTracker) obj2, continuation, (byte) 17);
                case 18:
                    return new AnonymousClass2((CompletableDeferredImpl) obj2, continuation, (byte) 18);
                case 19:
                    return new AnonymousClass2((SongItem) obj2, continuation, (byte) 19);
                case 20:
                    return new AnonymousClass2((InnerTubeExtractor) obj2, continuation, (byte) 20);
                case 21:
                    return new AnonymousClass2((AlbumEntity) obj2, continuation, (byte) 21);
                case 22:
                    return new AnonymousClass2((PlaylistEntity) obj2, continuation, (byte) 22);
                case 23:
                    return new AnonymousClass2((CompletableDeferred) obj2, continuation, (byte) 23);
                case 24:
                    return new AnonymousClass2((BottomSheetState) obj2, continuation, (byte) 24);
                case 25:
                    return new AnonymousClass2((Playlist) obj2, continuation, (byte) 25);
                case 26:
                    return new AnonymousClass2((BringIntoViewRequesterImpl) obj2, continuation, (byte) 26);
                case 27:
                    return new AnonymousClass2((WizardViewModel) obj2, continuation, (byte) 27);
                case 28:
                    return new AnonymousClass2((MediaMetadata) obj2, continuation, (byte) 28);
                default:
                    return new AnonymousClass2((ChartsViewModel) obj2, continuation, (byte) 29);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) throws Throwable {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    Boolean bool = (Boolean) obj;
                    bool.booleanValue();
                    ((AnonymousClass2) create(bool, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 1:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 2:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 3:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 4:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 5:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 6:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 7:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 8:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 9:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 10:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 11:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 13:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 14:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 15:
                    return ((AnonymousClass2) create((FlowCollector) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 16:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 17:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 18:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 19:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 20:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 21:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 22:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 23:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 24:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 25:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 26:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 27:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 28:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                default:
                    return ((AnonymousClass2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r9v0, types: [kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r9v10 */
        /* JADX WARN: Type inference failed for: r9v11 */
        /* JADX WARN: Type inference failed for: r9v13 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Clipboard clipboard;
            AnnotatedString selectedText;
            Object objM985getMediaInfogIAlus;
            Object value;
            Object objWithContext;
            Object value2;
            Object value3;
            Object objM1007getChartsPagegIAlus;
            byte b = this.$r8$classId;
            boolean z = false;
            Unit unit = Unit.INSTANCE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            Object obj2 = this.this$0;
            byte b2 = 1;
            AnnotatedString annotatedString = 0;
            annotatedString = 0;
            annotatedString = 0;
            switch (b) {
                case 0:
                    boolean z2 = this.Z$0;
                    ResultKt.throwOnFailure(obj);
                    ((SyncUtils) obj2).lastfmSendLikes = z2;
                    return unit;
                case 1:
                    boolean z3 = this.Z$0;
                    if (!z3) {
                        ResultKt.throwOnFailure(obj);
                        this.Z$0 = true;
                        return ((SeekableTransitionState) obj2).runAnimations(this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z3) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 2:
                    DefaultDebugIndication.DefaultDebugIndicationInstance defaultDebugIndicationInstance = (DefaultDebugIndication.DefaultDebugIndicationInstance) obj2;
                    boolean z4 = this.Z$0;
                    if (z4) {
                        if (z4) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Ref$IntRef ref$IntRef = new Ref$IntRef();
                    Ref$IntRef ref$IntRef2 = new Ref$IntRef();
                    Ref$IntRef ref$IntRef3 = new Ref$IntRef();
                    Flow interactions = defaultDebugIndicationInstance.interactionSource.getInteractions();
                    TriggerBasedInvalidationTracker$createFlow$1$2 triggerBasedInvalidationTracker$createFlow$1$2 = new TriggerBasedInvalidationTracker$createFlow$1$2(ref$IntRef, ref$IntRef2, ref$IntRef3, defaultDebugIndicationInstance, (byte) 1);
                    this.Z$0 = true;
                    return interactions.collect(triggerBasedInvalidationTracker$createFlow$1$2, this) == coroutineSingletons ? coroutineSingletons : unit;
                case 3:
                    boolean z5 = this.Z$0;
                    if (!z5) {
                        ResultKt.throwOnFailure(obj);
                        this.Z$0 = true;
                        return SizeKt.bringIntoView((FocusableNode) obj2, null, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z5) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 4:
                    MarqueeModifierNode marqueeModifierNode = (MarqueeModifierNode) obj2;
                    boolean z6 = this.Z$0;
                    if (z6) {
                        if (z6) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    SafeFlow safeFlowSnapshotFlow = Stack.snapshotFlow(new SliderState$$ExternalSyntheticLambda0((byte) 7, marqueeModifierNode));
                    AsyncImagePainter.AnonymousClass1 anonymousClass1 = new AsyncImagePainter.AnonymousClass1(marqueeModifierNode, annotatedString, b2);
                    this.Z$0 = true;
                    return StateFlowKt.collectLatest(safeFlowSnapshotFlow, anonymousClass1, this) == coroutineSingletons ? coroutineSingletons : unit;
                case 5:
                    boolean z7 = this.Z$0;
                    if (z7) {
                        if (z7) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    BufferedChannel bufferedChannel = ((MouseWheelScrollingLogicImpl) obj2).channel;
                    this.Z$0 = true;
                    Object objCoroutineScope = AwaitKt.coroutineScope(new SliderState.AnonymousClass2(bufferedChannel, annotatedString, (byte) 6), this);
                    return objCoroutineScope == coroutineSingletons ? coroutineSingletons : objCoroutineScope;
                case 6:
                    boolean z8 = this.Z$0;
                    if (z8) {
                        if (z8) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    AnimationState animationState = (AnimationState) ((WeakCache) obj2).referenceQueue;
                    Float f = new Float(CropImageView.DEFAULT_ASPECT_RATIO);
                    SpringSpec springSpecSpring$default = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, new Float(0.5f), 1);
                    this.Z$0 = true;
                    return ArcSplineKt.animateTo$default(animationState, f, springSpecSpring$default, true, null, this, 8) == coroutineSingletons ? coroutineSingletons : unit;
                case 7:
                    boolean z9 = this.Z$0;
                    if (z9) {
                        if (z9) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    CursorAnimationState cursorAnimationState = (CursorAnimationState) obj2;
                    this.Z$0 = true;
                    cursorAnimationState.getClass();
                    Object objCoroutineScope2 = AwaitKt.coroutineScope(new DownloadUtil.AnonymousClass2((Object) cursorAnimationState, (Continuation) annotatedString, (byte) 2), this);
                    if (objCoroutineScope2 != coroutineSingletons) {
                        objCoroutineScope2 = unit;
                    }
                    return objCoroutineScope2 == coroutineSingletons ? coroutineSingletons : unit;
                case 8:
                    boolean z10 = this.Z$0;
                    if (z10) {
                        if (z10) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    LinkStateInteractionSourceObserver linkStateInteractionSourceObserver = (LinkStateInteractionSourceObserver) obj2;
                    this.Z$0 = true;
                    linkStateInteractionSourceObserver.getClass();
                    Object objCollect = linkStateInteractionSourceObserver.interactionSource.getInteractions().collect(new HomeViewModel$2$1(new MutableObjectList(), linkStateInteractionSourceObserver, b2), this);
                    if (objCollect != coroutineSingletons) {
                        objCollect = unit;
                    }
                    return objCollect == coroutineSingletons ? coroutineSingletons : unit;
                case 9:
                    TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) obj2;
                    boolean z11 = this.Z$0;
                    if (z11) {
                        if (z11) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    if (!TextRange.m741getCollapsedimpl(textFieldSelectionManager.getValue$foundation().selection) && textFieldSelectionManager.getEditable() && !(textFieldSelectionManager.visualTransformation instanceof PasswordVisualTransformation)) {
                        selectedText = DatabaseDao_Impl.AnonymousClass17.getSelectedText(textFieldSelectionManager.getValue$foundation());
                        AnnotatedString textBeforeSelection = DatabaseDao_Impl.AnonymousClass17.getTextBeforeSelection(textFieldSelectionManager.getValue$foundation(), textFieldSelectionManager.getValue$foundation().annotatedString.text.length());
                        AnnotatedString textAfterSelection = DatabaseDao_Impl.AnonymousClass17.getTextAfterSelection(textFieldSelectionManager.getValue$foundation(), textFieldSelectionManager.getValue$foundation().annotatedString.text.length());
                        AnnotatedString.Builder builder = new AnnotatedString.Builder(textBeforeSelection);
                        builder.append(textAfterSelection);
                        AnnotatedString annotatedString2 = builder.toAnnotatedString();
                        int iM744getMinimpl = TextRange.m744getMinimpl(textFieldSelectionManager.getValue$foundation().selection);
                        textFieldSelectionManager.onValueChange.invoke(TextFieldSelectionManager.m230createTextFieldValueFDrldGo(annotatedString2, TextRangeKt.TextRange(iM744getMinimpl, iM744getMinimpl)));
                        textFieldSelectionManager.setHandleState(HandleState.None);
                        textFieldSelectionManager.undoManager.forceNextSnapshot = true;
                    }
                    if (annotatedString == 0 || (clipboard = textFieldSelectionManager.clipboard) == null) {
                        annotatedString = selectedText;
                        return unit;
                    }
                    ClipEntry clipEntry = ClipboardUtils.toClipEntry(annotatedString);
                    this.Z$0 = true;
                    ((AndroidClipboardImpl) clipboard).setClipEntry(clipEntry);
                    if (unit == coroutineSingletons) {
                        annotatedString = selectedText;
                        return coroutineSingletons;
                    }
                    annotatedString = selectedText;
                    return unit;
                case 10:
                    ClockDialNode clockDialNode = (ClockDialNode) obj2;
                    boolean z12 = this.Z$0;
                    if (z12) {
                        if (z12) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    if (clockDialNode.autoSwitchToMinute) {
                        clockDialNode.state.mo242setSelection6_8s6DQ(1);
                    }
                    AnalogTimePickerState analogTimePickerState = clockDialNode.state;
                    AnimationSpec animationSpec = clockDialNode.animationSpec;
                    this.Z$0 = true;
                    Object objMutate = analogTimePickerState.mutex.mutate(MutatePriority.PreventUserInput, new AnalogTimePickerState$onGestureEnd$2(analogTimePickerState, analogTimePickerState.endValueForAnimation(analogTimePickerState.state.mo241getSelectionyecRtBI() == 0 ? analogTimePickerState.hourAngle : analogTimePickerState.minuteAngle), animationSpec, null, (byte) 0), this);
                    if (objMutate != coroutineSingletons) {
                        objMutate = unit;
                    }
                    return objMutate == coroutineSingletons ? coroutineSingletons : unit;
                case 11:
                    ThumbNode thumbNode = (ThumbNode) obj2;
                    boolean z13 = this.Z$0;
                    if (z13) {
                        if (z13) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Ref$IntRef ref$IntRef4 = new Ref$IntRef();
                    Flow interactions2 = thumbNode.interactionSource.getInteractions();
                    ThumbNode$onAttach$1$1 thumbNode$onAttach$1$1 = new ThumbNode$onAttach$1$1(ref$IntRef4, thumbNode, z ? (byte) 1 : (byte) 0);
                    this.Z$0 = true;
                    return interactions2.collect(thumbNode$onAttach$1$1, this) == coroutineSingletons ? coroutineSingletons : unit;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    boolean z14 = this.Z$0;
                    if (!z14) {
                        ResultKt.throwOnFailure(obj);
                        this.Z$0 = true;
                        return ((SyncUtils$executeLikeSong$2$1) obj2).invoke(this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z14) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 13:
                    boolean z15 = this.Z$0;
                    if (z15) {
                        if (z15) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = ((AndroidRippleNode) obj2).animatedFocusRingInterpolation;
                    Float f2 = new Float(CropImageView.DEFAULT_ASPECT_RATIO);
                    this.Z$0 = true;
                    return animatable.snapTo(f2, this) == coroutineSingletons ? coroutineSingletons : unit;
                case 14:
                    boolean z16 = this.Z$0;
                    if (!z16) {
                        ResultKt.throwOnFailure(obj);
                        this.Z$0 = true;
                        return ((AsyncFontListLoader) obj2).load(this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z16) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 15:
                    boolean z17 = this.Z$0;
                    if (!z17) {
                        ResultKt.throwOnFailure(obj);
                        this.Z$0 = true;
                        return ((DataStoreImpl) obj2).incrementCollector(this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z17) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 16:
                    boolean z18 = this.Z$0;
                    if (!z18) {
                        ResultKt.throwOnFailure(obj);
                        this.Z$0 = true;
                        return ((InvalidationTracker) obj2).sync$room_runtime(this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z18) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 17:
                    boolean z19 = this.Z$0;
                    if (!z19) {
                        ResultKt.throwOnFailure(obj);
                        this.Z$0 = true;
                        return ((TriggerBasedInvalidationTracker) obj2).syncTriggers$room_runtime(this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z19) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 18:
                    boolean z20 = this.Z$0;
                    if (!z20) {
                        ResultKt.throwOnFailure(obj);
                        this.Z$0 = true;
                        Object objAwaitInternal = ((CompletableDeferredImpl) obj2).awaitInternal(this);
                        return objAwaitInternal == coroutineSingletons ? coroutineSingletons : objAwaitInternal;
                    }
                    if (z20) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 19:
                    SongItem songItem = (SongItem) obj2;
                    boolean z21 = this.Z$0;
                    if (!z21) {
                        ResultKt.throwOnFailure(obj);
                        if (songItem.artists.isEmpty()) {
                            InnerTube innerTube = YouTube.innerTube;
                            String str = songItem.id;
                            this.Z$0 = true;
                            objM985getMediaInfogIAlus = innerTube.m985getMediaInfogIAlus(str, this);
                            if (objM985getMediaInfogIAlus == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        return songItem;
                    }
                    if (!z21) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM985getMediaInfogIAlus = ((Result) obj).value;
                    if (objM985getMediaInfogIAlus instanceof Result.Failure) {
                        objM985getMediaInfogIAlus = null;
                    }
                    MediaInfo mediaInfo = (MediaInfo) objM985getMediaInfogIAlus;
                    if ((mediaInfo != null ? mediaInfo.author : null) != null) {
                        return SongItem.copy$default(songItem, CollectionsKt__IterablesKt.listOf(new Artist(mediaInfo.author, mediaInfo.authorId)), null, null, 131067);
                    }
                    return songItem;
                case 20:
                    boolean z22 = this.Z$0;
                    if (!z22) {
                        ResultKt.throwOnFailure(obj);
                        this.Z$0 = true;
                        Object objPrewarm$fetchConfig = InnerTubeExtractor.prewarm$fetchConfig((InnerTubeExtractor) obj2, false, this);
                        return objPrewarm$fetchConfig == coroutineSingletons ? coroutineSingletons : objPrewarm$fetchConfig;
                    }
                    if (z22) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 21:
                    boolean z23 = this.Z$0;
                    if (z23) {
                        if (!z23) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        Object obj3 = ((Result) obj).value;
                        return unit;
                    }
                    ResultKt.throwOnFailure(obj);
                    AlbumEntity albumEntity = (AlbumEntity) obj2;
                    String str2 = albumEntity.playlistId;
                    if (str2 == null) {
                        return unit;
                    }
                    YouTube youTube = YouTube.INSTANCE;
                    z = albumEntity.bookmarkedAt == null;
                    this.Z$0 = true;
                    return youTube.m1015likePlaylist0E7RQCE(str2, z, this) == coroutineSingletons ? coroutineSingletons : unit;
                case 22:
                    boolean z24 = this.Z$0;
                    if (z24) {
                        if (!z24) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        Object obj4 = ((Result) obj).value;
                        return unit;
                    }
                    ResultKt.throwOnFailure(obj);
                    PlaylistEntity playlistEntity = (PlaylistEntity) obj2;
                    String str3 = playlistEntity.browseId;
                    if (str3 == null) {
                        return unit;
                    }
                    YouTube youTube2 = YouTube.INSTANCE;
                    boolean z25 = playlistEntity.bookmarkedAt == null;
                    this.Z$0 = true;
                    return youTube2.m1015likePlaylist0E7RQCE(str3, z25, this) == coroutineSingletons ? coroutineSingletons : unit;
                case 23:
                    boolean z26 = this.Z$0;
                    if (!z26) {
                        ResultKt.throwOnFailure(obj);
                        this.Z$0 = true;
                        Object objAwaitInternal2 = ((CompletableDeferredImpl) ((CompletableDeferred) obj2)).awaitInternal(this);
                        return objAwaitInternal2 == coroutineSingletons ? coroutineSingletons : objAwaitInternal2;
                    }
                    if (z26) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 24:
                    boolean z27 = this.Z$0;
                    if (z27) {
                        if (z27) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable2 = ((BottomSheetState) obj2).animatable;
                    Comparable comparable = animatable2.lowerBound;
                    comparable.getClass();
                    this.Z$0 = true;
                    return Animatable.animateTo$default(animatable2, comparable, null, null, null, this, 14) == coroutineSingletons ? coroutineSingletons : unit;
                case 25:
                    boolean z28 = this.Z$0;
                    if (z28) {
                        if (!z28) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        Object obj5 = ((Result) obj).value;
                        return unit;
                    }
                    ResultKt.throwOnFailure(obj);
                    String str4 = ((Playlist) obj2).playlist.browseId;
                    if (str4 == null) {
                        return unit;
                    }
                    YouTube youTube3 = YouTube.INSTANCE;
                    this.Z$0 = true;
                    return youTube3.m1002deletePlaylistgIAlus(str4, this) == coroutineSingletons ? coroutineSingletons : unit;
                case 26:
                    boolean z29 = this.Z$0;
                    if (!z29) {
                        ResultKt.throwOnFailure(obj);
                        this.Z$0 = true;
                        return ((BringIntoViewRequesterImpl) obj2).bringIntoView(null, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z29) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 27:
                    WizardViewModel wizardViewModel = (WizardViewModel) obj2;
                    StateFlowImpl stateFlowImpl = wizardViewModel._state;
                    boolean z30 = this.Z$0;
                    if (!z30) {
                        ResultKt.throwOnFailure(obj);
                        do {
                            value = stateFlowImpl.getValue();
                        } while (!stateFlowImpl.compareAndSet(value, WizardState.copy$default((WizardState) value, null, null, null, null, null, null, true, null, 639)));
                        TextDelegate textDelegate = wizardViewModel.autoEqSearch;
                        this.Z$0 = true;
                        textDelegate.getClass();
                        DefaultScheduler defaultScheduler = Dispatchers.Default;
                        objWithContext = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new GitHubAutoEqSearch$buildIndex$2(textDelegate, null), this);
                        if (objWithContext == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z30) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        objWithContext = obj;
                    }
                    if (!((Boolean) objWithContext).booleanValue()) {
                        do {
                            value3 = stateFlowImpl.getValue();
                        } while (!stateFlowImpl.compareAndSet(value3, WizardState.copy$default((WizardState) value3, null, null, null, null, null, null, false, "Failed to load AutoEQ database", 639)));
                        return unit;
                    }
                    do {
                        value2 = stateFlowImpl.getValue();
                    } while (!stateFlowImpl.compareAndSet(value2, WizardState.copy$default((WizardState) value2, null, null, null, null, null, null, false, null, 831)));
                    wizardViewModel.searchModels("");
                    return unit;
                case 28:
                    MediaMetadata mediaMetadata = (MediaMetadata) obj2;
                    boolean z31 = this.Z$0;
                    if (z31) {
                        if (!z31) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        Object obj6 = ((Result) obj).value;
                        return unit;
                    }
                    ResultKt.throwOnFailure(obj);
                    LastFM lastFM = LastFM.INSTANCE;
                    String strJoinToString$default = CollectionsKt.joinToString$default(mediaMetadata.artists, null, null, null, new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 26), 31);
                    String str5 = mediaMetadata.title;
                    MediaMetadata.Album album = mediaMetadata.album;
                    String str6 = album != null ? album.title : null;
                    Integer num = new Integer(mediaMetadata.duration);
                    this.Z$0 = true;
                    return lastFM.m1053updateNowPlayinghUnOzRk(strJoinToString$default, str5, str6, num, this) == coroutineSingletons ? coroutineSingletons : unit;
                default:
                    ChartsViewModel chartsViewModel = (ChartsViewModel) obj2;
                    StateFlowImpl stateFlowImpl2 = chartsViewModel._error;
                    StateFlowImpl stateFlowImpl3 = chartsViewModel._isLoading;
                    boolean z32 = this.Z$0;
                    if (!z32) {
                        ResultKt.throwOnFailure(obj);
                        Boolean bool = Boolean.TRUE;
                        stateFlowImpl3.getClass();
                        stateFlowImpl3.updateState(null, bool);
                        stateFlowImpl2.setValue(null);
                        YouTube youTube4 = YouTube.INSTANCE;
                        this.Z$0 = true;
                        objM1007getChartsPagegIAlus = youTube4.m1007getChartsPagegIAlus(this);
                        if (objM1007getChartsPagegIAlus == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z32) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        objM1007getChartsPagegIAlus = ((Result) obj).value;
                    }
                    if (!(objM1007getChartsPagegIAlus instanceof Result.Failure)) {
                        chartsViewModel._chartsPage.setValue((ChartsPage) objM1007getChartsPagegIAlus);
                    }
                    Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1007getChartsPagegIAlus);
                    if (thM1866exceptionOrNullimpl != null) {
                        String str7 = "Failed to load charts: " + thM1866exceptionOrNullimpl.getMessage();
                        stateFlowImpl2.getClass();
                        stateFlowImpl2.updateState(null, str7);
                    }
                    Boolean bool2 = Boolean.FALSE;
                    stateFlowImpl3.getClass();
                    stateFlowImpl3.updateState(null, bool2);
                    return unit;
            }
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.SyncUtils$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass3 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass3(Object obj, Continuation continuation, byte b) {
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
                    return new AnonymousClass3((SyncUtils) obj2, continuation, (byte) 0);
                case 1:
                    return new AnonymousClass3((PlatformSelectionBehaviorsImpl) obj2, continuation, (byte) 1);
                case 2:
                    return new AnonymousClass3((AnalogTimePickerState) obj2, continuation, (byte) 2);
                case 3:
                    return new AnonymousClass3((TooltipStateImpl) obj2, continuation, (byte) 3);
                case 4:
                    return new AnonymousClass3((InvalidationTracker) obj2, continuation, (byte) 4);
                case 5:
                    return new AnonymousClass3((DiskLruCache) obj2, continuation, (byte) 5);
                case 6:
                    return new AnonymousClass3((ViewTargetRequestManager) obj2, continuation, (byte) 6);
                case 7:
                    return new AnonymousClass3((QuickJsEngine.Runtime) obj2, continuation, (byte) 7);
                case 8:
                    return new AnonymousClass3((ExecutorCoroutineDispatcherImpl) obj2, continuation, (byte) 8);
                case 9:
                    return new AnonymousClass3((App) obj2, continuation, (byte) 9);
                case 10:
                    return new AnonymousClass3((ListenTogetherClient) obj2, continuation, (byte) 10);
                case 11:
                    return new AnonymousClass3((StatsViewModel) obj2, continuation, (byte) 11);
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    return new AnonymousClass3((MusicDatabase) obj2, continuation, (byte) 12);
                case 13:
                    return new AnonymousClass3((RealDiskCache) obj2, continuation, (byte) 13);
                default:
                    return new AnonymousClass3((BackupRestoreViewModel) obj2, continuation, (byte) 14);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    ((AnonymousClass3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 1:
                    return ((AnonymousClass3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 2:
                    ((AnonymousClass3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 3:
                    ((AnonymousClass3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 4:
                    ((AnonymousClass3) create((FlowCollector) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 5:
                    return ((AnonymousClass3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 6:
                    ((AnonymousClass3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 7:
                    ((AnonymousClass3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 8:
                    return ((AnonymousClass3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                case 9:
                    ((AnonymousClass3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 10:
                    ((AnonymousClass3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 11:
                    ((AnonymousClass3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    ((AnonymousClass3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                case 13:
                    ((AnonymousClass3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
                default:
                    ((AnonymousClass3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                    return unit;
            }
        }

        /* JADX WARN: Code duplicated, block: B:43:0x0165 A[Catch: Exception -> 0x0179, TryCatch #3 {Exception -> 0x0179, blocks: (B:41:0x0153, B:43:0x0165, B:47:0x017d, B:46:0x017b), top: B:128:0x0153 }] */
        /* JADX WARN: Code duplicated, block: B:46:0x017b A[Catch: Exception -> 0x0179, TryCatch #3 {Exception -> 0x0179, blocks: (B:41:0x0153, B:43:0x0165, B:47:0x017d, B:46:0x017b), top: B:128:0x0153 }] */
        /* JADX WARN: Code duplicated, block: B:53:0x01b9 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:54:0x01ba A[Catch: Exception -> 0x01f1, TryCatch #6 {Exception -> 0x01f1, blocks: (B:51:0x019d, B:58:0x01c5, B:60:0x01cb, B:54:0x01ba), top: B:133:0x019d }] */
        /* JADX WARN: Code duplicated, block: B:60:0x01cb A[Catch: Exception -> 0x01f1, TRY_LEAVE, TryCatch #6 {Exception -> 0x01f1, blocks: (B:51:0x019d, B:58:0x01c5, B:60:0x01cb, B:54:0x01ba), top: B:133:0x019d }] */
        /* JADX WARN: Instruction removed from duplicated block: B:60:0x01cb, please report this as an issue */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Context context;
            StateFlowImpl stateFlowImpl;
            String str;
            String str2;
            String string;
            String str3;
            Iterable iterable;
            switch (this.$r8$classId) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    long jLongValue = ((Number) UtilsKt.get(UtilsKt.getDataStore(((SyncUtils) this.this$0).context), PreferenceKeysKt.LastFullSyncKey, new Long(0L))).longValue();
                    SyncUtils syncUtils = (SyncUtils) this.this$0;
                    syncUtils.cachedLastSyncEpoch = Math.max(syncUtils.cachedLastSyncEpoch, jLongValue);
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl = (PlatformSelectionBehaviorsImpl) this.this$0;
                    TextClassifier textClassifierCreateTextClassificationSession = HandlerCompat$Api28Impl.createTextClassificationSession(platformSelectionBehaviorsImpl.context, platformSelectionBehaviorsImpl.selectedTextType);
                    platformSelectionBehaviorsImpl.textClassificationSession = textClassifierCreateTextClassificationSession;
                    return textClassifierCreateTextClassificationSession;
                case 2:
                    ResultKt.throwOnFailure(obj);
                    AnalogTimePickerState analogTimePickerState = (AnalogTimePickerState) this.this$0;
                    if (((Boolean) analogTimePickerState.isDialFocusable$delegate.getValue()).booleanValue()) {
                        FocusRequester.m415requestFocus3ESFkO8$default(analogTimePickerState.dialFocusRequester);
                    }
                    return Unit.INSTANCE;
                case 3:
                    ResultKt.throwOnFailure(obj);
                    ((TooltipStateImpl) this.this$0).dismiss();
                    return Unit.INSTANCE;
                case 4:
                    ResultKt.throwOnFailure(obj);
                    ((InvalidationTracker) this.this$0).flowCount.incrementAndGet();
                    return Unit.INSTANCE;
                case 5:
                    ResultKt.throwOnFailure(obj);
                    DiskLruCache diskLruCache = (DiskLruCache) this.this$0;
                    synchronized (diskLruCache.lock) {
                        if (!diskLruCache.initialized || diskLruCache.closed) {
                            return Unit.INSTANCE;
                        }
                        try {
                            diskLruCache.trimToSize();
                            break;
                        } catch (IOException unused) {
                            diskLruCache.mostRecentTrimFailed = true;
                        }
                        try {
                            if (diskLruCache.operationsSinceRewrite >= 2000) {
                                diskLruCache.writeJournal();
                            }
                            break;
                        } catch (IOException unused2) {
                            diskLruCache.mostRecentRebuildFailed = true;
                            diskLruCache.journalWriter = new RealBufferedSink(new BlackholeSink());
                        }
                        return Unit.INSTANCE;
                    }
                case 6:
                    ResultKt.throwOnFailure(obj);
                    ViewTargetRequestManager viewTargetRequestManager = (ViewTargetRequestManager) this.this$0;
                    ViewTargetRequestDelegate viewTargetRequestDelegate = viewTargetRequestManager.currentRequest;
                    if (viewTargetRequestDelegate != null) {
                        Lifecycle lifecycle = viewTargetRequestDelegate.lifecycle;
                        viewTargetRequestDelegate.job.cancel(null);
                        GenericViewTarget genericViewTarget = viewTargetRequestDelegate.target;
                        if (genericViewTarget != null && lifecycle != null) {
                            lifecycle.removeObserver(genericViewTarget);
                        }
                        if (lifecycle != null) {
                            lifecycle.removeObserver(viewTargetRequestDelegate);
                        }
                    }
                    viewTargetRequestManager.currentRequest = null;
                    return Unit.INSTANCE;
                case 7:
                    ResultKt.throwOnFailure(obj);
                    ((QuickJsEngine.Runtime) this.this$0).js.close();
                    return Unit.INSTANCE;
                case 8:
                    ResultKt.throwOnFailure(obj);
                    QuickJs.Companion companion = QuickJs.INSTANCE;
                    ExecutorCoroutineDispatcherImpl executorCoroutineDispatcherImpl = (ExecutorCoroutineDispatcherImpl) this.this$0;
                    companion.getClass();
                    QuickJs quickJs = new QuickJs(executorCoroutineDispatcherImpl, null, null == true ? 1 : 0);
                    quickJs.setEvaluationTimeoutMillis(30000L);
                    quickJs.setMemoryLimit(201326592L);
                    quickJs.setMaxStackSize(262144L);
                    return quickJs;
                case 9:
                    ResultKt.throwOnFailure(obj);
                    App app = (App) this.this$0;
                    Toast.makeText(app, app.getString(R.string.failed_to_parse_proxy), 0).show();
                    return Unit.INSTANCE;
                case 10:
                    LogLevel logLevel = LogLevel.ERROR;
                    LogLevel logLevel2 = LogLevel.INFO;
                    ResultKt.throwOnFailure(obj);
                    ListenTogetherClient listenTogetherClient = (ListenTogetherClient) this.this$0;
                    ContextScope contextScope = listenTogetherClient.scope;
                    String str4 = ListenTogetherClient.DEFAULT_SERVER_URL;
                    Context context2 = listenTogetherClient.context;
                    AtomicInteger atomicInteger = listenTogetherClient.sessionApplyGeneration;
                    int i = atomicInteger.get();
                    try {
                        String str5 = (String) UtilsKt.get(UtilsKt.getDataStore(context2), PreferenceKeysKt.ListenTogetherSessionTokenKey, "");
                        String str6 = (String) UtilsKt.get(UtilsKt.getDataStore(context2), PreferenceKeysKt.ListenTogetherRoomCodeKey, "");
                        String str7 = (String) UtilsKt.get(UtilsKt.getDataStore(context2), PreferenceKeysKt.ListenTogetherUserIdKey, "");
                        boolean zBooleanValue = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context2), PreferenceKeysKt.ListenTogetherIsHostKey, Boolean.FALSE)).booleanValue();
                        context = context2;
                        try {
                            long jLongValue2 = ((Number) UtilsKt.get(UtilsKt.getDataStore(context2), PreferenceKeysKt.ListenTogetherSessionTimestampKey, 0L)).longValue();
                            if (str5.length() <= 0 || str6.length() <= 0 || System.currentTimeMillis() - jLongValue2 >= 600000) {
                                if (str5.length() <= 0) {
                                    stateFlowImpl = listenTogetherClient._blockedUsernames;
                                    try {
                                        str3 = (String) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.ListenTogetherBlockedUsersKey, "");
                                        if (str3.length() > 0) {
                                            JsonImpl jsonImpl = listenTogetherClient.json;
                                            jsonImpl.getClass();
                                            iterable = (List) jsonImpl.decodeFromString(new HashSetSerializer(StringSerializer.INSTANCE, (byte) 1), str3);
                                        } else {
                                            iterable = EmptyList.INSTANCE;
                                        }
                                        Set set = CollectionsKt.toSet(iterable);
                                        stateFlowImpl.getClass();
                                        stateFlowImpl.updateState(null, set);
                                    } catch (Exception e) {
                                        listenTogetherClient.log(logLevel, "Failed to load blocked usernames", e.getMessage());
                                        EmptySet emptySet = EmptySet.INSTANCE;
                                        stateFlowImpl.getClass();
                                        stateFlowImpl.updateState(null, emptySet);
                                    }
                                    try {
                                        DataStore dataStore = UtilsKt.getDataStore(context);
                                        Preferences$Key preferences$Key = PreferenceKeysKt.ListenTogetherServerUrlKey;
                                        str = ListenTogetherClient.DEFAULT_SERVER_URL;
                                        str2 = (String) UtilsKt.get(dataStore, preferences$Key, str);
                                        string = StringsKt.trim(str2).toString();
                                        if (string.length() == 0 && !StringsKt.contains(string, "metroserver.meowery.eu", true)) {
                                            str = string;
                                        }
                                        if (!Intrinsics.areEqual(str, str2)) {
                                            listenTogetherClient.log(logLevel2, "Migrating server URL", "Old: " + str2 + " -> New: " + str);
                                            AwaitKt.launch$default(contextScope, null, null, new App.C01391(listenTogetherClient, str, null, (byte) 17), 3);
                                        }
                                    } catch (Exception e2) {
                                        listenTogetherClient.log(logLevel, "Failed to migrate server URL", e2.getMessage());
                                    }
                                    break;
                                } else if (i == atomicInteger.get()) {
                                    listenTogetherClient.log(LogLevel.WARNING, "Session expired", "Age: " + (System.currentTimeMillis() - jLongValue2) + "ms");
                                    listenTogetherClient.clearPersistedSession();
                                    stateFlowImpl = listenTogetherClient._blockedUsernames;
                                    str3 = (String) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.ListenTogetherBlockedUsersKey, "");
                                    if (str3.length() > 0) {
                                        JsonImpl jsonImpl2 = listenTogetherClient.json;
                                        jsonImpl2.getClass();
                                        iterable = (List) jsonImpl2.decodeFromString(new HashSetSerializer(StringSerializer.INSTANCE, (byte) 1), str3);
                                    } else {
                                        iterable = EmptyList.INSTANCE;
                                    }
                                    Set set2 = CollectionsKt.toSet(iterable);
                                    stateFlowImpl.getClass();
                                    stateFlowImpl.updateState(null, set2);
                                    DataStore dataStore2 = UtilsKt.getDataStore(context);
                                    Preferences$Key preferences$Key2 = PreferenceKeysKt.ListenTogetherServerUrlKey;
                                    str = ListenTogetherClient.DEFAULT_SERVER_URL;
                                    str2 = (String) UtilsKt.get(dataStore2, preferences$Key2, str);
                                    string = StringsKt.trim(str2).toString();
                                    if (string.length() == 0) {
                                        str = string;
                                    }
                                    if (!Intrinsics.areEqual(str, str2)) {
                                        listenTogetherClient.log(logLevel2, "Migrating server URL", "Old: " + str2 + " -> New: " + str);
                                        AwaitKt.launch$default(contextScope, null, null, new App.C01391(listenTogetherClient, str, null, (byte) 17), 3);
                                    }
                                    break;
                                }
                            } else {
                                if (i == atomicInteger.get()) {
                                    listenTogetherClient.sessionToken = str5;
                                    listenTogetherClient.storedRoomCode = str6;
                                    StateFlowImpl stateFlowImpl2 = listenTogetherClient._userId;
                                    if (str7.length() == 0) {
                                        str7 = null;
                                    }
                                    stateFlowImpl2.setValue(str7);
                                    listenTogetherClient.wasHost = zBooleanValue;
                                    listenTogetherClient.log(logLevel2, "Loaded persisted session", "Room: " + str6 + ", Host: " + zBooleanValue);
                                    stateFlowImpl = listenTogetherClient._blockedUsernames;
                                    str3 = (String) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.ListenTogetherBlockedUsersKey, "");
                                    if (str3.length() > 0) {
                                        JsonImpl jsonImpl3 = listenTogetherClient.json;
                                        jsonImpl3.getClass();
                                        iterable = (List) jsonImpl3.decodeFromString(new HashSetSerializer(StringSerializer.INSTANCE, (byte) 1), str3);
                                    } else {
                                        iterable = EmptyList.INSTANCE;
                                    }
                                    Set set3 = CollectionsKt.toSet(iterable);
                                    stateFlowImpl.getClass();
                                    stateFlowImpl.updateState(null, set3);
                                    DataStore dataStore3 = UtilsKt.getDataStore(context);
                                    Preferences$Key preferences$Key3 = PreferenceKeysKt.ListenTogetherServerUrlKey;
                                    str = ListenTogetherClient.DEFAULT_SERVER_URL;
                                    str2 = (String) UtilsKt.get(dataStore3, preferences$Key3, str);
                                    string = StringsKt.trim(str2).toString();
                                    if (string.length() == 0) {
                                        str = string;
                                    }
                                    if (!Intrinsics.areEqual(str, str2)) {
                                        listenTogetherClient.log(logLevel2, "Migrating server URL", "Old: " + str2 + " -> New: " + str);
                                        AwaitKt.launch$default(contextScope, null, null, new App.C01391(listenTogetherClient, str, null, (byte) 17), 3);
                                    }
                                } else {
                                    listenTogetherClient.log(logLevel2, "Skipping persisted session restore", "User started a new room flow before restore completed");
                                }
                                break;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            listenTogetherClient.log(logLevel, "Failed to load persisted session", e.getMessage());
                        }
                    } catch (Exception e4) {
                        e = e4;
                        context = context2;
                    }
                    AwaitKt.launch$default(contextScope, null, null, new ListenTogetherClient$blockUser$3(listenTogetherClient, null, (byte) 5), 3);
                    return Unit.INSTANCE;
                case 11:
                    ResultKt.throwOnFailure(obj);
                    StatsViewModel statsViewModel = (StatsViewModel) this.this$0;
                    CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(statsViewModel);
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    AwaitKt.launch$default(viewModelScope, DefaultIoScheduler.INSTANCE, null, new StatsViewModel$syncMostPlaylistsIfNeeded$1(statsViewModel, false, null), 2);
                    return Unit.INSTANCE;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    ResultKt.throwOnFailure(obj);
                    ((MusicDatabase) this.this$0).query(new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 21));
                    return Unit.INSTANCE;
                case 13:
                    ResultKt.throwOnFailure(obj);
                    ((RealDiskCache) this.this$0).clear();
                    return Unit.INSTANCE;
                default:
                    ResultKt.throwOnFailure(obj);
                    ((BackupRestoreViewModel) this.this$0).database.checkpoint();
                    return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.SyncUtils$backfillAddedSetVideoIds$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public String L$0;
        public String L$1;
        public List L$2;
        public Object L$3;
        public Object L$6;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SyncUtils.this.backfillAddedSetVideoIds(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.SyncUtils$isLoggedIn$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01861 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C01861(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SyncUtils.this.isLoggedIn(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.SyncUtils$performFullSyncSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01871 extends ContinuationImpl {
        public Mutex L$0;
        public int label;
        public /* synthetic */ Object result;

        public C01871(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SyncUtils.this.performFullSyncSuspend(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.SyncUtils$processOperation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01881 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C01881(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SyncUtils.this.processOperation(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.SyncUtils$runQueuedPlaylistEdit$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01891 extends ContinuationImpl {
        public long J$0;
        public Function1 L$0;
        public Mutex L$1;
        public int label;
        public /* synthetic */ Object result;

        public C01891(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SyncUtils.this.runQueuedPlaylistEdit(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.SyncUtils$syncEpisodesForLaterSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01901 extends ContinuationImpl {
        public Mutex L$0;
        public int label;
        public /* synthetic */ Object result;

        public C01901(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SyncUtils.this.syncEpisodesForLaterSuspend(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.SyncUtils$syncLikedSongsSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01911 extends ContinuationImpl {
        public Mutex L$0;
        public int label;
        public /* synthetic */ Object result;

        public C01911(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SyncUtils.this.syncLikedSongsSuspend(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.SyncUtils$syncPlaylistSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01921 extends ContinuationImpl {
        public String L$0;
        public String L$1;
        public Mutex L$2;
        public int label;
        public /* synthetic */ Object result;

        public C01921(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SyncUtils.this.syncPlaylistSuspend(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.SyncUtils$syncPodcastSubscriptionsSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01931 extends ContinuationImpl {
        public Mutex L$0;
        public int label;
        public /* synthetic */ Object result;

        public C01931(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SyncUtils.this.syncPodcastSubscriptionsSuspend(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.SyncUtils$syncUploadedSongsSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01941 extends ContinuationImpl {
        public Mutex L$0;
        public int label;
        public /* synthetic */ Object result;

        public C01941(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SyncUtils.this.syncUploadedSongsSuspend(this);
        }
    }

    static {
        CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"sync_snapshot_liked_songs", "sync_snapshot_library_songs", "sync_snapshot_liked_albums"});
    }

    public SyncUtils(Context context, MusicDatabase musicDatabase) {
        musicDatabase.getClass();
        this.context = context;
        this.database = musicDatabase;
        RealImageLoaderKt$CoroutineScope$$inlined$CoroutineExceptionHandler$1 realImageLoaderKt$CoroutineScope$$inlined$CoroutineExceptionHandler$1 = new RealImageLoaderKt$CoroutineScope$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key.$$INSTANCE, (byte) 3);
        SupervisorJobImpl supervisorJobImplSupervisorJob$default = AwaitKt.SupervisorJob$default();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        ContextScope contextScopeCoroutineScope = AwaitKt.CoroutineScope(DefaultIoScheduler.INSTANCE.plus(supervisorJobImplSupervisorJob$default).plus(realImageLoaderKt$CoroutineScope$$inlined$CoroutineExceptionHandler$1));
        this.syncScope = contextScopeCoroutineScope;
        Continuation continuation = null;
        this.syncChannel = EntryPoints.Channel$default(-2, 6, null);
        this.syncExecutionMutex = new MutexImpl();
        this.queuedOperationKeys = ConcurrentHashMap.newKeySet();
        this.playlistsBeingModified = new ConcurrentHashMap();
        this.playlistEditMutex = new MutexImpl();
        byte b = 0;
        CoroutineExtKt.collectLatest(StateFlowKt.distinctUntilChanged(new SyncUtils$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), b)), contextScopeCoroutineScope, new AnonymousClass2(this, continuation, b));
        AwaitKt.launch$default(contextScopeCoroutineScope, null, null, new AnonymousClass3(this, continuation, b), 3);
        AwaitKt.launch$default(contextScopeCoroutineScope, null, null, new DiscordRpcManager.AnonymousClass4(this, continuation, (byte) 11), 3);
    }

    public static String coalescingKey(SyncOperation syncOperation) {
        if (Intrinsics.areEqual(syncOperation, SyncOperation.FullSync.INSTANCE)) {
            return "full";
        }
        if (Intrinsics.areEqual(syncOperation, SyncOperation.LikedSongs.INSTANCE)) {
            return "likedSongs";
        }
        if (Intrinsics.areEqual(syncOperation, SyncOperation.LibrarySongs.INSTANCE)) {
            return "librarySongs";
        }
        if (Intrinsics.areEqual(syncOperation, SyncOperation.UploadedSongs.INSTANCE)) {
            return "uploadedSongs";
        }
        if (Intrinsics.areEqual(syncOperation, SyncOperation.LikedAlbums.INSTANCE)) {
            return "likedAlbums";
        }
        if (Intrinsics.areEqual(syncOperation, SyncOperation.UploadedAlbums.INSTANCE)) {
            return "uploadedAlbums";
        }
        if (Intrinsics.areEqual(syncOperation, SyncOperation.ArtistsSubscriptions.INSTANCE)) {
            return "artistsSubscriptions";
        }
        if (Intrinsics.areEqual(syncOperation, SyncOperation.PodcastSubscriptions.INSTANCE)) {
            return "podcastSubscriptions";
        }
        if (Intrinsics.areEqual(syncOperation, SyncOperation.EpisodesForLater.INSTANCE)) {
            return "episodesForLater";
        }
        if (Intrinsics.areEqual(syncOperation, SyncOperation.SavedPlaylists.INSTANCE)) {
            return "savedPlaylists";
        }
        if (Intrinsics.areEqual(syncOperation, SyncOperation.AutoSyncPlaylists.INSTANCE)) {
            return "autoSyncPlaylists";
        }
        if (Intrinsics.areEqual(syncOperation, SyncOperation.ClearPodcastData.INSTANCE)) {
            return "clearPodcastData";
        }
        if (!(syncOperation instanceof SyncOperation.LikeSong) && !(syncOperation instanceof SyncOperation.SubscribeChannel) && !(syncOperation instanceof SyncOperation.SavePodcast) && !(syncOperation instanceof SyncOperation.SaveEpisode)) {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
        }
        return null;
    }

    public static boolean isCoveredByFullSync(SyncOperation syncOperation) {
        return Intrinsics.areEqual(syncOperation, SyncOperation.LikedSongs.INSTANCE) || Intrinsics.areEqual(syncOperation, SyncOperation.LibrarySongs.INSTANCE) || Intrinsics.areEqual(syncOperation, SyncOperation.UploadedSongs.INSTANCE) || Intrinsics.areEqual(syncOperation, SyncOperation.LikedAlbums.INSTANCE) || Intrinsics.areEqual(syncOperation, SyncOperation.UploadedAlbums.INSTANCE) || Intrinsics.areEqual(syncOperation, SyncOperation.ArtistsSubscriptions.INSTANCE) || Intrinsics.areEqual(syncOperation, SyncOperation.PodcastSubscriptions.INSTANCE) || Intrinsics.areEqual(syncOperation, SyncOperation.EpisodesForLater.INSTANCE) || Intrinsics.areEqual(syncOperation, SyncOperation.SavedPlaylists.INSTANCE) || Intrinsics.areEqual(syncOperation, SyncOperation.AutoSyncPlaylists.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00af  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c2 A[Catch: Exception -> 0x0038, TryCatch #1 {Exception -> 0x0038, blocks: (B:14:0x0033, B:49:0x00dd, B:43:0x00b2, B:45:0x00c2), top: B:60:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:57:0x0101  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v9 */
    public final Object backfillAddedSetVideoIds(String str, String str2, List list, ContinuationImpl continuationImpl) throws Exception {
        AnonymousClass1 anonymousClass1;
        List list2;
        String str3;
        ?? r12;
        Object obj;
        boolean z;
        List videoIdUpdatesForAddedSongs;
        InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$2;
        List list3;
        ?? r11;
        Throwable thM1866exceptionOrNullimpl;
        Object objM1025playlistgIAlus;
        ?? r13;
        Object objCompletedLibrary;
        MusicDatabase musicDatabase = this.database;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj2 = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj2);
                    if (!list.isEmpty()) {
                        YouTube youTube = YouTube.INSTANCE;
                        anonymousClass1.L$0 = str;
                        anonymousClass1.L$1 = str2;
                        anonymousClass1.L$2 = list;
                        anonymousClass1.L$3 = null;
                        anonymousClass1.label = 1;
                        objM1025playlistgIAlus = youTube.m1025playlistgIAlus(str, anonymousClass1);
                        if (objM1025playlistgIAlus == coroutineSingletons) {
                            r13 = str;
                        }
                        return coroutineSingletons;
                    }
                    return Unit.INSTANCE;
                }
                if (i2 == 1) {
                    list = anonymousClass1.L$2;
                    str2 = anonymousClass1.L$1;
                    String str4 = anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    objM1025playlistgIAlus = ((Result) obj2).value;
                    r13 = str4;
                } else {
                    if (i2 == 2) {
                        list = anonymousClass1.L$2;
                        str2 = anonymousClass1.L$1;
                        String str5 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        objCompletedLibrary = ((Result) obj2).value;
                        str = str5;
                        ResultKt.throwOnFailure(objCompletedLibrary);
                        String str6 = str2;
                        r12 = str;
                        obj = (PlaylistPage) objCompletedLibrary;
                        list2 = list;
                        str3 = str6;
                        z = obj instanceof Result.Failure;
                        r11 = obj;
                        if (!z) {
                            PlaylistPage playlistPage = (PlaylistPage) obj;
                            videoIdUpdatesForAddedSongs = UtilsKt.setVideoIdUpdatesForAddedSongs(list2, playlistPage.songs, musicDatabase.playlistSongMaps(str3));
                            r11 = obj;
                            if (!videoIdUpdatesForAddedSongs.isEmpty()) {
                                interruptibleKt$runInterruptible$2 = new InterruptibleKt$runInterruptible$2(videoIdUpdatesForAddedSongs, this, continuation, (byte) 14);
                                anonymousClass1.L$0 = r12;
                                anonymousClass1.L$1 = str3;
                                anonymousClass1.L$2 = null;
                                anonymousClass1.L$3 = obj;
                                anonymousClass1.L$6 = videoIdUpdatesForAddedSongs;
                                anonymousClass1.label = 3;
                                if (musicDatabase.withTransaction(interruptibleKt$runInterruptible$2, anonymousClass1) != coroutineSingletons) {
                                    list3 = videoIdUpdatesForAddedSongs;
                                    str = obj;
                                }
                                return coroutineSingletons;
                            }
                            return Unit.INSTANCE;
                        }
                        thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(r11);
                        if (thM1866exceptionOrNullimpl != null) {
                            ConnectionPool connectionPool = Timber.Forest;
                            thM1866exceptionOrNullimpl.getMessage();
                            connectionPool.getClass();
                            ConnectionPool.w(new Object[0]);
                        }
                        return Unit.INSTANCE;
                    }
                    if (i2 != 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    list3 = (List) anonymousClass1.L$6;
                    Object obj3 = anonymousClass1.L$3;
                    ResultKt.throwOnFailure(obj2);
                    str = obj3;
                }
                ConnectionPool connectionPool2 = Timber.Forest;
                list3.size();
                connectionPool2.getClass();
                ConnectionPool.d(new Object[0]);
                r11 = str;
                thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(r11);
                if (thM1866exceptionOrNullimpl != null) {
                    ConnectionPool connectionPool3 = Timber.Forest;
                    thM1866exceptionOrNullimpl.getMessage();
                    connectionPool3.getClass();
                    ConnectionPool.w(new Object[0]);
                }
                return Unit.INSTANCE;
                r13 = str;
                anonymousClass1.L$0 = r13;
                anonymousClass1.L$1 = str2;
                anonymousClass1.L$2 = list;
                anonymousClass1.L$3 = null;
                anonymousClass1.label = 2;
                objCompletedLibrary = StringsKt__IndentKt.completedLibrary(objM1025playlistgIAlus, anonymousClass1);
                str = r13;
                if (objCompletedLibrary != coroutineSingletons) {
                    ResultKt.throwOnFailure(objCompletedLibrary);
                    String str7 = str2;
                    r12 = str;
                    obj = (PlaylistPage) objCompletedLibrary;
                    list2 = list;
                    str3 = str7;
                    z = obj instanceof Result.Failure;
                    r11 = obj;
                    if (!z) {
                        PlaylistPage playlistPage2 = (PlaylistPage) obj;
                        videoIdUpdatesForAddedSongs = UtilsKt.setVideoIdUpdatesForAddedSongs(list2, playlistPage2.songs, musicDatabase.playlistSongMaps(str3));
                        r11 = obj;
                        if (!videoIdUpdatesForAddedSongs.isEmpty()) {
                            interruptibleKt$runInterruptible$2 = new InterruptibleKt$runInterruptible$2(videoIdUpdatesForAddedSongs, this, continuation, (byte) 14);
                            anonymousClass1.L$0 = r12;
                            anonymousClass1.L$1 = str3;
                            anonymousClass1.L$2 = null;
                            anonymousClass1.L$3 = obj;
                            anonymousClass1.L$6 = videoIdUpdatesForAddedSongs;
                            anonymousClass1.label = 3;
                            if (musicDatabase.withTransaction(interruptibleKt$runInterruptible$2, anonymousClass1) != coroutineSingletons) {
                                list3 = videoIdUpdatesForAddedSongs;
                                str = obj;
                                ConnectionPool connectionPool4 = Timber.Forest;
                                list3.size();
                                connectionPool4.getClass();
                                ConnectionPool.d(new Object[0]);
                                r11 = str;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(r11);
                    if (thM1866exceptionOrNullimpl != null) {
                        ConnectionPool connectionPool5 = Timber.Forest;
                        thM1866exceptionOrNullimpl.getMessage();
                        connectionPool5.getClass();
                        ConnectionPool.w(new Object[0]);
                    }
                    return Unit.INSTANCE;
                }
            } catch (Throwable th) {
                Result.Failure failure = new Result.Failure(th);
                list2 = list;
                str3 = str2;
                r12 = str;
                obj = failure;
            }
            return coroutineSingletons;
        } catch (Exception e) {
            if (e instanceof CancellationException) {
                throw e;
            }
            Timber.Forest.getClass();
            ConnectionPool.e$1(new Object[0]);
            r11 = str;
        }
    }

    public final void enqueue(SyncOperation syncOperation) {
        String strCoalescingKey = coalescingKey(syncOperation);
        if (strCoalescingKey == null || this.queuedOperationKeys.add(strCoalescingKey)) {
            AwaitKt.launch$default(this.syncScope, null, null, new DataStoreKt$get$2((Object) this, (Object) syncOperation, (Object) strCoalescingKey, (Continuation) null, (byte) 23), 3);
        } else {
            ConnectionPool connectionPool = Timber.Forest;
            syncOperation.toString();
            connectionPool.getClass();
            ConnectionPool.d(new Object[0]);
        }
    }

    public final Object executeSyncEpisodesForLater(ContinuationImpl continuationImpl) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        Object objWithContext = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncPlaylist$2(this, null, (byte) 1), continuationImpl);
        return objWithContext == CoroutineSingletons.COROUTINE_SUSPENDED ? objWithContext : Unit.INSTANCE;
    }

    public final Object executeSyncLikedSongs(ContinuationImpl continuationImpl) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        Object objWithContext = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SongMenuKt$SongMenu$2$1$1(this, null), continuationImpl);
        return objWithContext == CoroutineSingletons.COROUTINE_SUSPENDED ? objWithContext : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: executeSyncPlaylist-0E7RQCE, reason: not valid java name */
    public final Object m1521executeSyncPlaylist0E7RQCE(String str, String str2, ContinuationImpl continuationImpl) {
        SyncUtils$executeSyncPlaylist$1 syncUtils$executeSyncPlaylist$1;
        if (continuationImpl instanceof SyncUtils$executeSyncPlaylist$1) {
            syncUtils$executeSyncPlaylist$1 = (SyncUtils$executeSyncPlaylist$1) continuationImpl;
            int i = syncUtils$executeSyncPlaylist$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                syncUtils$executeSyncPlaylist$1.label = i - Integer.MIN_VALUE;
            } else {
                syncUtils$executeSyncPlaylist$1 = new SyncUtils$executeSyncPlaylist$1(this, continuationImpl);
            }
        } else {
            syncUtils$executeSyncPlaylist$1 = new SyncUtils$executeSyncPlaylist$1(this, continuationImpl);
        }
        Object objWithContext = syncUtils$executeSyncPlaylist$1.result;
        int i2 = syncUtils$executeSyncPlaylist$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
            SyncUtils$executeSyncPlaylist$2 syncUtils$executeSyncPlaylist$2 = new SyncUtils$executeSyncPlaylist$2(str, str2, this, null);
            syncUtils$executeSyncPlaylist$1.label = 1;
            objWithContext = AwaitKt.withContext(defaultIoScheduler, syncUtils$executeSyncPlaylist$2, syncUtils$executeSyncPlaylist$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithContext == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        return ((Result) objWithContext).value;
    }

    public final Object executeSyncPodcastSubscriptions(ContinuationImpl continuationImpl) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        Object objWithContext = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new PlaylistWidgetManager$buildQuickPicks$2(this, null, (byte) 1), continuationImpl);
        return objWithContext == CoroutineSingletons.COROUTINE_SUSPENDED ? objWithContext : Unit.INSTANCE;
    }

    public final Object executeSyncUploadedSongs(ContinuationImpl continuationImpl) {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        Object objWithContext = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new C01852(this, null), continuationImpl);
        return objWithContext == CoroutineSingletons.COROUTINE_SUSPENDED ? objWithContext : Unit.INSTANCE;
    }

    public final Set findSongIdsWithoutArtists(Collection collection) {
        ArrayList arrayListChunked = CollectionsKt.chunked(CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, collection);
        ArrayList arrayList = new ArrayList();
        int size = arrayListChunked.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListChunked.get(i);
            i++;
            CollectionsKt__MutableCollectionsKt.addAll(this.database.songIdsWithoutArtists((List) obj), arrayList);
        }
        return CollectionsKt.toSet(arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object isLoggedIn(Continuation continuation) {
        C01861 c01861;
        if (continuation instanceof C01861) {
            c01861 = (C01861) continuation;
            int i = c01861.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01861.label = i - Integer.MIN_VALUE;
            } else {
                c01861 = new C01861(continuation);
            }
        } else {
            c01861 = new C01861(continuation);
        }
        Object objFirst = c01861.result;
        int i2 = c01861.label;
        boolean zContainsKey = false;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objFirst);
                SyncUtils$special$$inlined$map$1 syncUtils$special$$inlined$map$1 = new SyncUtils$special$$inlined$map$1(UtilsKt.getDataStore(this.context).getData(), (byte) 23);
                c01861.label = 1;
                objFirst = StateFlowKt.first(syncUtils$special$$inlined$map$1, c01861);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objFirst == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objFirst);
            }
            String str = (String) objFirst;
            if (str != null) {
                zContainsKey = StringsKt__IndentKt.parseCookieString(str).containsKey("SAPISID");
            }
        } catch (Exception unused) {
            Timber.Forest.getClass();
            ConnectionPool.e$1(new Object[0]);
        }
        return Boolean.valueOf(zContainsKey);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0087  */
    /* JADX WARN: Code duplicated, block: B:38:0x008b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object performFullSyncSuspend(ContinuationImpl continuationImpl) throws Throwable {
        C01871 c01871;
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        Object objWithContext;
        if (continuationImpl instanceof C01871) {
            c01871 = (C01871) continuationImpl;
            int i = c01871.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01871.label = i - Integer.MIN_VALUE;
            } else {
                c01871 = new C01871(continuationImpl);
            }
        } else {
            c01871 = new C01871(continuationImpl);
        }
        Object objIsLoggedIn = c01871.result;
        int i2 = c01871.label;
        Object obj = Unit.INSTANCE;
        byte b = 1;
        Continuation continuation = null;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objIsLoggedIn);
            c01871.label = 1;
            objIsLoggedIn = isLoggedIn(c01871);
            if (objIsLoggedIn != obj2) {
            }
            return obj2;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                mutex2 = c01871.L$0;
                try {
                    ResultKt.throwOnFailure(objIsLoggedIn);
                    mutex2.unlock(null);
                    return obj;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = c01871.L$0;
            ResultKt.throwOnFailure(objIsLoggedIn);
            mutex = mutex3;
            try {
                c01871.L$0 = mutex;
                c01871.label = 3;
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                objWithContext = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$tryAutoSync$1(this, continuation, b), c01871);
                if (objWithContext != obj2) {
                    objWithContext = obj;
                }
                if (objWithContext != obj2) {
                    mutex2 = mutex;
                    mutex2.unlock(null);
                    return obj;
                }
                return obj2;
            } catch (Throwable th3) {
                Mutex mutex4 = mutex;
                th = th3;
                mutex2 = mutex4;
                mutex2.unlock(null);
                throw th;
            }
        }
        ResultKt.throwOnFailure(objIsLoggedIn);
        if (!((Boolean) objIsLoggedIn).booleanValue()) {
            Timber.Forest.getClass();
            ConnectionPool.w(new Object[0]);
            return obj;
        }
        mutex = this.syncExecutionMutex;
        c01871.L$0 = mutex;
        c01871.label = 2;
        if (mutex.lock(c01871) != obj2) {
            c01871.L$0 = mutex;
            c01871.label = 3;
            DefaultScheduler defaultScheduler2 = Dispatchers.Default;
            objWithContext = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$tryAutoSync$1(this, continuation, b), c01871);
            if (objWithContext != obj2) {
                objWithContext = obj;
            }
            if (objWithContext != obj2) {
                mutex2 = mutex;
                mutex2.unlock(null);
                return obj;
            }
        }
        return obj2;
    }

    /* JADX WARN: Code duplicated, block: B:163:0x022b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:164:0x022c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object processOperation(SyncOperation syncOperation, ContinuationImpl continuationImpl) {
        C01881 c01881;
        if (continuationImpl instanceof C01881) {
            c01881 = (C01881) continuationImpl;
            int i = c01881.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01881.label = i - Integer.MIN_VALUE;
            } else {
                c01881 = new C01881(continuationImpl);
            }
        } else {
            c01881 = new C01881(continuationImpl);
        }
        Object obj = c01881.result;
        int i2 = c01881.label;
        Object obj2 = Unit.INSTANCE;
        switch (i2) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (syncOperation != null) {
                    boolean z = syncOperation instanceof SyncOperation.FullSync;
                    byte b = 1;
                    Continuation continuation = null;
                    Object obj3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (z) {
                        c01881.label = 1;
                        DefaultScheduler defaultScheduler = Dispatchers.Default;
                        Object objWithContext = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$tryAutoSync$1(this, continuation, b), c01881);
                        if (objWithContext != obj3) {
                            objWithContext = obj2;
                        }
                        if (objWithContext == obj3) {
                            return obj3;
                        }
                        return obj2;
                    }
                    byte b2 = 2;
                    if (syncOperation instanceof SyncOperation.LikedSongs) {
                        c01881.label = 2;
                        if (executeSyncLikedSongs(c01881) == obj3) {
                            return obj3;
                        }
                        return obj2;
                    }
                    byte b3 = 5;
                    if (syncOperation instanceof SyncOperation.LibrarySongs) {
                        c01881.label = 3;
                        DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                        Object objWithContext2 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new MutatorMutex.AnonymousClass2(this, continuation, b3), c01881);
                        if (objWithContext2 != obj3) {
                            objWithContext2 = obj2;
                        }
                        if (objWithContext2 == obj3) {
                            return obj3;
                        }
                        return obj2;
                    }
                    if (syncOperation instanceof SyncOperation.UploadedSongs) {
                        c01881.label = 4;
                        if (executeSyncUploadedSongs(c01881) == obj3) {
                            return obj3;
                        }
                        return obj2;
                    }
                    if (syncOperation instanceof SyncOperation.LikedAlbums) {
                        c01881.label = 5;
                        DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                        Object objWithContext3 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncPlaylist$2(this, continuation, b2), c01881);
                        if (objWithContext3 != obj3) {
                            objWithContext3 = obj2;
                        }
                        if (objWithContext3 == obj3) {
                            return obj3;
                        }
                        return obj2;
                    }
                    if (syncOperation instanceof SyncOperation.UploadedAlbums) {
                        c01881.label = 6;
                        DefaultScheduler defaultScheduler4 = Dispatchers.Default;
                        Object objWithContext4 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(this, continuation, b), c01881);
                        if (objWithContext4 != obj3) {
                            objWithContext4 = obj2;
                        }
                        if (objWithContext4 == obj3) {
                            return obj3;
                        }
                        return obj2;
                    }
                    if (syncOperation instanceof SyncOperation.ArtistsSubscriptions) {
                        c01881.label = 7;
                        DefaultScheduler defaultScheduler5 = Dispatchers.Default;
                        Object objWithContext5 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new QuickJs.AnonymousClass3(this, null), c01881);
                        if (objWithContext5 != obj3) {
                            objWithContext5 = obj2;
                        }
                        if (objWithContext5 == obj3) {
                            return obj3;
                        }
                        return obj2;
                    }
                    if (syncOperation instanceof SyncOperation.PodcastSubscriptions) {
                        c01881.label = 8;
                        if (executeSyncPodcastSubscriptions(c01881) == obj3) {
                            return obj3;
                        }
                        return obj2;
                    }
                    if (syncOperation instanceof SyncOperation.EpisodesForLater) {
                        c01881.label = 9;
                        if (executeSyncEpisodesForLater(c01881) == obj3) {
                            return obj3;
                        }
                        return obj2;
                    }
                    if (syncOperation instanceof SyncOperation.SavedPlaylists) {
                        c01881.label = 10;
                        DefaultScheduler defaultScheduler6 = Dispatchers.Default;
                        Object objWithContext6 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSyncSavedPlaylists$2(this, continuation, (byte) 0), c01881);
                        if (objWithContext6 != obj3) {
                            objWithContext6 = obj2;
                        }
                        if (objWithContext6 == obj3) {
                            return obj3;
                        }
                        return obj2;
                    }
                    if (syncOperation instanceof SyncOperation.AutoSyncPlaylists) {
                        c01881.label = 11;
                        DefaultScheduler defaultScheduler7 = Dispatchers.Default;
                        Object objWithContext7 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new NavHostKt$NavHost$29$1(this, continuation, (byte) 12), c01881);
                        if (objWithContext7 != obj3) {
                            objWithContext7 = obj2;
                        }
                        if (objWithContext7 == obj3) {
                            return obj3;
                        }
                        return obj2;
                    }
                    byte b4 = 16;
                    if (syncOperation instanceof SyncOperation.LikeSong) {
                        SongEntity songEntity = ((SyncOperation.LikeSong) syncOperation).song;
                        c01881.label = 13;
                        DefaultScheduler defaultScheduler8 = Dispatchers.Default;
                        Object objWithContext8 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SimpleActor$offer$2(this, songEntity, continuation, b4), c01881);
                        if (objWithContext8 != obj3) {
                            objWithContext8 = obj2;
                        }
                        if (objWithContext8 == obj3) {
                            return obj3;
                        }
                        return obj2;
                    }
                    if (syncOperation instanceof SyncOperation.SubscribeChannel) {
                        SyncOperation.SubscribeChannel subscribeChannel = (SyncOperation.SubscribeChannel) syncOperation;
                        String str = subscribeChannel.channelId;
                        boolean z2 = subscribeChannel.subscribe;
                        c01881.label = 14;
                        DefaultScheduler defaultScheduler9 = Dispatchers.Default;
                        Object objWithContext9 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSavePodcast$2(str, z2, this, continuation, (byte) 1), c01881);
                        if (objWithContext9 != obj3) {
                            objWithContext9 = obj2;
                        }
                        if (objWithContext9 == obj3) {
                            return obj3;
                        }
                        return obj2;
                    }
                    byte b5 = 15;
                    if (syncOperation instanceof SyncOperation.SavePodcast) {
                        SyncOperation.SavePodcast savePodcast = (SyncOperation.SavePodcast) syncOperation;
                        String str2 = savePodcast.podcastId;
                        boolean z3 = savePodcast.save;
                        c01881.label = 15;
                        DefaultScheduler defaultScheduler10 = Dispatchers.Default;
                        Object objWithContext10 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SyncUtils$executeSavePodcast$2(str2, z3, this, continuation, (byte) 0), c01881);
                        if (objWithContext10 != obj3) {
                            objWithContext10 = obj2;
                        }
                        if (objWithContext10 == obj3) {
                            return obj3;
                        }
                        return obj2;
                    }
                    if (syncOperation instanceof SyncOperation.SaveEpisode) {
                        SyncOperation.SaveEpisode saveEpisode = (SyncOperation.SaveEpisode) syncOperation;
                        String str3 = saveEpisode.episodeId;
                        boolean z4 = saveEpisode.save;
                        String str4 = saveEpisode.setVideoId;
                        c01881.label = 16;
                        DefaultScheduler defaultScheduler11 = Dispatchers.Default;
                        Object objWithContext11 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new MusicService.AnonymousClass19(this, z4, str4, str3, (Continuation) null), c01881);
                        if (objWithContext11 != obj3) {
                            objWithContext11 = obj2;
                        }
                        if (objWithContext11 == obj3) {
                            return obj3;
                        }
                        return obj2;
                    }
                    if (syncOperation instanceof SyncOperation.ClearPodcastData) {
                        c01881.label = 17;
                        DefaultScheduler defaultScheduler12 = Dispatchers.Default;
                        Object objWithContext12 = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new SimpleActor$offer$2(this, continuation, b5), c01881);
                        if (objWithContext12 != obj3) {
                            objWithContext12 = obj2;
                        }
                        if (objWithContext12 == obj3) {
                            return obj3;
                        }
                        return obj2;
                    }
                }
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
            case 1:
                ResultKt.throwOnFailure(obj);
                return obj2;
            case 2:
                ResultKt.throwOnFailure(obj);
                return obj2;
            case 3:
                ResultKt.throwOnFailure(obj);
                return obj2;
            case 4:
                ResultKt.throwOnFailure(obj);
                return obj2;
            case 5:
                ResultKt.throwOnFailure(obj);
                return obj2;
            case 6:
                ResultKt.throwOnFailure(obj);
                return obj2;
            case 7:
                ResultKt.throwOnFailure(obj);
                return obj2;
            case 8:
                ResultKt.throwOnFailure(obj);
                return obj2;
            case 9:
                ResultKt.throwOnFailure(obj);
                return obj2;
            case 10:
                ResultKt.throwOnFailure(obj);
                return obj2;
            case 11:
                ResultKt.throwOnFailure(obj);
                return obj2;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ResultKt.throwOnFailure(obj);
                Object obj4 = ((Result) obj).value;
                return obj2;
            case 13:
                ResultKt.throwOnFailure(obj);
                return obj2;
            case 14:
                ResultKt.throwOnFailure(obj);
                return obj2;
            case 15:
                ResultKt.throwOnFailure(obj);
                return obj2;
            case 16:
                ResultKt.throwOnFailure(obj);
                return obj2;
            case 17:
                ResultKt.throwOnFailure(obj);
                return obj2;
            default:
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.util.Collection, java.util.LinkedHashSet] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public final Set readSyncSnapshot(String str) {
        ?? failure;
        try {
            File filesDir = this.context.getFilesDir();
            filesDir.getClass();
            File fileResolve = FilesKt.resolve(filesDir, str);
            if (!fileResolve.exists()) {
                fileResolve = null;
            }
            if (fileResolve != null) {
                Charset charset = Charsets.UTF_8;
                charset.getClass();
                ArrayList arrayList = new ArrayList();
                RegexKt.forEachLine(new BufferedReader(new InputStreamReader(new FileInputStream(fileResolve), charset)), new TextStreamsKt$$ExternalSyntheticLambda0(arrayList, (byte) 12));
                failure = new LinkedHashSet();
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    if (!StringsKt.isBlank((String) obj)) {
                        failure.add(obj);
                    }
                }
            } else {
                failure = 0;
            }
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        return (Set) (failure instanceof Result.Failure ? 0 : failure);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x009c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r13v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v2, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v5, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final Object runQueuedPlaylistEdit(Function1 function1, ContinuationImpl continuationImpl) throws Throwable {
        C01891 c01891;
        Mutex mutex;
        ?? r13;
        long jCurrentTimeMillis;
        ?? r1;
        Mutex mutex2;
        long j;
        ?? r14;
        Throwable th;
        Mutex mutex3;
        if (continuationImpl instanceof C01891) {
            c01891 = (C01891) continuationImpl;
            int i = c01891.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01891.label = i - Integer.MIN_VALUE;
            } else {
                c01891 = new C01891(continuationImpl);
            }
        } else {
            c01891 = new C01891(continuationImpl);
        }
        Object obj = c01891.result;
        int i2 = c01891.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    c01891.L$0 = function1;
                    mutex = this.playlistEditMutex;
                    c01891.L$1 = mutex;
                    c01891.label = 1;
                    if (mutex.lock(c01891) != coroutineSingletons) {
                    }
                    r13 = function1;
                    return coroutineSingletons;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        mutex3 = c01891.L$1;
                        try {
                            ResultKt.throwOnFailure(obj);
                            this.lastPlaylistEditAtMs = System.currentTimeMillis();
                            mutex3.unlock(null);
                            return Unit.INSTANCE;
                        } catch (Throwable th2) {
                            th = th2;
                            this.lastPlaylistEditAtMs = System.currentTimeMillis();
                            throw th;
                        }
                    }
                    j = c01891.J$0;
                    mutex2 = c01891.L$1;
                    Function1 function2 = c01891.L$0;
                    ResultKt.throwOnFailure(obj);
                    r1 = function2;
                    mutex = mutex2;
                    r14 = r1;
                    jCurrentTimeMillis = j;
                    try {
                        c01891.L$0 = null;
                        c01891.L$1 = mutex;
                        c01891.J$0 = jCurrentTimeMillis;
                        c01891.label = 3;
                        if (r14.invoke(c01891) != coroutineSingletons) {
                            mutex3 = mutex;
                            this.lastPlaylistEditAtMs = System.currentTimeMillis();
                            mutex3.unlock(null);
                            return Unit.INSTANCE;
                        }
                        r13 = function1;
                        return coroutineSingletons;
                    } catch (Throwable th3) {
                        th = th3;
                        this.lastPlaylistEditAtMs = System.currentTimeMillis();
                        throw th;
                    }
                }
                Mutex mutex4 = c01891.L$1;
                Function1 function3 = c01891.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex4;
                r13 = function3;
                r13 = function1;
                jCurrentTimeMillis = 500 - (System.currentTimeMillis() - this.lastPlaylistEditAtMs);
                r14 = r13;
                if (jCurrentTimeMillis > 0) {
                    c01891.L$0 = r13;
                    c01891.L$1 = mutex;
                    c01891.J$0 = jCurrentTimeMillis;
                    c01891.label = 2;
                    if (AwaitKt.delay(jCurrentTimeMillis, c01891) != coroutineSingletons) {
                        r1 = r13;
                        mutex2 = mutex;
                        j = jCurrentTimeMillis;
                        mutex = mutex2;
                        r14 = r1;
                        jCurrentTimeMillis = j;
                        c01891.L$0 = null;
                        c01891.L$1 = mutex;
                        c01891.J$0 = jCurrentTimeMillis;
                        c01891.label = 3;
                        if (r14.invoke(c01891) != coroutineSingletons) {
                            mutex3 = mutex;
                            this.lastPlaylistEditAtMs = System.currentTimeMillis();
                            mutex3.unlock(null);
                            return Unit.INSTANCE;
                        }
                    }
                } else {
                    c01891.L$0 = null;
                    c01891.L$1 = mutex;
                    c01891.J$0 = jCurrentTimeMillis;
                    c01891.label = 3;
                    if (r14.invoke(c01891) != coroutineSingletons) {
                        mutex3 = mutex;
                        this.lastPlaylistEditAtMs = System.currentTimeMillis();
                        mutex3.unlock(null);
                        return Unit.INSTANCE;
                    }
                }
                r13 = function1;
                return coroutineSingletons;
            } catch (Throwable th4) {
                th = th4;
                function1 = mutex;
                function1.unlock(null);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public final void saveEpisode(String str, String str2, boolean z) {
        str.getClass();
        enqueue(new SyncOperation.SaveEpisode(str, str2, z));
    }

    public final void savePodcast(String str, boolean z) {
        str.getClass();
        Timber.Forest.getClass();
        ConnectionPool.d(new Object[0]);
        enqueue(new SyncOperation.SavePodcast(str, z));
    }

    public final void scheduleRemoveFromPlaylist(String str, String str2, String str3, Function1 function1) {
        Object objPutIfAbsent;
        str.getClass();
        str2.getClass();
        str3.getClass();
        ConcurrentHashMap concurrentHashMap = this.playlistsBeingModified;
        Object atomicInteger = concurrentHashMap.get(str3);
        if (atomicInteger == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(str3, (atomicInteger = new AtomicInteger(0)))) != null) {
            atomicInteger = objPutIfAbsent;
        }
        ((AtomicInteger) atomicInteger).incrementAndGet();
        AwaitKt.launch$default(this.syncScope, null, null, new NetworkFetcher$doFetch$fetchResult$1(this, str2, str, str3, function1, null, (byte) 7), 3);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object syncEpisodesForLaterSuspend(ContinuationImpl continuationImpl) throws Throwable {
        C01901 c01901;
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        if (continuationImpl instanceof C01901) {
            c01901 = (C01901) continuationImpl;
            int i = c01901.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01901.label = i - Integer.MIN_VALUE;
            } else {
                c01901 = new C01901(continuationImpl);
            }
        } else {
            c01901 = new C01901(continuationImpl);
        }
        Object obj = c01901.result;
        int i2 = c01901.label;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.syncExecutionMutex;
                c01901.L$0 = mutex;
                c01901.label = 1;
                if (mutex.lock(c01901) != obj2) {
                }
                return obj2;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                mutex2 = c01901.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    Unit unit = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return unit;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = c01901.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            c01901.L$0 = mutex;
            c01901.label = 2;
            if (executeSyncEpisodesForLater(c01901) != obj2) {
                mutex2 = mutex;
                Unit unit2 = Unit.INSTANCE;
                mutex2.unlock(null);
                return unit2;
            }
            return obj2;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object syncLikedSongsSuspend(ContinuationImpl continuationImpl) throws Throwable {
        C01911 c01911;
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        if (continuationImpl instanceof C01911) {
            c01911 = (C01911) continuationImpl;
            int i = c01911.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01911.label = i - Integer.MIN_VALUE;
            } else {
                c01911 = new C01911(continuationImpl);
            }
        } else {
            c01911 = new C01911(continuationImpl);
        }
        Object obj = c01911.result;
        int i2 = c01911.label;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.syncExecutionMutex;
                c01911.L$0 = mutex;
                c01911.label = 1;
                if (mutex.lock(c01911) != obj2) {
                }
                return obj2;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                mutex2 = c01911.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    Unit unit = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return unit;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = c01911.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            c01911.L$0 = mutex;
            c01911.label = 2;
            if (executeSyncLikedSongs(c01911) != obj2) {
                mutex2 = mutex;
                Unit unit2 = Unit.INSTANCE;
                mutex2.unlock(null);
                return unit2;
            }
            return obj2;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object syncPlaylistSuspend(String str, String str2, ContinuationImpl continuationImpl) throws Throwable {
        C01921 c01921;
        String str3;
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        if (continuationImpl instanceof C01921) {
            c01921 = (C01921) continuationImpl;
            int i = c01921.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01921.label = i - Integer.MIN_VALUE;
            } else {
                c01921 = new C01921(continuationImpl);
            }
        } else {
            c01921 = new C01921(continuationImpl);
        }
        Object obj = c01921.result;
        int i2 = c01921.label;
        Continuation continuation = null;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                c01921.L$0 = str;
                c01921.L$1 = str2;
                MutexImpl mutexImpl = this.syncExecutionMutex;
                c01921.L$2 = mutexImpl;
                c01921.label = 1;
                if (mutexImpl.lock(c01921) != obj2) {
                    str3 = str;
                    mutex = mutexImpl;
                }
                return obj2;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                mutex2 = c01921.L$2;
                try {
                    ResultKt.throwOnFailure(obj);
                    Unit unit = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return unit;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            mutex = c01921.L$2;
            str2 = c01921.L$1;
            String str4 = c01921.L$0;
            ResultKt.throwOnFailure(obj);
            str3 = str4;
            Function1 c00594 = new QuickJs.C00594((Object) this, (Object) str3, (Object) str2, continuation, (byte) 4);
            c01921.L$0 = null;
            c01921.L$1 = null;
            c01921.L$2 = mutex;
            c01921.label = 2;
            if (runQueuedPlaylistEdit(c00594, c01921) != obj2) {
                mutex2 = mutex;
                Unit unit2 = Unit.INSTANCE;
                mutex2.unlock(null);
                return unit2;
            }
            return obj2;
        } catch (Throwable th3) {
            Mutex mutex3 = mutex;
            th = th3;
            mutex2 = mutex3;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object syncPodcastSubscriptionsSuspend(ContinuationImpl continuationImpl) throws Throwable {
        C01931 c01931;
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        if (continuationImpl instanceof C01931) {
            c01931 = (C01931) continuationImpl;
            int i = c01931.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01931.label = i - Integer.MIN_VALUE;
            } else {
                c01931 = new C01931(continuationImpl);
            }
        } else {
            c01931 = new C01931(continuationImpl);
        }
        Object obj = c01931.result;
        int i2 = c01931.label;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.syncExecutionMutex;
                c01931.L$0 = mutex;
                c01931.label = 1;
                if (mutex.lock(c01931) != obj2) {
                }
                return obj2;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                mutex2 = c01931.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    Unit unit = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return unit;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = c01931.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            c01931.L$0 = mutex;
            c01931.label = 2;
            if (executeSyncPodcastSubscriptions(c01931) != obj2) {
                mutex2 = mutex;
                Unit unit2 = Unit.INSTANCE;
                mutex2.unlock(null);
                return unit2;
            }
            return obj2;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object syncUploadedSongsSuspend(ContinuationImpl continuationImpl) throws Throwable {
        C01941 c01941;
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        if (continuationImpl instanceof C01941) {
            c01941 = (C01941) continuationImpl;
            int i = c01941.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c01941.label = i - Integer.MIN_VALUE;
            } else {
                c01941 = new C01941(continuationImpl);
            }
        } else {
            c01941 = new C01941(continuationImpl);
        }
        Object obj = c01941.result;
        int i2 = c01941.label;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.syncExecutionMutex;
                c01941.L$0 = mutex;
                c01941.label = 1;
                if (mutex.lock(c01941) != obj2) {
                }
                return obj2;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                mutex2 = c01941.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    Unit unit = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return unit;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = c01941.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            c01941.L$0 = mutex;
            c01941.label = 2;
            if (executeSyncUploadedSongs(c01941) != obj2) {
                mutex2 = mutex;
                Unit unit2 = Unit.INSTANCE;
                mutex2.unlock(null);
                return unit2;
            }
            return obj2;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock(null);
            throw th;
        }
    }

    public final void unmarkPlaylistModifying(String str) {
        ConcurrentHashMap concurrentHashMap = this.playlistsBeingModified;
        AtomicInteger atomicInteger = (AtomicInteger) concurrentHashMap.get(str);
        if (atomicInteger == null || atomicInteger.decrementAndGet() > 0) {
            return;
        }
        concurrentHashMap.remove(str);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(4:45|22|(1:25)|36) */
    /* JADX WARN: Code duplicated, block: B:25:0x0079  */
    /* JADX WARN: Code duplicated, block: B:32:0x009c  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:45:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0087, code lost:
    
        r15 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0088, code lost:
    
        r15 = r10;
        r10 = r15;
        r6 = r14;
        r13 = r12;
        r12 = r11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v12, types: [byte] */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v6, types: [int, short] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r15v10, types: [byte] */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v2, types: [byte, int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7, types: [int, short] */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00ba -> B:38:0x00be). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: withRetry-BWLJW6A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Serializable m1522withRetryBWLJW6A(int i, long j, Function1 function1, Continuation continuation) {
        SyncUtils$withRetry$1 syncUtils$withRetry$1;
        Ref$LongRef ref$LongRef;
        ?? r10;
        int i2;
        ?? r15;
        long j2;
        int i3;
        Function1 function2;
        int i4;
        ?? r11;
        Object objInvoke;
        if (continuation instanceof SyncUtils$withRetry$1) {
            syncUtils$withRetry$1 = (SyncUtils$withRetry$1) continuation;
            int i5 = syncUtils$withRetry$1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                syncUtils$withRetry$1.label = i5 - Integer.MIN_VALUE;
            } else {
                syncUtils$withRetry$1 = new SyncUtils$withRetry$1(this, continuation);
            }
        } else {
            syncUtils$withRetry$1 = new SyncUtils$withRetry$1(this, continuation);
        }
        Object obj = syncUtils$withRetry$1.result;
        int i6 = syncUtils$withRetry$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i6 == 0) {
                ResultKt.throwOnFailure(obj);
                Ref$LongRef ref$LongRef2 = new Ref$LongRef();
                ref$LongRef2.element = j;
                ref$LongRef = ref$LongRef2;
                r10 = i;
                i2 = 0;
                if (i2 >= r10) {
                    return new Result.Failure(new Exception("Max retries exceeded"));
                }
                syncUtils$withRetry$1.L$0 = function1;
                syncUtils$withRetry$1.L$1 = ref$LongRef;
                syncUtils$withRetry$1.I$0 = r10;
                syncUtils$withRetry$1.J$0 = (int) j;
                syncUtils$withRetry$1.I$1 = i2;
                syncUtils$withRetry$1.I$2 = i2;
                syncUtils$withRetry$1.label = 1;
                objInvoke = function1.invoke(syncUtils$withRetry$1);
                if (objInvoke != coroutineSingletons) {
                    r15 = r10;
                    obj = objInvoke;
                    function2 = function1;
                    j2 = j;
                    i3 = i2;
                }
                return coroutineSingletons;
            }
            if (i6 != 1) {
                if (i6 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                i4 = syncUtils$withRetry$1.I$1;
                j = syncUtils$withRetry$1.J$0;
                byte b = syncUtils$withRetry$1.I$0;
                Ref$LongRef ref$LongRef3 = syncUtils$withRetry$1.L$1;
                Function1 function3 = syncUtils$withRetry$1.L$0;
                ResultKt.throwOnFailure(obj);
                r11 = b;
                function1 = function3;
                ref$LongRef = ref$LongRef3;
                ref$LongRef.element *= 2;
                i2 = i4 + 1;
                r10 = r11;
                if (i2 >= r10) {
                    return new Result.Failure(new Exception("Max retries exceeded"));
                }
                syncUtils$withRetry$1.L$0 = function1;
                syncUtils$withRetry$1.L$1 = ref$LongRef;
                syncUtils$withRetry$1.I$0 = r10;
                syncUtils$withRetry$1.J$0 = (int) j;
                syncUtils$withRetry$1.I$1 = i2;
                syncUtils$withRetry$1.I$2 = i2;
                syncUtils$withRetry$1.label = 1;
                objInvoke = function1.invoke(syncUtils$withRetry$1);
                if (objInvoke != coroutineSingletons) {
                    r15 = r10;
                    obj = objInvoke;
                    function2 = function1;
                    j2 = j;
                    i3 = i2;
                }
                return coroutineSingletons;
            }
            i2 = syncUtils$withRetry$1.I$2;
            i3 = syncUtils$withRetry$1.I$1;
            j2 = syncUtils$withRetry$1.J$0;
            r15 = syncUtils$withRetry$1.I$0;
            ref$LongRef = syncUtils$withRetry$1.L$1;
            function2 = syncUtils$withRetry$1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                r15 = r15;
            } catch (Exception e) {
                Exception e2 = e;
                Timber.Forest.getClass();
                ConnectionPool.w$1(new Object[0]);
                if (i2 == r15 - 1) {
                    return new Result.Failure(e2);
                }
                long j3 = ref$LongRef.element;
                syncUtils$withRetry$1.L$0 = function2;
                syncUtils$withRetry$1.L$1 = ref$LongRef;
                syncUtils$withRetry$1.I$0 = r15;
                syncUtils$withRetry$1.J$0 = (int) j2;
                syncUtils$withRetry$1.I$1 = i3;
                syncUtils$withRetry$1.I$2 = i2;
                syncUtils$withRetry$1.label = 2;
                if (AwaitKt.delay(j3, syncUtils$withRetry$1) != coroutineSingletons) {
                    i4 = i3;
                    j = j2;
                    r11 = r15;
                    function1 = function2;
                    ref$LongRef.element *= 2;
                    i2 = i4 + 1;
                    r10 = r11;
                    if (i2 >= r10) {
                        return new Result.Failure(new Exception("Max retries exceeded"));
                    }
                    syncUtils$withRetry$1.L$0 = function1;
                    syncUtils$withRetry$1.L$1 = ref$LongRef;
                    syncUtils$withRetry$1.I$0 = r10;
                    syncUtils$withRetry$1.J$0 = (int) j;
                    syncUtils$withRetry$1.I$1 = i2;
                    syncUtils$withRetry$1.I$2 = i2;
                    syncUtils$withRetry$1.label = 1;
                    objInvoke = function1.invoke(syncUtils$withRetry$1);
                    if (objInvoke != coroutineSingletons) {
                        r15 = r10;
                        obj = objInvoke;
                        function2 = function1;
                        j2 = j;
                        i3 = i2;
                    }
                }
                return coroutineSingletons;
            }
            Result result = (Result) obj;
            ResultKt.throwOnFailure(result.value);
            return result;
        } catch (CancellationException e3) {
            throw e3;
        }
    }

    public final void writeSyncSnapshot(String str, Set set) {
        Object failure;
        try {
            File filesDir = this.context.getFilesDir();
            filesDir.getClass();
            FilesKt.writeText$default(FilesKt.resolve(filesDir, str), CollectionsKt.joinToString$default(set, "\n", null, null, null, 62));
            failure = Unit.INSTANCE;
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (Result.m1866exceptionOrNullimpl(failure) != null) {
            Timber.Forest.getClass();
            ConnectionPool.w$1(new Object[0]);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.utils.SyncUtils$executeSyncUploadedSongs$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C01852 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId = 0;
        public Object L$0;
        public SyncUtils L$1;
        public Object L$11;
        public Object L$12;
        public Object L$3;
        public Object L$5;
        public Object L$6;
        public Object L$7;
        public Object L$9;
        public byte label;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01852(Function1 function1, MusicDatabase musicDatabase, Playlist playlist, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, AddToPlaylistPosition addToPlaylistPosition, SyncUtils syncUtils, Function0 function0, Continuation continuation) {
            super(2, continuation);
            this.L$3 = function1;
            this.L$12 = musicDatabase;
            this.this$0 = playlist;
            this.L$5 = mutableState;
            this.L$7 = mutableState2;
            this.L$6 = mutableState3;
            this.L$11 = addToPlaylistPosition;
            this.L$1 = syncUtils;
            this.L$9 = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj2 = this.this$0;
            switch (b) {
                case 0:
                    return new C01852((SyncUtils) obj2, continuation);
                default:
                    return new C01852((Function1) this.L$3, (MusicDatabase) this.L$12, (Playlist) obj2, (MutableState) this.L$5, (MutableState) this.L$7, (MutableState) this.L$6, (AddToPlaylistPosition) this.L$11, this.L$1, (Function0) this.L$9, continuation);
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
            return ((C01852) create(coroutineScope, continuation)).invokeSuspend(unit);
        }

        /* JADX WARN: Code duplicated, block: B:106:0x0305 A[Catch: Exception -> 0x02fc, PHI: r1 r2 r3 r8 r9 r10 r11
          0x0305: PHI (r1v10 ??) = (r1v64 ??), (r1v65 ??), (r1v66 ??), (r1v67 ??) binds: [B:136:0x03a6, B:127:0x038a, B:105:0x0300, B:38:0x0108] A[DONT_GENERATE, DONT_INLINE]
          0x0305: PHI (r2v9 ??) = (r2v45 ??), (r2v46 ??), (r2v47 ??), (r2v48 ??) binds: [B:136:0x03a6, B:127:0x038a, B:105:0x0300, B:38:0x0108] A[DONT_GENERATE, DONT_INLINE]
          0x0305: PHI (r3v16 ??) = (r3v45 ??), (r3v46 ??), (r3v47 ??), (r3v48 ??) binds: [B:136:0x03a6, B:127:0x038a, B:105:0x0300, B:38:0x0108] A[DONT_GENERATE, DONT_INLINE]
          0x0305: PHI (r8v8 ??) = (r8v37 ??), (r8v38 ??), (r8v39 ??), (r8v40 ??) binds: [B:136:0x03a6, B:127:0x038a, B:105:0x0300, B:38:0x0108] A[DONT_GENERATE, DONT_INLINE]
          0x0305: PHI (r9v5 ??) = (r9v10 ??), (r9v11 ??), (r9v6 ??), (r9v12 ??) binds: [B:136:0x03a6, B:127:0x038a, B:105:0x0300, B:38:0x0108] A[DONT_GENERATE, DONT_INLINE]
          0x0305: PHI (r10v9 kotlin.coroutines.Continuation) = 
          (r10v3 kotlin.coroutines.Continuation)
          (r10v4 kotlin.coroutines.Continuation)
          (r10v17 kotlin.coroutines.Continuation)
          (r10v26 kotlin.coroutines.Continuation)
         binds: [B:136:0x03a6, B:127:0x038a, B:105:0x0300, B:38:0x0108] A[DONT_GENERATE, DONT_INLINE]
          0x0305: PHI (r11v7 ??) = (r11v24 ??), (r11v25 ??), (r11v26 ??), (r11v23 ??) binds: [B:136:0x03a6, B:127:0x038a, B:105:0x0300, B:38:0x0108] A[DONT_GENERATE, DONT_INLINE], TryCatch #6 {Exception -> 0x02fc, blocks: (B:106:0x0305, B:108:0x030b, B:136:0x03a6, B:137:0x03b5, B:96:0x02ad, B:98:0x02b3, B:103:0x02ed, B:105:0x0300), top: B:165:0x02ed }] */
        /* JADX WARN: Code duplicated, block: B:108:0x030b A[Catch: Exception -> 0x02fc, TRY_LEAVE, TryCatch #6 {Exception -> 0x02fc, blocks: (B:106:0x0305, B:108:0x030b, B:136:0x03a6, B:137:0x03b5, B:96:0x02ad, B:98:0x02b3, B:103:0x02ed, B:105:0x0300), top: B:165:0x02ed }] */
        /* JADX WARN: Code duplicated, block: B:123:0x0369  */
        /* JADX WARN: Code duplicated, block: B:46:0x015e A[PHI: r0 r1 r2 r3 r4 r8 r9 r10 r11
          0x015e: PHI (r0v15 ??) = (r0v57 ??), (r0v58 ??) binds: [B:110:0x0333, B:45:0x015a] A[DONT_GENERATE, DONT_INLINE]
          0x015e: PHI (r1v9 ??) = (r1v68 ??), (r1v69 ??) binds: [B:110:0x0333, B:45:0x015a] A[DONT_GENERATE, DONT_INLINE]
          0x015e: PHI (r2v8 ??) = (r2v49 ??), (r2v50 ??) binds: [B:110:0x0333, B:45:0x015a] A[DONT_GENERATE, DONT_INLINE]
          0x015e: PHI (r3v8 ??) = (r3v49 ??), (r3v50 ??) binds: [B:110:0x0333, B:45:0x015a] A[DONT_GENERATE, DONT_INLINE]
          0x015e: PHI (r4v5 java.lang.Object) = (r4v9 java.lang.Object), (r4v25 java.lang.Object) binds: [B:110:0x0333, B:45:0x015a] A[DONT_GENERATE, DONT_INLINE]
          0x015e: PHI (r8v7 ??) = (r8v41 ??), (r8v42 ??) binds: [B:110:0x0333, B:45:0x015a] A[DONT_GENERATE, DONT_INLINE]
          0x015e: PHI (r9v4 ??) = (r9v13 ??), (r9v14 ??) binds: [B:110:0x0333, B:45:0x015a] A[DONT_GENERATE, DONT_INLINE]
          0x015e: PHI (r10v5 kotlin.coroutines.Continuation) = (r10v9 kotlin.coroutines.Continuation), (r10v22 kotlin.coroutines.Continuation) binds: [B:110:0x0333, B:45:0x015a] A[DONT_GENERATE, DONT_INLINE]
          0x015e: PHI (r11v6 ??) = (r11v27 ??), (r11v21 ??) binds: [B:110:0x0333, B:45:0x015a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v19 */
        /* JADX WARN: Type inference failed for: r0v2, types: [com.metrolist.music.utils.SyncUtils] */
        /* JADX WARN: Type inference failed for: r0v23, types: [com.metrolist.innertube.models.SongItem, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v25, types: [com.metrolist.music.utils.SyncUtils] */
        /* JADX WARN: Type inference failed for: r0v28 */
        /* JADX WARN: Type inference failed for: r0v32 */
        /* JADX WARN: Type inference failed for: r0v33, types: [com.metrolist.music.utils.SyncUtils] */
        /* JADX WARN: Type inference failed for: r0v37 */
        /* JADX WARN: Type inference failed for: r0v57 */
        /* JADX WARN: Type inference failed for: r0v58 */
        /* JADX WARN: Type inference failed for: r0v59 */
        /* JADX WARN: Type inference failed for: r0v60 */
        /* JADX WARN: Type inference failed for: r0v61 */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9, types: [com.metrolist.innertube.models.SongItem] */
        /* JADX WARN: Type inference failed for: r11v1 */
        /* JADX WARN: Type inference failed for: r11v17 */
        /* JADX WARN: Type inference failed for: r11v18 */
        /* JADX WARN: Type inference failed for: r11v19, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r11v2 */
        /* JADX WARN: Type inference failed for: r11v21 */
        /* JADX WARN: Type inference failed for: r11v22 */
        /* JADX WARN: Type inference failed for: r11v23 */
        /* JADX WARN: Type inference failed for: r11v24 */
        /* JADX WARN: Type inference failed for: r11v25 */
        /* JADX WARN: Type inference failed for: r11v26 */
        /* JADX WARN: Type inference failed for: r11v27 */
        /* JADX WARN: Type inference failed for: r11v28 */
        /* JADX WARN: Type inference failed for: r11v29 */
        /* JADX WARN: Type inference failed for: r11v3 */
        /* JADX WARN: Type inference failed for: r11v30 */
        /* JADX WARN: Type inference failed for: r11v31 */
        /* JADX WARN: Type inference failed for: r11v32 */
        /* JADX WARN: Type inference failed for: r11v4 */
        /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r11v7, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r13v4 */
        /* JADX WARN: Type inference failed for: r18v0, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r19v0, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v64 */
        /* JADX WARN: Type inference failed for: r1v65 */
        /* JADX WARN: Type inference failed for: r1v66 */
        /* JADX WARN: Type inference failed for: r1v67 */
        /* JADX WARN: Type inference failed for: r1v68 */
        /* JADX WARN: Type inference failed for: r1v69 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v70 */
        /* JADX WARN: Type inference failed for: r1v71 */
        /* JADX WARN: Type inference failed for: r1v72 */
        /* JADX WARN: Type inference failed for: r1v73 */
        /* JADX WARN: Type inference failed for: r1v74 */
        /* JADX WARN: Type inference failed for: r1v75 */
        /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v17, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v20, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v45 */
        /* JADX WARN: Type inference failed for: r2v46 */
        /* JADX WARN: Type inference failed for: r2v47 */
        /* JADX WARN: Type inference failed for: r2v48 */
        /* JADX WARN: Type inference failed for: r2v49 */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v50 */
        /* JADX WARN: Type inference failed for: r2v51 */
        /* JADX WARN: Type inference failed for: r2v52 */
        /* JADX WARN: Type inference failed for: r2v53 */
        /* JADX WARN: Type inference failed for: r2v54 */
        /* JADX WARN: Type inference failed for: r2v55 */
        /* JADX WARN: Type inference failed for: r2v56 */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, java.util.Iterator] */
        /* JADX WARN: Type inference failed for: r3v1, types: [byte] */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v15 */
        /* JADX WARN: Type inference failed for: r3v16 */
        /* JADX WARN: Type inference failed for: r3v45 */
        /* JADX WARN: Type inference failed for: r3v46 */
        /* JADX WARN: Type inference failed for: r3v47 */
        /* JADX WARN: Type inference failed for: r3v48 */
        /* JADX WARN: Type inference failed for: r3v49 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v50 */
        /* JADX WARN: Type inference failed for: r3v51 */
        /* JADX WARN: Type inference failed for: r3v6 */
        /* JADX WARN: Type inference failed for: r3v7 */
        /* JADX WARN: Type inference failed for: r3v8 */
        /* JADX WARN: Type inference failed for: r3v9 */
        /* JADX WARN: Type inference failed for: r4v14 */
        /* JADX WARN: Type inference failed for: r4v15 */
        /* JADX WARN: Type inference failed for: r4v16 */
        /* JADX WARN: Type inference failed for: r4v17 */
        /* JADX WARN: Type inference failed for: r4v2 */
        /* JADX WARN: Type inference failed for: r4v22 */
        /* JADX WARN: Type inference failed for: r4v24 */
        /* JADX WARN: Type inference failed for: r8v0 */
        /* JADX WARN: Type inference failed for: r8v1 */
        /* JADX WARN: Type inference failed for: r8v13 */
        /* JADX WARN: Type inference failed for: r8v16 */
        /* JADX WARN: Type inference failed for: r8v17, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v19 */
        /* JADX WARN: Type inference failed for: r8v2 */
        /* JADX WARN: Type inference failed for: r8v20, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r8v37 */
        /* JADX WARN: Type inference failed for: r8v38 */
        /* JADX WARN: Type inference failed for: r8v39 */
        /* JADX WARN: Type inference failed for: r8v4 */
        /* JADX WARN: Type inference failed for: r8v40 */
        /* JADX WARN: Type inference failed for: r8v41 */
        /* JADX WARN: Type inference failed for: r8v42 */
        /* JADX WARN: Type inference failed for: r8v43 */
        /* JADX WARN: Type inference failed for: r8v44 */
        /* JADX WARN: Type inference failed for: r8v45 */
        /* JADX WARN: Type inference failed for: r8v46 */
        /* JADX WARN: Type inference failed for: r8v47 */
        /* JADX WARN: Type inference failed for: r8v48 */
        /* JADX WARN: Type inference failed for: r8v5 */
        /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v7, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v9 */
        /* JADX WARN: Type inference failed for: r9v0 */
        /* JADX WARN: Type inference failed for: r9v1 */
        /* JADX WARN: Type inference failed for: r9v10 */
        /* JADX WARN: Type inference failed for: r9v11 */
        /* JADX WARN: Type inference failed for: r9v12 */
        /* JADX WARN: Type inference failed for: r9v13 */
        /* JADX WARN: Type inference failed for: r9v14 */
        /* JADX WARN: Type inference failed for: r9v15 */
        /* JADX WARN: Type inference failed for: r9v16 */
        /* JADX WARN: Type inference failed for: r9v2 */
        /* JADX WARN: Type inference failed for: r9v3, types: [com.metrolist.music.utils.SyncUtils] */
        /* JADX WARN: Type inference failed for: r9v4, types: [com.metrolist.music.utils.SyncUtils] */
        /* JADX WARN: Type inference failed for: r9v5, types: [com.metrolist.music.utils.SyncUtils] */
        /* JADX WARN: Type inference failed for: r9v6 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:103:0x02ed -> B:96:0x02ad). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:127:0x038a -> B:106:0x0305). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:136:0x03a6 -> B:106:0x0305). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                Method dump skipped, instruction units count: 1042
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.utils.SyncUtils.C01852.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01852(SyncUtils syncUtils, Continuation continuation) {
            super(2, continuation);
            this.this$0 = syncUtils;
        }
    }
}
