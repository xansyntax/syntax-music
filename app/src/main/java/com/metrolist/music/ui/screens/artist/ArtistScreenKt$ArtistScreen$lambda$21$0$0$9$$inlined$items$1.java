package com.metrolist.music.ui.screens.artist;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda97;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.screens.library.LibraryScreenKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.screens.search.LocalSearchScreenKt$$ExternalSyntheticLambda5;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1 implements Function1 {
    public final /* synthetic */ List $items;
    public final /* synthetic */ Function $key;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(Function function, List list, byte b) {
        this.$r8$classId = b;
        this.$key = function;
        this.$items = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        List list = this.$items;
        Function function = this.$key;
        switch (b) {
            case 0:
                return ((StatsScreenKt$$ExternalSyntheticLambda9) function).invoke(list.get(((Number) obj).intValue()));
            case 1:
                return ((StatsScreenKt$$ExternalSyntheticLambda9) function).invoke(((ArrayList) list).get(((Number) obj).intValue()));
            case 2:
                int iIntValue = ((Number) obj).intValue();
                return ((HomeScreenKt$$ExternalSyntheticLambda97) function).invoke(Integer.valueOf(iIntValue), list.get(iIntValue));
            case 3:
                return ((StatsScreenKt$$ExternalSyntheticLambda9) function).invoke(((ArrayList) list).get(((Number) obj).intValue()));
            case 4:
                ((StatsScreenKt$$ExternalSyntheticLambda9) function).invoke(list.get(((Number) obj).intValue()));
                return "youtube_song";
            case 5:
                return ((StatsScreenKt$$ExternalSyntheticLambda9) function).invoke(list.get(((Number) obj).intValue()));
            case 6:
                ((StatsScreenKt$$ExternalSyntheticLambda9) function).invoke(list.get(((Number) obj).intValue()));
                return "youtube_grid";
            case 7:
                int iIntValue2 = ((Number) obj).intValue();
                return ((HomeScreenKt$$ExternalSyntheticLambda97) function).invoke(Integer.valueOf(iIntValue2), list.get(iIntValue2));
            case 8:
                return ((StatsScreenKt$$ExternalSyntheticLambda9) function).invoke(list.get(((Number) obj).intValue()));
            case 9:
                ((StatsScreenKt$$ExternalSyntheticLambda9) function).invoke(list.get(((Number) obj).intValue()));
                return 4;
            case 10:
                return ((StatsScreenKt$$ExternalSyntheticLambda9) function).invoke(list.get(((Number) obj).intValue()));
            case 11:
                ((StatsScreenKt$$ExternalSyntheticLambda9) function).invoke(list.get(((Number) obj).intValue()));
                return 4;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return ((LocalSearchScreenKt$$ExternalSyntheticLambda5) function).invoke(list.get(((Number) obj).intValue()));
            case 13:
                ((StatsScreenKt$$ExternalSyntheticLambda9) function).invoke(list.get(((Number) obj).intValue()));
                return 3;
            case 14:
                return ((StatsScreenKt$$ExternalSyntheticLambda9) function).invoke(list.get(((Number) obj).intValue()));
            case 15:
                ((LocalSearchScreenKt$$ExternalSyntheticLambda5) function).invoke(list.get(((Number) obj).intValue()));
                return 3;
            case 16:
                return ((LocalSearchScreenKt$$ExternalSyntheticLambda5) function).invoke(list.get(((Number) obj).intValue()));
            case 17:
                ((LocalSearchScreenKt$$ExternalSyntheticLambda5) function).invoke(list.get(((Number) obj).intValue()));
                return 5;
            case 18:
                return ((LocalSearchScreenKt$$ExternalSyntheticLambda5) function).invoke(list.get(((Number) obj).intValue()));
            case 19:
                ((LocalSearchScreenKt$$ExternalSyntheticLambda5) function).invoke(list.get(((Number) obj).intValue()));
                return 5;
            case 20:
                return ((LocalSearchScreenKt$$ExternalSyntheticLambda5) function).invoke(list.get(((Number) obj).intValue()));
            case 21:
                ((LocalSearchScreenKt$$ExternalSyntheticLambda5) function).invoke(list.get(((Number) obj).intValue()));
                return 5;
            case 22:
                return ((LocalSearchScreenKt$$ExternalSyntheticLambda5) function).invoke(list.get(((Number) obj).intValue()));
            case 23:
                ((LocalSearchScreenKt$$ExternalSyntheticLambda5) function).invoke(list.get(((Number) obj).intValue()));
                return 5;
            case 24:
                int iIntValue3 = ((Number) obj).intValue();
                return ((LibraryScreenKt$$ExternalSyntheticLambda7) function).invoke(Integer.valueOf(iIntValue3), list.get(iIntValue3));
            case 25:
                int iIntValue4 = ((Number) obj).intValue();
                return ((LibraryScreenKt$$ExternalSyntheticLambda7) function).invoke(Integer.valueOf(iIntValue4), list.get(iIntValue4));
            case 26:
                int iIntValue5 = ((Number) obj).intValue();
                return ((LibraryScreenKt$$ExternalSyntheticLambda7) function).invoke(Integer.valueOf(iIntValue5), list.get(iIntValue5));
            case 27:
                int iIntValue6 = ((Number) obj).intValue();
                return ((LibraryScreenKt$$ExternalSyntheticLambda7) function).invoke(Integer.valueOf(iIntValue6), ((ArrayList) list).get(iIntValue6));
            case 28:
                int iIntValue7 = ((Number) obj).intValue();
                return ((LibraryScreenKt$$ExternalSyntheticLambda7) function).invoke(Integer.valueOf(iIntValue7), list.get(iIntValue7));
            default:
                int iIntValue8 = ((Number) obj).intValue();
                return ((LibraryScreenKt$$ExternalSyntheticLambda7) function).invoke(Integer.valueOf(iIntValue8), list.get(iIntValue8));
        }
    }
}
