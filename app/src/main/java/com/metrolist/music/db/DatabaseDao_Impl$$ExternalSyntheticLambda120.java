package com.metrolist.music.db;

import androidx.sqlite.SQLiteConnection;
import com.metrolist.music.db.entities.AlbumArtistMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DatabaseDao_Impl$$ExternalSyntheticLambda120 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ DatabaseDao_Impl f$0;
    public final /* synthetic */ AlbumArtistMap f$1;

    public /* synthetic */ DatabaseDao_Impl$$ExternalSyntheticLambda120(DatabaseDao_Impl databaseDao_Impl, AlbumArtistMap albumArtistMap, byte b) {
        this.$r8$classId = b;
        this.f$0 = databaseDao_Impl;
        this.f$1 = albumArtistMap;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        AlbumArtistMap albumArtistMap = this.f$1;
        DatabaseDao_Impl databaseDao_Impl = this.f$0;
        SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
        switch (b) {
            case 0:
                sQLiteConnection.getClass();
                databaseDao_Impl.__insertAdapterOfAlbumArtistMap.insert(sQLiteConnection, albumArtistMap);
                break;
            default:
                sQLiteConnection.getClass();
                databaseDao_Impl.__deleteAdapterOfAlbumArtistMap.handle(sQLiteConnection, albumArtistMap);
                break;
        }
        return unit;
    }
}
