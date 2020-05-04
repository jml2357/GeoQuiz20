package com.example.geoquiz20;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CheatActivity extends AppCompatActivity {
    private static final String EXTRA_ANSWER_IS_TRUE = "com.example.geoquiz20.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN = "com.example.geoquiz20.answer_shown";

    private boolean mAnswerIsTrue;

    private TextView mAnswerTextView; // will need to add the TextView package
    private Button mShowAnswerButton; // will need to add the Button package

    public static Intent newIntent(Context packageContext, boolean answerIsTrue){
        Intent intent = new Intent(packageContext,CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE,answerIsTrue);
        return intent;
    }

    public static boolean wasAnswerShown (Intent result){
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN,false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);

        mAnswerTextView = (TextView)findViewById(R.id.answer_text_view); // linking to xml

        mShowAnswerButton = (Button)findViewById(R.id.show_answer_button); // linking to xml
        mShowAnswerButton.setOnClickListener(new View.OnClickListener(){ // if the value is true/false > display text
            @Override
            public void onClick(View view){
                if (mAnswerIsTrue){
                    mAnswerTextView.setText(R.string.true_button);
                }else {
                    mAnswerTextView.setText(R.string.false_button);
                }
            }
        });
    }

    private void setAnswerShownResult (boolean isAnswerShown){
        Intent data = new Intent ();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK,data);
    }
}
