package com.metrolist.music.ui.screens.settings;

import com.metrolist.music.playback.alarm.MusicAlarmEntry;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlarmSettingsKt$$ExternalSyntheticLambda21 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MusicAlarmEntry f$0;

    public /* synthetic */ AlarmSettingsKt$$ExternalSyntheticLambda21(MusicAlarmEntry musicAlarmEntry, byte b) {
        this.$r8$classId = b;
        this.f$0 = musicAlarmEntry;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        MusicAlarmEntry musicAlarmEntry = this.f$0;
        List list = (List) obj;
        switch (b) {
            case 0:
                list.getClass();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : list) {
                    if (!((MusicAlarmEntry) obj2).id.equals(musicAlarmEntry.id)) {
                        arrayList.add(obj2);
                    }
                }
                return CollectionsKt.plus(musicAlarmEntry, arrayList);
            default:
                list.getClass();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj3 : list) {
                    if (!((MusicAlarmEntry) obj3).id.equals(musicAlarmEntry.id)) {
                        arrayList2.add(obj3);
                    }
                }
                return arrayList2;
        }
    }
}
