package com.metrolist.music.viewmodels;

import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.MagnifierNode;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.text.input.internal.Api34StartStylusHandwriting;
import androidx.compose.material3.internal.BackHandlerKt;
import androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.MotionDurationScaleImpl;
import androidx.compose.ui.platform.WeakCache;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreImpl;
import androidx.datastore.core.Final;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.pages.ArtistPage;
import com.metrolist.innertube.pages.ArtistSection;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.DatabaseDao;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.ArtistPageCacheKt;
import com.metrolist.music.db.entities.CachedArtistPage;
import com.metrolist.music.listentogether.ConnectionState;
import com.metrolist.music.listentogether.ListenTogetherClient;
import com.metrolist.music.listentogether.LogLevel;
import com.metrolist.music.lyrics.LyricsEntry;
import com.metrolist.music.lyrics.LyricsUtils;
import com.metrolist.music.recognition.RecognitionForegroundService;
import com.metrolist.music.utils.DataStoreKt$get$1;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.SyncUtils$special$$inlined$map$1;
import com.metrolist.music.utils.UtilsKt;
import com.metrolist.shazamkit.models.RecognitionStatus;
import com.valentinilk.shimmer.ShimmerArea;
import dev.chrisbanes.haze.HazeArea;
import dev.chrisbanes.haze.HazeSourceNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.ProducerCoroutine;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StartedLazily;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.CombineKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/ArtistViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class ArtistViewModel extends ViewModel {
    public final StateFlowImpl _apiSubscribed;
    public final String artistId;
    public final ParcelableSnapshotMutableState artistPage$delegate;
    public final Context context;
    public final MusicDatabase database;
    public final ReadonlyStateFlow isChannelSubscribed;
    public final boolean isPodcastChannel;
    public final ReadonlyStateFlow libraryAlbums;
    public final ReadonlyStateFlow libraryArtist;
    public final ReadonlyStateFlow librarySongs;
    public final SyncUtils syncUtils;

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.ArtistViewModel$loadCachedPage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02011 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C02011(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ArtistViewModel.this.loadCachedPage(this);
        }
    }

    public ArtistViewModel(Context context, SavedStateHandle savedStateHandle, MusicDatabase musicDatabase, SyncUtils syncUtils) {
        musicDatabase.getClass();
        DatabaseDao databaseDao = musicDatabase.$$delegate_0;
        syncUtils.getClass();
        savedStateHandle.getClass();
        this.context = context;
        this.database = musicDatabase;
        this.syncUtils = syncUtils;
        Object obj = savedStateHandle.get("artistId");
        obj.getClass();
        String str = (String) obj;
        this.artistId = str;
        Boolean bool = (Boolean) savedStateHandle.get("isPodcastChannel");
        byte b = 0;
        this.isPodcastChannel = bool != null ? bool.booleanValue() : false;
        Continuation continuation = null;
        this.artistPage$delegate = Stack.mutableStateOf$default(null);
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._apiSubscribed = stateFlowImplMutableStateFlow;
        Flow flowArtist = databaseDao.artist(str);
        CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        StartedLazily startedLazily = SharingStarted.Companion.Lazily;
        this.libraryArtist = StateFlowKt.stateIn(flowArtist, viewModelScope, startedLazily, null);
        this.isChannelSubscribed = StateFlowKt.stateIn(new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(stateFlowImplMutableStateFlow, databaseDao.artist(str), new ArtistViewModel$isChannelSubscribed$1(3, continuation, b), b), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.Eagerly, Boolean.FALSE);
        ChannelFlowTransformLatest channelFlowTransformLatestTransformLatest = FlowKt__MergeKt.transformLatest(StateFlowKt.distinctUntilChanged(new SyncUtils$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), (byte) 27)), new ArtistViewModel$special$$inlined$flatMapLatest$1(continuation, this, b));
        CloseableCoroutineScope viewModelScope2 = ViewModelKt.getViewModelScope(this);
        EmptyList emptyList = EmptyList.INSTANCE;
        this.librarySongs = StateFlowKt.stateIn(channelFlowTransformLatestTransformLatest, viewModelScope2, startedLazily, emptyList);
        this.libraryAlbums = StateFlowKt.stateIn(FlowKt__MergeKt.transformLatest(StateFlowKt.distinctUntilChanged(new SyncUtils$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), (byte) 28)), new ArtistViewModel$special$$inlined$flatMapLatest$1(continuation, this, (byte) 1)), ViewModelKt.getViewModelScope(this), startedLazily, emptyList);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, continuation, b), 3);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0067, code lost:
    
        if (r9 == r6) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadCachedPage(ContinuationImpl continuationImpl) {
        C02011 c02011;
        Context context = this.context;
        if (continuationImpl instanceof C02011) {
            c02011 = (C02011) continuationImpl;
            int i = c02011.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02011.label = i - Integer.MIN_VALUE;
            } else {
                c02011 = new C02011(continuationImpl);
            }
        } else {
            c02011 = new C02011(continuationImpl);
        }
        Object objFirstOrNull = c02011.result;
        int i2 = c02011.label;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objFirstOrNull);
                Flow flowArtist = this.database.artist(this.artistId);
                c02011.label = 1;
                objFirstOrNull = StateFlowKt.firstOrNull(flowArtist, c02011);
                if (objFirstOrNull == coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i2 == 1) {
                ResultKt.throwOnFailure(objFirstOrNull);
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objFirstOrNull);
            }
            ArtistPage artistPage = ArtistPageCacheKt.toArtistPage((CachedArtistPage) objFirstOrNull);
            DataStore dataStore = UtilsKt.getDataStore(context);
            Preferences$Key preferences$Key = PreferenceKeysKt.HideExplicitKey;
            Boolean bool = Boolean.FALSE;
            boolean zBooleanValue = ((Boolean) UtilsKt.get(dataStore, preferences$Key, bool)).booleanValue();
            boolean zBooleanValue2 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideVideoSongsKey, bool)).booleanValue();
            boolean zBooleanValue3 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideYoutubeShortsKey, bool)).booleanValue();
            List<ArtistSection> list = artistPage.sections;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            for (ArtistSection artistSection : list) {
                arrayList.add(ArtistSection.copy$default(artistSection, HexFormatKt.filterYoutubeShorts(HexFormatKt.filterVideoSongs(HexFormatKt.filterExplicit(artistSection.items, zBooleanValue), zBooleanValue2), zBooleanValue3)));
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                if (!((ArtistSection) obj).items.isEmpty()) {
                    arrayList2.add(obj);
                }
            }
            this.artistPage$delegate.setValue(ArtistPage.copy$default(artistPage, arrayList2));
            StateFlowImpl stateFlowImpl = this._apiSubscribed;
            Boolean boolValueOf = Boolean.valueOf(artistPage.isSubscribed);
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, boolValueOf);
            return Unit.INSTANCE;
            Artist artist = (Artist) objFirstOrNull;
            String str = artist != null ? artist.artist.cachedPageJson : null;
            if (str != null) {
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                LyricsUtils.AnonymousClass2 anonymousClass2 = new LyricsUtils.AnonymousClass2(str, continuation, (byte) 5);
                c02011.label = 2;
                objFirstOrNull = AwaitKt.withContext(defaultIoScheduler, anonymousClass2, c02011);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Unit.INSTANCE;
    }

    public final void toggleChannelSubscription() {
        String str;
        ArtistPage artistPage = (ArtistPage) this.artistPage$delegate.getValue();
        if (artistPage == null || (str = artistPage.artist.channelId) == null) {
            str = this.artistId;
        }
        boolean z = !((Boolean) this.isChannelSubscribed.$$delegate_0.getValue()).booleanValue();
        Timber.Forest.getClass();
        ConnectionPool.d(new Object[0]);
        Boolean boolValueOf = Boolean.valueOf(z);
        StateFlowImpl stateFlowImpl = this._apiSubscribed;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, boolValueOf);
        CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        AwaitKt.launch$default(viewModelScope, DefaultIoScheduler.INSTANCE, null, new DataStoreKt$get$1(this, z, str, (Continuation) null), 2);
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.ArtistViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public byte label;
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
                    return new AnonymousClass1((ArtistViewModel) obj2, continuation, (byte) 0);
                case 1:
                    return new AnonymousClass1((MagnifierNode) obj2, continuation, (byte) 1);
                case 2:
                    return new AnonymousClass1((PullToRefreshModifierNode) obj2, continuation, (byte) 2);
                case 3:
                    return new AnonymousClass1((SuspendingPointerInputModifierNodeImpl) obj2, continuation, (byte) 3);
                case 4:
                    return new AnonymousClass1((ArtistEntity) obj2, continuation, (byte) 4);
                case 5:
                    return new AnonymousClass1((AccountViewModel) obj2, continuation, (byte) 5);
                case 6:
                    return new AnonymousClass1((AutoPlaylistViewModel) obj2, continuation, (byte) 6);
                case 7:
                    return new AnonymousClass1((HomeViewModel) obj2, continuation, (byte) 7);
                case 8:
                    return new AnonymousClass1((LocalPlaylistViewModel) obj2, continuation, (byte) 8);
                default:
                    return new AnonymousClass1((OnlinePlaylistViewModel) obj2, continuation, (byte) 9);
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
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                case 1:
                    ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                    return CoroutineSingletons.COROUTINE_SUSPENDED;
                case 2:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                case 3:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                case 4:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                case 5:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                case 6:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                case 7:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                case 8:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                default:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
            }
        }

        /* JADX WARN: Code duplicated, block: B:205:0x0360  */
        /* JADX WARN: Code duplicated, block: B:207:0x0364  */
        /* JADX WARN: Code duplicated, block: B:212:0x0371  */
        /* JADX WARN: Code duplicated, block: B:273:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:274:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
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
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:211:0x036f -> B:205:0x0360). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:213:0x038b -> B:215:0x038e). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:205:0x0360
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instruction units count: 1014
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.viewmodels.ArtistViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.metrolist.music.viewmodels.ArtistViewModel$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class AnonymousClass2 implements FlowCollector {
            public final /* synthetic */ byte $r8$classId;
            public final /* synthetic */ Object this$0;

            public /* synthetic */ AnonymousClass2(byte b, Object obj) {
                this.$r8$classId = b;
                this.this$0 = obj;
            }

            /* JADX WARN: Code duplicated, block: B:9:0x0020  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object obj, Continuation continuation) {
                Object dataAndUpdateCache;
                Object objLoadPlaylists;
                FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1;
                byte b = this.$r8$classId;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                Unit unit = Unit.INSTANCE;
                Object obj2 = this.this$0;
                switch (b) {
                    case 0:
                        ArtistViewModel artistViewModel = (ArtistViewModel) obj2;
                        AwaitKt.launch$default(ViewModelKt.getViewModelScope(artistViewModel), null, null, new ArtistViewModel$fetchArtistsFromYTM$1(artistViewModel, null), 3);
                        return unit;
                    case 1:
                        WeakCache weakCache = (WeakCache) obj2;
                        if (Build.VERSION.SDK_INT >= 34) {
                            Api34StartStylusHandwriting.startStylusHandwriting(weakCache.getImm(), (View) weakCache.values);
                        }
                        return unit;
                    case 2:
                        Object objSnapTo = ((Animatable) obj2).snapTo(new Float(BackHandlerKt.PredictiveBackEasing.transform(((BackEventCompat) obj).progress)), continuation);
                        return objSnapTo == coroutineSingletons ? objSnapTo : unit;
                    case 3:
                        Interaction interaction = (Interaction) obj;
                        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) obj2;
                        if ((interaction instanceof PressInteraction.Press) || (interaction instanceof FocusInteraction.Focus)) {
                            parcelableSnapshotMutableIntState.setIntValue(parcelableSnapshotMutableIntState.getIntValue() + 1);
                        } else if ((interaction instanceof PressInteraction.Release) || (interaction instanceof FocusInteraction.Unfocus) || (interaction instanceof PressInteraction.Cancel)) {
                            parcelableSnapshotMutableIntState.setIntValue(parcelableSnapshotMutableIntState.getIntValue() - 1);
                        }
                        return unit;
                    case 4:
                        ((MotionDurationScaleImpl) obj2)._scaleFactor$delegate.setFloatValue(((Number) obj).floatValue());
                        return unit;
                    case 5:
                        DataStoreImpl dataStoreImpl = (DataStoreImpl) obj2;
                        return ((dataStoreImpl.inMemoryCache.getCurrentState() instanceof Final) || (dataAndUpdateCache = dataStoreImpl.readDataAndUpdateCache(true, continuation)) != coroutineSingletons) ? unit : dataAndUpdateCache;
                    case 6:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        ListenTogetherClient listenTogetherClient = (ListenTogetherClient) obj2;
                        StateFlowImpl stateFlowImpl = listenTogetherClient._connectionState;
                        boolean z = listenTogetherClient.isNetworkAvailable;
                        listenTogetherClient.isNetworkAvailable = zBooleanValue;
                        if (zBooleanValue && !z) {
                            LogLevel logLevel = LogLevel.INFO;
                            listenTogetherClient.log(logLevel, "Network restored, checking if reconnection needed", null);
                            if ((stateFlowImpl.getValue() == ConnectionState.ERROR || stateFlowImpl.getValue() == ConnectionState.DISCONNECTED) && (listenTogetherClient.sessionToken != null || listenTogetherClient._roomState.getValue() != null || listenTogetherClient.pendingAction != null)) {
                                listenTogetherClient.log(logLevel, "Network restored, triggering reconnection", null);
                                listenTogetherClient.reconnectAttempts = 0;
                                listenTogetherClient.connect();
                            }
                        } else if (!zBooleanValue && z) {
                            listenTogetherClient.log(LogLevel.WARNING, "Network lost", null);
                        }
                        return unit;
                    case 7:
                        RecognitionStatus recognitionStatus = (RecognitionStatus) obj;
                        if (!(recognitionStatus instanceof RecognitionStatus.Ready)) {
                            int i = RecognitionForegroundService.$r8$clinit;
                            ((RecognitionForegroundService) obj2).renderStatus(recognitionStatus);
                        }
                        return unit;
                    case 8:
                        Iterator it = ((List) obj2).iterator();
                        while (it.hasNext()) {
                            ((StateFlowImpl) ((LyricsEntry) it.next()).translatedTextFlow).setValue(null);
                        }
                        return unit;
                    case 9:
                        ((Boolean) obj).getClass();
                        AccountViewModel accountViewModel = (AccountViewModel) obj2;
                        return (accountViewModel.playlists.getValue() == null || (objLoadPlaylists = accountViewModel.loadPlaylists(continuation)) != coroutineSingletons) ? unit : objLoadPlaylists;
                    case 10:
                        return emit(continuation);
                    case 11:
                        Boolean bool = (Boolean) obj;
                        bool.getClass();
                        StateFlowImpl stateFlowImpl2 = ((LyricsMenuViewModel) obj2)._isNetworkAvailable;
                        stateFlowImpl2.getClass();
                        stateFlowImpl2.updateState(null, bool);
                        return unit;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        ((OnlineSearchSuggestionViewModel) obj2)._viewState.setValue((SearchSuggestionViewState) obj);
                        return unit;
                    case 13:
                        Rect rect = (Rect) obj;
                        ShimmerArea shimmerArea = (ShimmerArea) obj2;
                        if (!Intrinsics.areEqual(shimmerArea.requestedShimmerBounds, rect)) {
                            shimmerArea.requestedShimmerBounds = rect;
                            shimmerArea.computeShimmerBounds();
                        }
                        return unit;
                    case 14:
                        if (((Lifecycle.State) obj).compareTo(Lifecycle.State.CREATED) <= 0) {
                            HazeSourceNode hazeSourceNode = (HazeSourceNode) obj2;
                            HazeArea hazeArea = hazeSourceNode.area;
                            hazeArea.getClass();
                            GraphicsLayer contentLayer = hazeArea.getContentLayer();
                            if (contentLayer != null) {
                                ((GraphicsContext) HitTestResultKt.currentValueOf(hazeSourceNode, CompositionLocalsKt.LocalGraphicsContext)).releaseGraphicsLayer(contentLayer);
                            }
                            hazeArea.contentLayer$delegate.setValue(null);
                        }
                        return unit;
                    default:
                        if (continuation instanceof FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1) {
                            flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 = (FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1) continuation;
                            int i2 = flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1.label;
                            if ((i2 & Integer.MIN_VALUE) != 0) {
                                flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1.label = i2 - Integer.MIN_VALUE;
                            } else {
                                flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 = new FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1(this, continuation);
                            }
                        } else {
                            flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 = new FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1(this, continuation);
                        }
                        Object obj3 = flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1.result;
                        int i3 = flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1.label;
                        if (i3 == 0) {
                            ResultKt.throwOnFailure(obj3);
                            ProducerScope producerScope = (ProducerScope) obj2;
                            if (obj == null) {
                                obj = CombineKt.NULL;
                            }
                            flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1.label = 1;
                            if (((ProducerCoroutine) producerScope)._channel.send(obj, flowKt__DelayKt$debounceInternal$1$values$1$1$emit$1) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } else {
                            if (i3 != 1) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            ResultKt.throwOnFailure(obj3);
                        }
                        return unit;
                }
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
            
                if (r7.fetchPodcastChannels(r0) == r4) goto L21;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Object emit(Continuation continuation) {
                LibraryPodcastsViewModel$5$1$emit$1 libraryPodcastsViewModel$5$1$emit$1;
                if (continuation instanceof LibraryPodcastsViewModel$5$1$emit$1) {
                    libraryPodcastsViewModel$5$1$emit$1 = (LibraryPodcastsViewModel$5$1$emit$1) continuation;
                    int i = libraryPodcastsViewModel$5$1$emit$1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        libraryPodcastsViewModel$5$1$emit$1.label = i - Integer.MIN_VALUE;
                    } else {
                        libraryPodcastsViewModel$5$1$emit$1 = new LibraryPodcastsViewModel$5$1$emit$1(this, continuation);
                    }
                } else {
                    libraryPodcastsViewModel$5$1$emit$1 = new LibraryPodcastsViewModel$5$1$emit$1(this, continuation);
                }
                Object obj = libraryPodcastsViewModel$5$1$emit$1.result;
                int i2 = libraryPodcastsViewModel$5$1$emit$1.label;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    libraryPodcastsViewModel$5$1$emit$1.label = 1;
                    if (AwaitKt.delay(1500L, libraryPodcastsViewModel$5$1$emit$1) != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
                LibraryPodcastsViewModel libraryPodcastsViewModel = (LibraryPodcastsViewModel) this.this$0;
                libraryPodcastsViewModel$5$1$emit$1.label = 2;
            }
        }
    }
}
