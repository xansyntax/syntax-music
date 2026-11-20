package com.metrolist.music.ui.screens.settings;

import android.content.Context;
import android.text.format.Formatter;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.Stack;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import com.metrolist.music.listentogether.ListenTogetherServer;
import com.metrolist.music.playback.alarm.MusicAlarmEntry;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda21;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.viewmodels.BackupRestoreViewModel;
import com.yalantis.ucrop.R;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlarmSettingsKt$$ExternalSyntheticLambda5 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ AlarmSettingsKt$$ExternalSyntheticLambda5(NavHostController navHostController, Object obj, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = navHostController;
        this.f$1 = obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
        String str;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$1;
        Object obj4 = this.f$0;
        switch (b) {
            case 0:
                Locale locale = (Locale) obj4;
                MusicAlarmEntry musicAlarmEntry = (MusicAlarmEntry) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(1 & iIntValue, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    String str2 = String.format(locale, "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(musicAlarmEntry.hour), Integer.valueOf(musicAlarmEntry.minute)}, 2));
                    if (musicAlarmEntry.enabled) {
                        gapComposer.startReplaceGroup(843848054);
                        gapComposer.end(false);
                        str = "";
                    } else {
                        gapComposer.startReplaceGroup(843944681);
                        String str3 = " (" + MathKt.stringResource(R.string.alarm_disabled, gapComposer) + ")";
                        gapComposer.end(false);
                        str = str3;
                    }
                    TextKt.m352TextNvy7gAk(str2.concat(str), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                }
                break;
            case 1:
                QueueKt$$ExternalSyntheticLambda21 queueKt$$ExternalSyntheticLambda21 = (QueueKt$$ExternalSyntheticLambda21) obj4;
                String str4 = (String) obj3;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(1 & iIntValue2, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk((String) queueKt$$ExternalSyntheticLambda21.invoke(str4, gapComposer2, 0), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262142);
                }
                break;
            case 2:
                ((Integer) obj2).getClass();
                AiSettingsKt.AppearanceSettings((NavHostController) obj4, (SnackbarHostState) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 3:
                ((Integer) obj2).getClass();
                AiSettingsKt.BackupAndRestore((NavHostController) obj4, (BackupRestoreViewModel) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 4:
                ((Integer) obj2).getClass();
                AiSettingsKt.SettingsScreen((NavHostController) obj4, (String) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 5:
                Context context = (Context) obj4;
                ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = (ParcelableSnapshotMutableLongState) obj3;
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    String shortFileSize = Formatter.formatShortFileSize(context, parcelableSnapshotMutableLongState.getLongValue());
                    shortFileSize.getClass();
                    TextKt.m352TextNvy7gAk(shortFileSize, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262142);
                }
                break;
            default:
                ListenTogetherServer listenTogetherServer = (ListenTogetherServer) obj4;
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1 = (DataStoreKt$rememberPreference$1$1) obj3;
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(listenTogetherServer != null ? Fragment$5$$ExternalSyntheticOutline0.m(listenTogetherServer.name, " - ", listenTogetherServer.location) : (String) dataStoreKt$rememberPreference$1$1.$state.getValue(), null, 0L, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, null, gapComposer4, 0, 24960, 241662);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ AlarmSettingsKt$$ExternalSyntheticLambda5(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }
}
