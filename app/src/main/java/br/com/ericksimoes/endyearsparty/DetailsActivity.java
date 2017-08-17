package br.com.ericksimoes.endyearsparty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mViewHolder.checkParticipate = (CheckBox) findViewById(R.id.checkbox_participate);

        this.mViewHolder.checkParticipate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.checkbox_participate) {
            // click action
        }
    }

    private static class ViewHolder {
        CheckBox checkParticipate;
    }
}
