package br.com.ericksimoes.endyearsparty.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.ericksimoes.endyearsparty.R;
import br.com.ericksimoes.endyearsparty.constants.EndYearsConstants;
import br.com.ericksimoes.endyearsparty.util.SecurityPreferences;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.textToday = (TextView) findViewById(R.id.text_today);
        this.mViewHolder.textDaysLeft = (TextView) findViewById(R.id.text_days_left);
        this.mViewHolder.buttonConfirm = (Button) findViewById(R.id.button_confirm);

        this.mViewHolder.buttonConfirm.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.verifyPresence();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button_confirm) {
            String presence = this.mSecurityPreferences.getStoredString(EndYearsConstants.PRESENCE);
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(EndYearsConstants.PRESENCE, presence);
            startActivity(intent);
        }
    }

    private void verifyPresence() {
        switch (mSecurityPreferences.getStoredString(EndYearsConstants.PRESENCE)) {
            case "":
                this.mViewHolder.buttonConfirm.setText(R.string.not_confirmed);
                break;
            case EndYearsConstants.CONFIRMED_WILL_GO:
                this.mViewHolder.buttonConfirm.setText(R.string.yes);
                break;
            case  EndYearsConstants.CONFIRMED_WONT_GO:
                this.mViewHolder.buttonConfirm.setText(R.string.no);
                break;
        }
    }

    private static class ViewHolder {
        TextView textToday;
        TextView textDaysLeft;
        Button buttonConfirm;
    }
}
