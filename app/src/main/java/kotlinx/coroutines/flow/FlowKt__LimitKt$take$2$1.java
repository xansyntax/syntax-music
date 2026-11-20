package kotlinx.coroutines.flow;

import android.content.Context;
import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.TransitionInstance;
import androidx.compose.foundation.gestures.AnchoredDragFinishedSignal;
import androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$emit$1;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.FloatingActionButtonElevationAnimatable;
import androidx.compose.material3.SliderState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ProduceStateScopeImpl;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import coil3.RealImageLoader;
import com.metrolist.innertube.pages.HomePage;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.ui.screens.HomeScreenKt;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$lambda$0$$inlined$map$1$2$1;
import com.metrolist.music.utils.UtilsKt;
import com.metrolist.music.viewmodels.HomeViewModel;
import com.metrolist.music.viewmodels.HomeViewModel$loadMoreYouTubeItems$1;
import com.metrolist.music.viewmodels.LocalFilter;
import com.metrolist.music.viewmodels.LocalSearchResult;
import com.metrolist.music.viewmodels.LocalSearchViewModel$result$lambda$1$$inlined$map$2$2$1;
import com.valentinilk.shimmer.ShimmerModifierKt$shimmer$1$1;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.internal.CombineKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FlowKt__LimitKt$take$2$1 implements FlowCollector {
    public final Object $consumed;
    public final Object $ownershipMarker;
    public final /* synthetic */ byte $r8$classId;
    public final Object $this_flow;

    public FlowKt__LimitKt$take$2$1(FlowCollector flowCollector, CoroutineContext coroutineContext) {
        this.$r8$classId = (byte) 10;
        this.$consumed = coroutineContext;
        this.$ownershipMarker = InlineList.threadContextElements(coroutineContext);
        this.$this_flow = new ShimmerModifierKt$shimmer$1$1(flowCollector, null, (byte) 9);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003e  */
    /* JADX WARN: Code duplicated, block: B:161:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:185:0x0364  */
    /* JADX WARN: Code duplicated, block: B:207:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x0086  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:60:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:99:0x0189  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) throws Throwable {
        FlowKt__LimitKt$take$2$1$emit$1 flowKt__LimitKt$take$2$1$emit$1;
        AnchoredDraggableKt$restartable$2$1$emit$1 anchoredDraggableKt$restartable$2$1$emit$1;
        DataStoreKt$rememberPreference$lambda$0$$inlined$map$1$2$1 dataStoreKt$rememberPreference$lambda$0$$inlined$map$1$2$1;
        LocalSearchViewModel$result$lambda$1$$inlined$map$2$2$1 localSearchViewModel$result$lambda$1$$inlined$map$2$2$1;
        LocalFilter localFilter;
        DistinctFlowImpl$collect$2$emit$1 distinctFlowImpl$collect$2$emit$1;
        FlowKt__LimitKt$dropWhile$1$1$emit$1 flowKt__LimitKt$dropWhile$1$1$emit$1;
        Object obj2 = obj;
        byte b = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Continuation continuation2 = null;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.$this_flow;
        Object obj4 = this.$ownershipMarker;
        Object obj5 = this.$consumed;
        switch (b) {
            case 0:
                if (continuation instanceof FlowKt__LimitKt$take$2$1$emit$1) {
                    flowKt__LimitKt$take$2$1$emit$1 = (FlowKt__LimitKt$take$2$1$emit$1) continuation;
                    int i = flowKt__LimitKt$take$2$1$emit$1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        flowKt__LimitKt$take$2$1$emit$1.label = i - Integer.MIN_VALUE;
                    } else {
                        flowKt__LimitKt$take$2$1$emit$1 = new FlowKt__LimitKt$take$2$1$emit$1(this, continuation);
                    }
                } else {
                    flowKt__LimitKt$take$2$1$emit$1 = new FlowKt__LimitKt$take$2$1$emit$1(this, continuation);
                }
                Object obj6 = flowKt__LimitKt$take$2$1$emit$1.result;
                int i2 = flowKt__LimitKt$take$2$1$emit$1.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj6);
                    Ref$IntRef ref$IntRef = (Ref$IntRef) obj5;
                    int i3 = ref$IntRef.element + 1;
                    ref$IntRef.element = i3;
                    FlowCollector flowCollector = (FlowCollector) obj3;
                    if (i3 >= 2) {
                        flowKt__LimitKt$take$2$1$emit$1.label = 2;
                        StateFlowKt.emitAbort$FlowKt__LimitKt(flowCollector, obj2, obj4, flowKt__LimitKt$take$2$1$emit$1);
                        return coroutineSingletons;
                    }
                    flowKt__LimitKt$take$2$1$emit$1.label = 1;
                    if (flowCollector.emit(obj2, flowKt__LimitKt$take$2$1$emit$1) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i2 != 1 && i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj6);
                }
                return unit;
            case 1:
                TransitionInstance transitionInstance = (TransitionInstance) obj3;
                ((ProduceStateScopeImpl) obj5).setValue(Boolean.valueOf(((Boolean) obj2).booleanValue() ? ((Boolean) ((Function2) ((MutableState) obj4).getValue()).invoke(transitionInstance.transitionState.getCurrentState(), transitionInstance.targetState$delegate.getValue())).booleanValue() : false));
                return unit;
            case 2:
                Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) obj5;
                if (continuation instanceof AnchoredDraggableKt$restartable$2$1$emit$1) {
                    anchoredDraggableKt$restartable$2$1$emit$1 = (AnchoredDraggableKt$restartable$2$1$emit$1) continuation;
                    int i4 = anchoredDraggableKt$restartable$2$1$emit$1.label;
                    if ((i4 & Integer.MIN_VALUE) != 0) {
                        anchoredDraggableKt$restartable$2$1$emit$1.label = i4 - Integer.MIN_VALUE;
                    } else {
                        anchoredDraggableKt$restartable$2$1$emit$1 = new AnchoredDraggableKt$restartable$2$1$emit$1(this, continuation);
                    }
                } else {
                    anchoredDraggableKt$restartable$2$1$emit$1 = new AnchoredDraggableKt$restartable$2$1$emit$1(this, continuation);
                }
                Object obj7 = anchoredDraggableKt$restartable$2$1$emit$1.result;
                int i5 = anchoredDraggableKt$restartable$2$1$emit$1.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj7);
                    Job job = (Job) ref$ObjectRef.element;
                    if (job != null) {
                        job.cancel(new AnchoredDragFinishedSignal());
                        anchoredDraggableKt$restartable$2$1$emit$1.L$0 = obj2;
                        anchoredDraggableKt$restartable$2$1$emit$1.label = 1;
                        if (job.join(anchoredDraggableKt$restartable$2$1$emit$1) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                } else {
                    if (i5 != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    obj2 = anchoredDraggableKt$restartable$2$1$emit$1.L$0;
                    ResultKt.throwOnFailure(obj7);
                }
                CoroutineScope coroutineScope = (CoroutineScope) obj3;
                ref$ObjectRef.element = AwaitKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new RealImageLoader.AnonymousClass2((Function2) obj4, obj2, coroutineScope, null, (byte) 6), 1);
                return unit;
            case 3:
                Interaction interaction = (Interaction) obj2;
                ArrayList arrayList = (ArrayList) obj5;
                if (interaction instanceof HoverInteraction$Enter) {
                    arrayList.add(interaction);
                } else if (interaction instanceof HoverInteraction$Exit) {
                    arrayList.remove(((HoverInteraction$Exit) interaction).enter);
                } else if (interaction instanceof FocusInteraction.Focus) {
                    arrayList.add(interaction);
                } else if (interaction instanceof FocusInteraction.Unfocus) {
                    arrayList.remove(((FocusInteraction.Unfocus) interaction).focus);
                } else if (interaction instanceof PressInteraction.Press) {
                    arrayList.add(interaction);
                } else if (interaction instanceof PressInteraction.Release) {
                    arrayList.remove(((PressInteraction.Release) interaction).press);
                } else if (interaction instanceof PressInteraction.Cancel) {
                    arrayList.remove(((PressInteraction.Cancel) interaction).press);
                }
                AwaitKt.launch$default((CoroutineScope) obj3, null, null, new SliderState.AnonymousClass2((FloatingActionButtonElevationAnimatable) obj4, (Interaction) CollectionsKt.lastOrNull(arrayList), continuation2, (byte) 16), 3);
                return unit;
            case 4:
                BackEventCompat backEventCompat = (BackEventCompat) obj2;
                if (((List) ((MutableState) obj5).getValue()).size() > 1) {
                    ((MutableState) obj3).setValue(Boolean.TRUE);
                    ((ParcelableSnapshotMutableFloatState) obj4).setFloatValue(backEventCompat.progress);
                }
                return unit;
            case 5:
                Integer num = (Integer) obj2;
                int i6 = ((LazyListState) obj5).getLayoutInfo().totalItemsCount;
                if (num != null && num.intValue() >= i6 - 3) {
                    HomeViewModel homeViewModel = (HomeViewModel) obj3;
                    List list = HomeScreenKt.DailyDiscoverMessages;
                    HomePage homePage = (HomePage) ((MutableState) obj4).getValue();
                    String str = homePage != null ? homePage.continuation : null;
                    Context context = homeViewModel.context;
                    if (str != null && !((Boolean) homeViewModel._isLoadingMore.getValue()).booleanValue()) {
                        DataStore dataStore = UtilsKt.getDataStore(context);
                        Preferences$Key preferences$Key = PreferenceKeysKt.HideExplicitKey;
                        Boolean bool = Boolean.FALSE;
                        boolean zBooleanValue = ((Boolean) UtilsKt.get(dataStore, preferences$Key, bool)).booleanValue();
                        boolean zBooleanValue2 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideVideoSongsKey, bool)).booleanValue();
                        boolean zBooleanValue3 = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(context), PreferenceKeysKt.HideYoutubeShortsKey, bool)).booleanValue();
                        CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(homeViewModel);
                        DefaultScheduler defaultScheduler = Dispatchers.Default;
                        AwaitKt.launch$default(viewModelScope, DefaultIoScheduler.INSTANCE, null, new HomeViewModel$loadMoreYouTubeItems$1(homeViewModel, str, zBooleanValue, zBooleanValue2, zBooleanValue3, null), 2);
                    }
                }
                return unit;
            case 6:
                if (continuation instanceof DataStoreKt$rememberPreference$lambda$0$$inlined$map$1$2$1) {
                    dataStoreKt$rememberPreference$lambda$0$$inlined$map$1$2$1 = (DataStoreKt$rememberPreference$lambda$0$$inlined$map$1$2$1) continuation;
                    int i7 = dataStoreKt$rememberPreference$lambda$0$$inlined$map$1$2$1.label;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        dataStoreKt$rememberPreference$lambda$0$$inlined$map$1$2$1.label = i7 - Integer.MIN_VALUE;
                    } else {
                        dataStoreKt$rememberPreference$lambda$0$$inlined$map$1$2$1 = new DataStoreKt$rememberPreference$lambda$0$$inlined$map$1$2$1(this, continuation);
                    }
                } else {
                    dataStoreKt$rememberPreference$lambda$0$$inlined$map$1$2$1 = new DataStoreKt$rememberPreference$lambda$0$$inlined$map$1$2$1(this, continuation);
                }
                Object obj8 = dataStoreKt$rememberPreference$lambda$0$$inlined$map$1$2$1.result;
                int i8 = dataStoreKt$rememberPreference$lambda$0$$inlined$map$1$2$1.label;
                if (i8 == 0) {
                    ResultKt.throwOnFailure(obj8);
                    FlowCollector flowCollector2 = (FlowCollector) obj3;
                    Object obj9 = ((MutablePreferences) obj2).get((Preferences$Key) obj5);
                    if (obj9 != null) {
                        obj4 = obj9;
                    }
                    dataStoreKt$rememberPreference$lambda$0$$inlined$map$1$2$1.label = 1;
                    if (flowCollector2.emit(obj4, dataStoreKt$rememberPreference$lambda$0$$inlined$map$1$2$1) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i8 != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj8);
                }
                return unit;
            case 7:
                if (continuation instanceof LocalSearchViewModel$result$lambda$1$$inlined$map$2$2$1) {
                    localSearchViewModel$result$lambda$1$$inlined$map$2$2$1 = (LocalSearchViewModel$result$lambda$1$$inlined$map$2$2$1) continuation;
                    int i9 = localSearchViewModel$result$lambda$1$$inlined$map$2$2$1.label;
                    if ((i9 & Integer.MIN_VALUE) != 0) {
                        localSearchViewModel$result$lambda$1$$inlined$map$2$2$1.label = i9 - Integer.MIN_VALUE;
                    } else {
                        localSearchViewModel$result$lambda$1$$inlined$map$2$2$1 = new LocalSearchViewModel$result$lambda$1$$inlined$map$2$2$1(this, continuation);
                    }
                } else {
                    localSearchViewModel$result$lambda$1$$inlined$map$2$2$1 = new LocalSearchViewModel$result$lambda$1$$inlined$map$2$2$1(this, continuation);
                }
                Object obj10 = localSearchViewModel$result$lambda$1$$inlined$map$2$2$1.result;
                int i10 = localSearchViewModel$result$lambda$1$$inlined$map$2$2$1.label;
                if (i10 != 0) {
                    if (i10 == 1) {
                        ResultKt.throwOnFailure(obj10);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj10);
                FlowCollector flowCollector3 = (FlowCollector) obj3;
                List list2 = (List) obj2;
                String str2 = (String) obj5;
                LocalFilter localFilter2 = (LocalFilter) obj4;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        LocalSearchResult localSearchResult = new LocalSearchResult(str2, localFilter2, linkedHashMap);
                        localSearchViewModel$result$lambda$1$$inlined$map$2$2$1.label = 1;
                        if (flowCollector3.emit(localSearchResult, localSearchViewModel$result$lambda$1$$inlined$map$2$2$1) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        return unit;
                    }
                    Object next = it.next();
                    LocalItem localItem = (LocalItem) next;
                    if (localItem != null) {
                        if (localItem instanceof Song) {
                            localFilter = LocalFilter.SONG;
                        } else if (localItem instanceof Album) {
                            localFilter = LocalFilter.ALBUM;
                        } else if (localItem instanceof Artist) {
                            localFilter = LocalFilter.ARTIST;
                        } else if (localItem instanceof Playlist) {
                            localFilter = LocalFilter.PLAYLIST;
                        }
                        Object arrayList2 = linkedHashMap.get(localFilter);
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                            linkedHashMap.put(localFilter, arrayList2);
                        }
                        ((List) arrayList2).add(next);
                    }
                }
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
            case 8:
                Ref$ObjectRef ref$ObjectRef2 = (Ref$ObjectRef) obj4;
                DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) obj5;
                if (continuation instanceof DistinctFlowImpl$collect$2$emit$1) {
                    distinctFlowImpl$collect$2$emit$1 = (DistinctFlowImpl$collect$2$emit$1) continuation;
                    int i11 = distinctFlowImpl$collect$2$emit$1.label;
                    if ((i11 & Integer.MIN_VALUE) != 0) {
                        distinctFlowImpl$collect$2$emit$1.label = i11 - Integer.MIN_VALUE;
                    } else {
                        distinctFlowImpl$collect$2$emit$1 = new DistinctFlowImpl$collect$2$emit$1(this, continuation);
                    }
                } else {
                    distinctFlowImpl$collect$2$emit$1 = new DistinctFlowImpl$collect$2$emit$1(this, continuation);
                }
                Object obj11 = distinctFlowImpl$collect$2$emit$1.result;
                int i12 = distinctFlowImpl$collect$2$emit$1.label;
                if (i12 == 0) {
                    ResultKt.throwOnFailure(obj11);
                    Object objInvoke = distinctFlowImpl.keySelector.invoke(obj2);
                    Object obj12 = ref$ObjectRef2.element;
                    if (obj12 == CombineKt.NULL || !((Boolean) distinctFlowImpl.areEquivalent.invoke(obj12, objInvoke)).booleanValue()) {
                        ref$ObjectRef2.element = objInvoke;
                        distinctFlowImpl$collect$2$emit$1.label = 1;
                        if (((FlowCollector) obj3).emit(obj2, distinctFlowImpl$collect$2$emit$1) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                } else {
                    if (i12 != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj11);
                }
                return unit;
            case 9:
                FlowCollector flowCollector4 = (FlowCollector) obj3;
                Ref$BooleanRef ref$BooleanRef = (Ref$BooleanRef) obj5;
                if (continuation instanceof FlowKt__LimitKt$dropWhile$1$1$emit$1) {
                    flowKt__LimitKt$dropWhile$1$1$emit$1 = (FlowKt__LimitKt$dropWhile$1$1$emit$1) continuation;
                    int i13 = flowKt__LimitKt$dropWhile$1$1$emit$1.label;
                    if ((i13 & Integer.MIN_VALUE) != 0) {
                        flowKt__LimitKt$dropWhile$1$1$emit$1.label = i13 - Integer.MIN_VALUE;
                    } else {
                        flowKt__LimitKt$dropWhile$1$1$emit$1 = new FlowKt__LimitKt$dropWhile$1$1$emit$1(this, continuation);
                    }
                } else {
                    flowKt__LimitKt$dropWhile$1$1$emit$1 = new FlowKt__LimitKt$dropWhile$1$1$emit$1(this, continuation);
                }
                Object objInvoke2 = flowKt__LimitKt$dropWhile$1$1$emit$1.result;
                int i14 = flowKt__LimitKt$dropWhile$1$1$emit$1.label;
                if (i14 != 0) {
                    if (i14 != 1) {
                        if (i14 == 2) {
                            obj2 = flowKt__LimitKt$dropWhile$1$1$emit$1.L$0;
                            ResultKt.throwOnFailure(objInvoke2);
                            if (!((Boolean) objInvoke2).booleanValue()) {
                                ref$BooleanRef.element = true;
                                flowKt__LimitKt$dropWhile$1$1$emit$1.L$0 = null;
                                flowKt__LimitKt$dropWhile$1$1$emit$1.label = 3;
                                if (flowCollector4.emit(obj2, flowKt__LimitKt$dropWhile$1$1$emit$1) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            }
                        } else if (i14 != 3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                    }
                    ResultKt.throwOnFailure(objInvoke2);
                } else {
                    ResultKt.throwOnFailure(objInvoke2);
                    if (ref$BooleanRef.element) {
                        flowKt__LimitKt$dropWhile$1$1$emit$1.L$0 = null;
                        flowKt__LimitKt$dropWhile$1$1$emit$1.label = 1;
                        if (flowCollector4.emit(obj2, flowKt__LimitKt$dropWhile$1$1$emit$1) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        flowKt__LimitKt$dropWhile$1$1$emit$1.L$0 = obj2;
                        flowKt__LimitKt$dropWhile$1$1$emit$1.label = 2;
                        objInvoke2 = ((Function2) obj4).invoke(obj2, flowKt__LimitKt$dropWhile$1$1$emit$1);
                        if (objInvoke2 == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        if (!((Boolean) objInvoke2).booleanValue()) {
                            ref$BooleanRef.element = true;
                            flowKt__LimitKt$dropWhile$1$1$emit$1.L$0 = null;
                            flowKt__LimitKt$dropWhile$1$1$emit$1.label = 3;
                            if (flowCollector4.emit(obj2, flowKt__LimitKt$dropWhile$1$1$emit$1) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                    }
                }
                return unit;
            default:
                Object objWithContextUndispatched = CombineKt.withContextUndispatched((CoroutineContext) obj5, obj2, obj4, (ShimmerModifierKt$shimmer$1$1) obj3, continuation);
                return objWithContextUndispatched == coroutineSingletons ? objWithContextUndispatched : unit;
        }
    }

    public FlowKt__LimitKt$take$2$1(DistinctFlowImpl distinctFlowImpl, Ref$ObjectRef ref$ObjectRef, FlowCollector flowCollector) {
        this.$r8$classId = (byte) 8;
        this.$consumed = distinctFlowImpl;
        this.$ownershipMarker = ref$ObjectRef;
        this.$this_flow = flowCollector;
    }

    public /* synthetic */ FlowKt__LimitKt$take$2$1(FlowCollector flowCollector, Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.$this_flow = flowCollector;
        this.$consumed = obj;
        this.$ownershipMarker = obj2;
    }

    public /* synthetic */ FlowKt__LimitKt$take$2$1(Object obj, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.$consumed = obj;
        this.$this_flow = obj2;
        this.$ownershipMarker = obj3;
    }
}
