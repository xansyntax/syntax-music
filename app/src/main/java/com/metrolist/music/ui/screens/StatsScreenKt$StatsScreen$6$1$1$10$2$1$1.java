package com.metrolist.music.ui.screens;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.Artist;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda0;
import com.metrolist.music.db.entities.EventWithSong;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda4;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StatsScreenKt$StatsScreen$6$1$1$10$2$1$1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object $toggleArtistSelection;
    public final /* synthetic */ Object $uiArtist;

    public /* synthetic */ StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.$toggleArtistSelection = obj;
        this.$uiArtist = obj2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.$uiArtist;
        Object obj3 = this.$toggleArtistSelection;
        switch (b) {
            case 0:
                ((Boolean) obj).getClass();
                ((Function1) obj3).invoke((Artist) obj2);
                return unit;
            case 1:
                EventWithSong eventWithSong = (EventWithSong) obj2;
                List list = (List) obj3;
                if (((Boolean) obj).booleanValue()) {
                    list.add(Long.valueOf(eventWithSong.event.id));
                } else {
                    list.remove(Long.valueOf(eventWithSong.event.id));
                }
                return unit;
            case 2:
                int iIntValue = ((Number) obj).intValue();
                return ((MainActivity$$ExternalSyntheticLambda0) obj3).invoke(Integer.valueOf(iIntValue), ((List) obj2).get(iIntValue));
            case 3:
                int iIntValue2 = ((Number) obj).intValue();
                return ((MainActivity$$ExternalSyntheticLambda0) obj3).invoke(Integer.valueOf(iIntValue2), ((List) obj2).get(iIntValue2));
            case 4:
                return ((QueueKt$$ExternalSyntheticLambda4) obj3).invoke(((ArrayList) obj2).get(((Number) obj).intValue()));
            case 5:
                return ((QueueKt$$ExternalSyntheticLambda4) obj3).invoke(((ArrayList) obj2).get(((Number) obj).intValue()));
            case 6:
                return ((QueueKt$$ExternalSyntheticLambda4) obj3).invoke(((ArrayList) obj2).get(((Number) obj).intValue()));
            case 7:
                return ((QueueKt$$ExternalSyntheticLambda4) obj3).invoke(((ArrayList) obj2).get(((Number) obj).intValue()));
            case 8:
                return ((QueueKt$$ExternalSyntheticLambda4) obj3).invoke(((ArrayList) obj2).get(((Number) obj).intValue()));
            case 9:
                return ((QueueKt$$ExternalSyntheticLambda4) obj3).invoke(((ArrayList) obj2).get(((Number) obj).intValue()));
            case 10:
                return ((QueueKt$$ExternalSyntheticLambda4) obj3).invoke(((ArrayList) obj2).get(((Number) obj).intValue()));
            case 11:
                return ((HomeScreenKt$$ExternalSyntheticLambda104) obj3).invoke(((ArrayList) obj2).get(((Number) obj).intValue()));
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return ((HomeScreenKt$$ExternalSyntheticLambda104) obj3).invoke(((ArrayList) obj2).get(((Number) obj).intValue()));
            case 13:
                return ((QueueKt$$ExternalSyntheticLambda4) obj3).invoke(((ArrayList) obj2).get(((Number) obj).intValue()));
            case 14:
                int iIntValue3 = ((Number) obj).intValue();
                return ((HomeScreenKt$$ExternalSyntheticLambda97) obj3).invoke(Integer.valueOf(iIntValue3), ((List) obj2).get(iIntValue3));
            case 15:
                ((QueueKt$$ExternalSyntheticLambda4) obj3).invoke(((List) obj2).get(((Number) obj).intValue()));
                return "community_playlist";
            case 16:
                return ((QueueKt$$ExternalSyntheticLambda4) obj3).invoke(((ArrayList) obj2).get(((Number) obj).intValue()));
            case 17:
                return ((StatsScreenKt$$ExternalSyntheticLambda6) obj3).invoke(((List) obj2).get(((Number) obj).intValue()));
            case 18:
                ((StatsScreenKt$$ExternalSyntheticLambda6) obj3).invoke(((List) obj2).get(((Number) obj).intValue()));
                return "grid_item";
            case 19:
                return ((StatsScreenKt$$ExternalSyntheticLambda6) obj3).invoke(((ArrayList) obj2).get(((Number) obj).intValue()));
            case 20:
                ((StatsScreenKt$$ExternalSyntheticLambda6) obj3).invoke(((ArrayList) obj2).get(((Number) obj).intValue()));
                return 3;
            case 21:
                int iIntValue4 = ((Number) obj).intValue();
                return ((HomeScreenKt$$ExternalSyntheticLambda97) obj3).invoke(Integer.valueOf(iIntValue4), ((List) obj2).get(iIntValue4));
            case 22:
                int iIntValue5 = ((Number) obj).intValue();
                return ((HomeScreenKt$$ExternalSyntheticLambda97) obj3).invoke(Integer.valueOf(iIntValue5), ((List) obj2).get(iIntValue5));
            case 23:
                int iIntValue6 = ((Number) obj).intValue();
                return ((HomeScreenKt$$ExternalSyntheticLambda97) obj3).invoke(Integer.valueOf(iIntValue6), ((List) obj2).get(iIntValue6));
            case 24:
                int iIntValue7 = ((Number) obj).intValue();
                return ((HomeScreenKt$$ExternalSyntheticLambda97) obj3).invoke(Integer.valueOf(iIntValue7), ((List) obj2).get(iIntValue7));
            case 25:
                return ((StatsScreenKt$$ExternalSyntheticLambda9) obj3).invoke(((List) obj2).get(((Number) obj).intValue()));
            case 26:
                ((StatsScreenKt$$ExternalSyntheticLambda9) obj3).invoke(((List) obj2).get(((Number) obj).intValue()));
                return "grid_item";
            case 27:
                return ((StatsScreenKt$$ExternalSyntheticLambda9) obj3).invoke(((ArrayList) obj2).get(((Number) obj).intValue()));
            case 28:
                ((StatsScreenKt$$ExternalSyntheticLambda9) obj3).invoke(((ArrayList) obj2).get(((Number) obj).intValue()));
                return 4;
            default:
                return ((StatsScreenKt$$ExternalSyntheticLambda9) obj3).invoke(((ArrayList) obj2).get(((Number) obj).intValue()));
        }
    }
}
