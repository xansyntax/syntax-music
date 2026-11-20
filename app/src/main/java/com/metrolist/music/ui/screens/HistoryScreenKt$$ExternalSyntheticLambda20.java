package com.metrolist.music.ui.screens;

import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteQuery;
import android.graphics.Typeface;
import androidx.compose.animation.AnimatedContentScopeImpl;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1;
import androidx.compose.ui.text.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolverImpl;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavBackStackEntry;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;
import com.metrolist.innertube.pages.HistoryPage;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.viewmodels.DateAgo;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HistoryScreenKt$$ExternalSyntheticLambda20 implements Function4 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ HistoryScreenKt$$ExternalSyntheticLambda20(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        byte b = this.$r8$classId;
        RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = ColorKt.RectangleShape;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                HistoryPage.HistorySection historySection = (HistoryPage.HistorySection) obj5;
                ((Integer) obj2).getClass();
                Composer composer = (Composer) obj3;
                int iIntValue = ((Integer) obj4).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 129) != 128)) {
                    MenuKt.NavigationTitle(historySection.title, ImageKt.m39backgroundbw27NRU(SizeKt.fillMaxWidth(companion, 1.0f), ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background, rectangleShapeKt$RectangleShape$1), null, null, null, null, gapComposer, 0, 60);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                Function3 function3 = (Function3) obj5;
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                ((Integer) obj2).intValue();
                Composer composer2 = (Composer) obj3;
                int iIntValue2 = ((Integer) obj4).intValue();
                if ((iIntValue2 & 6) == 0) {
                    iIntValue2 |= ((GapComposer) composer2).changed(lazyItemScopeImpl) ? 4 : 2;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 131) != 130)) {
                    function3.invoke(lazyItemScopeImpl, gapComposer2, Integer.valueOf(iIntValue2 & 14));
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 2:
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj5;
                LazyGridItemScopeImpl lazyGridItemScopeImpl = (LazyGridItemScopeImpl) obj;
                ((Integer) obj2).getClass();
                Composer composer3 = (Composer) obj3;
                int iIntValue3 = ((Integer) obj4).intValue();
                if ((iIntValue3 & 6) == 0) {
                    iIntValue3 |= ((GapComposer) composer3).changed(lazyGridItemScopeImpl) ? 4 : 2;
                }
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 131) != 130)) {
                    composableLambdaImpl.invoke(lazyGridItemScopeImpl, gapComposer3, Integer.valueOf(iIntValue3 & 14));
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 3:
                AndroidParagraphIntrinsics androidParagraphIntrinsics = (AndroidParagraphIntrinsics) obj5;
                TypefaceResult typefaceResultM753resolveDPcqOEQ = ((FontFamilyResolverImpl) androidParagraphIntrinsics.fontFamilyResolver).m753resolveDPcqOEQ((FontFamily) obj, (FontWeight) obj2, ((FontStyle) obj3).value, ((FontSynthesis) obj4).value);
                if (typefaceResultM753resolveDPcqOEQ instanceof TypefaceResult.Immutable) {
                    Object obj6 = ((TypefaceResult.Immutable) typefaceResultM753resolveDPcqOEQ).value;
                    obj6.getClass();
                    return (Typeface) obj6;
                }
                EmojiProcessor emojiProcessor = new EmojiProcessor(typefaceResultM753resolveDPcqOEQ, androidParagraphIntrinsics.resolvedTypefaces);
                androidParagraphIntrinsics.resolvedTypefaces = emojiProcessor;
                Object obj7 = emojiProcessor.mGlyphChecker;
                obj7.getClass();
                return (Typeface) obj7;
            case 4:
                SQLiteQuery sQLiteQuery = (SQLiteQuery) obj4;
                sQLiteQuery.getClass();
                ((SupportSQLiteQuery) obj5).bindTo(new FrameworkSQLiteProgram(sQLiteQuery));
                return new SQLiteCursor((SQLiteCursorDriver) obj2, (String) obj3, sQLiteQuery);
            case 5:
                DateAgo dateAgo = (DateAgo) obj5;
                ((Integer) obj2).getClass();
                Composer composer4 = (Composer) obj3;
                int iIntValue4 = ((Integer) obj4).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 129) != 128)) {
                    dateAgo.getClass();
                    MenuKt.NavigationTitle(AlbumScreenKt.HistoryScreen$dateAgoToString(dateAgo, gapComposer4), ImageKt.m39backgroundbw27NRU(SizeKt.fillMaxWidth(companion, 1.0f), ((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surface, rectangleShapeKt$RectangleShape$1), null, null, null, null, gapComposer4, 0, 60);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            default:
                Format$$ExternalSyntheticOutline0.m((Integer) obj4, (AnimatedContentScopeImpl) obj, (NavBackStackEntry) obj2);
                HomeScreenKt.HomeScreen((SnackbarHostState) obj5, null, (Composer) obj3, 0);
                return unit;
        }
    }
}
