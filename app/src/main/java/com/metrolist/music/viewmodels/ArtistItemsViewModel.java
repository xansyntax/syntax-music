package com.metrolist.music.viewmodels;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.ArtistItemsPage;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.models.ItemsPage;
import com.metrolist.music.utils.UtilsKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/ArtistItemsViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class ArtistItemsViewModel extends ViewModel {
    public final String browseId;
    public final Context context;
    public final StateFlowImpl itemsPage;
    public final String params;
    public final StateFlowImpl title;

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.ArtistItemsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public Object L$0;
        public ArtistItemsViewModel L$1;
        public ArtistItemsPage L$2;
        public byte label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ArtistItemsViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x00a0  */
        /* JADX WARN: Code duplicated, block: B:28:0x00d1  */
        /* JADX WARN: Code duplicated, block: B:32:0x00b1 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:34:0x009a A[SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM999artistItemsgIAlus;
            ArtistItemsPage artistItemsPage;
            Object obj2;
            Throwable thM1866exceptionOrNullimpl;
            HashSet hashSet;
            ArrayList arrayList;
            byte b = this.label;
            ArtistItemsViewModel artistItemsViewModel = ArtistItemsViewModel.this;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (b == 0) {
                ResultKt.throwOnFailure(obj);
                YouTube youTube = YouTube.INSTANCE;
                BrowseEndpoint browseEndpoint = new BrowseEndpoint(artistItemsViewModel.browseId, artistItemsViewModel.params);
                this.label = (byte) 1;
                objM999artistItemsgIAlus = youTube.m999artistItemsgIAlus(browseEndpoint, this);
                if (objM999artistItemsgIAlus != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (b == 1) {
                ResultKt.throwOnFailure(obj);
                objM999artistItemsgIAlus = ((Result) obj).value;
            } else {
                if (b != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                artistItemsPage = this.L$2;
                artistItemsViewModel = this.L$1;
                obj2 = this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            DataStore dataStore = UtilsKt.getDataStore(artistItemsViewModel.context);
            Preferences$Key preferences$Key = PreferenceKeysKt.HideExplicitKey;
            Boolean bool = Boolean.FALSE;
            boolean zBooleanValue = ((Boolean) UtilsKt.get(dataStore, preferences$Key, bool)).booleanValue();
            boolean zBooleanValue2 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(artistItemsViewModel.context), PreferenceKeysKt.HideVideoSongsKey, bool)).booleanValue();
            artistItemsViewModel.title.setValue(artistItemsPage.title);
            StateFlowImpl stateFlowImpl = artistItemsViewModel.itemsPage;
            hashSet = new HashSet();
            arrayList = new ArrayList();
            for (Object obj3 : (List) obj) {
                if (hashSet.add(((YTItem) obj3).getId())) {
                    arrayList.add(obj3);
                }
            }
            ItemsPage itemsPage = new ItemsPage(HexFormatKt.filterVideoSongs(HexFormatKt.filterExplicit(arrayList, zBooleanValue), zBooleanValue2), artistItemsPage.continuation);
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, itemsPage);
            objM999artistItemsgIAlus = obj2;
            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM999artistItemsgIAlus);
            if (thM1866exceptionOrNullimpl != null) {
                thM1866exceptionOrNullimpl.printStackTrace();
            }
            return Unit.INSTANCE;
            if (!(objM999artistItemsgIAlus instanceof Result.Failure)) {
                artistItemsPage = (ArtistItemsPage) objM999artistItemsgIAlus;
                YouTube youTube2 = YouTube.INSTANCE;
                List list = artistItemsPage.items;
                this.L$0 = objM999artistItemsgIAlus;
                this.L$1 = artistItemsViewModel;
                this.L$2 = artistItemsPage;
                this.label = (byte) 2;
                Object objResolveArtistIds = youTube2.resolveArtistIds(list, this);
                if (objResolveArtistIds != coroutineSingletons) {
                    Object obj4 = objM999artistItemsgIAlus;
                    obj = objResolveArtistIds;
                    obj2 = obj4;
                    DataStore dataStore2 = UtilsKt.getDataStore(artistItemsViewModel.context);
                    Preferences$Key preferences$Key2 = PreferenceKeysKt.HideExplicitKey;
                    Boolean bool2 = Boolean.FALSE;
                    boolean zBooleanValue3 = ((Boolean) UtilsKt.get(dataStore2, preferences$Key2, bool2)).booleanValue();
                    boolean zBooleanValue4 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(artistItemsViewModel.context), PreferenceKeysKt.HideVideoSongsKey, bool2)).booleanValue();
                    artistItemsViewModel.title.setValue(artistItemsPage.title);
                    StateFlowImpl stateFlowImpl2 = artistItemsViewModel.itemsPage;
                    hashSet = new HashSet();
                    arrayList = new ArrayList();
                    while (r11.hasNext()) {
                        if (hashSet.add(((YTItem) obj3).getId())) {
                            arrayList.add(obj3);
                        }
                    }
                    ItemsPage itemsPage2 = new ItemsPage(HexFormatKt.filterVideoSongs(HexFormatKt.filterExplicit(arrayList, zBooleanValue3), zBooleanValue4), artistItemsPage.continuation);
                    stateFlowImpl2.getClass();
                    stateFlowImpl2.updateState(null, itemsPage2);
                    objM999artistItemsgIAlus = obj2;
                }
                return coroutineSingletons;
            }
            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM999artistItemsgIAlus);
            if (thM1866exceptionOrNullimpl != null) {
                thM1866exceptionOrNullimpl.printStackTrace();
            }
            return Unit.INSTANCE;
        }
    }

    public ArtistItemsViewModel(Context context, SavedStateHandle savedStateHandle) {
        savedStateHandle.getClass();
        this.context = context;
        Object obj = savedStateHandle.get("browseId");
        obj.getClass();
        this.browseId = (String) obj;
        this.params = (String) savedStateHandle.get("params");
        this.title = StateFlowKt.MutableStateFlow("");
        this.itemsPage = StateFlowKt.MutableStateFlow(null);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3);
    }
}
