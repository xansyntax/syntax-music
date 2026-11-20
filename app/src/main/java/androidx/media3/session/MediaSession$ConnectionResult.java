package androidx.media3.session;

import android.util.SparseBooleanArray;
import androidx.media3.common.FileTypes;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Player;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSession$ConnectionResult {
    public static final Player.Commands DEFAULT_PLAYER_COMMANDS;
    public static final SessionCommands DEFAULT_SESSION_AND_LIBRARY_COMMANDS;
    public final Player.Commands availablePlayerCommands;
    public final SessionCommands availableSessionCommands;
    public final ImmutableList customLayout;
    public final ImmutableList mediaButtonPreferences;

    static {
        HashSet hashSet = new HashSet();
        RegularImmutableList regularImmutableList = SessionCommand.SESSION_COMMANDS;
        for (int i = 0; i < regularImmutableList.size; i++) {
            hashSet.add(new SessionCommand(((Integer) regularImmutableList.get(i)).intValue()));
        }
        new SessionCommands(hashSet);
        HashSet hashSet2 = new HashSet();
        RegularImmutableList regularImmutableList2 = SessionCommand.LIBRARY_COMMANDS;
        for (int i2 = 0; i2 < regularImmutableList2.size; i2++) {
            hashSet2.add(new SessionCommand(((Integer) regularImmutableList2.get(i2)).intValue()));
        }
        for (int i3 = 0; i3 < regularImmutableList.size; i3++) {
            hashSet2.add(new SessionCommand(((Integer) regularImmutableList.get(i3)).intValue()));
        }
        DEFAULT_SESSION_AND_LIBRARY_COMMANDS = new SessionCommands(hashSet2);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        for (int i4 : FileTypes.SUPPORTED_COMMANDS) {
            UtilsKt.checkState(!false);
            sparseBooleanArray.append(i4, true);
        }
        UtilsKt.checkState(!false);
        DEFAULT_PLAYER_COMMANDS = new Player.Commands(new FlagSet(sparseBooleanArray));
    }

    public MediaSession$ConnectionResult(SessionCommands sessionCommands, Player.Commands commands, ImmutableList immutableList, ImmutableList immutableList2) {
        this.availableSessionCommands = sessionCommands;
        this.availablePlayerCommands = commands;
        this.customLayout = immutableList;
        this.mediaButtonPreferences = immutableList2;
    }
}
