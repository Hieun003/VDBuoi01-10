package com.example.btvd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IscontactActivity extends AppCompatActivity {

    EditText edtName, edtPhone;
    Button btnLuu, btnDong;
    DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_iscontact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        dbManager = new DBManager(IscontactActivity.this);
        dbManager.open();
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intentResult = new Intent();
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("contact",getContact());
//                intentResult.putExtras(bundle);
//                setResult(RESULT_OK,intentResult);
//                finish();

            }
        });
    }
    private void getViews(){
        edtName = findViewById(R.id.edtTen);
        edtPhone = findViewById(R.id.edtSDT);
        btnLuu = findViewById(R.id.btnLuu);
        btnDong = findViewById(R.id.btnDong);
    }
    private Mycontact getContact(){
        return new Mycontact(android.R.drawable.ic_menu_report_image,edtName.getText().toString(), edtPhone.getText().toString());
    }
}