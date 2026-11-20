package androidx.compose.material3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface TimePickerState {
    int getHour();

    int getHourInput();

    int getMinute();

    /* JADX INFO: renamed from: getSelection-yecRtBI */
    int mo241getSelectionyecRtBI();

    boolean is24hour();

    void setHour(int i);

    void setHourInput(int i);

    void setMinute(int i);

    void setMinuteInput(int i);

    /* JADX INFO: renamed from: setSelection-6_8s6DQ */
    void mo242setSelection6_8s6DQ(int i);
}
