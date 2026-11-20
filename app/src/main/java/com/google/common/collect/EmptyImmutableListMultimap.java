package com.google.common.collect;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EmptyImmutableListMultimap extends ImmutableListMultimap {
    public static final EmptyImmutableListMultimap INSTANCE = new EmptyImmutableListMultimap(RegularImmutableMap.EMPTY, 0);

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final ImmutableMap asMap() {
        return this.map;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final Map asMap() {
        return this.map;
    }
}
