package com.metrolist.music.db;

import androidx.sqlite.SQLiteConnection;
import com.metrolist.music.db.entities.SongEntity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DatabaseDao_Impl$$ExternalSyntheticLambda19 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ DatabaseDao_Impl f$0;
    public final /* synthetic */ SongEntity f$1;

    public /* synthetic */ DatabaseDao_Impl$$ExternalSyntheticLambda19(DatabaseDao_Impl databaseDao_Impl, SongEntity songEntity, byte b) {
        this.$r8$classId = b;
        this.f$0 = databaseDao_Impl;
        this.f$1 = songEntity;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        SongEntity songEntity = this.f$1;
        DatabaseDao_Impl databaseDao_Impl = this.f$0;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        switch (b) {
            case 0:
                sQLiteConnection.getClass();
                databaseDao_Impl.__deleteAdapterOfSongEntity.handle(sQLiteConnection, songEntity);
                return unit;
            case 1:
                sQLiteConnection.getClass();
                databaseDao_Impl.__updateAdapterOfSongEntity.handle(sQLiteConnection, songEntity);
                return unit;
            case 2:
                sQLiteConnection.getClass();
                return Long.valueOf(databaseDao_Impl.__insertAdapterOfSongEntity.insertAndReturnId(sQLiteConnection, songEntity));
            default:
                sQLiteConnection.getClass();
                databaseDao_Impl.__upsertAdapterOfSongEntity.upsert(sQLiteConnection, songEntity);
                return unit;
        }
    }
}
