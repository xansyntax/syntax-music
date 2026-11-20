package com.metrolist.music.ui.theme;

import androidx.compose.ui.text.font.FontListFontFamily;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.ResourceFont;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.yalantis.ucrop.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FontKt {
    public static final FontListFontFamily DmSansFamily;
    public static final FontListFontFamily NewsreaderFamily;
    public static final List editorialWeights;

    static {
        FontWeight fontWeight = FontWeight.Normal;
        List listAsList = Arrays.asList(new FontVariation.SettingInt[0]);
        listAsList.getClass();
        List listAsList2 = Arrays.asList(new ResourceFont(R.font.bbh_bartle_regular, fontWeight, 0, new FontVariation.Settings(listAsList)));
        listAsList2.getClass();
        if (listAsList2.isEmpty()) {
            InlineClassHelperKt.throwIllegalStateException("At least one font should be passed to FontFamily");
        }
        List<FontWeight> listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new FontWeight[]{fontWeight, FontWeight.Medium, FontWeight.SemiBold, FontWeight.Bold});
        editorialWeights = listListOf;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listListOf, 10));
        for (FontWeight fontWeight2 : listListOf) {
            List listAsList3 = Arrays.asList(FontVariation.weight(fontWeight2.weight));
            listAsList3.getClass();
            arrayList.add(new ResourceFont(R.font.newsreader, fontWeight2, 0, new FontVariation.Settings(listAsList3)));
        }
        List<FontWeight> list = editorialWeights;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (FontWeight fontWeight3 : list) {
            List listAsList4 = Arrays.asList(FontVariation.weight(fontWeight3.weight));
            listAsList4.getClass();
            arrayList2.add(new ResourceFont(R.font.newsreader_italic, fontWeight3, 1, new FontVariation.Settings(listAsList4)));
        }
        NewsreaderFamily = new FontListFontFamily(CollectionsKt.plus((Iterable) arrayList2, (Collection) arrayList));
        List<FontWeight> list2 = editorialWeights;
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
        for (FontWeight fontWeight4 : list2) {
            List listAsList5 = Arrays.asList(FontVariation.weight(fontWeight4.weight));
            listAsList5.getClass();
            arrayList3.add(new ResourceFont(R.font.dm_sans, fontWeight4, 0, new FontVariation.Settings(listAsList5)));
        }
        DmSansFamily = new FontListFontFamily(arrayList3);
    }
}
