package com.metrolist.music.viewmodels;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.pages.LibraryPage;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.utils.SyncUtils$special$$inlined$map$1;
import com.metrolist.music.utils.UtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StartedLazily;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/AccountViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class AccountViewModel extends ViewModel {
    public final StateFlowImpl albums;
    public final StateFlowImpl artists;
    public final Context context;
    public final StateFlowImpl playlists;
    public final StateFlowImpl podcastChannels;
    public final ReadonlyStateFlow podcastPlaylists;
    public final StateFlowImpl rdpnPlaylist;
    public final StateFlowImpl sePlaylist;
    public final StateFlowImpl selectedContentType;

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.AccountViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public boolean label;
        public final /* synthetic */ AccountViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(AccountViewModel accountViewModel, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = accountViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            AccountViewModel accountViewModel = this.this$0;
            switch (b) {
                case 0:
                    return new AnonymousClass2(accountViewModel, continuation, (byte) 0);
                case 1:
                    return new AnonymousClass2(accountViewModel, continuation, (byte) 1);
                default:
                    return new AnonymousClass2(accountViewModel, continuation, (byte) 2);
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
                case 1:
                    break;
            }
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(unit);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM1022newEpisodesPlaylistInfoIoAF18A;
            Object objM1013libraryPodcastChannelsIoAF18A;
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            AccountViewModel accountViewModel = this.this$0;
            switch (b) {
                case 0:
                    boolean z = this.label;
                    if (!z) {
                        ResultKt.throwOnFailure(obj);
                        YouTube youTube = YouTube.INSTANCE;
                        this.label = true;
                        objM1022newEpisodesPlaylistInfoIoAF18A = youTube.m1022newEpisodesPlaylistInfoIoAF18A(this);
                        if (objM1022newEpisodesPlaylistInfoIoAF18A == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        objM1022newEpisodesPlaylistInfoIoAF18A = ((Result) obj).value;
                    }
                    if (!(objM1022newEpisodesPlaylistInfoIoAF18A instanceof Result.Failure)) {
                        accountViewModel.rdpnPlaylist.setValue((PlaylistItem) objM1022newEpisodesPlaylistInfoIoAF18A);
                    }
                    Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1022newEpisodesPlaylistInfoIoAF18A);
                    if (thM1866exceptionOrNullimpl == null) {
                        return unit;
                    }
                    thM1866exceptionOrNullimpl.printStackTrace();
                    return unit;
                case 1:
                    boolean z2 = this.label;
                    if (!z2) {
                        ResultKt.throwOnFailure(obj);
                        YouTube youTube2 = YouTube.INSTANCE;
                        this.label = true;
                        objM1013libraryPodcastChannelsIoAF18A = youTube2.m1013libraryPodcastChannelsIoAF18A(this);
                        if (objM1013libraryPodcastChannelsIoAF18A == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        objM1013libraryPodcastChannelsIoAF18A = ((Result) obj).value;
                    }
                    if (!(objM1013libraryPodcastChannelsIoAF18A instanceof Result.Failure)) {
                        StateFlowImpl stateFlowImpl = accountViewModel.podcastChannels;
                        List list = ((LibraryPage) objM1013libraryPodcastChannelsIoAF18A).items;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj2 : list) {
                            if (obj2 instanceof ArtistItem) {
                                arrayList.add(obj2);
                            }
                        }
                        stateFlowImpl.getClass();
                        stateFlowImpl.updateState(null, arrayList);
                    }
                    Throwable thM1866exceptionOrNullimpl2 = Result.m1866exceptionOrNullimpl(objM1013libraryPodcastChannelsIoAF18A);
                    if (thM1866exceptionOrNullimpl2 == null) {
                        return unit;
                    }
                    thM1866exceptionOrNullimpl2.printStackTrace();
                    return unit;
                default:
                    boolean z3 = this.label;
                    if (z3) {
                        if (z3) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Flow flowDistinctUntilChanged = StateFlowKt.distinctUntilChanged(new SyncUtils$special$$inlined$map$1(UtilsKt.getDataStore(accountViewModel.context).getData(), (byte) 24));
                    ArtistViewModel.AnonymousClass1.AnonymousClass2 anonymousClass2 = new ArtistViewModel.AnonymousClass1.AnonymousClass2((byte) 9, accountViewModel);
                    this.label = true;
                    return flowDistinctUntilChanged.collect(anonymousClass2, this) == coroutineSingletons ? coroutineSingletons : unit;
            }
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.AccountViewModel$loadPlaylists$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AccountViewModel.this.loadPlaylists(this);
        }
    }

    public AccountViewModel(Context context, MusicDatabase musicDatabase) {
        musicDatabase.getClass();
        this.context = context;
        Continuation continuation = null;
        this.playlists = StateFlowKt.MutableStateFlow(null);
        this.albums = StateFlowKt.MutableStateFlow(null);
        this.artists = StateFlowKt.MutableStateFlow(null);
        this.sePlaylist = StateFlowKt.MutableStateFlow(null);
        this.rdpnPlaylist = StateFlowKt.MutableStateFlow(null);
        Flow flowSubscribedPodcasts = musicDatabase.$$delegate_0.subscribedPodcasts();
        CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        StartedLazily startedLazily = SharingStarted.Companion.Lazily;
        EmptyList emptyList = EmptyList.INSTANCE;
        this.podcastPlaylists = StateFlowKt.stateIn(flowSubscribedPodcasts, viewModelScope, startedLazily, emptyList);
        this.podcastChannels = StateFlowKt.MutableStateFlow(emptyList);
        this.selectedContentType = StateFlowKt.MutableStateFlow(AccountContentType.PLAYLISTS);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ArtistViewModel.AnonymousClass1(this, continuation, (byte) 5), 3);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(this, continuation, (byte) 0), 3);
        CloseableCoroutineScope viewModelScope2 = ViewModelKt.getViewModelScope(this);
        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
        AwaitKt.launch$default(viewModelScope2, defaultIoScheduler, null, new AnonymousClass2(this, continuation, (byte) 1), 2);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), defaultIoScheduler, null, new AnonymousClass2(this, continuation, (byte) 2), 2);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x007a  */
    /* JADX WARN: Code duplicated, block: B:29:0x008e  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:51:0x0096 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x00b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x00c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object loadPlaylists(Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        boolean z;
        Object obj;
        Object objCompletedPlaylist;
        boolean z2;
        Throwable thM1866exceptionOrNullimpl;
        ArrayList arrayList;
        int size;
        int i;
        int i2;
        Object obj2;
        ArrayList arrayList2;
        int size2;
        Object obj3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i3 = anonymousClass1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i3 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj4 = anonymousClass1.result;
        int i4 = anonymousClass1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj4);
            boolean zBooleanValue = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(this.context), PreferenceKeysKt.HideYoutubeShortsKey, Boolean.FALSE)).booleanValue();
            YouTube youTube = YouTube.INSTANCE;
            anonymousClass1.Z$0 = zBooleanValue;
            anonymousClass1.label = 1;
            Object objM1011library0E7RQCE = YouTube.INSTANCE.m1011library0E7RQCE("FEmusic_liked_playlists", 0, anonymousClass1);
            if (objM1011library0E7RQCE != coroutineSingletons) {
                z = zBooleanValue;
                obj = objM1011library0E7RQCE;
            }
            return coroutineSingletons;
        }
        if (i4 == 1) {
            z = anonymousClass1.Z$0;
            ResultKt.throwOnFailure(obj4);
            obj = ((Result) obj4).value;
        } else {
            if (i4 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            z2 = anonymousClass1.Z$0;
            ResultKt.throwOnFailure(obj4);
            objCompletedPlaylist = ((Result) obj4).value;
        }
        if (!(objCompletedPlaylist instanceof Result.Failure)) {
            List list = ((LibraryPage) objCompletedPlaylist).items;
            arrayList = new ArrayList();
            for (Object obj5 : list) {
                if (obj5 instanceof PlaylistItem) {
                    arrayList.add(obj5);
                }
            }
            size = arrayList.size();
            i = 0;
            i2 = 0;
            do {
                if (i2 < size) {
                    obj2 = null;
                    break;
                }
                obj2 = arrayList.get(i2);
                i2++;
            } while (!Intrinsics.areEqual(((PlaylistItem) obj2).id, "SE"));
            this.sePlaylist.setValue(obj2);
            arrayList2 = new ArrayList();
            size2 = arrayList.size();
            while (i < size2) {
                obj3 = arrayList.get(i);
                i++;
                if (!Intrinsics.areEqual(((PlaylistItem) obj3).id, "SE")) {
                    arrayList2.add(obj3);
                }
            }
            List listFilterYoutubeShorts = HexFormatKt.filterYoutubeShorts(arrayList2, z2);
            StateFlowImpl stateFlowImpl = this.playlists;
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, listFilterYoutubeShorts);
        }
        thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCompletedPlaylist);
        if (thM1866exceptionOrNullimpl != null) {
            thM1866exceptionOrNullimpl.printStackTrace();
        }
        return Unit.INSTANCE;
        anonymousClass1.Z$0 = z;
        anonymousClass1.label = 2;
        objCompletedPlaylist = StringsKt__IndentKt.completedPlaylist(obj, anonymousClass1);
        if (objCompletedPlaylist != coroutineSingletons) {
            z2 = z;
            if (!(objCompletedPlaylist instanceof Result.Failure)) {
                List list2 = ((LibraryPage) objCompletedPlaylist).items;
                arrayList = new ArrayList();
                while (r1.hasNext()) {
                    if (obj5 instanceof PlaylistItem) {
                        arrayList.add(obj5);
                    }
                }
                size = arrayList.size();
                i = 0;
                i2 = 0;
                do {
                    if (i2 < size) {
                        obj2 = null;
                        break;
                    }
                    obj2 = arrayList.get(i2);
                    i2++;
                } while (!Intrinsics.areEqual(((PlaylistItem) obj2).id, "SE"));
                this.sePlaylist.setValue(obj2);
                arrayList2 = new ArrayList();
                size2 = arrayList.size();
                while (i < size2) {
                    obj3 = arrayList.get(i);
                    i++;
                    if (!Intrinsics.areEqual(((PlaylistItem) obj3).id, "SE")) {
                        arrayList2.add(obj3);
                    }
                }
                List listFilterYoutubeShorts2 = HexFormatKt.filterYoutubeShorts(arrayList2, z2);
                StateFlowImpl stateFlowImpl2 = this.playlists;
                stateFlowImpl2.getClass();
                stateFlowImpl2.updateState(null, listFilterYoutubeShorts2);
            }
            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objCompletedPlaylist);
            if (thM1866exceptionOrNullimpl != null) {
                thM1866exceptionOrNullimpl.printStackTrace();
            }
            return Unit.INSTANCE;
        }
        return coroutineSingletons;
    }
}
