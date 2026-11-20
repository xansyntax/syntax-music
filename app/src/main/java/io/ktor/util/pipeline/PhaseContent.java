package io.ktor.util.pipeline;

import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableList;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u0000 4*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u00014Bc\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012J\u0010\u000e\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r0\b¢\u0006\u0004\b\u000f\u0010\u0010B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0011JS\u0010\u0012\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r0\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015JS\u0010\u0017\u001a\u00020\f2D\u0010\u0016\u001a@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r¢\u0006\u0004\b\u0017\u0010\u0018JY\u0010\u001a\u001a\u00020\f2J\u0010\u0019\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r0\b¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001a\u001a\u00020\f2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\b\u001a\u0010\u001cJQ\u0010\u001d\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r0\b¢\u0006\u0004\b\u001d\u0010\u0013J\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010&RZ\u0010\u000e\u001aF\u0012B\u0012@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\r0\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b/\u0010,R\u0011\u00103\u001a\u0002008F¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00065"}, d2 = {"Lio/ktor/util/pipeline/PhaseContent;", "", "TSubject", "Call", "Lio/ktor/util/pipeline/PipelinePhase;", "phase", "Lio/ktor/util/pipeline/PipelinePhaseRelation;", "relation", "", "Lkotlin/Function3;", "Lio/ktor/util/pipeline/PipelineContext;", "Lkotlin/coroutines/Continuation;", "", "Lio/ktor/util/pipeline/PipelineInterceptor;", "interceptors", "<init>", "(Lio/ktor/util/pipeline/PipelinePhase;Lio/ktor/util/pipeline/PipelinePhaseRelation;Ljava/util/List;)V", "(Lio/ktor/util/pipeline/PipelinePhase;Lio/ktor/util/pipeline/PipelinePhaseRelation;)V", "copiedInterceptors", "()Ljava/util/List;", "copyInterceptors", "()V", "interceptor", "addInterceptor", "(Lkotlin/jvm/functions/Function3;)V", "destination", "addTo", "(Ljava/util/List;)V", "(Lio/ktor/util/pipeline/PhaseContent;)V", "sharedInterceptors", "", "toString", "()Ljava/lang/String;", "Lio/ktor/util/pipeline/PipelinePhase;", "getPhase", "()Lio/ktor/util/pipeline/PipelinePhase;", "Lio/ktor/util/pipeline/PipelinePhaseRelation;", "getRelation", "()Lio/ktor/util/pipeline/PipelinePhaseRelation;", "Ljava/util/List;", "", "shared", "Z", "getShared", "()Z", "setShared", "(Z)V", "isEmpty", "", "getSize", "()I", ContentDisposition.Parameters.Size, "Companion", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PhaseContent<TSubject, Call> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Object> SharedArrayList = new ArrayList();
    private List<Function3> interceptors;
    private final PipelinePhase phase;
    private final PipelinePhaseRelation relation;
    private boolean shared;

    /* JADX WARN: Illegal instructions before constructor call */
    public PhaseContent(PipelinePhase pipelinePhase, PipelinePhaseRelation pipelinePhaseRelation) {
        pipelinePhase.getClass();
        pipelinePhaseRelation.getClass();
        List<Object> list = SharedArrayList;
        list.getClass();
        if ((list instanceof KMappedMarker) && !(list instanceof KMutableList)) {
            TypeIntrinsics.throwCce(list, "kotlin.collections.MutableList");
            throw null;
        }
        this(pipelinePhase, pipelinePhaseRelation, list);
        if (list.isEmpty()) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("The shared empty array list has been modified");
        throw null;
    }

    private final List<Function3> copiedInterceptors() {
        return CollectionsKt.toMutableList((Collection) this.interceptors);
    }

    private final void copyInterceptors() {
        this.interceptors = copiedInterceptors();
        this.shared = false;
    }

    public final void addInterceptor(Function3 interceptor) {
        interceptor.getClass();
        if (this.shared) {
            copyInterceptors();
        }
        this.interceptors.add(interceptor);
    }

    public final void addTo(List<Function3> destination) {
        destination.getClass();
        List<Function3> list = this.interceptors;
        if (destination instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) destination;
            arrayList.ensureCapacity(list.size() + arrayList.size());
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            destination.add(list.get(i));
        }
    }

    public final PipelinePhase getPhase() {
        return this.phase;
    }

    public final PipelinePhaseRelation getRelation() {
        return this.relation;
    }

    public final boolean getShared() {
        return this.shared;
    }

    public final int getSize() {
        return this.interceptors.size();
    }

    public final boolean isEmpty() {
        return this.interceptors.isEmpty();
    }

    public final void setShared(boolean z) {
        this.shared = z;
    }

    public final List<Function3> sharedInterceptors() {
        this.shared = true;
        return this.interceptors;
    }

    public String toString() {
        return "Phase `" + this.phase.getName() + "`, " + getSize() + " handlers";
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001f\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/util/pipeline/PhaseContent$Companion;", "", "<init>", "()V", "", "SharedArrayList", "Ljava/util/List;", "getSharedArrayList", "()Ljava/util/List;", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<Object> getSharedArrayList() {
            return PhaseContent.SharedArrayList;
        }

        private Companion() {
        }
    }

    public final void addTo(PhaseContent<TSubject, Call> destination) {
        destination.getClass();
        if (isEmpty()) {
            return;
        }
        if (destination.isEmpty()) {
            destination.interceptors = sharedInterceptors();
            destination.shared = true;
        } else {
            if (destination.shared) {
                destination.copyInterceptors();
            }
            addTo(destination.interceptors);
        }
    }

    public PhaseContent(PipelinePhase pipelinePhase, PipelinePhaseRelation pipelinePhaseRelation, List<Function3> list) {
        pipelinePhase.getClass();
        pipelinePhaseRelation.getClass();
        list.getClass();
        this.phase = pipelinePhase;
        this.relation = pipelinePhaseRelation;
        this.interceptors = list;
        this.shared = true;
    }
}
