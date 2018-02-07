package com.test.activity;

import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.test.baseutil.R;

public class BottomSheetDialogActivity extends AppCompatActivity {
    private BottomSheetDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_dialog);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    private void openDialog() {
        View view = getLayoutInflater().inflate(R.layout.sheet_main, null);
        dialog = new BottomSheetDialog(this);
        dialog.setContentView(view);
        TextView camera_sel = (TextView) view.findViewById(R.id.camera);
        TextView gallery_sel = (TextView) view.findViewById(R.id.gallery);
        camera_sel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BottomSheetDialogActivity.this,"1",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        gallery_sel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BottomSheetDialogActivity.this,"2",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
