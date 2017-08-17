package br.com.ericksimoes.endyearsparty.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

import br.com.ericksimoes.endyearsparty.R;
import br.com.ericksimoes.endyearsparty.constants.EndYearsConstants;
import br.com.ericksimoes.endyearsparty.util.SecurityPreferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.checkParticipate = (CheckBox) findViewById(R.id.checkbox_participate);
        this.mViewHolder.checkParticipate.setOnClickListener(this);

        this.loadDataFromActivity();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.checkbox_participate) {
            if (this.mViewHolder.checkParticipate.isChecked()) {
                this.mSecurityPreferences.storeString(EndYearsConstants.PRESENCE, EndYearsConstants.CONFIRMED_WILL_GO);
            } else {
                this.mSecurityPreferences.storeString(EndYearsConstants.PRESENCE, EndYearsConstants.CONFIRMED_WONT_GO);
            }
        }
    }

    private void loadDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String presence = extras.getString(EndYearsConstants.PRESENCE);

            this.mViewHolder.checkParticipate.setChecked(presence.equals(EndYearsConstants.CONFIRMED_WILL_GO));
        }
    }

    private static class ViewHolder {
        CheckBox checkParticipate;
    }
}
