# 📱 ProfilApp – Jetpack Compose

<p align="center">
  <img width="540" height="540" alt="mockup" src="https://github.com/user-attachments/assets/7b66610c-f28e-4a65-9397-90e0fef71988" />
</p>

Aplikasi sederhana berbasis **Jetpack Compose** untuk menampilkan profil mahasiswa beserta tombol interaktif **Follow/Unfollow**.  
Project ini dibuat sebagai latihan penggunaan state (`remember { mutableStateOf() }`) dan komponen dasar Compose seperti `Box`, `Column`, `Image`, dan `OutlinedButton`.

---

## 🔎 Penjelasan Singkat Kode

- **MainActivity**  
  - Menggunakan `setContent { ... }` untuk memanggil fungsi `ProfilApp()` yang berisi UI berbasis Compose.  
  - Tema aplikasi diatur melalui `ProfilApp_235150207111067AnakAgungNgurahAdityaWirayudhaTheme`.

- **ProfilApp (Composable)**  
  - Menampilkan:
    - Foto profil (dibuat melingkar menggunakan `clip(CircleShape)`).
    - Nama, NIM, dan jurusan mahasiswa.
    - Tombol **Follow/Unfollow** menggunakan `OutlinedButton`.
  - Variabel `isFollowed` didefinisikan dengan:
    ```kotlin
    var isFollowed by remember { mutableStateOf(false) }
    ```
    Variabel ini menyimpan status follow. Nilainya akan berubah setiap kali tombol ditekan, dan teks tombol diperbarui secara otomatis antara `"follow"` dan `"unfollow"`.

- **State & UI Reaktif**  
  - Jetpack Compose bersifat **reactive**. Ketika `isFollowed` berubah, Compose akan langsung men-*render ulang* UI tombol sesuai nilai terbaru tanpa perlu kode tambahan.

---

## ✨ Keuntungan Jetpack Compose dibandingkan XML Layout

1. **Deklaratif & Ringkas**  
   - Compose memungkinkan kita menuliskan UI dalam bentuk fungsi Kotlin (`@Composable`) langsung.  
   - Tidak perlu lagi file XML terpisah + class Activity yang panjang.

2. **UI Reaktif**  
   - Perubahan state (`mutableStateOf`) otomatis mengupdate tampilan UI.  
   - Di XML, kita perlu manual memanggil `findViewById`, `setText()`, atau mengelola `Adapter`.

3. **Lebih Konsisten & Mudah Dibaca**  
   - Struktur UI disusun seperti pohon fungsi (`Column`, `Row`, `Box`) sehingga alurnya lebih mudah dipahami.  
   - Mengurangi *boilerplate code*.

4. **Integrasi dengan Kotlin**  
   - Karena Compose full Kotlin, kita bisa memanfaatkan fitur bahasa (lambda, extension, dsb) langsung di UI.  
   - Tidak perlu bolak-balik antara XML & Java/Kotlin.

5. **Mudah untuk Preview**  
   - Compose menyediakan anotasi `@Preview` untuk melihat tampilan UI tanpa harus menjalankan aplikasi di emulator/device.

---

## 📌 Kesimpulan
Proyek ini menunjukkan bagaimana Jetpack Compose menyederhanakan pembuatan UI Android. Dengan memanfaatkan state (`remember`), aplikasi dapat menampilkan tombol **Follow/Unfollow** yang interaktif dan selalu sinkron dengan nilai state, tanpa perlu pengelolaan manual seperti pada XML tradisional.

