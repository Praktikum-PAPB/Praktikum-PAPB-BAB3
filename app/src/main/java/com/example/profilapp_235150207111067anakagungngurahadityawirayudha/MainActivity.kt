package com.example.profilapp_235150207111067anakagungngurahadityawirayudha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilapp_235150207111067anakagungngurahadityawirayudha.ui.theme.ProfilApp_235150207111067AnakAgungNgurahAdityaWirayudhaTheme
import com.example.profilapp_235150207111067anakagungngurahadityawirayudha.bab3.CounterScreen
import com.example.profilapp_235150207111067anakagungngurahadityawirayudha.bab3.ColorToggleScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfilApp_235150207111067AnakAgungNgurahAdityaWirayudhaTheme {
//                CounterScreen()
//                ColorToggleScreen()
                ProfilApp()
            }
        }
    }
}

//bab 3 test
@Composable
//@Preview
fun ProfilApp () {
    var isFollowed by remember{ mutableStateOf(false) }
//    var
    Box(modifier = Modifier.fillMaxSize().background(Color.DarkGray), contentAlignment = Alignment.Center) {
        Column {
            Box(modifier = Modifier.fillMaxWidth().height(400.dp), contentAlignment = Alignment.Center){
                Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                    Image(painterResource(R.drawable.foto_profile),
                        contentDescription = "foto profile",
                        modifier = Modifier
                            .size(150.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    Text("Anak Agung Ngurah Aditya Wirayudha", modifier = Modifier.padding(top = 14.dp), color = Color.White)
                    Text("235150207111067", color = Color.White)
                    Text("Mahasiswa Teknik Informatika", color = Color.White)
                    Spacer(modifier = Modifier.height(24.dp))
                    OutlinedButton (onClick = {isFollowed = !isFollowed}) {
                        Text(if(isFollowed)"unfollow" else "follow",
                            color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(if (isFollowed) "Anda Mengikuti Akun Ini" else "Anda Belum Mengikuti Aku Ini", style = TextStyle(fontSize = 24.sp), color = Color.White)
                }
            }
        }
    }
}