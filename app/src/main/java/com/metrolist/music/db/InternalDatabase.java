package com.metrolist.music.db;

import androidx.room.RoomDatabase;
import com.metrolist.music.db.daos.SpeedDialDao_Impl;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/db/InternalDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public abstract class InternalDatabase extends RoomDatabase {
    public abstract DatabaseDao getDao();

    public abstract SpeedDialDao_Impl getSpeedDialDao();
}
