package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import com.metrolist.music.db.entities.Artist;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlertDialogKt$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Function3 f$3;
    public final /* synthetic */ int f$4;
    public final /* synthetic */ byte f$5;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ AlertDialogKt$$ExternalSyntheticLambda3(PopupPositionProvider popupPositionProvider, Function0 function0, PopupProperties popupProperties, ComposableLambdaImpl composableLambdaImpl, int i, int i2) {
        this.$r8$classId = (byte) 1;
        this.f$1 = popupPositionProvider;
        this.f$0 = function0;
        this.f$2 = popupProperties;
        this.f$3 = composableLambdaImpl;
        this.f$4 = i;
        this.f$5 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Function3 function3 = this.f$3;
        Unit unit = Unit.INSTANCE;
        int i = this.f$4;
        Object obj3 = this.f$2;
        Object obj4 = this.f$1;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                AlertDialogKt.BasicAlertDialog((Function0) obj5, (Modifier) obj4, (DialogProperties) obj3, (ComposableLambdaImpl) function3, (Composer) obj, Stack.updateChangedFlags(i | 1), this.f$5);
                break;
            case 1:
                ((Integer) obj2).getClass();
                AndroidPopup_androidKt.Popup((PopupPositionProvider) obj4, (Function0) obj5, (PopupProperties) obj3, (ComposableLambdaImpl) function3, (Composer) obj, Stack.updateChangedFlags(i | 1), this.f$5);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                com.metrolist.music.ui.component.MenuKt.ArtistListItem((Artist) obj5, (Modifier) obj4, (Function3) obj3, this.f$3, (Composer) obj, iUpdateChangedFlags, this.f$5);
                break;
        }
        return unit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ AlertDialogKt$$ExternalSyntheticLambda3(Object obj, Modifier modifier, Object obj2, Function3 function3, int i, int i2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = modifier;
        this.f$2 = obj2;
        this.f$3 = function3;
        this.f$4 = i;
        this.f$5 = i2;
    }
}
