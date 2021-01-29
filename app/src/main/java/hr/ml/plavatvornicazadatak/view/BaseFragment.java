package hr.ml.plavatvornicazadatak.view;

import android.app.AlertDialog;

import androidx.fragment.app.Fragment;

import hr.ml.plavatvornicazadatak.R;

public class BaseFragment extends Fragment implements BaseIFragment {
    @Override
    public void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.connection_alert_dialog_title);
        builder.setMessage(R.string.connection_alert_dialog_message);
        builder.setPositiveButton(R.string.connection_alert_dialog_button_text,
                (dialog, which) -> dialog.dismiss());
        builder.create().show();
    }
}
