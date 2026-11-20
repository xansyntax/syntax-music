package kotlin.text;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.InsetsPaddingValues;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListState$prefetchScope$1;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.innertube.models.Run;
import com.metrolist.music.discord.DiscordAuth;
import com.metrolist.music.discord.DiscordOAuthActivity;
import com.metrolist.music.utils.SyncUtils;
import com.yalantis.ucrop.view.CropImageView;
import dagger.hilt.EntryPoints;
import io.ktor.http.HttpHeaders;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteChannelKt;
import java.io.Closeable;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptySet;
import kotlin.collections.builders.SetBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.CharsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.SerializersCacheKt;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.PairSerializer;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.internal.ReferenceArraySerializer;
import kotlinx.serialization.internal.SerializerCache;
import kotlinx.serialization.internal.TripleSerializer;
import kotlinx.serialization.modules.SerialModuleImpl;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Buffer;
import okio.ByteString;
import okio.Okio__OkioKt;
import okio.Path;
import okio.RealBufferedSource;
import okio.internal.ResourceFileSystem$$ExternalSyntheticLambda0;
import sh.calvin.reorderable.AbsolutePixelPadding;
import sh.calvin.reorderable.ReorderableLazyCollectionState$layoutInfoFlow$1;
import sh.calvin.reorderable.ReorderableLazyListKt$rememberReorderableLazyListState$1$1;
import sh.calvin.reorderable.ReorderableLazyListKt$rememberReorderableLazyListState$state$1$1;
import sh.calvin.reorderable.ReorderableLazyListState;
import sh.calvin.reorderable.Scroller;
import sh.calvin.reorderable.ScrollerKt$rememberScroller$3$1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CharsKt {
    public CharsKt() {
        throw new UnsupportedOperationException("A DslProxy should never be instantiated");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void ReorderableItem(final LazyItemScopeImpl lazyItemScopeImpl, final ReorderableLazyListState reorderableLazyListState, final Object obj, Modifier modifier, boolean z, Modifier modifier2, final ComposableLambdaImpl composableLambdaImpl, Composer composer, final int i) {
        int i2;
        ComposableLambdaImpl composableLambdaImpl2;
        int i3;
        Modifier modifierAnimateItem$default;
        Modifier modifier3;
        boolean z2;
        Modifier modifierThen;
        boolean z3;
        Modifier modifierGraphicsLayer;
        final boolean z4;
        final Modifier modifier4;
        final Modifier modifier5;
        boolean z5;
        Modifier modifierGraphicsLayer2;
        lazyItemScopeImpl.getClass();
        reorderableLazyListState.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(346306449);
        byte b = 4;
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(lazyItemScopeImpl) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(reorderableLazyListState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(obj) ? 256 : 128;
        }
        int i4 = i2 | 27648;
        if ((196608 & i) == 0) {
            i4 = 93184 | i2;
        }
        if ((1572864 & i) == 0) {
            composableLambdaImpl2 = composableLambdaImpl;
            i4 |= gapComposer.changedInstance(composableLambdaImpl2) ? ByteChannelKt.CHANNEL_MAX_SIZE : 524288;
        } else {
            composableLambdaImpl2 = composableLambdaImpl;
        }
        if ((599187 & i4) == 599186 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            modifier4 = modifier;
            z4 = z;
            modifier5 = modifier2;
        } else {
            gapComposer.startDefaults();
            int i5 = i & 1;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (i5 == 0 || gapComposer.getDefaultsInvalid()) {
                i3 = i4 & (-458753);
                modifierAnimateItem$default = LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion);
                modifier3 = companion;
                z2 = true;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier;
                modifierAnimateItem$default = modifier2;
                i3 = i4 & (-458753);
                z2 = z;
            }
            gapComposer.endDefaults();
            gapComposer.startReplaceGroup(-1662944388);
            int i6 = i3 & 112;
            boolean z6 = i6 == 32;
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (z6 || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new ReorderableLazyCollectionState$layoutInfoFlow$1(reorderableLazyListState, b);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            gapComposer.end(false);
            DerivedSnapshotState derivedSnapshotStateDerivedStateOf = SnapshotStateKt__DerivedStateKt.derivedStateOf((Function0) objRememberedValue);
            DerivedSnapshotState derivedSnapshotStateDerivedStateOf2 = SnapshotStateKt__DerivedStateKt.derivedStateOf(new ScrollerKt$rememberScroller$3$1(obj, reorderableLazyListState, (byte) 2));
            if (((Boolean) derivedSnapshotStateDerivedStateOf2.getValue()).booleanValue()) {
                gapComposer.startReplaceGroup(-11550209);
                Modifier modifierZIndex = ZIndexModifierKt.zIndex(companion, 1.0f);
                int iOrdinal = ((Orientation) derivedSnapshotStateDerivedStateOf.getValue()).ordinal();
                if (iOrdinal == 0) {
                    gapComposer.startReplaceGroup(-1662936154);
                    gapComposer.startReplaceGroup(-1662935720);
                    boolean z7 = i6 == 32;
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (z7 || objRememberedValue2 == neverEqualPolicy) {
                        z5 = false;
                        final Object[] objArr = 0 == true ? 1 : 0;
                        objRememberedValue2 = new Function1() { // from class: sh.calvin.reorderable.ReorderableLazyListKt$ReorderableItem$offsetModifier$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                byte b2 = objArr;
                                Unit unit = Unit.INSTANCE;
                                ReorderableLazyListState reorderableLazyListState2 = reorderableLazyListState;
                                switch (b2) {
                                    case 0:
                                        ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj2;
                                        reusableGraphicsLayerScope.getClass();
                                        reusableGraphicsLayerScope.setTranslationY(Offset.m437getYimpl(reorderableLazyListState2.m1922getDraggingItemOffsetF1C5BW0$reorderable_release()));
                                        break;
                                    case 1:
                                        ReusableGraphicsLayerScope reusableGraphicsLayerScope2 = (ReusableGraphicsLayerScope) obj2;
                                        reusableGraphicsLayerScope2.getClass();
                                        reusableGraphicsLayerScope2.setTranslationX(Offset.m436getXimpl(reorderableLazyListState2.m1922getDraggingItemOffsetF1C5BW0$reorderable_release()));
                                        break;
                                    case 2:
                                        ReusableGraphicsLayerScope reusableGraphicsLayerScope3 = (ReusableGraphicsLayerScope) obj2;
                                        reusableGraphicsLayerScope3.getClass();
                                        reusableGraphicsLayerScope3.setTranslationY(Offset.m437getYimpl(((Offset) reorderableLazyListState2.previousDraggingItemOffset.getValue()).packedValue));
                                        break;
                                    default:
                                        ReusableGraphicsLayerScope reusableGraphicsLayerScope4 = (ReusableGraphicsLayerScope) obj2;
                                        reusableGraphicsLayerScope4.getClass();
                                        reusableGraphicsLayerScope4.setTranslationX(Offset.m436getXimpl(((Offset) reorderableLazyListState2.previousDraggingItemOffset.getValue()).packedValue));
                                        break;
                                }
                                return unit;
                            }
                        };
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    } else {
                        z5 = false;
                    }
                    gapComposer.end(z5);
                    modifierGraphicsLayer2 = ColorKt.graphicsLayer(companion, (Function1) objRememberedValue2);
                    gapComposer.end(z5);
                } else {
                    if (iOrdinal != 1) {
                        throw Format$$ExternalSyntheticOutline0.m(gapComposer, -1663429177, false);
                    }
                    gapComposer.startReplaceGroup(-1662931418);
                    gapComposer.startReplaceGroup(-1662930984);
                    boolean z8 = i6 == 32;
                    Object objRememberedValue3 = gapComposer.rememberedValue();
                    if (z8 || objRememberedValue3 == neverEqualPolicy) {
                        final byte b2 = 1;
                        objRememberedValue3 = new Function1() { // from class: sh.calvin.reorderable.ReorderableLazyListKt$ReorderableItem$offsetModifier$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                byte b3 = b2;
                                Unit unit = Unit.INSTANCE;
                                ReorderableLazyListState reorderableLazyListState2 = reorderableLazyListState;
                                switch (b3) {
                                    case 0:
                                        ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj2;
                                        reusableGraphicsLayerScope.getClass();
                                        reusableGraphicsLayerScope.setTranslationY(Offset.m437getYimpl(reorderableLazyListState2.m1922getDraggingItemOffsetF1C5BW0$reorderable_release()));
                                        break;
                                    case 1:
                                        ReusableGraphicsLayerScope reusableGraphicsLayerScope2 = (ReusableGraphicsLayerScope) obj2;
                                        reusableGraphicsLayerScope2.getClass();
                                        reusableGraphicsLayerScope2.setTranslationX(Offset.m436getXimpl(reorderableLazyListState2.m1922getDraggingItemOffsetF1C5BW0$reorderable_release()));
                                        break;
                                    case 2:
                                        ReusableGraphicsLayerScope reusableGraphicsLayerScope3 = (ReusableGraphicsLayerScope) obj2;
                                        reusableGraphicsLayerScope3.getClass();
                                        reusableGraphicsLayerScope3.setTranslationY(Offset.m437getYimpl(((Offset) reorderableLazyListState2.previousDraggingItemOffset.getValue()).packedValue));
                                        break;
                                    default:
                                        ReusableGraphicsLayerScope reusableGraphicsLayerScope4 = (ReusableGraphicsLayerScope) obj2;
                                        reusableGraphicsLayerScope4.getClass();
                                        reusableGraphicsLayerScope4.setTranslationX(Offset.m436getXimpl(((Offset) reorderableLazyListState2.previousDraggingItemOffset.getValue()).packedValue));
                                        break;
                                }
                                return unit;
                            }
                        };
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    z5 = false;
                    gapComposer.end(false);
                    modifierGraphicsLayer2 = ColorKt.graphicsLayer(companion, (Function1) objRememberedValue3);
                    gapComposer.end(false);
                }
                modifierThen = modifierZIndex.then(modifierGraphicsLayer2);
                gapComposer.end(z5);
            } else if (obj.equals(reorderableLazyListState.previousDraggingItemKey$delegate.getValue())) {
                gapComposer.startReplaceGroup(-11093021);
                Modifier modifierZIndex2 = ZIndexModifierKt.zIndex(companion, 1.0f);
                int iOrdinal2 = ((Orientation) derivedSnapshotStateDerivedStateOf.getValue()).ordinal();
                if (iOrdinal2 != 0) {
                    if (iOrdinal2 != 1) {
                        throw Format$$ExternalSyntheticOutline0.m(gapComposer, -1663429177, false);
                    }
                    gapComposer.startReplaceGroup(-1662916236);
                    gapComposer.startReplaceGroup(-1662915802);
                    boolean z9 = i6 == 32;
                    Object objRememberedValue4 = gapComposer.rememberedValue();
                    if (z9 || objRememberedValue4 == neverEqualPolicy) {
                        final byte b3 = 3;
                        objRememberedValue4 = new Function1() { // from class: sh.calvin.reorderable.ReorderableLazyListKt$ReorderableItem$offsetModifier$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                byte b4 = b3;
                                Unit unit = Unit.INSTANCE;
                                ReorderableLazyListState reorderableLazyListState2 = reorderableLazyListState;
                                switch (b4) {
                                    case 0:
                                        ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj2;
                                        reusableGraphicsLayerScope.getClass();
                                        reusableGraphicsLayerScope.setTranslationY(Offset.m437getYimpl(reorderableLazyListState2.m1922getDraggingItemOffsetF1C5BW0$reorderable_release()));
                                        break;
                                    case 1:
                                        ReusableGraphicsLayerScope reusableGraphicsLayerScope2 = (ReusableGraphicsLayerScope) obj2;
                                        reusableGraphicsLayerScope2.getClass();
                                        reusableGraphicsLayerScope2.setTranslationX(Offset.m436getXimpl(reorderableLazyListState2.m1922getDraggingItemOffsetF1C5BW0$reorderable_release()));
                                        break;
                                    case 2:
                                        ReusableGraphicsLayerScope reusableGraphicsLayerScope3 = (ReusableGraphicsLayerScope) obj2;
                                        reusableGraphicsLayerScope3.getClass();
                                        reusableGraphicsLayerScope3.setTranslationY(Offset.m437getYimpl(((Offset) reorderableLazyListState2.previousDraggingItemOffset.getValue()).packedValue));
                                        break;
                                    default:
                                        ReusableGraphicsLayerScope reusableGraphicsLayerScope4 = (ReusableGraphicsLayerScope) obj2;
                                        reusableGraphicsLayerScope4.getClass();
                                        reusableGraphicsLayerScope4.setTranslationX(Offset.m436getXimpl(((Offset) reorderableLazyListState2.previousDraggingItemOffset.getValue()).packedValue));
                                        break;
                                }
                                return unit;
                            }
                        };
                        gapComposer.updateRememberedValue(objRememberedValue4);
                    }
                    z3 = false;
                    gapComposer.end(false);
                    modifierGraphicsLayer = ColorKt.graphicsLayer(companion, (Function1) objRememberedValue4);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(-1662921420);
                    gapComposer.startReplaceGroup(-1662920986);
                    boolean z10 = i6 == 32;
                    Object objRememberedValue5 = gapComposer.rememberedValue();
                    if (z10 || objRememberedValue5 == neverEqualPolicy) {
                        final byte b4 = 2;
                        objRememberedValue5 = new Function1() { // from class: sh.calvin.reorderable.ReorderableLazyListKt$ReorderableItem$offsetModifier$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                byte b5 = b4;
                                Unit unit = Unit.INSTANCE;
                                ReorderableLazyListState reorderableLazyListState2 = reorderableLazyListState;
                                switch (b5) {
                                    case 0:
                                        ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj2;
                                        reusableGraphicsLayerScope.getClass();
                                        reusableGraphicsLayerScope.setTranslationY(Offset.m437getYimpl(reorderableLazyListState2.m1922getDraggingItemOffsetF1C5BW0$reorderable_release()));
                                        break;
                                    case 1:
                                        ReusableGraphicsLayerScope reusableGraphicsLayerScope2 = (ReusableGraphicsLayerScope) obj2;
                                        reusableGraphicsLayerScope2.getClass();
                                        reusableGraphicsLayerScope2.setTranslationX(Offset.m436getXimpl(reorderableLazyListState2.m1922getDraggingItemOffsetF1C5BW0$reorderable_release()));
                                        break;
                                    case 2:
                                        ReusableGraphicsLayerScope reusableGraphicsLayerScope3 = (ReusableGraphicsLayerScope) obj2;
                                        reusableGraphicsLayerScope3.getClass();
                                        reusableGraphicsLayerScope3.setTranslationY(Offset.m437getYimpl(((Offset) reorderableLazyListState2.previousDraggingItemOffset.getValue()).packedValue));
                                        break;
                                    default:
                                        ReusableGraphicsLayerScope reusableGraphicsLayerScope4 = (ReusableGraphicsLayerScope) obj2;
                                        reusableGraphicsLayerScope4.getClass();
                                        reusableGraphicsLayerScope4.setTranslationX(Offset.m436getXimpl(((Offset) reorderableLazyListState2.previousDraggingItemOffset.getValue()).packedValue));
                                        break;
                                }
                                return unit;
                            }
                        };
                        gapComposer.updateRememberedValue(objRememberedValue5);
                    }
                    z3 = false;
                    gapComposer.end(false);
                    modifierGraphicsLayer = ColorKt.graphicsLayer(companion, (Function1) objRememberedValue5);
                    gapComposer.end(false);
                }
                modifierThen = modifierZIndex2.then(modifierGraphicsLayer);
                gapComposer.end(z3);
            } else {
                gapComposer.startReplaceGroup(-10663144);
                gapComposer.end(false);
                modifierThen = modifierAnimateItem$default;
            }
            z4 = z2;
            EntryPoints.ReorderableCollectionItem(reorderableLazyListState, obj, modifier3.then(modifierThen), z4, ((Boolean) derivedSnapshotStateDerivedStateOf2.getValue()).booleanValue(), composableLambdaImpl2, gapComposer, 466046 & (i3 >> 3));
            modifier4 = modifier3;
            modifier5 = modifierAnimateItem$default;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: sh.calvin.reorderable.ReorderableLazyListKt$ReorderableItem$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    ((Number) obj3).intValue();
                    CharsKt.ReorderableItem(lazyItemScopeImpl, reorderableLazyListState, obj, modifier4, z4, modifier5, composableLambdaImpl, (Composer) obj2, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static Object awaitCode(DiscordAuth.AnonymousClass1 anonymousClass1) {
        CompletableDeferredImpl completableDeferredImpl = DiscordOAuthActivity.deferred;
        if (completableDeferredImpl != null) {
            return AwaitKt.withTimeout(120000L, new SyncUtils.AnonymousClass2(completableDeferredImpl, null, (byte) 23), anonymousClass1);
        }
        throw new CancellationException("No pending authorization");
    }

    public static SetBuilder build(SetBuilder setBuilder) {
        setBuilder.backing.build();
        return setBuilder.size() > 0 ? setBuilder : SetBuilder.Empty;
    }

    public static final void cancelConsumed(ReceiveChannel receiveChannel, Throwable th) {
        CancellationException CancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (CancellationException == null) {
            CancellationException = AwaitKt.CancellationException("Channel was consumed, consumer had failed", th);
        }
        receiveChannel.cancel(CancellationException);
    }

    public static void checkRadix(int i) {
        if (2 > i || i >= 37) {
            StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(i, "radix ", " was not in valid range ");
            sbM2m.append(new IntRange(2, 36, 1));
            throw new IllegalArgumentException(sbM2m.toString());
        }
    }

    public static final void closeFinally(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                ResultKt.addSuppressed(th, th2);
            }
        }
    }

    public static final boolean equals(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c);
        char upperCase2 = Character.toUpperCase(c2);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static Application getApplication(Context context) {
        if (context instanceof Application) {
            return (Application) context;
        }
        Context baseContext = context;
        while (baseContext instanceof ContextWrapper) {
            baseContext = ((ContextWrapper) baseContext).getBaseContext();
            if (baseContext instanceof Application) {
                return (Application) baseContext;
            }
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1(context, "Could not find an Application in the given context: ");
        return null;
    }

    public static boolean isEndToEnd(String str) {
        return (HttpHeaders.Connection.equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || HttpHeaders.ProxyAuthenticate.equalsIgnoreCase(str) || HttpHeaders.ProxyAuthorization.equalsIgnoreCase(str) || HttpHeaders.TE.equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || HttpHeaders.TransferEncoding.equalsIgnoreCase(str) || HttpHeaders.Upgrade.equalsIgnoreCase(str)) ? false : true;
    }

    public static boolean isWhitespace(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    public static String jsStringLiteral$com_github_MetrolistGroup_innertubex(String str) {
        str.getClass();
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\t') {
                sb.append("\\t");
            } else if (cCharAt == '\n') {
                sb.append("\\n");
            } else if (cCharAt == '\r') {
                sb.append("\\r");
            } else if (cCharAt == '\"') {
                sb.append("\\\"");
            } else if (cCharAt == '\\') {
                sb.append("\\\\");
            } else if (cCharAt < ' ') {
                checkRadix(16);
                String string = Integer.toString(cCharAt, 16);
                string.getClass();
                sb.append("\\u" + StringsKt.padStart(4, string));
            } else {
                sb.append(cCharAt);
            }
        }
        sb.append('\"');
        return sb.toString();
    }

    public static String key(HttpUrl httpUrl) {
        httpUrl.getClass();
        ByteString byteString = ByteString.EMPTY;
        return Path.Companion.encodeUtf8(httpUrl.url).digest$okio("MD5").hex();
    }

    public static final ArrayList oddElements(List list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__IterablesKt.throwIndexOverflow();
                throw null;
            }
            if (i % 2 == 0) {
                arrayList.add(obj);
            }
            i = i2;
        }
        return arrayList;
    }

    public static final KSerializer parametrizedSerializerOrNull(KClass kClass, ArrayList arrayList, Function0 function0) {
        KSerializer hashSetSerializer;
        KSerializer referenceArraySerializer;
        KSerializer tripleSerializer;
        if (kClass.equals(Reflection.getOrCreateKotlinClass(Collection.class)) || kClass.equals(Reflection.getOrCreateKotlinClass(List.class)) || kClass.equals(Reflection.getOrCreateKotlinClass(List.class)) || kClass.equals(Reflection.getOrCreateKotlinClass(ArrayList.class))) {
            hashSetSerializer = new HashSetSerializer((KSerializer) arrayList.get(0), (byte) 1);
        } else if (kClass.equals(Reflection.getOrCreateKotlinClass(HashSet.class))) {
            hashSetSerializer = new HashSetSerializer((KSerializer) arrayList.get(0), (byte) 0);
        } else if (kClass.equals(Reflection.getOrCreateKotlinClass(Set.class)) || kClass.equals(Reflection.getOrCreateKotlinClass(Set.class)) || kClass.equals(Reflection.getOrCreateKotlinClass(LinkedHashSet.class))) {
            hashSetSerializer = new HashSetSerializer((KSerializer) arrayList.get(0), (byte) 2);
        } else if (kClass.equals(Reflection.getOrCreateKotlinClass(HashMap.class))) {
            hashSetSerializer = new HashMapSerializer((KSerializer) arrayList.get(0), (KSerializer) arrayList.get(1), (byte) 0);
        } else if (kClass.equals(Reflection.getOrCreateKotlinClass(Map.class)) || kClass.equals(Reflection.getOrCreateKotlinClass(Map.class)) || kClass.equals(Reflection.getOrCreateKotlinClass(LinkedHashMap.class))) {
            hashSetSerializer = new HashMapSerializer((KSerializer) arrayList.get(0), (KSerializer) arrayList.get(1), (byte) 1);
        } else {
            if (kClass.equals(Reflection.getOrCreateKotlinClass(Map.Entry.class))) {
                KSerializer kSerializer = (KSerializer) arrayList.get(0);
                KSerializer kSerializer2 = (KSerializer) arrayList.get(1);
                kSerializer.getClass();
                kSerializer2.getClass();
                tripleSerializer = new PairSerializer(kSerializer, kSerializer2, (byte) 1);
            } else {
                if (kClass.equals(Reflection.getOrCreateKotlinClass(Pair.class))) {
                    KSerializer kSerializer3 = (KSerializer) arrayList.get(0);
                    KSerializer kSerializer4 = (KSerializer) arrayList.get(1);
                    kSerializer3.getClass();
                    kSerializer4.getClass();
                    referenceArraySerializer = new PairSerializer(kSerializer3, kSerializer4, (byte) 0);
                } else if (kClass.equals(Reflection.getOrCreateKotlinClass(Triple.class))) {
                    KSerializer kSerializer5 = (KSerializer) arrayList.get(0);
                    KSerializer kSerializer6 = (KSerializer) arrayList.get(1);
                    KSerializer kSerializer7 = (KSerializer) arrayList.get(2);
                    kSerializer5.getClass();
                    kSerializer6.getClass();
                    kSerializer7.getClass();
                    tripleSerializer = new TripleSerializer(kSerializer5, kSerializer6, kSerializer7);
                } else if (Okio__OkioKt.getJavaClass(kClass).isArray()) {
                    Object objInvoke = function0.invoke();
                    objInvoke.getClass();
                    KSerializer kSerializer8 = (KSerializer) arrayList.get(0);
                    kSerializer8.getClass();
                    referenceArraySerializer = new ReferenceArraySerializer((KClass) objInvoke, kSerializer8);
                } else {
                    hashSetSerializer = null;
                }
                hashSetSerializer = referenceArraySerializer;
            }
            hashSetSerializer = tripleSerializer;
        }
        if (hashSetSerializer != null) {
            return hashSetSerializer;
        }
        KSerializer[] kSerializerArr = (KSerializer[]) arrayList.toArray(new KSerializer[0]);
        return EnumsKt.constructSerializerForGivenTypeArgs(kClass, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    public static int readInt$okhttp(RealBufferedSource realBufferedSource) throws IOException {
        try {
            Buffer buffer = realBufferedSource.bufferField;
            realBufferedSource.require(1L);
            long j = 0;
            while (true) {
                long j2 = j + 1;
                if (!realBufferedSource.request(j2)) {
                    break;
                }
                byte b = buffer.getByte(j);
                if ((b >= 48 && b <= 57) || (j == 0 && b == 45)) {
                    j = j2;
                }
                if (j != 0) {
                    break;
                }
                checkRadix(16);
                String string = Integer.toString(b, 16);
                string.getClass();
                throw new NumberFormatException("Expected a digit or '-' but was 0x".concat(string));
            }
            long decimalLong = buffer.readDecimalLong();
            String utf8LineStrict = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
            if (decimalLong >= 0 && decimalLong <= 2147483647L && utf8LineStrict.length() <= 0) {
                return (int) decimalLong;
            }
            throw new IOException("expected an int but was \"" + decimalLong + utf8LineStrict + '\"');
        } catch (NumberFormatException e) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3(e.getMessage());
            return 0;
        }
    }

    /* JADX INFO: renamed from: rememberReorderableLazyListState-TN_CM5M, reason: not valid java name */
    public static final ReorderableLazyListState m1880rememberReorderableLazyListStateTN_CM5M(LazyListState lazyListState, InsetsPaddingValues insetsPaddingValues, Function4 function4, Composer composer, int i) {
        ReorderableLazyListKt$rememberReorderableLazyListState$state$1$1 reorderableLazyListKt$rememberReorderableLazyListState$state$1$1;
        lazyListState.getClass();
        function4.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startReplaceGroup(-645045624);
        PaddingValues paddingValuesImpl = (i & 2) != 0 ? new PaddingValuesImpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) : insetsPaddingValues;
        gapComposer.startReplaceGroup(1347434050);
        boolean zChanged = gapComposer.changed(lazyListState);
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        byte b = 0;
        if (zChanged || objRememberedValue == neverEqualPolicy) {
            objRememberedValue = new ReorderableLazyListKt$rememberReorderableLazyListState$1$1(b, lazyListState);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        Function0 function0 = (Function0) objRememberedValue;
        gapComposer.end(false);
        function0.getClass();
        gapComposer.startReplaceGroup(996643712);
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (objRememberedValue2 == neverEqualPolicy) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(Stack.createCompositionCoroutineScope(gapComposer));
            gapComposer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            objRememberedValue2 = compositionScopedCoroutineScopeCanceller;
        }
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).coroutineScope;
        MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(function0, gapComposer);
        MutableState mutableStateRememberUpdatedState2 = Stack.rememberUpdatedState(100L, gapComposer);
        gapComposer.startReplaceGroup(1852585201);
        boolean zChanged2 = gapComposer.changed(100L) | gapComposer.changed(lazyListState) | gapComposer.changed(coroutineScope);
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
            objRememberedValue3 = new Scroller(lazyListState, coroutineScope, new ScrollerKt$rememberScroller$3$1(mutableStateRememberUpdatedState, mutableStateRememberUpdatedState2, b));
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        Scroller scroller = (Scroller) objRememberedValue3;
        gapComposer.end(false);
        gapComposer.end(false);
        Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
        float fMo81toPx0680j_4 = density.mo81toPx0680j_4(48.0f);
        Object objRememberedValue4 = gapComposer.rememberedValue();
        if (objRememberedValue4 == neverEqualPolicy) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller2 = new CompositionScopedCoroutineScopeCanceller(Stack.createCompositionCoroutineScope(gapComposer));
            gapComposer.updateRememberedValue(compositionScopedCoroutineScopeCanceller2);
            objRememberedValue4 = compositionScopedCoroutineScopeCanceller2;
        }
        CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).coroutineScope;
        MutableState mutableStateRememberUpdatedState3 = Stack.rememberUpdatedState(function4, gapComposer);
        LayoutDirection layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
        AbsolutePixelPadding absolutePixelPadding = new AbsolutePixelPadding(density.mo81toPx0680j_4(OffsetKt.calculateStartPadding(paddingValuesImpl, layoutDirection)), density.mo81toPx0680j_4(OffsetKt.calculateEndPadding(paddingValuesImpl, layoutDirection)), density.mo81toPx0680j_4(paddingValuesImpl.mo125calculateTopPaddingD9Ej5fM()), density.mo81toPx0680j_4(paddingValuesImpl.mo122calculateBottomPaddingD9Ej5fM()));
        gapComposer.startReplaceGroup(1347465600);
        boolean zChanged3 = gapComposer.changed(lazyListState);
        Object objRememberedValue5 = gapComposer.rememberedValue();
        byte b2 = 1;
        if (zChanged3 || objRememberedValue5 == neverEqualPolicy) {
            objRememberedValue5 = new ReorderableLazyListKt$rememberReorderableLazyListState$1$1(b2, lazyListState);
            gapComposer.updateRememberedValue(objRememberedValue5);
        }
        gapComposer.end(false);
        DerivedSnapshotState derivedSnapshotStateDerivedStateOf = SnapshotStateKt__DerivedStateKt.derivedStateOf((Function0) objRememberedValue5);
        Orientation orientation = (Orientation) derivedSnapshotStateDerivedStateOf.getValue();
        gapComposer.startReplaceGroup(1347468268);
        boolean zChanged4 = gapComposer.changed(paddingValuesImpl) | gapComposer.changed(48.0f) | gapComposer.changed(coroutineScope2) | gapComposer.changed(lazyListState) | gapComposer.changed(scroller) | gapComposer.changed(orientation);
        Object objRememberedValue6 = gapComposer.rememberedValue();
        if (zChanged4 || objRememberedValue6 == neverEqualPolicy) {
            int iOrdinal = ((Orientation) derivedSnapshotStateDerivedStateOf.getValue()).ordinal();
            if (iOrdinal == 0) {
                reorderableLazyListKt$rememberReorderableLazyListState$state$1$1 = ReorderableLazyListKt$rememberReorderableLazyListState$state$1$1.INSTANCE;
            } else {
                if (iOrdinal != 1) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                reorderableLazyListKt$rememberReorderableLazyListState$state$1$1 = ReorderableLazyListKt$rememberReorderableLazyListState$state$1$1.INSTANCE$1;
            }
            ReorderableLazyListKt$rememberReorderableLazyListState$state$1$1 reorderableLazyListKt$rememberReorderableLazyListState$state$1$2 = reorderableLazyListKt$rememberReorderableLazyListState$state$1$1;
            scroller.getClass();
            layoutDirection.getClass();
            ReorderableLazyListState reorderableLazyListState = new ReorderableLazyListState(new LazyListState$prefetchScope$1(lazyListState), coroutineScope2, mutableStateRememberUpdatedState3, fMo81toPx0680j_4, absolutePixelPadding, scroller, layoutDirection, reorderableLazyListKt$rememberReorderableLazyListState$state$1$2);
            gapComposer.updateRememberedValue(reorderableLazyListState);
            objRememberedValue6 = reorderableLazyListState;
        }
        ReorderableLazyListState reorderableLazyListState2 = (ReorderableLazyListState) objRememberedValue6;
        gapComposer.end(false);
        gapComposer.end(false);
        return reorderableLazyListState2;
    }

    public static final KSerializer serializer(SerializersModule serializersModule, KType kType) {
        serializersModule.getClass();
        kType.getClass();
        KSerializer kSerializerSerializerByKTypeImpl$SerializersKt__SerializersKt = serializerByKTypeImpl$SerializersKt__SerializersKt(serializersModule, kType, true);
        if (kSerializerSerializerByKTypeImpl$SerializersKt__SerializersKt != null) {
            return kSerializerSerializerByKTypeImpl$SerializersKt__SerializersKt;
        }
        EnumsKt.serializerNotRegistered(EnumsKt.kclass(kType));
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:53:0x00d7 A[RETURN] */
    public static final KSerializer serializerByKTypeImpl$SerializersKt__SerializersKt(SerializersModule serializersModule, KType kType, boolean z) {
        KSerializer kSerializer;
        KSerializer kSerializerParametrizedSerializerOrNull;
        PolymorphicSerializer polymorphicSerializer;
        KClass kclass = EnumsKt.kclass(kType);
        boolean zIsMarkedNullable = kType.isMarkedNullable();
        List<KTypeProjection> arguments = kType.getArguments();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arguments, 10));
        for (KTypeProjection kTypeProjection : arguments) {
            kTypeProjection.getClass();
            KType type = kTypeProjection.getType();
            if (type == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$4(kTypeProjection.getType(), "Star projections in type arguments are not allowed, but had ");
                return null;
            }
            arrayList.add(type);
        }
        if (arrayList.isEmpty()) {
            if (Okio__OkioKt.getJavaClass(kclass).isInterface()) {
                SerializersModule.getContextual$default(serializersModule, kclass);
            }
            SerializerCache serializerCache = SerializersCacheKt.SERIALIZERS_CACHE;
            if (zIsMarkedNullable) {
                kSerializer = SerializersCacheKt.SERIALIZERS_CACHE_NULLABLE.get(kclass);
            } else {
                kSerializer = SerializersCacheKt.SERIALIZERS_CACHE.get(kclass);
                if (kSerializer == null) {
                    kSerializer = null;
                }
            }
        } else {
            ((SerialModuleImpl) serializersModule).getClass();
            SerializerCache serializerCache2 = SerializersCacheKt.SERIALIZERS_CACHE;
            Object objMo843getgIAlus = !zIsMarkedNullable ? SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE.mo843getgIAlus(kclass, arrayList) : SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE.mo843getgIAlus(kclass, arrayList);
            if (objMo843getgIAlus instanceof Result.Failure) {
                objMo843getgIAlus = null;
            }
            kSerializer = (KSerializer) objMo843getgIAlus;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        if (arrayList.isEmpty()) {
            kSerializerParametrizedSerializerOrNull = serializerOrNull(kclass);
            if (kSerializerParametrizedSerializerOrNull == null) {
                SerializersModule.getContextual$default(serializersModule, kclass);
                if (Okio__OkioKt.getJavaClass(kclass).isInterface()) {
                    polymorphicSerializer = new PolymorphicSerializer(kclass);
                    kSerializerParametrizedSerializerOrNull = polymorphicSerializer;
                } else {
                    kSerializerParametrizedSerializerOrNull = null;
                }
            }
            if (kSerializerParametrizedSerializerOrNull != null) {
                if (zIsMarkedNullable) {
                    return HexFormatKt.getNullable(kSerializerParametrizedSerializerOrNull);
                }
                return kSerializerParametrizedSerializerOrNull;
            }
        } else {
            ArrayList arrayListSerializersForParameters = serializersForParameters(serializersModule, arrayList, z);
            if (arrayListSerializersForParameters != null) {
                kSerializerParametrizedSerializerOrNull = parametrizedSerializerOrNull(kclass, arrayListSerializersForParameters, new ResourceFileSystem$$ExternalSyntheticLambda0((byte) 5, arrayList));
                if (kSerializerParametrizedSerializerOrNull == null) {
                    if (Okio__OkioKt.getJavaClass(kclass).isInterface()) {
                        polymorphicSerializer = new PolymorphicSerializer(kclass);
                        kSerializerParametrizedSerializerOrNull = polymorphicSerializer;
                    } else {
                        kSerializerParametrizedSerializerOrNull = null;
                    }
                }
                if (kSerializerParametrizedSerializerOrNull != null) {
                    if (zIsMarkedNullable) {
                        return HexFormatKt.getNullable(kSerializerParametrizedSerializerOrNull);
                    }
                    return kSerializerParametrizedSerializerOrNull;
                }
            }
        }
        return null;
    }

    public static final KSerializer serializerOrNull(KClass kClass) {
        kClass.getClass();
        KSerializer kSerializerConstructSerializerForGivenTypeArgs = EnumsKt.constructSerializerForGivenTypeArgs(kClass, new KSerializer[0]);
        return kSerializerConstructSerializerForGivenTypeArgs == null ? (KSerializer) PrimitivesKt.BUILTIN_SERIALIZERS.get(kClass) : kSerializerConstructSerializerForGivenTypeArgs;
    }

    public static final ArrayList serializersForParameters(SerializersModule serializersModule, List list, boolean z) {
        serializersModule.getClass();
        if (z) {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(serializer(serializersModule, (KType) it.next()));
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            KType kType = (KType) it2.next();
            kType.getClass();
            KSerializer kSerializerSerializerByKTypeImpl$SerializersKt__SerializersKt = serializerByKTypeImpl$SerializersKt__SerializersKt(serializersModule, kType, false);
            if (kSerializerSerializerByKTypeImpl$SerializersKt__SerializersKt == null) {
                return null;
            }
            arrayList2.add(kSerializerSerializerByKTypeImpl$SerializersKt__SerializersKt);
        }
        return arrayList2;
    }

    public static Set setOf(Object obj) {
        Set setSingleton = Collections.singleton(obj);
        setSingleton.getClass();
        return setSingleton;
    }

    public static final String sha1(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        bytes.getClass();
        byte[] bArrDigest = messageDigest.digest(bytes);
        bArrDigest.getClass();
        return HexExtensionsKt.toHexString$default(bArrDigest);
    }

    public static final ArrayList splitBySeparator(List list) {
        list.getClass();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Run run = (Run) it.next();
            if (Intrinsics.areEqual(StringsKt.trim(run.text).toString(), "•")) {
                arrayList.add(arrayList2);
                arrayList2 = new ArrayList();
            } else {
                arrayList2.add(run);
            }
        }
        arrayList.add(arrayList2);
        return arrayList;
    }

    public static void toggleMask(Buffer.UnsafeCursor unsafeCursor, byte[] bArr) {
        long j;
        unsafeCursor.getClass();
        bArr.getClass();
        int length = bArr.length;
        int i = 0;
        do {
            byte[] bArr2 = unsafeCursor.data;
            int i2 = unsafeCursor.start;
            int i3 = unsafeCursor.end;
            if (bArr2 != null) {
                while (i2 < i3) {
                    int i4 = i % length;
                    bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i4]);
                    i2++;
                    i = i4 + 1;
                }
            }
            long j2 = unsafeCursor.offset;
            Buffer buffer = unsafeCursor.buffer;
            buffer.getClass();
            if (j2 == buffer.size) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("no more bytes");
                return;
            }
            j = unsafeCursor.offset;
        } while (unsafeCursor.seek(j == -1 ? 0L : j + ((long) (unsafeCursor.end - unsafeCursor.start))) != -1);
    }

    public static Set varyFields(Headers headers) {
        int size = headers.size();
        TreeSet treeSet = null;
        for (int i = 0; i < size; i++) {
            if (HttpHeaders.Vary.equalsIgnoreCase(EntryPoints.commonName(headers, i))) {
                String strCommonValue = EntryPoints.commonValue(headers, i);
                if (treeSet == null) {
                    Comparator comparator = String.CASE_INSENSITIVE_ORDER;
                    comparator.getClass();
                    treeSet = new TreeSet(comparator);
                }
                Iterator it = StringsKt.split$default(strCommonValue, new char[]{','}).iterator();
                while (it.hasNext()) {
                    treeSet.add(StringsKt.trim((String) it.next()).toString());
                }
            }
        }
        return treeSet == null ? EmptySet.INSTANCE : treeSet;
    }

    public static final KSerializer serializer(KClass kClass) {
        kClass.getClass();
        KSerializer kSerializerSerializerOrNull = serializerOrNull(kClass);
        if (kSerializerSerializerOrNull != null) {
            return kSerializerSerializerOrNull;
        }
        EnumsKt.serializerNotRegistered(kClass);
        throw null;
    }
}
