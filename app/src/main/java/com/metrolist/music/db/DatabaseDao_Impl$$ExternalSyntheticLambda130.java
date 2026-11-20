package com.metrolist.music.db;

import androidx.collection.ArrayMap;
import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.layout.WrapContentNode;
import androidx.compose.material3.SegmentedButtonContentMeasurePolicy;
import androidx.compose.material3.SegmentedButtonDefaults;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import coil3.util.FileSystemsKt;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.AlbumEntity;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.LinkHeader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DatabaseDao_Impl$$ExternalSyntheticLambda130 implements Function1 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ int f$4;
    public final /* synthetic */ int f$5;

    public /* synthetic */ DatabaseDao_Impl$$ExternalSyntheticLambda130(WrapContentNode wrapContentNode, int i, Placeable placeable, int i2, MeasureScope measureScope) {
        this.f$1 = wrapContentNode;
        this.f$4 = i;
        this.f$2 = placeable;
        this.f$5 = i2;
        this.f$3 = measureScope;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$5;
        Object obj2 = this.f$3;
        int iIntValue = this.f$4;
        Object obj3 = this.f$2;
        Object obj4 = this.f$1;
        switch (b) {
            case 0:
                DatabaseDao_Impl databaseDao_Impl = (DatabaseDao_Impl) obj4;
                LocalDateTime localDateTime = (LocalDateTime) obj3;
                LocalDateTime localDateTime2 = (LocalDateTime) obj2;
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("\n    SELECT album.*,\n           COUNT(DISTINCT song_album_map.songId) as downloadCount,\n           (SELECT COUNT(1)\n            FROM song_album_map\n                     JOIN event e ON song_album_map.songId = e.songId\n            WHERE albumId = album.id\n              AND e.timestamp > ?\n              AND e.timestamp <= ?) AS songCountListened,\n           (SELECT SUM(e.playTime)\n            FROM song_album_map\n                     JOIN event e ON song_album_map.songId = e.songId\n            WHERE albumId = album.id\n              AND e.timestamp > ?\n              AND e.timestamp <= ?) AS timeListened\n    FROM album\n    JOIN song_album_map ON album.id = song_album_map.albumId\n    WHERE album.id IN (\n        SELECT sam.albumId\n        FROM event\n                 JOIN song_album_map sam ON event.songId = sam.songId\n        WHERE event.timestamp > ?\n          AND event.timestamp <= ?\n        GROUP BY sam.albumId\n        HAVING sam.albumId IS NOT NULL\n    )\n    GROUP BY album.id\n    ORDER BY timeListened DESC\n    LIMIT ? OFFSET ?\n    ");
                try {
                    Long lDateToTimestamp = Converters.dateToTimestamp(localDateTime);
                    if (lDateToTimestamp == null) {
                        sQLiteStatementPrepare.bindNull(1);
                    } else {
                        sQLiteStatementPrepare.bindLong(1, lDateToTimestamp.longValue());
                    }
                    Long lDateToTimestamp2 = Converters.dateToTimestamp(localDateTime2);
                    if (lDateToTimestamp2 == null) {
                        sQLiteStatementPrepare.bindNull(2);
                    } else {
                        sQLiteStatementPrepare.bindLong(2, lDateToTimestamp2.longValue());
                    }
                    Long lDateToTimestamp3 = Converters.dateToTimestamp(localDateTime);
                    if (lDateToTimestamp3 == null) {
                        sQLiteStatementPrepare.bindNull(3);
                    } else {
                        sQLiteStatementPrepare.bindLong(3, lDateToTimestamp3.longValue());
                    }
                    Long lDateToTimestamp4 = Converters.dateToTimestamp(localDateTime2);
                    if (lDateToTimestamp4 == null) {
                        sQLiteStatementPrepare.bindNull(4);
                    } else {
                        sQLiteStatementPrepare.bindLong(4, lDateToTimestamp4.longValue());
                    }
                    Long lDateToTimestamp5 = Converters.dateToTimestamp(localDateTime);
                    if (lDateToTimestamp5 == null) {
                        sQLiteStatementPrepare.bindNull(5);
                    } else {
                        sQLiteStatementPrepare.bindLong(5, lDateToTimestamp5.longValue());
                    }
                    Long lDateToTimestamp6 = Converters.dateToTimestamp(localDateTime2);
                    if (lDateToTimestamp6 == null) {
                        sQLiteStatementPrepare.bindNull(6);
                    } else {
                        sQLiteStatementPrepare.bindLong(6, lDateToTimestamp6.longValue());
                    }
                    sQLiteStatementPrepare.bindLong(7, iIntValue);
                    sQLiteStatementPrepare.bindLong(8, i);
                    int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                    int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "playlistId");
                    int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, LinkHeader.Parameters.Title);
                    int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "year");
                    int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "thumbnailUrl");
                    int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "themeColor");
                    int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "songCount");
                    int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "duration");
                    int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "explicit");
                    int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "lastUpdateTime");
                    int columnIndexOrThrow11 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "bookmarkedAt");
                    int columnIndexOrThrow12 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "likedDate");
                    int columnIndexOrThrow13 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "inLibrary");
                    int columnIndexOrThrow14 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isLocal");
                    int columnIndexOrThrow15 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isUploaded");
                    int columnIndexOrThrow16 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "songCountListened");
                    int i2 = columnIndexOrThrow12;
                    int columnIndexOrThrow17 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "timeListened");
                    int i3 = columnIndexOrThrow11;
                    int i4 = columnIndexOrThrow10;
                    ArrayMap arrayMap = new ArrayMap(0);
                    while (sQLiteStatementPrepare.step()) {
                        String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                        if (!arrayMap.containsKey(text)) {
                            arrayMap.put(text, new ArrayList());
                            columnIndexOrThrow9 = columnIndexOrThrow9;
                        }
                    }
                    int i5 = columnIndexOrThrow9;
                    sQLiteStatementPrepare.reset();
                    databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity_1(sQLiteConnection, arrayMap);
                    ArrayList arrayList = new ArrayList();
                    while (sQLiteStatementPrepare.step()) {
                        Integer numValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow16) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow16));
                        Long lValueOf = sQLiteStatementPrepare.isNull(columnIndexOrThrow17) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow17));
                        String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                        String text3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow2) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                        String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                        Integer numValueOf2 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow4));
                        String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                        Integer numValueOf3 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6));
                        int i6 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7);
                        int i7 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8);
                        int i8 = columnIndexOrThrow5;
                        int i9 = i5;
                        int i10 = columnIndexOrThrow4;
                        boolean z = ((int) sQLiteStatementPrepare.getLong(i9)) != 0;
                        int i11 = i4;
                        LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i11) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i11)));
                        if (localDateTimeFromTimestamp == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                        }
                        int i12 = i3;
                        LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i12) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i12)));
                        int i13 = i2;
                        LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i13) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i13)));
                        i2 = i13;
                        int i14 = columnIndexOrThrow13;
                        LocalDateTime localDateTimeFromTimestamp4 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i14) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i14)));
                        columnIndexOrThrow13 = i14;
                        int i15 = columnIndexOrThrow14;
                        i4 = i11;
                        int i16 = columnIndexOrThrow15;
                        AlbumEntity albumEntity = new AlbumEntity(text2, text3, text4, numValueOf2, text5, numValueOf3, i6, i7, z, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, localDateTimeFromTimestamp3, localDateTimeFromTimestamp4, ((int) sQLiteStatementPrepare.getLong(i15)) != 0, ((int) sQLiteStatementPrepare.getLong(i16)) != 0);
                        Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                        value.getClass();
                        arrayList.add(new Album(albumEntity, (List) value, numValueOf, lValueOf));
                        i3 = i12;
                        columnIndexOrThrow4 = i10;
                        columnIndexOrThrow3 = columnIndexOrThrow3;
                        columnIndexOrThrow5 = i8;
                        i5 = i9;
                        columnIndexOrThrow14 = i15;
                        columnIndexOrThrow15 = i16;
                        columnIndexOrThrow2 = columnIndexOrThrow2;
                    }
                    sQLiteStatementPrepare.close();
                    return arrayList;
                } catch (Throwable th) {
                    sQLiteStatementPrepare.close();
                    throw th;
                }
            case 1:
                Placeable placeable = (Placeable) obj3;
                Placeable.PlacementScope.m619place70tqf50$default((Placeable.PlacementScope) obj, placeable, ((IntOffset) ((WrapContentNode) obj4).alignmentCallback.invoke(new IntSize((((long) (iIntValue - placeable.width)) << 32) | (((long) (i - placeable.height)) & 4294967295L)), ((MeasureScope) obj2).getLayoutDirection())).packedValue);
                return unit;
            default:
                ArrayList arrayList2 = (ArrayList) obj4;
                SegmentedButtonContentMeasurePolicy segmentedButtonContentMeasurePolicy = (SegmentedButtonContentMeasurePolicy) obj3;
                ArrayList arrayList3 = (ArrayList) obj2;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                int size = arrayList2.size();
                for (int i17 = 0; i17 < size; i17++) {
                    Placeable placeable2 = (Placeable) arrayList2.get(i17);
                    placementScope.place(placeable2, 0, (i - placeable2.height) / 2, CropImageView.DEFAULT_ASPECT_RATIO);
                }
                SegmentedButtonDefaults segmentedButtonDefaults = SegmentedButtonDefaults.INSTANCE;
                int iMo75roundToPx0680j_4 = placementScope.mo75roundToPx0680j_4(8.0f) + placementScope.mo75roundToPx0680j_4(18.0f);
                Animatable animatable = segmentedButtonContentMeasurePolicy.animatable;
                if (animatable != null) {
                    iIntValue = ((Number) animatable.getValue()).intValue();
                }
                int i18 = iMo75roundToPx0680j_4 + iIntValue;
                int size2 = arrayList3.size();
                for (int i19 = 0; i19 < size2; i19++) {
                    Placeable placeable3 = (Placeable) arrayList3.get(i19);
                    placementScope.place(placeable3, i18, (i - placeable3.height) / 2, CropImageView.DEFAULT_ASPECT_RATIO);
                }
                return unit;
        }
    }

    public /* synthetic */ DatabaseDao_Impl$$ExternalSyntheticLambda130(DatabaseDao_Impl databaseDao_Impl, LocalDateTime localDateTime, LocalDateTime localDateTime2, int i, int i2) {
        this.f$1 = databaseDao_Impl;
        this.f$2 = localDateTime;
        this.f$3 = localDateTime2;
        this.f$4 = i;
        this.f$5 = i2;
    }

    public /* synthetic */ DatabaseDao_Impl$$ExternalSyntheticLambda130(ArrayList arrayList, SegmentedButtonContentMeasurePolicy segmentedButtonContentMeasurePolicy, int i, ArrayList arrayList2, int i2) {
        this.f$1 = arrayList;
        this.f$2 = segmentedButtonContentMeasurePolicy;
        this.f$4 = i;
        this.f$3 = arrayList2;
        this.f$5 = i2;
    }
}
