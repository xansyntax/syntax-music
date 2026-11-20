package io.ktor.websocket;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.text.input.TextFieldValue;
import com.metrolist.music.ui.component.LensController;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.uuid.UuidKt;
import kotlinx.io.Source;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RawWebSocketCommonKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ int f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ RawWebSocketCommonKt$$ExternalSyntheticLambda0(int i, Object obj, byte b) {
        this.$r8$classId = b;
        this.f$0 = i;
        this.f$1 = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ArrayList arrayListPlus;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$1;
        int i = this.f$0;
        switch (b) {
            case 0:
                return RawWebSocketCommonKt.mask$lambda$0(i, (Source) obj2, (byte[]) obj);
            case 1:
                return Boolean.valueOf(((List) obj).addAll(i, (Collection) obj2));
            case 2:
                boolean zM418requestFocus3ESFkO8 = ((FocusTargetNode) obj).m418requestFocus3ESFkO8(i);
                ((Ref$ObjectRef) obj2).element = Boolean.valueOf(zM418requestFocus3ESFkO8);
                return Boolean.valueOf(zM418requestFocus3ESFkO8);
            case 3:
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                reusableGraphicsLayerScope.getClass();
                reusableGraphicsLayerScope.setAlpha(UuidKt.coerceIn(((1.0f - Math.abs(((Number) ((LensController) obj2).pos.getValue()).floatValue() - i)) * 1.3f) - 0.3f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
                return unit;
            case 4:
                Function2 function2 = (Function2) obj2;
                TextFieldValue textFieldValue = (TextFieldValue) obj;
                textFieldValue.getClass();
                if (function2 != null) {
                    function2.invoke(Integer.valueOf(i), textFieldValue);
                }
                return unit;
            default:
                MutableState mutableState = (MutableState) obj2;
                ((Boolean) obj).getClass();
                if (((List) mutableState.getValue()).contains(Integer.valueOf(i))) {
                    arrayListPlus = CollectionsKt.minus((List) mutableState.getValue(), Integer.valueOf(i));
                } else {
                    arrayListPlus = CollectionsKt.plus(Integer.valueOf(i), (List) mutableState.getValue());
                }
                mutableState.setValue(arrayListPlus);
                return unit;
        }
    }

    public /* synthetic */ RawWebSocketCommonKt$$ExternalSyntheticLambda0(Object obj, int i, byte b) {
        this.$r8$classId = b;
        this.f$1 = obj;
        this.f$0 = i;
    }
}
