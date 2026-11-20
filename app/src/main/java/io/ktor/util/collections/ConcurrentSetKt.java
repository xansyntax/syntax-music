package io.ktor.util.collections;

import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "Key", "", "ConcurrentSet", "()Ljava/util/Set;", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ConcurrentSetKt {
    public static final <Key> Set<Key> ConcurrentSet() {
        return new AnonymousClass1();
    }

    /* JADX INFO: Add missing generic type declarations: [Key] */
    /* JADX INFO: renamed from: io.ktor.util.collections.ConcurrentSetKt$ConcurrentSet$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096\u0080\b¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\b\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0080\b¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u00020\nH\u0096\u0080\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0096\u0082\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096\u0080\b¢\u0006\u0004\b\u0010\u0010\u0005J\u001f\u0010\u0011\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0080\b¢\u0006\u0004\b\u0011\u0010\tJ\u001f\u0010\u0012\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0080\b¢\u0006\u0004\b\u0012\u0010\tJ\u0019\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0004\b\u0013\u0010\u0005J\u001f\u0010\u0014\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0080\u0004¢\u0006\u0004\b\u0014\u0010\tJ\u0011\u0010\u0015\u001a\u00020\u0003H\u0096\u0080\u0004¢\u0006\u0004\b\u0015\u0010\u0016R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"io/ktor/util/collections/ConcurrentSetKt$ConcurrentSet$1", "", "element", "", "add", "(Ljava/lang/Object;)Z", "", "elements", "addAll", "(Ljava/util/Collection;)Z", "", "clear", "()V", "", "iterator", "()Ljava/util/Iterator;", "remove", "removeAll", "retainAll", "contains", "containsAll", "isEmpty", "()Z", "Lio/ktor/util/collections/ConcurrentMap;", "delegate", "Lio/ktor/util/collections/ConcurrentMap;", "", "getSize", "()I", ContentDisposition.Parameters.Size, "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1<Key> implements Set<Key>, KMutableSet {
        private final ConcurrentMap<Key, Unit> delegate = new ConcurrentMap<>(0, 1, null);

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit add$lambda$0(Ref$BooleanRef ref$BooleanRef) {
            ref$BooleanRef.element = true;
            return Unit.INSTANCE;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(Key element) {
            element.getClass();
            Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            this.delegate.computeIfAbsent(element, new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 29, ref$BooleanRef));
            return ref$BooleanRef.element;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Key> elements) {
            elements.getClass();
            Iterator<T> it = elements.iterator();
            while (true) {
                boolean z = false;
                while (it.hasNext()) {
                    if (add(it.next()) || z) {
                        z = true;
                    }
                }
                return z;
            }
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            this.delegate.clear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object element) {
            if (element == null) {
                return false;
            }
            return this.delegate.containsKey(element);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> elements) {
            elements.getClass();
            Collection<?> collection = elements;
            if (collection.isEmpty()) {
                return true;
            }
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        public int getSize() {
            return this.delegate.size();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return this.delegate.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Key> iterator() {
            return new ConcurrentSetKt$ConcurrentSet$1$iterator$1(this);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object element) {
            return (element == null || this.delegate.remove(element) == null) ? false : true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> elements) {
            elements.getClass();
            Iterator<T> it = elements.iterator();
            while (true) {
                boolean z = false;
                while (it.hasNext()) {
                    if (remove(it.next()) || z) {
                        z = true;
                    }
                }
                return z;
            }
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> elements) {
            elements.getClass();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (Key key : this.delegate.keySet()) {
                if (!elements.contains(key)) {
                    linkedHashSet.add(key);
                }
            }
            return removeAll(linkedHashSet);
        }

        @Override // java.util.Set, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            tArr.getClass();
            return (T[]) Intrinsics.Kotlin.toArray(this, tArr);
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return Intrinsics.Kotlin.toArray(this);
        }
    }
}
