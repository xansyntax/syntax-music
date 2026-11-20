package androidx.compose.material3;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.material3.Shapes;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3;
import com.metrolist.music.ui.screens.settings.ThemeScreenKt;
import com.metrolist.music.ui.theme.ThemeKt;
import com.metrolist.music.utils.InnerTubeXPlayer$$ExternalSyntheticLambda3;
import com.yalantis.ucrop.view.CropImageView;
import dev.chrisbanes.haze.HazeEffectNode;
import dev.chrisbanes.haze.HazeStyle;
import dev.chrisbanes.haze.HazeTint;
import dev.chrisbanes.haze.ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1;
import java.util.List;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ScrimKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ long f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ ScrimKt$$ExternalSyntheticLambda1(long j, Object obj, byte b) {
        this.$r8$classId = b;
        this.f$0 = j;
        this.f$1 = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        final long j = this.f$0;
        Object obj2 = this.f$1;
        switch (b) {
            case 0:
                DrawScope.m550drawRectnJ9OG0$default((DrawScope) obj, this.f$0, 0L, 0L, UuidKt.coerceIn(((Number) ((Function0) obj2).invoke()).floatValue(), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f), 0, 118);
                return unit;
            case 1:
                AnimatedContentTransitionScopeImpl.SizeModifierNode sizeModifierNode = (AnimatedContentTransitionScopeImpl.SizeModifierNode) obj2;
                if (!Intrinsics.areEqual(obj, sizeModifierNode.scope.getInitialState())) {
                    State state = (State) sizeModifierNode.scope.targetSizeMap.get(obj);
                    j = state != null ? ((IntSize) state.getValue()).packedValue : 0L;
                } else if (!IntSize.m810equalsimpl0(sizeModifierNode.lastSize, -9223372034707292160L)) {
                    j = sizeModifierNode.lastSize;
                }
                return new IntSize(j);
            case 2:
                LazyLayoutItemAnimation lazyLayoutItemAnimation = (LazyLayoutItemAnimation) obj2;
                lazyLayoutItemAnimation.m172setPlacementDeltagyyYBs(IntOffset.m805minusqkQi6aY(((IntOffset) ((Animatable) obj).getValue()).packedValue, j));
                lazyLayoutItemAnimation.onLayerPropertyChanged.invoke();
                return unit;
            case 3:
                String str = (String) obj2;
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare("UPDATE song SET totalPlayTime = totalPlayTime + ? WHERE id = ?");
                try {
                    sQLiteStatementPrepare.bindLong(1, j);
                    sQLiteStatementPrepare.bindText(2, str);
                    sQLiteStatementPrepare.step();
                    return unit;
                } finally {
                    sQLiteStatementPrepare.close();
                }
            case 4:
                HazeEffectNode hazeEffectNode = (HazeEffectNode) obj;
                hazeEffectNode.getClass();
                long j2 = ((ColorScheme) obj2).surface;
                HazeStyle hazeStyle = new HazeStyle(ColorKt.Color(Color.m485getRedimpl(j2), Color.m484getGreenimpl(j2), Color.m482getBlueimpl(j2), 0.55f, Color.m483getColorSpaceimpl(j2)), new HazeTint(j), 16.0f, CropImageView.DEFAULT_ASPECT_RATIO);
                if (!Intrinsics.areEqual(hazeEffectNode.style, hazeStyle)) {
                    hazeEffectNode.onStyleChanged(hazeEffectNode.style, hazeStyle);
                    hazeEffectNode.style = hazeStyle;
                }
                return unit;
            default:
                final Function1 function1 = (Function1) obj2;
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                final List list = ThemeScreenKt.PaletteColors;
                lazyListIntervalContent.items(list.size(), new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 17), list, (byte) 22), new AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3(list, (byte) 15), new ComposableLambdaImpl(true, 802480018, new Function4() { // from class: com.metrolist.music.ui.screens.settings.ThemeScreenKt$ThemeControls_yrwZFoE$lambda$0$0$1$0$0$$inlined$items$default$4
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj3, Object obj4, Object obj5, Object obj6) {
                        int i;
                        boolean zM1869equalsimpl0;
                        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj3;
                        int iIntValue = ((Number) obj4).intValue();
                        Composer composer = (Composer) obj5;
                        int iIntValue2 = ((Number) obj6).intValue();
                        if ((iIntValue2 & 6) == 0) {
                            i = (((GapComposer) composer).changed(lazyItemScopeImpl) ? 4 : 2) | iIntValue2;
                        } else {
                            i = iIntValue2;
                        }
                        if ((iIntValue2 & 48) == 0) {
                            i |= ((GapComposer) composer).changed(iIntValue) ? 32 : 16;
                        }
                        GapComposer gapComposer = (GapComposer) composer;
                        if (gapComposer.shouldExecute(i & 1, (i & 147) != 146)) {
                            final ThemePalette themePalette = (ThemePalette) list.get(iIntValue);
                            gapComposer.startReplaceGroup(-1489965463);
                            final boolean zM1869equalsimpl1 = ULong.m1869equalsimpl0(themePalette.seedColor, 0L);
                            long j3 = j;
                            if (zM1869equalsimpl1) {
                                Shapes shapes = ThemeKt.EditorialShapes;
                                zM1869equalsimpl0 = ULong.m1869equalsimpl0(j3, -17343425833598976L);
                            } else {
                                zM1869equalsimpl0 = ULong.m1869equalsimpl0(j3, themePalette.seedColor);
                            }
                            boolean zChanged = gapComposer.changed(zM1869equalsimpl1) | gapComposer.changed(themePalette);
                            final Function1 function2 = function1;
                            boolean zChanged2 = zChanged | gapComposer.changed(function2);
                            Object objRememberedValue = gapComposer.rememberedValue();
                            if (zChanged2 || objRememberedValue == Composer.Companion.Empty) {
                                objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.screens.settings.ThemeScreenKt$ThemeControls$1$1$2$1$1$2$1$1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        long j4;
                                        if (zM1869equalsimpl1) {
                                            Shapes shapes2 = ThemeKt.EditorialShapes;
                                            j4 = -17343425833598976L;
                                        } else {
                                            j4 = themePalette.seedColor;
                                        }
                                        function2.invoke(new Color(j4));
                                        return Unit.INSTANCE;
                                    }
                                };
                                gapComposer.updateRememberedValue(objRememberedValue);
                            }
                            ThemeScreenKt.PaletteItem(themePalette, zM1869equalsimpl0, (Function0) objRememberedValue, gapComposer, 0);
                            gapComposer.end(false);
                        } else {
                            gapComposer.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }));
                return unit;
        }
    }

    public /* synthetic */ ScrimKt$$ExternalSyntheticLambda1(Object obj, long j, byte b) {
        this.$r8$classId = b;
        this.f$1 = obj;
        this.f$0 = j;
    }
}
