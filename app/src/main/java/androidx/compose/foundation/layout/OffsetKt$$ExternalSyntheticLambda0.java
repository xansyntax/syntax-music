package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.lazy.LazyListMeasureResult;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.pager.DefaultPagerState;
import androidx.compose.foundation.text.TextFieldDelegateKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import io.ktor.http.Url$$ExternalSyntheticLambda0;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class OffsetKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ OffsetKt$$ExternalSyntheticLambda0(int i, LazyListMeasureResult lazyListMeasureResult) {
        this.$r8$classId = (byte) 15;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                throw IntIntPair$$ExternalSyntheticOutline0.m(obj);
            case 1:
                ((Float) obj).getClass();
                return unit;
            case 2:
                return unit;
            case 3:
                return unit;
            case 4:
                return unit;
            case 5:
                return unit;
            case 6:
                throw IntIntPair$$ExternalSyntheticOutline0.m(obj);
            case 7:
                throw IntIntPair$$ExternalSyntheticOutline0.m(obj);
            case 8:
                throw IntIntPair$$ExternalSyntheticOutline0.m(obj);
            case 9:
                throw IntIntPair$$ExternalSyntheticOutline0.m(obj);
            case 10:
                return unit;
            case 11:
                return ((WindowInsetsHolder) obj).statusBars;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return ((WindowInsetsHolder) obj).ime;
            case 13:
                return unit;
            case 14:
                List list = (List) obj;
                return new LazyListState(((Number) list.get(0)).intValue(), ((Number) list.get(1)).intValue());
            case 15:
                return unit;
            case 16:
                return unit;
            case 17:
                List list2 = (List) obj;
                return new LazyGridState(((Number) list2.get(0)).intValue(), ((Number) list2.get(1)).intValue());
            case 18:
                ((Integer) obj).getClass();
                return EmptyList.INSTANCE;
            case 19:
                ((Integer) obj).getClass();
                return -1;
            case 20:
                List list3 = (List) obj;
                Object obj2 = list3.get(0);
                obj2.getClass();
                int iIntValue = ((Integer) obj2).intValue();
                Object obj3 = list3.get(1);
                obj3.getClass();
                return new DefaultPagerState(iIntValue, ((Float) obj3).floatValue(), new Url$$ExternalSyntheticLambda0(list3, (byte) 1));
            case 21:
                return unit;
            case 22:
                KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
                ((SemanticsPropertyReceiver) obj).set(SemanticsProperties.SelectableGroup, unit);
                return unit;
            case 23:
                return unit;
            case 24:
                return unit;
            case 25:
                return unit;
            case 26:
                return unit;
            case 27:
                return unit;
            case 28:
                return unit;
            default:
                ((Integer) obj).intValue();
                return TextFieldDelegateKt.EmptyTextReplacement;
        }
    }

    public /* synthetic */ OffsetKt$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }
}
