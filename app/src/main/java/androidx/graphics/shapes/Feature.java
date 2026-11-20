package androidx.graphics.shapes;

import androidx.room.RoomDatabase$$ExternalSyntheticLambda2;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Feature {
    public final List cubics;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Corner extends Feature {
        public final boolean convex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Corner(List list, boolean z) {
            super(list);
            list.getClass();
            this.convex = z;
        }

        public final String toString() {
            return "Corner: cubics=" + CollectionsKt.joinToString$default(this.cubics, ", ", null, null, new RoomDatabase$$ExternalSyntheticLambda2((byte) 3), 30) + " convex=" + this.convex;
        }

        @Override // androidx.graphics.shapes.Feature
        public final Feature transformed(PointTransformer pointTransformer) {
            ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
            List list = this.cubics;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                listBuilderCreateListBuilder.add(((Cubic) list.get(i)).transformed(pointTransformer));
            }
            return new Corner(CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder), this.convex);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Edge extends Feature {
        public final String toString() {
            return "Edge";
        }
    }

    public Feature(List list) {
        list.getClass();
        this.cubics = list;
    }

    public Feature transformed(PointTransformer pointTransformer) {
        ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
        List list = this.cubics;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            listBuilderCreateListBuilder.add(((Cubic) list.get(i)).transformed(pointTransformer));
        }
        ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
        listBuilderBuild.getClass();
        return new Edge(listBuilderBuild);
    }
}
