package com.myolin.optimiser;

import android.content.Context;
import android.text.InputType;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by mzlmy on 3/16/2017.
 */

public class TextBox extends EditText {

    public TextBox(Context context, String id, MyPrefs myPrefs, TextView textView) {
        super(context);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0.6f);
        this.setEms(10);
        this.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        this.setBackgroundResource(R.drawable.border);
        this.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        this.setListener(id, myPrefs);
    }

    public void setNumType(){
        this.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    public void setListener(final String id, final MyPrefs myPrefs){
        this.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                myPrefs.storeString(id, getText().toString());
            }
        });
    }
}
