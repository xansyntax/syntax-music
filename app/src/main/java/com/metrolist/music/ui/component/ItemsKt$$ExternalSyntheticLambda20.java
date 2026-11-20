package com.metrolist.music.ui.component;

import android.content.Context;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.layout.BoxWithConstraintsScopeImpl;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import coil3.compose.AsyncImageKt;
import coil3.request.CachePolicy;
import coil3.request.ImageRequest;
import com.google.common.math.IntMath;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.ui.utils.YouTubeUtilsKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ItemsKt$$ExternalSyntheticLambda20 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Artist f$0;

    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda20(Artist artist, byte b) {
        this.$r8$classId = b;
        this.f$0 = artist;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Artist artist = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else if (artist.artist.bookmarkedAt == null) {
                    gapComposer.startReplaceGroup(-1071090574);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(-1071382067);
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.favorite, 0, gapComposer), (String) null, OffsetKt.m139paddingqDBjuR0$default(SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, 18.0f), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 2.0f, CropImageView.DEFAULT_ASPECT_RATIO, 11), ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error, gapComposer, 440, 0);
                    gapComposer.end(false);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else if (artist.artist.bookmarkedAt == null) {
                    gapComposer2.startReplaceGroup(-155070802);
                    gapComposer2.end(false);
                } else {
                    gapComposer2.startReplaceGroup(-155108281);
                    Icon.INSTANCE.Favorite(6, gapComposer2);
                    gapComposer2.end(false);
                }
                break;
            default:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((BoxWithConstraintsScopeImpl) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    ImageRequest.Builder builder = new ImageRequest.Builder((Context) gapComposer3.consume(AndroidCompositionLocals_androidKt.LocalContext));
                    String str = artist.artist.thumbnailUrl;
                    builder.data = str != null ? YouTubeUtilsKt.resize(str, 544, 544) : null;
                    CachePolicy cachePolicy = CachePolicy.ENABLED;
                    builder.memoryCachePolicy = cachePolicy;
                    builder.diskCachePolicy = cachePolicy;
                    builder.networkCachePolicy = cachePolicy;
                    ImageRequest imageRequestBuild = builder.build();
                    FillElement fillElement = SizeKt.FillWholeMaxSize;
                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                    AsyncImageKt.m849AsyncImage10Xjiaw(imageRequestBuild, ClipKt.clip(fillElement, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(18.0f, 10.0f, gapComposer3))), ContentScale.Companion.Crop, gapComposer3, 1572912, 1976);
                }
                break;
        }
        return unit;
    }
}
