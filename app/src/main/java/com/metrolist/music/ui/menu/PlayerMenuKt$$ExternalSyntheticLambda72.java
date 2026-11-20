package com.metrolist.music.ui.menu;

import android.content.Context;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.metrolist.music.listentogether.proto.Listentogether;
import com.metrolist.music.ui.screens.ListenTogetherScreenKt;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.StringValuesKt$$ExternalSyntheticLambda1;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerMenuKt$$ExternalSyntheticLambda72 implements Function3 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Listentogether.RoomState f$1;
    public final /* synthetic */ Context f$2;

    public /* synthetic */ PlayerMenuKt$$ExternalSyntheticLambda72(Listentogether.RoomState roomState, boolean z, Context context) {
        this.f$1 = roomState;
        this.f$0 = z;
        this.f$2 = context;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Context context = this.f$2;
        boolean z = this.f$0;
        Listentogether.RoomState roomState = this.f$1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f);
                    long j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                    SurfaceKt.m337SurfaceT9BRK9s(modifierM137paddingVpY3zN4$default, roundedCornerShapeM185RoundedCornerShape0680j_4, ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.1f, Color.m483getColorSpaceimpl(j)), 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(1185404590, new StringValuesKt$$ExternalSyntheticLambda1(z, roomState, context, (byte) 6), gapComposer), gapComposer, 12582918, 120);
                }
                break;
            default:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    String roomCode = roomState.getRoomCode();
                    roomCode.getClass();
                    ListenTogetherScreenKt.RoomStatusCard(roomCode, z, context, gapComposer2, 0);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ PlayerMenuKt$$ExternalSyntheticLambda72(boolean z, Listentogether.RoomState roomState, Context context) {
        this.f$0 = z;
        this.f$1 = roomState;
        this.f$2 = context;
    }
}
