package com.example.test2

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.example.test2.databinding.ActivityMainBinding
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var filePath:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val requestGalleryLauncher=registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){
            try {
                val calRatio=calculateInSamplesize(
                    it.data!!.data!!,
                    resources.getDimensionPixelSize(R.dimen.imgSize),
                    resources.getDimensionPixelSize(R.dimen.imgSize)
                )
                val option=BitmapFactory.Options()
                option.inSampleSize=calRatio

                var inputStream=contentResolver.openInputStream(it.data!!.data!!)
                val bitmap=BitmapFactory.decodeStream(inputStream,null,option)
                inputStream!!.close()
                inputStream=null
                bitmap?.let{
                    binding.imageView.setImageBitmap(bitmap)
                }?: let{
                    Log.d("lyk","bitmap null")
                }
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
        binding.galleryButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type="image/*"
            requestGalleryLauncher.launch(intent)
        }

        val requestCameraFileLauncher=registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){
            val calRatio=calculateInSamplesize(
                Uri.fromFile(File(filePath)),
                resources.getDimensionPixelSize(R.dimen.imgSize),
                resources.getDimensionPixelSize(R.dimen.imgSize)
            )
            val option=BitmapFactory.Options()
            option.inSampleSize=calRatio
            val bitmap=BitmapFactory.decodeFile(filePath, option)
            bitmap?.let {
                binding.imageView.setImageBitmap(bitmap)
            }
        }
        binding.cameraButton.setOnClickListener {
            val timeStamp:String=SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val storageDir:File?=getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            val file=File.createTempFile(
                "JPEG_${timeStamp}_",
                ".jpg",
                storageDir
            )
            filePath=file.absolutePath
            val photoUri:Uri=FileProvider.getUriForFile(
                this,
                "com.example.test2.fileprovider", //오류 발생시 xml, manifest 에서 오타 확인 해볼 것
                file
            )
            val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
            requestCameraFileLauncher.launch(intent)
        }
    }
    private fun calculateInSamplesize(fileUri: Uri, reqWidth:Int, reqHeight:Int):Int{
        val options=BitmapFactory.Options()
        options.inJustDecodeBounds=true // 단순 옵션
        try{
            var inputStream=contentResolver.openInputStream(fileUri) // fileUri로부터 inputStream 생성
            BitmapFactory.decodeStream(inputStream, null, options)
            inputStream!!.close() // inputStream null 허용하지 않음
            inputStream=null
        }catch (e:Exception){
            e.printStackTrace()
        }
        val (height:Int, width:Int)=options.run { outHeight to outWidth }
        var inSampleSize=1

        if(height > reqHeight || width > reqWidth) {
            val halfHeight:Int=height/2
            val halfWidth:Int=height/2
            while (halfHeight/inSampleSize >= reqHeight && halfWidth/inSampleSize >= reqHeight){
                inSampleSize *=2
            }
        } // 작은 이미지의 경우 fitX, fitY로 사이즈 맞춰줌
        return inSampleSize
    }
}