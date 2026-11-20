package androidx.media3.session;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.primitives.ImmutableIntArray;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CommandButton {
    public static final String FIELD_DISPLAY_NAME;
    public static final String FIELD_ENABLED;
    public static final String FIELD_EXTRAS;
    public static final String FIELD_ICON;
    public static final String FIELD_ICON_RES_ID;
    public static final String FIELD_ICON_URI;
    public static final String FIELD_PARAMETER;
    public static final String FIELD_PLAYER_COMMAND;
    public static final String FIELD_SESSION_COMMAND;
    public static final String FIELD_SLOTS;
    public final CharSequence displayName;
    public final Bundle extras;
    public final int icon;
    public final int iconResId;
    public final Uri iconUri;
    public final boolean isEnabled;
    public final Object parameter;
    public final int playerCommand;
    public final SessionCommand sessionCommand;
    public final ImmutableIntArray slots;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_SESSION_COMMAND = Integer.toString(0, 36);
        FIELD_PLAYER_COMMAND = Integer.toString(1, 36);
        FIELD_ICON_RES_ID = Integer.toString(2, 36);
        FIELD_DISPLAY_NAME = Integer.toString(3, 36);
        FIELD_EXTRAS = Integer.toString(4, 36);
        FIELD_ENABLED = Integer.toString(5, 36);
        FIELD_ICON_URI = Integer.toString(6, 36);
        FIELD_ICON = Integer.toString(7, 36);
        FIELD_SLOTS = Integer.toString(8, 36);
        FIELD_PARAMETER = Integer.toString(9, 36);
    }

    public CommandButton(SessionCommand sessionCommand, int i, int i2, int i3, Uri uri, CharSequence charSequence, Bundle bundle, boolean z, ImmutableIntArray immutableIntArray, Object obj) {
        this.sessionCommand = sessionCommand;
        this.playerCommand = i;
        this.icon = i2;
        this.iconResId = i3;
        this.iconUri = uri;
        this.displayName = charSequence;
        this.extras = new Bundle(bundle);
        this.isEnabled = z;
        this.slots = immutableIntArray;
        this.parameter = obj;
    }

    public static boolean containsButtonForSlot(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (((CommandButton) list.get(i2)).slots.get(0) == i) {
                return true;
            }
        }
        return false;
    }

    public static CommandButton convertFromPredefinedCustomCommand(SessionCommand sessionCommand) {
        String str = sessionCommand.customAction;
        Bundle bundle = sessionCommand.customExtras;
        if (!str.startsWith("androidx.media3.session.PLAYER_COMMAND_")) {
            int i = Integer.parseInt(str.substring(40));
            Object parameterFromBundle = getParameterFromBundle(i == 40010 ? 5 : 0, 9, bundle, "androidx.media3.session.CUSTOM_COMMAND_PARAMETER");
            Builder builder = new Builder(0);
            builder.setSessionCommand(new SessionCommand(i), parameterFromBundle);
            return builder.build();
        }
        int i2 = Integer.parseInt(str.substring(39));
        Object parameterFromBundle2 = getParameterFromBundle(getParameterTypeForPlayerCommand(i2), 9, bundle, "androidx.media3.session.CUSTOM_COMMAND_PARAMETER");
        Builder builder2 = new Builder(0);
        UtilsKt.checkArgument("sessionCommand is already set. Only one of sessionCommand and playerCommand should be set.", builder2.sessionCommand == null);
        builder2.playerCommand = i2;
        builder2.parameter = verifyParameterType(getParameterTypeForPlayerCommand(i2), parameterFromBundle2);
        return builder2.build();
    }

    public static RegularImmutableList copyWithUnavailableButtonsDisabled(List list, SessionCommands sessionCommands, Player.Commands commands) {
        int i;
        ImmutableList.Builder builder = new ImmutableList.Builder(4);
        for (int i2 = 0; i2 < list.size(); i2++) {
            CommandButton commandButton = (CommandButton) list.get(i2);
            SessionCommand sessionCommand = commandButton.sessionCommand;
            if ((sessionCommand == null || !sessionCommands.commands.contains(sessionCommand)) && ((i = commandButton.playerCommand) == -1 || !commands.contains(i))) {
                if (commandButton.isEnabled) {
                    commandButton = new CommandButton(commandButton.sessionCommand, commandButton.playerCommand, commandButton.icon, commandButton.iconResId, commandButton.iconUri, commandButton.displayName, new Bundle(commandButton.extras), false, commandButton.slots, commandButton.parameter);
                }
                builder.add((Object) commandButton);
            } else {
                builder.add((Object) commandButton);
            }
        }
        return builder.build();
    }

    public static CommandButton fromBundle(int i, Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(FIELD_SESSION_COMMAND);
        SessionCommand sessionCommandFromBundle = bundle2 == null ? null : SessionCommand.fromBundle(bundle2);
        int i2 = bundle.getInt(FIELD_PLAYER_COMMAND, -1);
        int i3 = bundle.getInt(FIELD_ICON_RES_ID, 0);
        CharSequence charSequence = bundle.getCharSequence(FIELD_DISPLAY_NAME, "");
        Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(bundle.getBundle(FIELD_EXTRAS));
        boolean z = i < 3 || bundle.getBoolean(FIELD_ENABLED, true);
        Uri uri = (Uri) bundle.getParcelable(FIELD_ICON_URI);
        int i4 = bundle.getInt(FIELD_ICON, 0);
        int[] intArray = bundle.getIntArray(FIELD_SLOTS);
        Builder builder = new Builder(i4, i3);
        String str = FIELD_PARAMETER;
        if (sessionCommandFromBundle != null) {
            builder.setSessionCommand(sessionCommandFromBundle, getParameterFromBundle(sessionCommandFromBundle.commandCode == 40010 ? 5 : 0, i, bundle, str));
        }
        if (i2 != -1) {
            Object parameterFromBundle = getParameterFromBundle(getParameterTypeForPlayerCommand(i2), i, bundle, str);
            UtilsKt.checkArgument("sessionCommand is already set. Only one of sessionCommand and playerCommand should be set.", builder.sessionCommand == null);
            builder.playerCommand = i2;
            builder.parameter = verifyParameterType(getParameterTypeForPlayerCommand(i2), parameterFromBundle);
        }
        if (uri != null && (Objects.equals(uri.getScheme(), "content") || Objects.equals(uri.getScheme(), "android.resource"))) {
            builder.setIconUri(uri);
        }
        builder.displayName = charSequence;
        if (bundleConvertToNullIfInvalid == null) {
            bundleConvertToNullIfInvalid = Bundle.EMPTY;
        }
        builder.extras = new Bundle(bundleConvertToNullIfInvalid);
        builder.enabled = z;
        if (intArray == null) {
            intArray = new int[]{6};
        }
        UtilsKt.checkArgument(intArray.length != 0);
        ImmutableIntArray immutableIntArray = ImmutableIntArray.EMPTY;
        builder.slots = intArray.length == 0 ? ImmutableIntArray.EMPTY : new ImmutableIntArray(Arrays.copyOf(intArray, intArray.length));
        return builder.build();
    }

    public static RegularImmutableList getCustomLayoutFromMediaButtonPreferences(List list, boolean z, boolean z2, int i) {
        int i2;
        if (list.isEmpty()) {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            return RegularImmutableList.EMPTY;
        }
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < list.size(); i5++) {
            CommandButton commandButton = (CommandButton) list.get(i5);
            boolean z3 = commandButton.isEnabled;
            ImmutableIntArray immutableIntArray = commandButton.slots;
            if (z3 && commandButton.canExecuteAction()) {
                for (int i6 = 0; i6 < immutableIntArray.end && (i2 = immutableIntArray.get(i6)) != 6; i6++) {
                    if (z && i3 == -1 && i2 == 2) {
                        i3 = i5;
                        break;
                    }
                    if (z2 && i4 == -1 && i2 == 3) {
                        i4 = i5;
                        break;
                    }
                }
            }
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        if (i3 != -1) {
            builder.add((Object) ((CommandButton) list.get(i3)).convertToPredefinedCustomCommandButton(2, i));
        }
        if (i4 != -1) {
            builder.add((Object) ((CommandButton) list.get(i4)).convertToPredefinedCustomCommandButton(3, i));
        }
        for (int i7 = 0; i7 < list.size(); i7++) {
            CommandButton commandButton2 = (CommandButton) list.get(i7);
            if (commandButton2.isEnabled && commandButton2.canExecuteAction() && i7 != i3 && i7 != i4 && commandButton2.slots.contains(6)) {
                builder.add((Object) commandButton2.convertToPredefinedCustomCommandButton(6, i));
            }
        }
        return builder.build();
    }

    public static RegularImmutableList getMediaButtonPreferencesFromCustomLayout(List list, Player.Commands commands, Bundle bundle) {
        if (list.isEmpty()) {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            return RegularImmutableList.EMPTY;
        }
        boolean zContainsAny = commands.flags.containsAny(7, 6);
        boolean zContainsAny2 = commands.flags.containsAny(9, 8);
        boolean z = bundle.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", false);
        boolean z2 = bundle.getBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", false);
        int i = (zContainsAny || z) ? -1 : 0;
        int i2 = (zContainsAny2 || z2) ? -1 : i == 0 ? 1 : 0;
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i3 = 0; i3 < list.size(); i3++) {
            CommandButton commandButton = (CommandButton) list.get(i3);
            if (i3 == i) {
                if (i2 == -1) {
                    builder.add((Object) commandButton.copyWithSlots(new ImmutableIntArray(new int[]{2, 6})));
                } else {
                    builder.add((Object) commandButton.copyWithSlots(new ImmutableIntArray(new int[]{2, 3, 6})));
                }
            } else if (i3 == i2) {
                builder.add((Object) commandButton.copyWithSlots(new ImmutableIntArray(new int[]{3, 6})));
            } else {
                builder.add((Object) commandButton.copyWithSlots(new ImmutableIntArray(new int[]{6})));
            }
        }
        return builder.build();
    }

    public static Object getParameterFromBundle(int i, int i2, Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            return null;
        }
        switch (i) {
            case 1:
                return Long.valueOf(bundle.getLong(str));
            case 2:
                return Integer.valueOf(bundle.getInt(str));
            case 3:
                return Boolean.valueOf(bundle.getBoolean(str));
            case 4:
                return Float.valueOf(bundle.getFloat(str));
            case 5:
                Bundle bundle2 = bundle.getBundle(str);
                bundle2.getClass();
                return Rating.fromBundle(bundle2);
            case 6:
                Bundle bundle3 = bundle.getBundle(str);
                bundle3.getClass();
                return MediaItem.fromBundle(i2, bundle3);
            case 7:
                Bundle bundle4 = bundle.getBundle(str);
                bundle4.getClass();
                return MediaMetadata.fromBundle(i2, bundle4);
            case 8:
                Bundle bundle5 = bundle.getBundle(str);
                bundle5.getClass();
                return TrackSelectionParameters.fromBundle(bundle5);
            default:
                return null;
        }
    }

    public static int getParameterTypeForPlayerCommand(int i) {
        if (i == 1) {
            return 3;
        }
        if (i == 5) {
            return 1;
        }
        if (i == 10) {
            return 2;
        }
        if (i == 19) {
            return 7;
        }
        if (i == 24) {
            return 4;
        }
        if (i == 29) {
            return 8;
        }
        if (i == 31) {
            return 6;
        }
        switch (i) {
            case 13:
                return 4;
            case 14:
                return 3;
            case 15:
                return 2;
            default:
                return 0;
        }
    }

    public static boolean isPredefinedCustomCommandButtonCode(String str) {
        return str.startsWith("androidx.media3.session.PLAYER_COMMAND_") || str.startsWith("androidx.media3.session.SESSION_COMMAND_");
    }

    public static Object verifyParameterType(int i, Object obj) {
        if (obj == null) {
            return null;
        }
        switch (i) {
            case 1:
                if (obj instanceof Integer) {
                    obj = Long.valueOf(((Integer) obj).longValue());
                }
                UtilsKt.checkArgument("Parameter has incorrect type.", obj instanceof Long);
                return obj;
            case 2:
                UtilsKt.checkArgument("Parameter has incorrect type.", obj instanceof Integer);
                return obj;
            case 3:
                UtilsKt.checkArgument("Parameter has incorrect type.", obj instanceof Boolean);
                return obj;
            case 4:
                if (obj instanceof Double) {
                    obj = Float.valueOf(((Double) obj).floatValue());
                }
                UtilsKt.checkArgument("Parameter has incorrect type.", obj instanceof Float);
                return obj;
            case 5:
                UtilsKt.checkArgument("Parameter has incorrect type.", obj instanceof Rating);
                return obj;
            case 6:
                UtilsKt.checkArgument("Parameter has incorrect type.", obj instanceof MediaItem);
                return obj;
            case 7:
                UtilsKt.checkArgument("Parameter has incorrect type.", obj instanceof MediaMetadata);
                return obj;
            case 8:
                UtilsKt.checkArgument("Parameter has incorrect type.", obj instanceof TrackSelectionParameters);
                return obj;
            default:
                return null;
        }
    }

    public final boolean canExecuteAction() {
        Object obj = this.parameter;
        SessionCommand sessionCommand = this.sessionCommand;
        if (sessionCommand != null) {
            int i = sessionCommand.commandCode;
            if (i != 0) {
                return i == 40010 && obj != null;
            }
            return true;
        }
        int i2 = this.playerCommand;
        if (i2 != 19) {
            if (i2 != 24) {
                if (i2 != 29 && i2 != 31) {
                    switch (i2) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 11:
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                        case 14:
                            break;
                        case 5:
                        case 10:
                        case 13:
                        case 15:
                            break;
                        default:
                            return false;
                    }
                }
            }
            return true;
        }
        return obj != null;
    }

    public final CommandButton convertToPredefinedCustomCommandButton(int i, int i2) {
        String str;
        SessionCommand sessionCommand = this.sessionCommand;
        if (sessionCommand != null && sessionCommand.commandCode == 0) {
            return copyWithSlots(new ImmutableIntArray(new int[]{i}));
        }
        Bundle bundle = Bundle.EMPTY;
        if (this.parameter != null) {
            bundle = new Bundle();
            writeParameterToBundle("androidx.media3.session.CUSTOM_COMMAND_PARAMETER", i2, bundle);
        }
        if (sessionCommand != null) {
            str = "androidx.media3.session.SESSION_COMMAND_" + sessionCommand.commandCode;
        } else {
            str = "androidx.media3.session.PLAYER_COMMAND_" + this.playerCommand;
        }
        return new CommandButton(new SessionCommand(str, bundle), -1, this.icon, this.iconResId, this.iconUri, this.displayName, this.extras, this.isEnabled, new ImmutableIntArray(new int[]{i}), null);
    }

    public final CommandButton copyWithSlots(ImmutableIntArray immutableIntArray) {
        if (this.slots.equals(immutableIntArray)) {
            return this;
        }
        return new CommandButton(this.sessionCommand, this.playerCommand, this.icon, this.iconResId, this.iconUri, this.displayName, new Bundle(this.extras), this.isEnabled, immutableIntArray, this.parameter);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommandButton)) {
            return false;
        }
        CommandButton commandButton = (CommandButton) obj;
        return Objects.equals(this.sessionCommand, commandButton.sessionCommand) && this.playerCommand == commandButton.playerCommand && this.icon == commandButton.icon && this.iconResId == commandButton.iconResId && Objects.equals(this.iconUri, commandButton.iconUri) && TextUtils.equals(this.displayName, commandButton.displayName) && this.isEnabled == commandButton.isEnabled && this.slots.equals(commandButton.slots) && Objects.equals(this.parameter, commandButton.parameter);
    }

    public final void executePlayerAction(Player player) {
        if (this.isEnabled) {
            Object obj = this.parameter;
            int i = this.playerCommand;
            if (i == 19) {
                if (obj != null) {
                    player.setPlaylistMetadata((MediaMetadata) obj);
                    return;
                }
                return;
            }
            if (i == 24) {
                if (obj != null) {
                    player.setVolume(((Float) obj).floatValue());
                    return;
                } else if (player.getVolume() == CropImageView.DEFAULT_ASPECT_RATIO) {
                    player.unmute();
                    return;
                } else {
                    player.mute();
                    return;
                }
            }
            if (i == 29) {
                if (obj != null) {
                    player.setTrackSelectionParameters((TrackSelectionParameters) obj);
                    return;
                }
                return;
            }
            if (i == 31) {
                if (obj != null) {
                    player.setMediaItem((MediaItem) obj);
                    return;
                }
                return;
            }
            switch (i) {
                case 1:
                    if (obj == null) {
                        player.setPlayWhenReady(!player.getPlayWhenReady());
                    } else {
                        player.setPlayWhenReady(((Boolean) obj).booleanValue());
                    }
                    break;
                case 2:
                    player.prepare();
                    break;
                case 3:
                    player.stop();
                    break;
                case 4:
                    player.seekToDefaultPosition();
                    break;
                case 5:
                    if (obj != null) {
                        player.seekTo(((Long) obj).longValue());
                    }
                    break;
                case 6:
                    player.seekToPreviousMediaItem();
                    break;
                case 7:
                    player.seekToPrevious();
                    break;
                case 8:
                    player.seekToNextMediaItem();
                    break;
                case 9:
                    player.seekToNext();
                    break;
                case 10:
                    if (obj != null) {
                        player.seekToDefaultPosition(((Integer) obj).intValue());
                    }
                    break;
                case 11:
                    player.seekBack();
                    break;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    player.seekForward();
                    break;
                case 13:
                    if (obj != null) {
                        player.setPlaybackSpeed(((Float) obj).floatValue());
                    }
                    break;
                case 14:
                    if (obj == null) {
                        player.setShuffleModeEnabled(!player.getShuffleModeEnabled());
                    } else {
                        player.setShuffleModeEnabled(((Boolean) obj).booleanValue());
                    }
                    break;
                case 15:
                    if (obj != null) {
                        player.setRepeatMode(((Integer) obj).intValue());
                    }
                    break;
            }
        }
    }

    public final int hashCode() {
        return Objects.hash(this.sessionCommand, Integer.valueOf(this.playerCommand), Integer.valueOf(this.icon), Integer.valueOf(this.iconResId), this.displayName, Boolean.valueOf(this.isEnabled), this.iconUri, this.slots, this.parameter);
    }

    public final Bundle toBundle(int i) {
        Bundle bundle = new Bundle();
        SessionCommand sessionCommand = this.sessionCommand;
        if (sessionCommand != null) {
            bundle.putBundle(FIELD_SESSION_COMMAND, sessionCommand.toBundle());
        }
        int i2 = this.playerCommand;
        if (i2 != -1) {
            bundle.putInt(FIELD_PLAYER_COMMAND, i2);
        }
        int i3 = this.icon;
        if (i3 != 0) {
            bundle.putInt(FIELD_ICON, i3);
        }
        int i4 = this.iconResId;
        if (i4 != 0) {
            bundle.putInt(FIELD_ICON_RES_ID, i4);
        }
        CharSequence charSequence = this.displayName;
        if (charSequence != "") {
            bundle.putCharSequence(FIELD_DISPLAY_NAME, charSequence);
        }
        Bundle bundle2 = this.extras;
        if (!bundle2.isEmpty()) {
            bundle.putBundle(FIELD_EXTRAS, bundle2);
        }
        Uri uri = this.iconUri;
        if (uri != null) {
            bundle.putParcelable(FIELD_ICON_URI, uri);
        }
        boolean z = this.isEnabled;
        if (!z) {
            bundle.putBoolean(FIELD_ENABLED, z);
        }
        ImmutableIntArray immutableIntArray = this.slots;
        if (immutableIntArray.end != 1 || immutableIntArray.get(0) != 6) {
            bundle.putIntArray(FIELD_SLOTS, Arrays.copyOfRange(immutableIntArray.array, 0, immutableIntArray.end));
        }
        if (this.parameter != null) {
            writeParameterToBundle(FIELD_PARAMETER, i, bundle);
        }
        return bundle;
    }

    public final void writeParameterToBundle(String str, int i, Bundle bundle) {
        int parameterTypeForPlayerCommand;
        SessionCommand sessionCommand = this.sessionCommand;
        if (sessionCommand != null) {
            parameterTypeForPlayerCommand = sessionCommand.commandCode == 40010 ? 5 : 0;
        } else {
            parameterTypeForPlayerCommand = getParameterTypeForPlayerCommand(this.playerCommand);
        }
        Object obj = this.parameter;
        switch (parameterTypeForPlayerCommand) {
            case 1:
                bundle.putLong(str, ((Long) obj).longValue());
                break;
            case 2:
                bundle.putInt(str, ((Integer) obj).intValue());
                break;
            case 3:
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                break;
            case 4:
                bundle.putFloat(str, ((Float) obj).floatValue());
                break;
            case 5:
                bundle.putBundle(str, ((Rating) obj).toBundle());
                break;
            case 6:
                bundle.putBundle(str, ((MediaItem) obj).toBundle(i, false));
                break;
            case 7:
                bundle.putBundle(str, ((MediaMetadata) obj).toBundle(i));
                break;
            case 8:
                bundle.putBundle(str, ((TrackSelectionParameters) obj).toBundle());
                break;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder {
        public CharSequence displayName;
        public boolean enabled;
        public Bundle extras;
        public final int icon;
        public int iconResId;
        public Uri iconUri;
        public Object parameter;
        public int playerCommand;
        public SessionCommand sessionCommand;
        public ImmutableIntArray slots;

        /* JADX WARN: Illegal instructions before constructor call */
        public Builder(int i) {
            int i2;
            String str = CommandButton.FIELD_SESSION_COMMAND;
            switch (i) {
                case 57369:
                    i2 = R.drawable.media3_icon_album;
                    break;
                case 57370:
                    i2 = R.drawable.media3_icon_artist;
                    break;
                case 57372:
                    i2 = R.drawable.media3_icon_closed_captions;
                    break;
                case 57375:
                    i2 = R.drawable.media3_icon_fast_forward;
                    break;
                case 57376:
                    i2 = R.drawable.media3_icon_rewind;
                    break;
                case 57396:
                    i2 = R.drawable.media3_icon_pause;
                    break;
                case 57399:
                    i2 = R.drawable.media3_icon_play;
                    break;
                case 57403:
                    i2 = R.drawable.media3_icon_playlist_add;
                    break;
                case 57408:
                    i2 = R.drawable.media3_icon_repeat_all;
                    break;
                case 57409:
                    i2 = R.drawable.media3_icon_repeat_one;
                    break;
                case 57410:
                    i2 = R.drawable.media3_icon_skip_back;
                    break;
                case 57411:
                    i2 = R.drawable.media3_icon_shuffle_on;
                    break;
                case 57412:
                    i2 = R.drawable.media3_icon_next;
                    break;
                case 57413:
                    i2 = R.drawable.media3_icon_previous;
                    break;
                case 57415:
                    i2 = R.drawable.media3_icon_stop;
                    break;
                case 57416:
                    i2 = R.drawable.media3_icon_subtitles;
                    break;
                case 57421:
                    i2 = R.drawable.media3_icon_volume_down;
                    break;
                case 57423:
                    i2 = R.drawable.media3_icon_volume_off;
                    break;
                case 57424:
                    i2 = R.drawable.media3_icon_volume_up;
                    break;
                case 57430:
                    i2 = R.drawable.media3_icon_skip_forward_10;
                    break;
                case 57431:
                    i2 = R.drawable.media3_icon_skip_forward_30;
                    break;
                case 57432:
                    i2 = R.drawable.media3_icon_skip_forward_5;
                    break;
                case 57433:
                    i2 = R.drawable.media3_icon_skip_back_10;
                    break;
                case 57434:
                    i2 = R.drawable.media3_icon_skip_back_30;
                    break;
                case 57435:
                    i2 = R.drawable.media3_icon_skip_back_5;
                    break;
                case 57436:
                    i2 = R.drawable.media3_icon_queue_add;
                    break;
                case 57446:
                    i2 = R.drawable.media3_icon_queue_next;
                    break;
                case 57447:
                    i2 = R.drawable.media3_icon_queue_remove;
                    break;
                case 57448:
                    i2 = R.drawable.media3_icon_playback_speed;
                    break;
                case 57573:
                    i2 = R.drawable.media3_icon_feed;
                    break;
                case 57669:
                    i2 = R.drawable.media3_icon_plus;
                    break;
                case 57671:
                    i2 = R.drawable.media3_icon_plus_circle_unfilled;
                    break;
                case 57675:
                    i2 = R.drawable.media3_icon_block;
                    break;
                case 57683:
                    i2 = R.drawable.media3_icon_flag_unfilled;
                    break;
                case 57691:
                    i2 = R.drawable.media3_icon_minus;
                    break;
                case 58409:
                    i2 = R.drawable.media3_icon_quality;
                    break;
                case 58654:
                    i2 = R.drawable.media3_icon_radio;
                    break;
                case 58919:
                    i2 = R.drawable.media3_icon_sync;
                    break;
                case 59405:
                    i2 = R.drawable.media3_icon_share;
                    break;
                case 59448:
                    i2 = R.drawable.media3_icon_star_unfilled;
                    break;
                case 59494:
                    i2 = R.drawable.media3_icon_bookmark_unfilled;
                    break;
                case 59500:
                    i2 = R.drawable.media3_icon_check_circle_unfilled;
                    break;
                case 59517:
                    i2 = R.drawable.media3_icon_heart_unfilled;
                    break;
                case 59576:
                    i2 = R.drawable.media3_icon_settings;
                    break;
                case 59611:
                    i2 = R.drawable.media3_icon_thumb_down_unfilled;
                    break;
                case 59612:
                    i2 = R.drawable.media3_icon_thumb_up_unfilled;
                    break;
                case 60288:
                    i2 = R.drawable.media3_icon_playlist_remove;
                    break;
                case 61298:
                    i2 = R.drawable.media3_icon_subtitles_off;
                    break;
                case 61389:
                    i2 = R.drawable.media3_icon_playback_speed_1_0;
                    break;
                case 61512:
                    i2 = R.drawable.media3_icon_signal;
                    break;
                case 61916:
                    i2 = R.drawable.media3_icon_closed_captions_off;
                    break;
                case 62688:
                    i2 = R.drawable.media3_icon_playback_speed_1_5;
                    break;
                case 62689:
                    i2 = R.drawable.media3_icon_playback_speed_1_2;
                    break;
                case 62690:
                    i2 = R.drawable.media3_icon_playback_speed_0_5;
                    break;
                case 62699:
                    i2 = R.drawable.media3_icon_playback_speed_2_0;
                    break;
                case 63220:
                    i2 = R.drawable.media3_icon_skip_forward;
                    break;
                case 1040448:
                    i2 = R.drawable.media3_icon_repeat_off;
                    break;
                case 1040451:
                    i2 = R.drawable.media3_icon_shuffle_star;
                    break;
                case 1040452:
                    i2 = R.drawable.media3_icon_shuffle_off;
                    break;
                case 1040470:
                    i2 = R.drawable.media3_icon_skip_forward_15;
                    break;
                case 1040473:
                    i2 = R.drawable.media3_icon_skip_back_15;
                    break;
                case 1040711:
                    i2 = R.drawable.media3_icon_plus_circle_filled;
                    break;
                case 1040712:
                    i2 = R.drawable.media3_icon_minus_circle_filled;
                    break;
                case 1040713:
                    i2 = R.drawable.media3_icon_minus_circle_unfilled;
                    break;
                case 1040723:
                    i2 = R.drawable.media3_icon_flag_filled;
                    break;
                case 1042488:
                    i2 = R.drawable.media3_icon_star_filled;
                    break;
                case 1042534:
                    i2 = R.drawable.media3_icon_bookmark_filled;
                    break;
                case 1042540:
                    i2 = R.drawable.media3_icon_check_circle_filled;
                    break;
                case 1042557:
                    i2 = R.drawable.media3_icon_heart_filled;
                    break;
                case 1042651:
                    i2 = R.drawable.media3_icon_thumb_down_filled;
                    break;
                case 1042652:
                    i2 = R.drawable.media3_icon_thumb_up_filled;
                    break;
                case 1045728:
                    i2 = R.drawable.media3_icon_playback_speed_1_8;
                    break;
                case 1045730:
                    i2 = R.drawable.media3_icon_playback_speed_0_8;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            this(i, i2);
        }

        /* JADX WARN: Code duplicated, block: B:63:0x008f  */
        public final CommandButton build() {
            int i;
            int i2 = 1;
            UtilsKt.checkState("Exactly one of sessionCommand and playerCommand should be set", (this.sessionCommand == null) != (this.playerCommand == -1));
            if (this.slots == null) {
                int i3 = this.playerCommand;
                String str = CommandButton.FIELD_SESSION_COMMAND;
                if (i3 != 1 && (i = this.icon) != 57399 && i != 57396) {
                    if (i3 == 11 || i3 == 7) {
                        i2 = 2;
                    } else {
                        i2 = 6;
                        if (i3 == 6 || i == 57413 || i == 57376 || i == 57410 || i == 57435 || i == 57433 || i == 1040473 || i == 57434) {
                            i2 = 2;
                        } else if (i3 == 12 || i3 == 9 || i3 == 8 || i == 57412 || i == 57375 || i == 63220 || i == 57432 || i == 57430 || i == 1040470 || i == 57431) {
                            i2 = 3;
                        }
                    }
                }
                this.slots = new ImmutableIntArray(new int[]{i2});
            }
            return new CommandButton(this.sessionCommand, this.playerCommand, this.icon, this.iconResId, this.iconUri, this.displayName, this.extras, this.enabled, this.slots, this.parameter);
        }

        public final void setIconUri(Uri uri) {
            UtilsKt.checkArgument("Only content or resource Uris are supported for CommandButton", Objects.equals(uri.getScheme(), "content") || Objects.equals(uri.getScheme(), "android.resource"));
            this.iconUri = uri;
        }

        public final void setPlayerCommand(int i) {
            UtilsKt.checkArgument("sessionCommand is already set. Only one of sessionCommand and playerCommand should be set.", this.sessionCommand == null);
            this.playerCommand = i;
            this.parameter = null;
        }

        public final void setSessionCommand(SessionCommand sessionCommand, Object obj) {
            UtilsKt.checkArgument("playerCommands is already set. Only one of sessionCommand and playerCommand should be set.", this.playerCommand == -1);
            this.sessionCommand = sessionCommand;
            int i = sessionCommand.commandCode;
            String str = CommandButton.FIELD_SESSION_COMMAND;
            this.parameter = CommandButton.verifyParameterType(i == 40010 ? 5 : 0, obj);
        }

        public final void setSessionCommand(SessionCommand sessionCommand) {
            UtilsKt.checkNotNull(sessionCommand, "sessionCommand should not be null.");
            UtilsKt.checkArgument("playerCommands is already set. Only one of sessionCommand and playerCommand should be set.", this.playerCommand == -1);
            this.sessionCommand = sessionCommand;
            this.parameter = null;
        }

        public Builder(int i, int i2) {
            this.icon = i;
            this.iconResId = i2;
            this.displayName = "";
            this.extras = Bundle.EMPTY;
            this.playerCommand = -1;
            this.enabled = true;
        }
    }
}
