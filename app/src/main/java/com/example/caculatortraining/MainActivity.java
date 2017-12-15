package com.example.caculatortraining;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  private static final int PHEP_CONG = 1;
  private static final int PHEP_TRU = 2;
  private static final int PHEP_NHAN = 3;
  private static final int PHEP_CHIA = 4;
  private Button btTinh;
  private EditText edNum1;
  private EditText edNum2;
  private int phepTinh;
  private RadioGroup rgPhepTinh;
  private TextView tvKetQua;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    layCacViewTrongLayout();

    rgPhepTinh.setOnCheckedChangeListener(new OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(final RadioGroup radioGroup, final int id) {
        //Kiểm tra người dùng đang check vào phép tính nào
        switch (id) {
          case R.id.rbCong:
            phepTinh = PHEP_CONG;
            break;
          case R.id.rbTru:
            phepTinh = PHEP_TRU;
            break;
          case R.id.rbNhan:
            phepTinh = PHEP_NHAN;
            break;
          case R.id.rbChia:
            phepTinh = PHEP_CHIA;
            break;

        }
      }
    });

    btTinh.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(final View view) {
        //kiểm tra đã nhập 2 số vào editext
        if (!TextUtils.isEmpty(edNum1.getText()) && !TextUtils.isEmpty(edNum2.getText())) {
          //lấy số thứ nhất
          int num1 = Integer.parseInt(edNum1.getText().toString());
          //lấy số thứ 2
          int num2 = Integer.parseInt(edNum2.getText().toString());
          //gọi hàm tính 2 số
          int ketQua = tinhHaiSo(num1, num2);
          //xuất kết quả ra
          tvKetQua.setText(String.valueOf(ketQua));
        } else {
          //Nhắc nhỡ người dùng khi chưa nhập đủ 2 số
          Toast.makeText(MainActivity.this, "Vui lòng nhật vào 2 số", Toast.LENGTH_LONG).show();
        }
      }
    });

  }

  public int tinhHaiSo(int num1, int num2) {
    //Kiểm tra phép tính thuộc + - * /
    switch (phepTinh) {
      case PHEP_CONG:
        return num1 + num2;
      case PHEP_TRU:
        return num1 - num2;
      case PHEP_NHAN:
        return num1 * num2;
      case PHEP_CHIA:
        return num1 / num2;
    }
    return 0;
  }

  private void layCacViewTrongLayout() {
    btTinh = findViewById(R.id.btTinh);
    edNum1 = findViewById(R.id.edtNum1);
    edNum2 = findViewById(R.id.edtNum2);
    tvKetQua = findViewById(R.id.tvKetQua);
    rgPhepTinh = findViewById(R.id.rgPhepTinh);
  }
}
