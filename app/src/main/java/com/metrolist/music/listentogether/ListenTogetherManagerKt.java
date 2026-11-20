package com.metrolist.music.listentogether;

import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.metrolist.music.db.DatabaseDao_Impl$$ExternalSyntheticLambda7;
import com.metrolist.music.listentogether.proto.Listentogether;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.io.LinesSequence;
import kotlin.sequences.DistinctIterator;
import kotlin.sequences.FilteringSequence;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ListenTogetherManagerKt {
    public static final ListBuilder canonicalPlaybackQueue(Listentogether.TrackInfo trackInfo, List list) {
        trackInfo.getClass();
        ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
        listBuilderCreateListBuilder.add(trackInfo);
        FilteringSequence filteringSequence = new FilteringSequence(new LinesSequence((byte) 2, list), true, new DiskLruCache$$ExternalSyntheticLambda0((byte) 22, trackInfo));
        DistinctIterator distinctIterator = new DistinctIterator(new FilteringSequence.AnonymousClass1(filteringSequence), new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 17));
        while (distinctIterator.hasNext()) {
            listBuilderCreateListBuilder.add((Listentogether.TrackInfo) distinctIterator.next());
        }
        return CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
    }
}
