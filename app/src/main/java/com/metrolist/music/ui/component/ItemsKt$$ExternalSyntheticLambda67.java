package com.metrolist.music.ui.component;

import androidx.compose.foundation.layout.BoxWithConstraintsScopeImpl;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import com.metrolist.music.ui.player.QueueKt;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ItemsKt$$ExternalSyntheticLambda67 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ int f$3;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda67(Modifier modifier, Function2 function2, int i, int i2) {
        this.$r8$classId = (byte) 2;
        this.f$0 = modifier;
        this.f$2 = function2;
        this.f$3 = i;
        this.f$1 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$3;
        Object obj3 = this.f$2;
        boolean z = this.f$1;
        Object obj4 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                MenuKt.AlbumPlayButton((BoxWithConstraintsScopeImpl) obj4, z, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 1:
                ((Integer) obj2).getClass();
                MathKt.TextFieldSelectionHandle(z, (ResolvedTextDirection) obj4, (TextFieldSelectionManager) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 2:
                ((Integer) obj2).getClass();
                RulerKt.SubcomposeLayout((Modifier) obj4, (Function2) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1), z ? 1 : 0);
                break;
            default:
                ((Integer) obj2).getClass();
                QueueKt.ThumbnailImage((String) obj4, z, (Modifier) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
        }
        return unit;
    }

    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda67(Object obj, boolean z, Object obj2, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = z;
        this.f$2 = obj2;
        this.f$3 = i;
    }

    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda67(boolean z, ResolvedTextDirection resolvedTextDirection, TextFieldSelectionManager textFieldSelectionManager, int i) {
        this.$r8$classId = (byte) 1;
        this.f$1 = z;
        this.f$0 = resolvedTextDirection;
        this.f$2 = textFieldSelectionManager;
        this.f$3 = i;
    }
}
