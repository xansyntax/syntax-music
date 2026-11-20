package com.metrolist.music.viewmodels;

import com.metrolist.innertube.models.SearchSuggestions;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.db.entities.SearchHistory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$5 implements Flow {
    public final /* synthetic */ boolean $hideExplicit$inlined;
    public final /* synthetic */ boolean $hideVideoSongs$inlined;
    public final /* synthetic */ SearchSuggestions $result$inlined;
    public final /* synthetic */ HomeViewModel$special$$inlined$map$1 $this_unsafeTransform$inlined;

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$5$1, reason: invalid class name */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$5.this.collect(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$5$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 implements FlowCollector {
        public final /* synthetic */ boolean $hideExplicit$inlined;
        public final /* synthetic */ boolean $hideVideoSongs$inlined;
        public final /* synthetic */ SearchSuggestions $result$inlined;
        public final /* synthetic */ FlowCollector $this_unsafeFlow;

        /* JADX INFO: renamed from: com.metrolist.music.viewmodels.OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$5$2$1, reason: invalid class name */
        public final class AnonymousClass1 extends ContinuationImpl {
            public int label;
            public /* synthetic */ Object result;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass2.this.emit(null, this);
            }
        }

        public AnonymousClass2(FlowCollector flowCollector, SearchSuggestions searchSuggestions, boolean z, boolean z2) {
            this.$this_unsafeFlow = flowCollector;
            this.$result$inlined = searchSuggestions;
            this.$hideExplicit$inlined = z;
            this.$hideVideoSongs$inlined = z2;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1;
            ArrayList arrayList;
            if (continuation instanceof AnonymousClass1) {
                anonymousClass1 = (AnonymousClass1) continuation;
                int i = anonymousClass1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    anonymousClass1.label = i - Integer.MIN_VALUE;
                } else {
                    anonymousClass1 = new AnonymousClass1(continuation);
                }
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
            Object obj2 = anonymousClass1.result;
            int i2 = anonymousClass1.label;
            List listFilterVideoSongs = null;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj2);
                List list = (List) obj;
                SearchSuggestions searchSuggestions = this.$result$inlined;
                if (searchSuggestions != null) {
                    List list2 = searchSuggestions.queries;
                    arrayList = new ArrayList();
                    for (Object obj3 : list2) {
                        String str = (String) obj3;
                        if (list == null || !list.isEmpty()) {
                            Iterator it = list.iterator();
                            do {
                                if (it.hasNext()) {
                                }
                            } while (!Intrinsics.areEqual(((SearchHistory) it.next()).query, str));
                        }
                        arrayList.add(obj3);
                    }
                } else {
                    arrayList = null;
                }
                List list3 = EmptyList.INSTANCE;
                List list4 = arrayList;
                if (arrayList == null) {
                    list4 = list3;
                }
                if (searchSuggestions != null) {
                    List list5 = searchSuggestions.recommendedItems;
                    HashSet hashSet = new HashSet();
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj4 : list5) {
                        if (hashSet.add(((YTItem) obj4).getId())) {
                            arrayList2.add(obj4);
                        }
                    }
                    listFilterVideoSongs = HexFormatKt.filterVideoSongs(HexFormatKt.filterExplicit(arrayList2, this.$hideExplicit$inlined), this.$hideVideoSongs$inlined);
                }
                if (listFilterVideoSongs != null) {
                    list3 = listFilterVideoSongs;
                }
                SearchSuggestionViewState searchSuggestionViewState = new SearchSuggestionViewState(list, list4, list3, 24);
                anonymousClass1.label = 1;
                Object objEmit = this.$this_unsafeFlow.emit(searchSuggestionViewState, anonymousClass1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objEmit == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj2);
            }
            return Unit.INSTANCE;
        }
    }

    public OnlineSearchSuggestionViewModel$1$invokeSuspend$lambda$0$$inlined$map$5(HomeViewModel$special$$inlined$map$1 homeViewModel$special$$inlined$map$1, SearchSuggestions searchSuggestions, boolean z, boolean z2) {
        this.$this_unsafeTransform$inlined = homeViewModel$special$$inlined$map$1;
        this.$result$inlined = searchSuggestions;
        this.$hideExplicit$inlined = z;
        this.$hideVideoSongs$inlined = z2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector flowCollector, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(flowCollector, this.$result$inlined, this.$hideExplicit$inlined, this.$hideVideoSongs$inlined);
            anonymousClass1.label = 1;
            Object objCollect = this.$this_unsafeTransform$inlined.collect(anonymousClass2, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objCollect == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
