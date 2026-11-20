package kotlin.io;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.pager.MeasuredPage;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.DatabaseDao$$ExternalSyntheticLambda0;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Song;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.plugins.compression.ContentEncodingKt;
import io.ktor.client.statement.HttpResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextStreamsKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ArrayList f$0;

    public /* synthetic */ TextStreamsKt$$ExternalSyntheticLambda0(ArrayList arrayList, byte b) {
        this.$r8$classId = b;
        this.f$0 = arrayList;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        byte b2 = 0;
        int i = 0;
        int i2 = 0;
        Unit unit = Unit.INSTANCE;
        ArrayList arrayList = this.f$0;
        switch (b) {
            case 0:
                String str = (String) obj;
                str.getClass();
                arrayList.add(str);
                return unit;
            case 1:
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    placementScope.place((Placeable) arrayList.get(i3), 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                }
                return unit;
            case 2:
                Placeable.PlacementScope placementScope2 = (Placeable.PlacementScope) obj;
                int size2 = arrayList.size();
                int i4 = 0;
                while (i4 < size2) {
                    MeasuredPage measuredPage = (MeasuredPage) arrayList.get(i4);
                    List list = measuredPage.placeables;
                    boolean z = measuredPage.isVertical;
                    if (measuredPage.mainAxisLayoutSize == Integer.MIN_VALUE) {
                        InlineClassHelperKt.throwIllegalArgumentException("position() should be called first");
                    }
                    int size3 = list.size();
                    int i5 = b2;
                    while (i5 < size3) {
                        Placeable placeable = (Placeable) list.get(i5);
                        int[] iArr = measuredPage.placeableOffsets;
                        int i6 = i5 * 2;
                        Unit unit2 = unit;
                        long jM806plusqkQi6aY = IntOffset.m806plusqkQi6aY((((long) iArr[i6 + 1]) & 4294967295L) | (((long) iArr[i6]) << 32), measuredPage.visualOffset);
                        if (z) {
                            Placeable.PlacementScope.m622placeWithLayeraW9wM$default(placementScope2, placeable, jM806plusqkQi6aY);
                        } else {
                            Placeable.PlacementScope.m620placeRelativeWithLayeraW9wM$default(placementScope2, placeable, jM806plusqkQi6aY);
                        }
                        i5++;
                        unit = unit2;
                    }
                    i4++;
                    b2 = 0;
                }
                return unit;
            case 3:
                Placeable.PlacementScope placementScope3 = (Placeable.PlacementScope) obj;
                int size4 = arrayList.size();
                for (int i7 = 0; i7 < size4; i7++) {
                    Placeable.PlacementScope.placeRelative$default(placementScope3, (Placeable) arrayList.get(i7), 0, 0);
                }
                return unit;
            case 4:
                Placeable.PlacementScope placementScope4 = (Placeable.PlacementScope) obj;
                int size5 = arrayList.size();
                for (int i8 = 0; i8 < size5; i8++) {
                    placementScope4.place((Placeable) arrayList.get(i8), 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                }
                return unit;
            case 5:
                Placeable.PlacementScope placementScope5 = (Placeable.PlacementScope) obj;
                int size6 = arrayList.size();
                for (int i9 = 0; i9 < size6; i9++) {
                    Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope5, (Placeable) arrayList.get(i9), 0, 0, null, 12);
                }
                return unit;
            case 6:
                Placeable.PlacementScope placementScope6 = (Placeable.PlacementScope) obj;
                int size7 = arrayList.size();
                for (int i10 = 0; i10 < size7; i10++) {
                    Placeable.PlacementScope.placeRelative$default(placementScope6, (Placeable) arrayList.get(i10), 0, 0);
                }
                return unit;
            case 7:
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                musicDatabase.getClass();
                int size8 = arrayList.size();
                while (i2 < size8) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    musicDatabase.inLibrary(((Song) obj2).song.id, null);
                }
                return unit;
            case 8:
                MusicDatabase musicDatabase2 = (MusicDatabase) obj;
                musicDatabase2.getClass();
                int size9 = arrayList.size();
                int i11 = 0;
                while (i11 < size9) {
                    Object obj3 = arrayList.get(i11);
                    i11++;
                    Song song = (Song) obj3;
                    musicDatabase2.insert(HexFormatKt.toMediaMetadata(song), new DatabaseDao$$ExternalSyntheticLambda0(b2));
                    musicDatabase2.inLibrary(song.song.id, LocalDateTime.now());
                }
                return unit;
            case 9:
                MusicDatabase musicDatabase3 = (MusicDatabase) obj;
                musicDatabase3.getClass();
                int size10 = arrayList.size();
                while (i < size10) {
                    Object obj4 = arrayList.get(i);
                    i++;
                    musicDatabase3.inLibrary(((SongItem) obj4).id, null);
                }
                return unit;
            case 10:
                MusicDatabase musicDatabase4 = (MusicDatabase) obj;
                musicDatabase4.getClass();
                int size11 = arrayList.size();
                int i12 = 0;
                while (i12 < size11) {
                    Object obj5 = arrayList.get(i12);
                    i12++;
                    SongItem songItem = (SongItem) obj5;
                    musicDatabase4.insert(HexFormatKt.toMediaMetadata(songItem), new DatabaseDao$$ExternalSyntheticLambda0(b2));
                    musicDatabase4.inLibrary(songItem.id, LocalDateTime.now());
                }
                return unit;
            case 11:
                return ContentEncodingKt.ContentEncoding$lambda$0$decode$5(arrayList, (HttpResponse) obj);
            default:
                String str2 = (String) obj;
                str2.getClass();
                arrayList.add(str2);
                return unit;
        }
    }
}
