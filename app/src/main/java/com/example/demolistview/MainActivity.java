package com.example.demolistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_item);
        btnAdd = findViewById(R.id.btnAdd);
        btnEdit = findViewById(R.id.btnEdit);
        editText = findViewById(R.id.EditText1);
        edit2 = findViewById(R.id.EditText2);
        edit3 = findViewById(R.id.EditText3);
        btnClear = findViewById(R.id.btnClear);
        btnRemove = findViewById(R.id.btnRemove);
        listSubject.add(new information("Lập Trình Java","Nguyễn Minh An","4"));
        listSubject.add(new information("Lập Trình C++","Nguyễn Minh Ánh","4"));
        listSubject.add(new information("Lập Trình Ios","Lê Chí Bình","2"));
        listSubject.add(new information("Lập Trình Nhúng","Trương Hoàng Bảo Trung","2"));
        listSubject.add(new information("Lập Trình Kinh Tế","Nguyễn Minh","2"));
        listSubject.add(new information("Lập Trình Ios","Nguyễn Tài Cán","3"));
        listSubject.add(new information("Lập Trình C++","Nguyễn Dũng","3"));
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,listSubject);
        // gán vào adapter để hiện lên listview : trung gian giữa 
        listView.setAdapter(adapter);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Cảnh Báo");
                builder.setMessage("Bạn Có Muốn Xóa "+ listSubject.get(index).toString() + " Khỏi Danh Sách Môn?" );
                builder.setCancelable(true);
                builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listSubject.remove(index);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                    }
                });
                        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel(); // hủy quá trình xóa
                            }
                        });
                                builder.show(); // show alterDialog
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subjectName = editText.getText().toString();
                String nameTeacher = edit2.getText().toString();
                String stc = edit3.getText().toString();
                listSubject.add(new information(subjectName,nameTeacher,stc));
                adapter.notifyDataSetChanged(); // báo cho list view dữ liệu đã thay đổi nếu có nó sẽ load lại dữ lệu
            }
        });
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
          information name = listSubject.get(i);
          String str = String.valueOf(name);
          String [] words = str.split("\\:"); // chia các thông tin theo dấu : vào array xong tách chúng ra để hiện lên cột editext
          String textA = words[0];
          String textB = words[1];
          String textC = words[2];
          editText.setText(textA);
          edit2.setText(textB);
          edit3.setText(textC);
          index = i;

        }
    });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = editText.getText().toString();
                String b = edit2.getText().toString();
                String c = edit3.getText().toString();
                listSubject.set(index,new information(a,b,c));
                adapter.notifyDataSetChanged(); // Thông Báo với Hệ Thống là data đã thay đổi để cập nhật
            }
        });
    }
    public void clearString(View view){
        editText.setText("");
        edit2.setText("");
        edit3.setText("");
    }
    private ListView listView;
    private List<information> listSubject = new ArrayList<>();
    private ArrayAdapter adapter;
    private Button btnEdit;
    private Button btnAdd;
    private EditText editText;
    private EditText edit2;
    private EditText edit3;
    private Button btnClear;
    public int index = -1;
    private Button btnRemove;
}