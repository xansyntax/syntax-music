package com.metrolist.music.listentogether;

import com.metrolist.music.db.DatabaseDao_Impl$$ExternalSyntheticLambda7;
import com.metrolist.music.db.entities.CachedItem$$ExternalSyntheticLambda0;
import kotlin.SynchronizedLazyImpl;
import kotlin.uuid.UuidKt;
import kotlinx.serialization.json.JsonImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ListenTogetherServers {
    public static final JsonImpl json = UuidKt.Json$default(new DatabaseDao_Impl$$ExternalSyntheticLambda7((byte) 18));
    public static final SynchronizedLazyImpl servers$delegate = new SynchronizedLazyImpl(new CachedItem$$ExternalSyntheticLambda0((byte) 6));
}
