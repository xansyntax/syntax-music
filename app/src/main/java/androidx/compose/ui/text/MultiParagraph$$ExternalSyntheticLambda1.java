package androidx.compose.ui.text;

import android.graphics.Path;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MultiParagraph$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ MultiParagraph$$ExternalSyntheticLambda1(int i, int i2, String str) {
        this.$r8$classId = (byte) 1;
        this.f$1 = i;
        this.f$2 = i2;
        this.f$0 = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$2;
        int i2 = this.f$1;
        Object obj2 = this.f$0;
        switch (b) {
            case 0:
                AndroidPath androidPath = (AndroidPath) obj2;
                ParagraphInfo paragraphInfo = (ParagraphInfo) obj;
                AndroidParagraph androidParagraph = paragraphInfo.paragraph;
                int localIndex = paragraphInfo.toLocalIndex(i2);
                int localIndex2 = paragraphInfo.toLocalIndex(i);
                CharSequence charSequence = androidParagraph.charSequence;
                if (localIndex < 0 || localIndex > localIndex2 || localIndex2 > charSequence.length()) {
                    int length = charSequence.length();
                    StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(localIndex, "start(", ") or end(", localIndex2, ") is out of range [0..");
                    sbM3m.append(length);
                    sbM3m.append("], or start > end!");
                    InlineClassHelperKt.throwIllegalArgumentException(sbM3m.toString());
                }
                Path path = new Path();
                TextLayout textLayout = androidParagraph.layout;
                textLayout.layout.getSelectionPath(localIndex, localIndex2, path);
                int i3 = textLayout.topPadding;
                if (i3 != 0 && !path.isEmpty()) {
                    path.offset(CropImageView.DEFAULT_ASPECT_RATIO, i3);
                }
                if (CropImageView.DEFAULT_ASPECT_RATIO != CropImageView.DEFAULT_ASPECT_RATIO && !path.isEmpty()) {
                    path.offset(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                }
                AndroidPath androidPath2 = new AndroidPath(path);
                androidPath2.m472translatek4lQ0M((((long) Float.floatToRawIntBits(paragraphInfo.top)) & 4294967295L) | (Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO) << 32));
                AndroidPath.m469addPathUv8p0NA$default(androidPath, androidPath2);
                return unit;
            case 1:
                String str = (String) obj2;
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("\n        UPDATE playlist_song_map SET position =\n            CASE\n                WHEN position < ? THEN position + 1\n                WHEN position > ? THEN position - 1\n                ELSE ?\n            END\n        WHERE playlistId = ? AND position BETWEEN MIN(?, ?) AND MAX(?, ?)\n    ");
                long j = i2;
                try {
                    sQLiteStatementPrepare.bindLong(1, j);
                    sQLiteStatementPrepare.bindLong(2, j);
                    long j2 = i;
                    sQLiteStatementPrepare.bindLong(3, j2);
                    sQLiteStatementPrepare.bindText(4, str);
                    sQLiteStatementPrepare.bindLong(5, j);
                    sQLiteStatementPrepare.bindLong(6, j2);
                    sQLiteStatementPrepare.bindLong(7, j);
                    sQLiteStatementPrepare.bindLong(8, j2);
                    sQLiteStatementPrepare.step();
                    return unit;
                } finally {
                    sQLiteStatementPrepare.close();
                }
            default:
                DrawScope drawScope = (DrawScope) obj;
                drawScope.getClass();
                DrawScope.m544drawImageAZ2fEMs$default(drawScope, (AndroidImageBitmap) obj2, 0L, (((long) i2) << 32) | (4294967295L & ((long) i)), CropImageView.DEFAULT_ASPECT_RATIO, null, 1, 494);
                return unit;
        }
    }

    public /* synthetic */ MultiParagraph$$ExternalSyntheticLambda1(Object obj, int i, int i2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = i;
        this.f$2 = i2;
    }
}
