package com.example.ch14_220504.test2

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.ch14_220504.R
import com.example.ch14_220504.databinding.ActivityTest2Binding

class Test2Activity : AppCompatActivity() {
    lateinit var binding:ActivityTest2Binding
    lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    lateinit var intentLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTest2Binding.inflate(layoutInflater)

        setContentView(binding.root)

        permissionLauncher=registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()){

            for(entry in it.entries){
                if(entry.key=="android.permission.READ_CONTACTS" && entry.value) {
                    val intent=Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
                    intentLauncher.launch(intent)
                }else{
                    Toast.makeText(this, "required permission...", Toast.LENGTH_SHORT).show()
                }
            }// 사후 처리 가능한 채로 페이지를 열어줌(사후 처리 필요)
        }
        intentLauncher=registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){
            if(it.resultCode== RESULT_OK){
                val cursor=contentResolver.query(
                    it!!.data!!.data!!,
                    arrayOf(
                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                        ContactsContract.CommonDataKinds.Phone.NUMBER
                    ), null,null,null
                )
                if(cursor!!.moveToNext()){
                    binding.textView2.text="name: ${cursor?.getString(0)}, phone: ${cursor?.getString(1)}"
                }
            }
        }
        binding.button2.setOnClickListener {
            if(ContextCompat.checkSelfPermission(this,"android.permission.READ_CONTACTS")!= PackageManager.PERMISSION_GRANTED){
                permissionLauncher.launch(arrayOf("android.permission.READ_CONTACTS"))
            }else{
                val intent=Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
                intentLauncher.launch(intent)
            }
        }
        binding.button3.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, "android.permission.INTERNET")!=PackageManager.PERMISSION_GRANTED){
                permissionLauncher.launch(arrayOf("android.permission.INTERNET"))
            }else{
                val intent=Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.5662952,126.9779451"))
                startActivity(intent)
            }
        }
        binding.button4.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, "android.permission.CALL_PHONE")!=PackageManager.PERMISSION_GRANTED){
                permissionLauncher.launch(arrayOf("android.permission.CALL_PHONE"))
            }else{
                val intent=Intent(Intent.ACTION_CALL, Uri.parse("tel:000-0000-0000"))
                startActivity(intent)
            }
        }
    }
}