package com.metrolist.music.ui.screens.library;

import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import com.google.common.math.IntMath;
import com.metrolist.music.constants.LibraryViewType;
import com.yalantis.ucrop.R;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LibraryMixScreenKt$$ExternalSyntheticLambda57 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ LibraryViewType f$0;

    public /* synthetic */ LibraryMixScreenKt$$ExternalSyntheticLambda57(LibraryViewType libraryViewType, byte b) {
        this.$r8$classId = b;
        this.f$0 = libraryViewType;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0050 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x0052  */
    /* JADX WARN: Code duplicated, block: B:20:0x0054  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a8  */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
        int iOrdinal;
        int iOrdinal2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = R.string.switch_to_grid_view;
        int i2 = R.drawable.list;
        LibraryViewType libraryViewType = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                    return unit;
                }
                int iOrdinal3 = libraryViewType.ordinal();
                if (iOrdinal3 == 0) {
                    Painter painterPainterResource = IntMath.painterResource(i2, 0, gapComposer);
                    iOrdinal = libraryViewType.ordinal();
                    if (iOrdinal != 0) {
                        if (iOrdinal == 1) {
                            i = R.string.switch_to_list_view;
                        } else {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                        }
                    }
                    IconKt.m290Iconww6aTOc(painterPainterResource, MathKt.stringResource(i, gapComposer), (Modifier) null, 0L, gapComposer, 8, 12);
                    return unit;
                }
                if (iOrdinal3 == 1) {
                    i2 = R.drawable.grid_view;
                    Painter painterPainterResource2 = IntMath.painterResource(i2, 0, gapComposer);
                    iOrdinal = libraryViewType.ordinal();
                    if (iOrdinal != 0) {
                        if (iOrdinal == 1) {
                            i = R.string.switch_to_list_view;
                        } else {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                        }
                    }
                    IconKt.m290Iconww6aTOc(painterPainterResource2, MathKt.stringResource(i, gapComposer), (Modifier) null, 0L, gapComposer, 8, 12);
                    return unit;
                }
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
            default:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                    return unit;
                }
                int iOrdinal4 = libraryViewType.ordinal();
                if (iOrdinal4 == 0) {
                    Painter painterPainterResource3 = IntMath.painterResource(i2, 0, gapComposer2);
                    iOrdinal2 = libraryViewType.ordinal();
                    if (iOrdinal2 != 0) {
                        if (iOrdinal2 == 1) {
                            i = R.string.switch_to_list_view;
                        } else {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                        }
                    }
                    IconKt.m290Iconww6aTOc(painterPainterResource3, MathKt.stringResource(i, gapComposer2), (Modifier) null, 0L, gapComposer2, 8, 12);
                    return unit;
                }
                if (iOrdinal4 == 1) {
                    i2 = R.drawable.grid_view;
                    Painter painterPainterResource4 = IntMath.painterResource(i2, 0, gapComposer2);
                    iOrdinal2 = libraryViewType.ordinal();
                    if (iOrdinal2 != 0) {
                        if (iOrdinal2 == 1) {
                            i = R.string.switch_to_list_view;
                        } else {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                        }
                    }
                    IconKt.m290Iconww6aTOc(painterPainterResource4, MathKt.stringResource(i, gapComposer2), (Modifier) null, 0L, gapComposer2, 8, 12);
                    return unit;
                }
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
        }
    }
}
