package androidx.compose.ui.layout;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.io.Serializable;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RectRulersImpl {
    public final /* synthetic */ byte $r8$classId;
    public final VerticalRuler bottom;
    public final VerticalRuler left;
    public final Serializable name;
    public final VerticalRuler right;
    public final VerticalRuler top;

    /* JADX WARN: Multi-variable type inference failed */
    public RectRulersImpl(RectRulersImpl[] rectRulersImplArr) {
        final byte b = 1;
        this.$r8$classId = (byte) 1;
        this.name = rectRulersImplArr;
        int length = rectRulersImplArr.length;
        final VerticalRuler[] verticalRulerArr = new VerticalRuler[length];
        final byte b2 = 0;
        for (int i = 0; i < length; i++) {
            verticalRulerArr[i] = ((RectRulersImpl[]) this.name)[i].getLeft();
        }
        this.left = new VerticalRuler(new Function2() { // from class: androidx.compose.ui.layout.VerticalRuler$Companion$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                float fMergeRulerValues;
                byte b3 = b;
                VerticalRuler[] verticalRulerArr2 = verticalRulerArr;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                float fFloatValue = ((Float) obj2).floatValue();
                switch (b3) {
                    case 0:
                        fMergeRulerValues = RulerKt.mergeRulerValues(placementScope, false, verticalRulerArr2, fFloatValue);
                        break;
                    default:
                        fMergeRulerValues = RulerKt.mergeRulerValues(placementScope, true, verticalRulerArr2, fFloatValue);
                        break;
                }
                return Float.valueOf(fMergeRulerValues);
            }
        }, (byte) 0);
        int length2 = ((RectRulersImpl[]) this.name).length;
        final VerticalRuler[] verticalRulerArr2 = new VerticalRuler[length2];
        for (int i2 = 0; i2 < length2; i2++) {
            verticalRulerArr2[i2] = ((RectRulersImpl[]) this.name)[i2].getTop();
        }
        this.top = new VerticalRuler(new Function2() { // from class: androidx.compose.ui.layout.HorizontalRuler$Companion$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                float fMergeRulerValues;
                byte b3 = b;
                VerticalRuler[] verticalRulerArr3 = verticalRulerArr2;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                float fFloatValue = ((Float) obj2).floatValue();
                switch (b3) {
                    case 0:
                        fMergeRulerValues = RulerKt.mergeRulerValues(placementScope, false, verticalRulerArr3, fFloatValue);
                        break;
                    default:
                        fMergeRulerValues = RulerKt.mergeRulerValues(placementScope, true, verticalRulerArr3, fFloatValue);
                        break;
                }
                return Float.valueOf(fMergeRulerValues);
            }
        }, (byte) 1);
        int length3 = ((RectRulersImpl[]) this.name).length;
        final VerticalRuler[] verticalRulerArr3 = new VerticalRuler[length3];
        for (int i3 = 0; i3 < length3; i3++) {
            verticalRulerArr3[i3] = ((RectRulersImpl[]) this.name)[i3].getRight();
        }
        this.right = new VerticalRuler(new Function2() { // from class: androidx.compose.ui.layout.VerticalRuler$Companion$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                float fMergeRulerValues;
                byte b3 = b2;
                VerticalRuler[] verticalRulerArr4 = verticalRulerArr3;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                float fFloatValue = ((Float) obj2).floatValue();
                switch (b3) {
                    case 0:
                        fMergeRulerValues = RulerKt.mergeRulerValues(placementScope, false, verticalRulerArr4, fFloatValue);
                        break;
                    default:
                        fMergeRulerValues = RulerKt.mergeRulerValues(placementScope, true, verticalRulerArr4, fFloatValue);
                        break;
                }
                return Float.valueOf(fMergeRulerValues);
            }
        }, (byte) 0);
        int length4 = ((RectRulersImpl[]) this.name).length;
        final VerticalRuler[] verticalRulerArr4 = new VerticalRuler[length4];
        for (int i4 = 0; i4 < length4; i4++) {
            verticalRulerArr4[i4] = ((RectRulersImpl[]) this.name)[i4].getBottom();
        }
        this.bottom = new VerticalRuler(new Function2() { // from class: androidx.compose.ui.layout.HorizontalRuler$Companion$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                float fMergeRulerValues;
                byte b3 = b2;
                VerticalRuler[] verticalRulerArr5 = verticalRulerArr4;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                float fFloatValue = ((Float) obj2).floatValue();
                switch (b3) {
                    case 0:
                        fMergeRulerValues = RulerKt.mergeRulerValues(placementScope, false, verticalRulerArr5, fFloatValue);
                        break;
                    default:
                        fMergeRulerValues = RulerKt.mergeRulerValues(placementScope, true, verticalRulerArr5, fFloatValue);
                        break;
                }
                return Float.valueOf(fMergeRulerValues);
            }
        }, (byte) 1);
    }

    public final VerticalRuler getBottom() {
        byte b = this.$r8$classId;
        return this.bottom;
    }

    public final VerticalRuler getLeft() {
        byte b = this.$r8$classId;
        return this.left;
    }

    public final VerticalRuler getRight() {
        byte b = this.$r8$classId;
        return this.right;
    }

    public final VerticalRuler getTop() {
        byte b = this.$r8$classId;
        return this.top;
    }

    public final String toString() {
        byte b = this.$r8$classId;
        Object obj = this.name;
        switch (b) {
            case 0:
                String str = (String) obj;
                return str != null ? IntIntPair$$ExternalSyntheticOutline0.m("RectRulers(", str, ")") : super.toString();
            default:
                return ArraysKt.joinToString$default((RectRulersImpl[]) obj, null, 57);
        }
    }

    public RectRulersImpl(String str) {
        this.$r8$classId = (byte) 0;
        this.name = str;
        this.left = new VerticalRuler(null, (byte) 0);
        this.top = new VerticalRuler(null, (byte) 1);
        this.right = new VerticalRuler(null, (byte) 0);
        this.bottom = new VerticalRuler(null, (byte) 1);
    }
}
