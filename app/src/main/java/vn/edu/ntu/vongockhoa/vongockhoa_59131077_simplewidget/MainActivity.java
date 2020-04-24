package vn.edu.ntu.vongockhoa.vongockhoa_59131077_simplewidget;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtHoTen, edtNgaySinh, edtSoThich;
    RadioGroup rdgGioiTinh;
    CheckBox cbXP, cbNN, cbCF, cbONha, cbVB;
    Button btnXN;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView(R.layout.activity_main);
        AddView();
        AddEvent();
    }
    private void AddView()
    {
        edtHoTen = findViewById(R.id.edtHoTen);
        edtNgaySinh = findViewById(R.id.edtNgaySinh);
        edtSoThich = findViewById(R.id.edtSothich);
        rdgGioiTinh = findViewById(R.id.rdgGioiTinh);
        cbXP = findViewById(R.id.cbXP);
        cbNN = findViewById(R.id.cbNN);
        cbCF = findViewById(R.id.cbCF);
        cbONha = findViewById(R.id.cbONha);
        cbVB = findViewById(R.id.cbVB);
        btnXN = findViewById(R.id.btnXN);
    }
    //Nhan nut
    private void AddEvent()
        {
            btnXN.setOnClickListener (new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                      BatDau();
                }
            });
        }

        private void BatDau()
        {
            String XuatKetQua = "";
            XuatKetQua = edtHoTen.getText() + "\n" + "Ngày sinh: " + edtNgaySinh.getText() + "\n";
            switch (rdgGioiTinh.getCheckedRadioButtonId())
            {
                case R.id.rbNam: XuatKetQua +="Giới tính: "+"Nam"+"\n"+"Sở thích:"; break;
                case R.id.rbNu: XuatKetQua +="Giới tính:"+"Nữ"+"\n" + "Sở thích:"; break;
            }

            //Ham
            XuatKetQua += HDCheckBox();
            Toast.makeText (MainActivity.this,XuatKetQua,Toast.LENGTH_SHORT).show();
        }
    private String HDCheckBox()
    {
        String XuatKetQua="";
        CheckBox [] arrCb = new CheckBox[]{cbXP, cbNN, cbCF, cbONha, cbVB};
        for(int i = 0; i < arrCb.length; i++)
        {
            if(arrCb[i].isChecked())
            {
                XuatKetQua += arrCb[i].getText().toString() + "; ";
            }
        }

        //Thêm sở thích khác vào Ketqua nếu có
        XuatKetQua += edtSoThich.getText();
        return XuatKetQua;
    }

}
