package androidx.compose.material3;

import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.FlowRowScopeInstance;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifierNode;
import androidx.compose.foundation.text.selection.SelectionMagnifierKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda4;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifier;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.graphics.BlurEffect;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.exoplayer.offline.Download;
import coil3.compose.AsyncImageKt;
import coil3.request.ImageRequest;
import coil3.size.RealSizeResolver;
import coil3.util.FileSystemsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.pages.ChartsPage;
import com.metrolist.innertube.pages.SearchSummary;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.RecognitionHistory;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.eq.data.SavedEQProfile;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.ui.component.BottomSheetPageState;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.DialogKt$$ExternalSyntheticLambda29;
import com.metrolist.music.ui.component.Icon;
import com.metrolist.music.ui.component.ItemsKt$AlbumGridItem$1$songs$2$1;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda11;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda117;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda82;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.ui.screens.equalizer.EqScreenKt;
import com.metrolist.music.ui.screens.equalizer.wizard.DeviceModel;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import com.metrolist.music.ui.screens.settings.AiSettingsKt;
import com.metrolist.music.ui.screens.settings.BackupAndRestoreKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.screens.settings.ChangelogScreenKt;
import com.metrolist.music.utils.ReleaseInfo;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.SemaphoreAndMutexImpl;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ListItemKt$$ExternalSyntheticLambda17 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ListItemKt$$ExternalSyntheticLambda17(MutexImpl mutexImpl, MutexImpl.CancellableContinuationWithOwner cancellableContinuationWithOwner) {
        this.$r8$classId = (byte) 24;
        this.f$0 = mutexImpl;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$ChangelogScreenKt$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3) {
        ReleaseInfo releaseInfo = (ReleaseInfo) this.f$0;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((ColumnScopeInstance) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(Modifier.Companion.$$INSTANCE, 16.0f);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, 0);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM135padding3ABfNKs);
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
            ChangelogScreenKt.MarkdownText(releaseInfo.description, gapComposer, 0);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:303:0x08f2  */
    /* JADX WARN: Code duplicated, block: B:414:0x0bfc  */
    /* JADX WARN: Code duplicated, block: B:96:0x025f A[PHI: r3
      0x025f: PHI (r3v74 boolean) = 
      (r3v63 boolean)
      (r3v64 boolean)
      (r3v65 boolean)
      (r3v66 boolean)
      (r3v67 boolean)
      (r3v68 boolean)
      (r3v69 boolean)
      (r3v70 boolean)
      (r3v71 boolean)
      (r3v75 boolean)
     binds: [B:95:0x025d, B:91:0x024b, B:87:0x0239, B:83:0x0228, B:79:0x0217, B:75:0x0206, B:71:0x01f4, B:67:0x01e2, B:63:0x01d0, B:55:0x01ae] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x01ab. Please report as an issue. */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) throws XmlPullParserException, IOException {
        boolean z;
        boolean z2;
        boolean z3;
        Object obj4;
        Object obj5;
        int i;
        int i2;
        boolean z4;
        List list;
        int i3;
        boolean z5;
        int i4;
        int i5;
        byte b = this.$r8$classId;
        Continuation continuation = null;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        Object obj6 = this.f$0;
        switch (b) {
            case 0:
                Placeable placeableMo598measureBRTryo0 = ((Measurable) obj2).mo598measureBRTryo0(((Constraints) obj3).value);
                return ((MeasureScope) obj).layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new ZIndexNode$$ExternalSyntheticLambda0((Object) placeableMo598measureBRTryo0, obj6, (byte) 12));
            case 1:
                CoreTextFieldSemanticsModifierNode coreTextFieldSemanticsModifierNode = (CoreTextFieldSemanticsModifierNode) obj6;
                int iIntValue = ((Integer) obj).intValue();
                int iIntValue2 = ((Integer) obj2).intValue();
                boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                if (!zBooleanValue) {
                    iIntValue = coreTextFieldSemanticsModifierNode.offsetMapping.transformedToOriginal(iIntValue);
                }
                if (!zBooleanValue) {
                    iIntValue2 = coreTextFieldSemanticsModifierNode.offsetMapping.transformedToOriginal(iIntValue2);
                }
                if (coreTextFieldSemanticsModifierNode.enabled) {
                    long j = coreTextFieldSemanticsModifierNode.value.selection;
                    int i6 = TextRange.$r8$clinit;
                    if (iIntValue == ((int) (j >> 32)) && iIntValue2 == ((int) (j & 4294967295L))) {
                        z = false;
                    } else {
                        int iMin = Math.min(iIntValue, iIntValue2);
                        HandleState handleState = HandleState.None;
                        if (iMin < 0 || Math.max(iIntValue, iIntValue2) > coreTextFieldSemanticsModifierNode.value.annotatedString.text.length()) {
                            TextFieldSelectionManager textFieldSelectionManager = coreTextFieldSemanticsModifierNode.manager;
                            textFieldSelectionManager.updateFloatingToolbar(false);
                            textFieldSelectionManager.setHandleState(handleState);
                            z = false;
                        } else {
                            if (zBooleanValue || iIntValue == iIntValue2) {
                                z2 = true;
                                TextFieldSelectionManager textFieldSelectionManager2 = coreTextFieldSemanticsModifierNode.manager;
                                textFieldSelectionManager2.updateFloatingToolbar(false);
                                textFieldSelectionManager2.setHandleState(handleState);
                            } else {
                                z2 = true;
                                coreTextFieldSemanticsModifierNode.manager.enterSelectionMode$foundation(true);
                            }
                            coreTextFieldSemanticsModifierNode.state.onValueChange.invoke(new TextFieldValue(coreTextFieldSemanticsModifierNode.value.annotatedString, TextRangeKt.TextRange(iIntValue, iIntValue2), (TextRange) null));
                            z = z2;
                        }
                    }
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 2:
                TextFieldSelectionManager textFieldSelectionManager3 = (TextFieldSelectionManager) obj6;
                Modifier modifier = (Modifier) obj;
                ((Integer) obj3).getClass();
                GapComposer gapComposer = (GapComposer) ((Composer) obj2);
                gapComposer.startReplaceGroup(1980580247);
                Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
                Object objRememberedValue = gapComposer.rememberedValue();
                Object obj7 = objRememberedValue;
                if (objRememberedValue == neverEqualPolicy) {
                    ParcelableSnapshotMutableState parcelableSnapshotMutableStateMutableStateOf$default = Stack.mutableStateOf$default(new IntSize(0L));
                    gapComposer.updateRememberedValue(parcelableSnapshotMutableStateMutableStateOf$default);
                    obj7 = parcelableSnapshotMutableStateMutableStateOf$default;
                }
                MutableState mutableState = (MutableState) obj7;
                boolean zChangedInstance = gapComposer.changedInstance(textFieldSelectionManager3);
                Object objRememberedValue2 = gapComposer.rememberedValue();
                Object obj8 = objRememberedValue2;
                if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                    Recomposer$$ExternalSyntheticLambda6 recomposer$$ExternalSyntheticLambda6 = new Recomposer$$ExternalSyntheticLambda6((Object) textFieldSelectionManager3, (Object) mutableState, (byte) 17);
                    gapComposer.updateRememberedValue(recomposer$$ExternalSyntheticLambda6);
                    obj8 = recomposer$$ExternalSyntheticLambda6;
                }
                Function0 function0 = (Function0) obj8;
                boolean zChanged = gapComposer.changed(density);
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                    z3 = false;
                    TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda4 textFieldSelectionManager_androidKt$$ExternalSyntheticLambda4 = new TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda4(density, mutableState, false ? 1 : 0);
                    gapComposer.updateRememberedValue(textFieldSelectionManager_androidKt$$ExternalSyntheticLambda4);
                    obj4 = textFieldSelectionManager_androidKt$$ExternalSyntheticLambda4;
                } else {
                    z3 = false;
                    obj4 = objRememberedValue3;
                }
                AnimationVector2D animationVector2D = SelectionMagnifierKt.UnspecifiedAnimationVector2D;
                Modifier modifierThen = modifier.then(new ComposedModifier(new AlbumMenuKt$$ExternalSyntheticLambda11(function0, (Function1) obj4, (byte) 5)));
                gapComposer.end(z3);
                return modifierThen;
            case 3:
                MenuState menuState = (MenuState) obj6;
                Composer composer = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer;
                if (gapComposer2.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 20.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer2, 0);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM137paddingVpY3zN4$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    ((Function3) menuState.content$delegate.getValue()).invoke(ColumnScopeInstance.INSTANCE, gapComposer2, 6);
                    gapComposer2.end(true);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 4:
                BottomSheetPageState bottomSheetPageState = (BottomSheetPageState) obj6;
                Composer composer2 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer2;
                if (gapComposer3.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 16.0f, 7);
                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer3, 0);
                    int iHashCode2 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM139paddingqDBjuR0$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, columnMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer3, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    ((Function3) bottomSheetPageState.content$delegate.getValue()).invoke(ColumnScopeInstance.INSTANCE, gapComposer3, 6);
                    gapComposer3.end(true);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 5:
                Function3 function3 = (Function3) obj6;
                FlowRowScopeInstance flowRowScopeInstance = (FlowRowScopeInstance) obj;
                Composer composer3 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                flowRowScopeInstance.getClass();
                if ((iIntValue5 & 6) == 0) {
                    iIntValue5 |= ((GapComposer) composer3).changed(flowRowScopeInstance) ? 4 : 2;
                }
                GapComposer gapComposer4 = (GapComposer) composer3;
                if (gapComposer4.shouldExecute(iIntValue5 & 1, (iIntValue5 & 19) != 18)) {
                    Stack.CompositionLocalProvider(Fragment$5$$ExternalSyntheticOutline0.m(((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary, ContentColorKt.LocalContentColor), Expect_jvmKt.rememberComposableLambda(622620188, new DialogKt$$ExternalSyntheticLambda29(function3, flowRowScopeInstance, (byte) 0), gapComposer4), gapComposer4, 56);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 6:
                Album album = (Album) obj6;
                Composer composer4 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer4;
                if (gapComposer5.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    DownloadUtil downloadUtil = (DownloadUtil) gapComposer5.consume(MainActivityKt.LocalDownloadUtil);
                    MusicDatabase musicDatabase = (MusicDatabase) gapComposer5.consume(MainActivityKt.LocalDatabase);
                    AlbumEntity albumEntity = album.album;
                    String str = albumEntity.id;
                    boolean zChangedInstance2 = gapComposer5.changedInstance(musicDatabase) | gapComposer5.changed(album);
                    Object objRememberedValue4 = gapComposer5.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue4 == neverEqualPolicy) {
                        obj5 = objRememberedValue4;
                        ItemsKt$AlbumGridItem$1$songs$2$1 itemsKt$AlbumGridItem$1$songs$2$1 = new ItemsKt$AlbumGridItem$1$songs$2$1(musicDatabase, album, continuation, (byte) 0);
                        gapComposer5.updateRememberedValue(itemsKt$AlbumGridItem$1$songs$2$1);
                        obj5 = itemsKt$AlbumGridItem$1$songs$2$1;
                    }
                    MutableState mutableStateProduceState = Stack.produceState(EmptyList.INSTANCE, str, (Function2) obj5, gapComposer5);
                    MutableState mutableStateCollectAsStateWithLifecycle = FileSystemsKt.collectAsStateWithLifecycle(downloadUtil.downloads, gapComposer5);
                    boolean zChanged2 = gapComposer5.changed((List) mutableStateProduceState.getValue()) | gapComposer5.changed((Map) mutableStateCollectAsStateWithLifecycle.getValue());
                    Object objRememberedValue5 = gapComposer5.rememberedValue();
                    Object objM = objRememberedValue5;
                    if (zChanged2 || objRememberedValue5 == neverEqualPolicy) {
                        if (((List) mutableStateProduceState.getValue()).isEmpty()) {
                            i = 1;
                        } else {
                            List list2 = (List) mutableStateProduceState.getValue();
                            if (list2 == null || !list2.isEmpty()) {
                                Iterator it = list2.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        Download download = (Download) ((Map) mutableStateCollectAsStateWithLifecycle.getValue()).get(((Song) it.next()).song.id);
                                        if (download == null || download.state != 3) {
                                            List list3 = (List) mutableStateProduceState.getValue();
                                            if (list3 == null || !list3.isEmpty()) {
                                                Iterator it2 = list3.iterator();
                                                while (true) {
                                                    if (it2.hasNext()) {
                                                        Song song = (Song) it2.next();
                                                        List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new Integer[]{0, 2});
                                                        Download download2 = (Download) ((Map) mutableStateCollectAsStateWithLifecycle.getValue()).get(song.song.id);
                                                        if (CollectionsKt.contains(listListOf, download2 != null ? Integer.valueOf(download2.state) : null)) {
                                                            i = 2;
                                                        }
                                                    } else {
                                                        i = 1;
                                                    }
                                                }
                                            } else {
                                                i = 1;
                                            }
                                        }
                                    } else {
                                        i = 3;
                                    }
                                }
                            } else {
                                i = 3;
                            }
                        }
                        objM = Fragment$5$$ExternalSyntheticOutline0.m(i, gapComposer5);
                    }
                    ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) objM;
                    LocalDateTime localDateTime = albumEntity.bookmarkedAt;
                    Icon icon = Icon.INSTANCE;
                    if (localDateTime != null) {
                        gapComposer5.startReplaceGroup(1495330975);
                        i2 = 6;
                        icon.Favorite(6, gapComposer5);
                        z4 = false;
                        gapComposer5.end(false);
                    } else {
                        i2 = 6;
                        z4 = false;
                        gapComposer5.startReplaceGroup(1495368454);
                        gapComposer5.end(false);
                    }
                    if (albumEntity.explicit) {
                        gapComposer5.startReplaceGroup(1495404383);
                        icon.Explicit(i2, gapComposer5);
                        gapComposer5.end(z4);
                    } else {
                        gapComposer5.startReplaceGroup(1495441862);
                        gapComposer5.end(z4);
                    }
                    icon.Download(Integer.valueOf(parcelableSnapshotMutableIntState.getIntValue()), gapComposer5, 48);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 7:
                ColorScheme colorScheme = (ColorScheme) obj6;
                Composer composer5 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                ((BoxScope) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer5;
                if (gapComposer6.shouldExecute(iIntValue7 & 1, (iIntValue7 & 17) != 16)) {
                    CardKt.m252BadgeeopBjH0(null, colorScheme.error, 0L, gapComposer6, 0, 13);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 8:
                Song song2 = (Song) obj6;
                Composer composer6 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer6;
                if (gapComposer7.shouldExecute(iIntValue8 & 1, (iIntValue8 & 17) != 16)) {
                    com.metrolist.music.ui.utils.AppBarKt.ShowMediaInfo(song2.song.id, gapComposer7, 0);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 9:
                PlaylistItem playlistItem = (PlaylistItem) obj6;
                Composer composer7 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer8 = (GapComposer) composer7;
                if (gapComposer8.shouldExecute(iIntValue9 & 1, (iIntValue9 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.remove_download_playlist_confirm, new Object[]{playlistItem.title}, gapComposer8), OffsetKt.m137paddingVpY3zN4$default(companion, 18.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer8.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyLarge, gapComposer8, 48, 0, 131068);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 10:
                SongItem songItem = (SongItem) obj6;
                Composer composer8 = (Composer) obj2;
                int iIntValue10 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer9 = (GapComposer) composer8;
                if (gapComposer9.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                    com.metrolist.music.ui.utils.AppBarKt.ShowMediaInfo(songItem.id, gapComposer9, 0);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 11:
                Context context = (Context) obj6;
                String str2 = (String) obj;
                Composer composer9 = (Composer) obj2;
                int iIntValue11 = ((Integer) obj3).intValue();
                str2.getClass();
                if ((iIntValue11 & 6) == 0) {
                    iIntValue11 |= ((GapComposer) composer9).changed(str2) ? 4 : 2;
                }
                GapComposer gapComposer10 = (GapComposer) composer9;
                if (gapComposer10.shouldExecute(iIntValue11 & 1, (iIntValue11 & 19) != 18)) {
                    boolean z6 = (iIntValue11 & 14) == 4;
                    Object objRememberedValue6 = gapComposer10.rememberedValue();
                    if (z6 || objRememberedValue6 == neverEqualPolicy) {
                        ImageRequest.Builder builder = new ImageRequest.Builder(context);
                        builder.data = str2;
                        builder.sizeResolver = new RealSizeResolver(coil3.size.SizeKt.Size(64, 64));
                        objRememberedValue6 = builder.build();
                        gapComposer10.updateRememberedValue(objRememberedValue6);
                    }
                    ImageRequest imageRequest = (ImageRequest) objRememberedValue6;
                    FillElement fillElement = SizeKt.FillWholeMaxSize;
                    Object objRememberedValue7 = gapComposer10.rememberedValue();
                    if (objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = new SongMenuKt$$ExternalSyntheticLambda16((byte) 29);
                        gapComposer10.updateRememberedValue(objRememberedValue7);
                    }
                    Modifier modifierGraphicsLayer = ColorKt.graphicsLayer(fillElement, (Function1) objRememberedValue7);
                    if (Dp.m795compareTo0680j_4(72.0f, CropImageView.DEFAULT_ASPECT_RATIO) > 0) {
                        Dp.m795compareTo0680j_4(72.0f, CropImageView.DEFAULT_ASPECT_RATIO);
                    }
                    final boolean z7 = true;
                    final int i7 = 0;
                    AsyncImageKt.m849AsyncImage10Xjiaw(imageRequest, ColorKt.graphicsLayer(modifierGraphicsLayer, new Function1() { // from class: androidx.compose.ui.draw.BlurKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj9) {
                            ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj9;
                            float density2 = reusableGraphicsLayerScope.graphicsDensity.getDensity() * 72.0f;
                            float density3 = reusableGraphicsLayerScope.graphicsDensity.getDensity() * 72.0f;
                            reusableGraphicsLayerScope.setRenderEffect((density2 <= CropImageView.DEFAULT_ASPECT_RATIO || density3 <= CropImageView.DEFAULT_ASPECT_RATIO) ? null : new BlurEffect(density2, density3, i7));
                            reusableGraphicsLayerScope.setShape(ColorKt.RectangleShape);
                            reusableGraphicsLayerScope.setClip(z7);
                            return Unit.INSTANCE;
                        }
                    }), ContentScale.Companion.Crop, gapComposer10, 1573296, 1976);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                String strStringResource = ((ChartsPage.ChartSection) obj6).title;
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                Composer composer10 = (Composer) obj2;
                int iIntValue12 = ((Integer) obj3).intValue();
                lazyItemScopeImpl.getClass();
                if ((iIntValue12 & 6) == 0) {
                    iIntValue12 |= ((GapComposer) composer10).changed(lazyItemScopeImpl) ? 4 : 2;
                }
                GapComposer gapComposer11 = (GapComposer) composer10;
                if (gapComposer11.shouldExecute(iIntValue12 & 1, (iIntValue12 & 19) != 18)) {
                    if (Intrinsics.areEqual(strStringResource, "Trending")) {
                        strStringResource = Format$$ExternalSyntheticOutline0.m(gapComposer11, -421758774, R.string.trending, gapComposer11, false);
                    } else {
                        gapComposer11.startReplaceGroup(-189524562);
                        if (strStringResource.length() == 0) {
                            strStringResource = MathKt.stringResource(R.string.charts, gapComposer11);
                        }
                        gapComposer11.end(false);
                    }
                    com.metrolist.music.ui.component.MenuKt.NavigationTitle(strStringResource, LazyItemScopeImpl.animateItem$default(lazyItemScopeImpl, companion), null, null, null, null, gapComposer11, 0, 60);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case 13:
                ListenTogetherManager listenTogetherManager = (ListenTogetherManager) obj6;
                Composer composer11 = (Composer) obj2;
                int iIntValue13 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer12 = (GapComposer) composer11;
                if (gapComposer12.shouldExecute(iIntValue13 & 1, (iIntValue13 & 17) != 16)) {
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
                    ButtonColors buttonColorsM247buttonColorsro_MJ88 = ButtonDefaults.m247buttonColorsro_MJ88(((MaterialTheme$Values) gapComposer12.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error, 0L, 0L, gapComposer12, 14);
                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f);
                    boolean zChangedInstance3 = gapComposer12.changedInstance(listenTogetherManager);
                    Object objRememberedValue8 = gapComposer12.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = new PlayerMenuKt$$ExternalSyntheticLambda117(listenTogetherManager, (byte) 7);
                        gapComposer12.updateRememberedValue(objRememberedValue8);
                    }
                    CardKt.Button((Function0) objRememberedValue8, modifierFillMaxWidth, false, roundedCornerShapeM185RoundedCornerShape0680j_4, buttonColorsM247buttonColorsro_MJ88, null, null, null, null, AlbumScreenKt.lambda$1326441885, gapComposer12, 805306416, 484);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            case 14:
                List list4 = (List) obj6;
                Composer composer12 = (Composer) obj2;
                int iIntValue14 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer13 = (GapComposer) composer12;
                if (gapComposer13.shouldExecute(iIntValue14 & 1, (iIntValue14 & 17) != 16)) {
                    com.metrolist.music.ui.component.MenuKt.NavigationTitle(MathKt.pluralStringResource(R.plurals.n_playlist, list4.size(), new Object[]{Integer.valueOf(list4.size())}, gapComposer13), Modifier.Companion.$$INSTANCE, null, null, null, null, gapComposer13, 48, 60);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            case 15:
                SavedEQProfile savedEQProfile = (SavedEQProfile) obj6;
                Composer composer13 = (Composer) obj2;
                int iIntValue15 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer14 = (GapComposer) composer13;
                if (gapComposer14.shouldExecute(iIntValue15 & 1, (iIntValue15 & 17) != 16)) {
                    if (savedEQProfile == null || (list = savedEQProfile.bands) == null) {
                        list = EmptyList.INSTANCE;
                    }
                    EqScreenKt.EqFrequencyResponseGraph(list, savedEQProfile != null ? savedEQProfile.preamp : 0.0d, null, gapComposer14, 0);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                return unit;
            case 16:
                DeviceModel deviceModel = (DeviceModel) obj6;
                Composer composer14 = (Composer) obj2;
                int iIntValue16 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer15 = (GapComposer) composer14;
                if (gapComposer15.shouldExecute(iIntValue16 & 1, (iIntValue16 & 17) != 16)) {
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.CenterVertically, gapComposer15, 48);
                    int iHashCode3 = Long.hashCode(gapComposer15.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer15.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer15, modifierM135padding3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer15.startReusableNode();
                    if (gapComposer15.inserting) {
                        gapComposer15.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer15.useNode();
                    }
                    Stack.m390setimpl(gapComposer15, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer15, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer15, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer15);
                    Stack.m390setimpl(gapComposer15, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                    Painter painterPainterResource = IntMath.painterResource(R.drawable.graphic_eq, 0, gapComposer15);
                    Modifier modifierM151size3ABfNKs = SizeKt.m151size3ABfNKs(companion, 32.0f);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, modifierM151size3ABfNKs, ((MaterialTheme$Values) gapComposer15.consume(staticProvidableCompositionLocal)).colorScheme.primary, gapComposer15, 440, 0);
                    OffsetKt.Spacer(gapComposer15, SizeKt.m155width3ABfNKs(companion, 16.0f));
                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                    ColumnMeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer15, 0);
                    int iHashCode4 = Long.hashCode(gapComposer15.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer15.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer15, layoutWeightElement);
                    gapComposer15.startReusableNode();
                    if (gapComposer15.inserting) {
                        gapComposer15.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer15.useNode();
                    }
                    Stack.m390setimpl(gapComposer15, columnMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer15, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer15, updater$$ExternalSyntheticLambda1, gapComposer15);
                    Stack.m390setimpl(gapComposer15, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda0);
                    TextKt.m352TextNvy7gAk(deviceModel.name, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer15.consume(staticProvidableCompositionLocal)).typography.titleMedium, gapComposer15, 0, 0, 131070);
                    if (deviceModel.hasMultipleVariants) {
                        gapComposer15.startReplaceGroup(1220234703);
                        TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.wizard_multiple_variants, gapComposer15), null, ((MaterialTheme$Values) gapComposer15.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer15.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer15, 0, 0, 131066);
                        i3 = 0;
                        gapComposer15.end(false);
                    } else {
                        i3 = 0;
                        gapComposer15.startReplaceGroup(1220494731);
                        gapComposer15.end(false);
                    }
                    gapComposer15.end(true);
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.navigate_next, i3, gapComposer15), (String) null, (Modifier) null, 0L, gapComposer15, 56, 12);
                    gapComposer15.end(true);
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                return unit;
            case 17:
                ManagedActivityResultLauncher managedActivityResultLauncher = (ManagedActivityResultLauncher) obj6;
                Composer composer15 = (Composer) obj2;
                int iIntValue17 = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer16 = (GapComposer) composer15;
                if (gapComposer16.shouldExecute(iIntValue17 & 1, (iIntValue17 & 17) != 16)) {
                    boolean zChangedInstance4 = gapComposer16.changedInstance(managedActivityResultLauncher);
                    Object objRememberedValue9 = gapComposer16.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue9 == neverEqualPolicy) {
                        objRememberedValue9 = new BackupAndRestoreKt$$ExternalSyntheticLambda4(managedActivityResultLauncher, (byte) 1);
                        gapComposer16.updateRememberedValue(objRememberedValue9);
                    }
                    CardKt.m259FloatingActionButtonXz6DiA((Function0) objRememberedValue9, null, null, 0L, 0L, null, TopPlaylistScreenKt.f384lambda$1191573188, gapComposer16, 12582912, 126);
                } else {
                    gapComposer16.skipToGroupEnd();
                }
                return unit;
            case 18:
                RecognitionHistory recognitionHistory = (RecognitionHistory) obj6;
                Composer composer16 = (Composer) obj2;
                int iIntValue18 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer17 = (GapComposer) composer16;
                if (gapComposer17.shouldExecute(iIntValue18 & 1, (iIntValue18 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.delete_playlist_confirm, new Object[]{recognitionHistory.title}, gapComposer17), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer17.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium, gapComposer17, 0, 0, 131070);
                } else {
                    gapComposer17.skipToGroupEnd();
                }
                return unit;
            case 19:
                SearchSummary searchSummary = (SearchSummary) obj6;
                Composer composer17 = (Composer) obj2;
                int iIntValue19 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer18 = (GapComposer) composer17;
                if (gapComposer18.shouldExecute(iIntValue19 & 1, (iIntValue19 & 17) != 16)) {
                    Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                    Modifier modifierM138paddingqDBjuR0 = OffsetKt.m138paddingqDBjuR0(SizeKt.fillMaxWidth(companion2, 1.0f), 20.0f, 20.0f, 20.0f, 8.0f);
                    ColumnMeasurePolicy columnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer18, 0);
                    int iHashCode5 = Long.hashCode(gapComposer18.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer18.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer18, modifierM138paddingqDBjuR0);
                    ComposeUiNode.Companion.getClass();
                    gapComposer18.startReusableNode();
                    if (gapComposer18.inserting) {
                        gapComposer18.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer18.useNode();
                    }
                    Stack.m390setimpl(gapComposer18, columnMeasurePolicy4, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer18, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer18, Integer.valueOf(iHashCode5), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer18);
                    Stack.m390setimpl(gapComposer18, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda0);
                    String strM = searchSummary.title;
                    switch (strM.hashCode()) {
                        case -1732810888:
                            z5 = false;
                            if (!strM.equals("Videos")) {
                                gapComposer18.startReplaceGroup(1091376759);
                                gapComposer18.end(z5);
                            } else {
                                i4 = 1091363737;
                                i5 = R.string.filter_videos;
                                strM = Format$$ExternalSyntheticOutline0.m(gapComposer18, i4, i5, gapComposer18, z5);
                            }
                            break;
                        case -937619446:
                            z5 = false;
                            if (!strM.equals("Profiles")) {
                                gapComposer18.startReplaceGroup(1091376759);
                                gapComposer18.end(z5);
                            } else {
                                i4 = 1091374971;
                                i5 = R.string.filter_profiles;
                                strM = Format$$ExternalSyntheticOutline0.m(gapComposer18, i4, i5, gapComposer18, z5);
                            }
                            break;
                        case -568302088:
                            z5 = false;
                            if (!strM.equals("Episodes")) {
                                gapComposer18.startReplaceGroup(1091376759);
                                gapComposer18.end(z5);
                            } else {
                                i4 = 1091372955;
                                i5 = R.string.filter_episodes;
                                strM = Format$$ExternalSyntheticOutline0.m(gapComposer18, i4, i5, gapComposer18, z5);
                            }
                            break;
                        case 76517104:
                            z5 = false;
                            if (!strM.equals("Other")) {
                                gapComposer18.startReplaceGroup(1091376759);
                                gapComposer18.end(z5);
                            } else {
                                i4 = 1091360497;
                                i5 = R.string.other;
                                strM = Format$$ExternalSyntheticOutline0.m(gapComposer18, i4, i5, gapComposer18, z5);
                            }
                            break;
                        case 80068062:
                            z5 = false;
                            if (!strM.equals("Songs")) {
                                gapComposer18.startReplaceGroup(1091376759);
                                gapComposer18.end(z5);
                            } else {
                                i4 = 1091362097;
                                i5 = R.string.songs;
                                strM = Format$$ExternalSyntheticOutline0.m(gapComposer18, i4, i5, gapComposer18, z5);
                            }
                            break;
                        case 138139841:
                            z5 = false;
                            if (!strM.equals("Playlists")) {
                                gapComposer18.startReplaceGroup(1091376759);
                                gapComposer18.end(z5);
                            } else {
                                i4 = 1091369109;
                                i5 = R.string.playlists;
                                strM = Format$$ExternalSyntheticOutline0.m(gapComposer18, i4, i5, gapComposer18, z5);
                            }
                            break;
                        case 376914447:
                            z5 = false;
                            if (!strM.equals("Podcasts")) {
                                gapComposer18.startReplaceGroup(1091376759);
                                gapComposer18.end(z5);
                            } else {
                                i4 = 1091370939;
                                i5 = R.string.filter_podcasts;
                                strM = Format$$ExternalSyntheticOutline0.m(gapComposer18, i4, i5, gapComposer18, z5);
                            }
                            break;
                        case 932291052:
                            z5 = false;
                            if (!strM.equals("Artists")) {
                                gapComposer18.startReplaceGroup(1091376759);
                                gapComposer18.end(z5);
                            } else {
                                i4 = 1091367315;
                                i5 = R.string.artists;
                                strM = Format$$ExternalSyntheticOutline0.m(gapComposer18, i4, i5, gapComposer18, z5);
                            }
                            break;
                        case 1230901608:
                            z5 = false;
                            if (!strM.equals("Top result")) {
                                gapComposer18.startReplaceGroup(1091376759);
                                gapComposer18.end(z5);
                            } else {
                                i4 = 1091357750;
                                i5 = R.string.top_result;
                                strM = Format$$ExternalSyntheticOutline0.m(gapComposer18, i4, i5, gapComposer18, z5);
                            }
                            break;
                        case 1963670532:
                            if (strM.equals("Albums")) {
                                i4 = 1091365618;
                                i5 = R.string.albums;
                                z5 = false;
                                strM = Format$$ExternalSyntheticOutline0.m(gapComposer18, i4, i5, gapComposer18, z5);
                                break;
                            }
                        default:
                            z5 = false;
                            gapComposer18.startReplaceGroup(1091376759);
                            gapComposer18.end(z5);
                            break;
                    }
                    DialogKt.m1469MicroLabelFNF3uiM(strM, null, ((MaterialTheme$Values) gapComposer18.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary, gapComposer18, 0, 2);
                    DialogKt.m1467EditorialDivideriJQMabo(OffsetKt.m139paddingqDBjuR0$default(companion2, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13), 0L, gapComposer18, 6, 2);
                    gapComposer18.end(true);
                } else {
                    gapComposer18.skipToGroupEnd();
                }
                return unit;
            case 20:
                SliderColors sliderColors = (SliderColors) obj6;
                SliderState sliderState = (SliderState) obj;
                Composer composer18 = (Composer) obj2;
                int iIntValue20 = ((Integer) obj3).intValue();
                sliderState.getClass();
                if ((iIntValue20 & 6) == 0) {
                    iIntValue20 |= (iIntValue20 & 8) == 0 ? ((GapComposer) composer18).changed(sliderState) : ((GapComposer) composer18).changedInstance(sliderState) ? 4 : 2;
                }
                GapComposer gapComposer19 = (GapComposer) composer18;
                if (gapComposer19.shouldExecute(iIntValue20 & 1, (iIntValue20 & 19) != 18)) {
                    com.metrolist.music.ui.component.MenuKt.m1488PlayerSliderTrackjt2gSs(sliderState, null, sliderColors, CropImageView.DEFAULT_ASPECT_RATIO, gapComposer19, 8 | (iIntValue20 & 14), 10);
                } else {
                    gapComposer19.skipToGroupEnd();
                }
                return unit;
            case 21:
                UriHandler uriHandler = (UriHandler) obj6;
                Composer composer19 = (Composer) obj2;
                int iIntValue21 = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer20 = (GapComposer) composer19;
                if (gapComposer20.shouldExecute(iIntValue21 & 1, (iIntValue21 & 17) != 16)) {
                    String strStringResource2 = MathKt.stringResource(R.string.github_releases_url, gapComposer20);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    long j2 = ((MaterialTheme$Values) gapComposer20.consume(staticProvidableCompositionLocal2)).colorScheme.onPrimary;
                    long j3 = ((MaterialTheme$Values) gapComposer20.consume(staticProvidableCompositionLocal2)).colorScheme.primary;
                    ComposableLambdaImpl composableLambdaImpl = AiSettingsKt.lambda$908686495;
                    ComposableLambdaImpl composableLambdaImpl2 = AiSettingsKt.f464lambda$1284452256;
                    boolean zChangedInstance5 = gapComposer20.changedInstance(uriHandler) | gapComposer20.changed(strStringResource2);
                    Object objRememberedValue10 = gapComposer20.rememberedValue();
                    if (zChangedInstance5 || objRememberedValue10 == neverEqualPolicy) {
                        objRememberedValue10 = new QueueKt$$ExternalSyntheticLambda16(uriHandler, strStringResource2, (byte) 25);
                        gapComposer20.updateRememberedValue(objRememberedValue10);
                    }
                    CardKt.m258ExtendedFloatingActionButtonElI57k(composableLambdaImpl, composableLambdaImpl2, (Function0) objRememberedValue10, null, false, null, j2, j3, null, gapComposer20, 54);
                } else {
                    gapComposer20.skipToGroupEnd();
                }
                return unit;
            case 22:
                return invoke$com$metrolist$music$ui$screens$settings$ChangelogScreenKt$$ExternalSyntheticLambda1(obj, obj2, obj3);
            case 23:
                return new PlayerKt$$ExternalSyntheticLambda82(obj3, (BufferedChannel) obj6, (SelectImplementation) obj, (byte) 23);
            case 24:
                MutexImpl mutexImpl = (MutexImpl) obj6;
                MutexImpl.owner$volatile$FU.set(mutexImpl, null);
                mutexImpl.unlock(null);
                return unit;
            default:
                ((SemaphoreAndMutexImpl) obj6).release();
                return unit;
        }
    }

    public /* synthetic */ ListItemKt$$ExternalSyntheticLambda17(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }
}
