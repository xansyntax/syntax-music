package androidx.compose.material3;

import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import com.metrolist.music.ui.screens.recognition.RecognitionScreenKt;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TimePickerKt$$ExternalSyntheticLambda2 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 2;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ int f$3;
    public final /* synthetic */ int f$5;

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda2(int i, String str, String str2, Function0 function0, int i2) {
        this.f$3 = i;
        this.f$0 = str;
        this.f$1 = str2;
        this.f$2 = function0;
        this.f$5 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
        byte b = this.$r8$classId;
        int i = this.f$5;
        Object obj3 = this.f$0;
        Unit unit = Unit.INSTANCE;
        Object obj4 = this.f$2;
        Object obj5 = this.f$1;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                TimePickerKt.m355TimePickerImplNdgjQFA((TimePickerState) obj3, (Modifier) obj5, (TimePickerColors) obj4, this.f$3, (Composer) obj, iUpdateChangedFlags);
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                LazyLayoutKt.LazyLayoutPinnableItem(this.f$0, this.f$3, (LazyLayoutPinnedItemList) obj5, (ComposableLambdaImpl) obj4, (Composer) obj, iUpdateChangedFlags2);
                break;
            case 2:
                ((Integer) obj2).intValue();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(i | 1);
                RecognitionScreenKt.RecognitionMessageState(this.f$3, (String) obj3, (String) obj5, (Function0) obj4, (Composer) obj, iUpdateChangedFlags3);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags4 = Stack.updateChangedFlags(27649);
                AlarmSettingsKt.AlarmTimePickerDialog((String) obj3, this.f$3, this.f$5, (Function0) obj5, (Function2) obj4, (Composer) obj, iUpdateChangedFlags4);
                break;
        }
        return unit;
    }

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda2(TimePickerState timePickerState, Modifier modifier, TimePickerColors timePickerColors, int i, int i2) {
        this.f$0 = timePickerState;
        this.f$1 = modifier;
        this.f$2 = timePickerColors;
        this.f$3 = i;
        this.f$5 = i2;
    }

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda2(Object obj, int i, LazyLayoutPinnedItemList lazyLayoutPinnedItemList, ComposableLambdaImpl composableLambdaImpl, int i2) {
        this.f$0 = obj;
        this.f$3 = i;
        this.f$1 = lazyLayoutPinnedItemList;
        this.f$2 = composableLambdaImpl;
        this.f$5 = i2;
    }

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda2(String str, int i, int i2, Function0 function0, Function2 function2, int i3) {
        this.f$0 = str;
        this.f$3 = i;
        this.f$5 = i2;
        this.f$1 = function0;
        this.f$2 = function2;
    }
}
