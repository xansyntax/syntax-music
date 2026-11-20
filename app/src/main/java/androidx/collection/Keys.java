package androidx.collection;

import androidx.compose.runtime.collection.ScatterSetWrapper;
import dagger.hilt.EntryPoints;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequenceScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Keys implements Set, KMappedMarker {
    public final /* synthetic */ byte $r8$classId;
    public final MutableScatterMap parent;

    /* JADX INFO: renamed from: androidx.collection.Keys$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public int I$0;
        public int I$1;
        public int I$2;
        public int I$3;
        public long J$0;
        public /* synthetic */ Object L$0;
        public Object L$1;
        public long[] L$2;
        public boolean label;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(Object obj, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj2 = this.this$0;
            switch (b) {
                case 0:
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1((Keys) obj2, continuation, (byte) 0);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                case 1:
                    AnonymousClass1 anonymousClass2 = new AnonymousClass1((Keys) obj2, continuation, (byte) 1);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
                case 2:
                    AnonymousClass1 anonymousClass3 = new AnonymousClass1((Values) obj2, continuation, (byte) 2);
                    anonymousClass3.L$0 = obj;
                    return anonymousClass3;
                default:
                    AnonymousClass1 anonymousClass4 = new AnonymousClass1((ScatterSetWrapper) obj2, continuation, (byte) 3);
                    anonymousClass4.L$0 = obj;
                    return anonymousClass4;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            SequenceScope sequenceScope = (SequenceScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(unit);
        }

        /* JADX WARN: Code duplicated, block: B:79:0x0237  */
        /* JADX WARN: Code duplicated, block: B:88:0x0278  */
        /* JADX WARN: Code duplicated, block: B:90:0x027b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x006c -> B:22:0x00ab). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x006e -> B:15:0x007d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0083 -> B:19:0x00a1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00ff -> B:43:0x013f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0101 -> B:36:0x0112). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0118 -> B:40:0x0136). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0190 -> B:64:0x01e0). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0192 -> B:57:0x01a4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x01aa -> B:61:0x01d6). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x0237 -> B:80:0x0248). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x024e -> B:72:0x020e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x0278 -> B:89:0x0279). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r28) {
            /*
                Method dump skipped, instruction units count: 650
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.collection.Keys.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public /* synthetic */ Keys(MutableScatterMap mutableScatterMap, byte b) {
        this.$r8$classId = b;
        this.parent = mutableScatterMap;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        byte b = this.$r8$classId;
        MutableScatterMap mutableScatterMap = this.parent;
        switch (b) {
            case 0:
                return mutableScatterMap.containsKey(obj);
            default:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return Intrinsics.areEqual(mutableScatterMap.get(entry.getKey()), entry.getValue());
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        byte b = this.$r8$classId;
        MutableScatterMap mutableScatterMap = this.parent;
        collection.getClass();
        switch (b) {
            case 0:
                Collection collection2 = collection;
                if (!collection2.isEmpty()) {
                    Iterator it = collection2.iterator();
                    while (it.hasNext()) {
                        if (!mutableScatterMap.containsKey(it.next())) {
                            return false;
                        }
                    }
                }
                return true;
            default:
                Collection<Map.Entry> collection3 = collection;
                if (!collection3.isEmpty()) {
                    for (Map.Entry entry : collection3) {
                        if (!Intrinsics.areEqual(mutableScatterMap.get(entry.getKey()), entry.getValue())) {
                            return false;
                        }
                    }
                }
                return true;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        byte b = this.$r8$classId;
        MutableScatterMap mutableScatterMap = this.parent;
        switch (b) {
            case 0:
                break;
        }
        return mutableScatterMap.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        Continuation continuation = null;
        switch (this.$r8$classId) {
            case 0:
                return EntryPoints.iterator(new AnonymousClass1(this, continuation, (byte) 0));
            default:
                return EntryPoints.iterator(new AnonymousClass1(this, continuation, (byte) 1));
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        byte b = this.$r8$classId;
        MutableScatterMap mutableScatterMap = this.parent;
        switch (b) {
            case 0:
                break;
        }
        return mutableScatterMap._size;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.$r8$classId) {
            case 0:
                objArr.getClass();
                break;
            default:
                objArr.getClass();
                break;
        }
        return Intrinsics.Kotlin.toArray(this, objArr);
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return Intrinsics.Kotlin.toArray(this);
    }
}
