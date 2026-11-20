package io.ktor.util.pipeline;

import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableList;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u000b\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B\u001b\u0012\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB]\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012J\u0010\u0010\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f0\n¢\u0006\u0004\b\u0007\u0010\u0011J \u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00028\u0000H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001aJ[\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00052D\u0010\u001c\u001a@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001f\u0010 JY\u0010!\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f0\n2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b!\u0010\"J!\u0010$\u001a\u00020\u000e2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\b$\u0010%J!\u0010&\u001a\u00020\u000e2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\b&\u0010%J!\u0010'\u001a\u00020\u000e2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\b'\u0010%J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J[\u0010,\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f0\n2\u0006\u0010\t\u001a\u00020\u0005H\u0000¢\u0006\u0004\b+\u0010\"JS\u0010/\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f0\nH\u0000¢\u0006\u0004\b-\u0010.J#\u00100\u001a\u00020\u000e2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002¢\u0006\u0004\b0\u0010%J3\u00103\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f2\u0006\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u00102\u001a\u000201H\u0002¢\u0006\u0004\b3\u00104J%\u00106\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u0001052\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u0002082\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010<\u001a\u00020;2\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b<\u0010=JS\u0010>\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f0\nH\u0002¢\u0006\u0004\b>\u0010.J#\u0010?\u001a\u00020;2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002¢\u0006\u0004\b?\u0010@JS\u0010A\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f0\nH\u0002¢\u0006\u0004\bA\u0010.J\u000f\u0010B\u001a\u00020\u000eH\u0002¢\u0006\u0004\bB\u0010 J[\u0010D\u001a\u00020\u000e2J\u0010C\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000f0\nH\u0002¢\u0006\u0004\bD\u0010EJ#\u0010G\u001a\u00020\u000e2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000105H\u0002¢\u0006\u0004\bG\u0010HJ#\u0010J\u001a\u00020\u000e2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002¢\u0006\u0004\bJ\u0010%J]\u0010K\u001a\u00020;2\u0006\u0010\t\u001a\u00020\u00052D\u0010\u001c\u001a@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000fH\u0002¢\u0006\u0004\bK\u0010LJ\u001f\u0010O\u001a\u00020;2\u0006\u0010M\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\u0005H\u0002¢\u0006\u0004\bO\u0010PR\u0017\u0010R\u001a\u00020Q8\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u001a\u0010V\u001a\u00020;8\u0016X\u0096D¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00010Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010]\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010WR\u0018\u0010`\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0017\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00050\n8F¢\u0006\u0006\u001a\u0004\bb\u0010.R\u0011\u0010d\u001a\u00020;8F¢\u0006\u0006\u001a\u0004\bd\u0010Y¨\u0006e"}, d2 = {"Lio/ktor/util/pipeline/Pipeline;", "", "TSubject", "TContext", "", "Lio/ktor/util/pipeline/PipelinePhase;", "phases", "<init>", "([Lio/ktor/util/pipeline/PipelinePhase;)V", "phase", "", "Lkotlin/Function3;", "Lio/ktor/util/pipeline/PipelineContext;", "Lkotlin/coroutines/Continuation;", "", "Lio/ktor/util/pipeline/PipelineInterceptor;", "interceptors", "(Lio/ktor/util/pipeline/PipelinePhase;Ljava/util/List;)V", "context", "subject", "execute", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addPhase", "(Lio/ktor/util/pipeline/PipelinePhase;)V", "reference", "insertPhaseAfter", "(Lio/ktor/util/pipeline/PipelinePhase;Lio/ktor/util/pipeline/PipelinePhase;)V", "insertPhaseBefore", "block", "intercept", "(Lio/ktor/util/pipeline/PipelinePhase;Lkotlin/jvm/functions/Function3;)V", "afterIntercepted", "()V", "interceptorsForPhase", "(Lio/ktor/util/pipeline/PipelinePhase;)Ljava/util/List;", "from", "mergePhases", "(Lio/ktor/util/pipeline/Pipeline;)V", "merge", "resetFrom", "", "toString", "()Ljava/lang/String;", "phaseInterceptors$ktor_utils", "phaseInterceptors", "interceptorsForTests$ktor_utils", "()Ljava/util/List;", "interceptorsForTests", "mergeInterceptors", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "createContext", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/util/pipeline/PhaseContent;", "findPhase", "(Lio/ktor/util/pipeline/PipelinePhase;)Lio/ktor/util/pipeline/PhaseContent;", "", "findPhaseIndex", "(Lio/ktor/util/pipeline/PipelinePhase;)I", "", "hasPhase", "(Lio/ktor/util/pipeline/PipelinePhase;)Z", "cacheInterceptors", "fastPathMerge", "(Lio/ktor/util/pipeline/Pipeline;)Z", "sharedInterceptorsList", "resetInterceptorsList", "list", "notSharedInterceptorsList", "(Ljava/util/List;)V", "phaseContent", "setInterceptorsListFromPhase", "(Lio/ktor/util/pipeline/PhaseContent;)V", "pipeline", "setInterceptorsListFromAnotherPipeline", "tryAddToPhaseFastPath", "(Lio/ktor/util/pipeline/PipelinePhase;Lkotlin/jvm/functions/Function3;)Z", "fromPhaseOrContent", "fromPhase", "insertRelativePhase", "(Ljava/lang/Object;Lio/ktor/util/pipeline/PipelinePhase;)Z", "Lio/ktor/util/Attributes;", "attributes", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "developmentMode", "Z", "getDevelopmentMode", "()Z", "", "phasesRaw", "Ljava/util/List;", "interceptorsQuantity", "I", "interceptorsListShared", "interceptorsListSharedPhase", "Lio/ktor/util/pipeline/PipelinePhase;", "getItems", "items", "isEmpty", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class Pipeline<TSubject, TContext> {
    private final Attributes attributes;
    private final boolean developmentMode;
    private volatile /* synthetic */ Object interceptors$delegate;
    private boolean interceptorsListShared;
    private PipelinePhase interceptorsListSharedPhase;
    private int interceptorsQuantity;
    private final List<Object> phasesRaw;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Pipeline(PipelinePhase pipelinePhase, List<? extends Function3> list) {
        this(pipelinePhase);
        pipelinePhase.getClass();
        list.getClass();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            intercept(pipelinePhase, (Function3) it.next());
        }
    }

    private final List<Function3> cacheInterceptors() {
        int lastIndex;
        int i = this.interceptorsQuantity;
        if (i == 0) {
            EmptyList emptyList = EmptyList.INSTANCE;
            notSharedInterceptorsList(emptyList);
            return emptyList;
        }
        List<Object> list = this.phasesRaw;
        int i2 = 0;
        if (i == 1 && (lastIndex = CollectionsKt__IterablesKt.getLastIndex(list)) >= 0) {
            int i3 = 0;
            while (true) {
                Object obj = list.get(i3);
                PhaseContent<TSubject, TContext> phaseContent = obj instanceof PhaseContent ? (PhaseContent) obj : null;
                if (phaseContent != null && !phaseContent.isEmpty()) {
                    List<Function3> listSharedInterceptors = phaseContent.sharedInterceptors();
                    setInterceptorsListFromPhase(phaseContent);
                    return listSharedInterceptors;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        ArrayList arrayList = new ArrayList();
        int lastIndex2 = CollectionsKt__IterablesKt.getLastIndex(list);
        if (lastIndex2 >= 0) {
            while (true) {
                Object obj2 = list.get(i2);
                PhaseContent phaseContent2 = obj2 instanceof PhaseContent ? (PhaseContent) obj2 : null;
                if (phaseContent2 != null) {
                    phaseContent2.addTo(arrayList);
                }
                if (i2 == lastIndex2) {
                    break;
                }
                i2++;
            }
        }
        notSharedInterceptorsList(arrayList);
        return arrayList;
    }

    private final PipelineContext<TSubject, TContext> createContext(TContext context, TSubject subject, CoroutineContext coroutineContext) {
        return PipelineContextKt.pipelineContextFor(context, sharedInterceptorsList(), subject, coroutineContext, getDevelopmentMode());
    }

    private final boolean fastPathMerge(Pipeline<TSubject, TContext> from) {
        if (from.phasesRaw.isEmpty()) {
            return true;
        }
        int i = 0;
        if (!this.phasesRaw.isEmpty()) {
            return false;
        }
        List<Object> list = from.phasesRaw;
        int lastIndex = CollectionsKt__IterablesKt.getLastIndex(list);
        if (lastIndex >= 0) {
            while (true) {
                Object obj = list.get(i);
                if (obj instanceof PipelinePhase) {
                    this.phasesRaw.add(obj);
                } else if (obj instanceof PhaseContent) {
                    PhaseContent phaseContent = (PhaseContent) obj;
                    this.phasesRaw.add(new PhaseContent(phaseContent.getPhase(), phaseContent.getRelation(), phaseContent.sharedInterceptors()));
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        this.interceptorsQuantity += from.interceptorsQuantity;
        setInterceptorsListFromAnotherPipeline(from);
        return true;
    }

    private final PhaseContent<TSubject, TContext> findPhase(PipelinePhase phase) {
        List<Object> list = this.phasesRaw;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj == phase) {
                PhaseContent<TSubject, TContext> phaseContent = new PhaseContent<>(phase, PipelinePhaseRelation.Last.INSTANCE);
                list.set(i, phaseContent);
                return phaseContent;
            }
            if (obj instanceof PhaseContent) {
                PhaseContent<TSubject, TContext> phaseContent2 = (PhaseContent) obj;
                if (phaseContent2.getPhase() == phase) {
                    return phaseContent2;
                }
            }
        }
        return null;
    }

    private final int findPhaseIndex(PipelinePhase phase) {
        List<Object> list = this.phasesRaw;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj == phase || ((obj instanceof PhaseContent) && ((PhaseContent) obj).getPhase() == phase)) {
                return i;
            }
        }
        return -1;
    }

    private final List<Function3> getInterceptors() {
        return (List) this.interceptors$delegate;
    }

    private final boolean hasPhase(PipelinePhase phase) {
        List<Object> list = this.phasesRaw;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj == phase) {
                return true;
            }
            if ((obj instanceof PhaseContent) && ((PhaseContent) obj).getPhase() == phase) {
                return true;
            }
        }
        return false;
    }

    private final boolean insertRelativePhase(Object fromPhaseOrContent, PipelinePhase fromPhase) throws InvalidPhaseException {
        PipelinePhaseRelation relation;
        if (fromPhaseOrContent == fromPhase) {
            relation = PipelinePhaseRelation.Last.INSTANCE;
        } else {
            fromPhaseOrContent.getClass();
            relation = ((PhaseContent) fromPhaseOrContent).getRelation();
        }
        if (relation instanceof PipelinePhaseRelation.Last) {
            addPhase(fromPhase);
            return true;
        }
        if (relation instanceof PipelinePhaseRelation.Before) {
            PipelinePhaseRelation.Before before = (PipelinePhaseRelation.Before) relation;
            if (hasPhase(before.getRelativeTo())) {
                insertPhaseBefore(before.getRelativeTo(), fromPhase);
                return true;
            }
        }
        if (!(relation instanceof PipelinePhaseRelation.After)) {
            return false;
        }
        insertPhaseAfter(((PipelinePhaseRelation.After) relation).getRelativeTo(), fromPhase);
        return true;
    }

    private final void mergeInterceptors(Pipeline<TSubject, TContext> from) {
        if (this.interceptorsQuantity == 0) {
            setInterceptorsListFromAnotherPipeline(from);
        } else {
            resetInterceptorsList();
        }
        for (Object obj : from.phasesRaw) {
            PipelinePhase phase = obj instanceof PipelinePhase ? (PipelinePhase) obj : null;
            if (phase == null) {
                obj.getClass();
                phase = ((PhaseContent) obj).getPhase();
            }
            if (obj instanceof PhaseContent) {
                PhaseContent phaseContent = (PhaseContent) obj;
                if (!phaseContent.isEmpty()) {
                    PhaseContent<TSubject, TContext> phaseContentFindPhase = findPhase(phase);
                    phaseContentFindPhase.getClass();
                    phaseContent.addTo(phaseContentFindPhase);
                    this.interceptorsQuantity = phaseContent.getSize() + this.interceptorsQuantity;
                }
            }
        }
    }

    private final void notSharedInterceptorsList(List<? extends Function3> list) {
        setInterceptors(list);
        this.interceptorsListShared = false;
        this.interceptorsListSharedPhase = null;
    }

    private final void resetInterceptorsList() {
        setInterceptors(null);
        this.interceptorsListShared = false;
        this.interceptorsListSharedPhase = null;
    }

    private final void setInterceptors(List<? extends Function3> list) {
        this.interceptors$delegate = list;
    }

    private final void setInterceptorsListFromAnotherPipeline(Pipeline<TSubject, TContext> pipeline) {
        setInterceptors(pipeline.sharedInterceptorsList());
        this.interceptorsListShared = true;
        this.interceptorsListSharedPhase = null;
    }

    private final void setInterceptorsListFromPhase(PhaseContent<TSubject, TContext> phaseContent) {
        setInterceptors(phaseContent.sharedInterceptors());
        this.interceptorsListShared = false;
        this.interceptorsListSharedPhase = phaseContent.getPhase();
    }

    private final List<Function3> sharedInterceptorsList() {
        if (getInterceptors() == null) {
            cacheInterceptors();
        }
        this.interceptorsListShared = true;
        List<Function3> interceptors = getInterceptors();
        interceptors.getClass();
        return interceptors;
    }

    private final boolean tryAddToPhaseFastPath(PipelinePhase phase, Function3 block) {
        List<Function3> interceptors = getInterceptors();
        if (this.phasesRaw.isEmpty() || interceptors == null || this.interceptorsListShared || ((interceptors instanceof KMappedMarker) && !(interceptors instanceof KMutableList))) {
            return false;
        }
        if (Intrinsics.areEqual(this.interceptorsListSharedPhase, phase)) {
            interceptors.add(block);
            return true;
        }
        if (Intrinsics.areEqual(phase, CollectionsKt.last(this.phasesRaw)) || findPhaseIndex(phase) == CollectionsKt__IterablesKt.getLastIndex(this.phasesRaw)) {
            PhaseContent<TSubject, TContext> phaseContentFindPhase = findPhase(phase);
            phaseContentFindPhase.getClass();
            phaseContentFindPhase.addInterceptor(block);
            interceptors.add(block);
            return true;
        }
        return false;
    }

    public final void addPhase(PipelinePhase phase) {
        phase.getClass();
        if (hasPhase(phase)) {
            return;
        }
        this.phasesRaw.add(phase);
    }

    public final Object execute(TContext tcontext, TSubject tsubject, Continuation continuation) {
        return createContext(tcontext, tsubject, continuation.getContext()).execute$ktor_utils(tsubject, continuation);
    }

    public final Attributes getAttributes() {
        return this.attributes;
    }

    public boolean getDevelopmentMode() {
        return this.developmentMode;
    }

    public final List<PipelinePhase> getItems() {
        List<Object> list = this.phasesRaw;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (Object obj : list) {
            PipelinePhase pipelinePhase = obj instanceof PipelinePhase ? (PipelinePhase) obj : null;
            if (pipelinePhase == null) {
                PhaseContent phaseContent = obj instanceof PhaseContent ? (PhaseContent) obj : null;
                PipelinePhase phase = phaseContent != null ? phaseContent.getPhase() : null;
                phase.getClass();
                pipelinePhase = phase;
            }
            arrayList.add(pipelinePhase);
        }
        return arrayList;
    }

    public final void insertPhaseAfter(PipelinePhase reference, PipelinePhase phase) {
        PipelinePhaseRelation relation;
        PipelinePhase relativeTo;
        reference.getClass();
        phase.getClass();
        if (hasPhase(phase)) {
            return;
        }
        int iFindPhaseIndex = findPhaseIndex(reference);
        if (iFindPhaseIndex == -1) {
            throw new InvalidPhaseException("Phase " + reference + " was not registered for this pipeline");
        }
        int i = iFindPhaseIndex + 1;
        int lastIndex = CollectionsKt__IterablesKt.getLastIndex(this.phasesRaw);
        if (i <= lastIndex) {
            while (true) {
                Object obj = this.phasesRaw.get(i);
                PhaseContent phaseContent = obj instanceof PhaseContent ? (PhaseContent) obj : null;
                if (phaseContent != null && (relation = phaseContent.getRelation()) != null) {
                    PipelinePhaseRelation.After after = relation instanceof PipelinePhaseRelation.After ? (PipelinePhaseRelation.After) relation : null;
                    if (after != null && (relativeTo = after.getRelativeTo()) != null && relativeTo == reference) {
                        iFindPhaseIndex = i;
                    }
                    if (i == lastIndex) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    break;
                }
            }
        }
        this.phasesRaw.add(iFindPhaseIndex + 1, new PhaseContent(phase, new PipelinePhaseRelation.After(reference)));
    }

    public final void insertPhaseBefore(PipelinePhase reference, PipelinePhase phase) throws InvalidPhaseException {
        reference.getClass();
        phase.getClass();
        if (hasPhase(phase)) {
            return;
        }
        int iFindPhaseIndex = findPhaseIndex(reference);
        if (iFindPhaseIndex != -1) {
            this.phasesRaw.add(iFindPhaseIndex, new PhaseContent(phase, new PipelinePhaseRelation.Before(reference)));
            return;
        }
        throw new InvalidPhaseException("Phase " + reference + " was not registered for this pipeline");
    }

    public final void intercept(PipelinePhase phase, Function3 block) {
        phase.getClass();
        block.getClass();
        PhaseContent<TSubject, TContext> phaseContentFindPhase = findPhase(phase);
        if (phaseContentFindPhase == null) {
            throw new InvalidPhaseException("Phase " + phase + " was not registered for this pipeline");
        }
        if (tryAddToPhaseFastPath(phase, block)) {
            this.interceptorsQuantity++;
            return;
        }
        phaseContentFindPhase.addInterceptor(block);
        this.interceptorsQuantity++;
        resetInterceptorsList();
        afterIntercepted();
    }

    public final List<Function3> interceptorsForPhase(PipelinePhase phase) {
        Object obj;
        phase.getClass();
        List<Object> list = this.phasesRaw;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (obj2 instanceof PhaseContent) {
                arrayList.add(obj2);
            }
        }
        int size = arrayList.size();
        int i = 0;
        do {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i);
            i++;
        } while (!Intrinsics.areEqual(((PhaseContent) obj).getPhase(), phase));
        PhaseContent phaseContent = (PhaseContent) obj;
        List<Function3> listSharedInterceptors = phaseContent != null ? phaseContent.sharedInterceptors() : null;
        return listSharedInterceptors == null ? EmptyList.INSTANCE : listSharedInterceptors;
    }

    public final List<Function3> interceptorsForTests$ktor_utils() {
        List<Function3> interceptors = getInterceptors();
        return interceptors == null ? cacheInterceptors() : interceptors;
    }

    public final boolean isEmpty() {
        return this.interceptorsQuantity == 0;
    }

    public final void merge(Pipeline<TSubject, TContext> from) {
        from.getClass();
        if (fastPathMerge(from)) {
            return;
        }
        mergePhases(from);
        mergeInterceptors(from);
    }

    public final void mergePhases(Pipeline<TSubject, TContext> from) {
        from.getClass();
        ArrayList mutableList = CollectionsKt.toMutableList((Collection) from.phasesRaw);
        while (!mutableList.isEmpty()) {
            Iterator it = mutableList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                PipelinePhase phase = next instanceof PipelinePhase ? (PipelinePhase) next : null;
                if (phase == null) {
                    next.getClass();
                    phase = ((PhaseContent) next).getPhase();
                }
                if (hasPhase(phase)) {
                    it.remove();
                } else if (insertRelativePhase(next, phase)) {
                    it.remove();
                }
            }
        }
    }

    public final List<Function3> phaseInterceptors$ktor_utils(PipelinePhase phase) {
        List<Function3> listSharedInterceptors;
        phase.getClass();
        PhaseContent<TSubject, TContext> phaseContentFindPhase = findPhase(phase);
        return (phaseContentFindPhase == null || (listSharedInterceptors = phaseContentFindPhase.sharedInterceptors()) == null) ? EmptyList.INSTANCE : listSharedInterceptors;
    }

    public final void resetFrom(Pipeline<TSubject, TContext> from) {
        from.getClass();
        this.phasesRaw.clear();
        if (this.interceptorsQuantity == 0) {
            fastPathMerge(from);
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
        }
    }

    public String toString() {
        return super.toString();
    }

    public void afterIntercepted() {
    }

    public Pipeline(PipelinePhase... pipelinePhaseArr) {
        pipelinePhaseArr.getClass();
        this.attributes = AttributesJvmKt.Attributes(true);
        this.phasesRaw = CollectionsKt__IterablesKt.mutableListOf(Arrays.copyOf(pipelinePhaseArr, pipelinePhaseArr.length));
        this.interceptors$delegate = null;
    }
}
