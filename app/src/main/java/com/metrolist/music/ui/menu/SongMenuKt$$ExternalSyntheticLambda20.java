package com.metrolist.music.ui.menu;

import android.content.Context;
import android.net.Uri;
import androidx.collection.ArrayMap;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxMeasurePolicy;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda17;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$lambda$3$0$$inlined$onDispose$1;
import androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$1;
import androidx.compose.ui.window.PopupLayout;
import androidx.compose.ui.window.PopupProperties;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import coil3.util.FileSystemsKt;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda59;
import com.metrolist.music.db.Converters;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.Event;
import com.metrolist.music.db.entities.EventWithSong;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.eq.data.SavedEQProfile;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.alarm.MusicAlarmEntry;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda97;
import com.metrolist.music.ui.screens.StatsScreenKt$StatsScreen$6$1$1$10$2$1$1;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt$$ExternalSyntheticLambda21;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$$ExternalSyntheticLambda20 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda20(CoroutineScope coroutineScope, Mutex mutex, Context context, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        this.$r8$classId = (byte) 8;
        this.f$1 = coroutineScope;
        this.f$0 = mutex;
        this.f$2 = context;
        this.f$5 = mutableState;
        this.f$3 = mutableState2;
        this.f$4 = mutableState3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v0, types: [byte] */
    /* JADX WARN: Type inference failed for: r8v1, types: [int] */
    /* JADX WARN: Type inference failed for: r8v3, types: [int] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        byte b = this.$r8$classId;
        byte b2 = 5;
        byte b3 = 15;
        Unit unit = Unit.INSTANCE;
        ?? r8 = 0;
        int i = 0;
        Object obj2 = this.f$4;
        Object obj3 = this.f$3;
        Object obj4 = this.f$5;
        Object obj5 = this.f$2;
        Object obj6 = this.f$0;
        Object obj7 = this.f$1;
        switch (b) {
            case 0:
                Song song = (Song) obj6;
                CoroutineScope coroutineScope = (CoroutineScope) obj7;
                MusicDatabase musicDatabase = (MusicDatabase) obj5;
                PlayerConnection playerConnection = (PlayerConnection) obj3;
                Function0 function0 = (Function0) obj2;
                MutableState mutableState = (MutableState) obj4;
                List list = (List) obj;
                list.getClass();
                String str = (String) list.get(0);
                List listSplit$default = StringsKt.split$default((CharSequence) list.get(1), new char[]{','});
                ?? arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
                Iterator it = listSplit$default.iterator();
                while (it.hasNext()) {
                    arrayList.add(StringsKt.trim((String) it.next()).toString());
                }
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                while (r8 < size) {
                    Object obj8 = arrayList.get(r8);
                    r8++;
                    if (((String) obj8).length() > 0) {
                        arrayList2.add(obj8);
                    }
                }
                ?? list2 = CollectionsKt.toList(CollectionsKt.toMutableSet(arrayList2));
                List orderedArtists = song.getOrderedArtists();
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(orderedArtists, 10));
                Iterator it2 = orderedArtists.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(((ArtistEntity) it2.next()).name);
                }
                AwaitKt.launch$default(coroutineScope, null, null, new SongMenuKt$SongMenu$2$1$1(musicDatabase, song, playerConnection, function0, str, !list2.equals(arrayList3), list2, mutableState, null), 3);
                return unit;
            case 1:
                Placeable[] placeableArr = (Placeable[]) obj6;
                List list3 = (List) obj7;
                MeasureScope measureScope = (MeasureScope) obj5;
                Ref$IntRef ref$IntRef = (Ref$IntRef) obj3;
                Ref$IntRef ref$IntRef2 = (Ref$IntRef) obj2;
                BoxMeasurePolicy boxMeasurePolicy = (BoxMeasurePolicy) obj4;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                int length = placeableArr.length;
                int i2 = 0;
                while (i < length) {
                    Placeable placeable = placeableArr[i];
                    placeable.getClass();
                    BoxKt.placeInBox(placementScope, placeable, (Measurable) list3.get(i2), measureScope.getLayoutDirection(), ref$IntRef.element, ref$IntRef2.element, boxMeasurePolicy.alignment);
                    i++;
                    i2++;
                }
                return unit;
            case 2:
                PopupLayout popupLayout = (PopupLayout) obj6;
                popupLayout.windowManager.addView(popupLayout, popupLayout.params);
                popupLayout.updateParameters((Function0) obj2, (PopupProperties) obj7, (String) obj5, (LayoutDirection) obj3, (Density) obj4);
                return new AndroidPopup_androidKt$Popup$lambda$3$0$$inlined$onDispose$1(r8, popupLayout);
            case 3:
                DatabaseDao_Impl databaseDao_Impl = (DatabaseDao_Impl) obj6;
                LocalDateTime localDateTime = (LocalDateTime) obj7;
                LocalDateTime localDateTime2 = (LocalDateTime) obj5;
                LocalDateTime localDateTime3 = (LocalDateTime) obj3;
                LocalDateTime localDateTime4 = (LocalDateTime) obj2;
                LocalDateTime localDateTime5 = (LocalDateTime) obj4;
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("\n        SELECT event.*\n        FROM event\n        JOIN (\n            SELECT MAX(id) AS id\n            FROM event\n            GROUP BY songId,\n                CASE\n                    WHEN timestamp >= ? THEN 'this_week'\n                    WHEN timestamp >= ? THEN 'today'\n                    WHEN timestamp >= ? THEN 'yesterday'\n                    WHEN timestamp >= ? THEN 'this_week'\n                    WHEN timestamp >= ? THEN 'last_week'\n                    ELSE strftime('%Y-%m', timestamp / 1000, 'unixepoch')\n                END\n        ) AS latest_event ON latest_event.id = event.id\n        ORDER BY event.id DESC\n        ");
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
                    Long lDateToTimestamp3 = Converters.dateToTimestamp(localDateTime3);
                    if (lDateToTimestamp3 == null) {
                        sQLiteStatementPrepare.bindNull(3);
                    } else {
                        sQLiteStatementPrepare.bindLong(3, lDateToTimestamp3.longValue());
                    }
                    Long lDateToTimestamp4 = Converters.dateToTimestamp(localDateTime4);
                    if (lDateToTimestamp4 == null) {
                        sQLiteStatementPrepare.bindNull(4);
                    } else {
                        sQLiteStatementPrepare.bindLong(4, lDateToTimestamp4.longValue());
                    }
                    Long lDateToTimestamp5 = Converters.dateToTimestamp(localDateTime5);
                    if (lDateToTimestamp5 == null) {
                        sQLiteStatementPrepare.bindNull(5);
                    } else {
                        sQLiteStatementPrepare.bindLong(5, lDateToTimestamp5.longValue());
                    }
                    int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                    int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "songId");
                    int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "timestamp");
                    int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "playTime");
                    ArrayMap arrayMap = new ArrayMap(0);
                    while (sQLiteStatementPrepare.step()) {
                        arrayMap.put(sQLiteStatementPrepare.getText(columnIndexOrThrow2), null);
                    }
                    sQLiteStatementPrepare.reset();
                    databaseDao_Impl.__fetchRelationshipsongAscomMetrolistMusicDbEntitiesSong(sQLiteConnection, arrayMap);
                    ArrayList arrayList4 = new ArrayList();
                    while (sQLiteStatementPrepare.step()) {
                        long j = sQLiteStatementPrepare.getLong(columnIndexOrThrow);
                        String text = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                        LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow3)));
                        if (localDateTimeFromTimestamp == null) {
                            throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDateTime', but it was NULL.");
                        }
                        Event event = new Event(j, text, localDateTimeFromTimestamp, sQLiteStatementPrepare.getLong(columnIndexOrThrow4));
                        Song song2 = (Song) arrayMap.get(sQLiteStatementPrepare.getText(columnIndexOrThrow2));
                        if (song2 == null) {
                            throw new IllegalStateException("Relationship item 'song' was expected to be NON-NULL but is NULL in @Relation involving a parent column named 'songId' and entityColumn named 'id'.");
                        }
                        arrayList4.add(new EventWithSong(event, song2));
                    }
                    sQLiteStatementPrepare.close();
                    return arrayList4;
                } catch (Throwable th) {
                    sQLiteStatementPrepare.close();
                    throw th;
                }
            case 4:
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                List list4 = (List) ((State) obj6).getValue();
                lazyListIntervalContent.items(list4.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new HomeScreenKt$$ExternalSyntheticLambda97(b3), list4, (byte) 24), new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list4, (byte) 26), new ComposableLambdaImpl(true, 2039820996, new LyricsMenuKt$LyricsMenu$lambda$39$0$$inlined$itemsIndexed$default$3(list4, (HapticFeedback) obj7, (MenuState) obj5, (NavHostController) obj3, (State) obj2, (State) obj4, (byte) 2)));
                return unit;
            case 5:
                String str2 = (String) obj5;
                Function1 function1 = (Function1) obj3;
                Function1 function2 = (Function1) obj4;
                Function0 function3 = (Function0) obj2;
                LazyListIntervalContent lazyListIntervalContent2 = (LazyListIntervalContent) obj;
                lazyListIntervalContent2.getClass();
                LazyListIntervalContent.item$default(lazyListIntervalContent2, null, null, new ComposableLambdaImpl(true, 1921137996, new ListItemKt$$ExternalSyntheticLambda17(b3, (SavedEQProfile) obj7)), 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent2, null, null, new ComposableLambdaImpl(true, 1331860213, new PlaylistScreenMenusKt$$ExternalSyntheticLambda1(str2, function1)), 3);
                ArrayList arrayList5 = new ArrayList();
                for (Object obj9 : (List) obj6) {
                    if (((SavedEQProfile) obj9).isCustom) {
                        arrayList5.add(obj9);
                    }
                }
                if (!arrayList5.isEmpty()) {
                    lazyListIntervalContent2.items(arrayList5.size(), null, new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList5, (byte) 25), new ComposableLambdaImpl(true, 802480018, new YouTubeSongMenuKt$YouTubeSongMenu$lambda$16$0$$inlined$items$default$4(arrayList5, str2, function1, function2, (byte) 1)));
                }
                if (arrayList5.isEmpty()) {
                    LazyListIntervalContent.item$default(lazyListIntervalContent2, null, null, new ComposableLambdaImpl(true, -11473478, new PlayerMenuKt$$ExternalSyntheticLambda49(function3, b2)), 3);
                }
                return unit;
            case 6:
                FocusOwner focusOwner = (FocusOwner) obj6;
                NavHostController navHostController = (NavHostController) obj3;
                MutableState mutableState2 = (MutableState) obj4;
                CoroutineScope coroutineScope2 = (CoroutineScope) obj7;
                MutableState mutableState3 = (MutableState) obj2;
                MusicDatabase musicDatabase2 = (MusicDatabase) obj5;
                String str3 = (String) obj;
                str3.getClass();
                if (str3.length() > 0) {
                    mutableState2.setValue(Boolean.FALSE);
                    ((FocusOwnerImpl) focusOwner).m409clearFocusI7lrPNg(8, false, true);
                    navHostController.navigate(Fragment$5$$ExternalSyntheticOutline0.m("search/", Uri.encode("__metrolist_search_query__".concat(str3))), new MainActivity$$ExternalSyntheticLambda59(coroutineScope2, mutableState3, musicDatabase2, str3));
                }
                return unit;
            case 7:
                Map map = (Map) obj6;
                Map map2 = (Map) obj7;
                MutableState mutableState4 = (MutableState) obj4;
                MutableState mutableState5 = (MutableState) obj3;
                MutableState mutableState6 = (MutableState) obj2;
                String str4 = (String) obj;
                str4.getClass();
                ((DataStoreKt$rememberPreference$1$1) obj5).setValue(str4);
                if (str4.equals("Custom") || str4.equals("DeepL")) {
                    mutableState4.setValue("");
                } else {
                    String str5 = (String) map.get(str4);
                    if (str5 == null) {
                        str5 = "";
                    }
                    mutableState4.setValue(str5);
                }
                List list5 = (List) map2.get(str4);
                if (list5 == null) {
                    list5 = EmptyList.INSTANCE;
                }
                mutableState5.setValue(list5.isEmpty() ? "" : (String) list5.get(0));
                mutableState6.setValue(Boolean.FALSE);
                return unit;
            default:
                MusicAlarmEntry musicAlarmEntry = (MusicAlarmEntry) obj;
                musicAlarmEntry.getClass();
                AwaitKt.launch$default((CoroutineScope) obj7, null, null, new DownloadUtil.AnonymousClass1((Mutex) obj6, new AlarmSettingsKt$$ExternalSyntheticLambda21(musicAlarmEntry, (byte) 0), (Context) obj5, (MutableState) obj4, null), 3);
                ((MutableState) obj3).setValue(Boolean.FALSE);
                ((MutableState) obj2).setValue(null);
                return unit;
        }
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda20(PopupLayout popupLayout, Function0 function0, PopupProperties popupProperties, String str, LayoutDirection layoutDirection, Density density) {
        this.$r8$classId = (byte) 2;
        this.f$0 = popupLayout;
        this.f$4 = function0;
        this.f$1 = popupProperties;
        this.f$2 = str;
        this.f$3 = layoutDirection;
        this.f$5 = density;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda20(SavedEQProfile savedEQProfile, String str, List list, Function0 function0, Function1 function1, Function1 function2) {
        this.$r8$classId = (byte) 5;
        this.f$0 = list;
        this.f$1 = savedEQProfile;
        this.f$2 = str;
        this.f$3 = function1;
        this.f$5 = function2;
        this.f$4 = function0;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda20(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
        this.f$4 = obj5;
        this.f$5 = obj6;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda20(Map map, Map map2, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$2, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$3, MutableState mutableState) {
        this.$r8$classId = (byte) 7;
        this.f$0 = map;
        this.f$1 = map2;
        this.f$2 = dataStoreKt$rememberPreference$1$1;
        this.f$5 = dataStoreKt$rememberPreference$1$2;
        this.f$3 = dataStoreKt$rememberPreference$1$3;
        this.f$4 = mutableState;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda20(FocusOwner focusOwner, NavHostController navHostController, MutableState mutableState, CoroutineScope coroutineScope, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1, MusicDatabase musicDatabase) {
        this.$r8$classId = (byte) 6;
        this.f$0 = focusOwner;
        this.f$3 = navHostController;
        this.f$5 = mutableState;
        this.f$1 = coroutineScope;
        this.f$4 = dataStoreKt$rememberPreference$1$1;
        this.f$2 = musicDatabase;
    }
}
