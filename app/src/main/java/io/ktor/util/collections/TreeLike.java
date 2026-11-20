package io.ktor.util.collections;

import io.ktor.util.collections.TreeLike;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.LinesSequence;
import kotlin.sequences.FlatteningSequence;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt$flatMap$2;
import kotlin.time.InstantKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0002\b\u0004\bf\u0018\u0000*\u0010\b\u0000\u0010\u0001 \u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tR\u0016\u0010\r\u001a\u0004\u0018\u00018\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lio/ktor/util/collections/TreeLike;", "T", "", "Lkotlin/sequences/Sequence;", "lineage", "()Lkotlin/sequences/Sequence;", "descendants", "", "isRoot", "()Z", "isLeaf", "getParent", "()Lio/ktor/util/collections/TreeLike;", "parent", "", "getChildren", "()Ljava/lang/Iterable;", "children", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface TreeLike<T extends TreeLike<? extends T>> {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T extends TreeLike<? extends T>> Sequence descendants(TreeLike<? extends T> treeLike) {
            return TreeLike.super.descendants();
        }

        @Deprecated
        public static <T extends TreeLike<? extends T>> boolean isLeaf(TreeLike<? extends T> treeLike) {
            return TreeLike.super.isLeaf();
        }

        @Deprecated
        public static <T extends TreeLike<? extends T>> boolean isRoot(TreeLike<? extends T> treeLike) {
            return TreeLike.super.isRoot();
        }

        @Deprecated
        public static <T extends TreeLike<? extends T>> Sequence lineage(TreeLike<? extends T> treeLike) {
            return TreeLike.super.lineage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static Sequence descendants$lambda$0(TreeLike treeLike) {
        treeLike.getClass();
        return SequencesKt.plus(new LinesSequence((byte) 4, treeLike), treeLike.descendants());
    }

    /* JADX INFO: Access modifiers changed from: private */
    static TreeLike lineage$lambda$0(TreeLike treeLike) {
        treeLike.getClass();
        return treeLike.getParent();
    }

    default Sequence descendants() {
        return new FlatteningSequence(CollectionsKt.asSequence(getChildren()), new InstantKt$$ExternalSyntheticLambda0((byte) 10), SequencesKt___SequencesKt$flatMap$2.INSTANCE);
    }

    Iterable<T> getChildren();

    T getParent();

    default boolean isLeaf() {
        return !getChildren().iterator().hasNext();
    }

    default boolean isRoot() {
        return getParent() == null;
    }

    default Sequence lineage() {
        return SequencesKt.generateSequence(this, new InstantKt$$ExternalSyntheticLambda0((byte) 9));
    }
}
