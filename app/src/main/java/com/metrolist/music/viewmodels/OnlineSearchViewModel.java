package com.metrolist.music.viewmodels;

import android.content.Context;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.pages.SearchSummary;
import com.metrolist.innertube.pages.SearchSummaryPage;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.utils.UtilsKt;
import dev.chrisbanes.haze.HazeSourceNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/OnlineSearchViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class OnlineSearchViewModel extends ViewModel {
    public final Context context;
    public final StateFlowImpl filter;
    public final String query;
    public final ParcelableSnapshotMutableState summaryPage$delegate;
    public final SnapshotStateMap viewStateMap;

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.OnlineSearchViewModel$loadSummaryPage$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public SearchSummaryPage L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OnlineSearchViewModel.this.loadSummaryPage(this);
        }
    }

    public OnlineSearchViewModel(Context context, SavedStateHandle savedStateHandle) {
        savedStateHandle.getClass();
        this.context = context;
        String str = (String) savedStateHandle.get("query");
        this.query = StringsKt.removePrefix(str == null ? "" : str, "__metrolist_search_query__");
        this.filter = StateFlowKt.MutableStateFlow(null);
        this.summaryPage$delegate = Stack.mutableStateOf$default(null);
        this.viewStateMap = new SnapshotStateMap();
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HazeSourceNode.AnonymousClass1(this, null, (byte) 6), 3);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00c4 A[LOOP:0: B:32:0x00be->B:34:0x00c4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:37:0x0120  */
    /* JADX WARN: Code duplicated, block: B:39:0x012b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0141  */
    /* JADX WARN: Code duplicated, block: B:42:0x0143  */
    /* JADX WARN: Code duplicated, block: B:47:0x0156  */
    /* JADX WARN: Code duplicated, block: B:50:0x0167  */
    /* JADX WARN: Code duplicated, block: B:52:0x017b  */
    /* JADX WARN: Code duplicated, block: B:53:0x017d  */
    /* JADX WARN: Code duplicated, block: B:58:0x018f  */
    /* JADX WARN: Code duplicated, block: B:61:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:63:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:64:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:71:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:76:0x014a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x0129 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:81:0x0184 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x0161 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x01bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x019a A[SYNTHETIC] */
    public final Object loadSummaryPage(ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        Object objM1042searchSummary0E7RQCE;
        Object obj;
        SearchSummaryPage searchSummaryPage;
        Throwable thM1866exceptionOrNullimpl;
        List list;
        ArrayList arrayList;
        int i;
        int i2;
        SearchSummaryPage searchSummaryPage2;
        boolean zBooleanValue;
        boolean zBooleanValue2;
        boolean zBooleanValue3;
        ArrayList arrayList2;
        String str;
        List listFilterYoutubeShorts;
        SearchSummary searchSummary;
        ArrayList arrayList3;
        String str2;
        List listFilterVideoSongs;
        SearchSummary searchSummary2;
        ArrayList arrayList4;
        int size;
        String str3;
        List listFilterExplicit;
        SearchSummary searchSummary3;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i3 = anonymousClass1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i3 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj2 = anonymousClass1.result;
        int i4 = anonymousClass1.label;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.summaryPage$delegate;
        Continuation continuation = null;
        Context context = this.context;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj2);
            if (((SearchSummaryPage) parcelableSnapshotMutableState.getValue()) == null) {
                YouTube youTube = YouTube.INSTANCE;
                boolean z = !((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.PauseSearchHistoryKey, Boolean.FALSE)).booleanValue();
                anonymousClass1.label = 1;
                objM1042searchSummary0E7RQCE = youTube.m1042searchSummary0E7RQCE(this.query, z, anonymousClass1);
                if (objM1042searchSummary0E7RQCE != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            return Unit.INSTANCE;
        }
        if (i4 == 1) {
            ResultKt.throwOnFailure(obj2);
            objM1042searchSummary0E7RQCE = ((Result) obj2).value;
        } else {
            if (i4 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            searchSummaryPage = anonymousClass1.L$1;
            obj = anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj2);
        }
        list = (List) obj2;
        List<SearchSummary> list2 = searchSummaryPage.summaries;
        arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
        i = 0;
        i2 = 0;
        for (SearchSummary searchSummary4 : list2) {
            int size2 = searchSummary4.items.size() + i2;
            List listSubList = list.subList(i2, size2);
            String str4 = searchSummary4.title;
            str4.getClass();
            listSubList.getClass();
            arrayList.add(new SearchSummary(str4, listSubList));
            i2 = size2;
        }
        searchSummaryPage2 = new SearchSummaryPage(arrayList);
        DataStore dataStore = UtilsKt.getDataStore(context);
        Preferences$Key preferences$Key = PreferenceKeysKt.HideExplicitKey;
        Boolean bool = Boolean.FALSE;
        zBooleanValue = ((Boolean) UtilsKt.get(dataStore, preferences$Key, bool)).booleanValue();
        zBooleanValue2 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideVideoSongsKey, bool)).booleanValue();
        zBooleanValue3 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideYoutubeShortsKey, bool)).booleanValue();
        if (zBooleanValue) {
            arrayList4 = new ArrayList();
            size = arrayList.size();
            while (i < size) {
                Object obj3 = arrayList.get(i);
                i++;
                SearchSummary searchSummary5 = (SearchSummary) obj3;
                str3 = searchSummary5.title;
                listFilterExplicit = HexFormatKt.filterExplicit(searchSummary5.items, true);
                if (listFilterExplicit.isEmpty()) {
                    searchSummary3 = null;
                } else {
                    searchSummary3 = new SearchSummary(str3, listFilterExplicit);
                }
                if (searchSummary3 != null) {
                    arrayList4.add(searchSummary3);
                }
            }
            searchSummaryPage2 = new SearchSummaryPage(arrayList4);
        }
        if (zBooleanValue2) {
            arrayList3 = new ArrayList();
            for (SearchSummary searchSummary6 : searchSummaryPage2.summaries) {
                str2 = searchSummary6.title;
                listFilterVideoSongs = HexFormatKt.filterVideoSongs(searchSummary6.items, true);
                if (listFilterVideoSongs.isEmpty()) {
                    searchSummary2 = null;
                } else {
                    searchSummary2 = new SearchSummary(str2, listFilterVideoSongs);
                }
                if (searchSummary2 != null) {
                    arrayList3.add(searchSummary2);
                }
            }
            searchSummaryPage2 = new SearchSummaryPage(arrayList3);
        }
        if (zBooleanValue3) {
            arrayList2 = new ArrayList();
            for (SearchSummary searchSummary7 : searchSummaryPage2.summaries) {
                str = searchSummary7.title;
                listFilterYoutubeShorts = HexFormatKt.filterYoutubeShorts(searchSummary7.items, true);
                if (listFilterYoutubeShorts.isEmpty()) {
                    searchSummary = null;
                } else {
                    searchSummary = new SearchSummary(str, listFilterYoutubeShorts);
                }
                if (searchSummary != null) {
                    arrayList2.add(searchSummary);
                }
            }
            searchSummaryPage2 = new SearchSummaryPage(arrayList2);
        }
        parcelableSnapshotMutableState.setValue(searchSummaryPage2);
        objM1042searchSummary0E7RQCE = obj;
        thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1042searchSummary0E7RQCE);
        if (thM1866exceptionOrNullimpl != null) {
            thM1866exceptionOrNullimpl.printStackTrace();
        }
        return Unit.INSTANCE;
        if (!(objM1042searchSummary0E7RQCE instanceof Result.Failure)) {
            SearchSummaryPage searchSummaryPage3 = (SearchSummaryPage) objM1042searchSummary0E7RQCE;
            List list3 = searchSummaryPage3.summaries;
            ArrayList arrayList5 = new ArrayList();
            Iterator it = list3.iterator();
            while (it.hasNext()) {
                CollectionsKt__MutableCollectionsKt.addAll(((SearchSummary) it.next()).items, arrayList5);
            }
            anonymousClass1.L$0 = objM1042searchSummary0E7RQCE;
            anonymousClass1.L$1 = searchSummaryPage3;
            anonymousClass1.label = 2;
            Object objCoroutineScope = AwaitKt.coroutineScope(new NavHostKt$NavHost$29$1(arrayList5, continuation, (byte) 14), anonymousClass1);
            if (objCoroutineScope != coroutineSingletons) {
                obj = objM1042searchSummary0E7RQCE;
                searchSummaryPage = searchSummaryPage3;
                obj2 = objCoroutineScope;
                list = (List) obj2;
                List<SearchSummary> list4 = searchSummaryPage.summaries;
                arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
                i = 0;
                i2 = 0;
                while (r12.hasNext()) {
                    int size3 = searchSummary4.items.size() + i2;
                    List listSubList2 = list.subList(i2, size3);
                    String str5 = searchSummary4.title;
                    str5.getClass();
                    listSubList2.getClass();
                    arrayList.add(new SearchSummary(str5, listSubList2));
                    i2 = size3;
                }
                searchSummaryPage2 = new SearchSummaryPage(arrayList);
                DataStore dataStore2 = UtilsKt.getDataStore(context);
                Preferences$Key preferences$Key2 = PreferenceKeysKt.HideExplicitKey;
                Boolean bool2 = Boolean.FALSE;
                zBooleanValue = ((Boolean) UtilsKt.get(dataStore2, preferences$Key2, bool2)).booleanValue();
                zBooleanValue2 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideVideoSongsKey, bool2)).booleanValue();
                zBooleanValue3 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideYoutubeShortsKey, bool2)).booleanValue();
                if (zBooleanValue) {
                    arrayList4 = new ArrayList();
                    size = arrayList.size();
                    while (i < size) {
                        Object obj4 = arrayList.get(i);
                        i++;
                        SearchSummary searchSummary8 = (SearchSummary) obj4;
                        str3 = searchSummary8.title;
                        listFilterExplicit = HexFormatKt.filterExplicit(searchSummary8.items, true);
                        if (listFilterExplicit.isEmpty()) {
                            searchSummary3 = null;
                        } else {
                            searchSummary3 = new SearchSummary(str3, listFilterExplicit);
                        }
                        if (searchSummary3 != null) {
                            arrayList4.add(searchSummary3);
                        }
                    }
                    searchSummaryPage2 = new SearchSummaryPage(arrayList4);
                }
                if (zBooleanValue2) {
                    arrayList3 = new ArrayList();
                    while (r12.hasNext()) {
                        str2 = searchSummary6.title;
                        listFilterVideoSongs = HexFormatKt.filterVideoSongs(searchSummary6.items, true);
                        if (listFilterVideoSongs.isEmpty()) {
                            searchSummary2 = null;
                        } else {
                            searchSummary2 = new SearchSummary(str2, listFilterVideoSongs);
                        }
                        if (searchSummary2 != null) {
                            arrayList3.add(searchSummary2);
                        }
                    }
                    searchSummaryPage2 = new SearchSummaryPage(arrayList3);
                }
                if (zBooleanValue3) {
                    arrayList2 = new ArrayList();
                    while (r12.hasNext()) {
                        str = searchSummary7.title;
                        listFilterYoutubeShorts = HexFormatKt.filterYoutubeShorts(searchSummary7.items, true);
                        if (listFilterYoutubeShorts.isEmpty()) {
                            searchSummary = null;
                        } else {
                            searchSummary = new SearchSummary(str, listFilterYoutubeShorts);
                        }
                        if (searchSummary != null) {
                            arrayList2.add(searchSummary);
                        }
                    }
                    searchSummaryPage2 = new SearchSummaryPage(arrayList2);
                }
                parcelableSnapshotMutableState.setValue(searchSummaryPage2);
                objM1042searchSummary0E7RQCE = obj;
                thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1042searchSummary0E7RQCE);
                if (thM1866exceptionOrNullimpl != null) {
                    thM1866exceptionOrNullimpl.printStackTrace();
                }
            }
            return coroutineSingletons;
        }
        thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1042searchSummary0E7RQCE);
        if (thM1866exceptionOrNullimpl != null) {
            thM1866exceptionOrNullimpl.printStackTrace();
        }
        return Unit.INSTANCE;
    }
}
