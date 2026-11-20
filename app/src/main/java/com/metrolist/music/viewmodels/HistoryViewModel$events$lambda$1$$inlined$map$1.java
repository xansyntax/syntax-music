package com.metrolist.music.viewmodels;

import androidx.compose.ui.semantics.SemanticsSortKt$special$$inlined$thenBy$1;
import com.metrolist.music.db.entities.EventWithSong;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HistoryViewModel$events$lambda$1$$inlined$map$1 implements Flow {
    public final /* synthetic */ boolean $hideVideoSongs$inlined;
    public final /* synthetic */ Flow $this_unsafeTransform$inlined;
    public final /* synthetic */ HistoryViewModel this$0;

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HistoryViewModel$events$lambda$1$$inlined$map$1$1, reason: invalid class name */
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
            return HistoryViewModel$events$lambda$1$$inlined$map$1.this.collect(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HistoryViewModel$events$lambda$1$$inlined$map$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 implements FlowCollector {
        public final /* synthetic */ boolean $hideVideoSongs$inlined;
        public final /* synthetic */ FlowCollector $this_unsafeFlow;
        public final /* synthetic */ HistoryViewModel this$0;

        /* JADX INFO: renamed from: com.metrolist.music.viewmodels.HistoryViewModel$events$lambda$1$$inlined$map$1$2$1, reason: invalid class name */
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

        public AnonymousClass2(FlowCollector flowCollector, boolean z, HistoryViewModel historyViewModel) {
            this.$this_unsafeFlow = flowCollector;
            this.$hideVideoSongs$inlined = z;
            this.this$0 = historyViewModel;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1;
            HistoryViewModel historyViewModel;
            Object other;
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
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj2);
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : (List) obj) {
                    EventWithSong eventWithSong = (EventWithSong) obj3;
                    if (!this.$hideVideoSongs$inlined || !eventWithSong.song.song.isVideo) {
                        arrayList.add(obj3);
                    }
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int size = arrayList.size();
                int i3 = 0;
                while (true) {
                    historyViewModel = this.this$0;
                    if (i3 >= size) {
                        break;
                    }
                    Object obj4 = arrayList.get(i3);
                    i3++;
                    LocalDate localDate = ((EventWithSong) obj4).event.timestamp.toLocalDate();
                    int iBetween = (int) ChronoUnit.DAYS.between(localDate, historyViewModel.today);
                    if (iBetween == 0) {
                        other = DateAgo.Today.INSTANCE;
                    } else if (iBetween == 1) {
                        other = DateAgo.Yesterday.INSTANCE;
                    } else if (localDate.compareTo((ChronoLocalDate) historyViewModel.thisMonday) >= 0) {
                        other = DateAgo.ThisWeek.INSTANCE;
                    } else if (localDate.compareTo((ChronoLocalDate) historyViewModel.lastMonday) >= 0) {
                        other = DateAgo.LastWeek.INSTANCE;
                    } else {
                        LocalDate localDateWithDayOfMonth = localDate.withDayOfMonth(1);
                        localDateWithDayOfMonth.getClass();
                        other = new DateAgo.Other(localDateWithDayOfMonth);
                    }
                    Object arrayList2 = linkedHashMap.get(other);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        linkedHashMap.put(other, arrayList2);
                    }
                    ((List) arrayList2).add(obj4);
                }
                TreeMap treeMap = new TreeMap(new SemanticsSortKt$special$$inlined$thenBy$1((byte) 15, historyViewModel));
                treeMap.putAll(linkedHashMap);
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsKt.mapCapacity(treeMap.size()));
                for (Map.Entry entry : treeMap.entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    value.getClass();
                    HashSet hashSet = new HashSet();
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj5 : (Iterable) value) {
                        if (hashSet.add(((EventWithSong) obj5).song.song.id)) {
                            arrayList3.add(obj5);
                        }
                    }
                    linkedHashMap2.put(key, arrayList3);
                }
                anonymousClass1.label = 1;
                Object objEmit = this.$this_unsafeFlow.emit(linkedHashMap2, anonymousClass1);
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

    public HistoryViewModel$events$lambda$1$$inlined$map$1(Flow flow, boolean z, HistoryViewModel historyViewModel) {
        this.$this_unsafeTransform$inlined = flow;
        this.$hideVideoSongs$inlined = z;
        this.this$0 = historyViewModel;
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
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(flowCollector, this.$hideVideoSongs$inlined, this.this$0);
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
