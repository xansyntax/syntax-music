package androidx.compose.material3;

import android.webkit.WebView;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.input.TextFieldValue;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TooltipKt$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ TooltipKt$$ExternalSyntheticLambda2(MutableState mutableState, MutableState mutableState2, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
        this.f$1 = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$1;
        MutableState mutableState2 = this.f$0;
        switch (b) {
            case 0:
                if (mutableState2.getValue() == null || mutableState.getValue() == null) {
                    i = 0;
                } else {
                    Object value = mutableState2.getValue();
                    value.getClass();
                    long jMo607localToScreenMKHz9U = ((LayoutCoordinates) value).mo607localToScreenMKHz9U(0L);
                    Object value2 = mutableState.getValue();
                    value2.getClass();
                    long j = ((Offset) value2).packedValue;
                    if (Float.intBitsToFloat((int) (j >> 32)) <= Float.intBitsToFloat((int) (jMo607localToScreenMKHz9U >> 32))) {
                        i = Float.intBitsToFloat((int) (j & 4294967295L)) < Float.intBitsToFloat((int) (jMo607localToScreenMKHz9U & 4294967295L)) ? 1 : 3;
                    } else {
                        i = Float.intBitsToFloat((int) (j & 4294967295L)) < Float.intBitsToFloat((int) (jMo607localToScreenMKHz9U & 4294967295L)) ? 2 : 4;
                    }
                }
                return Integer.valueOf(i);
            case 1:
                mutableState2.setValue(Boolean.FALSE);
                mutableState.setValue(Boolean.TRUE);
                return unit;
            case 2:
                mutableState2.setValue(null);
                mutableState.setValue(null);
                return unit;
            case 3:
                if (!((Boolean) mutableState2.getValue()).booleanValue()) {
                    mutableState.setValue(Boolean.FALSE);
                }
                return unit;
            case 4:
                if (!((Boolean) mutableState2.getValue()).booleanValue()) {
                    mutableState.setValue(Boolean.FALSE);
                }
                return unit;
            case 5:
                mutableState2.setValue(Boolean.FALSE);
                mutableState.setValue(new TextFieldValue(7, 0L, (String) null));
                return unit;
            case 6:
                mutableState2.setValue(null);
                mutableState.setValue(null);
                return unit;
            case 7:
                mutableState2.setValue(null);
                WebView webView = (WebView) mutableState.getValue();
                if (webView != null) {
                    webView.reload();
                }
                return unit;
            case 8:
                mutableState2.setValue(Boolean.FALSE);
                mutableState.setValue(new TextFieldValue(7, 0L, (String) null));
                return unit;
            case 9:
                mutableState2.setValue(Boolean.FALSE);
                mutableState.setValue(new TextFieldValue(7, 0L, (String) null));
                return unit;
            case 10:
                mutableState2.setValue(Boolean.FALSE);
                mutableState.setValue(new TextFieldValue(7, 0L, (String) null));
                return unit;
            case 11:
                mutableState2.setValue(Boolean.FALSE);
                mutableState.setValue(new TextFieldValue(7, 0L, (String) null));
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                mutableState2.setValue(Boolean.FALSE);
                mutableState.setValue(new TextFieldValue(7, 0L, (String) null));
                return unit;
            case 13:
                mutableState2.setValue(Boolean.FALSE);
                mutableState.setValue(new TextFieldValue(7, 0L, (String) null));
                return unit;
            case 14:
                mutableState2.setValue(Boolean.FALSE);
                mutableState.setValue(new TextFieldValue(7, 0L, (String) null));
                return unit;
            case 15:
                mutableState2.setValue(Boolean.FALSE);
                mutableState.setValue(null);
                return unit;
            case 16:
                mutableState2.setValue(null);
                mutableState.setValue(Boolean.TRUE);
                return unit;
            case 17:
                mutableState2.setValue(Boolean.FALSE);
                mutableState.setValue(null);
                return unit;
            case 18:
                ((Function0) mutableState2.getValue()).invoke();
                mutableState.setValue(Boolean.FALSE);
                return unit;
            default:
                mutableState2.setValue("");
                mutableState.setValue(Boolean.FALSE);
                return unit;
        }
    }
}
