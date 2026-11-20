package com.metrolist.music.ui.screens.recognition;

import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.animation.AnimatedContentScopeImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda62;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.ui.screens.equalizer.wizard.DeviceModel;
import com.metrolist.music.ui.screens.equalizer.wizard.WizardScreenKt;
import com.metrolist.music.ui.screens.equalizer.wizard.WizardState;
import com.metrolist.music.ui.screens.equalizer.wizard.WizardStep;
import com.metrolist.music.ui.screens.search.SearchScreenKt$$ExternalSyntheticLambda0;
import com.metrolist.shazamkit.models.RecognitionResult;
import com.metrolist.shazamkit.models.RecognitionStatus;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RecognitionScreenKt$$ExternalSyntheticLambda6 implements Function4 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;

    public /* synthetic */ RecognitionScreenKt$$ExternalSyntheticLambda6(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
        this.f$4 = obj5;
        this.f$5 = obj6;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a8  */
    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) throws XmlPullParserException, IOException {
        final CoroutineScope coroutineScope;
        boolean z;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj5 = this.f$5;
        Object obj6 = this.f$4;
        Object obj7 = this.f$3;
        Object obj8 = this.f$2;
        Object obj9 = this.f$1;
        Object obj10 = this.f$0;
        switch (b) {
            case 0:
                final CoroutineScope coroutineScope2 = (CoroutineScope) obj10;
                final Context context = (Context) obj9;
                final ManagedActivityResultLauncher managedActivityResultLauncher = (ManagedActivityResultLauncher) obj8;
                NavHostController navHostController = (NavHostController) obj7;
                MusicDatabase musicDatabase = (MusicDatabase) obj6;
                final MutableState mutableState = (MutableState) obj5;
                RecognitionStatus recognitionStatus = (RecognitionStatus) obj2;
                Composer composer = (Composer) obj3;
                int iIntValue = ((Integer) obj4).intValue();
                ((AnimatedContentScopeImpl) obj).getClass();
                recognitionStatus.getClass();
                if ((iIntValue & 48) == 0) {
                    iIntValue |= (iIntValue & 64) == 0 ? ((GapComposer) composer).changed(recognitionStatus) : ((GapComposer) composer).changedInstance(recognitionStatus) ? 32 : 16;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 145) != 144)) {
                    boolean z2 = recognitionStatus instanceof RecognitionStatus.Ready;
                    NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                    if (z2) {
                        gapComposer.startReplaceGroup(-962591546);
                        boolean zChangedInstance = gapComposer.changedInstance(coroutineScope2) | gapComposer.changedInstance(context) | gapComposer.changedInstance(managedActivityResultLauncher);
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new RecognitionScreenKt$RecognitionScreen$5$1$2$1$1(coroutineScope2, managedActivityResultLauncher, mutableState, context);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        RecognitionScreenKt.ReadyState((Function0) ((KFunction) objRememberedValue), gapComposer, 0);
                        gapComposer.end(false);
                    } else if (recognitionStatus instanceof RecognitionStatus.Listening) {
                        gapComposer.startReplaceGroup(-962431741);
                        Object objRememberedValue2 = gapComposer.rememberedValue();
                        if (objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new SearchScreenKt$$ExternalSyntheticLambda0((byte) 21);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        RecognitionScreenKt.ListeningState((Function0) objRememberedValue2, gapComposer, 6);
                        gapComposer.end(false);
                    } else if (recognitionStatus instanceof RecognitionStatus.Processing) {
                        gapComposer.startReplaceGroup(-962090648);
                        RecognitionScreenKt.ProcessingState(0, gapComposer);
                        gapComposer.end(false);
                    } else if (recognitionStatus instanceof RecognitionStatus.Success) {
                        gapComposer.startReplaceGroup(-961952357);
                        RecognitionResult result = ((RecognitionStatus.Success) recognitionStatus).getResult();
                        boolean zChangedInstance2 = gapComposer.changedInstance(navHostController);
                        Object objRememberedValue3 = gapComposer.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                            objRememberedValue3 = new MainActivity$$ExternalSyntheticLambda62(navHostController, (byte) 2);
                            gapComposer.updateRememberedValue(objRememberedValue3);
                        }
                        Function1 function1 = (Function1) objRememberedValue3;
                        boolean zChangedInstance3 = gapComposer.changedInstance(coroutineScope2) | gapComposer.changedInstance(context) | gapComposer.changedInstance(managedActivityResultLauncher);
                        Object objRememberedValue4 = gapComposer.rememberedValue();
                        if (zChangedInstance3 || objRememberedValue4 == neverEqualPolicy) {
                            final byte b2 = 0;
                            coroutineScope = coroutineScope2;
                            Function0 function0 = new Function0() { // from class: com.metrolist.music.ui.screens.recognition.RecognitionScreenKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b3 = b2;
                                    Unit unit2 = Unit.INSTANCE;
                                    Context context2 = context;
                                    MutableState mutableState2 = mutableState;
                                    ManagedActivityResultLauncher managedActivityResultLauncher2 = managedActivityResultLauncher;
                                    CoroutineScope coroutineScope3 = coroutineScope;
                                    switch (b3) {
                                        case 0:
                                            RecognitionScreenKt.RecognitionScreen$startRecognition(coroutineScope3, managedActivityResultLauncher2, mutableState2, context2);
                                            break;
                                        case 1:
                                            RecognitionScreenKt.RecognitionScreen$startRecognition(coroutineScope3, managedActivityResultLauncher2, mutableState2, context2);
                                            break;
                                        default:
                                            RecognitionScreenKt.RecognitionScreen$startRecognition(coroutineScope3, managedActivityResultLauncher2, mutableState2, context2);
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer.updateRememberedValue(function0);
                            objRememberedValue4 = function0;
                        } else {
                            coroutineScope = coroutineScope2;
                        }
                        Function0 function2 = (Function0) objRememberedValue4;
                        Object objRememberedValue5 = gapComposer.rememberedValue();
                        if (objRememberedValue5 == neverEqualPolicy) {
                            objRememberedValue5 = RecognitionScreenKt$RecognitionScreen$5$1$2$5$1.INSTANCE;
                            gapComposer.updateRememberedValue(objRememberedValue5);
                        }
                        Function0 function3 = (Function0) ((KFunction) objRememberedValue5);
                        boolean zChangedInstance4 = gapComposer.changedInstance(coroutineScope) | gapComposer.changedInstance(musicDatabase);
                        Object objRememberedValue6 = gapComposer.rememberedValue();
                        if (zChangedInstance4 || objRememberedValue6 == neverEqualPolicy) {
                            objRememberedValue6 = new RecognitionScreenKt$RecognitionScreen$5$1$2$6$1(coroutineScope, musicDatabase);
                            gapComposer.updateRememberedValue(objRememberedValue6);
                        }
                        RecognitionScreenKt.SuccessState(result, function1, function2, function3, (Function1) ((KFunction) objRememberedValue6), gapComposer, RecognitionResult.$stable | 3072);
                        gapComposer.end(false);
                    } else if (recognitionStatus instanceof RecognitionStatus.NoMatch) {
                        gapComposer.startReplaceGroup(-961200545);
                        String message = ((RecognitionStatus.NoMatch) recognitionStatus).getMessage();
                        boolean zChangedInstance5 = gapComposer.changedInstance(coroutineScope2) | gapComposer.changedInstance(context) | gapComposer.changedInstance(managedActivityResultLauncher);
                        Object objRememberedValue7 = gapComposer.rememberedValue();
                        if (zChangedInstance5 || objRememberedValue7 == neverEqualPolicy) {
                            final byte b3 = 1;
                            Function0 function4 = new Function0() { // from class: com.metrolist.music.ui.screens.recognition.RecognitionScreenKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b4 = b3;
                                    Unit unit2 = Unit.INSTANCE;
                                    Context context2 = context;
                                    MutableState mutableState2 = mutableState;
                                    ManagedActivityResultLauncher managedActivityResultLauncher2 = managedActivityResultLauncher;
                                    CoroutineScope coroutineScope3 = coroutineScope2;
                                    switch (b4) {
                                        case 0:
                                            RecognitionScreenKt.RecognitionScreen$startRecognition(coroutineScope3, managedActivityResultLauncher2, mutableState2, context2);
                                            break;
                                        case 1:
                                            RecognitionScreenKt.RecognitionScreen$startRecognition(coroutineScope3, managedActivityResultLauncher2, mutableState2, context2);
                                            break;
                                        default:
                                            RecognitionScreenKt.RecognitionScreen$startRecognition(coroutineScope3, managedActivityResultLauncher2, mutableState2, context2);
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer.updateRememberedValue(function4);
                            objRememberedValue7 = function4;
                        }
                        RecognitionScreenKt.NoMatchState(message, (Function0) objRememberedValue7, gapComposer, 0);
                        gapComposer.end(false);
                    } else {
                        if (!(recognitionStatus instanceof RecognitionStatus.Error)) {
                            throw Format$$ExternalSyntheticOutline0.m(gapComposer, 246043176, false);
                        }
                        gapComposer.startReplaceGroup(-960885151);
                        String message2 = ((RecognitionStatus.Error) recognitionStatus).getMessage();
                        boolean zChangedInstance6 = gapComposer.changedInstance(coroutineScope2) | gapComposer.changedInstance(context) | gapComposer.changedInstance(managedActivityResultLauncher);
                        Object objRememberedValue8 = gapComposer.rememberedValue();
                        if (zChangedInstance6 || objRememberedValue8 == neverEqualPolicy) {
                            final byte b4 = 2;
                            Function0 function5 = new Function0() { // from class: com.metrolist.music.ui.screens.recognition.RecognitionScreenKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b5 = b4;
                                    Unit unit2 = Unit.INSTANCE;
                                    Context context2 = context;
                                    MutableState mutableState2 = mutableState;
                                    ManagedActivityResultLauncher managedActivityResultLauncher2 = managedActivityResultLauncher;
                                    CoroutineScope coroutineScope3 = coroutineScope2;
                                    switch (b5) {
                                        case 0:
                                            RecognitionScreenKt.RecognitionScreen$startRecognition(coroutineScope3, managedActivityResultLauncher2, mutableState2, context2);
                                            break;
                                        case 1:
                                            RecognitionScreenKt.RecognitionScreen$startRecognition(coroutineScope3, managedActivityResultLauncher2, mutableState2, context2);
                                            break;
                                        default:
                                            RecognitionScreenKt.RecognitionScreen$startRecognition(coroutineScope3, managedActivityResultLauncher2, mutableState2, context2);
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer.updateRememberedValue(function5);
                            objRememberedValue8 = function5;
                        }
                        RecognitionScreenKt.ErrorState(message2, (Function0) objRememberedValue8, gapComposer, 0);
                        gapComposer.end(false);
                    }
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            default:
                WizardState wizardState = (WizardState) obj10;
                Function0 function6 = (Function0) obj9;
                Function1 function7 = (Function1) obj8;
                Function1 function8 = (Function1) obj7;
                Function1 function9 = (Function1) obj6;
                Function0 function10 = (Function0) obj5;
                WizardStep wizardStep = (WizardStep) obj2;
                Composer composer2 = (Composer) obj3;
                int iIntValue2 = ((Integer) obj4).intValue();
                ((AnimatedContentScopeImpl) obj).getClass();
                wizardStep.getClass();
                if ((iIntValue2 & 48) == 0) {
                    iIntValue2 |= ((GapComposer) composer2).changed(wizardStep.ordinal()) ? 32 : 16;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 145) != 144)) {
                    gapComposer2.skipToGroupEnd();
                    return unit;
                }
                int iOrdinal = wizardStep.ordinal();
                if (iOrdinal == 0) {
                    gapComposer2.startReplaceGroup(270357923);
                    WizardScreenKt.ModelSelectionStep(wizardState.modelSearchQuery, wizardState.models, wizardState.isLoading, wizardState.isDatabaseReady, function6, function7, function8, gapComposer2, 0);
                    gapComposer2.end(false);
                    return unit;
                }
                if (iOrdinal != 1) {
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer2, 270356388, false);
                }
                gapComposer2.startReplaceGroup(270375648);
                DeviceModel deviceModel = wizardState.selectedModel;
                String str = deviceModel != null ? deviceModel.name : "";
                List list = wizardState.variants;
                Set set = wizardState.selectedVariantIds;
                boolean z3 = wizardState.isLoading;
                int iOrdinal2 = wizardState.currentStep.ordinal();
                if (iOrdinal2 != 0) {
                    if (iOrdinal2 != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    if (wizardState.selectedVariantIds.isEmpty()) {
                        z = false;
                    } else {
                        z = true;
                    }
                } else if (wizardState.selectedModel != null) {
                    z = true;
                } else {
                    z = false;
                }
                WizardScreenKt.VariantSelectionStep(str, list, set, z3, function9, function10, z, gapComposer2, 0);
                gapComposer2.end(false);
                return unit;
        }
    }
}
