package com.metrolist.music.viewmodels;

import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.pages.HomePage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HomeViewModel$loadMoreYouTubeItems$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $continuation;
    public final /* synthetic */ boolean $hideExplicit;
    public final /* synthetic */ boolean $hideVideoSongs;
    public final /* synthetic */ boolean $hideYoutubeShorts;
    public /* synthetic */ Object L$0;
    public boolean label;
    public final /* synthetic */ HomeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeViewModel$loadMoreYouTubeItems$1(HomeViewModel homeViewModel, String str, boolean z, boolean z2, boolean z3, Continuation continuation) {
        super(2, continuation);
        this.this$0 = homeViewModel;
        this.$continuation = str;
        this.$hideExplicit = z;
        this.$hideVideoSongs = z2;
        this.$hideYoutubeShorts = z3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        HomeViewModel$loadMoreYouTubeItems$1 homeViewModel$loadMoreYouTubeItems$1 = new HomeViewModel$loadMoreYouTubeItems$1(this.this$0, this.$continuation, this.$hideExplicit, this.$hideVideoSongs, this.$hideYoutubeShorts, continuation);
        homeViewModel$loadMoreYouTubeItems$1.L$0 = obj;
        return homeViewModel$loadMoreYouTubeItems$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((HomeViewModel$loadMoreYouTubeItems$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM987home0E7RQCE$default;
        HomeViewModel homeViewModel = this.this$0;
        StateFlowImpl stateFlowImpl = homeViewModel.homePage;
        StateFlowImpl stateFlowImpl2 = homeViewModel._isLoadingMore;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        boolean z = this.label;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            Boolean bool = Boolean.TRUE;
            stateFlowImpl2.getClass();
            stateFlowImpl2.updateState(null, bool);
            YouTube youTube = YouTube.INSTANCE;
            this.L$0 = coroutineScope;
            this.label = true;
            objM987home0E7RQCE$default = YouTube.m987home0E7RQCE$default(this.$continuation, null, this, 2);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objM987home0E7RQCE$default == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (!z) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            objM987home0E7RQCE$default = ((Result) obj).value;
        }
        if (objM987home0E7RQCE$default instanceof Result.Failure) {
            objM987home0E7RQCE$default = null;
        }
        HomePage homePage = (HomePage) objM987home0E7RQCE$default;
        Unit unit = Unit.INSTANCE;
        if (homePage == null) {
            Boolean bool2 = Boolean.FALSE;
            stateFlowImpl2.getClass();
            stateFlowImpl2.updateState(null, bool2);
            return unit;
        }
        HomePage homePage2 = (HomePage) stateFlowImpl.getValue();
        List list = homePage2 != null ? homePage2.chips : null;
        HomePage homePage3 = (HomePage) stateFlowImpl.getValue();
        List list2 = homePage3 != null ? homePage3.sections : null;
        if (list2 == null) {
            list2 = EmptyList.INSTANCE;
        }
        ArrayList arrayListPlus = CollectionsKt.plus((Iterable) homePage.sections, (Collection) list2);
        ArrayList arrayList = new ArrayList();
        int size = arrayListPlus.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayListPlus.get(i);
            i++;
            HomePage.Section section = (HomePage.Section) obj2;
            List listFilterYoutubeShorts = HexFormatKt.filterYoutubeShorts(HexFormatKt.filterVideoSongs(HexFormatKt.filterExplicit(CollectionsKt.filterNotNull(section.items), this.$hideExplicit), this.$hideVideoSongs), this.$hideYoutubeShorts);
            HomePage.Section sectionCopy$default = listFilterYoutubeShorts.isEmpty() ? null : HomePage.Section.copy$default(section, listFilterYoutubeShorts);
            if (sectionCopy$default != null) {
                arrayList.add(sectionCopy$default);
            }
        }
        HomePage homePageCopy$default = HomePage.copy$default(homePage, list, arrayList, 4);
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, homePageCopy$default);
        Boolean bool3 = Boolean.FALSE;
        stateFlowImpl2.getClass();
        stateFlowImpl2.updateState(null, bool3);
        return unit;
    }
}
