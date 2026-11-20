package com.metrolist.music.viewmodels;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences$Key;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.SearchSuggestions;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.utils.YouTubeUrlParser;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.playback.DownloadUtil$getDownload$$inlined$map$1;
import com.metrolist.music.utils.UtilsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OnlineSearchSuggestionViewModel$1$invokeSuspend$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3 {
    public final /* synthetic */ MusicDatabase $database$inlined;
    public /* synthetic */ FlowCollector L$0;
    public /* synthetic */ Object L$1;
    public FlowCollector L$2;
    public String L$4;
    public byte label;
    public final /* synthetic */ OnlineSearchSuggestionViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineSearchSuggestionViewModel$1$invokeSuspend$$inlined$flatMapLatest$1(Continuation continuation, MusicDatabase musicDatabase, OnlineSearchSuggestionViewModel onlineSearchSuggestionViewModel) {
        super(3, continuation);
        this.$database$inlined = musicDatabase;
        this.this$0 = onlineSearchSuggestionViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        OnlineSearchSuggestionViewModel$1$invokeSuspend$$inlined$flatMapLatest$1 onlineSearchSuggestionViewModel$1$invokeSuspend$$inlined$flatMapLatest$1 = new OnlineSearchSuggestionViewModel$1$invokeSuspend$$inlined$flatMapLatest$1((Continuation) obj3, this.$database$inlined, this.this$0);
        onlineSearchSuggestionViewModel$1$invokeSuspend$$inlined$flatMapLatest$1.L$0 = (FlowCollector) obj;
        onlineSearchSuggestionViewModel$1$invokeSuspend$$inlined$flatMapLatest$1.L$1 = obj2;
        return onlineSearchSuggestionViewModel$1$invokeSuspend$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00a3  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e6, code lost:
    
        if (kotlinx.coroutines.flow.StateFlowKt.emitAll(r2, r0, r12) == r10) goto L32;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String str;
        Object obj2;
        String str2;
        Flow homeViewModel$special$$inlined$map$1;
        OnlineSearchSuggestionViewModel onlineSearchSuggestionViewModel = this.this$0;
        Context context = onlineSearchSuggestionViewModel.context;
        FlowCollector flowCollector = this.L$0;
        Object obj3 = this.L$1;
        byte b = this.label;
        MusicDatabase musicDatabase = this.$database$inlined;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (b != 0) {
            if (b == 1) {
                str2 = this.L$4;
                flowCollector = this.L$2;
                ResultKt.throwOnFailure(obj);
                homeViewModel$special$$inlined$map$1 = new DownloadUtil$getDownload$$inlined$map$1(new HomeViewModel$special$$inlined$map$1(musicDatabase.searchHistory(str2), (byte) 21), (YTItem) obj, (byte) 4);
            } else if (b == 2) {
                str = this.L$4;
                flowCollector = this.L$2;
                ResultKt.throwOnFailure(obj);
                obj2 = ((Result) obj).value;
                if (obj2 instanceof Result.Failure) {
                    obj2 = null;
                }
                DataStore dataStore = UtilsKt.getDataStore(context);
                Preferences$Key preferences$Key = PreferenceKeysKt.HideExplicitKey;
                Boolean bool = Boolean.FALSE;
                homeViewModel$special$$inlined$map$1 = new OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$5(new HomeViewModel$special$$inlined$map$1(musicDatabase.searchHistory(str), (byte) 22), (SearchSuggestions) obj2, ((Boolean) UtilsKt.get(dataStore, preferences$Key, bool)).booleanValue(), ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideVideoSongsKey, bool)).booleanValue());
            } else {
                if (b != 3) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        String str3 = (String) obj3;
        if (str3.length() == 0) {
            musicDatabase.getClass();
            homeViewModel$special$$inlined$map$1 = new HomeViewModel$special$$inlined$map$1(musicDatabase.$$delegate_0.searchHistory(""), (byte) 20);
        } else {
            Okio__OkioKt okio__OkioKt = YouTubeUrlParser.parse(str3);
            if (okio__OkioKt != null) {
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = flowCollector;
                this.L$4 = str3;
                this.label = (byte) 1;
                Object objFetchParsedUrlItem = onlineSearchSuggestionViewModel.fetchParsedUrlItem(okio__OkioKt, this);
                if (objFetchParsedUrlItem != coroutineSingletons) {
                    str2 = str3;
                    obj = objFetchParsedUrlItem;
                    homeViewModel$special$$inlined$map$1 = new DownloadUtil$getDownload$$inlined$map$1(new HomeViewModel$special$$inlined$map$1(musicDatabase.searchHistory(str2), (byte) 21), (YTItem) obj, (byte) 4);
                }
            } else {
                YouTube youTube = YouTube.INSTANCE;
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = flowCollector;
                this.L$4 = str3;
                this.label = (byte) 2;
                Object objM1041searchSuggestionsgIAlus = youTube.m1041searchSuggestionsgIAlus(str3, this);
                if (objM1041searchSuggestionsgIAlus != coroutineSingletons) {
                    str = str3;
                    obj2 = objM1041searchSuggestionsgIAlus;
                    if (obj2 instanceof Result.Failure) {
                        obj2 = null;
                    }
                    DataStore dataStore2 = UtilsKt.getDataStore(context);
                    Preferences$Key preferences$Key2 = PreferenceKeysKt.HideExplicitKey;
                    Boolean bool2 = Boolean.FALSE;
                    homeViewModel$special$$inlined$map$1 = new OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$5(new HomeViewModel$special$$inlined$map$1(musicDatabase.searchHistory(str), (byte) 22), (SearchSuggestions) obj2, ((Boolean) UtilsKt.get(dataStore2, preferences$Key2, bool2)).booleanValue(), ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideVideoSongsKey, bool2)).booleanValue());
                }
            }
        }
        return coroutineSingletons;
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$4 = null;
        this.label = (byte) 3;
    }
}
