package androidx.compose.ui.window;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import coil3.network.okhttp.internal.CallsKt$await$2$1;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.io.TextStreamsKt$$ExternalSyntheticLambda0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPopup_androidKt$SimpleStack$1$1 implements MeasurePolicy {
    public final /* synthetic */ byte $r8$classId;
    public static final AndroidPopup_androidKt$SimpleStack$1$1 INSTANCE$1 = new AndroidPopup_androidKt$SimpleStack$1$1(1);
    public static final AndroidPopup_androidKt$SimpleStack$1$1 INSTANCE = new AndroidPopup_androidKt$SimpleStack$1$1(0);

    /* JADX INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Function1 {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass3 implements Function1 {
        public final /* synthetic */ ArrayList $placeables;
        public final /* synthetic */ byte $r8$classId;

        public /* synthetic */ AnonymousClass3(ArrayList arrayList, byte b) {
            this.$r8$classId = b;
            this.$placeables = arrayList;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            byte b = this.$r8$classId;
            ArrayList arrayList = this.$placeables;
            switch (b) {
                case 0:
                    Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                    int size = arrayList.size() - 1;
                    if (size >= 0) {
                        int i = 0;
                        while (true) {
                            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) arrayList.get(i), 0, 0);
                            if (i != size) {
                                i++;
                            }
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 2:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 3:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 4:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 5:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 6:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 7:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 8:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 9:
                    return "chart_song";
                case 10:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 11:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 13:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 14:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 15:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 16:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 17:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 18:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 19:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 20:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 21:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 22:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 23:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 24:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 25:
                    arrayList.get(((Number) obj).intValue());
                    return null;
                case 26:
                    return 2;
                default:
                    arrayList.get(((Number) obj).intValue());
                    return null;
            }
        }
    }

    public /* synthetic */ AndroidPopup_androidKt$SimpleStack$1$1(byte b) {
        this.$r8$classId = b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo13measure3p2s80s(MeasureScope measureScope, List list, long j) {
        byte b = this.$r8$classId;
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        Object[] objArr = 0;
        switch (b) {
            case 0:
                int size = list.size();
                if (size == 0) {
                    return measureScope.layout(0, 0, emptyMap, AnonymousClass1.INSTANCE);
                }
                if (size == 1) {
                    Placeable placeableMo598measureBRTryo0 = ((Measurable) list.get(0)).mo598measureBRTryo0(j);
                    return measureScope.layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, emptyMap, new CallsKt$await$2$1((byte) 7, placeableMo598measureBRTryo0));
                }
                ArrayList arrayList = new ArrayList(list.size());
                int size2 = list.size();
                int iMax = 0;
                int iMax2 = 0;
                for (int i = 0; i < size2; i++) {
                    Placeable placeableMo598measureBRTryo1 = ((Measurable) list.get(i)).mo598measureBRTryo0(j);
                    iMax = Math.max(iMax, placeableMo598measureBRTryo1.width);
                    iMax2 = Math.max(iMax2, placeableMo598measureBRTryo1.height);
                    arrayList.add(placeableMo598measureBRTryo1);
                }
                return measureScope.layout(iMax, iMax2, emptyMap, new AnonymousClass3(arrayList, objArr == true ? 1 : 0));
            default:
                ArrayList arrayList2 = new ArrayList(list.size());
                int size3 = list.size();
                int iM786getMinWidthimpl = 0;
                int iM785getMinHeightimpl = 0;
                for (int i2 = 0; i2 < size3; i2++) {
                    Placeable placeableMo598measureBRTryo2 = ((Measurable) list.get(i2)).mo598measureBRTryo0(j);
                    iM786getMinWidthimpl = Math.max(iM786getMinWidthimpl, placeableMo598measureBRTryo2.width);
                    iM785getMinHeightimpl = Math.max(iM785getMinHeightimpl, placeableMo598measureBRTryo2.height);
                    arrayList2.add(placeableMo598measureBRTryo2);
                }
                if (list.isEmpty()) {
                    iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(j);
                    iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(j);
                }
                return measureScope.layout(iM786getMinWidthimpl, iM785getMinHeightimpl, emptyMap, new TextStreamsKt$$ExternalSyntheticLambda0(arrayList2, (byte) 6));
        }
    }
}
