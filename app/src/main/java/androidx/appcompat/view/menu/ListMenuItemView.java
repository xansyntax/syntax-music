package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.emoji2.text.EmojiProcessor;
import com.yalantis.ucrop.R;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView, AbsListView.SelectionBoundsAdjuster {
    public final Drawable mBackground;
    public CheckBox mCheckBox;
    public LinearLayout mContent;
    public boolean mForceShowIcon;
    public ImageView mGroupDivider;
    public final boolean mHasListDivider;
    public ImageView mIconView;
    public LayoutInflater mInflater;
    public MenuItemImpl mItemData;
    public boolean mPreserveIconSpacing;
    public RadioButton mRadioButton;
    public TextView mShortcutView;
    public final Drawable mSubMenuArrow;
    public ImageView mSubMenuArrowView;
    public final int mTextAppearance;
    public final Context mTextAppearanceContext;
    public TextView mTitleView;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        EmojiProcessor emojiProcessorObtainStyledAttributes = EmojiProcessor.obtainStyledAttributes(getContext(), attributeSet, R$styleable.MenuView, R.attr.listMenuViewStyle);
        this.mBackground = emojiProcessorObtainStyledAttributes.getDrawable(5);
        TypedArray typedArray = (TypedArray) emojiProcessorObtainStyledAttributes.mMetadataRepo;
        this.mTextAppearance = typedArray.getResourceId(1, -1);
        this.mPreserveIconSpacing = typedArray.getBoolean(7, false);
        this.mTextAppearanceContext = context;
        this.mSubMenuArrow = emojiProcessorObtainStyledAttributes.getDrawable(8);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.mHasListDivider = typedArrayObtainStyledAttributes.hasValue(0);
        emojiProcessorObtainStyledAttributes.recycle();
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        LayoutInflater layoutInflater = this.mInflater;
        if (layoutInflater != null) {
            return layoutInflater;
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        this.mInflater = layoutInflaterFrom;
        return layoutInflaterFrom;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.mSubMenuArrowView;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.mGroupDivider;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mGroupDivider.getLayoutParams();
        rect.top = this.mGroupDivider.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0035  */
    /* JADX WARN: Code duplicated, block: B:25:0x0053  */
    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public final void initialize(MenuItemImpl menuItemImpl) {
        boolean z;
        int i;
        String string;
        this.mItemData = menuItemImpl;
        boolean zIsVisible = menuItemImpl.isVisible();
        MenuBuilder menuBuilder = menuItemImpl.mMenu;
        setVisibility(zIsVisible ? 0 : 8);
        setTitle(menuItemImpl.mTitle);
        setCheckable(menuItemImpl.isCheckable());
        if (menuBuilder.isShortcutsVisible()) {
            if ((menuBuilder.isQwertyMode() ? menuItemImpl.mShortcutAlphabeticChar : menuItemImpl.mShortcutNumericChar) != 0) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        menuBuilder.isQwertyMode();
        if (z) {
            MenuItemImpl menuItemImpl2 = this.mItemData;
            MenuBuilder menuBuilder2 = menuItemImpl2.mMenu;
            if (menuBuilder2.isShortcutsVisible()) {
                i = (menuBuilder2.isQwertyMode() ? menuItemImpl2.mShortcutAlphabeticChar : menuItemImpl2.mShortcutNumericChar) == 0 ? 8 : 0;
            }
        }
        if (i == 0) {
            TextView textView = this.mShortcutView;
            MenuItemImpl menuItemImpl3 = this.mItemData;
            MenuBuilder menuBuilder3 = menuItemImpl3.mMenu;
            Context context = menuBuilder3.mContext;
            char c = menuBuilder3.isQwertyMode() ? menuItemImpl3.mShortcutAlphabeticChar : menuItemImpl3.mShortcutNumericChar;
            if (c == 0) {
                string = "";
            } else {
                Resources resources = context.getResources();
                StringBuilder sb = new StringBuilder();
                if (ViewConfiguration.get(context).hasPermanentMenuKey()) {
                    sb.append(resources.getString(R.string.abc_prepend_shortcut_label));
                }
                int i2 = menuBuilder3.isQwertyMode() ? menuItemImpl3.mShortcutAlphabeticModifiers : menuItemImpl3.mShortcutNumericModifiers;
                MenuItemImpl.appendModifier(sb, i2, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
                MenuItemImpl.appendModifier(sb, i2, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
                MenuItemImpl.appendModifier(sb, i2, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
                MenuItemImpl.appendModifier(sb, i2, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
                MenuItemImpl.appendModifier(sb, i2, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
                MenuItemImpl.appendModifier(sb, i2, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
                if (c == '\b') {
                    sb.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
                } else if (c == '\n') {
                    sb.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
                } else if (c != ' ') {
                    sb.append(c);
                } else {
                    sb.append(resources.getString(R.string.abc_menu_space_shortcut_label));
                }
                string = sb.toString();
            }
            textView.setText(string);
        }
        if (this.mShortcutView.getVisibility() != i) {
            this.mShortcutView.setVisibility(i);
        }
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
        setSubMenuArrowVisible(menuItemImpl.hasSubMenu());
        setContentDescription(menuItemImpl.mContentDescription);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.mBackground);
        TextView textView = (TextView) findViewById(R.id.title);
        this.mTitleView = textView;
        int i = this.mTextAppearance;
        if (i != -1) {
            textView.setTextAppearance(this.mTextAppearanceContext, i);
        }
        this.mShortcutView = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.mSubMenuArrowView = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.mSubMenuArrow);
        }
        this.mGroupDivider = (ImageView) findViewById(R.id.group_divider);
        this.mContent = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        if (this.mIconView != null && this.mPreserveIconSpacing) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mIconView.getLayoutParams();
            int i3 = layoutParams.height;
            if (i3 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i3;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        CompoundButton compoundButton3;
        if (!z && this.mRadioButton == null && this.mCheckBox == null) {
            return;
        }
        if ((this.mItemData.mFlags & 4) != 0) {
            if (this.mRadioButton == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.mRadioButton = radioButton;
                LinearLayout linearLayout = this.mContent;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.mRadioButton;
            compoundButton2 = this.mCheckBox;
            compoundButton3 = compoundButton2;
        } else {
            if (this.mCheckBox == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.mCheckBox = checkBox;
                LinearLayout linearLayout2 = this.mContent;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.mCheckBox;
            compoundButton2 = this.mRadioButton;
            compoundButton3 = compoundButton;
        }
        if (!z) {
            if (compoundButton3 != null) {
                compoundButton3.setVisibility(8);
            }
            RadioButton radioButton2 = this.mRadioButton;
            if (radioButton2 != null) {
                radioButton2.setVisibility(8);
                return;
            }
            return;
        }
        compoundButton.setChecked(this.mItemData.isChecked());
        if (compoundButton.getVisibility() != 0) {
            compoundButton.setVisibility(0);
        }
        if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
            return;
        }
        compoundButton2.setVisibility(8);
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if ((this.mItemData.mFlags & 4) != 0) {
            if (this.mRadioButton == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.mRadioButton = radioButton;
                LinearLayout linearLayout = this.mContent;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.mRadioButton;
        } else {
            if (this.mCheckBox == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.mCheckBox = checkBox;
                LinearLayout linearLayout2 = this.mContent;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.mCheckBox;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.mForceShowIcon = z;
        this.mPreserveIconSpacing = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.mGroupDivider;
        if (imageView != null) {
            imageView.setVisibility((this.mHasListDivider || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        MenuBuilder menuBuilder = this.mItemData.mMenu;
        boolean z = this.mForceShowIcon;
        if (z || this.mPreserveIconSpacing) {
            ImageView imageView = this.mIconView;
            if (imageView == null && drawable == null && !this.mPreserveIconSpacing) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.mIconView = imageView2;
                LinearLayout linearLayout = this.mContent;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.mPreserveIconSpacing) {
                this.mIconView.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.mIconView;
            if (!z) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.mIconView.getVisibility() != 0) {
                this.mIconView.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView = this.mTitleView;
        if (charSequence == null) {
            if (textView.getVisibility() != 8) {
                this.mTitleView.setVisibility(8);
            }
        } else {
            textView.setText(charSequence);
            if (this.mTitleView.getVisibility() != 0) {
                this.mTitleView.setVisibility(0);
            }
        }
    }
}
