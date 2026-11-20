package io.ktor.http.cio.internals;

import io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0;
import io.ktor.http.cio.HttpParserKt$$ExternalSyntheticLambda0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\b\b\b\u0000\u0018\u0000 \u0017*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002\u0018\u0017B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006JS\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lio/ktor/http/cio/internals/AsciiCharTree;", "", "T", "Lio/ktor/http/cio/internals/AsciiCharTree$Node;", "root", "<init>", "(Lio/ktor/http/cio/internals/AsciiCharTree$Node;)V", "", "sequence", "", "fromIdx", "end", "", "lowerCase", "Lkotlin/Function2;", "", "stopPredicate", "", "search", "(Ljava/lang/CharSequence;IIZLkotlin/jvm/functions/Function2;)Ljava/util/List;", "Lio/ktor/http/cio/internals/AsciiCharTree$Node;", "getRoot", "()Lio/ktor/http/cio/internals/AsciiCharTree$Node;", "Companion", "Node", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AsciiCharTree<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Node<T> root;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B1\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u0005¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u0010\u0010\u000fR%\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00000\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/http/cio/internals/AsciiCharTree$Node;", "T", "", "", "ch", "", "exact", "children", "<init>", "(CLjava/util/List;Ljava/util/List;)V", "C", "getCh", "()C", "Ljava/util/List;", "getExact", "()Ljava/util/List;", "getChildren", "", "array", "[Lio/ktor/http/cio/internals/AsciiCharTree$Node;", "getArray", "()[Lio/ktor/http/cio/internals/AsciiCharTree$Node;", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Node<T> {
        private final Node<T>[] array;
        private final char ch;
        private final List<Node<T>> children;
        private final List<T> exact;

        /* JADX WARN: Multi-variable type inference failed */
        public Node(char c, List<? extends T> list, List<Node<T>> list2) {
            list.getClass();
            list2.getClass();
            this.ch = c;
            this.exact = list;
            this.children = list2;
            Node<T>[] nodeArr = new Node[256];
            for (int i = 0; i < 256; i++) {
                Iterator<T> it = this.children.iterator();
                Node<T> node = null;
                boolean z = false;
                Node<T> node2 = null;
                while (true) {
                    if (!it.hasNext()) {
                        if (!z) {
                            break;
                        }
                        node = node2;
                        break;
                    } else {
                        T next = it.next();
                        if (((Node) next).ch == i) {
                            if (z) {
                                break;
                            }
                            z = true;
                            node2 = next;
                        }
                    }
                }
                nodeArr[i] = node;
            }
            this.array = nodeArr;
        }

        public final Node<T>[] getArray() {
            return this.array;
        }

        public final char getCh() {
            return this.ch;
        }

        public final List<Node<T>> getChildren() {
            return this.children;
        }

        public final List<T> getExact() {
            return this.exact;
        }
    }

    public AsciiCharTree(Node<T> node) {
        node.getClass();
        this.root = node;
    }

    public static /* synthetic */ List search$default(AsciiCharTree asciiCharTree, CharSequence charSequence, int i, int i2, boolean z, Function2 function2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        if ((i3 & 8) != 0) {
            z = false;
        }
        return asciiCharTree.search(charSequence, i, i2, z, function2);
    }

    public final Node<T> getRoot() {
        return this.root;
    }

    public final List<T> search(CharSequence sequence, int fromIdx, int end, boolean lowerCase, Function2 stopPredicate) {
        sequence.getClass();
        stopPredicate.getClass();
        if (sequence.length() == 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Couldn't search in char tree for empty string");
            return null;
        }
        Node<T> node = this.root;
        while (fromIdx < end) {
            char cCharAt = sequence.charAt(fromIdx);
            if (((Boolean) stopPredicate.invoke(Character.valueOf(cCharAt), Integer.valueOf(cCharAt))).booleanValue()) {
                break;
            }
            Node<T> node2 = node.getArray()[cCharAt];
            if (node2 == null) {
                node = lowerCase ? node.getArray()[Character.toLowerCase(cCharAt)] : null;
                if (node == null) {
                    return EmptyList.INSTANCE;
                }
            } else {
                node = node2;
            }
            fromIdx++;
        }
        return node.getExact();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\b\b\u0001\u0010\u0005*\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\t\u0010\nJY\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\b\b\u0001\u0010\u0005*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\u000b2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\t\u0010\u0011Jy\u0010\t\u001a\u00020\u0017\"\b\b\u0001\u0010\u0005*\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00130\u00122\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\u000b2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\t\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/http/cio/internals/AsciiCharTree$Companion;", "", "<init>", "()V", "", "T", "", "from", "Lio/ktor/http/cio/internals/AsciiCharTree;", "build", "(Ljava/util/List;)Lio/ktor/http/cio/internals/AsciiCharTree;", "Lkotlin/Function1;", "", "length", "Lkotlin/Function2;", "", "charAt", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lio/ktor/http/cio/internals/AsciiCharTree;", "", "Lio/ktor/http/cio/internals/AsciiCharTree$Node;", "resultList", "maxLength", "idx", "", "(Ljava/util/List;Ljava/util/List;IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final <T> void build(List<Node<T>> resultList, List<? extends T> from, int maxLength, int idx, Function1 length, Function2 charAt) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (T t : from) {
                Character ch = (Character) charAt.invoke(t, Integer.valueOf(idx));
                ch.charValue();
                Object arrayList = linkedHashMap.get(ch);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(ch, arrayList);
                }
                ((List) arrayList).add(t);
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                char cCharValue = ((Character) entry.getKey()).charValue();
                List list = (List) entry.getValue();
                int i = idx + 1;
                ArrayList arrayList2 = new ArrayList();
                Companion companion = AsciiCharTree.INSTANCE;
                ArrayList arrayList3 = new ArrayList();
                for (T t2 : list) {
                    if (((Number) length.invoke(t2)).intValue() > i) {
                        arrayList3.add(t2);
                    }
                }
                int i2 = maxLength;
                Function1 function1 = length;
                Function2 function2 = charAt;
                companion.build(arrayList2, arrayList3, i2, i, function1, function2);
                arrayList2.trimToSize();
                ArrayList arrayList4 = new ArrayList();
                for (T t3 : list) {
                    if (((Number) function1.invoke(t3)).intValue() == i) {
                        arrayList4.add(t3);
                    }
                }
                resultList.add(new Node<>(cCharValue, arrayList4, arrayList2));
                maxLength = i2;
                length = function1;
                charAt = function2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int build$lambda$0(CharSequence charSequence) {
            charSequence.getClass();
            return charSequence.length();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final char build$lambda$1(CharSequence charSequence, int i) {
            charSequence.getClass();
            return charSequence.charAt(i);
        }

        private Companion() {
        }

        public final <T> AsciiCharTree<T> build(List<? extends T> from, Function1 length, Function2 charAt) {
            T next;
            from.getClass();
            length.getClass();
            charAt.getClass();
            Iterator<T> it = from.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    Comparable comparable = (Comparable) length.invoke(next);
                    do {
                        T next2 = it.next();
                        Comparable comparable2 = (Comparable) length.invoke(next2);
                        if (comparable.compareTo(comparable2) < 0) {
                            next = next2;
                            comparable = comparable2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            if (next != null) {
                int iIntValue = ((Number) length.invoke(next)).intValue();
                if (!from.isEmpty()) {
                    Iterator<T> it2 = from.iterator();
                    while (it2.hasNext()) {
                        if (((Number) length.invoke(it2.next())).intValue() == 0) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("There should be no empty entries");
                            return null;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                build(arrayList, from, iIntValue, 0, length, charAt);
                arrayList.trimToSize();
                return new AsciiCharTree<>(new Node((char) 0, EmptyList.INSTANCE, arrayList));
            }
            PathKt$$ExternalSyntheticBUOutline0.m$1("Unable to build char tree from an empty list");
            return null;
        }

        public final <T extends CharSequence> AsciiCharTree<T> build(List<? extends T> from) {
            from.getClass();
            return build(from, new URLUtilsKt$$ExternalSyntheticLambda0((byte) 7), new HttpParserKt$$ExternalSyntheticLambda0((byte) 14));
        }
    }
}
