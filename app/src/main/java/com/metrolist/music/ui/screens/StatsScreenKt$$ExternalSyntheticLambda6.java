package com.metrolist.music.ui.screens;

import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.runtime.Stack;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.navigation.IntNavType;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavType;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.music.db.entities.Artist;
import com.yalantis.ucrop.view.CropImageView;
import java.time.LocalDateTime;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.ConnectionSpec;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StatsScreenKt$$ExternalSyntheticLambda6 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ StatsScreenKt$$ExternalSyntheticLambda6(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        IntNavType intNavType = NavType.BoolType;
        IntNavType intNavType2 = NavType.StringType;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                LocalDateTime localDateTime = (LocalDateTime) obj;
                localDateTime.getClass();
                return localDateTime.minusWeeks(1L);
            case 1:
                NavArgumentBuilder navArgumentBuilder = (NavArgumentBuilder) obj;
                navArgumentBuilder.getClass();
                ConnectionSpec.Builder builder = navArgumentBuilder.builder;
                builder.cipherSuites = intNavType;
                builder.tlsVersions = Boolean.FALSE;
                builder.supportsTlsExtensions = true;
                return unit;
            case 2:
                NavArgumentBuilder navArgumentBuilder2 = (NavArgumentBuilder) obj;
                navArgumentBuilder2.getClass();
                navArgumentBuilder2.builder.cipherSuites = intNavType2;
                return unit;
            case 3:
                NavArgumentBuilder navArgumentBuilder3 = (NavArgumentBuilder) obj;
                navArgumentBuilder3.getClass();
                navArgumentBuilder3.builder.cipherSuites = intNavType2;
                return unit;
            case 4:
                NavArgumentBuilder navArgumentBuilder4 = (NavArgumentBuilder) obj;
                navArgumentBuilder4.getClass();
                navArgumentBuilder4.builder.cipherSuites = intNavType2;
                return unit;
            case 5:
                NavArgumentBuilder navArgumentBuilder5 = (NavArgumentBuilder) obj;
                navArgumentBuilder5.getClass();
                ConnectionSpec.Builder builder2 = navArgumentBuilder5.builder;
                builder2.cipherSuites = intNavType2;
                builder2.tls = true;
                return unit;
            case 6:
                NavArgumentBuilder navArgumentBuilder6 = (NavArgumentBuilder) obj;
                navArgumentBuilder6.getClass();
                ConnectionSpec.Builder builder3 = navArgumentBuilder6.builder;
                builder3.cipherSuites = intNavType2;
                builder3.tls = true;
                return unit;
            case 7:
                NavArgumentBuilder navArgumentBuilder7 = (NavArgumentBuilder) obj;
                navArgumentBuilder7.getClass();
                navArgumentBuilder7.builder.cipherSuites = intNavType2;
                return unit;
            case 8:
                NavArgumentBuilder navArgumentBuilder8 = (NavArgumentBuilder) obj;
                navArgumentBuilder8.getClass();
                navArgumentBuilder8.builder.cipherSuites = intNavType2;
                return unit;
            case 9:
                NavArgumentBuilder navArgumentBuilder9 = (NavArgumentBuilder) obj;
                navArgumentBuilder9.getClass();
                navArgumentBuilder9.builder.cipherSuites = intNavType2;
                return unit;
            case 10:
                NavArgumentBuilder navArgumentBuilder10 = (NavArgumentBuilder) obj;
                navArgumentBuilder10.getClass();
                navArgumentBuilder10.builder.cipherSuites = intNavType2;
                return unit;
            case 11:
                NavArgumentBuilder navArgumentBuilder11 = (NavArgumentBuilder) obj;
                navArgumentBuilder11.getClass();
                navArgumentBuilder11.builder.cipherSuites = intNavType2;
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                NavArgumentBuilder navArgumentBuilder12 = (NavArgumentBuilder) obj;
                navArgumentBuilder12.getClass();
                navArgumentBuilder12.builder.cipherSuites = intNavType2;
                return unit;
            case 13:
                NavArgumentBuilder navArgumentBuilder13 = (NavArgumentBuilder) obj;
                navArgumentBuilder13.getClass();
                ConnectionSpec.Builder builder4 = navArgumentBuilder13.builder;
                builder4.cipherSuites = intNavType2;
                builder4.tls = true;
                return unit;
            case 14:
                NavArgumentBuilder navArgumentBuilder14 = (NavArgumentBuilder) obj;
                navArgumentBuilder14.getClass();
                ConnectionSpec.Builder builder5 = navArgumentBuilder14.builder;
                builder5.cipherSuites = intNavType2;
                builder5.tls = true;
                return unit;
            case 15:
                NavArgumentBuilder navArgumentBuilder15 = (NavArgumentBuilder) obj;
                navArgumentBuilder15.getClass();
                navArgumentBuilder15.builder.cipherSuites = intNavType2;
                return unit;
            case 16:
                ((AnimatedContentTransitionScope) obj).getClass();
                return EnterExitTransitionKt.fadeIn$default(ArcSplineKt.tween$default(250, 0, null, 6), CropImageView.DEFAULT_ASPECT_RATIO, 2);
            case 17:
                AnimatedContentTransitionScope animatedContentTransitionScope = (AnimatedContentTransitionScope) obj;
                animatedContentTransitionScope.getClass();
                String str = (String) ((NavBackStackEntry) animatedContentTransitionScope.getTargetState()).destination.impl.layoutNodes;
                return (str == null || !StringsKt__StringsJVMKt.startsWith(str, "search/", false)) ? EnterExitTransitionKt.fadeOut$default(ArcSplineKt.tween$default(200, 0, null, 6), CropImageView.DEFAULT_ASPECT_RATIO, 2) : EnterExitTransitionKt.fadeOut$default(ArcSplineKt.tween$default(200, 0, null, 6), CropImageView.DEFAULT_ASPECT_RATIO, 2);
            case 18:
                NavArgumentBuilder navArgumentBuilder16 = (NavArgumentBuilder) obj;
                navArgumentBuilder16.getClass();
                ConnectionSpec.Builder builder6 = navArgumentBuilder16.builder;
                builder6.cipherSuites = intNavType;
                builder6.tlsVersions = Boolean.FALSE;
                builder6.supportsTlsExtensions = true;
                return unit;
            case 19:
                NavArgumentBuilder navArgumentBuilder17 = (NavArgumentBuilder) obj;
                navArgumentBuilder17.getClass();
                navArgumentBuilder17.builder.cipherSuites = intNavType2;
                return unit;
            case 20:
                AnimatedContentTransitionScope animatedContentTransitionScope2 = (AnimatedContentTransitionScope) obj;
                animatedContentTransitionScope2.getClass();
                String str2 = (String) ((NavBackStackEntry) animatedContentTransitionScope2.getInitialState()).destination.impl.layoutNodes;
                return (str2 == null || !StringsKt__StringsJVMKt.startsWith(str2, "search/", false)) ? EnterExitTransitionKt.fadeIn$default(ArcSplineKt.tween$default(250, 0, null, 6), CropImageView.DEFAULT_ASPECT_RATIO, 2) : EnterExitTransitionKt.fadeIn$default(ArcSplineKt.tween$default(250, 0, null, 6), CropImageView.DEFAULT_ASPECT_RATIO, 2);
            case 21:
                ((AnimatedContentTransitionScope) obj).getClass();
                return EnterExitTransitionKt.fadeOut$default(ArcSplineKt.tween$default(200, 0, null, 6), CropImageView.DEFAULT_ASPECT_RATIO, 2);
            case 22:
                NavArgumentBuilder navArgumentBuilder18 = (NavArgumentBuilder) obj;
                navArgumentBuilder18.getClass();
                navArgumentBuilder18.builder.cipherSuites = intNavType2;
                return unit;
            case 23:
                AlbumItem albumItem = (AlbumItem) obj;
                albumItem.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("newrelease_", albumItem.id);
            case 24:
                ((AlbumItem) obj).getClass();
                return "grid_item";
            case 25:
                LocalDateTime localDateTime2 = (LocalDateTime) obj;
                localDateTime2.getClass();
                return localDateTime2.minusYears(1L);
            case 26:
                List list = (List) obj;
                list.getClass();
                return Stack.toMutableStateList(list);
            case 27:
                ((Boolean) obj).getClass();
                return unit;
            case 28:
                Artist artist = (Artist) obj;
                artist.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("stats_artist_", artist.artist.id);
            default:
                ((Artist) obj).getClass();
                return 3;
        }
    }
}
