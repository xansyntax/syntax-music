package coil3.size;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LocaleSpan;
import android.text.style.RelativeSizeSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.EdgeEffect;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.FloatFloatPair;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableScatterMap;
import androidx.compose.animation.FlingCalculator;
import androidx.compose.animation.core.AnimateAsState;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.FocusInteractionKt$collectIsFocusedAsState$1$1;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda14;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults;
import androidx.compose.material3.pulltorefresh.PullToRefreshElement;
import androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.composer.gapbuffer.changelist.Operations;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.autofill.ContentDataType$Companion;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.TailModifierNode;
import androidx.compose.ui.relocation.BringIntoViewModifierNode;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.text.MultiParagraph$$ExternalSyntheticLambda0;
import androidx.compose.ui.text.font.AndroidFontResolveInterceptor;
import androidx.compose.ui.text.font.FontFamilyResolverImpl;
import androidx.compose.ui.text.font.FontWeightAdjustmentHelperApi31;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.provider.FontsContractCompat$FontInfo;
import androidx.core.view.KeyEventDispatcher$Component;
import androidx.core.view.ViewCompat;
import androidx.core.widget.EdgeEffectCompat$Api31Impl;
import androidx.emoji2.text.EmojiProcessor;
import androidx.graphics.shapes.CornerRounding;
import androidx.graphics.shapes.Cubic;
import androidx.graphics.shapes.Feature;
import androidx.graphics.shapes.RoundedCorner;
import androidx.graphics.shapes.RoundedPolygon;
import androidx.graphics.shapes.Utils;
import androidx.media3.datasource.DataSource;
import androidx.media3.extractor.text.ttml.TtmlStyle;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavArgument;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavType;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.compose.ComposeNavigator;
import androidx.navigation.compose.ComposeNavigatorDestinationBuilder;
import androidx.navigation.internal.NavContext;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import coil3.size.SizeKt;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import com.dokar.quickjs.QuickJsException;
import com.google.common.math.IntMath;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda6;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IntIterator;
import kotlin.collections.builders.ListBuilder;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.LinesSequence;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeReference;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.TransformingSequence;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__IndentKt$$ExternalSyntheticLambda0;
import kotlin.uuid.UuidKt;
import okhttp3.ConnectionSpec;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SizeKt {
    public static boolean sActionBarFieldsFetched = false;
    public static Method sActionBarOnMenuKeyMethod = null;
    public static boolean sDialogFieldsFetched = false;
    public static Field sDialogKeyListenerField;

    public SizeKt() {
        new ConcurrentHashMap();
    }

    /* JADX INFO: renamed from: CircularArrowProgressIndicator-RPmYEkk, reason: not valid java name */
    public static final void m860CircularArrowProgressIndicatorRPmYEkk(FloatProducer floatProducer, long j, Composer composer, int i) {
        GapComposer gapComposer;
        Object obj;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(-1353562852);
        int i2 = i | (gapComposer2.changed(floatProducer) ? 4 : 2) | (gapComposer2.changed(j) ? 32 : 16);
        byte b = 1;
        if (gapComposer2.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                obj = objRememberedValue;
                AndroidPath androidPathPath = AndroidPath_androidKt.Path();
                androidPathPath.m471setFillTypeoQ8Xj4U(1);
                gapComposer2.updateRememberedValue(androidPathPath);
                obj = androidPathPath;
            }
            obj = objRememberedValue;
            AndroidPath androidPath = (AndroidPath) obj;
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            Object obj2 = objRememberedValue2;
            if (objRememberedValue2 == neverEqualPolicy) {
                DerivedSnapshotState derivedSnapshotStateDerivedStateOf = SnapshotStateKt__DerivedStateKt.derivedStateOf(new RoomDatabase$$ExternalSyntheticLambda0(b, floatProducer));
                gapComposer2.updateRememberedValue(derivedSnapshotStateDerivedStateOf);
                obj2 = derivedSnapshotStateDerivedStateOf;
            }
            AnimateAsState animateAsStateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(((Number) ((State) obj2).getValue()).floatValue(), CardKt.m272valueyDoVZcs(3, gapComposer2), null, gapComposer2, 0, 28);
            GapComposer gapComposer3 = gapComposer2;
            int i3 = i2 & 14;
            boolean z = i3 == 4;
            Object objRememberedValue3 = gapComposer3.rememberedValue();
            Object obj3 = objRememberedValue3;
            if (z || objRememberedValue3 == neverEqualPolicy) {
                TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2 = new TextKt$$ExternalSyntheticLambda2((byte) 9, floatProducer);
                gapComposer3.updateRememberedValue(textKt$$ExternalSyntheticLambda2);
                obj3 = textKt$$ExternalSyntheticLambda2;
            }
            Modifier modifierM151size3ABfNKs = androidx.compose.foundation.layout.SizeKt.m151size3ABfNKs(SemanticsModifierKt.clearAndSetSemantics(Modifier.Companion.$$INSTANCE, (Function1) obj3), 16.0f);
            int i4 = (((i3 != 4 ? (char) 0 : (char) 1) | (gapComposer3.changed(animateAsStateAnimateFloatAsState) ? 1 : 0)) == true ? 1 : 0) | ((i2 & 112) != 32 ? (byte) 0 : (byte) 1) | (gapComposer3.changedInstance(androidPath) ? 1 : 0);
            Object objRememberedValue4 = gapComposer3.rememberedValue();
            if (i4 != 0 || objRememberedValue4 == neverEqualPolicy) {
                MultiParagraph$$ExternalSyntheticLambda0 multiParagraph$$ExternalSyntheticLambda0 = new MultiParagraph$$ExternalSyntheticLambda0(floatProducer, animateAsStateAnimateFloatAsState, j, androidPath, (byte) 2);
                gapComposer3.updateRememberedValue(multiParagraph$$ExternalSyntheticLambda0);
                objRememberedValue4 = multiParagraph$$ExternalSyntheticLambda0;
            }
            ImageKt.Canvas(0, gapComposer3, modifierM151size3ABfNKs, (Function1) objRememberedValue4);
            gapComposer = gapComposer3;
        } else {
            GapComposer gapComposer4 = gapComposer2;
            gapComposer4.skipToGroupEnd();
            gapComposer = gapComposer4;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ListItemKt$$ExternalSyntheticLambda14(floatProducer, j, i, (byte) 1);
        }
    }

    public static final long Offset(float f, float f2) {
        return (((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32);
    }

    /* JADX WARN: Failed to calculate best type for var: r12v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v1 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r12v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v1 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v1 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v10 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v12 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v14 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v14 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v16 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v16 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v17 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v17 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v18 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v18 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v2 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v8 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r17v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v10 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r17v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v12 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r17v13 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v13 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r17v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v9 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r24v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r24v1 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v1 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r60v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r60v0 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r61v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r61v0 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r8v26 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v26 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v2 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v8 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r60v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r60v0 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to set immutable type for var: r61v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r61v0 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v1 ??, new type: int
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    /* JADX INFO: renamed from: Pager-WMpiP2s, reason: not valid java name */
    public static final void m861PagerWMpiP2s(androidx.compose.ui.Modifier r43, androidx.compose.foundation.pager.PagerState r44, androidx.compose.foundation.layout.PaddingValuesImpl r45, androidx.compose.foundation.gestures.Orientation r46, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r47, boolean r48, androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r49, int r50, float r51, androidx.compose.foundation.pager.PageSize r52, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r53, androidx.compose.ui.Alignment.Horizontal r54, androidx.compose.ui.Alignment.Vertical r55, androidx.compose.foundation.gestures.snapping.SnapPosition r56, androidx.compose.foundation.gestures.BringIntoViewSpec r57, androidx.compose.runtime.internal.ComposableLambdaImpl r58, androidx.compose.runtime.Composer r59, int r60, int r61) {
        /*
            Method dump skipped, instruction units count: 1307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.size.SizeKt.m861PagerWMpiP2s(androidx.compose.ui.Modifier, androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.layout.PaddingValuesImpl, androidx.compose.foundation.gestures.Orientation, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior, boolean, androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect, int, float, androidx.compose.foundation.pager.PageSize, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, androidx.compose.ui.Alignment$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.snapping.SnapPosition, androidx.compose.foundation.gestures.BringIntoViewSpec, androidx.compose.runtime.internal.ComposableLambdaImpl, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: renamed from: PullToRefreshBox-gMrHQkA, reason: not valid java name */
    public static final void m862PullToRefreshBoxgMrHQkA(final boolean z, final Function0 function0, Modifier modifier, final PullToRefreshStateImpl pullToRefreshStateImpl, Alignment alignment, Function3 function3, boolean z2, float f, ComposableLambdaImpl composableLambdaImpl, Composer composer, final int i) {
        final Function3 function4;
        final ComposableLambdaImpl composableLambdaImpl2;
        final Modifier modifier2;
        final Alignment alignment2;
        final boolean z3;
        final float f2;
        Alignment alignment3;
        float f3;
        Modifier modifier3;
        boolean z4;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(492221845);
        int i2 = i | (gapComposer.changed(z) ? 4 : 2) | (gapComposer.changedInstance(function0) ? 32 : 16) | 384 | (gapComposer.changed(pullToRefreshStateImpl) ? 2048 : 1024) | 14180352;
        if (gapComposer.shouldExecute(i2 & 1, (38347923 & i2) != 38347922)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                alignment3 = Alignment.Companion.TopStart;
                f3 = PullToRefreshDefaults.PositionalThreshold;
                modifier3 = Modifier.Companion.$$INSTANCE;
                z4 = true;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier;
                alignment3 = alignment;
                z4 = z2;
                f3 = f;
            }
            gapComposer.endDefaults();
            Modifier modifierThen = modifier3.then(new PullToRefreshElement(z, function0, z4, pullToRefreshStateImpl, f3));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(alignment3, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composableLambdaImpl2 = composableLambdaImpl;
            composableLambdaImpl2.invoke((Object) boxScopeInstance, (Object) gapComposer, (Object) 54);
            function4 = function3;
            function4.invoke(boxScopeInstance, gapComposer, 54);
            gapComposer.end(true);
            Alignment alignment4 = alignment3;
            f2 = f3;
            alignment2 = alignment4;
            z3 = z4;
            modifier2 = modifier3;
        } else {
            function4 = function3;
            composableLambdaImpl2 = composableLambdaImpl;
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            alignment2 = alignment;
            z3 = z2;
            f2 = f;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(z, function0, modifier2, pullToRefreshStateImpl, alignment2, function4, z3, f2, composableLambdaImpl2, i) { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda1
                public final /* synthetic */ boolean f$0;
                public final /* synthetic */ Function0 f$1;
                public final /* synthetic */ Modifier f$2;
                public final /* synthetic */ PullToRefreshStateImpl f$3;
                public final /* synthetic */ Alignment f$4;
                public final /* synthetic */ Function3 f$5;
                public final /* synthetic */ boolean f$6;
                public final /* synthetic */ float f$7;
                public final /* synthetic */ ComposableLambdaImpl f$8;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(100859905);
                    SizeKt.m862PullToRefreshBoxgMrHQkA(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final RoundedPolygon RoundedPolygon(float[] fArr, CornerRounding cornerRounding, AbstractList abstractList, float f, float f2) {
        float f3;
        int i;
        List listListOf;
        Cubic Cubic;
        CornerRounding cornerRounding2;
        float f4 = 1.0f;
        Float fValueOf = Float.valueOf(1.0f);
        cornerRounding.getClass();
        RoundedPolygon roundedPolygon = null;
        if (fArr.length < 6) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Polygons must have at least 3 vertices");
            return null;
        }
        int i2 = 2;
        int i3 = 1;
        if (fArr.length % 2 == 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("The vertices array should have even size");
            return null;
        }
        if (abstractList != null && abstractList.size() * 2 != fArr.length) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("perVertexRounding list should be either null or the same size as the number of vertices (vertices.size / 2)");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = fArr.length / 2;
        ArrayList arrayList2 = new ArrayList();
        int i4 = 0;
        int i5 = 0;
        while (i5 < length) {
            CornerRounding cornerRounding3 = (abstractList == null || (cornerRounding2 = (CornerRounding) abstractList.get(i5)) == null) ? cornerRounding : cornerRounding2;
            int i6 = (((i5 + length) - 1) % length) * 2;
            int i7 = i5 + 1;
            int i8 = (i7 % length) * 2;
            int i9 = i5 * 2;
            arrayList2.add(new RoundedCorner(FloatFloatPair.m0constructorimpl(fArr[i6], fArr[i6 + 1]), FloatFloatPair.m0constructorimpl(fArr[i9], fArr[i9 + 1]), FloatFloatPair.m0constructorimpl(fArr[i8], fArr[i8 + 1]), cornerRounding3));
            i5 = i7;
            f4 = f4;
        }
        float f5 = f4;
        IntRange intRangeUntil = UuidKt.until(0, length);
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator it = intRangeUntil.iterator();
        while (true) {
            boolean z = ((IntProgressionIterator) it).hasNext;
            f3 = CropImageView.DEFAULT_ASPECT_RATIO;
            if (!z) {
                break;
            }
            int iNextInt = ((IntIterator) it).nextInt();
            int i10 = (iNextInt + 1) % length;
            float f6 = ((RoundedCorner) arrayList2.get(iNextInt)).expectedRoundCut + ((RoundedCorner) arrayList2.get(i10)).expectedRoundCut;
            float expectedCut = ((RoundedCorner) arrayList2.get(i10)).getExpectedCut() + ((RoundedCorner) arrayList2.get(iNextInt)).getExpectedCut();
            int i11 = iNextInt * 2;
            float f7 = fArr[i11];
            float f8 = fArr[i11 + 1];
            int i12 = i10 * 2;
            float f9 = f7 - fArr[i12];
            float f10 = f8 - fArr[i12 + 1];
            float f11 = Utils.FloatPi;
            float fSqrt = (float) Math.sqrt((f10 * f10) + (f9 * f9));
            arrayList3.add(f6 > fSqrt ? new Pair(Float.valueOf(fSqrt / f6), Float.valueOf(CropImageView.DEFAULT_ASPECT_RATIO)) : expectedCut > fSqrt ? new Pair(fValueOf, Float.valueOf((fSqrt - f6) / (expectedCut - f6))) : new Pair(fValueOf, fValueOf));
        }
        for (int i13 = 0; i13 < length; i13 = i + 1) {
            float[] fArrCopyOf = new float[i2];
            int i14 = i4;
            int i15 = i14;
            while (i14 < i2) {
                RoundedPolygon roundedPolygon2 = roundedPolygon;
                Pair pair = (Pair) arrayList3.get((((i13 + length) - 1) + i14) % length);
                int i16 = i4;
                float f12 = f3;
                int i17 = i2;
                float expectedCut2 = ((((RoundedCorner) arrayList2.get(i13)).getExpectedCut() - ((RoundedCorner) arrayList2.get(i13)).expectedRoundCut) * ((Number) pair.second).floatValue()) + (((RoundedCorner) arrayList2.get(i13)).expectedRoundCut * ((Number) pair.first).floatValue());
                int i18 = i15 + 1;
                if (fArrCopyOf.length < i18) {
                    fArrCopyOf = Arrays.copyOf(fArrCopyOf, Math.max(i18, (fArrCopyOf.length * 3) / 2));
                }
                fArrCopyOf[i15] = expectedCut2;
                i14++;
                f3 = f12;
                i15 = i18;
                fArrCopyOf = fArrCopyOf;
                i4 = i16;
                roundedPolygon = roundedPolygon2;
                i2 = i17;
            }
            int i19 = i2;
            RoundedPolygon roundedPolygon3 = roundedPolygon;
            int i20 = i4;
            float f13 = f3;
            RoundedCorner roundedCorner = (RoundedCorner) arrayList2.get(i13);
            if (i15 <= 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m("Index must be between 0 and size");
                return roundedPolygon3;
            }
            float f14 = fArrCopyOf[i20];
            if (i3 >= i15) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m("Index must be between 0 and size");
                return roundedPolygon3;
            }
            float f15 = fArrCopyOf[i3];
            long j = roundedCorner.d2;
            long j2 = roundedCorner.d1;
            int i21 = i3;
            float f16 = roundedCorner.cornerRadius;
            ArrayList arrayList4 = arrayList;
            long j3 = roundedCorner.p1;
            float fMin = Math.min(f14, f15);
            float f17 = roundedCorner.expectedRoundCut;
            if (f17 < 1.0E-4f || fMin < 1.0E-4f || f16 < 1.0E-4f) {
                i = i13;
                roundedCorner.center = j3;
                float fM1063getXDnnuFBc = DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(j3);
                float fM1064getYDnnuFBc = DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(j3);
                float fM1063getXDnnuFBc2 = DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(j3);
                float fM1064getYDnnuFBc2 = DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(j3);
                listListOf = CollectionsKt__IterablesKt.listOf(SQLite.Cubic(fM1063getXDnnuFBc, fM1064getYDnnuFBc, Utils.interpolate(fM1063getXDnnuFBc, fM1063getXDnnuFBc2, 0.33333334f), Utils.interpolate(fM1064getYDnnuFBc, fM1064getYDnnuFBc2, 0.33333334f), Utils.interpolate(fM1063getXDnnuFBc, fM1063getXDnnuFBc2, 0.6666667f), Utils.interpolate(fM1064getYDnnuFBc, fM1064getYDnnuFBc2, 0.6666667f), fM1063getXDnnuFBc2, fM1064getYDnnuFBc2));
            } else {
                float fMin2 = Math.min(fMin, f17);
                float fCalculateActualSmoothingValue = roundedCorner.calculateActualSmoothingValue(f14);
                float fCalculateActualSmoothingValue2 = roundedCorner.calculateActualSmoothingValue(f15);
                float f18 = (f16 * fMin2) / f17;
                float f19 = Utils.FloatPi;
                int i22 = i13;
                float fSqrt2 = (float) Math.sqrt((fMin2 * fMin2) + (f18 * f18));
                long jM1059divso9K2fw = DatabaseDao_Impl.AnonymousClass17.m1059divso9K2fw(DatabaseDao_Impl.AnonymousClass17.m1066plusybeJwSQ(j2, j), 2.0f);
                float fM1062getDistanceDnnuFBc = DatabaseDao_Impl.AnonymousClass17.m1062getDistanceDnnuFBc(jM1059divso9K2fw);
                if (fM1062getDistanceDnnuFBc <= f13) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Can't get the direction of a 0-length vector");
                    return roundedPolygon3;
                }
                roundedCorner.center = DatabaseDao_Impl.AnonymousClass17.m1066plusybeJwSQ(j3, DatabaseDao_Impl.AnonymousClass17.m1067timesso9K2fw(DatabaseDao_Impl.AnonymousClass17.m1059divso9K2fw(jM1059divso9K2fw, fM1062getDistanceDnnuFBc), fSqrt2));
                long jM1066plusybeJwSQ = DatabaseDao_Impl.AnonymousClass17.m1066plusybeJwSQ(j3, DatabaseDao_Impl.AnonymousClass17.m1067timesso9K2fw(j2, fMin2));
                long jM1066plusybeJwSQ2 = DatabaseDao_Impl.AnonymousClass17.m1066plusybeJwSQ(j3, DatabaseDao_Impl.AnonymousClass17.m1067timesso9K2fw(j, fMin2));
                Cubic cubicM834computeFlankingCurveoAJzIJU = RoundedCorner.m834computeFlankingCurveoAJzIJU(fMin2, fCalculateActualSmoothingValue, roundedCorner.p1, roundedCorner.p0, jM1066plusybeJwSQ, jM1066plusybeJwSQ2, roundedCorner.center, f18);
                Cubic cubicM834computeFlankingCurveoAJzIJU2 = RoundedCorner.m834computeFlankingCurveoAJzIJU(fMin2, fCalculateActualSmoothingValue2, roundedCorner.p1, roundedCorner.p2, jM1066plusybeJwSQ2, jM1066plusybeJwSQ, roundedCorner.center, f18);
                float anchor1X = cubicM834computeFlankingCurveoAJzIJU2.getAnchor1X();
                float anchor1Y = cubicM834computeFlankingCurveoAJzIJU2.getAnchor1Y();
                float[] fArr2 = cubicM834computeFlankingCurveoAJzIJU2.points;
                Cubic Cubic2 = SQLite.Cubic(anchor1X, anchor1Y, fArr2[4], fArr2[5], fArr2[i19], fArr2[3], fArr2[i20], fArr2[i21]);
                float fM1063getXDnnuFBc3 = DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(roundedCorner.center);
                float fM1064getYDnnuFBc3 = DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(roundedCorner.center);
                float anchor1X2 = cubicM834computeFlankingCurveoAJzIJU.getAnchor1X();
                float anchor1Y2 = cubicM834computeFlankingCurveoAJzIJU.getAnchor1Y();
                float[] fArr3 = Cubic2.points;
                float f20 = fArr3[i20];
                float f21 = fArr3[i21];
                float f22 = anchor1X2 - fM1063getXDnnuFBc3;
                float f23 = anchor1Y2 - fM1064getYDnnuFBc3;
                long jDirectionVector = Utils.directionVector(f22, f23);
                float f24 = f20 - fM1063getXDnnuFBc3;
                float f25 = f21 - fM1064getYDnnuFBc3;
                i = i22;
                long jDirectionVector2 = Utils.directionVector(f24, f25);
                long jM0constructorimpl = FloatFloatPair.m0constructorimpl(-DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(jDirectionVector), DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(jDirectionVector));
                long jM0constructorimpl2 = FloatFloatPair.m0constructorimpl(-DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(jDirectionVector2), DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(jDirectionVector2));
                int i23 = (DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(jM0constructorimpl) * f25) + (DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(jM0constructorimpl) * f24) >= f13 ? i21 : i20;
                float fM1060dotProductybeJwSQ = DatabaseDao_Impl.AnonymousClass17.m1060dotProductybeJwSQ(jDirectionVector, jDirectionVector2);
                if (fM1060dotProductybeJwSQ > 0.999f) {
                    Cubic = SQLite.Cubic(anchor1X2, anchor1Y2, Utils.interpolate(anchor1X2, f20, 0.33333334f), Utils.interpolate(anchor1Y2, f21, 0.33333334f), Utils.interpolate(anchor1X2, f20, 0.6666667f), Utils.interpolate(anchor1Y2, f21, 0.6666667f), f20, f21);
                } else {
                    float f26 = f5 - fM1060dotProductybeJwSQ;
                    float fSqrt3 = (((((float) Math.sqrt(2.0f * f26)) - ((float) Math.sqrt(f5 - (fM1060dotProductybeJwSQ * fM1060dotProductybeJwSQ)))) * ((((float) Math.sqrt((f23 * f23) + (f22 * f22))) * 4.0f) / 3.0f)) / f26) * (i23 != 0 ? f5 : -1.0f);
                    Cubic = SQLite.Cubic(anchor1X2, anchor1Y2, (DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(jM0constructorimpl) * fSqrt3) + anchor1X2, (DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(jM0constructorimpl) * fSqrt3) + anchor1Y2, f20 - (DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(jM0constructorimpl2) * fSqrt3), f21 - (DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(jM0constructorimpl2) * fSqrt3), f20, f21);
                }
                listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new Cubic[]{cubicM834computeFlankingCurveoAJzIJU, Cubic, Cubic2});
            }
            arrayList4.add(listListOf);
            f3 = f13;
            arrayList = arrayList4;
            arrayList3 = arrayList3;
            arrayList2 = arrayList2;
            i4 = i20;
            roundedPolygon = roundedPolygon3;
            i3 = i21;
            i2 = i19;
        }
        ArrayList arrayList5 = arrayList;
        int i24 = i2;
        RoundedPolygon roundedPolygon4 = roundedPolygon;
        int i25 = i3;
        int i26 = i4;
        float f27 = f3;
        ArrayList arrayList6 = new ArrayList();
        int i27 = i26;
        while (i27 < length) {
            int i28 = i27 + 1;
            int i29 = i28 % length;
            int i30 = i27 * 2;
            long jM0constructorimpl3 = FloatFloatPair.m0constructorimpl(fArr[i30], fArr[i30 + 1]);
            int i31 = (((i27 + length) - 1) % length) * 2;
            long jM0constructorimpl4 = FloatFloatPair.m0constructorimpl(fArr[i31], fArr[i31 + 1]);
            int i32 = i29 * 2;
            long jM0constructorimpl5 = FloatFloatPair.m0constructorimpl(fArr[i32], fArr[i32 + 1]);
            float f28 = Utils.FloatPi;
            long jM1065minusybeJwSQ = DatabaseDao_Impl.AnonymousClass17.m1065minusybeJwSQ(jM0constructorimpl3, jM0constructorimpl4);
            long jM1065minusybeJwSQ2 = DatabaseDao_Impl.AnonymousClass17.m1065minusybeJwSQ(jM0constructorimpl5, jM0constructorimpl3);
            arrayList6.add(new Feature.Corner((List) arrayList5.get(i27), (DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(jM1065minusybeJwSQ2) * DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(jM1065minusybeJwSQ)) - (DatabaseDao_Impl.AnonymousClass17.m1063getXDnnuFBc(jM1065minusybeJwSQ2) * DatabaseDao_Impl.AnonymousClass17.m1064getYDnnuFBc(jM1065minusybeJwSQ)) > f27 ? i25 : i26));
            float anchor1X3 = ((Cubic) CollectionsKt.last((List) arrayList5.get(i27))).getAnchor1X();
            float anchor1Y3 = ((Cubic) CollectionsKt.last((List) arrayList5.get(i27))).getAnchor1Y();
            float f29 = ((Cubic) CollectionsKt.first((List) arrayList5.get(i29))).points[i26];
            float f30 = ((Cubic) CollectionsKt.first((List) arrayList5.get(i29))).points[i25];
            arrayList6.add(new Feature.Edge(CollectionsKt__IterablesKt.listOf(SQLite.Cubic(anchor1X3, anchor1Y3, Utils.interpolate(anchor1X3, f29, 0.33333334f), Utils.interpolate(anchor1Y3, f30, 0.33333334f), Utils.interpolate(anchor1X3, f29, 0.6666667f), Utils.interpolate(anchor1Y3, f30, 0.6666667f), f29, f30))));
            i27 = i28;
        }
        long jCalculateCenter = (f == Float.MIN_VALUE || f2 == Float.MIN_VALUE) ? calculateCenter(fArr) : FloatFloatPair.m0constructorimpl(f, f2);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jCalculateCenter >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jCalculateCenter & 4294967295L));
        if (arrayList6.size() < i24) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Polygons must have at least 2 features");
            return roundedPolygon4;
        }
        ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
        int size = arrayList6.size();
        int i33 = i26;
        while (i33 < size) {
            Object obj = arrayList6.get(i33);
            i33++;
            for (Cubic cubic : ((Feature) obj).cubics) {
                listBuilderCreateListBuilder.add(Float.valueOf(cubic.points[i26]));
                listBuilderCreateListBuilder.add(Float.valueOf(cubic.points[i25]));
            }
        }
        float[] floatArray = CollectionsKt.toFloatArray(CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder));
        if (Float.isNaN(fIntBitsToFloat)) {
            fIntBitsToFloat = Float.intBitsToFloat((int) (calculateCenter(floatArray) >> 32));
        }
        if (Float.isNaN(fIntBitsToFloat2)) {
            fIntBitsToFloat2 = Float.intBitsToFloat((int) (calculateCenter(floatArray) & 4294967295L));
        }
        return new RoundedPolygon(arrayList6, FloatFloatPair.m0constructorimpl(fIntBitsToFloat, fIntBitsToFloat2));
    }

    public static final Size Size(int i, int i2) {
        Dimension.Pixels.m859constructorimpl(i);
        Dimension.Pixels pixels = new Dimension.Pixels(i);
        Dimension.Pixels.m859constructorimpl(i2);
        return new Size(pixels, new Dimension.Pixels(i2));
    }

    public static final Object bringIntoView(DelegatableNode delegatableNode, Function0 function0, ContinuationImpl continuationImpl) {
        Object obj;
        NodeCoordinator nodeCoordinatorRequireLayoutCoordinates;
        Object objBringIntoView;
        NodeChain nodeChain;
        if (((Modifier.Node) delegatableNode).node.isAttached) {
            Modifier.Node node = (Modifier.Node) delegatableNode;
            if (!node.node.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node2 = node.node.parent;
            LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(delegatableNode);
            loop0: while (true) {
                obj = null;
                if (layoutNodeRequireLayoutNode == null) {
                    break;
                }
                if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 524288) != 0) {
                    while (node2 != null) {
                        if ((node2.kindSet & 524288) != 0) {
                            Modifier.Node nodePop = node2;
                            MutableVector mutableVector = null;
                            while (nodePop != null) {
                                if (nodePop instanceof BringIntoViewModifierNode) {
                                    obj = nodePop;
                                    break loop0;
                                }
                                if ((nodePop.kindSet & 524288) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node node3 = ((DelegatingNode) nodePop).delegate; node3 != null; node3 = node3.child) {
                                        if ((node3.kindSet & 524288) != 0) {
                                            i++;
                                            if (i == 1) {
                                                nodePop = node3;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (nodePop != null) {
                                                    mutableVector.add(nodePop);
                                                    nodePop = null;
                                                }
                                                mutableVector.add(node3);
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                nodePop = HitTestResultKt.pop(mutableVector);
                            }
                        }
                        node2 = node2.parent;
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                node2 = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
            }
            BringIntoViewModifierNode bringIntoViewModifierNode = (BringIntoViewModifierNode) obj;
            if (bringIntoViewModifierNode != null && (objBringIntoView = bringIntoViewModifierNode.bringIntoView((nodeCoordinatorRequireLayoutCoordinates = HitTestResultKt.requireLayoutCoordinates(delegatableNode)), new ComponentRegistry$Builder$$ExternalSyntheticLambda2((Object) function0, (Object) nodeCoordinatorRequireLayoutCoordinates, (byte) 2), continuationImpl)) == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return objBringIntoView;
            }
        }
        return Unit.INSTANCE;
    }

    public static final long calculateCenter(float[] fArr) {
        float f = CropImageView.DEFAULT_ASPECT_RATIO;
        int i = 0;
        float f2 = 0.0f;
        while (i < fArr.length) {
            int i2 = i + 1;
            f += fArr[i];
            i += 2;
            f2 += fArr[i2];
        }
        return FloatFloatPair.m0constructorimpl(f / (fArr.length / 2), f2 / (fArr.length / 2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object castValueOr(Object obj, TypeReference typeReference, Function1 function1) throws QuickJsException {
        String str = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        if (obj == null) {
            return null;
        }
        KClassifier kClassifier = typeReference.classifier;
        kClassifier.getClass();
        KClass kClass = (KClass) kClassifier;
        if (kClass.isInstance(obj)) {
            return obj;
        }
        Class javaClass = Okio__OkioKt.getJavaClass(kClass);
        if (javaClass.equals(Boolean.TYPE)) {
            if (obj instanceof Boolean) {
                return Boolean.valueOf(obj.equals(Boolean.TRUE));
            }
        } else if (!javaClass.equals(Long.TYPE)) {
            int i = 2;
            if (javaClass.equals(Byte.TYPE)) {
                if (obj instanceof Long) {
                    long jLongValue = ((Number) obj).longValue();
                    if (jLongValue < -128 || jLongValue > 127) {
                        throw new QuickJsException(IntIntPair$$ExternalSyntheticOutline0.m(jLongValue, "Cannot cast Long(", ") to Byte: value out of range."), str, i, objArr7 == true ? 1 : 0);
                    }
                    return Byte.valueOf((byte) jLongValue);
                }
            } else if (javaClass.equals(Short.TYPE)) {
                if (obj instanceof Long) {
                    long jLongValue2 = ((Number) obj).longValue();
                    if (jLongValue2 < -32768 || jLongValue2 > 32767) {
                        throw new QuickJsException(IntIntPair$$ExternalSyntheticOutline0.m(jLongValue2, "Cannot cast Long(", ") to Short: value out of range."), objArr6 == true ? 1 : 0, i, objArr5 == true ? 1 : 0);
                    }
                    return Short.valueOf((short) jLongValue2);
                }
            } else if (javaClass.equals(Integer.class) || javaClass.equals(Integer.TYPE)) {
                if (obj instanceof Long) {
                    long jLongValue3 = ((Number) obj).longValue();
                    if (jLongValue3 < -2147483648L || jLongValue3 > 2147483647L) {
                        throw new QuickJsException(IntIntPair$$ExternalSyntheticOutline0.m(jLongValue3, "Cannot cast Long(", ") to Int: value out of range."), objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
                    }
                    return Integer.valueOf((int) jLongValue3);
                }
                if (obj instanceof Integer) {
                    return obj;
                }
            } else if (javaClass.equals(Float.class) || javaClass.equals(Float.TYPE)) {
                if (obj instanceof Double) {
                    double dDoubleValue = ((Number) obj).doubleValue();
                    if (dDoubleValue >= 1.401298464324817E-45d && dDoubleValue <= 3.4028234663852886E38d) {
                        return Float.valueOf((float) dDoubleValue);
                    }
                    throw new QuickJsException("Cannot cast Double(" + dDoubleValue + ") to Float: value out of range.", objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
                }
                if (obj instanceof Float) {
                    return obj;
                }
                if (obj instanceof Long) {
                    return Float.valueOf(((Number) obj).longValue());
                }
            } else if (javaClass.equals(Double.class) || javaClass.equals(Double.TYPE)) {
                if (obj instanceof Double) {
                    return obj;
                }
                if (obj instanceof Long) {
                    return Double.valueOf(((Number) obj).longValue());
                }
            }
        } else if (obj instanceof Long) {
            return obj;
        }
        return function1.invoke(obj);
    }

    public static void closeQuietly(DataSource dataSource) {
        if (dataSource != null) {
            try {
                dataSource.close();
            } catch (IOException unused) {
            }
        }
    }

    public static final MutableState collectIsPressedAsState(MutableInteractionSourceImpl mutableInteractionSourceImpl, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (objRememberedValue == neverEqualPolicy) {
            objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        byte b = 1;
        boolean z = (((i & 14) ^ 6) > 4 && gapComposer.changed(mutableInteractionSourceImpl)) || (i & 6) == 4;
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (z || objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = new FocusInteractionKt$collectIsFocusedAsState$1$1(mutableInteractionSourceImpl, mutableState, null, b);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        Stack.LaunchedEffect(gapComposer, mutableInteractionSourceImpl, (Function2) objRememberedValue2);
        return mutableState;
    }

    public static void composable$default(NavGraphBuilder navGraphBuilder, String str, List list, StatsScreenKt$$ExternalSyntheticLambda6 statsScreenKt$$ExternalSyntheticLambda6, StatsScreenKt$$ExternalSyntheticLambda6 statsScreenKt$$ExternalSyntheticLambda7, StatsScreenKt$$ExternalSyntheticLambda6 statsScreenKt$$ExternalSyntheticLambda8, StatsScreenKt$$ExternalSyntheticLambda6 statsScreenKt$$ExternalSyntheticLambda9, ComposableLambdaImpl composableLambdaImpl, int i) {
        if ((i & 2) != 0) {
            list = EmptyList.INSTANCE;
        }
        if ((i & 8) != 0) {
            statsScreenKt$$ExternalSyntheticLambda6 = null;
        }
        if ((i & 16) != 0) {
            statsScreenKt$$ExternalSyntheticLambda7 = null;
        }
        if ((i & 32) != 0) {
            statsScreenKt$$ExternalSyntheticLambda8 = statsScreenKt$$ExternalSyntheticLambda6;
        }
        if ((i & 64) != 0) {
            statsScreenKt$$ExternalSyntheticLambda9 = statsScreenKt$$ExternalSyntheticLambda7;
        }
        NavigatorProvider navigatorProvider = navGraphBuilder.provider;
        navigatorProvider.getClass();
        ComposeNavigatorDestinationBuilder composeNavigatorDestinationBuilder = new ComposeNavigatorDestinationBuilder((ComposeNavigator) navigatorProvider.getNavigator(UtilsKt.getNameForNavigator$navigation_common_release(ComposeNavigator.class)), str, composableLambdaImpl);
        for (NamedNavArgument namedNavArgument : list) {
            composeNavigatorDestinationBuilder.arguments.put(namedNavArgument.name, namedNavArgument.argument);
        }
        composeNavigatorDestinationBuilder.enterTransition = statsScreenKt$$ExternalSyntheticLambda6;
        composeNavigatorDestinationBuilder.exitTransition = statsScreenKt$$ExternalSyntheticLambda7;
        composeNavigatorDestinationBuilder.popEnterTransition = statsScreenKt$$ExternalSyntheticLambda8;
        composeNavigatorDestinationBuilder.popExitTransition = statsScreenKt$$ExternalSyntheticLambda9;
        navGraphBuilder.destinations.add(composeNavigatorDestinationBuilder.build());
    }

    /* JADX INFO: renamed from: computeDstSize-sEdh43o, reason: not valid java name */
    public static final long m863computeDstSizesEdh43o(int i, int i2, Size size, Scale scale, Size size2) {
        int i3;
        int i4;
        if (!Intrinsics.areEqual(size, Size.ORIGINAL)) {
            i = toPx(size.width, scale);
            i2 = toPx(size.height, scale);
        }
        Dimension dimension = size2.width;
        Dimension dimension2 = size2.height;
        if ((dimension instanceof Dimension.Pixels) && i != Integer.MIN_VALUE && i != Integer.MAX_VALUE && i > (i4 = ((Dimension.Pixels) dimension).px)) {
            i = i4;
        }
        if ((dimension2 instanceof Dimension.Pixels) && i2 != Integer.MIN_VALUE && i2 != Integer.MAX_VALUE && i2 > (i3 = ((Dimension.Pixels) dimension2).px)) {
            i2 = i3;
        }
        return (((long) i2) & 4294967295L) | (((long) i) << 32);
    }

    public static final double computeSizeMultiplier(int i, int i2, int i3, int i4, Scale scale, Size size) {
        double dMax;
        double d = i;
        double d2 = ((double) i3) / d;
        double d3 = i2;
        double d4 = ((double) i4) / d3;
        int iOrdinal = scale.ordinal();
        if (iOrdinal == 0) {
            dMax = Math.max(d2, d4);
        } else {
            if (iOrdinal != 1) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return 0.0d;
            }
            dMax = Math.min(d2, d4);
        }
        Dimension dimension = size.width;
        if (dimension instanceof Dimension.Pixels) {
            double d5 = ((double) ((Dimension.Pixels) dimension).px) / d;
            if (dMax > d5) {
                dMax = d5;
            }
        }
        Dimension dimension2 = size.height;
        if (dimension2 instanceof Dimension.Pixels) {
            double d6 = ((double) ((Dimension.Pixels) dimension2).px) / d3;
            if (dMax > d6) {
                return d6;
            }
        }
        return dMax;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m864constructorimpl(float f, float f2) {
        return (((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32);
    }

    public static final FontFamilyResolverImpl createFontFamilyResolver(Context context) {
        return new FontFamilyResolverImpl(new NavContext(context, (byte) 1), new AndroidFontResolveInterceptor(Build.VERSION.SDK_INT >= 31 ? FontWeightAdjustmentHelperApi31.INSTANCE.fontWeightAdjustment(context) : 0));
    }

    public static final boolean defaultValueEqualsCommon(String str, String str2) {
        str.getClass();
        if (str.equals(str2)) {
            return true;
        }
        if (str.length() != 0) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i < str.length()) {
                char cCharAt = str.charAt(i);
                int i4 = i3 + 1;
                if (i3 != 0 || cCharAt == '(') {
                    if (cCharAt == '(') {
                        i2++;
                    } else if (cCharAt == ')' && (i2 = i2 - 1) == 0 && i3 != str.length() - 1) {
                    }
                    i++;
                    i3 = i4;
                }
            }
            if (i2 == 0) {
                return Intrinsics.areEqual(StringsKt.trim(str.substring(1, str.length() - 1)).toString(), str2);
            }
        }
        return false;
    }

    public static boolean dispatchKeyEvent(KeyEventDispatcher$Component keyEventDispatcher$Component, View view, Window.Callback callback, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener onKeyListener;
        boolean zBooleanValue = false;
        if (keyEventDispatcher$Component != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return keyEventDispatcher$Component.superDispatchKeyEvent(keyEvent);
            }
            if (callback instanceof Activity) {
                Activity activity = (Activity) callback;
                activity.onUserInteraction();
                Window window = activity.getWindow();
                if (window.hasFeature(8)) {
                    ActionBar actionBar = activity.getActionBar();
                    if (keyEvent.getKeyCode() == 82 && actionBar != null) {
                        if (!sActionBarFieldsFetched) {
                            try {
                                sActionBarOnMenuKeyMethod = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
                            } catch (NoSuchMethodException unused) {
                            }
                            sActionBarFieldsFetched = true;
                        }
                        Method method = sActionBarOnMenuKeyMethod;
                        if (method != null) {
                            try {
                                Object objInvoke = method.invoke(actionBar, keyEvent);
                                if (objInvoke != null) {
                                    zBooleanValue = ((Boolean) objInvoke).booleanValue();
                                }
                            } catch (IllegalAccessException | InvocationTargetException unused2) {
                            }
                        }
                        if (zBooleanValue) {
                            return true;
                        }
                    }
                }
                if (window.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView = window.getDecorView();
                if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(decorView, keyEvent)) {
                    return true;
                }
                return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
            }
            if (callback instanceof Dialog) {
                Dialog dialog = (Dialog) callback;
                if (!sDialogFieldsFetched) {
                    try {
                        Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                        sDialogKeyListenerField = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException unused3) {
                    }
                    sDialogFieldsFetched = true;
                }
                Field field = sDialogKeyListenerField;
                if (field != null) {
                    try {
                        onKeyListener = (DialogInterface.OnKeyListener) field.get(dialog);
                    } catch (IllegalAccessException unused4) {
                        onKeyListener = null;
                    }
                } else {
                    onKeyListener = null;
                }
                if (onKeyListener != null && onKeyListener.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
                    return true;
                }
                Window window2 = dialog.getWindow();
                if (window2.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView2 = window2.getDecorView();
                if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(decorView2, keyEvent)) {
                    return true;
                }
                return keyEvent.dispatch(dialog, decorView2 != null ? decorView2.getKeyDispatcherState() : null, dialog);
            }
            if ((view != null && ViewCompat.dispatchUnhandledKeyEventBeforeCallback(view, keyEvent)) || keyEventDispatcher$Component.superDispatchKeyEvent(keyEvent)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: drawArrow-uDrxG_w, reason: not valid java name */
    public static final void m865drawArrowuDrxG_w(DrawScope drawScope, AndroidPath androidPath, Rect rect, long j, float f, FlingCalculator flingCalculator) {
        androidPath.reset();
        androidPath.moveTo(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
        float fMo81toPx0680j_4 = drawScope.mo81toPx0680j_4(10.0f);
        float f2 = flingCalculator.magicPhysicalCoefficient;
        androidPath.lineTo((fMo81toPx0680j_4 * f2) / 2.0f, drawScope.mo81toPx0680j_4(5.0f) * f2);
        androidPath.lineTo(drawScope.mo81toPx0680j_4(10.0f) * f2, CropImageView.DEFAULT_ASPECT_RATIO);
        float fMin = Math.min(rect.right - rect.left, rect.bottom - rect.top) / 2.0f;
        float fIntBitsToFloat = (Float.intBitsToFloat((int) (rect.m443getCenterF1C5BW0() >> 32)) + fMin) - ((drawScope.mo81toPx0680j_4(10.0f) * f2) / 2.0f);
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (rect.m443getCenterF1C5BW0() & 4294967295L)) - drawScope.mo81toPx0680j_4(2.5f);
        androidPath.m472translatek4lQ0M((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
        float fMo81toPx0680j_5 = flingCalculator.friction - drawScope.mo81toPx0680j_4(2.5f);
        long jMo555getCenterF1C5BW0 = drawScope.mo555getCenterF1C5BW0();
        EmojiProcessor drawContext = drawScope.getDrawContext();
        long jM831getSizeNHjbRc = drawContext.m831getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            ((DrawResult) drawContext.mSpanFactory).m402rotateUv8p0NA(jMo555getCenterF1C5BW0, fMo81toPx0680j_5);
            DrawScope.m548drawPathLG529CI$default(drawScope, androidPath, j, f, new Stroke(drawScope.mo81toPx0680j_4(2.5f), CropImageView.DEFAULT_ASPECT_RATIO, 0, 0, 30), 48);
        } finally {
            IntIntPair$$ExternalSyntheticOutline0.m(drawContext, jM831getSizeNHjbRc);
        }
    }

    public static final String formatString(Collection collection) {
        return !collection.isEmpty() ? SequencesKt.joinToString$default(new TransformingSequence(new LinesSequence((byte) 5, CollectionsKt.joinToString$default(collection, ",\n", "\n", "\n", null, 56)), new StringsKt__IndentKt$$ExternalSyntheticLambda0("    ", (byte) 0)), "\n").concat("},") : " }";
    }

    /* JADX INFO: renamed from: getCenter-ozmzZPI, reason: not valid java name */
    public static final long m866getCenterozmzZPI(long j) {
        return (((j << 32) >> 33) & 4294967295L) | ((j >> 33) << 32);
    }

    public static float getDistance(EdgeEffect edgeEffect) {
        return Build.VERSION.SDK_INT >= 31 ? EdgeEffectCompat$Api31Impl.getDistance(edgeEffect) : CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public static Drawable getDrawable(Context context, int i) {
        return ResourceManagerInternal.get().getDrawable(context, i);
    }

    public static long getSignificand(double d) {
        UtilsKt.checkArgument("not a normal value", isFinite(d));
        int exponent = Math.getExponent(d);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d) & 4503599627370495L;
        return exponent == -1023 ? jDoubleToRawLongBits << 1 : jDoubleToRawLongBits | 4503599627370496L;
    }

    public static final boolean isAutofillable(SemanticsConfiguration semanticsConfiguration) {
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDataType;
        MutableScatterMap mutableScatterMap = semanticsConfiguration.props;
        Object obj = mutableScatterMap.get(semanticsPropertyKey);
        if (obj == null) {
            obj = null;
        }
        if (Intrinsics.areEqual(obj, ContentDataType$Companion.None)) {
            return false;
        }
        return mutableScatterMap.contains(SemanticsActions.OnAutofillText) || mutableScatterMap.contains(SemanticsActions.OnFillData);
    }

    public static boolean isFinite(double d) {
        return Math.getExponent(d) <= 1023;
    }

    public static final String joinToStringEndWithIndent(Collection collection) {
        return SequencesKt.joinToString$default(new TransformingSequence(new LinesSequence((byte) 5, CollectionsKt.joinToString$default(collection, ",", null, null, null, 62)), new StringsKt__IndentKt$$ExternalSyntheticLambda0("    ", (byte) 0)), "\n").concat(SequencesKt.joinToString$default(new TransformingSequence(new LinesSequence((byte) 5, " }"), new StringsKt__IndentKt$$ExternalSyntheticLambda0("    ", (byte) 0)), "\n"));
    }

    public static final String joinToStringMiddleWithIndent(Collection collection) {
        return SequencesKt.joinToString$default(new TransformingSequence(new LinesSequence((byte) 5, CollectionsKt.joinToString$default(collection, ",", null, null, null, 62)), new StringsKt__IndentKt$$ExternalSyntheticLambda0("    ", (byte) 0)), "\n").concat(SequencesKt.joinToString$default(new TransformingSequence(new LinesSequence((byte) 5, "},"), new StringsKt__IndentKt$$ExternalSyntheticLambda0("    ", (byte) 0)), "\n"));
    }

    /* JADX INFO: renamed from: lerp-Wko1d7g, reason: not valid java name */
    public static final long m867lerpWko1d7g(long j, long j2, float f) {
        float fLerp = LifecyclesKt.lerp(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j2 >> 32)), f);
        float fLerp2 = LifecyclesKt.lerp(Float.intBitsToFloat((int) (j & 4294967295L)), Float.intBitsToFloat((int) (j2 & 4294967295L)), f);
        return (((long) Float.floatToRawIntBits(fLerp)) << 32) | (((long) Float.floatToRawIntBits(fLerp2)) & 4294967295L);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0080  */
    /* JADX WARN: Code duplicated, block: B:35:0x008a  */
    /* JADX WARN: Code duplicated, block: B:37:0x009d  */
    /* JADX WARN: Code duplicated, block: B:38:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:41:0x00bc  */
    public static final NamedNavArgument navArgument(String str, Function1 function1) {
        NavType serializableType;
        Class<?> componentType;
        NavArgumentBuilder navArgumentBuilder = new NavArgumentBuilder();
        function1.invoke(navArgumentBuilder);
        ConnectionSpec.Builder builder = navArgumentBuilder.builder;
        NavType navType = (NavType) builder.cipherSuites;
        if (navType == null) {
            Object obj = (Boolean) builder.tlsVersions;
            if (obj instanceof int[]) {
                serializableType = NavType.IntArrayType;
            } else if (obj instanceof long[]) {
                serializableType = NavType.LongArrayType;
            } else if (obj instanceof float[]) {
                serializableType = NavType.FloatArrayType;
            } else if (obj != null) {
                serializableType = NavType.BoolType;
            } else if (obj instanceof boolean[]) {
                serializableType = NavType.BoolArrayType;
            } else {
                serializableType = obj == null ? NavType.StringType : null;
            }
            if (serializableType != null) {
                navType = serializableType;
            } else if ((obj instanceof Object[]) && (((Object[]) obj) instanceof String[])) {
                navType = NavType.StringArrayType;
            } else {
                obj.getClass();
                if (obj.getClass().isArray()) {
                    Class<?> componentType2 = obj.getClass().getComponentType();
                    componentType2.getClass();
                    if (Parcelable.class.isAssignableFrom(componentType2)) {
                        Class<?> componentType3 = obj.getClass().getComponentType();
                        componentType3.getClass();
                        serializableType = new NavType.ParcelableArrayType(componentType3);
                    } else if (obj.getClass().isArray()) {
                        componentType = obj.getClass().getComponentType();
                        componentType.getClass();
                        if (Serializable.class.isAssignableFrom(componentType)) {
                            Class<?> componentType4 = obj.getClass().getComponentType();
                            componentType4.getClass();
                            serializableType = new NavType.SerializableArrayType(componentType4);
                        } else if (obj instanceof Parcelable) {
                            serializableType = new NavType.ParcelableType(obj.getClass());
                        } else {
                            serializableType = new NavType.SerializableType(obj.getClass());
                        }
                    } else if (obj instanceof Parcelable) {
                        serializableType = new NavType.ParcelableType(obj.getClass());
                    } else {
                        serializableType = new NavType.SerializableType(obj.getClass());
                    }
                } else if (obj.getClass().isArray()) {
                    componentType = obj.getClass().getComponentType();
                    componentType.getClass();
                    if (Serializable.class.isAssignableFrom(componentType)) {
                        Class<?> componentType5 = obj.getClass().getComponentType();
                        componentType5.getClass();
                        serializableType = new NavType.SerializableArrayType(componentType5);
                    } else if (obj instanceof Parcelable) {
                        serializableType = new NavType.ParcelableType(obj.getClass());
                    } else {
                        serializableType = new NavType.SerializableType(obj.getClass());
                    }
                } else if (obj instanceof Parcelable) {
                    serializableType = new NavType.ParcelableType(obj.getClass());
                } else {
                    serializableType = new NavType.SerializableType(obj.getClass());
                }
                navType = serializableType;
            }
        }
        return new NamedNavArgument(str, new NavArgument(navType, builder.tls, (Boolean) builder.tlsVersions, builder.supportsTlsExtensions));
    }

    public static float onPullDistance(EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 31) {
            return EdgeEffectCompat$Api31Impl.onPullDistance(edgeEffect, f, f2);
        }
        edgeEffect.onPull(f, f2);
        return f;
    }

    public static final PullToRefreshStateImpl rememberPullToRefreshState(Composer composer) {
        Object[] objArr = new Object[0];
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        if (objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new TextKt$$ExternalSyntheticLambda3((byte) 10);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (PullToRefreshStateImpl) SaverKt.m393rememberSaveable(objArr, (Saver) PullToRefreshStateImpl.Saver, (Function0) objRememberedValue, (Composer) gapComposer, 384);
    }

    /* JADX INFO: renamed from: resolveLineHeightInPx-o2QH7mI, reason: not valid java name */
    public static final float m869resolveLineHeightInPxo2QH7mI(long j, float f, Density density) {
        float fM814getValueimpl;
        long jM813getTypeUIouoOA = TextUnit.m813getTypeUIouoOA(j);
        if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA, 4294967296L)) {
            if (density.getFontScale() <= 1.05d) {
                return density.mo80toPxR2X_6o(j);
            }
            fM814getValueimpl = TextUnit.m814getValueimpl(j) / TextUnit.m814getValueimpl(density.mo84toSpkPz2Gy4(f));
        } else {
            if (!TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA, 8589934592L)) {
                return Float.NaN;
            }
            fM814getValueimpl = TextUnit.m814getValueimpl(j);
        }
        return fM814getValueimpl * f;
    }

    public static TtmlStyle resolveStyle(TtmlStyle ttmlStyle, String[] strArr, Map map) {
        int i = 0;
        if (ttmlStyle == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return (TtmlStyle) map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                TtmlStyle ttmlStyle2 = new TtmlStyle();
                int length = strArr.length;
                while (i < length) {
                    ttmlStyle2.chain((TtmlStyle) map.get(strArr[i]));
                    i++;
                }
                return ttmlStyle2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                ttmlStyle.chain((TtmlStyle) map.get(strArr[0]));
                return ttmlStyle;
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i < length2) {
                    ttmlStyle.chain((TtmlStyle) map.get(strArr[i]));
                    i++;
                }
            }
        }
        return ttmlStyle;
    }

    /* JADX INFO: renamed from: roundToIntSize-uvyYCjk, reason: not valid java name */
    public static final long m870roundToIntSizeuvyYCjk(long j) {
        int iRound = Math.round(Float.intBitsToFloat((int) (j >> 32)));
        return (((long) Math.round(Float.intBitsToFloat((int) (j & 4294967295L)))) & 4294967295L) | (((long) iRound) << 32);
    }

    /* JADX INFO: renamed from: setColor-RPmYEkk, reason: not valid java name */
    public static final void m871setColorRPmYEkk(Spannable spannable, long j, int i, int i2) {
        if (j != 16) {
            spannable.setSpan(new ForegroundColorSpan(ColorKt.m498toArgb8_81llA(j)), i, i2, 33);
        }
    }

    /* JADX INFO: renamed from: setFontSize-KmRG4DE, reason: not valid java name */
    public static final void m872setFontSizeKmRG4DE(Spannable spannable, long j, Density density, int i, int i2) {
        long jM813getTypeUIouoOA = TextUnit.m813getTypeUIouoOA(j);
        if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA, 4294967296L)) {
            spannable.setSpan(new AbsoluteSizeSpan(MathKt.roundToInt(density.mo80toPxR2X_6o(j)), false), i, i2, 33);
        } else if (TextUnitType.m816equalsimpl0(jM813getTypeUIouoOA, 8589934592L)) {
            spannable.setSpan(new RelativeSizeSpan(TextUnit.m814getValueimpl(j)), i, i2, 33);
        }
    }

    public static final void setLocaleList(Spannable spannable, LocaleList localeList, int i, int i2) {
        if (localeList != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(localeList, 10));
            Iterator it = localeList.localeList.iterator();
            while (it.hasNext()) {
                arrayList.add(((Locale) it.next()).platformLocale);
            }
            java.util.Locale[] localeArr = (java.util.Locale[]) arrayList.toArray(new java.util.Locale[0]);
            spannable.setSpan(new LocaleSpan(new android.os.LocaleList((java.util.Locale[]) Arrays.copyOf(localeArr, localeArr.length))), i, i2, 33);
        }
    }

    /* JADX INFO: renamed from: setObject-sGr0YRc, reason: not valid java name */
    public static final void m873setObjectsGr0YRc(Operations operations, int i, Object obj) {
        operations.objectArgs[(operations.objectArgsSize - operations.opCodes[operations.opCodesSize - 1].objects) + i] = obj;
    }

    /* JADX INFO: renamed from: setObjects-EsEZvaA, reason: not valid java name */
    public static final void m874setObjectsEsEZvaA(Operations operations, int i, Object obj, int i2, Object obj2) {
        int i3 = operations.objectArgsSize - operations.opCodes[operations.opCodesSize - 1].objects;
        Object[] objArr = operations.objectArgs;
        objArr[i + i3] = obj;
        objArr[i3 + i2] = obj2;
    }

    /* JADX INFO: renamed from: toIntSize-uvyYCjk, reason: not valid java name */
    public static final long m875toIntSizeuvyYCjk(long j) {
        int iIntBitsToFloat = (int) Float.intBitsToFloat((int) (j >> 32));
        return (((long) ((int) Float.intBitsToFloat((int) (j & 4294967295L)))) & 4294967295L) | (((long) iIntBitsToFloat) << 32);
    }

    public static int toPx(Dimension dimension, Scale scale) {
        if (dimension instanceof Dimension.Pixels) {
            return ((Dimension.Pixels) dimension).px;
        }
        int iOrdinal = scale.ordinal();
        if (iOrdinal == 0) {
            return Integer.MIN_VALUE;
        }
        if (iOrdinal == 1) {
            return Integer.MAX_VALUE;
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1();
        return 0;
    }

    /* JADX INFO: renamed from: toSize-ozmzZPI, reason: not valid java name */
    public static final long m876toSizeozmzZPI(long j) {
        return (((long) Float.floatToRawIntBits((int) (j & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits((int) (j >> 32)) << 32);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m877toStringimpl(long j) {
        return "InlineDensity(density=" + Float.intBitsToFloat((int) (j >> 32)) + ", fontScale=" + Float.intBitsToFloat((int) (j & 4294967295L)) + ")";
    }

    public static final Rect visibleBounds(LayoutCoordinates layoutCoordinates) {
        Rect rectBoundsInWindow = RulerKt.boundsInWindow(layoutCoordinates, true);
        long jMo612windowToLocalMKHz9U = layoutCoordinates.mo612windowToLocalMKHz9U(rectBoundsInWindow.m445getTopLeftF1C5BW0());
        float f = rectBoundsInWindow.right;
        float f2 = rectBoundsInWindow.bottom;
        return IntMath.m895Rect0a9Yr6o(jMo612windowToLocalMKHz9U, layoutCoordinates.mo612windowToLocalMKHz9U((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L)));
    }

    public abstract void bind(SQLiteStatement sQLiteStatement, Object obj);

    public abstract Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat$FontFamilyFilesResourceEntry fontResourcesParserCompat$FontFamilyFilesResourceEntry, Resources resources, int i);

    public abstract Typeface createFromFontInfo(Context context, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr, int i);

    public Typeface createFromFontInfoWithFallback(Context context, List list, int i) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    public abstract Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str);

    public abstract String createQuery();

    public void insert(SQLiteConnection sQLiteConnection, Object obj) {
        sQLiteConnection.getClass();
        if (obj == null) {
            return;
        }
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(createQuery());
        try {
            bind(sQLiteStatementPrepare, obj);
            sQLiteStatementPrepare.step();
            StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, th);
                throw th2;
            }
        }
    }

    public long insertAndReturnId(SQLiteConnection sQLiteConnection, Object obj) {
        if (obj == null) {
            return -1L;
        }
        SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare(createQuery());
        try {
            bind(sQLiteStatementPrepare, obj);
            sQLiteStatementPrepare.step();
            StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, null);
            if (MathKt.getTotalChangedRows(sQLiteConnection) == 0) {
                return -1L;
            }
            SQLiteStatement sQLiteStatementPrepare2 = sQLiteConnection.prepare("SELECT last_insert_rowid()");
            try {
                sQLiteStatementPrepare2.step();
                long j = sQLiteStatementPrepare2.getLong(0);
                StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare2, null);
                return j;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare2, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                StringsKt__IndentKt.closeFinally(sQLiteStatementPrepare, th3);
                throw th4;
            }
        }
    }

    public abstract void onFailed(Throwable th);

    public abstract void onLoaded(Dispatcher dispatcher);
}
