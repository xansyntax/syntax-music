package okio;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.AspectRatioElement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.datastore.preferences.core.Preferences$Key;
import coil3.util.FileSystemsKt;
import com.metrolist.music.MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.constants.GridItemSize;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.constants.StatPeriod;
import com.metrolist.music.ui.component.shimmer.GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.screens.OptionStats;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.utils.UtilsKt;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.network.sockets.DatagramKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.List;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.enums.EnumEntriesList;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntProgression;
import kotlin.reflect.KClass;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DispatchException;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.ScopeCoroutine;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class Okio__OkioKt {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ Okio__OkioKt(byte b) {
        this.$r8$classId = b;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031  */
    /* JADX WARN: Code duplicated, block: B:16:0x0033  */
    /* JADX WARN: Code duplicated, block: B:19:0x003b  */
    /* JADX WARN: Code duplicated, block: B:25:0x0050  */
    /* JADX WARN: Code duplicated, block: B:27:0x0062  */
    /* JADX WARN: Code duplicated, block: B:30:0x0078  */
    /* JADX WARN: Code duplicated, block: B:33:0x0087  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:39:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:47:0x0101  */
    /* JADX WARN: Code duplicated, block: B:48:0x0107  */
    /* JADX WARN: Code duplicated, block: B:51:0x0127  */
    /* JADX WARN: Code duplicated, block: B:52:0x012c  */
    /* JADX WARN: Code duplicated, block: B:55:0x0168  */
    /* JADX WARN: Code duplicated, block: B:58:0x0174  */
    /* JADX WARN: Code duplicated, block: B:60:? A[RETURN, SYNTHETIC] */
    public static final void GridItemPlaceHolder(Modifier modifier, Shape shape, boolean z, Composer composer, final int i, final int i2) {
        boolean z2;
        boolean z3;
        final boolean z4;
        final Shape shape2;
        final Modifier modifier2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i3;
        Modifier.Companion companion;
        Shape shapeM185RoundedCornerShape0680j_4;
        Preferences$Key preferences$Key;
        Context context;
        Object objRememberedValue;
        NeverEqualPolicy neverEqualPolicy;
        CoroutineScope coroutineScope;
        Object objRememberedValue2;
        GridItemSize gridItemSize;
        MutableState mutableStateCollectAsStateWithLifecycle;
        Object objRememberedValue3;
        float f;
        Modifier modifierM155width3ABfNKs;
        Modifier modifierM145height3ABfNKs;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-2113098135);
        int i4 = i | 22;
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                z2 = z;
                i4 |= gapComposer.changed(z2) ? 256 : 128;
            }
            if ((i4 & 147) != 146) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (gapComposer.shouldExecute(i4 & 1, z3)) {
                gapComposer.startDefaults();
                i3 = i & 1;
                companion = Modifier.Companion.$$INSTANCE;
                if (i3 != 0 || gapComposer.getDefaultsInvalid()) {
                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                    shapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(18.0f, 10.0f, gapComposer));
                    modifier = companion;
                    if (i5 != 0) {
                        z2 = false;
                    }
                } else {
                    gapComposer.skipToGroupEnd();
                    shapeM185RoundedCornerShape0680j_4 = shape;
                }
                gapComposer.endDefaults();
                preferences$Key = PreferenceKeysKt.GridItemsSizeKey;
                context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
                objRememberedValue = gapComposer.rememberedValue();
                neverEqualPolicy = Composer.Companion.Empty;
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = StateFlowKt.distinctUntilChanged(new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1(UtilsKt.getDataStore(context).getData(), preferences$Key, (byte) 11));
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                gridItemSize = GridItemSize.BIG;
                mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue2, gridItemSize, gapComposer, 48);
                objRememberedValue3 = gapComposer.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle, coroutineScope, context, preferences$Key);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                if (((GridItemSize) ((GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$2) objRememberedValue3).getValue()) == gridItemSize) {
                    SpringSpec springSpec2 = DimensionsKt.NavigationBarAnimationSpec;
                    f = 128.0f;
                } else {
                    SpringSpec springSpec3 = DimensionsKt.NavigationBarAnimationSpec;
                    f = 104.0f;
                }
                if (z2) {
                    modifierM155width3ABfNKs = SizeKt.fillMaxWidth(OffsetKt.m135padding3ABfNKs(modifier, 8.0f), 1.0f);
                } else {
                    modifierM155width3ABfNKs = SizeKt.m155width3ABfNKs(OffsetKt.m135padding3ABfNKs(modifier, 8.0f), f);
                }
                ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, 0);
                int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM155width3ABfNKs);
                ComposeUiNode.Companion.getClass();
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(LayoutNode.Constructor);
                } else {
                    gapComposer.useNode();
                }
                Stack.m390setimpl(gapComposer, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                Stack.m389reconcileimpl(gapComposer);
                Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                if (z2) {
                    modifierM145height3ABfNKs = SizeKt.fillMaxWidth(companion, 1.0f);
                } else {
                    modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(companion, f);
                }
                OffsetKt.Spacer(gapComposer, ImageKt.m39backgroundbw27NRU(ClipKt.clip(modifierM145height3ABfNKs.then(new AspectRatioElement(1.0f)), shapeM185RoundedCornerShape0680j_4), ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainerHigh, ColorKt.RectangleShape));
                OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 6.0f));
                UuidKt.m1896TextPlaceholderuFdPcIQ(null, CropImageView.DEFAULT_ASPECT_RATIO, null, gapComposer, 0, 7);
                UuidKt.m1896TextPlaceholderuFdPcIQ(null, CropImageView.DEFAULT_ASPECT_RATIO, null, gapComposer, 0, 7);
                gapComposer.end(true);
                z4 = z2;
                shape2 = shapeM185RoundedCornerShape0680j_4;
            } else {
                gapComposer.skipToGroupEnd();
                z4 = z2;
                shape2 = shape;
            }
            modifier2 = modifier;
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.shimmer.GridItemPlaceholderKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        Okio__OkioKt.GridItemPlaceHolder(modifier2, shape2, z4, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i4 = i | 406;
        z2 = z;
        if ((i4 & 147) != 146) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (gapComposer.shouldExecute(i4 & 1, z3)) {
            gapComposer.startDefaults();
            i3 = i & 1;
            companion = Modifier.Companion.$$INSTANCE;
            if (i3 != 0) {
                SpringSpec springSpec4 = DimensionsKt.NavigationBarAnimationSpec;
                shapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(18.0f, 10.0f, gapComposer));
                modifier = companion;
                if (i5 != 0) {
                    z2 = false;
                }
            } else {
                SpringSpec springSpec5 = DimensionsKt.NavigationBarAnimationSpec;
                shapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(18.0f, 10.0f, gapComposer));
                modifier = companion;
                if (i5 != 0) {
                    z2 = false;
                }
            }
            gapComposer.endDefaults();
            preferences$Key = PreferenceKeysKt.GridItemsSizeKey;
            context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            objRememberedValue = gapComposer.rememberedValue();
            neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            coroutineScope = (CoroutineScope) objRememberedValue;
            objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = StateFlowKt.distinctUntilChanged(new MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1(UtilsKt.getDataStore(context).getData(), preferences$Key, (byte) 11));
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gridItemSize = GridItemSize.BIG;
            mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle((Flow) objRememberedValue2, gridItemSize, gapComposer, 48);
            objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$2(mutableStateCollectAsStateWithLifecycle, coroutineScope, context, preferences$Key);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            if (((GridItemSize) ((GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$2) objRememberedValue3).getValue()) == gridItemSize) {
                SpringSpec springSpec6 = DimensionsKt.NavigationBarAnimationSpec;
                f = 128.0f;
            } else {
                SpringSpec springSpec7 = DimensionsKt.NavigationBarAnimationSpec;
                f = 104.0f;
            }
            if (z2) {
                modifierM155width3ABfNKs = SizeKt.fillMaxWidth(OffsetKt.m135padding3ABfNKs(modifier, 8.0f), 1.0f);
            } else {
                modifierM155width3ABfNKs = SizeKt.m155width3ABfNKs(OffsetKt.m135padding3ABfNKs(modifier, 8.0f), f);
            }
            ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, 0);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM155width3ABfNKs);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, columnMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
            if (z2) {
                modifierM145height3ABfNKs = SizeKt.fillMaxWidth(companion, 1.0f);
            } else {
                modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(companion, f);
            }
            OffsetKt.Spacer(gapComposer, ImageKt.m39backgroundbw27NRU(ClipKt.clip(modifierM145height3ABfNKs.then(new AspectRatioElement(1.0f)), shapeM185RoundedCornerShape0680j_4), ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainerHigh, ColorKt.RectangleShape));
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 6.0f));
            UuidKt.m1896TextPlaceholderuFdPcIQ(null, CropImageView.DEFAULT_ASPECT_RATIO, null, gapComposer, 0, 7);
            UuidKt.m1896TextPlaceholderuFdPcIQ(null, CropImageView.DEFAULT_ASPECT_RATIO, null, gapComposer, 0, 7);
            gapComposer.end(true);
            z4 = z2;
            shape2 = shapeM185RoundedCornerShape0680j_4;
        } else {
            gapComposer.skipToGroupEnd();
            z4 = z2;
            shape2 = shape;
        }
        modifier2 = modifier;
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.shimmer.GridItemPlaceholderKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    Okio__OkioKt.GridItemPlaceHolder(modifier2, shape2, z4, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final RealBufferedSink buffer(Sink sink) {
        sink.getClass();
        return new RealBufferedSink(sink);
    }

    public static long[] concat(long[]... jArr) {
        long length = 0;
        for (long[] jArr2 : jArr) {
            length += (long) jArr2.length;
        }
        int i = (int) length;
        coil3.util.UtilsKt.checkArgument(length, "the total number of elements (%s) in the arrays must fit in an int", length == ((long) i));
        long[] jArr3 = new long[i];
        int length2 = 0;
        for (long[] jArr4 : jArr) {
            System.arraycopy(jArr4, 0, jArr3, length2, jArr4.length);
            length2 += jArr4.length;
        }
        return jArr3;
    }

    public static final void copyOfRangeToIndexCheck(int i, int i2) {
        if (i <= i2) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m(IntIntPair$$ExternalSyntheticOutline0.m(i, "toIndex (", ") is greater than size (", i2, ")."));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Continuation createCoroutineUnintercepted(final Continuation continuation, final Continuation continuation2, final Function2 function2) {
        function2.getClass();
        if (function2 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function2).create(continuation, continuation2);
        }
        final CoroutineContext context = continuation2.getContext();
        return context == EmptyCoroutineContext.INSTANCE ? new RestrictedContinuationImpl(continuation2) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
            public byte label;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                byte b = this.label;
                if (b != 0) {
                    if (b != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This coroutine had already completed");
                        return null;
                    }
                    this.label = (byte) 2;
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                this.label = (byte) 1;
                ResultKt.throwOnFailure(obj);
                Function2 function3 = function2;
                function3.getClass();
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function3);
                return function3.invoke(continuation, this);
            }
        } : new ContinuationImpl(continuation2, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
            public byte label;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                byte b = this.label;
                if (b != 0) {
                    if (b != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This coroutine had already completed");
                        return null;
                    }
                    this.label = (byte) 2;
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                this.label = (byte) 1;
                ResultKt.throwOnFailure(obj);
                Function2 function3 = function2;
                function3.getClass();
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function3);
                return function3.invoke(continuation, this);
            }
        };
    }

    public static double distance(double[] dArr, double[] dArr2) {
        double d = dArr[0] - dArr2[0];
        double d2 = dArr[1] - dArr2[1];
        double d3 = dArr[2] - dArr2[2];
        return (d3 * d3) + (d2 * d2) + (d * d);
    }

    public static final Class getJavaClass(KClass kClass) {
        kClass.getClass();
        Class jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        jClass.getClass();
        return jClass;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class getJavaObjectType(KClass kClass) {
        kClass.getClass();
        Class jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (jClass.isPrimitive()) {
            String name = jClass.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return Short.class;
                    }
                    break;
            }
        }
        return jClass;
    }

    public static Continuation intercepted(Continuation continuation) {
        Continuation continuationIntercepted;
        continuation.getClass();
        ContinuationImpl continuationImpl = continuation instanceof ContinuationImpl ? (ContinuationImpl) continuation : null;
        return (continuationImpl == null || (continuationIntercepted = continuationImpl.intercepted()) == null) ? continuation : continuationIntercepted;
    }

    public static final boolean invalidatesCache(String str) {
        str.getClass();
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public static final boolean permitsRequestBody(String str) {
        str.getClass();
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static final String readYtEjsSolverScript(String str) throws IOException {
        InputStream resourceAsStream;
        String strConcat = "yt_ejs/".concat(str);
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if ((contextClassLoader == null || (resourceAsStream = contextClassLoader.getResourceAsStream(strConcat)) == null) && (resourceAsStream = coil3.size.SizeKt.class.getResourceAsStream("/".concat(strConcat))) == null) {
            resourceAsStream = coil3.size.SizeKt.class.getResourceAsStream(strConcat);
        }
        if (resourceAsStream == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) "Missing classpath resource: ".concat(strConcat));
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, Charsets.UTF_8), 8192);
        try {
            String text = RegexKt.readText(bufferedReader);
            bufferedReader.close();
            return text;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CharsKt.closeFinally(bufferedReader, th);
                throw th2;
            }
        }
    }

    public static final Object startUndispatched(ScopeCoroutine scopeCoroutine, boolean z, Object obj, Function2 function2) throws Throwable {
        Object completedExceptionally;
        Object objMakeCompletingOnce$kotlinx_coroutines_core;
        try {
            if (function2 instanceof BaseContinuationImpl) {
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function2);
                completedExceptionally = function2.invoke(obj, scopeCoroutine);
            } else {
                completedExceptionally = wrapWithContinuationImpl(function2, obj, scopeCoroutine);
            }
        } catch (DispatchException e) {
            Throwable th = e.cause;
            scopeCoroutine.makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(th, false));
            throw th;
        } catch (Throwable th2) {
            completedExceptionally = new CompletedExceptionally(th2, false);
        }
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (completedExceptionally == coroutineSingletons || (objMakeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally)) == AwaitKt.COMPLETING_WAITING_CHILDREN) {
            return coroutineSingletons;
        }
        scopeCoroutine.afterCompletionUndispatched();
        if (!(objMakeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
            return AwaitKt.unboxState(objMakeCompletingOnce$kotlinx_coroutines_core);
        }
        if (!z) {
            Throwable th3 = ((CompletedExceptionally) objMakeCompletingOnce$kotlinx_coroutines_core).cause;
            if ((th3 instanceof TimeoutCancellationException) && ((TimeoutCancellationException) th3).coroutine == scopeCoroutine) {
                if (completedExceptionally instanceof CompletedExceptionally) {
                    throw ((CompletedExceptionally) completedExceptionally).cause;
                }
                return completedExceptionally;
            }
        }
        throw ((CompletedExceptionally) objMakeCompletingOnce$kotlinx_coroutines_core).cause;
    }

    public static final LocalDateTime statToPeriod(OptionStats optionStats, int i) {
        optionStats.getClass();
        int iOrdinal = optionStats.ordinal();
        if (iOrdinal == 0) {
            LocalDateTime localDateTimeMinusDays = LocalDateTime.now().minusWeeks(i).minusDays(1L);
            localDateTimeMinusDays.getClass();
            return localDateTimeMinusDays;
        }
        if (iOrdinal == 1) {
            LocalDateTime localDateTimeMinusMonths = LocalDateTime.now().withDayOfMonth(1).minusMonths(i);
            localDateTimeMinusMonths.getClass();
            return localDateTimeMinusMonths;
        }
        if (iOrdinal == 2) {
            LocalDateTime localDateTimeMinusYears = LocalDateTime.now().withDayOfMonth(1).withMonth(1).minusYears(i);
            localDateTimeMinusYears.getClass();
            return localDateTimeMinusYears;
        }
        if (iOrdinal != 3) {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
            return null;
        }
        EnumEntriesList enumEntriesList = StatPeriod.$ENTRIES;
        if (i >= enumEntriesList.getSize()) {
            i = 0;
        }
        return ((StatPeriod) enumEntriesList.get(i)).toLocalDateTime();
    }

    public static void toQueryString(StringBuilder sb, List list) {
        IntProgression intProgressionStep = UuidKt.step(UuidKt.until(0, list.size()), 2);
        int i = intProgressionStep.first;
        int i2 = intProgressionStep.last;
        int i3 = intProgressionStep.step;
        if ((i3 <= 0 || i > i2) && (i3 >= 0 || i2 > i)) {
            return;
        }
        while (true) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
            if (i == i2) {
                return;
            } else {
                i += i3;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    public static final byte toUByte(String str) {
        UByte uByte;
        str.getClass();
        UInt uIntOrNull = toUIntOrNull(str);
        if (uIntOrNull != null) {
            int i = uIntOrNull.data;
            if (Integer.compareUnsigned(i, 255) > 0) {
                uByte = null;
            } else {
                uByte = new UByte((byte) i);
            }
        } else {
            uByte = null;
        }
        if (uByte != null) {
            return uByte.data;
        }
        StringsKt__StringsJVMKt.numberFormatError(str);
        throw null;
    }

    public static final UInt toUIntOrNull(String str) {
        int i;
        str.getClass();
        CharsKt.checkRadix(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        if (cCharAt < '0') {
            i = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i = 0;
        }
        int iDivideUnsigned = 119304647;
        while (i < length) {
            int iDigit = Character.digit((int) str.charAt(i), 10);
            if (iDigit < 0) {
                return null;
            }
            if (Integer.compareUnsigned(i2, iDivideUnsigned) > 0) {
                if (iDivideUnsigned != 119304647) {
                    return null;
                }
                iDivideUnsigned = Integer.divideUnsigned(-1, 10);
                if (Integer.compareUnsigned(i2, iDivideUnsigned) > 0) {
                    return null;
                }
            }
            int i3 = i2 * 10;
            int i4 = iDigit + i3;
            if (Integer.compareUnsigned(i4, i3) < 0) {
                return null;
            }
            i++;
            i2 = i4;
        }
        return new UInt(i2);
    }

    public static final ULong toULongOrNull(String str) {
        str.getClass();
        CharsKt.checkRadix(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i = 0;
        char cCharAt = str.charAt(0);
        if (cCharAt < '0') {
            i = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        }
        long j = 0;
        long jDivideUnsigned = 512409557603043100L;
        while (i < length) {
            int iDigit = Character.digit((int) str.charAt(i), 10);
            if (iDigit < 0) {
                return null;
            }
            if (Long.compareUnsigned(j, jDivideUnsigned) > 0) {
                if (jDivideUnsigned != 512409557603043100L) {
                    return null;
                }
                jDivideUnsigned = Long.divideUnsigned(-1L, 10L);
                if (Long.compareUnsigned(j, jDivideUnsigned) > 0) {
                    return null;
                }
            }
            long j2 = j * 10;
            long j3 = (((long) iDigit) & 4294967295L) + j2;
            if (Long.compareUnsigned(j3, j2) < 0) {
                return null;
            }
            i++;
            j = j3;
        }
        return new ULong(j);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    public static final short toUShort(String str) {
        UShort uShort;
        str.getClass();
        UInt uIntOrNull = toUIntOrNull(str);
        if (uIntOrNull != null) {
            int i = uIntOrNull.data;
            if (Integer.compareUnsigned(i, DatagramKt.MAX_DATAGRAM_SIZE) > 0) {
                uShort = null;
            } else {
                uShort = new UShort((short) i);
            }
        } else {
            uShort = null;
        }
        if (uShort != null) {
            return uShort.data;
        }
        StringsKt__StringsJVMKt.numberFormatError(str);
        throw null;
    }

    public static Object wrapWithContinuationImpl(Function2 function2, Object obj, Continuation continuation) {
        function2.getClass();
        CoroutineContext context = continuation.getContext();
        Object intrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1 = context == EmptyCoroutineContext.INSTANCE ? new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1(continuation) : new IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2(continuation, context);
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function2);
        return function2.invoke(obj, intrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1);
    }

    public int hashCode() {
        switch (this.$r8$classId) {
            case 13:
                return toString().hashCode();
            default:
                return super.hashCode();
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 13:
                String simpleName = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
                simpleName.getClass();
                return simpleName;
            default:
                return super.toString();
        }
    }
}
