package com.metrolist.music.viewmodels;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import com.metrolist.music.constants.ArtistSortType;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.UtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StartedLazily;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/LibraryMixViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class LibraryMixViewModel extends ViewModel {
    public final StateFlowImpl _isRefreshing;
    public final StateFlowImpl _searchQuery;
    public final ReadonlyStateFlow albums;
    public final ReadonlyStateFlow artists;
    public final ReadonlyStateFlow debouncedSearchQuery;
    public final ReadonlyStateFlow isRefreshing;
    public final ReadonlyStateFlow playlists;
    public final ReadonlyStateFlow searchQuery;
    public final ReadonlyStateFlow songs;
    public final ImageLoader$Builder$$ExternalSyntheticLambda1 syncAllLibrary;
    public final SyncUtils syncUtils;
    public final Flow topValue;

    public LibraryMixViewModel(Context context, MusicDatabase musicDatabase, SyncUtils syncUtils) {
        musicDatabase.getClass();
        syncUtils.getClass();
        this.syncUtils = syncUtils;
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this._isRefreshing = stateFlowImplMutableStateFlow;
        this.isRefreshing = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        StateFlowImpl stateFlowImplMutableStateFlow2 = StateFlowKt.MutableStateFlow("");
        this._searchQuery = stateFlowImplMutableStateFlow2;
        this.searchQuery = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow2);
        Flow flowDebounce = StateFlowKt.debounce(stateFlowImplMutableStateFlow2, 300L);
        CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        StartedLazily startedLazily = SharingStarted.Companion.Lazily;
        this.debouncedSearchQuery = StateFlowKt.stateIn(flowDebounce, viewModelScope, startedLazily, "");
        this.syncAllLibrary = new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 19, this);
        this.topValue = StateFlowKt.distinctUntilChanged(new HomeViewModel$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), (byte) 9));
        Flow flowArtistsBookmarked = musicDatabase.$$delegate_0.artistsBookmarked(ArtistSortType.CREATE_DATE, true);
        CloseableCoroutineScope viewModelScope2 = ViewModelKt.getViewModelScope(this);
        EmptyList emptyList = EmptyList.INSTANCE;
        this.artists = StateFlowKt.stateIn(flowArtistsBookmarked, viewModelScope2, startedLazily, emptyList);
        Continuation continuation = null;
        this.albums = StateFlowKt.stateIn(FlowKt__MergeKt.transformLatest(StateFlowKt.distinctUntilChanged(new HomeViewModel$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), (byte) 10)), new PlaylistsViewModel$special$$inlined$flatMapLatest$1(continuation, musicDatabase, (byte) 3)), ViewModelKt.getViewModelScope(this), startedLazily, emptyList);
        this.songs = StateFlowKt.stateIn(FlowKt__MergeKt.transformLatest(StateFlowKt.distinctUntilChanged(new HomeViewModel$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), (byte) 11)), new PlaylistsViewModel$special$$inlined$flatMapLatest$1(continuation, musicDatabase, (byte) 4)), ViewModelKt.getViewModelScope(this), startedLazily, emptyList);
        this.playlists = StateFlowKt.stateIn(FlowKt__MergeKt.transformLatest(StateFlowKt.distinctUntilChanged(new HomeViewModel$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), (byte) 12)), new PlaylistsViewModel$special$$inlined$flatMapLatest$1(continuation, musicDatabase, (byte) 5)), ViewModelKt.getViewModelScope(this), startedLazily, emptyList);
        CloseableCoroutineScope viewModelScope3 = ViewModelKt.getViewModelScope(this);
        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
        AwaitKt.launch$default(viewModelScope3, defaultIoScheduler, null, new AnonymousClass1(this, musicDatabase, continuation, (byte) 0), 2);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), defaultIoScheduler, null, new AnonymousClass1(this, musicDatabase, continuation, (byte) 1), 2);
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.LibraryMixViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ MusicDatabase $database;
        public final /* synthetic */ byte $r8$classId;
        public boolean label;
        public final /* synthetic */ LibraryMixViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(LibraryMixViewModel libraryMixViewModel, MusicDatabase musicDatabase, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = libraryMixViewModel;
            this.$database = musicDatabase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            MusicDatabase musicDatabase = this.$database;
            LibraryMixViewModel libraryMixViewModel = this.this$0;
            switch (b) {
                case 0:
                    return new AnonymousClass1(libraryMixViewModel, musicDatabase, continuation, (byte) 0);
                default:
                    return new AnonymousClass1(libraryMixViewModel, musicDatabase, continuation, (byte) 1);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
                default:
                    ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
            }
            return coroutineSingletons;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            MusicDatabase musicDatabase = this.$database;
            LibraryMixViewModel libraryMixViewModel = this.this$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
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
                    ReadonlyStateFlow readonlyStateFlow = libraryMixViewModel.albums;
                    C00111 c00111 = new C00111(musicDatabase, (byte) 0);
                    this.label = true;
                    if (readonlyStateFlow.$$delegate_0.collect(c00111, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                    return null;
                default:
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
                    ReadonlyStateFlow readonlyStateFlow2 = libraryMixViewModel.artists;
                    C00111 c00112 = new C00111(musicDatabase, (byte) 3);
                    this.label = true;
                    if (readonlyStateFlow2.$$delegate_0.collect(c00112, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                    return null;
            }
        }

        /* JADX INFO: renamed from: com.metrolist.music.viewmodels.LibraryMixViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class C00111 implements FlowCollector {
            public final /* synthetic */ MusicDatabase $database;
            public final /* synthetic */ byte $r8$classId;

            public /* synthetic */ C00111(MusicDatabase musicDatabase, byte b) {
                this.$r8$classId = b;
                this.$database = musicDatabase;
            }

            /* JADX WARN: Code duplicated, block: B:103:0x024a  */
            /* JADX WARN: Code duplicated, block: B:118:0x029d  */
            /* JADX WARN: Code duplicated, block: B:120:0x02b8  */
            /* JADX WARN: Code duplicated, block: B:123:0x02be  */
            /* JADX WARN: Code duplicated, block: B:126:0x02d0  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:119:0x02b6 -> B:121:0x02ba). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00ca -> B:32:0x00ce). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x018a -> B:64:0x018e). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x021b -> B:91:0x021f). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            public final java.lang.Object emit(java.util.List r20, kotlin.coroutines.Continuation r21) {
                /*
                    Method dump skipped, instruction units count: 736
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.viewmodels.LibraryMixViewModel.AnonymousClass1.C00111.emit(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                switch (this.$r8$classId) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                return emit((List) obj, continuation);
            }
        }
    }
}
