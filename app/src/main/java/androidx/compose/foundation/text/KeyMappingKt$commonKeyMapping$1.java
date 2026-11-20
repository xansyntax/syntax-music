package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.input.key.Key;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class KeyMappingKt$commonKeyMapping$1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ KeyMappingKt$commonKeyMapping$1(byte b) {
        this.$r8$classId = b;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005c  */
    /* JADX WARN: Code duplicated, block: B:53:0x00c5 A[PHI: r3
      0x00c5: PHI (r3v35 int) = (r3v14 int), (r3v39 int) binds: [B:69:0x00f0, B:51:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:94:0x0151  */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0273, code lost:
    
        if (androidx.compose.ui.input.key.Key.m579equalsimpl0(((long) r22.getKeyCode()) << 32, 231928233984L) != false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x03c1, code lost:
    
        if (androidx.compose.ui.input.key.Key.m579equalsimpl0(r11, -4294967334654705664L) == false) goto L315;
     */
    /* JADX INFO: renamed from: map-ZmokQxo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final KeyCommand m196mapZmokQxo(KeyEvent keyEvent) {
        KeyCommand keyCommand;
        int i;
        byte b = this.$r8$classId;
        KeyCommand keyCommand2 = KeyCommand.NEW_LINE;
        KeyCommand keyCommand3 = KeyCommand.DELETE_PREV_CHAR;
        switch (b) {
            case 0:
                int iM191getModifiersZmokQxo = BasicTextKt.m191getModifiersZmokQxo(keyEvent);
                KeyCommand keyCommand4 = KeyCommand.REDO;
                if (iM191getModifiersZmokQxo != 10) {
                    KeyCommand keyCommand5 = KeyCommand.COPY;
                    KeyCommand keyCommand6 = KeyCommand.CUT;
                    KeyCommand keyCommand7 = KeyCommand.PASTE;
                    if (iM191getModifiersZmokQxo == 2) {
                        long keyCode = ((long) keyEvent.getKeyCode()) << 32;
                        if (!Key.m579equalsimpl0(keyCode, 133143986176L) && !Key.m579equalsimpl0(keyCode, 532575944704L) && !Key.m579equalsimpl0(keyCode, -4294967334654705664L)) {
                            if (!Key.m579equalsimpl0(keyCode, 214748364800L)) {
                                if (!Key.m579equalsimpl0(keyCode, 223338299392L)) {
                                    if (Key.m579equalsimpl0(keyCode, 124554051584L)) {
                                        return KeyCommand.SELECT_ALL;
                                    }
                                    if (!Key.m579equalsimpl0(keyCode, 227633266688L)) {
                                        if (Key.m579equalsimpl0(keyCode, 231928233984L)) {
                                            return KeyCommand.UNDO;
                                        }
                                        return null;
                                    }
                                    return keyCommand4;
                                }
                                return keyCommand6;
                            }
                            return keyCommand7;
                        }
                        return keyCommand5;
                    }
                    if (iM191getModifiersZmokQxo == 8) {
                        long keyCode2 = ((long) keyEvent.getKeyCode()) << 32;
                        if (Key.m579equalsimpl0(keyCode2, 90194313216L) || Key.m579equalsimpl0(keyCode2, -4294967308884901888L)) {
                            return KeyCommand.SELECT_LEFT_CHAR;
                        }
                        if (Key.m579equalsimpl0(keyCode2, 94489280512L) || Key.m579equalsimpl0(keyCode2, -4294967313179869184L)) {
                            return KeyCommand.SELECT_RIGHT_CHAR;
                        }
                        if (Key.m579equalsimpl0(keyCode2, 81604378624L) || Key.m579equalsimpl0(keyCode2, -4294967300294967296L)) {
                            return KeyCommand.SELECT_UP;
                        }
                        if (Key.m579equalsimpl0(keyCode2, 85899345920L) || Key.m579equalsimpl0(keyCode2, -4294967304589934592L)) {
                            return KeyCommand.SELECT_DOWN;
                        }
                        if (Key.m579equalsimpl0(keyCode2, 395136991232L) || Key.m579equalsimpl0(keyCode2, -4294967326064771072L)) {
                            return KeyCommand.SELECT_PAGE_UP;
                        }
                        if (Key.m579equalsimpl0(keyCode2, 399431958528L) || Key.m579equalsimpl0(keyCode2, -4294967330359738368L)) {
                            return KeyCommand.SELECT_PAGE_DOWN;
                        }
                        if (Key.m579equalsimpl0(keyCode2, 523986010112L) || Key.m579equalsimpl0(keyCode2, -4294967317474836480L)) {
                            return KeyCommand.SELECT_LINE_START;
                        }
                        if (Key.m579equalsimpl0(keyCode2, 528280977408L) || Key.m579equalsimpl0(keyCode2, -4294967321769803776L)) {
                            return KeyCommand.SELECT_LINE_END;
                        }
                        if (!Key.m579equalsimpl0(keyCode2, 532575944704L)) {
                            break;
                        }
                        return keyCommand7;
                    }
                    if (iM191getModifiersZmokQxo == 0) {
                        long keyCode3 = ((long) keyEvent.getKeyCode()) << 32;
                        if (Key.m579equalsimpl0(keyCode3, 90194313216L) || Key.m579equalsimpl0(keyCode3, -4294967308884901888L)) {
                            return KeyCommand.LEFT_CHAR;
                        }
                        if (Key.m579equalsimpl0(keyCode3, 94489280512L) || Key.m579equalsimpl0(keyCode3, -4294967313179869184L)) {
                            return KeyCommand.RIGHT_CHAR;
                        }
                        if (Key.m579equalsimpl0(keyCode3, 81604378624L) || Key.m579equalsimpl0(keyCode3, -4294967300294967296L)) {
                            return KeyCommand.UP;
                        }
                        if (Key.m579equalsimpl0(keyCode3, 85899345920L) || Key.m579equalsimpl0(keyCode3, -4294967304589934592L)) {
                            return KeyCommand.DOWN;
                        }
                        if (Key.m579equalsimpl0(keyCode3, 98784247808L)) {
                            return KeyCommand.CENTER;
                        }
                        if (Key.m579equalsimpl0(keyCode3, 395136991232L) || Key.m579equalsimpl0(keyCode3, -4294967326064771072L)) {
                            return KeyCommand.PAGE_UP;
                        }
                        if (Key.m579equalsimpl0(keyCode3, 399431958528L) || Key.m579equalsimpl0(keyCode3, -4294967330359738368L)) {
                            return KeyCommand.PAGE_DOWN;
                        }
                        if (Key.m579equalsimpl0(keyCode3, 523986010112L) || Key.m579equalsimpl0(keyCode3, -4294967317474836480L)) {
                            return KeyCommand.LINE_START;
                        }
                        if (Key.m579equalsimpl0(keyCode3, 528280977408L) || Key.m579equalsimpl0(keyCode3, -4294967321769803776L)) {
                            return KeyCommand.LINE_END;
                        }
                        if (Key.m579equalsimpl0(keyCode3, 283467841536L) || Key.m579equalsimpl0(keyCode3, 687194767360L)) {
                            return keyCommand2;
                        }
                        if (Key.m579equalsimpl0(keyCode3, 287762808832L)) {
                            return keyCommand3;
                        }
                        if (Key.m579equalsimpl0(keyCode3, 481036337152L)) {
                            return KeyCommand.DELETE_NEXT_CHAR;
                        }
                        if (!Key.m579equalsimpl0(keyCode3, 1198295875584L)) {
                            if (!Key.m579equalsimpl0(keyCode3, 1189705940992L)) {
                                if (!Key.m579equalsimpl0(keyCode3, 1194000908288L)) {
                                    if (Key.m579equalsimpl0(keyCode3, 261993005056L)) {
                                        return KeyCommand.TAB;
                                    }
                                }
                                return keyCommand5;
                            }
                            return keyCommand6;
                        }
                        return keyCommand7;
                    }
                    return null;
                }
                break;
                break;
            default:
                int iM191getModifiersZmokQxo2 = BasicTextKt.m191getModifiersZmokQxo(keyEvent);
                if (iM191getModifiersZmokQxo2 == 9) {
                    long keyCode4 = ((long) keyEvent.getKeyCode()) << 32;
                    if (Key.m579equalsimpl0(keyCode4, 90194313216L)) {
                        keyCommand = KeyCommand.SELECT_LINE_LEFT;
                    } else if (Key.m579equalsimpl0(keyCode4, 94489280512L)) {
                        keyCommand = KeyCommand.SELECT_LINE_RIGHT;
                    } else if (Key.m579equalsimpl0(keyCode4, 81604378624L)) {
                        keyCommand = KeyCommand.SELECT_HOME;
                    } else if (Key.m579equalsimpl0(keyCode4, 85899345920L)) {
                        keyCommand = KeyCommand.SELECT_END;
                    } else {
                        keyCommand = null;
                    }
                } else if (iM191getModifiersZmokQxo2 == 1) {
                    long keyCode5 = ((long) keyEvent.getKeyCode()) << 32;
                    if (Key.m579equalsimpl0(keyCode5, 90194313216L)) {
                        keyCommand = KeyCommand.LINE_LEFT;
                    } else if (Key.m579equalsimpl0(keyCode5, 94489280512L)) {
                        keyCommand = KeyCommand.LINE_RIGHT;
                    } else if (Key.m579equalsimpl0(keyCode5, 81604378624L)) {
                        keyCommand = KeyCommand.HOME;
                    } else if (Key.m579equalsimpl0(keyCode5, 85899345920L)) {
                        keyCommand = KeyCommand.END;
                    } else if (Key.m579equalsimpl0(keyCode5, 287762808832L)) {
                        keyCommand = KeyCommand.DELETE_FROM_LINE_START;
                    } else {
                        keyCommand = null;
                    }
                } else {
                    keyCommand = null;
                }
                if (keyCommand != null) {
                    return keyCommand;
                }
                DrawResult drawResult = BasicTextKt.defaultKeyMapping;
                int iM191getModifiersZmokQxo3 = BasicTextKt.m191getModifiersZmokQxo(keyEvent);
                long keyCode6 = ((long) keyEvent.getKeyCode()) << 32;
                if (Key.m579equalsimpl0(keyCode6, 287762808832L)) {
                    if (iM191getModifiersZmokQxo3 == 0 || iM191getModifiersZmokQxo3 == 8 || iM191getModifiersZmokQxo3 == 12) {
                        keyCommand2 = keyCommand3;
                    } else {
                        if (iM191getModifiersZmokQxo3 != 2) {
                            i = 10;
                            if (iM191getModifiersZmokQxo3 != 10) {
                                keyCommand2 = null;
                            }
                        }
                        keyCommand2 = KeyCommand.DELETE_PREV_WORD;
                    }
                    i = 10;
                } else {
                    if (!Key.m579equalsimpl0(keyCode6, 283467841536L) && !Key.m579equalsimpl0(keyCode6, 687194767360L)) {
                        keyCommand2 = null;
                    } else if (iM191getModifiersZmokQxo3 != 0 && iM191getModifiersZmokQxo3 != 8 && iM191getModifiersZmokQxo3 != 2) {
                        i = 10;
                        if (iM191getModifiersZmokQxo3 != 10) {
                            keyCommand2 = null;
                        }
                    }
                    i = 10;
                }
                if (keyCommand2 != null) {
                    return keyCommand2;
                }
                int iM191getModifiersZmokQxo4 = BasicTextKt.m191getModifiersZmokQxo(keyEvent);
                if (iM191getModifiersZmokQxo4 == i) {
                    long keyCode7 = ((long) keyEvent.getKeyCode()) << 32;
                    if (Key.m579equalsimpl0(keyCode7, 90194313216L) || Key.m579equalsimpl0(keyCode7, -4294967308884901888L)) {
                        keyCommand3 = KeyCommand.SELECT_LEFT_WORD;
                    } else if (Key.m579equalsimpl0(keyCode7, 94489280512L) || Key.m579equalsimpl0(keyCode7, -4294967313179869184L)) {
                        keyCommand3 = KeyCommand.SELECT_RIGHT_WORD;
                    } else if (Key.m579equalsimpl0(keyCode7, 81604378624L) || Key.m579equalsimpl0(keyCode7, -4294967300294967296L)) {
                        keyCommand3 = KeyCommand.SELECT_PREV_PARAGRAPH;
                    } else if (Key.m579equalsimpl0(keyCode7, 85899345920L) || Key.m579equalsimpl0(keyCode7, -4294967304589934592L)) {
                        keyCommand3 = KeyCommand.SELECT_NEXT_PARAGRAPH;
                    } else {
                        keyCommand3 = null;
                    }
                } else if (iM191getModifiersZmokQxo4 == 2) {
                    long keyCode8 = ((long) keyEvent.getKeyCode()) << 32;
                    if (Key.m579equalsimpl0(keyCode8, 90194313216L) || Key.m579equalsimpl0(keyCode8, -4294967308884901888L)) {
                        keyCommand3 = KeyCommand.LEFT_WORD;
                    } else if (Key.m579equalsimpl0(keyCode8, 94489280512L) || Key.m579equalsimpl0(keyCode8, -4294967313179869184L)) {
                        keyCommand3 = KeyCommand.RIGHT_WORD;
                    } else if (Key.m579equalsimpl0(keyCode8, 81604378624L) || Key.m579equalsimpl0(keyCode8, -4294967300294967296L)) {
                        keyCommand3 = KeyCommand.PREV_PARAGRAPH;
                    } else if (Key.m579equalsimpl0(keyCode8, 85899345920L) || Key.m579equalsimpl0(keyCode8, -4294967304589934592L)) {
                        keyCommand3 = KeyCommand.NEXT_PARAGRAPH;
                    } else if (!Key.m579equalsimpl0(keyCode8, 154618822656L)) {
                        if (Key.m579equalsimpl0(keyCode8, 481036337152L)) {
                            keyCommand3 = KeyCommand.DELETE_NEXT_WORD;
                        } else if (Key.m579equalsimpl0(keyCode8, 313532612608L)) {
                            keyCommand3 = KeyCommand.DESELECT;
                        } else {
                            keyCommand3 = null;
                        }
                    }
                } else if (iM191getModifiersZmokQxo4 == 8) {
                    long keyCode9 = ((long) keyEvent.getKeyCode()) << 32;
                    if (Key.m579equalsimpl0(keyCode9, 523986010112L) || Key.m579equalsimpl0(keyCode9, -4294967317474836480L)) {
                        keyCommand3 = KeyCommand.SELECT_LINE_START;
                    } else if (Key.m579equalsimpl0(keyCode9, 528280977408L) || Key.m579equalsimpl0(keyCode9, -4294967321769803776L)) {
                        keyCommand3 = KeyCommand.SELECT_LINE_END;
                    } else {
                        keyCommand3 = null;
                    }
                } else if (iM191getModifiersZmokQxo4 == 1 && Key.m579equalsimpl0(((long) keyEvent.getKeyCode()) << 32, 481036337152L)) {
                    keyCommand3 = KeyCommand.DELETE_TO_LINE_END;
                } else {
                    keyCommand3 = null;
                }
                return keyCommand3 == null ? ((KeyMappingKt$commonKeyMapping$1) drawResult.block).m196mapZmokQxo(keyEvent) : keyCommand3;
        }
    }
}
