package com.metrolist.music.viewmodels;

import android.content.Context;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.lifecycle.ViewModelKt;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.SearchResult;
import com.metrolist.innertube.pages.SearchSummary;
import com.metrolist.innertube.pages.SearchSummaryPage;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.models.ItemsPage;
import com.metrolist.music.utils.UtilsKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OnlineSearchViewModel$1$1 implements FlowCollector {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ OnlineSearchViewModel this$0;

    public /* synthetic */ OnlineSearchViewModel$1$1(OnlineSearchViewModel onlineSearchViewModel, byte b) {
        this.$r8$classId = b;
        this.this$0 = onlineSearchViewModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        Object[] objArr = 0;
        switch (this.$r8$classId) {
            case 0:
                YouTube.SearchFilter searchFilter = (YouTube.SearchFilter) obj;
                return m1530emitq2z6kX0(searchFilter != null ? searchFilter.value : null, continuation);
            default:
                if (((Boolean) obj).booleanValue()) {
                    OnlineSearchViewModel onlineSearchViewModel = this.this$0;
                    YouTube.SearchFilter searchFilter2 = (YouTube.SearchFilter) onlineSearchViewModel.filter.getValue();
                    String str = searchFilter2 != null ? searchFilter2.value : null;
                    if (str != null) {
                        AwaitKt.launch$default(ViewModelKt.getViewModelScope(onlineSearchViewModel), null, null, new NavHostKt$NavHost$29$1(onlineSearchViewModel, str, objArr == true ? 1 : 0, (byte) 13), 3);
                    }
                }
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:61:0x0110  */
    /* JADX WARN: Code duplicated, block: B:65:0x0160  */
    /* JADX WARN: Code duplicated, block: B:69:0x018b A[PHI: r14
      0x018b: PHI (r14v10 java.lang.Object) = (r14v9 java.lang.Object), (r14v11 java.lang.Object) binds: [B:57:0x00f1, B:68:0x0175] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:71:0x0191  */
    /* JADX WARN: Code duplicated, block: B:74:0x0171 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x015a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
    
        if (r0.loadSummaryPage(r2) == r9) goto L60;
     */
    /* JADX INFO: renamed from: emit-q2z6kX0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m1530emitq2z6kX0(String str, Continuation continuation) {
        OnlineSearchViewModel$1$1$emitq2z6kX0$1 onlineSearchViewModel$1$1$emitq2z6kX0$1;
        Object objM1039searchMVsJJCw;
        Object next;
        Object obj;
        SearchResult searchResult;
        Object objCoroutineScope;
        SearchResult searchResult2;
        String str2;
        Throwable thM1866exceptionOrNullimpl;
        HashSet hashSet;
        ArrayList arrayList;
        OnlineSearchViewModel onlineSearchViewModel = this.this$0;
        SnapshotStateMap snapshotStateMap = onlineSearchViewModel.viewStateMap;
        if (continuation instanceof OnlineSearchViewModel$1$1$emitq2z6kX0$1) {
            onlineSearchViewModel$1$1$emitq2z6kX0$1 = (OnlineSearchViewModel$1$1$emitq2z6kX0$1) continuation;
            int i = onlineSearchViewModel$1$1$emitq2z6kX0$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                onlineSearchViewModel$1$1$emitq2z6kX0$1.label = i - Integer.MIN_VALUE;
            } else {
                onlineSearchViewModel$1$1$emitq2z6kX0$1 = new OnlineSearchViewModel$1$1$emitq2z6kX0$1(this, continuation);
            }
        } else {
            onlineSearchViewModel$1$1$emitq2z6kX0$1 = new OnlineSearchViewModel$1$1$emitq2z6kX0$1(this, continuation);
        }
        Object obj2 = onlineSearchViewModel$1$1$emitq2z6kX0$1.result;
        int i2 = onlineSearchViewModel$1$1$emitq2z6kX0$1.label;
        Unit unit = Unit.INSTANCE;
        Continuation continuation2 = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            if (str == null) {
                onlineSearchViewModel$1$1$emitq2z6kX0$1.L$0 = null;
                onlineSearchViewModel$1$1$emitq2z6kX0$1.label = 1;
                if (onlineSearchViewModel.loadSummaryPage(onlineSearchViewModel$1$1$emitq2z6kX0$1) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else if (str.equals("EgWKAQJYAWoKEAkQChAFEAMQBA%3D%3D")) {
                if (snapshotStateMap.get(str) == null) {
                    onlineSearchViewModel$1$1$emitq2z6kX0$1.L$0 = str;
                    onlineSearchViewModel$1$1$emitq2z6kX0$1.label = 2;
                }
            } else if (snapshotStateMap.get(str) == null) {
                YouTube youTube = YouTube.INSTANCE;
                String str3 = onlineSearchViewModel.query;
                boolean z = !((Boolean) UtilsKt.get(UtilsKt.getDataStore(onlineSearchViewModel.context), PreferenceKeysKt.PauseSearchHistoryKey, Boolean.FALSE)).booleanValue();
                onlineSearchViewModel$1$1$emitq2z6kX0$1.L$0 = str;
                onlineSearchViewModel$1$1$emitq2z6kX0$1.label = 3;
                objM1039searchMVsJJCw = youTube.m1039searchMVsJJCw(str3, str, z, onlineSearchViewModel$1$1$emitq2z6kX0$1);
                if (objM1039searchMVsJJCw != coroutineSingletons) {
                    obj = objM1039searchMVsJJCw;
                    if (obj instanceof Result.Failure) {
                        thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj);
                        if (thM1866exceptionOrNullimpl != null) {
                            thM1866exceptionOrNullimpl.printStackTrace();
                        }
                    } else {
                        searchResult = (SearchResult) obj;
                        List list = searchResult.items;
                        onlineSearchViewModel$1$1$emitq2z6kX0$1.L$0 = str;
                        onlineSearchViewModel$1$1$emitq2z6kX0$1.L$1 = obj;
                        onlineSearchViewModel$1$1$emitq2z6kX0$1.L$2 = onlineSearchViewModel;
                        onlineSearchViewModel$1$1$emitq2z6kX0$1.L$3 = searchResult;
                        onlineSearchViewModel$1$1$emitq2z6kX0$1.label = 4;
                        objCoroutineScope = AwaitKt.coroutineScope(new NavHostKt$NavHost$29$1(list, continuation2, (byte) 14), onlineSearchViewModel$1$1$emitq2z6kX0$1);
                        if (objCoroutineScope != coroutineSingletons) {
                            String str4 = str;
                            searchResult2 = searchResult;
                            obj2 = objCoroutineScope;
                            str2 = str4;
                            Context context = onlineSearchViewModel.context;
                            DataStore dataStore = UtilsKt.getDataStore(context);
                            Preferences$Key preferences$Key = PreferenceKeysKt.HideExplicitKey;
                            Boolean bool = Boolean.FALSE;
                            boolean zBooleanValue = ((Boolean) UtilsKt.get(dataStore, preferences$Key, bool)).booleanValue();
                            boolean zBooleanValue2 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideVideoSongsKey, bool)).booleanValue();
                            boolean zBooleanValue3 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideYoutubeShortsKey, bool)).booleanValue();
                            SnapshotStateMap snapshotStateMap2 = onlineSearchViewModel.viewStateMap;
                            hashSet = new HashSet();
                            arrayList = new ArrayList();
                            for (Object obj3 : (List) obj2) {
                                if (hashSet.add(((YTItem) obj3).getId())) {
                                    arrayList.add(obj3);
                                }
                            }
                            snapshotStateMap2.put(str2, new ItemsPage(HexFormatKt.filterYoutubeShorts(HexFormatKt.filterVideoSongs(HexFormatKt.filterExplicit(arrayList, zBooleanValue), zBooleanValue2), zBooleanValue3), searchResult2.continuation));
                            thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj);
                            if (thM1866exceptionOrNullimpl != null) {
                                thM1866exceptionOrNullimpl.printStackTrace();
                            }
                        }
                    }
                }
                return coroutineSingletons;
            }
        } else {
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj2);
                return unit;
            }
            if (i2 != 2) {
                if (i2 == 3) {
                    str = onlineSearchViewModel$1$1$emitq2z6kX0$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    objM1039searchMVsJJCw = ((Result) obj2).value;
                    obj = objM1039searchMVsJJCw;
                    if (obj instanceof Result.Failure) {
                        searchResult = (SearchResult) obj;
                        List list2 = searchResult.items;
                        onlineSearchViewModel$1$1$emitq2z6kX0$1.L$0 = str;
                        onlineSearchViewModel$1$1$emitq2z6kX0$1.L$1 = obj;
                        onlineSearchViewModel$1$1$emitq2z6kX0$1.L$2 = onlineSearchViewModel;
                        onlineSearchViewModel$1$1$emitq2z6kX0$1.L$3 = searchResult;
                        onlineSearchViewModel$1$1$emitq2z6kX0$1.label = 4;
                        objCoroutineScope = AwaitKt.coroutineScope(new NavHostKt$NavHost$29$1(list2, continuation2, (byte) 14), onlineSearchViewModel$1$1$emitq2z6kX0$1);
                        if (objCoroutineScope != coroutineSingletons) {
                            String str5 = str;
                            searchResult2 = searchResult;
                            obj2 = objCoroutineScope;
                            str2 = str5;
                        }
                        return coroutineSingletons;
                    }
                    thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj);
                    if (thM1866exceptionOrNullimpl != null) {
                        thM1866exceptionOrNullimpl.printStackTrace();
                    }
                } else {
                    if (i2 != 4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    searchResult2 = onlineSearchViewModel$1$1$emitq2z6kX0$1.L$3;
                    onlineSearchViewModel = onlineSearchViewModel$1$1$emitq2z6kX0$1.L$2;
                    obj = onlineSearchViewModel$1$1$emitq2z6kX0$1.L$1;
                    str2 = onlineSearchViewModel$1$1$emitq2z6kX0$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                }
                Context context2 = onlineSearchViewModel.context;
                DataStore dataStore2 = UtilsKt.getDataStore(context2);
                Preferences$Key preferences$Key2 = PreferenceKeysKt.HideExplicitKey;
                Boolean bool2 = Boolean.FALSE;
                boolean zBooleanValue4 = ((Boolean) UtilsKt.get(dataStore2, preferences$Key2, bool2)).booleanValue();
                boolean zBooleanValue5 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context2), PreferenceKeysKt.HideVideoSongsKey, bool2)).booleanValue();
                boolean zBooleanValue6 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context2), PreferenceKeysKt.HideYoutubeShortsKey, bool2)).booleanValue();
                SnapshotStateMap snapshotStateMap3 = onlineSearchViewModel.viewStateMap;
                hashSet = new HashSet();
                arrayList = new ArrayList();
                while (r12.hasNext()) {
                    if (hashSet.add(((YTItem) obj3).getId())) {
                        arrayList.add(obj3);
                    }
                }
                snapshotStateMap3.put(str2, new ItemsPage(HexFormatKt.filterYoutubeShorts(HexFormatKt.filterVideoSongs(HexFormatKt.filterExplicit(arrayList, zBooleanValue4), zBooleanValue5), zBooleanValue6), searchResult2.continuation));
                thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj);
                if (thM1866exceptionOrNullimpl != null) {
                    thM1866exceptionOrNullimpl.printStackTrace();
                }
            } else {
                str = onlineSearchViewModel$1$1$emitq2z6kX0$1.L$0;
                ResultKt.throwOnFailure(obj2);
                SearchSummaryPage searchSummaryPage = (SearchSummaryPage) onlineSearchViewModel.summaryPage$delegate.getValue();
                if (searchSummaryPage != null) {
                    Iterator it = searchSummaryPage.summaries.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!Intrinsics.areEqual(((SearchSummary) next).title, "Episodes"));
                    SearchSummary searchSummary = (SearchSummary) next;
                    List list3 = searchSummary != null ? searchSummary.items : null;
                    if (list3 == null) {
                        list3 = EmptyList.INSTANCE;
                    }
                    snapshotStateMap.put(str, new ItemsPage(list3, null));
                    return unit;
                }
            }
        }
        return unit;
    }
}
