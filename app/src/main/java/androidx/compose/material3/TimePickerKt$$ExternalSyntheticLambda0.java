package androidx.compose.material3;

import android.view.View;
import androidx.compose.foundation.contextmenu.ContextMenuColors;
import androidx.compose.foundation.contextmenu.ContextMenuUiKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazySaveableStateHolder;
import androidx.compose.foundation.text.TextLinkScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LifecycleStartStopEffectScope;
import coil3.util.FileSystemsKt;
import coil3.util.LifecyclesKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TimePickerKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda0(int i, Function0 function0, Function0 function1, Function0 function2, int i2) {
        this.$r8$classId = (byte) 16;
        this.f$3 = i;
        this.f$0 = function0;
        this.f$1 = function1;
        this.f$2 = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        int i = this.f$3;
        Object obj3 = this.f$2;
        Object obj4 = this.f$1;
        Unit unit = Unit.INSTANCE;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                TimePickerKt.m354TimePickermT9BvqQ((TimePickerState) obj5, (Modifier) obj4, (TimePickerColors) obj3, this.f$3, (Composer) obj, iUpdateChangedFlags);
                break;
            case 1:
                ((Integer) obj2).getClass();
                ContextMenuUiKt.ContextMenuColumn((ContextMenuColors) obj5, (Modifier) obj4, (ComposableLambdaImpl) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 2:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(1);
                LazyLayoutKt.m174SkippableItemJVlU9Rs((LazyLayoutItemProvider) obj5, this.f$1, this.f$3, this.f$2, (Composer) obj, iUpdateChangedFlags2);
                break;
            case 3:
                ((Integer) obj2).getClass();
                ((LazySaveableStateHolder) obj5).SaveableStateProvider(obj4, (ComposableLambdaImpl) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 4:
                ((Integer) obj2).getClass();
                ((TextLinkScope) obj5).StyleAnnotation((Object[]) obj4, (Function1) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 5:
                ((Integer) obj2).intValue();
                DefaultTextContextMenuDropdownProvider_androidKt.OpenContextMenu((TextContextMenuSession) obj5, (TextContextMenuDataProvider) obj4, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 6:
                ((Integer) obj2).getClass();
                DatabaseDao_Impl.AnonymousClass17.ProvideBasicTextContextMenu((Modifier) obj4, (ProvidableCompositionLocal) obj5, (ComposableLambdaImpl) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 7:
                ((Integer) obj2).getClass();
                FileSystemsKt.HandlePopup((OffsetProvider) obj5, (Alignment) obj4, (ComposableLambdaImpl) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 8:
                ((Integer) obj2).intValue();
                CardKt.SoftKeyboardListener((View) obj5, (Density) obj4, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 9:
                ((Integer) obj2).getClass();
                ((ComposableLambdaImpl) obj5).invoke(obj4, obj3, (Composer) obj, Stack.updateChangedFlags(i) | 1);
                break;
            case 10:
                ((Integer) obj2).getClass();
                ((SaveableStateHolderImpl) obj5).SaveableStateProvider(obj4, (ComposableLambdaImpl) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 11:
                ((Integer) obj2).getClass();
                RulerKt.SubcomposeLayout((SubcomposeLayoutState) obj5, (Modifier) obj4, (Function2) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((Integer) obj2).getClass();
                AndroidView_androidKt.AndroidView((Function1) obj5, (Modifier) obj4, (Function1) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 13:
                ((Integer) obj2).getClass();
                AndroidDialog_androidKt.Dialog((Function0) obj5, (DialogProperties) obj4, (ComposableLambdaImpl) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 14:
                ((Integer) obj2).intValue();
                LifecyclesKt.LifecycleStartEffectImpl((LifecycleOwner) obj5, (LifecycleStartStopEffectScope) obj4, (Function1) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            case 15:
                ((Integer) obj2).getClass();
                DialogKt.ListDialog((Function0) obj5, (Modifier) obj4, (Function1) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(1);
                AlbumMenuKt.TopPlaylistMenu(this.f$3, (Function0) obj5, (Function0) obj4, (Function0) obj3, (Composer) obj, iUpdateChangedFlags3);
                break;
        }
        return unit;
    }

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda0(byte b, int i, Object obj, Object obj2, Object obj3) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = i;
    }

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda0(LazyLayoutItemProvider lazyLayoutItemProvider, Object obj, int i, Object obj2, int i2) {
        this.$r8$classId = (byte) 2;
        this.f$0 = lazyLayoutItemProvider;
        this.f$1 = obj;
        this.f$3 = i;
        this.f$2 = obj2;
    }

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda0(TimePickerState timePickerState, Modifier modifier, TimePickerColors timePickerColors, int i, int i2) {
        this.$r8$classId = (byte) 0;
        this.f$0 = timePickerState;
        this.f$1 = modifier;
        this.f$2 = timePickerColors;
        this.f$3 = i;
    }

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda0(Modifier modifier, ProvidableCompositionLocal providableCompositionLocal, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.$r8$classId = (byte) 6;
        this.f$1 = modifier;
        this.f$0 = providableCompositionLocal;
        this.f$2 = composableLambdaImpl;
        this.f$3 = i;
    }
}
