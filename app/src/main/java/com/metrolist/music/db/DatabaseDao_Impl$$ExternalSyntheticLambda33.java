package com.metrolist.music.db;

import androidx.collection.ArrayMap;
import androidx.sqlite.SQLiteConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DatabaseDao_Impl$$ExternalSyntheticLambda33 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ DatabaseDao_Impl f$0;
    public final /* synthetic */ SQLiteConnection f$1;

    public /* synthetic */ DatabaseDao_Impl$$ExternalSyntheticLambda33(DatabaseDao_Impl databaseDao_Impl, SQLiteConnection sQLiteConnection, byte b) {
        this.$r8$classId = b;
        this.f$0 = databaseDao_Impl;
        this.f$1 = sQLiteConnection;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        SQLiteConnection sQLiteConnection = this.f$1;
        DatabaseDao_Impl databaseDao_Impl = this.f$0;
        ArrayMap arrayMap = (ArrayMap) obj;
        switch (b) {
            case 0:
                arrayMap.getClass();
                databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap);
                break;
            case 1:
                arrayMap.getClass();
                databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity_1(sQLiteConnection, arrayMap);
                break;
            case 2:
                arrayMap.getClass();
                databaseDao_Impl.__fetchRelationshipsongAscomMetrolistMusicDbEntitiesSong_1(sQLiteConnection, arrayMap);
                break;
            case 3:
                arrayMap.getClass();
                databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap);
                break;
            case 4:
                arrayMap.getClass();
                databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap);
                break;
            case 5:
                arrayMap.getClass();
                databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap);
                break;
            case 6:
                arrayMap.getClass();
                databaseDao_Impl.__fetchRelationshipsongAscomMetrolistMusicDbEntitiesSong(sQLiteConnection, arrayMap);
                break;
            default:
                arrayMap.getClass();
                databaseDao_Impl.__fetchRelationshipsongAsjavaLangString(sQLiteConnection, arrayMap);
                break;
        }
        return unit;
    }
}
