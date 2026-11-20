package androidx.navigation.internal;

import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.navigation.NavDeepLink;
import kotlin.jvm.functions.Function0;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class NavDestinationImpl$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String f$0;

    public /* synthetic */ NavDestinationImpl$$ExternalSyntheticLambda2(String str, byte b) {
        this.$r8$classId = b;
        this.f$0 = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        String str = this.f$0;
        switch (b) {
            case 0:
                return new NavDeepLink(str);
            case 1:
                int length = str.length();
                return Stack.mutableStateOf$default(new TextFieldValue(4, TextRangeKt.TextRange(length, length), str));
            case 2:
                return str;
            case 3:
                return Stack.mutableStateOf$default(str);
            case 4:
                return Stack.mutableStateOf$default(str);
            case 5:
                return new ParcelableSnapshotMutableFloatState(Float.parseFloat(str));
            case 6:
                return Stack.mutableStateOf$default(str);
            case 7:
                return Stack.mutableStateOf$default(str);
            default:
                return LoggerFactory.getLogger(str);
        }
    }
}
