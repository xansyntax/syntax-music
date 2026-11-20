package androidx.room;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.graphics.shapes.Cubic;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.compose.BackStackEntryIdViewModel;
import androidx.navigation.compose.ComposeNavigator;
import androidx.navigation.internal.NavBackStackEntryImpl;
import androidx.navigation.internal.NavGraphImpl;
import androidx.sqlite.SQLiteStatement;
import androidx.window.layout.WindowMetricsCalculator;
import coil3.compose.AsyncImagePainter;
import coil3.util.FileSystemsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.charleskorn.kaml.YamlNodeSerializer$annotationImpl$com_charleskorn_kaml_YamlContentPolymorphicSerializer_Marker$0;
import com.materialkolor.dynamiccolor.ContrastCurve;
import com.materialkolor.scheme.DynamicScheme;
import com.materialkolor.scheme.Variant;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.SetBuilder;
import kotlin.jvm.functions.Function1;
import kotlin.text.CharsKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RoomDatabase$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ RoomDatabase$$ExternalSyntheticLambda2(RoomDatabase roomDatabase) {
        this.$r8$classId = (byte) 0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((DatabaseConfiguration) obj).getClass();
                throw new NotImplementedError(0);
            case 1:
                ((Context) obj).getClass();
                return EmptyList.INSTANCE;
            case 2:
                Map.Entry entry = (Map.Entry) obj;
                entry.getClass();
                Object value = entry.getValue();
                return "  " + ((Preferences$Key) entry.getKey()).name + " = " + (value instanceof byte[] ? ArraysKt.joinToString$default((byte[]) value, ", ", null, 56) : String.valueOf(entry.getValue()));
            case 3:
                Cubic cubic = (Cubic) obj;
                cubic.getClass();
                return "[" + cubic + ']';
            case 4:
                Context context = (Context) obj;
                context.getClass();
                if (context instanceof ContextWrapper) {
                    return ((ContextWrapper) context).getBaseContext();
                }
                return null;
            case 5:
                Context context2 = (Context) obj;
                context2.getClass();
                if (context2 instanceof ContextWrapper) {
                    return ((ContextWrapper) context2).getBaseContext();
                }
                return null;
            case 6:
                ((CreationExtras) obj).getClass();
                return new NavControllerViewModel();
            case 7:
                Context context3 = (Context) obj;
                context3.getClass();
                ContextWrapper contextWrapper = context3 instanceof ContextWrapper ? (ContextWrapper) context3 : null;
                if (contextWrapper != null) {
                    return contextWrapper.getBaseContext();
                }
                return null;
            case 8:
                Context context4 = (Context) obj;
                context4.getClass();
                if (context4 instanceof Activity) {
                    return (Activity) context4;
                }
                return null;
            case 9:
                NavDestination navDestination = (NavDestination) obj;
                navDestination.getClass();
                return navDestination.parent;
            case 10:
                NavDestination navDestination2 = (NavDestination) obj;
                navDestination2.getClass();
                if (!(navDestination2 instanceof NavGraph)) {
                    return null;
                }
                NavGraphImpl navGraphImpl = ((NavGraph) navDestination2).impl;
                return navGraphImpl.findNode$navigation_common_release(navGraphImpl.startDestId);
            case 11:
                return new BackStackEntryIdViewModel(ViewModelKt.createSavedStateHandle((CreationExtras) obj));
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                NavDestination navDestination3 = ((NavBackStackEntry) ((AnimatedContentTransitionScope) obj).getTargetState()).destination;
                navDestination3.getClass();
                int i = NavDestination.$r8$clinit;
                for (NavDestination navDestination4 : FileSystemsKt.getHierarchy((ComposeNavigator.Destination) navDestination3)) {
                }
                return null;
            case 13:
                return ((NavBackStackEntry) obj).id;
            case 14:
                CreationExtras creationExtras = (CreationExtras) obj;
                creationExtras.getClass();
                return new NavBackStackEntryImpl.SavedStateViewModel(ViewModelKt.createSavedStateHandle(creationExtras));
            case 15:
                NavDestination navDestination5 = (NavDestination) obj;
                navDestination5.getClass();
                return Integer.valueOf(navDestination5.impl.size);
            case 16:
                NavDestination navDestination6 = (NavDestination) obj;
                navDestination6.getClass();
                NavGraph navGraph = navDestination6.parent;
                if (navGraph == null || navGraph.impl.startDestId != navDestination6.impl.size) {
                    return null;
                }
                return navGraph;
            case 17:
                NavDestination navDestination7 = (NavDestination) obj;
                navDestination7.getClass();
                NavGraph navGraph2 = navDestination7.parent;
                if (navGraph2 == null || navGraph2.impl.startDestId != navDestination7.impl.size) {
                    return null;
                }
                return navGraph2;
            case 18:
                SQLiteStatement sQLiteStatement = (SQLiteStatement) obj;
                sQLiteStatement.getClass();
                return Boolean.valueOf(sQLiteStatement.step());
            case 19:
                SQLiteStatement sQLiteStatement2 = (SQLiteStatement) obj;
                sQLiteStatement2.getClass();
                SetBuilder setBuilder = new SetBuilder();
                while (sQLiteStatement2.step()) {
                    setBuilder.add(Integer.valueOf((int) sQLiteStatement2.getLong(0)));
                }
                return CharsKt.build(setBuilder);
            case 20:
                WindowMetricsCalculator windowMetricsCalculator = (WindowMetricsCalculator) obj;
                windowMetricsCalculator.getClass();
                return windowMetricsCalculator;
            case 21:
                return (AsyncImagePainter.State) obj;
            case 22:
                return unit;
            case 23:
                ClassSerialDescriptorBuilder classSerialDescriptorBuilder = (ClassSerialDescriptorBuilder) obj;
                classSerialDescriptorBuilder.getClass();
                classSerialDescriptorBuilder.annotations = CollectionsKt.plus(new YamlNodeSerializer$annotationImpl$com_charleskorn_kaml_YamlContentPolymorphicSerializer_Marker$0(), classSerialDescriptorBuilder.annotations);
                return unit;
            case 24:
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                dynamicScheme.getClass();
                return dynamicScheme.neutralPalette;
            case 25:
                DynamicScheme dynamicScheme2 = (DynamicScheme) obj;
                dynamicScheme2.getClass();
                return Double.valueOf(dynamicScheme2.isDark ? 90.0d : 10.0d);
            case 26:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d);
            case 27:
                DynamicScheme dynamicScheme3 = (DynamicScheme) obj;
                dynamicScheme3.getClass();
                return dynamicScheme3.tertiaryPalette;
            case 28:
                DynamicScheme dynamicScheme4 = (DynamicScheme) obj;
                dynamicScheme4.getClass();
                return Double.valueOf(dynamicScheme4.variant == Variant.MONOCHROME ? 30.0d : 80.0d);
            default:
                ((DynamicScheme) obj).getClass();
                return new ContrastCurve(1.0d, 1.0d, 3.0d, 4.5d);
        }
    }

    public /* synthetic */ RoomDatabase$$ExternalSyntheticLambda2(byte b) {
        this.$r8$classId = b;
    }
}
