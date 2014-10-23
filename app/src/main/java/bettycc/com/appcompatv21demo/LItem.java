package bettycc.com.appcompatv21demo;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ccheng on 10/23/14.
 */
public class LItem extends LinearLayout {

    private final String mDescText;

    public LItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LItem);
        mDescText = typedArray.getString(R.styleable.LItem_desc);
        typedArray.recycle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        TextView descView = new TextView(getContext());
        descView.setTextAppearance(getContext(), android.R.style.TextAppearance_Small);
        descView.setText(mDescText);
        LinearLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.litem_desc_margin_bottom));
        descView.setLayoutParams(params);
        addView(descView, 0);

        int padding = getResources().getDimensionPixelOffset(R.dimen.litem_padding);
        setPadding(padding, padding, padding, padding);
    }
}
