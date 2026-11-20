package com.metrolist.innertubex;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.runtime.BroadcastFrameClock;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import coil3.util.FileSystemsKt;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda48;
import com.metrolist.music.constants.DimensionsKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class InnerTube$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ long f$0;

    public /* synthetic */ InnerTube$$ExternalSyntheticLambda2(long j, byte b) {
        this.$r8$classId = b;
        this.f$0 = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        byte b = this.$r8$classId;
        long j = this.f$0;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                InnerTube.SessionBoundRequest sessionBoundRequest = (InnerTube.SessionBoundRequest) obj;
                sessionBoundRequest.getClass();
                return Boolean.valueOf(sessionBoundRequest.session.generation < j);
            case 1:
                CacheDrawScope cacheDrawScope = (CacheDrawScope) obj;
                float fIntBitsToFloat = Float.intBitsToFloat((int) (cacheDrawScope.cacheParams.mo398getSizeNHjbRc() >> 32)) / 2.0f;
                return cacheDrawScope.onDrawWithContent(new MainActivity$$ExternalSyntheticLambda48(fIntBitsToFloat, FileSystemsKt.createHandleImage(cacheDrawScope, fIntBitsToFloat), new BlendModeColorFilter(j, 5), (byte) 3));
            case 2:
                ((SemanticsPropertyReceiver) obj).set(SelectionHandlesKt.SelectionHandleInfoKey, new SelectionHandleInfo(Handle.Cursor, this.f$0, SelectionHandleAnchor.Middle, true));
                return unit;
            case 3:
                ((BroadcastFrameClock.FrameAwaiter) obj).resume(j);
                return unit;
            case 4:
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("DELETE FROM recognition_history WHERE id = ?");
                try {
                    sQLiteStatementPrepare.bindLong(1, j);
                    sQLiteStatementPrepare.step();
                    return unit;
                } finally {
                    sQLiteStatementPrepare.close();
                }
            case 5:
                DrawScope drawScope = (DrawScope) obj;
                drawScope.getClass();
                drawScope.mo535drawLineNGM6Ib0(this.f$0, (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits(0.5f)) & 4294967295L), (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32)))) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(0.5f))), drawScope.mo81toPx0680j_4(1.0f), (496 & 16) != 0 ? 0 : 0, 3);
                return unit;
            case 6:
                DrawScope drawScope2 = (DrawScope) obj;
                drawScope2.getClass();
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope2.mo556getSizeNHjbRc() & 4294967295L)) - 0.5f;
                drawScope2.mo535drawLineNGM6Ib0(this.f$0, (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L), (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope2.mo556getSizeNHjbRc() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L), drawScope2.mo81toPx0680j_4(1.0f), (496 & 16) != 0 ? 0 : 0, 3);
                return unit;
            case 7:
                DrawScope drawScope3 = (DrawScope) obj;
                drawScope3.getClass();
                SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                float fMo81toPx0680j_4 = drawScope3.mo81toPx0680j_4(10.0f);
                float fMo81toPx0680j_5 = drawScope3.mo81toPx0680j_4(2.0f);
                DrawScope.m552drawRoundRectuAw5IA$default(drawScope3, this.f$0, (((long) Float.floatToRawIntBits(drawScope3.mo81toPx0680j_4(2.0f))) & 4294967295L) | (((long) Float.floatToRawIntBits(fMo81toPx0680j_5)) << 32), drawScope3.mo556getSizeNHjbRc(), (((long) Float.floatToRawIntBits(fMo81toPx0680j_4)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fMo81toPx0680j_4))), null, 240);
                return unit;
            default:
                DrawScope drawScope4 = (DrawScope) obj;
                drawScope4.getClass();
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32) | (((long) Float.floatToRawIntBits(drawScope4.mo81toPx0680j_4(2.0f))) & 4294967295L);
                long jMo556getSizeNHjbRc = drawScope4.mo556getSizeNHjbRc();
                float fMo81toPx0680j_6 = drawScope4.mo81toPx0680j_4(16.0f);
                DrawScope.m552drawRoundRectuAw5IA$default(drawScope4, this.f$0, jFloatToRawIntBits, jMo556getSizeNHjbRc, (((long) Float.floatToRawIntBits(fMo81toPx0680j_6)) << 32) | (((long) Float.floatToRawIntBits(fMo81toPx0680j_6)) & 4294967295L), null, 240);
                return unit;
        }
    }
}
