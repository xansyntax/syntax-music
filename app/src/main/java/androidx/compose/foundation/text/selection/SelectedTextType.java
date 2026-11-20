package androidx.compose.foundation.text.selection;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SelectedTextType {
    public static final /* synthetic */ SelectedTextType[] $VALUES;
    public static final SelectedTextType EditableText;

    static {
        SelectedTextType selectedTextType = new SelectedTextType("EditableText", 0);
        EditableText = selectedTextType;
        $VALUES = new SelectedTextType[]{selectedTextType, new SelectedTextType("StaticText", 1)};
    }

    public static SelectedTextType valueOf(String str) {
        return (SelectedTextType) Enum.valueOf(SelectedTextType.class, str);
    }

    public static SelectedTextType[] values() {
        return (SelectedTextType[]) $VALUES.clone();
    }
}
